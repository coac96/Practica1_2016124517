/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612517;
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
    private String elec;
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
        crearTablero();
        eleccion();

    }
    public void experto(){
        mod = 8;
        crearTablero();
        eleccion();
    }
    
    public void voltear(){
        do{
        System.out.println("Ingresar fila,columna Ej(1,1)");
         vol = lec.next();
         
        if(Character.getNumericValue(vol.charAt(0)) > 0 && Character.getNumericValue(vol.charAt(0)) <= (mod) && 
            Character.getNumericValue(vol.charAt(2)) > 0 && Character.getNumericValue(vol.charAt(2)) <= (mod)){

            System.out.println("Presione  Y  para aceptar los datos y  N  para repetir");
            yn = lec.next().toLowerCase();
            if(yn.equals("y")){
               if(solucion[(Character.getNumericValue(vol.charAt(0))-1)][(Character.getNumericValue(vol.charAt(2))-1)].equals("*")){
                    System.out.println("PERDISTE");
                    System.out.println("-----------------------");
                        mostrarSol();
                    System.out.println("------------------------");

                }else{
                    if(tablero[(Character.getNumericValue(vol.charAt(0))-1)][(Character.getNumericValue(vol.charAt(2))-1)] != "x"){
                    System.out.println("Casilla ya seleccionada");
                    }else{
                        
                        scanner(Character.getNumericValue(vol.charAt(0))-1,Character.getNumericValue(vol.charAt(2))-1);
                        mostrar();
                        eleccion();
                        
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
       switch(mod){
           case 4:
               principiante();
           break;
           case 6:
               intermedio();
               
           break;
               
           case 8:
               experto();
           break;
           
           default:
                   
       }
    }
    public void mostrar(){
        switch(mod){
            case 4:
                for(int fila = 0; fila<4; fila++){
                    for(int columna = 0; columna<4; columna++){
                        System.out.print(" | "+ tablero[fila][columna] +" | ");
                        if(columna == 3){
                            System.out.println("");
                        }
                    }
                }        
                break;
            case 6:
                for(int fila = 0; fila<6; fila++){
                    for(int columna = 0; columna<6; columna++){
                        System.out.print(" | "+ tablero[fila][columna] +" | ");
                        if(columna == 5){
                            System.out.println("");
                        }
                    }
                }     
                break;

            case 8:
                
                break;
                
            default:
                
        }
       
    }
    
    public void mostrarSol(){
        switch(mod){
            case 4:
               for(int fila = 0; fila<4; fila++){
                    for(int columna = 0; columna<4; columna++){
                        System.out.print(" | "+ solucion[fila][columna] +" | ");
                        if(columna == 3){
                            System.out.println("");
                        }
                    }
                }
            
                break;
            case 6:
                break;
            case 8:
                break;
                
                
                default:
                    
                    
            
        }
    }
    public void crearTablero(){
        //INSERTAR MINAS
        switch(mod){
            case 4:
            tablero = new String[mod][mod];
            solucion = new String[mod][mod];
            for(int fila = 0; fila < 4; fila++){
                for(int columna = 0; columna < 4; columna++){
                    tablero[fila][columna] = "x";
                    solucion[fila][columna] = "x";
                }
            }
                scanner = 12;
                System.out.println("--------- SOLUCION ------------------");
                cont = 0;
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
                System.out.println("----------------------");
                break;

            case 6:
                tablero = new String[mod][mod];
                solucion = new String[mod][mod];
                for(int fila = 0; fila < 6; fila++){
                    for(int columna = 0; columna < 6; columna++){
                        tablero[fila][columna] = "x";
                        solucion[fila][columna] = "x";
                    }
                }
                scanner = 28;
                System.out.println("--------- SOLUCION ------------------");
                cont=0;
                while (cont != 8) {
                    aleC = (int)(Math.random()*5+1);
                    aleF = (int)(Math.random()*5+1);
                    if(solucion[aleC][aleF].equals("x")){
                        solucion[aleC][aleF] = "*";
                        cont++;
                    }
                    
                }
                for(int fila = 0; fila<6; fila++){
                    for(int columna = 0; columna<6; columna++){
                        System.out.print(" | "+ solucion[fila][columna] +" | ");
                        if(columna == 5){
                            System.out.println("");
                        }
                    }
                }
                System.out.println("----------------------");
                break;
                
            case 8:
                 tablero = new String[mod][mod];
            solucion = new String[mod][mod];
            for(int fila = 0; fila < 8; fila++){
                for(int columna = 0; columna < 8; columna++){
                    tablero[fila][columna] = "x";
                    solucion[fila][columna] = "x";
                }
            }
                scanner = 52;
                System.out.println("--------- SOLUCION ------------------");
                cont =0;
                while (cont != 12) {
                    aleC = (int)(Math.random()*6+1);
                    aleF = (int)(Math.random()*6+1);
                    if(solucion[aleC][aleF].equals("x")){
                        solucion[aleC][aleF] = "*";
                        cont++;
                    }
                    
                }
                for(int fila = 0; fila<8; fila++){
                    for(int columna = 0; columna<8; columna++){
                        System.out.print(" | "+ solucion[fila][columna] +" | ");
                        if(columna == 7){
                            System.out.println("");
                        }
                    }
                }
                System.out.println("----------------------");
                break;
        }
        
        
    }
    public void eleccion(){
        if(scanner > 0){
        do{
            System.out.println("V.   Voltear");
            System.out.println("R.   Reiniciar");
            System.out.println("S.   Salir");
            System.out.println("Ingresar Opcion: ");    
        try {
            elec = lec.next();
        switch(String.valueOf(elec).toLowerCase()){
            case "v":
                voltear();
            break;
                
            case "r":
                reiniciar();
            break;
                
            case "s":
                System.out.println("SALIENDO");
            break;
            
            default:
                System.out.println("ERROR DE ELECCION");
            break;
            
        }
        }catch (java.util.InputMismatchException e) {
         
        }
            System.out.println("---------------");
        }while(elec == "s");
    
        }else{
            System.out.println("GANASTE, FELICIDADES");
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
        scanner--;
        System.out.println(scanner);

    }
}
