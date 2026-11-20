package com.hisavana.common.interfacz;

import android.app.Activity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface IadInterstitial {
    boolean isLoaded();

    void onResume();

    void show(Activity activity, String str, String str2);
}
