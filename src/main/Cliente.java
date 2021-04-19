package main;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private BufferedWriter bfw;
	//private List<String> mensagem;

	public static void main(String[] args) {

		Cliente clienteTh = new Cliente();
		Scanner mensagem = new Scanner(System.in);
		
		clienteTh.conectar();
		
		System.out.print("Informe: 1 - Feminino ou 2 - Masculino - ");
		mensagem.hasNext();
		
		System.out.print("Informe o status:\nformado, evadido, cursando ou trancado - ");
		mensagem.hasNext();

		//System.out.print("sexo: "+ mensagem.nextLine() + "\nStatus: "+ mensagem.nextLine());
		
		clienteTh.enviarMensagem(mensagem.nextLine(),mensagem.nextLine());
		
		clienteTh.receberResposta();
		
		clienteTh.sair();

	}
	

	public void conectar()  {

		try {
			socket = new Socket("localhost", 9874);
			ou = socket.getOutputStream();
			ouw = new OutputStreamWriter(ou);
			bfw = new BufferedWriter(ouw);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void enviarMensagem(String sexo, String status)  {

		try {
			//escrever dados no servidor
			bfw.write(sexo + System.lineSeparator() + status + System.lineSeparator());
			bfw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n Mensagem enviada");

	}

	public void receberResposta()  {

		InputStream in;
		try {
			in = socket.getInputStream();
			
			InputStreamReader inr = new InputStreamReader(in);
			//objeto para leitura e escreve os dados no cliente
			BufferedReader bfr = new BufferedReader(inr);
			String msg = "";
		
			while (!"Sair".equalsIgnoreCase(msg)) {

				if (bfr.ready()) {

					msg = bfr.readLine();
					
					System.out.println(msg);
					msg = "Sair";
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sair()  {

		try {
			bfw.close();
			ouw.close();
			ou.close();
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
