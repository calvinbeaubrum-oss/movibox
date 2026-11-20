package com.transsion.web.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.cloud.hisavana.sdk.bridge.HisavanaAdJsBridge;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.athena.jsbridge.AthenaJsInterface;
import com.transsion.downloadapi.IDownloadApiProvider;
import com.transsion.lib_web.BaseLibWebFragment;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebJavascriptNavigator;
import com.transsion.web.share.WebShareUtil;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WebFragmentV2 extends BaseLibWebFragment implements r00.a, com.transsion.baselib.report.e {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f60174r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f60175s = WebFragmentV2.class.getSimpleName();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WebShareUtil f60176j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f60179m;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ILoginApi f60177k = (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f60178l = "on_create";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f60180n = LazyKt__LazyJVMKt.b(new Function0<IDownloadApiProvider>() { // from class: com.transsion.web.fragment.WebFragmentV2$iDownloadApiProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IDownloadApiProvider invoke() {
            return (IDownloadApiProvider) com.alibaba.android.arouter.launcher.a.d().h(IDownloadApiProvider.class);
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f60181o = LazyKt__LazyJVMKt.b(new Function0<b00.a>() { // from class: com.transsion.web.fragment.WebFragmentV2$iWebApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b00.a invoke() {
            return (b00.a) NetServiceGenerator.f49399d.a().i(b00.a.class);
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HashMap<String, Long> f60182p = new HashMap<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.transsion.baselib.report.h f60183q = newLogViewConfig();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return WebFragmentV2.f60175s;
        }

        public final WebFragmentV2 b() {
            return new WebFragmentV2();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends AthenaJsInterface {
        public b(Context context) {
            super(context);
        }

        public static final void b() {
        }

        @Override // com.transsion.athena.jsbridge.AthenaJsInterface
        @JavascriptInterface
        public void track(int i11, String str, String str2) {
            super.track(i11, str, str2);
            WebFragmentV2.this.n0().getRoot().post(new Runnable() { // from class: com.transsion.web.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    WebFragmentV2.b.b();
                }
            });
        }
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void J0(WebView view, String url) {
        Intrinsics.g(view, "view");
        Intrinsics.g(url, "url");
        super.J0(view, url);
        Y0(url);
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void K0(WebView view, String url, Bitmap bitmap) {
        Intrinsics.g(view, "view");
        Intrinsics.g(url, "url");
        super.K0(view, url, bitmap);
        if (this.f60182p.get(url) == null) {
            this.f60182p.put(url, Long.valueOf(System.currentTimeMillis()));
        }
        getLogViewConfig().g().put("url", url);
        this.f60179m = false;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void L0(WebView webView, int i11, String str, String str2) {
        super.L0(webView, i11, str, str2);
        this.f60179m = true;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void M0(WebView webView, WebResourceRequest request, WebResourceError error) {
        Intrinsics.g(request, "request");
        Intrinsics.g(error, "error");
        super.M0(webView, request, error);
        this.f60179m = true;
    }

    public final IDownloadApiProvider V0() {
        return (IDownloadApiProvider) this.f60180n.getValue();
    }

    public final b00.a W0() {
        return (b00.a) this.f60181o.getValue();
    }

    public final boolean X0() {
        if (!s0().canGoBack()) {
            return false;
        }
        s0().goBack();
        return true;
    }

    public final void Y0(String str) {
        String string;
        com.transsion.lib_web.zip.loader.d dVarP0;
        String strB;
        if (this.f60182p.get(str) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l11 = this.f60182p.get(str);
            long jLongValue = jCurrentTimeMillis - (l11 != null ? l11.longValue() : jCurrentTimeMillis);
            uo.b.a aVar = uo.b.f78622a;
            String TAG = f60175s;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, " page mUrl:" + str + "  used time: " + jLongValue, false, 4, null);
            getLogViewConfig().g().put("load_h5_time", String.valueOf(jLongValue));
            if (this.f60182p.get(this.f60178l) != null) {
                Long l12 = this.f60182p.get(this.f60178l);
                Intrinsics.d(l12);
                getLogViewConfig().g().put("load_time", String.valueOf(jCurrentTimeMillis - l12.longValue()));
                this.f60182p.put(this.f60178l, null);
            }
            getLogViewConfig().g().put("load_h5_time", String.valueOf(jLongValue));
        }
        if (!getLogViewConfig().i()) {
            com.transsion.lib_web.zip.loader.d dVarP1 = p0();
            Boolean boolValueOf = dVarP1 != null ? Boolean.valueOf(dVarP1.f()) : null;
            HashMap<String, String> mapG = getLogViewConfig().g();
            if (boolValueOf == null || (string = boolValueOf.toString()) == null) {
                string = "false";
            }
            mapG.put("is_from_cache", string);
            if (Intrinsics.b(boolValueOf, Boolean.TRUE) && (dVarP0 = p0()) != null && (strB = dVarP0.b()) != null) {
                String strSubstring = strB.substring(0, 3);
                Intrinsics.f(strSubstring, "substring(...)");
                String strSubstring2 = strB.substring(strB.length() - 3, strB.length());
                Intrinsics.f(strSubstring2, "substring(...)");
                getLogViewConfig().g().put("zip_md5", strSubstring + strSubstring2);
            }
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = f60175s;
            Intrinsics.f(TAG2, "TAG");
            aVar2.c(TAG2, "mUrl:" + str + " onPageFinished  target:" + r0(), true);
        }
        HashMap<String, String> mapG2 = getLogViewConfig().g();
        Bundle arguments = getArguments();
        mapG2.put(WebConstants.PAGE_FROM, arguments != null ? arguments.getString(WebConstants.PAGE_FROM) : null);
        getLogViewConfig().j(true);
    }

    @Override // com.transsion.baselib.report.e
    public com.transsion.baselib.report.h getLogViewConfig() {
        return this.f60183q;
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void l0(FragmentActivity requireActivity, String tag, String str, String str2, long j11, String originalUrl) {
        Intrinsics.g(requireActivity, "requireActivity");
        Intrinsics.g(tag, "tag");
        Intrinsics.g(originalUrl, "originalUrl");
        IDownloadApiProvider iDownloadApiProviderV0 = V0();
        if (iDownloadApiProviderV0 != null) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "requireActivity()");
            iDownloadApiProviderV0.c(fragmentActivityRequireActivity, "web_load", str, q0(), j11, r0());
        }
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment
    public void m0(BridgeWebView bridgeWebView) {
        Intrinsics.g(bridgeWebView, "bridgeWebView");
        bridgeWebView.addJavascriptInterface(new b(getContext()), "AthenaNative");
        bridgeWebView.addJavascriptInterface(new WebJavascriptNavigator(), "yy_navigator");
        bridgeWebView.addJavascriptInterface(new WebFragmentV2$addJsInterface$2(this, s0()), "WebViewJavascriptBridge");
        bridgeWebView.addJavascriptInterface(new HisavanaAdJsBridge(bridgeWebView), HisavanaAdJsBridge.INTERFACE_NAME);
    }

    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("snifferh5page", false, 2, null);
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment, com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        if (getLogViewConfig().i() || !this.f60179m) {
            return;
        }
        n0().f67702b.reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f60182p.put(this.f60178l, Long.valueOf(System.currentTimeMillis()));
        this.f60182p.put(r0(), Long.valueOf(System.currentTimeMillis()));
        getLogViewConfig().g().put("original_url", r0());
        Bundle arguments = getArguments();
        getLogViewConfig().g().put(WebConstants.TAB_CODE, arguments != null ? arguments.getString(WebConstants.TAB_CODE) : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (isResumed()) {
            if (z11) {
                com.transsion.baselib.report.e.a.b(this);
            } else {
                com.transsion.baselib.report.e.a.c(this);
            }
        }
    }

    @Override // r00.a
    public void onLogin(UserInfo userInfo) {
        r00.a.C0822a.a(this, userInfo);
    }

    @Override // r00.a
    public void onLogout() {
        r00.a.C0822a.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isHidden()) {
            return;
        }
        com.transsion.baselib.report.e.a.b(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baselib.report.e.a.c(this);
    }

    @Override // r00.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        r00.a.C0822a.c(this, userInfo);
    }

    @Override // com.transsion.lib_web.BaseLibWebFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f60176j = new WebShareUtil(this, new Function2<String, String, Unit>() { // from class: com.transsion.web.fragment.WebFragmentV2.onViewCreated.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String resultCode) {
                Intrinsics.g(resultCode, "resultCode");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                WebFragmentV2.this.s0().sendResponse(resultCode, str);
            }
        });
        ILoginApi iLoginApi = this.f60177k;
        if (iLoginApi != null) {
            iLoginApi.F(this);
        }
    }
}
