package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1806Yy implements AnonymousClass66 {
    public static byte[] A03;
    public static String[] A04 = {"Yyt8Jrp", "FvQHlihhdkZe9tXm7YLHdG4gIBqm", "h7ITXytSbKbsxwMfZDKdUPEvMsTrizAq", "0TuNzKSIMRKA8K3EzRQL94hbriXTa7QT", "ySuQOOQJHVodSpCznPaDLfXVVxuxvbGA", "XYB8XYCfCTfWBGtKG07Wi1HuHmIQx2qC", "71D0xe3tljOi7f3b0iOVOXaXnoSWhNo4", "dwdYeokke3ChTNA3vTF4hdqHGwVronGN"};
    public final InterfaceC1613Rj A01;
    public Set<AnonymousClass69> A00 = new HashSet();
    public final List<AnonymousClass68> A02 = new ArrayList();

    static {
        A02();
    }

    public C1806Yy(InterfaceC1360Hj interfaceC1360Hj) {
        InterfaceC1613Rj interfaceC1613RjA4i = interfaceC1360Hj.A4i(EnumC1614Rk.A0B);
        this.A01 = interfaceC1613RjA4i;
        interfaceC1613RjA4i.A3R(new C1807Yz(this));
        A03();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static Set<AnonymousClass69> A01(JSONObject jSONObject) {
        C1805Yx c1805YxA00;
        HashSet hashSet = new HashSet();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(8, 6, 93));
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
            if (jSONObjectOptJSONObject == null || (c1805YxA00 = C1805Yx.A00(jSONObjectOptJSONObject)) == null) {
                return null;
            }
            hashSet.add(c1805YxA00);
            if (A04[1].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "2zeGpFgTpOohtr7xv9EhLTO87hKhrQIZ";
            strArr[3] = "Z45Lb0RXWpRaUi2IX7mXCACeVe5qt7dU";
        }
        return hashSet;
    }

    public static void A02() {
        A03 = new byte[]{-72, -72, -67, Ascii.VT, -46, -72, -67, Ascii.VT, 41, 59, 59, 45, 60, 59};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A03() {
        if (!this.A01.A9C()) {
            BuildConfigApi.isDebug();
            return;
        }
        Set<AnonymousClass69> setA01 = A01(this.A01.A6h());
        if (!this.A00.equals(setA01) && setA01 != null) {
            this.A00 = setA01;
            Iterator<AnonymousClass68> it = this.A02.iterator();
            while (it.hasNext()) {
                it.next().A3d();
            }
        }
        if (BuildConfigApi.isDebug()) {
            for (AnonymousClass69 anonymousClass69 : this.A00) {
                String.format(Locale.US, A00(0, 8, 45), anonymousClass69.A8D(), anonymousClass69.getUrl());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass66
    public final void A3P(AnonymousClass68 anonymousClass68) {
        this.A02.add(anonymousClass68);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass66
    public final synchronized Set<AnonymousClass69> A62() {
        return new HashSet(this.A00);
    }
}
