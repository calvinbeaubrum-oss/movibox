package com.cloud.tmc.integration.performance.innerworker;

import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import uc.c;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "com.cloud.tmc.integration.performance.innerworker.InnerWorkerWarmupManager$warmup$1", f = "InnerWorkerWarmupManager.kt", l = {}, m = "invokeSuspend")
public final class InnerWorkerWarmupManager$warmup$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.cloud.tmc.integration.performance.innerworker.a $listener;
    final /* synthetic */ nb.a $warmUpCallback;
    final /* synthetic */ Node $warmupNode;
    final /* synthetic */ gd.b $worker;
    int label;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gd.b f30863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IEventCenterFactory f30864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Node f30865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ nb.a f30866d;

        public a(gd.b bVar, IEventCenterFactory iEventCenterFactory, Node node, nb.a aVar) {
            this.f30863a = bVar;
            this.f30864b = iEventCenterFactory;
            this.f30865c = node;
            this.f30866d = aVar;
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            this.f30863a.q();
            uc.b eventCenterInstance = this.f30864b.getEventCenterInstance(this.f30865c);
            if (eventCenterInstance != null) {
                eventCenterInstance.c("workerOnMessageReady", this);
            }
            WarmupNode warmupNode = (WarmupNode) tc.a.a(WarmupNode.class);
            String workerId = this.f30863a.getWorkerId();
            Intrinsics.f(workerId, "worker.workerId");
            warmupNode.removeNode(workerId);
            this.f30866d.a(true);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerWorkerWarmupManager$warmup$1(gd.b bVar, Node node, com.cloud.tmc.integration.performance.innerworker.a aVar, nb.a aVar2, Continuation<? super InnerWorkerWarmupManager$warmup$1> continuation) {
        super(2, continuation);
        this.$worker = bVar;
        this.$warmupNode = node;
        this.$listener = aVar;
        this.$warmUpCallback = aVar2;
    }

    public static final void d(com.cloud.tmc.integration.performance.innerworker.a aVar, Node node, gd.b bVar, nb.a aVar2) {
        if (aVar != null) {
            aVar.d();
        }
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(node);
        if (eventCenterInstance != null) {
            eventCenterInstance.b("workerOnMessageReady", new a(bVar, iEventCenterFactory, node, aVar2));
        }
        bVar.g("100000", "https://100000.miniapp.transsion.com/master.js");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerWorkerWarmupManager$warmup$1(this.$worker, this.$warmupNode, this.$listener, this.$warmUpCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((InnerWorkerWarmupManager$warmup$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$worker.o();
        this.$worker.setAppId("99999");
        this.$worker.setNode(this.$warmupNode);
        final gd.b bVar = this.$worker;
        final com.cloud.tmc.integration.performance.innerworker.a aVar = this.$listener;
        final Node node = this.$warmupNode;
        final nb.a aVar2 = this.$warmUpCallback;
        bVar.l(new gd.b.a() { // from class: com.cloud.tmc.integration.performance.innerworker.b
            @Override // gd.b.a
            public final void a() {
                InnerWorkerWarmupManager$warmup$1.d(aVar, node, bVar, aVar2);
            }
        });
        return Unit.f68710a;
    }
}
