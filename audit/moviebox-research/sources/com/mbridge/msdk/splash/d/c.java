package com.mbridge.msdk.splash.d;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ar;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.splash.c.e;
import com.mbridge.msdk.splash.c.f;
import com.mbridge.msdk.splash.view.BaseSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f47118b = "SplashProvider";
    private boolean A;
    private CampaignEx B;
    private MBSplashPopView C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MBridgeIds f47122e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f47125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f f47126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f47127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MBSplashShowListener f47128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f47129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MBSplashView f47130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewGroup f47131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f47132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private k f47133p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f47134q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ViewGroup f47135r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private j f47136s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f47137t;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Activity f47143z;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f47123f = 5;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f47138u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f47139v = z.i(com.mbridge.msdk.foundation.controller.c.m().c());

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f47140w = z.g(com.mbridge.msdk.foundation.controller.c.m().c());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Object f47141x = new Object();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Object f47142y = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f47119a = false;
    private boolean D = false;

    public c(Activity activity, String str, String str2) {
        this.f47121d = TextUtils.isEmpty(str) ? "" : str;
        this.f47120c = str2;
        this.f47122e = new MBridgeIds(str, str2);
        this.f47143z = activity;
        if (this.f47126i == null) {
            if (activity != null) {
                this.f47126i = new f(activity, this.f47121d, this.f47120c);
            } else {
                this.f47126i = new f(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47121d, this.f47120c);
            }
        }
        if (this.f47130m == null) {
            if (activity != null) {
                this.f47130m = new MBSplashView(activity);
            } else {
                this.f47130m = new MBSplashView(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        }
        if (this.f47136s == null) {
            this.f47136s = new j();
        }
        this.f47136s.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b(), this.f47120c);
    }

    private ViewGroup a(Activity activity) {
        Throwable th2;
        ViewGroup viewGroup;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (activity == null) {
            ad.d(f47118b, "splash can't show because, activity is null or activity is finishing");
            return null;
        }
        try {
            viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
            try {
                try {
                    return (ViewGroup) viewGroup.getChildAt(0);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return viewGroup;
                }
            } catch (Throwable th3) {
                th2 = th3;
                th2.printStackTrace();
                return viewGroup;
            }
        } catch (Throwable th4) {
            th2 = th4;
            viewGroup = null;
        }
    }

    private void a(String str, int i11) {
        synchronized (this.f47141x) {
            try {
                if (this.f47134q) {
                    if (this.f47127j != null) {
                        this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880016, "current unit is loading"), i11);
                        this.f47134q = true;
                    }
                    return;
                }
                this.f47134q = true;
                int i12 = this.f47123f;
                if (i12 < 2 || i12 > 10) {
                    if (this.f47127j != null) {
                        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880037);
                        bVar.a("countDownTime must in 2 - 10");
                        this.f47127j.a(bVar, i11);
                        return;
                    }
                    return;
                }
                if (this.f47139v == 0 || this.f47140w == 0) {
                    if (this.f47127j != null) {
                        this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880028), i11);
                        return;
                    }
                    return;
                }
                try {
                    if (com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(com.mbridge.msdk.foundation.controller.c.m().c())) {
                        this.f47130m.clearResState();
                        this.f47133p = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47120c);
                        if (this.f47125h == null) {
                            this.f47125h = new e(this.f47121d, this.f47120c, this.f47124g * 1000);
                        }
                        b bVar2 = this.f47127j;
                        if (bVar2 != null) {
                            bVar2.a(str);
                            this.f47125h.a(this.f47127j);
                        }
                        this.f47130m.resetLoadState();
                        this.f47125h.a(this.f47123f);
                        this.f47125h.a(this.f47130m);
                        this.f47125h.a(this.f47133p);
                        this.f47125h.a(this.f47139v, this.f47140w);
                        this.f47125h.a(this.f47137t);
                        this.f47125h.b(this.f47138u);
                        this.f47125h.a(str, i11);
                        return;
                    }
                } catch (Exception unused) {
                }
                if (this.f47127j != null) {
                    this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880029), i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void b(int i11, int i12) {
        int i13 = z.i(com.mbridge.msdk.foundation.controller.c.m().c());
        int iG = z.g(com.mbridge.msdk.foundation.controller.c.m().c());
        int i14 = this.f47138u;
        if (i14 == 1) {
            if (iG >= i12 * 4) {
                this.f47140w = iG - i12;
                this.f47139v = i13;
                return;
            } else {
                this.f47140w = 0;
                this.f47139v = 0;
                return;
            }
        }
        if (i14 == 2) {
            if (i13 >= i11 * 4) {
                this.f47139v = i13 - i11;
                this.f47140w = iG;
            } else {
                this.f47140w = 0;
                this.f47139v = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final CampaignEx campaignEx, final int i11, final boolean z11) {
        if (!com.mbridge.msdk.splash.c.d.a(this.f47130m, campaignEx)) {
            if (i11 > 0) {
                this.f47126i.f47011o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.d.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.b(campaignEx, i11 - 1, z11);
                    }
                }, 1L);
                return;
            }
            d dVar = this.f47129l;
            if (dVar != null) {
                dVar.a(this.f47122e, "campaignEx is not ready");
                return;
            }
            return;
        }
        d(true);
        ViewGroup.LayoutParams layoutParams = this.f47131n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f47131n.setLayoutParams(layoutParams);
        this.f47131n.removeAllViews();
        this.f47126i.a(this.f47123f);
        this.f47126i.a(this.f47135r);
        this.f47126i.a(this.f47129l);
        ad.b(f47118b, "start show process");
        ViewGroup viewGroup = this.f47131n;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ar.a(this.f47130m);
            this.f47131n.addView(this.f47130m);
        }
        this.f47126i.a(this.f47137t);
        this.f47126i.a(campaignEx, this.f47130m);
    }

    public final ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(com.mbridge.msdk.foundation.controller.c.m().c(), new BaseSplashPopView.a(this.f47121d, this.f47120c, zoomOutTypeEnum.getIndex(), this.B), this.f47129l);
        this.C = mBSplashPopView;
        return mBSplashPopView;
    }

    public final void a(int i11) {
        this.f47138u = i11;
    }

    public final void a(int i11, int i12) {
        b(i12, i11);
    }

    public final void a(int i11, int i12, int i13, int i14) {
        try {
            MBSplashView mBSplashView = this.f47130m;
            if (mBSplashView != null) {
                mBSplashView.setNotchPadding(i11, i12, i13, i14);
            }
        } catch (Throwable th2) {
            ad.b(f47118b, th2.getMessage());
        }
    }

    public final void a(long j11) {
        this.f47124g = j11;
    }

    public final void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f47132o = view;
        if (view != null) {
            b(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.f47130m;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    public final void a(ViewGroup viewGroup) {
        this.f47135r = viewGroup;
    }

    public final void a(CampaignEx campaignEx, int i11, boolean z11) {
        if (campaignEx != null && z11) {
            if (this.f47133p == null) {
                this.f47133p = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47120c);
            }
            this.f47129l = new d(this, this.f47128k, campaignEx);
        }
        ViewGroup viewGroup = this.f47131n;
        if (viewGroup == null) {
            d dVar = this.f47129l;
            if (dVar != null) {
                dVar.a(this.f47122e, "container is null");
                return;
            }
            return;
        }
        if (this.f47126i == null) {
            this.f47126i = new f(viewGroup.getContext(), this.f47121d, this.f47120c);
        }
        this.B = campaignEx;
        b(campaignEx, i11, z11);
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.f47127j == null) {
            this.f47127j = new b(this, this.f47122e);
        }
        this.f47127j.a(mBSplashLoadListener);
    }

    public final void a(MBSplashShowListener mBSplashShowListener) {
        this.f47128k = mBSplashShowListener;
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a(str, 1);
        } else if (this.f47127j != null) {
            this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880035), 1);
        }
    }

    public final void a(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA != null) {
            a(str, viewGroupA);
        } else if (this.f47127j != null) {
            this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880036), 1);
        }
    }

    public final void a(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str)) {
            b(str, viewGroup);
        } else if (this.f47127j != null) {
            this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880035), 1);
        }
    }

    public final void a(boolean z11) {
        this.f47134q = z11;
    }

    public final boolean a() {
        return this.f47134q;
    }

    public final long b() {
        return this.f47124g;
    }

    public final void b(int i11) {
        this.f47123f = i11;
    }

    public final void b(String str) {
        a(str, 1);
    }

    public final void b(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA != null) {
            b(str, viewGroupA);
        } else if (this.f47127j != null) {
            this.f47127j.a(new com.mbridge.msdk.foundation.c.b(880036), 1);
        }
    }

    public final void b(String str, ViewGroup viewGroup) {
        this.f47131n = viewGroup;
        MBSplashView mBSplashView = this.f47130m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public final void b(boolean z11) {
        this.f47137t = z11;
    }

    public final void c(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA != null) {
            c(str, viewGroupA);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f47128k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f47122e, "activity is except,please check it");
        }
    }

    public final void c(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str)) {
            d(str, viewGroup);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f47128k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f47122e, "token is null or empty");
        }
    }

    public final void c(boolean z11) {
        this.A = z11;
    }

    public final boolean c() {
        return this.f47137t;
    }

    public final boolean c(String str) {
        return com.mbridge.msdk.splash.c.d.a(this.f47130m, this.f47121d, this.f47120c, str, this.f47137t, this.f47123f, false, true) != null;
    }

    public final int d() {
        return this.f47123f;
    }

    public final void d(String str, Activity activity) {
        ViewGroup viewGroupA = a(activity);
        if (viewGroupA != null) {
            d(str, viewGroupA);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f47128k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f47122e, "activity is except,please check it");
        }
    }

    public final void d(String str, ViewGroup viewGroup) {
        this.f47131n = viewGroup;
        MBSplashView mBSplashView = this.f47130m;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx campaignExA = com.mbridge.msdk.splash.c.d.a(this.f47130m, this.f47121d, this.f47120c, str, this.f47137t, this.f47123f, true, false);
        if (campaignExA == null) {
            MBSplashShowListener mBSplashShowListener = this.f47128k;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.f47122e, "campaignEx is vali");
                return;
            }
            return;
        }
        if (this.f47133p == null) {
            this.f47133p = h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f47120c);
        }
        d dVar = new d(this, this.f47128k, campaignExA);
        this.f47129l = dVar;
        if (this.f47139v == 0 || this.f47140w == 0) {
            dVar.a(this.f47122e, "width or height is 0  or width or height is too small");
            return;
        }
        int i11 = this.f47123f;
        if (i11 >= 2 && i11 <= 10) {
            a(campaignExA, this.f47133p.r(), false);
            return;
        }
        dVar.a(this.f47122e, "countDownTime must in 2 - 10 ,but now is " + this.f47123f);
    }

    public final void d(boolean z11) {
        MBSplashView mBSplashView = this.f47130m;
        if (mBSplashView != null) {
            mBSplashView.setAllowClickSplash(z11);
        }
    }

    public final String e() {
        if (this.f47119a) {
            f fVar = this.f47126i;
            return fVar != null ? fVar.a() : "";
        }
        e eVar = this.f47125h;
        return eVar != null ? eVar.a() : "";
    }

    public final String f() {
        if (this.f47119a) {
            f fVar = this.f47126i;
            return fVar != null ? fVar.b() : "";
        }
        e eVar = this.f47125h;
        return eVar != null ? eVar.b() : "";
    }

    public final void g() {
        this.D = true;
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public final void h() {
        this.D = false;
        MBSplashShowListener mBSplashShowListener = this.f47128k;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.f47121d, this.f47120c));
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }

    public final void i() {
        f fVar = this.f47126i;
        if (fVar != null) {
            fVar.c();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView == null || !this.D) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    public final void j() {
        f fVar = this.f47126i;
        if (fVar != null) {
            fVar.d();
        }
        MBSplashPopView mBSplashPopView = this.C;
        if (mBSplashPopView == null || !this.D) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    public final void k() {
        this.B = null;
        if (this.f47128k != null) {
            this.f47128k = null;
        }
        if (this.f47127j != null) {
            this.f47127j = null;
        }
        if (this.f47129l != null) {
            this.f47129l = null;
        }
        e eVar = this.f47125h;
        if (eVar != null) {
            eVar.c();
        }
        f fVar = this.f47126i;
        if (fVar != null) {
            fVar.e();
        }
        if (this.f47143z != null) {
            this.f47143z = null;
        }
    }
}
