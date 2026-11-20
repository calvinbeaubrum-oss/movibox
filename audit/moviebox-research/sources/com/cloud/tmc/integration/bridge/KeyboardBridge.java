package com.cloud.tmc.integration.bridge;

import android.util.Log;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class KeyboardBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uc.c f30488a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements uc.c {
        public a() {
        }

        @Override // uc.c
        public boolean O(uc.a aVar) {
            bc.a aVar2;
            if (aVar != null && aVar.getData() != null) {
                Map<String, Object> data = aVar.getData();
                Object obj = data.get("page");
                Object obj2 = data.get("height");
                if ((obj instanceof Page) && (obj2 instanceof String)) {
                    Page page = (Page) obj;
                    String str = (String) obj2;
                    App app = page.getApp();
                    if (app == null || (aVar2 = (bc.a) KeyboardBridge.this.a(app).get(page.getPageId())) == null) {
                        return true;
                    }
                    aVar2.d(z.a().c("height", Integer.valueOf(Integer.parseInt(str))).e());
                }
            }
            return true;
        }
    }

    @NonNull
    public final WeakHashMap<String, bc.a> a(@NonNull App app) {
        lb.d dVar = (lb.d) app.getData(lb.d.class, true);
        return dVar == null ? new WeakHashMap<>() : dVar.a();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    public void checkEventSubscriber(App app, boolean z11) {
        TmcLogger.c("KeyboardBridge", "checkEventSubscriber: register=" + z11 + " " + Log.getStackTraceString(new Throwable("Just print")));
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(app);
        if (eventCenterInstance == null) {
            return;
        }
        if (!z11) {
            eventCenterInstance.c("onKeyboardHeightChange", this.f30488a);
        } else {
            if (eventCenterInstance.e("onKeyboardHeightChange")) {
                return;
            }
            eventCenterInstance.b("onKeyboardHeightChange", this.f30488a);
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void hideKeyboard(@cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (page == null || page.getPageContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).hideKeyboard(page.getPageContext().v());
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void offKeyboardHeightChange(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (app == null || page == null || page.getPageContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            bc.a aVarRemove = a(app).remove(page.getPageId());
            if (aVarRemove != null) {
                aVarRemove.close();
            }
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("KeyboardBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("KeyboardBridge", "onInitialized");
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void onKeyboardHeightChange(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c(isSticky = true) bc.a aVar) {
        bc.a aVar2;
        if (app == null || page == null || page.getPageContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            WeakHashMap<String, bc.a> weakHashMapA = a(app);
            if (weakHashMapA.containsKey(page.getPageId()) && (aVar2 = weakHashMapA.get(page.getPageId())) != null) {
                aVar2.close();
            }
            weakHashMapA.put(page.getPageId(), aVar);
            checkEventSubscriber(app, true);
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }
}
