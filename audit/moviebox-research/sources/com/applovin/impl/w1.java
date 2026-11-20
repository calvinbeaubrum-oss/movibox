package com.applovin.impl;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f24009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f24010f;

    private w1(List list, int i11, int i12, int i13, float f11, String str) {
        this.f24005a = list;
        this.f24006b = i11;
        this.f24007c = i12;
        this.f24008d = i13;
        this.f24009e = f11;
        this.f24010f = str;
    }

    private static byte[] a(bh bhVar) {
        int iC = bhVar.C();
        int iD = bhVar.d();
        bhVar.g(iC);
        return o3.a(bhVar.c(), iD, iC);
    }

    public static w1 b(bh bhVar) throws dh {
        String strA;
        int i11;
        int i12;
        float f11;
        try {
            bhVar.g(4);
            int iW = (bhVar.w() & 3) + 1;
            if (iW == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iW2 = bhVar.w() & 31;
            for (int i13 = 0; i13 < iW2; i13++) {
                arrayList.add(a(bhVar));
            }
            int iW3 = bhVar.w();
            for (int i14 = 0; i14 < iW3; i14++) {
                arrayList.add(a(bhVar));
            }
            if (iW2 > 0) {
                zf.b bVarC = zf.c((byte[]) arrayList.get(0), iW, ((byte[]) arrayList.get(0)).length);
                int i15 = bVarC.f24856e;
                int i16 = bVarC.f24857f;
                float f12 = bVarC.f24858g;
                strA = o3.a(bVarC.f24852a, bVarC.f24853b, bVarC.f24854c);
                i11 = i15;
                i12 = i16;
                f11 = f12;
            } else {
                strA = null;
                i11 = -1;
                i12 = -1;
                f11 = 1.0f;
            }
            return new w1(arrayList, iW, i11, i12, f11, strA);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw dh.a("Error parsing AVC config", e11);
        }
    }
}
