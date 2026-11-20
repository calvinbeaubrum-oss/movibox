package fo;

import android.app.ActivityManager;
import android.app.UiModeManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import com.applovin.impl.lz;
import com.applovin.sdk.AppLovinMediationProvider;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    public static /* synthetic */ Point a(WindowManager windowManager) {
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static b b(Context context) {
        com.google.common.base.f fVar = new com.google.common.base.f() { // from class: fo.s
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return u.f((String) obj);
            }
        };
        b.a aVarB = b.g().e((String) fVar.apply(Build.MANUFACTURER)).d((String) fVar.apply(Build.MODEL)).a((String) fVar.apply(Build.VERSION.RELEASE)).c(a9.a.a(",", Build.SUPPORTED_ABIS)).b(Runtime.getRuntime().availableProcessors());
        aVarB.f(((Long) io.a.g(context, ActivityManager.class, "activity", new com.google.common.base.f() { // from class: fo.t
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return u.d((ActivityManager) obj);
            }
        }, 0L)).longValue());
        return aVarB.build();
    }

    public static /* synthetic */ Integer c(UiModeManager uiModeManager) {
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType != 4) {
            return (currentModeType == 5 || currentModeType == 6 || currentModeType == 7) ? 6 : 0;
        }
        return 3;
    }

    public static /* synthetic */ Long d(ActivityManager activityManager) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return Long.valueOf(memoryInfo.totalMem);
    }

    public static /* synthetic */ String f(String str) {
        return AppLovinMediationProvider.UNKNOWN.equals(com.google.common.base.p.e(str)) ? "" : str;
    }

    public static /* synthetic */ List g(InputMethodManager inputMethodManager) {
        HashSet hashSet = new HashSet();
        Iterator<InputMethodInfo> it = inputMethodManager.getEnabledInputMethodList().iterator();
        while (it.hasNext()) {
            for (InputMethodSubtype inputMethodSubtype : inputMethodManager.getEnabledInputMethodSubtypeList(it.next(), true)) {
                String languageTag = Build.VERSION.SDK_INT >= 24 ? inputMethodSubtype.getLanguageTag() : inputMethodSubtype.getLocale();
                if (!com.google.common.base.p.b(languageTag)) {
                    hashSet.add(languageTag);
                }
            }
        }
        return hashSet.isEmpty() ? Collections.emptyList() : new ArrayList(hashSet);
    }

    public static void h(d.a aVar, Context context) {
        aVar.j(Locale.getDefault().toLanguageTag()).i((List) io.a.g(context, InputMethodManager.class, "input_method", new com.google.common.base.f() { // from class: fo.r
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return u.g((InputMethodManager) obj);
            }
        }, Collections.emptyList()));
    }

    public static d.a i(Context context) {
        d.a aVarE = d.k().e(b(context));
        a.InterfaceC0676a interfaceC0676aB = a.f().b(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        int i11 = Build.VERSION.SDK_INT;
        a.InterfaceC0676a interfaceC0676aC = interfaceC0676aB.c(i11 >= 24 ? io.b.c(context.getContentResolver(), "boot_count", -1) : -1);
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            interfaceC0676aC.a(lz.a("", i11 >= 26 ? Files.readAllLines(file.toPath(), StandardCharsets.UTF_8) : hj.g.c(file, StandardCharsets.UTF_8)).trim());
        } catch (Throwable unused) {
            interfaceC0676aC.a("");
        }
        d.a aVarD = aVarE.d(interfaceC0676aC.build());
        m(aVarD, context);
        j(aVarD, context);
        h(aVarD, context);
        l(aVarD, context);
        k(aVarD, context);
        return aVarD;
    }

    public static void j(d.a aVar, Context context) {
        int i11;
        String strD = "";
        if (io.a.c(context, "android.permission.BLUETOOTH") && ((i11 = Build.VERSION.SDK_INT) < 31 || io.a.c(context, "android.permission.BLUETOOTH_CONNECT"))) {
            if (i11 >= 31) {
                strD = (String) io.a.g(context, BluetoothManager.class, "bluetooth", new com.google.common.base.f() { // from class: fo.o
                    @Override // com.google.common.base.f
                    public final Object apply(Object obj) {
                        return ((BluetoothManager) obj).getAdapter().getName();
                    }
                }, "");
            } else {
                try {
                    strD = com.google.common.base.p.e(BluetoothAdapter.getDefaultAdapter().getName());
                } catch (Throwable unused) {
                }
            }
        }
        if (strD.isEmpty() && Build.VERSION.SDK_INT >= 25) {
            strD = io.b.d(context.getContentResolver(), "device_name");
        }
        aVar.k(strD);
    }

    public static void k(d.a aVar, Context context) {
        aVar.l(context.getResources().getDisplayMetrics().density).m((Point) io.a.g(context, WindowManager.class, "window", new com.google.common.base.f() { // from class: fo.p
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return u.a((WindowManager) obj);
            }
        }, new Point()));
    }

    public static void l(d.a aVar, Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z11 = false;
        d.a aVarG = aVar.g(0, io.b.a(contentResolver, "bluetooth_on")).g(1, io.b.a(contentResolver, "wifi_on")).g(2, io.b.f(contentResolver, "accessibility_enabled")).g(3, io.b.a(contentResolver, "auto_time_zone")).g(100, io.b.a(contentResolver, "adb_enabled"));
        if (Build.VERSION.SDK_INT >= 30 && io.a.d(context, "android.hardware.sensor.hinge_angle")) {
            z11 = true;
        }
        aVarG.g(5, z11);
    }

    public static void m(d.a aVar, Context context) {
        int iIntValue;
        if (io.a.d(context, "android.hardware.type.watch") || io.a.d(context, "android.hardware.type.automotive")) {
            iIntValue = 6;
        } else {
            iIntValue = (io.a.d(context, "android.software.leanback") || io.a.d(context, "android.hardware.type.television")) ? 3 : 0;
        }
        if (iIntValue == 0) {
            iIntValue = ((Integer) io.a.g(context, UiModeManager.class, "uimode", new com.google.common.base.f() { // from class: fo.q
                @Override // com.google.common.base.f
                public final Object apply(Object obj) {
                    return u.c((UiModeManager) obj);
                }
            }, 0)).intValue();
        }
        if (iIntValue == 0) {
            iIntValue = 1;
        }
        aVar.o(iIntValue);
    }
}
