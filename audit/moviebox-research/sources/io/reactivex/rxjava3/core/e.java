package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.rxjava3.internal.subscribers.StrictSubscriber;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e<T> implements u30.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f67322a = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    public static int a() {
        return f67322a;
    }

    public final e<T> b() {
        return c(a(), false, true);
    }

    public final e<T> c(int i11, boolean z11, boolean z12) {
        io.reactivex.rxjava3.internal.functions.a.a(i11, "capacity");
        return p10.a.l(new FlowableOnBackpressureBuffer(this, i11, z12, z11, Functions.f67328c));
    }

    public final e<T> d() {
        return p10.a.l(new FlowableOnBackpressureDrop(this));
    }

    public final e<T> e() {
        return p10.a.l(new FlowableOnBackpressureLatest(this));
    }

    public final void f(f<? super T> fVar) {
        Objects.requireNonNull(fVar, "subscriber is null");
        try {
            u30.c<? super T> cVarY = p10.a.y(this, fVar);
            Objects.requireNonNull(cVarY, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            g(cVarY);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void g(u30.c<? super T> cVar);

    @Override // u30.b
    public final void subscribe(u30.c<? super T> cVar) {
        if (cVar instanceof f) {
            f((f) cVar);
        } else {
            Objects.requireNonNull(cVar, "subscriber is null");
            f(new StrictSubscriber(cVar));
        }
    }
}
