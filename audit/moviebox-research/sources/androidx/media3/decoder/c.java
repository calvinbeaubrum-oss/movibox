package androidx.media3.decoder;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public byte[] f9802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f9803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public int[] f9805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public int[] f9806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f9810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final b f9811j;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f9812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f9813b;

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f9812a = cryptoInfo;
            this.f9813b = d.a(0, 0);
        }

        public final void b(int i11, int i12) {
            this.f9813b.set(i11, i12);
            this.f9812a.setPattern(this.f9813b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f9810i = cryptoInfo;
        this.f9811j = u0.f81838a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f9810i;
    }

    public void b(int i11) {
        if (i11 == 0) {
            return;
        }
        if (this.f9805d == null) {
            int[] iArr = new int[1];
            this.f9805d = iArr;
            this.f9810i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f9805d;
        iArr2[0] = iArr2[0] + i11;
    }

    public void c(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.f9807f = i11;
        this.f9805d = iArr;
        this.f9806e = iArr2;
        this.f9803b = bArr;
        this.f9802a = bArr2;
        this.f9804c = i12;
        this.f9808g = i13;
        this.f9809h = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.f9810i;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (u0.f81838a >= 24) {
            ((b) z3.a.e(this.f9811j)).b(i13, i14);
        }
    }
}
