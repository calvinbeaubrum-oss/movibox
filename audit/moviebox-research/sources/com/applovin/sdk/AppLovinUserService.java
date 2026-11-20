package com.applovin.sdk;

import android.app.Activity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AppLovinUserService {

    /* JADX INFO: compiled from: source.java */
    public interface OnConsentDialogDismissListener {
        void onDismiss();
    }

    void preloadConsentDialog();

    void showConsentDialog(Activity activity, OnConsentDialogDismissListener onConsentDialogDismissListener);
}
