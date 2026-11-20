package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f21477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21479c;

    private oa(List list, int i11, String str) {
        this.f21477a = list;
        this.f21478b = i11;
        this.f21479c = str;
    }

    public static oa a(bh bhVar) throws dh {
        try {
            bhVar.g(21);
            int iW = bhVar.w() & 3;
            int iW2 = bhVar.w();
            int iD = bhVar.d();
            int i11 = 0;
            for (int i12 = 0; i12 < iW2; i12++) {
                bhVar.g(1);
                int iC = bhVar.C();
                for (int i13 = 0; i13 < iC; i13++) {
                    int iC2 = bhVar.C();
                    i11 += iC2 + 4;
                    bhVar.g(iC2);
                }
            }
            bhVar.f(iD);
            byte[] bArr = new byte[i11];
            String strA = null;
            int i14 = 0;
            for (int i15 = 0; i15 < iW2; i15++) {
                int iW3 = bhVar.w() & 127;
                int iC3 = bhVar.C();
                for (int i16 = 0; i16 < iC3; i16++) {
                    int iC4 = bhVar.C();
                    byte[] bArr2 = zf.f24845a;
                    System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                    int length = i14 + bArr2.length;
                    System.arraycopy(bhVar.c(), bhVar.d(), bArr, length, iC4);
                    if (iW3 == 33 && i16 == 0) {
                        strA = o3.a(new ch(bArr, length, length + iC4));
                    }
                    i14 = length + iC4;
                    bhVar.g(iC4);
                }
            }
            return new oa(i11 == 0 ? null : Collections.singletonList(bArr), iW + 1, strA);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw dh.a("Error parsing HEVC config", e11);
        }
    }
}
