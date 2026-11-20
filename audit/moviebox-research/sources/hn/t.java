package hn;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseVideo;
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
public class t extends c<BaseVideo, BaseVideo> {
    public t(CloudControlConfig.CodeSeat codeSeat, i iVar, s sVar) {
        super(codeSeat, iVar, sVar);
    }

    @Override // hn.c
    @NonNull
    public AdCache<BaseVideo> I() {
        return AdCacheManager.getCache(5);
    }

    @Override // hn.c
    public boolean d0() {
        return true;
    }

    @Override // hn.c
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void o(BaseVideo baseVideo) {
        if (baseVideo == null || I().hasAd(this.f66559j, baseVideo)) {
            return;
        }
        baseVideo.destroyAd();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [C, com.hisavana.common.interfacz.ICacheAd] */
    @Override // hn.c
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public BaseVideo c(boolean z11) {
        Bundle bundle;
        ?? cache = I().getCache(this.f66559j, false, U(), z11);
        this.f66558i = cache;
        if (cache == 0) {
            AdLogUtil.Log().w("VideoCacheHandler", "no ad");
            return null;
        }
        I().removeCache(this.f66559j, (BaseVideo) this.f66558i);
        if (((BaseVideo) this.f66558i).isExpired()) {
            AdLogUtil.Log().w("VideoCacheHandler", "ad is expired");
            return null;
        }
        TInnerAdRequestBody tInnerAdRequestBodyA = a(null, 2);
        ((BaseVideo) this.f66558i).addRequestBody(tInnerAdRequestBodyA);
        Bundle bundle2 = ((BaseVideo) this.f66558i).mBundle;
        if (bundle2 != null && (bundle = this.A) != null) {
            bundle2.putString(TrackingKey.TRIGGER_ID, bundle.getString(TrackingKey.TRIGGER_ID));
            ((BaseVideo) this.f66558i).mBundle.putLong(TrackingKey.TRIGGER_TS, this.A.getLong(TrackingKey.TRIGGER_TS));
        }
        ((BaseVideo) this.f66558i).setShowId(DeviceUtil.n());
        i(tInnerAdRequestBodyA, this.f66551b);
        if (LogSwitch.isDebug) {
            RecordTestInfo.LogMsg(RecordTestInfo.getLogMsg((BaseVideo) this.f66558i) + "  isSupportFlag = " + U(), RecordTestInfo.LOG_CODE12);
        }
        return (BaseVideo) this.f66558i;
    }
}
