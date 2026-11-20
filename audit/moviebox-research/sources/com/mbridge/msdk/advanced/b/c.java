package com.mbridge.msdk.advanced.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f42760b = "NativeAdvancedProvider";
    private MBOutNativeAdvancedViewGroup B;
    private boolean C;
    private boolean D;
    private boolean E;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f42762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f42763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MBridgeIds f42764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.advanced.a.b f42765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.advanced.a.c f42766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f42767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeAdvancedAdListener f42768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f42769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MBNativeAdvancedView f42770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MBNativeAdvancedWebview f42771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.advanced.view.a f42772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private k f42773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f42774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private j f42775p;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private JSONObject f42785z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f42776q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f42777r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f42778s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f42779t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f42780u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f42781v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f42782w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f42783x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Object f42784y = new Object();
    private boolean A = false;
    private boolean F = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42761a = false;
    private ViewTreeObserver.OnScrollChangedListener G = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.mbridge.msdk.advanced.b.c.1
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (c.this.F) {
                c.this.F = false;
                if (c.this.B != null) {
                    c.this.B.postDelayed(new Runnable() { // from class: com.mbridge.msdk.advanced.b.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.F = true;
                        }
                    }, 1000L);
                }
                try {
                    c.this.i();
                } catch (Exception e11) {
                    ad.b(c.f42760b, e11.getMessage());
                }
            }
        }
    };

    public c(String str, String str2, Activity activity) {
        com.mbridge.msdk.advanced.view.a aVar;
        Context context;
        this.f42763d = TextUtils.isEmpty(str) ? "" : str;
        this.f42762c = str2;
        this.f42764e = new MBridgeIds(str, str2);
        if (this.f42766g == null) {
            com.mbridge.msdk.advanced.a.c cVar = new com.mbridge.msdk.advanced.a.c(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42763d, this.f42762c);
            this.f42766g = cVar;
            cVar.a(this);
        }
        if (this.f42771l == null) {
            try {
                this.f42771l = new MBNativeAdvancedWebview(com.mbridge.msdk.foundation.controller.c.m().c());
            } catch (Exception e11) {
                ad.b(f42760b, e11.getMessage());
            }
            if (this.f42772m == null) {
                try {
                    this.f42772m = new com.mbridge.msdk.advanced.view.a(this.f42762c, this.f42766g.c(), this);
                } catch (Exception e12) {
                    ad.b(f42760b, e12.getMessage());
                }
            }
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
            if (mBNativeAdvancedWebview != null && (aVar = this.f42772m) != null) {
                mBNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.f42770k == null) {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (activity == null) {
                context = activity;
                context = contextC;
            }
            context = activity;
            MBNativeAdvancedView mBNativeAdvancedView = new MBNativeAdvancedView(context);
            this.f42770k = mBNativeAdvancedView;
            mBNativeAdvancedView.setAdvancedNativeWebview(this.f42771l);
            MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f42771l;
            if (mBNativeAdvancedWebview2 != null && mBNativeAdvancedWebview2.getParent() == null) {
                this.f42770k.addView(this.f42771l, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.B == null) {
            this.B = new MBOutNativeAdvancedViewGroup(com.mbridge.msdk.foundation.controller.c.m().c());
            this.B.setLayoutParams((this.f42782w == 0 || this.f42783x == 0) ? new ViewGroup.LayoutParams(-1, -1) : new ViewGroup.LayoutParams(this.f42782w, this.f42783x));
            this.B.setProvider(this);
            this.B.addView(this.f42770k);
            this.B.getViewTreeObserver().addOnScrollChangedListener(this.G);
        }
        if (this.f42775p == null) {
            this.f42775p = new j();
        }
        this.f42775p.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b(), this.f42762c);
    }

    private void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (this.f42773n == null) {
                this.f42773n = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f42762c);
            }
            this.f42769j = new d(this, this.f42768i, campaignEx);
            ad.a(f42760b, "show start");
            if (this.f42782w != 0 && this.f42783x != 0) {
                a(campaignEx, false);
                return;
            }
            d dVar = this.f42769j;
            if (dVar != null) {
                dVar.a(this.f42764e, "width or height is 0  or width or height is too small");
            }
        }
    }

    private void a(String str, int i11) {
        this.F = true;
        synchronized (this.f42784y) {
            try {
                if (this.f42774o) {
                    if (this.f42767h != null) {
                        this.f42767h.a(new com.mbridge.msdk.foundation.c.b(880016, "current unit is loading"), i11);
                        this.f42774o = true;
                    }
                    return;
                }
                this.f42774o = true;
                if (this.f42782w == 0 || this.f42783x == 0) {
                    if (this.f42767h != null) {
                        this.f42767h.a(new com.mbridge.msdk.foundation.c.b(880028), i11);
                        return;
                    }
                    return;
                }
                if (this.f42770k == null) {
                    if (this.f42767h != null) {
                        this.f42767h.a(new com.mbridge.msdk.foundation.c.b(880030), i11);
                        return;
                    }
                    return;
                }
                try {
                    if (com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c())) {
                        this.f42770k.clearResStateAndRemoveClose();
                        k kVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k(), this.f42762c);
                        this.f42773n = kVarB;
                        if (kVarB == null) {
                            this.f42773n = k.f(this.f42762c);
                        }
                        if (this.f42765f == null) {
                            this.f42765f = new com.mbridge.msdk.advanced.a.b(this.f42763d, this.f42762c, 0L);
                        }
                        b bVar = this.f42767h;
                        if (bVar != null) {
                            bVar.a(str);
                            this.f42765f.a(this.f42767h);
                        }
                        this.f42770k.resetLoadState();
                        this.f42765f.a(this.f42770k);
                        this.f42765f.a(this.f42773n);
                        this.f42765f.a(this.f42782w, this.f42783x);
                        this.f42765f.a(this.f42776q);
                        this.f42765f.a(str, i11);
                        return;
                    }
                } catch (Exception e11) {
                    ad.b(f42760b, e11.getMessage());
                }
                if (this.f42767h != null) {
                    this.f42767h.a(new com.mbridge.msdk.foundation.c.b(880029), i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void b(CampaignEx campaignEx) {
        if (com.mbridge.msdk.advanced.a.d.a(this.f42770k, campaignEx, this.f42763d, this.f42762c)) {
            this.f42766g.a(this.f42769j);
            ad.b(f42760b, "start show process");
            this.f42766g.a(campaignEx, this.f42770k, true);
        }
    }

    private void b(JSONObject jSONObject) {
        if (this.A) {
            this.f42785z = jSONObject;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f42771l, "setStyleList", "", jSONObject);
        }
    }

    private void f(int i11) {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
        if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
            return;
        }
        try {
            if (this.f42771l != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i11);
                g.a().a((WebView) this.f42771l, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th2) {
            ad.a(f42760b, th2.getMessage());
        }
    }

    private void g(int i11) {
        if (this.f42777r) {
            this.f42776q = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            int i12 = this.f42776q;
            if (i12 == 1) {
                this.f42766g.a(true);
                com.mbridge.msdk.advanced.signal.a.a(this.f42771l, "showCloseButton", "", null);
            } else if (i12 == 0) {
                this.f42766g.a(false);
                com.mbridge.msdk.advanced.signal.a.a(this.f42771l, "hideCloseButton", "", null);
            }
        }
    }

    private void h() {
        g(this.f42776q);
        h(this.f42778s);
        i(this.f42780u);
        b(this.f42785z);
        f(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
    }

    private void h(int i11) {
        if (this.f42779t) {
            this.f42778s = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f42771l, "setVolume", CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.C && this.D && this.E) {
            CampaignEx campaignExA = com.mbridge.msdk.advanced.a.d.a(this.f42770k, this.f42763d, this.f42762c, "", this.f42776q, true, true);
            if (campaignExA != null) {
                campaignExA.getImpReportType();
            }
            if (aq.a(this.f42770k.getAdvancedNativeWebview(), 0) || this.B.getAlpha() < 0.5f || this.B.getVisibility() != 0) {
                return;
            }
            com.mbridge.msdk.advanced.a.c cVar = this.f42766g;
            if (cVar != null) {
                cVar.e();
            }
            a(campaignExA);
        }
    }

    private void i(int i11) {
        if (this.f42781v) {
            this.f42780u = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f42771l;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f42771l, "setVideoPlayMode", "autoPlay", Integer.valueOf(i11));
        }
    }

    public final void a(int i11) {
        this.f42777r = true;
        g(i11);
    }

    public final void a(int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        this.f42783x = i11;
        this.f42782w = i12;
        this.B.setLayoutParams(new ViewGroup.LayoutParams(i12, i11));
    }

    public final void a(CampaignEx campaignEx, boolean z11) {
        h();
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup == null || mBOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (campaignEx != null && z11) {
            if (this.f42773n == null) {
                this.f42773n = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f42762c);
            }
            this.f42769j = new d(this, this.f42768i, campaignEx);
        }
        if (this.f42766g == null) {
            com.mbridge.msdk.advanced.a.c cVar = new com.mbridge.msdk.advanced.a.c(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42763d, this.f42762c);
            this.f42766g = cVar;
            cVar.a(this);
        }
        b(campaignEx);
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.f42768i = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42768i;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.f42764e, "bid  token is null or empty");
        }
    }

    public final void a(JSONObject jSONObject) {
        this.A = true;
        b(jSONObject);
    }

    public final void a(boolean z11) {
        this.f42774o = z11;
    }

    public final boolean a() {
        return this.f42774o;
    }

    public final MBOutNativeAdvancedViewGroup b() {
        return this.B;
    }

    public final void b(int i11) {
        this.f42779t = true;
        h(i11);
    }

    public final void b(String str) {
        b bVar = new b(this, this.f42764e);
        this.f42767h = bVar;
        bVar.a(this.f42768i);
        this.f42767h.a(str);
        a(str, 2);
    }

    public final int c() {
        return this.f42776q;
    }

    public final void c(int i11) {
        this.f42781v = true;
        i(i11);
    }

    public final boolean c(String str) {
        return (this.B == null || com.mbridge.msdk.advanced.a.d.a(this.f42770k, this.f42763d, this.f42762c, str, this.f42776q, false, true) == null) ? false : true;
    }

    public final String d() {
        if (this.f42761a) {
            com.mbridge.msdk.advanced.a.c cVar = this.f42766g;
            return cVar != null ? cVar.a() : "";
        }
        com.mbridge.msdk.advanced.a.b bVar = this.f42765f;
        return bVar != null ? bVar.a() : "";
    }

    public final String d(String str) {
        com.mbridge.msdk.advanced.a.b bVar = this.f42765f;
        return bVar != null ? bVar.a(str) : "";
    }

    public final void d(int i11) {
        if (i11 == 1) {
            this.C = true;
        } else if (i11 == 2) {
            this.D = true;
        } else if (i11 == 3) {
            this.E = true;
        }
        try {
            i();
        } catch (Exception e11) {
            ad.b(f42760b, e11.getMessage());
        }
    }

    public final String e() {
        if (this.f42761a) {
            com.mbridge.msdk.advanced.a.c cVar = this.f42766g;
            return cVar != null ? cVar.b() : "";
        }
        com.mbridge.msdk.advanced.a.b bVar = this.f42765f;
        return bVar != null ? bVar.b() : "";
    }

    public final void e(int i11) {
        if (i11 == 1) {
            this.C = false;
        } else if (i11 == 2) {
            this.D = false;
        } else if (i11 == 3) {
            this.E = false;
        }
        com.mbridge.msdk.advanced.a.c cVar = this.f42766g;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void f() {
        if (this.f42768i != null) {
            this.f42768i = null;
        }
        if (this.f42767h != null) {
            this.f42767h = null;
        }
        if (this.f42769j != null) {
            this.f42769j = null;
        }
        com.mbridge.msdk.advanced.a.b bVar = this.f42765f;
        if (bVar != null) {
            bVar.a((MBNativeAdvancedView) null);
            this.f42765f.c();
        }
        com.mbridge.msdk.advanced.a.c cVar = this.f42766g;
        if (cVar != null) {
            cVar.d();
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.f42770k;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        com.mbridge.msdk.advanced.common.c.b(this.f42763d + this.f42762c + d());
        com.mbridge.msdk.advanced.view.a aVar = this.f42772m;
        if (aVar != null) {
            aVar.a();
        }
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.B;
        if (mBOutNativeAdvancedViewGroup != null) {
            mBOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.G);
            this.B.removeAllViews();
            this.B = null;
        }
    }
}
