package br.com.damasceno.gerenciador_tarefas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 1. Diz ao JPA: "Esta classe representa uma tabela no banco de dados"
public class Task {

    @Id // 2. Marca este campo como a chave primária (o RG único de cada tarefa)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Pede ao banco para gerar o valor do ID automaticamente
    private Long id;

    private String description;

    private boolean done = false; // Por padrão, uma nova tarefa não está concluída

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}