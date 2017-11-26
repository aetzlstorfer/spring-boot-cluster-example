package org.mufuku.dockercluster.backend.repository;

import org.mufuku.dockercluster.backend.domain.TodoListEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Repository
public interface TodoListRepository extends CrudRepository<TodoListEntry, Long> {
    List<TodoListEntry> getEntriesByOwner(String owner);
}
