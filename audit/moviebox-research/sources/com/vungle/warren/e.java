package com.vungle.warren;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("settings")
    protected int f62009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("adSize")
    private AdConfig.AdSize f62010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f62011c;

    public e() {
    }

    public e(AdConfig.AdSize adSize) {
        this.f62010b = adSize;
    }

    public e(e eVar) {
        this(eVar.a());
        this.f62009a = eVar.b();
    }

    public AdConfig.AdSize a() {
        AdConfig.AdSize adSize = this.f62010b;
        return adSize == null ? AdConfig.AdSize.VUNGLE_DEFAULT : adSize;
    }

    public int b() {
        return this.f62009a;
    }

    public void c(AdConfig.AdSize adSize) {
        this.f62010b = adSize;
    }

    public void d(boolean z11) {
        if (z11) {
            this.f62009a |= 1;
        } else {
            this.f62009a &= -2;
        }
        this.f62011c = true;
    }
}
