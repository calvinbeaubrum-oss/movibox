package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1 f16422b;

    /* JADX WARN: Multi-variable type inference failed */
    public q1(Context context, t0 t0Var, n0 n0Var) {
        this.f16421a = context;
        this.f16422b = new p1(this, null, n0Var, 0 == true ? 1 : 0);
    }

    public q1(Context context, v vVar, c cVar, n0 n0Var) {
        this.f16421a = context;
        this.f16422b = new p1(this, vVar, cVar, n0Var, null);
    }

    @Nullable
    public final t0 c() {
        p1.a(this.f16422b);
        return null;
    }

    @Nullable
    public final v d() {
        return this.f16422b.f16413a;
    }

    public final void e(boolean z11) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        this.f16421a.getApplicationContext().getPackageName();
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.f16422b.c(this.f16421a, intentFilter, null, null);
    }
}
