package hn;

import android.os.Bundle;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseBanner;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a extends c<BaseBanner, BaseBanner> {
    public a(CloudControlConfig.CodeSeat codeSeat, i iVar, s sVar) {
        super(codeSeat, iVar, sVar);
    }

    @Override // hn.c
    public AdCache<BaseBanner> I() {
        return AdCacheManager.getCache(2);
    }

    @Override // hn.c
    public boolean d0() {
        return true;
    }

    @Override // hn.c
    public boolean e0() {
        return false;
    }

    @Override // hn.c
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void o(BaseBanner baseBanner) {
        if (baseBanner == null || I().hasAd(this.f66559j, baseBanner)) {
            return;
        }
        baseBanner.destroyAd();
    }

    @Override // hn.c
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void z(BaseBanner baseBanner) {
        if (baseBanner != null) {
            baseBanner.pauseAd();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [C, com.hisavana.common.interfacz.ICacheAd] */
    @Override // hn.c
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public BaseBanner c(boolean z11) {
        Bundle bundle;
        ?? cache = I().getCache(this.f66559j, false, U(), z11);
        this.f66558i = cache;
        if (cache == 0) {
            AdLogUtil.Log().w("BannerCacheHandler", "no ad");
            return null;
        }
        I().removeCache(this.f66559j, (BaseBanner) this.f66558i);
        if (((BaseBanner) this.f66558i).isExpired()) {
            AdLogUtil.Log().w("InterstitialCacheHandler", "ad is expired");
            return null;
        }
        TInnerAdRequestBody tInnerAdRequestBodyA = a(null, 2);
        ((BaseBanner) this.f66558i).addRequestBody(tInnerAdRequestBodyA);
        Bundle bundle2 = ((BaseBanner) this.f66558i).mBundle;
        if (bundle2 != null && (bundle = this.A) != null) {
            bundle2.putString(TrackingKey.TRIGGER_ID, bundle.getString(TrackingKey.TRIGGER_ID));
            ((BaseBanner) this.f66558i).mBundle.putLong(TrackingKey.TRIGGER_TS, this.A.getLong(TrackingKey.TRIGGER_TS));
        }
        ((BaseBanner) this.f66558i).setShowId(DeviceUtil.n());
        i(tInnerAdRequestBodyA, this.f66551b);
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg(RecordTestInfo.getLogMsg((BaseBanner) this.f66558i) + "  isSupportFlag = " + U(), RecordTestInfo.LOG_CODE12);
        }
        return (BaseBanner) this.f66558i;
    }

    @Override // hn.c
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void H(BaseBanner baseBanner) {
        if (baseBanner != null) {
            baseBanner.resumeAd();
        }
    }
}
