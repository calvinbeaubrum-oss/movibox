package com.transsion.quickjs.api;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class JSConfigBean {
    private final List<CodeItem> items;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public JSConfigBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public JSConfigBean(List<CodeItem> list, String str) {
        this.items = list;
        this.version = str;
    }

    public /* synthetic */ JSConfigBean(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSConfigBean copy$default(JSConfigBean jSConfigBean, List list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = jSConfigBean.items;
        }
        if ((i11 & 2) != 0) {
            str = jSConfigBean.version;
        }
        return jSConfigBean.copy(list, str);
    }

    public final List<CodeItem> component1() {
        return this.items;
    }

    public final String component2() {
        return this.version;
    }

    public final JSConfigBean copy(List<CodeItem> list, String str) {
        return new JSConfigBean(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JSConfigBean)) {
            return false;
        }
        JSConfigBean jSConfigBean = (JSConfigBean) obj;
        return Intrinsics.b(this.items, jSConfigBean.items) && Intrinsics.b(this.version, jSConfigBean.version);
    }

    public final List<CodeItem> getItems() {
        return this.items;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        List<CodeItem> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.version;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "JSConfigBean(items=" + this.items + ", version=" + this.version + ")";
    }
}
