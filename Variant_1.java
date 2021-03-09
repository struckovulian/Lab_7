import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Variant_1{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Scanner sc=new Scanner(System.in);
        File mountainData=new File("C:\\Users\\mountainData.txt");
        File answer=new File("C:\\Users\\answer.txt");
        if (answer.exists()) {answer.delete(); }
        answer.createNewFile();
        if (mountainData.exists()) {mountainData.delete();}
        mountainData.createNewFile();
        System.out.println("Сколько гор? ");
        int count = sc.nextInt();
        int kolAfrica=0;
        FileOutputStream f1 = new FileOutputStream(mountainData);
        ObjectOutputStream oos1 = new ObjectOutputStream(f1);
        FileOutputStream fOSAnswer = new FileOutputStream(answer);
        ObjectOutputStream oosAnswer = new ObjectOutputStream(fOSAnswer);
        Mountain moun = new Mountain();
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            moun = new Mountain();
            System.out.println("Введите месторасположение ");
            moun.place = sc.nextLine();
            System.out.println("Введите название горы ");
            moun.Name = sc.nextLine();
            System.out.println("Введите высоту горы  ");
            moun.height = sc.nextLine();
            oos1.writeObject(moun);
            if (moun.place.equals("Africa")){
                oosAnswer.writeObject(moun);
                kolAfrica+=1;
            }
            if (moun.place.equals("Африка")){
                oosAnswer.writeObject(moun);
                kolAfrica+=1;
            }
        }
        FileInputStream fis = new FileInputStream(answer);
        ObjectInputStream oin = new ObjectInputStream(fis);
        int kol=1;
        System.out.println("Горы подходящие под условия ->");
        if (kolAfrica!=0){
            for (int i = 0; i < kolAfrica; i++) {
                moun = (Mountain) oin.readObject();
                System.out.println("Гора номер "+ kol);
                System.out.println(" Название горы "+ moun.Name);
                System.out.println(" ее место = "+ moun.place);
                System.out.println(" ее высота = "+ moun.height);
                System.out.println();
                kol+=1;
            }
        } else {
            System.out.println("Таких гор не существует ");
        }
        oos1.flush();
        oos1.close();

        System.out.println();
        System.out.println("Нужно ли вывести информацию о всех горах ? ");
        System.out.println("Введите ДА если нужно и НЕТ если не нужно ");
        String ask=sc.nextLine();
        if (ask.equals("ДА")){
            fis = new FileInputStream(mountainData);
            oin = new ObjectInputStream(fis);
            for (int i = 0; i < count; i++) {
                moun = (Mountain) oin.readObject();
                System.out.println("Гора номер "+ kol);
                System.out.println(" Название горы "+ moun.Name);
                System.out.println(" ее место = "+ moun.place);
                System.out.println(" ее высота = "+ moun.height);
                System.out.println();
                kol+=1;
            }
        }


        oosAnswer.flush();
        oosAnswer.close();

    }}
