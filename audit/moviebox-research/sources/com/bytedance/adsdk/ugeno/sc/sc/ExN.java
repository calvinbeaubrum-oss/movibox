package com.bytedance.adsdk.ugeno.sc.sc;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends sc {
    private Paint ExN;
    private boolean Ol;
    private boolean Qj;
    private PorterDuffXfermode Ql;
    private float TRI;
    private Path Tf;
    private Path UFX;
    private Path WH;
    private float We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26457qr;
    private float zY;

    public ExN(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        super(zYVar, jSONObject);
        this.Qj = true;
        this.Ol = true;
        Paint paint = new Paint();
        this.ExN = paint;
        paint.setAntiAlias(true);
        this.pFF.Ol().setLayerType(2, null);
        this.Ql = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.WH = new Path();
        this.UFX = new Path();
        this.Tf = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void pFF() {
        this.TRI = (float) this.f26460sc.optDouble("start", 0.0d);
        this.f26457qr = this.f26460sc.optString("direction", TtmlNode.CENTER);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(int i11, int i12) {
        if (i11 > 0 && this.Qj) {
            this.zY = i11;
            this.Qj = false;
        }
        if (i12 <= 0 || !this.Ol) {
            return;
        }
        this.We = i12;
        this.Ol = false;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(Canvas canvas) {
        if (this.pFF.GI() > 0.0f) {
            int iGI = (int) (this.zY * this.pFF.GI());
            int iGI2 = (int) (this.We * this.pFF.GI());
            this.ExN.setXfermode(this.Ql);
            String str = this.f26457qr;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iGI2, this.zY, this.We, this.ExN);
                    break;
                case "center":
                    this.WH.reset();
                    this.UFX.reset();
                    this.Tf.reset();
                    Path.Direction direction = Path.Direction.CW;
                    this.WH.addCircle(this.zY / 2.0f, this.We / 2.0f, iGI, direction);
                    Path path = this.UFX;
                    float f11 = this.zY;
                    path.addRect(f11 / 2.0f, 0.0f, f11, this.We, direction);
                    Path path2 = this.UFX;
                    Path path3 = this.WH;
                    Path.Op op2 = Path.Op.DIFFERENCE;
                    path2.op(path3, op2);
                    this.Tf.addRect(0.0f, 0.0f, this.zY / 2.0f, this.We, direction);
                    this.Tf.op(this.WH, op2);
                    canvas.drawPath(this.UFX, this.ExN);
                    canvas.drawPath(this.Tf, this.ExN);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.zY, this.We - iGI2, this.ExN);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.zY - iGI, this.We, this.ExN);
                    break;
                case "right":
                    canvas.drawRect(iGI, 0.0f, this.zY, this.We, this.ExN);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public List<PropertyValuesHolder> zY() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(We(), this.TRI, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
