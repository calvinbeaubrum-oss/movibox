package com.applovin.impl;

import android.media.MediaCodec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f17440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f17441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f17443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f17444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f17448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f17449j;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f17450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f17451b;

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f17450a = cryptoInfo;
            this.f17451b = androidx.media3.decoder.d.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i11, int i12) {
            this.f17451b.set(i11, i12);
            this.f17450a.setPattern(this.f17451b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a5() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f17448i = cryptoInfo;
        this.f17449j = xp.f24372a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f17448i;
    }

    public void a(int i11) {
        if (i11 == 0) {
            return;
        }
        if (this.f17443d == null) {
            int[] iArr = new int[1];
            this.f17443d = iArr;
            this.f17448i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f17443d;
        iArr2[0] = iArr2[0] + i11;
    }

    public void a(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.f17445f = i11;
        this.f17443d = iArr;
        this.f17444e = iArr2;
        this.f17441b = bArr;
        this.f17440a = bArr2;
        this.f17442c = i12;
        this.f17446g = i13;
        this.f17447h = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.f17448i;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (xp.f24372a >= 24) {
            ((b) b1.a(this.f17449j)).a(i13, i14);
        }
    }
}
