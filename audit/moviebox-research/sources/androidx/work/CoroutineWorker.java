package androidx.work;

import android.content.Context;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.z;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class CoroutineWorker extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f13228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<i.a> f13229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineDispatcher f13230c;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobListenableFuture<e> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(JobListenableFuture<e> jobListenableFuture, CoroutineWorker coroutineWorker, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$jobFuture = jobListenableFuture;
            this.this$0 = coroutineWorker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            JobListenableFuture jobListenableFuture;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                JobListenableFuture<e> jobListenableFuture2 = this.$jobFuture;
                CoroutineWorker coroutineWorker = this.this$0;
                this.L$0 = jobListenableFuture2;
                this.label = 1;
                Object objG = coroutineWorker.g(this);
                if (objG == objE) {
                    return objE;
                }
                jobListenableFuture = jobListenableFuture2;
                obj = objG;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jobListenableFuture = (JobListenableFuture) this.L$0;
                ResultKt.b(obj);
            }
            jobListenableFuture.c(obj);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    public static final class C09431 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public C09431(Continuation<? super C09431> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoroutineWorker.this.new C09431(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C09431) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.label = 1;
                    obj = coroutineWorker.d(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                CoroutineWorker.this.i().t((i.a) obj);
            } catch (Throwable th2) {
                CoroutineWorker.this.i().u(th2);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        Intrinsics.g(appContext, "appContext");
        Intrinsics.g(params, "params");
        this.f13228a = v1.b(null, 1, null);
        androidx.work.impl.utils.futures.a<i.a> aVarX = androidx.work.impl.utils.futures.a.x();
        Intrinsics.f(aVarX, "create()");
        this.f13229b = aVarX;
        aVarX.addListener(new Runnable() { // from class: androidx.work.c
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineWorker.c(this.f13303a);
            }
        }, getTaskExecutor().b());
        this.f13230c = w0.a();
    }

    public static final void c(CoroutineWorker this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f13229b.isCancelled()) {
            q1.a.b(this$0.f13228a, null, 1, null);
        }
    }

    public static /* synthetic */ Object h(CoroutineWorker coroutineWorker, Continuation<? super e> continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object d(Continuation<? super i.a> continuation);

    public CoroutineDispatcher f() {
        return this.f13230c;
    }

    public Object g(Continuation<? super e> continuation) {
        return h(this, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.work.i
    public final com.google.common.util.concurrent.s<e> getForegroundInfoAsync() {
        z zVarB = v1.b(null, 1, null);
        k0 k0VarA = l0.a(f().plus(zVarB));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(zVarB, null, 2, 0 == true ? 1 : 0);
        kotlinx.coroutines.j.d(k0VarA, null, null, new AnonymousClass1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    public final androidx.work.impl.utils.futures.a<i.a> i() {
        return this.f13229b;
    }

    @Override // androidx.work.i
    public final void onStopped() {
        super.onStopped();
        this.f13229b.cancel(false);
    }

    @Override // androidx.work.i
    public final com.google.common.util.concurrent.s<i.a> startWork() {
        kotlinx.coroutines.j.d(l0.a(f().plus(this.f13228a)), null, null, new C09431(null), 3, null);
        return this.f13229b;
    }
}
