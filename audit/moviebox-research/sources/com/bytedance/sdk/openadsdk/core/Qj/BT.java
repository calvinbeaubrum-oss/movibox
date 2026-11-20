package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.kX;
import t8.a;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT extends com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI implements View.OnClickListener {
    private boolean dE;

    public BT(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, com.bytedance.sdk.openadsdk.We.qr qrVar) {
        super(context, sfl, false, str, false, false, qrVar);
        this.dE = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    private void Xc() {
        kX.sc((View) this.f28140qr, 0);
        kX.sc((View) this.Qj, 0);
        kX.sc((View) this.WH, 8);
    }

    private void wjp() {
        qr();
        RelativeLayout relativeLayout = this.f28140qr;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.f28141sc.GI().r(), this.f28141sc.GI().L(), this.f28141sc.GI().z(), this.Qj, this.f28141sc);
            }
        }
        Xc();
    }

    public void ExN() {
        qr();
        kX.sc((View) this.f28140qr, 0);
    }

    public void We() {
        ImageView imageView = this.WH;
        if (imageView != null) {
            kX.sc((View) imageView, 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.Ol;
        if (imageView != null && imageView.getVisibility() == 0) {
            kX.ExN(this.f28140qr);
        }
        zY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI, android.view.View
    public void onWindowFocusChanged(boolean z11) {
        ImageView imageView = this.Ol;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z11);
        } else {
            wjp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI, android.view.View
    public void onWindowVisibilityChanged(int i11) {
        ImageView imageView = this.Ol;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i11);
        } else {
            wjp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI
    public void pFF() {
        if (!this.ExN || !JPJ.pFF(this.Tf)) {
            this.We = false;
        }
        super.pFF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI
    public void sc(boolean z11) {
    }

    public void setCanInterruptVideoPlay(boolean z11) {
        this.dE = z11;
    }

    public void setShouldCheckNetChange(boolean z11) {
        c cVar = this.pFF;
        if (cVar != null) {
            cVar.ExN(z11);
        }
    }

    public void setShowAdInteractionView(boolean z11) {
        a aVarQl;
        c cVar = this.pFF;
        if (cVar == null || (aVarQl = cVar.Ql()) == null) {
            return;
        }
        aVarQl.sc(z11);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI
    public void zY() {
        if (this.dE) {
            super.zY();
        }
    }
}
