package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import wj.a;
import wj.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FileFileFilter extends a implements Serializable {
    public static final b FILE = new FileFileFilter();
    private static final long serialVersionUID = 5345244090827540862L;

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        return file.isFile();
    }
}
