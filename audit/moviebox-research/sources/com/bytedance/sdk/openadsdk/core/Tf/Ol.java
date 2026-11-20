package com.bytedance.sdk.openadsdk.core.Tf;

import android.view.View;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends qr {

    @NonNull
    private final MediaEvents ExN;
    private boolean TRI;

    public Ol(@NonNull AdSession adSession, @NonNull AdEvents adEvents, @NonNull View view, @NonNull MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.ExN = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.qr
    public void pFF(int i11) {
        if (sc()) {
            switch (i11) {
                case 0:
                    this.ExN.pause();
                    break;
                case 1:
                    this.ExN.resume();
                    break;
                case 2:
                case 14:
                    this.ExN.skipped();
                    break;
                case 4:
                    this.ExN.bufferStart();
                    break;
                case 5:
                    this.ExN.bufferFinish();
                    break;
                case 6:
                    this.ExN.firstQuartile();
                    break;
                case 7:
                    this.ExN.midpoint();
                    break;
                case 8:
                    this.ExN.thirdQuartile();
                    break;
                case 9:
                    this.ExN.complete();
                    break;
                case 10:
                    this.ExN.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.ExN.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.ExN.volumeChange(this.TRI ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.ExN.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.qr
    public void sc(float f11, boolean z11) {
        if (sc()) {
            this.ExN.start(f11, z11 ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.qr
    public void sc(boolean z11) {
        this.TRI = z11;
        pFF(12);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.qr
    public void sc(boolean z11, float f11) {
        if (z11) {
            this.We = VastProperties.createVastPropertiesForSkippableMedia(f11, true, Position.STANDALONE);
        } else {
            this.We = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        sc(2);
    }
}
