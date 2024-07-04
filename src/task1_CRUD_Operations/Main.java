package task1_CRUD_Operations;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your choice\n1)Add Data\n2)Delete Data\n3)Display Data\n4)Update data\n5)Exit");
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter your name");
                    String name = sc.nextLine();
                    System.out.println("Enter your age");
                    int age = sc.nextInt();
                    System.out.println("Enter your Occupation");
                    String occupation = sc.nextLine();
                    try{
                        if(DAO.insert(name,age,occupation))
                            System.out.println("Data added successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Enter your name");
                    name = sc.next();
                    try{
                        if(DAO.delete(name))
                            System.out.println("Data deleted successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    name = sc.nextLine();
                    System.out.println("Enter your age");
                    age = sc.nextInt();
                    System.out.println("Enter your Occupation");
                    occupation = sc.nextLine();
                    try{
                        if(DAO.update(name,age,occupation))
                            System.out.println("Data updated successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:



            }
        }while(sc.nextInt()!=5);
    }
}
