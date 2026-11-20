package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.a;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NotFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 6131563330944994230L;
    private final b filter;

    public NotFileFilter(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("The filter must not be null");
        }
        this.filter = bVar;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !this.filter.accept(file, str);
    }

    @Override // wj.a
    public String toString() {
        return super.toString() + "(" + this.filter.toString() + ")";
    }
}
