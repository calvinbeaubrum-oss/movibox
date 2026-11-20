package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzl;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16321a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16322b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f16323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f16324d;

    public /* synthetic */ f0(i iVar, j jVar, e0 e0Var) {
        this.f16324d = iVar;
        this.f16323c = jVar;
    }

    public final /* synthetic */ Object a() throws Exception {
        Bundle bundle;
        int i11;
        int iZzv;
        synchronized (this.f16321a) {
            try {
                if (!this.f16322b) {
                    if (TextUtils.isEmpty(null)) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("accountName", null);
                    }
                    int i12 = 3;
                    try {
                        String packageName = this.f16324d.f16335e.getPackageName();
                        int i13 = 21;
                        iZzv = 3;
                        while (true) {
                            if (i13 < 3) {
                                i13 = 0;
                                break;
                            }
                            if (bundle == null) {
                                try {
                                    iZzv = this.f16324d.f16337g.zzv(i13, packageName, "subs");
                                } catch (Exception e11) {
                                    e = e11;
                                    i12 = iZzv;
                                    zzb.zzl("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                    this.f16324d.f16331a = 0;
                                    this.f16324d.f16337g = null;
                                    i11 = 42;
                                    iZzv = i12;
                                }
                            } else {
                                iZzv = this.f16324d.f16337g.zzc(i13, packageName, "subs", bundle);
                            }
                            if (iZzv == 0) {
                                zzb.zzj("BillingClient", "highestLevelSupportedForSubs: " + i13);
                                break;
                            }
                            i13--;
                        }
                        boolean z11 = true;
                        this.f16324d.f16340j = i13 >= 5;
                        this.f16324d.f16339i = i13 >= 3;
                        if (i13 < 3) {
                            zzb.zzj("BillingClient", "In-app billing API does not support subscription on this device.");
                            i11 = 9;
                        } else {
                            i11 = 1;
                        }
                        for (int i14 = 21; i14 >= 3; i14--) {
                            iZzv = bundle == null ? this.f16324d.f16337g.zzv(i14, packageName, "inapp") : this.f16324d.f16337g.zzc(i14, packageName, "inapp", bundle);
                            if (iZzv == 0) {
                                this.f16324d.f16341k = i14;
                                zzb.zzj("BillingClient", "mHighestLevelSupportedForInApp: " + this.f16324d.f16341k);
                                break;
                            }
                        }
                        i iVar = this.f16324d;
                        iVar.f16354x = iVar.f16341k >= 21;
                        i iVar2 = this.f16324d;
                        iVar2.f16353w = iVar2.f16341k >= 20;
                        i iVar3 = this.f16324d;
                        iVar3.f16352v = iVar3.f16341k >= 19;
                        i iVar4 = this.f16324d;
                        iVar4.f16351u = iVar4.f16341k >= 18;
                        i iVar5 = this.f16324d;
                        iVar5.f16350t = iVar5.f16341k >= 17;
                        i iVar6 = this.f16324d;
                        iVar6.f16349s = iVar6.f16341k >= 16;
                        i iVar7 = this.f16324d;
                        iVar7.f16348r = iVar7.f16341k >= 15;
                        i iVar8 = this.f16324d;
                        iVar8.f16347q = iVar8.f16341k >= 14;
                        i iVar9 = this.f16324d;
                        iVar9.f16346p = iVar9.f16341k >= 12;
                        i iVar10 = this.f16324d;
                        iVar10.f16345o = iVar10.f16341k >= 10;
                        i iVar11 = this.f16324d;
                        iVar11.f16344n = iVar11.f16341k >= 9;
                        i iVar12 = this.f16324d;
                        iVar12.f16343m = iVar12.f16341k >= 8;
                        i iVar13 = this.f16324d;
                        if (iVar13.f16341k < 6) {
                            z11 = false;
                        }
                        iVar13.f16342l = z11;
                        if (this.f16324d.f16341k < 3) {
                            zzb.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
                            i11 = 36;
                        }
                        if (iZzv == 0) {
                            this.f16324d.f16331a = 2;
                            if (this.f16324d.f16334d != null) {
                                q1 q1Var = this.f16324d.f16334d;
                                this.f16324d.f16335e.getPackageName();
                                q1Var.e(false);
                            }
                        } else {
                            this.f16324d.f16331a = 0;
                            this.f16324d.f16337g = null;
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                    if (iZzv == 0) {
                        this.f16324d.f16336f.c(m0.b(6));
                        c(p0.f16398l);
                    } else {
                        n0 n0Var = this.f16324d.f16336f;
                        n nVar = p0.f16387a;
                        n0Var.a(m0.a(i11, 6, nVar));
                        c(nVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return null;
    }

    public final /* synthetic */ void b() {
        this.f16324d.f16331a = 0;
        this.f16324d.f16337g = null;
        n0 n0Var = this.f16324d.f16336f;
        n nVar = p0.f16400n;
        n0Var.a(m0.a(24, 6, nVar));
        c(nVar);
    }

    public final void c(n nVar) {
        synchronized (this.f16321a) {
            try {
                j jVar = this.f16323c;
                if (jVar != null) {
                    jVar.a(nVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb.zzj("BillingClient", "Billing service connected.");
        this.f16324d.f16337g = zzl.zzr(iBinder);
        Callable callable = new Callable() { // from class: com.android.billingclient.api.d0
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f16317a.a();
                return null;
            }
        };
        Runnable runnable = new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.b();
            }
        };
        i iVar = this.f16324d;
        if (iVar.K(callable, 30000L, runnable, iVar.F()) == null) {
            i iVar2 = this.f16324d;
            n nVarI = iVar2.I();
            iVar2.f16336f.a(m0.a(25, 6, nVarI));
            c(nVarI);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzb.zzk("BillingClient", "Billing service disconnected.");
        this.f16324d.f16336f.b(zziz.zzw());
        this.f16324d.f16337g = null;
        this.f16324d.f16331a = 0;
        synchronized (this.f16321a) {
            try {
                j jVar = this.f16323c;
                if (jVar != null) {
                    jVar.b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
