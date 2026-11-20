package com.pgl.ssdk;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e1 extends m0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Context f48773p;

    public e1(Context context, String str) {
        super(context, str);
        this.f48773p = context;
        this.f48796a = l0.b() + b();
    }

    @Override // com.pgl.ssdk.m0
    public boolean a(int i11, byte[] bArr) {
        try {
            Object objA = b1.a(bArr);
            if ((objA instanceof Integer) && ((Integer) objA).intValue() == 0) {
                b1.f48718a = 200;
                return true;
            }
            if (objA instanceof String) {
                b1.f48720c = (String) objA;
                b1.f48718a = 200;
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public String b() {
        return "?os=android&app_id=" + b1.f48719b + "&did=" + com.pgl.ssdk.ces.b.e() + "&app_ver=" + z.g(this.f48773p) + "&platform=android&ver=6.5.0.0.overseas-rc.1&mode=1";
    }
}
