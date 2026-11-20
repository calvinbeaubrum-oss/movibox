package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f78272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f78278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f78279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f78280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f78281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f78282k;

    public g0(List<byte[]> list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f11, @Nullable String str) {
        this.f78272a = list;
        this.f78273b = i11;
        this.f78274c = i12;
        this.f78275d = i13;
        this.f78276e = i14;
        this.f78277f = i15;
        this.f78278g = i16;
        this.f78279h = i17;
        this.f78280i = i18;
        this.f78281j = f11;
        this.f78282k = str;
    }

    public static g0 a(z3.c0 c0Var) throws ParserException {
        try {
            c0Var.V(21);
            int iH = c0Var.H() & 3;
            int iH2 = c0Var.H();
            int iF = c0Var.f();
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < iH2; i13++) {
                c0Var.V(1);
                int iN = c0Var.N();
                for (int i14 = 0; i14 < iN; i14++) {
                    int iN2 = c0Var.N();
                    i12 += iN2 + 4;
                    c0Var.V(iN2);
                }
            }
            c0Var.U(iF);
            byte[] bArr = new byte[i12];
            String strC = null;
            int i15 = 0;
            int i16 = 0;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i21 = -1;
            int i22 = -1;
            int i23 = -1;
            int i24 = -1;
            float f11 = 1.0f;
            while (i15 < iH2) {
                int iH3 = c0Var.H() & 63;
                int iN3 = c0Var.N();
                int i25 = 0;
                while (i25 < iN3) {
                    int iN4 = c0Var.N();
                    byte[] bArr2 = a4.a.f366a;
                    int i26 = iH2;
                    System.arraycopy(bArr2, i11, bArr, i16, bArr2.length);
                    int length = i16 + bArr2.length;
                    System.arraycopy(c0Var.e(), c0Var.f(), bArr, length, iN4);
                    if (iH3 == 33 && i25 == 0) {
                        a4.a.C0019a c0019aH = a4.a.h(bArr, length, length + iN4);
                        int i27 = c0019aH.f380k;
                        i18 = c0019aH.f381l;
                        i19 = c0019aH.f375f + 8;
                        i21 = c0019aH.f376g + 8;
                        int i28 = c0019aH.f383n;
                        int i29 = c0019aH.f384o;
                        int i31 = c0019aH.f385p;
                        float f12 = c0019aH.f382m;
                        i17 = i27;
                        strC = z3.e.c(c0019aH.f370a, c0019aH.f371b, c0019aH.f372c, c0019aH.f373d, c0019aH.f377h, c0019aH.f378i);
                        i23 = i29;
                        i22 = i28;
                        f11 = f12;
                        i24 = i31;
                    }
                    i16 = length + iN4;
                    c0Var.V(iN4);
                    i25++;
                    iH2 = i26;
                    iH3 = iH3;
                    iN3 = iN3;
                    i11 = 0;
                }
                i15++;
                i11 = 0;
            }
            return new g0(i12 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iH + 1, i17, i18, i19, i21, i22, i23, i24, f11, strC);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e11);
        }
    }
}
