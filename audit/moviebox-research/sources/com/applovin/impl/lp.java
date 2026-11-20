package com.applovin.impl;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class lp extends ek {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final bh f20498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f20499p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f20500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f20501r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f20502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final float f20503t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f20504u;

    public lp(List list) {
        super("Tx3gDecoder");
        this.f20498o = new bh();
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.f20500q = 0;
            this.f20501r = -1;
            this.f20502s = C.SANS_SERIF_NAME;
            this.f20499p = false;
            this.f20503t = 0.85f;
            this.f20504u = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.f20500q = bArr[24];
        this.f20501r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f20502s = "Serif".equals(xp.a(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * Ascii.DC4;
        this.f20504u = i11;
        boolean z11 = (bArr[0] & 32) != 0;
        this.f20499p = z11;
        if (z11) {
            this.f20503t = xp.a(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.0f, 0.95f);
        } else {
            this.f20503t = 0.85f;
        }
    }

    private static String a(bh bhVar) throws pl {
        char cF;
        a(bhVar.a() >= 2);
        int iC = bhVar.C();
        if (iC == 0) {
            return "";
        }
        return (bhVar.a() < 2 || !((cF = bhVar.f()) == 65279 || cF == 65534)) ? bhVar.a(iC, Charsets.UTF_8) : bhVar.a(iC, Charsets.UTF_16);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    private void a(bh bhVar, SpannableStringBuilder spannableStringBuilder) throws pl {
        a(bhVar.a() >= 12);
        int iC = bhVar.C();
        int iC2 = bhVar.C();
        bhVar.g(2);
        int iW = bhVar.w();
        bhVar.g(1);
        int iJ = bhVar.j();
        if (iC2 > spannableStringBuilder.length()) {
            pc.d("Tx3gDecoder", "Truncating styl end (" + iC2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iC2 = spannableStringBuilder.length();
        }
        if (iC < iC2) {
            int i11 = iC2;
            b(spannableStringBuilder, iW, this.f20500q, iC, i11, 0);
            a(spannableStringBuilder, iJ, this.f20501r, iC, i11, 0);
            return;
        }
        pc.d("Tx3gDecoder", "Ignoring styl with start (" + iC + ") >= end (" + iC2 + ").");
    }

    private static void a(boolean z11) throws pl {
        if (!z11) {
            throw new pl("Unexpected subtitle format.");
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            int i16 = i15 | 33;
            boolean z11 = (i11 & 1) != 0;
            boolean z12 = (i11 & 2) != 0;
            if (z11) {
                if (z12) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i13, i14, i16);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i13, i14, i16);
                }
            } else if (z12) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i13, i14, i16);
            }
            boolean z13 = (i11 & 4) != 0;
            if (z13) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, i14, i16);
            }
            if (z13 || z11 || z12) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i13, i14, i16);
        }
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) throws pl {
        this.f20498o.a(bArr, i11);
        String strA = a(this.f20498o);
        if (strA.isEmpty()) {
            return mp.f21189b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strA);
        b(spannableStringBuilder, this.f20500q, 0, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f20501r, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.f20502s, 0, spannableStringBuilder.length());
        float fA = this.f20503t;
        while (this.f20498o.a() >= 8) {
            int iD = this.f20498o.d();
            int iJ = this.f20498o.j();
            int iJ2 = this.f20498o.j();
            if (iJ2 == 1937013100) {
                a(this.f20498o.a() >= 2);
                int iC = this.f20498o.C();
                for (int i12 = 0; i12 < iC; i12++) {
                    a(this.f20498o, spannableStringBuilder);
                }
            } else if (iJ2 == 1952608120 && this.f20499p) {
                a(this.f20498o.a() >= 2);
                fA = xp.a(this.f20498o.C() / this.f20504u, 0.0f, 0.95f);
            }
            this.f20498o.f(iD + iJ);
        }
        return new mp(new b5.b().a(spannableStringBuilder).a(fA, 0).a(0).a());
    }
}
