package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f44801b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f44802a = new Handler() { // from class: com.mbridge.msdk.foundation.same.report.b.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Context context;
            HashMap map;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) d.this.f44803c.get()) != null) {
                Object obj = message.obj;
                if (!(obj instanceof HashMap) || (map = (HashMap) obj) == null) {
                    return;
                }
                new o(context).a((String) map.get("crashinfo"), (File) map.get("file"));
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<Context> f44803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Throwable f44804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f44805e;

    private d(Context context) {
        this.f44803c = new WeakReference<>(context);
    }

    public static d a(Context context) {
        if (f44801b == null) {
            synchronized (d.class) {
                try {
                    if (f44801b == null) {
                        f44801b = new d(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44801b;
    }

    public static String a() {
        try {
            g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                h.a();
                gVarB = i.a();
            }
            String strU = gVarB.U();
            return TextUtils.isEmpty(strU) ? "<mvpackage>mbridge</mvpackage>" : strU;
        } catch (Exception unused) {
            return "<mvpackage>mbridge</mvpackage>";
        }
    }

    private String a(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb2.append(stackTraceElement.toString() + "\n");
        }
        return sb2.toString();
    }

    private String a(Throwable th2, String str) {
        try {
            JSONObject jSONObjectB = b(str);
            if (jSONObjectB == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            jSONObjectB.put("crashinfo", stringWriter.toString());
            String string = jSONObjectB.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000052");
            stringBuffer.append("&");
            stringBuffer.append("crash_first_index_from_mtg=");
            stringBuffer.append(c.b(th2.getStackTrace()));
            stringBuffer.append("&exception=" + string);
            return stringBuffer.toString();
        } catch (Throwable th3) {
            th3.printStackTrace();
            return "";
        }
    }

    public static List<String> a(String str) {
        try {
            List<String> listA = a(str, "<mvpackage>(.*?)</mvpackage>");
            return listA == null ? new ArrayList() : listA;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return arrayList;
    }

    private void a(String str, String str2, Throwable th2, Thread thread) {
        if (!str.contains(str2)) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f44805e;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
                return;
            }
            return;
        }
        HashMap<String, Object> mapC = c();
        if (mapC == null || mapC.get("file") == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        HashMap map = new HashMap();
        map.put("crashinfo", a(th2, (String) mapC.get("time")));
        map.put("file", mapC.get("file"));
        messageObtain.obj = map;
        messageObtain.what = 101;
        this.f44802a.sendMessage(messageObtain);
        a(thread, th2);
    }

    private void a(Thread thread, Throwable th2) {
        try {
            Thread.sleep(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    private static String b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e("", e11.getMessage());
            return "";
        }
    }

    private String c(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> map = new HashMap<>();
        if (this.f44804d == null) {
            return null;
        }
        String strA = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_CRASH_INFO);
        File file = new File(strA + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(strA + "/sdkcrash" + str + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.f44804d, str));
            printWriter.println("====");
            this.f44804d.printStackTrace(printWriter);
            printWriter.close();
            map.put("file", file2);
            map.put("time", str);
            return map;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public final JSONObject b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = this.f44803c.get();
        if (context == null) {
            return null;
        }
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f11 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long usableSpace = externalStorageDirectory.getUsableSpace();
        long totalSpace = externalStorageDirectory.getTotalSpace();
        String fileSize = Formatter.formatFileSize(context, usableSpace);
        String fileSize2 = Formatter.formatFileSize(context, totalSpace);
        jSONObject.put("max_memory", String.valueOf(fMaxMemory));
        jSONObject.put("memoryby_app", String.valueOf(f11));
        jSONObject.put("remaining_memory", fFreeMemory);
        jSONObject.put("sdcard_remainder", fileSize);
        jSONObject.put("totalspacestr", fileSize2);
        jSONObject.put("crashtime", str);
        String strA = com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID);
        if (!TextUtils.isEmpty(strA)) {
            jSONObject.put(SafeStringUtils.SP_APPID, strA);
        }
        try {
            jSONObject.put("osversion", Build.VERSION.SDK_INT);
            jSONObject.put("appversioncode", d(context));
            jSONObject.put("appversionname", b(context));
            jSONObject.put("appname", c(context));
        } catch (Exception unused) {
            jSONObject.put("osversion", 0);
            jSONObject.put("appversioncode", "-1");
            jSONObject.put("appversionname", "-1");
            jSONObject.put("appname", "");
        }
        return jSONObject;
    }

    public final void b() {
        this.f44805e = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        l.a().b();
        try {
            this.f44804d = th2;
            String strA = a();
            List<String> listA = a(strA);
            if (listA.size() <= 0) {
                a(a(th2), strA, th2, thread);
                return;
            }
            for (int i11 = 0; i11 < listA.size(); i11++) {
                a(a(th2), listA.get(i11), th2, thread);
            }
        } catch (Exception e11) {
            a(thread, th2);
            e11.printStackTrace();
        }
    }
}
