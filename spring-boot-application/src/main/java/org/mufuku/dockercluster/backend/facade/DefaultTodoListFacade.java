package org.mufuku.dockercluster.backend.facade;

import org.mufuku.dockercluster.backend.domain.TodoListEntry;
import org.mufuku.dockercluster.backend.facade.converter.TodoListEntryConverter;
import org.mufuku.dockercluster.backend.facade.dto.NewTodoListEntryDTO;
import org.mufuku.dockercluster.backend.facade.dto.TodoListEntryDTO;
import org.mufuku.dockercluster.backend.repository.TodoListRepository;
import org.mufuku.dockercluster.backend.services.AuthenticationDetails;
import org.mufuku.dockercluster.backend.services.AuthenticationService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Component
public class DefaultTodoListFacade implements TodoListFacade {

    private final TodoListRepository todoListRepository;

    private final AuthenticationService authenticationService;

    private final TodoListEntryConverter todoListEntryConverter;

    public DefaultTodoListFacade(TodoListRepository todoListRepository,
                                 AuthenticationService authenticationService,
                                 TodoListEntryConverter todoListEntryConverter) {
        this.todoListRepository = todoListRepository;
        this.authenticationService = authenticationService;
        this.todoListEntryConverter = todoListEntryConverter;
    }

    @Override
    public List<TodoListEntryDTO> getEntries() {
        AuthenticationDetails authentication = authenticationService.getAuthentication();
        List<TodoListEntry> entries = todoListRepository.getEntriesByOwner(authentication.getUserCode());
        return todoListEntryConverter.convertToList(entries);
    }

    @Override
    public void addEntry(NewTodoListEntryDTO newTodoListEntryDTO) {

        AuthenticationDetails authentication = authenticationService.getAuthentication();

        TodoListEntry entry = new TodoListEntry();
        entry.setOwner(authentication.getUserCode());
        entry.setTitle(newTodoListEntryDTO.getTitle());
        entry.setDone(false);

        todoListRepository.save(entry);
    }

    @Override
    public void remove(Long id) {
        TodoListEntry entry = getSecuredEntry(id);
        if (entry != null) {
            todoListRepository.delete(entry);
        }
    }


    @Override
    public void setDone(Long id) {
        TodoListEntry entry = getSecuredEntry(id);
        if (entry != null) {
            entry.setDone(true);
            todoListRepository.save(entry);
        }
    }

    private TodoListEntry getSecuredEntry(Long id) {
        TodoListEntry entry = todoListRepository.findOne(id);
        if (entry != null) {
            AuthenticationDetails authentication = authenticationService.getAuthentication();
            if (!entry.getOwner().equals(authentication.getUserCode())) {
                throw new AccessDeniedException("This entry for given id does not belong to current user");
            }
        }
        return entry;
    }
}
