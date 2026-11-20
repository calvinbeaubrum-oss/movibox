package com.mbridge.msdk.out;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface AdapterListener {
    void onAdClicked(Campaign campaign);

    void onAdLoaded(List<Campaign> list);

    void onError(String str);

    void onFrameAdLoaded(List<Frame> list);
}
