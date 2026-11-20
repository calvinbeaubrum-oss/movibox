package l;

import OooOO0.OooO0o;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cloud.tmc.integration.proxy.IKeyboardProxy;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle;
import com.cloud.tmc.kernel.node.Node;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends pc.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final zc.i f69724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f69725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OooO0o f69726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f69727i;

    /* JADX INFO: compiled from: source.java */
    public final class a implements m.a {
        public a() {
        }

        public static final void b(c this$0, String eventName, JsonObject json) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(eventName, "$eventName");
            Intrinsics.g(json, "$json");
            try {
                TmcLogger.f(this$0.f69725g, "onWebviewEvent eventName=" + eventName + " $ json = " + json);
                this$0.n(eventName, json);
            } catch (Throwable th2) {
                TmcLogger.g(this$0.f69725g, "onWebviewEvent", th2);
            }
        }

        @Override // m.a
        public void a(final String eventName, final JsonObject json) {
            Intrinsics.g(eventName, "eventName");
            Intrinsics.g(json, "json");
            try {
                ExecutorType executorType = ExecutorType.IO;
                final c cVar = c.this;
                com.cloud.tmc.kernel.utils.e.a(executorType, new Runnable() { // from class: l.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a.b(cVar, eventName, json);
                    }
                });
            } catch (Throwable th2) {
                TmcLogger.g(c.this.f69725g, "onWebviewEvent", th2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String renderId, String viewId, zc.i render) {
        super(context, renderId, viewId, render);
        Intrinsics.g(context, "context");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(render, "render");
        this.f69724f = render;
        this.f69725g = "NativeWebViewComponent";
        this.f69726h = new OooO0o(viewId, context, new WeakReference(render.getActivity()), null);
        this.f69727i = new a();
    }

    @Override // pc.a
    public String b() {
        return "native-webview";
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void c() {
        try {
            this.f69726h.OooO0oo();
        } catch (Throwable th2) {
            TmcLogger.g(this.f69725g, "onRemove", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void d(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        try {
            this.f69726h.OooO00o(jsonObject, BaseComponentLifecycle.ViewAction.ON_UPDATE_VIEW);
            onViewChangeCallback.onSuccess();
        } catch (Throwable th2) {
            TmcLogger.g(this.f69725g, "onUpdateView", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void e(JsonObject jsonObject, qc.b onViewChangeCallback) {
        Intrinsics.g(onViewChangeCallback, "onViewChangeCallback");
        try {
            OooO0o oooO0o = this.f69726h;
            oooO0o.f169OooO0o = this.f69727i;
            oooO0o.OooO00o(jsonObject, BaseComponentLifecycle.ViewAction.ON_ADD_VIEW);
            Node node = this.f69724f.i();
            if (node != null) {
                this.f69726h.OooO00o(node);
                OooO0o oooO0o2 = this.f69726h;
                oooO0o2.getClass();
                Intrinsics.g(node, "node");
                try {
                    PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
                    if (pageNode != null) {
                        pageNode.addOnKeyboardListener(oooO0o2);
                    }
                } catch (Throwable th2) {
                    TmcLogger.g(oooO0o2.OooO0OO, "", th2);
                }
            }
            onViewChangeCallback.onSuccess();
        } catch (Throwable th3) {
            TmcLogger.g(this.f69725g, "onAddView", th3);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void f() {
        try {
            this.f69726h.OooO0o();
            OooO0o oooO0o = this.f69726h;
            Node node = this.f69724f.i();
            Intrinsics.f(node, "render.page");
            oooO0o.getClass();
            Intrinsics.g(node, "node");
            try {
                PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
                if (pageNode != null) {
                    pageNode.removeOnKeyboardListener(oooO0o);
                    return;
                }
                return;
            } catch (Throwable th2) {
                TmcLogger.g(oooO0o.OooO0OO, "", th2);
                return;
            }
        } catch (Throwable th3) {
            TmcLogger.g(this.f69725g, "onDestory", th3);
        }
        TmcLogger.g(this.f69725g, "onDestory", th3);
    }

    @Override // pc.a
    public View g() {
        return this.f69726h;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // pc.a
    public void l(String methodName, JsonObject args, qc.a callback) {
        Intrinsics.g(methodName, "methodName");
        Intrinsics.g(args, "args");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.f(this.f69725g, "onEventMessage method = " + methodName + ", args = " + args);
            switch (methodName.hashCode()) {
                case -1691085464:
                    if (!methodName.equals("loadDataWithBaseURL")) {
                        break;
                    } else {
                        JsonElement jsonElement = args.get("baseUrl");
                        String asString = jsonElement != null ? jsonElement.getAsString() : null;
                        if (asString != null) {
                            JsonElement jsonElement2 = args.get("pageHtmlData");
                            String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                            if (asString2 != null) {
                                JsonElement jsonElement3 = args.get("mimeType");
                                String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                                if (asString3 == null) {
                                    asString3 = "text/html";
                                }
                                JsonElement jsonElement4 = args.get("encoding");
                                String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                                if (asString4 == null) {
                                    asString4 = "UTF-8";
                                }
                                this.f69726h.OooO00o(asString, asString2, asString3, asString4);
                                qc.a.C0817a.a(callback, null, 1, null);
                                break;
                            }
                        }
                    }
                    break;
                case -1241591313:
                    if (methodName.equals("goBack")) {
                        if (this.f69726h.OooO00o()) {
                            qc.a.C0817a.a(callback, null, 1, null);
                        }
                        this.f69726h.OooOO0o();
                    }
                    break;
                case -934641255:
                    if (methodName.equals("reload")) {
                        this.f69726h.OooOO0O();
                        qc.a.C0817a.a(callback, null, 1, null);
                    }
                    break;
                case -318289731:
                    if (methodName.equals("goForward")) {
                        if (this.f69726h.f170OooO0o0.canGoForward()) {
                            this.f69726h.f170OooO0o0.goForward();
                            qc.a.C0817a.a(callback, null, 1, null);
                        }
                        this.f69726h.OooOO0o();
                    }
                    break;
                case 233302058:
                    if (methodName.equals("getPageUrl")) {
                        callback.a(com.cloud.tmc.kernel.utils.h.a().d("pageUrl", this.f69726h.getPageUrl()));
                    }
                    break;
                case 336631465:
                    if (!methodName.equals("loadUrl")) {
                        break;
                    } else {
                        JsonElement jsonElement5 = args.get("url");
                        String asString5 = jsonElement5 != null ? jsonElement5.getAsString() : null;
                        if (asString5 != null) {
                            this.f69726h.OooO0O0(asString5);
                            qc.a.C0817a.a(callback, null, 1, null);
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        } catch (Throwable th2) {
            TmcLogger.g(this.f69725g, "onEventMessage", th2);
        }
    }

    @Override // pc.a
    public boolean m() {
        tb.d pageContext;
        ViewGroup viewGroupV;
        try {
            TmcLogger.c(this.f69725g, "hide keyboard->" + this.f69726h.OooO0Oo());
            if (!this.f69726h.OooO0Oo()) {
                if (!this.f69726h.OooO00o()) {
                    TmcLogger.c(this.f69725g, "onInterceptBackPressed -> false");
                    return false;
                }
                TmcLogger.c(this.f69725g, "onInterceptBackPressed -> true");
                this.f69726h.OooOO0o();
                return true;
            }
            try {
                Node nodeI = this.f69724f.i();
                PageNode pageNode = nodeI instanceof PageNode ? (PageNode) nodeI : null;
                if (pageNode != null && (pageContext = pageNode.getPageContext()) != null && (viewGroupV = pageContext.v()) != null) {
                    ((IKeyboardProxy) tc.a.a(IKeyboardProxy.class)).hideKeyboard(viewGroupV);
                }
                TmcLogger.c(this.f69725g, "hide keyboard");
                return true;
            } catch (Throwable th2) {
                TmcLogger.g(this.f69725g, "hide keyboard error ", th2);
                return false;
            }
        } catch (Throwable th3) {
            TmcLogger.g(this.f69725g, "onInterceptBackPressed", th3);
            return false;
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onPause() {
        try {
            this.f69726h.OooO0oO();
        } catch (Throwable th2) {
            TmcLogger.g(this.f69725g, "onPause", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onResume() {
        try {
            this.f69726h.OooO();
        } catch (Throwable th2) {
            TmcLogger.g(this.f69725g, "onResume", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.minicover.lifecycle.BaseComponentLifecycle
    public void onStop() {
        try {
            this.f69726h.OooOO0();
        } catch (Throwable unused) {
            TmcLogger.f(this.f69725g, "onStop");
        }
    }
}
