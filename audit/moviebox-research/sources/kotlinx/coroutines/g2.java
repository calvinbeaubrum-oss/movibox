package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
public final class g2<T> extends w1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CancellableContinuationImpl<T> f69431f;

    /* JADX WARN: Multi-variable type inference failed */
    public g2(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.f69431f = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
        t(th2);
        return Unit.f68710a;
    }

    @Override // kotlinx.coroutines.d0
    public void t(Throwable th2) {
        Object state$kotlinx_coroutines_core = u().getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b0) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.f69431f;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(ResultKt.a(((b0) state$kotlinx_coroutines_core).f69208a)));
        } else {
            CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.f69431f;
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl2.resumeWith(Result.m163constructorimpl(x1.h(state$kotlinx_coroutines_core)));
        }
    }
}
