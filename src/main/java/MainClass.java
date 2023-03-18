import Business.ClientBLL;
import Business.OrderBLL;
import DataAccess.AbstractDAO;
import DataAccess.ClientDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Order;
import Model.Product;
import Presentation.Controller;
import Presentation.CreateClient;
import Presentation.View;

public class MainClass
{
    public static void main(String[] args)
    {
        /*ClientDAO dao = new ClientDAO();
        ProductDAO pdao = new ProductDAO();
        OrderBLL ob = new OrderBLL();
        Client aux = new Client();
        aux.setName("radu");
        aux.setNumber("0742");
        aux.setEmail("fghj@ghj");
        Product p = new Product();
        p.setName("dasdas");
        p.setPrice(15);
        p.setQuantity(100);
        Order order = new Order();
        order.setIdClient(1);
        order.setIdProduct(1);
        order.setQuantity(5);
        //ob.insertOrder(order, pdao);

       //pdao.insert(p);
       //dao.update(1, aux);
       //dao.delete(2);
        ob.deleteOrder(1, pdao);
        ClientBLL cl = new ClientBLL();
        cl.deleteClient(1, ob.getOrderDAO());*/

        View view = new View("Warehouse management");
        CreateClient clientGui = new CreateClient("Create");
        Controller controller = new Controller(view);
        controller.updateClientTable();
        controller.updateProductTable();
        controller.updateOrderTable();
    }
}
