package Presentation;

import javax.swing.*;
import java.awt.*;

public class UpdateProduct extends JFrame
{
    private JPanel mainPanel;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JLabel blankLabel;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField quantityTextField;
    private JButton acceptButton;

    public UpdateProduct(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.mainPanel = new JPanel(new GridLayout(5, 2));
        this.idLabel = new JLabel("ID");
        this.mainPanel.add(this.idLabel);
        this.idTextField = new JTextField();
        this.mainPanel.add(this.idTextField);
        this.nameLabel = new JLabel("Name");
        this.mainPanel.add(this.nameLabel);
        this.nameTextField = new JTextField();
        this.mainPanel.add(this.nameTextField);
        this.priceLabel = new JLabel("Price");
        this.mainPanel.add(this.priceLabel);
        this.priceTextField = new JTextField();
        this.mainPanel.add(this.priceTextField);
        this.quantityLabel = new JLabel("Quantity");
        this.mainPanel.add(this.quantityLabel);
        this.quantityTextField = new JTextField();
        this.mainPanel.add(this.quantityTextField);
        this.blankLabel = new JLabel("");
        this.mainPanel.add(this.blankLabel);
        this.acceptButton = new JButton("Update");
        this.mainPanel.add(this.acceptButton);

        this.setSize(200, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }

    public JLabel getQuantityLabel() {
        return quantityLabel;
    }

    public void setQuantityLabel(JLabel quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

    public JLabel getBlankLabel() {
        return blankLabel;
    }

    public void setBlankLabel(JLabel blankLabel) {
        this.blankLabel = blankLabel;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(JButton acceptButton) {
        this.acceptButton = acceptButton;
    }
}
