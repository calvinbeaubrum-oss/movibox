package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DirectoryWalker$CancelException extends IOException {
    private static final long serialVersionUID = 1347339620135041008L;
    private final int depth;
    private final File file;

    public DirectoryWalker$CancelException(File file, int i11) {
        this("Operation Cancelled", file, i11);
    }

    public DirectoryWalker$CancelException(String str, File file, int i11) {
        super(str);
        this.file = file;
        this.depth = i11;
    }

    public int getDepth() {
        return this.depth;
    }

    public File getFile() {
        return this.file;
    }
}
