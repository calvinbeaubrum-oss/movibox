package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import u4.d;
import u4.r0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f11793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f11794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11798g;

    public b(r0 r0Var) {
        super(r0Var);
        this.f11793b = new c0(a4.a.f366a);
        this.f11794c = new c0(4);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        int iH = c0Var.H();
        int i11 = (iH >> 4) & 15;
        int i12 = iH & 15;
        if (i12 == 7) {
            this.f11798g = i11;
            return i11 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i12);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j11) throws ParserException {
        int iH = c0Var.H();
        long jR = j11 + (((long) c0Var.r()) * 1000);
        if (iH == 0 && !this.f11796e) {
            c0 c0Var2 = new c0(new byte[c0Var.a()]);
            c0Var.l(c0Var2.e(), 0, c0Var.a());
            d dVarB = d.b(c0Var2);
            this.f11795d = dVarB.f78234b;
            this.f11788a.b(new y.b().k0(MimeTypes.VIDEO_H264).M(dVarB.f78243k).r0(dVarB.f78235c).V(dVarB.f78236d).g0(dVarB.f78242j).Y(dVarB.f78233a).I());
            this.f11796e = true;
            return false;
        }
        if (iH != 1 || !this.f11796e) {
            return false;
        }
        int i11 = this.f11798g == 1 ? 1 : 0;
        if (!this.f11797f && i11 == 0) {
            return false;
        }
        byte[] bArrE = this.f11794c.e();
        bArrE[0] = 0;
        bArrE[1] = 0;
        bArrE[2] = 0;
        int i12 = 4 - this.f11795d;
        int i13 = 0;
        while (c0Var.a() > 0) {
            c0Var.l(this.f11794c.e(), i12, this.f11795d);
            this.f11794c.U(0);
            int iL = this.f11794c.L();
            this.f11793b.U(0);
            this.f11788a.c(this.f11793b, 4);
            this.f11788a.c(c0Var, iL);
            i13 = i13 + 4 + iL;
        }
        this.f11788a.f(jR, i11, i13, 0, null);
        this.f11797f = true;
        return true;
    }
}
