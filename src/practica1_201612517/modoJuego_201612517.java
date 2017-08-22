/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612517;
import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author Coac_96
 */
public class modoJuego_201612517 {
    private String[][] tablero;
    private String[][] solucion;
    private int mod = 0;
    private int elec = 0;
    private int cont = 0;
    private int aleF = 0;
    private int aleC = 0;
    private int scanner = 0;
    private int contMinas = 0;
    private String vol;
    private String yn;
    private Scanner lec = new Scanner(System.in);

    public modoJuego_201612517() {
    }
    
    public void principiante(){
        mod = 4;
        crearTablero();
        eleccion();
    }
    
    public void intermedio(){
        mod = 6;
    }
    public void experto(){
        mod = 8;
    }
    
    public void voltear(){
        System.out.println("Ingresar fila,columna Ej(1,1)");
        do{
        vol = lec.next();
        if(Character.getNumericValue(vol.charAt(0)) > 0 && Character.getNumericValue(vol.charAt(0)) <= (mod) && 
            Character.getNumericValue(vol.charAt(2)) > 0 && Character.getNumericValue(vol.charAt(2)) <= (mod)){
            System.out.println("PresioneY para aceptar los datos y N para repetir");
            yn = lec.next().toLowerCase();
            if(yn.equals("y")){
                if(solucion[(Character.getNumericValue(vol.charAt(0))-1)][(Character.getNumericValue(vol.charAt(2))-1)].equals("*")){
                    mostrar();
                    System.out.println("PERDISTE");
                }else{
                    if(scanner > 0){
                        //IZQUIERDA DE SELECCION
                        scanner(Character.getNumericValue(vol.charAt(0))-1,Character.getNumericValue(vol.charAt(2))-1);
                        mostrar();
                        eleccion();
                        scanner--;
                        
                    }else{
                        System.out.println("GANASTE, FELICIDADES!!");
                        
                    }
                }
                break;
            }if(yn.equals("n")){
                mostrar();
                eleccion();
                break;
            }
        }else{
            System.out.println("ERROR");
        }
        }while(Character.getNumericValue(vol.charAt(0)) >=  0 || Character.getNumericValue(vol.charAt(0)) < (mod) ||
                Character.getNumericValue(vol.charAt(2)) >= 0 || Character.getNumericValue(vol.charAt(2)) < (mod));
    }
    
    public void reiniciar(){
        crearTablero();
    }
    public void mostrar(){
        for(int fila = 0; fila<4; fila++){
            for(int columna = 0; columna<4; columna++){
                System.out.print(" | "+ tablero[fila][columna] +" | ");
                if(columna == 3){
                    System.out.println("");
                }
            }
        }        
    }
    public void crearTablero(){
        tablero = new String[mod][mod];
        solucion = new String[mod][mod];
        scanner = mod*mod;
        for(int fila = 0; fila<4; fila++){
            for(int columna = 0; columna<4; columna++){
                tablero[fila][columna] = "x";
                solucion[fila][columna] = "x";
            }
        }
        //INSERTAR MINAS
        switch(mod){
            case 4:
                System.out.println("--------------- SOLUCION ------------------");

                while (cont != 4) {
                    aleC = (int)(Math.random()*3+1);
                    aleF = (int)(Math.random()*3+1);
                    if(solucion[aleC][aleF].equals("x")){
                        solucion[aleC][aleF] = "*";
                        cont++;
                    }
                    
                }
                for(int fila = 0; fila<4; fila++){
                    for(int columna = 0; columna<4; columna++){
                        System.out.print(" | "+ solucion[fila][columna] +" | ");
                        if(columna == 3){
                            System.out.println("");
                        }
                    }
                }
                System.out.println("------------------------------");
                break;

            case 6:
                
                break;
                
            case 8:
                
                break;
        }
        
        
    }
    public void eleccion(){
        System.out.println("---------------");
        System.out.println("1. Voltear");
        System.out.println("2. Reiniciar");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.println("Ingresar Opcion: ");        
        elec = lec.nextInt();
        switch(elec){
            case 1:
                voltear();
            break;
            case 2:
                reiniciar();
            break;
                
            case 3:
  //              m.menu();
            break;
            
            default:
            break;
            
        }
    } 
    
    
    public void scanner(int fila, int colum){
    //------------------ 4X4-----------------------//    
    //EXTREMOS
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b<= 1; b++){
                try {
                     if(solucion[fila+a][colum+b].equals("*")){
                    contMinas++;
                }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
               
            }
        }
        
        tablero[fila][colum]= String.valueOf(contMinas);
        contMinas=0;
        
    }
}
