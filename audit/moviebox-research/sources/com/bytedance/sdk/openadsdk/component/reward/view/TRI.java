package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.component.reward.sc.Sfl;
import com.bytedance.sdk.openadsdk.component.reward.sc.Xc;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    private boolean ExN;
    private Sfl We;

    @Nullable
    private RFEndCardBackUpLayout pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc f27957sc;
    private boolean zY;

    public TRI(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.f27957sc = scVar;
    }

    public boolean ExN() {
        Sfl sfl = this.We;
        if (sfl != null) {
            return sfl.zY();
        }
        return false;
    }

    public boolean TRI() {
        return this.ExN;
    }

    public void We() {
        Sfl sfl = this.We;
        if (sfl != null) {
            sfl.pFF();
        }
    }

    public void pFF() {
        this.ExN = true;
        kX.sc((View) this.pFF, 0);
    }

    public void sc() {
        if (this.zY) {
            return;
        }
        this.zY = true;
        RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.f27957sc.JoC.findViewById(SR.f28748gx);
        this.pFF = rFEndCardBackUpLayout;
        if (rFEndCardBackUpLayout != null) {
            rFEndCardBackUpLayout.init(this.f27957sc);
        }
        if (this.f27957sc.pFF.ymG()) {
            this.We = new Sfl(this.f27957sc);
        }
    }

    public void sc(int i11) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.pFF;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        rFEndCardBackUpLayout.setShownAdCount(i11);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.pFF;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        kX.sc(rFEndCardBackUpLayout, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.TRI.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        Sfl sfl = this.We;
        if (sfl != null) {
            sfl.sc(exN);
        }
    }

    public boolean sc(Xc xc2) {
        this.ExN = true;
        Sfl sfl = this.We;
        if (sfl == null || !sfl.sc(xc2)) {
            return false;
        }
        kX.sc((View) this.pFF, 0);
        return true;
    }

    public void zY() {
        Sfl sfl = this.We;
        if (sfl != null) {
            sfl.sc();
        }
    }
}
