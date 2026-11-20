package com.applovin.sdk;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AppLovinCmpService {

    /* JADX INFO: compiled from: source.java */
    public interface OnCompletedListener {
        void onCompleted(@Nullable AppLovinCmpError appLovinCmpError);
    }

    boolean hasSupportedCmp();

    void showCmpForExistingUser(@NonNull Activity activity, @NonNull OnCompletedListener onCompletedListener);
}
