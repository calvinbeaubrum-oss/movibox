package com.cloud.hisavana.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class j2 extends t {
    public h2 R;
    public volatile AdsDTO S;
    public e T;
    public ViewGroup U;
    public boolean V;
    public boolean W;
    public CopyOnWriteArrayList<e2> X;

    /* JADX INFO: compiled from: source.java */
    public class a implements Preconditions.a {
        public a() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            j2.this.S0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Preconditions.a {
        public b() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            j2.this.E0();
            h2 h2Var = j2.this.R;
            if (h2Var != null) {
                h2Var.c();
            }
            j2.super.W();
            if (j2.this.U != null) {
                j2.this.U.removeAllViews();
            }
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(j2.this.S);
            e eVar = j2.this.T;
            if (eVar != null) {
                eVar.removeMessages(1);
                j2.this.T = null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {
        public c() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            if (j2.this.f30046d != 2 || j2.this.f30046d == 8 || j2.this.f30046d == 1) {
                z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bid  is not success");
            } else {
                j2 j2Var = j2.this;
                j2Var.U0(j2Var.S, 4);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements l0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f29834a;

        public d(int i11) {
            this.f29834a = i11;
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void a(TaErrorCode taErrorCode) {
            j2.this.p(taErrorCode, this.f29834a);
        }

        @Override // com.cloud.hisavana.sdk.l0
        public void b(AdsDTO adsDTO) {
            if (this.f29834a == 4) {
                j2.this.f30046d = 4;
                j2.this.E.e();
                if (j2.this.f30058p) {
                    j2.this.S0();
                    return;
                }
                return;
            }
            if (j2.this.s0()) {
                return;
            }
            z.a().d("TranBanner", "loadPlatformAd onSuccess");
            if (j2.this.S != adsDTO) {
                com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(j2.this.S);
            }
            z.a().d("TranBanner", "loadPlatformAd onSuccess mAdBean ");
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(adsDTO);
            j2.this.z(arrayList, this.f29834a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<j2> f29836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f29837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f29838c;

        public e(j2 j2Var, Looper looper, int i11) {
            super(looper);
            this.f29838c = 1;
            this.f29836a = new WeakReference<>(j2Var);
            this.f29837b = i11;
        }

        public void a() {
            this.f29838c = 1;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            j2 j2Var;
            super.handleMessage(message);
            int i11 = this.f29838c;
            if (i11 >= this.f29837b) {
                return;
            }
            this.f29838c = i11 + 1;
            WeakReference<j2> weakReference = this.f29836a;
            if (weakReference == null || weakReference.get() == null || (j2Var = this.f29836a.get()) == null) {
                return;
            }
            j2Var.Q0();
        }
    }

    public j2(Context context, ViewGroup viewGroup, String str) {
        super(2, str);
        this.S = null;
        this.X = new CopyOnWriteArrayList<>();
        this.U = viewGroup;
        this.R = new h2(this);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void D0() {
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdShowStub ");
        sb2.append(P0());
        sb2.append(" time ");
        ConfigCodeSeatDTO configCodeSeatDTO = this.f30054l;
        sb2.append(configCodeSeatDTO == null ? 0 : configCodeSeatDTO.getCarouselTime());
        zVarA.d("TranBanner", sb2.toString());
        R0();
    }

    public final void E0() {
        CopyOnWriteArrayList<e2> copyOnWriteArrayList = this.X;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (e2 e2Var : this.X) {
            if (e2Var != null) {
                e2Var.j();
            }
        }
        this.X.clear();
    }

    public void F0() {
        ViewGroup viewGroup = this.U;
        if (viewGroup instanceof TBannerView) {
            ((TBannerView) viewGroup).setCloseTypeUsedForTrack(null);
        }
        G0();
    }

    public final void G0() {
        ViewGroup viewGroup;
        if (l() == null || (viewGroup = this.U) == null || !(viewGroup instanceof TBannerView)) {
            return;
        }
        l().c((TBannerView) this.U);
    }

    public final void H0() {
        h2 h2Var;
        if (this.f30046d == 4 && this.S != null && (h2Var = this.R) != null) {
            h2Var.f(this.U, this.V, this.W, this.S);
            return;
        }
        z.a().d("TranBanner", "no ad show, set visible gone");
        ViewGroup viewGroup = this.U;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public int I0() {
        if (this.S != null) {
            return this.S.getDspType().intValue();
        }
        return 1;
    }

    public double J0() {
        if (this.S != null) {
            return this.S.getFirstPrice().doubleValue();
        }
        return 0.0d;
    }

    public boolean K0() {
        return !w9.c.b(this.S);
    }

    public boolean L0() {
        return this.S != null && this.S.getSource() == 4;
    }

    public boolean M0() {
        return this.f30046d == 4;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        AdsDTO adsDTO = (list == null || list.isEmpty()) ? null : list.get(0);
        if (this.f30061s) {
            z(list, i11);
        } else {
            U0(adsDTO, i11);
        }
    }

    public boolean N0() {
        if (this.S == null) {
            return false;
        }
        return this.S.isOfflineAd();
    }

    public boolean O0() {
        return this.f30046d == 4 && K0();
    }

    public final boolean P0() {
        ConfigCodeSeatDTO configCodeSeatDTO = this.f30054l;
        return configCodeSeatDTO != null && configCodeSeatDTO.getCarouselTime() > 0 && this.f30054l.getCarouselCount().intValue() > 1;
    }

    public final void Q0() {
        z.a().d("TranBanner", "loadNextAD");
        this.B = System.currentTimeMillis();
        this.f30051i = DeviceUtil.n();
        this.f30046d = 1;
        x0();
    }

    public final void R0() {
        z.a().d("TranBanner", "postDelayRefresh");
        if (!P0() || this.S == null || this.f30054l == null) {
            return;
        }
        if (this.T == null) {
            this.T = new e(this, Looper.getMainLooper(), this.f30054l.getCarouselCount().intValue());
        }
        this.f30058p = true;
        this.T.sendEmptyMessageDelayed(1, ((long) this.f30054l.getCarouselTime()) * 1000);
    }

    public void S0() {
        Preconditions.a();
        if (this.U == null || this.S == null) {
            z.a().d("TranBanner", "mViewGroup or mAdBean = null");
            return;
        }
        boolean zK0 = K0();
        if (!zK0 || this.f30046d == 6) {
            if (!zK0) {
                z.a().d("TranBanner", "ad not condition to use");
                return;
            }
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.S);
        }
        H0();
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        z.a().d("TranBanner", "onAdLoadedStub isStartRotation " + this.f30058p);
        if (list == null || list.isEmpty()) {
            return;
        }
        AdsDTO adsDTO = list.get(0);
        if (this.S != adsDTO) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(adsDTO);
        }
        this.S = adsDTO;
        if (!this.f30058p || this.f30046d == 2) {
            return;
        }
        Preconditions.d(new a());
    }

    public final void U0(AdsDTO adsDTO, int i11) {
        e2 e2Var = new e2(adsDTO, i11, new d(i11));
        this.X.add(e2Var);
        e2Var.h();
    }

    public void V0(BidInfo bidInfo) {
        Preconditions.d(new c());
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        Preconditions.d(new b());
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

    public void c1(int i11) {
        ViewGroup viewGroup = this.U;
        if (viewGroup instanceof TBannerView) {
            ((TBannerView) viewGroup).setCloseTypeUsedForTrack(Integer.valueOf(i11));
        }
        G0();
    }

    public void d1(boolean z11) {
        this.W = z11;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void f() {
        E0();
        this.f30058p = false;
        e eVar = this.T;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void g1(boolean z11) {
        this.V = z11;
    }

    @Override // com.cloud.hisavana.sdk.t
    public void m(double d11) {
        if (this.S != null) {
            this.S.setSecondPrice(d11);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void o(TaErrorCode taErrorCode) {
        if (this.f30058p) {
            R0();
        }
    }
}
