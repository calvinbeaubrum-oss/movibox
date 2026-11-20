package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.q;
import com.bykv.vk.openvk.preload.a.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements r, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f25508a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f25509b = -1.0d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25510c = 136;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f25511d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.bykv.vk.openvk.preload.geckox.a.a.c> f25512e = Collections.emptyList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.bykv.vk.openvk.preload.geckox.a.a.c> f25513f = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.c cVar) {
        return cVar == null || cVar.a() <= this.f25509b;
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.c cVar, com.bykv.vk.openvk.preload.a.a.d dVar) {
        return a(cVar) && a(dVar);
    }

    private boolean a(com.bykv.vk.openvk.preload.a.a.d dVar) {
        return dVar == null || dVar.a() > this.f25509b;
    }

    private boolean a(Class<?> cls) {
        if (this.f25509b == -1.0d || a((com.bykv.vk.openvk.preload.a.a.c) cls.getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class), (com.bykv.vk.openvk.preload.a.a.d) cls.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class))) {
            return (!this.f25511d && c(cls)) || b(cls);
        }
        return true;
    }

    private boolean a(boolean z11) {
        Iterator<com.bykv.vk.openvk.preload.geckox.a.a.c> it = (z11 ? this.f25512e : this.f25513f).iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private static boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private static boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final <T> q<T> a(final com.bykv.vk.openvk.preload.a.d dVar, final com.bykv.vk.openvk.preload.a.c.a<T> aVar) {
        boolean zA = a(aVar.a());
        final boolean z11 = zA || a(true);
        final boolean z12 = zA || a(false);
        if (z11 || z12) {
            return new q<T>() { // from class: com.bykv.vk.openvk.preload.a.b.c.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private q<T> f25514a;

                private q<T> b() {
                    q<T> qVar = this.f25514a;
                    if (qVar != null) {
                        return qVar;
                    }
                    q<T> qVarA = dVar.a(c.this, aVar);
                    this.f25514a = qVarA;
                    return qVarA;
                }

                @Override // com.bykv.vk.openvk.preload.a.q
                public final T a(com.bykv.vk.openvk.preload.a.d.a aVar2) throws IOException {
                    if (!z12) {
                        return b().a(aVar2);
                    }
                    aVar2.n();
                    return null;
                }

                @Override // com.bykv.vk.openvk.preload.a.q
                public final void a(com.bykv.vk.openvk.preload.a.d.c cVar, T t11) throws IOException {
                    if (z11) {
                        cVar.h();
                    } else {
                        b().a(cVar, t11);
                    }
                }
            };
        }
        return null;
    }

    public final boolean a(Class<?> cls, boolean z11) {
        return a(cls) || a(z11);
    }

    public final boolean a(Field field, boolean z11) {
        if ((this.f25510c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f25509b != -1.0d && !a((com.bykv.vk.openvk.preload.a.a.c) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.c.class), (com.bykv.vk.openvk.preload.a.a.d) field.getAnnotation(com.bykv.vk.openvk.preload.a.a.d.class))) || field.isSynthetic()) {
            return true;
        }
        if ((!this.f25511d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.bykv.vk.openvk.preload.geckox.a.a.c> list = z11 ? this.f25512e : this.f25513f;
        if (list.isEmpty()) {
            return false;
        }
        new com.bykv.vk.openvk.preload.geckox.g.a(field);
        Iterator<com.bykv.vk.openvk.preload.geckox.a.a.c> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a()) {
                return true;
            }
        }
        return false;
    }
}
