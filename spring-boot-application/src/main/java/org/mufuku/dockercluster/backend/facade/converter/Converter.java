package org.mufuku.dockercluster.backend.facade.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
public interface Converter<Source, Target> {

    Target convert(Source source);

    default List<Target> convertToList(Collection<Source> sourceCollection) {
        return
                sourceCollection
                        .stream()
                        .map(this::convert)
                        .collect(Collectors.toList());
    }

}