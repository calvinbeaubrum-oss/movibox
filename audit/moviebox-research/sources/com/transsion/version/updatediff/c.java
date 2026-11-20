package com.transsion.version.updatediff;

import com.transsion.baselib.report.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f59779a = new c();

    public final void a(String fromPage, boolean z11) {
        Intrinsics.g(fromPage, "fromPage");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isUpgrade", String.valueOf(z11));
        linkedHashMap.put("event_detail", "event_dialog_upgrade_click");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("click diff update from page:");
        sb2.append(fromPage);
        sb2.append(", ");
        sb2.append(linkedHashMap);
        linkedHashMap.put("action", "click");
        m.f51277a.m(fromPage, "update", linkedHashMap);
    }

    public final void b(String fromPage, boolean z11) {
        Intrinsics.g(fromPage, "fromPage");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("isAgree", String.valueOf(z11));
        linkedHashMap.put("event_detail", "event_install_permission_click");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("click request install permission from page:");
        sb2.append(fromPage);
        sb2.append(", ");
        sb2.append(linkedHashMap);
        linkedHashMap.put("action", "click");
        m.f51277a.m(fromPage, "update", linkedHashMap);
    }

    public final void c(Map<String, String> info) {
        Intrinsics.g(info, "info");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "event_download_package_fail_key");
        linkedHashMap.putAll(info);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("log diff update process fail reason: ");
        sb2.append(info);
        linkedHashMap.put("action", "click");
        m.f51277a.t("main_page", "update", linkedHashMap);
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "event_download_package_start_key");
        linkedHashMap.put("action", "click");
        m.f51277a.t("main_page", "update", linkedHashMap);
    }

    public final void e(Map<String, String> info) {
        Intrinsics.g(info, "info");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "event_download_package_success_key");
        linkedHashMap.putAll(info);
        linkedHashMap.put("action", "click");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("log diff update process success, info: ");
        sb2.append(info);
        m.f51277a.t("main_page", "update", linkedHashMap);
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "event_install_complete");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("log diff update process complete  ");
        sb2.append(linkedHashMap);
        linkedHashMap.put("action", "click");
        m.f51277a.m("main_page", "update", linkedHashMap);
    }

    public final void g(String fromPage) {
        Intrinsics.g(fromPage, "fromPage");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("event_detail", "event_dialog_show");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("show diffUpdateDialog from page:");
        sb2.append(fromPage);
        sb2.append(", ");
        sb2.append(linkedHashMap);
        linkedHashMap.put("action", "browse");
        m.f51277a.t(fromPage, "update", linkedHashMap);
    }
}
