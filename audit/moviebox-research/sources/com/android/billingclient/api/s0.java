package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zziv;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cg.g f16462b;

    public s0(Context context) {
        try {
            com.google.android.datatransport.runtime.t.f(context);
            this.f16462b = com.google.android.datatransport.runtime.t.c().g(dg.a.f63032g).b("PLAY_BILLING_LIBRARY", zziv.class, cg.c.b("proto"), new cg.f() { // from class: com.android.billingclient.api.r0
                @Override // cg.f
                public final Object apply(Object obj) {
                    return ((zziv) obj).zzc();
                }
            });
        } catch (Throwable unused) {
            this.f16461a = true;
        }
    }

    public final void a(zziv zzivVar) {
        if (this.f16461a) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f16462b.a(cg.d.e(zzivVar));
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}
