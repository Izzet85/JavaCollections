package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private String myNumber;

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Contacts> listOfContacts ;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.listOfContacts = new ArrayList<>();
    }

    public static ArrayList<Contacts> getListOfContacts() {
        return listOfContacts;
    }

    public void printMobilePhoneList() {
        System.out.println("There are " + listOfContacts.size() + " on your phone");

        for (int i=0; i<listOfContacts.size();i++){
            System.out.println(listOfContacts.get(i).getName() +" ----> " + listOfContacts.get(i).getPhoneNumber());
        }


    }

    public boolean addContact(Contacts contact){
        if (findContact(contact.getName()) >=0){
            System.out.println("contact is already on file");
            return false;
        }

        listOfContacts.add(contact);
        return true;

    }



    public boolean modifyContact(Contacts oldContact,Contacts newContact){
        int position = findContact(oldContact);

           if (position <0){
               System.out.println(oldContact.getName() +" does not exists");
               return false;

           }else{
               listOfContacts.set(position,newContact);
               System.out.println("old contact with name "+ oldContact.getName() + " has been replaced with "+ newContact.getName());
               return true;

           }

    }

    public boolean removeContact(Contacts contact){
        int position = findContact(contact);

        if (position <0){
            System.out.println(contact.getName() +" does not exists");
            return false;

        }else{
            listOfContacts.remove(contact);
            System.out.println("old contact with name "+ contact.getName() + "has been removed");
            return true;

        }

    }

    public  void removeContact(String name){
        int position = findContact(name);

        if (position >= 0) {
            listOfContacts.remove(position);
        }
    }

    private int findContact(Contacts contact){
        return this.listOfContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i=0; i<this.listOfContacts.size();i++){
            Contacts contact = this.listOfContacts.get(i);

            if (contact.getName().equals(contactName) ){
              return i;
            }


        }
        return -1;

    }

    public String queryContact(Contacts contact){
        if (findContact(contact) >= 0){
            return contact.getName();
        }

        return null;
    }

    public Contacts queryContact(String name){
        int position = findContact(name);
        if (position >=0){
          return  this.listOfContacts.get(position);
        }
        return null;
    }


    public void printContacts(){
        System.out.println("Contact list");
        for (int i=0;i<this.listOfContacts.size();i++){
            System.out.println((i+1) +" . " +
                    this.listOfContacts.get(i).getName() + " " +
                    this.listOfContacts.get(i).getPhoneNumber());
    }




    }



}

