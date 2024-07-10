package in.co.zitsolutions.task4_serialization_deserialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Pojo p = new Pojo();
        p.setName("Raj");
        p.setAge(23);

        File f = new File("object.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Pojo p1 = (Pojo) ois.readObject();

        System.out.println(p);

    }
}
