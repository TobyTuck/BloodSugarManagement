/* This is a class that will provide a page serves as the 
standard page- and provides a number of JTextFields to
enter values, and two buttons to log in or create an 
account */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // ActionListener, ActionEvent
import java.time.*;  // LocalTime and LocalDate classes
import java.io.*;  // File, IOException

public class Home implements ActionListener{
    
    private JTextField bloodSugar;
    private JTextField isf;
    private JTextField numCarbs;
    private JTextField carbRatio;
    private JButton calculate;
    private JButton a1c;
    private JButton average;
    private JButton specific;
    private String _userName;

    public Home(JFrame frame, String userName, int bS, 
                int carbs, int insulin){
        _userName = userName;

        // add data to file before being logged in if nec.
        if(bS != 0){
            Write writer = new Write(_userName);
            LocalDate currentDate = LocalDate.now();
            LocalDateTime currentTime = 
                LocalDateTime.now();

            // save data to account file
            writer.save(currentDate);
            writer.save(getMeal(currentTime.getHour()));
            writer.save(bS);
            writer.save(carbs);
            writer.save(insulin + "\n");}

        // make default panel 
        frame.getContentPane().removeAll();
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.blue);
        myPanel.setLayout(new BorderLayout());

        // make instance of the "GridBagConstraints"
        GridBagConstraints gbc = new GridBagConstraints();

        // make a background panel
        JPanel background = new JPanel
            (/*new BorderLayout()*/);
        background.setLayout(new GridBagLayout());
        background.setPreferredSize(frame.getSize());
        background.setBackground(Color.blue);

        // make a panel that holds calculation text fields
        JPanel calculatePanel = new JPanel();
        calculatePanel.setBackground(Color.lightGray);
        calculatePanel.setPreferredSize
            (new Dimension(550, 400));
        calculatePanel.setLayout(new GridLayout
            (4, 2, 10, 20));

        // make a "log-in" and "sign-up" panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
        loginPanel.setBackground(Color.lightGray);

        // make a "calculate" button JPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setPreferredSize
            (new Dimension(250, 122));

        // make several blue "filler" panels
        JPanel filler1 = new JPanel();
        filler1.setBackground(Color.blue);
        filler1.setPreferredSize(new Dimension(150, 30));

        // make standard font to use for TextFields, Labels
        Font myFont = new Font
            ("Times New Roman", Font.PLAIN, 35);
        Font myFont2 = new Font
            ("Times New Roman", Font.BOLD, 35);
        Font logoFont;
        try{
             logoFont = Font.createFont    
                (Font.TRUETYPE_FONT, new File("Blenda " +
                "Script.otf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.
                getLocalGraphicsEnvironment();
            //register the font           
            ge.registerFont(logoFont);    
        } catch(IOException | FontFormatException e){
            System.out.println("problem w/ custom font");
            logoFont = myFont;}
        
        // make 4 JTextFields
        bloodSugar = new JTextField();
        bloodSugar.setPreferredSize
            (new Dimension(250, 30));
        bloodSugar.setForeground(Color.white);
        bloodSugar.setBackground(Color.black);
        bloodSugar.setFont(myFont);

        isf = new JTextField();
        isf.setPreferredSize
            (new Dimension(250, 30));
        isf.setForeground(Color.white);
        isf.setBackground(Color.black);
        isf.setFont(myFont);

        numCarbs = new JTextField();
        numCarbs.setPreferredSize
            (new Dimension(250, 30));
        numCarbs.setForeground(Color.white);
        numCarbs.setBackground(Color.black);
        numCarbs.setFont(myFont);

        carbRatio = new JTextField();
        carbRatio.setPreferredSize  
            (new Dimension(250, 30));
        carbRatio.setForeground(Color.white);
        carbRatio.setBackground(Color.black);
        carbRatio.setFont(myFont);

        // make 4 JLabels
        JLabel label1 = new JLabel("Blood Sugar:");
        label1.setForeground(Color.black);
        label1.setFont(myFont2);

        JLabel label2 = new JLabel("ISF:");
        label2.setForeground(Color.black);
        label2.setFont(myFont2);

        JLabel label3 = new JLabel("Carbs:");
        label3.setForeground(Color.black);
        label3.setFont(myFont2);

        JLabel label4 = new JLabel("Carb Ratio:");
        label4.setForeground(Color.black);
        label4.setFont(myFont2);

        //  add JLabels and JTextFields to calculatePanel
        calculatePanel.add(label1);
        calculatePanel.add(bloodSugar);
        calculatePanel.add(label2);
        calculatePanel.add(isf);
        calculatePanel.add(label3);
        calculatePanel.add(numCarbs);
        calculatePanel.add(label4);
        calculatePanel.add(carbRatio);

        gbc.gridx = 0;
        gbc.gridy = 0;
        background.add(calculatePanel, gbc);

        // make 'Calculate' button
        calculate = new JButton("Calculate");
        calculate.setFont(myFont);
        calculate.setForeground(Color.white);
        calculate.setBackground(Color.black);
        calculate.addActionListener(this);
        buttonPanel.add(calculate);
        
        a1c = new JButton("A1C");
        a1c.setBackground(Color.black);
        a1c.setForeground(Color.white);
        a1c.setFont(myFont);
        a1c.addActionListener(this);

        average = new JButton("Average");
        average.setBackground(Color.black);
        average.setForeground(Color.white);
        average.setFont(myFont);
        average.addActionListener(this);

        specific = new JButton("Search");
        specific.setBackground(Color.black);
        specific.setForeground(Color.white);
        specific.setFont(myFont);
        specific.addActionListener(this);

        loginPanel.add(a1c);
        loginPanel.add(average);
        loginPanel.add(specific);

        // test
        JPanel test = new JPanel();
        test.setBackground(Color.blue);
        test.setPreferredSize(new Dimension(200, 120));

        // test 2
        JPanel test2 = new JPanel();
        test2.setBackground(Color.blue);
        test2.setPreferredSize(new Dimension(200, 120));

        GridBagConstraints gbt = new GridBagConstraints();

        // JLabels for top of JPanel 
        JLabel tester1 = new JLabel("MYTESTERYOUMANONE" +
                                    "ROERNIG");
        tester1.setForeground(Color.blue);
        tester1.setFont(myFont);

        JLabel tester2 = new JLabel("MyT1D");
        tester2.setForeground(Color.black);
        tester2.setFont(logoFont);

        JLabel tester3 = new JLabel("ERIA");
        tester3.setForeground(Color.blue);
        tester3.setFont(myFont);
        
        JPanel test3 = new JPanel(new FlowLayout());
        test3.setPreferredSize(new Dimension(250, 122));
        test3.setBackground(Color.blue);

        test3.add(tester1);
        test3.add(tester2);
        test3.add(tester3);
        test3.add(loginPanel, gbt);

        myPanel.add(background, BorderLayout.CENTER);
        myPanel.add(test, BorderLayout.EAST);
        myPanel.add(test2, BorderLayout.WEST);
        myPanel.add(buttonPanel, BorderLayout.SOUTH);
        myPanel.add(test3, BorderLayout.NORTH);

        frame.add(myPanel);
        frame.setVisible(true);
    }
    
    @ Override
    public void actionPerformed(ActionEvent press){
        // press was 'Calculate' button
        if(press.getSource() == calculate){ 
            CalculateCarbs carbCount = 
                new CalculateCarbs();
            CalculateBS bloodC12H22011 = new CalculateBS();
            int bS,
                insulin,
                carbs,
                cR,
                units;

            bS = Integer.parseInt(bloodSugar.getText());
            insulin = Integer.parseInt(isf.getText());
            carbs = Integer.parseInt(numCarbs.getText());
            cR = Integer.parseInt(carbRatio.getText()); 
            
            // calculate insulin
            units = rounder(carbCount.calculateInsulin
                    (cR, carbs) +  bloodC12H22011.
                    calculateInsulin(insulin, bS));

            // display calculations
            JOptionPane.showMessageDialog(null, "Inject " +
                                          units + " units"+
                                          " of insulin");

            Write writer = new Write(_userName);
            LocalDate currentDate = LocalDate.now();
            LocalDateTime currentTime = 
                LocalDateTime.now();

            // save data to account file
            writer.save(currentDate);
            writer.save(getMeal(currentTime.getHour()));
            writer.save(bS);
            writer.save(carbs);
            writer.save(units + "\n");} 
            
            /* physical 'Enter' button = 'Calculate' button
            calculate.addKeyListener(new KeyListener()) {
            // listen to keys
            public void keyPressed(KeyEvent e){
                // find ENTER key press
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    calculate();} } }
            calculate();*/

        // press was to calculate A1C
        else if(press.getSource() == a1c){
            MedicalRecords records = 
                new MedicalRecords(_userName);
            JOptionPane.showMessageDialog(null, "Your " +
                                          "A1C is " + 
                                          records.
                                          getA1C());}

        // press was to find the average of bs, carbs
        else if(press.getSource() == average){
            MedicalRecords records = 
                new MedicalRecords(_userName);
            int i = 0;
            char option;

            do{
                if(i > 0){
                    JOptionPane.showMessageDialog
                    (null, "Incorrect Input!\nEnter " +
                    "either 'carbs' or 'insulin'");}
                // user option for BS, carb averages
                option = JOptionPane.showInputDialog
                ("Would you like to receive:\nThe " +
                "average number of carbs you consume " +
                "per meal\nThe average units of " +
                "insulin you inject per meal").charAt(0);
                ++i;
            }while(option != 'c' && option != 'C' &&
                   option != 'i' && option != 'I');

            if(option == 'c' || option == 'C'){ 
                JOptionPane.showMessageDialog(null, 
                "The average number of carbs you " +
                "consume each meal is " + 
                rounder(records.getAverageCarbs())+ 
                " carbs");}

            else{ 
                JOptionPane.showMessageDialog(null, 
                "Your average insulin inject amount is " +
                rounder(records.getAverageInsulin()));} } 

        // press was to find a specific entry
        if(press.getSource() == specific){
            MedicalRecords records = 
                new MedicalRecords(_userName);
            int i = 0;
            char categoryOption,
                 mealOption;
            String date,
                   meal,
                   message;

            // get category
            do{
                if(i > 0){
                    JOptionPane.showMessageDialog
                    (null, "Incorrect Input!\nEnter " +
                    "either 'carbs', 'insulin', or " +
                    "'bloodsugar'");}
                // user option for BS, carb averages
                categoryOption = 
                JOptionPane.showInputDialog
                ("Would you like to view a specific " +
                 "entry for:\nInsulin injection\nCarbs\n" +
                 "Blood Sugar").charAt(0);
                ++i;
            }while(categoryOption != 'c' && 
                   categoryOption != 'C' &&
                   categoryOption != 'i' && 
                   categoryOption != 'I' &&
                   categoryOption != 'b' && 
                   categoryOption != 'B');
            
            // get date
            i = 0;
            do{
                if(i > 0){
                    JOptionPane.showMessageDialog(null, 
                    "Incorrect Input!");}
                date = JOptionPane.showInputDialog
                ("Enter the date of the event you are " +
                 "searching for (in the format " +
                 "YYYY-MM-DD):");
                ++i;
            }while(date.length() != 10);

            // get meal character
            i = 0;
            do{
                if(i > 0){
                    JOptionPane.showMessageDialog(null,
                    "Incorrect Input!\nEnter either " +
                    "breakfast, lunch, or dinner");}
                meal = JOptionPane.showInputDialog
                ("Enter the meal of the event you are " +
                 "looking for:");
                mealOption = meal.toUpperCase().charAt(0);
                ++i;
            }while(mealOption != 'B' && mealOption != 'L' 
                  && mealOption != 'D');

            if(categoryOption == 'c' || 
               categoryOption == 'C'){
                if(records.getCarbs
                    (mealOption, date) == 0){
                    message =  "Sorry, there is no data " +
                               "for your " + meal + " on "+
                               date;}
                else{
                    message = "Your carb count for your " +
                              meal + " on " + date + 
                              " was " +
                              records.getCarbs
                              (mealOption, date);} }
            else if(categoryOption == 'i' || 
                    categoryOption == 'I'){
                if(records.getInsulin
                    (mealOption, date) == 0){
                    message = "Sorry, there is no data " +
                              "for your " + meal + " on " +
                              date;}
                else{
                    message = "You injected " + 
                              records.getInsulin
                              (mealOption, date) + 
                              " units of insulin for " + 
                              "your " + meal + " on " + 
                              date;} }
            else{
                if(records.getBS(mealOption, date) == 0){
                    message = "Sorry, there is no data " +
                              "for your " + meal + " on " +
                              date;}
                else{
                    message = "Your blood sugar was " + 
                              records.getBS
                              (mealOption, date) + 
                              " before your " + meal + 
                              " on " + date;} } 
            JOptionPane.showMessageDialog(null, message);}
    }

    // method that rounds off doubles to the nearest int
    public static int rounder(double dHolder){
        int intHolder = (int)(dHolder + 0.5);
        return intHolder;
    }

    /* method to apply a char representing the meal, 
       given the hour. 'B' 'L', 'D' are options */
    public static char getMeal(int hour){
        char charHolder;

        if(hour > 3 && hour < 11){
            charHolder = 'B';}
        else if(hour > 11 && hour < 15){
            charHolder = 'L';}
         else{  
            charHolder = 'D';}
 
         return charHolder; 
    }
}

        
