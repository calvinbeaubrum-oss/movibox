package com.bytedance.sdk.openadsdk.core.Tf;

import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    protected String ExN;
    protected String Qj;
    protected List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> TRI;
    private Sfl Tf;
    private String WH;
    protected com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF We;
    protected int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> f28240qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected int f28241sc;
    protected com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc zY;
    private final AtomicBoolean UFX = new AtomicBoolean(false);
    protected String Ol = "endcard_click";

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.Tf.zY$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f28242sc;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.values().length];
            f28242sc = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.STATIC_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28242sc[com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28242sc[com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.IFRAME_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public zY(int i11, int i12, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff, String str, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list2, String str2) {
        this.TRI = new ArrayList();
        this.f28240qr = new ArrayList();
        this.f28241sc = i11;
        this.pFF = i12;
        this.zY = enumC0293sc;
        this.We = pff;
        this.ExN = str;
        this.TRI = list;
        this.f28240qr = list2;
        this.Qj = str2;
    }

    public static zY pFF(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("width");
        int iOptInt2 = jSONObject.optInt("height");
        String strOptString = jSONObject.optString("creativeType", com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.NONE.toString());
        String strOptString2 = jSONObject.optString("resourceType", com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.HTML_RESOURCE.toString());
        String strOptString3 = jSONObject.optString("contentUrl");
        String strOptString4 = jSONObject.optString("clickThroughUri");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("clickTrackers");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("creativeViewTrackers");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            arrayList.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONArrayOptJSONArray.optString(i11)).sc());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
            arrayList2.add(new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONArrayOptJSONArray2.optString(i12)).sc());
        }
        return new zY(iOptInt, iOptInt2, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.valueOf(strOptString), com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.valueOf(strOptString2), strOptString3, arrayList, arrayList2, strOptString4);
    }

    public static float sc(int i11, int i12, int i13, int i14, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc) {
        if (i12 == 0 || i14 == 0) {
            return 0.0f;
        }
        float f11 = i11;
        float f12 = i13;
        return sc(pff, enumC0293sc) / ((Math.abs((f11 / i12) - (f12 / i14)) + Math.abs((f11 - f12) / f11)) + 1.0f);
    }

    private static float sc(com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc) {
        int i11 = AnonymousClass1.f28242sc[pff.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                return i11 != 3 ? 0.0f : 1.0f;
            }
            return 1.2f;
        }
        if (com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.JAVASCRIPT.equals(enumC0293sc)) {
            return 1.0f;
        }
        return com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.IMAGE.equals(enumC0293sc) ? 0.8f : 0.0f;
    }

    public String ExN() {
        if (this.We == com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF.STATIC_RESOURCE && this.zY == com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.IMAGE) {
            return this.ExN;
        }
        return null;
    }

    public String TRI() {
        return this.ExN;
    }

    public String We() {
        int i11 = AnonymousClass1.f28242sc[this.We.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return this.ExN;
            }
            if (i11 != 3) {
                return null;
            }
            return "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"" + this.f28241sc + "\" height=\"" + this.pFF + "\" src=\"" + this.ExN + "\"></iframe>";
        }
        com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc = this.zY;
        if (enumC0293sc == com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.IMAGE) {
            return "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + this.ExN + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
        }
        if (enumC0293sc != com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc.JAVASCRIPT) {
            return null;
        }
        return "<script src=\"" + this.ExN + "\"></script>";
    }

    public int pFF() {
        return this.f28241sc;
    }

    public void pFF(long j11) {
        if (this.UFX.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF(this.f28240qr, null, j11, this.WH);
        }
    }

    public JSONObject sc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.f28241sc);
        jSONObject.put("height", this.pFF);
        jSONObject.put("creativeType", this.zY.toString());
        jSONObject.put("resourceType", this.We.toString());
        jSONObject.put("contentUrl", this.ExN);
        jSONObject.put("clickThroughUri", this.Qj);
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.TRI));
        jSONObject.put("creativeViewTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.f28240qr));
        return jSONObject;
    }

    public void sc(long j11) {
        com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.TRI, null, j11, this.WH, new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF(this.Ol, this.Tf));
    }

    public void sc(Sfl sfl) {
        this.Tf = sfl;
    }

    public void sc(String str) {
        this.WH = str;
    }

    public int zY() {
        return this.pFF;
    }
}
