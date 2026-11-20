package com.cloud.tmc.integration.performance.innerrender;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.KeyEvent;
import android.view.View;
import com.cloud.tmc.integration.model.InnerWarmup;
import com.cloud.tmc.integration.performance.InnerWarmupSettingData;
import com.cloud.tmc.integration.performance.WarmupType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniutils.util.k;
import com.cloud.tmc.miniutils.util.z;
import ee.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lb.f;
import zc.i;

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
public final class InnerRenderPool implements IInnerRenderPool, nb.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f30836b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InnerRenderWarmupManager f30840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.cloud.tmc.integration.performance.innerrender.a f30841g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30835a = "InnerWarmup";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<i> f30837c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<i> f30838d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f30839e = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements nb.a {
        public a() {
        }

        @Override // nb.a
        public void a(boolean z11) {
            if (!z11) {
                TmcLogger.c(InnerRenderPool.this.f30835a, "InnerRenderPool => warmupRender fail unUsedRenderQueue = " + InnerRenderPool.this.f30838d.size());
                InnerRenderPool.this.preWarmupRenderFail();
                return;
            }
            TmcLogger.c(InnerRenderPool.this.f30835a, "InnerRenderPool => warmupRender success unUsedRenderQueue = " + InnerRenderPool.this.f30838d.size());
            if (InnerRenderPool.this.f30838d.size() > 0) {
                ((i) InnerRenderPool.this.f30838d.getLast()).u();
                com.cloud.tmc.integration.performance.innerrender.a aVar = InnerRenderPool.this.f30841g;
                if (aVar != null) {
                    aVar.d();
                }
                InnerRenderPool.this.f30841g = null;
            }
            InnerRenderPool.this.f30839e.set(false);
        }
    }

    public static final void d(InnerRenderPool this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.g();
    }

    public static final void f(i render) {
        Intrinsics.g(render, "$render");
        render.destroy();
    }

    public static final void i(InnerRenderPool this$0, f fVar) {
        Intrinsics.g(this$0, "this$0");
        this$0.h(fVar);
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public boolean createRender(boolean z11) {
        TmcLogger.c(this.f30835a, "InnerRenderPool => createRender");
        try {
            String configString = ((ConfigService) tc.a.a(ConfigService.class)).getConfigString("innerWarmup", "{\"innerWarmUpRenderEnable\": true, \"innerWarmUpWorkerEnable\": true, \"renderMaxWarmupSize\": 1, \"workerMaxWarmupSize\": 1}");
            InnerWarmup innerWarmup = (InnerWarmup) k.d(configString, InnerWarmup.class);
            String str = this.f30835a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("InnerRenderPool => createRender ret:");
            sb2.append(configString);
            sb2.append(", canCreate:");
            sb2.append(innerWarmup.getInnerWarmUpRenderEnable() && this.f30838d.size() < innerWarmup.getRenderMaxWarmupSize() && !this.f30839e.get());
            sb2.append(", processName:");
            sb2.append(l.c());
            TmcLogger.c(str, sb2.toString());
            if (innerWarmup.getInnerWarmUpRenderEnable() && this.f30838d.size() < innerWarmup.getRenderMaxWarmupSize() && !this.f30839e.get()) {
                this.f30839e.set(true);
                e.f(new Runnable() { // from class: com.cloud.tmc.integration.performance.innerrender.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        InnerRenderPool.d(this.f30846a);
                    }
                });
                return true;
            }
        } catch (Throwable unused) {
        }
        com.cloud.tmc.integration.performance.innerrender.a aVar = this.f30841g;
        if (aVar != null) {
            aVar.b(1);
        }
        this.f30841g = null;
        return false;
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void destroy() {
        TmcLogger.c(this.f30835a, "InnerRenderPool => destroy");
        Iterator<T> it = this.f30837c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i iVar = (i) it.next();
            View view = iVar.getView();
            Context context = view != null ? view.getContext() : null;
            MutableContextWrapper mutableContextWrapper = context instanceof MutableContextWrapper ? (MutableContextWrapper) context : null;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(this.f30836b);
            }
            iVar.destroy();
        }
        this.f30837c.clear();
        Iterator<T> it2 = this.f30838d.iterator();
        while (it2.hasNext()) {
            ((i) it2.next()).destroy();
        }
        this.f30838d.clear();
        this.f30840f = null;
        this.f30836b = null;
    }

    public final boolean e(String str) {
        i iVarPeek;
        if (this.f30838d.size() <= 0 || (iVarPeek = this.f30838d.peek()) == null || !iVarPeek.a()) {
            return false;
        }
        i iVarPeek2 = this.f30838d.peek();
        KeyEvent.Callback view = iVarPeek2 != null ? iVarPeek2.getView() : null;
        yc.a aVar = view instanceof yc.a ? (yc.a) view : null;
        if (aVar == null || !Intrinsics.b(aVar.isRenderProcessGone(), Boolean.TRUE)) {
            if (isValid(str, iVarPeek2 != null ? iVarPeek2.getFrameworkVersion() : null)) {
                return true;
            }
        }
        i iVarPoll = this.f30838d.poll();
        if (iVarPoll == null) {
            return false;
        }
        iVarPoll.destroy();
        return false;
    }

    public final void g() {
        j jVar = new j(new MutableContextWrapper(this.f30836b), null, null, null, 0, 16, null);
        jVar.A(2);
        this.f30838d.add(jVar);
        com.cloud.tmc.integration.performance.innerrender.a aVar = this.f30841g;
        if (aVar != null) {
            aVar.c();
        }
        TmcLogger.c(this.f30835a, "InnerRenderPool => addRender unUsedRenderQueue = " + this.f30838d.size());
        InnerRenderWarmupManager innerRenderWarmupManager = new InnerRenderWarmupManager();
        this.f30840f = innerRenderWarmupManager;
        Application application = this.f30836b;
        if (application != null) {
            innerRenderWarmupManager.b(application, WarmupType.INNER_RENNDER.getType());
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00ac  */
    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public i getRender(Activity context, String str) {
        i iVarPeek;
        View view;
        Intrinsics.g(context, "context");
        TmcLogger.c(this.f30835a, "InnerRenderPool => getRender unUsedRenderQueue = " + this.f30838d.size());
        i iVar = null;
        iVar = null;
        iVar = null;
        iVar = null;
        if (this.f30838d.size() > 0 && (iVarPeek = this.f30838d.peek()) != null && iVarPeek.a()) {
            i iVarPoll = this.f30838d.poll();
            Object view2 = iVarPoll != null ? iVarPoll.getView() : null;
            yc.a aVar = view2 instanceof yc.a ? (yc.a) view2 : null;
            if (aVar == null || !Intrinsics.b(aVar.isRenderProcessGone(), Boolean.TRUE)) {
                if (isValid(str, iVarPoll != null ? iVarPoll.getFrameworkVersion() : null) && iVarPoll != null && Intrinsics.b(iVarPoll.g(), Boolean.valueOf(z.a(context)))) {
                    Context context2 = (iVarPoll == null || (view = iVarPoll.getView()) == null) ? null : view.getContext();
                    MutableContextWrapper mutableContextWrapper = context2 instanceof MutableContextWrapper ? (MutableContextWrapper) context2 : null;
                    if (mutableContextWrapper != null) {
                        mutableContextWrapper.setBaseContext(context);
                    }
                    if (iVarPoll != null) {
                        iVarPoll.o(context);
                    }
                    this.f30837c.add(iVarPoll);
                    iVar = iVarPoll;
                } else {
                    iVarPoll.destroy();
                }
            } else {
                iVarPoll.destroy();
            }
        }
        String str2 = this.f30835a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InnerRenderPool => getRender success:");
        sb2.append(iVar != null);
        TmcLogger.c(str2, sb2.toString());
        return iVar;
    }

    public final void h(f fVar) {
        if (!this.f30839e.get() || this.f30838d.size() <= 0) {
            return;
        }
        i iVarPeek = this.f30838d.peek();
        if (iVarPeek != null) {
            iVarPeek.m(z.a(this.f30836b));
        }
        InnerRenderWarmupManager innerRenderWarmupManager = this.f30840f;
        if (innerRenderWarmupManager != null) {
            i last = this.f30838d.getLast();
            Intrinsics.f(last, "unUsedRenderQueue.last");
            innerRenderWarmupManager.c(last, fVar, new a());
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void init(Application context) {
        Intrinsics.g(context, "context");
        TmcLogger.c(this.f30835a, "render init");
        this.f30836b = context;
    }

    public boolean isValid(String str, String str2) {
        return nb.b.a.a(this, str, str2);
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void preWarmupRenderFail() {
        TmcLogger.c(this.f30835a, "InnerRenderPool => preWarmupFail unUsedRenderQueue = " + this.f30838d.size());
        com.cloud.tmc.integration.performance.innerrender.a aVar = this.f30841g;
        if (aVar != null) {
            aVar.b(2);
        }
        this.f30841g = null;
        if (this.f30838d.size() > 0) {
            int size = this.f30838d.size() - 1;
            i iVar = this.f30838d.get(size);
            Intrinsics.f(iVar, "unUsedRenderQueue[lastIndex]");
            final i iVar2 = iVar;
            this.f30838d.remove(size);
            e.f(new Runnable() { // from class: com.cloud.tmc.integration.performance.innerrender.c
                @Override // java.lang.Runnable
                public final void run() {
                    InnerRenderPool.f(iVar2);
                }
            });
        }
        this.f30839e.set(false);
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void registerListener(com.cloud.tmc.integration.performance.innerrender.a listener, boolean z11, String str) {
        Intrinsics.g(listener, "listener");
        if (e(str)) {
            listener.a();
            return;
        }
        if (!this.f30839e.get()) {
            listener.b(0);
            return;
        }
        this.f30841g = listener;
        try {
            new Timer().schedule(new TimerTask() { // from class: com.cloud.tmc.integration.performance.innerrender.InnerRenderPool.registerListener.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    com.cloud.tmc.integration.performance.innerrender.a aVar = InnerRenderPool.this.f30841g;
                    if (aVar != null) {
                        aVar.b(3);
                    }
                    InnerRenderPool.this.f30841g = null;
                    cancel();
                }
            }, z11 ? ((InnerWarmupSettingData) k.d(((ConfigService) tc.a.a(ConfigService.class)).getConfigString("innerWarmupSetting", "{\"renderWaitTime\":1500,\"workerWaitTime\":1500}"), InnerWarmupSettingData.class)).getRenderWaitTime() : 0L);
        } catch (Throwable unused) {
            com.cloud.tmc.integration.performance.innerrender.a aVar = this.f30841g;
            if (aVar != null) {
                aVar.b(4);
            }
            this.f30841g = null;
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void removeRender(String str) {
        TmcLogger.c(this.f30835a, "InnerRenderPool => removeRender renderId = " + str);
        i iVar = null;
        for (i iVar2 : this.f30837c) {
            if (Intrinsics.b(iVar2.b(), str)) {
                iVar = iVar2;
            }
        }
        if (iVar != null) {
            View view = iVar.getView();
            Context context = view != null ? view.getContext() : null;
            MutableContextWrapper mutableContextWrapper = context instanceof MutableContextWrapper ? (MutableContextWrapper) context : null;
            if (mutableContextWrapper != null) {
                mutableContextWrapper.setBaseContext(this.f30836b);
            }
            iVar.destroy();
            this.f30837c.remove(iVar);
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool
    public void warmupRender(final f fVar) {
        String str = this.f30835a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InnerRenderPool => warmupRender unUsedRenderQueue = ");
        sb2.append(this.f30838d.size());
        sb2.append(" , canWarmup:");
        sb2.append(this.f30839e.get() && this.f30838d.size() > 0);
        TmcLogger.c(str, sb2.toString());
        e.f(new Runnable() { // from class: com.cloud.tmc.integration.performance.innerrender.d
            @Override // java.lang.Runnable
            public final void run() {
                InnerRenderPool.i(this.f30848a, fVar);
            }
        });
    }
}
