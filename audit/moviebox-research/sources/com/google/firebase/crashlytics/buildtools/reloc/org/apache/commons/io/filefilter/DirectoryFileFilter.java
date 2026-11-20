package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.a;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DirectoryFileFilter extends a implements Serializable {
    public static final b DIRECTORY;
    public static final b INSTANCE;
    private static final long serialVersionUID = -5148237843784525732L;

    static {
        DirectoryFileFilter directoryFileFilter = new DirectoryFileFilter();
        DIRECTORY = directoryFileFilter;
        INSTANCE = directoryFileFilter;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
