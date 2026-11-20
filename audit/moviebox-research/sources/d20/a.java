package d20;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.i;

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
public final class a {
    public static final void a(Continuation<?> continuation, Throwable th2) throws Throwable {
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m163constructorimpl(ResultKt.a(th2)));
        throw th2;
    }

    public static final void b(Continuation<? super Unit> continuation, Continuation<?> continuation2) throws Throwable {
        try {
            Continuation continuationC = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            Result.Companion companion = Result.Companion;
            i.c(continuationC, Result.m163constructorimpl(Unit.f68710a), null, 2, null);
        } catch (Throwable th2) {
            a(continuation2, th2);
        }
    }

    public static final <R, T> void c(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r11, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) throws Throwable {
        try {
            Continuation continuationC = IntrinsicsKt__IntrinsicsJvmKt.c(IntrinsicsKt__IntrinsicsJvmKt.a(function2, r11, continuation));
            Result.Companion companion = Result.Companion;
            i.b(continuationC, Result.m163constructorimpl(Unit.f68710a), function1);
        } catch (Throwable th2) {
            a(continuation, th2);
        }
    }

    public static /* synthetic */ void d(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i11, Object obj2) throws Throwable {
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        c(function2, obj, continuation, function1);
    }
}
