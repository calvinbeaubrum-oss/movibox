package com.android.billingclient.api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16466a;

    public /* synthetic */ v0(u0 u0Var) {
    }

    public final v0 a() {
        this.f16466a = true;
        return this;
    }

    public final x0 b() {
        if (this.f16466a) {
            return new x0(true, false, null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
