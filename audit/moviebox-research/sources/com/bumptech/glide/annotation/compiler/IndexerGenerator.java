package com.bumptech.glide.annotation.compiler;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.repackaged.com.squareup.javapoet.AnnotationSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.ClassName;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class IndexerGenerator {
    private final ProcessorUtil processorUtil;

    public IndexerGenerator(ProcessorUtil processorUtil) {
        this.processorUtil = processorUtil;
    }

    private TypeSpec generate(List<TypeElement> list, Class<? extends Annotation> cls) {
        AnnotationSpec.Builder builder = AnnotationSpec.builder((Class<?>) Index.class);
        String annotationValue = getAnnotationValue(cls);
        Iterator<TypeElement> it = list.iterator();
        while (it.hasNext()) {
            builder.addMember(annotationValue, "$S", ClassName.get(it.next()).toString());
        }
        StringBuilder sb2 = new StringBuilder("GlideIndexer_" + cls.getSimpleName() + "_");
        Iterator<TypeElement> it2 = list.iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next().getQualifiedName().toString().replace(InstructionFileId.DOT, "_"));
            sb2.append("_");
        }
        String string = new StringBuilder(sb2.substring(0, sb2.length() - 1)).toString();
        if (string.length() >= 242) {
            string = "GlideIndexer_" + UUID.nameUUIDFromBytes(string.getBytes()).toString().replace("-", "_");
        }
        return TypeSpec.classBuilder(string).addAnnotation(builder.build()).addModifiers(Modifier.PUBLIC).build();
    }

    private static String getAnnotationValue(Class<? extends Annotation> cls) {
        if (cls == GlideModule.class) {
            return "modules";
        }
        if (cls == GlideExtension.class) {
            return "extensions";
        }
        throw new IllegalArgumentException("Unrecognized annotation: " + cls);
    }

    public TypeSpec generate(List<TypeElement> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement : list) {
            if (this.processorUtil.isExtension(typeElement)) {
                arrayList2.add(typeElement);
            } else {
                if (!this.processorUtil.isLibraryGlideModule(typeElement)) {
                    throw new IllegalArgumentException("Unrecognized type: " + typeElement);
                }
                arrayList.add(typeElement);
            }
        }
        if (arrayList.isEmpty() || arrayList2.isEmpty()) {
            return !arrayList.isEmpty() ? generate(list, GlideModule.class) : generate(list, GlideExtension.class);
        }
        throw new IllegalArgumentException("Given both modules and extensions, expected one or the other. Modules: " + arrayList + " Extensions: " + arrayList2);
    }
}
