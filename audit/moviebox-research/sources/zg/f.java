package zg;

import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import tg.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f82043a = new c0(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f82044b;

    public final long a(m mVar) throws IOException {
        int i11 = 0;
        mVar.peekFully(this.f82043a.d(), 0, 1);
        int i12 = this.f82043a.d()[0] & 255;
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
        mVar.peekFully(this.f82043a.d(), 1, i14);
        while (i11 < i14) {
            i11++;
            i15 = (this.f82043a.d()[i11] & 255) + (i15 << 8);
        }
        this.f82044b += i14 + 1;
        return i15;
    }

    public boolean b(m mVar) throws IOException {
        long length = mVar.getLength();
        long j11 = 1024;
        if (length != -1 && length <= 1024) {
            j11 = length;
        }
        int i11 = (int) j11;
        mVar.peekFully(this.f82043a.d(), 0, 4);
        long jF = this.f82043a.F();
        this.f82044b = 4;
        while (jF != 440786851) {
            int i12 = this.f82044b + 1;
            this.f82044b = i12;
            if (i12 == i11) {
                return false;
            }
            mVar.peekFully(this.f82043a.d(), 0, 1);
            jF = ((jF << 8) & (-256)) | ((long) (this.f82043a.d()[0] & 255));
        }
        long jA = a(mVar);
        long j12 = this.f82044b;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j12 + jA >= length) {
            return false;
        }
        while (true) {
            int i13 = this.f82044b;
            long j13 = j12 + jA;
            if (i13 >= j13) {
                return ((long) i13) == j13;
            }
            if (a(mVar) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(mVar);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i14 = (int) jA2;
                mVar.advancePeekPosition(i14);
                this.f82044b += i14;
            }
        }
    }
}
