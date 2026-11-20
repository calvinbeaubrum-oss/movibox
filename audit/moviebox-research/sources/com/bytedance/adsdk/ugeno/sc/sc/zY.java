package com.bytedance.adsdk.ugeno.sc.sc;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends sc {
    private float ExN;
    private PorterDuffXfermode Ol;
    private Paint Qj;
    private View TRI;
    private Matrix UFX;
    private LinearGradient WH;
    private float We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Paint f26461qr;
    private String zY;

    public zY(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        super(zYVar, jSONObject);
        this.TRI = this.pFF.Ol();
        Paint paint = new Paint();
        this.f26461qr = paint;
        paint.setAntiAlias(true);
        this.TRI.setLayerType(2, null);
        this.Ol = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.Qj = new Paint();
        this.UFX = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void pFF() {
        this.zY = this.f26460sc.optString("direction", TtmlNode.LEFT);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(int i11, int i12) {
        this.We = i11;
        this.ExN = i12;
        String str = this.zY;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.WH = new LinearGradient(0.0f, -this.ExN, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.WH = new LinearGradient(0.0f, this.ExN, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.WH = new LinearGradient(this.We, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.WH = new LinearGradient(-this.We, 0.0f, 0.0f, this.ExN, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(Canvas canvas) {
        byte b11;
        try {
            if (this.pFF.MxZ() > 0.0f) {
                int iMxZ = (int) (this.We * this.pFF.MxZ());
                int iMxZ2 = (int) (this.ExN * this.pFF.MxZ());
                this.f26461qr.setXfermode(this.Ol);
                String str = this.zY;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (!str.equals("bottom")) {
                            b11 = -1;
                        } else {
                            b11 = 2;
                        }
                        break;
                    case 115029:
                        if (!str.equals("top")) {
                            b11 = -1;
                        } else {
                            b11 = 3;
                        }
                        break;
                    case 3317767:
                        if (!str.equals(TtmlNode.LEFT)) {
                            b11 = -1;
                        } else {
                            b11 = 1;
                        }
                        break;
                    case 108511772:
                        if (!str.equals(TtmlNode.RIGHT)) {
                            b11 = -1;
                        } else {
                            b11 = 0;
                        }
                        break;
                    default:
                        b11 = -1;
                        break;
                }
                if (b11 == 0) {
                    float f11 = iMxZ;
                    canvas.drawRect(f11, 0.0f, this.We, this.ExN, this.f26461qr);
                    this.UFX.setTranslate(f11, this.ExN);
                    this.WH.setLocalMatrix(this.UFX);
                    this.Qj.setShader(this.WH);
                    if (this.pFF.MxZ() <= 1.0f && this.pFF.MxZ() > 0.9f) {
                        this.Qj.setAlpha((int) (255.0f - (this.pFF.MxZ() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f11, this.ExN, this.Qj);
                    return;
                }
                if (b11 == 1) {
                    float f12 = iMxZ;
                    canvas.drawRect(0.0f, 0.0f, this.We - f12, this.ExN, this.f26461qr);
                    this.UFX.setTranslate(this.We - f12, 0.0f);
                    this.WH.setLocalMatrix(this.UFX);
                    this.Qj.setShader(this.WH);
                    if (this.pFF.MxZ() <= 1.0f && this.pFF.MxZ() > 0.9f) {
                        this.Qj.setAlpha((int) (255.0f - (this.pFF.MxZ() * 255.0f)));
                    }
                    float f13 = this.We;
                    canvas.drawRect(f13, this.ExN, f13 - f12, 0.0f, this.Qj);
                    return;
                }
                if (b11 == 2) {
                    float f14 = iMxZ2;
                    canvas.drawRect(0.0f, f14, this.We, this.ExN, this.f26461qr);
                    this.UFX.setTranslate(0.0f, f14);
                    this.WH.setLocalMatrix(this.UFX);
                    this.Qj.setShader(this.WH);
                    if (this.pFF.MxZ() <= 1.0f && this.pFF.MxZ() > 0.9f) {
                        this.Qj.setAlpha((int) (255.0f - (this.pFF.MxZ() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.We, f14, this.Qj);
                    return;
                }
                if (b11 != 3) {
                    return;
                }
                float f15 = iMxZ2;
                canvas.drawRect(0.0f, 0.0f, this.We, this.ExN - f15, this.f26461qr);
                this.UFX.setTranslate(0.0f, this.ExN - f15);
                this.WH.setLocalMatrix(this.UFX);
                this.Qj.setShader(this.WH);
                if (this.pFF.MxZ() <= 1.0f && this.pFF.MxZ() > 0.9f) {
                    this.Qj.setAlpha((int) (255.0f - (this.pFF.MxZ() * 255.0f)));
                }
                float f16 = this.We;
                float f17 = this.ExN;
                canvas.drawRect(f16, f17, 0.0f, f17 - f15, this.Qj);
            }
        } catch (Throwable th2) {
            Log.e("BaseEffectWrapper", th2.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public List<PropertyValuesHolder> zY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.sc.We.ALPHA.pFF(), 0.0f, 1.0f));
        return arrayList;
    }
}
