package com.bytedance.adsdk.ugeno.sc.sc;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc {
    protected com.bytedance.adsdk.ugeno.pFF.zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected JSONObject f26460sc;
    private String zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.sc.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0236sc {
        public static sc sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
            if (zYVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new ExN(zYVar, jSONObject);
                case "ripple":
                    return new pFF(zYVar, jSONObject);
                case "rub_in":
                    return new zY(zYVar, jSONObject);
                case "shine":
                    return new We(zYVar, jSONObject);
                default:
                    return null;
            }
        }
    }

    public sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, JSONObject jSONObject) {
        this.f26460sc = jSONObject;
        this.pFF = zYVar;
        sc();
    }

    public String We() {
        return this.zY;
    }

    public abstract void pFF();

    public void sc() {
        this.zY = this.f26460sc.optString("type");
        pFF();
    }

    public abstract void sc(int i11, int i12);

    public abstract void sc(Canvas canvas);

    public abstract List<PropertyValuesHolder> zY();
}
