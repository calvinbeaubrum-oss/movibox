package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Type extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        boolean zL = tVar.l();
        if (zL == tVar2.l()) {
            return 0;
        }
        return zL ? 1 : -1;
    }
}
