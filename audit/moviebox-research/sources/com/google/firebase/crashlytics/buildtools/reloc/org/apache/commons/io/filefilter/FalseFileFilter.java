package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FalseFileFilter implements b, Serializable {
    public static final b FALSE;
    public static final b INSTANCE;
    private static final long serialVersionUID = 6210271677940926200L;

    static {
        FalseFileFilter falseFileFilter = new FalseFileFilter();
        FALSE = falseFileFilter;
        INSTANCE = falseFileFilter;
    }

    @Override // wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return false;
    }

    @Override // wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return false;
    }
}
