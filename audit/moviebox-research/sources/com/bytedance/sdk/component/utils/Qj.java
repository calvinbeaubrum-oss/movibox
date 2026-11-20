package com.bytedance.sdk.component.utils;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private static final byte[] ExN;
    private static final byte[] TRI;
    private static final byte[] We;
    private static final byte[] pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static final int f27026qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final byte[] f27027sc;
    private static final byte[] zY;

    static {
        byte[] bArr = {-1, -40, -1};
        f27027sc = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
        pFF = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        zY = bArr3;
        byte[] bArrSc = sc("BM");
        We = bArrSc;
        ExN = sc("GIF87a");
        TRI = sc("GIF89a");
        f27026qr = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(bArrSc.length), 6))).intValue();
    }

    private static boolean ExN(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = We;
        return length >= bArr2.length && sc(bArr, bArr2);
    }

    private static boolean TRI(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = zY;
        return length >= bArr2.length && sc(bArr, bArr2);
    }

    private static boolean We(byte[] bArr) {
        return (bArr.length >= 6 && sc(bArr, ExN)) || sc(bArr, TRI);
    }

    private static boolean pFF(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f27027sc;
        return length >= bArr2.length && sc(bArr, bArr2);
    }

    public static int sc() {
        return f27026qr;
    }

    public static final String sc(byte[] bArr) {
        if (pFF(bArr)) {
            return "jpeg";
        }
        if (zY(bArr)) {
            return "png";
        }
        if (We(bArr)) {
            return "gif";
        }
        if (ExN(bArr)) {
            return "bmp";
        }
        return TRI(bArr) ? "ico" : "other";
    }

    private static boolean sc(byte[] bArr, byte[] bArr2) {
        return sc(bArr, bArr2, 0);
    }

    private static boolean sc(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr2.length + i11 > bArr.length) {
            return false;
        }
        for (int i12 = 0; i12 < bArr2.length; i12++) {
            if (bArr[i11 + i12] != bArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] sc(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException("ASCII not found!", e11);
        }
    }

    private static boolean zY(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = pFF;
        return length >= bArr2.length && sc(bArr, bArr2);
    }
}
