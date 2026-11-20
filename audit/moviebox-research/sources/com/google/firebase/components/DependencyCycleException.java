package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import rj.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class DependencyCycleException extends DependencyException {
    private final List<c<?>> componentsInCycle;

    public DependencyCycleException(List<c<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<c<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
