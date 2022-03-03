package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {
	
	public String os(){
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String os) {
		String listawindows = "TASKLIST /FO TABLE";
		String listalinux = "ps -ef";
		
		if (os.contains("Windows")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec(listawindows);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if (os.contains("Linux")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec(listalinux);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				while(linha != null) {
					
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		}
		
		
	}
	
	public void matapid(String os) {
		String pidwindows = "TASKKILL /PID ";
		String pidlinux = "kill -9 ";
		
		String pid = JOptionPane.showInputDialog("Digite o PID do Processo que deseja finalizar:");
		
		if (os.contains("Windows")) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(pidwindows);
			buffer.append(pid);
			
			try {
				
				Runtime.getRuntime().exec(buffer.toString());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if (os.contains("Linux")) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(pidlinux);
			buffer.append(pid);
			
			try {
				
				Runtime.getRuntime().exec(buffer.toString());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	public void mataNome(String os) {
		
		String nomewindows = "TASKKILL /IM ";
		String nomelinux = " pkill -f ";
		
		String pid = JOptionPane.showInputDialog("Digite o nome do Processo que deseja finalizar:");
		
		if (os.contains("Windows")) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(nomewindows);
			buffer.append(pid);
			
			try {
				
				Runtime.getRuntime().exec(buffer.toString());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		if (os.contains("Linux")) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append(nomelinux);
			buffer.append(pid);
			
			try {
				
				Runtime.getRuntime().exec(buffer.toString());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
