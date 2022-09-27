/*
This is my S.T.E.M. Train project
*/

import java.util.Scanner;
import java.time.*;  // LocalTime and LocalDate classes

public class CommandLinePrototype{
    
    public static void main(String[] args){
        // object declarations
        CalculateBS bloodSugar = new CalculateBS();
        CalculateCarbs carbs = new CalculateCarbs();
        FileMaker account = new FileMaker();
        Scanner keyboard = new Scanner(System.in);

        // simple declarations
        int bs,
            isf,
            numCarbs,
            carbRatio,
            units;
        String userName,
               password;
        char option;

        // calculate
        System.out.println("Enter your bloodsugar:");
        bs = keyboard.nextInt();
        System.out.println("Enter your ISF:");
        isf = keyboard.nextInt();
        System.out.println("Enter the carbs you are " +
                           "eating:");
        numCarbs = keyboard.nextInt();
        System.out.println("Enter your current carb " +
                           "ratio:");
        carbRatio = keyboard.nextInt();
        units = rounder(carbs.calculateInsulin
                (carbRatio, numCarbs) + 
                bloodSugar.calculateInsulin(isf, bs));
        System.out.println("You need to inject " + 
                           units + " units of insulin");
        // making account
        System.out.println("Would like to setup an " +
                           "account or log in:");
        option = keyboard.next().charAt(0);
        if(option == 'S' || option == 's'){
            do{
                System.out.println("Enter a userName:");
                userName = keyboard.next() + ".txt";
            }while(!account.setFileName(userName));
            System.out.println("Enter a password:");
            password = keyboard.next();
            account.setFirstLine(password);}
        else{
            do{
                System.out.println("Enter your userName:");
                userName = keyboard.next() + ".txt";
                System.out.println("Enter your password:");
                password = keyboard.next();
            }while(!account.check(userName, password));}

        // saving calculations to the Account
        Write writer = new Write(userName);
        LocalDate currentDate = LocalDate.now();
        writer.save(currentDate);
        LocalDateTime currentTime = LocalDateTime.now();
        writer.save(getMeal(currentTime.getHour()));
        writer.save(bs);
        writer.save(numCarbs);
        writer.save(units);

        // use records
        MedicalRecords records = new MedicalRecords
                                 (userName);
        System.out.println("Your A1C is " + 
                           records.getA1C() + "\nYour " +
                           "average carb intake is " +
                           records.getAverageCarbs() +
                           "\nYour average insulin is " +
                           records.getAverageInsulin());}
    // "helper method" to round to the nearest integer
    public static int rounder(double dHolder){
        int intHolder = (int)(dHolder + 0.5);
        return intHolder;} 

    /* "helper method" to apply a char representing the 
        meal, given the hour. 'B', 'L', 'D' are options */
    public static char getMeal(int hour){
         char charHolder;
         
         if(hour > 3 && hour < 11){
            charHolder = 'B';}
         else if(hour > 11 && hour < 15){
            charHolder = 'L';}
         else{  
            charHolder = 'D';}

         return charHolder;} }
            
