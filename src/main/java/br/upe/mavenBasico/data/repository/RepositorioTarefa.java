package br.upe.mavenBasico.data.repository;

import br.upe.mavenBasico.data.beans.Tarefa;
import br.upe.mavenBasico.data.repository.interfaces.ITarefas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioTarefa implements ITarefas {
    private Map<String, Tarefa> tarefas = new HashMap<>();


    @Override
    public boolean create(String nome, int prioridade) {
        try{
            tarefas.put(nome, new Tarefa(nome, prioridade));
            System.out.println(tarefas.keySet());
        } catch (Exception e) {
            System.out.println("falha ao criar tarefa");
            return false;
        }
        return true;
    }

    @Override
    public Tarefa retrieve(String nome) {
        return tarefas.get(nome);
    }

    public List<Tarefa> listarTodas(){
        return new ArrayList<>(tarefas.values());
    }

    @Override
    public boolean update(Tarefa t) {
        Tarefa existente = retrieve(t.getNome());
        try{
            if(existente!=null){
                existente.setNome(t.getNome());
                existente.setPrioridade(t.getPrioridade());
            }

        } catch (Exception e) {
            System.out.println("Não foi possível atualizar a tarefa");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String nome) {
        Tarefa tarefa = retrieve(nome);
        try{
            if(tarefas.containsKey(nome)){
               tarefas.remove(nome);
               return true;
            }
        } catch (Exception e) {
            System.out.println("Não foi possível deletar a tarefa");
            return false;
        }
        return true;
    }

}
