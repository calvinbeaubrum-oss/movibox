package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
class ImmersionDelegate implements Runnable {
    private c mBarProperties;
    private ImmersionBar mImmersionBar;
    private int mNotchHeight;
    private u mOnBarListener;

    public ImmersionDelegate(Activity activity, Dialog dialog) {
        if (this.mImmersionBar == null) {
            this.mImmersionBar = new ImmersionBar(activity, dialog);
        }
    }

    public ImmersionDelegate(Object obj) {
        if (obj instanceof Activity) {
            if (this.mImmersionBar == null) {
                this.mImmersionBar = new ImmersionBar((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.mImmersionBar == null) {
                if (obj instanceof DialogFragment) {
                    this.mImmersionBar = new ImmersionBar((DialogFragment) obj);
                    return;
                } else {
                    this.mImmersionBar = new ImmersionBar((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.mImmersionBar == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.mImmersionBar = new ImmersionBar((android.app.DialogFragment) obj);
            } else {
                this.mImmersionBar = new ImmersionBar((android.app.Fragment) obj);
            }
        }
    }

    private void barChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar == null || !immersionBar.initialized()) {
            return;
        }
        this.mImmersionBar.getBarParams().getClass();
    }

    public ImmersionBar get() {
        return this.mImmersionBar;
    }

    public void onActivityCreated(Configuration configuration) {
        barChanged(configuration);
    }

    public void onConfigurationChanged(Configuration configuration) {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onConfigurationChanged(configuration);
            barChanged(configuration);
        }
    }

    public void onDestroy() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onDestroy();
            this.mImmersionBar = null;
        }
    }

    public void onResume() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null) {
            immersionBar.onResume();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar == null || immersionBar.getActivity() == null) {
            return;
        }
        Activity activity = this.mImmersionBar.getActivity();
        a aVar = new a(activity);
        this.mBarProperties.g(aVar.k());
        this.mBarProperties.b(aVar.m());
        this.mBarProperties.c(aVar.d());
        this.mBarProperties.d(aVar.g());
        this.mBarProperties.a(aVar.a());
        boolean zHasNotchScreen = NotchUtils.hasNotchScreen(activity);
        this.mBarProperties.f(zHasNotchScreen);
        if (zHasNotchScreen && this.mNotchHeight == 0) {
            int notchHeight = NotchUtils.getNotchHeight(activity);
            this.mNotchHeight = notchHeight;
            this.mBarProperties.e(notchHeight);
        }
        throw null;
    }
}
