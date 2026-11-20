package com.facebook.ads.redexgen.uinode;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PW implements View.OnTouchListener {
    public final /* synthetic */ C1653Sx A00;

    public PW(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.A00.A00 = motionEvent.getY();
                break;
            case 1:
                if (this.A00.A00 < motionEvent.getY()) {
                    this.A00.A0k(false);
                }
                break;
        }
        return true;
    }
}
