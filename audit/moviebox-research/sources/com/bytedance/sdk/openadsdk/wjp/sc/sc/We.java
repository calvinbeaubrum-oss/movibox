package com.bytedance.sdk.openadsdk.wjp.sc.sc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.cD;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.uEA;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We implements TRI {
    protected int TRI;
    protected Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final WeakReference<Context> f28793qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.model.zY f28794sc;
    protected String zY;
    protected boolean We = false;
    protected final AtomicBoolean ExN = new AtomicBoolean(false);
    private boolean Qj = false;

    public We(Context context, Sfl sfl, String str) {
        this.f28793qr = new WeakReference<>(context);
        this.pFF = sfl;
        this.f28794sc = sfl.NP();
        this.zY = str;
        "====tag===".concat(String.valueOf(str));
        if (Xc.sc() == null) {
            Xc.pFF(context);
        }
    }

    private void sc(Map<String, Object> map) {
        Sfl sfl = this.pFF;
        if (sfl != null && sfl.Vb() == 0) {
            Sfl sfl2 = this.pFF;
            map.put("auto_click", Boolean.valueOf((sfl2 == null || sfl2.We()) ? false : true));
        }
        Sfl sfl3 = this.pFF;
        if (sfl3 != null && sfl3.Vb() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.TRI >= 11));
        }
        map.put("can_query_install", 1);
    }

    public static boolean sc(Context context, String str, String str2, String str3, Sfl sfl) {
        if (zY.sc()) {
            return ExN.sc(context, str, str2, str3, sfl);
        }
        if (!TextUtils.isEmpty(str3) && str3.contains("_landingpage")) {
            str3 = str3.replace("_landingpage", "");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(ASTNode.DEOP);
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str3, "store_open", (JSONObject) null);
                return true;
            } catch (Throwable unused) {
            }
        }
        if (context != null && str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri uri = Uri.parse("market://details?id=".concat(str2));
                intent2.setData(uri);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending") && context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(uri);
                        intent3.setPackage("com.android.vending");
                        if (!(context instanceof Activity)) {
                            intent3.setFlags(ASTNode.DEOP);
                        }
                        context.startActivity(intent3);
                        com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str3, "store_open", (JSONObject) null);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                ApmHelper.reportCustomError("gotoGooglePlayByPackageNameAndUrl error", "gotoGooglePlay", th2);
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public boolean ExN() {
        this.ExN.set(true);
        return this.f28794sc != null && sc(zY(), this.f28794sc.sc(), this.f28794sc.zY());
    }

    public boolean TRI() {
        uEA ueaAf;
        IPMiBroadcastReceiver iPMiBroadcastReceiverSc;
        try {
            Sfl sfl = this.pFF;
            if (sfl == null || (ueaAf = sfl.Af()) == null || TextUtils.isEmpty(ueaAf.pFF())) {
                return false;
            }
            if (ueaAf.sc() && this.pFF.NP() != null && !TextUtils.isEmpty(this.pFF.NP().zY()) && (iPMiBroadcastReceiverSc = IPMiBroadcastReceiver.sc(zY())) != null) {
                iPMiBroadcastReceiverSc.sc(this.pFF.NP().zY(), this.pFF);
            }
            final boolean zSc = pFF.sc(zY(), ueaAf.pFF(), this.pFF);
            Cb.pFF(new Qj("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.wjp.sc.sc.We.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zSc) {
                        Ol.sc("oem_store", "1");
                    } else {
                        Ol.sc("oem_store", "-2");
                    }
                }
            });
            return zSc;
        } catch (Throwable th2) {
            Tf.sc("GPDownLoader", th2.getMessage());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public void We() {
        if (zY() == null) {
            return;
        }
        if (pFF()) {
            this.ExN.set(true);
            this.pFF.zY(true);
            return;
        }
        if (sc()) {
            this.pFF.zY(true);
            return;
        }
        if (TRI()) {
            return;
        }
        if (ExN()) {
            this.pFF.zY(true);
        } else {
            if (this.pFF.NP() != null || this.pFF.ko() == null) {
                return;
            }
            cD.sc(zY(), this.pFF.ko(), this.pFF, cJ.sc(this.zY), this.zY, true);
            this.pFF.zY(true);
        }
    }

    public boolean pFF() {
        com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, 1, null);
        if (this.pFF.otH() == null) {
            com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, -1, null);
            return false;
        }
        String strSc = this.pFF.otH().sc();
        if (TextUtils.isEmpty(strSc)) {
            Sfl sfl = this.pFF;
            com.bytedance.sdk.openadsdk.core.We.sc(sfl, this.zY, -2, sfl.otH().We());
        } else {
            Uri uri = Uri.parse(strSc);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            cJ.pFF pFF = cJ.pFF(zY(), intent);
            if (pFF.pFF > 0) {
                if (!(zY() instanceof Activity)) {
                    intent.addFlags(ASTNode.DEOP);
                }
                try {
                    Map<String, Object> map = new HashMap<>();
                    sc(map);
                    map.put("matched_count", Integer.valueOf(pFF.pFF));
                    map.put("url", strSc);
                    ComponentName componentName = pFF.f28768sc;
                    if (componentName != null) {
                        intent.setComponent(componentName);
                    }
                    com.bytedance.sdk.openadsdk.We.zY.sc(this.pFF, this.zY, "open_url_app", map);
                    zY().startActivity(intent);
                    com.bytedance.sdk.openadsdk.We.Tf.sc().sc(map).sc(this.pFF, this.zY);
                    com.bytedance.sdk.openadsdk.We.zY.sc("dp_start_act_success", this.pFF, this.zY, map);
                    return true;
                } catch (Throwable th2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", th2.getMessage());
                        jSONObject.put("intent", intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, -4, jSONObject);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("intent", intent.toString());
                    jSONObject2.put("can_query_install", 1);
                } catch (Exception unused2) {
                }
                com.bytedance.sdk.openadsdk.core.We.sc(this.pFF, this.zY, -3, jSONObject2);
            }
        }
        if (this.We && !this.ExN.get()) {
            return false;
        }
        this.We = true;
        Map<String, Object> map2 = new HashMap<>();
        sc(map2);
        com.bytedance.sdk.openadsdk.We.zY.sc(this.pFF, this.zY, "open_fallback_url", map2);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public void sc(int i11) {
        this.TRI = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public void sc(boolean z11) {
        this.Qj = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public boolean sc() {
        Intent intentSc;
        if (this.f28794sc == null) {
            return false;
        }
        Sfl sfl = this.pFF;
        if (sfl != null && sfl.hE() == 0) {
            return false;
        }
        String strZY = this.f28794sc.zY();
        if (TextUtils.isEmpty(strZY) || !cJ.pFF(zY(), strZY) || (intentSc = cJ.sc(zY(), strZY)) == null) {
            return false;
        }
        intentSc.putExtra("START_ONLY_FOR_ANDROID", true);
        try {
            zY().startActivity(intentSc);
            HashMap map = new HashMap();
            sc(map);
            com.bytedance.sdk.openadsdk.We.zY.sc(this.pFF, this.zY, "click_open", map);
            return true;
        } catch (Throwable th2) {
            Tf.sc("GPDownLoader", th2.getMessage());
            return false;
        }
    }

    public boolean sc(Context context, String str, String str2) {
        return sc(context, str, str2, this.zY, this.pFF);
    }

    public Context zY() {
        WeakReference<Context> weakReference = this.f28793qr;
        return (weakReference == null || weakReference.get() == null) ? Xc.sc() : this.f28793qr.get();
    }
}
