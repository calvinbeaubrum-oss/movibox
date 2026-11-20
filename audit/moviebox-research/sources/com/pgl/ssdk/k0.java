package com.pgl.ssdk;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class k0 extends m0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Context f48789p;

    public k0(Context context, String str) {
        super(context, str);
        this.f48789p = context;
        this.f48796a = l0.a() + b();
    }

    @Override // com.pgl.ssdk.m0
    public boolean a(int i11, byte[] bArr) {
        if (i11 == 200 && bArr != null) {
            try {
                if (bArr.length > 0) {
                    if (((Integer) com.pgl.ssdk.ces.a.meta(223, null, bArr)).intValue() == 0) {
                        com.pgl.ssdk.ces.b.f48732a = true;
                    } else {
                        com.pgl.ssdk.ces.b.f48732a = false;
                    }
                }
            } catch (Throwable unused) {
                com.pgl.ssdk.ces.b.f48732a = false;
            }
        }
        return true;
    }

    public String b() {
        return ((("?os=0&ver=6.5.0.0.overseas-rc.1&mode=1&app_ver=" + String.valueOf(z.g(this.f48789p))) + "&region=" + b0.a()) + "&did=" + com.pgl.ssdk.ces.b.e()) + "&aid=" + com.pgl.ssdk.ces.b.d();
    }
}
