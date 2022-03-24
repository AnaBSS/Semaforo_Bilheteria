package controller; 
 
import java.util.concurrent.Semaphore; 
import java.util.Random; 
 
   public class Bilheteria extends Thread { 
     private int pessoa; 
     private Semaphore semaforo; 
     static int qnt_ingressos = 100;  
      
    
   public Bilheteria (int pessoa, Semaphore semaforo) { 
    this.pessoa = pessoa; 
    this.semaforo = semaforo; 
   } 
    
   public void run() { 
    Login(); 
    Processo_compra(); 
    Validacao_ingresso(); 
   } 
    
   private void Login () { 
    int temp_login = new Random().nextInt(2000)+50; 
    try { 
     sleep (temp_login); 
     if (temp_login > 1000) { 
      System.out.println("Tempo esgotado"); 
     } else { 
      System.out.println("Pessoa "+pessoa+" Logou com sucesso"); 
     } 
    } catch (InterruptedException e) { 
     e.printStackTrace(); 
    } 
     
   } 
    
   private void Processo_compra () { 
    int temp_compra = new Random().nextInt(3000)+1000; 
    try { 
     sleep (temp_compra); 
     if (temp_compra > 2500) { 
      System.out.println("Tempo esgotado"); 
     } else { 
      System.out.println("Pessoa "+pessoa+" Comprará agora"); 
     } 
    } catch (InterruptedException e) { 
     e.printStackTrace(); 
    } 
     
   } 
    
   private void Validacao_ingresso () { 
    int ingresso = new Random().nextInt(4)+1; 
    try { 
     if (qnt_ingressos >=4) { 
      qnt_ingressos -= ingresso; 
       
     semaforo.acquire(); 
     System.out.println("A pessoa "+pessoa+" comprou "+ingresso+". Ingressos restantes: "+qnt_ingressos); 
     } else { 
      System.out.println("Ingressos esgotados"); 
     } 
    } catch (InterruptedException e) { 
     e.printStackTrace(); 
    } finally { 
     semaforo.release(); 
    } 
     
   } 
   }
