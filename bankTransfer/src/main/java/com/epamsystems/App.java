package com.epamsystems;

import com.epamsystems.Service.UserInterface;


public class App
{
    public static void main( String[] args )
    {
        UserInterface userInterface = new UserInterface();
        UserInterface.printInputLine();
        userInterface.getUsersChoice();
    }
}
