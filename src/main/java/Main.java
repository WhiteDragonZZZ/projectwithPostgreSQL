import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Driver;
import java.util.ArrayList;

public class Main {

    public static MainFrame frame;
    public static void connect(PackageData pd) {
        try {
            Socket socket=new Socket("127.0.0.1",8888);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD")) {
                objectOutputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST")) {
                objectOutputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData) objectInputStream.readObject();
                ArrayList<Student> arrayList=infoFromServer.getStudents();
                String s = "";
                for(int i=0; i<arrayList.size(); i++) {
                    s+=arrayList.get(i)+"\n";
                }

                ListStudent.text.append(s);
            }

            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        frame=new MainFrame();
        frame.setVisible(true);

    }
}
