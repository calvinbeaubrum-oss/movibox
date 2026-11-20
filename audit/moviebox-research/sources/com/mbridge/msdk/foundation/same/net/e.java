package com.mbridge.msdk.foundation.same.net;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface e<T> {
    void onCancel();

    void onError(com.mbridge.msdk.foundation.same.net.b.a aVar);

    void onFinish();

    void onNetworking();

    void onPreExecute();

    void onProgressChange(long j11, long j12);

    void onRetry();

    void onSuccess(k<T> kVar);
}
