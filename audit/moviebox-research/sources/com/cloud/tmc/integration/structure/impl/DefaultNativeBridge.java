package com.cloud.tmc.integration.structure.impl;

import ac.c;
import ac.d;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.point.NativeCallNotFoundPoint;
import com.cloud.tmc.kernel.point.NativeCallResultPoint;
import com.cloud.tmc.kernel.security.AccessControlException;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kc.b;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultNativeBridge implements NativeBridge {
    public static final String TAG = "TmcEngine:NativeBridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f30930a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EngineRouter f30931b;

    /* JADX INFO: compiled from: source.java */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f30932a;

        public a(c cVar) {
            this.f30932a = cVar;
        }

        @Override // ac.c
        public void a(HashMap<String, Object> map, boolean z11, boolean z12) {
            c cVar = this.f30932a;
            if (cVar != null) {
                cVar.a(map, z11, z12);
            }
        }

        @Override // ac.c
        public void b(JsonObject jsonObject, boolean z11, boolean z12) {
            c cVar = this.f30932a;
            if (cVar != null) {
                cVar.b(jsonObject, z11, z12);
            }
        }
    }

    public final boolean a(NativeCallContext nativeCallContext, @Nullable c cVar, boolean z11) {
        List<i> registeredRender;
        d dVarB;
        Page activePage;
        if (nativeCallContext == null) {
            TmcLogger.o(TAG, "executeNative but bridgeContext == null!");
            return false;
        }
        if (nativeCallContext.getNode() == null) {
            TmcLogger.o(TAG, "executeNative with node == null!!! may cause memory leak");
        }
        if (nativeCallContext.getRender() == null) {
            if (nativeCallContext.getNode() instanceof Page) {
                nativeCallContext.setRender(((Page) nativeCallContext.getNode()).getRender());
            } else if ((nativeCallContext.getNode() instanceof App) && (activePage = ((App) nativeCallContext.getNode()).getActivePage()) != null) {
                nativeCallContext.setRender(activePage.getRender());
            }
        }
        EngineRouter engineRouter = this.f30931b;
        if (engineRouter != null && (registeredRender = engineRouter.getRegisteredRender()) != null) {
            for (i iVar : registeredRender) {
                if (iVar.getRenderBridge() != null && (dVarB = iVar.getRenderBridge().b(nativeCallContext.getId())) != null) {
                    TmcLogger.c(TAG, "executeNative hit callback! " + nativeCallContext.getId());
                    dVarB.a(nativeCallContext.getParams());
                    return true;
                }
            }
        }
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            TmcLogger.o(TAG, "cannot dispatch empty API!");
            return true;
        }
        mc.a aVar = new mc.a(new a(cVar));
        aVar.p(nativeCallContext.getCallbackId());
        TmcLogger.c(TAG, "executeNative jsapi req name={" + nativeCallContext.getName() + "} " + nativeCallContext.getId() + " " + nativeCallContext.getParams());
        if (gb.a.f().b(nativeCallContext, aVar, z11)) {
            return true;
        }
        TmcLogger.o(TAG, "executeNative but not found Extension!" + nativeCallContext.getName());
        if (z11) {
            try {
                if (doCheckPermission(nativeCallContext, aVar)) {
                    return true;
                }
            } catch (AccessControlException unused) {
                TmcLogger.c(TAG, "executeNative check failed for legacy call! " + nativeCallContext.getName());
                aVar.m();
                return true;
            }
        }
        if (((NativeCallNotFoundPoint) ib.a.b(NativeCallNotFoundPoint.class).g(nativeCallContext.getNode()).d()).handleNotFound(nativeCallContext, aVar)) {
            TmcLogger.c(TAG, "executeNative handleNotFound intercepted");
            return true;
        }
        aVar.n();
        return false;
    }

    @Override // com.cloud.tmc.kernel.bridge.NativeBridge
    public void bindEngineRouter(EngineRouter engineRouter) {
        this.f30931b = engineRouter;
    }

    public boolean doCheckPermission(NativeCallContext nativeCallContext, mc.a aVar) throws AccessControlException {
        fb.d dVar = new fb.d(nativeCallContext, aVar, gb.a.f().e());
        ed.a aVar2 = new ed.a();
        aVar2.a(dVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kc.a(new b(nativeCallContext.getName(), nativeCallContext.getName())));
        if (aVar2.b(nativeCallContext.getNode(), arrayList, null)) {
            TmcLogger.c(TAG, "executeNative check pending! " + nativeCallContext.getName());
            return true;
        }
        TmcLogger.c(TAG, "executeNative check success! " + nativeCallContext.getName());
        return false;
    }

    public NativeCallResultPoint getNativeCallResultPoint(NativeCallContext nativeCallContext) {
        return (NativeCallResultPoint) ib.a.b(NativeCallResultPoint.class).g(nativeCallContext.getNode()).d();
    }

    public void onRelease() {
    }

    @Override // com.cloud.tmc.kernel.bridge.NativeBridge
    public final void release() {
        if (this.f30930a) {
            return;
        }
        this.f30930a = true;
        onRelease();
    }

    @Override // com.cloud.tmc.kernel.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable c cVar) {
        if (!this.f30930a && nativeCallContext != null) {
            return a(nativeCallContext, cVar, true);
        }
        TmcLogger.o(TAG, "sendToNative but released!");
        return false;
    }

    @Override // com.cloud.tmc.kernel.bridge.NativeBridge
    public boolean sendToNative(NativeCallContext nativeCallContext, @Nullable c cVar, boolean z11) {
        if (!this.f30930a && nativeCallContext != null) {
            return a(nativeCallContext, cVar, z11);
        }
        TmcLogger.o(TAG, "sendToNative but released!");
        return false;
    }
}
