package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
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
public enum MemberSource implements Parcelable {
    SOURCE_HDDL("HDDL"),
    SOURCE_MULTI_DL("Multi_DL_DIALOG"),
    SOURCE_AD_DIALOG("AD_DIALOG"),
    SOURCE_DOWNLOAD_DIALOG("DOWNLOAD_DIALOG"),
    SOURCE_LANDSCAPE_PLAY("LANDSCAPE_PLAY"),
    SOURCE_OTHER_DOWNLOAD_DIALOG("OTHER_DOWNLOAD_DIALOG");

    private final String value;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<MemberSource> CREATOR = new Parcelable.Creator<MemberSource>() { // from class: com.transsion.memberapi.MemberSource.b
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemberSource createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return MemberSource.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemberSource[] newArray(int i11) {
            return new MemberSource[i11];
        }
    };

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final MemberSource a(String value) {
            Intrinsics.g(value, "value");
            switch (value.hashCode()) {
                case -440595233:
                    if (value.equals("DOWNLOAD_DIALOG")) {
                        return MemberSource.SOURCE_DOWNLOAD_DIALOG;
                    }
                    break;
                case -420306344:
                    if (value.equals("LANDSCAPE_PLAY")) {
                        return MemberSource.SOURCE_LANDSCAPE_PLAY;
                    }
                    break;
                case 2212484:
                    if (value.equals("HDDL")) {
                        return MemberSource.SOURCE_HDDL;
                    }
                    break;
                case 684919184:
                    if (value.equals("OTHER_DOWNLOAD_DIALOG")) {
                        return MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG;
                    }
                    break;
                case 1456277732:
                    if (value.equals("AD_DIALOG")) {
                        return MemberSource.SOURCE_AD_DIALOG;
                    }
                    break;
                case 1758712121:
                    if (value.equals("Multi_DL_DIALOG")) {
                        return MemberSource.SOURCE_MULTI_DL;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        }
    }

    MemberSource(String str) {
        this.value = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(name());
    }
}
