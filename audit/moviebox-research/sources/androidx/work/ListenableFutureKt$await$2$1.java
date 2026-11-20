package androidx.work;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ kotlinx.coroutines.n<Object> $cancellableContinuation;
    final /* synthetic */ com.google.common.util.concurrent.s<Object> $this_await;

    public ListenableFutureKt$await$2$1(kotlinx.coroutines.n<Object> nVar, com.google.common.util.concurrent.s<Object> sVar) {
        this.$cancellableContinuation = nVar;
        this.$this_await = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            kotlinx.coroutines.n<Object> nVar = this.$cancellableContinuation;
            Result.Companion companion = Result.Companion;
            nVar.resumeWith(Result.m163constructorimpl(this.$this_await.get()));
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                cause = th2;
            }
            if (th2 instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
                return;
            }
            kotlinx.coroutines.n<Object> nVar2 = this.$cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            nVar2.resumeWith(Result.m163constructorimpl(ResultKt.a(cause)));
        }
    }
}
