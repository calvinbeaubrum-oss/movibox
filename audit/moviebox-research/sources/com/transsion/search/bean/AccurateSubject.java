package com.transsion.search.bean;

import com.google.gson.annotations.SerializedName;
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
@Metadata
public final class AccurateSubject implements Serializable {

    @SerializedName("seasons")
    private final List<Season> seasons;

    @SerializedName("subject")
    private final SearchSubject subject;

    public AccurateSubject(SearchSubject searchSubject, List<Season> list) {
        this.subject = searchSubject;
        this.seasons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccurateSubject copy$default(AccurateSubject accurateSubject, SearchSubject searchSubject, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            searchSubject = accurateSubject.subject;
        }
        if ((i11 & 2) != 0) {
            list = accurateSubject.seasons;
        }
        return accurateSubject.copy(searchSubject, list);
    }

    public final SearchSubject component1() {
        return this.subject;
    }

    public final List<Season> component2() {
        return this.seasons;
    }

    public final AccurateSubject copy(SearchSubject searchSubject, List<Season> list) {
        return new AccurateSubject(searchSubject, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccurateSubject)) {
            return false;
        }
        AccurateSubject accurateSubject = (AccurateSubject) obj;
        return Intrinsics.b(this.subject, accurateSubject.subject) && Intrinsics.b(this.seasons, accurateSubject.seasons);
    }

    public final List<Season> getSeasons() {
        return this.seasons;
    }

    public final SearchSubject getSubject() {
        return this.subject;
    }

    public int hashCode() {
        SearchSubject searchSubject = this.subject;
        int iHashCode = (searchSubject == null ? 0 : searchSubject.hashCode()) * 31;
        List<Season> list = this.seasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AccurateSubject(subject=" + this.subject + ", seasons=" + this.seasons + ")";
    }
}
