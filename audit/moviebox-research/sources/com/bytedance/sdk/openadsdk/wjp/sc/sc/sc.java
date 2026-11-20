package com.bytedance.sdk.openadsdk.wjp.sc.sc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.We.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends We {
    public sc(Context context, Sfl sfl, String str) {
        super(context, sfl, str);
    }

    private static void sc(Sfl sfl, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (sfl != null && sfl.Vb() == 0) {
            map.put("auto_click", Boolean.valueOf(!sfl.We()));
        }
        map.put("can_query_install", 0);
    }

    public static boolean sc(Sfl sfl, String str, Context context, String str2, Map<String, Object> map) {
        Intent intentSc;
        if (sfl != null && sfl.hE() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (intentSc = cJ.sc(context, str)) == null) {
                return false;
            }
            intentSc.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                intentSc.addFlags(ASTNode.DEOP);
            }
            context.startActivity(intentSc);
            if (map == null) {
                map = new HashMap<>();
            }
            sc(sfl, map);
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean sc(String str, Context context, String str2, Sfl sfl, Map<String, Object> map) {
        Intent intent = null;
        try {
            if (TextUtils.isEmpty(str)) {
                com.bytedance.sdk.openadsdk.core.We.sc(sfl, str2, -2, null);
                return false;
            }
            Uri uri = Uri.parse(str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            try {
                intent2.setData(uri);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(ASTNode.DEOP);
                }
                if (map == null) {
                    map = new HashMap<>();
                }
                sc(sfl, map);
                map.put("url", str);
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, "open_url_app", map);
                context.startActivity(intent2);
                Tf.sc().sc(map).sc(sfl, str2);
                com.bytedance.sdk.openadsdk.We.zY.sc("dp_start_act_success", sfl, str2, map);
                return true;
            } catch (Throwable th2) {
                th = th2;
                intent = intent2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("exception", th.getMessage());
                    if (intent != null) {
                        jSONObject.put("intent", intent.toString());
                    }
                    jSONObject.put("can_query_install", 0);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.We.sc(sfl, str2, -4, jSONObject);
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.We
    public boolean pFF() {
        com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, 1, null);
        if (this.pFF.otH() != null) {
            HashMap map = new HashMap();
            Sfl sfl = this.pFF;
            if (sfl != null && sfl.Vb() == 0) {
                map.put("dpl_probability_jump", Boolean.valueOf(this.TRI >= 11));
            }
            if (sc(this.pFF.otH().sc(), zY(), this.zY, this.pFF, map)) {
                return true;
            }
            if (!this.We || this.ExN.get()) {
                this.We = true;
                sc(this.pFF, map);
                com.bytedance.sdk.openadsdk.We.zY.sc(this.pFF, this.zY, "open_fallback_url", map);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, -1, null);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.We, com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public boolean sc() {
        HashMap map;
        if (this.f28794sc == null) {
            return false;
        }
        Sfl sfl = this.pFF;
        if (sfl == null || sfl.Vb() != 0) {
            map = null;
        } else {
            map = new HashMap();
            map.put("dpl_probability_jump", Boolean.valueOf(this.TRI >= 11));
        }
        return sc(this.pFF, this.f28794sc.zY(), zY(), this.zY, map);
    }
}
