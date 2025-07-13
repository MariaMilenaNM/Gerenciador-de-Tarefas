package br.upe.mavenBasico;

import br.upe.mavenBasico.data.beans.Tarefa;
import br.upe.mavenBasico.data.repository.RepositorioTarefa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteRepositorioTarefa {

    private RepositorioTarefa repo;

    @BeforeEach
    public void setUp() {
        repo = new RepositorioTarefa();
    }

    @Test
    public void testCreateRetrieve() {
        boolean criado = repo.create("Estudar", 2);
        assertTrue(criado);

        Tarefa t = repo.retrieve("Estudar");
        assertNotNull(t);
        assertEquals("Estudar", t.getNome());
        assertEquals(2, t.getPrioridade());
    }

    @Test
    public void testUpdate() {
        repo.create("Dormir", 1);
        Tarefa atualizada = new Tarefa("Dormir", 5);
        boolean atualizado = repo.update(atualizada);

        assertTrue(atualizado);
        assertEquals(5, repo.retrieve("Dormir").getPrioridade());
    }

    @Test
    public void testDelete() {
        repo.create("Comer", 3);
        boolean deletado = repo.delete("Comer");

        assertTrue(deletado);
        assertNull(repo.retrieve("Comer"));
    }
}
