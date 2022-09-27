/*
This is a subclass that provides a couple of methods to 
Aid the T1D project. The purpose is to Calculate the 
Insulin needed from the carbs consumed
*/

public class CalculateCarbs extends Calculate{
    
    // override the 'Calculate' abstract method
    public double calculateInsulin(double cr, double carb){
        _injectionAmount = carb / cr;
        return _injectionAmount;} }
