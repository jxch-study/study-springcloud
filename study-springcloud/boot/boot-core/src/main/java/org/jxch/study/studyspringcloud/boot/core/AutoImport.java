package org.jxch.study.studyspringcloud.boot.core;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

public class AutoImport implements DeferredImportSelector {
    @NonNull
    @Override
    public String[] selectImports(@NonNull AnnotationMetadata importingClassMetadata) {
        return StreamSupport.stream(ServiceLoader.load(AutoConfig.class).spliterator(), false)
                .map(autoConfig -> autoConfig.getClass().getName())
                .toArray(String[]::new);
    }
}
