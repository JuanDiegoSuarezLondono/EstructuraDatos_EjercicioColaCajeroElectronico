/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciocolacajeroelectronico;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author suare
 */
public class EjercicioColaCajeroElectronico {

    public static void main(String[] args) {
        
        Queue<Object> cola=new LinkedList<>();
        int salida = -1;
        int serv;
        String[] servicios=new String[]{"Odontologia","Medicina general","Fisioterapia"};
        int clientesAtendidos = 0;
        int seFueron = 0;
        int ocupado = -1;
        int dO = 0;
        int dM = 0;
        int dF = 0;
        int promedio = 0;
        for(int minuto = 0;minuto<480;minuto++) {
            if (minuto%4 == 0) {
                serv=(int) (Math.random() *3) + 1;
                
                if(serv == 1 && cola.size()<4) {
                    cola.offer(4);
                    if (ocupado == -1) {
                        salida = 4+minuto;
                        ocupado = 1;
                    }
                }
                
                else if(serv == 2 && cola.size()<4) {
                    cola.offer(5);
                    if (ocupado == -1) {
                        salida = 5+minuto;
                        ocupado = 1;
                    }
                }   
                
                else if(serv == 3 && cola.size()<4) {
                    cola.offer(3);
                    if (ocupado == -1) {
                        salida = 3+minuto;
                        ocupado = 1;
                    }
                }
                else
                    seFueron++; 
            }
            if(salida == minuto) {
                    ocupado = 0;
                    if ((int)cola.peek() == 4) {
                        dO++;
                        promedio+=4;
                    }
                    if ((int)cola.peek() == 5) {
                        dM++;
                        promedio+=5;
                    }
                    if ((int)cola.peek() == 3) {
                        dF++;
                        promedio+=3;
                    }
                    if (cola.isEmpty()!=true) {
                        cola.poll();
                    }
                    if (cola.isEmpty()!=true) {                        
                        salida = (int) cola.peek()+minuto;
                    }
                    else  {
                        ocupado = -1;
                    }
                    
                }            
        }
        promedio/=(dO+dF+dM);
        System.out.println("Clientes atendidos en Odontologia : "+dO);
        System.out.println("Clientes atendidos en Medicina general : "+dM);
        System.out.println("Clientes atendidos en Fisioterapia : "+dF);
        System.out.println("Cantidad de usuarios sin cita: "+seFueron);
        System.out.println("Tiempo promedio esperando cita: "+promedio);
    }
    
}
