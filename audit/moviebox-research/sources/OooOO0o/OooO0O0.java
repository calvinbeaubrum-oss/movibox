package OooOO0o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.nativewebview.interfaces.NativeWebviewInterface;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import o.a;
import zc.m;
import zc.o;
import zc.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO0O0 extends WebView {
    public m OooO00o;
    public o OooO0O0;
    public p OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public a f185OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public final Lazy f186OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public l.a f187OooO0o0;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<Handler> {
        public static final OooO00o OooO00o = new OooO00o();

        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OooO0O0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f186OooO0o = LazyKt__LazyJVMKt.b(OooO00o.OooO00o);
    }

    public /* synthetic */ OooO0O0(Context context, AttributeSet attributeSet, int i11) {
        this(context, null);
    }

    private final Handler getMHandler() {
        return (Handler) this.f186OooO0o.getValue();
    }

    @SuppressLint({"JavascriptInterface"})
    public void OooO00o() {
        Context context = getContext();
        Intrinsics.f(context, "context");
        l.a aVar = new l.a(context, this.OooO0OO);
        this.f187OooO0o0 = aVar;
        setWebChromeClient(aVar);
        a aVar2 = new a(this.OooO0OO, this.OooO0O0);
        this.f185OooO0Oo = aVar2;
        setWebViewClient(aVar2);
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(true);
        settings.setJavaScriptEnabled(true);
        addJavascriptInterface(new NativeWebviewInterface(), "dltNativeWebview");
    }

    public void OooO00o(o pageCallback) {
        Intrinsics.g(pageCallback, "pageCallback");
        this.OooO0O0 = pageCallback;
    }

    public void OooO00o(p pageEventCallback) {
        Intrinsics.g(pageEventCallback, "pageEventCallback");
        this.OooO0OO = pageEventCallback;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        clearHistory();
        a aVar = this.f185OooO0Oo;
        if (aVar != null) {
            aVar.f72237a = null;
        }
        this.f185OooO0Oo = null;
        l.a aVar2 = this.f187OooO0o0;
        if (aVar2 != null) {
            aVar2.f69720a = null;
        }
        this.f187OooO0o0 = null;
        this.OooO0O0 = null;
        this.OooO0OO = null;
        super.destroy();
    }

    public final l.a getMWebChromeClient() {
        return this.f187OooO0o0;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        super.goBack();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onCheckIsTextEditor() {
        boolean zOnCheckIsTextEditor = false;
        try {
            if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
                zOnCheckIsTextEditor = super.onCheckIsTextEditor();
            } else {
                TmcLogger.f("NativeWebView", "onCheckIsTextEditor() does not run in the main thread");
            }
        } catch (Throwable th2) {
            TmcLogger.g("NativeWebView", "Probable deadlock detected due to WebView API being called on incorrect thread while the UI thread is blocked.", th2);
        }
        return zOnCheckIsTextEditor;
    }

    @Override // android.webkit.WebView
    public void onPause() {
        super.onPause();
    }

    @Override // android.webkit.WebView
    public void onResume() {
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    public final void setMWebChromeClient(l.a aVar) {
        this.f187OooO0o0 = aVar;
    }

    public void setScrollChangedCallback(m mVar) {
    }
}
