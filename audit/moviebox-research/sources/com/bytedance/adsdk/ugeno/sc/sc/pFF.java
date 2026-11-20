package com.bytedance.adsdk.ugeno.sc.sc;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static final int f26459qr = Color.parseColor("#7ed321");
    private int ExN;
    private Paint TRI;
    private int We;
    private int zY;

    public pFF(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        super(zYVar, jSONObject);
        Paint paint = new Paint();
        this.TRI = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void pFF() {
        this.zY = com.bytedance.adsdk.ugeno.qr.sc.sc(this.f26460sc.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), f26459qr);
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(int i11, int i12) {
        this.We = i11 / 2;
        this.ExN = i12 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.sc.sc.sc
    public void sc(Canvas canvas) {
        try {
            if (this.pFF.qKn() > 0.0f) {
                this.TRI.setColor(this.zY);
                this.TRI.setAlpha((int) ((1.0f - this.pFF.qKn()) * 255.0f));
                ((ViewGroup) this.pFF.Ol().getParent()).setClipChildren(true);
                int i11 = this.We;
                int i12 = this.ExN;
                canvas.drawCircle(i11, i12, Math.min(i11, i12) * 2 * this.pFF.qKn(), this.TRI);
            }
        } catch (Throwable th2) {
            new StringBuilder("ripple animation error ").append(th2.getMessage());
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
