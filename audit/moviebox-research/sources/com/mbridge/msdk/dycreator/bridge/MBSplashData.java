package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBSplashData implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DyOption f43610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f43611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f43613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CampaignEx f43615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f43618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f43619j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f43620k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f43610a = dyOption;
        this.f43615f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.f43612c;
    }

    public String getAppInfo() {
        return this.f43611b;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public CampaignEx getBindData() {
        return this.f43615f;
    }

    public int getClickType() {
        return this.f43620k;
    }

    public String getCountDownText() {
        return this.f43613d;
    }

    public DyOption getDyOption() {
        return this.f43610a;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public DyOption getEffectData() {
        return this.f43610a;
    }

    public int getLogoImage() {
        return this.f43617h;
    }

    public String getLogoText() {
        return this.f43614e;
    }

    public int getNoticeImage() {
        return this.f43616g;
    }

    public float getxInScreen() {
        return this.f43618i;
    }

    public float getyInScreen() {
        return this.f43619j;
    }

    public void setAdClickText(String str) {
        this.f43612c = str;
    }

    public void setAppInfo(String str) {
        this.f43611b = str;
    }

    public void setClickType(int i11) {
        this.f43620k = i11;
    }

    public void setCountDownText(String str) {
        this.f43613d = str;
    }

    public void setLogoImage(int i11) {
        this.f43617h = i11;
    }

    public void setLogoText(String str) {
        this.f43614e = str;
    }

    public void setNoticeImage(int i11) {
        this.f43616g = i11;
    }

    public void setxInScreen(float f11) {
        this.f43618i = f11;
    }

    public void setyInScreen(float f11) {
        this.f43619j = f11;
    }
}
