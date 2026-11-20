package com.cloud.hisavana.sdk;

import com.google.android.exoplayer2.PlaybackException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface q0 {
    void a();

    void b(long j11, long j12, int i11);

    void c(boolean z11);

    void d();

    void e(boolean z11);

    void onComplete();

    void onIsPlayingChanged(boolean z11);

    void onPlayerError(PlaybackException playbackException);

    void onVideoSizeChanged(int i11, int i12);

    void onVolumeChanged(float f11);
}
