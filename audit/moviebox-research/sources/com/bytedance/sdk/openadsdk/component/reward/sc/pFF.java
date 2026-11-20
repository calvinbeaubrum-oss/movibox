package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.model.YIK;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final SparseArray<WeakReference<com.bytedance.sdk.openadsdk.core.model.Sfl>> f27905sc = new SparseArray<>();

    public static com.bytedance.sdk.openadsdk.core.model.Sfl sc(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff) {
        com.bytedance.sdk.openadsdk.core.model.Sfl yik = null;
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            com.bytedance.sdk.openadsdk.core.model.sc scVarQr = FI.sc().qr();
            yik = scVarQr != null ? new YIK(scVarQr) : null;
            if (pff != null) {
                pff.sc(bundle);
            }
            FI.sc().TRI();
        } else if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                if (stringExtra != null) {
                    yik = new YIK(com.bytedance.sdk.openadsdk.core.model.sc.zY(new JSONObject(stringExtra)));
                }
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFDM", "", e11);
            }
        }
        if (bundle != null) {
            try {
                WeakReference<com.bytedance.sdk.openadsdk.core.model.Sfl> weakReference = f27905sc.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    yik = weakReference.get();
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFDM", "", th2);
            }
        }
        if (yik != null) {
            yik.sc(yik.wjp(), 7);
        }
        return yik;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    public static void sc(Intent intent, Activity activity, boolean z11, com.bytedance.sdk.openadsdk.core.model.sc scVar, String str) {
        int rotation;
        JSONObject jSONObjectQl;
        if (activity != null) {
            try {
                rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFDM", "", e11);
                rotation = 0;
            }
            intent.putExtra("orientation_angle", rotation);
            intent.putExtra("video_is_cached", z11);
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                FI.sc().TRI();
                FI.sc().sc(scVar);
                return;
            }
            jSONObjectQl = scVar.Ql();
            if (jSONObjectQl == null) {
                com.bytedance.sdk.component.utils.Tf.pFF("toJsonObj return null");
            } else {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectQl.toString());
                intent.putExtra("multi_process_listener_key", str);
            }
        }
        intent.addFlags(ASTNode.DEOP);
        rotation = 0;
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra("video_is_cached", z11);
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            FI.sc().TRI();
            FI.sc().sc(scVar);
            return;
        }
        jSONObjectQl = scVar.Ql();
        if (jSONObjectQl == null) {
            com.bytedance.sdk.component.utils.Tf.pFF("toJsonObj return null");
        } else {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_AD_INFO, jSONObjectQl.toString());
            intent.putExtra("multi_process_listener_key", str);
        }
    }

    public static void sc(Intent intent, sc scVar) {
        if (intent == null) {
            return;
        }
        scVar.JPJ.zY(intent.getBooleanExtra("video_is_cached", false));
        scVar.QLv = intent.getStringExtra("multi_process_listener_key");
        scVar.idT = intent.getIntExtra("orientation_angle", 0) == 3;
    }

    public static void sc(Bundle bundle, sc scVar) {
        if (bundle == null) {
            return;
        }
        scVar.QLv = bundle.getString("multi_process_listener_key");
        scVar.JPJ.zY(bundle.getBoolean("video_is_cached", false));
        scVar.f27908eo = bundle.getBoolean("is_mute");
        if (bundle.getLong("video_current") > 0) {
            scVar.JPJ.sc(bundle.getLong("video_current", 0L));
        }
        scVar.sc(bundle.getBoolean("has_show_skip_btn"));
    }

    public static void sc(sc scVar, Intent intent, Bundle bundle) {
        sc(intent, scVar);
        sc(bundle, scVar);
    }

    public static void sc(sc scVar, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.pFF;
            f27905sc.append(sfl.hashCode(), new WeakReference<>(sfl));
            bundle.putInt("meta_tmp", sfl.hashCode());
            bundle.putString("multi_process_listener_key", scVar.QLv);
            bundle.putBoolean("video_is_cached", scVar.JPJ.FI());
            bundle.putLong("video_current", scVar.JPJ.qr());
            bundle.putBoolean("is_mute", scVar.f27908eo);
            bundle.putBoolean("has_show_skip_btn", scVar.fT);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.RFDM", "onSaveInstanceState: ", th2);
        }
    }
}
