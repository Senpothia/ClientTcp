/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            System.out.println("Début");
            //On se connecte à OC
            Socket sock = new Socket("192.46.239.178", 5725);
            //Socket sock = new Socket("127.0.0.1", 5725);
            //On récupère maintenant la réponse du serveur 
            //dans un flux, comme pour les fichiers...
           

            //nous créons donc un flux en écriture
            // BufferedOutputStream bos = new BufferedOutputStream(sock.getOutputStream());
            PrintWriter writer = null;
            writer = new PrintWriter(sock.getOutputStream());

            String message = "c:<15><45455>";

            //bos.write(message.getBytes());
            // bos.flush();
            writer.println(message);
            writer.flush();
        
            while(true){
            
            InputStreamReader inr = new InputStreamReader(sock.getInputStream());
            BufferedReader br = new BufferedReader(inr);
            String response = br.readLine();
            System.out.println("Message reçu: " + response);
            System.out.println("Fin");
            }
           

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
