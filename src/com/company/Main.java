package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main {
    
    
    public static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0611728394");


    public static void main(String[] args) {
        boolean quit = false;
        int choice =0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printMobilePhoneList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;

                case 6:
                    quit = true;
                    break;

            }
        }
    }

   

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options. ");
        System.out.println("\t 1 - To print the list of grocery items. ");
        System.out.println("\t 2 - To add an item to the list. ");
        System.out.println("\t 3 - To modify an item in the list. ");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - to search for an item in the list.");
        System.out.println("\t 6 - tp quit the application");
    }


    public static void addContact(){
        System.out.println("Pleas enter an contact name: ");
        String contactName = scanner.nextLine();
        System.out.println("enter new contact phone number");
        String phoneNumber = scanner.nextLine();


      if (mobilePhone.addContact(Contacts.createContact(contactName,phoneNumber))){
            System.out.println("new contact added " + contactName + " phonenumber: " + phoneNumber) ;
        }else{
          System.out.println("contact with name " + contactName + " already on file!");
      }

        }


    public static void modifyItem(){
        System.out.print("Enter existing contact name:  ");
        String contactName = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(contactName);
        if(existingContact == null){
            System.out.println("contact not found!");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName,newNumber);
       if (mobilePhone.modifyContact(existingContact,newContact)){
           System.out.println("succesfully updated record");
       }else{
           System.out.println("error updating record");
       }
    }

    public static void  removeItem(){
        System.out.print("Enter existing contact name:  ");
        String contactName = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(contactName);
        if(existingContact == null){
            System.out.println("contact not found!");
            return;
        }
       if (mobilePhone.removeContact(existingContact)){
           System.out.println("Contact with name: " + existingContact.getName() + " has been removed!");
       } else{
           System.out.println("error!");
       }

    }

    public static void searchForItem(){
        System.out.print("Enter existing contact name:  ");
        String contactName = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(contactName);
        if(existingContact == null){
            System.out.println("contact not found!");
            return;
        }
        System.out.println("Name: " + existingContact.getName()+ " with phone number is " + existingContact.getPhoneNumber()+".");

    }





}












