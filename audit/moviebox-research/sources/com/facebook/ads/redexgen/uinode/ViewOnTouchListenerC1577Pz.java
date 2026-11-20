package com.facebook.ads.redexgen.uinode;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1577Pz implements View.OnTouchListener {
    public final /* synthetic */ Q0 A00;

    public ViewOnTouchListenerC1577Pz(Q0 q11) {
        this.A00 = q11;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.A00.A01 = System.currentTimeMillis();
        Q0.A00(this.A00);
        this.A00.A06.A9u(this.A00.A03.A12(), new C1508Ni().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
        return false;
    }
}
