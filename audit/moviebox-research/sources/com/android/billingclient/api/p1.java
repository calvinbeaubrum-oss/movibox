package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzej;
import com.google.android.gms.internal.play_billing.zzhy;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f16413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f16414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q1 f16416d;

    public /* synthetic */ p1(q1 q1Var, t0 t0Var, n0 n0Var, n1 n1Var) {
        this.f16416d = q1Var;
        this.f16413a = null;
        this.f16414b = n0Var;
    }

    public /* synthetic */ p1(q1 q1Var, v vVar, c cVar, n0 n0Var, n1 n1Var) {
        this.f16416d = q1Var;
        this.f16413a = vVar;
        this.f16414b = n0Var;
    }

    public static /* bridge */ /* synthetic */ t0 a(p1 p1Var) {
        p1Var.getClass();
        return null;
    }

    public final synchronized void c(Context context, IntentFilter intentFilter, @Nullable String str, @Nullable IntentFilter intentFilter2) {
        try {
            if (this.f16415c) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.f16416d.f16422b, intentFilter, null, null, 2);
            } else {
                this.f16416d.f16421a.getApplicationContext().getPackageName();
                context.registerReceiver(this.f16416d.f16422b, intentFilter);
            }
            this.f16415c = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void d(Bundle bundle, n nVar, int i11) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") == null) {
            this.f16414b.a(m0.a(23, i11, nVar));
            return;
        }
        try {
            this.f16414b.a(zzhy.zzx(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzej.zza()));
        } catch (Throwable unused) {
            zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        int i11 = 1;
        if (extras == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            n0 n0Var = this.f16414b;
            n nVar = p0.f16396j;
            n0Var.a(m0.a(11, 1, nVar));
            v vVar = this.f16413a;
            if (vVar != null) {
                vVar.a(nVar, null);
                return;
            }
            return;
        }
        n nVarZze = zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        String string = extras.getString("INTENT_SOURCE");
        if (string == "LAUNCH_BILLING_FLOW" || (string != null && string.equals("LAUNCH_BILLING_FLOW"))) {
            i11 = 2;
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List<Purchase> listZzi = zzb.zzi(extras);
            if (nVarZze.b() == 0) {
                this.f16414b.c(m0.b(i11));
            } else {
                d(extras, nVarZze, i11);
            }
            this.f16413a.a(nVarZze, listZzi);
            return;
        }
        if (action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
            if (nVarZze.b() != 0) {
                d(extras, nVarZze, i11);
                this.f16413a.a(nVarZze, zzaf.zzk());
                return;
            }
            zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            n0 n0Var2 = this.f16414b;
            n nVar2 = p0.f16396j;
            n0Var2.a(m0.a(77, i11, nVar2));
            this.f16413a.a(nVar2, zzaf.zzk());
        }
    }
}
