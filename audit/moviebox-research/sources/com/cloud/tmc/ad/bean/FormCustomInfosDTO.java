package com.cloud.tmc.ad.bean;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FormCustomInfosDTO implements Serializable {
    private String title;
    private List<String> values;

    /* JADX WARN: Multi-variable type inference failed */
    public FormCustomInfosDTO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public FormCustomInfosDTO(String str, List<String> list) {
        this.title = str;
        this.values = list;
    }

    public /* synthetic */ FormCustomInfosDTO(String str, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormCustomInfosDTO copy$default(FormCustomInfosDTO formCustomInfosDTO, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = formCustomInfosDTO.title;
        }
        if ((i11 & 2) != 0) {
            list = formCustomInfosDTO.values;
        }
        return formCustomInfosDTO.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<String> component2() {
        return this.values;
    }

    public final FormCustomInfosDTO copy(String str, List<String> list) {
        return new FormCustomInfosDTO(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormCustomInfosDTO)) {
            return false;
        }
        FormCustomInfosDTO formCustomInfosDTO = (FormCustomInfosDTO) obj;
        return Intrinsics.b(this.title, formCustomInfosDTO.title) && Intrinsics.b(this.values, formCustomInfosDTO.values);
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getValues() {
        return this.values;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.values;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setValues(List<String> list) {
        this.values = list;
    }

    public String toString() {
        return "FormCustomInfosDTO(title=" + this.title + ", values=" + this.values + ')';
    }
}
