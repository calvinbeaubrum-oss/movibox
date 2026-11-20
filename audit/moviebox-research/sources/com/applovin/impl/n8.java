package com.applovin.impl;

import java.io.EOFException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n8 {
    public static int a(l8 l8Var, byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int iB = l8Var.b(bArr, i11 + i13, i12 - i13);
            if (iB == -1) {
                break;
            }
            i13 += iB;
        }
        return i13;
    }

    public static void a(boolean z11, String str) throws dh {
        if (!z11) {
            throw dh.a(str, null);
        }
    }

    public static boolean a(l8 l8Var, int i11) {
        try {
            l8Var.a(i11);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean a(l8 l8Var, byte[] bArr, int i11, int i12, boolean z11) throws EOFException {
        try {
            return l8Var.b(bArr, i11, i12, z11);
        } catch (EOFException e11) {
            if (z11) {
                return false;
            }
            throw e11;
        }
    }

    public static boolean b(l8 l8Var, byte[] bArr, int i11, int i12) {
        try {
            l8Var.d(bArr, i11, i12);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
