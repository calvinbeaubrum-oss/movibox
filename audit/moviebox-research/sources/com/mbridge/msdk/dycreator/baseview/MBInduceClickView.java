package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.baseview.inter.InterEffect;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.s;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBInduceClickView extends FrameLayout implements InterBase, InterEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f43332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Boolean> f43333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43334c;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.baseview.MBInduceClickView$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43335a;

        static {
            int[] iArr = new int[c.values().length];
            f43335a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43335a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43335a[c.layout_gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43335a[c.layout_marginLeft.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43335a[c.layout_margin.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MBInduceClickView(Context context) {
        super(context);
        this.f43334c = "";
    }

    public MBInduceClickView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f43334c = "";
        if (context != null && attributeSet != null) {
            try {
                this.f43332a = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            } catch (Exception e11) {
                ad.b("MBInduceClickView", e11.getMessage());
                return;
            }
        }
        a.a(this, attributeSet);
        setLayoutParams(generateLayoutParams(attributeSet));
        com.mbridge.msdk.dycreator.e.c.a(this.f43332a, this);
    }

    public MBInduceClickView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43334c = "";
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        HashMap mapB = b.a().b();
        layoutParams.width = -2;
        layoutParams.height = -2;
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                int i12 = AnonymousClass1.f43335a[cVar.ordinal()];
                if (i12 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i11);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i12 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i11);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("w")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                } else if (i12 == 3) {
                    layoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i11));
                } else if (i12 == 4) {
                    layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i11));
                } else if (i12 == 5) {
                    int iB = b.a().b(attributeSet.getAttributeValue(i11));
                    layoutParams.setMargins(iB, iB, iB, iB);
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f43332a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f43332a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f43332a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f43332a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f43332a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f43332a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f43332a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f43332a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f43332a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f43332a.get("mbridgeStrategy");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f43333b;
        if (map != null && map.containsKey("mbridgeAttached") && this.f43333b.get("mbridgeAttached").booleanValue()) {
            new s.a("mbridgeAttached").a().a(this.f43334c);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f43333b;
        if (map != null && map.containsKey("mbridgeDetached") && this.f43333b.get("mbridgeDetached").booleanValue()) {
            new s.a("mbridgeDetached").a().a(this.f43334c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterEffect
    public void setAnimator(Animator animator) {
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f43333b = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f43334c = campaignEx.getCampaignUnitId();
        }
    }
}
