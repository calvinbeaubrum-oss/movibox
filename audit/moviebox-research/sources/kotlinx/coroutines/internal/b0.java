package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
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
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement f69453a = new y0.a().a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f69454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f69455c;

    static {
        Object objM163constructorimpl;
        Object objM163constructorimpl2;
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f69454b = (String) objM163constructorimpl;
        try {
            objM163constructorimpl2 = Result.m163constructorimpl(b0.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.Companion companion3 = Result.Companion;
            objM163constructorimpl2 = Result.m163constructorimpl(ResultKt.a(th3));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl2) != null) {
            objM163constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f69455c = (String) objM163constructorimpl2;
    }

    public static final <E extends Throwable> E a(E e11) {
        return e11;
    }
}
