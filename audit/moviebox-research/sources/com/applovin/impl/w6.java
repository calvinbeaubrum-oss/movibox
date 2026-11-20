package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f24061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24064d;

    public w6(Object obj, long j11) {
        this.f24062b = obj;
        this.f24061a = j11;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) obj;
            this.f24063c = bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null;
            this.f24064d = "AppLovin";
        } else if (obj instanceof ge) {
            ge geVar = (ge) obj;
            this.f24063c = geVar.getFormat().getLabel();
            this.f24064d = geVar.getNetworkName();
        }
    }

    public Object a() {
        return this.f24062b;
    }

    public long b() {
        return this.f24061a;
    }

    public String c() {
        String str = this.f24063c;
        return str != null ? str : "Unknown";
    }

    public String d() {
        String str = this.f24064d;
        return str != null ? str : "Unknown";
    }
}
