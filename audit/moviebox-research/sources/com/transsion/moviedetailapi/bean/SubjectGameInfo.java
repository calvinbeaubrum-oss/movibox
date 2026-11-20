package com.transsion.moviedetailapi.bean;

import androidx.annotation.Keep;
import com.transsion.bean.GameInfoType;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata
public final class SubjectGameInfo implements Serializable {
    private String itemId;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public SubjectGameInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public SubjectGameInfo(String str, String str2) {
        this.itemId = str;
        this.type = str2;
    }

    public /* synthetic */ SubjectGameInfo(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ SubjectGameInfo copy$default(SubjectGameInfo subjectGameInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subjectGameInfo.itemId;
        }
        if ((i11 & 2) != 0) {
            str2 = subjectGameInfo.type;
        }
        return subjectGameInfo.copy(str, str2);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.type;
    }

    public final SubjectGameInfo copy(String str, String str2) {
        return new SubjectGameInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubjectGameInfo)) {
            return false;
        }
        SubjectGameInfo subjectGameInfo = (SubjectGameInfo) obj;
        return Intrinsics.b(this.itemId, subjectGameInfo.itemId) && Intrinsics.b(this.type, subjectGameInfo.type);
    }

    public final GameInfoType getGameInfoType() {
        String str = this.type;
        if (str == null || str.length() == 0) {
            return null;
        }
        String str2 = this.type;
        GameInfoType gameInfoType = GameInfoType.AHA;
        if (!Intrinsics.b(str2, gameInfoType.getValue())) {
            String str3 = this.type;
            gameInfoType = GameInfoType.PS;
            if (!Intrinsics.b(str3, gameInfoType.getValue())) {
                return null;
            }
        }
        return gameInfoType;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.itemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "SubjectGameInfo(itemId=" + this.itemId + ", type=" + this.type + ")";
    }
}
