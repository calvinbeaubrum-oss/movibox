package com.cloud.hisavana.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f29744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2 f29745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdsDTO f29746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29747d = false;

    /* JADX INFO: compiled from: source.java */
    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1 f29748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<s9.a> f29749b;

        public a(h1 h1Var, s9.a aVar) {
            this.f29748a = h1Var;
            this.f29749b = new WeakReference<>(aVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            h1 h1Var;
            z.a().d("InterGemini", "fc_problem_onReceive,intent: " + intent);
            if (intent == null || (action = intent.getAction()) == null || this.f29748a == null) {
                return;
            }
            if (action.equals(this.f29748a.g() + "_click")) {
                z.a().d("InterGemini", "receive interstitial click");
                AdsDTO adsDTO = (AdsDTO) intent.getParcelableExtra("mAdBean");
                if (adsDTO != null) {
                    this.f29748a.f29746c = adsDTO;
                    this.f29748a.f29745b.P0(adsDTO);
                }
                AthenaTracker.Y(adsDTO);
                if (this.f29749b.get() != null) {
                    this.f29749b.get().a();
                    return;
                }
                return;
            }
            if (!action.equals(this.f29748a.g() + "_close")) {
                if (action.equals(this.f29748a.g() + "_error")) {
                    z.a().d("InterGemini", "receive interstitial error");
                    if (this.f29749b.get() != null) {
                        this.f29749b.get().h(new TaErrorCode(intent.getIntExtra(TrackingKey.ERROR_CODE, -1), intent.getStringExtra("error_msg")));
                    }
                } else {
                    if (action.equals(this.f29748a.g() + "_show")) {
                        z.a().d("InterGemini", "receive interstitial show");
                        if (this.f29749b.get() != null) {
                            this.f29749b.get().g();
                            return;
                        }
                        return;
                    }
                    if (action.equals(this.f29748a.g() + "_pre_imp")) {
                        z.a().d("InterGemini", "receive interstitial pre impression");
                        return;
                    }
                    if (!action.equals(this.f29748a.g() + "_destroy")) {
                        return;
                    }
                    z.a().d("InterGemini", "receive interstitial ad_destroy");
                    h1Var = this.f29748a;
                    if (h1Var == null) {
                        return;
                    }
                }
                h1Var.k();
                this.f29748a.f29744a = null;
            }
            z.a().d("InterGemini", "receive interstitial ad_close");
            AdsDTO adsDTO2 = (AdsDTO) intent.getParcelableExtra("mAdBean");
            if (adsDTO2 != null) {
                this.f29748a.f29746c = adsDTO2;
                this.f29748a.f29745b.P0(adsDTO2);
            }
            if (this.f29749b.get() == null) {
                return;
            } else {
                this.f29749b.get().b();
            }
            h1Var = this.f29748a;
            h1Var.k();
            this.f29748a.f29744a = null;
        }
    }

    public h1(l2 l2Var) {
        this.f29745b = l2Var;
    }

    public void d() {
        k();
        z.a().d("InterGemini", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    public void e(AdsDTO adsDTO) {
        this.f29746c = adsDTO;
        if (adsDTO == null) {
            z.a().d("InterGemini", "show() --> mAdBean == null");
        } else {
            j();
        }
    }

    public final String g() {
        if (this.f29746c == null) {
            return null;
        }
        return com.cloud.sdk.commonutil.util.f.c() + "_adx_" + this.f29746c.getId();
    }

    public final void h() {
        IntentFilter intentFilter = new IntentFilter();
        String strG = g();
        intentFilter.addAction(strG + "_click");
        intentFilter.addAction(strG + "_close");
        intentFilter.addAction(strG + "_show");
        intentFilter.addAction(strG + "_pre_imp");
        intentFilter.addAction(strG + "_error");
        intentFilter.addAction(strG + "_destroy");
        if (Build.VERSION.SDK_INT >= 33) {
            com.cloud.sdk.commonutil.util.f.a().registerReceiver(this.f29744a, intentFilter, 2);
        } else {
            com.cloud.sdk.commonutil.util.f.a().registerReceiver(this.f29744a, intentFilter);
        }
        z.a().d("InterGemini", "registerInterstitialAdReceiver");
    }

    public final void j() {
        z.a().d("InterGemini", "interstitial showNormalAd");
        if (this.f29744a == null) {
            this.f29744a = new a(this, this.f29745b.l());
        }
        h();
        AdsDTO adsDTO = this.f29746c;
        if (adsDTO != null) {
            adsDTO.setCloseDelayTime(this.f29745b.G(adsDTO));
        }
        Intent intent = new Intent(com.cloud.sdk.commonutil.util.f.a(), (Class<?>) TAdInterstitialActivity.class);
        intent.setFlags(268500992);
        intent.putExtra("mAdBean", this.f29746c);
        intent.putExtra("BroadCastPrefix", g());
        com.cloud.sdk.commonutil.util.f.a().startActivity(intent);
    }

    public final void k() {
        if (this.f29744a != null) {
            com.cloud.sdk.commonutil.util.f.a().unregisterReceiver(this.f29744a);
            this.f29744a = null;
        }
    }
}
