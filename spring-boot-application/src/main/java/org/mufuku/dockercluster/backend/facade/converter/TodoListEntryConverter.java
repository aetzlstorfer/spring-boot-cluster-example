package org.mufuku.dockercluster.backend.facade.converter;

import org.mufuku.dockercluster.backend.domain.TodoListEntry;
import org.mufuku.dockercluster.backend.facade.dto.TodoListEntryDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Component
public class TodoListEntryConverter extends AbstractPopulatorConverter<TodoListEntry, TodoListEntryDTO> {

    public TodoListEntryConverter(
            @Qualifier("todoListEntryPopulator")
            Populator<TodoListEntry, TodoListEntryDTO> defaultPopulator
    ) {
        super(TodoListEntryDTO.class, Collections.singletonList(defaultPopulator));
    }
}
