package br.upe.mavenBasico.data.beans;

import java.util.ArrayList;

public class Tarefa {
    //private ArrayList<Integer> episodios = new ArrayList<>();
    private ArrayList<String> tarefas = new ArrayList<>();
    private String nome;
    private int prioridade;

    public Tarefa(){

    }

    public Tarefa(String nome, int prioridade){
        this.nome = nome;
        this.prioridade = prioridade;
    }


    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString(){
    return "Tarefa: "+ nome + " | Prioridade: " + prioridade;
    }
}
