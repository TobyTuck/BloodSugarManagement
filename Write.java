/*
The purpose of this class is to provide methods that allow
The user to write to text files
*/

import java.io.*;

public class Write{

    // field
    private String _usrName;

    // constructor
    public Write(String usrName){   
        _usrName = usrName;}

    /* provide several overwritten methods account for 
       different types of parameters */
    public void save(int a){
        try{
            // open file for appending
            FileWriter file = new FileWriter("/home/" +
                              "tobytuckness/STUFF/" +
                              "code_lib/java/Projects/" +
                              "T1D/Accounts/" + _usrName,
                              true);
            PrintWriter inputFile = new PrintWriter(file);

            // write to the file
            inputFile.print(a + " ");
            inputFile.close();}
        catch(IOException e){
            System.out.println("File does not exist");} }

    public void save(double a){
        try{
            // open file for appending
            FileWriter file = new FileWriter("/home/" +
                              "tobytuckness/STUFF/" +
                              "code_lib/java/Projects/" +
                              "T1D/Accounts/" + _usrName,
                              true);
            PrintWriter inputFile = new PrintWriter(file);

            // write to the file
            inputFile.print(a + " ");
            inputFile.close();}
        catch(IOException e){
            System.out.println("File does not exist");} }

    public void save(char a){
        try{
            // open file for appending
            FileWriter file = new FileWriter("/home/" +
                              "tobytuckness/STUFF/" +
                              "code_lib/java/Projects/" +
                              "T1D/Accounts/" + _usrName,
                              true);
            PrintWriter inputFile = new PrintWriter(file);

            // write to the file
            inputFile.print(a + " ");
            inputFile.close();}
        catch(IOException e){
            System.out.println("File does not exist");} }

    public void save(Object a){
        try{
            // open file for appending
            FileWriter file = new FileWriter("/home/" +
                              "tobytuckness/STUFF/" +
                              "code_lib/java/Projects/" +
                              "T1D/Accounts/" + _usrName,
                              true);
            PrintWriter inputFile = new PrintWriter(file);

            // write to the file
            inputFile.print(a + " ");
            inputFile.close();}
        catch(IOException e){
            System.out.println("File does not exist");} } }

