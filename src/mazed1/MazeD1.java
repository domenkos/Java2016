/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazed1;

/**
 *
 * @author domen
 */
public class MazeD1 {

    /**
     * @param args the command line arguments
     */
    static void tab(int width, int height){
        int[][] ta = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ta[j][i] = j;
            }
        }  
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ta[j][i]);
                
            }
            System.out.println();
            
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        tab(5,2);
    }
    
}
