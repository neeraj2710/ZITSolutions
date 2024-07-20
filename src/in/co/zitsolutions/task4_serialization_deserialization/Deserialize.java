package in.co.zitsolutions.task4_serialization_deserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("object.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Pojo p1 = (Pojo) ois.readObject();

        System.out.println(p1);
    }
}
