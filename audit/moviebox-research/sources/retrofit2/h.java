package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@IgnoreJRERequirement
public final class h extends retrofit2.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final retrofit2.c.a f75268a = new h();

    /* JADX INFO: compiled from: source.java */
    @IgnoreJRERequirement
    public static final class a<R> implements retrofit2.c<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f75269a;

        /* JADX INFO: renamed from: retrofit2.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @IgnoreJRERequirement
        public class C0828a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CompletableFuture<R> f75270a;

            public C0828a(CompletableFuture<R> completableFuture) {
                this.f75270a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th2) {
                this.f75270a.completeExceptionally(th2);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, b0<R> b0Var) {
                if (b0Var.e()) {
                    this.f75270a.complete(b0Var.a());
                } else {
                    this.f75270a.completeExceptionally(new HttpException(b0Var));
                }
            }
        }

        public a(Type type) {
            this.f75269a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f75269a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.e(new C0828a(bVar2));
            return bVar2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f75272a;

        public b(retrofit2.b<?> bVar) {
            this.f75272a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z11) {
            if (z11) {
                this.f75272a.cancel();
            }
            return super.cancel(z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @IgnoreJRERequirement
    public static final class c<R> implements retrofit2.c<R, CompletableFuture<b0<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f75273a;

        /* JADX INFO: compiled from: source.java */
        @IgnoreJRERequirement
        public class a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CompletableFuture<b0<R>> f75274a;

            public a(CompletableFuture<b0<R>> completableFuture) {
                this.f75274a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th2) {
                this.f75274a.completeExceptionally(th2);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, b0<R> b0Var) {
                this.f75274a.complete(b0Var);
            }
        }

        public c(Type type) {
            this.f75273a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f75273a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<b0<R>> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.e(new a(bVar2));
            return bVar2;
        }
    }

    @Override // retrofit2.c.a
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, c0 c0Var) {
        if (retrofit2.c.a.c(type) != e.a()) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = retrofit2.c.a.b(0, (ParameterizedType) type);
        if (retrofit2.c.a.c(typeB) != b0.class) {
            return new a(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new c(retrofit2.c.a.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
