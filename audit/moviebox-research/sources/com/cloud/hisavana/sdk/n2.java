package com.cloud.hisavana.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.TNativeView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.VideoMeasureManager;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class n2 extends t implements x0 {
    public final p3 R;
    public List<AdsDTO> S;
    public final int T;
    public CopyOnWriteArrayList<o3> U;
    public final e V;

    /* JADX INFO: compiled from: source.java */
    public class a implements o3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f29924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f29925b;

        public a(int i11, boolean z11) {
            this.f29924a = i11;
            this.f29925b = z11;
        }

        @Override // com.cloud.hisavana.sdk.o3.b
        public void a(TaErrorCode taErrorCode) {
            n2.this.p(taErrorCode, this.f29924a);
        }

        @Override // com.cloud.hisavana.sdk.o3.b
        public void b(List<TaNativeInfo> list, List<AdsDTO> list2) {
            if (this.f29924a == 4) {
                List<TaNativeInfo> listX = e1.x(list2);
                n2.this.c0(listX);
                n2.this.f30046d = 4;
                n2.this.E.f(listX);
                return;
            }
            if (n2.this.s0()) {
                return;
            }
            if (list == null || list.size() <= 0) {
                n2.this.p(TaErrorCode.ERROR_AD_MATERIAL_TAKE_FAILED, this.f29924a);
                return;
            }
            if (n2.this.K || !this.f29925b || list.size() >= n2.this.f30057o) {
                n2.this.z(list2, this.f29924a);
            } else {
                n2.this.K0(n2.this.f30057o - list.size(), list2, list, this.f29924a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Preconditions.a {
        public b() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            n2.this.E0();
            n2.this.F0();
            n2.super.W();
            n2.this.R.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaNativeInfo f29928a;

        public c(TaNativeInfo taNativeInfo) {
            this.f29928a = taNativeInfo;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            n2.this.b1(this.f29928a);
            VideoMeasureManager.INSTANCE.f(this.f29928a.getAdItem());
            n2.this.d1(this.f29928a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements b1.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f29930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29931b;

        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f29933a;

            public a(List list) {
                this.f29933a = list;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                List list = this.f29933a;
                if (list != null && list.size() != 0) {
                    d.this.f29930a.addAll(this.f29933a);
                }
                d dVar = d.this;
                n2.this.f0(dVar.f29930a);
                d dVar2 = d.this;
                n2.this.z(dVar2.f29930a, dVar2.f29931b);
            }
        }

        public d(List list, int i11) {
            this.f29930a = list;
            this.f29931b = i11;
        }

        @Override // com.cloud.hisavana.sdk.b1.i
        public void a(List<AdsDTO> list, String str) {
            Preconditions.d(new a(list));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends com.cloud.hisavana.sdk.common.tranmeasure.a<TaNativeInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<n2> f29935a;

        public e(n2 n2Var) {
            this.f29935a = new WeakReference<>(n2Var);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(TaNativeInfo taNativeInfo) {
            super.a(taNativeInfo);
            z.a().d("TranNative", "native ad has impression,start report track---------------------------------");
            n2 n2Var = this.f29935a.get();
            if (n2Var == null || n2Var.R == null || taNativeInfo == null) {
                return;
            }
            n2Var.R.f(taNativeInfo);
        }
    }

    public n2(String str) {
        super(1, str);
        this.T = 0;
        this.U = new CopyOnWriteArrayList<>();
        this.R = new p3(this);
        this.V = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        CopyOnWriteArrayList<o3> copyOnWriteArrayList = this.U;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (o3 o3Var : this.U) {
            if (o3Var != null) {
                o3Var.i();
            }
        }
        this.U.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        p3 p3Var = this.R;
        if (p3Var == null || p3Var.k() == null) {
            return;
        }
        Iterator<TaNativeInfo> it = this.R.k().iterator();
        while (it.hasNext()) {
            b1(it.next());
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void D(t9.a aVar) {
        super.D(aVar);
    }

    public AdChoicesView H0(Context context, TaNativeInfo taNativeInfo) {
        return e1.b(context, e1.c(taNativeInfo), null);
    }

    public AdCloseView I0(Context context) {
        AdCloseView adCloseView = new AdCloseView(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.ad_badge_height);
        adCloseView.setLayoutParams(new RelativeLayout.LayoutParams(dimensionPixelOffset, dimensionPixelOffset));
        return adCloseView;
    }

    public void K0(int i11, List<AdsDTO> list, List<TaNativeInfo> list2, int i12) {
        z.a().d("TranNative", "replenishCacheAd:-----> count " + i11);
        if (list == null || list2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TaNativeInfo> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdCreateId());
        }
        b1.c().k(this.f30043a, i11, false, arrayList, new d(list, i12));
    }

    public final void L0(@NonNull View view, TaNativeInfo taNativeInfo) {
        z.a().d("ssp", "current native did not showed...");
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(taNativeInfo, view, this.V);
    }

    public final void M0(@NonNull ViewGroup viewGroup, List<View> list, TaNativeInfo taNativeInfo) {
        z.a().d("ssp", "registerClickAndImpression");
        Preconditions.a();
        if (this.R == null || taNativeInfo == null) {
            return;
        }
        AdsDTO adsDTOC = e1.c(taNativeInfo);
        if (adsDTOC == null) {
            z.a().d("ssp", "adItem is null");
            return;
        }
        adsDTOC.setSecondPrice(taNativeInfo.getSecondPrice());
        b(taNativeInfo);
        L0(viewGroup, taNativeInfo);
        AthenaTracker.B(adsDTOC);
        this.R.e(viewGroup, list, taNativeInfo, adsDTOC);
        z.a().d("ssp", "Native Ad start registered");
        if (viewGroup == null || 8 != viewGroup.getVisibility()) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void N(List<AdsDTO> list, int i11) {
        if (this.f30061s) {
            z(list, i11);
        } else {
            Y0(list, i11);
        }
    }

    public void Q0(@NonNull ViewGroup viewGroup, List<View> list, TaNativeInfo taNativeInfo) {
        if (viewGroup != null && (viewGroup instanceof TNativeView)) {
            ((TNativeView) viewGroup).setupViews(taNativeInfo);
        }
        M0(viewGroup, list, taNativeInfo);
    }

    @Override // com.cloud.hisavana.sdk.t
    public void T(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        F0();
        this.S = list;
    }

    public void V0(TaNativeInfo taNativeInfo) {
        z.a().d("ssp", "native close ad ----》");
        if (l() != null) {
            l().d(taNativeInfo);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void W() {
        Preconditions.d(new b());
    }

    public final void Y0(List<AdsDTO> list, int i11) {
        boolean z11 = i11 == 1;
        z.a().d("ssp", "loadPlatformAd start load ad  and isNeedReplenish = " + z11);
        o3 o3Var = new o3(list, i11, new a(i11, z11));
        this.U.add(o3Var);
        o3Var.a();
    }

    @Override // com.cloud.hisavana.sdk.x0
    public void a(TaNativeInfo taNativeInfo) {
        Preconditions.d(new c(taNativeInfo));
    }

    @Override // com.cloud.hisavana.sdk.t
    public List<AdsDTO> a0() {
        return this.S;
    }

    public void a1(int i11) {
        this.f30057o = Math.min(Math.max(i11, 1), 5);
    }

    @Override // com.cloud.hisavana.sdk.x0
    public boolean b(TaNativeInfo taNativeInfo) {
        return !w9.c.b(e1.c(taNativeInfo));
    }

    public final void b1(TaNativeInfo taNativeInfo) {
        if (taNativeInfo != null) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(taNativeInfo);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void c0(List<TaNativeInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (TaNativeInfo taNativeInfo : list) {
            if (taNativeInfo != null) {
                taNativeInfo.setNativeBridge(this);
            }
        }
        this.R.g(list);
        R(list.size());
    }

    public void c1(boolean z11) {
        this.f30055m = z11 ? 6 : 1;
    }

    public final void d1(TaNativeInfo taNativeInfo) {
        p3 p3Var = this.R;
        if (p3Var != null) {
            p3Var.l(taNativeInfo);
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void e() {
        p3 p3Var = this.R;
        if (p3Var == null || !w9.e.a(p3Var.k())) {
            super.e();
        } else {
            this.E.f(this.R.k());
        }
    }

    @Override // com.cloud.hisavana.sdk.t
    public void f() {
        E0();
    }
}
