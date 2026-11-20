package com.mbridge.msdk.video.dynview.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.dynview.moffer.b;
import com.mbridge.msdk.video.dynview.moffer.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f47782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f47783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimatorSet f47784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f47786e;

    public MBridgeRelativeLayout(Context context) {
        super(context);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnimatorSet animatorSet = this.f47784c;
        if (animatorSet != null) {
            try {
                animatorSet.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d dVar;
        super.onDetachedFromWindow();
        if (!this.f47783b && (dVar = this.f47782a) != null) {
            this.f47783b = true;
            dVar.a();
        }
        AnimatorSet animatorSet = this.f47784c;
        if (animatorSet != null) {
            try {
                animatorSet.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i11) {
        b bVar;
        super.onVisibilityChanged(view, i11);
        if (!(view instanceof MBridgeRelativeLayout) || i11 != 0 || (bVar = this.f47786e) == null || this.f47785d) {
            return;
        }
        this.f47785d = true;
        bVar.a();
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f47784c = animatorSet;
    }

    public void setMoreOfferCacheReportCallBack(b bVar) {
        this.f47786e = bVar;
    }

    public void setMoreOfferShowFailedCallBack(d dVar) {
        this.f47782a = dVar;
    }
}
