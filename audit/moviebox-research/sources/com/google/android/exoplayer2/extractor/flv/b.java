package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends TagPayloadReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f33215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f33216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f33217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f33218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f33219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33220g;

    public b(e0 e0Var) {
        super(e0Var);
        this.f33215b = new c0(x.f35652a);
        this.f33216c = new c0(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        int iD = c0Var.D();
        int i11 = (iD >> 4) & 15;
        int i12 = iD & 15;
        if (i12 == 7) {
            this.f33220g = i11;
            return i11 != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i12);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j11) throws ParserException {
        int iD = c0Var.D();
        long jO = j11 + (((long) c0Var.o()) * 1000);
        if (iD == 0 && !this.f33218e) {
            c0 c0Var2 = new c0(new byte[c0Var.a()]);
            c0Var.j(c0Var2.d(), 0, c0Var.a());
            com.google.android.exoplayer2.video.a aVarB = com.google.android.exoplayer2.video.a.b(c0Var2);
            this.f33217d = aVarB.f35711b;
            this.f33210a.e(new m1.b().e0(MimeTypes.VIDEO_H264).I(aVarB.f35715f).j0(aVarB.f35712c).Q(aVarB.f35713d).a0(aVarB.f35714e).T(aVarB.f35710a).E());
            this.f33218e = true;
            return false;
        }
        if (iD != 1 || !this.f33218e) {
            return false;
        }
        int i11 = this.f33220g == 1 ? 1 : 0;
        if (!this.f33219f && i11 == 0) {
            return false;
        }
        byte[] bArrD = this.f33216c.d();
        bArrD[0] = 0;
        bArrD[1] = 0;
        bArrD[2] = 0;
        int i12 = 4 - this.f33217d;
        int i13 = 0;
        while (c0Var.a() > 0) {
            c0Var.j(this.f33216c.d(), i12, this.f33217d);
            this.f33216c.P(0);
            int iH = this.f33216c.H();
            this.f33215b.P(0);
            this.f33210a.c(this.f33215b, 4);
            this.f33210a.c(c0Var, iH);
            i13 = i13 + 4 + iH;
        }
        this.f33210a.d(jO, i11, i13, 0, null);
        this.f33219f = true;
        return true;
    }
}
