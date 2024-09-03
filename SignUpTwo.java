package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener{
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes, sno,eyes,eno;
    JComboBox religion2, category2, income2, occupation2, education2;
    String formno;

    SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");



        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Parsi", "Christian", "Other"};
        religion2 = new JComboBox(valReligion);
        religion2.setBounds(300,140,400,30);
        religion2.setBackground(Color.WHITE);
        add(religion2);


        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category2 = new JComboBox(valCategory);
        category2.setBounds(300,190,400,30);
        category2.setBackground(Color.WHITE);
        add(category2);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        String valincome[] = {"Null", "less than 1,50,000", "less than 2,50,000", "less than 5,00,000", "Upto 10,00,000", "greater than 10,00,000"};
        income2 = new JComboBox(valincome);
        income2.setBounds(300,240,400,30);
        income2.setBackground(Color.WHITE);
        add(income2);


        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        String valeducation[] = {"Non Graduate", "Graduation", "Under Graduation", "Post Graduation", "Doctrate", "Other"};
        education2 = new JComboBox(valeducation);
        education2.setBounds(300,315,400,30);
        education2.setBackground(Color.WHITE);
        add(education2);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        String valoccupation[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupation2 = new JComboBox(valoccupation);
        occupation2.setBounds(300,390,400,30);
        occupation2.setBackground(Color.WHITE);
        add(occupation2);


        JLabel panno = new JLabel("PAN Number:");
        panno.setFont(new Font("Raleway", Font.BOLD,20));
        panno.setBounds(100,440,200,30);
        add(panno);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,60,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(450,540,60,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD,20));
        existing.setBounds(100,590,200,30);
        add(existing);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450,590,60,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(syes);
        existinggroup.add(sno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,630,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,720);
        setLocation(210,2);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        String sreligion = (String)religion2.getSelectedItem();
        String scategory = (String)category2.getSelectedItem();
        String sincome = (String)income2.getSelectedItem();
        String seducation =(String)education2.getSelectedItem();
        String soccupation = (String)occupation2.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"' , '"+sincome+"' , '"+seducation+"', '"+soccupation+"', '"+span+"' , '"+saadhar+"' , '"+seniorcitizen+"' , '"+existingaccount+"')";
                c.s.executeUpdate(query);
                //signupthree object
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
