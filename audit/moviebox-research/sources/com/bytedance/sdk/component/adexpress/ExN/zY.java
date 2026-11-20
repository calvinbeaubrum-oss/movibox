package com.bytedance.sdk.component.adexpress.ExN;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private WeakReference<pFF> f26658sc;

    public zY(pFF pff) {
        this.f26658sc = new WeakReference<>(pff);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get();
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<pFF> weakReference = this.f26658sc;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f26658sc.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<pFF> weakReference = this.f26658sc;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f26658sc.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void chooseAdResult(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().chooseAdResult(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<pFF> weakReference = this.f26658sc;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f26658sc.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f26658sc.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<pFF> weakReference = this.f26658sc;
        return (weakReference == null || weakReference.get() == null) ? "" : this.f26658sc.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().sc(str);
    }

    public void sc(pFF pff) {
        this.f26658sc = new WeakReference<>(pff);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<pFF> weakReference = this.f26658sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26658sc.get().skipVideo();
    }
}
