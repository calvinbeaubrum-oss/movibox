package com.transsion.commercialization;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.transsion.baselib.helper.a;
import com.transsion.commercializationapi.IInterceptReportApi;
import java.util.LinkedHashMap;
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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/commercialize/InterceptReportProvider")
@Metadata
public final class InterceptReportProvider implements IInterceptReportApi {
    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void S() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "member_guide_dialog_click_get_ad");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void T() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_task_dialog_resume_all_click");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void Z() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "get_ad_free_btn_show");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void j() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "member_guide_dialog_click_close");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void o() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_page_manager_btn_click");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void q() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "member_guide_dialog_show");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void q0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_task_dialog_pause_all_click");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void w1() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "get_ad_free_btn_click");
        a.f51183a.b("download_intercept", linkedHashMap);
    }

    @Override // com.transsion.commercializationapi.IInterceptReportApi
    public void y0() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_task_dialog_at_a_time_click");
        a.f51183a.b("download_intercept", linkedHashMap);
    }
}
