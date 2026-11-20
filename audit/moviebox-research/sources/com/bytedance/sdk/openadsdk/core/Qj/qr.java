package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.transsion.gslb.Worker;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    private sc Qj;
    private List<com.bytedance.sdk.openadsdk.core.model.Sfl> TRI;
    private PAGBannerAdLoadListener We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.model.Sfl> f28087qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private AdSlot f28088sc;
    private final Context zY;
    private final AtomicBoolean ExN = new AtomicBoolean(false);
    private int Ol = 5;
    private final OXF WH = OXF.zY();
    private final com.bytedance.sdk.openadsdk.core.Sfl pFF = com.bytedance.sdk.openadsdk.core.Xc.zY();

    /* JADX INFO: compiled from: source.java */
    public interface sc {
    }

    private qr(Context context) {
        if (context != null) {
            this.zY = context.getApplicationContext();
        } else {
            this.zY = com.bytedance.sdk.openadsdk.core.Xc.sc();
        }
    }

    private PAGBannerAd sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (this.Ol == 1) {
            return sfl.GI() != null ? new com.bytedance.sdk.openadsdk.core.zY.TRI(this.zY, sfl, this.f28088sc) : new com.bytedance.sdk.openadsdk.core.zY.We(this.zY, sfl, this.f28088sc);
        }
        return null;
    }

    @Nullable
    private PAGBannerAd sc(OXF oxf) {
        Iterator<com.bytedance.sdk.openadsdk.core.model.Sfl> it = this.f28087qr.iterator();
        PAGBannerAd pAGBannerAdSc = null;
        while (it.hasNext() && (pAGBannerAdSc = sc(it.next())) == null) {
        }
        return pAGBannerAdSc;
    }

    public static qr sc(Context context) {
        return new qr(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc() {
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> list = this.TRI;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> list2 = this.f28087qr;
        if (list2 != null) {
            list2.clear();
        }
    }

    private void sc(int i11) {
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> list = this.TRI;
        com.bytedance.sdk.openadsdk.SR.zY.sc().sc(com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc(this.Ol).zY(this.f28088sc.getCodeId()).ExN((list == null || list.size() <= 0) ? "" : this.TRI.get(0).ofL()).pFF(i11).TRI(com.bytedance.sdk.openadsdk.core.Qj.sc(i11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11, String str) {
        if (this.ExN.getAndSet(false)) {
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.We;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i11, str);
            }
            sc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> list = this.TRI;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.model.Sfl sfl : list) {
            if (com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl) && sfl.GI() != null && sfl.GI().q() != null) {
                if (com.bytedance.sdk.openadsdk.core.Xc.We().ExN(String.valueOf(sfl.QT())) && com.bytedance.sdk.openadsdk.core.Xc.We().OKY()) {
                    com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = com.bytedance.sdk.openadsdk.core.model.Sfl.sc(CacheDirFactory.getICacheDir(sfl.Flm()).zY(), sfl);
                    pffSc.sc("material_meta", sfl);
                    pffSc.sc("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.Ql.ExN.sc.sc(pffSc, null);
                }
            }
        }
    }

    private void sc(final AdSlot adSlot, com.bytedance.sdk.openadsdk.common.TRI tri) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.Dl dl2 = new com.bytedance.sdk.openadsdk.core.model.Dl();
        dl2.Qj = 2;
        this.pFF.sc(adSlot, dl2, this.Ol, new com.bytedance.sdk.openadsdk.core.Sfl.sc() { // from class: com.bytedance.sdk.openadsdk.core.Qj.qr.1
            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(int i11, String str) {
                qr.this.sc(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Sfl.sc
            public void sc(final com.bytedance.sdk.openadsdk.core.model.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
                if (scVar.We() == null || scVar.We().isEmpty()) {
                    qr.this.sc(-3, com.bytedance.sdk.openadsdk.core.Qj.sc(-3));
                    pff.sc(-3);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
                    return;
                }
                qr.this.TRI = scVar.We();
                qr.this.f28087qr = scVar.We();
                qr.this.sc(adSlot);
                if (com.bytedance.sdk.component.utils.Tf.We()) {
                    Log.e("ExpressAdLoadManager", "onAdLoad: net work response duration = " + qr.this.WH.We() + "run in  " + Thread.currentThread().getName());
                }
                if (qr.this.ExN.getAndSet(false)) {
                    Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.qr.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (qr.this.f28087qr != null && qr.this.f28087qr.size() > 0) {
                                qr qrVar = qr.this;
                                qrVar.sc(scVar, qrVar.WH, jElapsedRealtime);
                                if (qr.this.Qj != null) {
                                    sc unused = qr.this.Qj;
                                    List unused2 = qr.this.f28087qr;
                                }
                            } else if (qr.this.Qj != null) {
                                sc unused3 = qr.this.Qj;
                            }
                            qr.this.sc();
                        }
                    });
                }
            }
        });
    }

    private void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, final long j11, final long j12, final long j13) {
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl;
        try {
            if (com.bytedance.sdk.openadsdk.core.Xc.We().qfG() && com.bytedance.sdk.openadsdk.YIK.sc.We()) {
                try {
                    if (this.Ol != 1 || scVar == null || scVar.We() == null || scVar.We().isEmpty() || scVar.sc() == null || (sfl = scVar.We().get(0)) == null) {
                        return;
                    }
                    final JSONObject jSONObjectSc = scVar.sc();
                    com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), sfl, jSONObjectSc.optString("tag", ""), "load_ad_time", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.core.Qj.qr.2
                        @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                        public JSONObject sc() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                long jOptLong = jSONObjectSc.optLong("callback_start", 0L);
                                long j14 = j12;
                                long j15 = j14 - jOptLong;
                                long j16 = j13 - j14;
                                long jOptLong2 = jSONObjectSc.optLong("duration", 0L);
                                JSONObject jSONObjectOptJSONObject = jSONObjectSc.optJSONObject("extra_data");
                                if (jSONObjectOptJSONObject == null) {
                                    jSONObjectOptJSONObject = new JSONObject();
                                }
                                jSONObjectOptJSONObject.put("thread_dispatch_duration", j15);
                                jSONObjectOptJSONObject.put("build_banner_ad_duration", j16);
                                jSONObjectOptJSONObject.put("ad_load_duration_full", j11);
                                jSONObject.put("duration", jOptLong2);
                                jSONObject.put("ad_extra_data", jSONObjectOptJSONObject.toString());
                                if (com.bytedance.sdk.component.utils.Tf.We()) {
                                    com.bytedance.sdk.component.utils.Tf.sc("ExpressAdLoadManager", "reportAdLoadTime: result = ".concat(String.valueOf(jSONObject)));
                                }
                            } catch (Throwable unused) {
                            }
                            return jSONObject;
                        }
                    });
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, OXF oxf, long j11) {
        if (this.We != null) {
            PAGBannerAd pAGBannerAdSc = sc(oxf);
            if (pAGBannerAdSc == null) {
                this.We.onError(Worker.WHAT_SYNC_DATA, com.bytedance.sdk.openadsdk.core.Qj.sc(Worker.WHAT_SYNC_DATA));
                sc(Worker.WHAT_SYNC_DATA);
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jWe = this.WH.We();
            if (!TextUtils.isEmpty(this.f28088sc.getBidAdm())) {
                com.bytedance.sdk.openadsdk.SR.zY.sc(this.f28087qr.get(0), jWe);
            }
            this.We.onAdLoaded(pAGBannerAdSc);
            sc(scVar, jWe, j11, jElapsedRealtime);
        }
    }

    public void sc(AdSlot adSlot, int i11, @NonNull com.bytedance.sdk.openadsdk.common.TRI tri, int i12) {
        sc(adSlot, i11, tri, null, i12);
    }

    public void sc(AdSlot adSlot, int i11, @Nullable com.bytedance.sdk.openadsdk.common.TRI tri, @Nullable sc scVar, int i12) {
        this.WH.ExN();
        if (this.ExN.get()) {
            com.bytedance.sdk.component.utils.Tf.sc("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.Ol = i11;
        this.ExN.set(true);
        this.f28088sc = adSlot;
        if (tri instanceof PAGBannerAdLoadListener) {
            this.We = (PAGBannerAdLoadListener) tri;
        }
        this.Qj = scVar;
        sc(adSlot, tri);
    }
}
