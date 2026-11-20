package com.cloud.tmc.integration.performance.innerworker;

import android.app.Application;
import com.cloud.tmc.integration.model.InnerWarmup;
import com.cloud.tmc.integration.performance.InnerWarmupSettingData;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniutils.util.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import lb.f;

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
@SourceDebugExtension
public final class InnerWorkerPool implements IInnerWorkerPool, nb.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f30856b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InnerWorkerWarmupManager f30860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.cloud.tmc.integration.performance.innerworker.a f30861g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30855a = "InnerWarmup";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<gd.b> f30857c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<gd.b> f30858d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f30859e = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements nb.a {
        public a() {
        }

        @Override // nb.a
        public void a(boolean z11) {
            if (!z11) {
                TmcLogger.c(InnerWorkerPool.this.f30855a, "InnerWorkerPool => warmupWorker fail unUsedWorkerQueue = " + InnerWorkerPool.this.f30858d.size());
                InnerWorkerPool.this.preWarmupWorkerFail();
                return;
            }
            TmcLogger.c(InnerWorkerPool.this.f30855a, "InnerWorkerPool => warmupWorker success unUsedWorkerQueue = " + InnerWorkerPool.this.f30858d.size());
            if (InnerWorkerPool.this.f30858d.size() > 0) {
                ((gd.b) InnerWorkerPool.this.f30858d.getLast()).h();
                com.cloud.tmc.integration.performance.innerworker.a aVar = InnerWorkerPool.this.f30861g;
                if (aVar != null) {
                    aVar.c();
                }
                InnerWorkerPool.this.f30861g = null;
            }
            InnerWorkerPool.this.f30859e.set(false);
        }
    }

    public final boolean a(String str) {
        gd.b bVarPeek;
        if (this.f30858d.size() <= 0 || (bVarPeek = this.f30858d.peek()) == null) {
            return false;
        }
        Boolean boolA = bVarPeek.a();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.b(boolA, bool)) {
            return false;
        }
        gd.b bVarPeek2 = this.f30858d.peek();
        if (bVarPeek2 == null || !Intrinsics.b(bVarPeek2.isRenderProcessGone(), bool)) {
            if (isValid(str, bVarPeek2 != null ? bVarPeek2.getFrameworkVersion() : null)) {
                return true;
            }
        }
        gd.b bVarPoll = this.f30858d.poll();
        if (bVarPoll == null) {
            return false;
        }
        bVarPoll.destroy();
        return false;
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public boolean createWorker(boolean z11) {
        try {
            Application application = this.f30856b;
            if (application != null) {
                TmcLogger.c(this.f30855a, "InnerWorkerPool => createWorker");
                String configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("innerWarmup", "{\"innerWarmUpRenderEnable\": true, \"innerWarmUpWorkerEnable\": true, \"renderMaxWarmupSize\": 1, \"workerMaxWarmupSize\": 1}");
                InnerWarmup innerWarmup = (InnerWarmup) k.d(configString, InnerWarmup.class);
                String str = this.f30855a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("InnerWorkerPool => createWorker ret:");
                sb2.append(configString);
                sb2.append(", canCreate:");
                sb2.append(innerWarmup.getInnerWarmUpWorkerEnable() && this.f30858d.size() < innerWarmup.getWorkerMaxWarmupSize() && !this.f30859e.get());
                sb2.append(", processName:");
                sb2.append(l.c());
                TmcLogger.c(str, sb2.toString());
                if (innerWarmup.getInnerWarmUpWorkerEnable() && this.f30858d.size() < innerWarmup.getWorkerMaxWarmupSize() && !this.f30859e.get()) {
                    this.f30859e.set(true);
                    j.d(l0.a(w0.b()), null, null, new InnerWorkerPool$createWorker$1$1(this, application, null), 3, null);
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        com.cloud.tmc.integration.performance.innerworker.a aVar = this.f30861g;
        if (aVar != null) {
            aVar.b(1);
        }
        this.f30861g = null;
        return false;
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void destroy() {
        TmcLogger.c(this.f30855a, "InnerWorkerPool => destroy");
        Iterator<T> it = this.f30857c.iterator();
        while (it.hasNext()) {
            ((gd.b) it.next()).destroy();
        }
        this.f30857c.clear();
        Iterator<T> it2 = this.f30858d.iterator();
        while (it2.hasNext()) {
            ((gd.b) it2.next()).destroy();
        }
        this.f30858d.clear();
        this.f30860f = null;
        this.f30856b = null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public gd.b getWorker(String str) {
        TmcLogger.c(this.f30855a, "InnerWorkerPool => getWorker unUsedWorkerQueue = " + this.f30858d.size());
        gd.b bVar = null;
        if (this.f30858d.size() > 0) {
            Boolean boolA = this.f30858d.peek().a();
            Intrinsics.f(boolA, "unUsedWorkerQueue.peek().warmupSuccess()");
            if (boolA.booleanValue()) {
                gd.b bVarPoll = this.f30858d.poll();
                if (bVarPoll == null || !Intrinsics.b(bVarPoll.isRenderProcessGone(), Boolean.TRUE)) {
                    if (isValid(str, bVarPoll != null ? bVarPoll.getFrameworkVersion() : null)) {
                        this.f30857c.add(bVarPoll);
                        bVar = bVarPoll;
                    } else if (bVarPoll != null) {
                        bVarPoll.destroy();
                    }
                } else if (bVarPoll != null) {
                    bVarPoll.destroy();
                }
            }
        }
        String str2 = this.f30855a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InnerWorkerPool => getWorker success:");
        sb2.append(bVar != null);
        TmcLogger.c(str2, sb2.toString());
        return bVar;
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void init(Application context) {
        Intrinsics.g(context, "context");
        TmcLogger.c(this.f30855a, "worker init");
        this.f30856b = context;
    }

    public boolean isValid(String str, String str2) {
        return nb.b.a.a(this, str, str2);
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void preWarmupWorkerFail() {
        TmcLogger.c(this.f30855a, "InnerWorkerPool => preWarmupWorkerFail unUsedWorkerQueue = " + this.f30858d.size());
        com.cloud.tmc.integration.performance.innerworker.a aVar = this.f30861g;
        if (aVar != null) {
            aVar.b(2);
        }
        this.f30861g = null;
        if (this.f30858d.size() > 0) {
            int size = this.f30858d.size() - 1;
            gd.b bVar = this.f30858d.get(size);
            Intrinsics.f(bVar, "unUsedWorkerQueue[lastIndex]");
            this.f30858d.remove(size);
            bVar.destroy();
        }
        this.f30859e.set(false);
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void registerListener(com.cloud.tmc.integration.performance.innerworker.a listener, String str) {
        Intrinsics.g(listener, "listener");
        if (a(str)) {
            listener.a();
            return;
        }
        if (!this.f30859e.get()) {
            listener.b(0);
            return;
        }
        this.f30861g = listener;
        try {
            new Timer().schedule(new TimerTask() { // from class: com.cloud.tmc.integration.performance.innerworker.InnerWorkerPool.registerListener.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    com.cloud.tmc.integration.performance.innerworker.a aVar = InnerWorkerPool.this.f30861g;
                    if (aVar != null) {
                        aVar.b(3);
                    }
                    InnerWorkerPool.this.f30861g = null;
                    cancel();
                }
            }, ((InnerWarmupSettingData) k.d(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("innerWarmupSetting", "{\"renderWaitTime\":1500,\"workerWaitTime\":1500}"), InnerWarmupSettingData.class)).getWorkerWaitTime());
        } catch (Throwable unused) {
            com.cloud.tmc.integration.performance.innerworker.a aVar = this.f30861g;
            if (aVar != null) {
                aVar.b(4);
            }
            this.f30861g = null;
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void removeWorker(String workerId) {
        Intrinsics.g(workerId, "workerId");
        TmcLogger.c(this.f30855a, "InnerWorkerPool => removeWorker workerId = " + workerId);
        gd.b bVar = null;
        for (gd.b bVar2 : this.f30857c) {
            if (Intrinsics.b(bVar2.getWorkerId(), workerId)) {
                bVar = bVar2;
            }
        }
        if (bVar != null) {
            bVar.destroy();
            this.f30857c.remove(bVar);
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool
    public void warmupWorker(f fVar) {
        InnerWorkerWarmupManager innerWorkerWarmupManager;
        String str = this.f30855a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InnerWorkerPool => warmupWorker unUsedWorkerQueue = ");
        sb2.append(this.f30858d.size());
        sb2.append(" , canWarmup:");
        sb2.append(this.f30859e.get() && this.f30858d.size() > 0);
        TmcLogger.c(str, sb2.toString());
        if (!this.f30859e.get() || this.f30858d.size() <= 0 || (innerWorkerWarmupManager = this.f30860f) == null) {
            return;
        }
        gd.b last = this.f30858d.getLast();
        Intrinsics.f(last, "unUsedWorkerQueue.last");
        innerWorkerWarmupManager.b(last, fVar, new a(), this.f30861g);
    }
}
