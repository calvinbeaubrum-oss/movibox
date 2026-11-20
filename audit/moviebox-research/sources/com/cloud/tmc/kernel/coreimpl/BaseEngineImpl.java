package com.cloud.tmc.kernel.coreimpl;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.IBridgeFactory;
import com.cloud.tmc.kernel.service.EnvironmentService;
import rc.c;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseEngineImpl implements IEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f31148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NativeBridge f31150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EngineRouter f31151d;
    protected c initParams;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f31153f = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f31152e = ((EnvironmentService) tc.a.a(EnvironmentService.class)).getApplicationContext();

    public BaseEngineImpl(String str, Node node) {
        this.f31148a = node;
        this.f31149b = str;
        NativeBridge nativeBridgeCreateNativeBridge = createNativeBridge();
        this.f31150c = nativeBridgeCreateNativeBridge;
        nativeBridgeCreateNativeBridge.bindEngineRouter(this.f31151d);
    }

    public NativeBridge createNativeBridge() {
        return ((IBridgeFactory) tc.a.a(IBridgeFactory.class)).createNativeBridge();
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public final synchronized void destroy() {
        if (this.f31153f) {
            return;
        }
        this.f31153f = true;
        onDestroy();
        this.f31150c.release();
        ic.c.a().d(this);
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public String getAppId() {
        return this.f31149b;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public Context getApplication() {
        return this.f31152e;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public NativeBridge getBridge() {
        return this.f31150c;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public EngineRouter getEngineRouter() {
        return this.f31151d;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public String getEngineType() {
        return "WEB";
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public Node getNode() {
        return this.f31148a;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public Bundle getStartParams() {
        c cVar = this.initParams;
        if (cVar == null) {
            return null;
        }
        return cVar.f75175a;
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public i getTopRender() {
        return this.f31151d.getRenderById(null);
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    @CallSuper
    public void init(c cVar, ic.a aVar) {
        this.initParams = cVar;
        this.f31151d = ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).get(cVar.f75177c);
        ic.c.a().c(this);
    }

    @Override // com.cloud.tmc.kernel.engine.IEngine
    public boolean isDestroyed() {
        return this.f31153f;
    }

    public void onDestroy() {
        EngineRouter engineRouter = this.f31151d;
        if (engineRouter != null) {
            engineRouter.destroy();
            ((EngineRouterManager) tc.a.a(EngineRouterManager.class)).remove(this.f31151d);
        }
    }

    public void setNativeBridge(@NonNull NativeBridge nativeBridge) {
        this.f31150c = nativeBridge;
    }
}
