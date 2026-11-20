package com.cloud.hisavana.sdk;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
@SuppressLint({"ClickableViewAccessibility"})
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29820f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebView f29822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdsDTO f29823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l1 f29824j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29815a = "AdmHandler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f29816b = -1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f29817c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f29818d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f29819e = -1.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f29821g = LazyKt__LazyJVMKt.b(c.f29827a);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f29825k = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(String str, int i11);

        boolean a(String str);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements a {
        public b() {
        }

        @Override // com.cloud.hisavana.sdk.j.a
        public void a(String str, int i11) {
            l1 l1Var = j.this.f29824j;
            if (l1Var != null) {
                l1Var.a(str, i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.j.a
        public boolean a(String url) {
            Intrinsics.g(url, "url");
            return j.this.g(url);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends Lambda implements Function0<x9.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f29827a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x9.c invoke() {
            return new x9.c(com.cloud.sdk.commonutil.util.f.a());
        }
    }

    public static final boolean e(j this$0, AdsDTO mAdBean, View view, MotionEvent motionEvent) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(mAdBean, "$mAdBean");
        if (motionEvent == null) {
            return false;
        }
        this$0.i().onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.f29816b = motionEvent.getX();
            this$0.f29817c = motionEvent.getY();
            return false;
        }
        if (action != 1) {
            return false;
        }
        this$0.f29818d = motionEvent.getX();
        this$0.f29819e = motionEvent.getY();
        if (!this$0.i().a() || mAdBean.isAdmNormalClick()) {
            return false;
        }
        this$0.c();
        return false;
    }

    public final void c() {
        l1 l1Var = this.f29824j;
        this.f29820f = l1Var != null ? l1Var.b(this.f29816b, this.f29817c, this.f29818d, this.f29819e) : 0;
    }

    public final void d(TadmWebView admWebView, final AdsDTO mAdBean, l1 loadAdmListener) {
        Intrinsics.g(admWebView, "admWebView");
        Intrinsics.g(mAdBean, "mAdBean");
        Intrinsics.g(loadAdmListener, "loadAdmListener");
        admWebView.addJavascriptInterface(new a1(this.f29825k), "loadError");
        admWebView.setWebViewClient(new j1(this.f29825k));
        admWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.cloud.hisavana.sdk.c1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return j.e(this.f29207a, mAdBean, view, motionEvent);
            }
        });
        this.f29823i = mAdBean;
        this.f29824j = loadAdmListener;
        this.f29820f = 0;
    }

    public final boolean g(String str) {
        AdsDTO adsDTO;
        if (!i().a()) {
            return false;
        }
        int i11 = this.f29820f;
        if (i11 == 0) {
            AdsDTO adsDTO2 = this.f29823i;
            if (adsDTO2 != null) {
                adsDTO2.setClickUrl(str);
            }
            AdsDTO adsDTO3 = this.f29823i;
            if (adsDTO3 != null) {
                adsDTO3.setUpdateClickUrl(true);
            }
            c();
        } else if (i11 == 5 && (adsDTO = this.f29823i) != null && adsDTO.isJumpToHalfscreen()) {
            if (this.f29822h == null) {
                try {
                    WebView webView = new WebView(com.cloud.sdk.commonutil.util.f.a());
                    this.f29822h = webView;
                    webView.setWebViewClient(new WebViewClient());
                } catch (Exception unused) {
                    z.a().w(this.f29815a, "create web view error");
                }
            }
            WebView webView2 = this.f29822h;
            if (webView2 != null) {
                webView2.loadUrl(str);
            }
        }
        return true;
    }

    public final void h() {
        WebView webView = this.f29822h;
        if (webView != null) {
            try {
                webView.clearHistory();
                webView.clearCache(true);
                webView.loadUrl("about:blank");
                webView.freeMemory();
                webView.destroy();
            } catch (Exception unused) {
            }
        }
        this.f29822h = null;
        this.f29824j = null;
    }

    public final x9.c i() {
        return (x9.c) this.f29821g.getValue();
    }
}
