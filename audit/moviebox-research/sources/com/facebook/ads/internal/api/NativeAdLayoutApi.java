package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public interface NativeAdLayoutApi extends AdComponentViewApiProvider {
    void initialize(NativeAdLayout nativeAdLayout);

    void setMaxWidth(int i11);

    void setMinWidth(int i11);
}
