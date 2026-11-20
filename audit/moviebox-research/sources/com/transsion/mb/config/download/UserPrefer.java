package com.transsion.mb.config.download;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UserPrefer implements Parcelable {
    public static final Parcelable.Creator<UserPrefer> CREATOR = new a();
    private final int days;
    private final List<UserPreferOption> options;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<UserPrefer> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserPrefer createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.g(parcel, "parcel");
            int i11 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i12 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i12);
                for (int i13 = 0; i13 != i12; i13++) {
                    arrayList2.add(UserPreferOption.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new UserPrefer(i11, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UserPrefer[] newArray(int i11) {
            return new UserPrefer[i11];
        }
    }

    public UserPrefer(int i11, List<UserPreferOption> list) {
        this.days = i11;
        this.options = list;
    }

    public /* synthetic */ UserPrefer(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserPrefer copy$default(UserPrefer userPrefer, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = userPrefer.days;
        }
        if ((i12 & 2) != 0) {
            list = userPrefer.options;
        }
        return userPrefer.copy(i11, list);
    }

    public final int component1() {
        return this.days;
    }

    public final List<UserPreferOption> component2() {
        return this.options;
    }

    public final UserPrefer copy(int i11, List<UserPreferOption> list) {
        return new UserPrefer(i11, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserPrefer)) {
            return false;
        }
        UserPrefer userPrefer = (UserPrefer) obj;
        return this.days == userPrefer.days && Intrinsics.b(this.options, userPrefer.options);
    }

    public final int getDays() {
        return this.days;
    }

    public final List<UserPreferOption> getOptions() {
        return this.options;
    }

    public int hashCode() {
        int i11 = this.days * 31;
        List<UserPreferOption> list = this.options;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "UserPrefer(days=" + this.days + ", options=" + this.options + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.days);
        List<UserPreferOption> list = this.options;
        if (list == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(list.size());
        Iterator<UserPreferOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(out, i11);
        }
    }
}
