package com.iab.omid.library.bytedance2.walking.async;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f42328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f42329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f42330e;

    public a(b.InterfaceC0470b interfaceC0470b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0470b);
        this.f42328c = new HashSet<>(hashSet);
        this.f42329d = jSONObject;
        this.f42330e = j11;
    }
}
