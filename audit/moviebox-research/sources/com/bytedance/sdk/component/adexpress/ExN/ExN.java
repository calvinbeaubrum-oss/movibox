package com.bytedance.sdk.component.adexpress.ExN;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.sc.WP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private static final byte[] ExN = new byte[0];
    private static volatile ExN Ol = null;
    private static int Qj = 10;
    private static int TRI = 10;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final AtomicBoolean f26652qr = new AtomicBoolean(false);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private List<com.bytedance.sdk.component.Ol.We> f26653sc = new ArrayList();
    private List<com.bytedance.sdk.component.Ol.We> pFF = new ArrayList();
    private Map<Integer, zY> zY = new HashMap();
    private Map<Integer, We> We = new HashMap();

    private ExN() {
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        if (zYVarZY != null) {
            TRI = zYVarZY.WH();
            Qj = zYVarZY.UFX();
        }
    }

    private void qr(com.bytedance.sdk.component.Ol.We we2) {
        try {
            we2.removeAllViews();
            we2.zY();
            we2.setWebChromeClient(null);
            we2.setWebViewClient(null);
            we2.setDownloadListener(null);
            we2.setJavaScriptEnabled(true);
            we2.setCacheMode(-1);
            we2.setSupportZoom(false);
            we2.setUseWideViewPort(true);
            we2.setJavaScriptCanOpenWindowsAutomatically(true);
            we2.setDomStorageEnabled(true);
            we2.setBuiltInZoomControls(false);
            we2.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            we2.setLoadWithOverviewMode(false);
            we2.setDefaultTextEncodingName("UTF-8");
            we2.setDefaultFontSize(16);
        } catch (Throwable unused) {
        }
    }

    public static ExN sc() {
        if (Ol == null) {
            synchronized (ExN.class) {
                try {
                    if (Ol == null) {
                        Ol = new ExN();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Ol;
    }

    public boolean ExN(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return false;
        }
        try {
            Context context = we2.getContext();
            if (context instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
            }
            we2.Tf();
            return true;
        } catch (Throwable th2) {
            th2.getMessage();
            return true;
        }
    }

    public void TRI(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        zY zYVar = this.zY.get(Integer.valueOf(we2.hashCode()));
        if (zYVar != null) {
            zYVar.sc(null);
        }
        we2.b_("SDK_INJECT_GLOBAL");
    }

    public int We() {
        return this.pFF.size();
    }

    public void We(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        if (this.f26653sc.size() >= TRI) {
            try {
                Context context = we2.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                we2.Tf();
                return;
            } catch (Throwable th2) {
                th2.getMessage();
                return;
            }
        }
        if (this.f26653sc.contains(we2)) {
            return;
        }
        try {
            Context context2 = we2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                we2.setRecycler(true);
                this.f26653sc.add(we2);
                zY();
            }
        } catch (Throwable th3) {
            zY();
            th3.getMessage();
        }
    }

    @Nullable
    public com.bytedance.sdk.component.Ol.We pFF(Context context, String str) {
        if (zY() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.We.ExN.sc(str) && zY() <= 1) {
            zY();
            return null;
        }
        com.bytedance.sdk.component.Ol.We weRemove = this.f26653sc.remove(0);
        if (weRemove == null) {
            return null;
        }
        try {
            Context context2 = weRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                weRemove.setRecycler(false);
                zY();
            }
            return weRemove;
        } catch (Throwable unused) {
            zY();
            return null;
        }
    }

    public void pFF() {
        for (com.bytedance.sdk.component.Ol.We we2 : this.f26653sc) {
            if (we2 != null) {
                try {
                    Context context = we2.getContext();
                    if (context instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                    }
                    we2.Tf();
                } catch (Throwable th2) {
                    th2.getMessage();
                }
            }
        }
        this.f26653sc.clear();
        for (com.bytedance.sdk.component.Ol.We we3 : this.pFF) {
            if (we3 != null) {
                try {
                    Context context2 = we3.getContext();
                    if (context2 instanceof MutableContextWrapper) {
                        ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                    }
                    we3.Tf();
                } catch (Throwable th3) {
                    th3.getMessage();
                }
            }
        }
        this.pFF.clear();
    }

    public void pFF(int i11) {
        synchronized (ExN) {
            Qj = i11;
        }
    }

    public void pFF(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        qr(we2);
        we2.b_("SDK_INJECT_GLOBAL");
        TRI(we2);
        sc(we2);
    }

    @Nullable
    public com.bytedance.sdk.component.Ol.We sc(Context context, String str) {
        if (We() <= 0) {
            return null;
        }
        if (com.bytedance.sdk.component.adexpress.We.ExN.sc(str) && We() <= 1) {
            We();
            return null;
        }
        com.bytedance.sdk.component.Ol.We weRemove = this.pFF.remove(0);
        if (weRemove == null) {
            return null;
        }
        try {
            Context context2 = weRemove.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context.getApplicationContext());
                weRemove.setRecycler(false);
                We();
            }
            return weRemove;
        } catch (Throwable unused) {
            We();
            return null;
        }
    }

    public void sc(int i11) {
        synchronized (ExN) {
            TRI = i11;
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void sc(WebView webView, WP wp2, String str) {
        if (webView == null || wp2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        We we2 = this.We.get(Integer.valueOf(webView.hashCode()));
        if (we2 != null) {
            we2.sc(wp2);
        } else {
            we2 = new We(wp2);
            this.We.put(Integer.valueOf(webView.hashCode()), we2);
        }
        webView.addJavascriptInterface(we2, str);
    }

    public void sc(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        We we2 = this.We.get(Integer.valueOf(webView.hashCode()));
        if (we2 != null) {
            we2.sc(null);
        }
        webView.removeJavascriptInterface(str);
    }

    public void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        if (this.pFF.size() >= Qj) {
            try {
                Context context = we2.getContext();
                if (context instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) context).setBaseContext(context.getApplicationContext());
                }
                we2.Tf();
                return;
            } catch (Throwable th2) {
                th2.getMessage();
                return;
            }
        }
        if (this.pFF.contains(we2)) {
            return;
        }
        try {
            Context context2 = we2.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(context2.getApplicationContext());
                we2.setRecycler(true);
                this.pFF.add(we2);
                We();
            }
        } catch (Throwable th3) {
            We();
            th3.getMessage();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    public void sc(com.bytedance.sdk.component.Ol.We we2, pFF pff) {
        if (we2 == null || pff == null) {
            return;
        }
        zY zYVar = this.zY.get(Integer.valueOf(we2.hashCode()));
        if (zYVar != null) {
            zYVar.sc(pff);
        } else {
            zYVar = new zY(pff);
            this.zY.put(Integer.valueOf(we2.hashCode()), zYVar);
        }
        we2.sc(zYVar, "SDK_INJECT_GLOBAL");
    }

    public int zY() {
        return this.f26653sc.size();
    }

    public void zY(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        qr(we2);
        we2.b_("SDK_INJECT_GLOBAL");
        TRI(we2);
        We(we2);
    }
}
