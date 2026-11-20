package com.vungle.warren;

import com.vungle.warren.error.VungleException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface l {
    void onAutoCacheAdAvailable(String str);

    void onError(VungleException vungleException);

    void onSuccess();
}
