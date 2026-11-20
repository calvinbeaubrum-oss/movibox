package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.transsion.gslb.Worker;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1475Mb extends LinearLayout {
    public static String[] A07 = {"RdKbZKE5ShqjtspsYuId0BpVT", "jFs6Ox2yxsj", "", "O0DGVMIkWcl", "ZjYxtVw01iwSMNXN0b17Jtyc9gHU9Z2d", "b1LSaO6GQJOSELIr8C99", "", "wukZGaaSm"};
    public static final int A08 = (int) (LD.A02 * 15.0f);
    public static final int A09 = (int) (LD.A02 * 10.0f);
    public static final int A0A = (int) (LD.A02 * 44.0f);
    public int A00;
    public boolean A01;
    public final ImageView A02;
    public final LinearLayout A03;
    public final TextView A04;
    public final C1795Yn A05;
    public final C1519Nt A06;

    public C1475Mb(C1795Yn c1795Yn, int i11) {
        super(c1795Yn);
        this.A01 = false;
        this.A05 = c1795Yn;
        ImageView imageView = new ImageView(c1795Yn);
        this.A02 = imageView;
        int i12 = A09;
        imageView.setPadding(i12, i12, i12, i12);
        C1519Nt c1519Nt = new C1519Nt(c1795Yn);
        this.A06 = c1519Nt;
        c1519Nt.setProgress(0.0f);
        c1519Nt.setPadding(i12, i12, i12, i12);
        this.A04 = new TextView(c1795Yn);
        setOrientation(0);
        this.A03 = new LinearLayout(c1795Yn);
        this.A00 = i11;
        A00();
    }

    private void A00() {
        setToolbarActionMode(this.A00);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setGravity(17);
        int i11 = A0A;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i11, i11);
        AbstractC1462Lo.A0X(this.A04, true, 16);
        this.A04.setTextColor(-1);
        this.A04.setVisibility(8);
        this.A03.addView(this.A02, layoutParams2);
        this.A03.addView(this.A06, layoutParams2);
        addView(this.A03, layoutParams);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        addView(this.A04, layoutParams3);
    }

    private void A01() {
        int i11;
        C1519Nt c1519Nt = this.A06;
        int i12 = this.A00;
        int i13 = 8;
        if (i12 == 2 || i12 == 6) {
            i11 = this.A01 ? 4 : 0;
        } else {
            i11 = 8;
        }
        c1519Nt.setVisibility(i11);
        ImageView imageView = this.A02;
        int i14 = this.A00;
        if (i14 == 5) {
            i13 = 4;
        } else if (i14 != 2 && i14 != 6) {
            i13 = 0;
        }
        imageView.setVisibility(i13);
    }

    public final void A02(C1P c1p, boolean z11, boolean z12) {
        int iA04 = c1p.A04(z11);
        this.A06.A02(AbstractC10112p.A01(iA04, 77), iA04, Worker.WHAT_QUIT);
        this.A02.setColorFilter(iA04);
        if (z12) {
            this.A04.setTextColor(AbstractC10112p.A01(-1, Worker.WHAT_QUIT));
        } else {
            this.A04.setTextColor(iA04);
        }
    }

    public final boolean A03() {
        return !this.A04.getText().toString().isEmpty();
    }

    public final boolean A04() {
        int i11 = this.A00;
        return (i11 == 2 || i11 == 4) ? false : true;
    }

    public int getToolbarActionMode() {
        return this.A00;
    }

    public void setActionClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setInitialUnskippableSeconds(int i11) {
        if (i11 > 0) {
            setToolbarActionMode(2);
        }
    }

    public void setProgress(float f11) {
        this.A06.setProgressWithAnimation(f11);
    }

    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A06.setOnClickListener(onClickListener);
    }

    public void setProgressImage(EnumC1470Lw enumC1470Lw) {
        this.A06.setImage(enumC1470Lw);
    }

    public void setProgressImmediate(float f11) {
        this.A06.clearAnimation();
        this.A06.setProgress(f11);
    }

    public void setProgressSpinnerInvisible(boolean z11) {
        this.A01 = z11;
        A01();
    }

    public void setToolbarActionMode(int i11) {
        EnumC1470Lw enumC1470Lw;
        this.A05.A0E().ADK(i11);
        this.A00 = i11;
        A01();
        setVisibility(0);
        if (Build.VERSION.SDK_INT >= 16) {
            this.A02.setImageAlpha(255);
        }
        ImageView imageView = this.A02;
        int i12 = A09;
        imageView.setPadding(i12, i12, i12, i12);
        switch (i11) {
            case 0:
                enumC1470Lw = EnumC1470Lw.CROSS;
                break;
            case 1:
                enumC1470Lw = EnumC1470Lw.SKIP_ARROW;
                break;
            case 2:
            default:
                enumC1470Lw = EnumC1470Lw.CROSS;
                break;
            case 3:
                enumC1470Lw = EnumC1470Lw.MINIMIZE_ARROW;
                break;
            case 4:
                enumC1470Lw = EnumC1470Lw.CROSS;
                this.A02.setVisibility(8);
                setVisibility(8);
                break;
            case 5:
                enumC1470Lw = EnumC1470Lw.CROSS;
                break;
            case 6:
                enumC1470Lw = EnumC1470Lw.CROSS;
                break;
            case 7:
                enumC1470Lw = EnumC1470Lw.CROSS;
                if (Build.VERSION.SDK_INT >= 16) {
                    this.A02.setImageAlpha(Worker.WHAT_QUIT);
                }
                ImageView imageView2 = this.A02;
                if (A07[4].charAt(13) == 'C') {
                    throw new RuntimeException();
                }
                String[] strArr = A07;
                strArr[6] = "";
                strArr[2] = "";
                int i13 = A08;
                imageView2.setPadding(i13, i13, i13, i13);
                break;
                break;
        }
        this.A02.setImageBitmap(AbstractC1471Lx.A01(enumC1470Lw));
        if (i11 == 1) {
            AbstractC1462Lo.A0G(1005, this.A02);
        } else {
            AbstractC1462Lo.A0G(1002, this.A02);
        }
    }

    public void setToolbarMessage(String str) {
        this.A04.setText(str);
        this.A04.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    public void setToolbarMessageEnabled(boolean z11) {
        this.A04.setVisibility(z11 ? 0 : 4);
    }
}
