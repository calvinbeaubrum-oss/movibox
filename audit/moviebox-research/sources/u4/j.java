package u4;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.common.l f78302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f78303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78304d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f78306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f78307g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f78305e = new byte[65536];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f78301a = new byte[4096];

    static {
        androidx.media3.common.c0.a("media3.extractor");
    }

    public j(androidx.media3.common.l lVar, long j11, long j12) {
        this.f78302b = lVar;
        this.f78304d = j11;
        this.f78303c = j12;
    }

    @Override // u4.t
    public void advancePeekPosition(int i11) throws IOException {
        advancePeekPosition(i11, false);
    }

    @Override // u4.t
    public boolean advancePeekPosition(int i11, boolean z11) throws IOException {
        e(i11);
        int iG = this.f78307g - this.f78306f;
        while (iG < i11) {
            iG = g(this.f78305e, this.f78306f, i11, iG, z11);
            if (iG == -1) {
                return false;
            }
            this.f78307g = this.f78306f + iG;
        }
        this.f78306f += i11;
        return true;
    }

    @Override // u4.t
    public int b(byte[] bArr, int i11, int i12) throws IOException {
        int iMin;
        e(i12);
        int i13 = this.f78307g;
        int i14 = this.f78306f;
        int i15 = i13 - i14;
        if (i15 == 0) {
            iMin = g(this.f78305e, i14, i12, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f78307g += iMin;
        } else {
            iMin = Math.min(i12, i15);
        }
        System.arraycopy(this.f78305e, this.f78306f, bArr, i11, iMin);
        this.f78306f += iMin;
        return iMin;
    }

    public final void d(int i11) {
        if (i11 != -1) {
            this.f78304d += (long) i11;
        }
    }

    public final void e(int i11) {
        int i12 = this.f78306f + i11;
        byte[] bArr = this.f78305e;
        if (i12 > bArr.length) {
            this.f78305e = Arrays.copyOf(this.f78305e, z3.u0.p(bArr.length * 2, 65536 + i12, i12 + 524288));
        }
    }

    public final int f(byte[] bArr, int i11, int i12) {
        int i13 = this.f78307g;
        if (i13 == 0) {
            return 0;
        }
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f78305e, 0, bArr, i11, iMin);
        j(iMin);
        return iMin;
    }

    public final int g(byte[] bArr, int i11, int i12, int i13, boolean z11) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i14 = this.f78302b.read(bArr, i11 + i13, i12 - i13);
        if (i14 != -1) {
            return i13 + i14;
        }
        if (i13 == 0 && z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // u4.t
    public long getLength() {
        return this.f78303c;
    }

    @Override // u4.t
    public long getPeekPosition() {
        return this.f78304d + ((long) this.f78306f);
    }

    @Override // u4.t
    public long getPosition() {
        return this.f78304d;
    }

    public final int h(int i11) {
        int iMin = Math.min(this.f78307g, i11);
        j(iMin);
        return iMin;
    }

    public boolean i(int i11, boolean z11) throws IOException {
        int iH = h(i11);
        while (iH < i11 && iH != -1) {
            iH = g(this.f78301a, -iH, Math.min(i11, this.f78301a.length + iH), iH, z11);
        }
        d(iH);
        return iH != -1;
    }

    public final void j(int i11) {
        int i12 = this.f78307g - i11;
        this.f78307g = i12;
        this.f78306f = 0;
        byte[] bArr = this.f78305e;
        byte[] bArr2 = i12 < bArr.length - 524288 ? new byte[65536 + i12] : bArr;
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        this.f78305e = bArr2;
    }

    @Override // u4.t
    public void peekFully(byte[] bArr, int i11, int i12) throws IOException {
        peekFully(bArr, i11, i12, false);
    }

    @Override // u4.t
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        if (!advancePeekPosition(i12, z11)) {
            return false;
        }
        System.arraycopy(this.f78305e, this.f78306f - i12, bArr, i11, i12);
        return true;
    }

    @Override // u4.t, androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int iF = f(bArr, i11, i12);
        if (iF == 0) {
            iF = g(bArr, i11, i12, 0, true);
        }
        d(iF);
        return iF;
    }

    @Override // u4.t
    public void readFully(byte[] bArr, int i11, int i12) throws IOException {
        readFully(bArr, i11, i12, false);
    }

    @Override // u4.t
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        int iF = f(bArr, i11, i12);
        while (iF < i12 && iF != -1) {
            iF = g(bArr, i11, i12, iF, z11);
        }
        d(iF);
        return iF != -1;
    }

    @Override // u4.t
    public void resetPeekPosition() {
        this.f78306f = 0;
    }

    @Override // u4.t
    public int skip(int i11) throws IOException {
        int iH = h(i11);
        if (iH == 0) {
            byte[] bArr = this.f78301a;
            iH = g(bArr, 0, Math.min(i11, bArr.length), 0, true);
        }
        d(iH);
        return iH;
    }

    @Override // u4.t
    public void skipFully(int i11) throws IOException {
        i(i11, false);
    }
}
