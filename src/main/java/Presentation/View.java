package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame
{
    private JTable table2;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JButton createButton2;
    private JButton updateButton2;
    private JButton deleteButton2;
    private JButton receiptButton;
    private JTabbedPane tabbedPane;
    private JTable table1;
    private JButton createButton1;
    private JButton updateButton1;
    private JButton deleteButton1;
    private JPanel clientPanel;
    private JPanel productPanel;
    private JPanel orderPanel;

    private Controller controller;

    public View(String name)
    {
        super(name);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(tabbedPane);
        this.pack();
        this.setVisible(true);
        DefaultTableModel client = new DefaultTableModel();
        DefaultTableModel product = new DefaultTableModel();
        DefaultTableModel order = new DefaultTableModel();
        table1.setModel(client);
        table1.setEnabled(false);
        table2.setModel(product);
        table3.setModel(client);
        table4.setModel(product);
        table5.setModel(order);
        table2.setEnabled(false);
        table3.setEnabled(false);
        table4.setEnabled(false);
        table5.setEnabled(false);
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public JTable getTable3() {
        return table3;
    }

    public void setTable3(JTable table3) {
        this.table3 = table3;
    }

    public JTable getTable4() {
        return table4;
    }

    public void setTable4(JTable table4) {
        this.table4 = table4;
    }

    public JTable getTable5() {
        return table5;
    }

    public void setTable5(JTable table5) {
        this.table5 = table5;
    }

    public JButton getCreateButton2() {
        return createButton2;
    }

    public void setCreateButton2(JButton createButton2) {
        this.createButton2 = createButton2;
    }

    public JButton getUpdateButton2() {
        return updateButton2;
    }

    public void setUpdateButton2(JButton updateButton2) {
        this.updateButton2 = updateButton2;
    }

    public JButton getDeleteButton2() {
        return deleteButton2;
    }

    public void setDeleteButton2(JButton deleteButton2) {
        this.deleteButton2 = deleteButton2;
    }

    public JButton getReceiptButton() {
        return receiptButton;
    }

    public void setReceiptButton(JButton receiptButton) {
        this.receiptButton = receiptButton;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getCreateButton1() {
        return createButton1;
    }

    public void setCreateButton1(JButton createButton1) {
        this.createButton1 = createButton1;
    }

    public JButton getUpdateButton1() {
        return updateButton1;
    }

    public void setUpdateButton1(JButton updateButton1) {
        this.updateButton1 = updateButton1;
    }

    public JButton getDeleteButton1() {
        return deleteButton1;
    }

    public void setDeleteButton1(JButton deleteButton1) {
        this.deleteButton1 = deleteButton1;
    }

    public JPanel getClientPanel() {
        return clientPanel;
    }

    public void setClientPanel(JPanel clientPanel) {
        this.clientPanel = clientPanel;
    }

    public JPanel getProductPanel() {
        return productPanel;
    }

    public void setProductPanel(JPanel productPanel) {
        this.productPanel = productPanel;
    }

    public JPanel getOrderPanel() {
        return orderPanel;
    }

    public void setOrderPanel(JPanel orderPanel) {
        this.orderPanel = orderPanel;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
