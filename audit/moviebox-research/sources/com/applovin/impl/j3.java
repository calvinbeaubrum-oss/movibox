package com.applovin.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.applovin.impl.adview.AppLovinWebViewBase;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j3 extends AppLovinWebViewBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f19833b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f19834a;

    public j3(Context context) {
        super(context);
        this.f19834a = new AtomicReference();
        if (f19833b == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", MotionEvent.class);
                f19833b = Boolean.TRUE;
            } catch (NoSuchMethodException unused) {
                com.applovin.impl.sdk.n.h("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                f19833b = Boolean.FALSE;
            }
        }
    }

    public boolean a() {
        return this.f19834a.get() != null;
    }

    @Nullable
    public MotionEvent getAndClearLastClickEvent() {
        return (MotionEvent) this.f19834a.getAndSet(null);
    }

    @Nullable
    public MotionEvent getLastClickEvent() {
        return (MotionEvent) this.f19834a.get();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f19834a.set(MotionEvent.obtain(motionEvent));
        if (f19833b.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
