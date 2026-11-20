package di;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.common.base.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;
import vh.h;
import vh.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f63412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f63413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f63414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f63415r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f63416s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f63417t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f63418u;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.f63412o = new c0();
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f63414q = 0;
            this.f63415r = -1;
            this.f63416s = C.SANS_SERIF_NAME;
            this.f63413p = false;
            this.f63417t = 0.85f;
            this.f63418u = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f63414q = bArr[24];
        this.f63415r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f63416s = "Serif".equals(o0.E(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * Ascii.DC4;
        this.f63418u = i11;
        boolean z11 = (bArr[0] & 32) != 0;
        this.f63413p = z11;
        if (z11) {
            this.f63417t = o0.p(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.0f, 0.95f);
        } else {
            this.f63417t = 0.85f;
        }
    }

    public static void A(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
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

    public static void B(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    public static String C(c0 c0Var) throws SubtitleDecoderException {
        char cG;
        y(c0Var.a() >= 2);
        int iJ = c0Var.J();
        if (iJ == 0) {
            return "";
        }
        return (c0Var.a() < 2 || !((cG = c0Var.g()) == 65279 || cG == 65534)) ? c0Var.B(iJ, c.f38165c) : c0Var.B(iJ, c.f38168f);
    }

    public static void y(boolean z11) throws SubtitleDecoderException {
        if (!z11) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void z(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    @Override // vh.h
    public i w(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.f63412o.N(bArr, i11);
        String strC = C(this.f63412o);
        if (strC.isEmpty()) {
            return b.f63419b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strC);
        A(spannableStringBuilder, this.f63414q, 0, 0, spannableStringBuilder.length(), 16711680);
        z(spannableStringBuilder, this.f63415r, -1, 0, spannableStringBuilder.length(), 16711680);
        B(spannableStringBuilder, this.f63416s, 0, spannableStringBuilder.length());
        float fP = this.f63417t;
        while (this.f63412o.a() >= 8) {
            int iE = this.f63412o.e();
            int iN = this.f63412o.n();
            int iN2 = this.f63412o.n();
            if (iN2 == 1937013100) {
                y(this.f63412o.a() >= 2);
                int iJ = this.f63412o.J();
                for (int i12 = 0; i12 < iJ; i12++) {
                    x(this.f63412o, spannableStringBuilder);
                }
            } else if (iN2 == 1952608120 && this.f63413p) {
                y(this.f63412o.a() >= 2);
                fP = o0.p(this.f63412o.J() / this.f63418u, 0.0f, 0.95f);
            }
            this.f63412o.P(iE + iN);
        }
        return new b(new vh.b.C0875b().o(spannableStringBuilder).h(fP, 0).i(0).a());
    }

    public final void x(c0 c0Var, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        y(c0Var.a() >= 12);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        c0Var.Q(2);
        int iD = c0Var.D();
        c0Var.Q(1);
        int iN = c0Var.n();
        if (iJ2 > spannableStringBuilder.length()) {
            s.i("Tx3gDecoder", "Truncating styl end (" + iJ2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iJ2 = spannableStringBuilder.length();
        }
        if (iJ < iJ2) {
            int i11 = iJ2;
            A(spannableStringBuilder, iD, this.f63414q, iJ, i11, 0);
            z(spannableStringBuilder, iN, this.f63415r, iJ, i11, 0);
            return;
        }
        s.i("Tx3gDecoder", "Ignoring styl with start (" + iJ + ") >= end (" + iJ2 + ").");
    }
}
