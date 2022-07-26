package TicTacToe;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    JButton replay;

    TicTacToe(){

        

        textfield.setBackground(new Color(40,40,40));
        textfield.setForeground(new Color(239,235,216));       
        textfield.setFont(new Font("Open Sans", Font.CENTER_BASELINE,40));
        //textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setBounds(325,30,355,70);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
       
        title_panel.setLayout(null);
        title_panel.setBackground(new Color(40,40,40));
        title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBounds(0,100,800,800);
        button_panel.setBackground(new Color(28,28,28));

         for(int i=0; i<9 ; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(Color.DARK_GRAY);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Open Sans", Font.CENTER_BASELINE,120));
            buttons[i].addActionListener(this);
        }
       
        replay = new JButton();
        replay.setText("REPLAY");
        //replay.setSize(80, 50);
        replay.addActionListener(this);
        replay.setBackground(Color.CYAN);
        replay.setBounds(15, 30, 170, 50);
        replay.setFocusable(false);
        title_panel.add(replay);
        
        frame.add(button_panel,BorderLayout.SOUTH);
        frame.add(title_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 950);
        frame.getContentPane().setBackground(new Color(18,18,18));
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == replay){
            replay();
        }


        for(int i=0; i<9;i++){

            if(e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == "" ){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText(" O turn ");
                        check();
                    }
                } else{
                    if(!player1_turn){
                        if(buttons[i].getText() == "" ){
                            buttons[i].setForeground(Color.red);
                            buttons[i].setText("O");
                            player1_turn = true;
                            textfield.setText(" X turn ");
                            check();
                        }

                    }

                }
            }
        }
    }

    public void firstTurn(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
        if(random.nextInt(2) == 0)
        {
            player1_turn = true;
            textfield.setText("X turn");
        } else
        {
            player1_turn = true;
            textfield.setText("O turn");
        }

    }

    public void check(){

        //check X win

        if((buttons[0].getText()=="X") && 
        (buttons[1].getText()=="X") &&
        (buttons[2].getText()=="X")){
            xWins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") && 
        (buttons[4].getText()=="X") &&
        (buttons[5].getText()=="X")){
            xWins(3,4 , 5);
        }
        if((buttons[6].getText()=="X") && 
        (buttons[7].getText()=="X") &&
        (buttons[8].getText()=="X")){
            xWins(6, 7, 8);
        }
        if((buttons[0].getText()=="X") && 
        (buttons[3].getText()=="X") &&
        (buttons[6].getText()=="X")){
            xWins(0, 3, 6);
        }
        if((buttons[1].getText()=="X") && 
        (buttons[4].getText()=="X") &&
        (buttons[7].getText()=="X")){
            xWins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") && 
        (buttons[5].getText()=="X") &&
        (buttons[8].getText()=="X")){
            xWins(2, 5, 8);
        }
        if((buttons[0].getText()=="X") && 
        (buttons[4].getText()=="X") &&
        (buttons[8].getText()=="X")){
            xWins(0, 4, 8);
        }
        if((buttons[2].getText()=="X") && 
        (buttons[4].getText()=="X") &&
        (buttons[6].getText()=="X")){
            xWins(2, 4, 6);
        }

        //check O win

        if((buttons[0].getText()=="O") && 
        (buttons[1].getText()=="O") &&
        (buttons[2].getText()=="O")){
            oWins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") && 
        (buttons[4].getText()=="O") &&
        (buttons[5].getText()=="O")){
            oWins(3,4 , 5);
        }
        if((buttons[6].getText()=="O") && 
        (buttons[7].getText()=="O") &&
        (buttons[8].getText()=="O")){
            oWins(6, 7, 8);
        }
        if((buttons[0].getText()=="O") && 
        (buttons[3].getText()=="O") &&
        (buttons[6].getText()=="O")){
            oWins(0, 3, 6);
        }
        if((buttons[1].getText()=="O") && 
        (buttons[4].getText()=="O") &&
        (buttons[7].getText()=="O")){
            oWins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") && 
        (buttons[5].getText()=="O") &&
        (buttons[8].getText()=="O")){
            oWins(2, 5, 8);
        }
        if((buttons[0].getText()=="O") && 
        (buttons[4].getText()=="O") &&
        (buttons[8].getText()=="O")){
            oWins(0, 4, 8);
        }
        if((buttons[2].getText()=="O") && 
        (buttons[4].getText()=="O") &&
        (buttons[6].getText()=="O")){
            oWins(2, 4, 6);
        }



    }

    public void xWins(int a, int b, int c){

        textfield.setText("X wins");
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0; i<9 ; i++){
            buttons[i].setEnabled(false);
        }

    }
    
    public void oWins(int a, int b, int c){

        textfield.setText("O wins");
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for(int i=0; i<9 ; i++){
            buttons[i].setEnabled(false);
        }

    }

    public void replay(){

        frame.dispose();
        new TicTacToe();
        
        
    }





    
}
