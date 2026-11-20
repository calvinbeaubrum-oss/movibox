package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class x extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImmersionDelegate f41666a;

    public ImmersionBar a(Activity activity, Dialog dialog) {
        if (this.f41666a == null) {
            this.f41666a = new ImmersionDelegate(activity, dialog);
        }
        return this.f41666a.get();
    }

    public ImmersionBar b(Object obj) {
        if (this.f41666a == null) {
            this.f41666a = new ImmersionDelegate(obj);
        }
        return this.f41666a.get();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.f41666a;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.f41666a;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.f41666a;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.f41666a = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.f41666a;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }
}
