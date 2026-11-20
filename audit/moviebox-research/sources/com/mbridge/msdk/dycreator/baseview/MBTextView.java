package com.mbridge.msdk.dycreator.baseview;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
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
public class MBTextView extends TextView implements InterBase, InterEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f43401a;
    public AttributeSet attrs;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Animator f43402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f43403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f43404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43405e;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.baseview.MBTextView$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43406a;

        static {
            int[] iArr = new int[c.values().length];
            f43406a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43406a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MBTextView(Context context) {
        super(context);
        this.f43401a = false;
        this.f43405e = "";
    }

    public MBTextView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f43401a = false;
        this.f43405e = "";
        this.attrs = attributeSet;
        try {
            this.f43403c = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f43403c, this);
        } catch (Exception e11) {
            ad.b("TextView", e11.getMessage());
        }
    }

    public MBTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43401a = false;
        this.f43405e = "";
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        HashMap mapB = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                int i12 = AnonymousClass1.f43406a[cVar.ordinal()];
                if (i12 == 1) {
                    String attributeValue = attributeSet.getAttributeValue(i11);
                    if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue);
                    }
                } else if (i12 == 2) {
                    String attributeValue2 = attributeSet.getAttributeValue(i11);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue2);
                    }
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f43403c;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f43403c.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f43403c;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f43403c.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f43403c;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f43403c.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f43403c;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f43403c.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f43403c;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f43403c.get("mbridgeStrategy");
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.f43401a) {
            return true;
        }
        return super.isFocused();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Animator animator = this.f43402b;
        if (animator != null) {
            try {
                animator.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f43404d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f43404d.get("mbridgeAttached").booleanValue()) {
            new s.a("mbridgeAttached").a().a(this.f43405e);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f43402b;
        if (animator != null) {
            try {
                animator.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        Map<String, Boolean> map = this.f43404d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f43404d.get("mbridgeDetached").booleanValue()) {
            new s.a("mbridgeDetached").a().a(this.f43405e);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterEffect
    public void setAnimator(Animator animator) {
        this.f43402b = animator;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f43404d = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f43405e = campaignEx.getCampaignUnitId();
        }
    }
}
