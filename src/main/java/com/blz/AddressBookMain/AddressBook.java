package com.blz.AddressBookMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;

public class AddressBook {

    public static void main(String[] args) throws IOException {

        /*String addressBookName;
        Map<String, ArrayList<Contact>> addressBookMap = new HashMap<>();
        ArrayList contactsList = null;
        Scanner sc = new Scanner(System.in);

        boolean whileLoopFlag = true;

        System.out.println("\n*************** Welcome to Address Book Application ***************");

        while(whileLoopFlag)
        {
            System.out.println("\n*************** Address Book Menu ***************");

            System.out.println("1. Add New Address Book \n2. Show All Address Books with Contacts \n3. Operations on Address Book \n4. Delete Address Book \n5. Exit");
            System.out.println("Enter Your Choice =  ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Name of Address Book = ");
                    addressBookName = sc.next();
                    if(addressBookMap.containsKey(addressBookName) == false)
                    {
                        addressBookMap.putIfAbsent(addressBookName,null);
                        System.out.println("Address Book Name '"+ addressBookName + "' successfully added in address book list !!!");
                    }
                    else
                        System.out.println("Address Book Name '"+ addressBookName + "' is already exist in address book list !!! \nPlease use different name !!!");
                    break;
                case 2:
                    System.out.println("No of Address Books in Address Book List = " + addressBookMap.size());
                    for(String bookName : addressBookMap.keySet())
                    {
                        String value = addressBookMap.get(bookName).toString();
                        System.out.println(bookName + " --> " + value);
                    }
                    break;
                case 3:
                    System.out.println("Enter Address Book name on which you want to perform operations = ");
                    addressBookName = sc.next();
                    contactsList = ContactDetailsList.optionsInsideAddressBook();
                    if(addressBookMap.get(addressBookName) !=null)
                    {
                        contactsList.add(addressBookMap.get(addressBookName));
                    }
                    addressBookMap.put(addressBookName,contactsList);
                    break;
                case 4:
                    if (addressBookMap.size() > 0) {
                        System.out.println("Enter Address Book name which you want to delete = ");
                        addressBookName = sc.next();
                        addressBookMap.remove(addressBookName);
                        System.out.println("Address Book Name '"+ addressBookName + "' successfully deleted from address book list !!!");
                    }
                    else
                        System.out.println("Address book list is empty so cannot perform delete operation !!!");
                    break;
                case 5:
                    System.out.println("!!! Thank you for using Address Book Application !!!");
                    exit(0);
                default:
                    System.out.println("Wrong Choice !!!!");
            }
        }*/

        Contact newContact = new Contact();
        Contact person = new Contact();
        newContact = person.addNewContact();
    }
}