package v5;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.base.c;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.List;
import o5.e;
import o5.k;
import o5.r;
import o5.s;
import z3.c0;
import z3.h;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f78751a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f78752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f78755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f78756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f78757g;

    public a(List<byte[]> list) {
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.f78753c = 0;
            this.f78754d = -1;
            this.f78755e = C.SANS_SERIF_NAME;
            this.f78752b = false;
            this.f78756f = 0.85f;
            this.f78757g = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.f78753c = bArr[24];
        this.f78754d = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.f78755e = "Serif".equals(u0.I(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
        int i11 = bArr[25] * Ascii.DC4;
        this.f78757g = i11;
        boolean z11 = (bArr[0] & 32) != 0;
        this.f78752b = z11;
        if (z11) {
            this.f78756f = u0.o(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i11, 0.0f, 0.95f);
        } else {
            this.f78756f = 0.85f;
        }
    }

    public static void f(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    public static void g(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
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

    public static void h(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    public static String i(c0 c0Var) {
        z3.a.a(c0Var.a() >= 2);
        int iN = c0Var.N();
        if (iN == 0) {
            return "";
        }
        int iF = c0Var.f();
        Charset charsetP = c0Var.P();
        int iF2 = iN - (c0Var.f() - iF);
        if (charsetP == null) {
            charsetP = c.f38165c;
        }
        return c0Var.F(iF2, charsetP);
    }

    @Override // o5.s
    public /* synthetic */ void a(byte[] bArr, s.b bVar, h hVar) {
        r.a(this, bArr, bVar, hVar);
    }

    @Override // o5.s
    public /* synthetic */ k b(byte[] bArr, int i11, int i12) {
        return r.b(this, bArr, i11, i12);
    }

    @Override // o5.s
    public void c(byte[] bArr, int i11, int i12, s.b bVar, h<e> hVar) {
        this.f78751a.S(bArr, i11 + i12);
        this.f78751a.U(i11);
        String strI = i(this.f78751a);
        if (strI.isEmpty()) {
            hVar.accept(new e(ImmutableList.of(), C.TIME_UNSET, C.TIME_UNSET));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strI);
        g(spannableStringBuilder, this.f78753c, 0, 0, spannableStringBuilder.length(), 16711680);
        f(spannableStringBuilder, this.f78754d, -1, 0, spannableStringBuilder.length(), 16711680);
        h(spannableStringBuilder, this.f78755e, 0, spannableStringBuilder.length());
        float fO = this.f78756f;
        while (this.f78751a.a() >= 8) {
            int iF = this.f78751a.f();
            int iQ = this.f78751a.q();
            int iQ2 = this.f78751a.q();
            if (iQ2 == 1937013100) {
                z3.a.a(this.f78751a.a() >= 2);
                int iN = this.f78751a.N();
                for (int i13 = 0; i13 < iN; i13++) {
                    e(this.f78751a, spannableStringBuilder);
                }
            } else if (iQ2 == 1952608120 && this.f78752b) {
                z3.a.a(this.f78751a.a() >= 2);
                fO = u0.o(this.f78751a.N() / this.f78757g, 0.0f, 0.95f);
            }
            this.f78751a.U(iF + iQ);
        }
        hVar.accept(new e(ImmutableList.of(new y3.a.b().o(spannableStringBuilder).h(fO, 0).i(0).a()), C.TIME_UNSET, C.TIME_UNSET));
    }

    @Override // o5.s
    public int d() {
        return 2;
    }

    public final void e(c0 c0Var, SpannableStringBuilder spannableStringBuilder) {
        z3.a.a(c0Var.a() >= 12);
        int iN = c0Var.N();
        int iN2 = c0Var.N();
        c0Var.V(2);
        int iH = c0Var.H();
        c0Var.V(1);
        int iQ = c0Var.q();
        if (iN2 > spannableStringBuilder.length()) {
            o.h("Tx3gParser", "Truncating styl end (" + iN2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iN2 = spannableStringBuilder.length();
        }
        if (iN < iN2) {
            int i11 = iN2;
            g(spannableStringBuilder, iH, this.f78753c, iN, i11, 0);
            f(spannableStringBuilder, iQ, this.f78754d, iN, i11, 0);
            return;
        }
        o.h("Tx3gParser", "Ignoring styl with start (" + iN + ") >= end (" + iN2 + ").");
    }

    @Override // o5.s
    public /* synthetic */ void reset() {
        r.c(this);
    }
}
