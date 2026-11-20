package com.mbridge.msdk.video.module;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeClickMiniCardView extends MBridgeH5EndCardView {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f47818x;

    public MBridgeClickMiniCardView(Context context) {
        super(context);
        this.f47818x = false;
    }

    public MBridgeClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47818x = false;
    }

    private void a(View view) {
        int iF = ai.f(this.f47790a);
        int iE = (int) ((ai.e(this.f47790a) * 0.7f) + 0.5f);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((iF * 0.7f) + 0.5f);
        layoutParams.height = iE;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final String a() {
        CampaignEx campaignEx = this.f47791b;
        if (campaignEx == null) {
            return null;
        }
        CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
        String strC = rewardTemplateMode != null ? rewardTemplateMode.c() : null;
        if (TextUtils.isEmpty(strC) || !strC.contains(".zip")) {
            return strC;
        }
        String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(strC);
        return !TextUtils.isEmpty(h5ResAddress) ? h5ResAddress : strC;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final void e() {
        super.e();
        if (this.f47795f) {
            setBackgroundResource(findColor("mbridge_reward_minicard_bg"));
            a(this.f47839n);
            setClickable(true);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView, com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f47795f) {
            a(this.f47839n);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i11, int i12) {
        View viewFindViewById = ((Activity) this.f47790a).getWindow().findViewById(R.id.content);
        int width = viewFindViewById.getWidth();
        int height = viewFindViewById.getHeight();
        if (i11 <= 0 || i12 <= 0 || i11 > width || i12 > height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f47839n.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i12;
        this.f47839n.setLayoutParams(layoutParams);
    }

    public void setMBridgeClickMiniCardViewClickable(boolean z11) {
        setClickable(z11);
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i11, int i12, int i13, int i14) {
        this.f47818x = true;
        resizeMiniCard(i13, i14);
    }

    public void setRadius(int i11) {
        if (i11 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(ai.a(getContext(), i11));
            gradientDrawable.setColor(-1);
            this.f47842q.setBackground(gradientDrawable);
            this.f47842q.setClipToOutline(true);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f47842q;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeClickMiniCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ad.a(MBridgeBaseView.TAG, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            MBridgeClickMiniCardView.this.f47842q.getLocationOnScreen(iArr);
                            ad.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", ai.b(c.m().c(), (float) iArr[0]));
                            jSONObject.put("startY", ai.b(c.m().c(), (float) iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th2) {
                            ad.a(MBridgeBaseView.TAG, th2.getMessage(), th2);
                        }
                        g.a().a((WebView) MBridgeClickMiniCardView.this.f47842q, "webviewshow", Base64.encodeToString(string.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            });
            d dVar = new d();
            dVar.a("type", 3);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000133", this.f47791b, dVar);
        }
    }
}
