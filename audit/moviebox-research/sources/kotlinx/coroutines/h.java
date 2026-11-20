package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

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
public final class h {
    public static final <T> o0<T> a(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2) {
        return j.a(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final q1 c(k0 k0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super k0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return j.c(k0Var, coroutineContext, coroutineStart, function2);
    }

    public static final <T> T e(CoroutineContext coroutineContext, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) i.a(coroutineContext, function2);
    }

    public static final <T> Object g(CoroutineContext coroutineContext, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return j.e(coroutineContext, function2, continuation);
    }
}
