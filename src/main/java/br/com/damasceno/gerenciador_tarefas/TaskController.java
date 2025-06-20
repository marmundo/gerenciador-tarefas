package br.com.damasceno.gerenciador_tarefas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List; // Importe a classe List

@RestController
@RequestMapping("/tarefas")
public class TaskController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TaskController.class);

    @Autowired // 1. Injetando nosso repositório de tarefas
    private TaskRepository taskRepository;

    // 2. Método GET, agora buscando do banco de dados
    @GetMapping
    public List<Task> listarTarefas() {
        return taskRepository.findAll();
    }

    // 3. Método POST, agora salvando no banco de dados
    @PostMapping
    public Task criarTarefa(@RequestBody Task novaTarefa) {
        logger.info("Criando nova tarefa: {}", novaTarefa);
        return taskRepository.save(novaTarefa);
    }

    // 4. Método PUT, atualizando uma tarefa existente
    @PutMapping("/{id}")
    public Task atualizarTarefa(@PathVariable Long id, @RequestBody Task tarefaAtualizada) {
        logger.info("Atualizando tarefa com ID {}: {}", id, tarefaAtualizada);
        tarefaAtualizada.setId(id); // Certifique-se de que o ID está correto
        return taskRepository.save(tarefaAtualizada);
    }

    // 5. Método DELETE, removendo uma tarefa
    @DeleteMapping("/{id}")
    public void removerTarefa(@PathVariable Long id) {
        logger.info("Removendo tarefa com ID {}", id);
        taskRepository.deleteById(id);
    }

    // 6. Método GET para buscar uma tarefa específica pelo ID
    @GetMapping("/{id}")
    public Task buscarTarefaPorId(@PathVariable Long id) {
        logger.info("Buscando tarefa com ID {}", id);
        return taskRepository.findById(id).orElse(null); // Retorna null se não encontrar
    }
}