package m5;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import u4.m0;
import u4.n0;
import u4.t;
import u4.v;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f70791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f70792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f70793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f70794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f70795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f70796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f70797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f70798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f70799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f70800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f70801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f70802l;

    /* JADX INFO: compiled from: source.java */
    public final class b implements m0 {
        public b() {
        }

        @Override // u4.m0
        public long getDurationUs() {
            return a.this.f70794d.b(a.this.f70796f);
        }

        @Override // u4.m0
        public m0.a getSeekPoints(long j11) {
            return new m0.a(new n0(j11, u0.q((a.this.f70792b + BigInteger.valueOf(a.this.f70794d.c(j11)).multiply(BigInteger.valueOf(a.this.f70793c - a.this.f70792b)).divide(BigInteger.valueOf(a.this.f70796f)).longValue()) - 30000, a.this.f70792b, a.this.f70793c - 1)));
        }

        @Override // u4.m0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j11, long j12, long j13, long j14, boolean z11) {
        z3.a.a(j11 >= 0 && j12 > j11);
        this.f70794d = iVar;
        this.f70792b = j11;
        this.f70793c = j12;
        if (j13 == j12 - j11 || z11) {
            this.f70796f = j14;
            this.f70795e = 4;
        } else {
            this.f70795e = 0;
        }
        this.f70791a = new f();
    }

    @Override // m5.g
    public long a(t tVar) throws IOException {
        int i11 = this.f70795e;
        if (i11 == 0) {
            long position = tVar.getPosition();
            this.f70797g = position;
            this.f70795e = 1;
            long j11 = this.f70793c - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long jG = g(tVar);
                if (jG != -1) {
                    return jG;
                }
                this.f70795e = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(tVar);
            this.f70795e = 4;
            return -(this.f70801k + 2);
        }
        this.f70796f = h(tVar);
        this.f70795e = 4;
        return this.f70797g;
    }

    @Override // m5.g
    @Nullable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f70796f != 0) {
            return new b();
        }
        return null;
    }

    public final long g(t tVar) throws IOException {
        if (this.f70799i == this.f70800j) {
            return -1L;
        }
        long position = tVar.getPosition();
        if (!this.f70791a.d(tVar, this.f70800j)) {
            long j11 = this.f70799i;
            if (j11 != position) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f70791a.a(tVar, false);
        tVar.resetPeekPosition();
        long j12 = this.f70798h;
        f fVar = this.f70791a;
        long j13 = fVar.f70821c;
        long j14 = j12 - j13;
        int i11 = fVar.f70826h + fVar.f70827i;
        if (0 <= j14 && j14 < 72000) {
            return -1L;
        }
        if (j14 < 0) {
            this.f70800j = position;
            this.f70802l = j13;
        } else {
            this.f70799i = tVar.getPosition() + ((long) i11);
            this.f70801k = this.f70791a.f70821c;
        }
        long j15 = this.f70800j;
        long j16 = this.f70799i;
        if (j15 - j16 < 100000) {
            this.f70800j = j16;
            return j16;
        }
        long position2 = tVar.getPosition() - (((long) i11) * (j14 <= 0 ? 2L : 1L));
        long j17 = this.f70800j;
        long j18 = this.f70799i;
        return u0.q(position2 + ((j14 * (j17 - j18)) / (this.f70802l - this.f70801k)), j18, j17 - 1);
    }

    public long h(t tVar) throws IOException {
        this.f70791a.b();
        if (!this.f70791a.c(tVar)) {
            throw new EOFException();
        }
        this.f70791a.a(tVar, false);
        f fVar = this.f70791a;
        tVar.skipFully(fVar.f70826h + fVar.f70827i);
        long j11 = this.f70791a.f70821c;
        while (true) {
            f fVar2 = this.f70791a;
            if ((fVar2.f70820b & 4) == 4 || !fVar2.c(tVar) || tVar.getPosition() >= this.f70793c || !this.f70791a.a(tVar, true)) {
                break;
            }
            f fVar3 = this.f70791a;
            if (!v.e(tVar, fVar3.f70826h + fVar3.f70827i)) {
                break;
            }
            j11 = this.f70791a.f70821c;
        }
        return j11;
    }

    public final void i(t tVar) throws IOException {
        while (true) {
            this.f70791a.c(tVar);
            this.f70791a.a(tVar, false);
            f fVar = this.f70791a;
            if (fVar.f70821c > this.f70798h) {
                tVar.resetPeekPosition();
                return;
            } else {
                tVar.skipFully(fVar.f70826h + fVar.f70827i);
                this.f70799i = tVar.getPosition();
                this.f70801k = this.f70791a.f70821c;
            }
        }
    }

    @Override // m5.g
    public void startSeek(long j11) {
        this.f70798h = u0.q(j11, 0L, this.f70796f - 1);
        this.f70795e = 2;
        this.f70799i = this.f70792b;
        this.f70800j = this.f70793c;
        this.f70801k = 0L;
        this.f70802l = this.f70796f;
    }
}
