package com.cloud.tmc.worker;

import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;
import com.cloud.tmc.worker.WorkerManager.b;
import com.cloud.tmc.worker.WorkerManager.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "com.cloud.tmc.worker.WorkerManager$registerWorkerReadyListener$1", f = "WorkerManager.kt", l = {}, m = "invokeSuspend")
public final class WorkerManager$registerWorkerReadyListener$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkerManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerManager$registerWorkerReadyListener$1(WorkerManager workerManager, Continuation<? super WorkerManager$registerWorkerReadyListener$1> continuation) {
        super(2, continuation);
        this.this$0 = workerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkerManager$registerWorkerReadyListener$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WorkerManager$registerWorkerReadyListener$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        WorkerManager workerManager = this.this$0;
        gd.a aVarCreateWorker = ((IWorkerFactory) tc.a.a(IWorkerFactory.class)).createWorker(this.this$0.f32144c, this.this$0.f32145d);
        if (aVarCreateWorker != null) {
            WorkerManager workerManager2 = this.this$0;
            aVarCreateWorker.registerWorkLifeCycle(workerManager2.new c());
            aVarCreateWorker.registerWorkerCallback(workerManager2.new b());
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(workerManager2.f32144c, WorkerAnalyseType.CREATE_START, null);
            aVarCreateWorker.create();
        } else {
            aVarCreateWorker = null;
        }
        workerManager.f32142a = aVarCreateWorker;
        if (this.this$0.f32142a == null) {
            if (this.this$0.f32143b == null || Intrinsics.b(this.this$0.f32143b, "100000") || ((str = this.this$0.f32143b) != null && l.L(str, "warmup_worker_id_", false, 2, null))) {
                this.this$0.f32152k = true;
            } else {
                this.this$0.D();
            }
        }
        return Unit.f68710a;
    }
}
