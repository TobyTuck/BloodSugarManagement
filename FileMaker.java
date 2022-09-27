/*
This is a class that is meant to create 'Account' objects 
He can log into his account or create a new one
*/

import java.io.*;  // need classes for writing files
import java.util.Scanner;

public class FileMaker{
    
    private String _userName;
    private String _password;
    private static Scanner keyboard = 
        new Scanner(System.in);

    public FileMaker(){
        _userName = "";
        _password = "";}

    /* method that allows the user to set up an "account"
       "account" = data file w/ name being 'userName' */ 
    public boolean setFileName(String userName){ 
        boolean exists = false; 
        String strHolder;

        // check if file already exists 
        File folder = new File("/home/tobytuckness/" +
                               "STUFF/code_lib/java/" +
                               "Projects/T1D/Accounts");
        File[] accounts = folder.listFiles();
        for(int index = 0; index < accounts.length;
        ++index){
            strHolder = accounts[index].toString();
            if(strHolder.equals("/home/tobytuckness/" +
                                "STUFF/code_lib/java/" +
                                "Projects/T1D/Accounts/" + 
                                userName)){
                exists = true;} }
        if(exists){
            return false;}
        else{
            // make a file with 'userName'
            try{
                PrintWriter myPath = new PrintWriter
                                    ("/home/" +
                                    "tobytuckness/STUFF/" +
                                    "code_lib/java/" +
                                    "Projects/T1D/" +
                                    "Accounts/" + 
                                    userName);

                // set the fields
                _userName = userName;
                return true;
            }catch(FileNotFoundException e){
                System.out.println
                    ("File does not exist");
                return false;} } }

    /*  Method to set the _password field
        And write to the data file */
    public void setFirstLine(String password){
        // open the file for writing
        try{
            PrintWriter inputFile = 
                new PrintWriter("/home/tobytuckness/" +
                                "STUFF/code_lib/java/" +
                                "Projects/T1D/Accounts/" +
                                _userName);

            // write the password to the file
            inputFile.println(password);

            // set the 'password' field
            _password = password;
            inputFile.close();
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");} }
        /* finally{
            inputFile.close();} } */


    /* method that compares the parameters to the 
       FileName, First Line of the text file database */
    public boolean check(String userName, String password){
        boolean access;

        // open the file for reading
        try{
            File myFile = new File("/home/tobytuckness/" +
                                   "STUFF/code_lib/java/" +
                                   "Projects/T1D/" +
                                   "Accounts/" + userName);
            Scanner account = new Scanner(myFile);

            // check that entry matches records
            if(account.next().equals(password)){
                access = true;}
            else{
                access = false;}

            return access;
        }catch(FileNotFoundException e){
            System.out.println("File does not exist");
            return false;} } }
