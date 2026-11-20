package yg;

import androidx.annotation.Nullable;
import bh.k;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.c0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import tg.a0;
import tg.b0;
import tg.l;
import tg.m;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f81326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f81327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f81328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f81329e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f81331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f81332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f81333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public k f81334j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f81325a = new c0(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f81330f = -1;

    @Nullable
    public static MotionPhotoMetadata f(String str, long j11) throws IOException {
        b bVarA;
        if (j11 == -1 || (bVarA = e.a(str)) == null) {
            return null;
        }
        return bVarA.a(j11);
    }

    public final void a(m mVar) throws IOException {
        this.f81325a.L(2);
        mVar.peekFully(this.f81325a.d(), 0, 2);
        mVar.advancePeekPosition(this.f81325a.J() - 2);
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        if (h(mVar) != 65496) {
            return false;
        }
        int iH = h(mVar);
        this.f81328d = iH;
        if (iH == 65504) {
            a(mVar);
            this.f81328d = h(mVar);
        }
        if (this.f81328d != 65505) {
            return false;
        }
        mVar.advancePeekPosition(2);
        this.f81325a.L(6);
        mVar.peekFully(this.f81325a.d(), 0, 6);
        return this.f81325a.F() == 1165519206 && this.f81325a.J() == 0;
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        int i11 = this.f81327c;
        if (i11 == 0) {
            i(mVar);
            return 0;
        }
        if (i11 == 1) {
            k(mVar);
            return 0;
        }
        if (i11 == 2) {
            j(mVar);
            return 0;
        }
        if (i11 == 4) {
            long position = mVar.getPosition();
            long j11 = this.f81330f;
            if (position != j11) {
                a0Var.f76990a = j11;
                return 1;
            }
            l(mVar);
            return 0;
        }
        if (i11 != 5) {
            if (i11 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f81333i == null || mVar != this.f81332h) {
            this.f81332h = mVar;
            this.f81333i = new c(mVar, this.f81330f);
        }
        int iC = ((k) com.google.android.exoplayer2.util.a.e(this.f81334j)).c(this.f81333i, a0Var);
        if (iC == 1) {
            a0Var.f76990a += this.f81330f;
        }
        return iC;
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f81326b = nVar;
    }

    public final void e() {
        g(new Metadata.Entry[0]);
        ((n) com.google.android.exoplayer2.util.a.e(this.f81326b)).endTracks();
        this.f81326b.g(new b0.b(C.TIME_UNSET));
        this.f81327c = 6;
    }

    public final void g(Metadata.Entry... entryArr) {
        ((n) com.google.android.exoplayer2.util.a.e(this.f81326b)).track(1024, 4).e(new m1.b().K("image/jpeg").X(new Metadata(entryArr)).E());
    }

    public final int h(m mVar) throws IOException {
        this.f81325a.L(2);
        mVar.peekFully(this.f81325a.d(), 0, 2);
        return this.f81325a.J();
    }

    public final void i(m mVar) throws IOException {
        this.f81325a.L(2);
        mVar.readFully(this.f81325a.d(), 0, 2);
        int iJ = this.f81325a.J();
        this.f81328d = iJ;
        if (iJ == 65498) {
            if (this.f81330f != -1) {
                this.f81327c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((iJ < 65488 || iJ > 65497) && iJ != 65281) {
            this.f81327c = 1;
        }
    }

    public final void j(m mVar) throws IOException {
        String strX;
        if (this.f81328d == 65505) {
            c0 c0Var = new c0(this.f81329e);
            mVar.readFully(c0Var.d(), 0, this.f81329e);
            if (this.f81331g == null && "http://ns.adobe.com/xap/1.0/".equals(c0Var.x()) && (strX = c0Var.x()) != null) {
                MotionPhotoMetadata motionPhotoMetadataF = f(strX, mVar.getLength());
                this.f81331g = motionPhotoMetadataF;
                if (motionPhotoMetadataF != null) {
                    this.f81330f = motionPhotoMetadataF.videoStartPosition;
                }
            }
        } else {
            mVar.skipFully(this.f81329e);
        }
        this.f81327c = 0;
    }

    public final void k(m mVar) throws IOException {
        this.f81325a.L(2);
        mVar.readFully(this.f81325a.d(), 0, 2);
        this.f81329e = this.f81325a.J() - 2;
        this.f81327c = 2;
    }

    public final void l(m mVar) throws IOException {
        if (!mVar.peekFully(this.f81325a.d(), 0, 1, true)) {
            e();
            return;
        }
        mVar.resetPeekPosition();
        if (this.f81334j == null) {
            this.f81334j = new k();
        }
        c cVar = new c(mVar, this.f81330f);
        this.f81333i = cVar;
        if (!this.f81334j.b(cVar)) {
            e();
        } else {
            this.f81334j.d(new d(this.f81330f, (n) com.google.android.exoplayer2.util.a.e(this.f81326b)));
            m();
        }
    }

    public final void m() {
        g((Metadata.Entry) com.google.android.exoplayer2.util.a.e(this.f81331g));
        this.f81327c = 5;
    }

    @Override // tg.l
    public void release() {
        k kVar = this.f81334j;
        if (kVar != null) {
            kVar.release();
        }
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        if (j11 == 0) {
            this.f81327c = 0;
            this.f81334j = null;
        } else if (this.f81327c == 5) {
            ((k) com.google.android.exoplayer2.util.a.e(this.f81334j)).seek(j11, j12);
        }
    }
}
