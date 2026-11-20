package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {
    private final SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> BT;
    private final float ExN;
    private final long Ol;
    private final float Qj;
    private final int Ql;
    private final int SR;
    private final JSONObject Sfl;
    private final float TRI;
    private final int Tf;
    private final int UFX;
    private final long WH;
    private final int[] We;
    private final JSONObject Xc;
    private final int dE;
    private final int[] pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final float f28409qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int[] f28410sc;
    private final String wjp;
    private final int[] zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private int BT;
        private JSONObject Dl;
        private long ExN;
        private float Ol;
        private float Qj;
        private int[] Ql;
        private int SR;
        private String Sfl;
        private float TRI;
        private int[] Tf;
        private int[] UFX;
        private int[] WH;
        private long We;
        private SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> Xc;
        private int YIK;
        private int dE;
        int pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private float f28411qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        float f28412sc;
        private JSONObject uEA;
        private int wjp;
        float zY;

        public sc ExN(float f11) {
            this.Qj = f11;
            return this;
        }

        public sc ExN(int i11) {
            this.BT = i11;
            return this;
        }

        public sc TRI(float f11) {
            this.Ol = f11;
            return this;
        }

        public sc TRI(int i11) {
            this.dE = i11;
            return this;
        }

        public sc We(float f11) {
            this.f28411qr = f11;
            return this;
        }

        public sc We(int i11) {
            this.SR = i11;
            return this;
        }

        public sc We(int[] iArr) {
            this.Ql = iArr;
            return this;
        }

        public sc pFF(float f11) {
            this.zY = f11;
            return this;
        }

        public sc pFF(int i11) {
            this.wjp = i11;
            return this;
        }

        public sc pFF(long j11) {
            this.ExN = j11;
            return this;
        }

        public sc pFF(JSONObject jSONObject) {
            this.uEA = jSONObject;
            return this;
        }

        public sc pFF(int[] iArr) {
            this.UFX = iArr;
            return this;
        }

        public sc sc(float f11) {
            this.f28412sc = f11;
            return this;
        }

        public sc sc(int i11) {
            this.YIK = i11;
            return this;
        }

        public sc sc(long j11) {
            this.We = j11;
            return this;
        }

        public sc sc(SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray) {
            this.Xc = sparseArray;
            return this;
        }

        public sc sc(String str) {
            this.Sfl = str;
            return this;
        }

        public sc sc(JSONObject jSONObject) {
            this.Dl = jSONObject;
            return this;
        }

        public sc sc(int[] iArr) {
            this.WH = iArr;
            return this;
        }

        public WH sc() {
            return new WH(this);
        }

        public sc zY(float f11) {
            this.TRI = f11;
            return this;
        }

        public sc zY(int i11) {
            this.pFF = i11;
            return this;
        }

        public sc zY(int[] iArr) {
            this.Tf = iArr;
            return this;
        }
    }

    private WH(@NonNull sc scVar) {
        this.f28410sc = scVar.UFX;
        this.pFF = scVar.Tf;
        this.We = scVar.Ql;
        this.zY = scVar.WH;
        this.ExN = scVar.Ol;
        this.TRI = scVar.Qj;
        this.f28409qr = scVar.f28411qr;
        this.Qj = scVar.TRI;
        this.Ol = scVar.ExN;
        this.WH = scVar.We;
        this.UFX = scVar.SR;
        this.Tf = scVar.BT;
        this.Ql = scVar.dE;
        this.SR = scVar.wjp;
        this.BT = scVar.Xc;
        this.wjp = scVar.Sfl;
        this.dE = scVar.YIK;
        this.Xc = scVar.Dl;
        this.Sfl = scVar.uEA;
    }

    public static JSONObject sc(SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (sparseArray != null) {
                for (int i12 = 0; i12 < sparseArray.size(); i12++) {
                    com.bytedance.sdk.openadsdk.core.pFF.zY.sc scVarValueAt = sparseArray.valueAt(i12);
                    if (scVarValueAt != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("force", Double.valueOf(scVarValueAt.zY)).putOpt("mr", Double.valueOf(scVarValueAt.pFF)).putOpt("phase", Integer.valueOf(scVarValueAt.f28466sc)).putOpt("ts", Long.valueOf(scVarValueAt.We));
                        jSONArray.put(jSONObject2);
                        jSONObject.putOpt("ftc", Integer.valueOf(i11)).putOpt("info", jSONArray);
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject sc() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.Sfl;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.Sfl.opt(next));
                    }
                } catch (Exception unused) {
                }
            }
            int[] iArr = this.f28410sc;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.f28410sc[1]));
            }
            int[] iArr2 = this.pFF;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.pFF[1]));
            }
            int[] iArr3 = this.zY;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.zY[1]));
            }
            int[] iArr4 = this.We;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.We[1]));
            }
            jSONObject.putOpt("down_x", Float.toString(this.ExN)).putOpt("down_y", Float.toString(this.TRI)).putOpt("up_x", Float.toString(this.f28409qr)).putOpt("up_y", Float.toString(this.Qj)).putOpt("down_time", Long.valueOf(this.Ol)).putOpt("up_time", Long.valueOf(this.WH)).putOpt("toolType", Integer.valueOf(this.UFX)).putOpt("deviceId", Integer.valueOf(this.Tf)).putOpt("source", Integer.valueOf(this.Ql)).putOpt("ft", sc(this.BT, this.SR)).putOpt("click_area_type", this.wjp);
            int i11 = this.dE;
            if (i11 > 0) {
                jSONObject.putOpt("areaType", Integer.valueOf(i11));
            }
            JSONObject jSONObject3 = this.Xc;
            if (jSONObject3 != null) {
                jSONObject.putOpt("rectInfo", jSONObject3);
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }
}
