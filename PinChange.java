package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 250, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("New Pin: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setBounds(165, 290, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(330, 290, 180, 25);
        image.add(pin);


        JLabel repintext = new JLabel("Re-Enter New Pin: ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 14));
        repintext.setBounds(165, 330, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 22));
        repin.setBounds(330, 330, 180, 25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(165, 422, 150, 22);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 422, 150, 22);
        back.addActionListener(this);
        image.add(back);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin doesn't match!");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

}
