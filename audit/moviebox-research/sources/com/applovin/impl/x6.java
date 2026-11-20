package com.applovin.impl;

import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24264c;

    private x6(int i11, int i12, String str) {
        this.f24262a = i11;
        this.f24263b = i12;
        this.f24264c = str;
    }

    public static x6 a(bh bhVar) {
        String str;
        bhVar.g(2);
        int iW = bhVar.w();
        int i11 = iW >> 1;
        int iW2 = ((bhVar.w() >> 3) & 31) | ((iW & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else {
            if (i11 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(iW2 >= 10 ? InstructionFileId.DOT : ".0");
        sb2.append(iW2);
        return new x6(i11, iW2, sb2.toString());
    }
}
