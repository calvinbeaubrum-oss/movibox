package bu;

import android.util.Log;
import wt.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC0149c<Object> f14405a = new e();

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T create();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        k getVerifier();
    }

    /* JADX INFO: renamed from: bu.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0149c<T> {
        void reset(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<T> f14406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0149c<T> f14407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f<T> f14408c;

        public d(f<T> fVar, a<T> aVar, InterfaceC0149c<T> interfaceC0149c) {
            this.f14408c = fVar;
            this.f14406a = aVar;
            this.f14407b = interfaceC0149c;
        }

        @Override // bu.f
        public T acquire() {
            T tAcquire = this.f14408c.acquire();
            if (tAcquire == null) {
                tAcquire = this.f14406a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof b) {
                ((b) tAcquire).getVerifier().a(false);
            }
            return tAcquire;
        }

        @Override // bu.f
        public boolean release(T t11) {
            if (t11 instanceof b) {
                ((b) t11).getVerifier().a(true);
            }
            this.f14407b.reset(t11);
            return this.f14408c.release(t11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements InterfaceC0149c<Object> {
        @Override // bu.c.InterfaceC0149c
        public void reset(Object obj) {
        }
    }

    public static <T extends b> f<T> a(f<T> fVar, a<T> aVar) {
        return b(fVar, aVar, f14405a);
    }

    public static <T> f<T> b(f<T> fVar, a<T> aVar, InterfaceC0149c<T> interfaceC0149c) {
        return new d(fVar, aVar, interfaceC0149c);
    }

    public static <T extends b> f<T> c(int i11, a<T> aVar) {
        return a(new h(i11), aVar);
    }
}
