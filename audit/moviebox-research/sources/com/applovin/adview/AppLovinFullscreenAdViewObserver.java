package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.t;
import com.applovin.impl.p9;
import com.applovin.impl.sdk.j;
import com.applovin.impl.tb;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinFullscreenAdViewObserver implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f17143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f17144b = new AtomicBoolean(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p9 f17145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private tb f17146d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, tb tbVar, j jVar) {
        this.f17146d = tbVar;
        this.f17143a = jVar;
        lifecycle.a(this);
    }

    @e0(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        tb tbVar = this.f17146d;
        if (tbVar != null) {
            tbVar.a();
            this.f17146d = null;
        }
        p9 p9Var = this.f17145c;
        if (p9Var != null) {
            p9Var.f();
            this.f17145c.v();
            this.f17145c = null;
        }
    }

    @e0(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        p9 p9Var = this.f17145c;
        if (p9Var != null) {
            p9Var.w();
            this.f17145c.z();
        }
    }

    @e0(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        p9 p9Var;
        if (this.f17144b.getAndSet(false) || (p9Var = this.f17145c) == null) {
            return;
        }
        p9Var.x();
        this.f17145c.a(0L);
    }

    @e0(Lifecycle.Event.ON_STOP)
    public void onStop() {
        p9 p9Var = this.f17145c;
        if (p9Var != null) {
            p9Var.y();
        }
    }

    public void setPresenter(p9 p9Var) {
        this.f17145c = p9Var;
    }
}
