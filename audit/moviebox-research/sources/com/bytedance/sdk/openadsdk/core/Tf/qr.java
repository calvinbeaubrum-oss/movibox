package com.bytedance.sdk.openadsdk.core.Tf;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    private final AdSession ExN;
    private final AdEvents TRI;
    protected VastProperties We;
    protected String zY;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f28229qr = false;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected boolean f28230sc = false;
    protected int pFF = 0;

    public qr(AdSession adSession, AdEvents adEvents, View view) {
        this.ExN = adSession;
        this.TRI = adEvents;
        this.zY = adSession.getAdSessionId();
        sc(view);
    }

    public void We() {
        sc(3);
    }

    public void pFF() {
        sc(1);
    }

    public void pFF(int i11) {
    }

    public void sc(float f11, boolean z11) {
    }

    public void sc(int i11) {
        int i12;
        if (this.ExN == null || this.TRI == null || !ExN.zY()) {
            return;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4 || (i12 = this.pFF) == 0 || i12 == 4) {
                        return;
                    }
                    this.ExN.finish();
                    this.f28230sc = false;
                } else {
                    if (this.f28229qr) {
                        return;
                    }
                    int i13 = this.pFF;
                    if (i13 != 1 && i13 != 2) {
                        return;
                    }
                    this.TRI.impressionOccurred();
                    this.f28229qr = true;
                }
            } else {
                if (this.pFF != 0) {
                    return;
                }
                this.ExN.start();
                if (this.We == null) {
                    this.We = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                this.TRI.loaded(this.We);
                this.f28230sc = true;
                this.We = null;
            }
        } else {
            if (this.pFF != 0) {
                return;
            }
            this.ExN.start();
            this.TRI.loaded();
            this.f28230sc = true;
        }
        this.pFF = i11;
    }

    public void sc(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.ExN) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void sc(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.ExN;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    public void sc(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            sc((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }

    public void sc(boolean z11) {
    }

    public void sc(boolean z11, float f11) {
    }

    public boolean sc() {
        return this.f28230sc;
    }

    public void zY() {
        sc(4);
    }
}
