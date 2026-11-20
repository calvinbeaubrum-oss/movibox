package dh;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements tg.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final tg.r f63094d = new tg.r() { // from class: dh.d
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return e.e();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f63095a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63096b = new com.google.android.exoplayer2.util.c0(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63097c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tg.l[] e() {
        return new tg.l[]{new e()};
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(10);
        int i11 = 0;
        while (true) {
            mVar.peekFully(c0Var.d(), 0, 10);
            c0Var.P(0);
            if (c0Var.G() != 4801587) {
                break;
            }
            c0Var.Q(3);
            int iC = c0Var.C();
            i11 += iC + 10;
            mVar.advancePeekPosition(iC);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i11);
        int i12 = i11;
        while (true) {
            int i13 = 0;
            while (true) {
                mVar.peekFully(c0Var.d(), 0, 7);
                c0Var.P(0);
                int iJ = c0Var.J();
                if (iJ == 44096 || iJ == 44097) {
                    i13++;
                    if (i13 >= 4) {
                        return true;
                    }
                    int iE = com.google.android.exoplayer2.audio.c.e(c0Var.d(), iJ);
                    if (iE == -1) {
                        return false;
                    }
                    mVar.advancePeekPosition(iE - 7);
                }
            }
            mVar.resetPeekPosition();
            i12++;
            if (i12 - i11 >= 8192) {
                return false;
            }
            mVar.advancePeekPosition(i12);
        }
    }

    @Override // tg.l
    public int c(tg.m mVar, tg.a0 a0Var) throws IOException {
        int i11 = mVar.read(this.f63096b.d(), 0, 16384);
        if (i11 == -1) {
            return -1;
        }
        this.f63096b.P(0);
        this.f63096b.O(i11);
        if (!this.f63097c) {
            this.f63095a.c(0L, 4);
            this.f63097c = true;
        }
        this.f63095a.b(this.f63096b);
        return 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f63095a.d(nVar, new i0.d(0, 1));
        nVar.endTracks();
        nVar.g(new tg.b0.b(C.TIME_UNSET));
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f63097c = false;
        this.f63095a.seek();
    }
}
