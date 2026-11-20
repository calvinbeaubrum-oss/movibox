package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MD5DigestCalculatingInputStream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageDigest f15956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MessageDigest f15957b;

    public MD5DigestCalculatingInputStream(InputStream inputStream) {
        super(inputStream);
        this.f15956a = g();
    }

    public final MessageDigest d(MessageDigest messageDigest) {
        try {
            return (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e11) {
            throw new IllegalStateException("unexpected", e11);
        }
    }

    public byte[] e() {
        return this.f15956a.digest();
    }

    public final MessageDigest g() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException("unexpected", e11);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i11) {
        if (markSupported()) {
            super.mark(i11);
            this.f15957b = d(this.f15956a);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i11 = super.read();
        if (i11 != -1) {
            this.f15956a.update((byte) i11);
        }
        return i11;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = super.read(bArr, i11, i12);
        if (i13 != -1) {
            this.f15956a.update(bArr, i11, i13);
        }
        return i13;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!markSupported()) {
            throw new IOException("mark/reset not supported");
        }
        super.reset();
        MessageDigest messageDigest = this.f15957b;
        this.f15956a = messageDigest == null ? g() : d(messageDigest);
    }
}
