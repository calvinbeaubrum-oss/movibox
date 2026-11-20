package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzaf;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f16315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f16316c;

    public c0(i iVar, String str, u uVar) {
        this.f16316c = iVar;
        this.f16314a = str;
        this.f16315b = uVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        e1 e1VarE = i.E(this.f16316c, this.f16314a, 9);
        if (e1VarE.b() != null) {
            this.f16315b.a(e1VarE.a(), e1VarE.b());
            return null;
        }
        this.f16315b.a(e1VarE.a(), zzaf.zzk());
        return null;
    }
}
