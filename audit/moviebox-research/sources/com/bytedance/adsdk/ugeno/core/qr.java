package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {
    private int ExN;
    private int TRI;
    private View We;
    private sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26404qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Paint f26405sc;
    private AnimatorSet zY = new AnimatorSet();

    public qr(View view, sc scVar) {
        this.We = view;
        this.pFF = scVar;
        Paint paint = new Paint();
        this.f26405sc = paint;
        paint.setAntiAlias(true);
    }

    public void pFF() {
        AnimatorSet animatorSet = this.zY;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:50:0x0147  */
    public void sc() {
        ArrayList arrayList = new ArrayList();
        List<sc.C0231sc> listZY = this.pFF.zY();
        if (listZY == null || listZY.size() <= 0) {
            return;
        }
        for (sc.C0231sc c0231sc : listZY) {
            if (c0231sc != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0231sc.sc());
                if (TextUtils.equals(c0231sc.ExN(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0231sc.ExN(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0231sc.ExN());
                }
                objectAnimator.setStartDelay(c0231sc.We());
                objectAnimator.setTarget(this.We);
                if (TextUtils.equals(c0231sc.ExN(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setIntValues((int) c0231sc.TRI(), (int) c0231sc.qr());
                    StringBuilder sb2 = new StringBuilder("playAnimation: from = ");
                    sb2.append(c0231sc.TRI());
                    sb2.append("; to=");
                    sb2.append(c0231sc.qr());
                } else {
                    objectAnimator.setFloatValues(c0231sc.TRI(), c0231sc.qr());
                }
                int iPFF = (int) this.pFF.pFF();
                if (iPFF != 0) {
                    objectAnimator.setRepeatCount(iPFF);
                } else {
                    objectAnimator.setRepeatCount((int) c0231sc.pFF());
                }
                if (TextUtils.equals(c0231sc.ExN(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strTRI = this.pFF.TRI();
                if (TextUtils.isEmpty(strTRI)) {
                    strTRI = c0231sc.zY();
                }
                if (TextUtils.equals(strTRI, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0231sc.Qj() != null && c0231sc.Qj().length > 0) {
                    objectAnimator.setFloatValues(c0231sc.Qj());
                }
                if (TextUtils.equals(c0231sc.ExN(), "rotationX")) {
                    this.We.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.qr.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qr.this.We.setPivotX(qr.this.We.getWidth() / 2.0f);
                            qr.this.We.setPivotY(qr.this.We.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0231sc.ExN(), "ripple")) {
                    this.f26404qr = c0231sc.WH();
                }
                String strOl = c0231sc.Ol();
                strOl.hashCode();
                switch (strOl) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.pFF.We() != 0) {
            this.zY.setDuration(this.pFF.We());
        }
        this.zY.setStartDelay(this.pFF.ExN());
        if (TextUtils.equals(this.pFF.sc(), "sequentially")) {
            this.zY.playSequentially(arrayList);
        } else {
            this.zY.playTogether(arrayList);
        }
        this.zY.start();
    }

    public void sc(int i11, int i12) {
        this.ExN = i11 / 2;
        this.TRI = i12 / 2;
    }

    public void sc(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.f26404qr)) {
                return;
            }
            this.f26405sc.setColor(com.bytedance.adsdk.ugeno.qr.sc.sc(this.f26404qr));
            this.f26405sc.setAlpha(90);
            ((ViewGroup) this.We.getParent()).setClipChildren(true);
            int i11 = this.ExN;
            int i12 = this.TRI;
            canvas.drawCircle(i11, i12, Math.min(i11, i12) * 2 * iAnimation.getRipple(), this.f26405sc);
        } catch (Throwable th2) {
            new StringBuilder("ripple animation error ").append(th2.getMessage());
        }
    }
}
