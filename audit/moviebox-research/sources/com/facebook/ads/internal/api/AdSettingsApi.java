package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public interface AdSettingsApi {
    boolean isTestMode(Context context);

    void turnOnDebugger();
}
