package Business;

import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Order;
import Model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientBLL
{
    private ClientDAO clientDAO;

    public ClientBLL()
    {
        clientDAO = new ClientDAO();
    }

    public void createClient(Client client) { clientDAO.insert(client);}

    public void updateClient(int id, Client client) { clientDAO.update(id, client);}

    public Client findById(int id) {return clientDAO.findById(id);}

    public boolean deleteClient(int id, OrderDAO orderDAO)
    {
        List<Order> orders = orderDAO.findAll();
        for (Order o : orders)
            if (o.getIdClient() == id)
                return false;

        clientDAO.delete(id);

        return true;
    }

    public String generateReceipt(int id, ProductDAO productDAO, OrderDAO orderDAO)
    {
        String ret = "";
        Product product = null;
        Client client = clientDAO.findById(id);
        List<Order> orders = new ArrayList<Order>();

        for (Order o : orderDAO.findAll())
            if (o.getIdClient() == client.getId())
                orders.add(o);

        if (orders.isEmpty()) return ret;

        ret += "Factura pentru " + client.getName() + " : \n";

        int suma = 0;

        for (Order o : orders)
        {
            product = productDAO.findById(o.getIdProduct());
            ret += product.getName() + " - " + o.getQuantity() + " buc - " + product.getPrice() * o.getQuantity() + ";\n";
            suma += product.getPrice() * o.getQuantity();

        }

        ret += "Total: " + suma + "\n";
        return ret;
    }

    public Object[][] provideData() { return clientDAO.dataReflexion(clientDAO.findAll());}

    public String[] generateHeader()
    {
        return clientDAO.headerReflexion();
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}
