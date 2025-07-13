package br.upe.mavenBasico.ui;
import br.upe.mavenBasico.business.ManipuladorArquivo;
import br.upe.mavenBasico.business.TarefaBusiness;
import br.upe.mavenBasico.data.beans.Tarefa;
import br.upe.mavenBasico.data.repository.RepositorioTarefa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static TarefaBusiness TarefaBusiness;
    private static RepositorioTarefa RepositorioTarefa;


    public static void main(String[] args) {
        RepositorioTarefa = new RepositorioTarefa();
        TarefaBusiness = new TarefaBusiness(RepositorioTarefa);
        for (Tarefa t : ManipuladorArquivo.lerTarefas()) {
            RepositorioTarefa.create(t.getNome(), t.getPrioridade());
        }

        int opcao = 1;

        while(opcao != 0){
            System.out.print("Olá, seja bem-vindo ao gerenciamento de tarefas\nOpções: \n1 - Criar\n2 - Listar\n3 - Atualizar\n4 - Deletar\n0 - Sair\nOque voce deseja realizar?");
            try{
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao){
                    case 1:
                        System.out.println("Digite o nome para sua tarefa");
                        String nome = sc.nextLine();
                        System.out.println("Digite a prioridade para sua tarefa");
                        int prioridade = sc.nextInt();
                        sc.nextLine();
                        TarefaBusiness.criaNova(nome, prioridade);
                        ManipuladorArquivo.arquivarTarefas(RepositorioTarefa.listarTodas());
                        break;
                    case 2:
                        //Aqui vou querer listar tds as tarefas e unitário
                        //DEU CERTO!
                        System.out.println("Listar tarefa específica: 1\nListar todas as tarefas: 2");
                        int listar = sc.nextInt();
                        sc.nextLine();
                        if(listar == 1){
                            System.out.println("digite o nome da tarefa que deseja listar.");
                            String name = sc.nextLine();
                            TarefaBusiness.listar(name);
                        }else{
                           TarefaBusiness.listarTodas();
                        }
                        break;
                    case 3:
                        System.out.println("Diga o nome da tarefa que quer atualizar:");
                        String nomeAntigo = sc.nextLine();

                        System.out.println("Digite a nova prioridade:");
                        int novaPrioridade = sc.nextInt();
                        sc.nextLine();

                        Tarefa tAtualizada = new Tarefa(nomeAntigo, novaPrioridade);
                        RepositorioTarefa.update(tAtualizada);
                        ManipuladorArquivo.arquivarTarefas(RepositorioTarefa.listarTodas());
                        break;
                    case 4:
                        System.out.println("Diga o nome da tarefa que quer deletar");
                        String deletarTarefa = sc.nextLine();
                        RepositorioTarefa.delete(deletarTarefa);
                        ManipuladorArquivo.arquivarTarefas(RepositorioTarefa.listarTodas());
                        break;
                    case 0:
                        ManipuladorArquivo.arquivarTarefas(RepositorioTarefa.listarTodas());
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }}catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
                sc.nextLine();
            }
        }
       sc.close();

    }
}
