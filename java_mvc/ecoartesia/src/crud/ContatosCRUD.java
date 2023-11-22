package crud;

import java.util.Scanner;

import dao.ContatosDAO;
import model.Contatos;

public class ContatosCRUD {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ContatosDAO contatosDAO = new ContatosDAO();
            int opcao;

            do {
                exibirMenu();
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcao) {
                    case 1:
                        criarContato(scanner, contatosDAO);
                        break;

                    case 2:
                        consultarContatos(contatosDAO);
                        break;

                    case 3:
                        atualizarContato(scanner, contatosDAO);
                        break;

                    case 4:
                        deletarContato(scanner, contatosDAO);
                        break;

                    case 5:
                        consultarContatoPorID(scanner, contatosDAO);
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            } while (opcao != 0);

            System.out.println("Até mais!");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado:");
            e.printStackTrace();
        }
    }

    private static void exibirMenu() {
        System.out.println("\n============================== CONTATOS =================================\n");
        System.out.println("1 - CRIAR   2 - CONSULTAR   3 - ATUALIZAR   4 - DELETAR   5 - CONSULTAR POR ID  0 - SAIR");
    }

    private static void criarContato(Scanner scanner, ContatosDAO contatosDAO) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        Contatos novoContato = new Contatos(nome, email, telefone, mensagem);
        contatosDAO.create(novoContato);

        System.out.println("Contato criado com sucesso!");
    }

    private static void consultarContatos(ContatosDAO contatosDAO) {
        for (Contatos contato : contatosDAO.read()) {
            System.out.println(contato.toString());
        }
    }

    private static void atualizarContato(Scanner scanner, ContatosDAO contatosDAO) {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a mensagem: ");
        String mensagem = scanner.nextLine();

        Contatos contatoAtualizado = new Contatos(id, nome, email, telefone, mensagem);
        contatosDAO.update(contatoAtualizado);

        System.out.println("Contato atualizado com sucesso!");
    }

    private static void deletarContato(Scanner scanner, ContatosDAO contatosDAO) {
        System.out.print("Digite um ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

        contatosDAO.delete(id);

        System.out.println("Contato deletado com sucesso!");
    }

    private static void consultarContatoPorID(Scanner scanner, ContatosDAO contatosDAO) {
        System.out.print("Digite um ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

        Contatos contato = contatosDAO.readByID(id);

        if (contato != null) {
            System.out.println(contato.toString());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}
