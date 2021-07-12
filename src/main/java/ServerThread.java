import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DBManager dbManager=new DBManager();
            dbManager.connect();

            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());


            PackageData pd=null;
            while ( (pd=(PackageData)objectInputStream.readObject())!=null) {
                if (pd.getOperationType().equals("ADD")) {
                    Student studentFromClient = pd.getStudent();
                    dbManager.addStudent(studentFromClient);
                } else if (pd.getOperationType().equals("LIST")) {


                    ArrayList<Student> infoFromClient = dbManager.getAllStudents();
                    PackageData toClient = new PackageData(infoFromClient);
                    objectOutputStream.writeObject(toClient);
                }
            }
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
