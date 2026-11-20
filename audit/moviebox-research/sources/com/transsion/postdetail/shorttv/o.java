package com.transsion.postdetail.shorttv;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.web.api.WebConstants;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f55416a = new o();

    public static /* synthetic */ void b(o oVar, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str4 = "minitv_play";
        }
        oVar.a(str, str2, str3, str4);
    }

    public static /* synthetic */ void d(o oVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "minitv_play";
        }
        oVar.c(str, str2, str3);
    }

    public static /* synthetic */ void f(o oVar, String str, String str2, boolean z11, String str3, String str4, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str3 = "minitv_play";
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            str4 = null;
        }
        oVar.e(str, str2, z11, str5, str4);
    }

    public static /* synthetic */ void h(o oVar, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str5 = "minitv_play";
        }
        oVar.g(str, str2, str3, str4, str5);
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
        com.transsion.baselib.report.m.f51277a.t(pageName, "click", map);
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
        com.transsion.baselib.report.m.f51277a.t(pageName, "dialog_show", map);
    }

    public final void e(String str, String optType, boolean z11, String pageName, String str2) {
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
        if (str2 != null && str2.length() != 0) {
            map.put(WebConstants.PAGE_FROM, str2);
        }
        com.transsion.baselib.report.m.f51277a.t(pageName, "click", map);
    }

    public final void g(String subjectId, String str, String unlockType, String unlockEp, String pageName) {
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(unlockType, "unlockType");
        Intrinsics.g(unlockEp, "unlockEp");
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("subject_id", subjectId);
        map.put("unlock_ep", unlockEp);
        map.put("unlock_type", unlockType);
        if (str != null && str.length() > 0) {
            map.put("ops", str);
        }
        com.transsion.baselib.report.m.f51277a.t(pageName, "minitv_unlock", map);
    }
}
