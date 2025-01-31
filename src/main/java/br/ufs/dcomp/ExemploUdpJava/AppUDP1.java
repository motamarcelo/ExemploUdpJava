package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
                System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
                System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getByName("200.17.141.3");
            int destination_port = 9276; 

                System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
                System.out.println("[OK] ]");
            
                System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
                System.out.println("[OK] ]");
                
                byte[] buf = new byte[20];
                DatagramPacket packResponse = new DatagramPacket(buf, buf.length);
                
                System.out.println("Aguardando resposta de mensagem ---------- ");
                socket.receive(packResponse);
                System.out.println("[OK] ]");
                
                byte[] received_data = packResponse.getData();
                String received_msg = new String(received_data);
                InetAddress origin_address = packResponse.getAddress();
                int origin_port = packResponse.getPort();
                
                System.out.println("  Mensagem:             "+received_msg);
                System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
                System.out.println("  Porta de origem:      "+origin_port);

                System.out.println("Resposta Recebida!!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}