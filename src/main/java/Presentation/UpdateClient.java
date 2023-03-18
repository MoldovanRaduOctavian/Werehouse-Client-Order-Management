package Presentation;

import javax.swing.*;
import java.awt.*;

public class UpdateClient extends JFrame
{
    private JPanel mainPanel;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel numberLabel;
    private JLabel emailLabel;
    private JLabel blankLabel;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField numberTextField;
    private JTextField emailTextField;
    private JButton acceptButton;

    public UpdateClient(String s)
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
        this.numberLabel = new JLabel("Number");
        this.mainPanel.add(this.numberLabel);
        this.numberTextField = new JTextField();
        this.mainPanel.add(this.numberTextField);
        this.emailLabel = new JLabel("Email");
        this.mainPanel.add(this.emailLabel);
        this.emailTextField = new JTextField();
        this.mainPanel.add(this.emailTextField);
        this.blankLabel = new JLabel("");
        this.mainPanel.add(this.blankLabel);
        this.acceptButton = new JButton("Update");
        this.mainPanel.add(this.acceptButton);

        this.setSize(200, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        //this.setVisible(false);
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

    public JLabel getNumberLabel() {
        return numberLabel;
    }

    public void setNumberLabel(JLabel numberLabel) {
        this.numberLabel = numberLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
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

    public JTextField getNumberTextField() {
        return numberTextField;
    }

    public void setNumberTextField(JTextField numberTextField) {
        this.numberTextField = numberTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(JButton acceptButton) {
        this.acceptButton = acceptButton;
    }
}
