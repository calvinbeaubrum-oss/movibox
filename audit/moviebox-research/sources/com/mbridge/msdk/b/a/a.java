package com.mbridge.msdk.b.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements PreloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WeakReference<PreloadListener> f42884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f42885b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f42886c = false;

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.f42884a = new WeakReference<>(preloadListener);
        }
    }

    public final void a(boolean z11) {
        this.f42886c = z11;
    }

    public final boolean a() {
        return this.f42886c;
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.f42884a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f42884a.get().onPreloadFaild(str);
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.f42884a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f42884a.get().onPreloadSucceed();
    }
}
