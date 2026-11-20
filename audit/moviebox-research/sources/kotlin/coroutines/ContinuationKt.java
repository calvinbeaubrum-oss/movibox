package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class ContinuationKt {
    @SinceKotlin
    public static final <R, T> Continuation<Unit> a(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r11, Continuation<? super T> completion) {
        Intrinsics.g(function2, "<this>");
        Intrinsics.g(completion, "completion");
        return new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function2, r11, completion)), a.e());
    }

    @SinceKotlin
    public static final <R, T> void b(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r11, Continuation<? super T> completion) {
        Intrinsics.g(function2, "<this>");
        Intrinsics.g(completion, "completion");
        Continuation continuationC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function2, r11, completion));
        Result.Companion companion = Result.Companion;
        continuationC.resumeWith(Result.m163constructorimpl(Unit.f68710a));
    }
}
