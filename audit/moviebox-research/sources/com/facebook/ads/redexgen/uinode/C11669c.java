package com.facebook.ads.redexgen.uinode;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11669c extends Exception {
    public final int A00;
    public final int A01;

    public C11669c(int i11, String str, Throwable th2, int i12) {
        super(str, th2);
        this.A01 = i11;
        this.A00 = i12;
    }

    public static C11669c A00(IOException iOException) {
        return new C11669c(0, null, iOException, -1);
    }

    public static C11669c A01(Exception exc, int i11) {
        return new C11669c(1, null, exc, i11);
    }

    public static C11669c A02(RuntimeException runtimeException) {
        return new C11669c(2, null, runtimeException, -1);
    }
}
