package com.hisavana.max.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.base.BaseNativeViewHolder;
import com.hisavana.common.bean.CommonViewBinder;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.max.R;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NativeAdViewHolder extends BaseNativeViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommonViewBinder f41846c;

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void addContentView(View view) {
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void destroy() {
        super.destroy();
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getContainer(TAdNativeInfo tAdNativeInfo, ViewGroup viewGroup) {
        MaxNativeAdViewBinder.Builder builder;
        CommonViewBinder commonViewBinder = this.f41846c;
        if (commonViewBinder == null) {
            return null;
        }
        int i11 = commonViewBinder.layoutId;
        if (i11 > 0) {
            builder = new MaxNativeAdViewBinder.Builder(i11);
        } else {
            WeakReference<View> weakReference = commonViewBinder.layoutReference;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            builder = new MaxNativeAdViewBinder.Builder(this.f41846c.layoutReference.get());
        }
        return new MaxNativeAdView(builder.setTitleTextViewId(this.f41846c.titleId).setBodyTextViewId(this.f41846c.descriptionId).setIconImageViewId(R.id.icon_image_view).setMediaContentViewGroupId(this.f41846c.mediaId).setOptionsContentViewGroupId(this.f41846c.adChoicesView).setCallToActionButtonId(this.f41846c.callToActionId).build(), f.a());
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public View getIconView(Context context) {
        return null;
    }

    @Override // com.hisavana.common.base.BaseNativeViewHolder
    public void setBinderLayoutId(CommonViewBinder commonViewBinder) {
        this.f41846c = commonViewBinder;
    }
}
