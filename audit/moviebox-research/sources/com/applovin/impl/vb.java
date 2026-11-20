package com.applovin.impl;

import java.lang.ref.WeakReference;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface vb {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Object a();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements vb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Stack f23818b;

        public c() {
            this(3);
        }

        public c(int i11) {
            this.f23818b = new Stack();
            this.f23817a = i11;
        }

        @Override // com.applovin.impl.vb
        public synchronized Object a(a aVar) {
            try {
            } catch (Throwable th2) {
                throw th2;
            }
            return this.f23818b.isEmpty() ? aVar.a() : this.f23818b.pop();
        }

        @Override // com.applovin.impl.vb
        public synchronized void a(Object obj, b bVar) {
            try {
                if (this.f23818b.size() < this.f23817a) {
                    this.f23818b.push(obj);
                } else {
                    try {
                        bVar.a(obj);
                    } catch (RuntimeException e11) {
                        q6.a((Throwable) e11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements vb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f23819a = new c();

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ WeakReference b(a aVar) {
            return new WeakReference(aVar.a());
        }

        @Override // com.applovin.impl.vb
        public Object a(final a aVar) {
            Object obj;
            do {
                obj = ((WeakReference) this.f23819a.a(new a() { // from class: com.applovin.impl.u70
                    @Override // com.applovin.impl.vb.a
                    public final Object a() {
                        return vb.d.b(aVar);
                    }
                })).get();
            } while (obj == null);
            return obj;
        }

        @Override // com.applovin.impl.vb
        public void a(final Object obj, final b bVar) {
            q6.a(obj);
            this.f23819a.a(new WeakReference(obj), new b() { // from class: com.applovin.impl.t70
                @Override // com.applovin.impl.vb.b
                public final void a(Object obj2) {
                    bVar.a(obj);
                }
            });
        }
    }

    Object a(a aVar);

    void a(Object obj, b bVar);
}
