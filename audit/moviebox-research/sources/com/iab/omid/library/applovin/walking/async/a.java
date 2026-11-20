package com.iab.omid.library.applovin.walking.async;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f42199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f42200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f42201e;

    public a(b.InterfaceC0466b interfaceC0466b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0466b);
        this.f42199c = new HashSet<>(hashSet);
        this.f42200d = jSONObject;
        this.f42201e = j11;
    }
}
