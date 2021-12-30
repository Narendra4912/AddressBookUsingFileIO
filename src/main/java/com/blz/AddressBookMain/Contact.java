package com.blz.AddressBookMain;


import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Contact implements Serializable {

    //default serialVersion id
    private static final long serialVersionUID = 1L;
    String first_name, last_name, address, city, email;
    long zip, phone_number;

    public Contact(){}



    public Contact addNewContact() throws IOException {

        Contact person = new Contact();
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter First Name = ");
        person.first_name=sc.next();

//        System.out.println("Enter Last Name = ");
//        person.last_name=sc.next();
//
//        System.out.println("Enter Address = ");
//        person.address=sc.next();
//
//        System.out.println("Enter City = ");
//        person.city=sc.next();
//
//        System.out.println("Enter Zip Code = ");
//        person.zip= Long.parseLong(sc.next());
//
//        System.out.println("Enter Phone Number = ");
//        person.phone_number= Long.parseLong(sc.next());
//
//        System.out.println("Enter Email Address = ");
//        person.email=sc.next();

//        String filePath ="D:\\BridgeLabz Assignments\\AddressBookApplication\\src\\main\\resources\\AddressBook.txt";
//        String csvPath = "D:\\BridgeLabz Assignments\\AddressBookApplication\\src\\main\\resources\\contacts.csv";
        String jsonPath = "D:\\BridgeLabz Assignments\\AddressBookApplication\\src\\main\\resources\\contacts.json";
        Path path = Paths.get(jsonPath);

        try {

            /*FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(person.toString());
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

            System.out.println("\n\n\n");

            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object object = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            System.out.println(object);
            objectIn.close();*/

            /*FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(person.first_name);
            fileWriter.append(person.last_name);
            fileWriter.write(person.address);
            fileWriter.write(person.city);
            fileWriter.write(String.valueOf(person.zip));
            fileWriter.write(String.valueOf(person.phone_number));
            fileWriter.write(person.email);
            fileWriter.close();
            System.out.println("The contact was successfully written to a file");

            System.out.println("*******************************************************");

            FileReader fileReader = new FileReader(filePath);
            int i;
            while((i=fileReader.read())!=-1)
                System.out.print((char)i);
            fileReader.close();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine())!=null)
                System.out.println(line);*/


            /*//CSV File reading and writing
            Writer writer = Files.newBufferedWriter(Paths.get(csvPath));
            StatefulBeanToCsv beantoCSV = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<Contact> contactList = new ArrayList<>();
            contactList.add(person);
            beantoCSV.write(contactList);
            //beantoCSV.write(person.last_name);
            writer.close();

            Reader reader = Files.newBufferedReader(path);
            CsvToBean<Contact> csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class).build();
            contactList = csvToBean.parse();
            System.out.println(contactList);*/

            Gson gson = new Gson();
            List<Contact> contactList = new ArrayList<>();
            contactList.add(person);
            String json = gson.toJson(contactList);

            FileWriter fileWriter = new FileWriter(jsonPath);
            fileWriter.write(json);
            fileWriter.close();

            BufferedReader br = new BufferedReader(new FileReader(jsonPath));
            Contact[] contacts = gson.fromJson(br,Contact[].class);
            System.out.println(Arrays.asList(contactList));
            br.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return person;
    }


    public void showSingleContact(Contact person)
    {
            System.out.println("*****************************************************");
            System.out.println("First Name : " + person.first_name);
            System.out.println("Last Name : " + person.last_name);
            System.out.println("Address : " + person.address);
            System.out.println("City Name : " + person.city);
            System.out.println("Zip code : " + person.zip);
            System.out.println("Phone Number : " + person.phone_number);
            System.out.println("Email ID : " + person.email);
            System.out.println("*****************************************************");

    }

    public void showContact(ArrayList<Contact> person)
    {
        for (int i = 0; i < person.size(); i++) {

            System.out.println("*****************************************************");
            System.out.println("First Name : " + person.get(i).first_name);
            System.out.println("Last Name : " + person.get(i).last_name);
            System.out.println("Address : " + person.get(i).address);
            System.out.println("City Name : " + person.get(i).city);
            System.out.println("Zip code : " + person.get(i).zip);
            System.out.println("Phone Number : " + person.get(i).phone_number);
            System.out.println("Email ID : " + person.get(i).email);
            System.out.println("*****************************************************");
        }
    }

    public void updateContact(String name, ArrayList<Contact> contacts) throws IOException {
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).first_name)) {
                contacts.remove(i);
                contacts.add(i, addNewContact());
            }
        }
        System.out.println("Contact details for "+name+" updated successfully !!!");
    }


    public void deleteContact(String name, ArrayList<Contact> contacts) {
        int flag = 0;
        for (int i = 0; i < contacts.size(); i++) {
            if (name.equals(contacts.get(i).first_name)) {
                contacts.remove(i);
                System.out.println("Contact details for " + name + " deleted successfully !!!");
                flag = 1;
            }
        }
        if(flag == 0)
        {
            System.out.println("There is no contact details available for name = " + name +" !!!");
        }
    }

//    public void showAddressBook(Map<String, Contact> addressBookMap) {
//        for (String addressBook : addressBookMap.keySet()) {
//            System.out.println("Contacts in the " + addressBook.toString() + " are " + addressBookMap.get(addressBook).toString());
//        }
//    }

    @Override
    public String toString() {
        return "Contact{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", zip=" + zip +
                ", phone_number=" + phone_number +
                '}';
    }
}
