package tg;

import com.google.android.exoplayer2.k1;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.g f77016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f77017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77018d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f77020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77021g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f77019e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f77015a = new byte[4096];

    static {
        k1.a("goog.exo.extractor");
    }

    public f(com.google.android.exoplayer2.upstream.g gVar, long j11, long j12) {
        this.f77016b = gVar;
        this.f77018d = j11;
        this.f77017c = j12;
    }

    @Override // tg.m
    public void advancePeekPosition(int i11) throws IOException {
        advancePeekPosition(i11, false);
    }

    @Override // tg.m
    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        h(i11);
        int iJ = this.f77021g - this.f77020f;
        while (iJ < i11) {
            iJ = j(this.f77019e, this.f77020f, i11, iJ, z11);
            if (iJ == -1) {
                return false;
            }
            this.f77021g = this.f77020f + iJ;
        }
        this.f77020f += i11;
        return true;
    }

    @Override // tg.m
    public int b(byte[] bArr, int i11, int i12) throws IOException {
        int iMin;
        h(i12);
        int i13 = this.f77021g;
        int i14 = this.f77020f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            iMin = j(this.f77019e, i14, i12, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f77021g += iMin;
        } else {
            iMin = Math.min(i12, i15);
        }
        System.arraycopy(this.f77019e, this.f77020f, bArr, i11, iMin);
        this.f77020f += iMin;
        return iMin;
    }

    public final void f(int i11) {
        if (i11 != -1) {
            this.f77018d += (long) i11;
        }
    }

    @Override // tg.m
    public long getLength() {
        return this.f77017c;
    }

    @Override // tg.m
    public long getPeekPosition() {
        return this.f77018d + ((long) this.f77020f);
    }

    @Override // tg.m
    public long getPosition() {
        return this.f77018d;
    }

    public final void h(int i11) {
        int i12 = this.f77020f + i11;
        byte[] bArr = this.f77019e;
        if (i12 > bArr.length) {
            this.f77019e = Arrays.copyOf(this.f77019e, o0.q(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    public final int i(byte[] bArr, int i11, int i12) {
        int i13 = this.f77021g;
        if (i13 == 0) {
            return 0;
        }
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f77019e, 0, bArr, i11, iMin);
        m(iMin);
        return iMin;
    }

    public final int j(byte[] bArr, int i11, int i12, int i13, boolean z11) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i14 = this.f77016b.read(bArr, i11 + i13, i12 - i13);
        if (i14 != -1) {
            return i13 + i14;
        }
        if (i13 == 0 && z11) {
            return -1;
        }
        throw new EOFException();
    }

    public final int k(int i11) {
        int iMin = Math.min(this.f77021g, i11);
        m(iMin);
        return iMin;
    }

    public boolean l(int i11, boolean z11) throws IOException {
        int iK = k(i11);
        while (iK < i11 && iK != -1) {
            iK = j(this.f77015a, -iK, Math.min(i11, this.f77015a.length + iK), iK, z11);
        }
        f(iK);
        return iK != -1;
    }

    public final void m(int i11) {
        int i12 = this.f77021g - i11;
        this.f77021g = i12;
        this.f77020f = 0;
        byte[] bArr = this.f77019e;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.f77019e = bArr2;
    }

    @Override // tg.m
    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        peekFully(bArr, i11, i12, false);
    }

    @Override // tg.m
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        if (!advancePeekPosition(i12, z11)) {
            return false;
        }
        System.arraycopy(this.f77019e, this.f77020f - i12, bArr, i11, i12);
        return true;
    }

    @Override // tg.m, com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = i(bArr, i11, i12);
        if (i13 == 0) {
            i13 = j(bArr, i11, i12, 0, true);
        }
        f(i13);
        return i13;
    }

    @Override // tg.m
    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        readFully(bArr, i11, i12, false);
    }

    @Override // tg.m
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        int i13 = i(bArr, i11, i12);
        while (i13 < i12 && i13 != -1) {
            i13 = j(bArr, i11, i12, i13, z11);
        }
        f(i13);
        return i13 != -1;
    }

    @Override // tg.m
    public void resetPeekPosition() {
        this.f77020f = 0;
    }

    @Override // tg.m
    public int skip(int i11) throws IOException {
        int iK = k(i11);
        if (iK == 0) {
            byte[] bArr = this.f77015a;
            iK = j(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        f(iK);
        return iK;
    }

    @Override // tg.m
    public void skipFully(int i11) throws IOException {
        l(i11, false);
    }
}
