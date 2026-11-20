package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1520Nu extends RelativeLayout {
    public static String[] A06 = {"GfXFZtEZk1NZfob7Kzf1xTq0EESlD7si", "ewzI1iE8tF5Z2B86REyPWWZDw7DKLBH9", "kOyZSgqEibXIKTIW7tLvn8rBuxcmsyDd", "XpDxTY", "v6DhXkGtrQWw75h", "XA27k4WXBENWs2k6KViFhCSGxV0pMN8g", "cLUj8uWE8C4NOcjwK2waVMiWyPuWQVsm", ""};
    public final int A00;
    public final LinearLayout A01;
    public final C1896b3 A02;
    public final C1795Yn A03;
    public final J2 A04;
    public final MC A05;

    public C1520Nu(C1795Yn c1795Yn, C1896b3 c1896b3, J2 j11, MC mc2, int i11, int i12) {
        super(c1795Yn);
        this.A03 = c1795Yn;
        this.A02 = c1896b3;
        this.A04 = j11;
        this.A05 = mc2;
        this.A00 = i11;
        LinearLayout linearLayout = new LinearLayout(c1795Yn);
        this.A01 = linearLayout;
        A00();
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        setLayoutOrientation(i12);
    }

    private void A00() {
        int i11 = 0;
        while (true) {
            C1896b3 c1896b3 = this.A02;
            if (A06[4].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[6] = "6kBjYVyQvbEVjVKJKeawSG2VEKMXDcJL";
            strArr[5] = "aQimcOJmMOk7TFcbK4Cqi1kaRliNN4Qj";
            if (i11 >= c1896b3.A0s()) {
                return;
            }
            C1671Tp c1671Tp = new C1671Tp(this.A03, this.A02.A0v(i11), this.A04, this.A05);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(C1671Tp.A0B, C1671Tp.A0B, C1671Tp.A0B, C1671Tp.A0B);
            c1671Tp.setLayoutParams(layoutParams);
            this.A01.addView(c1671Tp);
            i11++;
        }
    }

    private void setLayoutOrientation(int i11) {
        if (i11 == 1) {
            this.A01.setOrientation(1);
            LinearLayout linearLayout = this.A01;
            int i12 = this.A00;
            linearLayout.setPadding(0, (int) (((double) i12) * 1.5d), 0, i12);
            return;
        }
        this.A01.setOrientation(0);
        LinearLayout linearLayout2 = this.A01;
        int i13 = this.A00;
        linearLayout2.setPadding(0, i13, 0, (int) (((double) i13) * 0.25d));
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutOrientation(configuration.orientation);
    }
}
