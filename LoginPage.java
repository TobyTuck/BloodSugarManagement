import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*; // ActionListener, ActionEvent
import java.io.*; // needed for File, IOException

public class LoginPage implements ActionListener{

    private JButton button;
    private JTextField usrEntry;
    private JPasswordField pwordEntry;
    private JFrame frame;
    private int _bS;
    private int _carbs;
    private int _insulin;

    public LoginPage(JFrame myFrame, int bS, int carbs, 
                     int insulin){
        // set fields
        _bS = bS;
        _carbs = carbs;
        _insulin = insulin;
        frame = myFrame;

        // clear frame of old contents
        frame.getContentPane().removeAll();
        JPanel myPanel = new JPanel();
        myPanel.setBackground(Color.blue);
        myPanel.setLayout(new BorderLayout());

        // make background panel
        JPanel background = new JPanel
            (new GridBagLayout());
        background.setPreferredSize(frame.getSize());
        background.setBackground(Color.blue);

        // make panel to hold contents
        JPanel panel = new JPanel(); 
        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(700, 200));
        panel.setLayout(new GridLayout(2, 2, 0, 20));

        // make blue panel to help fill space 
        JPanel filler = new JPanel();
        filler.setBackground(Color.blue);
        filler.setPreferredSize(new Dimension(400, 200));
        filler.setLayout(new FlowLayout());

        // make a second panel to fill space
        JPanel filler2 = new JPanel();
        filler2.setBackground(Color.blue);
        filler2.setPreferredSize(new Dimension(400, 200));
        // make fonts
        Font myFontPlain = 
            new Font("Times New Roman", Font.PLAIN, 35);
        Font myFontBold =
            new Font("Times New Roman", Font.BOLD, 35);
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
            System.out.println("Problem w/ custom font");
            logoFont = myFontPlain;}

        GridBagConstraints gbc = new GridBagConstraints();

        // add 'Login Page' Label
        JLabel loginLabel = new JLabel
            ("MyTypeOneDiabetes");
        loginLabel.setForeground(Color.black);
        loginLabel.setFont(logoFont);
        filler2.add(loginLabel);

        // add 'user' tag to the panel
        JLabel usrLabel = new JLabel("UserName:");
        usrLabel.setForeground(Color.black);
        usrLabel.setFont(myFontBold);
        panel.add(usrLabel);
               
        // add space for user to enter his username
        usrEntry = new JTextField(20);
        usrEntry.setForeground(Color.white);
        usrEntry.setBackground(Color.black);
        usrEntry.setFont(myFontPlain);
        panel.add(usrEntry);

        // add 'password' tag to the panel
        JLabel pwordLabel = new JLabel("Password:");
        pwordLabel.setForeground(Color.black);
        pwordLabel.setFont(myFontBold);
        panel.add(pwordLabel);

        // add space for user to enter his password
        pwordEntry = new JPasswordField(20);
        pwordEntry.setForeground(Color.white);
        pwordEntry.setBackground(Color.black);
        pwordEntry.setFont(myFontPlain);
        panel.add(pwordEntry);

        // add the panel to the background
        background.add(panel);

        // make button for login
        button = new JButton("Continue");
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        button.setFont(myFontPlain);
        button.addActionListener(this);

        // add button to panel
        filler.add(button);
        
        // make the frame
        myPanel.add(background, BorderLayout.CENTER);
        myPanel.add(filler, BorderLayout.SOUTH);
        myPanel.add(filler2, BorderLayout.NORTH);

        frame.add(myPanel);
        frame.setVisible(true);
    } 

    @ Override
    public void actionPerformed(ActionEvent press){
        if(press.getSource() == button){
            String usrName,
                   password;
            // get user input
            usrName = usrEntry.getText() + ".txt";
            password = pwordEntry.getText();
            FileMaker account = new FileMaker();
            if(account.check(usrName, password)){
                Home home = new Home(frame, usrName, _bS,
                            _carbs, _insulin);}
            else{
                JOptionPane.showMessageDialog(null, 
                "Incorrect UserName, Password " +
                "Combination");} }
    }
}

