package m5;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import u4.u0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public a f70848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f70849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f70850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public u0.c f70851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public u0.a f70852r;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u0.c f70853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u0.a f70854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f70855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final u0.b[] f70856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f70857e;

        public a(u0.c cVar, u0.a aVar, byte[] bArr, u0.b[] bVarArr, int i11) {
            this.f70853a = cVar;
            this.f70854b = aVar;
            this.f70855c = bArr;
            this.f70856d = bVarArr;
            this.f70857e = i11;
        }
    }

    public static void n(c0 c0Var, long j11) {
        if (c0Var.b() < c0Var.g() + 4) {
            c0Var.R(Arrays.copyOf(c0Var.e(), c0Var.g() + 4));
        } else {
            c0Var.T(c0Var.g() + 4);
        }
        byte[] bArrE = c0Var.e();
        bArrE[c0Var.g() - 4] = (byte) (j11 & 255);
        bArrE[c0Var.g() - 3] = (byte) ((j11 >>> 8) & 255);
        bArrE[c0Var.g() - 2] = (byte) ((j11 >>> 16) & 255);
        bArrE[c0Var.g() - 1] = (byte) ((j11 >>> 24) & 255);
    }

    public static int o(byte b11, a aVar) {
        return !aVar.f70856d[p(b11, aVar.f70857e, 1)].f78399a ? aVar.f70853a.f78409g : aVar.f70853a.f78410h;
    }

    public static int p(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    public static boolean r(c0 c0Var) {
        try {
            return u0.o(1, c0Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // m5.i
    public void e(long j11) {
        super.e(j11);
        this.f70850p = j11 != 0;
        u0.c cVar = this.f70851q;
        this.f70849o = cVar != null ? cVar.f78409g : 0;
    }

    @Override // m5.i
    public long f(c0 c0Var) {
        if ((c0Var.e()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(c0Var.e()[0], (a) z3.a.i(this.f70848n));
        long j11 = this.f70850p ? (this.f70849o + iO) / 4 : 0;
        n(c0Var, j11);
        this.f70850p = true;
        this.f70849o = iO;
        return j11;
    }

    @Override // m5.i
    public boolean i(c0 c0Var, long j11, i.b bVar) throws IOException {
        if (this.f70848n != null) {
            z3.a.e(bVar.f70846a);
            return false;
        }
        a aVarQ = q(c0Var);
        this.f70848n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        u0.c cVar = aVarQ.f70853a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar.f78412j);
        arrayList.add(aVarQ.f70855c);
        bVar.f70846a = new y.b().k0(MimeTypes.AUDIO_VORBIS).K(cVar.f78407e).f0(cVar.f78406d).L(cVar.f78404b).l0(cVar.f78405c).Y(arrayList).d0(u0.d(ImmutableList.copyOf(aVarQ.f70854b.f78397b))).I();
        return true;
    }

    @Override // m5.i
    public void l(boolean z11) {
        super.l(z11);
        if (z11) {
            this.f70848n = null;
            this.f70851q = null;
            this.f70852r = null;
        }
        this.f70849o = 0;
        this.f70850p = false;
    }

    @Nullable
    public a q(c0 c0Var) throws IOException {
        u0.c cVar = this.f70851q;
        if (cVar == null) {
            this.f70851q = u0.l(c0Var);
            return null;
        }
        u0.a aVar = this.f70852r;
        if (aVar == null) {
            this.f70852r = u0.j(c0Var);
            return null;
        }
        byte[] bArr = new byte[c0Var.g()];
        System.arraycopy(c0Var.e(), 0, bArr, 0, c0Var.g());
        u0.b[] bVarArrM = u0.m(c0Var, cVar.f78404b);
        return new a(cVar, aVar, bArr, bVarArrM, u0.b(bVarArrM.length - 1));
    }
}
