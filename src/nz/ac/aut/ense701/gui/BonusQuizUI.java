/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author JeffChoi
 * @since 30/05/2017
 */
public class BonusQuizUI extends JFrame{
    private ArrayList<String> facts;
    private int points;
    private int numKiwi;
    //public static final Container startPage;
    
    public BonusQuizUI(ArrayList<String> facts, int points, int numKiwi){
        this.facts = facts;
        this.points = points;
        this.numKiwi = numKiwi;
        
        // to create 5 question randomly.
        createFiveQuiz();
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Bonus Quiz!");
        //Container page = null;
        //navigateTo(this, page);
        
    }
    
    static void navigateTo(BonusQuizUI quiz, Container page){
        quiz.setContentPane(page);
        quiz.setSize(page.getSize());
    }
    
    public void createFiveQuiz(){
        Collections.shuffle(this.facts);
        for(int i = 0; i < 3; i++){
            if(facts.get(i).equals("Rat")){
                
            }else if(facts.get(i).equals("Cat")){
                
            }else if(facts.get(i).equals("Kiore")){
                
            }else if(facts.get(i).equals("Stoat")){
                
            }else if(facts.get(i).equals("Possum")){
                
            }else if(facts.get(i).equals("Bat")){
                
            }else if(facts.get(i).equals("Cat")){
                
            }else if(facts.get(i).equals("Weta")){
                
            }else if(facts.get(i).equals("Tuatara")){
                
            }else if(facts.get(i).equals("Kakapo")){
                
            }
        }
        for(int j = 0; j < 3; j++){
            if(numKiwi < 3){
                
            }else if(numKiwi < 5){
                
            }else{
                
            }
        }
    }
    
    
}
