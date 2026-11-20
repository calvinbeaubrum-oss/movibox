package com.applovin.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f19503a = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f19504b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f19505c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19506d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference f19507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f19508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f19509g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11, int i12);
    }

    public hl(View view) {
        this.f19507e = new WeakReference(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f19508f = null;
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.iy
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f19781a.b();
            }
        };
        this.f19508f = onPreDrawListener;
        viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
    }

    private boolean a(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b() {
        d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        synchronized (this.f19504b) {
            try {
                this.f19506d = false;
                int iMin = -1;
                int iMax = -1;
                for (Map.Entry entry : this.f19503a.entrySet()) {
                    if (a((View) entry.getKey())) {
                        Integer num = (Integer) entry.getValue();
                        if (iMin == -1 && iMax == -1) {
                            iMin = num.intValue();
                            iMax = num.intValue();
                        } else {
                            iMin = Math.min(iMin, ((Integer) entry.getValue()).intValue());
                            iMax = Math.max(iMax, ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
                a aVar = this.f19509g;
                if (aVar != null) {
                    aVar.a(iMin, iMax);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void d() {
        if (this.f19506d) {
            return;
        }
        this.f19506d = true;
        this.f19505c.postDelayed(new Runnable() { // from class: com.applovin.impl.hy
            @Override // java.lang.Runnable
            public final void run() {
                this.f19552a.c();
            }
        }, 100L);
    }

    public void a() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.f19509g = null;
        View view = (View) this.f19507e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.f19508f) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.f19507e.clear();
        }
    }

    public void a(View view, int i11) {
        synchronized (this.f19504b) {
            this.f19503a.put(view, Integer.valueOf(i11));
            d();
        }
    }

    public void a(a aVar) {
        this.f19509g = aVar;
    }

    public void b(View view) {
        synchronized (this.f19504b) {
            this.f19503a.remove(view);
        }
    }
}
