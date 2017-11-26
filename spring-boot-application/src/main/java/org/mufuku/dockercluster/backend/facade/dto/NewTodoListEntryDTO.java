package org.mufuku.dockercluster.backend.facade.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Data
public class NewTodoListEntryDTO {

    @Getter
    @Setter
    private String title;

}
