package com.google.android.ump;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface ConsentForm {

    /* JADX INFO: compiled from: source.java */
    public interface OnConsentFormDismissedListener {
        void onConsentFormDismissed(@Nullable FormError formError);
    }

    void show(@RecentlyNonNull Activity activity, @RecentlyNonNull OnConsentFormDismissedListener onConsentFormDismissedListener);
}
