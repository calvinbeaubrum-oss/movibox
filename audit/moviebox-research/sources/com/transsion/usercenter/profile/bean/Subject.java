package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Keep
@Metadata
public final class Subject implements Serializable {
    private int haveSeenCount;
    private List<CoverUrl> wantSubjects;
    private int wantToSeeCount;

    public Subject(int i11, int i12, List<CoverUrl> list) {
        this.wantToSeeCount = i11;
        this.haveSeenCount = i12;
        this.wantSubjects = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Subject copy$default(Subject subject, int i11, int i12, List list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = subject.wantToSeeCount;
        }
        if ((i13 & 2) != 0) {
            i12 = subject.haveSeenCount;
        }
        if ((i13 & 4) != 0) {
            list = subject.wantSubjects;
        }
        return subject.copy(i11, i12, list);
    }

    public final int component1() {
        return this.wantToSeeCount;
    }

    public final int component2() {
        return this.haveSeenCount;
    }

    public final List<CoverUrl> component3() {
        return this.wantSubjects;
    }

    public final Subject copy(int i11, int i12, List<CoverUrl> list) {
        return new Subject(i11, i12, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Subject)) {
            return false;
        }
        Subject subject = (Subject) obj;
        return this.wantToSeeCount == subject.wantToSeeCount && this.haveSeenCount == subject.haveSeenCount && Intrinsics.b(this.wantSubjects, subject.wantSubjects);
    }

    public final int getHaveSeenCount() {
        return this.haveSeenCount;
    }

    public final List<CoverUrl> getWantSubjects() {
        return this.wantSubjects;
    }

    public final int getWantToSeeCount() {
        return this.wantToSeeCount;
    }

    public int hashCode() {
        int i11 = ((this.wantToSeeCount * 31) + this.haveSeenCount) * 31;
        List<CoverUrl> list = this.wantSubjects;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public final void setHaveSeenCount(int i11) {
        this.haveSeenCount = i11;
    }

    public final void setWantSubjects(List<CoverUrl> list) {
        this.wantSubjects = list;
    }

    public final void setWantToSeeCount(int i11) {
        this.wantToSeeCount = i11;
    }

    public String toString() {
        return "Subject(wantToSeeCount=" + this.wantToSeeCount + ", haveSeenCount=" + this.haveSeenCount + ", wantSubjects=" + this.wantSubjects + ")";
    }
}
