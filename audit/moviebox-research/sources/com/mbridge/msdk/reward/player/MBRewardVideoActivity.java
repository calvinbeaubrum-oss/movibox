package com.mbridge.msdk.reward.player;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.reward.adapter.RewardUnitCacheManager;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.activity.AbstractJSActivity;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBRewardVideoActivity extends AbstractJSActivity {
    public static String INTENT_EXTRADATA = "extraData";
    public static String INTENT_ISBID = "isBid";
    public static String INTENT_ISBIG_OFFER = "isBigOffer";
    public static String INTENT_ISIV = "isIV";
    public static String INTENT_IVREWARD_MODETYPE = "ivRewardMode";
    public static String INTENT_IVREWARD_VALUE = "ivRewardValue";
    public static String INTENT_IVREWARD_VALUETYPE = "ivRewardValueType";
    public static String INTENT_LOCAL_REQUEST_ID = "lRid";
    public static String INTENT_MUTE = "mute";
    public static String INTENT_REWARD = "reward";
    public static String INTENT_UNITID = "unitId";
    public static String INTENT_USERID = "userId";
    public static String SAVE_STATE_KEY_REPORT = "hasRelease";
    private boolean A;
    private String I;
    private com.mbridge.msdk.foundation.same.report.d.b J;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f46893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f46894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f46896d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46902j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private h f46905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f46906n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f46909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CampaignEx f46910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<com.mbridge.msdk.videocommon.download.a> f46911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<CampaignEx> f46912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MBTempContainer f46913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MBridgeBTContainer f46914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private WindVaneWebView f46915w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.video.bt.module.a.a f46916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f46917y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f46918z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46897e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46898f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f46899g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f46903k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f46904l = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f46907o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f46908p = false;
    private int B = 1;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private boolean K = false;
    private com.mbridge.msdk.video.dynview.e.a M = new com.mbridge.msdk.video.dynview.e.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.1
        @Override // com.mbridge.msdk.video.dynview.e.a
        public final void a(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            if (map.containsKey(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                MBRewardVideoActivity.this.f46897e = ((Integer) map.get(CampaignEx.JSON_NATIVE_VIDEO_MUTE)).intValue();
            }
            if (map.containsKey(RequestParameters.POSITION)) {
                int iIntValue = ((Integer) map.get(RequestParameters.POSITION)).intValue();
                if (MBRewardVideoActivity.this.f46912t == null || MBRewardVideoActivity.this.f46912t.size() <= 0 || iIntValue < 1) {
                    return;
                }
                MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
                mBRewardVideoActivity.f46910r = (CampaignEx) mBRewardVideoActivity.f46912t.get(iIntValue);
                MBRewardVideoActivity.b(MBRewardVideoActivity.this);
                int i11 = iIntValue - 1;
                if (MBRewardVideoActivity.this.f46912t.get(i11) != null) {
                    MBRewardVideoActivity.this.C -= ((CampaignEx) MBRewardVideoActivity.this.f46912t.get(i11)).getVideoLength();
                }
                MBRewardVideoActivity mBRewardVideoActivity2 = MBRewardVideoActivity.this;
                MBRewardVideoActivity.this.f46910r.setVideoCompleteTime(mBRewardVideoActivity2.a(mBRewardVideoActivity2.f46910r.getVideoCompleteTime(), MBRewardVideoActivity.this.B));
                MBRewardVideoActivity.this.f46910r.setShowIndex(MBRewardVideoActivity.this.B);
                MBRewardVideoActivity.this.f46910r.setShowType(1);
                MBRewardVideoActivity mBRewardVideoActivity3 = MBRewardVideoActivity.this;
                mBRewardVideoActivity3.a(mBRewardVideoActivity3.f46910r);
            }
        }
    };
    private d N = new d() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.2
        @Override // com.mbridge.msdk.video.dynview.e.d
        public final void a() {
            if (MBRewardVideoActivity.this.f46914v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b(MBRewardVideoActivity.this.f46914v, 500L);
            }
            MBRewardVideoActivity.this.f46903k = true;
            MBRewardVideoActivity.this.b();
            if (MBRewardVideoActivity.this.f46913u != null) {
                MBRewardVideoActivity.this.f46913u.setNotchPadding(MBRewardVideoActivity.this.H, MBRewardVideoActivity.this.D, MBRewardVideoActivity.this.F, MBRewardVideoActivity.this.E, MBRewardVideoActivity.this.G);
            }
        }

        @Override // com.mbridge.msdk.video.dynview.e.d
        public final void a(CampaignEx campaignEx) {
            if (campaignEx == null) {
                MBRewardVideoActivity.this.a("campaign is null");
                return;
            }
            if (MBRewardVideoActivity.this.f46914v != null) {
                new com.mbridge.msdk.video.dynview.h.b().b(MBRewardVideoActivity.this.f46914v, 500L);
            }
            MBRewardVideoActivity.this.f46910r = campaignEx;
            MBRewardVideoActivity.this.f46910r.setShowType(2);
            MBRewardVideoActivity mBRewardVideoActivity = MBRewardVideoActivity.this;
            mBRewardVideoActivity.a(mBRewardVideoActivity.f46910r);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f46923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f46924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f46925c;

        public a(List<com.mbridge.msdk.videocommon.download.a> list, String str, String str2) {
            this.f46923a = list;
            this.f46924b = str;
            this.f46925c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f46923a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f46923a) {
                    if (aVar != null && aVar.l() != null) {
                        CampaignEx campaignExL = aVar.l();
                        try {
                            AppletModelManager.getInstance().remove(campaignExL);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                ad.a("MBRewardVideoActivity", "AppletModelManager remove error", e11);
                            }
                        }
                        String str = campaignExL.getRequestId() + campaignExL.getId() + campaignExL.getVideoUrlEncode();
                        j jVarC = com.mbridge.msdk.videocommon.download.b.getInstance().c(this.f46924b);
                        if (jVarC != null) {
                            try {
                                jVarC.b(str);
                            } catch (Exception e12) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("DownLoadManager", e12.getMessage());
                                }
                            }
                        }
                        if (campaignExL.getRewardTemplateMode() != null) {
                            if (!TextUtils.isEmpty(campaignExL.getRewardTemplateMode().e())) {
                                com.mbridge.msdk.videocommon.a.b(this.f46924b + "_" + campaignExL.getId() + "_" + this.f46925c + "_" + campaignExL.getRewardTemplateMode().e());
                                com.mbridge.msdk.videocommon.a.b(campaignExL.getAdType(), campaignExL);
                            }
                            if (!TextUtils.isEmpty(campaignExL.getCMPTEntryUrl())) {
                                com.mbridge.msdk.videocommon.a.b(this.f46924b + "_" + this.f46925c + "_" + campaignExL.getCMPTEntryUrl());
                            }
                            com.mbridge.msdk.videocommon.a.a.a().a(campaignExL);
                        }
                    }
                }
            } catch (Exception e13) {
                ad.a("MBRewardVideoActivity", e13.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.mbridge.msdk.videocommon.download.a> f46926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f46927b;

        public b(String str, List<com.mbridge.msdk.videocommon.download.a> list) {
            this.f46926a = list;
            this.f46927b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                List<com.mbridge.msdk.videocommon.download.a> list = this.f46926a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f46926a) {
                    if (aVar != null && aVar.l() != null) {
                        com.mbridge.msdk.videocommon.a.a.a().a(aVar.l(), this.f46927b);
                    }
                }
            } catch (Throwable th2) {
                ad.b("MBRewardVideoActivity", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i11, int i12) {
        List<CampaignEx> list = this.f46912t;
        if (list == null || list.size() == 0) {
            return i11;
        }
        int videoLength = 0;
        int videoCompleteTime = 0;
        for (int i13 = 0; i13 < this.f46912t.size(); i13++) {
            if (this.f46912t.get(0) != null) {
                if (i13 == 0) {
                    videoCompleteTime = this.f46912t.get(0).getVideoCompleteTime();
                }
                videoLength += this.f46912t.get(i13).getVideoLength();
            }
        }
        if (i12 == 1) {
            if (i11 == 0) {
                if (videoLength >= 45) {
                    return 45;
                }
            } else if (videoLength > i11) {
                if (i11 > 45) {
                    return 45;
                }
                return i11;
            }
            return videoLength;
        }
        int videoLength2 = 0;
        for (int i14 = 0; i14 < i12 - 1; i14++) {
            if (this.f46912t.get(i14) != null) {
                videoLength2 += this.f46912t.get(i14).getVideoLength();
            }
        }
        if (videoCompleteTime > videoLength2) {
            return videoCompleteTime - videoLength2;
        }
        return 0;
    }

    private void a() {
        try {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.f46893a, this.f46898f ? 287 : 94);
            if (bitmapDrawableA != null) {
                ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                ai.a(imageView, bitmapDrawableA, getResources().getDisplayMetrics());
                ((ViewGroup) ((ViewGroup) ((ViewGroup) viewGroup.getChildAt(0)).getChildAt(1)).getChildAt(0)).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx) {
        CampaignEx campaignExL;
        try {
            List<com.mbridge.msdk.videocommon.download.a> list = this.f46911s;
            if (list != null && list.size() > 0) {
                for (com.mbridge.msdk.videocommon.download.a aVar : this.f46911s) {
                    if (aVar != null && (campaignExL = aVar.l()) != null && TextUtils.equals(campaignExL.getId(), campaignEx.getId()) && TextUtils.equals(campaignExL.getRequestId(), campaignEx.getRequestId())) {
                        this.f46909q = aVar;
                    }
                }
            }
            this.f46903k = true;
            b();
            MBTempContainer mBTempContainer = this.f46913u;
            if (mBTempContainer != null) {
                mBTempContainer.setNotchPadding(this.H, this.D, this.F, this.E, this.G);
            }
        } catch (Exception e11) {
            ad.b("MBRewardVideoActivity", e11.getMessage());
            a("more offer to one offer exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        ad.b("MBRewardVideoActivity", str);
        b(this.f46912t);
        h hVar = this.f46905m;
        if (hVar != null) {
            hVar.a(this.J, str);
        }
        finish();
    }

    private void a(List<CampaignEx> list) {
        if (list == null) {
            a("no available campaign");
            return;
        }
        if (list.size() == 0) {
            a("no available campaign");
            return;
        }
        if (list.get(0) != null) {
            int dynamicTempCode = list.get(0).getDynamicTempCode();
            this.I = list.get(0).getCurrentLocalRid();
            if (dynamicTempCode == 5) {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        this.C += campaignEx.getVideoLength();
                    }
                }
                CampaignEx campaignEx2 = list.get(0);
                if (campaignEx2 == null) {
                    a("campaign is less");
                    return;
                }
                int iA = a(campaignEx2.getVideoCompleteTime(), this.B);
                this.f46910r = campaignEx2;
                campaignEx2.setCampaignIsFiltered(true);
                this.B = 1;
                this.f46910r.setVideoCompleteTime(iA);
                this.f46910r.setShowIndex(this.B);
                this.f46910r.setShowType(1);
                a(this.f46910r);
                return;
            }
        }
        c();
    }

    public static /* synthetic */ int b(MBRewardVideoActivity mBRewardVideoActivity) {
        int i11 = mBRewardVideoActivity.B;
        mBRewardVideoActivity.B = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<CampaignEx> list;
        RewardPlus rewardPlus;
        CampaignEx campaignEx;
        List<CampaignEx> list2;
        int iFindID = findID("mbridge_temp_container");
        if (iFindID < 0) {
            a("no id mbridge_bt_container in mbridge_more_offer_activity layout");
        }
        MBTempContainer mBTempContainer = (MBTempContainer) findViewById(iFindID);
        this.f46913u = mBTempContainer;
        if (mBTempContainer == null) {
            a("env error");
        }
        List<CampaignEx> list3 = this.f46912t;
        if (list3 == null || list3.size() <= 0 || !this.f46912t.get(0).isDynamicView()) {
            this.f46913u.setVisibility(0);
        } else {
            new com.mbridge.msdk.video.dynview.h.b().c(this.f46913u, 500L);
        }
        changeHalfScreenPadding(-1);
        this.f46913u.setActivity(this);
        this.f46913u.setBidCampaign(this.f46899g);
        this.f46913u.setBigOffer(this.f46903k);
        this.f46913u.setUnitId(this.f46893a);
        this.f46913u.setCampaign(this.f46910r);
        if (this.f46910r.getDynamicTempCode() == 5 && (list2 = this.f46912t) != null && list2.size() > 1) {
            View viewFindViewById = findViewById(findID("mbridge_reward_root_container"));
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.f46913u.removeAllViews();
            this.f46913u.setCampOrderViewData(this.f46912t, this.C);
            this.f46913u.setCamPlayOrderCallback(this.M, this.B);
        }
        this.f46913u.setCampaignDownLoadTask(this.f46909q);
        this.f46913u.setIV(this.f46898f);
        CampaignEx campaignEx2 = this.f46910r;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2) {
            this.f46913u.setIVRewardEnable(this.f46900h, this.f46901i, this.f46902j);
        } else {
            this.f46913u.setIVRewardEnable(0, 0, 0);
        }
        this.f46913u.setMute(this.f46897e);
        CampaignEx campaignEx3 = this.f46910r;
        if (((campaignEx3 != null && (rewardPlus = campaignEx3.getRewardPlus()) != null) || ((list = this.f46912t) != null && list.size() > 0 && this.f46912t.get(0) != null && (rewardPlus = this.f46912t.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f46896d = cVar;
        }
        this.f46913u.setReward(this.f46896d);
        this.f46913u.setRewardUnitSetting(this.f46906n);
        this.f46913u.setPlacementId(this.f46894b);
        this.f46913u.setUserId(this.f46895c);
        this.f46913u.setShowRewardListener(this.f46905m);
        this.f46913u.setDeveloperExtraData(this.f46918z);
        this.f46913u.init(this);
        this.f46913u.onCreate();
        if (!com.mbridge.msdk.f.b.a() || (campaignEx = this.f46910r) == null) {
            return;
        }
        b(campaignEx);
    }

    private void b(CampaignEx campaignEx) {
    }

    private void b(List<CampaignEx> list) {
        CampaignEx campaignEx;
        if (this.L) {
            return;
        }
        if (list == null) {
            try {
                if (this.f46903k) {
                    list = this.f46912t;
                } else {
                    list = new ArrayList<>();
                    List<com.mbridge.msdk.videocommon.download.a> list2 = this.f46911s;
                    if (list2 != null && list2.get(0) != null && this.f46911s.get(0).l() != null) {
                        list.add(this.f46911s.get(0).l());
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        String currentLocalRid = "";
        if (list != null && !list.isEmpty() && (campaignEx = list.get(0)) != null) {
            currentLocalRid = campaignEx.getCurrentLocalRid();
        }
        if (!TextUtils.isEmpty(currentLocalRid)) {
            this.J = com.mbridge.msdk.foundation.same.report.d.c.a().b(currentLocalRid);
        }
        if (this.J == null) {
            this.J = new com.mbridge.msdk.foundation.same.report.d.b();
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46893a);
            dVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(this.f46899g ? 1 : 0));
            dVar.a("adtp", Integer.valueOf(this.f46898f ? 287 : 94));
            dVar.a("lrid", this.I);
            dVar.a("his_reason", "show campaign is null");
            this.J.a("2000129", dVar);
        }
        if (list != null) {
            this.J.b(list);
        }
        this.L = true;
        com.mbridge.msdk.reward.c.a.a.a().a("2000129", this.J);
    }

    private void c() {
        RewardPlus rewardPlus;
        List<CampaignEx> list;
        int iFindID = findID("mbridge_bt_container");
        if (iFindID < 0) {
            a("no mbridge_webview_framelayout in mbridge_more_offer_activity layout");
        }
        MBridgeBTContainer mBridgeBTContainer = (MBridgeBTContainer) findViewById(iFindID);
        this.f46914v = mBridgeBTContainer;
        if (mBridgeBTContainer == null) {
            a("env error");
        }
        this.f46914v.setVisibility(0);
        com.mbridge.msdk.video.bt.module.a.a aVarD = d();
        this.f46916x = aVarD;
        this.f46914v.setBTContainerCallback(aVarD);
        this.f46914v.setShowRewardVideoListener(this.f46905m);
        this.f46914v.setChoiceOneCallback(this.N);
        this.f46914v.setCampaigns(this.f46912t);
        this.f46914v.setCampaignDownLoadTasks(this.f46911s);
        this.f46914v.setRewardUnitSetting(this.f46906n);
        this.f46914v.setUnitId(this.f46893a);
        this.f46914v.setPlacementId(this.f46894b);
        this.f46914v.setUserId(this.f46895c);
        this.f46914v.setActivity(this);
        CampaignEx campaignEx = this.f46910r;
        if (((campaignEx != null && (rewardPlus = campaignEx.getRewardPlus()) != null) || (this.f46912t.get(0) != null && (rewardPlus = this.f46912t.get(0).getRewardPlus()) != null)) && !TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
            c cVar = new c(rewardPlus.getName(), rewardPlus.getAmount());
            if (cVar.b() < 0) {
                cVar.a(1);
            }
            this.f46896d = cVar;
        }
        this.f46914v.setReward(this.f46896d);
        this.f46914v.setIVRewardEnable(this.f46900h, this.f46901i, this.f46902j);
        this.f46914v.setIV(this.f46898f);
        this.f46914v.setMute(this.f46897e);
        this.f46914v.setJSFactory((com.mbridge.msdk.video.signal.factory.b) this.jsFactory);
        this.f46914v.setDeveloperExtraData(this.f46918z);
        this.f46914v.init(this);
        this.f46914v.onCreate(this.K);
        if (!com.mbridge.msdk.f.b.a() || (list = this.f46912t) == null || list.size() <= 0 || this.f46912t.get(0) == null) {
            return;
        }
        b(this.f46912t.get(0));
    }

    private void c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getImageUrl());
            }
            if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getIconUrl());
        }
    }

    private com.mbridge.msdk.video.bt.module.a.a d() {
        if (this.f46916x == null) {
            this.f46916x = new com.mbridge.msdk.video.bt.module.a.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.3
                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a() {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(MBRewardVideoActivity.this.J);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(int i11, String str, String str2) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(i11, str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(String str) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(MBRewardVideoActivity.this.J, str);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(String str, String str2) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z11, int i11) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(z11, i11);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z11, c cVar) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(MBRewardVideoActivity.this.J, z11, cVar);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void a(boolean z11, String str, String str2) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.a(z11, str, str2);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.a
                public final void b(String str, String str2) {
                    if (MBRewardVideoActivity.this.f46905m != null) {
                        MBRewardVideoActivity.this.f46905m.b(str, str2);
                    }
                }
            };
        }
        return this.f46916x;
    }

    public void changeHalfScreenPadding(int i11) {
        try {
            CampaignEx campaignEx = this.f46910r;
            if (campaignEx == null || campaignEx.getAdSpaceT() != 2) {
                return;
            }
            getWindow().getDecorView().setBackground(new ColorDrawable(0));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f46913u.getLayoutParams();
            int iA = ai.a(this, 58.0f);
            int iA2 = ai.a(this, 104.0f);
            if (this.f46910r.getRewardTemplateMode().b() == 0) {
                if (i11 == 2) {
                    layoutParams.setMargins(iA2, iA, iA2, iA);
                } else {
                    layoutParams.setMargins(iA, iA2, iA, iA2);
                }
            } else if (this.f46910r.getRewardTemplateMode().b() == 2) {
                layoutParams.setMargins(iA2, iA, iA2, iA);
            } else {
                layoutParams.setMargins(iA, iA2, iA, iA2);
            }
            this.f46913u.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            ad.b("MBRewardVideoActivity", th2.getMessage());
        }
    }

    public int findID(String str) {
        return v.a(getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return v.a(getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        com.mbridge.msdk.foundation.controller.c.m().b(0);
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f46913u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f46914v = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f46893a);
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onBackPressed();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onBackPressed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f46913u != null) {
            changeHalfScreenPadding(configuration.orientation);
            this.f46913u.onConfigurationChanged(configuration);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        List<com.mbridge.msdk.videocommon.download.a> list;
        String cMPTEntryUrl = "";
        super.onCreate(bundle);
        MBridgeConstans.isRewardActivityShowing = true;
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        try {
            Intent intent = getIntent();
            this.f46893a = intent.getStringExtra(INTENT_UNITID);
            this.f46894b = intent.getStringExtra(MBridgeConstans.PLACEMENT_ID);
            this.f46896d = c.b(intent.getStringExtra(INTENT_REWARD));
            this.f46895c = intent.getStringExtra(INTENT_USERID);
            this.f46897e = intent.getIntExtra(INTENT_MUTE, 2);
            this.f46898f = intent.getBooleanExtra(INTENT_ISIV, false);
            com.mbridge.msdk.foundation.controller.c.m().b(this.f46898f ? 287 : 94);
            this.f46899g = intent.getBooleanExtra(INTENT_ISBID, false);
            this.f46918z = intent.getStringExtra(INTENT_EXTRADATA);
            boolean booleanExtra = intent.getBooleanExtra("is_refactor", false);
            this.K = booleanExtra;
            if (booleanExtra) {
                this.f46905m = MBridgeGlobalCommon.showRewardListener;
            } else {
                this.f46905m = com.mbridge.msdk.reward.b.a.f46786f.get(this.f46893a);
            }
            if (this.f46898f) {
                this.f46900h = intent.getIntExtra(INTENT_IVREWARD_MODETYPE, 0);
                this.f46901i = intent.getIntExtra(INTENT_IVREWARD_VALUETYPE, 0);
                this.f46902j = intent.getIntExtra(INTENT_IVREWARD_VALUE, 0);
            }
            this.f46903k = intent.getBooleanExtra(INTENT_ISBIG_OFFER, false);
            this.f46911s = com.mbridge.msdk.videocommon.download.b.getInstance().b(this.f46893a);
            this.f46912t = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f46893a);
            int iFindLayout = findLayout("mbridge_more_offer_activity");
            if (iFindLayout < 0) {
                a("no mbridge_more_offer_activity layout");
                return;
            }
            setContentView(iFindLayout);
            if (TextUtils.isEmpty(this.f46893a)) {
                a("data empty error");
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this);
            this.jsFactory = bVar;
            registerJsFactory(bVar);
            if (this.f46905m == null) {
                a("showRewardListener is null");
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = RewardUnitCacheManager.getInstance().get(this.f46894b, this.f46893a);
            this.f46906n = cVar;
            if (cVar == null) {
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46893a);
                this.f46906n = cVarA;
                if (cVarA == null) {
                    this.f46906n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46893a, this.f46898f);
                }
            }
            com.mbridge.msdk.videocommon.d.c cVar2 = this.f46906n;
            if (cVar2 != null) {
                this.f46896d.a(cVar2.m());
                this.f46896d.a(this.f46906n.n());
            }
            c cVar3 = this.f46896d;
            if (cVar3 != null && cVar3.b() <= 0) {
                this.f46896d.a(1);
            }
            int iA = v.a(this, "mbridge_reward_activity_open", "anim");
            int iA2 = v.a(this, "mbridge_reward_activity_stay", "anim");
            if (iA > 1 && iA2 > 1) {
                overridePendingTransition(iA, iA2);
            }
            if (bundle != null) {
                try {
                    this.f46908p = bundle.getBoolean(SAVE_STATE_KEY_REPORT);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            ad.a("DynamicViewCampaignResourceDownloader", "进入 show，大模板 " + this.f46903k);
            if (!this.f46903k) {
                List<com.mbridge.msdk.videocommon.download.a> list2 = this.f46911s;
                if (list2 != null && list2.size() > 0) {
                    this.f46909q = this.f46911s.get(0);
                }
                com.mbridge.msdk.videocommon.download.a aVar = this.f46909q;
                if (aVar != null) {
                    this.f46910r = aVar.l();
                    this.f46909q.e(true);
                    this.f46909q.f(false);
                    CampaignEx campaignEx = this.f46910r;
                    if (campaignEx != null) {
                        this.I = campaignEx.getCurrentLocalRid();
                        this.f46910r.setShowIndex(1);
                        this.f46910r.setShowType(1);
                        com.mbridge.msdk.reward.b.a.f46783b = this.f46910r.getEcppv();
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f46910r.getMaitve(), this.f46910r.getMaitve_src());
                    }
                }
                if (this.f46909q == null || this.f46910r == null || this.f46896d == null) {
                    a("data empty error");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f46910r);
                b(arrayList);
                b();
                if (com.mbridge.msdk.f.b.a()) {
                    return;
                }
                a();
                return;
            }
            b(this.f46912t);
            this.f46917y = "";
            List<CampaignEx> list3 = this.f46912t;
            if (list3 != null && list3.size() > 0) {
                CampaignEx campaignEx2 = this.f46912t.get(0);
                cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                this.f46917y = campaignEx2.getRequestId();
                this.I = campaignEx2.getCurrentLocalRid();
                com.mbridge.msdk.reward.b.a.f46783b = campaignEx2.getEcppv();
                com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx2.getMaitve(), campaignEx2.getMaitve_src());
            }
            com.mbridge.msdk.videocommon.a.C0532a c0532aA = com.mbridge.msdk.videocommon.a.a(this.f46893a + "_" + this.f46917y + "_" + cMPTEntryUrl);
            WindVaneWebView windVaneWebViewA = c0532aA != null ? c0532aA.a() : null;
            this.f46915w = windVaneWebViewA;
            if (windVaneWebViewA == null) {
                if (this.f46909q == null && (list = this.f46911s) != null && list.size() > 0) {
                    this.f46909q = this.f46911s.get(0);
                }
                if (this.f46909q == null) {
                    com.mbridge.msdk.videocommon.download.b bVar2 = com.mbridge.msdk.videocommon.download.b.getInstance();
                    int i11 = this.f46898f ? 287 : 94;
                    String str = this.f46893a;
                    boolean z11 = this.f46899g;
                    j jVarC = bVar2.c(str);
                    this.f46909q = jVarC != null ? jVarC.b(i11, z11) : null;
                }
                com.mbridge.msdk.videocommon.download.a aVar2 = this.f46909q;
                if (aVar2 != null) {
                    this.f46910r = aVar2.l();
                    this.f46909q.e(true);
                    this.f46909q.f(false);
                }
                if (this.f46909q != null && this.f46910r != null && this.f46896d != null) {
                    this.f46903k = false;
                    List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46912t);
                    if (listA == null) {
                        a("no available campaign");
                        return;
                    }
                    int size = listA.size();
                    if (size == 0) {
                        a("no available campaign");
                        return;
                    }
                    if (listA.get(0) == null || !(this.K || listA.get(0).isDynamicView())) {
                        b();
                    } else if (size == 1) {
                        CampaignEx campaignEx3 = listA.get(0);
                        this.f46910r = campaignEx3;
                        if (campaignEx3 != null) {
                            this.I = campaignEx3.getCurrentLocalRid();
                            this.f46910r.setCampaignIsFiltered(true);
                        }
                        a(this.f46910r);
                    } else {
                        a(listA);
                    }
                }
                a("data empty error");
                return;
            }
            c();
            if (com.mbridge.msdk.f.b.a()) {
                return;
            }
            a();
        } catch (Throwable th2) {
            b(this.f46912t);
            a("onCreate error" + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000151", this.f46910r);
        try {
            h hVar = this.f46905m;
            if (hVar instanceof com.mbridge.msdk.video.bt.module.b.b) {
                com.mbridge.msdk.video.bt.module.b.b bVar = (com.mbridge.msdk.video.bt.module.b.b) hVar;
                if (!bVar.f47510b && !bVar.f47511c) {
                    hVar.a(this.J, "show fail : unexpected destroy");
                }
            }
        } catch (Throwable th2) {
            ad.b("MBRewardVideoActivity", th2.getMessage());
        }
        com.mbridge.msdk.video.module.b.b.a(this.f46893a);
        try {
            List<CampaignEx> list = this.f46912t;
            if (list != null && list.size() > 0) {
                Iterator<CampaignEx> it = this.f46912t.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
            CampaignEx campaignEx = this.f46910r;
            if (campaignEx != null) {
                c(campaignEx);
            }
        } catch (Throwable th3) {
            ad.b("MBRewardVideoActivity", th3.getMessage());
        }
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onDestroy();
            this.f46913u = null;
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onDestroy();
            this.f46914v = null;
        }
        this.M = null;
        this.N = null;
        com.mbridge.msdk.foundation.d.b.a().c(this.f46893a + "_1");
        com.mbridge.msdk.foundation.d.b.a().c(this.f46893a + "_2");
        com.mbridge.msdk.foundation.same.f.b.b().execute(new a(this.f46911s, this.f46893a, this.f46917y));
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onPause();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onRestart();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onRestart();
        }
    }

    @Override // com.mbridge.msdk.video.signal.activity.AbstractJSActivity, com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.mbridge.msdk.foundation.d.b.f44150c) {
            return;
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        try {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new b(this.f46893a, this.f46911s));
        } catch (Throwable th2) {
            ad.b("MBRewardVideoActivity", th2.getMessage());
        }
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onResume();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(SAVE_STATE_KEY_REPORT, this.f46908p);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (com.mbridge.msdk.foundation.d.b.f44150c) {
            return;
        }
        new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.reward.player.MBRewardVideoActivity.4
            @Override // com.mbridge.msdk.foundation.d.a
            public final void a() {
                MBRewardVideoActivity.this.onPause();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void a(String str) {
                MBRewardVideoActivity.this.onResume();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void b() {
                MBRewardVideoActivity.this.onResume();
            }
        };
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onStart();
            this.f46910r.setCampaignUnitId(this.f46893a);
            com.mbridge.msdk.foundation.d.b.a().a(this.f46893a + "_1", this.f46910r);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStart();
            List<CampaignEx> list = this.f46912t;
            if (list != null && list.size() > 0) {
                CampaignEx campaignEx = this.f46912t.get(0);
                campaignEx.setCampaignUnitId(this.f46893a);
                com.mbridge.msdk.foundation.d.b.a().a(this.f46893a + "_1", campaignEx);
            }
        }
        if (this.A) {
            return;
        }
        com.mbridge.msdk.foundation.d.b.a().a(this.f46893a + "_1", 1);
        com.mbridge.msdk.foundation.d.b.a().c(this.f46893a + "_2");
        this.A = true;
    }

    @Override // android.app.Activity
    public void onStop() {
        MBridgeConstans.isRewardActivityShowing = false;
        super.onStop();
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.onStop();
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i11) {
        super.setTheme(v.a(this, "mbridge_transparent_theme", TtmlNode.TAG_STYLE));
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i11, int i12, int i13, int i14, int i15) {
        this.D = i12;
        this.F = i13;
        this.E = i14;
        this.G = i15;
        this.H = i11;
        MBTempContainer mBTempContainer = this.f46913u;
        if (mBTempContainer != null) {
            mBTempContainer.setNotchPadding(i11, i12, i13, i14, i15);
        }
        MBridgeBTContainer mBridgeBTContainer = this.f46914v;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.setNotchPadding(i11, i12, i13, i14, i15);
        }
        com.mbridge.msdk.video.dynview.a.a.f47537e = i11;
        com.mbridge.msdk.video.dynview.a.a.f47533a = i12;
        com.mbridge.msdk.video.dynview.a.a.f47534b = i13;
        com.mbridge.msdk.video.dynview.a.a.f47535c = i14;
        com.mbridge.msdk.video.dynview.a.a.f47536d = i15;
    }
}
