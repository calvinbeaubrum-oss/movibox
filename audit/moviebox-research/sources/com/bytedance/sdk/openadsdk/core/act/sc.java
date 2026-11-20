package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.j;
import androidx.browser.customtabs.l;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.SR;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static Boolean ExN = null;
    private static ActServiceConnection TRI = null;
    private static volatile boolean We = false;
    private static int pFF = -1;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static String f28360sc = null;
    private static int zY = -1;

    private sc() {
    }

    public static int pFF() {
        return pFF;
    }

    public static int pFF(Context context) {
        try {
            return !TextUtils.isEmpty(sc(context)) ? 1 : 0;
        } catch (Throwable unused) {
        }
    }

    public static void pFF(int i11) {
        zY = i11;
    }

    public static int sc() {
        Boolean bool = ExN;
        return (bool != null && bool.booleanValue()) ? 1 : 0;
    }

    public static String sc(final Context context) {
        String str = f28360sc;
        if (str != null) {
            return str;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            String str2 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                Intent intent2 = new Intent();
                intent2.setAction("android.support.customtabs.action.CustomTabsService");
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                if (packageManager.resolveService(intent2, 0) != null) {
                    arrayList.add(resolveInfo.activityInfo.packageName);
                }
            }
            if (arrayList.isEmpty()) {
                f28360sc = null;
            } else if (TextUtils.isEmpty(str2) || sc(context, intent) || !arrayList.contains(str2)) {
                f28360sc = (String) arrayList.get(0);
            } else {
                f28360sc = str2;
            }
            if (!TextUtils.isEmpty(f28360sc)) {
                synchronized (sc.class) {
                    try {
                        if (!We) {
                            pFF pff = new pFF() { // from class: com.bytedance.sdk.openadsdk.core.act.sc.1
                                @Override // com.bytedance.sdk.openadsdk.core.act.pFF
                                public void sc() {
                                    ActServiceConnection unused = sc.TRI = null;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.act.pFF
                                public void sc(final CustomTabsClient customTabsClient) {
                                    SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.sc.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                c cVar = new c();
                                                l lVar = new l() { // from class: com.bytedance.sdk.openadsdk.core.act.sc.1.1.1
                                                    @Override // androidx.browser.customtabs.l
                                                    public void onGreatestScrollPercentageIncreased(int i11, @NonNull Bundle bundle) {
                                                    }

                                                    @Override // androidx.browser.customtabs.l
                                                    public void onSessionEnded(boolean z11, @NonNull Bundle bundle) {
                                                    }

                                                    @Override // androidx.browser.customtabs.l
                                                    public void onVerticalScrollEvent(boolean z11, @NonNull Bundle bundle) {
                                                    }
                                                };
                                                j jVarE = customTabsClient.e(cVar);
                                                boolean z11 = false;
                                                boolean zH = jVarE != null ? jVarE.h(Bundle.EMPTY) : false;
                                                if (zH) {
                                                    int unused = sc.pFF = 1;
                                                    boolean zM = jVarE.m(lVar, Bundle.EMPTY);
                                                    if (zM) {
                                                        int unused2 = sc.zY = 1;
                                                    }
                                                    z11 = zM;
                                                } else {
                                                    int unused3 = sc.pFF = 0;
                                                }
                                                if (zH && z11) {
                                                    Boolean unused4 = sc.ExN = Boolean.TRUE;
                                                } else {
                                                    Boolean unused5 = sc.ExN = Boolean.FALSE;
                                                }
                                            } catch (Throwable th2) {
                                                Tf.sc("CustomTabsHelper", th2.getMessage());
                                            }
                                            ActServiceConnection actServiceConnection = sc.TRI;
                                            if (!sc.We || actServiceConnection == null) {
                                                return;
                                            }
                                            try {
                                                context.unbindService(actServiceConnection);
                                            } catch (Throwable unused6) {
                                            }
                                        }
                                    });
                                }
                            };
                            if (TRI == null) {
                                TRI = new ActServiceConnection(pff);
                            }
                            CustomTabsClient.a(context, f28360sc, TRI);
                            We = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            Tf.sc("CustomTabsHelper", th3.getMessage());
        }
        com.bytedance.sdk.openadsdk.SR.zY.sc("act_package_name", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.act.sc.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("package_name", sc.f28360sc);
                return We.pFF().sc("act_package_name").pFF(jSONObject.toString());
            }
        });
        return f28360sc;
    }

    public static void sc(int i11) {
        pFF = i11;
    }

    private static boolean sc(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (listQueryIntentActivities.size() == 0) {
                return false;
            }
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        return false;
    }

    public static int zY() {
        return zY;
    }
}
