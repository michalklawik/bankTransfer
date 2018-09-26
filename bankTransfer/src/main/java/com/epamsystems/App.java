package com.epamsystems;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        UserInterface userInterface = new UserInterface();
        UserInterface.printMainMenu();
        Scanner scanner = new Scanner(System.in);
        userInterface.getUsersChoice(scanner.next());
    }
}
