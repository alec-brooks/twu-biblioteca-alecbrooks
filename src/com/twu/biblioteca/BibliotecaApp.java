package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        System.out.println(ui.getWelcomeMessage());
        System.out.println(ui.getMenuString());

        int menuSelection = -1;

        while(menuSelection != ui.getExitCode()){
            menuSelection = ui.getUserMenuSelection();
            System.out.println(ui.getMenuOption(menuSelection));
        }
    }
}
