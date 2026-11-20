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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f52668a = new HashSet<>();

    public final void a(String pageName, String str, String str2, Integer num, String str3, boolean z11, String str4) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        map.put(RequestParameters.POSITION, sb2.toString());
        map.put("item_type", str3);
        if (str != null) {
            boolean zContains = this.f52668a.contains(str);
            this.f52668a.add(str);
            if (zContains) {
                return;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z11);
        map.put("has_resource", sb3.toString());
        map.put("category_type", str4);
        com.transsion.baselib.helper.a.f51183a.a(pageName, map);
    }

    public final void b(String pageName, String str, String str2, Integer num, String str3, boolean z11, String str4) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        map.put(RequestParameters.POSITION, sb2.toString());
        map.put("item_type", str3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z11);
        map.put("has_resource", sb3.toString());
        map.put("category_type", str4);
        com.transsion.baselib.helper.a.f51183a.e(pageName, map);
    }

    public final void c(String pageName, String moduleName, String str, String str2, Integer num, String str3, boolean z11, String str4) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        map.put("subject_id", str);
        map.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        map.put(RequestParameters.POSITION, sb2.toString());
        map.put("item_type", str3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z11);
        map.put("has_resource", sb3.toString());
        map.put("category_type", str4);
        com.transsion.baselib.helper.a.f51183a.h(pageName, map);
    }

    public final void d(String pageName, String str) {
        Intrinsics.g(pageName, "pageName");
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        com.transsion.baselib.helper.a.f51183a.a(pageName, map);
    }

    public final void e(String pageName, String str, String moduleName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        if (str == null) {
            str = "";
        }
        map.put("subject_id", str);
        map.put("module_name", moduleName);
        com.transsion.baselib.helper.a.f51183a.b(pageName, map);
    }
}
