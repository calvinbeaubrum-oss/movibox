package com.bytedance.sdk.component.adexpress.dynamic.animation.sc;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends We {
    private float ExN;
    private float TRI;
    private sc We;

    /* JADX INFO: compiled from: source.java */
    public class sc {
        private View pFF;

        public sc(View view) {
            this.pFF = view;
        }

        public void sc(int i11) {
            if (!"top".equals(WH.this.pFF.sc())) {
                ViewGroup.LayoutParams layoutParams = this.pFF.getLayoutParams();
                layoutParams.height = i11;
                this.pFF.setLayoutParams(layoutParams);
                this.pFF.requestLayout();
                return;
            }
            if (WH.this.zY instanceof ViewGroup) {
                for (int i12 = 0; i12 < ((ViewGroup) WH.this.zY).getChildCount(); i12++) {
                    ((ViewGroup) WH.this.zY).getChildAt(i12).setTranslationY(i11 - WH.this.ExN);
                }
            }
            WH wh2 = WH.this;
            wh2.zY.setTranslationY(wh2.ExN - i11);
        }
    }

    public WH(View view, com.bytedance.sdk.component.adexpress.dynamic.We.sc scVar) {
        super(view, scVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.sc.We
    public List<ObjectAnimator> sc() {
        int i11;
        String str;
        View view = this.zY;
        if ((view instanceof ImageView) && (view.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN)) {
            this.zY = (View) this.zY.getParent();
        }
        this.zY.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zY, "alpha", 0.0f, 1.0f).setDuration((int) (this.pFF.WH() * 1000.0d));
        this.We = new sc(this.zY);
        final int i12 = this.zY.getLayoutParams().height;
        this.ExN = i12;
        this.TRI = this.zY.getLayoutParams().width;
        if (TtmlNode.LEFT.equals(this.pFF.sc()) || TtmlNode.RIGHT.equals(this.pFF.sc())) {
            i11 = (int) this.TRI;
            str = "width";
        } else {
            str = "height";
            i11 = i12;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.We, str, 0, i11).setDuration((int) (this.pFF.WH() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(sc(duration));
        arrayList.add(sc(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.sc.WH.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WH.this.We.sc(i12);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z11) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z11) {
            }
        });
        return arrayList;
    }
}
