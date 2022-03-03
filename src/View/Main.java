package View;

import javax.swing.JOptionPane;

import Controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController killCont = new KillController();
		String os = killCont.os();
		System.out.println("Sistema Operacional: " + os);
		System.out.println("");
		String a;
		
		killCont.listaProcessos(os);
		
		do {
			
			a = JOptionPane.showInputDialog("Se você deseja Matar o processo com PID digite: 1  \nCaso você deseje matar um processo com nome digite: 2\nCaso você deseje fechar o programa clique em cancelar");
			
			if (a.contains("1")) {
				killCont.matapid(os);
			}
			
			if (a.contains("2")) {
				killCont.mataNome(os);
			}
			
		}while(a != null);
	}

}
