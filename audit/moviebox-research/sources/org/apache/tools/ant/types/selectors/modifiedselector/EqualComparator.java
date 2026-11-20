package org.apache.tools.ant.types.selectors.modifiedselector;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class EqualComparator implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? 1 : 0;
        }
        return !obj.equals(obj2) ? 1 : 0;
    }

    public String toString() {
        return "EqualComparator";
    }
}
