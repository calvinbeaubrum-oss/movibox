package com.google.common.primitives;

import com.google.common.base.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static int a(byte[] bArr, byte[] bArr2) {
        m.q(bArr, "array");
        m.q(bArr2, "target");
        if (bArr2.length == 0) {
            return 0;
        }
        for (int i11 = 0; i11 < (bArr.length - bArr2.length) + 1; i11++) {
            for (int i12 = 0; i12 < bArr2.length; i12++) {
                if (bArr[i11 + i12] != bArr2[i12]) {
                }
            }
            return i11;
        }
        return -1;
    }
}
