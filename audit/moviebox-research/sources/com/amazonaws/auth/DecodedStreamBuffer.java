package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class DecodedStreamBuffer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Log f15694f = LogFactory.b(DecodedStreamBuffer.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f15695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15698d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15699e;

    public DecodedStreamBuffer(int i11) {
        this.f15695a = new byte[i11];
        this.f15696b = i11;
    }

    public void a(byte[] bArr, int i11, int i12) {
        this.f15698d = -1;
        int i13 = this.f15697c;
        if (i13 + i12 <= this.f15696b) {
            System.arraycopy(bArr, i11, this.f15695a, i13, i12);
            this.f15697c += i12;
            return;
        }
        Log log = f15694f;
        if (log.b()) {
            log.a("Buffer size " + this.f15696b + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
        }
        this.f15699e = true;
    }

    public boolean b() {
        int i11 = this.f15698d;
        return i11 != -1 && i11 < this.f15697c;
    }

    public byte c() {
        byte[] bArr = this.f15695a;
        int i11 = this.f15698d;
        this.f15698d = i11 + 1;
        return bArr[i11];
    }

    public void d() {
        if (!this.f15699e) {
            this.f15698d = 0;
            return;
        }
        throw new AmazonClientException("The input stream is not repeatable since the buffer size " + this.f15696b + " has been exceeded.");
    }
}
