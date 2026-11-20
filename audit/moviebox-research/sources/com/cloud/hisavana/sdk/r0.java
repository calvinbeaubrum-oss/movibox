package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.activity.HisavanaSplashActivity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u1 f30008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HisavanaSplashActivity f30009b;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static r0 f30010a = new r0();
    }

    public r0() {
    }

    public static r0 e() {
        return b.f30010a;
    }

    public void a() {
        HisavanaSplashActivity hisavanaSplashActivity = this.f30009b;
        if (hisavanaSplashActivity == null || hisavanaSplashActivity.isDestroyed() || this.f30009b.isFinishing()) {
            return;
        }
        this.f30009b.finish();
    }

    public void b(HisavanaSplashActivity hisavanaSplashActivity) {
        this.f30009b = hisavanaSplashActivity;
    }

    public void c(u1 u1Var) {
        if (u1Var == null || u1Var.u0()) {
            return;
        }
        this.f30008a = u1Var;
    }

    public void d() {
        u1 u1Var = this.f30008a;
        if (u1Var != null) {
            u1Var.W();
        }
        this.f30009b = null;
        this.f30008a = null;
    }

    public u1 f() {
        return this.f30008a;
    }
}
