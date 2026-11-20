package com.bytedance.sdk.openadsdk.wjp.sc.sc;

import android.app.Activity;
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
import com.bytedance.sdk.openadsdk.core.model.UFX;
import com.bytedance.sdk.openadsdk.core.model.uEA;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements TRI {
    private static Boolean TRI;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Boolean f28790sc;
    protected int ExN;
    protected String We;
    protected com.bytedance.sdk.openadsdk.core.model.zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final WeakReference<Context> f28791qr;
    protected Sfl zY;

    public ExN(Context context, Sfl sfl, String str) {
        this.f28791qr = new WeakReference<>(context);
        this.zY = sfl;
        this.pFF = sfl.NP();
        this.We = str;
        "====tag===".concat(String.valueOf(str));
        if (Xc.sc() == null) {
            Xc.pFF(context);
        }
    }

    private static boolean qr() {
        if (TRI == null) {
            TRI = Boolean.valueOf(cJ.Qj(Xc.sc()));
        }
        return TRI.booleanValue();
    }

    private void sc(Map<String, Object> map) {
        Sfl sfl = this.zY;
        if (sfl != null && sfl.Vb() == 0) {
            Sfl sfl2 = this.zY;
            map.put("auto_click", Boolean.valueOf((sfl2 == null || sfl2.We()) ? false : true));
        }
        Sfl sfl3 = this.zY;
        if (sfl3 != null && sfl3.Vb() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.ExN >= 11));
        }
        map.put("can_query_install", Integer.valueOf(qr() ? 1 : 0));
    }

    public static boolean sc(Context context, String str, String str2, String str3, Sfl sfl) {
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
            if (sfl != null && sfl.Vb() == 0) {
                map.put("auto_click", Boolean.valueOf(!sfl.We()));
            }
            map.put("can_query_install", Integer.valueOf(qr() ? 1 : 0));
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public boolean ExN() {
        return this.pFF != null && sc(pFF(), this.pFF.sc(), this.pFF.zY());
    }

    public boolean TRI() {
        uEA ueaAf;
        IPMiBroadcastReceiver iPMiBroadcastReceiverSc;
        try {
            Sfl sfl = this.zY;
            if (sfl == null || (ueaAf = sfl.Af()) == null || TextUtils.isEmpty(ueaAf.pFF())) {
                return false;
            }
            if (ueaAf.sc() && this.zY.NP() != null && !TextUtils.isEmpty(this.zY.NP().zY()) && (iPMiBroadcastReceiverSc = IPMiBroadcastReceiver.sc(pFF())) != null) {
                iPMiBroadcastReceiverSc.sc(this.zY.NP().zY(), this.zY);
            }
            Context contextPFF = pFF();
            String strPFF = ueaAf.pFF();
            Sfl sfl2 = this.zY;
            final boolean zSc = zY.sc(contextPFF, strPFF, sfl2, cJ.pFF(sfl2), null, true);
            Cb.pFF(new Qj("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.wjp.sc.sc.ExN.1
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
        if (pFF() == null) {
            return;
        }
        if (zY()) {
            this.zY.zY(true);
            return;
        }
        if (sc()) {
            this.zY.zY(true);
            return;
        }
        if (TRI()) {
            return;
        }
        if (ExN()) {
            this.zY.zY(true);
        } else {
            if (this.zY.NP() != null || this.zY.ko() == null) {
                return;
            }
            cD.sc(pFF(), this.zY.ko(), this.zY, cJ.sc(this.We), this.We, true);
            this.zY.zY(true);
        }
    }

    public Context pFF() {
        WeakReference<Context> weakReference = this.f28791qr;
        return (weakReference == null || weakReference.get() == null) ? Xc.sc() : this.f28791qr.get();
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public void sc(int i11) {
        this.ExN = i11;
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public void sc(boolean z11) {
    }

    @Override // com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI
    public boolean sc() {
        if (this.pFF == null) {
            return false;
        }
        Sfl sfl = this.zY;
        if (sfl != null && sfl.hE() == 0) {
            return false;
        }
        String strZY = this.pFF.zY();
        if (TextUtils.isEmpty(strZY)) {
            return false;
        }
        Context contextPFF = pFF();
        if (qr() && !cJ.pFF(contextPFF, strZY)) {
            return false;
        }
        return sc(this.zY, strZY, contextPFF, this.We, new HashMap());
    }

    public boolean sc(Context context, String str, String str2) {
        return sc(context, str, str2, this.We, this.zY);
    }

    public boolean zY() {
        com.bytedance.sdk.openadsdk.core.We.sc(this.zY, this.We, 1, null);
        UFX ufxOtH = this.zY.otH();
        if (ufxOtH == null) {
            com.bytedance.sdk.openadsdk.core.We.sc(this.zY, this.We, -1, null);
            return false;
        }
        HashMap map = new HashMap();
        sc(map);
        String strSc = ufxOtH.sc();
        Context contextPFF = pFF();
        Sfl sfl = this.zY;
        if (zY.sc(contextPFF, strSc, sfl, cJ.pFF(sfl), map, true)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(this.zY, this.We, "open_fallback_url", map);
        return false;
    }
}
