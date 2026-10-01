package gerenciador_tarefas.api.Controller;

import gerenciador_tarefas.api.model.TarefaModel;
import gerenciador_tarefas.api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefa) {
        TarefaModel tarefaCriada = tarefaRepository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    // Retorna todas as tarefas
    @GetMapping
    public List<TarefaModel> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Retorna uma tarefa específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> buscarPorId(@PathVariable Long id) { // Assumindo que seu ID é do tipo Long
        Optional<TarefaModel> tarefa = tarefaRepository.findById(id);

        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

