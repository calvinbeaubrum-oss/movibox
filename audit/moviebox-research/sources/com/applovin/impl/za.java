package com.applovin.impl;

import java.io.EOFException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f24829a = new bh(10);

    public bf a(l8 l8Var, xa.a aVar) {
        bf bfVarA = null;
        int i11 = 0;
        while (true) {
            try {
                l8Var.c(this.f24829a.c(), 0, 10);
                this.f24829a.f(0);
                if (this.f24829a.z() != 4801587) {
                    break;
                }
                this.f24829a.g(3);
                int iV = this.f24829a.v();
                int i12 = iV + 10;
                if (bfVarA == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.f24829a.c(), 0, bArr, 0, 10);
                    l8Var.c(bArr, 10, iV);
                    bfVarA = new xa(aVar).a(bArr, i12);
                } else {
                    l8Var.c(iV);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        l8Var.b();
        l8Var.c(i11);
        return bfVarA;
    }
}
