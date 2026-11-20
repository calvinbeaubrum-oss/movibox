package j5;

import java.io.IOException;
import u4.t;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f67930a = new c0(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f67931b;

    public final long a(t tVar) throws IOException {
        int i11 = 0;
        tVar.peekFully(this.f67930a.e(), 0, 1);
        int i12 = this.f67930a.e()[0] & 255;
        if (i12 == 0) {
            return Long.MIN_VALUE;
        }
        int i13 = 128;
        int i14 = 0;
        while ((i12 & i13) == 0) {
            i13 >>= 1;
            i14++;
        }
        int i15 = i12 & (~i13);
        tVar.peekFully(this.f67930a.e(), 1, i14);
        while (i11 < i14) {
            i11++;
            i15 = (this.f67930a.e()[i11] & 255) + (i15 << 8);
        }
        this.f67931b += i14 + 1;
        return i15;
    }

    public boolean b(t tVar) throws IOException {
        long length = tVar.getLength();
        long j11 = 1024;
        if (length != -1 && length <= 1024) {
            j11 = length;
        }
        int i11 = (int) j11;
        tVar.peekFully(this.f67930a.e(), 0, 4);
        long J = this.f67930a.J();
        this.f67931b = 4;
        while (J != 440786851) {
            int i12 = this.f67931b + 1;
            this.f67931b = i12;
            if (i12 == i11) {
                return false;
            }
            tVar.peekFully(this.f67930a.e(), 0, 1);
            J = ((J << 8) & (-256)) | ((long) (this.f67930a.e()[0] & 255));
        }
        long jA = a(tVar);
        long j12 = this.f67931b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j12 + jA >= length) {
            return false;
        }
        while (true) {
            int i13 = this.f67931b;
            long j13 = j12 + jA;
            if (i13 >= j13) {
                return ((long) i13) == j13;
            }
            if (a(tVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(tVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i14 = (int) jA2;
                tVar.advancePeekPosition(i14);
                this.f67931b += i14;
            }
        }
    }
}
