/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612517;
import java.util.Scanner;

import javax.management.Query;

/**
 *
 * @author Coac_96
 */
public class modoJuego_201612517 {
    private String[][] tablero;
    private int mod = 0;
    private Scanner elec = new Scanner(System.in);

    public modoJuego_201612517() {
    }
    
    public void principiante(){
        mod = 4;
        tablero = new String[4][4];
        for(int fila = 0; fila<4; fila++){
            for(int columna = 0; columna<4; columna++){
                tablero[fila][columna] = "x";
                System.out.print(" | "+ tablero[fila][columna] +" | ");
                if(columna == 3){
                    System.out.println("");
                }
            }
        }
    }
    
    public void intermedio(){
        tablero = new String[6][6];
    }
    public void experto(){
        tablero = new String[8][8];
    }
    
    public void voltear(){
        
    }
}
