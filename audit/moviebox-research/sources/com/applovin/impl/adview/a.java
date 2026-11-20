package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.ca;
import com.applovin.impl.ea;
import com.applovin.impl.gc;
import com.applovin.impl.jn;
import com.applovin.impl.la;
import com.applovin.impl.mg;
import com.applovin.impl.og;
import com.applovin.impl.pi;
import com.applovin.impl.qb;
import com.applovin.impl.qc;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.t6;
import com.applovin.impl.tm;
import com.applovin.impl.tr;
import com.applovin.impl.vb;
import com.applovin.impl.yp;
import com.applovin.impl.zq;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements AppLovinCommunicatorSubscriber {
    private static final AtomicReference H = new AtomicReference();
    private volatile AppLovinAdLoadListener C;
    private volatile AppLovinAdDisplayListener D;
    private volatile AppLovinAdViewEventListener E;
    private volatile AppLovinAdClickListener F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f17519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f17520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.applovin.impl.sdk.j f17521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdServiceImpl f17522d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.n f17523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AppLovinCommunicator f17524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f17525h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AppLovinAdSize f17527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f17528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private androidx.browser.customtabs.j f17529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.applovin.impl.adview.c f17530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f17531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.applovin.impl.adview.b f17532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WebView f17533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k f17534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Runnable f17535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Runnable f17536s;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f17526i = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f17537t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile AppLovinAd f17538u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f f17539v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f f17540w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicReference f17541x = new AtomicReference();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f17542y = new AtomicBoolean();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile boolean f17543z = false;
    private volatile boolean A = false;
    private volatile boolean B = false;
    private volatile com.applovin.impl.g0 G = null;

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(a aVar);
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f17532o != null) {
                a.this.f17532o.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: com.applovin.impl.adview.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0177a implements k.a {
            public C0177a() {
            }

            @Override // com.applovin.impl.adview.k.a
            public void a() {
                a.this.f17532o.addView(a.this.f17534q, new ViewGroup.LayoutParams(-1, -1));
            }

            @Override // com.applovin.impl.adview.k.a
            public void onFailure() {
                com.applovin.impl.sdk.n unused = a.this.f17523f;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f17523f.b("AppLovinAdView", "Watermark failed to render.");
                }
            }
        }

        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f17537t != null) {
                if (a.this.f17532o == null) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to render advertisement for ad #" + a.this.f17537t.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                    gc.a(a.this.E, a.this.f17537t, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
                    return;
                }
                a.this.w();
                com.applovin.impl.sdk.n unused = a.this.f17523f;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f17523f.a("AppLovinAdView", "Rendering advertisement ad for #" + a.this.f17537t.getAdIdNumber() + "...");
                }
                a.b(a.this.f17532o, a.this.f17537t.getSize());
                if (a.this.f17534q != null) {
                    zq.c(a.this.f17534q);
                    a.this.f17534q = null;
                }
                ea eaVar = new ea(a.this.f17526i, a.this.f17521c);
                if (eaVar.c()) {
                    a.this.f17534q = new k(eaVar, a.this.f17519a);
                    a.this.f17534q.a(new C0177a());
                }
                a.this.f17532o.setAdHtmlLoaded(false);
                a.this.f17532o.a(a.this.f17537t);
                if (a.this.f17537t.getSize() == AppLovinAdSize.INTERSTITIAL || a.this.A) {
                    return;
                }
                a.this.f17537t.setHasShown(true);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f17547a;

        public e(a aVar, com.applovin.impl.sdk.j jVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("No view specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f17547a = aVar;
        }

        private a a() {
            return this.f17547a;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(appLovinAd);
            } else {
                com.applovin.impl.sdk.n.h("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i11) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(i11);
            }
        }
    }

    private void G() {
        com.applovin.impl.adview.b bVar;
        if (this.f17523f != null && com.applovin.impl.sdk.n.a() && com.applovin.impl.sdk.n.a()) {
            this.f17523f.a("AppLovinAdView", "Destroying...");
        }
        if (!((Boolean) this.f17521c.a(sj.G1)).booleanValue() || (bVar = this.f17532o) == null) {
            tr.b(this.f17532o);
        } else {
            tr.a(bVar);
            f().a(this.f17532o, new vb.b() { // from class: com.applovin.impl.adview.w
                @Override // com.applovin.impl.vb.b
                public final void a(Object obj) {
                    tr.b((b) obj);
                }
            });
        }
        this.f17532o = null;
        tr.b(this.f17533p);
        this.f17533p = null;
        this.f17529l = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.E = null;
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i11) {
        try {
            if (this.C != null) {
                this.C.failedToReceiveAd(i11);
            }
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while running app load callback", th2);
            com.applovin.impl.sdk.j jVar = this.f17521c;
            if (jVar != null) {
                jVar.E().a("AppLovinAdView", "notifyAdLoadFailed", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        a();
    }

    private void a(AppLovinAdView appLovinAdView, com.applovin.impl.sdk.j jVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (appLovinAdSize == null) {
            throw new IllegalArgumentException("No ad size specified");
        }
        this.f17521c = jVar;
        this.f17522d = jVar.i();
        this.f17523f = jVar.J();
        this.f17524g = AppLovinCommunicator.getInstance(context);
        this.f17527j = appLovinAdSize;
        this.f17528k = str;
        if (!(context instanceof AppLovinFullscreenActivity)) {
            context = context.getApplicationContext();
        }
        this.f17519a = context;
        this.f17520b = appLovinAdView;
        this.f17530m = new com.applovin.impl.adview.c(this, jVar);
        this.f17536s = new c();
        this.f17535r = new d();
        this.f17531n = new e(this, jVar);
        a(appLovinAdSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f17542y.compareAndSet(true, false)) {
            a(this.f17527j);
        }
        try {
            if (this.C != null) {
                this.C.adReceived(appLovinAd);
            }
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Exception while running ad load callback: " + th2.getMessage());
            com.applovin.impl.sdk.j jVar = this.f17521c;
            if (jVar != null) {
                jVar.E().a("AppLovinAdView", "notifyAdLoaded", th2);
            }
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        String str3;
        if (StringUtils.isValidString(str)) {
            str3 = "gtag('event', '" + str2 + "', " + str + ");";
        } else {
            str3 = "gtag('event', '" + str2 + "')";
        }
        tr.a(this.f17533p, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i11) {
        if (!this.A) {
            a(this.f17536s);
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17594a.a(i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent) {
        if (this.f17539v == null && (this.f17537t instanceof com.applovin.impl.sdk.ad.a) && this.f17532o != null) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f17537t;
            Context context = this.f17519a;
            Activity activityA = context instanceof Activity ? (Activity) context : zq.a(this.f17532o, this.f17521c);
            if (activityA == null || activityA.isFinishing()) {
                com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to expand ad. No Activity found.");
                Uri uriJ = aVar.j();
                if (uriJ != null) {
                    this.f17522d.trackAndLaunchClick(aVar, k(), this, uriJ, motionEvent, this.B, null);
                }
                this.f17532o.a("javascript:al_onFailedExpand();");
                return;
            }
            ViewGroup viewGroup = this.f17520b;
            if (viewGroup != null) {
                viewGroup.removeView(this.f17532o);
            }
            f fVar = new f(aVar, this.f17532o, activityA, this.f17521c);
            this.f17539v = fVar;
            fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.z
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f17636a.a(dialogInterface);
                }
            });
            this.f17539v.show();
            gc.c(this.E, this.f17537t, (AppLovinAdView) this.f17520b);
            if (this.f17537t.isOpenMeasurementEnabled()) {
                this.f17537t.getAdEventTracker().a((View) this.f17539v.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize) {
        int iApplyDimension;
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        String label = appLovinAdSize.getLabel();
        AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
        int iApplyDimension2 = -1;
        if (label.equals(appLovinAdSize2.getLabel())) {
            iApplyDimension = -1;
        } else {
            iApplyDimension = appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getWidth(), displayMetrics);
        }
        if (!appLovinAdSize.getLabel().equals(appLovinAdSize2.getLabel())) {
            iApplyDimension2 = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getHeight(), displayMetrics);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = iApplyDimension;
        layoutParams.height = iApplyDimension2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        this.f17537t.getAdEventTracker().c(webView);
        k kVar = this.f17534q;
        if (kVar == null || !kVar.a()) {
            this.f17537t.getAdEventTracker().a((View) webView);
        } else {
            mg adEventTracker = this.f17537t.getAdEventTracker();
            k kVar2 = this.f17534q;
            adEventTracker.b(webView, Collections.singletonList(new og(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier())));
        }
        this.f17537t.getAdEventTracker().h();
        this.f17537t.getAdEventTracker().g();
    }

    private void c() {
        a(new Runnable() { // from class: com.applovin.impl.adview.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f17624a.s();
            }
        });
    }

    private void d() {
        a(new Runnable() { // from class: com.applovin.impl.adview.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f17625a.t();
            }
        });
    }

    public static vb f() {
        AtomicReference atomicReference = H;
        Object dVar = atomicReference.get();
        if (dVar == null) {
            synchronized (atomicReference) {
                try {
                    dVar = atomicReference.get();
                    if (dVar == null) {
                        dVar = new vb.d();
                        atomicReference.set(dVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        if (dVar == atomicReference) {
            dVar = null;
        }
        return (vb) dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.applovin.impl.adview.b o() {
        return new com.applovin.impl.adview.b(this.f17521c, this.f17519a.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f17532o.loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        com.applovin.impl.adview.b bVar;
        d();
        if (this.f17520b == null || (bVar = this.f17532o) == null || bVar.getParent() != null) {
            return;
        }
        this.f17520b.addView(this.f17532o);
        b(this.f17532o, this.f17537t.getSize());
        if (this.f17537t.isOpenMeasurementEnabled()) {
            this.f17537t.getAdEventTracker().a((View) this.f17532o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (this.f17532o != null && this.f17539v != null) {
            a();
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        if (this.f17539v != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17523f.a("AppLovinAdView", "Detaching expanded ad: " + this.f17539v.b());
            }
            this.f17540w = this.f17539v;
            this.f17539v = null;
            a(this.f17527j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        com.applovin.impl.sdk.ad.a aVarB;
        f fVar = this.f17540w;
        if (fVar == null && this.f17539v == null) {
            return;
        }
        if (fVar != null) {
            aVarB = fVar.b();
            this.f17540w.dismiss();
            this.f17540w = null;
        } else {
            aVarB = this.f17539v.b();
            this.f17539v.dismiss();
            this.f17539v = null;
        }
        gc.a(this.E, aVarB, (AppLovinAdView) this.f17520b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        g().loadUrl("chrome://crash");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.applovin.impl.sdk.ad.b bVar = this.f17537t;
        qc qcVar = new qc();
        qcVar.a().a(bVar).a(k());
        if (!yp.a(bVar.getSize())) {
            qcVar.a().a("Fullscreen Ad Properties").b(bVar);
        }
        qcVar.a(this.f17521c);
        qcVar.a();
        if (com.applovin.impl.sdk.n.a()) {
            this.f17523f.a("AppLovinAdView", qcVar.toString());
        }
    }

    private void y() {
        if (this.f17537t.T0()) {
            int iA = this.f17521c.n().a();
            if (com.applovin.impl.sdk.f.a(iA)) {
                this.f17532o.a("javascript:al_muteSwitchOn();");
            } else if (iA == 2) {
                this.f17532o.a("javascript:al_muteSwitchOff();");
            }
        }
    }

    public void A() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f17523f.a("AppLovinAdView", "AdView fully watched...");
        }
        b bVar = this.f17525h;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void B() {
        if (com.applovin.impl.e0.a(this.f17532o)) {
            this.f17521c.D().c(ca.f18161r);
        }
    }

    public void C() {
        if (this.f17543z) {
            gc.b(this.D, this.f17537t);
            if (this.f17537t != null && this.f17537t.isOpenMeasurementEnabled() && yp.a(this.f17537t.getSize())) {
                this.f17537t.getAdEventTracker().f();
            }
            if (this.f17532o == null || this.f17539v == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f17523f.a("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                }
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f17523f.a("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                c();
            }
        }
    }

    public void D() {
        this.B = true;
    }

    public void E() {
        this.B = false;
    }

    public void F() {
        if (!this.f17543z || this.A) {
            return;
        }
        this.A = true;
    }

    public void H() {
        if (this.f17543z) {
            AppLovinAd appLovinAd = (AppLovinAd) this.f17541x.getAndSet(null);
            if (appLovinAd != null) {
                c(appLovinAd);
            }
            this.A = false;
        }
    }

    public void a() {
        a(new Runnable() { // from class: com.applovin.impl.adview.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f17633a.q();
            }
        });
    }

    public void a(Uri uri) {
        if (this.f17537t == null || !this.f17537t.C0()) {
            return;
        }
        if (this.f17533p == null) {
            this.f17521c.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f17521c.J().a("AppLovinAdView", "GA is not initialized. Cannot fire GA event");
                return;
            }
            return;
        }
        final String queryParameter = uri.getQueryParameter("event_name");
        final String queryParameter2 = uri.getQueryParameter("event_params_json");
        if (!TextUtils.isEmpty(queryParameter)) {
            a(new Runnable() { // from class: com.applovin.impl.adview.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17630a.a(queryParameter2, queryParameter);
                }
            });
            return;
        }
        this.f17521c.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f17521c.J().a("AppLovinAdView", "Invalid GA event name. Cannot fire GA event");
        }
    }

    public void a(final MotionEvent motionEvent) {
        a(new Runnable() { // from class: com.applovin.impl.adview.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f17626a.b(motionEvent);
            }
        });
    }

    public void a(final WebView webView, String str) {
        if (this.f17537t == null) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.a0
            @Override // java.lang.Runnable
            public final void run() {
                webView.setVisibility(0);
            }
        });
        if (!((Boolean) this.f17521c.a(sj.f22987j6)).booleanValue() || (str != null && str.startsWith(this.f17537t.h()))) {
            try {
                if (this.f17537t != this.f17538u) {
                    this.f17538u = this.f17537t;
                    y();
                    this.f17532o.setAdHtmlLoaded(true);
                    if (this.D != null) {
                        this.f17521c.w().d(this.f17537t);
                        this.f17521c.E().a(la.f20382k, this.f17537t);
                        gc.a(this.D, this.f17537t);
                        this.f17532o.a("javascript:al_onAdViewRendered();");
                    }
                    if ((this.f17537t instanceof com.applovin.impl.sdk.ad.a) && this.f17537t.isOpenMeasurementEnabled()) {
                        this.f17521c.j0().a(new jn(this.f17521c, "StartOMSDK", new Runnable() { // from class: com.applovin.impl.adview.b0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f17576a.b(webView);
                            }
                        }), tm.b.OTHER, 500L);
                    }
                }
            } catch (Throwable th2) {
                com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while notifying ad display listener", th2);
                com.applovin.impl.sdk.j jVar = this.f17521c;
                if (jVar != null) {
                    jVar.E().a("AppLovinAdView", "onAdHtmlLoaded", th2);
                }
            }
        }
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
            return;
        }
        if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.e0.a(attributeSet)) == null) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        }
        AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        if (appLovinSdk != null) {
            a(appLovinAdView, appLovinSdk.a(), appLovinAdSize2, str, context);
            if (com.applovin.impl.e0.b(attributeSet)) {
                v();
            }
        }
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.E = appLovinAdViewEventListener;
    }

    public void a(b bVar) {
        this.f17525h = bVar;
    }

    public void a(com.applovin.impl.g0 g0Var) {
        this.G = g0Var;
    }

    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        if (appLovinAdView != null) {
            this.f17522d.trackAndLaunchClick(bVar, appLovinAdView, this, uri, motionEvent, this.B, bundle);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f17523f.b("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
        gc.a(this.F, bVar);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        yp.b(appLovinAd, this.f17521c);
        if (!this.f17543z) {
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) yp.a(appLovinAd, this.f17521c);
        if (bVar == null) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to retrieve the loaded ad: " + appLovinAd);
            gc.a(this.D, "Unable to retrieve the loaded ad");
            return;
        }
        if (bVar == this.f17537t) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Attempting to show ad again: " + bVar);
            if (((Boolean) this.f17521c.a(sj.Y1)).booleanValue()) {
                if (!(this.D instanceof qb)) {
                    throw new IllegalStateException("Attempting to show ad again");
                }
                gc.a(this.D, "Attempting to show ad again");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f17523f.a("AppLovinAdView", "Rendering ad #" + bVar.getAdIdNumber() + " (" + bVar.getSize() + ")");
        }
        gc.b(this.D, this.f17537t);
        if (this.f17537t != null && this.f17537t.isOpenMeasurementEnabled()) {
            this.f17537t.getAdEventTracker().f();
        }
        this.f17541x.set(null);
        this.f17538u = null;
        this.f17537t = bVar;
        if (this.f17537t.A0()) {
            this.f17529l = this.f17521c.x().a(this);
            this.f17521c.x().b(this.f17537t.A(), this.f17529l);
        }
        if (!this.A && yp.a(this.f17527j)) {
            this.f17521c.i().trackImpression(bVar);
        }
        if (this.f17539v != null) {
            c();
        }
        a(this.f17535r);
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.F = appLovinAdClickListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.D = appLovinAdDisplayListener;
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.C = appLovinAdLoadListener;
    }

    public void a(AppLovinAdSize appLovinAdSize) {
        try {
            if (((Boolean) this.f17521c.a(sj.G1)).booleanValue()) {
                this.f17532o = (com.applovin.impl.adview.b) f().a(new vb.a() { // from class: com.applovin.impl.adview.t
                    @Override // com.applovin.impl.vb.a
                    public final Object a() {
                        return this.f17628a.o();
                    }
                });
            } else {
                this.f17532o = new com.applovin.impl.adview.b(this.f17521c, this.f17519a);
            }
            this.f17532o.a(this.f17530m);
            this.f17532o.setBackgroundColor(0);
            this.f17532o.setWillNotCacheDrawing(false);
            this.f17520b.setBackgroundColor(0);
            this.f17520b.addView(this.f17532o);
            b(this.f17532o, appLovinAdSize);
            if (!this.f17543z) {
                a(this.f17536s);
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17629a.p();
                }
            });
            this.f17543z = true;
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Failed to initialize AdWebView", th2);
            this.f17521c.E().a("AppLovinAdView", "initAdWebView", th2);
            this.f17542y.set(true);
        }
    }

    public void a(String str, Object obj) {
        this.f17526i.put(str, obj);
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.adview.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f17581a.r();
            }
        });
    }

    public void b(Uri uri) {
        if (this.f17537t != null && this.f17537t.C0() && this.f17533p == null) {
            String queryParameter = uri.getQueryParameter("tracking_id");
            if (TextUtils.isEmpty(queryParameter)) {
                this.f17521c.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f17521c.J().b("AppLovinAdView", "Invalid tracking id. Cannot initialize GA");
                    return;
                }
                return;
            }
            WebView webView = new WebView(this.f17519a);
            this.f17533p = webView;
            webView.setWebViewClient(new pi());
            this.f17533p.getSettings().setJavaScriptEnabled(true);
            this.f17533p.loadDataWithBaseURL((String) this.f17521c.a(sj.D6), "<html><head><link rel=\"icon\" href=\"data:,\"><G-SCRIPT_TAG></head><body></body></html>".replace("<G-SCRIPT_TAG>", "<script src='https://www.googletagmanager.com/gtag/js?id=<G-TRACKING_ID>'></script><script>window.dataLayer = window.dataLayer || [];function gtag(){dataLayer.push(arguments);}gtag('js', new Date());gtag('config', '<G-TRACKING_ID>')</script>".replace("<G-TRACKING_ID>", queryParameter)), "text/html", "UTF-8", null);
        }
    }

    public void b(final AppLovinAd appLovinAd) {
        if (appLovinAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17523f.b("AppLovinAdView", "No provided when to the view controller");
            }
            b(-1);
        } else {
            if (this.A) {
                this.f17541x.set(appLovinAd);
                if (com.applovin.impl.sdk.n.a()) {
                    this.f17523f.a("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            } else {
                c(appLovinAd);
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17634a.a(appLovinAd);
                }
            });
        }
    }

    public void c(WebView webView) {
        a(webView, (String) null);
    }

    public void c(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public AppLovinAdViewEventListener e() {
        return this.E;
    }

    public com.applovin.impl.adview.b g() {
        return this.f17532o;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return a.class.getSimpleName();
    }

    public com.applovin.impl.g0 h() {
        return this.G;
    }

    public com.applovin.impl.sdk.ad.b i() {
        return this.f17537t;
    }

    public androidx.browser.customtabs.j j() {
        return this.f17529l;
    }

    public AppLovinAdView k() {
        return (AppLovinAdView) this.f17520b;
    }

    public com.applovin.impl.sdk.j l() {
        return this.f17521c;
    }

    public AppLovinAdSize m() {
        return this.f17527j;
    }

    public String n() {
        return this.f17528k;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a(new Runnable() { // from class: com.applovin.impl.adview.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17585a.u();
                }
            });
        }
    }

    public void v() {
        if (this.f17521c == null || this.f17531n == null || this.f17519a == null || !this.f17543z) {
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f17522d.loadNextAd(this.f17528k, this.f17527j, this.f17531n);
        }
    }

    public void x() {
        if ((this.f17519a instanceof t6) && this.f17537t != null && this.f17537t.R() == com.applovin.impl.sdk.ad.b.EnumC0200b.DISMISS) {
            ((t6) this.f17519a).dismiss();
        }
    }

    public void z() {
        if (this.f17539v != null || this.f17540w != null) {
            a();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f17523f.a("AppLovinAdView", "Ad: " + this.f17537t + " closed.");
        }
        a(this.f17536s);
        gc.b(this.D, this.f17537t);
        this.f17537t = null;
    }
}
