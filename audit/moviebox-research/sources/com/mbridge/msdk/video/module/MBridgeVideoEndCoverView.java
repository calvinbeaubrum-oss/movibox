package com.mbridge.msdk.video.module;

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
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeVideoEndCoverView extends MBridgeBaseView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f47911n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f47912o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f47913p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f47914q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f47915r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f47916s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f47917t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private b f47918u;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
        this.f47911n = "MBridgeVideoEndCoverView";
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47911n = "MBridgeVideoEndCoverView";
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f47913p = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.f47914q = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.f47915r = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.f47916s = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.f47917t = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th2) {
            ad.b("MBridgeVideoEndCoverView", th2.getMessage());
            return false;
        }
    }

    public final void a() {
        JSONObject jSONObject;
        JSONException e11;
        JSONObject jSONObject2;
        JSONException e12;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.f44372h, ai.b(c.m().c(), this.f47796g));
                    jSONObject2.put(a.f44373i, ai.b(c.m().c(), this.f47797h));
                    jSONObject2.put(a.f44377m, 0);
                    try {
                        this.f47793d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                    jSONObject2.put(a.f44375k, this.f47793d);
                    jSONObject2.put(a.f44376l, ai.d(getContext()));
                } catch (JSONException e14) {
                    e12 = e14;
                    ad.b("MBridgeVideoEndCoverView", e12.getMessage());
                }
            } catch (JSONException e15) {
                jSONObject2 = jSONObject3;
                e12 = e15;
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f44374j, jSONObject2);
            } catch (JSONException e16) {
                e11 = e16;
                e11.printStackTrace();
            }
        } catch (JSONException e17) {
            jSONObject = null;
            e11 = e17;
        }
        this.f47794e.a(105, jSONObject);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        this.f47914q.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.f47794e.a(104, "");
            }
        });
        this.f47913p.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.f47917t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoEndCoverView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_videoend_cover");
        if (iFindLayout >= 0) {
            View viewInflate = this.f47792c.inflate(iFindLayout, (ViewGroup) null);
            this.f47912o = viewInflate;
            if (viewInflate != null) {
                this.f47795f = a(viewInflate);
                addView(this.f47912o, -1, -1);
                c();
            }
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f47796g = motionEvent.getRawX();
        this.f47797h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f47793d = configuration.orientation;
        removeView(this.f47912o);
        View view = this.f47912o;
        if (view == null) {
            init(this.f47790a);
            preLoadData(this.f47918u);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f47912o.getParent()).removeView(this.f47912o);
        }
        addView(this.f47912o);
        a(this.f47912o);
        c();
    }

    public void preLoadData(b bVar) {
        ImageView imageView;
        this.f47918u = bVar;
        try {
            CampaignEx campaignEx = this.f47791b;
            if (campaignEx == null || !this.f47795f || campaignEx == null) {
                return;
            }
            if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.f47913p) != null) {
                com.mbridge.msdk.foundation.same.c.b.a(this.f47790a.getApplicationContext()).a(this.f47791b.getIconUrl(), new j(imageView, ai.a(c.m().c(), 8.0f)));
            }
            TextView textView = this.f47915r;
            if (textView != null) {
                textView.setText(this.f47791b.getAppName());
            }
            TextView textView2 = this.f47917t;
            if (textView2 != null) {
                textView2.setText(this.f47791b.getAdCall());
            }
            TextView textView3 = this.f47916s;
            if (textView3 != null) {
                textView3.setText(this.f47791b.getAppDesc());
            }
        } catch (Throwable th2) {
            ad.a("MBridgeVideoEndCoverView", th2.getMessage());
        }
    }
}
