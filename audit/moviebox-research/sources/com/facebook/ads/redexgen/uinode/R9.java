package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public interface R9 {
    void A8Q();

    boolean A8b();

    boolean A8c();

    boolean A9B();

    void ADu(boolean z11, int i11);

    void AGN(int i11);

    void AGS(QM qm2, int i11);

    void AGZ(int i11);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    QM getStartReason();

    RB getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i11);

    void setBackgroundPlaybackEnabled(boolean z11);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z11);

    void setRequestedVolume(float f11);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(RC rc2);

    void setup(Uri uri);
}
