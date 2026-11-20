package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f47790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CampaignEx f47791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected LayoutInflater f47792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f47793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected a f47794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f47795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float f47796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected float f47797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f47798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f47799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f47800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f47801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f47802m;

    public MBridgeBaseView(Context context) {
        this(context, null);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47793d = 1;
        this.f47794e = new f();
        this.f47795f = false;
        this.f47801l = 1;
        this.f47802m = 0;
        this.f47790a = context;
        this.f47792c = LayoutInflater.from(context);
        init(context);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z11, int i11, boolean z12, int i12, int i13) {
        super(context, attributeSet);
        this.f47793d = 1;
        this.f47794e = new f();
        this.f47795f = false;
        this.f47801l = 1;
        this.f47802m = 0;
        this.f47790a = context;
        this.f47792c = LayoutInflater.from(context);
        this.f47798i = z11;
        this.f47799j = i11;
        this.f47800k = z12;
        this.f47801l = i12;
        this.f47802m = i13;
        init(context);
    }

    public final JSONObject a(int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44372h, ai.b(c.m().c(), this.f47796g));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44373i, ai.b(c.m().c(), this.f47797h));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44377m, i11);
                try {
                    this.f47793d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44375k, this.f47793d);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f44376l, ai.d(getContext()));
                return jSONObject2;
            } catch (JSONException e12) {
                e = e12;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e13) {
            e = e13;
        }
    }

    public void c() {
    }

    public final String d() {
        return a(0).toString();
    }

    public void defaultShow() {
        ad.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z11, String str) {
        return z11 ? findDyID(str) : findID(str);
    }

    public int findColor(String str) {
        return v.a(this.f47790a.getApplicationContext(), str, TtmlNode.ATTR_TTS_COLOR);
    }

    public int findDrawable(String str) {
        return v.a(this.f47790a.getApplicationContext(), str, "drawable");
    }

    public int findDyID(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public int findID(String str) {
        return v.a(this.f47790a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return v.a(this.f47790a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f47791b;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        return this.f47790a.getResources().getConfiguration().orientation == 2;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < length) {
            if (viewArr[i11] == null) {
                return false;
            }
            i11++;
            z11 = true;
        }
        return z11;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        this.f47793d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onConfigurationChanged:");
        sb2.append(configuration.orientation);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f47796g = motionEvent.getRawX();
        this.f47797h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f47793d = configuration.orientation;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onSelfConfigurationChanged:");
        sb2.append(configuration.orientation);
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f47791b = campaignEx;
    }

    public void setLayoutCenter(int i11, int i12) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i11 != -999) {
                parentRelativeLayoutParams.width = i11;
            }
            if (i12 != -999) {
                parentRelativeLayoutParams.height = i12;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i11 != -999) {
                parentLinearLayoutParams.width = i11;
            }
            if (i12 != -999) {
                parentLinearLayoutParams.height = i12;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setLayoutParam(int i11, int i12, int i13, int i14) {
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i12;
            parentRelativeLayoutParams.leftMargin = i11;
            if (i13 != -999) {
                parentRelativeLayoutParams.width = i13;
            }
            if (i14 != -999) {
                parentRelativeLayoutParams.height = i14;
            }
            setLayoutParams(parentRelativeLayoutParams);
            return;
        }
        if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i12;
            parentLinearLayoutParams.leftMargin = i11;
            if (i13 != -999) {
                parentLinearLayoutParams.width = i13;
            }
            if (i14 != -999) {
                parentLinearLayoutParams.height = i14;
            }
            setLayoutParams(parentLinearLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setNotifyListener(a aVar) {
        this.f47794e = aVar;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        } else {
            layoutParams.height = -2;
            layoutParams.width = -2;
        }
    }
}
