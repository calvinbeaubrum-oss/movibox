package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f35710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f35714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f35715f;

    public a(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str) {
        this.f35710a = list;
        this.f35711b = i11;
        this.f35712c = i12;
        this.f35713d = i13;
        this.f35714e = f11;
        this.f35715f = str;
    }

    public static byte[] a(c0 c0Var) {
        int iJ = c0Var.J();
        int iE = c0Var.e();
        c0Var.Q(iJ);
        return com.google.android.exoplayer2.util.f.d(c0Var.d(), iE, iJ);
    }

    public static a b(c0 c0Var) throws ParserException {
        String strA;
        int i11;
        int i12;
        float f11;
        try {
            c0Var.Q(4);
            int iD = (c0Var.D() & 3) + 1;
            if (iD == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iD2 = c0Var.D() & 31;
            for (int i13 = 0; i13 < iD2; i13++) {
                arrayList.add(a(c0Var));
            }
            int iD3 = c0Var.D();
            for (int i14 = 0; i14 < iD3; i14++) {
                arrayList.add(a(c0Var));
            }
            if (iD2 > 0) {
                com.google.android.exoplayer2.util.x.c cVarL = com.google.android.exoplayer2.util.x.l((byte[]) arrayList.get(0), iD, ((byte[]) arrayList.get(0)).length);
                int i15 = cVarL.f35674f;
                int i16 = cVarL.f35675g;
                float f12 = cVarL.f35676h;
                strA = com.google.android.exoplayer2.util.f.a(cVarL.f35669a, cVarL.f35670b, cVarL.f35671c);
                i11 = i15;
                i12 = i16;
                f11 = f12;
            } else {
                strA = null;
                i11 = -1;
                i12 = -1;
                f11 = 1.0f;
            }
            return new a(arrayList, iD, i11, i12, f11, strA);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedContainer("Error parsing AVC config", e11);
        }
    }
}
