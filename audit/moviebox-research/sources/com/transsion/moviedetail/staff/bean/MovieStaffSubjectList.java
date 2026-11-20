package com.transsion.moviedetail.staff.bean;

import com.transsion.postdetail.bean.Pager;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MovieStaffSubjectList implements Serializable {
    private List<MovieStaffSubject> items;
    private Pager pager;

    public MovieStaffSubjectList(List<MovieStaffSubject> list, Pager pager) {
        this.items = list;
        this.pager = pager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MovieStaffSubjectList copy$default(MovieStaffSubjectList movieStaffSubjectList, List list, Pager pager, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = movieStaffSubjectList.items;
        }
        if ((i11 & 2) != 0) {
            pager = movieStaffSubjectList.pager;
        }
        return movieStaffSubjectList.copy(list, pager);
    }

    public final List<MovieStaffSubject> component1() {
        return this.items;
    }

    public final Pager component2() {
        return this.pager;
    }

    public final MovieStaffSubjectList copy(List<MovieStaffSubject> list, Pager pager) {
        return new MovieStaffSubjectList(list, pager);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MovieStaffSubjectList)) {
            return false;
        }
        MovieStaffSubjectList movieStaffSubjectList = (MovieStaffSubjectList) obj;
        return Intrinsics.b(this.items, movieStaffSubjectList.items) && Intrinsics.b(this.pager, movieStaffSubjectList.pager);
    }

    public final List<MovieStaffSubject> getItems() {
        return this.items;
    }

    public final Pager getPager() {
        return this.pager;
    }

    public int hashCode() {
        List<MovieStaffSubject> list = this.items;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Pager pager = this.pager;
        return iHashCode + (pager != null ? pager.hashCode() : 0);
    }

    public final void setItems(List<MovieStaffSubject> list) {
        this.items = list;
    }

    public final void setPager(Pager pager) {
        this.pager = pager;
    }

    public String toString() {
        return "MovieStaffSubjectList(items=" + this.items + ", pager=" + this.pager + ")";
    }
}
