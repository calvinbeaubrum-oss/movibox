package com.bykv.vk.openvk.preload.a;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q<T> {
    public final q<T> a() {
        return new q<T>() { // from class: com.bykv.vk.openvk.preload.a.q.1
            @Override // com.bykv.vk.openvk.preload.a.q
            public final T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() != com.bykv.vk.openvk.preload.a.d.b.NULL) {
                    return (T) q.this.a(aVar);
                }
                aVar.j();
                return null;
            }

            @Override // com.bykv.vk.openvk.preload.a.q
            public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
                if (t11 == null) {
                    cVar.h();
                } else {
                    q.this.a(cVar, t11);
                }
            }
        };
    }

    public abstract T a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException;

    public abstract void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException;
}
