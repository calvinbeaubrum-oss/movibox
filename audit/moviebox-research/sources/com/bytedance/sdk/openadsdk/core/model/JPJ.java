package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class JPJ {
    private String ExN;
    private int Ol;
    private int Qj;
    private String TRI;
    private boolean WH;
    private int We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28393qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f28394sc;
    private boolean zY;

    public JPJ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.zY = jSONObject.optBoolean("is_playable");
        this.We = jSONObject.optInt("playable_type", 0);
        this.ExN = jSONObject.optString("playable_style");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("playable");
        if (jSONObjectOptJSONObject != null) {
            this.TRI = jSONObjectOptJSONObject.optString("playable_url", "");
            this.f28393qr = jSONObjectOptJSONObject.optInt("playable_orientation", 0);
            this.pFF = jSONObjectOptJSONObject.optInt("new_style", 0);
            this.f28394sc = jSONObjectOptJSONObject.optInt("close_2_app", 0);
            int iPFF = pFF(this.We);
            this.Qj = jSONObjectOptJSONObject.optInt("playable_webview_timeout", iPFF);
            this.Ol = jSONObjectOptJSONObject.optInt("playable_js_timeout", iPFF);
            this.WH = jSONObjectOptJSONObject.optInt("playable_backup_enable", 0) == 1;
        }
    }

    public static boolean BT(Sfl sfl) {
        return sfl == null || sfl.GI() == null || sfl.GI().x() != 1;
    }

    public static long Dl(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return 5L;
        }
        return jpjFI.sc();
    }

    public static boolean ExN(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        return jpjFI != null && sfl.nW() && jpjFI.zY && !TextUtils.isEmpty(Ql(sfl));
    }

    private static JPJ FI(Sfl sfl) {
        if (sfl == null) {
            return null;
        }
        return sfl.dE();
    }

    public static boolean JPJ(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        return jpjFI != null && jpjFI.zY();
    }

    public static boolean Ol(Sfl sfl) {
        JPJ jpjDE = sfl.dE();
        return jpjDE != null && jpjDE.zY && jpjDE.pFF == 1;
    }

    public static boolean Qj(Sfl sfl) {
        JPJ jpjDE = sfl.dE();
        return jpjDE != null && !sfl.nW() && jpjDE.zY && jpjDE.pFF == 1;
    }

    public static String Ql(Sfl sfl) {
        if (sfl == null) {
            return null;
        }
        JPJ jpjDE = sfl.dE();
        if (jpjDE != null && jpjDE.zY) {
            String str = jpjDE.TRI;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (sfl.Xc() == 20) {
            return sfl.ko();
        }
        if (sfl.GI() != null) {
            return sfl.GI().p();
        }
        return null;
    }

    public static boolean SR(Sfl sfl) {
        return true;
    }

    public static boolean Sfl(Sfl sfl) {
        return qr(sfl) && WP(sfl) == 0;
    }

    public static boolean TRI(Sfl sfl) {
        return ExN(sfl) && WP(sfl) == 1;
    }

    public static String Tf(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return null;
        }
        return jpjFI.TRI;
    }

    public static String UFX(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return null;
        }
        return jpjFI.ExN;
    }

    public static boolean WH(Sfl sfl) {
        JPJ jpjDE = sfl.dE();
        return jpjDE != null && sfl.nW() && jpjDE.zY && jpjDE.pFF == 1;
    }

    private static int WP(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return 0;
        }
        return jpjFI.We;
    }

    public static boolean We(Sfl sfl) {
        return zY(sfl) && !Ol(sfl);
    }

    public static int Xc(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return 0;
        }
        return jpjFI.f28393qr;
    }

    public static long YIK(Sfl sfl) {
        return Math.max(Dl(sfl), uEA(sfl));
    }

    public static boolean dE(Sfl sfl) {
        a aVarGI = sfl.GI();
        return aVarGI != null && aVarGI.x() == 1;
    }

    private static int pFF(int i11) {
        return i11 == 1 ? 10 : 5;
    }

    public static boolean pFF(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        return (jpjFI == null || !jpjFI.zY || TextUtils.isEmpty(Ql(sfl))) ? false : true;
    }

    public static boolean qr(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        return (jpjFI == null || sfl.nW() || !jpjFI.zY || TextUtils.isEmpty(Ql(sfl))) ? false : true;
    }

    public static int sc(int i11) {
        return i11 + 10;
    }

    public static int sc(Sfl sfl) {
        int i11;
        JPJ jpjDE = sfl.dE();
        if (jpjDE != null && (i11 = jpjDE.f28394sc) >= 0 && i11 <= 100) {
            return i11;
        }
        return 0;
    }

    public static long uEA(Sfl sfl) {
        JPJ jpjFI = FI(sfl);
        if (jpjFI == null) {
            return 5L;
        }
        return jpjFI.pFF();
    }

    public static boolean wjp(Sfl sfl) {
        return qr(sfl) && WP(sfl) == 1;
    }

    public static boolean zY(Sfl sfl) {
        return pFF(sfl) && WP(sfl) == 1;
    }

    public int pFF() {
        return this.Ol;
    }

    public int sc() {
        return this.Qj;
    }

    public void sc(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.zY);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("PlayableModel", e11.getMessage());
        }
        if (!TextUtils.isEmpty(this.TRI)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.TRI);
                jSONObject2.put("playable_orientation", this.f28393qr);
                jSONObject2.put("new_style", this.pFF);
                jSONObject2.put("close_2_app", this.f28394sc);
                jSONObject2.put("playable_webview_timeout", this.Qj);
                jSONObject2.put("playable_js_timeout", this.Ol);
                jSONObject2.put("playable_backup_enable", this.WH ? 1 : 0);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e12) {
                com.bytedance.sdk.component.utils.Tf.sc("PlayableModel", e12.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.We);
        } catch (JSONException e13) {
            com.bytedance.sdk.component.utils.Tf.sc("PlayableModel", e13.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.ExN);
        } catch (JSONException e14) {
            com.bytedance.sdk.component.utils.Tf.sc("PlayableModel", e14.getMessage());
        }
    }

    public boolean zY() {
        return this.WH;
    }
}
