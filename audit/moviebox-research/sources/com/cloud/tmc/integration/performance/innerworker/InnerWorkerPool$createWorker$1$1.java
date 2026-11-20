package com.cloud.tmc.integration.performance.innerworker;

import android.app.Application;
import com.cloud.tmc.integration.performance.WarmupType;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.worker.WorkerManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import nb.c;

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
@DebugMetadata(c = "com.cloud.tmc.integration.performance.innerworker.InnerWorkerPool$createWorker$1$1", f = "InnerWorkerPool.kt", l = {}, m = "invokeSuspend")
public final class InnerWorkerPool$createWorker$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $it;
    int label;
    final /* synthetic */ InnerWorkerPool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerWorkerPool$createWorker$1$1(InnerWorkerPool innerWorkerPool, Application application, Continuation<? super InnerWorkerPool$createWorker$1$1> continuation) {
        super(2, continuation);
        this.this$0 = innerWorkerPool;
        this.$it = application;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerWorkerPool$createWorker$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((InnerWorkerPool$createWorker$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        WorkerManager workerManager = new WorkerManager();
        workerManager.r("warmup_worker_id__" + c.f71783a.b().addAndGet(1));
        workerManager.E(2);
        ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).get(-1L).registerWorker(workerManager.getWorkerId(), workerManager);
        this.this$0.f30858d.add(workerManager);
        TmcLogger.c(this.this$0.f30855a, "InnerWorkerPool => addWorker unUsedWorkerQueue = " + this.this$0.f30858d.size());
        this.this$0.f30860f = new InnerWorkerWarmupManager();
        InnerWorkerWarmupManager innerWorkerWarmupManager = this.this$0.f30860f;
        if (innerWorkerWarmupManager != null) {
            innerWorkerWarmupManager.a(this.$it, WarmupType.INNER_WORKER.getType());
        }
        return Unit.f68710a;
    }
}
