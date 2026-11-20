package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Suppliers {

    /* JADX INFO: compiled from: source.java */
    public static class MemoizingSupplier<T> implements q<T>, Serializable {
        private static final long serialVersionUID = 0;
        final q<T> delegate;
        volatile transient boolean initialized;
        transient T value;

        public MemoizingSupplier(q<T> qVar) {
            this.delegate = (q) m.p(qVar);
        }

        @Override // com.google.common.base.q
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    try {
                        if (!this.initialized) {
                            T t11 = this.delegate.get();
                            this.value = t11;
                            this.initialized = true;
                            return t11;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return (T) i.a(this.value);
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a<T> implements q<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q<Void> f38152c = new q() { // from class: com.google.common.base.r
            @Override // com.google.common.base.q
            public final Object get() {
                return Suppliers.a.b();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile q<T> f38153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f38154b;

        public a(q<T> qVar) {
            this.f38153a = (q) m.p(qVar);
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.base.q
        public T get() {
            q<T> qVar = this.f38153a;
            q<T> qVar2 = (q<T>) f38152c;
            if (qVar != qVar2) {
                synchronized (this) {
                    try {
                        if (this.f38153a != qVar2) {
                            T t11 = this.f38153a.get();
                            this.f38154b = t11;
                            this.f38153a = qVar2;
                            return t11;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return (T) i.a(this.f38154b);
        }

        public String toString() {
            Object obj = this.f38153a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == f38152c) {
                obj = "<supplier that returned " + this.f38154b + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static <T> q<T> a(q<T> qVar) {
        if ((qVar instanceof a) || (qVar instanceof MemoizingSupplier)) {
            return qVar;
        }
        return qVar instanceof Serializable ? new MemoizingSupplier(qVar) : new a(qVar);
    }
}
