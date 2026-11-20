package com.mbridge.msdk.playercommon;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(String str);

    void onPlayCompleted();

    void onPlayError(String str);

    void onPlayProgress(int i11, int i12);

    void onPlayProgressMS(int i11, int i12);

    void onPlaySetDataSourceError(String str);

    void onPlayStarted(int i11);
}
