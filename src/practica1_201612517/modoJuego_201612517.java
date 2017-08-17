/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612517;

/**
 *
 * @author Coac_96
 */
public class modoJuego_201612517 {
    private int[][] tablero;

    public modoJuego_201612517() {
    }
    
    public void principiante(){
        tablero = new int[4][4];
        for(int fila = 0; fila<4; fila++){
            for(int columna = 0; columna<4; columna++){
                System.out.print(" | "+ tablero[fila][columna] +" | ");
                if(columna == 3){
                    System.out.println("");
                }
            }
        }
        
    }
    
    public void intermedio(){
        tablero = new int[6][6];
    }
    public void experto(){
        tablero = new int[8][8];
    }
}
