package com.google.android.datatransport.runtime;

import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements cg.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<cg.c> f32649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f32650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f32651c;

    public p(Set<cg.c> set, o oVar, s sVar) {
        this.f32649a = set;
        this.f32650b = oVar;
        this.f32651c = sVar;
    }

    @Override // cg.h
    public <T> cg.g<T> a(String str, Class<T> cls, cg.f<T, byte[]> fVar) {
        return b(str, cls, cg.c.b("proto"), fVar);
    }

    @Override // cg.h
    public <T> cg.g<T> b(String str, Class<T> cls, cg.c cVar, cg.f<T, byte[]> fVar) {
        if (this.f32649a.contains(cVar)) {
            return new r(this.f32650b, str, cVar, fVar, this.f32651c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f32649a));
    }
}
