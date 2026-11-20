package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import org.mvel2.ast.ASTNode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ViewOnSystemUiVisibilityChangeListenerC1449Lb implements View.OnSystemUiVisibilityChangeListener {
    public int A00;
    public Window A01;
    public final View A03;
    public EnumC1448La A02 = EnumC1448La.A03;
    public final Runnable A04 = new C1685Ud(this);

    public ViewOnSystemUiVisibilityChangeListenerC1449Lb(View view) {
        this.A03 = view;
        view.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i11, boolean z11) {
        Window window = this.A01;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z11) {
            attributes.flags |= i11;
        } else {
            attributes.flags &= i11 ^ (-1);
        }
        this.A01.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(boolean z11) {
        if (EnumC1448La.A03.equals(this.A02)) {
            return;
        }
        int i11 = z11 ? 3840 : 3840 | 7;
        Handler handler = this.A03.getHandler();
        if (handler != null && z11) {
            handler.removeCallbacks(this.A04);
            handler.postDelayed(this.A04, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
        this.A03.setSystemUiVisibility(i11);
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(EnumC1448La enumC1448La) {
        this.A02 = enumC1448La;
        switch (LZ.A00[this.A02.ordinal()]) {
            case 1:
                A00(67108864, true);
                A00(ASTNode.NOJIT, true);
                A02(false);
                break;
            default:
                A00(67108864, false);
                A00(ASTNode.NOJIT, false);
                this.A03.setSystemUiVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i11) {
        int i12 = this.A00 ^ i11;
        this.A00 = i11;
        if ((i12 & 2) == 0 || (i11 & 2) != 0) {
            return;
        }
        A02(true);
    }
}
