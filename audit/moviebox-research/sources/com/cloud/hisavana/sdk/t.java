package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.RunTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t {
    public volatile long B;
    public final s C;
    public final u D;
    public final j E;
    public boolean F;
    public boolean L;
    public boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30043a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s9.a f30049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t9.a f30050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f30051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f30052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f30053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConfigCodeSeatDTO f30054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f30055m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f30058p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f30059q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f30060r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f30061s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f30062t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f30063u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map<String, Object> f30064v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f30065w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f30066x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30044b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f30045c = 60000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f30046d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RunTimer f30047e = new RunTimer();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RunTimer f30048f = new RunTimer();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicInteger f30056n = new AtomicInteger(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f30057o = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f30067y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f30068z = false;
    public int A = 0;
    public int G = -1;
    public volatile int H = 0;
    public int I = 0;
    public int J = 0;
    public boolean K = false;
    public final List<AdsDTO> M = new ArrayList();
    public boolean O = false;
    public final RunTimer.a P = new f();
    public final RunTimer.a Q = new g();

    /* JADX INFO: compiled from: source.java */
    public class a implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.a f30069a;

        public a(s9.a aVar) {
            this.f30069a = aVar;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            this.f30069a.o();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Preconditions.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.a f30071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BidInfo f30072b;

        public b(s9.a aVar, BidInfo bidInfo) {
            this.f30071a = aVar;
            this.f30072b = bidInfo;
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            this.f30071a.j(this.f30072b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Preconditions.a {
        public c() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            t tVar = t.this;
            int i11 = tVar.f30046d;
            if (i11 == 1 || i11 == 2 || i11 == 8) {
                z.a().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "current object is loading or destroyed");
                t tVar2 = t.this;
                int i12 = tVar2.f30055m;
                String str = tVar2.f30052j;
                String str2 = tVar2.f30043a;
                int i13 = tVar2.f30057o;
                int i14 = tVar2.f30053k;
                t tVar3 = t.this;
                AthenaTracker.V(false, i12, str, str2, i13, i14, tVar3.f30062t, tVar3.f30063u, tVar3.f30064v, tVar3.f30046d == 1 ? TaErrorCode.CODE_LOAD_FAILED_CAUSE_LOADING : TaErrorCode.CODE_LOAD_FAILED_CAUSE_DESTROY);
                return;
            }
            tVar.B = System.currentTimeMillis();
            t tVar4 = t.this;
            tVar4.f30046d = 1;
            tVar4.f();
            t9.a aVar = t.this.f30050h;
            if (aVar == null || aVar.f() == null || !t.this.f30050h.f().startsWith("hisa-")) {
                t.this.f30052j = w9.z.b();
            }
            t9.a aVar2 = t.this.f30050h;
            if (aVar2 == null || aVar2.c() == null || !t.this.f30050h.c().startsWith("hisa-")) {
                t.this.f30051i = DeviceUtil.n();
            }
            t.this.x0();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements Runnable {

        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ConfigCodeSeatDTO f30076a;

            public a(ConfigCodeSeatDTO configCodeSeatDTO) {
                this.f30076a = configCodeSeatDTO;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                t.this.r(this.f30076a);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Preconditions.d(new a(x.h().c(t.this.f30043a)));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements b1.i {

        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f30079a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f30080b;

            public a(List list, String str) {
                this.f30079a = list;
                this.f30080b = str;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                t.this.U(this.f30079a, this.f30080b);
            }
        }

        public e() {
        }

        @Override // com.cloud.hisavana.sdk.b1.i
        public void a(List<AdsDTO> list, String str) {
            Preconditions.d(new a(list, str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f implements RunTimer.a {
        public f() {
        }

        @Override // com.cloud.sdk.commonutil.util.RunTimer.a
        public void isTimeOut() {
            t.this.f30048f.b();
            j jVar = t.this.E;
            if (jVar != null) {
                jVar.o();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements RunTimer.a {
        public g() {
        }

        @Override // com.cloud.sdk.commonutil.util.RunTimer.a
        public void isTimeOut() {
            z.a().w("BaseAd", "cloudLoadTimeOutCallback isTimeOut");
            t.this.Q();
            t tVar = t.this;
            if (tVar.K) {
                tVar.k();
            } else {
                tVar.z0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h implements Comparator<AdsDTO> {
        public h() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AdsDTO adsDTO, AdsDTO adsDTO2) {
            int source = adsDTO.getSource();
            double dDoubleValue = adsDTO.getFirstPrice().doubleValue();
            if (source == 4) {
                dDoubleValue *= 100.0d;
            }
            return Double.compare(adsDTO2.getSource() == 4 ? adsDTO2.getFirstPrice().doubleValue() * 100.0d : adsDTO2.getFirstPrice().doubleValue(), dDoubleValue);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class i implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<t> f30085a;

        public i(t tVar) {
            this.f30085a = new WeakReference<>(tVar);
        }

        @Override // com.cloud.hisavana.sdk.u
        public void a(@NonNull List<AdsDTO> list) {
            z.a().d("BaseAd", "onAdResponse");
            t tVar = this.f30085a.get();
            if (tVar == null) {
                return;
            }
            if (list == null || list.isEmpty()) {
                z.a().d("ssp", "adList is empty");
                if (tVar.z0()) {
                    return;
                }
                tVar.p(TaErrorCode.ERROR_AD_DATA_IS_NULL, 1);
                return;
            }
            int i11 = tVar.f30046d;
            if (i11 == 8 || i11 == 7) {
                z.a().d("ssp", "Request time out");
                return;
            }
            int size = list.size();
            int i12 = tVar.f30057o;
            if (size > i12) {
                try {
                    tVar.N(list.subList(0, i12), 1);
                    return;
                } catch (Exception unused) {
                }
            }
            tVar.N(list, 1);
        }

        @Override // com.cloud.hisavana.sdk.u
        public void a(List<AdsDTO> list, TaErrorCode taErrorCode, AdxImpBean adxImpBean) {
            z.a().d("BaseAd", "onResponseError adError = " + taErrorCode);
            t tVar = this.f30085a.get();
            if (tVar == null) {
                return;
            }
            tVar.H = 2;
            if (adxImpBean != null) {
                adxImpBean.isTimeOut = tVar.f30046d == 7 ? 1 : 0;
            }
            if (adxImpBean == null || !adxImpBean.offlineAd) {
                if (AdManager.h()) {
                    com.cloud.sdk.commonutil.util.r.b(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg5), 2);
                }
                if (tVar.z0()) {
                    return;
                }
                tVar.p(taErrorCode, 1);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class j extends s9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<t> f30086a;

        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30087a;

            public a(s9.a aVar) {
                this.f30087a = aVar;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30087a.g();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30089a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaNativeInfo f30090b;

            public b(s9.a aVar, TaNativeInfo taNativeInfo) {
                this.f30089a = aVar;
                this.f30090b = taNativeInfo;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30089a.m(this.f30090b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class c implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30092a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaErrorCode f30093b;

            public c(s9.a aVar, TaErrorCode taErrorCode) {
                this.f30092a = aVar;
                this.f30093b = taErrorCode;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30092a.h(this.f30093b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class d implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30095a;

            public d(s9.a aVar) {
                this.f30095a = aVar;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30095a.e();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class e implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30097a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f30098b;

            public e(s9.a aVar, List list) {
                this.f30097a = aVar;
                this.f30098b = list;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30097a.f(this.f30098b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class f implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30100a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaErrorCode f30101b;

            public f(s9.a aVar, TaErrorCode taErrorCode) {
                this.f30100a = aVar;
                this.f30101b = taErrorCode;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30100a.i(this.f30101b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class g implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30103a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaErrorCode f30104b;

            public g(s9.a aVar, TaErrorCode taErrorCode) {
                this.f30103a = aVar;
                this.f30104b = taErrorCode;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30103a.k(this.f30104b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class h implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30106a;

            public h(s9.a aVar) {
                this.f30106a = aVar;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30106a.a();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class i implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30108a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaNativeInfo f30109b;

            public i(s9.a aVar, TaNativeInfo taNativeInfo) {
                this.f30108a = aVar;
                this.f30109b = taNativeInfo;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30108a.l(this.f30109b);
            }
        }

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.t$j$j, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0332j implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30111a;

            public C0332j(s9.a aVar) {
                this.f30111a = aVar;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30111a.b();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class k implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30113a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TBannerView f30114b;

            public k(s9.a aVar, TBannerView tBannerView) {
                this.f30113a = aVar;
                this.f30114b = tBannerView;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30113a.c(this.f30114b);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class l implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s9.a f30116a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TaNativeInfo f30117b;

            public l(s9.a aVar, TaNativeInfo taNativeInfo) {
                this.f30116a = aVar;
                this.f30117b = taNativeInfo;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                this.f30116a.d(this.f30117b);
            }
        }

        public j(t tVar) {
            this.f30086a = new WeakReference<>(tVar);
        }

        @Override // s9.a
        public void a() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.B0();
            s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": onAdClicked");
                Preconditions.d(new h(aVar));
            }
        }

        @Override // s9.a
        public void b() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.C0();
            AthenaTracker.f0(p(tVar));
            s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": onAdClosed");
                Preconditions.d(new C0332j(aVar));
            }
        }

        @Override // s9.a
        public void c(TBannerView tBannerView) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.C0();
            AthenaTracker.g0(p(tVar), tBannerView != null ? tBannerView.getCloseTypeUsedForTrack() : null);
            s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": banner onAdClosed");
                Preconditions.d(new k(aVar, tBannerView));
            }
        }

        @Override // s9.a
        public void d(TaNativeInfo taNativeInfo) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.C0();
            AthenaTracker.f0(p(tVar));
            s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": native onAdClosed");
                Preconditions.d(new l(aVar, taNativeInfo));
            }
        }

        @Override // s9.a
        public void e() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            s9.a aVar = tVar.f30049g;
            long jCurrentTimeMillis = System.currentTimeMillis() - tVar.B;
            tVar.A(tVar.a0(), jCurrentTimeMillis, null, 0);
            z.a().d("BaseAd", "code seat id is " + tVar.f30043a + ": fill success ,fill time is ------》" + jCurrentTimeMillis);
            if (aVar != null) {
                Preconditions.d(new d(aVar));
            }
            tVar.A0();
        }

        @Override // s9.a
        public void f(List<TaNativeInfo> list) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            s9.a aVar = tVar.f30049g;
            long jCurrentTimeMillis = System.currentTimeMillis() - tVar.B;
            tVar.A(tVar.a0(), jCurrentTimeMillis, null, 0);
            z.a().d("BaseAd", "code seat id is " + tVar.f30043a + ": fill success ,fill time is ------》" + jCurrentTimeMillis);
            if (aVar != null) {
                Preconditions.d(new e(aVar, list));
            }
            tVar.A0();
        }

        @Override // s9.a
        public void g() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.q(null);
            tVar.D0();
            tVar.f30056n.decrementAndGet();
            s9.a aVar = tVar.f30049g;
            if (aVar == null || tVar.f30046d == 6) {
                return;
            }
            if (tVar.f30056n.get() <= 0) {
                tVar.f30046d = 6;
            }
            com.cloud.sdk.commonutil.util.c.Log().d("ssp", "onAdShow");
            Preconditions.d(new a(aVar));
        }

        @Override // s9.a
        public void h(TaErrorCode taErrorCode) {
            s9.a aVar;
            t tVar = this.f30086a.get();
            if (tVar == null || (aVar = tVar.f30049g) == null) {
                return;
            }
            Preconditions.d(new c(aVar, taErrorCode));
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.i();
            tVar.f30048f.b();
            long jCurrentTimeMillis = System.currentTimeMillis() - tVar.B;
            tVar.o(taErrorCode);
            tVar.A(null, jCurrentTimeMillis, tVar.f30059q, taErrorCode == null ? -1 : taErrorCode.getErrorCode());
            s9.a aVar = tVar.f30049g;
            if (tVar.f30061s) {
                tVar.f30046d = 3;
            } else {
                tVar.f30046d = 5;
            }
            if (aVar != null) {
                if (taErrorCode != null) {
                    z.a().d("BaseAd", "code seat id is " + tVar.f30043a + ": fill error ,adErrorCode: =" + taErrorCode.getErrorCode() + "  adError：=" + taErrorCode.getErrorMessage());
                }
                Preconditions.d(tVar.f30061s ? new f(aVar, taErrorCode) : new g(aVar, taErrorCode));
            }
            int errorCode = taErrorCode == null ? 0 : taErrorCode.getErrorCode();
            if (errorCode == 4011) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": fill error ,adErrorCode: =" + errorCode + " ----> send cloud config request");
                v.p().g(3);
            }
        }

        @Override // s9.a
        public void l(TaNativeInfo taNativeInfo) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.B0();
            s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                z.a().d("ssp", "code seat id is " + tVar.f30043a + ": onNativeAdClick");
                Preconditions.d(new i(aVar, taNativeInfo));
            }
        }

        @Override // s9.a
        public void m(TaNativeInfo taNativeInfo) {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            if (taNativeInfo != null) {
                tVar.q(taNativeInfo.getAdItem());
            }
            tVar.D0();
            tVar.f30056n.decrementAndGet();
            s9.a aVar = tVar.f30049g;
            if (aVar == null || tVar.f30046d == 6) {
                return;
            }
            if (tVar.f30056n.get() <= 0) {
                tVar.f30046d = 6;
            }
            com.cloud.sdk.commonutil.util.c.Log().d("ssp", "onNativeAdShow");
            Preconditions.d(new b(aVar, taNativeInfo));
        }

        @Override // s9.a
        public void n() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            AthenaTracker.a0(p(tVar));
            final s9.a aVar = tVar.f30049g;
            if (aVar != null) {
                Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.q2
                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public final void onRun() {
                        aVar.n();
                    }
                });
            }
        }

        @Override // s9.a
        public void o() {
            t tVar = this.f30086a.get();
            if (tVar == null) {
                return;
            }
            tVar.f30046d = 7;
            tVar.A(null, System.currentTimeMillis() - tVar.B, null, 4001);
            tVar.e();
        }

        public final AdsDTO p(t tVar) {
            if (tVar.a0() == null || tVar.a0().size() <= 0) {
                return null;
            }
            return tVar.a0().get(0);
        }
    }

    public t(int i11, String str) {
        this.f30055m = i11;
        this.f30043a = str;
        i iVar = new i(this);
        this.D = iVar;
        this.E = new j(this);
        s sVar = new s(this.f30043a);
        this.C = sVar;
        sVar.f(iVar);
    }

    public final void A(List<AdsDTO> list, long j11, String str, int i11) {
        AdsDTO adsDTO;
        if (list != null && list.size() > 0 && (adsDTO = list.get(0)) != null && adsDTO.getSource() == 4) {
            AthenaTracker.M(list, this.f30052j, this.f30043a, j11);
            return;
        }
        String str2 = this.f30052j;
        int i12 = this.f30053k;
        String str3 = this.f30043a;
        boolean z11 = this.f30068z;
        String str4 = this.f30060r;
        ConfigCodeSeatDTO configCodeSeatDTO = this.f30054l;
        AthenaTracker.x(list, str2, i12, str, i11, j11, str3, z11, str4, configCodeSeatDTO == null ? 0 : configCodeSeatDTO.getLocalOfflineAdCacheCount());
    }

    public final void A0() {
        List<AdsDTO> listA0;
        if (AdManager.h() && (listA0 = a0()) != null && listA0.size() > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fill_success:");
            sb2.append("\n");
            for (AdsDTO adsDTO : listA0) {
                if (adsDTO != null) {
                    sb2.append("ad_trigger_status:");
                    sb2.append(this.f30053k);
                    sb2.append("，is_offline_ad：");
                    sb2.append(adsDTO.isOfflineAd());
                    sb2.append("，adCreativeId：");
                    sb2.append(adsDTO.getAdCreativeId());
                    sb2.append(", source:");
                    sb2.append(adsDTO.getSource());
                    sb2.append("\n");
                }
            }
            com.cloud.sdk.commonutil.util.r.b(sb2.toString(), 3);
        }
    }

    public void B0() {
    }

    public void C(s9.a aVar) {
        this.f30049g = aVar;
    }

    public void C0() {
    }

    public void D(t9.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f30050h = aVar;
        String strC = aVar.c();
        if (!TextUtils.isEmpty(strC)) {
            this.f30051i = strC.replace("hisa-", "");
        }
        if (aVar.e() > 0) {
            this.f30045c = aVar.e();
        }
        if (aVar.d() != -1) {
            this.f30044b = aVar.d();
        }
        this.f30065w = aVar.g();
        String strF = aVar.f();
        if (!TextUtils.isEmpty(strF)) {
            L(strF.replace("hisa-", ""));
        }
        if (aVar.b() > 0.0d) {
            m(aVar.b());
        }
    }

    public void D0() {
    }

    public void E(boolean z11) {
        int i11 = this.f30046d;
        if (i11 == 1 || i11 == 8) {
            return;
        }
        this.f30061s = z11;
    }

    public int G(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return 0;
        }
        int iP0 = p0();
        int iR0 = r0();
        z.a().d("BaseAd", "picDelayTime: " + iP0 + ", videoDelayTime: " + iR0);
        return adsDTO.isVastTypeAd() ? iR0 : iP0;
    }

    public AdxImpBean H() {
        AdxImpBean adxImpBean = new AdxImpBean();
        adxImpBean.adt = this.f30055m;
        adxImpBean.pmid = this.f30043a;
        adxImpBean.mAdCount = this.f30057o;
        adxImpBean.requestId = this.f30051i;
        adxImpBean.requestType = this.f30044b;
        adxImpBean.triggerId = this.f30052j;
        adxImpBean.gameName = this.f30062t;
        adxImpBean.gameScene = this.f30063u;
        adxImpBean.extInfo = this.f30064v;
        adxImpBean.supportEw = this.f30065w;
        adxImpBean.requestTs = Long.valueOf(System.currentTimeMillis());
        adxImpBean.isAutoPlayVideoAd = this.f30067y;
        adxImpBean.offlineAdEnable = this.f30068z;
        adxImpBean.cacheAdCount = this.A;
        adxImpBean.mTriggerNetState = this.f30053k;
        return adxImpBean;
    }

    public void J(int i11) {
        this.G = i11;
    }

    public void K(TaErrorCode taErrorCode, int i11) {
        if (s0()) {
            return;
        }
        if (i11 == 1) {
            this.H = 2;
        }
        z.a().d("BaseAd", "current status is :onLineRequestStatus is " + this.H + ",cacheLoadStatus is " + this.I + " ,defaultLoadStatus is " + this.J);
        if (this.H == 1 || this.I == 1 || this.J == 1 || z0() || y0()) {
            return;
        }
        this.E.k(taErrorCode);
    }

    public void L(String str) {
        this.f30052j = str;
    }

    public void M(@NonNull List<AdsDTO> list) {
        if (s0()) {
            return;
        }
        i();
        Q();
        this.f30046d = this.f30061s ? 2 : 4;
        T(list);
        if (this.f30061s) {
            Y(list);
        } else {
            int i11 = this.f30055m;
            if (i11 == 1 || i11 == 6) {
                List<TaNativeInfo> listX = e1.x(list);
                c0(listX);
                this.E.f(listX);
            } else {
                this.E.e();
            }
        }
        z.a().d("ssp", "code seat id is " + this.f30043a + ":onAdLoaded");
        v.p().g(3);
    }

    public abstract void N(List<AdsDTO> list, int i11);

    public final /* synthetic */ void O(final List list, final String str) {
        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.p2
            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public final void onRun() {
                this.f29986a.B(list, str);
            }
        });
    }

    public void P(boolean z11) {
        this.N = z11;
    }

    public final void Q() {
        this.f30048f.b();
        this.L = true;
    }

    public void R(int i11) {
        if (i11 == 0) {
            i11 = 1;
        }
        AtomicInteger atomicInteger = this.f30056n;
        if (atomicInteger != null) {
            atomicInteger.set(i11);
        }
    }

    public abstract void T(List<AdsDTO> list);

    public final void U(List<AdsDTO> list, String str) {
        ArrayList<AdsDTO> arrayListH0;
        if (AdManager.h()) {
            z.a().d("ssp", "loadLocalCacheAd == " + GsonUtil.d(list) + "，status == " + str);
        }
        this.I = 2;
        if (s0()) {
            z.a().d("ssp", "loadLocalCacheAd -----> 当前已经有了填充结果");
            return;
        }
        this.f30059q = str;
        if (list != null && !list.isEmpty() && (arrayListH0 = h0(list)) != null && !arrayListH0.isEmpty()) {
            z(list, 2);
            if (!this.K) {
                return;
            }
        }
        if (y0()) {
            return;
        }
        p(TaErrorCode.ERROR_TAKE_AD_FAILED, 2);
    }

    public void V(boolean z11) {
        this.F = z11;
    }

    public void W() {
        this.C.b();
        i();
        this.f30048f.b();
        h();
        this.f30049g = null;
        com.cloud.sdk.commonutil.util.r.c();
        if (!this.f30058p && this.f30046d == 1) {
            A(null, System.currentTimeMillis() - this.B, null, TaErrorCode.CODE_DESTROY_BEFORE_FILLING);
        }
        this.f30046d = 8;
    }

    public void Y(List<AdsDTO> list) {
        s9.a aVar = this.f30049g;
        if (list == null || list.isEmpty() || aVar == null) {
            return;
        }
        AdsDTO adsDTO = list.get(0);
        this.f30046d = 2;
        BidInfo bidInfo = new BidInfo();
        bidInfo.setPrice(adsDTO.getFirstPrice());
        bidInfo.setCodeSeatId(this.f30043a);
        bidInfo.setAdCreativeId(adsDTO.getAdCreativeId());
        bidInfo.setBiddingToken(this.f30052j);
        bidInfo.setCurrency(Constants.CURRENCY.USD);
        Preconditions.d(new b(aVar, bidInfo));
    }

    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final void B(List<AdsDTO> list, String str) {
        if (AdManager.h()) {
            z.a().d("ssp", "loadDefaultAd == " + GsonUtil.d(list));
        }
        this.J = 2;
        if (s0()) {
            z.a().d("ssp", "loadDefaultAd -----> 当前请求已经有了填充结果");
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList<AdsDTO> arrayListH0 = h0(list);
            if (arrayListH0 != null && !arrayListH0.isEmpty()) {
                z(arrayListH0, 3);
                return;
            }
        } else if (this.O) {
            z(new ArrayList(), 3);
            return;
        }
        this.f30060r = str;
        p(TaErrorCode.ERROR_TAKE_AD_FAILED, 3);
    }

    public abstract List<AdsDTO> a0();

    public void c0(List<TaNativeInfo> list) {
    }

    public ConfigCodeSeatDTO d0() {
        return this.f30054l;
    }

    public void e() {
        s9.a aVar = this.f30049g;
        if (aVar != null) {
            z.a().d("ssp", "onTimeOut");
            Preconditions.d(new a(aVar));
        }
    }

    public void f() {
    }

    public void f0(List<AdsDTO> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Collections.sort(list, new h());
    }

    public String g() {
        return this.f30043a;
    }

    public final void h() {
        this.L = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.M.clear();
    }

    public final ArrayList<AdsDTO> h0(List<AdsDTO> list) {
        ArrayList<AdsDTO> arrayList = new ArrayList<>(list);
        Iterator<AdsDTO> it = arrayList.iterator();
        while (it.hasNext()) {
            AdsDTO next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.setTriggerId(this.f30052j);
                String str = next.getImpBeanRequest() == null ? "" : next.getImpBeanRequest().requestId;
                AdxImpBean adxImpBeanH = H();
                if (adxImpBeanH != null) {
                    adxImpBeanH.isTimeOut = this.f30046d == 7 ? 1 : 0;
                    adxImpBeanH.requestTs = Long.valueOf(System.currentTimeMillis());
                    adxImpBeanH.isAutoPlayVideoAd = this.f30067y;
                    adxImpBeanH.requestId = str;
                }
                next.setImpBeanRequest(adxImpBeanH);
            }
        }
        return arrayList;
    }

    public final void i() {
        this.f30047e.b();
    }

    public Map<String, Object> i0() {
        return this.f30064v;
    }

    public final void j() {
        this.f30047e.b();
        this.f30047e.e(this.P);
        this.f30047e.d(this.f30045c);
        this.f30047e.c();
    }

    public int j0() {
        if (a0() == null || a0().isEmpty() || a0().get(0) == null) {
            return -1;
        }
        return a0().get(0).isOfflineAd() ? 1 : 0;
    }

    public final void k() {
        z.a().d("BaseAd", "takeAdToFill status: isFillTimeOut is " + this.L + ",cacheLoadStatus is " + this.I + " ,defaultLoadStatus is " + this.J + ", onLineRequestStatus is " + this.H);
        if (s0() || this.I < 2 || this.J < 2) {
            return;
        }
        if (this.H != 1 || this.L) {
            if (this.L && this.M.isEmpty() && this.H == 1) {
                return;
            }
            if (this.M.isEmpty()) {
                this.E.k(TaErrorCode.ERROR_TAKE_AD_FAILED);
                return;
            }
            f0(this.M);
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            if (this.f30057o > 0) {
                for (AdsDTO adsDTO : this.M) {
                    if (!hashSet.contains(adsDTO.getAdCreativeId())) {
                        hashSet.add(adsDTO.getAdCreativeId());
                        arrayList.add(adsDTO);
                        if (arrayList.size() >= this.f30057o) {
                            break;
                        }
                    }
                }
            }
            M(arrayList);
        }
    }

    public s9.a l() {
        return this.E;
    }

    public String l0() {
        return this.f30062t;
    }

    public void m(double d11) {
    }

    public final void n(int i11) {
        if (i11 < 0) {
            return;
        }
        this.f30048f.b();
        this.f30048f.e(this.Q);
        this.f30048f.d(i11);
        this.f30048f.c();
    }

    public void o(TaErrorCode taErrorCode) {
    }

    public String o0() {
        return this.f30063u;
    }

    public void p(TaErrorCode taErrorCode, int i11) {
        if (i11 == 4) {
            this.f30046d = 5;
            this.E.k(taErrorCode);
            return;
        }
        if (i11 == 1) {
            this.H = 2;
        }
        if (this.K) {
            k();
        } else {
            K(taErrorCode, i11);
        }
    }

    public int p0() {
        if (d0() == null) {
            return 0;
        }
        return d0().getPictureDelayCloseTime();
    }

    public final void q(AdsDTO adsDTO) {
        if (adsDTO == null) {
            List<AdsDTO> listA0 = a0();
            if (listA0 == null || listA0.isEmpty()) {
                return;
            } else {
                adsDTO = listA0.get(0);
            }
        }
        if (adsDTO == null || adsDTO.isOfflineAd()) {
            return;
        }
        b1.c().h(adsDTO);
    }

    public t9.a q0() {
        return this.f30050h;
    }

    public final void r(ConfigCodeSeatDTO configCodeSeatDTO) {
        j jVar;
        z.a().d("BaseAd", "current load -----> code seat id is :" + g());
        if (NetStateManager.checkNetworkState()) {
            this.f30053k = 0;
        } else {
            this.f30053k = 1;
        }
        this.f30054l = configCodeSeatDTO;
        this.f30068z = configCodeSeatDTO == null ? false : configCodeSeatDTO.isOfflineAdEnable();
        int iIntValue = configCodeSeatDTO == null ? this.f30055m : configCodeSeatDTO.getCodeSeatType().intValue();
        this.f30055m = iIntValue;
        AthenaTracker.V(this.f30068z, iIntValue, this.f30052j, this.f30043a, this.f30057o, this.f30053k, this.f30062t, this.f30063u, this.f30064v, 0);
        if (configCodeSeatDTO == null) {
            z.a().d("ssp", "当前代码位不存在 ----->" + this.f30043a);
            if (x.h().l() && !this.O) {
                j jVar2 = this.E;
                if (jVar2 != null) {
                    jVar2.k(TaErrorCode.ERROR_AD_UNIT_CONFIG_IS_EMPTY);
                    return;
                }
                return;
            }
            z.a().d("ssp", "当前代码位不存在 -----> 构建默认云控发起广告请求");
            ConfigCodeSeatDTO configCodeSeatDTO2 = new ConfigCodeSeatDTO();
            configCodeSeatDTO2.setCodeSeatId(this.f30043a);
            configCodeSeatDTO2.setCodeSeatType(Integer.valueOf(this.f30055m));
            configCodeSeatDTO2.setOfflineAdEnable(this.f30068z);
            int i11 = this.G;
            if (i11 >= 0) {
                configCodeSeatDTO2.setFillTimeoutDuration(Integer.valueOf(i11));
            }
            configCodeSeatDTO = w9.d.f79364a.a(configCodeSeatDTO2);
            this.f30054l = configCodeSeatDTO;
        }
        this.K = this.f30054l.getCrosslevelComparison().booleanValue();
        z.a().d("ssp", "crosslevelComparison is " + this.K);
        this.A = configCodeSeatDTO.getLocalOfflineAdCacheCount();
        if (AdManager.h()) {
            com.cloud.sdk.commonutil.util.r.b(String.format(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg1), Boolean.valueOf(configCodeSeatDTO.isOfflineAdEnable()), configCodeSeatDTO.getAdShowCountLimit(), Integer.valueOf(configCodeSeatDTO.getCurrentShowTimes()), Integer.valueOf(configCodeSeatDTO.getCarouselTime()), configCodeSeatDTO.getCarouselCount()), 1);
            b1.c().l(this.f30043a, this.f30053k == 1);
        }
        if (configCodeSeatDTO.getAdShowCountLimit().intValue() > -1 && configCodeSeatDTO.getCurrentShowTimes() >= configCodeSeatDTO.getAdShowCountLimit().intValue()) {
            z.a().d("ssp", "当前代码位展示次数达到上限 ----- 已展示次数=" + configCodeSeatDTO.getCurrentShowTimes() + "  展示上限=" + configCodeSeatDTO.getAdShowCountLimit());
            j jVar3 = this.E;
            if (jVar3 != null) {
                jVar3.k(TaErrorCode.ERROR_AD_IMPRESSION_LIMIT);
                return;
            }
            return;
        }
        if (this.f30053k == 1 || this.O) {
            z.a().d("ssp", "judge load offline, isOfflineAdEnable " + configCodeSeatDTO.isOfflineAdEnable());
            j();
            this.H = 2;
            if (z0() || (jVar = this.E) == null) {
                return;
            }
            jVar.k(TaErrorCode.ERROR_NETWORK_NOT_CONNECTED);
            return;
        }
        if (!this.C.l(H(), this.f30054l)) {
            this.E.k(TaErrorCode.ERROR_UNKNOWN);
            return;
        }
        this.H = 1;
        j();
        int iIntValue2 = configCodeSeatDTO.getFillTimeoutDuration().intValue();
        z.a().d("BaseAd", "fillTimeoutDuration is " + iIntValue2);
        if (iIntValue2 > 0) {
            n(iIntValue2);
        }
        if (iIntValue2 == 0 || this.K) {
            z0();
        }
    }

    public int r0() {
        if (d0() == null) {
            return 0;
        }
        return d0().getVideoDelayCloseTime();
    }

    public boolean s0() {
        int i11 = this.f30046d;
        if (i11 != 7 && i11 != 2 && i11 != 3 && i11 != 4 && i11 != 5 && i11 != 8 && i11 != 6) {
            return false;
        }
        z.a().d("ssp", "The loadAd call have delivered,current status is: " + this.f30046d);
        return true;
    }

    public boolean t0() {
        return this.F;
    }

    public boolean u0() {
        return this.f30046d == 8;
    }

    public boolean v0() {
        List<AdsDTO> listA0 = a0();
        if (listA0 == null || listA0.isEmpty()) {
            return false;
        }
        return listA0.get(0).isMatchVulgarBrand();
    }

    public void w(String str) {
        this.f30043a = str;
        this.C.i(str);
    }

    public void w0() {
        Preconditions.d(new c());
    }

    public void x(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        int i11 = this.f30046d;
        if (i11 == 1 || i11 == 8) {
            return;
        }
        this.f30062t = str;
        this.f30063u = str2;
        this.f30064v = map;
    }

    public void x0() {
        h();
        boolean zL = x.h().l();
        z.a().d("ssp", "loadAdInternal isConfigInit " + zL);
        if (zL) {
            r(x.h().c(this.f30043a));
        } else {
            com.cloud.sdk.commonutil.util.i.f30292a.b(new d());
        }
    }

    public final void y(List<AdsDTO> list) {
        this.M.addAll(list);
        k();
    }

    public final boolean y0() {
        a0 a0Var = a0.f29085a;
        if (!a0Var.x()) {
            z.a().d("BaseAd", "loadDefaultAd -----> 默认广告未开启");
            this.J = 2;
            return false;
        }
        if (s0() || this.J > 0) {
            return false;
        }
        if (AdManager.h()) {
            com.cloud.sdk.commonutil.util.r.b(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg13), 2);
        }
        this.J = 1;
        z.a().d("BaseAd", "start to load default ad");
        a0Var.f(this.f30055m, this.f30043a, this.f30057o, this.N, this.f30053k, new a0.a() { // from class: com.cloud.hisavana.sdk.o2
            @Override // com.cloud.hisavana.sdk.a0.a
            public final void a(List list, String str) {
                this.f29955a.O(list, str);
            }
        });
        return true;
    }

    public void z(List<AdsDTO> list, int i11) {
        if (i11 == 1) {
            this.H = 2;
        }
        if (this.K) {
            y(list);
        } else {
            M(list);
        }
    }

    public final boolean z0() {
        if (!this.K) {
            this.f30048f.b();
        }
        if (s0() || this.I > 0) {
            return false;
        }
        boolean z11 = this.f30053k == 1;
        if (this.O || (z11 && !this.f30068z)) {
            this.I = 2;
            return y0();
        }
        this.f30059q = "";
        if (AdManager.h()) {
            com.cloud.sdk.commonutil.util.r.b(com.cloud.sdk.commonutil.util.f.a().getString(R$string.ssp_log_msg10), 2);
        }
        z.a().d("BaseAd", "start to load cache ad");
        this.I = 1;
        b1.c().k(this.f30043a, this.f30057o, z11, null, new e());
        return true;
    }
}
