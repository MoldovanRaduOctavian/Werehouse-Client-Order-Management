package DataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source http://www.java-blog.com/mapping-javaobjects-database-reflection-generics
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM tp.");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "select * from tp." + type.getSimpleName();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String insert(T t){
        String query;
        String cols = "(";
        String vals = "(";
        try{
            int ok = 0;
            for (Field field : type.getDeclaredFields())
            {
                String fieldName = field.getName();
                field.setAccessible(true);
                if (!fieldName.equals("id"))
                {
                    if (ok == 0)
                    {
                        cols += fieldName;
                        Object value = field.get(t);
                        String wrap = "'" + value + "'";
                        vals += wrap;
                        ok = 1;
                    }
                    else
                    {
                        cols += "," + fieldName;
                        Object value = field.get(t);
                        String wrap = "'" + value + "'";
                        vals += "," + wrap;
                    }

                }
            }
            cols += ")";
            vals += ")";
            query = "insert into tp." + type.getSimpleName() + cols + " values " + vals + ";";
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            System.out.println(query);
            statement.execute();
            return query;
        }
        catch (IllegalAccessException | SQLException e) {e.printStackTrace();}
        return null;
    }

    public String update(int id, T t)
    {
        int ok = 0;
        String aux = "";
        String query = "update tp." + type.getSimpleName() + " set ";
        try{
            for (Field field : type.getDeclaredFields())
            {
                String fieldName = field.getName();
                field.setAccessible(true);
                if (!fieldName.equals("id"))
                {
                    Object value = field.get(t);
                    if (ok == 0)
                    {
                        aux += fieldName + "=" + "'" + value + "'";
                        ok = 1;
                    }

                    else {aux += "," + fieldName + "=" + "'" + value + "'";}
                }
            }

            query += aux + " where id=?;";
            Connection connection  = ConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            System.out.println(query);
            statement.execute();

        }
        catch (Exception e) { e.printStackTrace();}

        return null;
    }

    public String delete(int id)
    {
        try
        {
             String query = "delete from tp." + type.getSimpleName() + " where id=?";
             Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setInt(1, id);
             System.out.println(query);
             statement.execute();
        }
        catch (Exception e) {e.printStackTrace();}

        return null;
    }

    // Generare de capete de tabel utilizand reflexia
    public String[] headerReflexion()
    {
        String[] ret = new String[type.getDeclaredFields().length];
        int i = 0;

        for (Field f : type.getDeclaredFields())
            ret[i++] = f.getName();

        return ret;
    }

    public Object[][] dataReflexion(List<T> obj)
    {
        Object[][] ret = new Object[100][type.getDeclaredFields().length];
        int i = 0, j = 0;

        try
        {
            for (T t : obj)
            {
                j = 0;
                for (Field f : type.getDeclaredFields())
                {
                    f.setAccessible(true);
                    Object aux = f.get(t);
                    ret[i][j++] = aux;
                }

                i++;
            }
        }
        catch (Exception e) {e.printStackTrace();}

        return ret;

    }
}
