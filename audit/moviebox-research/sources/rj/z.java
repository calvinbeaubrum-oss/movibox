package rj;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class z<T> implements bl.b<T>, bl.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final bl.a.InterfaceC0146a<Object> f75583c = new bl.a.InterfaceC0146a() { // from class: rj.w
        @Override // bl.a.InterfaceC0146a
        public final void a(bl.b bVar) {
            z.f(bVar);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final bl.b<Object> f75584d = new bl.b() { // from class: rj.x
        @Override // bl.b
        public final Object get() {
            return z.g();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bl.a.InterfaceC0146a<T> f75585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile bl.b<T> f75586b;

    public z(bl.a.InterfaceC0146a<T> interfaceC0146a, bl.b<T> bVar) {
        this.f75585a = interfaceC0146a;
        this.f75586b = bVar;
    }

    public static <T> z<T> e() {
        return new z<>(f75583c, f75584d);
    }

    public static /* synthetic */ void f(bl.b bVar) {
    }

    public static /* synthetic */ Object g() {
        return null;
    }

    public static /* synthetic */ void h(bl.a.InterfaceC0146a interfaceC0146a, bl.a.InterfaceC0146a interfaceC0146a2, bl.b bVar) {
        interfaceC0146a.a(bVar);
        interfaceC0146a2.a(bVar);
    }

    public static <T> z<T> i(bl.b<T> bVar) {
        return new z<>(null, bVar);
    }

    @Override // bl.a
    public void a(@NonNull final bl.a.InterfaceC0146a<T> interfaceC0146a) {
        bl.b<T> bVar;
        bl.b<T> bVar2;
        bl.b<T> bVar3 = this.f75586b;
        bl.b<Object> bVar4 = f75584d;
        if (bVar3 != bVar4) {
            interfaceC0146a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f75586b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final bl.a.InterfaceC0146a<T> interfaceC0146a2 = this.f75585a;
                this.f75585a = new bl.a.InterfaceC0146a() { // from class: rj.y
                    @Override // bl.a.InterfaceC0146a
                    public final void a(bl.b bVar5) {
                        z.h(interfaceC0146a2, interfaceC0146a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0146a.a(bVar);
        }
    }

    @Override // bl.b
    public T get() {
        return this.f75586b.get();
    }

    public void j(bl.b<T> bVar) {
        bl.a.InterfaceC0146a<T> interfaceC0146a;
        if (this.f75586b != f75584d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0146a = this.f75585a;
            this.f75585a = null;
            this.f75586b = bVar;
        }
        interfaceC0146a.a(bVar);
    }
}
