package com.cloud.tmc.integration.performance.innerwebview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import com.cloud.tmc.integration.model.InnerWebviewWarmup;
import com.cloud.tmc.integration.performance.innerwebview.InnerH5WebviewPool;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.coreimpl.DefaultEngineRouter;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.l;
import com.cloud.tmc.miniutils.util.k;
import ee.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import nb.c;
import tc.a;
import zc.i;

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
@SourceDebugExtension
public final class InnerH5WebviewPool implements IInnerH5WebviewPool {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f30851b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30850a = "InnerH5WebviewPool";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<i> f30852c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<i> f30853d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicBoolean f30854e = new AtomicBoolean(false);

    public static final void b(InnerH5WebviewPool this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.c();
    }

    public final void c() {
        TmcLogger.c(this.f30850a, "H5WebviewPool => realCreateRender unUsedWebviewQueue = " + this.f30853d.size());
        j jVar = new j(new MutableContextWrapper(this.f30851b), null, null, null, MiniAppType.SHELL.ordinal());
        jVar.A(2);
        String str = "warmup_render_id__" + c.f71783a.a().addAndGet(1);
        Node node = ((WarmupNode) a.a(WarmupNode.class)).getNode(str);
        jVar.h(new DefaultEngineRouter());
        jVar.q("99999");
        jVar.p(node);
        jVar.init(str);
        this.f30853d.add(jVar);
        this.f30854e.set(false);
        TmcLogger.c(this.f30850a, "H5WebviewPool => realCreateRender finished unUsedWebviewQueue = " + this.f30853d.size());
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public boolean createWebview() {
        try {
            String configString = ((ConfigService) a.a(ConfigService.class)).getConfigString("innerWebviewWarmupV3", "{\"innerWarmUpWebviewEnable\": true, \"webviewMaxWarmupSize\": 1}");
            InnerWebviewWarmup innerWebviewWarmup = (InnerWebviewWarmup) k.d(configString, InnerWebviewWarmup.class);
            String str = this.f30850a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("H5WebviewPool => createWebview ret:");
            sb2.append(configString);
            sb2.append(", canCreate:");
            sb2.append(innerWebviewWarmup.getInnerWarmUpWebviewEnable() && this.f30853d.size() < innerWebviewWarmup.getWebviewMaxWarmupSize() && !this.f30854e.get());
            sb2.append(", processName:");
            sb2.append(l.c());
            TmcLogger.c(str, sb2.toString());
            if (innerWebviewWarmup.getInnerWarmUpWebviewEnable() && this.f30853d.size() < innerWebviewWarmup.getWebviewMaxWarmupSize() && !this.f30854e.get()) {
                this.f30854e.set(true);
                e.f(new Runnable() { // from class: ob.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        InnerH5WebviewPool.b(this.f72394a);
                    }
                });
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public void destroy() {
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public synchronized i getWebview(Activity context) {
        i iVar;
        View view;
        try {
            Intrinsics.g(context, "context");
            TmcLogger.c(this.f30850a, "H5WebviewPool => getWebview unUsedWebviewQueue = " + this.f30853d.size());
            iVar = null;
            iVar = null;
            if (this.f30853d.size() > 0) {
                i iVarPoll = this.f30853d.poll();
                Object view2 = iVarPoll != null ? iVarPoll.getView() : null;
                yc.a aVar = view2 instanceof yc.a ? (yc.a) view2 : null;
                if (aVar == null || !Intrinsics.b(aVar.isRenderProcessGone(), Boolean.TRUE)) {
                    Context context2 = (iVarPoll == null || (view = iVarPoll.getView()) == null) ? null : view.getContext();
                    MutableContextWrapper mutableContextWrapper = context2 instanceof MutableContextWrapper ? (MutableContextWrapper) context2 : null;
                    if (mutableContextWrapper != null) {
                        mutableContextWrapper.setBaseContext(context);
                    }
                    if (iVarPoll != null) {
                        iVarPoll.o(context);
                    }
                    this.f30852c.add(iVarPoll);
                    iVar = iVarPoll;
                } else {
                    iVarPoll.destroy();
                }
            }
            String str = this.f30850a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("H5WebviewPool => getWebview success:");
            sb2.append(iVar != null);
            TmcLogger.c(str, sb2.toString());
        } catch (Throwable th2) {
            throw th2;
        }
        return iVar;
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public void init(Application context) {
        Intrinsics.g(context, "context");
        this.f30851b = context;
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public void registerListener(ob.a listener) {
        Intrinsics.g(listener, "listener");
    }

    @Override // com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool
    public void removeWebview(i iVar, boolean z11) {
        View view;
        String str = this.f30850a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("H5WebviewPool => removeWebview render.hasCode = ");
        sb2.append(iVar != null ? Integer.valueOf(iVar.hashCode()) : null);
        TmcLogger.c(str, sb2.toString());
        i iVar2 = null;
        for (i iVar3 : this.f30852c) {
            if (iVar != null && iVar3.hashCode() == iVar.hashCode()) {
                iVar2 = iVar3;
            }
        }
        if (iVar2 != null) {
            if (z11) {
                TmcLogger.c(this.f30850a, "H5WebviewPool => real destroy");
                Context context = (iVar == null || (view = iVar.getView()) == null) ? null : view.getContext();
                MutableContextWrapper mutableContextWrapper = context instanceof MutableContextWrapper ? (MutableContextWrapper) context : null;
                if (mutableContextWrapper != null) {
                    mutableContextWrapper.setBaseContext(this.f30851b);
                }
                iVar2.destroy();
            }
            this.f30852c.remove(iVar2);
        }
    }
}
