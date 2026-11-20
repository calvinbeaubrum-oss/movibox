package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.q1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {
    public static final <T> z0<T> a(u0<T> u0Var) {
        return FlowKt__ShareKt.a(u0Var);
    }

    public static final <T> f1<T> b(v0<T> v0Var) {
        return FlowKt__ShareKt.b(v0Var);
    }

    public static final <T> a<T> c(a<? extends T> aVar, int i11, BufferOverflow bufferOverflow) {
        return q.a(aVar, i11, bufferOverflow);
    }

    public static final <T> a<T> e(a<? extends T> aVar, Function3<? super b<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.a(aVar, function3);
    }

    public static final <T> Object f(a<? extends T> aVar, b<? super T> bVar, Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.b(aVar, bVar, continuation);
    }

    public static final Object g(a<?> aVar, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.a(aVar, continuation);
    }

    public static final <T> Object h(a<? extends T> aVar, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.b(aVar, function2, continuation);
    }

    public static final <T> a<T> i(a<? extends T> aVar) {
        return FlowKt__DistinctKt.a(aVar);
    }

    public static final <T> a<T> j(a<? extends T> aVar, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.a(aVar, function2);
    }

    public static final <T> Object k(b<? super T> bVar, kotlinx.coroutines.channels.o<? extends T> oVar, Continuation<? super Unit> continuation) {
        return FlowKt__ChannelsKt.b(bVar, oVar, continuation);
    }

    public static final <T> Object l(b<? super T> bVar, a<? extends T> aVar, Continuation<? super Unit> continuation) {
        return FlowKt__CollectKt.c(bVar, aVar, continuation);
    }

    public static final void m(b<?> bVar) throws Throwable {
        FlowKt__EmittersKt.b(bVar);
    }

    public static final <T> Object n(a<? extends T> aVar, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.a(aVar, function2, continuation);
    }

    public static final <T> a<T> o(@BuilderInference Function2<? super b<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return n.a(function2);
    }

    public static final <T> a<T> p(T t11) {
        return n.b(t11);
    }

    public static final <T> a<T> q(a<? extends T> aVar, CoroutineContext coroutineContext) {
        return q.d(aVar, coroutineContext);
    }

    public static final <T> q1 r(a<? extends T> aVar, kotlinx.coroutines.k0 k0Var) {
        return FlowKt__CollectKt.d(aVar, k0Var);
    }

    public static final <T, R> a<R> s(a<? extends T> aVar, @BuilderInference Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.a(aVar, function2);
    }

    public static final <T> a<T> t(a<? extends T> aVar, Function3<? super b<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.d(aVar, function3);
    }

    public static final <T> a<T> u(a<? extends T> aVar, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.a(aVar, function2);
    }

    public static final <T> a<T> v(a<? extends T> aVar, long j11, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.e(aVar, j11, function2);
    }

    public static final <T> a<T> x(a<? extends T> aVar, Function4<? super b<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.g(aVar, function4);
    }

    public static final <T> f1<T> y(a<? extends T> aVar, kotlinx.coroutines.k0 k0Var, d1 d1Var, T t11) {
        return FlowKt__ShareKt.e(aVar, k0Var, d1Var, t11);
    }

    public static final <T, R> a<R> z(a<? extends T> aVar, @BuilderInference Function3<? super b<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.b(aVar, function3);
    }
}
