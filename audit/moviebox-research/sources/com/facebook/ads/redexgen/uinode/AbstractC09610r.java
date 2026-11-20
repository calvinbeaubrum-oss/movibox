package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC09610r {
    public static byte[] A04;
    public static String[] A05 = {"OqcLT37Xtir4oyEfNmT1h4Rk4YkQZZDY", "Uwe5RI", "pL0dXLjcEL0YvPTfwlaTsWSX1DbaAkE5", "xtw7OOYBvYdKgcW8WzcZrKA0PDZy4bwg", "f918FI", "0rYE8aKdqB5alUcDRGHr7byWf0zxjLED", "HJdrWZ0hD1uhwEG", "W2AWehjS6wPr2mpVEIqcODXDVwSDQEbA"};
    public boolean A00;
    public final C1795Yn A01;
    public final AbstractC09620s A02;
    public final RE A03;

    static {
        A01();
    }

    public AbstractC09610r(C1795Yn c1795Yn, AbstractC09620s abstractC09620s, RE re2) {
        this.A01 = c1795Yn;
        this.A02 = abstractC09620s;
        this.A03 = re2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 37);
            String[] strArr = A05;
            if (strArr[7].charAt(19) == strArr[3].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "ralyQsFIfJjHchT6ijaCYOn7xcrh9SYP";
            strArr2[0] = "lf1tsTh5P7IODA8hmkOKCVUdKtrYifbk";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-126, -90, -87, -85, -98, -84, -84, -94, -88, -89, 89, -91, -88, -96, -96, -98, -99};
    }

    public final void A02() {
        if (this.A00) {
            return;
        }
        AbstractC09620s abstractC09620s = this.A02;
        if (abstractC09620s != null) {
            abstractC09620s.A00();
        }
        A06(new C1508Ni().A03(this.A03).A05());
        this.A00 = true;
        L4.A02(this.A01, A00(0, 17, 20));
        AbstractC09620s abstractC09620s2 = this.A02;
    }

    public abstract void A06(Map<String, String> map);
}
