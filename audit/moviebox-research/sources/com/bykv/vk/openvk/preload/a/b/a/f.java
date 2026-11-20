package com.bykv.vk.openvk.preload.a.b.a;

import com.bykv.vk.openvk.preload.a.o;
import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.b f25393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25394b = false;

    /* JADX INFO: compiled from: source.java */
    public final class a<K, V> extends q<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q<K> f25395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q<V> f25396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> f25397c;

        public a(com.bykv.vk.openvk.preload.a.d dVar, Type type, q<K> qVar, Type type2, q<V> qVar2, com.bykv.vk.openvk.preload.a.b.h<? extends Map<K, V>> hVar) {
            this.f25395a = new l(dVar, qVar, type);
            this.f25396b = new l(dVar, qVar2, type2);
            this.f25397c = hVar;
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
            com.bykv.vk.openvk.preload.a.d.b bVarF = aVar.f();
            if (bVarF == com.bykv.vk.openvk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> mapA = this.f25397c.a();
            if (bVarF == com.bykv.vk.openvk.preload.a.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K kA = this.f25395a.a(aVar);
                    if (mapA.put(kA, this.f25396b.a(aVar)) != null) {
                        throw new o("duplicate key: ".concat(String.valueOf(kA)));
                    }
                    aVar.b();
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.bykv.vk.openvk.preload.a.b.e.f25521a.a(aVar);
                    K kA2 = this.f25395a.a(aVar);
                    if (mapA.put(kA2, this.f25396b.a(aVar)) != null) {
                        throw new o("duplicate key: ".concat(String.valueOf(kA2)));
                    }
                }
                aVar.d();
            }
            return mapA;
        }

        @Override // com.bykv.vk.openvk.preload.a.q
        public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                cVar.h();
                return;
            }
            cVar.f();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                cVar.a(String.valueOf(entry.getKey()));
                this.f25396b.a(cVar, entry.getValue());
            }
            cVar.g();
        }
    }

    public f(com.bykv.vk.openvk.preload.a.b.b bVar) {
        this.f25393a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final <T> q<T> a(com.bykv.vk.openvk.preload.a.d dVar, com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        Type typeB = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] typeArrB = com.bykv.vk.openvk.preload.a.b.a.b(typeB, com.bykv.vk.openvk.preload.a.b.a.b(typeB));
        Type type = typeArrB[0];
        return new a(dVar, typeArrB[0], (type == Boolean.TYPE || type == Boolean.class) ? m.f25436c : dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(type)), typeArrB[1], dVar.a((com.bykv.vk.openvk.preload.a.c.a) com.bykv.vk.openvk.preload.a.c.a.a(typeArrB[1])), this.f25393a.a(aVar));
    }
}
