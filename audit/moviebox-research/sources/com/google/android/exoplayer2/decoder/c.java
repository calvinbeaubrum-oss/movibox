package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public byte[] f33050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f33051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f33052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public int[] f33053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public int[] f33054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f33057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f33058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final b f33059j;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f33060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f33061b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f33060a = cryptoInfo;
            this.f33061b = androidx.media3.decoder.d.a(0, 0);
        }

        public final void b(int i11, int i12) {
            this.f33061b.set(i11, i12);
            this.f33060a.setPattern(this.f33061b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f33058i = cryptoInfo;
        this.f33059j = o0.f35608a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f33058i;
    }

    public void b(int i11) {
        if (i11 == 0) {
            return;
        }
        if (this.f33053d == null) {
            int[] iArr = new int[1];
            this.f33053d = iArr;
            this.f33058i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f33053d;
        iArr2[0] = iArr2[0] + i11;
    }

    public void c(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.f33055f = i11;
        this.f33053d = iArr;
        this.f33054e = iArr2;
        this.f33051b = bArr;
        this.f33050a = bArr2;
        this.f33052c = i12;
        this.f33056g = i13;
        this.f33057h = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.f33058i;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (o0.f35608a >= 24) {
            ((b) com.google.android.exoplayer2.util.a.e(this.f33059j)).b(i13, i14);
        }
    }
}
