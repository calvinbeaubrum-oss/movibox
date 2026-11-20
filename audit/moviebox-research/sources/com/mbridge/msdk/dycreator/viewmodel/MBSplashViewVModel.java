package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBSplashViewVModel implements BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f43693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f43694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f43695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f43696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DynamicViewBackListener f43697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DyOption f43698f;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43699a;

        static {
            int[] iArr = new int[EAction.values().length];
            f43699a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43699a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MBSplashViewVModel(DyOption dyOption) {
        this.f43698f = dyOption;
        String campaignUnitId = (dyOption == null || dyOption.getCampaignEx() == null) ? "" : dyOption.getCampaignEx().getCampaignUnitId();
        if (TextUtils.isEmpty(campaignUnitId)) {
            EventBus.getDefault().register(this);
        } else {
            EventBus.getDefault().register(campaignUnitId, this);
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        if (this.f43697e == null || splashResData == null) {
            return;
        }
        int i11 = AnonymousClass1.f43699a[splashResData.geteAction().ordinal()];
        if (i11 == 1 || i11 == 2) {
            try {
                String campaignUnitId = "";
                if (splashResData.getBaseViewData() != null && splashResData.getBaseViewData().getBindData() != null) {
                    campaignUnitId = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
                }
                if (TextUtils.isEmpty(campaignUnitId)) {
                    EventBus.getDefault().unregister(this);
                    b.a().b();
                } else {
                    EventBus.getDefault().unregister(campaignUnitId);
                    b.a().b();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                EventBus.getDefault().unregister(this);
                EventBus.getDefault().release();
                b.a().b();
            }
        }
        this.f43697e.viewClicked(splashResData);
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f43694b = cVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f43693a = dVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f43697e = dynamicViewBackListener;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f43695c = fVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setModelDataAndBind() {
        MBSplashData mBSplashData = new MBSplashData(this.f43698f);
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC != null) {
            DyOption dyOption = this.f43698f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                mBSplashData.setCountDownText(contextC.getResources().getString(v.a(contextC, this.f43698f.isCanSkip() ? "mbridge_splash_count_time_can_skip" : "mbridge_splash_count_time_can_skip_not", "string")));
            }
            mBSplashData.setNoticeImage(v.a(contextC, "mbridge_splash_notice", "drawable"));
            String strS = z.s(contextC);
            mBSplashData.setLogoText((TextUtils.isEmpty(strS) || !strS.contains("zh")) ? "AD" : "广告");
        }
        d dVar = this.f43693a;
        if (dVar != null) {
            dVar.a(mBSplashData);
        }
        c cVar = this.f43694b;
        if (cVar != null) {
            cVar.a(mBSplashData);
        }
        f fVar = this.f43695c;
        if (fVar != null) {
            fVar.a(mBSplashData);
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f43696d = hVar;
        }
    }
}
