/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201612517;
import java.util.Scanner;
/**
 *
 * @author Coac_96
 */
public class menu_201612517 {
    private int eleccion = 0;
    private modoJuego_201612517 mj =new  modoJuego_201612517();
    private Scanner lector = new Scanner(System.in);
    public menu_201612517() {
    }
    public void menu(){
        
        while(eleccion != 4){
        System.out.println("---------------------------");
        System.out.println("BUSCAMINAS!!!!");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        eleccion = lector.nextInt();
        switch(eleccion){
            case 1:
                mj.principiante();
            break;
            
            case 2:
                mj.intermedio();
            break;
                
            case 3:
                mj.experto();
            break;
                
            case 4:
                System.out.println("ADIOS");
            break;
                
            default:
            break;
            }
               System.out.println("---------------------------");
        }
    }
}
