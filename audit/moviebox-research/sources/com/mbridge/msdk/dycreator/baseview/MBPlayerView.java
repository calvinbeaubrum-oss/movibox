package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.e.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.s;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.playercommon.PlayerView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBPlayerView extends PlayerView implements InterBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f43346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f43347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f43348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Boolean> f43349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43350e;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.baseview.MBPlayerView$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43351a;

        static {
            int[] iArr = new int[c.values().length];
            f43351a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43351a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43351a[c.layout_centerHorizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43351a[c.layout_centerVertical.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43351a[c.layout_weight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43351a[c.gravity.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43351a[c.layout_margin.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f43351a[c.layout_marginLeft.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43351a[c.layout_marginRight.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f43351a[c.layout_marginTop.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f43351a[c.layout_marginBottom.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f43351a[c.layout_gravity.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public MBPlayerView(Context context) {
        super(context);
        this.f43350e = "";
    }

    public MBPlayerView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f43350e = "";
        try {
            this.f43348c = com.mbridge.msdk.dycreator.e.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.e.c.a(this.f43348c, this);
        } catch (Exception e11) {
            ad.b("MBLinearLayout", e11.getMessage());
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        HashMap mapB = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            c cVar = (c) mapB.get(attributeSet.getAttributeName(i11));
            if (cVar != null) {
                switch (AnonymousClass1.f43351a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i11);
                        if (attributeValue.startsWith("f") || attributeValue.startsWith("m")) {
                            layoutParams.width = -1;
                        } else if (attributeValue.startsWith("wrap")) {
                            layoutParams.width = -2;
                        } else {
                            layoutParams.width = b.a().b(attributeValue);
                        }
                        break;
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i11);
                        if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                            layoutParams.height = -1;
                        } else if (attributeValue2.startsWith("wrap")) {
                            layoutParams.height = -2;
                        } else {
                            layoutParams.height = b.a().b(attributeValue2);
                        }
                        break;
                    case 3:
                        layoutParams.gravity = 1;
                        break;
                    case 4:
                        layoutParams.gravity = 16;
                        break;
                    case 5:
                        layoutParams.weight = attributeSet.getAttributeFloatValue(i11, 0.0f);
                        break;
                    case 6:
                        setGravity(b.a().c(attributeSet.getAttributeValue(i11)));
                        break;
                    case 7:
                        int iB = b.a().b(attributeSet.getAttributeValue(i11));
                        layoutParams.bottomMargin = iB;
                        layoutParams.leftMargin = iB;
                        layoutParams.rightMargin = iB;
                        layoutParams.topMargin = iB;
                        break;
                    case 8:
                        layoutParams.leftMargin = b.a().b(attributeSet.getAttributeValue(i11));
                        break;
                    case 9:
                        layoutParams.rightMargin = b.a().b(attributeSet.getAttributeValue(i11));
                        break;
                    case 10:
                        layoutParams.topMargin = b.a().b(attributeSet.getAttributeValue(i11));
                        break;
                    case 11:
                        layoutParams.bottomMargin = b.a().b(attributeSet.getAttributeValue(i11));
                        break;
                    case 12:
                        layoutParams.gravity = b.a().c(attributeSet.getAttributeValue(i11));
                        break;
                }
            }
        }
        return layoutParams;
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f43348c;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f43348c.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f43348c;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f43348c.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f43348c;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f43348c.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f43348c;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f43348c.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f43348c;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f43348c.get("mbridgeStrategy");
    }

    public float getxInScreen() {
        return this.f43346a;
    }

    public float getyInScreen() {
        return this.f43347b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.f43349d;
        if (map != null && map.containsKey("mbridgeAttached") && this.f43349d.get("mbridgeAttached").booleanValue()) {
            new s.a("mbridgeAttached").a().a(this.f43350e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.f43349d;
        if (map != null && map.containsKey("mbridgeDetached") && this.f43349d.get("mbridgeDetached").booleanValue()) {
            new s.a("mbridgeDetached").a().a(this.f43350e);
        }
    }

    @Override // com.mbridge.msdk.playercommon.PlayerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f43346a = motionEvent.getRawX();
        this.f43347b = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.f43349d = com.mbridge.msdk.dycreator.e.c.a(str);
        if (campaignEx != null) {
            this.f43350e = campaignEx.getCampaignUnitId();
        }
    }
}
