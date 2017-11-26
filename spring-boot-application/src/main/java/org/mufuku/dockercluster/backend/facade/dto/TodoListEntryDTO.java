package org.mufuku.dockercluster.backend.facade.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Data
public class TodoListEntryDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private boolean done;

    @Getter
    @Setter
    private String owner;
}
