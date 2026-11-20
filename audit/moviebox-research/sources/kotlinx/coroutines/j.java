package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ThreadContextKt;

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
@SourceDebugExtension
public final /* synthetic */ class j {
    public static final <T> o0<T> a(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(k0Var, coroutineContext);
        p0 y1Var = coroutineStart.isLazy() ? new y1(coroutineContextE, function2) : new p0(coroutineContextE, true);
        ((a) y1Var).start(coroutineStart, y1Var, function2);
        return (o0<T>) y1Var;
    }

    public static /* synthetic */ o0 b(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final q1 c(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        CoroutineContext coroutineContextE = CoroutineContextKt.e(k0Var, coroutineContext);
        a z1Var = coroutineStart.isLazy() ? new z1(coroutineContextE, function2) : new i2(coroutineContextE, true);
        z1Var.start(coroutineStart, z1Var, function2);
        return z1Var;
    }

    public static /* synthetic */ q1 d(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i11 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.c(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Object e(CoroutineContext coroutineContext, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        Object objS;
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContextD = CoroutineContextKt.d(context, coroutineContext);
        t1.j(coroutineContextD);
        if (coroutineContextD == context) {
            kotlinx.coroutines.internal.y yVar = new kotlinx.coroutines.internal.y(coroutineContextD, continuation);
            objS = d20.b.b(yVar, yVar, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.f68810h8;
            if (Intrinsics.b(coroutineContextD.get(key), context.get(key))) {
                q2 q2Var = new q2(coroutineContextD, continuation);
                CoroutineContext context2 = q2Var.getContext();
                Object objC = ThreadContextKt.c(context2, null);
                try {
                    Object objB = d20.b.b(q2Var, q2Var, function2);
                    ThreadContextKt.a(context2, objC);
                    objS = objB;
                } catch (Throwable th2) {
                    ThreadContextKt.a(context2, objC);
                    throw th2;
                }
            } else {
                t0 t0Var = new t0(coroutineContextD, continuation);
                d20.a.d(function2, t0Var, t0Var, null, 4, null);
                objS = t0Var.s();
            }
        }
        if (objS == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objS;
    }
}
