package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

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
public final class c2 extends AbstractCoroutineContextElement implements q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c2 f69212a = new c2();

    public c2() {
        super(q1.f69514j8);
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public t attachChild(v vVar) {
        return d2.f69264a;
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public void cancel(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.q1
    public q1 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public y0 invokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        return d2.f69264a;
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public y0 invokeOnCompletion(boolean z11, boolean z12, Function1<? super Throwable, Unit> function1) {
        return d2.f69264a;
    }

    @Override // kotlinx.coroutines.q1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.q1
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.q1
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public Object join(Continuation<? super Unit> continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.q1
    @Deprecated
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }
}
