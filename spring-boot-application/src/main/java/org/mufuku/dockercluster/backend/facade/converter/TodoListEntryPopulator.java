package org.mufuku.dockercluster.backend.facade.converter;

import org.mufuku.dockercluster.backend.domain.TodoListEntry;
import org.mufuku.dockercluster.backend.facade.dto.TodoListEntryDTO;
import org.springframework.stereotype.Component;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Component
public class TodoListEntryPopulator implements Populator<TodoListEntry, TodoListEntryDTO> {
    @Override
    public void populate(TodoListEntry todoListEntry, TodoListEntryDTO todoListEntryDTO) {
        todoListEntryDTO.setDone(todoListEntry.isDone());
        todoListEntryDTO.setTitle(todoListEntry.getTitle());
        todoListEntryDTO.setId(todoListEntry.getId());
        todoListEntryDTO.setOwner(todoListEntry.getOwner());
    }
}
