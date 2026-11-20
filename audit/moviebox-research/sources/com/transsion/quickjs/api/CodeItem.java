package com.transsion.quickjs.api;

import androidx.annotation.Keep;
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
public final class CodeItem {
    private final String configType;
    private final String file;
    private final String key;
    private final String value;

    public CodeItem() {
        this(null, null, null, null, 15, null);
    }

    public CodeItem(String str, String str2, String str3, String str4) {
        this.configType = str;
        this.key = str2;
        this.value = str3;
        this.file = str4;
    }

    public /* synthetic */ CodeItem(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }

    public static /* synthetic */ CodeItem copy$default(CodeItem codeItem, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = codeItem.configType;
        }
        if ((i11 & 2) != 0) {
            str2 = codeItem.key;
        }
        if ((i11 & 4) != 0) {
            str3 = codeItem.value;
        }
        if ((i11 & 8) != 0) {
            str4 = codeItem.file;
        }
        return codeItem.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.configType;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.value;
    }

    public final String component4() {
        return this.file;
    }

    public final CodeItem copy(String str, String str2, String str3, String str4) {
        return new CodeItem(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeItem)) {
            return false;
        }
        CodeItem codeItem = (CodeItem) obj;
        return Intrinsics.b(this.configType, codeItem.configType) && Intrinsics.b(this.key, codeItem.key) && Intrinsics.b(this.value, codeItem.value) && Intrinsics.b(this.file, codeItem.file);
    }

    public final String getConfigType() {
        return this.configType;
    }

    public final String getFile() {
        return this.file;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.configType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.key;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.value;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.file;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "CodeItem(configType=" + this.configType + ", key=" + this.key + ", value=" + this.value + ", file=" + this.file + ")";
    }
}
