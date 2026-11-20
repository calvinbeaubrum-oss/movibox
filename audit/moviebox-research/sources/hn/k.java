package hn;

import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseInterstitial;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.mock.RecordTestInfo;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k extends c<BaseInterstitial, BaseInterstitial> {
    public k(CloudControlConfig.CodeSeat codeSeat, i iVar, s sVar) {
        super(codeSeat, iVar, sVar);
    }

    @Override // hn.c
    @NonNull
    public AdCache<BaseInterstitial> I() {
        return AdCacheManager.getCache(3);
    }

    @Override // hn.c
    public boolean d0() {
        return true;
    }

    @Override // hn.c
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void o(BaseInterstitial baseInterstitial) {
        if (baseInterstitial == null || I().hasAd(this.f66559j, baseInterstitial)) {
            return;
        }
        baseInterstitial.destroyAd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [C, com.hisavana.common.interfacz.ICacheAd] */
    @Override // hn.c
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public BaseInterstitial c(boolean z11) {
        ?? cache = I().getCache(this.f66559j, false, U(), z11);
        this.f66558i = cache;
        if (cache == 0) {
            AdLogUtil.Log().w("InterstialCacheHandler", "no ad");
            return null;
        }
        I().removeCache(this.f66559j, (BaseInterstitial) this.f66558i);
        if (((BaseInterstitial) this.f66558i).isExpired()) {
            AdLogUtil.Log().w("InterstialCacheHandler", "ad is expired");
            return null;
        }
        TInnerAdRequestBody tInnerAdRequestBodyA = a(null, 2);
        ((BaseInterstitial) this.f66558i).addRequestBody(tInnerAdRequestBodyA);
        ((BaseInterstitial) this.f66558i).setShowId(DeviceUtil.n());
        i(tInnerAdRequestBodyA, this.f66551b);
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg(RecordTestInfo.getLogMsg((BaseInterstitial) this.f66558i) + "  isSupportFlag = " + U(), RecordTestInfo.LOG_CODE12);
        }
        return (BaseInterstitial) this.f66558i;
    }
}
