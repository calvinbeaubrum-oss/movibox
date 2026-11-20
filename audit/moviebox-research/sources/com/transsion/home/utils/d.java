package com.transsion.home.utils;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import java.util.HashSet;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f52669a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f52670b = new HashSet<>();

    public final void a(String pageName, String moduleName, String str, String str2, Integer num, boolean z11, String str3, String str4, String str5) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        map.put("subject_id", str);
        map.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        map.put(RequestParameters.POSITION, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z11);
        map.put("has_resource", sb3.toString());
        map.put("category", String.valueOf(str3));
        map.put("rec_type", String.valueOf(str4));
        map.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f51183a.h(pageName, map);
    }

    public final void b(String pageName, String str, String str2, Integer num, String str3, String str4, String str5) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("staff_id", String.valueOf(str));
        map.put("ops", String.valueOf(str2));
        map.put(RequestParameters.POSITION, String.valueOf(num));
        if (str != null) {
            boolean zContains = this.f52670b.contains(str);
            this.f52670b.add(str);
            if (zContains) {
                return;
            }
        }
        map.put("category", String.valueOf(str3));
        map.put("rec_type", String.valueOf(str4));
        map.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f51183a.a(pageName, map);
    }

    public final void c(String pageName, String str, String str2, Integer num, String str3, String str4, String str5) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("staff_id", String.valueOf(str));
        map.put("ops", String.valueOf(str2));
        map.put(RequestParameters.POSITION, String.valueOf(num));
        map.put("category", String.valueOf(str3));
        map.put("rec_type", String.valueOf(str4));
        map.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f51183a.e(pageName, map);
    }

    public final void d(String pageName, String str, String str2, Integer num, boolean z11, String str3, String str4, String str5) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("subject_id", String.valueOf(str));
        map.put("ops", String.valueOf(str2));
        map.put(RequestParameters.POSITION, String.valueOf(num));
        if (str != null) {
            boolean zContains = this.f52669a.contains(str);
            this.f52669a.add(str);
            if (zContains) {
                return;
            }
        }
        map.put("has_resource", String.valueOf(z11));
        map.put("category", String.valueOf(str3));
        map.put("rec_type", String.valueOf(str4));
        map.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f51183a.a(pageName, map);
    }

    public final void e(String pageName, String str, String str2, Integer num, boolean z11, String str3, String str4, String str5) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("subject_id", String.valueOf(str));
        map.put("ops", String.valueOf(str2));
        map.put(RequestParameters.POSITION, String.valueOf(num));
        map.put("has_resource", String.valueOf(z11));
        map.put("category", String.valueOf(str3));
        map.put("rec_type", String.valueOf(str4));
        map.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f51183a.e(pageName, map);
    }
}
