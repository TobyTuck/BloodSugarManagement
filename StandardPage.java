/* This is a class that will provide a page serves as the 
standard page- and provides a number of JTextFields to
enter values, and two buttons to log in or create an 
account */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  // ActionListener, ActionEvent
import java.io.*; // File, IOException

public class StandardPage extends JFrame 
                          implements ActionListener{
    
    private JTextField bloodSugar;
    private JTextField isf;
    private JTextField numCarbs;
    private JTextField carbRatio;
    private JButton calculate;
    private JButton logIn;
    private JButton signUp;
    private int _bS;
    private int _carbs;
    private int _insulin;

    public StandardPage(){
        // set the default fields
        _bS = 0;
        _carbs = 0;
        _insulin = 0;

        // set the JFrame
        this.setDefaultCloseOperation
            (JFrame.EXIT_ON_CLOSE);
        this.setSize(1366, 768);
        this.setBackground(Color.blue);
        this.setLayout(new BorderLayout());

        // make instance of the "GridBagConstraints"
        GridBagConstraints gbc = new GridBagConstraints();

        // make a background panel
        JPanel background = new JPanel();
        background.setLayout(new GridBagLayout());
        background.setPreferredSize(this.getSize());
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
        
        logIn = new JButton("LogIn");
        logIn.setBackground(Color.black);
        logIn.setForeground(Color.white);
        logIn.setFont(myFont);
        logIn.addActionListener(this);

        signUp = new JButton("SignUp");
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.setFont(myFont);
        signUp.addActionListener(this);

        loginPanel.add(logIn);
        loginPanel.add(signUp);

        // test
        JPanel test = new JPanel();
        test.setBackground(Color.blue);
        test.setPreferredSize(new Dimension(200, 120));

        // test 2
        JPanel test2 = new JPanel();
        test2.setBackground(Color.blue);
        test2.setPreferredSize(new Dimension(200, 120));

        GridBagConstraints gbt = new GridBagConstraints();

        // JLabel for top of panel
        JLabel tester1 = new JLabel("MYTESTERYOUMAYNONAY" +
                                    "ROOE");
        tester1.setForeground(Color.blue);
        tester1.setFont(myFont);

        JLabel tester2 = new JLabel("MyT1D");
        tester2.setForeground(Color.black);
        tester2.setFont(logoFont);

        JLabel tester3 = new JLabel("NAYEVERNOM");
        tester3.setForeground(Color.blue);
        tester3.setFont(myFont);

        JPanel test3 = new JPanel(new FlowLayout());
        test3.setPreferredSize(new Dimension(250, 122));
        test3.setBackground(Color.blue);

        test3.add(tester1);
        test3.add(tester2);
        test3.add(tester3);
        test3.add(loginPanel, gbt);

        this.add(background, BorderLayout.CENTER);
        this.add(test, BorderLayout.EAST);
        this.add(test2, BorderLayout.WEST);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(test3, BorderLayout.NORTH);
        this.setVisible(true);
    }

    @ Override
    public void actionPerformed(ActionEvent press){
        // direct user to login page
        if(press.getSource() == logIn){
            LoginPage login = new LoginPage(this, _bS, 
                              _carbs, _insulin);}
        
        // direct user to signup page
        else if(press.getSource() == signUp){
            SignupPage signup = new SignupPage(this, _bS,
                                _carbs, _insulin);}
        
        // calculate and return user's insulin amount
        else{
            CalculateCarbs carbCount = 
                new CalculateCarbs();
            CalculateBS bloodC12H22011 = new CalculateBS();
            int iSF,
                cR;
 
            _bS = Integer.parseInt(bloodSugar.getText());
            iSF = Integer.parseInt(isf.getText());
            _carbs = Integer.parseInt(numCarbs.getText());
            cR = Integer.parseInt(carbRatio.getText()); 
            
            // calculate insulin
            _insulin = rounder(carbCount.calculateInsulin
                      (cR, _carbs) +  bloodC12H22011.
                      calculateInsulin(iSF, _bS));
 
            // display calculations
            JOptionPane.showMessageDialog(null, "Inject " +
                                          _insulin + 
                                          " units of " +
                                          "insulin");}
    }        

    // "helper" that rounds off to nearest int
    public static int rounder(double dHolder){
        int intHolder = (int)(dHolder + 0.5);
        return intHolder;} 
}
        
