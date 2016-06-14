package Labirint;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domen
 */
public class Save_Maze {
    public static void save(String dat, Maze ma){
        try(PrintWriter pw = new PrintWriter(new File(dat));){
            pw.println(ma.getWidth() + " " + ma.getHeight());
            pw.println(ma.getStartY() + " " + ma.getStopY());
            for(int i = 0; i < ma.getWidth(); i++){
                for (int j = 0; j < ma.getHeight(); j++) {
                    pw.print(ma.walls[i][j] + " ");
                }
                pw.println();

            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void restore(String dat,Maze ma){
        try(Scanner sc = new Scanner(new File (dat))){
            int width = sc.nextInt();
            int height = sc.nextInt();
            int start = sc.nextInt();
            int stop = sc.nextInt();
            ma.setStartY(start);
            ma.setStopY(stop);
            ma.setWidthHeight(width, height);
            boolean[][] res = new boolean[width][height];
            boolean[] pom = new boolean[width*height];
            int st = 0;
            while(sc.hasNext()){
                String line = sc.next();
                pom[st] = Boolean.valueOf(line);
                st++;
            }
            st = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    res[i][j] = pom[st];
                    st++;
                }
            }
            ma.walls = res;
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
