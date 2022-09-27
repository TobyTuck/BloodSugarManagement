import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;  // File, IOException

public class SignupPage implements ActionListener{

    private JButton button;
    private JTextField usrEntry;
    private JTextField pwordEntry;
    private JFrame frame;
    private int _bS;
    private int _carbs;
    private int _insulin;

    public SignupPage(JFrame myFrame, int bS, int carbs,
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

        // make a blue "filler" panel
        JPanel filler = new JPanel();
        filler.setBackground(Color.blue);
        filler.setPreferredSize(new Dimension(400, 200));
        filler.setLayout(new FlowLayout());

        // make a top "filler" panel
        JPanel topFiller = new JPanel();
        topFiller.setBackground(Color.blue);
        topFiller.setPreferredSize
            (new Dimension(400, 200));

        GridBagConstraints gbc = new GridBagConstraints();

        // make a font
        Font myFont = 
            new Font("Times New Roman", Font.PLAIN, 35);
        Font myFont2 = 
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
            logoFont = myFont;}    

        // add 'logo' label
        JLabel logo = new JLabel("MyTypeOneDiabetes");
        logo.setForeground(Color.black);
        logo.setFont(logoFont);
        topFiller.add(logo);

        // add 'user' tag to the panel
        JLabel usrLabel = new JLabel("UserName:");
        usrLabel.setFont(myFont2);
        usrLabel.setForeground(Color.black);
        panel.add(usrLabel);
               
        // add space for user to enter his username
        usrEntry = new JTextField();
        usrEntry.setFont(myFont);
        usrEntry.setBackground(Color.black);
        usrEntry.setForeground(Color.white);
        panel.add(usrEntry);
 
        // add 'password' tag to the panel
        JLabel pwordLabel = new JLabel("Password:");
        pwordLabel.setFont(myFont2);
        pwordLabel.setForeground(Color.black);
        panel.add(pwordLabel);

        // add space for user to enter his password
        pwordEntry = new JTextField(20);
        pwordEntry.setFont(myFont);
        pwordEntry.setBackground(Color.black);
        pwordEntry.setForeground(Color.white);
        panel.add(pwordEntry);
 
        // add panel to background
        background.add(panel);

        // make button for login
        button = new JButton("Create");
        button.setFont(myFont);
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        button.addActionListener(this);
        
        // add button 
        filler.add(button);

        myPanel.add(background, BorderLayout.CENTER);
        myPanel.add(filler, BorderLayout.SOUTH);
        myPanel.add(topFiller, BorderLayout.NORTH);

        frame.add(myPanel);
        frame.setVisible(true);
    } 

    @ Override
    public void actionPerformed(ActionEvent press){
        if(press.getSource() == button){
            String userName,
                   password,
                   message;
            FileMaker account = new FileMaker();

            // get user input
            userName = usrEntry.getText() + ".txt";
            password = pwordEntry.getText();
            
            // check if userName already exists
            if(!account.setFileName(userName)){
                JOptionPane.showMessageDialog
                    (null, "User Name already exists!");}
            else{
                account.setFirstLine(password);
                Home home = new Home(frame, userName, _bS,
                            _carbs, _insulin);} } }
}
