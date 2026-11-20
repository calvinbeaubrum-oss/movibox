package com.bytedance.sdk.component.adexpress.dynamic.sc;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.We;
import com.bytedance.sdk.component.adexpress.dynamic.We.Qj;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BT;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Dl;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.FI;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Gb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.HJN;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.II;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.JPJ;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.McK;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Ol;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.SR;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.TRI;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Tf;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.UFX;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WH;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.WP;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Xc;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YIK;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cD;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cvk;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.dE;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.qr;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.uEA;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.wjp;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.zY;
import com.bytedance.sdk.component.adexpress.pFF.Ql;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    public static ExN sc(Context context, DynamicRootView dynamicRootView, Qj qj2) {
        Ql renderRequest;
        if (context == null || dynamicRootView == null || qj2 == null || qj2.WH() == null) {
            return null;
        }
        switch (qj2.WH().sc()) {
            case -1:
                return new Gb(context, dynamicRootView, qj2);
            case 0:
                return new WP(context, dynamicRootView, qj2);
            case 1:
                return new UFX(context, dynamicRootView, qj2);
            case 2:
                return new qr(context, dynamicRootView, qj2);
            case 3:
                return new Ol(context, dynamicRootView, qj2);
            case 4:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Ql(context, dynamicRootView, qj2);
            case 5:
                return new SR(context, dynamicRootView, qj2);
            case 6:
            case 9:
            case 17:
                return new TRI(context, dynamicRootView, qj2);
            case 7:
                return new Cb(context, dynamicRootView, qj2);
            case 8:
                return new wjp(context, dynamicRootView, qj2);
            case 10:
                return new dE(context, dynamicRootView, qj2);
            case 11:
                return new FI(context, dynamicRootView, qj2);
            case 12:
                return new WH(context, dynamicRootView, qj2);
            case 13:
                return new cvk(context, dynamicRootView, qj2);
            case 14:
                return new II(context, dynamicRootView, qj2);
            case 15:
                return We.pFF() ? new McK(context, dynamicRootView, qj2) : new HJN(context, dynamicRootView, qj2);
            case 16:
                return new UFX(context, dynamicRootView, qj2);
            case 18:
                return new JPJ(context, dynamicRootView, qj2);
            case 19:
                return new uEA(context, dynamicRootView, qj2);
            case 20:
                return new YIK(context, dynamicRootView, qj2);
            case 21:
                return new Dl(context, dynamicRootView, qj2);
            case 22:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Qj(context, dynamicRootView, qj2);
            case 23:
                return new Xc(context, dynamicRootView, qj2);
            case 24:
                return new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.We(context, dynamicRootView, qj2);
            case 25:
                return new Tf(context, dynamicRootView, qj2);
            case 26:
                return "vertical".equals(qj2.WH().ExN().Mrq()) ? new cD(context, dynamicRootView, qj2) : new zY(context, dynamicRootView, qj2);
            case 27:
                return new HJN(context, dynamicRootView, qj2);
            case 28:
                if (!We.pFF() || (renderRequest = dynamicRootView.getRenderRequest()) == null) {
                    return null;
                }
                return new BT(context, dynamicRootView, qj2, renderRequest.FI());
            default:
                return null;
        }
    }
}
