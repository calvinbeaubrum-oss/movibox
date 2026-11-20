package com.bytedance.adsdk.ugeno.TRI.sc;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.adsdk.ugeno.TRI.We;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends LinearLayout {
    private int ExN;
    private int Ol;
    private boolean Qj;
    private int TRI;
    private Context We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26368qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private List<View> f26369sc;
    private int zY;

    public sc(Context context) {
        super(context);
        this.pFF = FlowLayout.SPACING_AUTO;
        this.zY = -16776961;
        this.ExN = 5;
        this.TRI = 20;
        this.f26368qr = 20;
        this.We = context;
        this.f26369sc = new ArrayList();
        sc();
    }

    private GradientDrawable pFF(int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i11);
        return gradientDrawable;
    }

    public int getSize() {
        return this.f26369sc.size();
    }

    public void pFF() {
        View view = new View(getContext());
        view.setClickable(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TRI, this.f26368qr);
        int i11 = this.ExN;
        layoutParams.leftMargin = i11;
        layoutParams.rightMargin = i11;
        addView(view, layoutParams);
        view.setBackground(pFF(this.zY));
        this.f26369sc.add(view);
    }

    public void sc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        setGravity(17);
        setOrientation(0);
        layoutParams.bottomMargin = (int) Qj.sc(this.We, 10.0f);
        setLayoutParams(layoutParams);
    }

    public void sc(int i11) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TRI, this.f26368qr);
        int i12 = this.ExN;
        layoutParams.leftMargin = i12;
        layoutParams.rightMargin = i12;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.TRI, this.f26368qr);
        int i13 = this.ExN;
        layoutParams2.leftMargin = i13;
        layoutParams2.rightMargin = i13;
        int iSc = We.sc(this.Qj, this.Ol, this.f26369sc.size());
        int iSc2 = We.sc(this.Qj, i11, this.f26369sc.size());
        if (this.f26369sc.size() == 0) {
            iSc2 = 0;
        }
        if (!this.f26369sc.isEmpty() && We.sc(iSc, this.f26369sc) && We.sc(iSc2, this.f26369sc)) {
            this.f26369sc.get(iSc).setBackground(pFF(this.zY));
            this.f26369sc.get(iSc).setLayoutParams(layoutParams2);
            this.f26369sc.get(iSc2).setBackground(pFF(this.pFF));
            this.f26369sc.get(iSc2).setLayoutParams(layoutParams);
            this.Ol = i11;
        }
    }

    public void sc(int i11, int i12) {
        Iterator<View> it = this.f26369sc.iterator();
        while (it.hasNext()) {
            it.next().setBackground(pFF(this.zY));
        }
        if (i11 < 0 || i11 >= this.f26369sc.size()) {
            i11 = 0;
        }
        if (this.f26369sc.size() > 0) {
            this.f26369sc.get(i11).setBackground(pFF(this.pFF));
            this.Ol = i12;
        }
    }

    public void setLoop(boolean z11) {
        this.Qj = z11;
    }

    public void setSelectedColor(int i11) {
        this.pFF = i11;
    }

    public void setUnSelectedColor(int i11) {
        this.zY = i11;
    }
}
