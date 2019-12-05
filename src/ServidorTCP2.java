import java.net.*;
import java.io.*;

public class ServidorTCP2 {
	
	public static void main (String[] args) throws Exception {
		
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
		
		System.out.println("Esperant connexi�... ");
		Socket clientConnectat = servidor.accept();
		System.out.println("Client connectat... ");
		
		//FLUX DE SORTIDA AL CLIENT
		PrintWriter fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);
		
		
		//FLUX D'ENTRADA DEL CLIENT
		BufferedReader fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));
		
		while ((cadena = fentrada.readLine()) != null) {
			
			fsortida.println(cadena);
			System.out.println("Rebent: "+cadena);
			if (cadena.equals("*")) break;
			
		}
		
		//TANCAR STREAMS I SOCKETS
		System.out.println("Tancant connexi�... ");
		fentrada.close();
		fsortida.close();
		clientConnectat.close();
		servidor.close();
		
	}

}