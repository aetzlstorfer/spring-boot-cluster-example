package org.mufuku.dockercluster.backend.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Entity
@Data
public class TodoListEntry {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Getter
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
