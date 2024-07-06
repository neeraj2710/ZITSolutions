package in.co.task1_CRUD_Operations;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Pojo pojo = new Pojo();
        do{
            System.out.println("Enter your choice\n1)Add Data\n2)Delete Data\n3)Display Data\n4)Update data\n5)Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter your name");
                    pojo.setName(sc.next());
                    System.out.println("Enter your age");
                    pojo.setAge(sc.nextInt());
                    System.out.println("Enter your Occupation");
                    pojo.setJob(sc.next());
                    try{
                        if(DAO.insert(pojo))
                            System.out.println("Data added successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Enter your name");
                    String name = sc.next();

                    try{
                        if(DAO.delete(name))
                            System.out.println("Data deleted successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter your name");
                    pojo.setName(sc.next());
                    System.out.println("Enter your age");
                    pojo.setAge(sc.nextInt());
                    System.out.println("Enter your Occupation");
                    pojo.setJob(sc.next());

                    try{
                        if(DAO.update(pojo))
                            System.out.println("Data updated successfully");
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try{
                        System.out.println(DAO.getAll());
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our program");
                    System.exit(0);
                default:
                    System.out.println("invalid choice");


            }
        }while(choice!=5);
    }
}
