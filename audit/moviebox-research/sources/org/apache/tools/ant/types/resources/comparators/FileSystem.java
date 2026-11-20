package org.apache.tools.ant.types.resources.comparators;

import java.io.File;
import org.apache.tools.ant.types.t;
import org.apache.tools.ant.util.d;
import w20.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class FileSystem extends ResourceComparator {
    private static final d FILE_UTILS = d.k();

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        File fileT = ((c) tVar).t();
        File fileT2 = ((c) tVar2).t();
        if (fileT.equals(fileT2)) {
            return 0;
        }
        d dVar = FILE_UTILS;
        if (dVar.n(fileT, fileT2)) {
            return -1;
        }
        return dVar.o(fileT.getAbsolutePath()).compareTo(dVar.o(fileT2.getAbsolutePath()));
    }
}
