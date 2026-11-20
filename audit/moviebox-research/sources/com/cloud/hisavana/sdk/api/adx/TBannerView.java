package com.cloud.hisavana.sdk.api.adx;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$styleable;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.j2;
import com.cloud.hisavana.sdk.z;
import java.util.Map;
import t9.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TBannerView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j2 f29112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Integer f29113b;

    public TBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        String string = null;
        this.f29113b = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AdBannerView);
        for (int i12 = 0; i12 < typedArrayObtainStyledAttributes.getIndexCount(); i12++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i12);
            if (index == R$styleable.AdBannerView_placementId) {
                string = typedArrayObtainStyledAttributes.getString(index);
            }
        }
        if (typedArrayObtainStyledAttributes.getIndexCount() > 0) {
            z.a().d("ssp", "placementId=" + string);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f29112a = new j2(context, this, string);
    }

    public TBannerView(Context context, String str) {
        super(context);
        this.f29113b = null;
        this.f29112a = new j2(context, this, str);
    }

    public void destroy() {
        this.f29112a.W();
    }

    public int getAdSource() {
        j2 j2Var = this.f29112a;
        if (j2Var != null) {
            return j2Var.I0();
        }
        return 1;
    }

    public int getAdStatus() {
        return (this.f29112a == null || !isReady()) ? -1 : 0;
    }

    public double getBidPrice() {
        return this.f29112a.J0();
    }

    @Nullable
    public Integer getCloseTypeUsedForTrack() {
        return this.f29113b;
    }

    public Map<String, Object> getExtInfo() {
        return this.f29112a.i0();
    }

    public int getFillAdType() {
        return this.f29112a.j0();
    }

    public String getGameName() {
        return this.f29112a.l0();
    }

    public String getGameScene() {
        return this.f29112a.o0();
    }

    public a getRequest() {
        return this.f29112a.q0();
    }

    public boolean isAdValid() {
        return this.f29112a.K0();
    }

    public boolean isDefaultAd() {
        j2 j2Var = this.f29112a;
        return j2Var != null && j2Var.L0();
    }

    public boolean isLoaded() {
        return this.f29112a.M0();
    }

    public boolean isMatchVulgarBrand() {
        return this.f29112a.v0();
    }

    public boolean isOfflineAd() {
        j2 j2Var = this.f29112a;
        return j2Var != null && j2Var.N0();
    }

    public boolean isReady() {
        return this.f29112a.O0();
    }

    public void loadAd() {
        this.f29112a.w0();
    }

    public void loadAd(BidInfo bidInfo) {
        j2 j2Var = this.f29112a;
        if (j2Var != null) {
            j2Var.V0(bidInfo);
        }
    }

    public void setAdLoadScenes(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f29112a.x(str, str2, map);
    }

    public void setBidding(boolean z11) {
        this.f29112a.E(z11);
    }

    public void setCloseDirectlyWithoutJumping(boolean z11) {
        this.f29112a.d1(z11);
    }

    public void setCloseTypeUsedForTrack(Integer num) {
        this.f29113b = num;
    }

    public void setContainVulgarContent(boolean z11) {
        this.f29112a.P(z11);
    }

    public void setCurrActivityFullscreen(boolean z11) {
        this.f29112a.V(z11);
    }

    public void setDefaultFillTimeoutDuration(int i11) {
        this.f29112a.J(i11);
    }

    public void setHideAdCloseView(boolean z11) {
        this.f29112a.g1(z11);
    }

    public void setListener(s9.a aVar) {
        j2 j2Var = this.f29112a;
        if (j2Var == null) {
            return;
        }
        j2Var.C(aVar);
    }

    public void setPlacementId(String str) {
        j2 j2Var = this.f29112a;
        if (j2Var == null) {
            return;
        }
        j2Var.w(str);
    }

    public void setRequest(a aVar) {
        this.f29112a.D(aVar);
    }

    public void show() {
        this.f29112a.S0();
    }
}
