package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Name extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        return tVar.j().compareTo(tVar2.j());
    }
}
