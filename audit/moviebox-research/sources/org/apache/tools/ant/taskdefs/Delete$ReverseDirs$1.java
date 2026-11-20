package org.apache.tools.ant.taskdefs;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class Delete$ReverseDirs$1 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2) * (-1);
    }
}
