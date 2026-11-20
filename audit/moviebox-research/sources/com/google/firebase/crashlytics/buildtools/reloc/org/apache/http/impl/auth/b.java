package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f40096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f40097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f40098c;

    public b(MessageDigest messageDigest) {
        this.f40096a = messageDigest;
        messageDigest.reset();
    }

    public byte[] a() {
        return this.f40098c;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f40097b) {
            return;
        }
        this.f40097b = true;
        this.f40098c = this.f40096a.digest();
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i11) throws IOException {
        if (this.f40097b) {
            throw new IOException("Stream has been already closed");
        }
        this.f40096a.update((byte) i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f40097b) {
            throw new IOException("Stream has been already closed");
        }
        this.f40096a.update(bArr, i11, i12);
    }
}
