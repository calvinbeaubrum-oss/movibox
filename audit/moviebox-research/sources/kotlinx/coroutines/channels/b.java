package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

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
public class b<E> extends kotlinx.coroutines.a<Unit> implements a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<E> f69252a;

    public b(CoroutineContext coroutineContext, a<E> aVar, boolean z11, boolean z12) {
        super(coroutineContext, z11, z12);
        this.f69252a = aVar;
    }

    @Override // kotlinx.coroutines.JobSupport
    @Deprecated
    public /* synthetic */ void cancel() {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.q1
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    @Override // kotlinx.coroutines.JobSupport
    @Deprecated
    public final /* synthetic */ boolean cancel(Throwable th2) {
        cancelInternal(new JobCancellationException(cancellationExceptionMessage(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable th2) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th2, null, 1, null);
        this.f69252a.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.p
    public Object f(E e11) {
        return this.f69252a.f(e11);
    }

    @Override // kotlinx.coroutines.channels.o
    public c<E> iterator() {
        return this.f69252a.iterator();
    }

    @Override // kotlinx.coroutines.channels.o
    public Object k() {
        return this.f69252a.k();
    }

    @Override // kotlinx.coroutines.channels.o
    public Object m(Continuation<? super e<? extends E>> continuation) {
        Object objM = this.f69252a.m(continuation);
        kotlin.coroutines.intrinsics.a.e();
        return objM;
    }

    @Override // kotlinx.coroutines.channels.o
    public Object o(Continuation<? super E> continuation) {
        return this.f69252a.o(continuation);
    }

    @Override // kotlinx.coroutines.channels.p
    public boolean p(Throwable th2) {
        return this.f69252a.p(th2);
    }

    @Override // kotlinx.coroutines.channels.p
    public Object q(E e11, Continuation<? super Unit> continuation) {
        return this.f69252a.q(e11, continuation);
    }

    public final a<E> s() {
        return this.f69252a;
    }
}
