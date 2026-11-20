package com.cloud.tmc.miniutils.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f31999a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f32000b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte a(char c11) {
        return (byte) "0123456789ABCDEF".indexOf(c11);
    }

    public static String b(byte[] bArr) {
        return c(bArr, false);
    }

    public static String c(byte[] bArr, boolean z11) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb2.append(hexString);
            if (z11) {
                sb2.append(" ");
            }
        }
        return sb2.toString().trim();
    }

    public static byte[] d(String str) {
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String upperCase = str.trim().toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((a(charArray[i12 + 1]) & 255) | (a(charArray[i12]) << 4));
        }
        return bArr;
    }
}
