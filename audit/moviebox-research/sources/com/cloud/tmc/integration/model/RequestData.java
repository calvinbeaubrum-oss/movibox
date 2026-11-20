package com.cloud.tmc.integration.model;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
public final class RequestData extends b implements Serializable {
    private Object data;
    private HashMap<String, String> header;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f30827id = "";
    private String method = "GET";
    private String url;

    public final Object getData() {
        return this.data;
    }

    public final HashMap<String, String> getHeader() {
        return this.header;
    }

    public final String getId() {
        return this.f30827id;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setHeader(HashMap<String, String> map) {
        this.header = map;
    }

    public final void setId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f30827id = str;
    }

    public final void setMethod(String str) {
        Intrinsics.g(str, "<set-?>");
        this.method = str;
    }

    public final void setUrl(String str) {
        this.url = str;
    }
}
