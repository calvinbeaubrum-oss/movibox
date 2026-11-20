package com.cloud.hisavana.sdk.internal.agentpage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.cloud.hisavana.sdk.a0;
import com.cloud.hisavana.sdk.b1;
import com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.f;
import com.cloud.hisavana.sdk.internal.agentpage.bean.AgentPageCurrentAd;
import com.cloud.hisavana.sdk.x;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.l;
import org.json.JSONArray;
import org.json.JSONObject;

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
public final class AgentPageJsBridge extends HisavanaAdJsBridge {
    public static final String AGENT_PAGE_INFO = "ssplocalhost=true";
    public static final String AGENT_PAGE_START_URL = "https://ssplocalhost/";
    public static final String HTML_FROM_LOCAL = "htmlfromlocal=true";
    public static final String HTTPS = "https://";
    public static final String INTERFACE_NAME = "AgentPageJsBridge";
    public static final int MAX_FETCH_NUM = 100;
    public static final int TRACK_LIFE_CYCLE_CLICK = 2;
    public static final int TRACK_LIFE_CYCLE_OPEN = 0;
    public static final int TRACK_LIFE_CYCLE_SHOW = 1;
    public static final int TYPE_TRACK_AD_CLICK = 2;
    public static final int TYPE_TRACK_AD_SHOW = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f29797c = INTERFACE_NAME;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AgentPageCurrentAd f29798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AdsDTO f29799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f29800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<WebView> f29801g;
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static float f29793h = -1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static float f29794i = -1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f29795j = -1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static float f29796k = -1.0f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a();

        void a(int i11);

        void onClick();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v11, MotionEvent event) {
            Intrinsics.g(v11, "v");
            Intrinsics.g(event, "event");
            int action = event.getAction();
            if (action == 0) {
                b bVar = AgentPageJsBridge.Companion;
                AgentPageJsBridge.f29793h = event.getX();
                AgentPageJsBridge.f29794i = event.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            b bVar2 = AgentPageJsBridge.Companion;
            AgentPageJsBridge.f29795j = event.getX();
            AgentPageJsBridge.f29796k = event.getY();
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f29802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AgentPageJsBridge f29803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WebView f29804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f29805d;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements ValueCallback<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<String, Unit> f29806a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super String, Unit> function1) {
                this.f29806a = function1;
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                Function1<String, Unit> function1 = this.f29806a;
                if (function1 != null) {
                    function1.invoke(str);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(String str, AgentPageJsBridge agentPageJsBridge, WebView webView, Function1<? super String, Unit> function1) {
            super(0);
            this.f29802a = str;
            this.f29803b = agentPageJsBridge;
            this.f29804c = webView;
            this.f29805d = function1;
        }

        public final void a() {
            String str = this.f29802a;
            if (!l.L(str, "javascript", false, 2, null)) {
                str = "javascript:" + this.f29802a;
            }
            z.a().d(this.f29803b.f29797c, "nativeSendToRender DefaultRenderBridge= " + str);
            try {
                this.f29804c.evaluateJavascript(str, new a(this.f29805d));
            } catch (Exception e11) {
                z.a().e(this.f29803b.f29797c, "evaluateJavascript error = " + e11);
                this.f29804c.loadUrl(str);
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.cloud.hisavana.sdk.internal.agentpage.b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f29809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.cloud.hisavana.sdk.internal.agentpage.b f29810d;

        public e(String str, String str2, com.cloud.hisavana.sdk.internal.agentpage.b bVar) {
            this.f29808b = str;
            this.f29809c = str2;
            this.f29810d = bVar;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.b.a
        public void a(List<AdsDTO> ads) {
            WebView webView;
            Intrinsics.g(ads, "ads");
            try {
                String strM = AgentPageJsBridge.this.m(this.f29808b, this.f29809c, true, new JSONObject().put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray(GsonUtil.d(ads))));
                WeakReference weakReference = AgentPageJsBridge.this.f29801g;
                if (weakReference != null && (webView = (WebView) weakReference.get()) != null) {
                    AgentPageJsBridge.this.executeJavascript(webView, "javascript:window.HisavanaAdJsBridgeCallback(" + strM + ')', null);
                }
                this.f29810d.W();
            } catch (Throwable th2) {
                z.a().e(AgentPageJsBridge.this.f29797c, Log.getStackTraceString(th2));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void executeJavascript$default(AgentPageJsBridge agentPageJsBridge, WebView webView, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        agentPageJsBridge.executeJavascript(webView, str, function1);
    }

    public static final void o(Function0 runnable) {
        Intrinsics.g(runnable, "$runnable");
        runnable.invoke();
    }

    @JavascriptInterface
    public final void closeAd(String adInfo, int i11) {
        Intrinsics.g(adInfo, "adInfo");
        WeakReference<WebView> weakReference = this.f29801g;
        if ((weakReference != null ? weakReference.get() : null) == null) {
            z.a().w(this.f29797c, "close Ad webviewRefer == null");
            return;
        }
        a aVar = this.f29800f;
        if (aVar != null) {
            aVar.a(i11);
        }
    }

    public final void executeJavascript(WebView webView, String jsScript, Function1<? super String, Unit> function1) {
        Intrinsics.g(webView, "<this>");
        Intrinsics.g(jsScript, "jsScript");
        if (jsScript.length() == 0) {
            return;
        }
        final d dVar = new d(jsScript, this, webView, function1);
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            dVar.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.hisavana.sdk.internal.agentpage.a
                @Override // java.lang.Runnable
                public final void run() {
                    AgentPageJsBridge.o(dVar);
                }
            });
        }
    }

    public final a getAdActionListener() {
        return this.f29800f;
    }

    @JavascriptInterface
    public final void getCurrentAd(String callbackId) {
        WebView webView;
        Intrinsics.g(callbackId, "callbackId");
        try {
            String strM = m("getCurrentAd", callbackId, true, new JSONObject().put("currentAd", GsonUtil.d(this.f29799e)));
            WeakReference<WebView> weakReference = this.f29801g;
            if (weakReference == null || (webView = weakReference.get()) == null) {
                return;
            }
            executeJavascript(webView, "javascript:window.HisavanaAdJsBridgeCallback(" + strM + ')', null);
        } catch (Throwable th2) {
            z.a().e(this.f29797c, Log.getStackTraceString(th2));
        }
    }

    @JavascriptInterface
    public final void getCurrentAdInfo(String callbackId) {
        WebView webView;
        Intrinsics.g(callbackId, "callbackId");
        try {
            String strM = m("getCurrentAdInfo", callbackId, true, new JSONObject().put("currentAdInfo", GsonUtil.d(this.f29798d)));
            WeakReference<WebView> weakReference = this.f29801g;
            if (weakReference == null || (webView = weakReference.get()) == null) {
                return;
            }
            executeJavascript(webView, "javascript:window.HisavanaAdJsBridgeCallback(" + strM + ')', null);
        } catch (Throwable th2) {
            z.a().e(this.f29797c, Log.getStackTraceString(th2));
        }
    }

    @JavascriptInterface
    public final void loadAds(String callbackId, int i11, String codeSeatId, int i12) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        com.cloud.hisavana.sdk.internal.agentpage.b bVar = new com.cloud.hisavana.sdk.internal.agentpage.b(i11, codeSeatId, i12);
        n(bVar, callbackId, "loadAds");
        bVar.w0();
    }

    @JavascriptInterface
    public final void loadNormalAds(String callbackId, int i11, String codeSeatId, int i12) {
        Intrinsics.g(callbackId, "callbackId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        com.cloud.hisavana.sdk.internal.agentpage.b bVar = new com.cloud.hisavana.sdk.internal.agentpage.b(i11, codeSeatId, i12);
        n(bVar, callbackId, "loadNormalAds");
        bVar.F0(false);
        bVar.w0();
    }

    public final String m(String str, String str2, boolean z11, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("apiName", str);
            jSONObject2.put("success", z11);
            jSONObject2.put("callbackId", str2);
            if (jSONObject != null) {
                jSONObject2.put("args", jSONObject);
            }
            String string = new JSONObject().put("data", jSONObject2).toString();
            Intrinsics.f(string, "JSONObject().put(\"data\", jsonObject).toString()");
            return string;
        } catch (Throwable th2) {
            z.a().e(this.f29797c, Log.getStackTraceString(th2));
            return "";
        }
    }

    public final void n(com.cloud.hisavana.sdk.internal.agentpage.b bVar, String str, String str2) {
        bVar.E0(new e(str2, str, bVar));
    }

    @JavascriptInterface
    public final boolean openLandingPage(String adInfo) {
        Intrinsics.g(adInfo, "adInfo");
        try {
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(adInfo, AdsDTO.class);
            if (adsDTO == null) {
                return false;
            }
            a aVar = this.f29800f;
            if (aVar != null) {
                aVar.onClick();
            }
            WeakReference<WebView> weakReference = this.f29801g;
            return q(weakReference != null ? weakReference.get() : null, adsDTO);
        } catch (Throwable th2) {
            z.a().d(this.f29797c, Log.getStackTraceString(th2));
            return false;
        }
    }

    public final boolean p() {
        return this.f29799e != null;
    }

    public final boolean q(View view, AdsDTO adsDTO) {
        if (view == null) {
            return false;
        }
        try {
            e1.a(view.getContext(), adsDTO, new DownUpPointBean(f29793h, f29794i, f29795j, f29796k, view.getMeasuredHeight(), view.getMeasuredWidth()), true);
            return true;
        } catch (Throwable th2) {
            z.a().e("ssp", Log.getStackTraceString(th2));
            return false;
        }
    }

    public final void setAdActionListener(a aVar) {
        this.f29800f = aVar;
    }

    public final void setCurrentAd(AdsDTO adsDTO) {
        Intrinsics.g(adsDTO, "adsDTO");
        this.f29799e = adsDTO;
    }

    public final void setCurrentAdInfo(AgentPageCurrentAd agentPageCurrentAd) {
        Intrinsics.g(agentPageCurrentAd, "agentPageCurrentAd");
        this.f29798d = agentPageCurrentAd;
    }

    public final void setWebview(WebView webview) {
        Intrinsics.g(webview, "webview");
        webview.setOnTouchListener(new c());
        this.f29801g = new WeakReference<>(webview);
    }

    @JavascriptInterface
    public final boolean trackAd(int i11, String adInfo) {
        Intrinsics.g(adInfo, "adInfo");
        try {
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(adInfo, AdsDTO.class);
            if (adsDTO == null) {
                return false;
            }
            if (i11 != 1) {
                if (i11 != 2) {
                    return false;
                }
                AthenaTracker.Y(adsDTO);
            } else if (p()) {
                a aVar = this.f29800f;
                if (aVar != null) {
                    aVar.a();
                }
            } else {
                if (adsDTO.getImpBeanRequest() != null) {
                    x.h().k(adsDTO.getImpBeanRequest().pmid);
                    if (adsDTO.getSource() == 4) {
                        a0 a0Var = a0.f29085a;
                        String adCreativeId = adsDTO.getAdCreativeId();
                        Intrinsics.f(adCreativeId, "adsDTO.adCreativeId");
                        String codeSeatId = adsDTO.getCodeSeatId();
                        Intrinsics.f(codeSeatId, "adsDTO.codeSeatId");
                        a0Var.m(adCreativeId, codeSeatId);
                    } else if (adsDTO.isOfflineAd()) {
                        adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                        b1.c().s(adsDTO);
                    }
                }
                f.b(adsDTO);
            }
            return true;
        } catch (Throwable th2) {
            z.a().d(this.f29797c, Log.getStackTraceString(th2));
            return false;
        }
    }

    @JavascriptInterface
    public final boolean trackContainerLifeCycle(int i11, int i12, Integer num, String adInfo) {
        AdsDTO adsDTO;
        Intrinsics.g(adInfo, "adInfo");
        try {
            if (TextUtils.isEmpty(adInfo) || (adsDTO = (AdsDTO) GsonUtil.a(adInfo, AdsDTO.class)) == null) {
                return false;
            }
            AthenaTracker.A(i11, Integer.valueOf(i12), num, adsDTO);
            return true;
        } catch (Throwable th2) {
            z.a().d(this.f29797c, Log.getStackTraceString(th2));
            return false;
        }
    }

    @JavascriptInterface
    public final boolean trackWarning(int i11, String adInfo) {
        Intrinsics.g(adInfo, "adInfo");
        try {
            if (TextUtils.isEmpty(adInfo)) {
                AthenaTracker.D("", "", i11);
                return true;
            }
            AdsDTO adsDTO = (AdsDTO) GsonUtil.a(adInfo, AdsDTO.class);
            if (adsDTO == null) {
                return false;
            }
            AthenaTracker.D(adsDTO.getCodeSeatId(), adsDTO.getUuid(), i11);
            return true;
        } catch (Throwable th2) {
            z.a().d(this.f29797c, Log.getStackTraceString(th2));
            return false;
        }
    }
}
