

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public void connect() {
        try{
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/University","postgres","root");
        }
        catch (Exception e) {
            System.out.println("");
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "Insert into Student(id,name,surname,faculty,groups)"+"VALUES (null,?,?,?,?)"
            );
            statement.setString(1,student.getName());
            statement.setString(2,student.getSurname());
            statement.setString(3,student.getFaculty());
            statement.setString(4,student.getGroup());
            statement.executeUpdate();

            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentsList=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT *FROM 'Student'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                String faculty=resultSet.getString("faculty");
                String groups=resultSet.getString("groups");
                studentsList.add(new Student(id,name,surname,faculty,groups));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentsList;
    }


    /*public void deleteStudent(Integer id) {
        try {
            PreparedStatement statement=connection.prepareStatement(""+
                    "DELETE FROM Student WHERE id = ?");
            statement.setInt(1,id);
            int rows=statement.executeUpdate();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }*/
}
