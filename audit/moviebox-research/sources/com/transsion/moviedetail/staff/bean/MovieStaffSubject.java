package com.transsion.moviedetail.staff.bean;

import com.transsion.moviedetailapi.bean.Subject;
import e9.a;
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
@Metadata
public final class MovieStaffSubject extends Subject implements a {
    private final int itemType;

    public MovieStaffSubject() {
        this(0, 1, null);
    }

    public MovieStaffSubject(int i11) {
        super(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -1, 4194303, null);
        this.itemType = i11;
    }

    public /* synthetic */ MovieStaffSubject(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 1 : i11);
    }

    public static /* synthetic */ MovieStaffSubject copy$default(MovieStaffSubject movieStaffSubject, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = movieStaffSubject.getItemType();
        }
        return movieStaffSubject.copy(i11);
    }

    public final int component1() {
        return getItemType();
    }

    public final MovieStaffSubject copy(int i11) {
        return new MovieStaffSubject(i11);
    }

    public boolean equals(Object obj) {
        String subjectId;
        return (obj instanceof MovieStaffSubject) && Intrinsics.b(((MovieStaffSubject) obj).getSubjectId(), getSubjectId()) && (subjectId = getSubjectId()) != null && subjectId.length() != 0;
    }

    @Override // e9.a
    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        String subjectId = getSubjectId();
        return subjectId != null ? subjectId.hashCode() : super.hashCode();
    }

    public String toString() {
        return "MovieStaffSubject(itemType=" + getItemType() + ")";
    }
}
