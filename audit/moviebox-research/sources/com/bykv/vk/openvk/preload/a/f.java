package com.bykv.vk.openvk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends h implements Iterable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<h> f25634a = new ArrayList();

    @Override // com.bykv.vk.openvk.preload.a.h
    public final Number a() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).a();
        }
        throw new IllegalStateException();
    }

    public final void a(h hVar) {
        if (hVar == null) {
            hVar = j.f25635a;
        }
        this.f25634a.add(hVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final String b() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final double c() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final long d() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final int e() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof f) && ((f) obj).f25634a.equals(this.f25634a);
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.preload.a.h
    public final boolean f() {
        if (this.f25634a.size() == 1) {
            return this.f25634a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return this.f25634a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<h> iterator() {
        return this.f25634a.iterator();
    }
}
