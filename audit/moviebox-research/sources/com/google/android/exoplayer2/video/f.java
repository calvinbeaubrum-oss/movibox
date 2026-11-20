package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f35739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f35743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f35744f;

    public f(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str) {
        this.f35739a = list;
        this.f35740b = i11;
        this.f35741c = i12;
        this.f35742d = i13;
        this.f35743e = f11;
        this.f35744f = str;
    }

    public static f a(c0 c0Var) throws ParserException {
        try {
            c0Var.Q(21);
            int iD = c0Var.D() & 3;
            int iD2 = c0Var.D();
            int iE = c0Var.e();
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < iD2; i13++) {
                c0Var.Q(1);
                int iJ = c0Var.J();
                for (int i14 = 0; i14 < iJ; i14++) {
                    int iJ2 = c0Var.J();
                    i12 += iJ2 + 4;
                    c0Var.Q(iJ2);
                }
            }
            c0Var.P(iE);
            byte[] bArr = new byte[i12];
            String strC = null;
            int i15 = 0;
            int i16 = 0;
            int i17 = -1;
            int i18 = -1;
            float f11 = 1.0f;
            while (i15 < iD2) {
                int iD3 = c0Var.D() & 127;
                int iJ3 = c0Var.J();
                int i19 = 0;
                while (i19 < iJ3) {
                    int iJ4 = c0Var.J();
                    byte[] bArr2 = com.google.android.exoplayer2.util.x.f35652a;
                    int i21 = iD2;
                    System.arraycopy(bArr2, i11, bArr, i16, bArr2.length);
                    int length = i16 + bArr2.length;
                    System.arraycopy(c0Var.d(), c0Var.e(), bArr, length, iJ4);
                    if (iD3 == 33 && i19 == 0) {
                        com.google.android.exoplayer2.util.x.a aVarH = com.google.android.exoplayer2.util.x.h(bArr, length, length + iJ4);
                        int i22 = aVarH.f35663h;
                        i18 = aVarH.f35664i;
                        f11 = aVarH.f35665j;
                        i17 = i22;
                        strC = com.google.android.exoplayer2.util.f.c(aVarH.f35656a, aVarH.f35657b, aVarH.f35658c, aVarH.f35659d, aVarH.f35660e, aVarH.f35661f);
                    }
                    i16 = length + iJ4;
                    c0Var.Q(iJ4);
                    i19++;
                    iD2 = i21;
                    iD3 = iD3;
                    iJ3 = iJ3;
                    i11 = 0;
                }
                i15++;
                i11 = 0;
            }
            return new f(i12 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iD + 1, i17, i18, f11, strC);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e11);
        }
    }
}
