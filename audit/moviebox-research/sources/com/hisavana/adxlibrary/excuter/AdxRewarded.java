package com.hisavana.adxlibrary.excuter;

import android.app.Activity;
import android.content.Context;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.hisavana.common.base.BaseVideo;
import com.hisavana.common.bean.Network;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.push.PushConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r9.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class AdxRewarded extends BaseVideo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Network f41747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f41749c;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends s9.a {
        public a() {
        }

        @Override // s9.a
        public void a() {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onAdClicked");
            AdxRewarded.this.adClicked(null);
        }

        @Override // s9.a
        public void b() {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onAdClosed");
            AdxRewarded.this.adClosed();
        }

        @Override // s9.a
        public void e() {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onAdLoaded");
            c cVar = AdxRewarded.this.f41749c;
            double dC = cVar != null ? cVar.c() : 0.0d;
            if (dC > 0.0d) {
                AdxRewarded.this.setEcpmPrice(dC);
            }
            AdxRewarded.this.adLoaded();
        }

        @Override // s9.a
        public void g() {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onAdShow");
            AdxRewarded.this.adImpression(null);
        }

        @Override // s9.a
        public void k(TaErrorCode taErrorCode) {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onError : " + taErrorCode);
            if (taErrorCode != null) {
                AdxRewarded.this.adFailedToLoad(new TAdErrorCode(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage()));
            }
        }

        @Override // s9.a
        public void n() {
            AdLogUtil.Log().i(AdxRewarded.this.f41748b, "onRewarded");
            AdxRewarded.this.onReward();
        }
    }

    public AdxRewarded(Context context, Network network) {
        super(context, network);
        this.f41747a = network;
        this.f41748b = "AdxRewarded";
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public void destroyAd() {
        super.destroyAd();
        c cVar = this.f41749c;
        if (cVar != null) {
            cVar.a();
        }
        this.f41749c = null;
        AdLogUtil.Log().d(this.f41748b, PushConstants.PROVIDER_FIELD_DESTROY + getLogString());
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void initVideo() {
        Network network = this.f41747a;
        if (network != null) {
            String codeSeatId = network.getCodeSeatId();
            Intrinsics.f(codeSeatId, "it.codeSeatId");
            c cVar = new c(codeSeatId);
            this.f41749c = cVar;
            cVar.k(t9.a.a().a());
            c cVar2 = this.f41749c;
            if (cVar2 != null) {
                cVar2.h(new a());
            }
        }
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isAdxAd() {
        c cVar = this.f41749c;
        return cVar != null && cVar.b() == 2;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isEwAd() {
        c cVar = this.f41749c;
        return cVar != null && cVar.b() == 1;
    }

    @Override // com.hisavana.common.base.BaseAd, com.hisavana.common.interfacz.ICacheAd
    public boolean isExpired() {
        c cVar;
        return super.isExpired() || !((cVar = this.f41749c) == null || cVar.e());
    }

    @Override // com.hisavana.common.base.BaseVideo, com.hisavana.common.interfacz.IadVideo
    public boolean isLoaded() {
        c cVar = this.f41749c;
        if (cVar != null) {
            return cVar.f();
        }
        return false;
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoShow(Activity activity) {
        t9.a aVarD;
        Unit unit;
        c cVar = this.f41749c;
        if (cVar != null && (aVarD = cVar.d()) != null) {
            double d11 = this.secondPrice;
            if (d11 != 0.0d) {
                aVarD.h(d11);
                c cVar2 = this.f41749c;
                if (cVar2 != null) {
                    cVar2.k(aVarD);
                }
            }
            c cVar3 = this.f41749c;
            if (cVar3 != null) {
                cVar3.l();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        new Function0<Unit>() { // from class: com.hisavana.adxlibrary.excuter.AdxRewarded.onVideoShow.2
            {
                super(0);
            }

            public final void a() {
                AdxRewarded.this.onAdShowError(TAdErrorCode.ERROR_SHOW_EXCEPTION);
                AdLogUtil.Log().w(AdxRewarded.this.f41748b, "rewarded ad or listener is null");
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.f68710a;
            }
        };
    }

    @Override // com.hisavana.common.base.BaseVideo
    public void onVideoStartLoad() {
        t9.a aVarD;
        c cVar = this.f41749c;
        if (cVar == null || cVar.f() || (aVarD = cVar.d()) == null) {
            return;
        }
        aVarD.k(this.requestType);
        aVarD.l("hisa-" + this.mTriggerId);
        aVarD.j("hisa-" + this.mRequestId);
        aVarD.i(getSupportHisavanaFlag() >= 2);
        cVar.k(aVarD);
        cVar.j(this.isContainVulgarContent);
        cVar.i(this.mGameName, this.mGameScene, this.mExtInfo);
        cVar.g();
    }
}
