package dh;

import com.google.android.exoplayer2.m1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public tg.e0 f63344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63345c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f63347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f63348f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63343a = new com.google.android.exoplayer2.util.c0(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f63346d = C.TIME_UNSET;

    @Override // dh.m
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        com.google.android.exoplayer2.util.a.i(this.f63344b);
        if (this.f63345c) {
            int iA = c0Var.a();
            int i11 = this.f63348f;
            if (i11 < 10) {
                int iMin = Math.min(iA, 10 - i11);
                System.arraycopy(c0Var.d(), c0Var.e(), this.f63343a.d(), this.f63348f, iMin);
                if (this.f63348f + iMin == 10) {
                    this.f63343a.P(0);
                    if (73 != this.f63343a.D() || 68 != this.f63343a.D() || 51 != this.f63343a.D()) {
                        com.google.android.exoplayer2.util.s.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f63345c = false;
                        return;
                    } else {
                        this.f63343a.Q(3);
                        this.f63347e = this.f63343a.C() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f63347e - this.f63348f);
            this.f63344b.c(c0Var, iMin2);
            this.f63348f += iMin2;
        }
    }

    @Override // dh.m
    public void c(long j11, int i11) {
        if ((i11 & 4) == 0) {
            return;
        }
        this.f63345c = true;
        if (j11 != C.TIME_UNSET) {
            this.f63346d = j11;
        }
        this.f63347e = 0;
        this.f63348f = 0;
    }

    @Override // dh.m
    public void d(tg.n nVar, i0.d dVar) {
        dVar.a();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 5);
        this.f63344b = e0VarTrack;
        e0VarTrack.e(new m1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    @Override // dh.m
    public void packetFinished() {
        int i11;
        com.google.android.exoplayer2.util.a.i(this.f63344b);
        if (this.f63345c && (i11 = this.f63347e) != 0 && this.f63348f == i11) {
            long j11 = this.f63346d;
            if (j11 != C.TIME_UNSET) {
                this.f63344b.d(j11, 1, i11, 0, null);
            }
            this.f63345c = false;
        }
    }

    @Override // dh.m
    public void seek() {
        this.f63345c = false;
        this.f63346d = C.TIME_UNSET;
    }
}
