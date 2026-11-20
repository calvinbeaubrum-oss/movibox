package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.WP;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sc extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    protected TTDislikeDialogAbstract ExN;
    protected int Ol;
    protected int Qj;
    protected String TRI;
    protected String Tf;
    protected boolean UFX;
    protected boolean WH;
    protected com.bytedance.sdk.openadsdk.zY.zY We;
    protected Context pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected int f28092qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.We.qr f28093sc;
    protected com.bytedance.sdk.openadsdk.core.model.Sfl zY;

    public sc(@NonNull Context context) {
        super(context);
        this.TRI = "embeded_ad";
        this.WH = true;
        this.UFX = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    public sc(@NonNull Context context, String str) {
        super(context);
        this.TRI = "embeded_ad";
        this.WH = true;
        this.UFX = true;
        this.Tf = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    public String getDescription() {
        if (TextUtils.isEmpty(this.zY.YdT())) {
            return !TextUtils.isEmpty(this.zY.bSP()) ? this.zY.bSP() : "";
        }
        return this.zY.YdT();
    }

    public String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl == null) {
            return "";
        }
        if (sfl.NP() == null || TextUtils.isEmpty(this.zY.NP().pFF())) {
            return !TextUtils.isEmpty(this.zY.MxZ()) ? this.zY.MxZ() : "";
        }
        return this.zY.NP().pFF();
    }

    public float getRealHeight() {
        return kX.We(this.pFF, this.Qj);
    }

    public float getRealWidth() {
        return kX.We(this.pFF, this.f28092qr);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        if (this.zY.NP() != null && !TextUtils.isEmpty(this.zY.NP().pFF())) {
            return this.zY.NP().pFF();
        }
        if (TextUtils.isEmpty(this.zY.MxZ())) {
            return !TextUtils.isEmpty(this.zY.YdT()) ? this.zY.YdT() : "";
        }
        return this.zY.MxZ();
    }

    public com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI getVideoView() {
        com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI tri;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl != null && this.pFF != null) {
            if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl)) {
                try {
                    tri = new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI(this.pFF, this.zY, this.TRI, true, false, this.f28093sc);
                    tri.setVideoCacheUrl(this.Tf);
                    tri.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF() { // from class: com.bytedance.sdk.openadsdk.core.Qj.sc.2
                        @Override // com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI.pFF
                        public void sc(boolean z11, long j11, long j12, long j13, boolean z12) {
                        }
                    });
                    tri.setIsAutoPlay(this.WH);
                    tri.setIsQuiet(this.UFX);
                } catch (Throwable unused) {
                    tri = null;
                }
            } else {
                tri = null;
            }
            if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(this.zY) && tri != null && tri.sc(0L, true, false)) {
                return tri;
            }
        }
        return null;
    }

    public void sc() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ExN;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.zY.zY zYVar = this.We;
        if (zYVar != null) {
            zYVar.sc();
        } else {
            TTDelegateActivity.sc(this.zY, (String) null);
        }
    }

    public void sc(int i11) {
        this.UFX = com.bytedance.sdk.openadsdk.core.Xc.We().zY(String.valueOf(this.Ol));
        int iPFF = com.bytedance.sdk.openadsdk.core.Xc.We().pFF(i11);
        if (3 == iPFF) {
            this.WH = false;
            return;
        }
        int iZY = com.bytedance.sdk.component.utils.BT.zY(com.bytedance.sdk.openadsdk.core.Xc.sc());
        if (1 != iPFF || !cJ.We(iZY)) {
            if (2 == iPFF) {
                if (cJ.ExN(iZY) || cJ.We(iZY) || cJ.TRI(iZY)) {
                    this.WH = true;
                    return;
                }
                return;
            }
            if (5 != iPFF) {
                return;
            }
            if (!cJ.We(iZY) && !cJ.TRI(iZY)) {
                return;
            }
        }
        this.WH = true;
    }

    public void sc(View view) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
        if (sfl == null || sfl.GI() == null || view == null) {
            return;
        }
        sc(view, this.zY.WP() == 1 && this.WH);
    }

    public abstract void sc(View view, int i11, com.bytedance.sdk.openadsdk.core.model.SR sr2);

    public void sc(View view, boolean z11) {
        com.bytedance.sdk.openadsdk.core.pFF.pFF pff;
        if (view == null) {
            return;
        }
        if (z11) {
            Context context = this.pFF;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.zY;
            String str = this.TRI;
            pff = new com.bytedance.sdk.openadsdk.core.pFF.sc(context, sfl, str, cJ.sc(str));
        } else {
            Context context2 = this.pFF;
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = this.zY;
            String str2 = this.TRI;
            pff = new com.bytedance.sdk.openadsdk.core.pFF.pFF(context2, sfl2, str2, cJ.sc(str2));
        }
        view.setOnTouchListener(pff);
        view.setOnClickListener(pff);
        pff.sc(new pFF() { // from class: com.bytedance.sdk.openadsdk.core.Qj.sc.1
            @Override // com.bytedance.sdk.openadsdk.core.Qj.pFF
            public void sc(View view2, int i11, com.bytedance.sdk.openadsdk.core.model.SR sr2) {
                sc.this.sc(view2, i11, sr2);
            }
        });
    }

    public void setDislikeInner(WP wp2) {
        if (wp2 instanceof com.bytedance.sdk.openadsdk.zY.zY) {
            this.We = (com.bytedance.sdk.openadsdk.zY.zY) wp2;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        if (tTDislikeDialogAbstract != null && (sfl = this.zY) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(sfl.mD(), this.zY.IEI());
        }
        this.ExN = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }
}
