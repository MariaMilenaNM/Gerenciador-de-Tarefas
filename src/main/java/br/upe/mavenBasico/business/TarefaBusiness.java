package br.upe.mavenBasico.business;

import br.upe.mavenBasico.data.beans.Tarefa;
import br.upe.mavenBasico.data.repository.interfaces.ITarefas;

public class TarefaBusiness {
    private static ITarefas repositorio;

    public TarefaBusiness(ITarefas repositorio) {
        this.repositorio = repositorio;
    }

    public boolean listar(String nome) {
        try {
            Tarefa t = repositorio.retrieve(nome);
            if (t != null) {
                System.out.println(t);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void listarTodas() {
        for (Tarefa t : repositorio.listarTodas()) {
            System.out.println(t);
        }
    }

    public boolean criaNova(String nome, int prioridade) {
        try {
            if (verificaExistente(nome)) {
                System.out.println("Tarefa já existe!");
                return false;
            }

            Tarefa t = new Tarefa(nome, prioridade);
            repositorio.create(nome, prioridade);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verificaExistente(String nome) {
        return repositorio.retrieve(nome) != null;
    }

    public static void chamarEscritor(){
        ManipuladorArquivo.arquivarTarefas(repositorio.listarTodas());
    }

    public boolean atualizar(Tarefa t){
      //  Tarefa t = new Tarefa(nomeAntigo, novaPrioridade);
        return repositorio.update(t);
    }
}
