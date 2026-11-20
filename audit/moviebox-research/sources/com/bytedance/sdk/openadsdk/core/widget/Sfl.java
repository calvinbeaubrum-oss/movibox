package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Sfl {
    private pFF ExN;
    private ViewGroup Qj;
    private boolean TRI = false;
    private com.bytedance.sdk.openadsdk.core.Ql.pFF.sc We;
    private TextView pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private x8.a f28537qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private View f28538sc;
    private Context zY;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        void UFX();

        boolean WH();
    }

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    private void We() {
        View view = this.f28538sc;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void pFF() {
        this.f28537qr = null;
    }

    private ViewGroup.LayoutParams sc(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    private void sc(Context context, View view, boolean z11) {
        ViewGroup.LayoutParams layoutParamsSc;
        if (context == null || view == null || this.f28538sc != null || (layoutParamsSc = sc(this.Qj)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ql.BT bt2 = new com.bytedance.sdk.openadsdk.Ql.BT(context);
        this.f28538sc = bt2;
        bt2.setLayoutParams(layoutParamsSc);
        this.Qj.addView(this.f28538sc);
        this.pFF = (TextView) this.f28538sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Eyy);
        View viewFindViewById = this.f28538sc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.VU);
        if (z11) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.Sfl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Sfl.this.zY();
                    if (Sfl.this.We != null) {
                        Sfl.this.We.sc(sc.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    private void sc(x8.a aVar, boolean z11) {
        View view;
        String str;
        View view2;
        if (aVar == null || (view = this.f28538sc) == null || this.zY == null || view.getVisibility() == 0) {
            return;
        }
        pFF pff = this.ExN;
        if (pff != null) {
            pff.UFX();
        }
        double dCeil = Math.ceil((aVar.c() * 1.0d) / 1048576.0d);
        if (z11) {
            str = String.format(com.bytedance.sdk.component.utils.Sfl.sc(this.zY, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(dCeil).floatValue()));
        } else {
            str = com.bytedance.sdk.component.utils.Sfl.sc(this.zY, "tt_video_without_wifi_tips") + com.bytedance.sdk.component.utils.Sfl.sc(this.zY, "tt_video_bytesize");
        }
        kX.sc(this.f28538sc, 0);
        kX.sc(this.pFF, str);
        if (!kX.We(this.f28538sc) || (view2 = this.f28538sc) == null) {
            return;
        }
        view2.bringToFront();
    }

    private boolean sc(int i11) {
        pFF pff;
        if (sc() || this.TRI) {
            return true;
        }
        if (this.We != null && (pff = this.ExN) != null) {
            if (pff.WH()) {
                this.We.ExN(null, null);
            }
            this.We.sc(sc.PAUSE_VIDEO, (String) null);
        }
        sc(this.f28537qr, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        if (this.zY == null) {
            return;
        }
        We();
    }

    public void sc(Context context, ViewGroup viewGroup) {
        if (context == null || !(viewGroup instanceof ViewGroup)) {
            return;
        }
        this.Qj = viewGroup;
        this.zY = com.bytedance.sdk.openadsdk.core.Xc.sc().getApplicationContext();
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.pFF.sc scVar, pFF pff) {
        this.ExN = pff;
        this.We = scVar;
    }

    public void sc(boolean z11) {
        if (z11) {
            pFF();
        }
        We();
    }

    public boolean sc() {
        View view = this.f28538sc;
        return view != null && view.getVisibility() == 0;
    }

    public boolean sc(int i11, x8.a aVar, boolean z11) {
        Context context = this.zY;
        if (context == null || aVar == null) {
            return true;
        }
        sc(context, this.Qj, z11);
        this.f28537qr = aVar;
        if (i11 == 1 || i11 == 2) {
            return sc(i11);
        }
        return true;
    }
}
