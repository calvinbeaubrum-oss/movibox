package com.cloud.tmc.integration.permission.model;

import java.util.HashMap;
import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ApiPermissionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f30896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, List<String>> f30897b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, String> f30898c = new HashMap<>();

    public final void clear() {
        this.f30897b.clear();
        this.f30898c.clear();
    }

    public final List<String> getApiLevelList(String level) {
        Intrinsics.g(level, "level");
        return this.f30897b.get(level);
    }

    public final String getApiLevelStr(String level) {
        Intrinsics.g(level, "level");
        return this.f30898c.get(level);
    }

    public final boolean isHasPermissionFile() {
        return this.f30896a;
    }

    public final void setApiLevelList(String level, List<String> list) {
        Intrinsics.g(level, "level");
        Intrinsics.g(list, "list");
        this.f30897b.put(level, list);
    }

    public final void setApiLevelStr(String level, String value) {
        Intrinsics.g(level, "level");
        Intrinsics.g(value, "value");
        this.f30898c.put(level, value);
    }

    public final void setHasPermissionFile(boolean z11) {
        this.f30896a = z11;
    }
}
