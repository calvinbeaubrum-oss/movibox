package com.bytedance.sdk.component.Ol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Tf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends WebView {
    private boolean ExN;
    private sc TRI;
    private boolean We;
    private final HashSet<String> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public long f26552sc;
    private boolean zY;

    public zY(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pFF = new HashSet<>();
        this.f26552sc = System.currentTimeMillis();
        sc();
    }

    public zY(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.pFF = new HashSet<>();
        this.f26552sc = System.currentTimeMillis();
        sc();
    }

    private void pFF() {
        if (this.zY) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.pFF.iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface(it.next());
        }
    }

    private void sc() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new We.sc());
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        toString();
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "addJavascriptInterface: has destroyed or has recycler");
        } else {
            super.addJavascriptInterface(obj, str);
            this.pFF.add(str);
        }
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z11) {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "clearCache: has destroyed or recycler");
        } else {
            super.clearCache(z11);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        toString();
        if (this.zY) {
            return;
        }
        this.zY = true;
        pFF();
        super.destroy();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.zY && !this.ExN) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            Tf.sc("TTAD.PangleWebView", "evaluateJavascript: has destroyed or recycler, ".concat(String.valueOf(str)));
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "goBack: has destroyed or recycler");
        } else {
            super.goBack();
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i11) {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "goBackOrForward: has destroyed or recycler");
        } else {
            super.goBackOrForward(i11);
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "goForward: has destroyed or recycler");
        } else {
            super.goForward();
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "loadDataWithBaseURL: has destroyed or recycler");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e11) {
            Tf.sc("TTAD.PangleWebView", "loadUrl: ", e11);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "loadUrl: has destroyed or recycler");
            return;
        }
        try {
            super.loadUrl(str, map);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e11) {
            Tf.sc("TTAD.PangleWebView", "loadUrl: ", e11);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        toString();
        if (this.We) {
            destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.zY || this.ExN) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.zY || this.ExN) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i11, i12);
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "onPause: has destroyed or recycler");
            return;
        }
        try {
            super.onPause();
        } catch (Exception e11) {
            Tf.sc("TTAD.PangleWebView", "onPause: ", e11);
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "onResume: has destroyed or recycler");
            return;
        }
        try {
            super.onResume();
        } catch (Exception e11) {
            Tf.sc("TTAD.PangleWebView", "onResume: ", e11);
        }
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        if (this.zY || this.ExN) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "reload: has destroyed or recycler");
        } else {
            super.reload();
        }
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (this.zY || this.ExN) {
            return;
        }
        super.removeJavascriptInterface(str);
        this.pFF.remove(str);
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        if (this.zY || this.ExN) {
            return;
        }
        super.resumeTimers();
    }

    public void setArbitrageTouchListener(sc scVar) {
        this.TRI = scVar;
    }

    public void setDestroyOnDetached(boolean z11) {
        this.We = z11;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        sc scVar = this.TRI;
        if (scVar == null) {
            super.setOnTouchListener(onTouchListener);
        } else {
            scVar.sc(onTouchListener);
            super.setOnTouchListener(this.TRI);
        }
    }

    public void setRecycler(boolean z11) {
        this.ExN = z11;
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.zY || this.ExN) {
            Tf.sc("TTAD.PangleWebView", "stopLoading: has destroyed or recycler");
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e11) {
            Tf.sc("TTAD.PangleWebView", "stopLoading: ", e11);
        }
    }
}
