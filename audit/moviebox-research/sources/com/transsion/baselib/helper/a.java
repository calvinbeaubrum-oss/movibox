package com.transsion.baselib.helper;

import com.transsion.baselib.report.m;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51183a = new a();

    public final void a(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.t(pageName, "browse", map);
    }

    public final void b(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.m(pageName, "click", map);
    }

    public final void c(Map<String, String> map) {
        Intrinsics.g(map, "map");
        m.f51277a.n("download_app", map);
    }

    public final void d(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.t(pageName, "browse", map);
    }

    public final void e(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.m(pageName, "click", map);
    }

    public final void f(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.m(pageName, "click", map);
    }

    public final void g(String pageName, String moduleName, String str, String str2, String str3) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        HashMap map = new HashMap();
        map.put("module_name", moduleName);
        if (str != null) {
            map.put("group_id", str);
        }
        if (str2 != null) {
            map.put("subject_id", str2);
        }
        if (str3 != null) {
            map.put("post_id", str3);
        }
        m.f51277a.m(pageName, "click", map);
    }

    public final void h(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.m(pageName, "click", map);
    }

    public final void j(String pageName, String pageFrom, String duration) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(pageFrom, "pageFrom");
        Intrinsics.g(duration, "duration");
        HashMap map = new HashMap();
        map.put(WebConstants.PAGE_FROM, pageFrom);
        map.put("duration", duration);
        m.f51277a.t(pageName, "pt", map);
    }

    public final void k(String pageName, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(map, "map");
        m.f51277a.m(pageName, "click", map);
    }

    public final void l(String pageName, String pageTabName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(pageTabName, "pageTabName");
        HashMap map = new HashMap();
        map.put("page_tab_name", pageTabName);
        m.f51277a.m(pageName, "click", map);
    }
}
