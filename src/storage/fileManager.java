package storage;

import model.Receipt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileManager {
    public static List<Receipt> readFile() throws IOException, ClassNotFoundException {
        File file = new File("list3.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() > 0){
            FileInputStream fs = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fs);
            Object obj = ois.readObject();
            List<Receipt> list = (List<Receipt>) obj;
            ois.close();
            fs.close();
            return list;
        }
        else return new ArrayList<>();
    }

    public static void writeFile(List<Receipt> receipts ) throws IOException {
        FileOutputStream fos = new FileOutputStream("list3.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(receipts);
        fos.close();
        oos.close();
    }
}
