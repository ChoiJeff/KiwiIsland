package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Kiwi;
import nz.ac.aut.ense701.gameModel.Occupant;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        neighbour = new ArrayList<GridSquarePanel>();
        initComponents();
        
    }
    
    // the reason to add this method is to access to each panel's location
    public int getRow(){
        return row;
    }
    
    // the reason to add this method is to access to each panel's location
    public int getColumn(){
        return column;
    }
    
    public void addNeighbour(GridSquarePanel panel)
    {
        neighbour.add(panel);
    }    

    /**
     * Author : Jeff Choi
     * @param imgURL 
     * To load the pictuere safely so that jar file works properly.
     */
    private void loadImage(String imgURL){
        try {
            img1 = ImageIO.read(GridSquarePanel.class.getResource(imgURL));
        } catch (IOException ex) {
            Logger.getLogger(GridSquarePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        Color      color;
        ImageIcon imgIcon = null;
        Image img = null;
        URL iconUrl = null;
        //Toolkit toolkit = this.getToolkit();
        
        String imgURL;
        
        
        setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        switch ( terrain )
        {
            case SAND     : color = Color.YELLOW; break;
            case FOREST   : color = Color.GREEN;  break;
            case WETLAND : color = Color.BLUE; break;
            case SCRUB : color = Color.DARK_GRAY;   break;
            case WATER    : color = Color.CYAN;   break;
            default  : color = Color.LIGHT_GRAY; break;              
        }
        
        // test submittion
        if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            String textRepre = game.getOccupantStringRepresentation(row,column);
            lblText.setText("");
            
            // Sand
            if(color.equals(Color.YELLOW)){
                if(textRepre.equals("B")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Bat.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("BC")){    // C stands for count.
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Bat.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                    
                }else if(textRepre.equals("F")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Fauna.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("H")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Hazard.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("E")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Item.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("k")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kakapo.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("kC")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kakapo.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                } else if(textRepre.equals("K")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kiwi.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("KC")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Kiwi.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                } else if(textRepre.equals("P")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Predator.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("T")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Tool.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("t")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Tuatara.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("tC")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Tuatara.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                    
                }else if(textRepre.equals("W")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Weta.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("WC")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with Weta.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
                   
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Bat.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Bat.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Weta.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Weta.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                    setBorder(countBorder);
                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Fauna.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Item.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand with predator and Tool.JPG";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }
                else{
                    
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    /*
                    imgURL = "/nz/ac/aut/ense701/icons/Sand.jpg";
                    loadImage(imgURL);
                    imgIcon = new ImageIcon(img1);
                    */
                }    
            }
            
//            // Forrest
//            if(color.equals(Color.GREEN)){
//                if(textRepre.equals("B")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("BC")){    // C stands for count.
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("F")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("H")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Hazard.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("E")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("k")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("kC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("K")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("KC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("P")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("T")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("t")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("tC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("W")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("WC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Kakapo.jpg";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest with predator and Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }
//                else{
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Forrest.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }    
//            }
//            // Wet Land
//            if(color.equals(Color.BLUE)){
//                if(textRepre.equals("B")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("BC")){    // C stands for count.
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("F")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("H")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Hazard.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("E")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("k")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("kC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("K")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("KC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("P")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("T")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("t")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("tC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("W")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("WC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land with predator and Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }
//                else{
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Wet Land.jpg";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }    
//            }
//            // Scrub
//            if(color.equals(Color.DARK_GRAY)){
//                if(textRepre.equals("B")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("BC")){    // C stands for count.
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("F")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("H")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Hazard.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("E")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("k")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("kC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("K")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("KC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("P")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("T")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("t")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("tC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("W")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("WC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub with predator and Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }
//                else{
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Scrub.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }    
//            }
//            // Water
//            if(color.equals(Color.CYAN)){
//                if(textRepre.equals("B")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("BC")){    // C stands for count.
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("F")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("H")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Hazard.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("E")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("k")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("kC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kiwi and Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("K")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("KC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Kiwi.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                } else if(textRepre.equals("P")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Predator.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("T")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("t")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("tC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("W")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("WC")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Bat.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Kakapo.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Tuatara.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Weta.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                    setBorder(countBorder);
//                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Fauna.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Item.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water with predator and Tool.JPG";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }
//                else{
//                    /*
//                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg");
//                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
//                    imgIcon = new ImageIcon(img);
//                    */
//                    imgURL = "/nz/ac/aut/ense701/icons/Water.jpg";
//                    loadImage(imgURL);
//                    imgIcon = new ImageIcon(img1);
//                }    
//            }
            
            
            // Forrest
            if(color.equals(Color.GREEN)){
                if(textRepre.equals("B")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("BC")){    // C stands for count.
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("F")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("H")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Hazard.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("E")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("k")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("kC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("K")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("KC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("P")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg"));  
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("T")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("t")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("tC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("W")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("WC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    setBorder(countBorder);
                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest with predator and Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }
                else{
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Forrest.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }    
            }
            
            // Wet Land
            if(color.equals(Color.BLUE)){
                if(textRepre.equals("B")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("BC")){    // C stands for count.
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("F")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("H")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Hazard.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("E")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("k")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("kC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("K")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("KC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("P")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg"));  
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("T")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("t")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("tC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("W")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("WC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    setBorder(countBorder);
                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land with predator and Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }
                else{
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Wet Land.jpg");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }    
            }
            
            // Scrub
            if(color.equals(Color.DARK_GRAY)){
                if(textRepre.equals("B")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("BC")){    // C stands for count.
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("F")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("H")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Hazard.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("E")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("k")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("kC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("K")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("KC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("P")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg"));  
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("T")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("t")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("tC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("W")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("WC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    setBorder(countBorder);
                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub with predator and Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }
                else{
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Scrub.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }    
            }
            
            // Water
            if(color.equals(Color.CYAN)){
                if(textRepre.equals("B")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("BC")){    // C stands for count.
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("F")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("H")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Hazard.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Hazard.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("E")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("k")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("kC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("PK") || textRepre.equals("KP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PKC") || textRepre.equals("KCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi and Predator.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kiwi and Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("K")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("KC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Kiwi.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Kiwi.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                } else if(textRepre.equals("P")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Predator.jpg"));  
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Predator.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("T")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("t")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("tC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("W")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("WC")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PB") || textRepre.equals("BP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PBC") || textRepre.equals("BCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Bat.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Bat.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pk") || textRepre.equals("kP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PkC") || textRepre.equals("kCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Kakapo.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Kakapo.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("Pt") || textRepre.equals("tP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PtC") || textRepre.equals("tCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tuatara.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Tuatara.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                    setBorder(countBorder);
                }else if(textRepre.equals("PW") || textRepre.equals("WP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PWC") || textRepre.equals("WCP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Weta.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Weta.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    setBorder(countBorder);
                }else if(textRepre.equals("PF") || textRepre.equals("FP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Fauna.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Fauna.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PE") || textRepre.equals("EP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Item.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Item.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }else if(textRepre.equals("PT") || textRepre.equals("TP")){
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand with predator and Tool.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water with predator and Tool.JPG");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }
                else{
                    //img = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg"));
                    iconUrl = getClass().getResource("/nz/ac/aut/ense701/icons/Water.jpg");
                    img = Toolkit.getDefaultToolkit().getImage(iconUrl);
                    imgIcon = new ImageIcon(img);
                }    
            }
            
            /*
            // change the color of "KC" in order to recognize easily.
            if(lblText.getText().contains("KC")){
                String text = lblText.getText();
                text = text.replaceAll("C", "");               
                text = "<html><body>" + text.replaceAll("K", "<span style=\"color:orange\">K</span>") +"</body></html>";              
                lblText.setText(text);
            }
            else if(lblText.getText().equals("kC"))   {
                String text = lblText.getText();
                text = text.replaceAll("C", "");               
                text = "<html><body>" + text.replaceAll("k", "<span style=\"color:orange\">k</span>") +"</body></html>";              
                lblText.setText(text);
            }
            else if(lblText.getText().equals("BC"))   {
                String text = lblText.getText();
                text = text.replaceAll("C", "");               
                text = "<html><body>" + text.replaceAll("B", "<span style=\"color:orange\">B</span>") +"</body></html>";              
                lblText.setText(text);
            }
            else if(lblText.getText().equals("tC")){
                String text = lblText.getText();
                text = text.replaceAll("C", "");               
                text = "<html><body>" + text.replaceAll("t", "<span style=\"color:orange\">t</span>") +"</body></html>";              
                lblText.setText(text);
            }
            else if(lblText.getText().equals("WC")){
                String text = lblText.getText();
                text = text.replaceAll("C", "");               
                text = "<html><body>" + text.replaceAll("W", "<span style=\"color:orange\">W</span>") +"</body></html>";              
                lblText.setText(text);
            }
            // Set the colour. 
            */
            
            
            if ( squareVisible && !squareExplored ) 
            {
                
                lblText.setText("");
                // When explored the colour is brighter
                /*
                color = new Color(Math.min(255, color.getRed()   + 128), 
                                  Math.min(255, color.getGreen() + 128), 
                                  Math.min(255, color.getBlue()  + 128));
                */
            }
            //lblText.setBackground(color);
            lblText.setIcon(imgIcon);
            //lblText = new JLabel(new ImageIcon(img));
            // set border colour according to 
            // whether the player is in the grid square or not
            //setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
            
        }
        else
        {
            lblText.setText("");
            lblText.setBackground(null);
            lblText.setIcon(null);
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    
    private Game game;
    private int row, column;
    private List<GridSquarePanel> neighbour;
    private BufferedImage img1;     // to load the picture properly in jar file.
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
    private static final Border countBorder = new LineBorder(Color.ORANGE, 3);  // to add new border line.
}
