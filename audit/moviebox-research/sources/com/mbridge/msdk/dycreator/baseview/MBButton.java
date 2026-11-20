package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.dycreator.e.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.s;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBButton extends Button implements InterBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f43307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Boolean> f43308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43309c;

    public MBButton(Context context) {
        super(context);
        this.f43309c = "";
    }

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        this.f43309c = "";
        this.f43307a = c.a(context, attributeSet);
        a.a(this, attributeSet);
        c.a(this.f43307a, this);
    }

    public MBButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43309c = "";
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f43307a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f43307a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f43307a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f43307a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f43307a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f43307a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f43307a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f43307a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f43307a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f43307a.get("mbridgeStrategy");
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f43308b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f43308b.get("mbridgeAttached").booleanValue()) {
            new s.a("mbridgeAttached").a().a(this.f43309c);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f43308b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f43308b.get("mbridgeDetached").booleanValue()) {
            new s.a("mbridgeDetached").a().a(this.f43309c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f43308b = c.a(str);
        if (campaignEx != null) {
            this.f43309c = campaignEx.getCampaignUnitId();
        }
    }
}
