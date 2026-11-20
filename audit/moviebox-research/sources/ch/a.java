package ch;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.EOFException;
import java.io.IOException;
import tg.b0;
import tg.c0;
import tg.m;
import tg.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f14790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f14793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f14794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f14795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f14796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f14798l;

    /* JADX INFO: compiled from: source.java */
    public final class b implements b0 {
        public b() {
        }

        @Override // tg.b0
        public long getDurationUs() {
            return a.this.f14790d.b(a.this.f14792f);
        }

        @Override // tg.b0
        public b0.a getSeekPoints(long j11) {
            return new b0.a(new c0(j11, o0.r((a.this.f14788b + ((a.this.f14790d.c(j11) * (a.this.f14789c - a.this.f14788b)) / a.this.f14792f)) - 30000, a.this.f14788b, a.this.f14789c - 1)));
        }

        @Override // tg.b0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j11, long j12, long j13, long j14, boolean z11) {
        com.google.android.exoplayer2.util.a.a(j11 >= 0 && j12 > j11);
        this.f14790d = iVar;
        this.f14788b = j11;
        this.f14789c = j12;
        if (j13 == j12 - j11 || z11) {
            this.f14792f = j14;
            this.f14791e = 4;
        } else {
            this.f14791e = 0;
        }
        this.f14787a = new f();
    }

    @Override // ch.g
    public long a(m mVar) throws IOException {
        int i11 = this.f14791e;
        if (i11 == 0) {
            long position = mVar.getPosition();
            this.f14793g = position;
            this.f14791e = 1;
            long j11 = this.f14789c - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                long jG = g(mVar);
                if (jG != -1) {
                    return jG;
                }
                this.f14791e = 3;
            } else if (i11 != 3) {
                if (i11 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(mVar);
            this.f14791e = 4;
            return -(this.f14797k + 2);
        }
        this.f14792f = h(mVar);
        this.f14791e = 4;
        return this.f14793g;
    }

    @Override // ch.g
    @Nullable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f14792f != 0) {
            return new b();
        }
        return null;
    }

    public final long g(m mVar) throws IOException {
        if (this.f14795i == this.f14796j) {
            return -1L;
        }
        long position = mVar.getPosition();
        if (!this.f14787a.d(mVar, this.f14796j)) {
            long j11 = this.f14795i;
            if (j11 != position) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f14787a.a(mVar, false);
        mVar.resetPeekPosition();
        long j12 = this.f14794h;
        f fVar = this.f14787a;
        long j13 = fVar.f14817c;
        long j14 = j12 - j13;
        int i11 = fVar.f14822h + fVar.f14823i;
        if (0 <= j14 && j14 < 72000) {
            return -1L;
        }
        if (j14 < 0) {
            this.f14796j = position;
            this.f14798l = j13;
        } else {
            this.f14795i = mVar.getPosition() + ((long) i11);
            this.f14797k = this.f14787a.f14817c;
        }
        long j15 = this.f14796j;
        long j16 = this.f14795i;
        if (j15 - j16 < 100000) {
            this.f14796j = j16;
            return j16;
        }
        long position2 = mVar.getPosition() - (((long) i11) * (j14 <= 0 ? 2L : 1L));
        long j17 = this.f14796j;
        long j18 = this.f14795i;
        return o0.r(position2 + ((j14 * (j17 - j18)) / (this.f14798l - this.f14797k)), j18, j17 - 1);
    }

    public long h(m mVar) throws IOException {
        this.f14787a.b();
        if (!this.f14787a.c(mVar)) {
            throw new EOFException();
        }
        this.f14787a.a(mVar, false);
        f fVar = this.f14787a;
        mVar.skipFully(fVar.f14822h + fVar.f14823i);
        long j11 = this.f14787a.f14817c;
        while (true) {
            f fVar2 = this.f14787a;
            if ((fVar2.f14816b & 4) == 4 || !fVar2.c(mVar) || mVar.getPosition() >= this.f14789c || !this.f14787a.a(mVar, true)) {
                break;
            }
            f fVar3 = this.f14787a;
            if (!o.e(mVar, fVar3.f14822h + fVar3.f14823i)) {
                break;
            }
            j11 = this.f14787a.f14817c;
        }
        return j11;
    }

    public final void i(m mVar) throws IOException {
        while (true) {
            this.f14787a.c(mVar);
            this.f14787a.a(mVar, false);
            f fVar = this.f14787a;
            if (fVar.f14817c > this.f14794h) {
                mVar.resetPeekPosition();
                return;
            } else {
                mVar.skipFully(fVar.f14822h + fVar.f14823i);
                this.f14795i = mVar.getPosition();
                this.f14797k = this.f14787a.f14817c;
            }
        }
    }

    @Override // ch.g
    public void startSeek(long j11) {
        this.f14794h = o0.r(j11, 0L, this.f14792f - 1);
        this.f14791e = 2;
        this.f14795i = this.f14788b;
        this.f14796j = this.f14789c;
        this.f14797k = 0L;
        this.f14798l = this.f14792f;
    }
}
