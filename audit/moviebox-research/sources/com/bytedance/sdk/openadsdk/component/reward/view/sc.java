package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.widget.Xc;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.Qj.sc {
    private int BT;
    private boolean Ql;
    private int SR;
    private FrameLayout Sfl;
    private View Xc;
    private com.bytedance.sdk.openadsdk.core.pFF.ExN YIK;
    private int dE;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f27968sc;
    private View wjp;

    public sc(@NonNull Context context, String str) {
        super(context, str);
        this.dE = 1;
        this.pFF = context;
    }

    private void ExN() {
        com.bytedance.sdk.openadsdk.Ql.zY zYVar = new com.bytedance.sdk.openadsdk.Ql.zY(this.pFF);
        this.Xc = zYVar;
        pFF(zYVar);
        We();
        TRI();
    }

    private void Ol() {
        com.bytedance.sdk.openadsdk.Ql.TRI tri = new com.bytedance.sdk.openadsdk.Ql.TRI(this.pFF);
        this.Xc = tri;
        pFF(tri);
        We();
        TRI();
    }

    private void Qj() {
        com.bytedance.sdk.openadsdk.Ql.We we2 = new com.bytedance.sdk.openadsdk.Ql.We(this.pFF);
        this.Xc = we2;
        pFF(we2);
        We();
    }

    private void Ql() {
        com.bytedance.sdk.openadsdk.Ql.Ol ol2 = new com.bytedance.sdk.openadsdk.Ql.Ol(this.pFF);
        this.Xc = ol2;
        pFF(ol2);
        We();
        TRI();
    }

    private void TRI() {
        TextView textView = (TextView) this.Xc.findViewById(SR.jcs);
        if (textView != null) {
            textView.setText(getDescription());
            zY(textView);
        }
    }

    private void Tf() {
        com.bytedance.sdk.openadsdk.Ql.qr qrVar = new com.bytedance.sdk.openadsdk.Ql.qr(this.pFF);
        this.Xc = qrVar;
        pFF(qrVar);
        We();
    }

    private void UFX() {
        View exN = new com.bytedance.sdk.openadsdk.Ql.ExN(this.pFF);
        this.Xc = exN;
        pFF(exN);
        this.Sfl = (FrameLayout) this.Xc.findViewById(SR.ymG);
        ImageView imageView = (ImageView) this.Xc.findViewById(SR.GOt);
        TextView textView = (TextView) this.Xc.findViewById(SR.Pu);
        View viewFindViewById = this.Xc.findViewById(520093739);
        sc(this.Sfl, imageView);
        textView.setText(getDescription());
        zY(this.Sfl);
        zY(imageView);
        zY(textView);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.sc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                } catch (Throwable th2) {
                    Tf.sc("FullInteractionStyleView", th2.getMessage());
                }
            }
        });
    }

    private void WH() {
        com.bytedance.sdk.openadsdk.Ql.Qj qj2 = new com.bytedance.sdk.openadsdk.Ql.Qj(this.pFF);
        this.Xc = qj2;
        pFF(qj2);
        We();
    }

    private void We() {
        this.Sfl = (FrameLayout) this.Xc.findViewById(SR.ymG);
        ImageView imageView = (ImageView) this.Xc.findViewById(SR.HC);
        Xc xc2 = (Xc) this.Xc.findViewById(SR.vYl);
        TextView textView = (TextView) this.Xc.findViewById(SR.f28744ds);
        TextView textView2 = (TextView) this.Xc.findViewById(SR.JP);
        View viewFindViewById = this.Xc.findViewById(520093739);
        if (!TextUtils.isEmpty(this.zY.NQ())) {
            textView2.setText(this.zY.NQ());
        }
        sc(this.Sfl, imageView);
        if (this.zY.qfG() != null && !TextUtils.isEmpty(this.zY.qfG().sc())) {
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc(this.zY.qfG().sc(), this.zY.qfG().pFF(), this.zY.qfG().zY(), xc2, this.zY);
        }
        textView.setText(getTitle());
        zY(this.Sfl);
        zY(imageView);
        zY(xc2);
        zY(textView);
        zY(textView2);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.sc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.sc(((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).pFF, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).zY, ((com.bytedance.sdk.openadsdk.core.Qj.sc) sc.this).TRI);
                } catch (Throwable th2) {
                    Tf.sc("FullInteractionStyleView", th2.getMessage());
                }
            }
        });
    }

    private float getHeightDp() {
        return kX.We(this.pFF, kX.Ol(this.pFF));
    }

    private float getWidthDp() {
        return kX.We(this.pFF, kX.WH(this.pFF));
    }

    private void pFF() {
        this.f28092qr = kX.zY(this.pFF, this.SR);
        this.Qj = kX.zY(this.pFF, this.BT);
        int i11 = (int) (this.f27968sc * 1000.0f);
        if (this.dE == 1) {
            if (i11 == 666) {
                ExN();
                return;
            }
            if (i11 == 1000) {
                zY();
                return;
            }
            if (i11 == 1500) {
                UFX();
                return;
            } else if (i11 == 1777) {
                Ql();
                return;
            } else {
                sc(0.562f);
                Tf();
                return;
            }
        }
        if (i11 == 562) {
            Ol();
            return;
        }
        if (i11 == 666) {
            qr();
            return;
        }
        if (i11 == 1000) {
            zY();
        } else if (i11 == 1500) {
            Qj();
        } else {
            sc(1.777f);
            WH();
        }
    }

    private void pFF(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void qr() {
        com.bytedance.sdk.openadsdk.Ql.pFF pff = new com.bytedance.sdk.openadsdk.Ql.pFF(this.pFF);
        this.Xc = pff;
        pFF(pff);
        We();
        TRI();
    }

    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI sc(Sfl sfl, Context context) {
        if (sfl != null && sfl.QLv() == 4) {
            return new com.bytedance.sdk.openadsdk.wjp.sc.sc.We(context, sfl, this.TRI);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0075  */
    private void sc(float f11) {
        float fMin;
        float fMax;
        int iMax;
        int i11;
        int iMax2;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.dE == 2) {
            fMin = Math.max(heightDp, widthDp);
            fMax = Math.min(heightDp, widthDp);
        } else {
            fMin = Math.min(heightDp, widthDp);
            fMax = Math.max(heightDp, widthDp);
        }
        if (this.dE != 2 && kX.zY((Activity) this.pFF)) {
            fMax -= kX.We(this.pFF, kX.sc());
        }
        int i12 = 20;
        if (this.dE != 2) {
            if (f11 == 0.0f || f11 == 100.0f) {
                i12 = 0;
                iMax2 = 0;
                iMax = 0;
                i11 = 0;
            } else {
                iMax2 = (int) Math.max((fMax - (((fMin - 20.0f) - 20.0f) / f11)) / 2.0f, 0.0f);
                i12 = iMax2;
                iMax = 20;
                i11 = 20;
            }
        } else if (f11 == 0.0f || f11 == 100.0f) {
            i12 = 0;
            iMax2 = 0;
            iMax = 0;
            i11 = 0;
        } else {
            iMax = (int) Math.max((fMin - (((fMax - 20.0f) - 20.0f) * f11)) / 2.0f, 0.0f);
            i11 = iMax;
            iMax2 = 20;
        }
        ((Activity) this.pFF).getWindow().getDecorView().setPadding(kX.zY(this.pFF, iMax), kX.zY(this.pFF, i12), kX.zY(this.pFF, i11), kX.zY(this.pFF, iMax2));
    }

    private void sc(FrameLayout frameLayout, ImageView imageView) {
        Sfl sfl = this.zY;
        if (sfl == null) {
            return;
        }
        boolean zExN = Sfl.ExN(sfl);
        if (this.zY.GI() != null && zExN) {
            kX.sc((View) imageView, 8);
            kX.sc((View) frameLayout, 0);
        } else {
            sc(imageView);
            kX.sc((View) imageView, 0);
            kX.sc((View) frameLayout, 8);
        }
    }

    private void sc(ImageView imageView) {
        List<BT> listHt;
        BT bt2;
        Sfl sfl = this.zY;
        if (sfl == null || (listHt = sfl.ht()) == null || listHt.size() <= 0 || (bt2 = listHt.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ol.We.sc(bt2).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(this.zY, bt2.sc(), imageView));
    }

    private void zY() {
        com.bytedance.sdk.openadsdk.Ql.sc scVar = new com.bytedance.sdk.openadsdk.Ql.sc(this.pFF);
        this.Xc = scVar;
        pFF(scVar);
        We();
        TRI();
    }

    private void zY(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pFF.sc scVar = this.YIK;
        if (scVar == null) {
            Context context = this.pFF;
            Sfl sfl = this.zY;
            String str = this.TRI;
            scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(context, sfl, str, cJ.sc(str));
            scVar.sc(sc(this.zY, this.pFF));
        }
        view.setOnTouchListener(scVar);
        view.setOnClickListener(scVar);
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    public FrameLayout getVideoContainer() {
        return this.Sfl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.Qj.sc
    public void sc(View view, int i11, com.bytedance.sdk.openadsdk.core.model.SR sr2) {
    }

    public void sc(Sfl sfl, float f11, int i11, int i12, int i13) {
        this.f27968sc = f11;
        this.dE = i11;
        this.zY = sfl;
        this.TRI = "fullscreen_interstitial_ad";
        this.SR = i12;
        this.BT = i13;
        sc(this.Ol);
        pFF();
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        this.YIK = exN;
    }

    public void setIsMute(boolean z11) {
        this.Ql = z11;
        View view = this.wjp;
        if (view != null && (view instanceof com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI)) {
            ((com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI) view).setIsQuiet(z11);
        }
    }
}
