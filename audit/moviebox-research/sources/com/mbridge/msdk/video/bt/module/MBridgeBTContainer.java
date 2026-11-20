package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.dynview.e.d;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeBTContainer extends AbstractJSContainer implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f47428a = "MBridgeBTContainer";
    private boolean A;
    private String B;
    private boolean C;
    private List<CampaignEx> D;
    private List<com.mbridge.msdk.videocommon.download.a> E;
    private com.mbridge.msdk.video.bt.module.a.a F;
    private h G;
    private h H;
    private com.mbridge.msdk.video.bt.module.a.b I;
    private String J;
    private String K;
    private String L;
    private boolean M;
    private int N;
    private String O;
    private d P;
    private com.mbridge.msdk.foundation.same.report.d.b Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f47429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f47430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f47431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MBridgeBTLayout f47432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WindVaneWebView f47433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LayoutInflater f47434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f47435h;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f47436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f47437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f47438z;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<CampaignEx> f47443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f47444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f47445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f47446d;

        public a(List<CampaignEx> list, Context context, String str, String str2) {
            this.f47443a = list;
            this.f47444b = context;
            this.f47445c = str;
            this.f47446d = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<CampaignEx> list = this.f47443a;
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                f.a(com.mbridge.msdk.foundation.db.h.a(this.f47444b)).a(this.f47445c, this.f47443a);
                com.mbridge.msdk.videocommon.a.a.a().c(this.f47446d, this.f47443a.get(0).getAdType());
            } catch (Exception unused) {
                ad.a(MBridgeBTContainer.f47428a, "remove campaign failed");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends com.mbridge.msdk.video.signal.a.a.C0531a {
        private b() {
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a() {
            super.a();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(int i11, String str) {
            super.a(i11, str);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(boolean z11) {
            super.a(z11);
            MBridgeBTContainer.this.H.a(z11, ((AbstractJSContainer) MBridgeBTContainer.this).f48402k, ((AbstractJSContainer) MBridgeBTContainer.this).f48401j);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void b() {
            super.b();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            ah.a(campaign, MBridgeBTContainer.this.f47431d);
            if (campaign == null || !(campaign instanceof CampaignEx)) {
                return;
            }
            try {
                CampaignEx campaignEx = (CampaignEx) campaign;
                String strOptString = new JSONObject(MBridgeBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(NotificationCompat.CATEGORY_PROGRESS, "");
                if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals("1.0") && ((AbstractJSContainer) MBridgeBTContainer.this).f48400i != null) {
                    if (MBridgeBTContainer.this.A) {
                        MBridgeBTContainer.this.onAdClose();
                    } else {
                        ((AbstractJSContainer) MBridgeBTContainer.this).f48400i.finish();
                    }
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            ah.a(campaign, MBridgeBTContainer.this.f47431d);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0531a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            ah.b(campaign, MBridgeBTContainer.this.f47431d);
        }
    }

    public MBridgeBTContainer(Context context) {
        super(context);
        this.f47429b = 0;
        this.f47430c = 1;
        this.f47438z = false;
        this.A = true;
        this.C = false;
        init(context);
    }

    public MBridgeBTContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47429b = 0;
        this.f47430c = 1;
        this.f47438z = false;
        this.A = true;
        this.C = false;
        init(context);
    }

    public static /* synthetic */ void a(MBridgeBTContainer mBridgeBTContainer, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                HashMap map = new HashMap();
                List<com.mbridge.msdk.foundation.entity.d> listA = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getCampaignUnitId(), campaignEx.getRequestId());
                if (listA == null || listA.size() <= 0 || listA.get(0) == null) {
                    return;
                }
                int iC = listA.get(0).c();
                String strB = listA.get(0).b();
                if (iC == 1) {
                    map.put("encrypt_p=", "encrypt_p=" + strB);
                    map.put("irlfa=", "irlfa=1");
                    for (Map.Entry entry : map.entrySet()) {
                        campaignEx.setOnlyImpressionURL(campaignEx.getOnlyImpressionURL().replaceAll((String) entry.getKey(), (String) entry.getValue()));
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    private com.mbridge.msdk.video.bt.module.a.b c() {
        if (this.I == null) {
            this.I = new com.mbridge.msdk.video.bt.module.a.b() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.3
                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f48402k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, ((AbstractJSContainer) MBridgeBTContainer.this).f48401j);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onAdShow " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewPlayStart", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, int i11, String str2, String str3) {
                    if (MBridgeBTContainer.this.G != null) {
                        MBridgeBTContainer.this.G.a(i11, str2, str3);
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, ((AbstractJSContainer) MBridgeBTContainer.this).f48402k);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, ((AbstractJSContainer) MBridgeBTContainer.this).f48401j);
                            jSONObject2.put("error", str2);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onShowFail " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewPlayFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onVideoAdClicked " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(String str, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            if (cVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("name", cVar.a());
                                jSONObject3.put("amount", cVar.b());
                                jSONObject2.put("reward", jSONObject3);
                            }
                            jSONObject2.put("isComplete", z11);
                            jSONObject2.put("convert", z11 ? 1 : 2);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onAdClose " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewDismissed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void a(boolean z11, int i11) {
                    MBridgeBTContainer.this.M = z11;
                    MBridgeBTContainer.this.N = i11;
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void b(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("convert", true);
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onVideoComplete " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewPlayCompleted", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }

                @Override // com.mbridge.msdk.video.bt.module.a.b
                public final void c(String str, String str2, String str3) {
                    if (MBridgeBTContainer.this.f47433f != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", str);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MBridgeConstans.PLACEMENT_ID, str2);
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, str3);
                            jSONObject.put("data", jSONObject2);
                            ad.a(MBridgeBTContainer.f47428a, " BT Call H5 onEndcardShow " + jSONObject.toString());
                        } catch (JSONException e11) {
                            ad.a(MBridgeBTContainer.f47428a, e11.getMessage());
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onSubPlayTemplateViewEndcardShowSuccess", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            };
        }
        return this.I;
    }

    private com.mbridge.msdk.videocommon.download.a d(CampaignEx campaignEx) {
        List<com.mbridge.msdk.videocommon.download.a> list = this.E;
        if (list == null || campaignEx == null) {
            return null;
        }
        for (com.mbridge.msdk.videocommon.download.a aVar : list) {
            if (aVar.l().getId().equals(campaignEx.getId())) {
                ad.a(f47428a, "tempContainer task initSuccess");
                return aVar;
            }
        }
        return null;
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, this.f48401j, it.next(), false, true);
                }
            } catch (Throwable th2) {
                ad.b(f47428a, th2.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.G;
        if (hVar != null) {
            hVar.a(this.Q, str);
        }
        super.a(str);
    }

    public void addNativeCloseButtonWhenWebViewCrash() {
        try {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            int iA = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 48.0f);
            int iA2 = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.setMargins(iA2, iA2, iA2, iA2);
            layoutParams.gravity = 5;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_close", "drawable"));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeBTContainer.this.onAdClose();
                }
            });
            addView(imageView);
        } catch (Throwable th2) {
            ad.b(f47428a, th2.getMessage());
        }
    }

    public void appendSubView(MBridgeBTContainer mBridgeBTContainer, MBTempContainer mBTempContainer, JSONObject jSONObject) {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                int iOptInt = jSONObject.optInt(TtmlNode.LEFT, -999);
                int iOptInt2 = jSONObject.optInt("top", -999);
                int iOptInt3 = jSONObject.optInt(TtmlNode.RIGHT, -999);
                int iOptInt4 = jSONObject.optInt("bottom", -999);
                if (iOptInt != -999 && contextC != null) {
                    layoutParams.leftMargin = ai.a(contextC, iOptInt);
                }
                if (iOptInt2 != -999 && contextC != null) {
                    layoutParams.topMargin = ai.a(contextC, iOptInt2);
                }
                if (iOptInt3 != -999 && contextC != null) {
                    layoutParams.rightMargin = ai.a(contextC, iOptInt3);
                }
                if (iOptInt4 != -999 && contextC != null) {
                    layoutParams.bottomMargin = ai.a(contextC, iOptInt4);
                }
                int iOptInt5 = jSONObject.optInt("width");
                int iOptInt6 = jSONObject.optInt("height");
                if (iOptInt5 > 0) {
                    layoutParams.width = iOptInt5;
                }
                if (iOptInt6 > 0) {
                    layoutParams.height = iOptInt6;
                }
            }
            mBridgeBTContainer.addView(mBTempContainer, layoutParams);
            mBTempContainer.setActivity(this.f48400i);
            mBTempContainer.setMute(this.f48407p);
            mBTempContainer.setBidCampaign(this.f47438z);
            mBTempContainer.setIV(this.f48408q);
            mBTempContainer.setBigOffer(this.A);
            mBTempContainer.setIVRewardEnable(this.f48410s, this.f48411t, this.f48412u);
            mBTempContainer.setShowRewardListener(this.H);
            mBTempContainer.setCampaignDownLoadTask(d(mBTempContainer.getCampaign()));
            mBTempContainer.setMBridgeTempCallback(c());
            mBTempContainer.setWebViewFront(getJSCommon().a());
            mBTempContainer.init(this.f47435h);
            mBTempContainer.onCreate();
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    public void broadcast(String str, JSONObject jSONObject) {
        if (this.f47433f != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TrackingKey.CODE, this.f47429b);
                jSONObject2.put("id", this.B);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                g.a().a((WebView) this.f47433f, "broadcast", Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (Exception unused) {
                com.mbridge.msdk.video.bt.a.d.c().a((WebView) this.f47433f, "broadcast", this.B);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i11, String str) {
    }

    public int findID(String str) {
        return v.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return v.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public List<CampaignEx> getCampaigns() {
        return this.D;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i11, String str) {
    }

    public void init(Context context) {
        this.f47435h = context;
        this.f47434g = LayoutInflater.from(context);
    }

    public void onAdClose() {
        Activity activity = this.f48400i;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onBackPressed();
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onBackPressed();
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onBackPressed();
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onCreate(boolean z11) {
        String cMPTEntryUrl;
        WindVaneWebView windVaneWebViewA;
        CampaignEx campaignEx;
        try {
            int iFindLayout = findLayout("mbridge_bt_container");
            if (iFindLayout < 0) {
                a("mbridge_bt_container layout null");
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.f47434g.inflate(iFindLayout, this);
            this.f47431d = frameLayout;
            if (frameLayout == null) {
                a("ViewIds null");
                return;
            }
            this.K = "";
            List<CampaignEx> list = this.D;
            if (list == null || list.size() <= 0) {
                cMPTEntryUrl = "";
            } else {
                CampaignEx campaignEx2 = this.D.get(0);
                cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                this.K = campaignEx2.getRequestId();
                this.L = campaignEx2.getCurrentLocalRid();
            }
            com.mbridge.msdk.videocommon.a.C0532a c0532aA = com.mbridge.msdk.videocommon.a.a(this.f48401j + "_" + this.K + "_" + cMPTEntryUrl);
            RelativeLayout.LayoutParams layoutParams = null;
            if (c0532aA != null) {
                this.B = c0532aA.b();
                ad.a(f47428a, "get BT wraper.getTag = " + this.B);
                c0532aA.a("");
                windVaneWebViewA = c0532aA.a();
            } else {
                windVaneWebViewA = null;
            }
            this.f47433f = windVaneWebViewA;
            com.mbridge.msdk.videocommon.a.b(this.f48401j + "_" + this.K + "_" + cMPTEntryUrl);
            WindVaneWebView windVaneWebView = this.f47433f;
            if (windVaneWebView == null) {
                List<CampaignEx> list2 = this.D;
                if (list2 == null || list2.size() <= 0 || (campaignEx = this.D.get(0)) == null || !(z11 || campaignEx.isDynamicView())) {
                    a("big template webview is null");
                    return;
                }
                Context context = this.f47435h;
                if (this.P == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                HashMap map = new HashMap();
                map.put("choice_one_callback", this.P);
                com.mbridge.msdk.video.dynview.b.a();
                new com.mbridge.msdk.video.dynview.h.a(context, this.D, new com.mbridge.msdk.video.dynview.e.g() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.2
                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                        CampaignEx campaignEx3;
                        String str;
                        if (aVar != null) {
                            if (MBridgeBTContainer.this.f47431d == null || aVar.a() == null) {
                                MBridgeBTContainer.this.a("nativeview is null");
                                return;
                            }
                            MBridgeBTContainer.this.f47431d.removeAllViews();
                            MBridgeBTContainer.this.f47431d.addView(aVar.a());
                            MBridgeBTContainer mBridgeBTContainer = MBridgeBTContainer.this;
                            mBridgeBTContainer.f47436x = (TextView) mBridgeBTContainer.findViewById(mBridgeBTContainer.findID("mbridge_choice_one_countdown_tv"));
                            MBridgeBTContainer mBridgeBTContainer2 = MBridgeBTContainer.this;
                            mBridgeBTContainer2.f47437y = (ImageView) mBridgeBTContainer2.findViewById(mBridgeBTContainer2.findID("mbridge_iv_link"));
                            if (MBridgeBTContainer.this.F != null) {
                                MBridgeBTContainer.this.F.a();
                                MBridgeBTContainer.this.F.a(2, ((AbstractJSContainer) MBridgeBTContainer.this).f48402k, ((AbstractJSContainer) MBridgeBTContainer.this).f48401j);
                            }
                            if (MBridgeBTContainer.this.D == null || MBridgeBTContainer.this.D.size() <= 0 || (campaignEx3 = (CampaignEx) MBridgeBTContainer.this.D.get(0)) == null) {
                                return;
                            }
                            if (campaignEx3.isBidCampaign()) {
                                MBridgeBTContainer.a(MBridgeBTContainer.this, campaignEx3);
                            }
                            String onlyImpressionURL = campaignEx3.getOnlyImpressionURL();
                            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), ((AbstractJSContainer) MBridgeBTContainer.this).f48401j);
                            int iY = cVarA != null ? cVarA.y() : 1;
                            if (campaignEx3.getSpareOfferFlag() == 1) {
                                str = onlyImpressionURL + "&to=1&cbt=" + campaignEx3.getCbt() + "&tmorl=" + iY;
                            } else {
                                str = onlyImpressionURL + "&to=0&cbt=" + campaignEx3.getCbt() + "&tmorl=" + iY;
                            }
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx3, ((AbstractJSContainer) MBridgeBTContainer.this).f48401j, str, false, true, com.mbridge.msdk.click.a.a.f43073h);
                            com.mbridge.msdk.foundation.same.a.d.f44407k.put(campaignEx3.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                            MBridgeBTContainer.this.a(campaignEx3);
                            try {
                                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                                dVar.a("type", "choseFromTwoShow");
                                com.mbridge.msdk.video.module.b.a.a("2000103", campaignEx3, dVar);
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        String str;
                        if (aVar != null) {
                            str = "errorCode:" + aVar.a() + "Msg:" + aVar.b();
                        } else {
                            str = "";
                        }
                        MBridgeBTContainer.this.a("nativeview is null" + str);
                    }
                }, map);
                return;
            }
            com.mbridge.msdk.video.signal.factory.b bVar = new com.mbridge.msdk.video.signal.factory.b(this.f48400i, this, windVaneWebView);
            registerJsFactory(bVar);
            this.f47433f.setApiManagerJSFactory(bVar);
            if (this.f47433f.getParent() != null) {
                a("preload template webview is null or load error");
                return;
            }
            if (this.f47433f.getObject() instanceof k) {
                bVar.a((k) this.f47433f.getObject());
                if (this.f47433f != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(getContext()));
                    try {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", this.f48405n.a());
                            jSONObject2.put("amount", this.f48405n.b());
                            jSONObject2.put("id", this.f48406o);
                            jSONObject.put("userId", this.f48404m);
                            jSONObject.put("reward", jSONObject2);
                            jSONObject.put("playVideoMute", this.f48407p);
                            jSONObject.put("extra", this.O);
                        } catch (JSONException e11) {
                            ad.a(f47428a, e11.getMessage());
                        }
                    } catch (Exception e12) {
                        ad.a(f47428a, e12.getMessage());
                    }
                    this.H = new com.mbridge.msdk.video.bt.module.b.c(c(), "");
                    String string = jSONObject.toString();
                    try {
                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar.a("type", 1);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000133", this.D, dVar);
                    } catch (Exception unused) {
                    }
                    getJSNotifyProxy().a(string);
                    getJSCommon().b(true);
                    getJSCommon().a(new b());
                }
                ((com.mbridge.msdk.video.signal.a.d) getJSCommon()).f48086m.a();
            }
            this.f47433f.setBackgroundColor(0);
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || !linkedHashMapB.containsKey(this.B)) {
                a("big template webviewLayout is null");
                return;
            }
            View view = linkedHashMapB.get(this.B);
            if (view instanceof MBridgeBTLayout) {
                this.f47432e = (MBridgeBTLayout) view;
                com.mbridge.msdk.foundation.d.b.a().a(this.f48401j + "_1", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTContainer.1
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a() {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th2) {
                            ad.a(MBridgeBTContainer.f47428a, th2.getMessage(), th2);
                            string2 = "";
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a(String str) {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th2) {
                            ad.a(MBridgeBTContainer.f47428a, th2.getMessage(), th2);
                            string2 = "";
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void b() {
                        String string2;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string2 = jSONObject3.toString();
                        } catch (Throwable th2) {
                            ad.a(MBridgeBTContainer.f47428a, th2.getMessage(), th2);
                            string2 = "";
                        }
                        g.a().a((WebView) MBridgeBTContainer.this.f47433f, "onFeedbackAlertStatusNotify", Base64.encodeToString(string2.getBytes(), 2));
                    }
                });
                this.f47432e.addView(this.f47433f, 0, new FrameLayout.LayoutParams(-1, -1));
                com.mbridge.msdk.foundation.d.b.a().c(this.f48401j + "_2");
                FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.d.b.a().b(this.f48401j + "_1");
                if (com.mbridge.msdk.foundation.d.b.a().b() && feedBackButtonB != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f44149b, com.mbridge.msdk.foundation.d.b.f44148a);
                    }
                    layoutParams.topMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    layoutParams.leftMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    feedBackButtonB.setLayoutParams(layoutParams);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonB);
                    }
                    this.f47432e.addView(feedBackButtonB);
                }
                this.f47432e.setTag(this.B);
                linkedHashMapB.put(this.B, this.f47432e);
                for (View view2 : linkedHashMapB.values()) {
                    if (view2 instanceof MBridgeBTRootLayout) {
                        MBridgeBTRootLayout mBridgeBTRootLayout = (MBridgeBTRootLayout) view2;
                        this.J = mBridgeBTRootLayout.getInstanceId();
                        this.f47431d.addView(mBridgeBTRootLayout, new FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                linkedHashMapB.remove(this.J);
                linkedHashMapB.put(this.J, this);
            }
            com.mbridge.msdk.video.bt.a.d.c().a(this.f48401j, this.f48407p);
            com.mbridge.msdk.video.bt.a.d.c().a(this.B, this.K);
            com.mbridge.msdk.video.bt.a.d.c().a(this.J, this.K);
            com.mbridge.msdk.video.bt.a.d.c().a(this.f48401j + "_" + this.K, this.f48400i);
            try {
                com.mbridge.msdk.foundation.same.f.b.b().execute(new a(this.D, getContext().getApplicationContext(), this.f48401j, this.f48402k));
            } catch (Throwable unused2) {
                ad.a(f47428a, "remove campaign failed");
            }
            List<CampaignEx> list3 = this.D;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            a(this.f48403l, this.D.get(0));
        } catch (Throwable th2) {
            a("onCreate exception " + th2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.C) {
            return;
        }
        this.C = true;
        super.onDestroy();
        com.mbridge.msdk.video.bt.a.d.c().d(this.f48401j + "_" + this.K);
        try {
            WindVaneWebView windVaneWebView = this.f47433f;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f47433f.clearWebView();
                this.f47433f.release();
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.F != null) {
                this.F = null;
            }
            if (this.f47435h != null) {
                this.f47435h = null;
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                for (CampaignEx campaignEx : this.D) {
                    if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                        com.mbridge.msdk.videocommon.a.b(this.f48401j + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
                com.mbridge.msdk.video.dynview.b.a.a().b();
            }
            com.mbridge.msdk.video.bt.a.d.c().f(this.B);
            com.mbridge.msdk.video.bt.a.d.c().g(this.f48401j);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K).remove(this.B);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K).remove(this.J);
            com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K).clear();
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onPause();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView() && (aVar = com.mbridge.msdk.video.dynview.b.a.a().f47541a) != null) {
            aVar.b();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onPause();
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        CampaignEx campaignEx;
        com.mbridge.msdk.video.dynview.d.a aVar;
        super.onResume();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView() && (aVar = com.mbridge.msdk.video.dynview.b.a.a().f47541a) != null) {
            aVar.a();
        }
        if (com.mbridge.msdk.foundation.d.b.f44150c) {
            return;
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onResume();
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        CampaignEx campaignEx;
        super.onStop();
        List<CampaignEx> list = this.D;
        if (list != null && list.size() > 0 && (campaignEx = this.D.get(0)) != null && campaignEx.isDynamicView()) {
            com.mbridge.msdk.video.dynview.b.a.a().b();
        }
        try {
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onStop();
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reactDeveloper(Object obj, String str) {
        int i11;
        if (this.F == null || TextUtils.isEmpty(str)) {
            a(obj, "listener is null");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, getUnitId());
            String strOptString2 = jSONObject.optString(MBridgeConstans.PLACEMENT_ID, getPlacementId());
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            CampaignEx campaignEx = this.D.get(0);
            boolean z11 = true;
            if (iOptInt == 1 && jSONObjectOptJSONObject != null) {
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
                if (campaignEx != null) {
                    if (zOptBoolean) {
                        campaignEx.setSpareOfferFlag(1);
                    } else {
                        campaignEx.setSpareOfferFlag(0);
                    }
                }
            }
            setCBT(campaignEx);
            JSONObject jSONObjectOptJSONObject2 = null;
            switch (iOptInt) {
                case 1:
                    this.F.a();
                    this.F.a(2, strOptString2, strOptString);
                    a(obj);
                    break;
                case 2:
                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("error") : null;
                    this.F.a(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString(NotificationCompat.CATEGORY_MESSAGE) : "");
                    this.F.a(4, strOptString2, strOptString);
                    a(obj);
                    break;
                case 3:
                    this.F.a(strOptString2, strOptString);
                    this.F.a(5, strOptString2, strOptString);
                    a(obj);
                    break;
                case 4:
                    try {
                        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000147", this.D, dVar);
                    } catch (Throwable th2) {
                        ad.b(f47428a, th2.getMessage());
                    }
                    this.F.b(strOptString2, strOptString);
                    this.F.a(6, strOptString2, strOptString);
                    a(obj);
                    break;
                case 5:
                    this.F.a(jSONObject.optBoolean("isAutoClick"), strOptString2, strOptString);
                    a(obj);
                    break;
                case 6:
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("convert") != 1) {
                            z11 = false;
                        }
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
                        String strOptString3 = jSONObjectOptJSONObject.optString("extra");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            this.O = strOptString3;
                        }
                    } else {
                        z11 = false;
                    }
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                    com.mbridge.msdk.videocommon.b.c cVarA = com.mbridge.msdk.videocommon.b.c.a(jSONObjectOptJSONObject2);
                    if (cVarA == null) {
                        cVarA = this.f48405n;
                    }
                    this.F.a(7, strOptString2, strOptString);
                    try {
                        com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
                        dVar2.a("type", 2);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", campaignWithBackData, dVar2);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    if (this.f48408q && ((i11 = this.f48410s) == com.mbridge.msdk.foundation.same.a.G || i11 == com.mbridge.msdk.foundation.same.a.H)) {
                        this.F.a(this.M, this.N);
                    }
                    if (!z11) {
                        cVarA.a(0);
                    }
                    this.F.a(z11, cVarA);
                    ad.a(f47428a, "sendToServerRewardInfo");
                    if (!this.f48408q && z11) {
                        if (campaignWithBackData != null) {
                            com.mbridge.msdk.video.module.b.b.a(campaignWithBackData, cVarA, strOptString, this.f48404m, this.O);
                        } else {
                            com.mbridge.msdk.video.module.b.b.a(campaignEx, cVarA, strOptString, this.f48404m, this.O);
                        }
                    }
                    com.mbridge.msdk.foundation.same.report.d.c.a().a("2000134", campaignWithBackData);
                    a(obj);
                    break;
                default:
                    a(obj);
                    break;
            }
        } catch (JSONException e12) {
            a(obj, e12.getMessage());
            ad.a(f47428a, e12.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.c
    public void reportUrls(Object obj, String str) {
        ad.a(f47428a, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int iOptInt = jSONObject.optInt("type");
                String strA = ai.a(jSONObject.optString("url"), "&tun=", z.q() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list = this.D;
                    com.mbridge.msdk.click.a.a(contextC, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    List<CampaignEx> list2 = this.D;
                    com.mbridge.msdk.click.a.a(contextC2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, Base64.encodeToString("".getBytes(), 2));
        } catch (Throwable th2) {
            ad.a(f47428a, "reportUrls", th2);
        }
    }

    public void setBTContainerCallback(com.mbridge.msdk.video.bt.module.a.a aVar) {
        this.F = aVar;
    }

    public void setCBT(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (campaignEx.getSpareOfferFlag() != 1) {
                campaignEx.setCbt(0);
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVar = this.f48403l;
            if (cVar != null) {
                if (cVar.y() == 1) {
                    campaignEx.setCbt(1);
                } else {
                    campaignEx.setCbt(0);
                }
            }
        }
    }

    public void setCampaignDownLoadTasks(List<com.mbridge.msdk.videocommon.download.a> list) {
        this.E = list;
    }

    public void setCampaigns(List<CampaignEx> list) {
        CampaignEx campaignEx;
        this.D = list;
        String currentLocalRid = "";
        if (list != null) {
            try {
                if (list.size() > 0 && (campaignEx = list.get(0)) != null) {
                    currentLocalRid = campaignEx.getCurrentLocalRid();
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(currentLocalRid)) {
            this.Q = com.mbridge.msdk.foundation.same.report.d.c.a().b(currentLocalRid);
        }
        if (this.Q == null) {
            this.Q = new com.mbridge.msdk.foundation.same.report.d.b();
        }
        this.Q.c(currentLocalRid);
        this.Q.b(list);
    }

    public void setChoiceOneCallback(d dVar) {
        this.P = dVar;
    }

    public void setDeveloperExtraData(String str) {
        this.O = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.f48414w = bVar;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14, int i15) {
        TextView textView;
        FrameLayout.LayoutParams layoutParams;
        try {
            String strA = r.a(i11, i12, i13, i14, i15);
            ad.b(f47428a, strA);
            WindVaneWebView windVaneWebView = this.f47433f;
            if (windVaneWebView != null && (windVaneWebView.getObject() instanceof k) && !TextUtils.isEmpty(strA)) {
                ((k) this.f47433f.getObject()).b(strA);
                g.a().a((WebView) this.f47433f, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
            }
            List<CampaignEx> list = this.D;
            if (list != null && list.size() > 0) {
                try {
                    if (this.D.get(0).isDynamicView() && (textView = this.f47436x) != null && (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                        if (i12 > 0) {
                            layoutParams.leftMargin = i12;
                        }
                        if (i13 > 0) {
                            layoutParams.rightMargin = i13;
                        }
                        if (i14 > 0) {
                            layoutParams.topMargin = i14;
                        }
                        if (i15 > 0) {
                            layoutParams.bottomMargin = i15;
                        }
                        this.f47436x.setLayoutParams(layoutParams);
                        if (this.f47437y != null) {
                            try {
                                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f47437y.getLayoutParams());
                                layoutParams2.leftMargin = layoutParams.rightMargin;
                                layoutParams2.topMargin = layoutParams.topMargin;
                                this.f47437y.setLayoutParams(layoutParams2);
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e12) {
                    ad.b(f47428a, e12.getMessage());
                }
            }
            com.mbridge.msdk.video.bt.a.d.c().a(i11, i12, i13, i14, i15);
            LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f48401j, this.K);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setNotchPadding(i12, i13, i14, i15);
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).setNotchPadding(i11, i12, i13, i14, i15);
                }
                if ((view instanceof WindVaneWebView) && !TextUtils.isEmpty(strA)) {
                    g.a().a(view, "oncutoutfetched", Base64.encodeToString(strA.getBytes(), 0));
                }
            }
        } catch (Throwable th2) {
            ad.a(f47428a, th2.getMessage());
        }
    }

    public void setShowRewardVideoListener(h hVar) {
        this.G = hVar;
    }
}
