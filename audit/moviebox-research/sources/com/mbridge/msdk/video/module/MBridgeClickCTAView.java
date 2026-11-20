package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.video.dynview.e.g;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewGroup f47803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f47804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f47805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f47806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f47807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f47808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f47809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f47810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ObjectAnimator f47811v;

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f47804o;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        JSONException e11;
        CampaignEx campaignEx = mBridgeClickCTAView.f47791b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.f47791b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                q.a(c.m().c(), "cta_click", mBridgeClickCTAView.f47791b.getCampaignUnitId(), mBridgeClickCTAView.f47791b.isBidCampaign(), mBridgeClickCTAView.f47791b.getRequestId(), mBridgeClickCTAView.f47791b.getRequestIdNotice(), mBridgeClickCTAView.f47791b.getId(), str);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f44374j, mBridgeClickCTAView.a(0));
            } catch (JSONException e13) {
                e11 = e13;
                e11.printStackTrace();
            }
        } catch (JSONException e14) {
            jSONObject = null;
            e11 = e14;
        }
        mBridgeClickCTAView.f47791b.setTriggerClickSource(1);
        mBridgeClickCTAView.f47791b.setClickTempSource(1);
        mBridgeClickCTAView.f47794e.a(105, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        this.f47803n = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.f47804o = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.f47805p = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.f47803n, this.f47804o, this.f47805p, textView);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.f47795f) {
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.2
                    @Override // com.mbridge.msdk.widget.a
                    public final void a(View view) {
                        MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                    }
                });
            }
            this.ctaTv.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.3
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    MBridgeClickCTAView.b(MBridgeClickCTAView.this);
                }
            });
            ImageView imageView = this.f47804o;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff, com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f47811v;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f47811v;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f47808s = motionEvent.getRawX();
        this.f47809t = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f47810u = configuration.orientation;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeClickCTAViewDiff
    public void preLoadData(b bVar) {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().b(this, this.f47791b), new g() { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.1
                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.f47795f = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            mBridgeClickCTAView2.f47806q = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }

                    @Override // com.mbridge.msdk.video.dynview.e.g
                    public final void a(com.mbridge.msdk.video.dynview.c.a aVar) {
                        ad.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }
                });
            } else {
                int iFindLayout = findLayout("mbridge_reward_clickable_cta");
                if (iFindLayout >= 0) {
                    this.f47792c.inflate(iFindLayout, this);
                    this.f47795f = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f47795f) {
                if (com.mbridge.msdk.f.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.f47791b.getAdCall());
                if (TextUtils.isEmpty(this.f47791b.getIconUrl())) {
                    a();
                } else {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f47790a.getApplicationContext()).a(this.f47791b.getIconUrl(), new e(this.f47804o, this.f47791b, this.f47807r) { // from class: com.mbridge.msdk.video.module.MBridgeClickCTAView.5
                        @Override // com.mbridge.msdk.video.module.a.a.e, com.mbridge.msdk.foundation.same.c.c
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                }
                if (this.f47805p != null && !TextUtils.isEmpty(this.f47791b.getAppName())) {
                    this.f47805p.setText(this.f47791b.getAppName());
                }
                if (this.f47806q == null || TextUtils.isEmpty(this.f47791b.getAppDesc())) {
                    return;
                }
                this.f47806q.setText(this.f47791b.getAppDesc());
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f47811v = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f47807r = str;
    }
}
