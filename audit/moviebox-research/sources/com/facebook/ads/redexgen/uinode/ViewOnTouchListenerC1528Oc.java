package com.facebook.ads.redexgen.uinode;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1528Oc implements View.OnTouchListener {
    public final /* synthetic */ TT A00;

    public ViewOnTouchListenerC1528Oc(TT tt2) {
        this.A00 = tt2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.A00.A00 = motionEvent.getY();
                break;
            case 1:
                if (this.A00.A00 < motionEvent.getY()) {
                    this.A00.A0g(false);
                }
                break;
        }
        return true;
    }
}
