package com.transsnet.downloader.report;

import com.transsion.baselib.report.m;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f61117a = new HashSet<>();

    public final void a(String pageName, Subject item, int i11, long j11) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(item, "item");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f61117a.contains(item.getSubjectId())) {
            return;
        }
        this.f61117a.add(item.getSubjectId());
        linkedHashMap.put("sequence", String.valueOf(i11));
        linkedHashMap.put("ops", String.valueOf(item.getOps()));
        linkedHashMap.put("subject_id", String.valueOf(item.getSubjectId()));
        if (j11 > 0) {
            linkedHashMap.put("browse_duration", String.valueOf(j11));
        }
        linkedHashMap.put("has_resource", String.valueOf(item.getHasResource()));
        m.f51277a.t(pageName, "browse", linkedHashMap);
    }

    public final void b(String pageName, Subject subject, int i11) {
        Intrinsics.g(pageName, "pageName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sequence", String.valueOf(i11));
        linkedHashMap.put("ops", String.valueOf(subject != null ? subject.getOps() : null));
        linkedHashMap.put("subject_id", String.valueOf(subject != null ? subject.getSubjectId() : null));
        linkedHashMap.put("has_resource", String.valueOf(subject != null ? subject.getHasResource() : null));
        m.f51277a.m(pageName, "click", linkedHashMap);
    }

    public final void c(String pageName, Subject subject, String moduleName) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(moduleName, "moduleName");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", moduleName);
        linkedHashMap.put("ops", String.valueOf(subject != null ? subject.getOps() : null));
        linkedHashMap.put("subject_id", String.valueOf(subject != null ? subject.getSubjectId() : null));
        linkedHashMap.put("has_resource", String.valueOf(subject != null ? subject.getHasResource() : null));
        m.f51277a.m(pageName, "click", linkedHashMap);
    }
}
