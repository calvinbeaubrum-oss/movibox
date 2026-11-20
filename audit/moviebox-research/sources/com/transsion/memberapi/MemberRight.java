package com.transsion.memberapi;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class MemberRight implements Serializable {
    private String description;
    private String icon;

    public MemberRight(String icon, String description) {
        Intrinsics.g(icon, "icon");
        Intrinsics.g(description, "description");
        this.icon = icon;
        this.description = description;
    }

    public static /* synthetic */ MemberRight copy$default(MemberRight memberRight, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = memberRight.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = memberRight.description;
        }
        return memberRight.copy(str, str2);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.description;
    }

    public final MemberRight copy(String icon, String description) {
        Intrinsics.g(icon, "icon");
        Intrinsics.g(description, "description");
        return new MemberRight(icon, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemberRight)) {
            return false;
        }
        MemberRight memberRight = (MemberRight) obj;
        return Intrinsics.b(this.icon, memberRight.icon) && Intrinsics.b(this.description, memberRight.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.description.hashCode();
    }

    public final void setDescription(String str) {
        Intrinsics.g(str, "<set-?>");
        this.description = str;
    }

    public final void setIcon(String str) {
        Intrinsics.g(str, "<set-?>");
        this.icon = str;
    }

    public String toString() {
        return "MemberRight(icon=" + this.icon + ", description=" + this.description + ")";
    }
}
