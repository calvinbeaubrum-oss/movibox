package com.transsion.shorttv.dot;

import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.baselib.report.m;
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f57848a = new b();

    public static /* synthetic */ void b(b bVar, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "minitv_play";
        }
        bVar.a(str, str2, str3);
    }

    public static /* synthetic */ void e(b bVar, String str, Integer num, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "minitv_play";
        }
        bVar.d(str, num, str2);
    }

    public final void a(String str, String dialogName, String pageName) {
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

    public final void c(String str, String optType, boolean z11, String pageName) {
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

    public final void d(String str, Integer num, String pageName) {
        String string;
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("module_name", AppLovinEventTypes.USER_SHARED_LINK);
        String str2 = "";
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        if (num != null && (string = num.toString()) != null) {
            str2 = string;
        }
        map.put("ep", str2);
        m.f51277a.t(pageName, "click", map);
    }
}
