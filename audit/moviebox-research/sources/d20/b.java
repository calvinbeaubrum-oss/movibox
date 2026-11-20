package d20;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.x1;

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
public final class b {
    public static final <R, T> void a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r11, Continuation<? super T> continuation) {
        Continuation continuationA = DebugProbesKt.a(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object objC = ThreadContextKt.c(context, null);
            try {
                Object objD = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.d(function2, r11, continuationA) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(r11, continuationA);
                ThreadContextKt.a(context, objC);
                if (objD != kotlin.coroutines.intrinsics.a.e()) {
                    continuationA.resumeWith(Result.m163constructorimpl(objD));
                }
            } catch (Throwable th2) {
                ThreadContextKt.a(context, objC);
                throw th2;
            }
        } catch (Throwable th3) {
            Result.Companion companion = Result.Companion;
            continuationA.resumeWith(Result.m163constructorimpl(ResultKt.a(th3)));
        }
    }

    public static final <T, R> Object b(y<? super T> yVar, R r11, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object b0Var;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            b0Var = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.d(function2, r11, yVar) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(r11, yVar);
        } catch (Throwable th2) {
            b0Var = new b0(th2, false, 2, null);
        }
        if (b0Var != kotlin.coroutines.intrinsics.a.e() && (objMakeCompletingOnce$kotlinx_coroutines_core = yVar.makeCompletingOnce$kotlinx_coroutines_core(b0Var)) != x1.f69617b) {
            if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof b0) {
                throw ((b0) objMakeCompletingOnce$kotlinx_coroutines_core).f69208a;
            }
            return x1.h(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return kotlin.coroutines.intrinsics.a.e();
    }

    public static final <T, R> Object c(y<? super T> yVar, R r11, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object b0Var;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            b0Var = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.d(function2, r11, yVar) : ((Function2) TypeIntrinsics.e(function2, 2)).invoke(r11, yVar);
        } catch (Throwable th2) {
            b0Var = new b0(th2, false, 2, null);
        }
        if (b0Var != kotlin.coroutines.intrinsics.a.e() && (objMakeCompletingOnce$kotlinx_coroutines_core = yVar.makeCompletingOnce$kotlinx_coroutines_core(b0Var)) != x1.f69617b) {
            if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof b0) {
                Throwable th3 = ((b0) objMakeCompletingOnce$kotlinx_coroutines_core).f69208a;
                if (!(th3 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th3).coroutine != yVar) {
                    throw th3;
                }
                if (b0Var instanceof b0) {
                    throw ((b0) b0Var).f69208a;
                }
            } else {
                b0Var = x1.h(objMakeCompletingOnce$kotlinx_coroutines_core);
            }
            return b0Var;
        }
        return kotlin.coroutines.intrinsics.a.e();
    }
}
