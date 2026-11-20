package com.facebook.ads.redexgen.uinode;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZF extends C3E {
    public static String[] A02 = {"f2MNSWDlL1YMuTPGOAjONPZtO", "cmMTh0pUaJ1RDNo0mFNR3IJYAK2Mf6gB", "4dFqjoT4qnH4w96CQtkjoCAuJyqtgp11", "6XB3g70NG5Gd02gyy8Ab40YcxuzvQEqb", "wwGHlt0jZwPrQfekoFOvLm8zPwbBrmxC", "1Rqxvwj8Vs8GuK5", "NKSqZWGd9qA279w", "7JvmemziLS26U2JKZlqSRSAl5nA0imSt"};
    public List<NativeAd> A00 = new ArrayList();
    public final /* synthetic */ C10815j A01;

    public ZF(C10815j c10815j) {
        this.A01 = c10815j;
    }

    @Override // com.facebook.ads.redexgen.uinode.C3E
    public final int A01() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.uinode.C3E
    public final int A02(Object obj) {
        int iIndexOf = this.A00.indexOf(obj);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -2;
    }

    @Override // com.facebook.ads.redexgen.uinode.C3E
    public final Object A04(ViewGroup viewGroup, int i11) {
        View viewRender;
        if (this.A01.A01 != null) {
            NativeAdScrollView.AdViewProvider adViewProvider = this.A01.A01;
            List<NativeAd> list = this.A00;
            String[] strArr = A02;
            if (strArr[7].charAt(19) == strArr[4].charAt(19)) {
                throw new RuntimeException();
            }
            A02[2] = "d9x9bMDlXKa90r8XaToMTFuUxNqAoP43";
            viewRender = adViewProvider.createView(list.get(i11), i11);
        } else {
            viewRender = this.A01.A02 != null ? NativeAdView.render(this.A01.A06, this.A00.get(i11), this.A01.A02, this.A01.A03) : NativeAdView.render(this.A01.A06, this.A00.get(i11), this.A01.A03);
        }
        viewGroup.addView(viewRender);
        return viewRender;
    }

    @Override // com.facebook.ads.redexgen.uinode.C3E
    public final void A07(ViewGroup viewGroup, int i11, Object obj) {
        if (i11 < this.A00.size()) {
            if (this.A01.A01 != null) {
                this.A01.A01.destroyView(this.A00.get(i11), (View) obj);
            } else {
                List<NativeAd> list = this.A00;
                if (A02[0].length() != 25) {
                    throw new RuntimeException();
                }
                A02[0] = "BErMlyrXrYPfhoDWoAGZwiXdk";
                list.get(i11).unregisterView();
            }
        }
        viewGroup.removeView((View) obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.C3E
    public final boolean A08(View view, Object obj) {
        return view == obj;
    }

    public final void A09() {
        this.A00.clear();
        int iMin = Math.min(this.A01.A00, this.A01.A04.getUniqueNativeAdCount());
        for (int i11 = 0; i11 < iMin; i11++) {
            NativeAd nativeAdNextNativeAd = this.A01.A04.nextNativeAd();
            V2.A0L(nativeAdNextNativeAd.getInternalNativeAd()).A1a(true);
            this.A00.add(nativeAdNextNativeAd);
        }
        A05();
    }
}
