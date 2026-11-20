package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f75276a;

    /* JADX INFO: compiled from: source.java */
    public class a implements c<Object, retrofit2.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f75277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f75278b;

        public a(Type type, Executor executor) {
            this.f75277a = type;
            this.f75278b = executor;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f75277a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> b(retrofit2.b<Object> bVar) {
            Executor executor = this.f75278b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b<T> implements retrofit2.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f75280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.b<T> f75281b;

        /* JADX INFO: compiled from: source.java */
        public class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f75282a;

            public a(d dVar) {
                this.f75282a = dVar;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<T> bVar, final Throwable th2) {
                Executor executor = b.this.f75280a;
                final d dVar = this.f75282a;
                executor.execute(new Runnable() { // from class: retrofit2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f75287a.e(dVar, th2);
                    }
                });
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<T> bVar, final b0<T> b0Var) {
                Executor executor = b.this.f75280a;
                final d dVar = this.f75282a;
                executor.execute(new Runnable() { // from class: retrofit2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f75284a.f(dVar, b0Var);
                    }
                });
            }

            public final /* synthetic */ void e(d dVar, Throwable th2) {
                dVar.a(b.this, th2);
            }

            public final /* synthetic */ void f(d dVar, b0 b0Var) {
                if (b.this.f75281b.isCanceled()) {
                    dVar.a(b.this, new IOException("Canceled"));
                } else {
                    dVar.b(b.this, b0Var);
                }
            }
        }

        public b(Executor executor, retrofit2.b<T> bVar) {
            this.f75280a = executor;
            this.f75281b = bVar;
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f75281b.cancel();
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f75280a, this.f75281b.clone());
        }

        @Override // retrofit2.b
        public void e(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f75281b.e(new a(dVar));
        }

        @Override // retrofit2.b
        public b0<T> execute() throws IOException {
            return this.f75281b.execute();
        }

        @Override // retrofit2.b
        public boolean isCanceled() {
            return this.f75281b.isCanceled();
        }

        @Override // retrofit2.b
        public Request request() {
            return this.f75281b.request();
        }
    }

    public j(Executor executor) {
        this.f75276a = executor;
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, c0 c0Var) {
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(g0.g(0, (ParameterizedType) type), g0.l(annotationArr, e0.class) ? null : this.f75276a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
