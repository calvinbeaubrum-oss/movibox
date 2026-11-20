package com.transsnet.downloader.report;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashMap;
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
public final class b {
    public static /* synthetic */ void b(b bVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = "minitv_download";
        }
        bVar.a(str, str2, str3, str4);
    }

    public static /* synthetic */ void d(b bVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "minitv_download";
        }
        bVar.c(str, str2, str3);
    }

    public static /* synthetic */ void g(b bVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "minitv_download";
        }
        bVar.f(str, str2);
    }

    public static /* synthetic */ void i(b bVar, Subject subject, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = "minitv_download";
        }
        bVar.h(subject, str, str2, str3);
    }

    public final void a(String str, String optType, String position, String pageName) {
        Intrinsics.g(optType, "optType");
        Intrinsics.g(position, "position");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("module_name", "watch_ad");
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        map.put("opt_type", optType);
        map.put(RequestParameters.POSITION, position);
        m.f51277a.t(pageName, "click", map);
    }

    public final void c(String str, String dialogName, String pageName) {
        Intrinsics.g(dialogName, "dialogName");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        map.put("dialog_name", dialogName);
        m.f51277a.t(pageName, "dialog_show", map);
    }

    public final void e(String str, String optType, boolean z11, String pageName) {
        Intrinsics.g(optType, "optType");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("module_name", "favorite");
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        map.put("opt_type", optType);
        map.put("favorite", String.valueOf(!z11));
        m.f51277a.t(pageName, "click", map);
    }

    public final void f(String str, String pageName) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("module_name", AppLovinEventTypes.USER_SHARED_LINK);
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        m.f51277a.t(pageName, "click", map);
    }

    public final void h(Subject subject, String unlockType, String unlockEp, String pageName) {
        String subjectId;
        String ops;
        Intrinsics.g(unlockType, "unlockType");
        Intrinsics.g(unlockEp, "unlockEp");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        map.put("unlock_ep", unlockEp);
        map.put("unlock_type", unlockType);
        if (subject != null && (ops = subject.getOps()) != null && ops.length() > 0) {
            String ops2 = subject.getOps();
            map.put("ops", ops2 != null ? ops2 : "");
        }
        m.f51277a.t(pageName, "minitv_unlock", map);
    }
}
