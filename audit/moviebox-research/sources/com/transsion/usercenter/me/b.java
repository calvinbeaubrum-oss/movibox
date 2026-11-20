package com.transsion.usercenter.me;

import com.alibaba.sdk.android.oss.common.RequestParameters;
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
    public static final b f59452a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f59453b;

    public final void a(String moduleName) {
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        String str = f59453b;
        if (str == null) {
            str = "";
        }
        map.put("user_id", str);
        map.put("user_status", "me");
        map.put("module_name", moduleName);
        m.f51277a.t("profiledetail", "browse", map);
    }

    public final void b(String moduleName) {
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        String str = f59453b;
        if (str == null) {
            str = "";
        }
        map.put("user_id", str);
        map.put("user_status", "me");
        map.put("module_name", moduleName);
        m.f51277a.m("profiledetail", "click", map);
    }

    public final void c(String moduleName, int i11) {
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        String str = f59453b;
        if (str == null) {
            str = "";
        }
        map.put("user_id", str);
        map.put("user_status", "me");
        map.put("module_name", moduleName);
        map.put(RequestParameters.POSITION, String.valueOf(i11));
        m.f51277a.m("profiledetail", "click", map);
    }

    public final void d(String str) {
        f59453b = str;
    }
}
