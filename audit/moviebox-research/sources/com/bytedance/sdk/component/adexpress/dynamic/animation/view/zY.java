package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.We.Qj;
import com.bytedance.sdk.component.adexpress.dynamic.We.qr;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.UFX;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.tn.lib.view.FlowLayout;
import com.transsion.gslb.Utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    private int ExN;
    private int TRI;
    private int We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Paint f26787sc;
    Path pFF = new Path();
    Path zY = new Path();

    public zY() {
        Paint paint = new Paint();
        this.f26787sc = paint;
        paint.setAntiAlias(true);
    }

    public void sc(Canvas canvas, IAnimation iAnimation, View view) {
        int iIntValue;
        int iIntValue2;
        String str;
        float[] fArrPFF;
        if (iAnimation.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrPFF = qr.pFF(str);
                    } catch (Exception unused) {
                        fArrPFF = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith(Utils.SEPARATOR)) {
                    this.f26787sc.setColor(Color.parseColor(str));
                    this.f26787sc.setAlpha(90);
                } else if (fArrPFF != null) {
                    this.f26787sc.setColor(Qj.sc(fArrPFF[3] * (1.0f - iAnimation.getRippleValue()), fArrPFF[0] / 256.0f, fArrPFF[1] / 256.0f, fArrPFF[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i11 = this.We;
            int i12 = this.ExN;
            canvas.drawCircle(i11, i12, Math.min(i11, i12) * 2 * iAnimation.getRippleValue(), this.f26787sc);
        }
        if (iAnimation.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.pFF.reset();
            try {
                iIntValue2 = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue2 = 0;
            }
            if (iIntValue2 >= 0) {
                int shineValue = ((int) ((((this.We * 4) + (iIntValue2 * 2)) + (this.ExN * 2)) * iAnimation.getShineValue())) - ((this.ExN * 2) + iIntValue2);
                float f11 = shineValue;
                int i13 = this.ExN;
                this.f26787sc.setShader(new LinearGradient(f11, 0.0f, ((iIntValue2 + i13) / 2) + shineValue, i13 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.f26787sc.setStrokeWidth(this.We * 2);
                Path path = this.zY;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i14 = shineValue + iIntValue2;
                int i15 = this.ExN;
                canvas.drawLine(f11, 0.0f, i14 + i15, i15, this.f26787sc);
            }
        }
        if (iAnimation.getMarqueeValue() != 0.0f) {
            try {
                iIntValue = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                this.pFF.reset();
                this.pFF.moveTo(0.0f, 0.0f);
                this.pFF.lineTo(this.We * 2, 0.0f);
                this.pFF.lineTo(this.We * 2, this.ExN * 2);
                this.pFF.lineTo(0.0f, this.ExN * 2);
                this.pFF.lineTo(0.0f, 0.0f);
                this.f26787sc.setShader(new LinearGradient(0.0f, 0.0f, this.We * 2, this.ExN * 2, new int[]{(int) (iAnimation.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - iAnimation.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.f26787sc.setColor(FlowLayout.SPACING_AUTO);
                this.f26787sc.setStyle(Paint.Style.STROKE);
                this.f26787sc.setStrokeWidth(iIntValue);
                canvas.drawPath(this.pFF, this.f26787sc);
            }
        }
    }

    public void sc(View view, float f11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i11 = this.TRI;
        int i12 = (int) (i11 * f11);
        layoutParams.width = i12;
        view.setTranslationX((i11 - i12) / 2);
        if (view instanceof UFX) {
            int i13 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i13 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i13).setTranslationX((-(this.TRI - layoutParams.width)) / 2);
                i13++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void sc(View view, int i11, int i12) {
        String str;
        this.We = i11 / 2;
        this.ExN = i12 / 2;
        if (this.TRI == 0 && view.getLayoutParams().width > 0) {
            this.TRI = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.zY.addRoundRect(new RectF(0.0f, 0.0f, i11, i12), i12 / 2, i12 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (TtmlNode.RIGHT.equals(str)) {
            view.setPivotX(this.We * 2);
            view.setPivotY(this.ExN);
        } else if (TtmlNode.LEFT.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.ExN);
        } else {
            view.setPivotX(this.We);
            view.setPivotY(this.ExN);
        }
    }
}
