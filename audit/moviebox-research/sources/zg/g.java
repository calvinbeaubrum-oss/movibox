package zg;

import java.io.IOException;
import tg.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f82045d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f82046a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f82048c;

    public static long a(byte[] bArr, int i11, boolean z11) {
        long j11 = ((long) bArr[0]) & 255;
        if (z11) {
            j11 &= ~f82045d[i11 - 1];
        }
        for (int i12 = 1; i12 < i11; i12++) {
            j11 = (j11 << 8) | (((long) bArr[i12]) & 255);
        }
        return j11;
    }

    public static int c(int i11) {
        int i12 = 0;
        while (true) {
            long[] jArr = f82045d;
            if (i12 >= jArr.length) {
                return -1;
            }
            if ((jArr[i12] & ((long) i11)) != 0) {
                return i12 + 1;
            }
            i12++;
        }
    }

    public int b() {
        return this.f82048c;
    }

    public long d(m mVar, boolean z11, boolean z12, int i11) throws IOException {
        if (this.f82047b == 0) {
            if (!mVar.readFully(this.f82046a, 0, 1, z11)) {
                return -1L;
            }
            int iC = c(this.f82046a[0] & 255);
            this.f82048c = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f82047b = 1;
        }
        int i12 = this.f82048c;
        if (i12 > i11) {
            this.f82047b = 0;
            return -2L;
        }
        if (i12 != 1) {
            mVar.readFully(this.f82046a, 1, i12 - 1);
        }
        this.f82047b = 0;
        return a(this.f82046a, this.f82048c, z12);
    }

    public void e() {
        this.f82047b = 0;
        this.f82048c = 0;
    }
}
