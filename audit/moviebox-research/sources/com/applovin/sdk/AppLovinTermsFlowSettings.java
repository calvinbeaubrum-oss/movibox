package com.applovin.sdk;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AppLovinTermsFlowSettings {
    @Nullable
    Uri getPrivacyPolicyUri();

    @Nullable
    Uri getTermsOfServiceUri();

    boolean isEnabled();

    void setEnabled(boolean z11);

    void setPrivacyPolicyUri(Uri uri);

    void setTermsOfServiceUri(Uri uri);
}
