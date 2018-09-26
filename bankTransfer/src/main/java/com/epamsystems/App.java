package com.epamsystems;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        UserInterface.printMainMenu();
        Scanner scanner = new Scanner(System.in);
        UserInterface.getUsersChoice(scanner.next());
    }
}
