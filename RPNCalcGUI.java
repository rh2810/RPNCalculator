package edu.vccs.mla2911.gui.lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This creates a GUI RPN calculator
 * 2/8/2017
 * @author Michele Ambrose
 * @author Ryan Hurst
 */
public class RPNCalcGUI extends JFrame{
    // use the helper to do all the operations of the calculator
    private RPNCalcGUIHelper helper = new RPNCalcGUIHelper();
    private final int ROWS = 4;  //number of rows of keys
    private final int COLS = 5;  // number of columns of keys
    private JTextField display;          // so we can have a display

    public RPNCalcGUI(){
        // Give the window a title.  Windows love titles.
        this.setTitle("RPN Calculator");
        //we need to put things somewhere
        Container contentPane = this.getContentPane();
        // BorderLayout works best for us.
        contentPane.setLayout(new BorderLayout());
        // Make it big enough to use.
        setBounds(400,400, 400, 300);

        // call our method to build the display panel
        JPanel displayPanel = buildDisplayPanel();
        // add it to the window
        this.add(displayPanel, BorderLayout.NORTH);
        // call our method to build the key pad panel
        JPanel keyPadPanel = buildKeyPadPanel();
        //add it to the window
        this.add(keyPadPanel, BorderLayout.CENTER);

        // make sure the program actually stops when we want it to.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // do all this on a different thread so bad things don't happen.  Just in case.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    /**
     * builds the display panel of calculator.  So we can see our numbers.  Numbers are
     * good.
     * @return the display panel
     */
    private JPanel buildDisplayPanel(){
        //need a new panel to start off with
        JPanel displayPanel = new JPanel();
        // make that display a Textfield. make it with 30 columns, because why not?
        display = new JTextField(30);
        // No one can edit it but me!
        display.setEditable(false);
        // add this amazing textField to our panel.
        displayPanel.add(display);
        // and return that panel.
        return displayPanel;
    }

    /**
     * Build the key pad panel, where all the calculator keys will go. Otherwise, what
     * good is a calculator without keys?  Unless it is psychic, which doesn't exits.
     * @return the key pad panel.
     */
    private JPanel buildKeyPadPanel(){
        //need a new panel to start off with
        JPanel keyPadPanel = new JPanel();
        // make it with the gridLayout, because that makes sense with so many buttons
        keyPadPanel.setLayout(new GridLayout(ROWS, COLS));
        // an array of buttons.  Because a calculator needs buttons
        JButton[] keys = new JButton[ROWS * COLS];
        // an array of names for our buttons.  Buttons love names
        String[] keyNames = {"7", "8", "9", "pi", "/", "4", "5", "6",
                "", "*", "1", "2", "3", "<", "-", "0", ".", "+/-", "^", "+"};

        // 1 for loop to create each button, and add an action listeners to each.
        for (int i = 0; i < (ROWS* COLS); i++){

            // create a button
            keys[i] = new JButton(keyNames[i]);
            /* need a another int so that we can use it in our action listener, because
            IntelliJ says so.*/
            int finalI = i;
            //get an action listener for each button.  Have IntelliJ write it.
            keys[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //call add key from RPNCalcGUIHelper for what each action is
                        display.setText(helper.addKey(keyNames[finalI]));
                }
            });
            //add the keys to the panel
            keyPadPanel.add(keys[i]);
        }
        // give back our awesome keyPad!
        return keyPadPanel;
    }

    /**
     * main to run the calculator
     * @param args not used
     */
    public static void main(String[] args) {
        // just starts a new RPNCalcGUI object
        new RPNCalcGUI();
    }



}
