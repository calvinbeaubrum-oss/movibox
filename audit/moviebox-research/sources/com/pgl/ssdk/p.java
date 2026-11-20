package com.pgl.ssdk;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {
    public static o a(RandomAccessFile randomAccessFile, long j11, long j12) {
        return a(randomAccessFile.getChannel(), j11, j12);
    }

    public static o a(FileChannel fileChannel, long j11, long j12) {
        fileChannel.getClass();
        return new l(fileChannel, j11, j12);
    }
}
