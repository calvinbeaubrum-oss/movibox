package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE extends sc {
    private Sfl Ql;
    private FrameLayout SR;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private FrameLayout f28086sc;

    public dE(@NonNull Context context) {
        super(context);
        this.pFF = context;
    }

    private void pFF() {
        this.f28092qr = kX.zY(this.pFF, this.Ql.getExpectExpressWidth());
        this.Qj = kX.zY(this.pFF, this.Ql.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28092qr, this.Qj);
        }
        layoutParams.width = this.f28092qr;
        layoutParams.height = this.Qj;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.zY.Gb();
        zY();
    }

    private void zY() {
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(this.pFF);
        this.f28086sc = zYVar;
        addView(zYVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(this.pFF);
        this.SR = zYVar2;
        this.f28086sc.addView(zYVar2, new FrameLayout.LayoutParams(-1, -1));
        this.SR.removeAllViews();
    }

    public View getBackupContainerBackgroundView() {
        return this.f28086sc;
    }

    public FrameLayout getVideoContainer() {
        return this.SR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc(View view, int i11, com.bytedance.sdk.openadsdk.core.model.SR sr2) {
        Sfl sfl = this.Ql;
        if (sfl != null) {
            sfl.sc(view, i11, sr2);
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, Sfl sfl2, ViewGroup viewGroup) {
        if (sfl == null) {
            return;
        }
        setBackgroundColor(-1);
        this.zY = sfl;
        this.Ql = sfl2;
        if (sfl.qY() == 7) {
            this.TRI = "rewarded_video";
        } else {
            this.TRI = "fullscreen_interstitial_ad";
        }
        pFF();
        if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(sfl)) {
            this.Ql.addView(this, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.Ql.addView(this, new ViewGroup.LayoutParams(-2, -2));
        }
        int i11 = com.bytedance.sdk.openadsdk.utils.SR.NT;
        View viewFindViewById = viewGroup.findViewById(i11);
        if (viewFindViewById != null) {
            Object tag = viewFindViewById.getTag(i11);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(str, viewFindViewById);
            }
        }
    }
}
