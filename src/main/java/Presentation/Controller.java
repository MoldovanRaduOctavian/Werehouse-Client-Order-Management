package Presentation;

import Business.ClientBLL;
import Business.OrderBLL;
import Business.ProductBLL;
import Model.Client;
import Model.Order;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private View view;

    private CreateClient createClientGui;
    private UpdateClient updateClientGui;
    private DeleteClient deleteClientGui;

    private CreateProduct createProductGui;
    private UpdateProduct updateProductGui;
    private DeleteProduct deleteProductGui;

    private CreateOrder createOrderGui;
    private UpdateOrder updateOrderGui;
    private DeleteOrder deleteOrderGui;

    private ClientBLL cbll;
    private OrderBLL obll;
    private ProductBLL pbll;

    public Controller(View view)
    {
        this.view = view;

        this.createClientGui = new CreateClient("Create");
        this.updateClientGui = new UpdateClient("Update");
        this.deleteClientGui = new DeleteClient("Delete");

        this.createProductGui = new CreateProduct("Create");
        this.updateProductGui = new UpdateProduct("Update");
        this.deleteProductGui = new DeleteProduct("Delete");

        this.createOrderGui = new CreateOrder("Create");
        this.updateOrderGui = new UpdateOrder("Update");
        this.deleteOrderGui = new DeleteOrder("Delete");

        cbll = new ClientBLL();
        pbll = new ProductBLL();
        obll = new OrderBLL();

        this.addListeners();

    }

    public void addListeners()
    {
        view.getCreateButton1().addActionListener(e -> clientShowCreateButton());
        createClientGui.getAcceptButton().addActionListener(e -> clientInsertButton());
        view.getUpdateButton1().addActionListener(e -> clientShowUpdateButton());
        updateClientGui.getAcceptButton().addActionListener(e -> clientUpdateButton());
        view.getDeleteButton1().addActionListener(e -> clientShowDeleteButton());
        deleteClientGui.getAcceptButton().addActionListener(e -> clientDeleteButton());

        view.getCreateButton().addActionListener(e -> productShowCreateButton());
        createProductGui.getAcceptButton().addActionListener(e -> productCreateButton());
        view.getUpdateButton().addActionListener(e -> productShowUpdateButton());
        updateProductGui.getAcceptButton().addActionListener(e -> productUpdateButton());
        view.getDeleteButton().addActionListener(e -> productShowDeleteButton());
        deleteProductGui.getAcceptButton().addActionListener(e -> productDeleteButton());

        view.getCreateButton2().addActionListener(e -> orderShowCreateButton());
        createOrderGui.getAcceptButton().addActionListener(e -> orderCreateButton());
        view.getUpdateButton2().addActionListener(e-> orderShowUpdateButton());
        updateOrderGui.getAcceptButton().addActionListener(e -> orderUpdateButton());
        view.getDeleteButton2().addActionListener(e -> orderShowDeleteButton());
        deleteOrderGui.getAcceptButton().addActionListener(e -> orderDeleteButton());

        view.getReceiptButton().addActionListener(e -> printReceiptButton());
    }

    public void updateClientTable()
    {
        DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();
        model.setDataVector(cbll.provideData(), cbll.generateHeader());
    }

    public void updateProductTable()
    {
        DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();
        model.setDataVector(pbll.provideData(), pbll.generateHeader());
    }

    public void updateOrderTable()
    {
        DefaultTableModel model = (DefaultTableModel) view.getTable5().getModel();
        model.setDataVector(obll.provideData(), obll.generateHeader());
    }

    public void updateTables()
    {
        updateClientTable();
        updateProductTable();
        updateOrderTable();
    }

    public void clientShowCreateButton() {createClientGui.setVisible(true);}
    public void clientInsertButton()
    {
        Client client = new Client();
        client.setName(createClientGui.getNameTextField().getText());
        client.setNumber(createClientGui.getNumberTextField().getText());
        client.setEmail(createClientGui.getEmailTextField().getText());
        cbll.createClient(client);
        createClientGui.dispose();
        updateTables();
    }

    public void clientShowUpdateButton() {updateClientGui.setVisible(true);}

    public void clientUpdateButton()
    {
        try
        {
            int aux_id;
            Client client = new Client();
            aux_id = Integer.parseInt(updateClientGui.getIdTextField().getText());
            client.setName(updateClientGui.getNameTextField().getText());
            client.setNumber(updateClientGui.getNumberTextField().getText());
            client.setEmail(updateClientGui.getEmailTextField().getText());

            if (cbll.findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            cbll.updateClient(aux_id, client);
            updateTables();
            updateClientGui.setVisible(false);

        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!"); }
    }

    public void clientShowDeleteButton() {deleteClientGui.setVisible(true);}

    public void clientDeleteButton()
    {
        try
        {
            int aux_id;
            aux_id = Integer.parseInt(deleteClientGui.getIdTextField().getText());

            if (cbll.findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }


            cbll.deleteClient(aux_id, obll.getOrderDAO());
            updateTables();
            deleteClientGui.setVisible(false);

        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}
    }

    public void productShowCreateButton() {this.createProductGui.setVisible(true); }
    public void productCreateButton()
    {
        try {
            Product product = new Product();
            product.setName(createProductGui.getNameTextField().getText());
            product.setPrice(Integer.parseInt(createProductGui.getPriceTextField().getText()));
            product.setQuantity(Integer.parseInt(createProductGui.getQuantityTextField().getText()));

            if (product.getPrice()  < 0 || product.getQuantity() < 0)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            pbll.createProduct(product);
            createClientGui.setVisible(false);
            updateTables();
        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}
    }

    public void productShowUpdateButton() {this.updateProductGui.setVisible(true); }
    public void productUpdateButton()
    {
        try
        {
            int aux_id;
            Product product = new Product();
            aux_id = Integer.parseInt(updateProductGui.getIdTextField().getText());
            product.setName(updateProductGui.getNameTextField().getText());
            product.setPrice(Integer.parseInt(updateProductGui.getPriceTextField().getText()));
            product.setQuantity(Integer.parseInt(updateProductGui.getQuantityTextField().getText()));

            if (product.getPrice()  < 0 || product.getQuantity() < 0)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            if (pbll.getProductDAO().findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            pbll.updateProduct(aux_id, product);
            updateTables();
            updateProductGui.setVisible(false);
        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}
    }

    public void productShowDeleteButton() {this.deleteProductGui.setVisible(true);}
    public void productDeleteButton()
    {
        try
        {
            int aux_id = Integer.parseInt(deleteProductGui.getIdTextField().getText());

            if (pbll.getProductDAO().findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            if(!pbll.deleteProduct(aux_id, obll.getOrderDAO()))
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }
            updateTables();
            deleteProductGui.setVisible(false);
        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}

    }

    public void orderShowCreateButton() {this.createOrderGui.setVisible(true);}
    public void orderShowUpdateButton() {this.updateOrderGui.setVisible(true);}
    public void orderShowDeleteButton() {this.deleteOrderGui.setVisible(true);}

    public void orderCreateButton()
    {
        try
        {
            Order order = new Order();
            order.setIdClient(Integer.parseInt(createOrderGui.getClientIdTextField().getText()));
            order.setIdProduct(Integer.parseInt(createOrderGui.getProductIdTextField().getText()));
            order.setQuantity(Integer.parseInt(createOrderGui.getQuantityTextField().getText()));

            if (!obll.insertOrder(order, pbll.getProductDAO()))
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }
            updateTables();
            createOrderGui.setVisible(false);
        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}
    }

    public void orderUpdateButton()
    {
        try
        {
            int aux_id;
            Order order = new Order();
            aux_id = Integer.parseInt(updateOrderGui.getIdTextField().getText());
            order.setIdClient(Integer.parseInt(updateOrderGui.getClientIdTextField().getText()));
            order.setIdProduct(Integer.parseInt(updateOrderGui.getProductIdTextField().getText()));
            order.setQuantity(Integer.parseInt(updateOrderGui.getQuantityTextField().getText()));

            if (order.getQuantity() < 0)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            if (obll.findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            if (!obll.updateOrder(aux_id, order, pbll.getProductDAO()))
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            updateTables();
            updateProductGui.setVisible(false);
        }
        catch (Exception e) { JOptionPane.showMessageDialog(view, "Invalid Input Data!");}

    }

    public void orderDeleteButton()
    {
        try
        {
            int aux_id = Integer.parseInt(deleteOrderGui.getIdTextField().getText());

            if (obll.findById(aux_id) == null)
            {
                JOptionPane.showMessageDialog(view, "Invalid Input Data!");
                return;
            }

            obll.deleteOrder(aux_id, pbll.getProductDAO());
            updateTables();
            deleteOrderGui.setVisible(false);
        }
        catch (Exception e) {JOptionPane.showMessageDialog(view, "Invalid Input Data!");}
    }

    public void printReceiptButton() {
        List<Client> clients = cbll.getClientDAO().findAll();

        File file = new File("facturi.txt");
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(file);
        } catch (Exception ignored) {}

        for (Client c : clients)
        {
            System.out.println(cbll.generateReceipt(c.getId(), pbll.getProductDAO(), obll.getOrderDAO()));
            writer.print(cbll.generateReceipt(c.getId(), pbll.getProductDAO(), obll.getOrderDAO()));
        }

        writer.close();
        JOptionPane.showMessageDialog(view, "Au fost generate facturile pentru toti clientii!");
    }

}
