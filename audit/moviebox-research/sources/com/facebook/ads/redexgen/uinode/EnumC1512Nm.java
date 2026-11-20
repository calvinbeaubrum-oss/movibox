package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1512Nm {
    A06(0),
    A05(1),
    A04(2);

    public static byte[] A01;
    public static String[] A02 = {"rZGvvZMI6I", "wpdicw5jfWUP9Cs9nncu65zzvPXSjTXh", "qXEMgnv7Ct425l7In8PWxhOPFYVbEYpB", "dTodKdBY68fO6HNBSU3LN7qZJ4nOCEpk", "Hkjhu", "mY7TKQYFYXm3BBS2pDypGTbdY20sKsEk", "u0FGaDIimXxXG0l3UqPLAtx16Sc8Y059", "GEphX9PDUn8ir5euMIdeMTZrm9gVIFzw"};
    public int A00;

    static {
        A02();
    }

    EnumC1512Nm(int i11) {
        this.A00 = i11;
    }

    public static EnumC1512Nm A00(int i11) throws CloneNotSupportedException {
        for (EnumC1512Nm enumC1512Nm : valuesCustom()) {
            if (enumC1512Nm.A00 == i11) {
                return enumC1512Nm;
            }
        }
        return A05;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{46, 35, 44, 38, 49, 33, 35, 50, 39, 77, 82, 79, 73, 79, 92, 84, 73, 102, 125, 96, 99, 118, 112, 122, 117, 122, 118, 119};
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1512Nm[] valuesCustom() throws CloneNotSupportedException {
        Object objClone = values().clone();
        if (A02[4].length() == 18) {
            throw new RuntimeException();
        }
        A02[4] = "9YF3oPenjmVnddjujEMQmJq4m";
        return (EnumC1512Nm[]) objClone;
    }

    public final int A03() {
        return this.A00;
    }
}
