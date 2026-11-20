package com.cloud.tmc.integration.model;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
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
public final class ScopeModel extends b implements Serializable {
    private List<String> apis;
    private boolean defaultAuthorization;
    private JsonObject language;
    private String scopeName;
    private boolean userAuthorization;
    private long validityTime;

    public final List<String> getApis() {
        return this.apis;
    }

    public final boolean getDefaultAuthorization() {
        return this.defaultAuthorization;
    }

    public final JsonObject getLanguage() {
        return this.language;
    }

    public final String getScopeName() {
        return this.scopeName;
    }

    public final boolean getUserAuthorization() {
        return this.userAuthorization;
    }

    public final long getValidityTime() {
        return this.validityTime;
    }

    public final void setApis(List<String> list) {
        this.apis = list;
    }

    public final void setDefaultAuthorization(boolean z11) {
        this.defaultAuthorization = z11;
    }

    public final void setLanguage(JsonObject jsonObject) {
        this.language = jsonObject;
    }

    public final void setScopeName(String str) {
        this.scopeName = str;
    }

    public final void setUserAuthorization(boolean z11) {
        this.userAuthorization = z11;
    }

    public final void setValidityTime(long j11) {
        this.validityTime = j11;
    }
}
