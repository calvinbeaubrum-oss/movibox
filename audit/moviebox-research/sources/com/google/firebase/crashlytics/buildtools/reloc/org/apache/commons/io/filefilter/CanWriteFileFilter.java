package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.a;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CanWriteFileFilter extends a implements Serializable {
    public static final b CANNOT_WRITE;
    public static final b CAN_WRITE;
    private static final long serialVersionUID = 5132005214688990379L;

    static {
        CanWriteFileFilter canWriteFileFilter = new CanWriteFileFilter();
        CAN_WRITE = canWriteFileFilter;
        CANNOT_WRITE = new NotFileFilter(canWriteFileFilter);
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return file.canWrite();
    }
}
