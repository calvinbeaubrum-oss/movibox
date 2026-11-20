package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.d;
import androidx.browser.customtabs.j;
import com.bytedance.sdk.openadsdk.activity.TTBaseActivity;
import com.bytedance.sdk.openadsdk.core.act.AdActAction;
import java.util.HashMap;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class YIK {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.SR.sc.pFF pFF(String str, int i11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        com.bytedance.sdk.openadsdk.SR.sc.pFF pff = new com.bytedance.sdk.openadsdk.SR.sc.pFF();
        pff.sc(str);
        pff.sc(sfl);
        pff.pFF(cJ.sc(sfl));
        pff.sc(i11);
        pff.sc(false);
        pff.pFF(sfl.QLv());
        return pff;
    }

    public static boolean pFF(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str2) {
        if (!(context instanceof Activity)) {
            Activity activityPFF = com.bytedance.sdk.openadsdk.core.BT.sc().ExN().pFF();
            if (activityPFF != null && sc(activityPFF)) {
                context = activityPFF;
            }
        } else if (!sc((Activity) context)) {
            context = null;
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.Xc.sc();
        }
        Context context2 = context;
        if (context2 == null || !sc(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap map = new HashMap();
        map.put("deeplink_url", str);
        map.put("jsb_deeplink", 1);
        if (com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc()) {
            return com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc(context2, str, sfl, cJ.pFF(sfl), map, true);
        }
        if (!cJ.Qj(context2)) {
            try {
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, "open_url_app", map);
                context2.startActivity(intent);
                com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map).sc(sfl, str2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        if (cJ.sc(context2, intent)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, "open_url_app", map);
            try {
                if (!(context2 instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                context2.startActivity(intent);
                com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map).sc(sfl, str2);
                return true;
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pFF(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(ASTNode.DEOP);
            }
            try {
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.SR.sc.pFF pFF = pFF(str2, 100, sfl);
                pFF.sc(true);
                pFF.pFF(2);
                com.bytedance.sdk.openadsdk.We.zY.sc(pFF);
                return true;
            } catch (Throwable th2) {
                String message = th2.getMessage();
                com.bytedance.sdk.openadsdk.SR.sc.pFF pFF2 = pFF(str2, 7, sfl);
                pFF2.zY(message);
                pFF2.pFF(2);
                com.bytedance.sdk.openadsdk.We.zY.sc(pFF2);
                return false;
            }
        } catch (Throwable th3) {
            String message2 = th3.getMessage();
            com.bytedance.sdk.openadsdk.SR.sc.pFF pFF3 = pFF(str2, 6, sfl);
            pFF3.zY(message2);
            pFF3.pFF(2);
            com.bytedance.sdk.openadsdk.We.zY.sc(pFF3);
            return false;
        }
    }

    public static boolean sc(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static boolean sc(Context context, final String str, final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final String str2) {
        if (!(context instanceof Activity)) {
            Activity activityPFF = com.bytedance.sdk.openadsdk.core.BT.sc().ExN().pFF();
            if (activityPFF != null && sc(activityPFF)) {
                context = activityPFF;
            }
        } else if (!sc((Activity) context)) {
            context = null;
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.Xc.sc();
        }
        if (context == null) {
            return false;
        }
        final String strSc = cJ.sc(sfl);
        if (!com.bytedance.sdk.component.utils.BT.sc(str)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(pFF(str2, 5, sfl));
            return false;
        }
        final String strPFF = com.bytedance.sdk.openadsdk.core.model.Sfl.pFF(context, sfl);
        if (TextUtils.isEmpty(strPFF)) {
            return pFF(context, str, sfl, str2, strSc);
        }
        try {
            final d.b bVar = new d.b();
            bVar.l(false);
            bVar.i(2);
            final Context context2 = context;
            new AdActAction(context, sfl, str2, str).sc(new AdActAction.BindCustomTabsServiceCallback() { // from class: com.bytedance.sdk.openadsdk.utils.YIK.1
                @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                public void onBindFail(int i11, String str3) {
                    com.bytedance.sdk.openadsdk.SR.sc.pFF pFF = YIK.pFF(str2, i11, sfl);
                    pFF.zY(str3);
                    com.bytedance.sdk.openadsdk.We.zY.sc(pFF);
                    YIK.pFF(context2, str, sfl, str2, strSc);
                }

                @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                public void onBindSuccess(j jVar) {
                    if (jVar != null) {
                        try {
                            bVar.g(jVar);
                        } catch (Throwable th2) {
                            String message = th2.getMessage();
                            com.bytedance.sdk.component.utils.Tf.sc("OpenUtils", message);
                            com.bytedance.sdk.openadsdk.SR.sc.pFF pFF = YIK.pFF(str2, 13, sfl);
                            pFF.zY(message);
                            com.bytedance.sdk.openadsdk.We.zY.sc(pFF);
                            YIK.pFF(context2, str, sfl, str2, strSc);
                            return;
                        }
                    }
                    d dVarA = bVar.a();
                    if (!(context2 instanceof Activity)) {
                        dVarA.f1830a.addFlags(ASTNode.DEOP);
                    }
                    com.bytedance.sdk.openadsdk.core.act.zY.sc(context2, strPFF, dVarA, Uri.parse(str));
                    Context context3 = context2;
                    if (context3 instanceof TTBaseActivity) {
                        ((TTBaseActivity) context3).pFF(true);
                    }
                    com.bytedance.sdk.openadsdk.SR.sc.pFF pFF2 = YIK.pFF(str2, 100, sfl);
                    pFF2.sc(true);
                    pFF2.pFF(8);
                    com.bytedance.sdk.openadsdk.We.zY.sc(pFF2);
                }
            });
            return true;
        } catch (Throwable th2) {
            String message = th2.getMessage();
            com.bytedance.sdk.component.utils.Tf.sc("OpenUtils", message);
            com.bytedance.sdk.openadsdk.SR.sc.pFF pFF = pFF(str2, 12, sfl);
            pFF.zY(message);
            com.bytedance.sdk.openadsdk.We.zY.sc(pFF);
            return pFF(context, str, sfl, str2, strSc);
        }
    }

    public static boolean sc(String str) {
        return !TextUtils.isEmpty(str);
    }
}
