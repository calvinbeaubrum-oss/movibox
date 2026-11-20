package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(File file) {
        super("File " + file + " exists");
    }

    public FileExistsException(String str) {
        super(str);
    }
}
