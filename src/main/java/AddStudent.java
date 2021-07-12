import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends Container {
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel faculty;
    private JLabel group;


    private JTextField nameText;
    private JTextField surnameText;
    private String[] faculties={"ISCS","ISNS","ISHS"};
    private JComboBox facultyBox;
    private JTextField groupText;

    private JButton addButton;
    private JButton backButton;

    public AddStudent() {
        setSize(500,400);
        setLayout(null);

        nameLabel=new JLabel("NAME");
        nameLabel.setBounds(90,60,80,30);
        add(nameLabel);

        nameText=new JTextField();
        nameText.setBounds(170,60,150,30);
        add(nameText);

        surnameLabel=new JLabel("SURNAME");
        surnameLabel.setBounds(90,100,80,30);
        add(surnameLabel);

        surnameText=new JTextField();
        surnameText.setBounds(170,100,150,30);
        add(surnameText);


        faculty=new JLabel("FACULTY");
        faculty.setBounds(90,140,80,30);
        add(faculty);

        facultyBox=new JComboBox(faculties);
        facultyBox.setBounds(170,140,150,30);
        add(facultyBox);


        group=new JLabel("GROUP");
        group.setBounds(90,180,80,30);
        add(group);

        groupText=new JTextField();
        groupText.setBounds(170,180,150,30);
        add(groupText);

        addButton=new JButton("ADD STUDENT");
        addButton.setBounds(90,220,230,30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameText.getText();
                String surname=surnameText.getText();
                String faculty=(String) facultyBox.getSelectedItem();
                String group=groupText.getText();

                Student student=new Student(null,name,surname,faculty,group);
                PackageData pd=new PackageData("ADD",student);
                Main.connect(pd);

                nameText.setText("");
                surnameText.setText("");
                groupText.setText("");
            }
        });
        add(addButton);


        backButton=new JButton("BACK");
        backButton.setBounds(90,260,230,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addWindow.setVisible(false);
                Main.frame.menuWindow.setVisible(true);
            }
        });
        add(backButton);
    }
}
