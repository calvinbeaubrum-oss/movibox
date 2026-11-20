package hj;

import com.google.common.base.m;
import com.google.common.base.s;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f66465d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f66466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<Closeable> f66467b = new ArrayDeque(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Throwable f66468c;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f66469a = new a();

        @Override // hj.f.c
        public void a(Closeable closeable, Throwable th2, Throwable th3) {
            e.f66464a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th3);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f66470a;

        public b(Method method) {
            this.f66470a = method;
        }

        public static b b() {
            try {
                return new b(Throwable.class.getMethod("addSuppressed", Throwable.class));
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // hj.f.c
        public void a(Closeable closeable, Throwable th2, Throwable th3) {
            if (th2 == th3) {
                return;
            }
            try {
                this.f66470a.invoke(th2, th3);
            } catch (Throwable unused) {
                a.f66469a.a(closeable, th2, th3);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(Closeable closeable, Throwable th2, Throwable th3);
    }

    static {
        c cVarB = b.b();
        if (cVarB == null) {
            cVarB = a.f66469a;
        }
        f66465d = cVarB;
    }

    public f(c cVar) {
        this.f66466a = (c) m.p(cVar);
    }

    public static f a() {
        return new f(f66465d);
    }

    public <C extends Closeable> C b(C c11) {
        if (c11 != null) {
            this.f66467b.addFirst(c11);
        }
        return c11;
    }

    public RuntimeException c(Throwable th2) throws Throwable {
        m.p(th2);
        this.f66468c = th2;
        s.g(th2, IOException.class);
        throw new RuntimeException(th2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        Throwable th2 = this.f66468c;
        while (!this.f66467b.isEmpty()) {
            Closeable closeableRemoveFirst = this.f66467b.removeFirst();
            try {
                closeableRemoveFirst.close();
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    this.f66466a.a(closeableRemoveFirst, th2, th3);
                }
            }
        }
        if (this.f66468c != null || th2 == null) {
            return;
        }
        s.g(th2, IOException.class);
        throw new AssertionError(th2);
    }
}
