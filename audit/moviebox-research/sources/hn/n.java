package hn;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.hisavana.common.base.BaseNative;
import com.hisavana.common.bean.AdCache;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TInnerAdRequestBody;
import com.hisavana.common.manager.AdCacheManager;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class n extends c<BaseNative, ArrayList<TAdNativeInfo>> {
    public int B;

    public n(CloudControlConfig.CodeSeat codeSeat, i iVar, s sVar) {
        super(codeSeat, iVar, sVar);
        this.B = 0;
    }

    @Override // hn.c
    @NonNull
    public AdCache<TAdNativeInfo> I() {
        return AdCacheManager.getCache(this.f66566q);
    }

    @Override // hn.c
    public int L() {
        return this.B;
    }

    @Override // hn.c
    public boolean d0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayList<TAdNativeInfo> q0(int i11, int i12, boolean z11, boolean z12) {
        ArrayList caches = I().getCaches(this.f66559j, i12, z11, this.f66566q == 6, i11, z12);
        AdLogUtil adLogUtilLog = AdLogUtil.Log();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("*---->get ad from cache,size:");
        sb2.append(caches != null ? caches.size() : 0);
        adLogUtilLog.d("NativeCacheHandler", sb2.toString());
        this.B = AdUtil.filterAdByPullOrNew(caches);
        if (caches == null || caches.isEmpty()) {
            AdLogUtil.Log().w("NativeCacheHandler", "get 0 native ad from cache");
            return new ArrayList<>();
        }
        if (z11) {
            t0(caches);
        }
        return caches;
    }

    public final void r0(TAdNativeInfo tAdNativeInfo, s sVar) {
        NativeAdWrapper nativeAdWrapper;
        BaseNative adImpl;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null || (adImpl = nativeAdWrapper.getAdImpl()) == null) {
            return;
        }
        TInnerAdRequestBody tInnerAdRequestBodyA = a(null, 2);
        adImpl.addRequestBody(tInnerAdRequestBodyA);
        i(tInnerAdRequestBodyA, sVar);
    }

    @Override // hn.c
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void o(ArrayList<TAdNativeInfo> arrayList) {
    }

    public void t0(ArrayList<TAdNativeInfo> arrayList) {
        for (TAdNativeInfo tAdNativeInfo : arrayList) {
            if (tAdNativeInfo != null) {
                if (TextUtils.isEmpty(tAdNativeInfo.getShowId())) {
                    tAdNativeInfo.setShowId(DeviceUtil.n());
                }
                r0(tAdNativeInfo, this.f66551b);
            }
        }
    }
}
