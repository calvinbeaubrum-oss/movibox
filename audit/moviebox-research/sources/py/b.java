package py;

import com.transsion.baselib.report.m;
import com.transsion.transfer.impl.h;
import com.transsion.transfer.impl.util.StringExtKt;
import com.transsion.transfer.wifi.bean.ReportTransferAction;
import com.transsion.transfer.wifi.util.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f74066a = new b();

    public final String a() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Map<String, String> b(ReportTransferAction reportTransferAction) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ReportTransferAction.REPORT_TRANSFER_ACTION.getAction(), reportTransferAction.getAction());
        return linkedHashMap;
    }

    public final void c(Map<String, String> map) {
        m.f51277a.t("transfer_status", "transfer", map);
    }

    public final void d(String error, String str) {
        Intrinsics.g(error, "error");
        Map<String, String> mapB = b(ReportTransferAction.xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED);
        mapB.put("error", error);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientConnectFailed() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void e(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS);
        g.f(g.f59252a, a() + " --> reportClientConnectSuccess() --> map = " + mapB, false, 2, null);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        c(mapB);
    }

    public final void f(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportServerReceiveDisconnectClick() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String remoteFilePath, boolean z11, String str, long j11, long j12, String str2) {
        Object objM163constructorimpl;
        Intrinsics.g(remoteFilePath, "remoteFilePath");
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END);
        mapB.put("task_id", StringExtKt.a(remoteFilePath));
        try {
            Result.Companion companion = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(StringsKt__StringsKt.O0(oy.a.a(remoteFilePath), '.', ""));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m169isFailureimpl(objM163constructorimpl)) {
            objM163constructorimpl = "";
        }
        mapB.put("file_type", objM163constructorimpl);
        mapB.put("success", String.valueOf(z11));
        if (str == null) {
            str = "";
        }
        mapB.put("error", str);
        mapB.put("file_size", String.valueOf(j11));
        mapB.put("time_cost", String.valueOf(j12));
        if (str2 == null) {
            str2 = "";
        }
        mapB.put("transfer_id", str2);
        g.f(g.f59252a, a() + " --> reportClientDownloadFileEnd() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void h(String path, long j11, String str) {
        Intrinsics.g(path, "path");
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START);
        mapB.put("task_id", StringExtKt.a(path));
        mapB.put("file_size", String.valueOf(j11));
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientDownloadFileStart() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void i(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientFetchFilesStart() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void j(String str, String str2) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT);
        if (str == null) {
            str = "";
        }
        mapB.put("type", str);
        if (str2 == null) {
            str2 = "";
        }
        mapB.put("transfer_id", str2);
        g.f(g.f59252a, a() + " --> reportClientReceiveDisconnect() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void k(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientReceiveServerUpdateFileList() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void l(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientSendFileNotify() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void m(int i11, String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH);
        mapB.put("file_list_size", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientServerFilesFinish() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void n(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        g.f(g.f59252a, a() + " --> reportClientStartConnect() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void o(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerConnectSuccess() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void p(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerReceiveDisconnectClick() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void q(int i11, String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE);
        mapB.put("file_list_size", String.valueOf(i11));
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerHandleFetchFiles() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void r() {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_OPEN);
        g.f(g.f59252a, a() + " --> reportServerOpen() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void s(String str, String str2) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_DISCONNECT);
        if (str == null) {
            str = "";
        }
        mapB.put("type", str);
        if (str2 == null) {
            str2 = "";
        }
        mapB.put("transfer_id", str2);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerReceiveDisconnect() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void t(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerReceiveFile() --> map = " + mapB, false, 2, null);
        c(mapB);
    }

    public final void u(String str) {
        Map<String, String> mapB = b(ReportTransferAction.REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD);
        if (str == null) {
            str = "";
        }
        mapB.put("transfer_id", str);
        mapB.put("transfer_channel_info", h.f59057a.a());
        g.f(g.f59252a, a() + " --> reportServerSendFileClick() --> map = " + mapB, false, 2, null);
        c(mapB);
    }
}
