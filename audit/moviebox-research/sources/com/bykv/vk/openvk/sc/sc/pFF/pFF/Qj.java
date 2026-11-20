package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f25919a;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends Exception {
        public sc(Throwable th2) {
            super(th2);
        }
    }

    public Qj(File file, String str) throws sc {
        try {
            this.f25919a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e11) {
            throw new sc(e11);
        }
    }

    public int a(byte[] bArr) throws sc {
        try {
            return this.f25919a.read(bArr);
        } catch (IOException e11) {
            throw new sc(e11);
        }
    }

    public void b() {
        p8.a.s(this.f25919a);
    }

    public void c(long j11) throws sc {
        try {
            this.f25919a.seek(j11);
        } catch (IOException e11) {
            throw new sc(e11);
        }
    }

    public void d(byte[] bArr, int i11, int i12) throws sc {
        try {
            this.f25919a.write(bArr, i11, i12);
        } catch (IOException e11) {
            throw new sc(e11);
        }
    }
}
