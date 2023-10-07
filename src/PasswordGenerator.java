import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGenerator extends JFrame{
    private Logic logic;
    public PasswordGenerator(){
        // render frame and add a title

        super("Password Generator");

        //set the size of the GUI
        setSize(540, 600);

        // prevent Gut form being able to resized
        setResizable(false);

        // we will set the Layout to be null to have control over the position and size of our components in out app
        setLayout(null);

        // terminate the program when the GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //center the GUI to the screen
        setLocationRelativeTo(null);

        //init password generator
        logic = new Logic();

        //render gui components
        addGuiComponents();
    }

    private void addGuiComponents(){
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");

        // increase the font size
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0, 10,540, 40);

        //add to Gui
        add(titleLabel);

        //create result text area
        JTextArea passwordOutput = new JTextArea();

        //prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 30));

        // add scrollability in case the output is too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        //create a black border around the text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // create password length label
        JLabel passwordLengthLabel = new JLabel("Password Length :");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        // create password length input
        JTextArea passwordLengthInput = new JTextArea();
        passwordLengthInput.setFont(new Font("Dialog", Font.PLAIN, 30));
        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInput.setBounds(310, 215, 192, 39);
        add(passwordLengthInput);

        // create toggle buttons
        //upper letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("UpperCase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        uppercaseToggle.setBounds(23, 302, 225, 56);
        add(uppercaseToggle);

        //lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("LowerCase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        //number toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 20));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        //create generate button
        JButton generatorButton = new JButton("Generate");
        generatorButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        generatorButton.setBounds(155, 477, 222, 41);
        generatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validation: generate a password only when length > 0 and one of the toggled button is pressed
                if(passwordLengthInput.getText().length() <= 0) return;
                boolean togglePressed = lowercaseToggle.isSelected() ||
                        uppercaseToggle.isSelected() ||
                        numbersToggle.isSelected() ||
                        symbolsToggle.isSelected();

                int passwordLength = Integer.parseInt(passwordLengthInput.getText());
                if(togglePressed){
                    String generated = logic.generatePass(passwordLength, uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    //display the password
                    passwordOutput.setText(generated);
                }
            }
        });
        add(generatorButton);
    }
}

