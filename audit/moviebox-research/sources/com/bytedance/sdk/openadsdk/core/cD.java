package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class cD {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f28364sc = false;

    public static boolean pFF(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, String str2, boolean z11) {
        try {
            Intent intentSc = sc(context, str, sfl, i11, (PAGNativeAd) null, (PangleAd) null, str2, z11, true);
            if (!(context instanceof Activity)) {
                intentSc.addFlags(ASTNode.DEOP);
            }
            context.startActivity(intentSc);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent sc(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, @Nullable PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z11) {
        return sc(context, str, sfl, i11, pAGNativeAd, pangleAd, str2, z11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent sc(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, @Nullable PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str2, boolean z11, boolean z12) {
        Intent intent;
        if (z12 || !com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(sfl) || (pAGNativeAd == 0 && pangleAd == null)) {
            intent = (z12 || sfl.QLv() != 3 || !(sfl.Xc() == 2 || (sfl.Xc() == 1 && f28364sc)) || sfl.Ao()) ? new Intent(context, (Class<?>) TTLandingPageActivity.class) : new Intent(context, (Class<?>) TTVideoLandingPageLink2Activity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            intent.putExtra("ad_pending_download", sc(sfl, z11));
            String strTf = com.bytedance.sdk.openadsdk.core.model.JPJ.Tf(sfl);
            if (!TextUtils.isEmpty(strTf)) {
                if (strTf.contains("?")) {
                    str = strTf + "&orientation=portrait";
                } else {
                    str = strTf + "?orientation=portrait";
                }
            }
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", sfl.PPh());
        intent.putExtra("web_title", sfl.YdT());
        intent.putExtra("sdk_version", BuildConfig.VERSION_CODE);
        intent.putExtra("adid", sfl.kDg());
        intent.putExtra("log_extra", sfl.mD());
        com.bytedance.sdk.openadsdk.multipro.pFF.sc scVarZY = null;
        intent.putExtra("icon_url", sfl.qfG() == null ? null : sfl.qfG().sc());
        intent.putExtra("event_tag", str2);
        intent.putExtra("source", i11);
        if (!(context instanceof Activity)) {
            intent.addFlags(ASTNode.DEOP);
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, sfl.JP().toString());
        } else {
            FI.sc().TRI();
            FI.sc().sc(sfl);
        }
        if (sfl.dix() == 5 || sfl.dix() == 15 || sfl.dix() == 50) {
            if (pAGNativeAd != 0) {
                if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.multipro.pFF.sc.InterfaceC0311sc) {
                    scVarZY = ((com.bytedance.sdk.openadsdk.multipro.pFF.sc.InterfaceC0311sc) pAGNativeAd).TRI();
                } else if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.sc.pFF.sc.pFF) {
                    scVarZY = ((com.bytedance.sdk.openadsdk.sc.pFF.sc.pFF) pAGNativeAd).pFF();
                }
                if (scVarZY != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, scVarZY.sc().toString());
                }
            }
            if ((pangleAd instanceof com.bytedance.sdk.openadsdk.core.zY.TRI) && (scVarZY = ((com.bytedance.sdk.openadsdk.core.zY.TRI) pangleAd).zY()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, scVarZY.sc().toString());
            }
            if (scVarZY != null) {
                intent.putExtra("video_is_auto_play", scVarZY.We);
                if (com.bytedance.sdk.component.utils.Tf.We()) {
                    scVarZY.sc().toString();
                }
            }
        }
        return intent;
    }

    private static com.bytedance.sdk.openadsdk.SR.sc.pFF sc(int i11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        com.bytedance.sdk.openadsdk.SR.sc.pFF pff = new com.bytedance.sdk.openadsdk.SR.sc.pFF();
        pff.sc(com.bytedance.sdk.openadsdk.We.pFF.sc.f27374sc);
        pff.sc(sfl);
        pff.pFF(cJ.sc(sfl));
        pff.sc(i11);
        pff.sc(false);
        pff.pFF(sfl.QLv());
        return pff;
    }

    private static String sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return (!sfl.ymG() || sfl.GOt() == null) ? sfl.ko() : sfl.GOt().Ol();
    }

    private static String sc(com.bytedance.sdk.openadsdk.core.model.UFX ufx, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return !TextUtils.isEmpty(ufx.pFF()) ? ufx.pFF() : sc(sfl);
    }

    public static void sc(boolean z11) {
        f28364sc = z11;
    }

    public static boolean sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, @Nullable PAGNativeAd pAGNativeAd, @Nullable PangleAd pangleAd, String str, @Nullable com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI tri, boolean z11, int i12) {
        String strSc;
        com.bytedance.sdk.openadsdk.We.zY.sc(sc(-1, sfl));
        if (context == null || sfl == null || i11 == -1) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sc(1, sfl));
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.UFX ufxOtH = sfl.otH();
        HashMap map = new HashMap();
        if (sfl.Vb() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(i12 >= 11));
        }
        if (i12 != 0 && sfl.ymG()) {
            map.put("dsp_click_type", Integer.valueOf(i12));
        }
        if (ufxOtH == null || TextUtils.isEmpty(ufxOtH.sc())) {
            strSc = sc(sfl);
        } else {
            if (sc(context, sfl, i11, str, z11, map)) {
                com.bytedance.sdk.openadsdk.We.zY.sc(sc(2, sfl));
                return true;
            }
            if (ufxOtH.zY() != 2 || sfl.dix() == 5 || sfl.dix() == 15) {
                strSc = (ufxOtH.zY() != 1 || TextUtils.isEmpty(ufxOtH.pFF())) ? sc(sfl) : ufxOtH.pFF();
            } else if (tri == null) {
                strSc = sc(ufxOtH, sfl);
            } else {
                if (tri.sc()) {
                    com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_fallback_url", map);
                    com.bytedance.sdk.openadsdk.We.zY.sc(sc(3, sfl));
                    return true;
                }
                if (tri.ExN()) {
                    com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_fallback_url", map);
                    com.bytedance.sdk.openadsdk.We.zY.sc(sc(3, sfl));
                    return true;
                }
                strSc = sc(ufxOtH, sfl);
                com.bytedance.sdk.openadsdk.We.zY.sc(sc(3, sfl));
            }
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_fallback_url", map);
        }
        String str2 = strSc;
        if (sfl.Vb() != 0 || TextUtils.isEmpty(str2) || !str2.contains("play.google.com/store")) {
            return sc(context, sfl, i11, pAGNativeAd, pangleAd, str, z11, str2);
        }
        String strSubstring = str2.substring(str2.indexOf("?id=") + 4);
        com.bytedance.sdk.openadsdk.We.zY.sc(sc(4, sfl));
        return com.bytedance.sdk.openadsdk.wjp.sc.sc.We.sc(context, str2, strSubstring, str, sfl);
    }

    public static boolean sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, PAGNativeAd pAGNativeAd, PangleAd pangleAd, String str, boolean z11, String str2) {
        if (TextUtils.isEmpty(str2) && !com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(sfl)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sc(5, sfl));
            return false;
        }
        int iQLv = sfl.QLv();
        if (iQLv == 2 || iQLv == 8) {
            return com.bytedance.sdk.openadsdk.utils.YIK.sc(context, str2, sfl, com.bytedance.sdk.openadsdk.We.pFF.sc.f27374sc);
        }
        com.bytedance.sdk.component.utils.pFF.sc(context, sc(context, str2, sfl, i11, pAGNativeAd, pangleAd, str, z11), null);
        f28364sc = false;
        return true;
    }

    public static boolean sc(Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, String str, boolean z11, Map<String, Object> map) {
        if (sfl == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.UFX ufxOtH = sfl.otH();
        if (ufxOtH == null || TextUtils.isEmpty(ufxOtH.sc())) {
            We.sc(sfl, str, ufxOtH == null ? -1 : -2, ufxOtH != null ? ufxOtH.We() : null);
            return false;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        String strSc = ufxOtH.sc();
        if (com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc()) {
            return com.bytedance.sdk.openadsdk.wjp.sc.sc.zY.sc(context, strSc, sfl, i11, map2, z11);
        }
        Uri uri = Uri.parse(strSc);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (cJ.Qj(context)) {
            cJ.pFF pFF = cJ.pFF(context, intent);
            if (pFF.pFF > 0) {
                if (Xc.We().Qj()) {
                    cJ.sc(sfl, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                map2.put("can_query_install", 1);
                map2.put("matched_count", Integer.valueOf(pFF.pFF));
                map2.put("url", strSc);
                ComponentName componentName = pFF.f28768sc;
                if (componentName != null) {
                    intent.setComponent(componentName);
                }
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_url_app", map2);
                try {
                    context.startActivity(intent);
                    com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map2).sc(sfl, str);
                    com.bytedance.sdk.openadsdk.We.zY.sc("dp_start_act_success", sfl, str, map2);
                    return true;
                } catch (Exception e11) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", e11.getMessage());
                        jSONObject.put("intent", intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    We.sc(sfl, str, -4, jSONObject);
                    if (!Xc.We().Qj()) {
                        sc(context, sfl.ko(), sfl, i11, str, z11);
                        com.bytedance.sdk.component.utils.Tf.sc("WebHelper", "openDetailPage() -> context.startActivity(intent) fail :", e11);
                    }
                    return false;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("intent", intent.toString());
                jSONObject2.put("can_query_install", 1);
            } catch (Exception unused2) {
            }
            We.sc(sfl, str, -3, jSONObject2);
        } else {
            try {
                if (Xc.We().Qj()) {
                    cJ.sc(sfl, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                map2.put("can_query_install", 0);
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "open_url_app", map2);
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map2).sc(sfl, str);
                return true;
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static boolean sc(Context context, String str, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, int i11, String str2, boolean z11) {
        try {
            context.startActivity(sc(context, str, sfl, i11, (PAGNativeAd) null, (PangleAd) null, str2, z11));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, boolean z11) {
        if (z11 && sfl != null && sfl.QLv() == 4) {
            return com.bytedance.sdk.openadsdk.core.model.JPJ.pFF(sfl);
        }
        return false;
    }
}
