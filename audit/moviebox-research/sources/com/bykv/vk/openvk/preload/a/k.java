package com.bykv.vk.openvk.preload.a;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.g<String, h> f25636a = new com.bykv.vk.openvk.preload.a.b.g<>();

    public final void a(String str, h hVar) {
        com.bykv.vk.openvk.preload.a.b.g<String, h> gVar = this.f25636a;
        if (hVar == null) {
            hVar = j.f25635a;
        }
        gVar.put(str, hVar);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof k) && ((k) obj).f25636a.equals(this.f25636a);
        }
        return true;
    }

    public final Set<Map.Entry<String, h>> g() {
        return this.f25636a.entrySet();
    }

    public final int hashCode() {
        return this.f25636a.hashCode();
    }
}
