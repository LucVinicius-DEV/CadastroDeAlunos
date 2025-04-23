import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ArrayList<Cadastro> alunos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Atualizar notas");
            System.out.println("3 - Listar alunos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno(sc, alunos);
                    break;
                case 2:
                    atualizarNotas(sc, alunos);
                    break;
                case 3:
                    listarAlunos(alunos);
                    break;
                case 0:
                    System.out.println("Encerrando programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    public static void cadastrarAluno(Scanner sc, ArrayList<Cadastro> alunos) {
        System.out.print("Digite o nome do aluno: ");
        String nome = sc.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        if (existeMatricula(alunos, matricula)) {
            System.out.println("Erro: matrícula já existente!");
            return;
        }

        System.out.print("As notas do aluno já estão disponíveis? (s/n): ");
        char resp = sc.next().charAt(0);

        Cadastro novoAluno;
        if (resp == 's') {
            System.out.print("Digite a primeira nota: ");
            double nota1 = sc.nextDouble();
            System.out.print("Digite a segunda nota: ");
            double nota2 = sc.nextDouble();
            novoAluno = new Cadastro(nome, matricula, nota1, nota2);
        } else {
            novoAluno = new Cadastro(nome, matricula);
        }

        alunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void atualizarNotas(Scanner sc, ArrayList<Cadastro> alunos) {
        System.out.print("Digite a matrícula do aluno para atualizar as notas: ");
        int matricula = sc.nextInt();

        Cadastro aluno = buscarAluno(alunos, matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Digite a nova nota 1: ");
        double nota1 = sc.nextDouble();
        System.out.print("Digite a nova nota 2: ");
        double nota2 = sc.nextDouble();

        aluno.setNota1(nota1);
        aluno.setNota2(nota2);
        System.out.println("Notas atualizadas com sucesso!");
    }

    public static void listarAlunos(ArrayList<Cadastro> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("\n=== Lista de Alunos ===");
            for (Cadastro aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }

    public static boolean existeMatricula(ArrayList<Cadastro> alunos, int matricula) {
        for (Cadastro aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    public static Cadastro buscarAluno(ArrayList<Cadastro> alunos, int matricula) {
        for (Cadastro aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
        }
        return null;
    }
}
