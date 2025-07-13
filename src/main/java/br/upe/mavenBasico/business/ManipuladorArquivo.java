package br.upe.mavenBasico.business;
import br.upe.mavenBasico.data.beans.Tarefa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivo {
    private static final String caminho = "tarefas.txt";

    public static void arquivarTarefas(List<Tarefa> tarefas){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminho));
            writer.write("nome, prioridade");
            writer.newLine();
            for(Tarefa t : tarefas){
                String linha = t.getNome() + "," + t.getPrioridade();
                writer.write(linha);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public static List<Tarefa> lerTarefas(){
        List<Tarefa> tarefas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminho));
            String linha;
            reader.readLine();
            while((linha = reader.readLine())!=null){
                String[] nomePrioridade = linha.split(",");
                String nome =  nomePrioridade[0];
                int prioridade = Integer.parseInt(nomePrioridade[1]);
                tarefas.add(new Tarefa(nome, prioridade));
            }
        }catch(IOException e){
            System.out.println("Erro ao ler tarefas: " + e.getMessage());

        }
        return tarefas;
    }

}
