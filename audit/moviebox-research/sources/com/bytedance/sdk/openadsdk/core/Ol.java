package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import v8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol {
    public static final Set<String> pFF = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Ol.1
        {
            add("8025677");
            add("5001121");
        }
    };

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Ql f28027sc = null;
    private static boolean wjp = false;
    private Integer BT;
    private String Dl;
    private String ExN;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.zY.We.sc> JPJ;

    @Nullable
    private String Ol;
    private boolean Qj;
    private boolean Ql;
    private Bitmap SR;
    private int Sfl;

    @NonNull
    private String TRI;
    private boolean Tf;
    private int UFX;

    @Nullable
    private String WH;

    @NonNull
    private String We;
    private Integer Xc;
    private boolean YIK;
    private Integer dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28028qr;
    private com.bytedance.sdk.openadsdk.core.Ql.zY.zY uEA;
    private boolean zY;

    /* JADX INFO: compiled from: source.java */
    public static class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private static final Ol f28033sc = new Ol();
    }

    private Ol() {
        this.zY = false;
        this.UFX = 0;
        this.Tf = true;
        this.Ql = false;
        this.SR = null;
        this.BT = null;
        this.dE = null;
        this.Xc = null;
        this.Sfl = 0;
        this.JPJ = null;
        try {
            b.a(Xc.sc());
        } catch (Throwable unused) {
        }
    }

    public static void JPJ() {
        if (Build.VERSION.SDK_INT == 26 && "MI 6".equals(Build.MODEL)) {
            wjp = true;
        }
    }

    private static void Ol(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        Ql ql2 = f28027sc;
        if (ql2 != null) {
            ql2.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    private static void Qj(String str) {
        Ql ql2;
        if (TextUtils.isEmpty(str) && (ql2 = f28027sc) != null) {
            ql2.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", "appid cannot be empty");
    }

    private static JSONObject WH(String str) {
        String strPFF = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("sp_global_file", str, null);
        if (TextUtils.isEmpty(strPFF)) {
            return null;
        }
        try {
            return new JSONObject(strPFF);
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", e11.getMessage());
            return null;
        }
    }

    public static Pair<String, Long> We(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectWH = WH(str);
            if (jSONObjectWH == null) {
                return null;
            }
            return new Pair<>(jSONObjectWH.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE), Long.valueOf(jSONObjectWH.getLong("time")));
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", e11.getMessage());
            return null;
        }
    }

    @NonNull
    public static Ol pFF() {
        return sc.f28033sc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(Integer num, int i11) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "tt_gdpr", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(4, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "tt_gdpr", -1) != i11) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "tt_gdpr", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(4, true);
        }
    }

    public static boolean qr(String str) {
        return (TextUtils.isEmpty(str) || !com.bytedance.sdk.openadsdk.utils.FI.f28730sc || str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad") || str.contains("pag_sp_bad_par")) ? false : true;
    }

    private String sc(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String sc(String str, long j11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectWH = WH(str);
            if (jSONObjectWH == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectWH.getLong("time") <= j11) {
                return jSONObjectWH.getString(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            }
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", e11.getMessage());
        }
        return null;
    }

    public static void sc(Ql ql2) {
        f28027sc = ql2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Integer num, int i11) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "sdk_coppa", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(3, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "sdk_coppa", -1) != i11) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "sdk_coppa", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(3, true);
        }
    }

    public static void sc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, str2);
            jSONObject.put("time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.GlobalInfo", e11.getMessage());
        }
    }

    public static boolean uEA() {
        return wjp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(Integer num, int i11) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_ccpa", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(5, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_ccpa", -1) != i11) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_ccpa", Integer.valueOf(i11));
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(5, true);
        }
    }

    public boolean BT() {
        return true;
    }

    public void Dl() {
        try {
            if (this.JPJ == null || this.JPJ.size() != 0) {
                return;
            }
            this.JPJ = null;
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    public com.bytedance.sdk.openadsdk.core.zY.We.sc ExN(String str) {
        try {
            if (this.JPJ == null || str == null) {
                return null;
            }
            return this.JPJ.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String ExN() {
        String str = this.ExN;
        if (str != null) {
            return str;
        }
        String strSc = sc("mediation_info", Long.MAX_VALUE);
        this.ExN = strSc;
        if (strSc == null) {
            this.ExN = "";
        }
        return this.ExN;
    }

    public void ExN(int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "title_bar_theme", Integer.valueOf(i11));
        }
        this.UFX = i11;
    }

    public int Ol() {
        Integer num = this.dE;
        return num != null ? num.intValue() : com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "tt_gdpr", -1);
    }

    public int Qj() {
        Integer num = this.BT;
        return num != null ? num.intValue() : com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "sdk_coppa", -1);
    }

    @Nullable
    public String Ql() {
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.We.pFF("sp_global_file", "extra_data", null) : this.WH;
    }

    public com.bytedance.sdk.openadsdk.core.Ql.zY.zY SR() {
        if (this.uEA == null) {
            this.uEA = new com.bytedance.sdk.openadsdk.core.Ql.zY.zY(10, 8);
        }
        return this.uEA;
    }

    public String Sfl() {
        if (!TextUtils.isEmpty(this.Dl)) {
            return this.Dl;
        }
        String strSc = com.bytedance.sdk.openadsdk.utils.WH.sc();
        this.Dl = strSc;
        if (!TextUtils.isEmpty(strSc)) {
            return this.Dl;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.WH.sc(strValueOf);
        this.Dl = strValueOf;
        return strValueOf;
    }

    @NonNull
    public String TRI() {
        if (TextUtils.isEmpty(this.TRI)) {
            this.TRI = sc(Xc.sc());
        }
        return this.TRI;
    }

    public void TRI(final int i11) {
        if (i11 == 0 || i11 == 1 || i11 == -1) {
            final Integer num = this.Xc;
            if (num == null || num.intValue() != i11) {
                this.Xc = Integer.valueOf(i11);
                if (com.bytedance.sdk.openadsdk.utils.Cb.ExN()) {
                    SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ol.5
                        @Override // java.lang.Runnable
                        public void run() {
                            Ol.this.zY(num, i11);
                        }
                    });
                } else {
                    zY(num, i11);
                }
            }
        }
    }

    public void TRI(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                com.bytedance.sdk.openadsdk.zY.WH.sc(6, str);
            } else if (this.JPJ != null) {
                this.JPJ.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public String Tf() {
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.We.pFF("sp_global_file", "keywords", null) : this.Ol;
    }

    public boolean UFX() {
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "is_paid", false) : this.Qj;
    }

    public int WH() {
        int iSc = com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_coppa", -99);
        this.Sfl = iSc;
        if (iSc == -99) {
            this.Sfl = Qj();
        }
        return this.Sfl;
    }

    @Nullable
    public String We() {
        if (TextUtils.isEmpty(this.We)) {
            String strSc = sc("app_id", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(strSc)) {
                this.We = strSc;
            }
        }
        return this.We;
    }

    public void We(int i11) {
        if (i11 != 0 && i11 != 1) {
            i11 = -99;
        }
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_coppa", Integer.valueOf(i11));
        this.Sfl = i11;
    }

    public boolean Xc() {
        return pFF.contains(this.We);
    }

    public int YIK() {
        Integer num = this.Xc;
        return num != null ? num.intValue() : com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_privacy", "global_ccpa", -1);
    }

    public Bitmap dE() {
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.component.utils.We.sc(com.bytedance.sdk.openadsdk.multipro.We.We.pFF("sp_global_file", "pause_icon", null)) : this.SR;
    }

    public void pFF(final int i11) {
        if (i11 == 0 || i11 == 1 || i11 == -1) {
            final Integer num = this.BT;
            if (num == null || num.intValue() != i11) {
                this.BT = Integer.valueOf(i11);
                if (com.bytedance.sdk.openadsdk.utils.Cb.ExN()) {
                    SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ol.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Ol.this.sc(num, i11);
                        }
                    });
                } else {
                    sc(num, i11);
                }
            }
        }
    }

    public void pFF(String str) {
        this.ExN = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sc("mediation_info", str);
    }

    public void pFF(boolean z11) {
        com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "sdk_activate_init", Boolean.valueOf(z11));
    }

    public int qr() {
        return com.bytedance.sdk.openadsdk.multipro.pFF.zY() ? com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_icon_id", "icon_id", 0) : this.f28028qr;
    }

    public void sc(int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_icon_id", "icon_id", Integer.valueOf(i11));
        }
        this.f28028qr = i11;
    }

    public void sc(@NonNull String str) {
        Qj(str);
        this.We = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sc("app_id", str);
        com.bytedance.sdk.openadsdk.core.settings.dE.ef().We(7);
    }

    public void sc(String str, com.bytedance.sdk.openadsdk.core.zY.We.sc scVar) {
        try {
            if (TextUtils.isEmpty(str) || scVar == null) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                com.bytedance.sdk.openadsdk.zY.WH.sc(6, str, scVar);
                return;
            }
            if (this.JPJ == null) {
                synchronized (Ol.class) {
                    try {
                        if (this.JPJ == null) {
                            this.JPJ = new ConcurrentHashMap<>();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            if (this.JPJ != null) {
                this.JPJ.put(str, scVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void sc(boolean z11) {
        this.YIK = z11;
    }

    public boolean sc() {
        return this.YIK;
    }

    public boolean wjp() {
        return "com.union_test.internationad".equals(cJ.ExN());
    }

    public void zY(final int i11) {
        if (i11 == 1) {
            i11 = 0;
        } else if (i11 == 0) {
            i11 = 1;
        }
        if (i11 == 0 || i11 == 1 || i11 == -1) {
            final Integer num = this.dE;
            if (num == null || num.intValue() != i11) {
                this.dE = Integer.valueOf(i11);
                if (com.bytedance.sdk.openadsdk.utils.Cb.ExN()) {
                    SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ol.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Ol.this.pFF(num, i11);
                        }
                    });
                } else {
                    pFF(num, i11);
                }
            }
        }
    }

    public void zY(@Nullable final String str) {
        Ol(str);
        if (com.bytedance.sdk.openadsdk.utils.Cb.ExN()) {
            SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Ol.4
                @Override // java.lang.Runnable
                public void run() {
                    if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "extra_data", str);
                    }
                }
            });
        } else if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "extra_data", str);
        }
        this.WH = str;
    }

    public void zY(boolean z11) {
        this.zY = z11;
    }

    public boolean zY() {
        return com.bytedance.sdk.openadsdk.multipro.We.We.sc("sp_global_file", "sdk_activate_init", true);
    }
}
