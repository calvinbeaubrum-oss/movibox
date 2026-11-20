package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class z implements androidx.lifecycle.m, f6.e, y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f8648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f8649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0.c f8650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.w f8651d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f6.d f8652f = null;

    public z(@NonNull Fragment fragment, @NonNull x0 x0Var) {
        this.f8648a = fragment;
        this.f8649b = x0Var;
    }

    public void a(@NonNull Lifecycle.Event event) {
        this.f8651d.i(event);
    }

    public void b() {
        if (this.f8651d == null) {
            this.f8651d = new androidx.lifecycle.w(this);
            f6.d dVarA = f6.d.a(this);
            this.f8652f = dVarA;
            dVarA.c();
            o0.c(this);
        }
    }

    public boolean c() {
        return this.f8651d != null;
    }

    public void d(@Nullable Bundle bundle) {
        this.f8652f.d(bundle);
    }

    public void e(@NonNull Bundle bundle) {
        this.f8652f.e(bundle);
    }

    public void f(@NonNull Lifecycle.State state) {
        this.f8651d.n(state);
    }

    @Override // androidx.lifecycle.m
    @NonNull
    @CallSuper
    public r3.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f8648a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        r3.b bVar = new r3.b();
        if (application != null) {
            bVar.c(v0.a.f8785g, application);
        }
        bVar.c(o0.f8761a, this);
        bVar.c(o0.f8762b, this);
        if (this.f8648a.getArguments() != null) {
            bVar.c(o0.f8763c, this.f8648a.getArguments());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.m
    @NonNull
    public v0.c getDefaultViewModelProviderFactory() {
        Application application;
        v0.c defaultViewModelProviderFactory = this.f8648a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f8648a.mDefaultFactory)) {
            this.f8650c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f8650c == null) {
            Context applicationContext = this.f8648a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f8650c = new q0(application, this, this.f8648a.getArguments());
        }
        return this.f8650c;
    }

    @Override // androidx.lifecycle.u
    @NonNull
    public Lifecycle getLifecycle() {
        b();
        return this.f8651d;
    }

    @Override // f6.e
    @NonNull
    public f6.c getSavedStateRegistry() {
        b();
        return this.f8652f.b();
    }

    @Override // androidx.lifecycle.y0
    @NonNull
    public x0 getViewModelStore() {
        b();
        return this.f8649b;
    }
}
