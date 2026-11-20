package com.transsion.home.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class HotSubjectEntity implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<HotSubjectEntity> CREATOR = new a();
    private List<HotSearchKeyWord> everyoneSearch;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a implements Parcelable.Creator<HotSubjectEntity> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HotSubjectEntity createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    arrayList2.add(HotSearchKeyWord.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new HotSubjectEntity(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HotSubjectEntity[] newArray(int i11) {
            return new HotSubjectEntity[i11];
        }
    }

    public HotSubjectEntity(List<HotSearchKeyWord> list) {
        this.everyoneSearch = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HotSubjectEntity copy$default(HotSubjectEntity hotSubjectEntity, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = hotSubjectEntity.everyoneSearch;
        }
        return hotSubjectEntity.copy(list);
    }

    public final List<HotSearchKeyWord> component1() {
        return this.everyoneSearch;
    }

    public final HotSubjectEntity copy(List<HotSearchKeyWord> list) {
        return new HotSubjectEntity(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HotSubjectEntity) && Intrinsics.b(this.everyoneSearch, ((HotSubjectEntity) obj).everyoneSearch);
    }

    public final List<HotSearchKeyWord> getEveryoneSearch() {
        return this.everyoneSearch;
    }

    public int hashCode() {
        List<HotSearchKeyWord> list = this.everyoneSearch;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setEveryoneSearch(List<HotSearchKeyWord> list) {
        this.everyoneSearch = list;
    }

    public String toString() {
        return "HotSubjectEntity(everyoneSearch=" + this.everyoneSearch + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        List<HotSearchKeyWord> list = this.everyoneSearch;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<HotSearchKeyWord> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
