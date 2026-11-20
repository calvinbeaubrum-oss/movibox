package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends TagPayloadReader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f33211e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f33213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f33214d;

    public a(e0 e0Var) {
        super(e0Var);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f33212b) {
            c0Var.Q(1);
        } else {
            int iD = c0Var.D();
            int i11 = (iD >> 4) & 15;
            this.f33214d = i11;
            if (i11 == 2) {
                this.f33210a.e(new m1.b().e0(MimeTypes.AUDIO_MPEG).H(1).f0(f33211e[(iD >> 2) & 3]).E());
                this.f33213c = true;
            } else if (i11 == 7 || i11 == 8) {
                this.f33210a.e(new m1.b().e0(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).H(1).f0(8000).E());
                this.f33213c = true;
            } else if (i11 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f33214d);
            }
            this.f33212b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j11) throws ParserException {
        if (this.f33214d == 2) {
            int iA = c0Var.a();
            this.f33210a.c(c0Var, iA);
            this.f33210a.d(j11, 1, iA, 0, null);
            return true;
        }
        int iD = c0Var.D();
        if (iD != 0 || this.f33213c) {
            if (this.f33214d == 10 && iD != 1) {
                return false;
            }
            int iA2 = c0Var.a();
            this.f33210a.c(c0Var, iA2);
            this.f33210a.d(j11, 1, iA2, 0, null);
            return true;
        }
        int iA3 = c0Var.a();
        byte[] bArr = new byte[iA3];
        c0Var.j(bArr, 0, iA3);
        com.google.android.exoplayer2.audio.a.b bVarF = com.google.android.exoplayer2.audio.a.f(bArr);
        this.f33210a.e(new m1.b().e0(MimeTypes.AUDIO_AAC).I(bVarF.f32772c).H(bVarF.f32771b).f0(bVarF.f32770a).T(Collections.singletonList(bArr)).E());
        this.f33213c = true;
        return false;
    }
}
