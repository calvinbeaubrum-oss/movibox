package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkDigestInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class DigestValidationInputStream extends SdkDigestInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f15949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15950b;

    public DigestValidationInputStream(InputStream inputStream, MessageDigest messageDigest, byte[] bArr) {
        super(inputStream, messageDigest);
        this.f15950b = false;
        this.f15949a = bArr;
    }

    public final void b() {
        if (this.f15949a == null || this.f15950b) {
            return;
        }
        this.f15950b = true;
        if (!Arrays.equals(((DigestInputStream) this).digest.digest(), this.f15949a)) {
            throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data may be corrupt.");
        }
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i11 = super.read();
        if (i11 == -1) {
            b();
        }
        return i11;
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = super.read(bArr, i11, i12);
        if (i13 == -1) {
            b();
        }
        return i13;
    }
}
