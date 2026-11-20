package com.cloud.hisavana.sdk.common.tranmeasure;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.b2;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f29471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f29472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f29474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29475e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29476f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f29477g;

    /* JADX INFO: compiled from: source.java */
    public class a implements Preconditions.a {
        public a() {
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            if (c.this.f29471a == null || c.this.f29471a.f29480b == 0 || c.this.f29471a.g() == null) {
                return;
            }
            c.this.f29471a.f29480b.a((T) c.this.f29471a.g());
        }
    }

    public c(d dVar) {
        this.f29471a = dVar;
        this.f29472b = g.b(dVar.f29483e);
    }

    public final boolean b() {
        b2 b2Var;
        d dVar = this.f29471a;
        return (dVar == null || (b2Var = dVar.f29483e) == null || this.f29474d < ((long) b2Var.f29199c)) ? false : true;
    }

    public void c() {
        int iD;
        d dVar = this.f29471a;
        if (dVar == null) {
            return;
        }
        View viewF = dVar.f();
        if (this.f29472b == null || this.f29471a.f29483e == null || viewF == null) {
            return;
        }
        if (viewF.getTag(R$id.native_view_source) != null && !TextUtils.equals(Constants.f29411a, viewF.getTag(R$id.native_view_source).toString())) {
            if (viewF.getTag(R$id.native_view_source) != null) {
                z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "session.AdView.Tag" + viewF.getTag(R$id.native_view_source).toString());
                return;
            }
            return;
        }
        if (this.f29471a.i()) {
            return;
        }
        try {
            iD = d();
        } catch (Throwable th2) {
            z.a().w(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, Log.getStackTraceString(th2));
            iD = 0;
        }
        if (iD > 0 && !this.f29471a.h()) {
            d dVar2 = this.f29471a;
            if (dVar2.f29480b != null) {
                dVar2.c(true);
                Preconditions.d(new a());
                AdsDTO adsDTOE = this.f29471a.e();
                if (adsDTOE != null) {
                    int measuredWidth = viewF.getMeasuredWidth();
                    adsDTOE.setViewHeight(viewF.getMeasuredHeight());
                    adsDTOE.setViewWidth(measuredWidth);
                    adsDTOE.setShowReportTimeType(1);
                    com.cloud.hisavana.sdk.f.a(adsDTOE);
                }
            }
        }
        if (iD > this.f29476f) {
            this.f29476f = iD;
            this.f29477g = this.f29472b.f29506b;
        }
        if (iD > 0) {
            if (!this.f29475e) {
                z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "检查View在Window的可见性 返回百分比 --> exposureRatio = " + iD + " totalImpressionTime=" + this.f29474d);
            }
            if (this.f29473c > 0) {
                this.f29474d += SystemClock.uptimeMillis() - this.f29473c;
            }
            this.f29473c = SystemClock.uptimeMillis();
            if (b()) {
                float f11 = iD;
                d dVar3 = this.f29471a;
                if (f11 < dVar3.f29483e.f29197a || this.f29475e) {
                    return;
                }
                this.f29475e = true;
                AdsDTO adsDTOE2 = dVar3.e();
                if (adsDTOE2 != null) {
                    adsDTOE2.setShowReportTimeType(2);
                    adsDTOE2.setActualShowRate(Integer.valueOf(this.f29476f));
                    adsDTOE2.setShowArea(this.f29477g);
                    adsDTOE2.setActualShowTime(Long.valueOf(this.f29474d));
                    if (com.cloud.hisavana.sdk.api.config.a.a(adsDTOE2)) {
                        com.cloud.hisavana.sdk.f.b(adsDTOE2);
                    } else {
                        com.cloud.hisavana.sdk.f.a(adsDTOE2);
                    }
                } else {
                    z.a().d(com.cloud.sdk.commonutil.util.c.MEASURE_TAG, "session.getmKey() instanceof AdsDTO --> false");
                }
                e.c().f(this.f29471a);
            }
        }
    }

    public int d() {
        b2 b2Var;
        g gVar;
        d dVar = this.f29471a;
        if (dVar == null || (b2Var = dVar.f29483e) == null || (gVar = this.f29472b) == null) {
            return 0;
        }
        return gVar.a(b2Var, dVar.f());
    }
}
