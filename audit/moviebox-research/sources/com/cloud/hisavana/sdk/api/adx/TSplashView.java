package com.cloud.hisavana.sdk.api.adx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.u1;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.Map;
import s9.c;
import t9.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TSplashView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f29114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f29115b;

    public TSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TSplashView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f29115b = relativeLayout;
        addView(relativeLayout, -1, -1);
        this.f29114a = new u1(context, relativeLayout, "");
    }

    public TSplashView(Context context, String str) {
        super(context, null);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f29115b = relativeLayout;
        addView(relativeLayout, -1, -1);
        this.f29114a = new u1(context, relativeLayout, str);
    }

    public void destroy() {
        this.f29114a.W();
    }

    public int getAdSource() {
        u1 u1Var = this.f29114a;
        if (u1Var != null) {
            return u1Var.Q0();
        }
        return 1;
    }

    public int getAdStatus() {
        return !isReady() ? -1 : 0;
    }

    public double getBidPrice() {
        return this.f29114a.R0();
    }

    public Map<String, Object> getExtInfo() {
        return this.f29114a.i0();
    }

    public int getFillAdType() {
        return this.f29114a.j0();
    }

    public String getGameName() {
        return this.f29114a.l0();
    }

    public String getGameScene() {
        return this.f29114a.o0();
    }

    public a getRequest() {
        return this.f29114a.q0();
    }

    public boolean isAdValid() {
        return this.f29114a.T0();
    }

    public boolean isDefaultAd() {
        u1 u1Var = this.f29114a;
        return u1Var != null && u1Var.U0();
    }

    public boolean isMatchVulgarBrand() {
        return this.f29114a.v0();
    }

    public boolean isOfflineAd() {
        u1 u1Var = this.f29114a;
        return u1Var != null && u1Var.W0();
    }

    public boolean isReady() {
        u1 u1Var = this.f29114a;
        return u1Var != null && u1Var.X0();
    }

    public void loadAd() {
        this.f29114a.w0();
    }

    public void loadAd(BidInfo bidInfo) {
        u1 u1Var = this.f29114a;
        if (u1Var != null) {
            u1Var.l1(bidInfo);
        }
    }

    public void setAdLoadScenes(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f29114a.x(str, str2, map);
    }

    public void setBidding(boolean z11) {
        this.f29114a.E(z11);
    }

    public void setContainVulgarContent(boolean z11) {
        this.f29114a.P(z11);
    }

    public void setCurrActivityFullscreen(boolean z11) {
        this.f29114a.V(z11);
    }

    public void setDefaultFillTimeoutDuration(int i11) {
        this.f29114a.J(i11);
    }

    public void setListener(s9.a aVar) {
        this.f29114a.C(aVar);
    }

    public void setLogoLayout(View view) {
        this.f29114a.g1(view);
    }

    public void setPlacementId(String str) {
        this.f29114a.w(str);
    }

    public void setRequest(a aVar) {
        this.f29114a.D(aVar);
    }

    public void setSkipListener(c cVar) {
        this.f29114a.q1(cVar);
    }

    public void show() {
        Preconditions.a();
        this.f29114a.B1();
    }
}
