package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class MB extends LinearLayout {
    public static int A00 = (int) (LD.A02 * 56.0f);

    public MB(Context context) {
        super(context);
    }

    public abstract void A04();

    public abstract void A05();

    public abstract void A06(C1P c1p, boolean z11);

    public abstract boolean A07();

    public abstract View getDetailsContainer();

    public abstract int getToolbarActionMode();

    public abstract int getToolbarHeight();

    public abstract MA getToolbarListener();

    public abstract void setAdReportingVisible(boolean z11);

    public abstract void setCTAClickListener(View.OnClickListener onClickListener);

    public abstract void setCTAClickListener(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl);

    public abstract void setFullscreen(boolean z11);

    public abstract void setPageDetails(C09701a c09701a, String str, int i11, C09761g c09761g);

    public abstract void setPageDetailsVisible(boolean z11);

    public abstract void setProgress(float f11);

    public abstract void setProgressClickListener(View.OnClickListener onClickListener);

    public abstract void setProgressImage(EnumC1470Lw enumC1470Lw);

    public abstract void setProgressImmediate(float f11);

    public abstract void setProgressSpinnerInvisible(boolean z11);

    public abstract void setToolbarActionMessage(String str);

    public abstract void setToolbarActionMode(int i11);

    public abstract void setToolbarListener(MA ma2);
}
