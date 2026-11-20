package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.q;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class l<T> extends q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.d f25431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<T> f25432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f25433c;

    public l(com.bykv.vk.openvk.preload.a.d dVar, q<T> qVar, Type type) {
        this.f25431a = dVar;
        this.f25432b = qVar;
        this.f25433c = type;
    }

    @Override // com.bykv.vk.openvk.preload.a.q
    public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        return this.f25432b.a(aVar);
    }

    @Override // com.bykv.vk.openvk.preload.a.q
    public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
        q<T> qVarA = this.f25432b;
        Type type = this.f25433c;
        if (t11 != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t11.getClass();
        }
        if (type != this.f25433c) {
            qVarA = this.f25431a.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type));
            if (qVarA instanceof h.a) {
                q<T> qVar = this.f25432b;
                if (!(qVar instanceof h.a)) {
                    qVarA = qVar;
                }
            }
        }
        qVarA.a(cVar, t11);
    }
}
