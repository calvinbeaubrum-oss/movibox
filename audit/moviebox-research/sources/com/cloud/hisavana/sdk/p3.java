package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n2 f29990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<TaNativeInfo> f29991c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f29992d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f29993e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f29994f = -1.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f29995g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<TaNativeInfo, List<View>> f29996h = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AdsDTO f29997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TaNativeInfo f29998b;

        public b(AdsDTO adsDTO, TaNativeInfo taNativeInfo) {
            this.f29997a = adsDTO;
            this.f29998b = taNativeInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z zVarA;
            String str;
            if (view == null || this.f29997a == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (view instanceof AdCloseView) {
                if (jCurrentTimeMillis - h.p().r() >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                    p3.this.f29989a = jCurrentTimeMillis;
                    if (this.f29997a.getSource() != 4) {
                        if (h.p().o(view.getContext(), p3.this.f29990b, this.f29997a, (AdCloseView) view)) {
                            h.p().n(p3.this.f29990b, this.f29998b);
                            return;
                        }
                        return;
                    } else {
                        if (p3.this.f29990b == null || p3.this.f29990b.l() == null) {
                            return;
                        }
                        p3.this.f29990b.l().d(this.f29998b);
                        return;
                    }
                }
                return;
            }
            if (this.f29997a.getPslinkInfo() != null) {
                if (view.getTag() == null || !TextUtils.equals("ad_download", view.getTag().toString())) {
                    this.f29997a.getPslinkInfo().setClickType(1);
                    zVarA = z.a();
                    str = "pslink half setClickType, click_img";
                } else {
                    this.f29997a.getPslinkInfo().setClickType(2);
                    zVarA = z.a();
                    str = "pslink half setClickType, click_install";
                }
                zVarA.d("ssp", str);
            }
            if (jCurrentTimeMillis - p3.this.f29989a > 1000) {
                try {
                    e1.a(view.getContext(), this.f29997a, new DownUpPointBean(p3.this.f29992d, p3.this.f29993e, p3.this.f29994f, p3.this.f29995g, view.getMeasuredHeight(), view.getMeasuredWidth()), p3.this.f29990b == null ? false : p3.this.f29990b.t0());
                    AthenaTracker.Y(this.f29997a);
                    if (p3.this.f29990b != null && p3.this.f29990b.l() != null) {
                        p3.this.f29990b.l().l(this.f29998b);
                    }
                    p3.this.f29989a = jCurrentTimeMillis;
                } catch (Throwable th2) {
                    z.a().e(Log.getStackTraceString(th2));
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                p3.this.f29992d = motionEvent.getX();
                p3.this.f29993e = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            p3.this.f29994f = motionEvent.getX();
            p3.this.f29995g = motionEvent.getY();
            return false;
        }
    }

    public p3(n2 n2Var) {
        this.f29990b = n2Var;
    }

    public void d() {
        o();
        z.a().d("ssp", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    public void e(View view, List<View> list, TaNativeInfo taNativeInfo, AdsDTO adsDTO) {
        if (list != null) {
            this.f29996h.put(taNativeInfo, list);
            c cVar = new c();
            b bVar = new b(adsDTO, taNativeInfo);
            if (view != null) {
                view.setOnTouchListener(cVar);
                view.setOnClickListener(bVar);
            }
            for (View view2 : list) {
                if (view2 != null && !h(view2) && !(view2 instanceof AdChoicesView)) {
                    view2.setOnClickListener(bVar);
                }
            }
        }
    }

    public void f(TaNativeInfo taNativeInfo) {
        n2 n2Var = this.f29990b;
        if (n2Var == null || n2Var.l() == null) {
            return;
        }
        this.f29990b.l().m(taNativeInfo);
        AdsDTO adItem = taNativeInfo == null ? null : taNativeInfo.getAdItem();
        if (adItem == null || adItem.getImpBeanRequest() == null) {
            return;
        }
        x.h().k(adItem.getImpBeanRequest().pmid);
        if (adItem.getSource() == 4) {
            a0.f29085a.m(adItem.getAdCreativeId(), adItem.getCodeSeatId());
        } else if (adItem.isOfflineAd()) {
            adItem.setShowNum(Integer.valueOf(adItem.getShowNum().intValue() + 1));
            b1.c().s(adItem);
        }
    }

    public void g(List<TaNativeInfo> list) {
        this.f29991c = list;
    }

    public final boolean h(View view) {
        if (view == null || view.getTag() == null) {
            return false;
        }
        return view.getTag().equals("adxAdChoice") || view.getTag().equals("image_webview");
    }

    public List<TaNativeInfo> k() {
        return this.f29991c;
    }

    public void l(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null) {
            return;
        }
        List<View> list = this.f29996h.get(taNativeInfo);
        if (w9.e.a(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                }
            }
            this.f29996h.remove(taNativeInfo);
        }
    }

    public final void o() {
        Iterator<Map.Entry<TaNativeInfo, List<View>>> it = this.f29996h.entrySet().iterator();
        while (it.hasNext()) {
            List<View> value = it.next().getValue();
            if (value != null) {
                for (View view : value) {
                    if (view != null) {
                        view.setOnClickListener(null);
                        view.setOnTouchListener(null);
                    }
                }
            }
        }
        this.f29996h.clear();
    }
}
