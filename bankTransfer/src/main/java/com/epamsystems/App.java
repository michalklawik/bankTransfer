package com.epamsystems;

import com.epamsystems.Service.UserInterface;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        UserInterface userInterface = new UserInterface();
        UserInterface.printInputLine();
        Scanner scanner = new Scanner(System.in);
        userInterface.getUsersChoice();
    }
}
