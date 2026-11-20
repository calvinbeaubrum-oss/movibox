package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Date extends ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        long jD = tVar.d() - tVar2.d();
        if (jD > 0) {
            return 1;
        }
        return jD < 0 ? -1 : 0;
    }
}
