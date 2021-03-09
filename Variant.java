import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Variant {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько гор? ");
        int count = sc.nextInt();
        sc.nextLine();
        RandomAccessFile rf, df;
        String name , place,height, Path1 = "C:\\Users\\mountainData.txt",Path2 = "C:\\Users\\answer.txt";
        try{
            File f1 = new File(Path1);
            File f2 = new File(Path2);
            rf = new RandomAccessFile(f1, "rw");
            df = new RandomAccessFile(f2, "rw");
            for (int i = 0; i < count; i++) {
                System.out.println("Введите название горы ");
                name = sc.nextLine();
                rf.writeUTF(name);
                for (int j = 0; j < 20 - name.length(); j++) {
                    rf.writeByte(1);
                }

                System.out.println("Введите месторасположение ");
                place = sc.nextLine();
                rf.writeUTF(place);
                for (int j = 0; j < 20 - place.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println("Введите возраст ");
                height = sc.nextLine();
                rf.writeUTF(height);
                for (int j = 0; j < 20 - height.length(); j++) {
                    rf.writeByte(1);
                }
                System.out.println();
                if (name.equals("Африка")){
                    df.writeUTF(name);
                    for (int j = 0; j < 20 - name.length(); j++) df.writeByte(1);
                    df.writeUTF(place);
                    for (int j = 0; j < 20 - place.length(); j++) df.writeByte(1);
                    df.writeUTF(height);
                    for (int j = 0; j < 20 - height.length(); j++)df.writeByte(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Mountain implements Serializable {
    String Name;
    String place;
    String height;
}