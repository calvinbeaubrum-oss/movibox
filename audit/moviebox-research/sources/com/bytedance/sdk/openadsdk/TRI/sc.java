package com.bytedance.sdk.openadsdk.TRI;

import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile sc f27281sc;
    private int BT;
    private int[] ExN;
    private int[] Ol;
    private int[] Qj;
    private boolean Ql;
    private boolean SR;
    private int[] TRI;
    private int[] Tf;
    private boolean UFX;
    private boolean WH;
    private boolean We;
    private boolean Xc;
    private boolean dE;
    private boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int[] f27282qr;
    private boolean zY;

    private sc() {
        pFF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] pFF(String[] strArr) {
        return strArr.length > 0 ? zY(strArr[0].split(",")) : new int[0];
    }

    public static sc sc() {
        if (f27281sc == null) {
            synchronized (zY.class) {
                try {
                    if (f27281sc == null) {
                        f27281sc = new sc();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27281sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(String[] strArr) {
        if (strArr.length == 2) {
            return "session".equals(strArr[1]);
        }
        if (strArr.length == 1) {
            return "session".equals(strArr[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] zY(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        int i11 = 0;
        for (String str : strArr) {
            try {
                int i12 = Integer.parseInt(str);
                iArr[i11] = i12;
                if (i12 > 0) {
                    i11++;
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (i11 == length) {
            return iArr;
        }
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, i11);
        return iArr2;
    }

    public boolean BT() {
        return this.UFX;
    }

    public boolean ExN() {
        return this.dE;
    }

    public int[] Ol() {
        return this.ExN;
    }

    public boolean Qj() {
        return this.We;
    }

    public int[] Ql() {
        return this.Ol;
    }

    public boolean SR() {
        return this.WH;
    }

    public boolean TRI() {
        return this.pFF;
    }

    public int[] Tf() {
        return this.Qj;
    }

    public int[] UFX() {
        return this.f27282qr;
    }

    public int[] WH() {
        return this.TRI;
    }

    public int We() {
        return this.BT;
    }

    public boolean Xc() {
        return this.Ql;
    }

    public int[] dE() {
        return this.Tf;
    }

    public void pFF() {
        SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.sc.1
            @Override // java.lang.Runnable
            public void run() {
                sc.this.SR = com.bytedance.sdk.openadsdk.YIK.sc.sc("feature_switch", false);
                if (sc.this.SR) {
                    try {
                        sc.this.Xc = com.bytedance.sdk.openadsdk.YIK.sc.sc("exclude_banner_native", false);
                        sc.this.BT = com.bytedance.sdk.openadsdk.YIK.sc.sc("feature_timer_interval", 10000);
                        sc.this.dE = com.bytedance.sdk.openadsdk.YIK.sc.sc("enable_feature_cids", true);
                        String[] strArrSplit = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_ad_show_cnt", "1,3,5&session").split("&");
                        String[] strArrSplit2 = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_ad_click_cnt", "1,3,5&session").split("&");
                        String[] strArrSplit3 = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_video_play_cnt", "1,3,5&session").split("&");
                        String[] strArrSplit4 = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_dislike_cnt", "1,3,5session").split(",");
                        sc scVar = sc.this;
                        scVar.pFF = scVar.sc(strArrSplit);
                        sc scVar2 = sc.this;
                        scVar2.zY = scVar2.sc(strArrSplit2);
                        sc scVar3 = sc.this;
                        scVar3.We = scVar3.sc(strArrSplit3);
                        sc scVar4 = sc.this;
                        scVar4.ExN = scVar4.pFF(strArrSplit);
                        sc scVar5 = sc.this;
                        scVar5.TRI = scVar5.pFF(strArrSplit2);
                        sc scVar6 = sc.this;
                        scVar6.f27282qr = scVar6.pFF(strArrSplit3);
                        sc scVar7 = sc.this;
                        scVar7.Tf = scVar7.zY(strArrSplit4);
                        String[] strArrSplit5 = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_landingPage_stay_time", "1,3,5&session").split("&");
                        String[] strArrSplit6 = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_video_stay_time", "1,3,5&session").split("&");
                        sc scVar8 = sc.this;
                        scVar8.WH = scVar8.sc(strArrSplit5);
                        sc scVar9 = sc.this;
                        scVar9.UFX = scVar9.sc(strArrSplit6);
                        sc scVar10 = sc.this;
                        scVar10.Qj = scVar10.pFF(strArrSplit5);
                        sc scVar11 = sc.this;
                        scVar11.Ol = scVar11.pFF(strArrSplit6);
                        sc.this.Ql = com.bytedance.sdk.openadsdk.YIK.sc.sc("pag_video_30p_session", true);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public boolean qr() {
        return this.zY;
    }

    public boolean wjp() {
        return this.Xc;
    }

    public boolean zY() {
        return this.SR;
    }
}
