package com.applovin.impl;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f18037a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f18041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f18042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f18043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f18044h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18047k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f18048l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f18049m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f18050n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18038b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f18039c = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WeakReference f18045i = new WeakReference(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference f18046j = new WeakReference(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f18051o = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f18040d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onLogVisibilityImpression();
    }

    public br(final View view, com.applovin.impl.sdk.j jVar, a aVar) {
        this.f18037a = jVar.J();
        this.f18044h = ((Long) jVar.a(sj.S1)).longValue();
        this.f18043g = new WeakReference(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f18041e = new Runnable() { // from class: com.applovin.impl.nt
            @Override // java.lang.Runnable
            public final void run() {
                this.f21423a.a(weakReference);
            }
        };
        this.f18042f = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.ot
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f21619a.a(view);
            }
        };
    }

    private void a() {
        this.f18040d.postDelayed(this.f18041e, this.f18044h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WeakReference weakReference) {
        View view = (View) this.f18043g.get();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View view2 = (View) this.f18046j.get();
        if (viewGroup == null || view2 == null) {
            return;
        }
        if (!a(viewGroup, view2)) {
            a();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f18037a.a("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
        }
        b();
        a aVar = (a) weakReference.get();
        if (aVar != null) {
            aVar.onLogVisibilityImpression();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        a();
        b(view);
        return true;
    }

    private boolean a(View view, View view2) {
        if (!b(view, view2)) {
            return false;
        }
        if (this.f18051o == Long.MIN_VALUE) {
            this.f18051o = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f18051o >= this.f18050n;
    }

    private void b(View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f18045i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f18042f);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.f18042f);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f18037a.a("VisibilityTracker", "Could not remove on pre-draw listener. View tree observer is not alive.");
            }
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f18037a.a("VisibilityTracker", "Could not remove on pre-draw listener. Root view is null.");
        }
        this.f18045i.clear();
    }

    private boolean b(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.f18039c)) {
            return false;
        }
        long jPxToDp = AppLovinSdkUtils.pxToDp(view2.getContext(), this.f18039c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f18039c.height());
        if (jPxToDp < this.f18047k) {
            return false;
        }
        if ((jPxToDp / (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))) * 100.0f < this.f18048l) {
            return false;
        }
        return (((float) ((long) (this.f18039c.width() * this.f18039c.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f >= this.f18049m;
    }

    private void c(View view) {
        View viewB = zq.b((View) this.f18043g.get());
        if (viewB == null) {
            viewB = zq.b(view);
        }
        if (viewB == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f18037a.a("VisibilityTracker", "Unable to set view tree observer due to no root view.");
                return;
            }
            return;
        }
        ViewTreeObserver viewTreeObserver = viewB.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f18045i = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f18042f);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f18037a.k("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
        }
    }

    public void a(int i11, float f11, float f12, long j11, View view) {
        synchronized (this.f18038b) {
            try {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f18037a.a("VisibilityTracker", "Tracking visibility for " + view);
                }
                b();
                WeakReference weakReference = new WeakReference(view);
                this.f18046j = weakReference;
                this.f18047k = i11;
                this.f18048l = f11;
                this.f18049m = f12;
                this.f18050n = j11;
                c((View) weakReference.get());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(ne neVar) {
        View viewR0;
        if (neVar instanceof he) {
            viewR0 = neVar.z();
        } else if (!(neVar instanceof je)) {
            return;
        } else {
            viewR0 = ((je) neVar).r0();
        }
        a(neVar.j0(), neVar.l0(), neVar.m0(), neVar.n0(), viewR0);
    }

    public void b() {
        synchronized (this.f18038b) {
            this.f18040d.removeMessages(0);
            b((View) this.f18043g.get());
            this.f18051o = Long.MIN_VALUE;
            this.f18046j.clear();
        }
    }
}
