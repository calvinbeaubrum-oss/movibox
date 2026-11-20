package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.We, com.bytedance.sdk.component.adexpress.theme.sc {
    private String bgColor;
    private Map<Integer, String> bgMaterialCenterCalcColor;
    private ExN dynamicBaseWidget;
    private int logoUnionHeight;
    private Context mContext;
    private com.bytedance.sdk.component.adexpress.dynamic.TRI.sc mDynamicClickListener;
    boolean mIsMute;
    private ThemeStatusBroadcastReceiver mReceiver;
    private com.bytedance.sdk.component.adexpress.pFF.UFX mRenderListener;
    private com.bytedance.sdk.component.adexpress.pFF.Ql mRenderRequest;
    private ViewGroup mTimeOut;
    private com.bytedance.sdk.component.adexpress.dynamic.pFF muteListener;
    protected final com.bytedance.sdk.component.adexpress.pFF.SR renderResult;
    private int scoreCountWithIcon;
    private List<com.bytedance.sdk.component.adexpress.dynamic.zY> timeOutListener;
    private int timedown;
    private com.bytedance.sdk.component.adexpress.dynamic.ExN videoListener;
    public View videoView;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z11, com.bytedance.sdk.component.adexpress.pFF.Ql ql2, com.bytedance.sdk.component.adexpress.dynamic.TRI.sc scVar) {
        super(context);
        this.mTimeOut = null;
        this.timedown = 0;
        this.timeOutListener = new ArrayList();
        this.logoUnionHeight = 0;
        this.scoreCountWithIcon = 0;
        this.mContext = context;
        com.bytedance.sdk.component.adexpress.pFF.SR sr2 = new com.bytedance.sdk.component.adexpress.pFF.SR();
        this.renderResult = sr2;
        sr2.sc(2);
        this.mDynamicClickListener = scVar;
        scVar.sc(this);
        this.mReceiver = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.sc(this);
        this.mIsMute = z11;
        this.mRenderRequest = ql2;
    }

    private void checkCanOpenLandingPage(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        com.bytedance.sdk.component.adexpress.dynamic.We.TRI triExN;
        com.bytedance.sdk.component.adexpress.dynamic.We.ExN exNWH = qj2.WH();
        if (exNWH == null || (triExN = exNWH.ExN()) == null) {
            return;
        }
        this.renderResult.pFF(triExN.qOv());
    }

    private boolean checkSizeValid() {
        ExN exN = this.dynamicBaseWidget;
        return exN.ExN > 0.0f && exN.TRI > 0.0f;
    }

    private void setClipChildren(ViewGroup viewGroup, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !qj2.FI()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void beginHideFromVisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 4);
    }

    public void beginShowFromInvisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 0);
    }

    public void beginShowFromInvisible(ExN exN, int i11) {
        if (exN == null) {
            return;
        }
        if (exN.getBeginInvisibleAndShow()) {
            exN.setVisibility(i11);
            View view = exN.BT;
            if (view != null) {
                view.setVisibility(i11);
            }
        }
        int childCount = exN.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            if (exN.getChildAt(i12) instanceof ExN) {
                beginShowFromInvisible((ExN) exN.getChildAt(i12), i11);
            }
        }
    }

    public void callBackRenderFail(int i11, String str) {
        this.renderResult.sc(false);
        this.renderResult.pFF(i11);
        this.renderResult.sc(str);
        this.mRenderListener.sc(this.renderResult);
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.bgMaterialCenterCalcColor;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.TRI.sc getDynamicClickListener() {
        return this.mDynamicClickListener;
    }

    public int getLogoUnionHeight() {
        return this.logoUnionHeight;
    }

    public com.bytedance.sdk.component.adexpress.pFF.UFX getRenderListener() {
        return this.mRenderListener;
    }

    public com.bytedance.sdk.component.adexpress.pFF.Ql getRenderRequest() {
        return this.mRenderRequest;
    }

    public int getScoreCountWithIcon() {
        return this.scoreCountWithIcon;
    }

    public ViewGroup getTimeOut() {
        return this.mTimeOut;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.zY> getTimeOutListener() {
        return this.timeOutListener;
    }

    public int getTimedown() {
        return this.timedown;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.sc
    public void onThemeChanged(int i11) {
        ExN exN = this.dynamicBaseWidget;
        if (exN == null) {
            return;
        }
        exN.sc(i11);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void onvideoComplate() {
        try {
            this.videoListener.sc();
        } catch (Exception unused) {
        }
    }

    public void render(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, int i11) {
        this.dynamicBaseWidget = renderDynamicView(qj2, this, i11);
        this.renderResult.sc(true);
        this.renderResult.sc(this.dynamicBaseWidget.ExN);
        this.renderResult.pFF(this.dynamicBaseWidget.TRI);
        this.renderResult.sc(this.videoView);
        this.mRenderListener.sc(this.renderResult);
    }

    public ExN renderDynamicView(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2, ViewGroup viewGroup, int i11) {
        if (qj2 == null) {
            return null;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX = qj2.UFX();
        ExN exNSc = com.bytedance.sdk.component.adexpress.dynamic.sc.pFF.sc(this.mContext, this, qj2);
        if (exNSc instanceof Gb) {
            callBackRenderFail(i11 == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        checkCanOpenLandingPage(qj2);
        exNSc.zY();
        if (viewGroup != null) {
            viewGroup.addView(exNSc);
            setClipChildren(viewGroup, qj2);
        }
        if (listUFX == null || listUFX.size() <= 0) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> it = listUFX.iterator();
        while (it.hasNext()) {
            renderDynamicView(it.next(), exNSc, i11);
        }
        return exNSc;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.bgMaterialCenterCalcColor = map;
    }

    public void setDislikeView(View view) {
        this.mDynamicClickListener.pFF(view);
    }

    public void setLogoUnionHeight(int i11) {
        this.logoUnionHeight = i11;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.pFF pff) {
        this.muteListener = pff;
    }

    public void setRenderListener(com.bytedance.sdk.component.adexpress.pFF.UFX ufx) {
        this.mRenderListener = ufx;
        this.mDynamicClickListener.sc(ufx);
    }

    public void setScoreCountWithIcon(int i11) {
        this.scoreCountWithIcon = i11;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setSoundMute(boolean z11) {
        com.bytedance.sdk.component.adexpress.dynamic.pFF pff = this.muteListener;
        if (pff != null) {
            pff.setSoundMute(z11);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTime(CharSequence charSequence, int i11, int i12, boolean z11) {
        for (int i13 = 0; i13 < this.timeOutListener.size(); i13++) {
            if (this.timeOutListener.get(i13) != null) {
                this.timeOutListener.get(i13).sc(charSequence, i11 == 1, i12, z11);
            }
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.mTimeOut = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.zY zYVar) {
        this.timeOutListener.add(zYVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.We
    public void setTimeUpdate(int i11) {
        this.videoListener.setTimeUpdate(i11);
    }

    public void setTimedown(int i11) {
        this.timedown = i11;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.ExN exN) {
        this.videoListener = exN;
    }

    public void updateRenderInfoForVideo(double d11, double d12, double d13, double d14, float f11) {
        this.renderResult.zY(d11);
        this.renderResult.We(d12);
        this.renderResult.ExN(d13);
        this.renderResult.TRI(d14);
        this.renderResult.sc(f11);
        this.renderResult.pFF(f11);
        this.renderResult.zY(f11);
        this.renderResult.We(f11);
    }
}
