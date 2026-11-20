package w30;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.p;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.b0;
import retrofit2.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g extends retrofit2.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scheduler f79239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f79240b;

    public g(Scheduler scheduler, boolean z11) {
        this.f79239a = scheduler;
        this.f79240b = z11;
    }

    public static g d(Scheduler scheduler) {
        if (scheduler != null) {
            return new g(scheduler, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.c.a
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, c0 c0Var) {
        Type typeB;
        boolean z11;
        boolean z12;
        String str;
        Class<?> clsC = retrofit2.c.a.c(type);
        if (clsC == io.reactivex.rxjava3.core.a.class) {
            return new f(Void.class, this.f79239a, this.f79240b, false, true, false, false, false, true);
        }
        boolean z13 = clsC == io.reactivex.rxjava3.core.e.class;
        boolean z14 = clsC == p.class;
        boolean z15 = clsC == io.reactivex.rxjava3.core.g.class;
        if (clsC != j.class && !z13 && !z14 && !z15) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            if (z13) {
                str = "Flowable";
            } else if (z14) {
                str = "Single";
            } else {
                str = z15 ? "Maybe" : "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeB2 = retrofit2.c.a.b(0, (ParameterizedType) type);
        Class<?> clsC2 = retrofit2.c.a.c(typeB2);
        if (clsC2 != b0.class) {
            if (clsC2 != d.class) {
                typeB = typeB2;
                z11 = false;
                z12 = true;
            } else {
                if (!(typeB2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                typeB = retrofit2.c.a.b(0, (ParameterizedType) typeB2);
                z11 = true;
            }
            return new f(typeB, this.f79239a, this.f79240b, z11, z12, z13, z14, z15, false);
        }
        if (!(typeB2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        typeB = retrofit2.c.a.b(0, (ParameterizedType) typeB2);
        z11 = false;
        z12 = false;
        return new f(typeB, this.f79239a, this.f79240b, z11, z12, z13, z14, z15, false);
    }
}
