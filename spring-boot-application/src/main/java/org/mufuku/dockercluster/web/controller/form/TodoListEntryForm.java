package org.mufuku.dockercluster.web.controller.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Data
public class TodoListEntryForm {

    @Getter
    @Setter
    private String title;

}
