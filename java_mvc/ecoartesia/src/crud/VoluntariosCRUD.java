package crud;

import java.util.List;
import java.util.Scanner;
import dao.VoluntariosDAO;
import model.Voluntarios;

public class VoluntariosCRUD {

		public static void main(String[] args) {
	        try (Scanner s = new Scanner(System.in)) {
	            VoluntariosDAO voluntariosDAO = new VoluntariosDAO();
	            int opcao = 0;
	
	            String nome = "", email = "", disponibilidade = "", interesses = "";
	
	            do {
	                System.out.println("\n============================== VOLUNTÁRIOS =================================\n");
	                System.out.println("1 - CRIAR 2 - CONSULTAR 3 - ATUALIZAR 4 - DELETAR 5 - CONSULTAR POR ID 0 - SAIR");
	                opcao = s.nextInt();
	                s.nextLine();
	
	            switch (opcao) {
	                case 1:
	                    System.out.print("Digite o nome: ");
	                    nome = s.nextLine();
	                    
	                    System.out.print("Digite o email: ");
	                    email = s.nextLine();
	                    
	                    System.out.print("Digite a disponibilidade: ");
	                    disponibilidade = s.nextLine();
	                    
	                    System.out.print("Digite os interesses: ");
	                    interesses = s.nextLine();
	
	                    Voluntarios voluntario1 = new Voluntarios(nome, email, disponibilidade, interesses);
	                    voluntariosDAO.create(voluntario1);
	                    break;
	
	                case 2:
	                    List<Voluntarios> voluntariosList = voluntariosDAO.read();
	                    for (Voluntarios u : voluntariosList) {
	                        System.out.println(u.toString());
	                    }
	                    break;
	
	                case 3:
	                    System.out.print("Digite o nome: ");
	                    nome = s.nextLine();
	                    
	                    System.out.print("Digite o email: ");
	                    email = s.nextLine();
	                    
	                    System.out.print("Digite a disponibilidade: ");
	                    disponibilidade = s.nextLine();
	                    
	                    System.out.print("Digite os interesses: ");
	                    interesses = s.nextLine();
	                    
	    				System.out.println("Digite seu id:");
	    				int id = s.nextInt();
	    				s.nextLine();
	
	                    Voluntarios voluntario2 = new Voluntarios(id, nome, email, disponibilidade, interesses);
	                    voluntariosDAO.update(voluntario2);
	                    break;
	
	                case 4:
	                    System.out.print("Digite um ID: ");
	                    id = s.nextInt();
	                    s.nextLine();
	                    voluntariosDAO.delete(id);
	                    break;
	
	                case 5:
	                    System.out.print("Digite um ID: ");
	                    id = s.nextInt();
	                    s.nextLine();
	
	                    Voluntarios voluntario3 = voluntariosDAO.readByID(id);
	                    System.out.println(voluntario3.toString());
	                    break;
	
	                default:
	                    break;
	            }
	
	        } while (opcao != 0);
	        
	    	System.out.println("Até mais!");
	    } catch (Exception e) {
	            e.printStackTrace();
    	}
	}
}