package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class l2 extends t {
    public final h1 R;
    public volatile AdsDTO S;
    public CopyOnWriteArrayList<d1> T;

    /* JADX INFO: compiled from: source.java */
    public class a implements Preconditions.a {
        public a() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            l2.this.E0();
            l2.super.W();
            l2.this.R.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f29850a;

        public b(int i11) {
            this.f29850a = i11;
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void a(TaErrorCode taErrorCode) {
            l2.this.p(taErrorCode, this.f29850a);
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void b(AdsDTO adsDTO) {
            if (this.f29850a == 4) {
                l2.this.f30046d = 4;
                l2.this.E.e();
            } else {
                if (l2.this.s0() || adsDTO == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(adsDTO);
                l2.this.z(arrayList, this.f29850a);
            }
        }
    }

    public l2(String str) {
        super(3, str);
        this.S = null;
        this.T = new CopyOnWriteArrayList<>();
        this.R = new h1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        CopyOnWriteArrayList<d1> copyOnWriteArrayList = this.T;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (d1 d1Var : this.T) {
            if (d1Var != null) {
                d1Var.n();
            }
        }
        this.T.clear();
    }

    private void M0(AdsDTO adsDTO, int i11) {
        z.a().d("TranInterstitial", "loadPlatformAd");
        d1 d1Var = new d1(adsDTO, i11, new b(i11));
        this.T.add(d1Var);
        d1Var.a();
    }

    public int F0() {
        if (this.S != null) {
            return this.S.getDspType().intValue();
        }
        return 1;
    }

    public double G0() {
        if (this.S != null) {
            return this.S.getFirstPrice().doubleValue();
        }
        return 0.0d;
    }

    public boolean H0() {
        return !w9.c.b(this.S);
    }

    public boolean I0() {
        return this.S != null && this.S.getSource() == 4;
    }

    public boolean J0() {
        return this.f30046d == 4;
    }

    public void K0() {
        Preconditions.a();
        if (this.S == null) {
            z.a().d("ssp", "adBean = null");
        } else if (H0() && this.f30046d == 4) {
            this.R.e(this.S);
        } else {
            z.a().d("ssp", "ad not condition to use");
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        z.a().d("ssp", "loadPlatformAd on start load ad ");
        AdsDTO adsDTO = (list == null || list.isEmpty()) ? null : list.get(0);
        if (this.f30061s) {
            z(list, i11);
        } else {
            M0(adsDTO, i11);
        }
    }

    public void P0(AdsDTO adsDTO) {
        if (adsDTO != null) {
            this.S = adsDTO;
        }
    }

    public void R0(AdsDTO adsDTO) {
        this.S = adsDTO;
        this.R.e(adsDTO);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.S = list.get(0);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        Preconditions.d(new a());
    }

    @Override // com.cloud.hisavana.sdk.t
    public List<AdsDTO> a0() {
        ArrayList arrayList = new ArrayList();
        if (this.S == null) {
            return arrayList;
        }
        arrayList.add(this.S);
        return arrayList;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void f() {
        E0();
    }

    @Override // com.cloud.hisavana.sdk.t
    public void m(double d11) {
        if (this.S != null) {
            this.S.setSecondPrice(d11);
        }
    }
}
