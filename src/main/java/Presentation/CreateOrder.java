package Presentation;

import javax.swing.*;
import java.awt.*;

public class CreateOrder extends JFrame
{
    private JPanel mainPanel;

    private JLabel clientIdLabel;
    private JLabel productIdLabel;
    private JLabel quantityLabel;
    private JLabel blankLabel;
    private JTextField clientIdTextField;
    private JTextField productIdTextField;
    private JTextField quantityTextField;
    private JButton acceptButton;

    public CreateOrder(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.mainPanel = new JPanel(new GridLayout(4, 2));
        this.clientIdLabel = new JLabel("Client ID");
        this.mainPanel.add(this.clientIdLabel);
        this.clientIdTextField = new JTextField();
        this.mainPanel.add(this.clientIdTextField);
        this.productIdLabel = new JLabel("Product ID");
        this.mainPanel.add(this.productIdLabel);
        this.productIdTextField = new JTextField();
        this.mainPanel.add(this.productIdTextField);
        this.quantityLabel = new JLabel("Quantity");
        this.mainPanel.add(this.quantityLabel);
        this.quantityTextField = new JTextField();
        this.mainPanel.add(this.quantityTextField);
        this.blankLabel = new JLabel("");
        this.mainPanel.add(this.blankLabel);
        this.acceptButton = new JButton("Create");
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

    public JLabel getClientIdLabel() {
        return clientIdLabel;
    }

    public void setClientIdLabel(JLabel clientIdLabel) {
        this.clientIdLabel = clientIdLabel;
    }

    public JLabel getProductIdLabel() {
        return productIdLabel;
    }

    public void setProductIdLabel(JLabel productIdLabel) {
        this.productIdLabel = productIdLabel;
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

    public JTextField getClientIdTextField() {
        return clientIdTextField;
    }

    public void setClientIdTextField(JTextField clientIdTextField) {
        this.clientIdTextField = clientIdTextField;
    }

    public JTextField getProductIdTextField() {
        return productIdTextField;
    }

    public void setProductIdTextField(JTextField productIdTextField) {
        this.productIdTextField = productIdTextField;
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
