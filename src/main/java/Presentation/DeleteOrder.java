package Presentation;

import javax.swing.*;
import java.awt.*;

public class DeleteOrder extends JFrame
{
    private JPanel mainPanel;

    private JLabel idLabel;
    private JTextField idTextField;
    private JButton acceptButton;

    public DeleteOrder(String s)
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
        this.acceptButton = new JButton("Delete");
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

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JButton getAcceptButton() {
        return acceptButton;
    }

    public void setAcceptButton(JButton acceptButton) {
        this.acceptButton = acceptButton;
    }
}
