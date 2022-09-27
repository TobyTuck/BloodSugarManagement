/*
This is a class designed for my T1D Project
The purpose of this class is to allow the user to:
    1. view his medical account
    2. view any specific bloodsugar, insulin, or carb 
       records from any meal on any day
    3. view his average bloodsugar, insulin, and carbs
       for the entire history of the program
The fields will store all the data from the account
*/

import java.util.Scanner;
import java.io.*;  // necessary for reading files
import java.time.LocalDate;

public class MedicalRecords{

    // data member declarations
    private String[] _date = new String[100];
    private int _dateSize;
    private char[] _meal = new char[100];
    private int _mealSize;
    private int[] _bs = new int[100];
    private int _bsSize;
    private int[] _carbs = new int[100];
    private int _carbsSize;
    private double[] _injectionAmount = new double[100];
    private int _unitsSize;
    private double _a1C;

    // constructor
    public MedicalRecords(String fileName){
        // open file for reading
        int count = 0;
        int i = -1;
        try{
            File file = new File("/home/tobytuckness/" +
                                 "STUFF/code_lib/java/" +
                                 "Projects/T1D/Accounts/" +
                                 fileName);
            Scanner medicalRecords = new Scanner(file);
            // get the password out of the way
            String password = medicalRecords.next(); 
            while(medicalRecords.hasNext()){
                // set all the array fields
                _date[count] = medicalRecords.next();
                _meal[count] = 
                    medicalRecords.next().charAt(0);
                _bs[count] = medicalRecords.nextInt();
                _carbs[count] = medicalRecords.nextInt();
                _injectionAmount[count] =
                    medicalRecords.nextDouble();
                ++count;} }
        catch(FileNotFoundException e){
            System.out.println("File does not exist");}
        
        // set the "size" fields
        _dateSize = count;
        _mealSize = count;
        _bsSize = count;
        _carbsSize = count;
        _unitsSize = count;
        
        // set the '_a1C' field
        LocalDate time = LocalDate.now();
        LocalDate holder = time.minusMonths(3);
        String myDate = holder.toString();
        double averageBS = 0;
        // find the corresponding _bs for every w/ in date
        for(int index = 0; index < _dateSize; ++index){
            if(_date[index].equals(myDate)){
                i = index;} }
        // over 3 months of values
        if(i >= 0){
            for(int index = i; index < _bsSize; ++index){
                averageBS += _bs[index];}
            averageBS = averageBS / (_bsSize - i);
            _a1C = round((46.7 + averageBS) / 28.7);}
        // less than 3- average all bs values
        else{
            for(int index = 0; index < _bsSize; ++index){
                averageBS += _bs[index];}
            averageBS = averageBS / (_bsSize);
            _a1C = round((46.7 + averageBS) / 28.7);} }

    // method to return the A1C
    public double getA1C(){
        return _a1C;}

    // methods to return averages of the data members
    public double getAverageCarbs(){
        double holder = 0;

        for(int index = 0; index < _carbsSize; ++index){
            holder += _carbs[index];}
        holder = holder / _carbsSize;

        return holder;}

    public double getAverageInsulin(){
        double holder = 0;

        for(int index = 0; index < _unitsSize; ++index){
            holder += _injectionAmount[index];}
        holder = holder / _unitsSize;

        return holder;}

    /* methods to return a "specific" data member
       returns 0 if DNE */
    public int getBS(char charHolder, String date){
        int myIndex = -1;
        
        for(int index = 0; index < _mealSize; ++index){
            if(_meal[index] == charHolder && 
               _date[index].equals(date)){
                myIndex = index;} }
        if(myIndex == -1){
            return 0;}
        else{
            return _bs[myIndex];} }

    public int getCarbs(char charHolder, String date){
        int myIndex = -1;

        for(int index = 0; index < _mealSize; ++index){
            if(_meal[index] == charHolder &&
               _date[index].equals(date)){
                myIndex = index;} }
        if(myIndex == -1){
            return 0;}
        else{
            return _carbs[myIndex];} }

    public double getInsulin(char charHolder,
                             String date){
        int myIndex = -1;

        for(int index = 0; index < _mealSize; ++index){
            if(_meal[index] == charHolder &&
               _date[index].equals(date)){
                myIndex = index;} }
        if(myIndex == -1){
            return 0;}
        else{
            return _injectionAmount[myIndex];} }
    
    // "helper" that rounds values to the nearest 100th
    private static double round(double value){
        value = value * 100;
        value = (double)((int) value);
        value = value / 100;
        return value;}
}
