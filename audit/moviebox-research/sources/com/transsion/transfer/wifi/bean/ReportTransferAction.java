package com.transsion.transfer.wifi.bean;

import kotlin.Metadata;

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
public enum ReportTransferAction {
    REPORT_TRANSFER_ACTION("action"),
    REPORT_TRANSFER_ACTION_SHARE_APK_DIALOG("share_apk_dialog"),
    REPORT_TRANSFER_ACTION_CREATE_PAGE_PV("create_page"),
    REPORT_TRANSFER_ACTION_CREATE_TRIGGER("create_trigger"),
    REPORT_TRANSFER_ACTION_CREATE_CANCEL("create_cancel"),
    REPORT_TRANSFER_ACTION_CREATE_SUCCESS("create_success"),
    REPORT_TRANSFER_ACTION_CREATE_FAIL("create_fail"),
    REPORT_TRANSFER_ACTION_CONNECT_PAGE_PV("connect_page"),
    REPORT_TRANSFER_ACTION_CONNECT_TRIGGER("connect_trigger"),
    REPORT_TRANSFER_ACTION_CONNECT_CANCEL("connect_cancel"),
    REPORT_TRANSFER_ACTION_CONNECT_SUCCESS("connect_success"),
    REPORT_TRANSFER_ACTION_CONNECT_FAIL("connect_fail"),
    REPORT_TRANSFER_ACTION_PERMISSION_REQUEST("permission"),
    REPORT_TRANSFER_ACTION_PERMISSION_PAGE_PV("permission_page"),
    REPORT_TRANSFER_ACTION_SERVER_OPEN("server_open_success"),
    REPORT_TRANSFER_ACTION_CLIENT_CONNECT_START("client_connect_start"),
    REPORT_TRANSFER_ACTION_CLIENT_CONNECT_SUCCESS("client_connect_success"),
    xREPORT_TRANSFER_ACTION_CLIENT_CONNECT_FAILED("client_connect_failed"),
    REPORT_TRANSFER_ACTION_SERVER_CONNECT_SUCCESS("server_connect_success"),
    REPORT_TRANSFER_ACTION_SERVER_DISCONNECT("server_receive_disconnect"),
    REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT("client_receive_disconnect"),
    REPORT_TRANSFER_ACTION_SERVER_SEND_FILE_CMD("server_send_file_cmd"),
    REPORT_TRANSFER_ACTION_CLIENT_RECEIVE_FILE_CMD("client_receive_file_cmd"),
    REPORT_TRANSFER_ACTION_CLIENT_FETCH_FILES_START("client_fetch_files_req_start"),
    REPORT_TRANSFER_ACTION_SERVER_FETCH_FILES_HANDLE("server_fetch_files_req_handle"),
    REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_START("client_download_file_req_start"),
    REPORT_TRANSFER_ACTION_CLIENT_DOWNLOAD_FILE_END("client_download_file_req_end"),
    REPORT_TRANSFER_ACTION_CLIENT_NOTIFY_FINISH("client_notify_server_file_finish"),
    REPORT_TRANSFER_ACTION_CLIENT_SEND_FILE_NOTIFY("client_send_file_notify"),
    REPORT_TRANSFER_ACTION_SERVER_RECEIVE_FILE_READY("server_receive_file_ready"),
    REPORT_TRANSFER_ACTION_CLIENT_DISCONNECT_BY_USER("client_disconnect_byuser"),
    REPORT_TRANSFER_ACTION_SERVER_DISCONNECT_BY_USER("server_disconnect_byuser");

    private final String action;

    ReportTransferAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
