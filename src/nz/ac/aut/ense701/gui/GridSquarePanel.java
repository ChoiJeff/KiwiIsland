package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
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
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        Color      color;
        ImageIcon imgTerrain, imgOccupant = null;
        switch ( terrain )
        {
            /*
            case SAND      : imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Sand.jpg")) ; break;
            case FOREST    : imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Forrest.png")) ; break;
            case WETLAND :   imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Wetland.JPG")) ;  break;
            case SCRUB :     imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Scrub.JPG")) ; break;
            case WATER    :  imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/Water.jpeg")) ; break;
            default  :       imgTerrain = new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/icons/black.jpg")) ;break;
            */
            
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
            lblText.setText(game.getOccupantStringRepresentation(row,column));
            
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
            
            
            
            if ( squareVisible && !squareExplored ) 
            {
                // When explored the colour is brighter
                /*
                color = new Color(Math.min(255, color.getRed()   + 128), 
                                  Math.min(255, color.getGreen() + 128), 
                                  Math.min(255, color.getBlue()  + 128));
                */
            }
            lblText.setBackground(color);
            //lblText.setIcon(imgTerrain);
            // set border colour according to 
            // whether the player is in the grid square or not
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
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
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 1);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
