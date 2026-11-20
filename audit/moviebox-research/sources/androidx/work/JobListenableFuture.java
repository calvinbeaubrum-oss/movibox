package androidx.work;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.q1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class JobListenableFuture<R> implements com.google.common.util.concurrent.s<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f13231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<R> f13232b;

    public JobListenableFuture(q1 job, androidx.work.impl.utils.futures.a<R> underlying) {
        Intrinsics.g(job, "job");
        Intrinsics.g(underlying, "underlying");
        this.f13231a = job;
        this.f13232b = underlying;
        job.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: androidx.work.JobListenableFuture.1
            final /* synthetic */ JobListenableFuture<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                if (th2 == null) {
                    if (!this.this$0.f13232b.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    if (th2 instanceof CancellationException) {
                        this.this$0.f13232b.cancel(true);
                        return;
                    }
                    androidx.work.impl.utils.futures.a aVar = this.this$0.f13232b;
                    Throwable cause = th2.getCause();
                    if (cause != null) {
                        th2 = cause;
                    }
                    aVar.u(th2);
                }
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JobListenableFuture(q1 q1Var, androidx.work.impl.utils.futures.a aVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 2) != 0) {
            aVar = androidx.work.impl.utils.futures.a.x();
            Intrinsics.f(aVar, "create()");
        }
        this(q1Var, aVar);
    }

    @Override // com.google.common.util.concurrent.s
    public void addListener(Runnable runnable, Executor executor) {
        this.f13232b.addListener(runnable, executor);
    }

    public final void c(R r11) {
        this.f13232b.t(r11);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z11) {
        return this.f13232b.cancel(z11);
    }

    @Override // java.util.concurrent.Future
    public R get() {
        return this.f13232b.get();
    }

    @Override // java.util.concurrent.Future
    public R get(long j11, TimeUnit timeUnit) {
        return this.f13232b.get(j11, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f13232b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f13232b.isDone();
    }
}
