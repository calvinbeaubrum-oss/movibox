package com.bytedance.sdk.openadsdk.core.Qj;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private static int pFF;
    private static volatile We zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<ExN> f28082sc = new ArrayList();

    public static We sc() {
        if (zY == null) {
            synchronized (We.class) {
                try {
                    if (zY == null) {
                        zY = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return zY;
    }

    @Nullable
    public ExN pFF() {
        ExN exNRemove;
        if (zY() > 0 && (exNRemove = this.f28082sc.remove(0)) != null) {
            return exNRemove;
        }
        return null;
    }

    public void pFF(ExN exN) {
        if (exN != null) {
            if (this.f28082sc.size() >= pFF) {
                exN.Tf();
            } else {
                if (this.f28082sc.contains(exN)) {
                    return;
                }
                zY(exN);
                this.f28082sc.add(exN);
            }
        }
    }

    public void sc(ExN exN) {
        if (exN != null) {
            pFF(exN);
        }
    }

    public int zY() {
        return this.f28082sc.size();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void zY(ExN exN) {
        if (exN == null || exN.getWebView() == null) {
            return;
        }
        if (exN.getParent() != null) {
            ((ViewGroup) exN.getParent()).removeView(exN);
        }
        try {
            exN.removeAllViews();
            exN.zY();
            exN.setWebChromeClient(null);
            exN.setWebViewClient(null);
            exN.setDownloadListener(null);
            exN.setDefaultTextEncodingName("UTF-8");
            exN.setAllowFileAccess(false);
            exN.setJavaScriptEnabled(true);
            exN.setCacheMode(-1);
            exN.setDatabaseEnabled(true);
            exN.setSupportZoom(false);
            exN.getWebView().setLayerType(0, null);
            exN.setBackgroundColor(0);
            exN.getWebView().setHorizontalScrollBarEnabled(false);
            exN.getWebView().setHorizontalScrollbarOverlay(false);
            exN.getWebView().setVerticalScrollBarEnabled(false);
            exN.getWebView().setVerticalScrollbarOverlay(false);
            com.bytedance.sdk.openadsdk.core.widget.sc.zY.sc(exN);
            exN.WH();
            exN.setMixedContentMode(0);
        } catch (Exception unused) {
        }
    }
}
