package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io;

import java.nio.file.FileSystemException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(String str) {
        super(str, null, "unable to guarantee security of recursive delete");
    }
}
