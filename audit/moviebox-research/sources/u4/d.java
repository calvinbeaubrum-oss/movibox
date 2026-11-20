package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f78233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f78237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f78238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f78239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f78240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f78241i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f78242j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public final String f78243k;

    public d(List<byte[]> list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f11, @Nullable String str) {
        this.f78233a = list;
        this.f78234b = i11;
        this.f78235c = i12;
        this.f78236d = i13;
        this.f78237e = i14;
        this.f78238f = i15;
        this.f78239g = i16;
        this.f78240h = i17;
        this.f78241i = i18;
        this.f78242j = f11;
        this.f78243k = str;
    }

    public static byte[] a(z3.c0 c0Var) {
        int iN = c0Var.N();
        int iF = c0Var.f();
        c0Var.V(iN);
        return z3.e.d(c0Var.e(), iF, iN);
    }

    public static d b(z3.c0 c0Var) throws ParserException {
        String strA;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f11;
        try {
            c0Var.V(4);
            int iH = (c0Var.H() & 3) + 1;
            if (iH == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iH2 = c0Var.H() & 31;
            for (int i18 = 0; i18 < iH2; i18++) {
                arrayList.add(a(c0Var));
            }
            int iH3 = c0Var.H();
            for (int i19 = 0; i19 < iH3; i19++) {
                arrayList.add(a(c0Var));
            }
            if (iH2 > 0) {
                a4.a.c cVarL = a4.a.l((byte[]) arrayList.get(0), iH, ((byte[]) arrayList.get(0)).length);
                int i21 = cVarL.f394f;
                int i22 = cVarL.f395g;
                int i23 = cVarL.f397i + 8;
                int i24 = cVarL.f398j + 8;
                int i25 = cVarL.f405q;
                int i26 = cVarL.f406r;
                int i27 = cVarL.f407s;
                float f12 = cVarL.f396h;
                strA = z3.e.a(cVarL.f389a, cVarL.f390b, cVarL.f391c);
                i16 = i26;
                i17 = i27;
                f11 = f12;
                i13 = i23;
                i14 = i24;
                i15 = i25;
                i11 = i21;
                i12 = i22;
            } else {
                strA = null;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = -1;
                i16 = -1;
                i17 = -1;
                f11 = 1.0f;
            }
            return new d(arrayList, iH, i11, i12, i13, i14, i15, i16, i17, f11, strA);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e11);
        }
    }
}
