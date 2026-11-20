package py;

import android.os.Build;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.baselib.report.m;
import com.transsion.transfer.wifi.bean.PermissionState;
import com.transsion.transfer.wifi.bean.ReportTransferAction;
import com.transsion.transfer.wifi.permission.PermissionsBean;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.transsion.transfer.wifi.util.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sy.e;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f74067a = new c();

    public final String a() {
        String simpleName = c.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Map<String, String> b(ReportTransferAction reportTransferAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ReportTransferAction.REPORT_TRANSFER_ACTION.getAction(), reportTransferAction.getAction());
        linkedHashMap.put("is_p2p_supported", String.valueOf(WifiUtils.f59242a.p()));
        linkedHashMap.put("sdk_int", String.valueOf(Build.VERSION.SDK_INT));
        return linkedHashMap;
    }

    public final void c(Map<String, String> map) {
        m.f51277a.t("wifi_p2p", "transfer", map);
    }

    public final void d() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_CANCEL);
        g.f(g.f59252a, a() + " --> reportConnectWifiCancel() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void e(int i11) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_FAIL);
        mapB.put(TrackingKey.CODE, String.valueOf(i11));
        g.f(g.f59252a, a() + " --> reportConnectWifiFail() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void f(long j11) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_SUCCESS);
        mapB.put("duration", String.valueOf(j11));
        g.f(g.f59252a, a() + " --> reportConnectWifiSuccess() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void g() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CONNECT_TRIGGER);
        g.f(g.f59252a, a() + " --> reportConnectWifiTrigger() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void h() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_CANCEL);
        g.f(g.f59252a, a() + " --> reportCreateWifiP2PCancel() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void i(int i11) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_FAIL);
        mapB.put(TrackingKey.CODE, String.valueOf(i11));
        g.f(g.f59252a, a() + " --> reportCreateWifiP2PFail() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void j(long j11, long j12) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_SUCCESS);
        mapB.put("duration", String.valueOf(j11));
        mapB.put("qr_duration", String.valueOf(j12));
        g.f(g.f59252a, a() + " --> reportCreateWifiP2PSuccess() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void k() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CREATE_TRIGGER);
        g.f(g.f59252a, a() + " --> reportCreateWifiP2PTrigger() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    @Deprecated
    public final void l(String str, String permissions, PermissionState permissionsState) {
        Intrinsics.g(permissions, "permissions");
        Intrinsics.g(permissionsState, "permissionsState");
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_PERMISSION_REQUEST);
        mapB.put("user_role", Intrinsics.b(str, "com.transsion.transfer.wifi.util.send") ? "sender" : "receiver");
        mapB.put("permissions", permissions);
        mapB.put("state", permissionsState.getState());
    }

    public final void m(String str) {
        String str2;
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV);
        if (Intrinsics.b(str, "com.transsion.transfer.wifi.util.send")) {
            for (PermissionsBean permissionsBean : e.f76637a.e()) {
                mapB.put(permissionsBean.getPermission(), permissionsBean.getState().getState());
            }
            str2 = "sender";
        } else {
            for (PermissionsBean permissionsBean2 : e.f76637a.c()) {
                mapB.put(permissionsBean2.getPermission(), permissionsBean2.getState().getState());
            }
            str2 = "receiver";
        }
        mapB.put("user_role", str2);
        g.f(g.f59252a, a() + " --> reportPermission() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void n() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG);
        g.f(g.f59252a, a() + " --> reportShareApkDialogShow() --> map = " + mapB, false, 2, null);
        c(mapB);
    }
}
