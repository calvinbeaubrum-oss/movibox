package com.cloud.tmc.worker.debug;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.performanceanalyse.BuildConfigProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.worker.debug.WebviewWorker;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gd.e;
import ge.f;
import ge.j;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class WebviewWorker extends WebView implements gd.a, yc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Node f32161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f32162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f32163d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gd.d f32164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ExecutorService f32165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f32166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f32167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public me.b f32168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebMessagePort f32169k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class MyJavascriptInterface {
        public MyJavascriptInterface() {
        }

        @JavascriptInterface
        public final void workerSendToNative(String result) {
            Intrinsics.g(result, "result");
            p.e("miniapp", "workerSendToNative DefaultChannel = " + result);
            JsonObject asJsonObject = JsonParser.parseString(result).getAsJsonObject();
            if (asJsonObject.has("abilityName") && Intrinsics.b(asJsonObject.get("abilityName").getAsString(), "debugRefresh")) {
                hc.c.b();
                return;
            }
            gd.d dVar = WebviewWorker.this.f32164f;
            if (dVar != null) {
                dVar.a(asJsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ValueCallback<String> {
        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ValueCallback<String> {
        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements ValueCallback<String> {
        @Override // android.webkit.ValueCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends WebMessagePort.WebMessageCallback {
        public d() {
        }

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort port, WebMessage message) {
            Intrinsics.g(port, "port");
            Intrinsics.g(message, "message");
            String data = message.getData();
            p.e("miniapp", "workerSendToNative MessageChannel = " + data);
            JsonObject asJsonObject = JsonParser.parseString(data).getAsJsonObject();
            if (asJsonObject.has("abilityName") && Intrinsics.b(asJsonObject.get("abilityName").getAsString(), "debugRefresh")) {
                hc.c.b();
                return;
            }
            gd.d dVar = WebviewWorker.this.f32164f;
            if (dVar != null) {
                dVar.a(asJsonObject);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WebviewWorker(String str, Node node, Context context) {
        this(str, node, context, null, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WebviewWorker(String str, Node node, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f32160a = str;
        this.f32161b = node;
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.d(mainLooper);
        this.f32166h = new Handler(mainLooper);
    }

    public /* synthetic */ WebviewWorker(String str, Node node, Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, node, context, (i11 & 8) != 0 ? null : attributeSet);
    }

    public static final void k(final WebviewWorker this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f32166h.post(new Runnable() { // from class: me.n
            @Override // java.lang.Runnable
            public final void run() {
                WebviewWorker.l(this.f71019a);
            }
        });
    }

    public static final void l(WebviewWorker this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            Boolean boolIsDebug = ((BuildConfigProxy) tc.a.a(BuildConfigProxy.class)).isDebug();
            Intrinsics.f(boolIsDebug, "get(BuildConfigProxy::class.java).isDebug");
            if (boolIsDebug.booleanValue()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        } catch (Throwable unused) {
        }
        me.b bVar = new me.b(this$0.f32160a, this$0.f32161b, this$0);
        this$0.f32168j = bVar;
        this$0.setWebViewClient(bVar);
        this$0.setWebChromeClient(new me.a());
        WebSettings settings = this$0.getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        this$0.addJavascriptInterface(this$0.new MyJavascriptInterface(), "debug");
        e eVar = this$0.f32163d;
        if (eVar != null) {
            eVar.onCreate();
        }
    }

    public static final void m(final WebviewWorker this$0, final JsonObject jsonObject) {
        Intrinsics.g(this$0, "this$0");
        this$0.f32166h.post(new Runnable() { // from class: me.e
            @Override // java.lang.Runnable
            public final void run() {
                WebviewWorker.n(jsonObject, this$0);
            }
        });
    }

    public static final void n(JsonObject jsonObject, WebviewWorker this$0) {
        Intrinsics.g(this$0, "this$0");
        if (jsonObject != null) {
            jsonObject.addProperty("time", Long.valueOf(System.currentTimeMillis()));
        }
        this$0.o(jsonObject);
    }

    public static final void p(final WebviewWorker this$0, final String filePath) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(filePath, "$filePath");
        this$0.f32166h.post(new Runnable() { // from class: me.m
            @Override // java.lang.Runnable
            public final void run() {
                WebviewWorker.q(filePath, this$0);
            }
        });
    }

    public static final void q(String filePath, WebviewWorker this$0) {
        Intrinsics.g(filePath, "$filePath");
        Intrinsics.g(this$0, "this$0");
        try {
            if (!new File(filePath).exists()) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : js path : " + filePath + " is not exist");
                return;
            }
            int iJ0 = StringsKt__StringsKt.j0(filePath, "/", 0, false, 6, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append('.');
            String strSubstring = filePath.substring(iJ0, filePath.length());
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(strSubstring);
            String string = sb2.toString();
            StringBuffer stringBuffer = new StringBuffer();
            Map<String, String> parasm = ((JSAheadParamsProxy) tc.a.a(JSAheadParamsProxy.class)).getParasm();
            Intrinsics.f(parasm, "get(JSAheadParamsProxy::class.java).parasm");
            for (Map.Entry<String, String> entry : parasm.entrySet()) {
                stringBuffer.append("var " + entry.getKey() + " = \"" + entry.getValue() + "\";\n");
            }
            this$0.loadDataWithBaseURL("https://100000.miniapp.transsion.com", "<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<meta charset=\"utf-8\" />\n\t\t<title></title>\n\t</head>\n\t<script>\n\t" + ((Object) stringBuffer) + "\n\tvar global = window;\n\t\twindow.onload = function(){\n\u3000\u3000\u3000\u3000var script = document.createElement(\"script\");\n\u3000\u3000\u3000\u3000script.setAttribute(\"type\",\"text/javascript\");\n\u3000\u3000\u3000\u3000script.src = \"" + string + "\";\n\u3000\u3000\u3000\u3000document.getElementsByTagName(\"head\")[0].appendChild(script);  \n\u3000\u3000}\t</script></html>\n", "text/html", "utf-8", null);
        } catch (Exception e11) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : Exception = " + e11);
        }
    }

    public static final void r(final WebviewWorker this$0, final String script) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(script, "$script");
        this$0.f32166h.post(new Runnable() { // from class: me.f
            @Override // java.lang.Runnable
            public final void run() {
                WebviewWorker.s(this.f71002a, script);
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void s(WebviewWorker this$0, String script) {
        String strValueOf;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(script, "$script");
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.LOAD_JS_START, null);
        boolean z11 = false;
        try {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.LOAD_JS_END, null);
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_WORKER_READY, "");
            this$0.evaluateJavascript(script, new b());
            z11 = true;
            strValueOf = "";
        } catch (Error e11) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : Error = " + e11);
            strValueOf = String.valueOf(e11);
        } catch (Exception e12) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : Exception = " + e12);
            strValueOf = String.valueOf(e12);
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("abilityName", "callback");
        jsonObject.addProperty("callbackId", "");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("eventName", "loadWorkerJS");
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("result", String.valueOf(z11));
        jsonObject3.addProperty(NotificationCompat.CATEGORY_MESSAGE, strValueOf);
        jsonObject2.add("dataJson", jsonObject3);
        jsonObject.add("dataJson", jsonObject2);
        jsonObject.addProperty("source", "worker");
        jsonObject.addProperty("target", "render");
        gd.d dVar = this$0.f32164f;
        if (dVar != null) {
            dVar.a(jsonObject);
        }
    }

    public static final void t(final WebviewWorker this$0, final String str, final Map map) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(map, "$map");
        this$0.f32166h.post(new Runnable() { // from class: me.l
            @Override // java.lang.Runnable
            public final void run() {
                WebviewWorker.u(str, map, this$0);
            }
        });
    }

    public static final void u(String str, Map map, WebviewWorker this$0) {
        Intrinsics.g(map, "$map");
        Intrinsics.g(this$0, "this$0");
        this$0.evaluateJavascript("var " + str + " = " + map, new c());
    }

    @Override // gd.a
    @SuppressLint({"JavascriptInterface"})
    public void create() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f32165g = executorServiceNewSingleThreadExecutor;
        if (executorServiceNewSingleThreadExecutor != null) {
            executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: me.i
                @Override // java.lang.Runnable
                public final void run() {
                    WebviewWorker.k(this.f71008a);
                }
            });
        }
    }

    @Override // android.webkit.WebView, gd.a
    public void destroy() {
        if (this.f32162c) {
            return;
        }
        this.f32162c = true;
        clearHistory();
        e eVar = this.f32163d;
        if (eVar != null) {
            eVar.onDestroy();
        }
        this.f32165g = null;
        super.destroy();
        this.f32161b = null;
        this.f32168j = null;
    }

    @Override // gd.a
    public void execute(final JsonObject jsonObject) {
        ExecutorService executorService = this.f32165g;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: me.h
                @Override // java.lang.Runnable
                public final void run() {
                    WebviewWorker.m(this.f71006a, jsonObject);
                }
            });
        }
    }

    public void execute(String str) {
        execute(JsonParser.parseString(str).getAsJsonObject());
    }

    @Override // gd.a
    public void execute(HashMap<String, Object> map) {
    }

    public int getActivityRuntimes() {
        return 1;
    }

    public final String getAppId() {
        return this.f32160a;
    }

    public Void getData(String key) {
        Intrinsics.g(key, "key");
        return null;
    }

    public final Node getNode() {
        return this.f32161b;
    }

    public final WebMessagePort getPort0() {
        return this.f32169k;
    }

    public final me.b getmWebViewClientInstance() {
        return this.f32168j;
    }

    @Override // gd.a
    public Boolean isDestroy() {
        return Boolean.valueOf(this.f32162c);
    }

    @Override // gd.a
    public Boolean isLoad() {
        return Boolean.valueOf(!this.f32162c);
    }

    @Override // yc.a
    public Boolean isRenderProcessGone() {
        return Boolean.valueOf(this.f32167i);
    }

    @Override // gd.a
    public void loadJS(final String filePath) {
        Intrinsics.g(filePath, "filePath");
        ExecutorService executorService = this.f32165g;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: me.g
                @Override // java.lang.Runnable
                public final void run() {
                    WebviewWorker.p(this.f71004a, filePath);
                }
            });
        }
    }

    public void loadScript(final String script) {
        Intrinsics.g(script, "script");
        if (!isLoad().booleanValue()) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : Worker is not load ");
            return;
        }
        if (TextUtils.isEmpty(script)) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", WorkerAnalyseType.ERROR, "loadJS fail : js string is null");
            return;
        }
        ExecutorService executorService = this.f32165g;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: me.j
                @Override // java.lang.Runnable
                public final void run() {
                    WebviewWorker.r(this.f71009a, script);
                }
            });
        }
    }

    public final void o(JsonObject jsonObject) {
        if (!v() || Build.VERSION.SDK_INT < 23) {
            p.a("miniapp", "nativeSendToWorker DefaultChannel= " + jsonObject);
            evaluateJavascript("javascript:onMessage(" + jsonObject + ')', new a());
            return;
        }
        p.a("miniapp", "nativeSendToWorker MessageChannel= " + jsonObject);
        try {
            WebMessagePort webMessagePort = this.f32169k;
            if (webMessagePort != null) {
                fe.d.a();
                webMessagePort.postMessage(fe.c.a(String.valueOf(jsonObject)));
            }
        } catch (Exception e11) {
            Log.e("miniapp", "port post message: " + e11);
        }
    }

    @Override // yc.a
    public void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.f32167i = true;
        ((IOnRenderProcessGoneProxy) tc.a.a(IOnRenderProcessGoneProxy.class)).received(webView, renderProcessGoneDetail);
    }

    public void registerObject(final String str, final Map<String, String> map) {
        Intrinsics.g(map, "map");
        ExecutorService executorService = this.f32165g;
        if (executorService != null) {
            executorService.submit(new Runnable() { // from class: me.k
                @Override // java.lang.Runnable
                public final void run() {
                    WebviewWorker.t(this.f71011a, str, map);
                }
            });
        }
    }

    public void registerObjects(Map<String, ? extends Map<String, String>> mapMap) {
        Intrinsics.g(mapMap, "mapMap");
        for (Map.Entry<String, ? extends Map<String, String>> entry : mapMap.entrySet()) {
            registerObject(entry.getKey(), entry.getValue());
        }
    }

    @Override // gd.a
    public void registerWorkLifeCycle(e lifeCycle) {
        Intrinsics.g(lifeCycle, "lifeCycle");
        this.f32163d = lifeCycle;
    }

    @Override // gd.a
    public void registerWorkerCallback(gd.d dVar) {
        this.f32164f = dVar;
    }

    public final void registerWorkerMessageChannel() {
        if (Build.VERSION.SDK_INT < 23 || !v()) {
            return;
        }
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = createWebMessageChannel();
        Intrinsics.f(webMessagePortArrCreateWebMessageChannel, "this.createWebMessageChannel()");
        WebMessagePort webMessagePort = webMessagePortArrCreateWebMessageChannel[0];
        this.f32169k = webMessagePort;
        if (webMessagePort != null) {
            webMessagePort.setWebMessageCallback(f.a(new d()));
        }
        fe.d.a();
        postWebMessage(j.a("mini_init", new WebMessagePort[]{webMessagePortArrCreateWebMessageChannel[1]}), Uri.EMPTY);
    }

    public void setData(String key, Object value) {
        Intrinsics.g(key, "key");
        Intrinsics.g(value, "value");
    }

    public final void setNode(Node node) {
        this.f32161b = node;
    }

    public final void setPort0(WebMessagePort webMessagePort) {
        this.f32169k = webMessagePort;
    }

    @Override // gd.a
    public int type() {
        return 3;
    }

    public final boolean v() {
        try {
            String frameworkVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion();
            return Build.VERSION.SDK_INT >= 23 && !(Intrinsics.b(frameworkVersion, "1.0.0") || Intrinsics.b(frameworkVersion, "0.1.0"));
        } catch (Exception unused) {
            return false;
        }
    }
}
