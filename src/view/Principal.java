package view; 
 
import java.util.concurrent.Semaphore; 
import controller.Bilheteria; 
 
public class Principal { 
 
 public static void main(String[] args) { 
    int pessoas = 300; 
    Semaphore semaforo = new Semaphore (1); 
     
    for(int i = 0 ; i < pessoas ; i++) { 
     new Bilheteria (i, semaforo).start(); 
    } 
 
 } 
 
}