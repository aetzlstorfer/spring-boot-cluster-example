package org.mufuku.dockercluster.backend.facade.converter;

import java.util.List;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
public abstract class AbstractPopulatorConverter<Source, Target> implements Converter<Source, Target> {

    private final List<Populator<Source, Target>> populators;
    private final Class<Target> targetClass;

    public AbstractPopulatorConverter(
            Class<Target> targetClass,
            List<Populator<Source, Target>> populators
    ) {
        this.targetClass = targetClass;
        this.populators = populators;
    }

    @Override
    public Target convert(Source source) {
        Target target = getInstance();
        populators.forEach(
                p -> p.populate(source, target)
        );
        return target;
    }

    private Target getInstance() {
        try {
            return targetClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("Class " + targetClass + " cannot be created by default means.");
        }
    }
}
