package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d1 f48730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f48731b;

    public c1(Context context, d1 d1Var) {
        this.f48730a = d1Var;
        this.f48731b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = l0.b();
        try {
            byte[] bArr = (byte[]) com.pgl.ssdk.ces.a.meta(301, this.f48731b, null);
            if (bArr == null || bArr.length <= 0) {
                b1.f48718a = 501;
                return;
            }
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            new e1(this.f48731b, null).a(1, 2, bArr);
            d1 d1Var = this.f48730a;
            if (d1Var != null) {
                d1Var.a(b1.a());
            }
        } catch (Throwable unused) {
            b1.f48718a = 501;
        }
    }
}
