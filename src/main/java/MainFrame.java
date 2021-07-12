import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menuWindow;
    public static AddStudent addWindow;
    public static ListStudent listWindow;


    public MainFrame() {
        setSize(500,400);
        setTitle("STUDENT APPLICATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuWindow=new MainMenu();
        setLocation(0,0);
        add(menuWindow);

        addWindow=new AddStudent();
        setLocation(0,0);
        addWindow.setVisible(false);
        add(addWindow);


        listWindow=new ListStudent();
        setLocation(0,0);
        listWindow.setVisible(false);
        add(listWindow);
    }
}
