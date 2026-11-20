package com.applovin.sdk;

import androidx.annotation.Nullable;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AppLovinSdkInitializationConfiguration {

    /* JADX INFO: compiled from: source.java */
    public interface Builder {
        AppLovinSdkInitializationConfiguration build();

        List<String> getAdUnitIds();

        @Nullable
        String getMediationProvider();

        @Nullable
        String getPluginVersion();

        String getSdkKey();

        @Nullable
        MaxSegmentCollection getSegmentCollection();

        List<String> getTestDeviceAdvertisingIds();

        boolean isExceptionHandlerEnabled();

        Builder setAdUnitIds(List<String> list);

        Builder setExceptionHandlerEnabled(boolean z11);

        Builder setMediationProvider(@Nullable String str);

        Builder setPluginVersion(@Nullable String str);

        Builder setSegmentCollection(MaxSegmentCollection maxSegmentCollection);

        Builder setTestDeviceAdvertisingIds(List<String> list);
    }

    List<String> getAdUnitIds();

    @Nullable
    String getMediationProvider();

    @Nullable
    String getPluginVersion();

    @Nullable
    String getSdkKey();

    @Nullable
    MaxSegmentCollection getSegmentCollection();

    List<String> getTestDeviceAdvertisingIds();

    boolean isExceptionHandlerEnabled();
}
