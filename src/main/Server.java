package main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import domain.LerCsv;
import domain.Pojo;

public class Server extends Thread{
	
	private static ServerSocket server;
	private Socket socket;
	private InputStream in;
	private InputStreamReader inr;
	private BufferedReader bfr;
	
	private static ArrayList<Pojo> pojos;

	public Server(Socket con) {
		this.socket = con;
		try {
			in = con.getInputStream();
			inr = new InputStreamReader(in);
			bfr = new BufferedReader(inr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
//		ArrayList<Pojo> pojos = LerCsv.lerCSV("C:\\Users\\Jefferson\\Downloads\\dados.csv", ",", true);
		
//		System.out.println("Haha"+pojos.get(27954).toString());
		
//		for(Pojo pojo : pojos) {
//			System.out.println("Oi: "+pojo.getSituacao());
//		}
		
		pojos = LerCsv.lerCSV("C:\\Users\\Jefferson\\Downloads\\dados.csv", ",", true);
		
		try {

			server = new ServerSocket(9874);
			System.out.println("Servidor ativo ");

			while (true) {
				System.out.println("Aguardando conexão...");
				Socket con = server.accept();
				
				System.out.println("Cliente conectado...");
				Thread t = new Server(con);
				t.start();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {

			String sexo,status;

			OutputStream out = this.socket.getOutputStream();// enviar dados para o cliente (writer)
			Writer ouw = new OutputStreamWriter(out);
			BufferedWriter bfw = new BufferedWriter(ouw);

			while(((sexo = bfr.readLine()) == null) || ((status = bfr.readLine()) == null)) {				
			}
			
//			while((status = bfr.readLine()) == null){
//				System.out.println("Entrou no while");
//			}
			
			Integer resposta =0;
			
			for(Pojo pojo : pojos) {
				if((pojo.getSexo().equals(sexo))&&(pojo.getSituacao().equalsIgnoreCase(status))) { 
					resposta++;
				}
			}
			
//			if(msg.equalsIgnoreCase("7as75fj345k")) {
//				resposta = "sim";
//			}else {
//				resposta = "nao";
//			}
			
			Thread.currentThread().sleep(1000);
			
			//resposta = msg.equalsIgnoreCase("7as75fj345k") ? "sim" : "nao";

			//servidor envia resposta para o cliente
			bfw.write(resposta.toString() + System.lineSeparator());
			bfw.flush();
			
			
			//espera o cliente fechar a conexao ou pode colocar um timeout
			//while(this.socket.isConnected()) {
				// recomendado esperar o cliente encerrar a conexao para nao fechar o fluxo de dados
			//}
			
			bfw.close();
			ouw.close();
			out.close();
			this.socket.close();
			
		} catch (

		Exception e) {
			e.printStackTrace();

		}

	}

}
