/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author michel
 */
public class ClientTcp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         try {
         //On se connecte à OC
         Socket sock = new Socket("192.46.239.178", 5725);
         
         //On récupère maintenant la réponse du serveur 
         //dans un flux, comme pour les fichiers...
         BufferedInputStream bis = new BufferedInputStream(sock.getInputStream());
         
          //nous créons donc un flux en écriture
        // BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
        PrintWriter writer = null;
        writer = new PrintWriter(sock.getOutputStream());
          
         String message = "c:<15><45455>";
         
         //bos.write(message.getBytes());
        
        // bos.flush();
        
         writer.println(message);
         writer.flush();
         //Il ne nous reste plus qu'à le lire
         String content = "";
         int stream;
         while((stream = bis.read()) != -1){
            content += (char)stream;
         }
         
        
         
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
    }
    

