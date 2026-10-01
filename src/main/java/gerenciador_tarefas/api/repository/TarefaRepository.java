package gerenciador_tarefas.api.repository;

import gerenciador_tarefas.api.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long>{

}

