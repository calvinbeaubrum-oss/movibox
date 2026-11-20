package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface IDownloadListener {
    void onEnd(int i11, int i12, String str);

    void onProgressUpdate(int i11);

    void onStart();

    void onStatus(int i11);
}
