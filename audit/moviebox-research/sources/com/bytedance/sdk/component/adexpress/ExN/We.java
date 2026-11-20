package com.bytedance.sdk.component.adexpress.ExN;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.sc.WP;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private WeakReference<WP> f26654sc;

    public We(WP wp2) {
        this.f26654sc = new WeakReference<>(wp2);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<WP> weakReference = this.f26654sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26654sc.get().invokeMethod(str);
    }

    public void sc(WP wp2) {
        this.f26654sc = new WeakReference<>(wp2);
    }
}
