package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<ViewTreeObserver> f45554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<View> f45555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f45556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f45557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f45558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f45559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45560g;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(ArrayList<View> arrayList, ArrayList<View> arrayList2);
    }

    public c(List<View> list, a aVar, Handler handler, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f45555b = arrayList;
        this.f45556c = null;
        this.f45557d = aVar;
        this.f45558e = handler;
        this.f45560g = i11;
        if (list != null) {
            this.f45555b = list;
        } else {
            arrayList.clear();
        }
        try {
            b();
        } catch (Throwable th2) {
            ad.a("ImpressionTracker", th2.getMessage(), th2);
        }
        try {
            this.f45556c = new ViewTreeObserver.OnPreDrawListener() { // from class: com.mbridge.msdk.mbnative.controller.c.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    c.this.b();
                    return true;
                }
            };
        } catch (Throwable th3) {
            ad.a("ImpressionTracker", th3.getMessage(), th3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f45559f) {
            return;
        }
        Handler handler = this.f45558e;
        if (handler != null) {
            if (this.f45560g == 1) {
                c();
            } else {
                handler.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.c();
                    }
                }, 100L);
            }
        }
        this.f45559f = true;
    }

    private boolean b(View view) {
        return !aq.a(view, this.f45560g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.f45559f = false;
            List<View> list = this.f45555b;
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList<View> arrayList = new ArrayList<>();
            ArrayList<View> arrayList2 = new ArrayList<>();
            for (int i11 = 0; i11 < this.f45555b.size(); i11++) {
                View view = this.f45555b.get(i11);
                if (b(view)) {
                    arrayList.add(view);
                } else {
                    arrayList2.add(view);
                }
            }
            a aVar = this.f45557d;
            if (aVar != null) {
                aVar.a(arrayList, arrayList2);
            }
            if (arrayList.size() > 0) {
                a();
            }
            arrayList.clear();
            arrayList2.clear();
        } catch (Exception unused) {
        }
    }

    public final void a() {
        try {
            this.f45559f = false;
            WeakReference<ViewTreeObserver> weakReference = this.f45554a;
            if (weakReference != null && weakReference.get() != null) {
                ViewTreeObserver viewTreeObserver = this.f45554a.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f45556c);
                }
                this.f45554a.clear();
            }
            this.f45557d = null;
            this.f45556c = null;
            List<View> list = this.f45555b;
            if (list != null) {
                list.clear();
            }
            this.f45555b = null;
        } catch (Throwable unused) {
        }
    }

    public final void a(View view) {
        final View viewA;
        View view2;
        if (view != null) {
            viewA = f.a(view.getContext(), view);
            this.f45555b.add(view);
        } else {
            List<View> list = this.f45555b;
            viewA = null;
            if (list != null && list.size() > 0) {
                for (int i11 = 0; i11 < this.f45555b.size() && ((view2 = this.f45555b.get(i11)) == null || (viewA = f.a(view2.getContext(), view2)) == null); i11++) {
                }
            }
        }
        if (viewA == null) {
            return;
        }
        viewA.post(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.c.3
            @Override // java.lang.Runnable
            public final void run() {
                ViewTreeObserver viewTreeObserver = viewA.getViewTreeObserver();
                if (viewTreeObserver == null || viewTreeObserver.isAlive()) {
                    c.this.f45554a = new WeakReference(viewTreeObserver);
                    if (c.this.f45556c != null) {
                        viewTreeObserver.addOnPreDrawListener(c.this.f45556c);
                    }
                }
            }
        });
    }
}
