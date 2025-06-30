// William Odom
// Lab #1

import java.util.Scanner;
//import javax.swing.JOptionPane;

public class Main {

    static int get_input(Scanner in, int num, String msg){ 
        System.out.print("Enter a " + msg + ": ");
        while (!in.hasNextInt()) {
            System.out.print("\nInvalid input, enter a " + msg + ": ");
            in.nextLine(); // Clear the invalid input
        }
        num = in.nextInt();
        in.nextLine(); // Clear the invalid input
        return num;
    }

    static float get_input(Scanner in, float dec, String msg){ 
        System.out.print("Enter a " + msg + ": ");
        while (!in.hasNextFloat()) {
            System.out.print("\nInvalid input, enter a " + msg + ": ");
            in.nextLine(); // Clear the invalid input
        }
        dec = in.nextFloat();
        in.nextLine(); // Clear the invalid input
        return dec;
    }

    static String get_input(Scanner in, String n, String msg){ 
        System.out.print("Enter a " + msg + ": ");
        while (in.hasNextInt() || in.hasNextBoolean() || in.hasNextFloat() || in.hasNextDouble()) {
            System.out.print("\nInvalid input, enter a " + msg + ": ");
            in.nextLine(); // Clear the invalid input
        }
        n = in.next();
        in.nextLine(); // Clear the invalid input
        return n;
    }

    static void display_output(String name, String noun, int num, float dec){
        System.out.println("\nSo there I was, "+ name + " and I had just left the station.");
        System.out.println("Things were going smoothly, then "+ num + " " + noun + "s appeared!");
        System.out.println("We tried to just go about our day, but these " + noun + "s seemed angry.");
        System.out.println("We figured we had a " + dec + "% chance of beating these " + noun + "s, ");
        System.out.println("luckily the authorities arrived and saved the day.");
        System.out.println("You never know what could happen when you leave the station!\n");
    }

    static void madlibs(Scanner input)   {
        System.out.println("\nLet's play Mad Libs!");
        String name = null;
        String noun = null;
        String msg = null;
        int num = 0;
        float dec = 0;
        
        msg = "num"; num = get_input(input, num, msg);
        msg = "name"; name = get_input(input, name, msg);
        msg = "decimal"; dec = get_input(input, dec, msg);
        msg = "noun"; noun = get_input(input, noun, msg);
        display_output(name, noun, num, dec);
    }

    public static void displaymenu()    { System.out.println("Menu: \nPlay Mad Libs: 1 \nQuit: 0");}

    public static void main(String[] args) {
        int menu_input;
        Scanner input = new Scanner(System.in);

        // Display Menu
        displaymenu();
        do {
            while(!input.hasNextInt())  {
                System.out.print("\nInvalid input, try again \n");
                displaymenu();
                input.nextLine();
            }
            menu_input = input.nextInt();
            input.nextLine(); // Clear the invalid input
            switch(menu_input)  
            {
                case 1 : madlibs(input); displaymenu(); break;
                case 0 : break;
                default: System.out.print("\nInvalid input, try again \n"); displaymenu();
            }
        } while (menu_input != 0);
        input.close();
        System.out.println("\nGoodbye! Thanks for stopping by!");
    }
}
