package com.bytedance.adsdk.ugeno.sc;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private int ExN;
    private com.bytedance.adsdk.ugeno.sc.sc.sc TRI;
    private Context We;
    private pFF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.pFF.zY f26455sc;
    private ValueAnimator zY;

    public sc(Context context, com.bytedance.adsdk.ugeno.pFF.zY zYVar, pFF pff) {
        this.f26455sc = zYVar;
        this.pFF = pff;
        this.We = context;
    }

    public void pFF() {
        ValueAnimator valueAnimator = this.zY;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void sc() {
        ValueAnimator valueAnimator = this.zY;
        if (valueAnimator == null || this.ExN == -2) {
            return;
        }
        valueAnimator.start();
    }

    public void sc(int i11, int i12) {
        com.bytedance.adsdk.ugeno.sc.sc.sc scVar = this.TRI;
        if (scVar != null) {
            scVar.sc(i11, i12);
        }
    }

    public void sc(Canvas canvas) {
        com.bytedance.adsdk.ugeno.sc.sc.sc scVar = this.TRI;
        if (scVar != null) {
            scVar.sc(canvas);
        }
    }

    public ValueAnimator zY() {
        com.bytedance.adsdk.ugeno.sc.pFF.sc zYVar;
        pFF pff = this.pFF;
        if (pff == null || this.f26455sc == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapPFF = pff.pFF();
        ArrayList arrayList = new ArrayList();
        if (mapPFF != null && !mapPFF.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapPFF.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String strZY = We.sc(key).zY();
                    strZY.hashCode();
                    switch (strZY) {
                        case "int":
                            zYVar = new com.bytedance.adsdk.ugeno.sc.pFF.zY(this.We, this.f26455sc, key, entry.getValue());
                            break;
                        case "float":
                            zYVar = new com.bytedance.adsdk.ugeno.sc.pFF.pFF(this.We, this.f26455sc, key, entry.getValue());
                            break;
                        case "point":
                            zYVar = new com.bytedance.adsdk.ugeno.sc.pFF.We(this.We, this.f26455sc, key, entry.getValue());
                            break;
                        default:
                            zYVar = null;
                            break;
                    }
                    if (zYVar != null) {
                        arrayList.addAll(zYVar.ExN());
                    }
                }
            }
        }
        JSONObject jSONObjectSc = this.pFF.sc();
        if (jSONObjectSc != null) {
            com.bytedance.adsdk.ugeno.sc.sc.sc scVarSc = com.bytedance.adsdk.ugeno.sc.sc.sc.C0236sc.sc(this.f26455sc, jSONObjectSc);
            this.TRI = scVarSc;
            if (scVarSc != null) {
                arrayList.addAll(scVarSc.zY());
            }
        }
        final View viewOl = this.f26455sc.Ol();
        if (viewOl == null) {
            return null;
        }
        final pFF.sc scVarQr = this.pFF.qr();
        if (scVarQr != null) {
            viewOl.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.sc.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewOl.getWidth();
                    int height = viewOl.getHeight();
                    viewOl.setPivotX(zY.sc(scVarQr.f26450sc, width));
                    viewOl.setPivotY(zY.sc(scVarQr.pFF, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewOl, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.ExN = zY.sc(this.pFF.We());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.pFF.zY());
        int i11 = this.ExN;
        if (i11 != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i11);
        }
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.pFF.TRI());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(zY.sc(this.pFF.ExN()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(zY.pFF(this.pFF.Qj()));
        this.zY = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }
}
