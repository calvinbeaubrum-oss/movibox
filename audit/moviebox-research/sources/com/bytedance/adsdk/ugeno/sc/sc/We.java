package com.bytedance.adsdk.ugeno.sc.sc;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    private static final float BT;
    private static final float SR;
    private static final float Xc;
    private static final float dE;
    private Path ExN;
    private float Ol;
    private int Qj;
    private Path Ql;
    private com.bytedance.adsdk.ugeno.qr.sc.C0234sc TRI;
    private boolean Tf;
    private int UFX;
    private int WH;
    private Paint We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26458qr;
    private float wjp;
    private int zY;

    static {
        float radians = (float) Math.toRadians(30.0d);
        SR = radians;
        BT = (float) Math.tan(radians);
        dE = (float) Math.cos(radians);
        Xc = (float) Math.sin(radians);
    }

    public We(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        super(zYVar, jSONObject);
        this.Tf = true;
        Paint paint = new Paint();
        this.We = paint;
        paint.setAntiAlias(true);
        this.ExN = new Path();
        this.Ol = this.pFF.YIK();
        this.Ql = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void pFF() {
        this.zY = (int) Qj.sc(this.pFF.Ol().getContext(), this.f26460sc.optInt("shineWidth", 30));
        String strOptString = this.f26460sc.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.TRI = com.bytedance.adsdk.ugeno.qr.sc.pFF(str);
        } else {
            int iSc = com.bytedance.adsdk.ugeno.qr.sc.sc(str);
            this.f26458qr = iSc;
            this.Qj = com.bytedance.adsdk.ugeno.qr.sc.sc(iSc, 32);
            this.Tf = false;
        }
        this.wjp = dE * this.zY;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(int i11, int i12) {
        this.WH = i11;
        this.UFX = i12;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i11, i12);
            Path path = this.ExN;
            float f11 = this.Ol;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    @SuppressLint({"DrawAllocation"})
    public void sc(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.pFF.pc() > 0.0f) {
                int i11 = this.WH;
                float f11 = BT;
                float fPc = (i11 + (i11 * f11)) * this.pFF.pc();
                this.Ql.reset();
                this.Ql.moveTo(fPc, 0.0f);
                int i12 = this.UFX;
                float f12 = fPc - (i12 * f11);
                this.Ql.lineTo(f12, i12);
                this.Ql.lineTo(f12 + this.zY, this.UFX);
                this.Ql.lineTo(this.zY + fPc, 0.0f);
                this.Ql.close();
                float f13 = this.wjp;
                float f14 = dE * f13;
                float f15 = f13 * Xc;
                if (!this.Tf || this.TRI == null) {
                    float f16 = fPc + f14;
                    int i13 = this.Qj;
                    linearGradient = new LinearGradient(fPc, 0.0f, f16, f15, new int[]{i13, this.f26458qr, i13}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(fPc, 0.0f, fPc + f14, f15, this.TRI.pFF, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.We.setShader(linearGradient);
                Path path = this.ExN;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.Ql, this.We);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public List<PropertyValuesHolder> zY() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(We(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
