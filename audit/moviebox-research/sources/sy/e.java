package sy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.transfer.R$drawable;
import com.transsion.transfer.R$string;
import com.transsion.transfer.wifi.bean.PermissionState;
import com.transsion.transfer.wifi.permission.PermissionsBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f76637a = new e();

    public final boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context);
    }

    public final boolean b(String permission) {
        Intrinsics.g(permission, "permission");
        return Build.VERSION.SDK_INT < 23 || Utils.a().checkSelfPermission(permission) == 0;
    }

    public final List<PermissionsBean> c() {
        ArrayList<PermissionsBean> arrayList = new ArrayList();
        PermissionsBean permissionsBeanD = d("android.permission.CAMERA");
        if (permissionsBeanD != null) {
            arrayList.add(permissionsBeanD);
        }
        arrayList.addAll(e());
        for (PermissionsBean permissionsBean : arrayList) {
            if (f76637a.f(permissionsBean.getPermission())) {
                permissionsBean.setState(PermissionState.PERMISSION_GRANTED);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final PermissionsBean d(String str) {
        switch (str.hashCode()) {
            case -2078357533:
                if (!str.equals("android.permission.WRITE_SETTINGS")) {
                    return null;
                }
                int i11 = R$drawable.transfer_wifi_permissions_write_settings;
                String string = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_write_settings);
                String string2 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_write_settings_tip);
                PermissionState permissionState = PermissionState.PERMISSION_DENIED;
                String string3 = Utils.a().getResources().getString(R$string.wifi_setting);
                Intrinsics.f(string3, "getApp().resources.getSt…ng(R.string.wifi_setting)");
                return new PermissionsBean(0, i11, string, string2, permissionState, "android.permission.WRITE_SETTINGS", string3);
            case -1888586689:
                if (!str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    return null;
                }
                int i12 = R$drawable.transfer_wifi_permissions_location;
                String string4 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_location_title);
                String string5 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_location_tip);
                PermissionState permissionState2 = PermissionState.PERMISSION_DENIED;
                String string6 = Utils.a().getResources().getString(R$string.wifi_setting);
                Intrinsics.f(string6, "getApp().resources.getSt…ng(R.string.wifi_setting)");
                return new PermissionsBean(0, i12, string4, string5, permissionState2, "android.permission.ACCESS_FINE_LOCATION", string6);
            case -1208777349:
                if (!str.equals("mb.permission.WIFI")) {
                    return null;
                }
                int i13 = R$drawable.transfer_wifi_permissions_wifi;
                String string7 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_wifi_title);
                String string8 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_wifi_tip);
                PermissionState permissionState3 = PermissionState.PERMISSION_DENIED;
                String string9 = Utils.a().getResources().getString(R$string.wifi_setting);
                Intrinsics.f(string9, "getApp().resources.getSt…ng(R.string.wifi_setting)");
                return new PermissionsBean(0, i13, string7, string8, permissionState3, "mb.permission.WIFI", string9);
            case -909527021:
                if (!str.equals("android.permission.NEARBY_WIFI_DEVICES") || Build.VERSION.SDK_INT < 33) {
                    return null;
                }
                int i14 = R$drawable.transfer_wifi_permissions_devices;
                String string10 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_device_title);
                String string11 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_device_tip);
                PermissionState permissionState4 = PermissionState.PERMISSION_DENIED;
                String string12 = Utils.a().getResources().getString(R$string.wifi_setting);
                Intrinsics.f(string12, "getApp().resources.getSt…ng(R.string.wifi_setting)");
                return new PermissionsBean(0, i14, string10, string11, permissionState4, "android.permission.NEARBY_WIFI_DEVICES", string12);
            case 463403621:
                if (!str.equals("android.permission.CAMERA")) {
                    return null;
                }
                int i15 = R$drawable.transfer_wifi_permissions_camera;
                String string13 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_camera_title);
                String string14 = Utils.a().getResources().getString(R$string.transfer_wifi_permissions_camera_tip);
                PermissionState permissionState5 = PermissionState.PERMISSION_DENIED;
                String string15 = Utils.a().getResources().getString(R$string.wifi_setting);
                Intrinsics.f(string15, "getApp().resources.getSt…ng(R.string.wifi_setting)");
                return new PermissionsBean(0, i15, string13, string14, permissionState5, "android.permission.CAMERA", string15);
            default:
                return null;
        }
    }

    public final List<PermissionsBean> e() {
        PermissionsBean permissionsBeanD;
        PermissionsBean permissionsBeanD2;
        ArrayList<PermissionsBean> arrayList = new ArrayList();
        PermissionsBean permissionsBeanD3 = d("mb.permission.WIFI");
        if (permissionsBeanD3 != null) {
            arrayList.add(permissionsBeanD3);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23 && (permissionsBeanD2 = d("android.permission.WRITE_SETTINGS")) != null) {
            arrayList.add(permissionsBeanD2);
        }
        PermissionsBean permissionsBeanD4 = d("android.permission.ACCESS_FINE_LOCATION");
        if (permissionsBeanD4 != null) {
            arrayList.add(permissionsBeanD4);
        }
        if (i11 >= 33 && (permissionsBeanD = d("android.permission.NEARBY_WIFI_DEVICES")) != null) {
            arrayList.add(permissionsBeanD);
        }
        for (PermissionsBean permissionsBean : arrayList) {
            if (f76637a.f(permissionsBean.getPermission())) {
                permissionsBean.setState(PermissionState.PERMISSION_GRANTED);
            }
        }
        return arrayList;
    }

    public final boolean f(String permission) {
        Intrinsics.g(permission, "permission");
        if (!Intrinsics.b(permission, "mb.permission.WIFI")) {
            return Intrinsics.b(permission, "android.permission.WRITE_SETTINGS") ? a(Utils.a()) : b(permission);
        }
        Object systemService = Utils.a().getApplicationContext().getSystemService("wifi");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        return ((WifiManager) systemService).isWifiEnabled();
    }

    public final boolean g(List<PermissionsBean> list) {
        if (Build.VERSION.SDK_INT >= 23 && list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!f76637a.f(((PermissionsBean) it.next()).getPermission())) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void h(AppCompatActivity activity) {
        Intrinsics.g(activity, "activity");
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", com.blankj.utilcode.util.c.c(), null));
            activity.startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    public final void i(AppCompatActivity activity, String permission, int i11) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(permission, "permission");
        ActivityCompat.g(activity, new String[]{permission}, i11);
    }
}
