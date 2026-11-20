package b5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.y;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import l5.k;
import u4.l0;
import u4.m0;
import u4.r;
import u4.s;
import u4.t;
import u4.u;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f14011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14014e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f14016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f14017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f14018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public k f14019j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f14010a = new c0(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f14015f = -1;

    @Nullable
    public static MotionPhotoMetadata g(String str, long j11) throws IOException {
        c cVarA;
        if (j11 == -1 || (cVarA = f.a(str)) == null) {
            return null;
        }
        return cVarA.a(j11);
    }

    private void k(t tVar) throws IOException {
        String strB;
        if (this.f14013d == 65505) {
            c0 c0Var = new c0(this.f14014e);
            tVar.readFully(c0Var.e(), 0, this.f14014e);
            if (this.f14016g == null && "http://ns.adobe.com/xap/1.0/".equals(c0Var.B()) && (strB = c0Var.B()) != null) {
                MotionPhotoMetadata motionPhotoMetadataG = g(strB, tVar.getLength());
                this.f14016g = motionPhotoMetadataG;
                if (motionPhotoMetadataG != null) {
                    this.f14015f = motionPhotoMetadataG.videoStartPosition;
                }
            }
        } else {
            tVar.skipFully(this.f14014e);
        }
        this.f14012c = 0;
    }

    public final void a(t tVar) throws IOException {
        this.f14010a.Q(2);
        tVar.peekFully(this.f14010a.e(), 0, 2);
        tVar.advancePeekPosition(this.f14010a.N() - 2);
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        if (i(tVar) != 65496) {
            return false;
        }
        int i11 = i(tVar);
        this.f14013d = i11;
        if (i11 == 65504) {
            a(tVar);
            this.f14013d = i(tVar);
        }
        if (this.f14013d != 65505) {
            return false;
        }
        tVar.advancePeekPosition(2);
        this.f14010a.Q(6);
        tVar.peekFully(this.f14010a.e(), 0, 6);
        return this.f14010a.J() == 1165519206 && this.f14010a.N() == 0;
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        int i11 = this.f14012c;
        if (i11 == 0) {
            j(tVar);
            return 0;
        }
        if (i11 == 1) {
            l(tVar);
            return 0;
        }
        if (i11 == 2) {
            k(tVar);
            return 0;
        }
        if (i11 == 4) {
            long position = tVar.getPosition();
            long j11 = this.f14015f;
            if (position != j11) {
                l0Var.f78322a = j11;
                return 1;
            }
            m(tVar);
            return 0;
        }
        if (i11 != 5) {
            if (i11 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f14018i == null || tVar != this.f14017h) {
            this.f14017h = tVar;
            this.f14018i = new d(tVar, this.f14015f);
        }
        int iD = ((k) z3.a.e(this.f14019j)).d(this.f14018i, l0Var);
        if (iD == 1) {
            l0Var.f78322a += this.f14015f;
        }
        return iD;
    }

    public final void e() {
        ((u) z3.a.e(this.f14011b)).endTracks();
        this.f14011b.f(new m0.b(C.TIME_UNSET));
        this.f14012c = 6;
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f14011b = uVar;
    }

    public final void h(MotionPhotoMetadata motionPhotoMetadata) {
        ((u) z3.a.e(this.f14011b)).track(1024, 4).b(new y.b().O("image/jpeg").d0(new Metadata(motionPhotoMetadata)).I());
    }

    public final int i(t tVar) throws IOException {
        this.f14010a.Q(2);
        tVar.peekFully(this.f14010a.e(), 0, 2);
        return this.f14010a.N();
    }

    public final void j(t tVar) throws IOException {
        this.f14010a.Q(2);
        tVar.readFully(this.f14010a.e(), 0, 2);
        int iN = this.f14010a.N();
        this.f14013d = iN;
        if (iN == 65498) {
            if (this.f14015f != -1) {
                this.f14012c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((iN < 65488 || iN > 65497) && iN != 65281) {
            this.f14012c = 1;
        }
    }

    public final void l(t tVar) throws IOException {
        this.f14010a.Q(2);
        tVar.readFully(this.f14010a.e(), 0, 2);
        this.f14014e = this.f14010a.N() - 2;
        this.f14012c = 2;
    }

    public final void m(t tVar) throws IOException {
        if (!tVar.peekFully(this.f14010a.e(), 0, 1, true)) {
            e();
            return;
        }
        tVar.resetPeekPosition();
        if (this.f14019j == null) {
            this.f14019j = new k(o5.s.a.f72352a, 8);
        }
        d dVar = new d(tVar, this.f14015f);
        this.f14018i = dVar;
        if (!this.f14019j.b(dVar)) {
            e();
        } else {
            this.f14019j.f(new e(this.f14015f, (u) z3.a.e(this.f14011b)));
            n();
        }
    }

    public final void n() {
        h((MotionPhotoMetadata) z3.a.e(this.f14016g));
        this.f14012c = 5;
    }

    @Override // u4.s
    public void release() {
        k kVar = this.f14019j;
        if (kVar != null) {
            kVar.release();
        }
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f14012c = 0;
            this.f14019j = null;
        } else if (this.f14012c == 5) {
            ((k) z3.a.e(this.f14019j)).seek(j11, j12);
        }
    }
}
