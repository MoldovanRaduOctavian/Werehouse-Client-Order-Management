package Business;

import DataAccess.OrderDAO;
import DataAccess.ProductDAO;
import Model.Client;
import Model.Order;
import Model.Product;

import java.util.List;

public class ProductBLL {

    private ProductDAO productDAO;

    public ProductBLL()
    {
        productDAO = new ProductDAO();
    }

    public void createProduct(Product product) {productDAO.insert(product);}
    public void updateProduct(int id, Product product) {productDAO.update(id, product); }

    public boolean deleteProduct(int id, OrderDAO orderDAO)
    {
        List<Order> orders = orderDAO.findAll();
        for (Order o : orders)
            if (o.getIdProduct() == id)
                return false;

        productDAO.delete(id);

        return true;
    }


    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Object[][] provideData() { return productDAO.dataReflexion(productDAO.findAll()); }

    public String[] generateHeader()
    {
        return productDAO.headerReflexion();
    }

}
