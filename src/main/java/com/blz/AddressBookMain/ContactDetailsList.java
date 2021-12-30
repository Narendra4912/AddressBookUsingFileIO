package com.blz.AddressBookMain;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class ContactDetailsList

{

    public static ArrayList<Contact> optionsInsideAddressBook() throws IOException {
        Map<String, ArrayList<Contact>> addressBookMap = new HashMap<>();
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact person = new Contact();
        Scanner sc = new Scanner(System.in);
        String choice2, name;
        int index = 0;
        boolean whileLoopFlag = true, contactExist = false;



        while(whileLoopFlag)
        {

            System.out.println("\n*************** Contact Details Menu ***************");
            System.out.println("1. Add New Contact \n2. Show Contacts \n3. Update Contact \n4. Delete Contact\n5. Exit from this Menu");
            System.out.println("Enter Your Choice = ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    Contact newContact = new Contact();
                    newContact = person.addNewContact();
                    if(contacts.isEmpty())
                    {
                        contacts.add(newContact);
                        System.out.println("Contact successfully added !!!");
                        contactExist = true;
                    }
                    else
                    {
                        for(Contact existingContact : contacts)
                        {
                            if(existingContact.first_name.equals(newContact.first_name))
                            {
                                System.out.println("These contact details already present in this address book !!!");
                                contactExist = true;
                                break;
                            }
                        }
                    }
                    if (contactExist == false)
                    {
                        contacts.add(newContact);
                        System.out.println("Contact successfully added !!!");
                    }
                    //addressBookMap.put(contacts.get(index).first_name, contacts.get(index++));
                    break;
                case 2:
                    System.out.println("No of Contacts in this Address Book = " + contacts.size());
                    person.showContact(contacts);
                    break;
                case 3:
                    System.out.println("Enter first name for which you want to update the contact details = ");
                    name = sc.next();
                    person.updateContact(name, contacts);
                    break;
                case 4:
                    if (contacts.size() > 0)
                    {
                        System.out.println("Enter first name for which you want to delete the contact details = ");
                        name = sc.next();
                        person.deleteContact(name, contacts);
                    } else
                        System.out.println("Address book is empty so cannot perform delete operation !!!");
                    break;
                case 5:
                    whileLoopFlag = false;
                    break;
            }
        }
        return contacts;
    }
}
