package com.transsion.user.action.sync.event;

import androidx.annotation.Keep;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class CommentEvent implements Serializable {
    private final String commentsId;
    private final String commentsNum;
    private final boolean status;
    private final String subjectId;

    public CommentEvent(boolean z11, String commentsId, String commentsNum, String str) {
        Intrinsics.g(commentsId, "commentsId");
        Intrinsics.g(commentsNum, "commentsNum");
        this.status = z11;
        this.commentsId = commentsId;
        this.commentsNum = commentsNum;
        this.subjectId = str;
    }

    public /* synthetic */ CommentEvent(boolean z11, String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, str, str2, (i11 & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ CommentEvent copy$default(CommentEvent commentEvent, boolean z11, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = commentEvent.status;
        }
        if ((i11 & 2) != 0) {
            str = commentEvent.commentsId;
        }
        if ((i11 & 4) != 0) {
            str2 = commentEvent.commentsNum;
        }
        if ((i11 & 8) != 0) {
            str3 = commentEvent.subjectId;
        }
        return commentEvent.copy(z11, str, str2, str3);
    }

    public final boolean component1() {
        return this.status;
    }

    public final String component2() {
        return this.commentsId;
    }

    public final String component3() {
        return this.commentsNum;
    }

    public final String component4() {
        return this.subjectId;
    }

    public final CommentEvent copy(boolean z11, String commentsId, String commentsNum, String str) {
        Intrinsics.g(commentsId, "commentsId");
        Intrinsics.g(commentsNum, "commentsNum");
        return new CommentEvent(z11, commentsId, commentsNum, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentEvent)) {
            return false;
        }
        CommentEvent commentEvent = (CommentEvent) obj;
        return this.status == commentEvent.status && Intrinsics.b(this.commentsId, commentEvent.commentsId) && Intrinsics.b(this.commentsNum, commentEvent.commentsNum) && Intrinsics.b(this.subjectId, commentEvent.subjectId);
    }

    public final String getCommentsId() {
        return this.commentsId;
    }

    public final String getCommentsNum() {
        return this.commentsNum;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z11 = this.status;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iHashCode = ((((r11 * 31) + this.commentsId.hashCode()) * 31) + this.commentsNum.hashCode()) * 31;
        String str = this.subjectId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CommentEvent(status=" + this.status + ", commentsId=" + this.commentsId + ", commentsNum=" + this.commentsNum + ", subjectId=" + this.subjectId + ")";
    }
}
