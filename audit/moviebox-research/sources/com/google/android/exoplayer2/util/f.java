package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f35557a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f35558b = {"", "A", "B", "C"};

    public static String a(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static List<byte[]> b(boolean z11) {
        return Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i11, boolean z11, int i12, int i13, int[] iArr, int i14) {
        Object[] objArr = new Object[5];
        objArr[0] = f35558b[i11];
        objArr[1] = Integer.valueOf(i12);
        objArr[2] = Integer.valueOf(i13);
        objArr[3] = Character.valueOf(z11 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i14);
        StringBuilder sb2 = new StringBuilder(o0.C("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i15 = 0; i15 < length; i15++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i15])));
        }
        return sb2.toString();
    }

    public static byte[] d(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = f35557a;
        byte[] bArr3 = new byte[bArr2.length + i12];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }

    public static int e(byte[] bArr, int i11) {
        int length = bArr.length - f35557a.length;
        while (i11 <= length) {
            if (g(bArr, i11)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static Pair<Integer, Integer> f(byte[] bArr) {
        boolean z11;
        c0 c0Var = new c0(bArr);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i12 + 3;
            if (i13 >= bArr.length) {
                z11 = false;
                break;
            }
            if (c0Var.G() == 1 && (bArr[i13] & 240) == 32) {
                z11 = true;
                break;
            }
            c0Var.P(c0Var.e() - 2);
            i12++;
        }
        a.b(z11, "Invalid input: VOL not found.");
        b0 b0Var = new b0(bArr);
        b0Var.r((i12 + 4) * 8);
        b0Var.r(1);
        b0Var.r(8);
        if (b0Var.g()) {
            b0Var.r(4);
            b0Var.r(3);
        }
        if (b0Var.h(4) == 15) {
            b0Var.r(8);
            b0Var.r(8);
        }
        if (b0Var.g()) {
            b0Var.r(2);
            b0Var.r(1);
            if (b0Var.g()) {
                b0Var.r(79);
            }
        }
        a.b(b0Var.h(2) == 0, "Only supports rectangular video object layer shape.");
        a.a(b0Var.g());
        int iH = b0Var.h(16);
        a.a(b0Var.g());
        if (b0Var.g()) {
            a.a(iH > 0);
            for (int i14 = iH - 1; i14 > 0; i14 >>= 1) {
                i11++;
            }
            b0Var.r(i11);
        }
        a.a(b0Var.g());
        int iH2 = b0Var.h(13);
        a.a(b0Var.g());
        int iH3 = b0Var.h(13);
        a.a(b0Var.g());
        b0Var.r(1);
        return Pair.create(Integer.valueOf(iH2), Integer.valueOf(iH3));
    }

    public static boolean g(byte[] bArr, int i11) {
        if (bArr.length - i11 <= f35557a.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = f35557a;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i11 + i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    public static Pair<Integer, Integer> h(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        c0Var.P(9);
        int iD = c0Var.D();
        c0Var.P(20);
        return Pair.create(Integer.valueOf(c0Var.H()), Integer.valueOf(iD));
    }

    public static boolean i(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    @Nullable
    public static byte[][] j(byte[] bArr) {
        if (!g(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iE = 0;
        do {
            arrayList.add(Integer.valueOf(iE));
            iE = e(bArr, iE + f35557a.length);
        } while (iE != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i11 = 0;
        while (i11 < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i11)).intValue();
            int iIntValue2 = (i11 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i11 + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i11] = bArr3;
            i11++;
        }
        return bArr2;
    }
}
