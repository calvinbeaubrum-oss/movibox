package com.transsion.transfer.androidasync.http.server;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class AsyncHttpServerRouter$1$1 implements Comparator<File> {
    final /* synthetic */ m this$1;

    public AsyncHttpServerRouter$1$1(m mVar) {
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
