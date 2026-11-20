package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.widget.Toast;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f43108a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String string;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i11 = message.arg1;
                    int i12 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string2 = data.getString("rid");
                        String string3 = data.getString("rid_n");
                        string = data.getString(BidResponsedEx.KEY_CID);
                        str = string2;
                        str2 = string3;
                    } else {
                        str = "";
                        str2 = str;
                        string = str2;
                    }
                    new com.mbridge.msdk.foundation.same.report.o(com.mbridge.msdk.foundation.controller.c.m().c()).a(i11, i12, str, str2, string);
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    th2.printStackTrace();
                }
            }
        }
    };

    public static String a(String str, String str2, String str3) {
        Map<String, com.mbridge.msdk.c.b.a> mapP;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null || (mapP = gVarB.p()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            Iterator<Map.Entry<String, com.mbridge.msdk.c.b.a>> it = mapP.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && host.contains(key)) {
                    com.mbridge.msdk.c.b.a aVar = mapP.get(key);
                    return aVar != null ? a(a(a(a(str, aVar.a(), String.valueOf(z.g(com.mbridge.msdk.foundation.controller.c.m().c()))), aVar.b(), String.valueOf(z.i(com.mbridge.msdk.foundation.controller.c.m().c()))), aVar.c(), str2), aVar.d(), str3) : str;
                }
            }
            return str;
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String str3 : list) {
                if (!TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }

    public static void a(final Context context, int i11, final String str) {
        if (i11 == 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.click.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Method method = t.class.getMethod("mia", Context.class, String.class);
                        Context context2 = context;
                        if (context2 != null) {
                            method.invoke(null, context2, str);
                        } else {
                            ad.b("CommonClickUtil", "Context is null");
                        }
                    } catch (Throwable th2) {
                        ad.b("CommonClickUtil", th2.getMessage());
                    }
                }
            });
        } catch (Throwable th2) {
            ad.b("CommonClickUtil", th2.getMessage());
        }
    }

    public static void a(Context context, String str) {
        Intent launchIntentForPackage;
        List<ResolveInfo> listQueryIntentActivities;
        ResolveInfo next;
        try {
            if (TextUtils.isEmpty(str) || !b(context, str) || (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0)) == null || listQueryIntentActivities.size() <= 0 || (next = listQueryIntentActivities.iterator().next()) == null) {
                return;
            }
            ActivityInfo activityInfo = next.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.addFlags(ASTNode.DEOP);
            context.startActivity(intent);
        } catch (Exception e11) {
            if (com.mbridge.msdk.f.b.a()) {
                Toast.makeText(context, "The app connot start up", 0).show();
            }
            e11.printStackTrace();
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (context instanceof Activity) {
                context.startActivity(intent);
                return true;
            }
            if (com.mbridge.msdk.foundation.controller.c.m().e() != null) {
                Context contextE = com.mbridge.msdk.foundation.controller.c.m().e();
                if (!(contextE instanceof Activity)) {
                    return false;
                }
                contextE.startActivity(intent);
                return true;
            }
            return false;
        } catch (Throwable th2) {
            ad.a("CommonClickUtil", th2.getMessage(), th2);
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        return true;
    }

    public static boolean b(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static void c(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(ASTNode.DEOP);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
        } catch (Exception e11) {
            e11.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(ASTNode.DEOP);
                context.startActivity(intent2);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    public static boolean d(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setData(uri);
            if (a(context, intent)) {
                return true;
            }
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
            return true;
        } catch (Throwable th2) {
            ad.a("CommonClickUtil", th2.getMessage(), th2);
            return false;
        }
    }

    public static void e(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            int i11 = MBCommonActivity.f42643d;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            intent.putExtra("url", str);
            if (!(context instanceof ContextThemeWrapper)) {
                intent.setFlags(ASTNode.DEOP);
            }
            context.startActivity(intent);
        } catch (ClassNotFoundException e11) {
            ad.b("CommonClickUtil", e11.getMessage());
        } catch (Throwable th2) {
            ad.b("CommonClickUtil", th2.getMessage());
        }
    }
}
