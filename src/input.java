import java.util.Scanner;

public class input{
    public static void main(String[] args){
    int age=0;
    try (Scanner input = new Scanner(System.in)) {
        System.out.println("Enter an age");

        age= input.nextInt();
    }
    System.out.println("Age is: " +age);
    }
}