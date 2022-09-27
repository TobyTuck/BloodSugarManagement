/*
This is a subclass that provides a couple of methods to 
Calculate the insulin needed from the user's bloodsugar
*/

public class CalculateBS extends Calculate{

    // override the 'Calculate' abstract method
    public double calculateInsulin(double isf, double bs){
        _injectionAmount = (bs - 150) / isf;
        if(_injectionAmount < 0){
            _injectionAmount = 0;}
        return _injectionAmount;} }
