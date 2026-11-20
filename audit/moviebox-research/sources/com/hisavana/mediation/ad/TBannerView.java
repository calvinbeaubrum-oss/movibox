package com.hisavana.mediation.ad;

import android.content.Context;
import android.util.AttributeSet;
import com.hisavana.common.base.WrapTadView;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.utils.AdLogUtil;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TBannerView extends WrapTadView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TBannerAd f41869a;

    public TBannerView(Context context) {
        this(context, null);
    }

    public TBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public TBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41869a = null;
        this.f41869a = new TBannerAd(context, this);
    }

    public void destroy() {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.destroy();
        }
    }

    public void enterScene(String str, int i11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.enterScene(str, i11);
        }
    }

    public void loadAd() {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.loadAd();
        }
    }

    public void pause() {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.pause();
        }
    }

    public void resume() {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.resume();
        }
    }

    public void setAdLoadScenes(String str, String str2, Map<String, Object> map) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setAdLoadScenes(str, str2, map);
        }
    }

    public void setAdSize(int i11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.c(i11);
        }
    }

    public void setAdUnitId(String str) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setAdUnitId(str);
        }
    }

    public void setAdWidth(int i11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.d(i11);
        }
    }

    public void setBannerType(int i11) {
        if (i11 >= 0 && i11 <= 2) {
            TBannerAd tBannerAd = this.f41869a;
            if (tBannerAd != null) {
                tBannerAd.setBannerType(i11);
                return;
            }
            return;
        }
        AdLogUtil.Log().d("TBannerView", "setBannerType --> invalid banner type " + i11);
    }

    public void setCloseDirectlyWithoutJumping(boolean z11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setCloseDirectlyWithoutJumping(z11);
        }
    }

    public void setContainVulgarContent(boolean z11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setContainVulgarContent(z11);
        }
    }

    public void setCurrActivityFullscreen(boolean z11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setCurrActivityFullscreen(z11);
        }
    }

    public void setHideAdCloseView(boolean z11) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setHideAdCloseView(z11);
        }
    }

    public void setRequestBody(TAdRequestBody tAdRequestBody) {
        TBannerAd tBannerAd = this.f41869a;
        if (tBannerAd != null) {
            tBannerAd.setRequestBody(tAdRequestBody);
        }
    }
}
