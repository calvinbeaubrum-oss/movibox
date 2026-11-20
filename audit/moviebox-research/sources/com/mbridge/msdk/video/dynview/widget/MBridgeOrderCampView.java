package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.dynview.e.b;
import com.mbridge.msdk.video.dynview.e.c;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import com.transsion.gslb.Worker;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeOrderCampView extends MBridgeBaseView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MBridgeOrderCampView f47763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<CampaignEx> f47764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f47765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f47766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f47767r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f47768s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f47769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FeedBackButton f47770u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f47771v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f47772w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private c f47773x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private b f47774y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f47775z;

    public MBridgeOrderCampView(Context context) {
        super(context);
        this.f47772w = false;
        this.f47773x = new c() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.1
            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a() {
                MBridgeOrderCampView.a(MBridgeOrderCampView.this);
            }

            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a(CampaignEx campaignEx, int i11) {
                if (campaignEx != null) {
                    try {
                        MBridgeOrderCampView.this.setCampaign(campaignEx);
                        campaignEx.setClickTempSource(2);
                        campaignEx.setTriggerClickSource(2);
                        MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i11);
                    } catch (Exception e11) {
                        ad.b(MBridgeBaseView.TAG, e11.getMessage());
                    }
                }
            }
        };
        this.f47775z = false;
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47772w = false;
        this.f47773x = new c() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.1
            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a() {
                MBridgeOrderCampView.a(MBridgeOrderCampView.this);
            }

            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a(CampaignEx campaignEx, int i11) {
                if (campaignEx != null) {
                    try {
                        MBridgeOrderCampView.this.setCampaign(campaignEx);
                        campaignEx.setClickTempSource(2);
                        campaignEx.setTriggerClickSource(2);
                        MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i11);
                    } catch (Exception e11) {
                        ad.b(MBridgeBaseView.TAG, e11.getMessage());
                    }
                }
            }
        };
        this.f47775z = false;
    }

    public static /* synthetic */ void a(MBridgeOrderCampView mBridgeOrderCampView) {
        try {
            d dVar = new d();
            dVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000134", mBridgeOrderCampView.f47791b);
        } catch (Throwable th2) {
            ad.a(MBridgeBaseView.TAG, th2.getMessage());
        }
        try {
            com.mbridge.msdk.video.dynview.moffer.a.a().b();
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
        com.mbridge.msdk.video.module.a.a aVar = mBridgeOrderCampView.f47794e;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    public static /* synthetic */ void a(MBridgeOrderCampView mBridgeOrderCampView, CampaignEx campaignEx, int i11, int i12) {
        JSONObject jSONObject;
        JSONException e11;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                String str2 = str;
                q.a(com.mbridge.msdk.foundation.controller.c.m().c(), "order_view_click" + str2, campaignEx.getCampaignUnitId(), campaignEx.isBidCampaign(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str2);
            } catch (Exception e12) {
                ad.b(MBridgeBaseView.TAG, e12.getMessage());
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f44374j, mBridgeOrderCampView.a(i11));
                jSONObject.put("camp_position", i12);
            } catch (JSONException e13) {
                e11 = e13;
                e11.printStackTrace();
            }
        } catch (JSONException e14) {
            jSONObject = null;
            e11 = e14;
        }
        com.mbridge.msdk.video.module.a.a aVar = mBridgeOrderCampView.f47794e;
        if (aVar != null) {
            aVar.a(105, jSONObject);
        }
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.f47764o == null) {
            b bVar = this.f47774y;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("order_view_callback", this.f47773x);
        com.mbridge.msdk.video.dynview.c cVarB = new com.mbridge.msdk.video.dynview.j.c().b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47764o);
        com.mbridge.msdk.video.dynview.b.a();
        new com.mbridge.msdk.video.dynview.h.a(cVarB, new g() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.2
            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    try {
                        MBridgeOrderCampView.this.f47763n.addView(aVar.a());
                        MBridgeOrderCampView.this.f47772w = aVar.c();
                        viewGroup.removeAllViews();
                        viewGroup.addView(MBridgeOrderCampView.this.f47763n);
                        f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f47764o, ((CampaignEx) MBridgeOrderCampView.this.f47764o.get(0)).getCampaignUnitId());
                        MBridgeOrderCampView.this.setViewStatus();
                        if (MBridgeOrderCampView.this.f47774y != null) {
                            MBridgeOrderCampView.this.f47774y.a();
                        }
                    } catch (Exception e11) {
                        ad.b(MBridgeBaseView.TAG, e11.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.g
            public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                try {
                    f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f47764o, ((CampaignEx) MBridgeOrderCampView.this.f47764o.get(0)).getCampaignUnitId(), aVar.b());
                    if (MBridgeOrderCampView.this.f47774y != null) {
                        MBridgeOrderCampView.this.f47774y.b();
                    }
                } catch (Exception e11) {
                    ad.b(MBridgeBaseView.TAG, e11.getMessage());
                }
            }
        }, map);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        this.f47763n = this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        JSONObject jSONObject;
        JSONException e11;
        super.onAttachedToWindow();
        if (this.f47764o == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f47764o.size(); i11++) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("camp_position", i11);
                } catch (JSONException e12) {
                    e11 = e12;
                    e11.printStackTrace();
                }
            } catch (JSONException e13) {
                jSONObject = null;
                e11 = e13;
            }
            com.mbridge.msdk.video.module.a.a aVar = this.f47794e;
            if (aVar != null) {
                aVar.a(Worker.WHAT_QUIT, jSONObject);
            }
        }
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.f47774y = bVar;
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.f47764o = list;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        this.f47765p = i11;
        this.f47766q = i12;
        this.f47767r = i13;
        this.f47768s = i14;
        setViewStatus();
    }

    public void setRewarded(boolean z11) {
        this.f47775z = z11;
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.f47763n;
        if (mBridgeOrderCampView == null || !this.f47775z) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.f47772w, "mbridge_native_order_camp_controller"));
        this.f47770u = (FeedBackButton) this.f47763n.findViewById(filterFindViewId(this.f47772w, "mbridge_native_order_camp_feed_btn"));
        this.f47771v = (ImageView) this.f47763n.findViewById(filterFindViewId(this.f47772w, "mbridge_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.f47765p, this.f47767r, this.f47766q, this.f47768s);
        }
        if (this.f47770u != null) {
            try {
                List<CampaignEx> list = this.f47764o;
                if (list == null || list.get(0) == null) {
                    FeedBackButton feedBackButton = this.f47770u;
                    if (feedBackButton != null) {
                        feedBackButton.setVisibility(8);
                    }
                } else {
                    this.f47769t = this.f47764o.get(0).getCampaignUnitId();
                    this.f47791b = this.f47764o.get(0);
                    com.mbridge.msdk.foundation.d.b.a().a(this.f47769t + "_2", this.f47791b);
                    if (this.f47770u != null) {
                        if (com.mbridge.msdk.foundation.d.b.a().b()) {
                            com.mbridge.msdk.foundation.d.b.a().a(this.f47769t + "_2", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.3
                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void a() {
                                }

                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void a(String str) {
                                }

                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void b() {
                                }
                            });
                            com.mbridge.msdk.foundation.d.b.a().a(this.f47769t + "_2", this.f47770u);
                        } else {
                            this.f47770u.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e11) {
                ad.b(MBridgeBaseView.TAG, e11.getMessage());
            }
        }
        ImageView imageView = this.f47771v;
        if (imageView == null || imageView == null) {
            return;
        }
        try {
            com.mbridge.msdk.c.g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                this.f47771v.setVisibility(8);
                return;
            }
            final String strG = gVarB.g();
            if (TextUtils.isEmpty(strG)) {
                this.f47771v.setVisibility(8);
            }
            this.f47771v.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.mbridge.msdk.click.c.e(((MBridgeBaseView) MBridgeOrderCampView.this).f47790a, strG);
                }
            });
        } catch (Exception e12) {
            ad.b(MBridgeBaseView.TAG, e12.getMessage());
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.f47763n.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.f47763n.startAnimation(translateAnimation);
    }
}
