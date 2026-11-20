package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import u4.r0;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends TagPayloadReader {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f11789e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11792d;

    public a(r0 r0Var) {
        super(r0Var);
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean b(c0 c0Var) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f11790b) {
            c0Var.V(1);
        } else {
            int iH = c0Var.H();
            int i11 = (iH >> 4) & 15;
            this.f11792d = i11;
            if (i11 == 2) {
                this.f11788a.b(new y.b().k0(MimeTypes.AUDIO_MPEG).L(1).l0(f11789e[(iH >> 2) & 3]).I());
                this.f11791c = true;
            } else if (i11 == 7 || i11 == 8) {
                this.f11788a.b(new y.b().k0(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW).L(1).l0(8000).I());
                this.f11791c = true;
            } else if (i11 != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f11792d);
            }
            this.f11790b = true;
        }
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    public boolean c(c0 c0Var, long j11) throws ParserException {
        if (this.f11792d == 2) {
            int iA = c0Var.a();
            this.f11788a.c(c0Var, iA);
            this.f11788a.f(j11, 1, iA, 0, null);
            return true;
        }
        int iH = c0Var.H();
        if (iH != 0 || this.f11791c) {
            if (this.f11792d == 10 && iH != 1) {
                return false;
            }
            int iA2 = c0Var.a();
            this.f11788a.c(c0Var, iA2);
            this.f11788a.f(j11, 1, iA2, 0, null);
            return true;
        }
        int iA3 = c0Var.a();
        byte[] bArr = new byte[iA3];
        c0Var.l(bArr, 0, iA3);
        u4.a.b bVarE = u4.a.e(bArr);
        this.f11788a.b(new y.b().k0(MimeTypes.AUDIO_AAC).M(bVarE.f78196c).L(bVarE.f78195b).l0(bVarE.f78194a).Y(Collections.singletonList(bArr)).I());
        this.f11791c = true;
        return false;
    }
}
