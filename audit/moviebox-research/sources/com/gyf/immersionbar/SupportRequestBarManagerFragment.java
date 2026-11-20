package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class SupportRequestBarManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImmersionDelegate f41607a;

    public ImmersionBar g0(Activity activity, Dialog dialog) {
        if (this.f41607a == null) {
            this.f41607a = new ImmersionDelegate(activity, dialog);
        }
        return this.f41607a.get();
    }

    public ImmersionBar h0(Object obj) {
        if (this.f41607a == null) {
            this.f41607a = new ImmersionDelegate(obj);
        }
        return this.f41607a.get();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.f41607a;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.f41607a;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.f41607a;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.f41607a = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ImmersionDelegate immersionDelegate = this.f41607a;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
    }
}
