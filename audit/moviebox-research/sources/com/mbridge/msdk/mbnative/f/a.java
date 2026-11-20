package com.mbridge.msdk.mbnative.f;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbnative.controller.NativeController;
import com.mbridge.msdk.mbnative.controller.d;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeController f45634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f45635b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.mbnative.d.a f45636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f45637d;

    public a() {
    }

    public a(com.mbridge.msdk.mbnative.d.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f45636c = aVar;
        this.f45637d = nativeTrackingListener;
    }

    private void a(int i11, String str) {
        if (this.f45634a != null) {
            com.mbridge.msdk.mbnative.d.a aVar = this.f45636c;
            if (aVar == null || !aVar.a()) {
                com.mbridge.msdk.mbnative.d.a aVar2 = this.f45636c;
                if (aVar2 != null) {
                    aVar2.b();
                }
                this.f45634a.a(i11, str);
                return;
            }
            if (ai.g()) {
                g();
            } else {
                this.f45635b.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.f.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.g();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f45636c.onAdLoadError("current request is loading");
        this.f45636c.b();
    }

    public static void preload(Map<String, Object> map, int i11) {
        ad.c("NativeProvider", "native provider preload");
        new d().a(map, i11);
    }

    public final void a() {
        a(0, "");
    }

    public final void a(Context context, Resources resources, Map<String, Object> map) {
        this.f45634a = new NativeController(this.f45636c, this.f45637d, map, context);
    }

    public final void a(View view, Campaign campaign) {
        ad.c("NativeProvider", "native provider registerView");
        NativeController nativeController = this.f45634a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view);
    }

    public final void a(View view, List<View> list, Campaign campaign) {
        NativeController nativeController = this.f45634a;
        if (nativeController == null) {
            return;
        }
        nativeController.a(campaign, view, list);
    }

    public final void a(com.mbridge.msdk.mbnative.d.a aVar) {
        this.f45636c = aVar;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f45637d = nativeTrackingListener;
    }

    public final void a(String str) {
        a(0, str);
    }

    public final void b() {
        a(1, "");
    }

    public final void b(View view, Campaign campaign) {
        ad.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f45634a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view);
    }

    public final void b(View view, List<View> list, Campaign campaign) {
        ad.c("NativeProvider", "native provider unregisterView");
        NativeController nativeController = this.f45634a;
        if (nativeController == null) {
            return;
        }
        nativeController.b(campaign, view, list);
    }

    public final void c() {
        try {
            ab.b();
        } catch (Exception unused) {
            ad.b("NativeProvider", "clear cache failed");
        }
    }

    public final void d() {
        try {
            this.f45634a.a();
        } catch (Exception unused) {
            ad.b("NativeProvider", "release failed");
        }
    }

    public final String e() {
        NativeController nativeController = this.f45634a;
        return nativeController != null ? nativeController.b() : "";
    }

    public final String f() {
        NativeController nativeController = this.f45634a;
        return nativeController != null ? nativeController.c() : "";
    }
}
