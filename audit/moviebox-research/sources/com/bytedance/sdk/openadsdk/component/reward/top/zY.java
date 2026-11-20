package com.bytedance.sdk.openadsdk.component.reward.top;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends View implements sc<zY> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private sc<zY> f27950sc;

    public zY(Context context) {
        this(context, null);
    }

    public zY(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public zY(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setVisibility(8);
        setWillNotDraw(true);
    }

    private void sc(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
        if (view != null) {
            view.setId(SR.Ao);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void clickSkip() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.clickSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void clickSound() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.clickSound();
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public View getCloseButton() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            return scVar.getCloseButton();
        }
        return null;
    }

    public View getITopLayout() {
        Object obj = this.f27950sc;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(0, 0);
    }

    public zY sc(@NonNull Sfl sfl) {
        if (this.f27950sc != null) {
            return this;
        }
        TopLayoutDislike2 topLayoutDislike2M100load = new TopLayoutDislike2(getContext()).load(sfl);
        this.f27950sc = topLayoutDislike2M100load;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            sc(topLayoutDislike2M100load, (ViewGroup) parent);
        }
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setListener(pFF pff) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setListener(pff);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowDislike(boolean z11) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setShowDislike(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowSkip(boolean z11) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setShowSkip(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowSound(boolean z11) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setShowSound(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipEnable(boolean z11) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setSkipEnable(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipInvisiable() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setSkipInvisiable();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipText(CharSequence charSequence) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setSkipText(charSequence);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSoundMute(boolean z11) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setSoundMute(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.setTime(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showCloseButton() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.showCloseButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showCountDownText() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.showCountDownText();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showSkipButton() {
        sc<zY> scVar = this.f27950sc;
        if (scVar != null) {
            scVar.showSkipButton();
        }
    }
}
