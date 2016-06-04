

package dao;

import controle.ImpressoraImpl;
import java.util.List;
import java.util.Scanner;
import modelo.Impressora;

public class Main {

	public static void main(String[] args) {
                ImpressoraImpl impressoraImpl = new ImpressoraImpl();
		
                Scanner in = new Scanner(System.in);
                for (int i = 0; i < 3; i++) {
                    Impressora c = new Impressora();
                    System.out.print("Marca: ");
                    c.setMarca(in.next());
                    
                    System.out.print("Modelo: ");
                    c.setModelo(in.next());
                    
                    System.out.print("Local: ");
                    c.setLocal(in.next());
                    
                    impressoraImpl.salvar(c);
                }
                List<Impressora> list = impressoraImpl.getListAll();
		String msg = ("ID\t"+f("Marca")+"\t"+f("Modelo")+"\t"+f("Local"));
		System.out.println(msg);
		for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		out(list);
		
                System.out.print("Escolha um id para pesquisa: ");
		Impressora a = impressoraImpl.findById(in.nextInt());
		
		System.out.println("\n"+msg);
		for (int i = 0; i < msg.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println(a.getId()+"\t"+f(a.getMarca())+"\t"+a.getModelo()+"\t"+a.getLocal);
	}

	private static String f(String s) {
			for (int i = s.length(); i < 30; i++) {
				s+=" ";
			}
		return s;
	}

	private static void out(List<Impressora> list) {
		for (Impressora impressora : list) {
			System.out.println(impressora.getId()+"\t"+f(impressora.getMarca())+"\t"+impressora.getMarca()+"\t"+impressora.getLocal());
		}
		
	}

}








