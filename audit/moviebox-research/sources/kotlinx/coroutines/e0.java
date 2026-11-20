package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class e0 {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (!(obj instanceof b0)) {
            return Result.m163constructorimpl(obj);
        }
        Result.Companion companion = Result.Companion;
        return Result.m163constructorimpl(ResultKt.a(((b0) obj).f69208a));
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(obj);
        if (thM166exceptionOrNullimpl == null) {
            return function1 != null ? new c0(obj, function1) : obj;
        }
        return new b0(thM166exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object c(Object obj, n<?> nVar) {
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(obj);
        if (thM166exceptionOrNullimpl == null) {
            return obj;
        }
        return new b0(thM166exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
