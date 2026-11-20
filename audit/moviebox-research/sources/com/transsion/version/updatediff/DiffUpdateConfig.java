package com.transsion.version.updatediff;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.constant.ComConstants;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.ActivityPermissionUtil;
import com.transsion.lib.diffupdate.DownloadStrategy;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;

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
public final class DiffUpdateConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DiffUpdateConfig f59770a = new DiffUpdateConfig();

    public final void a(String path) {
        Intrinsics.g(path, "path");
        RoomAppMMKV.f51271a.a().putString("diff_update_new_package_cache_path", path);
    }

    public final void b(Function1<? super Boolean, Unit> resCall) {
        Intrinsics.g(resCall, "resCall");
        j.d(l0.a(w0.b()), null, null, new DiffUpdateConfig$checkDiffUpdatePkgState$1(resCall, null), 3, null);
    }

    public final boolean c() {
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        int i11 = roomAppMMKV.a().getInt("diff_dialog_showed", 1);
        long j11 = roomAppMMKV.a().getLong("diff_update_dialog_show_timestamp", 0L);
        int iD = com.blankj.utilcode.util.c.d();
        if (roomAppMMKV.a().getInt("version_code", iD) != iD) {
            return true;
        }
        return i11 < 3 && System.currentTimeMillis() - j11 > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
    }

    public final DownloadStrategy d() {
        String value;
        Integer numL = null;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "diff_update_patch_mode", false, 2, null);
        if (configBeanC != null && (value = configBeanC.getValue()) != null) {
            numL = k.l(value);
        }
        if (numL != null && numL.intValue() == 1) {
            return DownloadStrategy.WIFI;
        }
        if (numL != null && numL.intValue() == 2) {
            return DownloadStrategy.MOBILE_TRAFFIC_WIFI;
        }
        return (numL != null && numL.intValue() == 0) ? DownloadStrategy.DISABLE : DownloadStrategy.WIFI;
    }

    public final boolean e() {
        String value;
        Boolean boolY0;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("diff_update_switch", true);
        if (configBeanB == null || (value = configBeanB.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null) {
            return true;
        }
        return boolY0.booleanValue();
    }

    public final String f() {
        return RoomAppMMKV.f51271a.a().getString("diff_update_new_package_cache_path", "");
    }

    public final void g(final File apkFile, final String fromPage) {
        Intrinsics.g(apkFile, "apkFile");
        Intrinsics.g(fromPage, "fromPage");
        if (apkFile.exists()) {
            final PackageManager packageManager = Utils.a().getPackageManager();
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26 && !packageManager.canRequestPackageInstalls()) {
                ActivityPermissionUtil.f51294a.c("android.settings.MANAGE_UNKNOWN_APP_SOURCES", 10, new Function0<Unit>() { // from class: com.transsion.version.updatediff.DiffUpdateConfig$installApk$1
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
                        if (!packageManager.canRequestPackageInstalls()) {
                            c.f59779a.b(fromPage, false);
                        } else {
                            c.f59779a.b(fromPage, true);
                            DiffUpdateConfig.f59770a.g(apkFile, fromPage);
                        }
                    }
                });
                return;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(ASTNode.DEOP);
                if (i11 >= 24) {
                    intent.setFlags(1);
                    intent.setDataAndType(FileProvider.getUriForFile(Utils.a(), Utils.a().getPackageName() + ".download.fileprovider", apkFile), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                }
                if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
                    RoomAppMMKV.f51271a.a().putInt("diff_dialog_showed", 0);
                    Activity activityG = RoomActivityLifecycleCallbacks.f51239a.g();
                    if (activityG != null) {
                        activityG.startActivity(intent);
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final boolean h() {
        String strF = f();
        return strF != null && strF.length() > 0;
    }

    public final boolean i() {
        String value;
        Boolean boolY0;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("fb_diff_update_dialog_show", true);
        if (configBeanB == null || (value = configBeanB.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null) {
            return true;
        }
        return boolY0.booleanValue();
    }
}
