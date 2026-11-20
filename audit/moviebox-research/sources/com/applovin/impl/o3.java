package com.applovin.impl;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f21454a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f21455b = {"", "A", "B", "C"};

    public static Pair a(byte[] bArr) {
        bh bhVar = new bh(bArr);
        bhVar.f(9);
        int iW = bhVar.w();
        bhVar.f(20);
        return Pair.create(Integer.valueOf(bhVar.A()), Integer.valueOf(iW));
    }

    public static String a(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static String a(ch chVar) {
        chVar.d(24);
        int iB = chVar.b(2);
        boolean zC = chVar.c();
        int iB2 = chVar.b(5);
        int i11 = 0;
        for (int i12 = 0; i12 < 32; i12++) {
            if (chVar.c()) {
                i11 |= 1 << i12;
            }
        }
        int i13 = 6;
        int[] iArr = new int[6];
        for (int i14 = 0; i14 < 6; i14++) {
            iArr[i14] = chVar.b(8);
        }
        int iB3 = chVar.b(8);
        Object[] objArr = new Object[5];
        objArr[0] = f21455b[iB];
        objArr[1] = Integer.valueOf(iB2);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = Character.valueOf(zC ? 'H' : 'L');
        objArr[4] = Integer.valueOf(iB3);
        StringBuilder sb2 = new StringBuilder(xp.a("hvc1.%s%d.%X.%c%d", objArr));
        while (i13 > 0 && iArr[i13 - 1] == 0) {
            i13--;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i15])));
        }
        return sb2.toString();
    }

    public static List a(boolean z11) {
        return Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
    }

    public static boolean a(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static byte[] a(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = f21454a;
        byte[] bArr3 = new byte[bArr2.length + i12];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }
}
