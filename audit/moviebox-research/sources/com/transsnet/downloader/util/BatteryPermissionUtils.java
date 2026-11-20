package com.transsnet.downloader.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.RequiresApi;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.h0;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.dialog.RequestAuthorizationDialog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BatteryPermissionUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BatteryPermissionUtils f61124a = new BatteryPermissionUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f61125b;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(BatteryPermissionUtils batteryPermissionUtils, Context context, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        batteryPermissionUtils.c(context, str, function0);
    }

    public static final void e(Ref.BooleanRef isRequestPermission, Context context, DialogInterface dialogInterface) {
        Intrinsics.g(isRequestPermission, "$isRequestPermission");
        Intrinsics.g(context, "$context");
        if (isRequestPermission.element) {
            return;
        }
        co.c.f15010a.c(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(BatteryPermissionUtils batteryPermissionUtils, Context context, String str, Function0 function0, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        batteryPermissionUtils.i(context, str, function0);
    }

    public final void b() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        roomAppMMKV.a().putLong("key_showed_times", roomAppMMKV.a().getLong("key_showed_times", 0L) + 1);
        roomAppMMKV.a().putLong("key_show_last_time", System.currentTimeMillis());
    }

    public final void c(final Context context, final String pageFrom, final Function0<Unit> function0) {
        String value;
        Integer numL;
        String value2;
        Long lN;
        Intrinsics.g(context, "context");
        Intrinsics.g(pageFrom, "pageFrom");
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        long j11 = 0;
        long j12 = roomAppMMKV.a().getLong("key_show_last_time", 0L);
        long j13 = roomAppMMKV.a().getLong("key_showed_times", 0L);
        ConfigManager.a aVar = ConfigManager.f53111c;
        ConfigBean configBeanB = aVar.a().b("key_total_show_times", false);
        long jLongValue = (configBeanB == null || (value2 = configBeanB.getValue()) == null || (lN = kotlin.text.k.n(value2)) == null) ? 3L : lN.longValue();
        long j14 = jLongValue > 0 ? jLongValue : 3L;
        ConfigBean configBeanB2 = aVar.a().b("sb_battery_interval_day", false);
        int iIntValue = (configBeanB2 == null || (value = configBeanB2.getValue()) == null || (numL = kotlin.text.k.l(value)) == null) ? 10 : numL.intValue();
        int i11 = iIntValue > 0 ? iIntValue : 10;
        boolean zF = h0.f(j12);
        if (TimeUtilKt.b() - TimeUtilKt.c(j12) > i11) {
            roomAppMMKV.a().putLong("key_showed_times", 0L);
        } else {
            j11 = j13;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (zF || j14 <= j11) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (g(context)) {
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        RequestAuthorizationDialog requestAuthorizationDialogA = RequestAuthorizationDialog.f60559h.a();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        requestAuthorizationDialogA.s0(new Function0<Unit>() { // from class: com.transsnet.downloader.util.BatteryPermissionUtils$checkBattery$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                booleanRef.element = true;
                BatteryPermissionUtils.f61124a.i(context, pageFrom, function0);
            }
        });
        Dialog dialog = requestAuthorizationDialogA.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        requestAuthorizationDialogA.i0(new DialogInterface.OnDismissListener() { // from class: com.transsnet.downloader.util.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BatteryPermissionUtils.e(booleanRef, context, dialogInterface);
            }
        });
        if (co.c.f15010a.b(requestAuthorizationDialogA, "authorization_dialog")) {
            requestAuthorizationDialogA.j0(context, "authorization_dialog");
        }
    }

    public final void f(String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB == null || activityB.isFinishing() || activityB.isDestroyed()) {
            return;
        }
        d(f61124a, activityB, pageFrom, null, 4, null);
    }

    @RequiresApi(api = 23)
    public final boolean g(Context context) {
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean zIsIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(Utils.a().getPackageName());
        if (!f61125b) {
            HashMap map = new HashMap();
            map.put("battery_opt", String.valueOf(zIsIgnoringBatteryOptimizations));
            com.transsion.baselib.report.m.f51277a.t("battery_opt", "app_perf", map);
            f61125b = true;
        }
        return zIsIgnoringBatteryOptimizations;
    }

    @RequiresApi(api = 23)
    public final void h(Context context) {
        Intrinsics.g(context, "context");
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            context.startActivity(intent);
            HashMap map = new HashMap();
            map.put("action", "system_battery_page_show");
            com.transsion.baselib.report.m.f51277a.t("download_authorization", "browse", map);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @RequiresApi(api = 23)
    public final void i(Context context, String pageFrom, final Function0<Unit> function0) {
        Intrinsics.g(context, "context");
        Intrinsics.g(pageFrom, "pageFrom");
        try {
            ActivityPermissionUtil.f51294a.d("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "android.settings.APPLICATION_DETAILS_SETTINGS", 11101, new Function0<Unit>() { // from class: com.transsnet.downloader.util.BatteryPermissionUtils$requestIgnoreBatteryOptimizations$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0<Unit> function1 = function0;
                    if (function1 != null) {
                        function1.invoke();
                    }
                }
            });
            HashMap map = new HashMap();
            map.put("action", "system_dialog_show");
            map.put(WebConstants.PAGE_FROM, pageFrom);
            com.transsion.baselib.report.m.f51277a.t("download_authorization", "browse", map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
