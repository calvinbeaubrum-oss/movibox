package com.bytedance.adsdk.ugeno.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private long ExN;
    private String TRI;
    private long We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26407sc;
    private List<C0231sc> zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0231sc {
        private String ExN;
        private String Ol;
        private float[] Qj;
        private float TRI;
        private String WH;
        private long We;
        private float pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private float f26408qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private long f26409sc;
        private String zY;

        public static C0231sc sc(JSONObject jSONObject, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
            if (jSONObject == null) {
                return null;
            }
            C0231sc c0231sc = new C0231sc();
            c0231sc.sc(jSONObject.optLong("duration"));
            String strOptString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", strOptString)) {
                c0231sc.sc(-1.0f);
            } else {
                try {
                    c0231sc.sc(Float.parseFloat(strOptString));
                } catch (NumberFormatException unused) {
                    c0231sc.sc(0.0f);
                }
            }
            c0231sc.sc(jSONObject.optString("loopMode"));
            c0231sc.pFF(jSONObject.optString("type"));
            if (TextUtils.equals(c0231sc.ExN(), "ripple")) {
                c0231sc.zY(jSONObject.optString("rippleColor"));
            }
            View viewOl = zYVar.Ol();
            Context context = viewOl != null ? viewOl.getContext() : null;
            if (TextUtils.equals(c0231sc.ExN(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                String strSc = com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObject.optString("valueTo"), zYVar.WH());
                int iSc = com.bytedance.adsdk.ugeno.qr.sc.sc(jSONObject.optString("valueFrom"));
                int iSc2 = com.bytedance.adsdk.ugeno.qr.sc.sc(strSc);
                c0231sc.pFF(iSc);
                c0231sc.zY(iSc2);
            } else if ((TextUtils.equals(c0231sc.ExN(), "translateX") || TextUtils.equals(c0231sc.ExN(), "translateY")) && context != null) {
                try {
                    float fSc = com.bytedance.adsdk.ugeno.qr.Qj.sc(context, (float) jSONObject.optDouble("valueFrom"));
                    float fSc2 = com.bytedance.adsdk.ugeno.qr.Qj.sc(context, (float) jSONObject.optDouble("valueTo"));
                    c0231sc.pFF(fSc);
                    c0231sc.zY(fSc2);
                } catch (Exception unused2) {
                    Log.e("animation", "animation ");
                }
            } else {
                c0231sc.pFF((float) jSONObject.optDouble("valueFrom"));
                c0231sc.zY((float) jSONObject.optDouble("valueTo"));
            }
            c0231sc.We(jSONObject.optString("interpolator"));
            c0231sc.pFF(com.bytedance.adsdk.ugeno.qr.zY.sc(com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObject.optString("startDelay"), zYVar.WH()), 0L));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                float[] fArr = new float[jSONArrayOptJSONArray.length()];
                int i11 = 0;
                if ((TextUtils.equals(c0231sc.ExN(), "translateX") || TextUtils.equals(c0231sc.ExN(), "translateY")) && context != null) {
                    while (i11 < jSONArrayOptJSONArray.length()) {
                        fArr[i11] = com.bytedance.adsdk.ugeno.qr.Qj.sc(context, (float) sc.sc(jSONArrayOptJSONArray.optString(i11), zYVar.WH()));
                        i11++;
                    }
                } else {
                    while (i11 < jSONArrayOptJSONArray.length()) {
                        fArr[i11] = (float) sc.sc(jSONArrayOptJSONArray.optString(i11), zYVar.WH());
                        i11++;
                    }
                }
                c0231sc.sc(fArr);
            }
            return c0231sc;
        }

        public String ExN() {
            return this.ExN;
        }

        public String Ol() {
            return this.Ol;
        }

        public float[] Qj() {
            return this.Qj;
        }

        public float TRI() {
            return this.TRI;
        }

        public String WH() {
            return this.WH;
        }

        public long We() {
            return this.We;
        }

        public void We(String str) {
            this.Ol = str;
        }

        public float pFF() {
            return this.pFF;
        }

        public void pFF(float f11) {
            this.TRI = f11;
        }

        public void pFF(long j11) {
            this.We = j11;
        }

        public void pFF(String str) {
            this.ExN = str;
        }

        public float qr() {
            return this.f26408qr;
        }

        public long sc() {
            return this.f26409sc;
        }

        public void sc(float f11) {
            this.pFF = f11;
        }

        public void sc(long j11) {
            this.f26409sc = j11;
        }

        public void sc(String str) {
            this.zY = str;
        }

        public void sc(float[] fArr) {
            this.Qj = fArr;
        }

        public String zY() {
            return this.zY;
        }

        public void zY(float f11) {
            this.f26408qr = f11;
        }

        public void zY(String str) {
            this.WH = str;
        }
    }

    public static double sc(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.qr.zY.sc(com.bytedance.adsdk.ugeno.zY.pFF.sc((String) obj, jSONObject), 0.0d);
        }
        if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof Integer)) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }

    public static sc sc(String str, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return sc(new JSONObject(str), zYVar);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static sc sc(JSONObject jSONObject, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        return sc(jSONObject, null, zYVar);
    }

    public static sc sc(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        if (jSONObject == null) {
            return null;
        }
        sc scVar = new sc();
        scVar.sc(jSONObject.optString("ordering"));
        String strOptString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", strOptString)) {
            scVar.sc(-1.0f);
        } else {
            try {
                scVar.sc(Float.parseFloat(strOptString));
            } catch (NumberFormatException unused) {
                scVar.sc(0.0f);
            }
        }
        scVar.sc(jSONObject.optLong("duration", 0L));
        scVar.pFF(com.bytedance.adsdk.ugeno.qr.zY.sc(com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObject.optString("startDelay"), zYVar.WH()), 0L));
        scVar.pFF(jSONObject.optString("loopMode"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animators");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.qr.pFF.sc(jSONObject2, jSONObjectOptJSONObject);
                }
                arrayList.add(C0231sc.sc(jSONObjectOptJSONObject, zYVar));
            }
            scVar.sc(arrayList);
        }
        return scVar;
    }

    public long ExN() {
        return this.ExN;
    }

    public String TRI() {
        return this.TRI;
    }

    public long We() {
        return this.We;
    }

    public float pFF() {
        return this.pFF;
    }

    public void pFF(long j11) {
        this.ExN = j11;
    }

    public void pFF(String str) {
        this.TRI = str;
    }

    public String sc() {
        return this.f26407sc;
    }

    public void sc(float f11) {
        this.pFF = f11;
    }

    public void sc(long j11) {
        this.We = j11;
    }

    public void sc(String str) {
        this.f26407sc = str;
    }

    public void sc(List<C0231sc> list) {
        this.zY = list;
    }

    public List<C0231sc> zY() {
        return this.zY;
    }
}
