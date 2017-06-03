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
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author JeffChoi
 * @since 30/05/2017
 */
public class BonusQuizUI extends JFrame{
    private static JFrame quiz1;
    private static JFrame quiz2;
    private static JFrame quiz3;
    private static JFrame quiz4;
    private static JFrame quiz5;
    private ArrayList<JFrame> quizList;
    private ArrayList<String> facts;
    private int points;
    //public static final Container startPage;
    
    public BonusQuizUI(ArrayList<String> facts, int points){
        this.facts = facts;
        this.points = points;
        quizList = new ArrayList<JFrame>();
        
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
        Collections.shuffle(this.facts);    // suffle the list of String.
        for(int i = 0; i < 5; i++){
            if(i == 0){
                if(facts.get(i).equals("There are about 68,000 kiwi left in all of New Zealand.")){
                    //quizList.add();
                    //quizOne = ;
                    
                }else if(facts.get(i).equals("We are losing 2% of our unmanaged kiwi every year –that's around 20 per week.")){
                    
                }else if(facts.get(i).equals("Kiwi are mostly nocturnal.")){
                    
                }else if(facts.get(i).equals("Kiwi nest in burrows, hollow logs or under dense vegetation.")){
                    
                }else if(facts.get(i).equals("Kiwi are the only bird to have nostrils at the end of their very long bill. Their nostrils are used to probe in the ground, sniffing out invertebrates to eat, along with some fallen fruit.")){
                    
                }else if(facts.get(i).equals("The egg averages 15% of the female's body weight (compared to 2% for the ostrich).")){
                    
                }else if(facts.get(i).equals("Females are larger than males (up to 3.3 kg and 45 cm).")){
                    
                }else if(facts.get(i).equals("Kiwi are long-lived, and depending on the species live for between 25 and 50 years.")){
                    
                }else if(facts.get(i).equals("Rat")){
                    
                }else if(facts.get(i).equals("Cat")){
                    
                }else if(facts.get(i).equals("Kiore")){
                    
                }else if(facts.get(i).equals("Stoat")){
                    
                }else if(facts.get(i).equals("Possum")){
                    
                }else if(facts.get(i).equals("Bat")){
                    
                }else if(facts.get(i).equals("Weta")){
                    
                }else if(facts.get(i).equals("Tuatara")){
                    
                }else if(facts.get(i).equals("Kakapu")){
                    
                }
            }else if(i == 1){
                
            }else if(i == 2){
                
            }else if(i == 3){
                
            }else{
                
            }
            
        }
        
    }
    
    
}
