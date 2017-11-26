package org.mufuku.dockercluster.backend.facade.converter;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
public interface Populator<Source, Target> {
    void populate(Source source, Target target);
}
