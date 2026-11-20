package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum EnumC1958c9 {
    A06,
    A04,
    A05;

    public static byte[] A00;
    public static String[] A01 = {"api0z4PLINI5PK7LagBELyWT8AU4BGgW", "tmHanTUUlVK2", "u8tbQk2LTcb9GIJamNGwL98U9aG3b", "uEM1KGpibvzV", "W9EVcNIUBQlzdv120ZbDMEhAMhQyYGpr", "AlTJn44OR47d", "gBWp24bWtYCd", "71PlBcC0MYbUetiTqoYfalKEMb7tn"};
    public static final /* synthetic */ InterfaceC1327Ga A02;

    static {
        A01();
        A02 = AbstractC1952by.A01(A02());
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 71);
            String[] strArr = A01;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "DA30Z9K3Cvr4";
            strArr2[3] = "j8lODtrdRLA8";
            bArrCopyOfRange[i14] = b11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{109, 122, 122, 103, 122, 64, 65, 76, 76, 77, 70, 83, 69, 86, 74, 77, 74, 67};
    }
}
