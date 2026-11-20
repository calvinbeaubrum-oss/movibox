package com.bytedance.sdk.openadsdk.wjp.sc.sc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private static Intent sc(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            return intent;
        } catch (Throwable th2) {
            Tf.sc("DeepLinkUtils", th2.getMessage());
            return null;
        }
    }

    private static void sc(Context context, Sfl sfl, Map<String, Object> map) {
        if (sfl != null && sfl.Vb() == 0) {
            map.put("auto_click", Boolean.valueOf(!sfl.We()));
        }
        map.put("can_query_install", Integer.valueOf(cJ.Qj(context) ? 1 : 0));
    }

    public static boolean sc(Context context, String str, Sfl sfl) {
        String strSc = cJ.sc(sfl);
        com.bytedance.sdk.openadsdk.core.We.sc(sfl, strSc, 1, null);
        Intent intentSc = sc(context, str);
        if (TextUtils.isEmpty(str) || intentSc == null) {
            com.bytedance.sdk.openadsdk.core.We.sc(sfl, strSc, -2, sfl.otH().We());
            return false;
        }
        boolean zQj = cJ.Qj(context);
        HashMap map = new HashMap();
        map.put("url", str);
        if (zQj) {
            cJ.pFF pFF = cJ.pFF(context, intentSc);
            if (pFF.pFF <= 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("intent", intentSc.toString());
                    jSONObject.put("can_query_install", 1);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.We.sc(sfl, strSc, -3, jSONObject);
                return false;
            }
            try {
                sc(context, sfl, map);
                map.put("matched_count", Integer.valueOf(pFF.pFF));
                ComponentName componentName = pFF.f28768sc;
                if (componentName != null) {
                    intentSc.setComponent(componentName);
                }
            } catch (Throwable th2) {
                Tf.sc("DeepLinkUtils", th2.getMessage());
            }
        }
        try {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, strSc, "open_url_app", map);
            context.startActivity(intentSc);
            com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map).sc(sfl, strSc);
            com.bytedance.sdk.openadsdk.We.zY.sc("dp_start_act_success", sfl, strSc, map);
            return true;
        } catch (Throwable th3) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("exception", th3.getMessage());
                jSONObject2.put("intent", intentSc.toString());
                jSONObject2.put("can_query_install", zQj ? 1 : 0);
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.We.sc(sfl, strSc, -4, jSONObject2);
            return false;
        }
    }
}
