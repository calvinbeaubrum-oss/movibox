package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TrueFileFilter implements b, Serializable {
    public static final b INSTANCE;
    public static final b TRUE;
    private static final long serialVersionUID = 8782512160909720199L;

    static {
        TrueFileFilter trueFileFilter = new TrueFileFilter();
        TRUE = trueFileFilter;
        INSTANCE = trueFileFilter;
    }

    @Override // wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return true;
    }

    @Override // wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return true;
    }
}
