package org.apache.tools.ant.taskdefs;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class Jar$1 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof String)) {
            return ((String) obj2).length() - ((String) obj).length();
        }
        return 0;
    }
}
