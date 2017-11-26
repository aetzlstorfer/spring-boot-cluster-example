package org.mufuku.dockercluster.backend.facade;

import org.mufuku.dockercluster.backend.facade.dto.NewTodoListEntryDTO;
import org.mufuku.dockercluster.backend.facade.dto.TodoListEntryDTO;

import java.util.List;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
public interface TodoListFacade {

    List<TodoListEntryDTO> getEntries();

    void addEntry(NewTodoListEntryDTO newTodoListEntryDTO);

    void remove(Long id);

    void setDone(Long id);
}
