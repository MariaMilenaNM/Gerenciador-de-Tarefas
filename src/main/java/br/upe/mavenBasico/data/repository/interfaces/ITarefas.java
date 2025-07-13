package br.upe.mavenBasico.data.repository.interfaces;
import br.upe.mavenBasico.data.beans.Tarefa;

import java.util.List;

public interface ITarefas {
    boolean create(String nome, int prioridade);
    Tarefa retrieve(String nome);
    boolean update(Tarefa t);
    boolean delete(String nome);
    List<Tarefa> listarTodas();
}
