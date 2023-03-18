package Business;

import DataAccess.ClientDAO;
import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Order;
import Model.Product;

import java.util.List;

public class OrderBLL {

    private OrderDAO orderDAO;

    public boolean insertOrder(Order order, ProductDAO productDAO)
    {
        Product p = productDAO.findById(order.getIdProduct());
        if (order.getQuantity() > p.getQuantity())
            return false;

        p.setQuantity(p.getQuantity() - order.getQuantity());

        orderDAO.insert(order);
        productDAO.update(order.getIdProduct(), p);
        return true;
    }

    public boolean updateOrder(int idOrder, Order order, ProductDAO productDAO)
    {
        Order old =  orderDAO.findById(idOrder);
        Product p = null;

        if (old.getIdProduct() == order.getIdProduct())
        {
            p = productDAO.findById(order.getIdProduct());
            if (order.getQuantity() - old.getQuantity() > p.getQuantity())
                return false;

            p.setQuantity(p.getQuantity() + (old.getQuantity() - order.getQuantity()));
            productDAO.update(p.getId(), p);
            orderDAO.update(idOrder, order);

        }
        else
        {
            Product old_p = productDAO.findById(old.getIdProduct());
            old_p.setQuantity(old_p.getQuantity() + old.getQuantity());
            p = productDAO.findById(order.getIdProduct());

            if (p.getQuantity() < order.getQuantity())
                return false;

            p.setQuantity(p.getQuantity() - order.getQuantity());

            productDAO.update(old_p.getId(), old_p);
            productDAO.update(p.getId(), p);
            orderDAO.update(idOrder, order);
        }
        return true;
    }

    public void deleteOrder(int idOrder, ProductDAO productDAO)
    {
        Order o = orderDAO.findById(idOrder);
        Product p = productDAO.findById(o.getIdProduct());
        p.setQuantity(p.getQuantity() + o.getQuantity());
        productDAO.update(p.getId(), p);
        orderDAO.delete(idOrder);
    }

    public OrderBLL()
    {
        orderDAO = new OrderDAO();
    }

    public Object[][] provideData() { return orderDAO.dataReflexion(orderDAO.findAll()); }

    public String[] generateHeader() { return orderDAO.headerReflexion();}

    public Order findById(int id) {return orderDAO.findById(id);}

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
