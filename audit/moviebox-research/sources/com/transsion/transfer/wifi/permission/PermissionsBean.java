package com.transsion.transfer.wifi.permission;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.transfer.wifi.bean.PermissionState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionsBean implements Parcelable {
    public static final int ITEM_TYPE_PERMISSION = 0;
    private String btnName;
    private String content;
    private int icon;
    private int itemType;
    private String permission;
    private PermissionState state;
    private String title;
    public static final a Companion = new a(null);
    public static final Parcelable.Creator<PermissionsBean> CREATOR = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements Parcelable.Creator<PermissionsBean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PermissionsBean createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PermissionsBean(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), PermissionState.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PermissionsBean[] newArray(int i11) {
            return new PermissionsBean[i11];
        }
    }

    public PermissionsBean(int i11, int i12, String str, String str2, PermissionState state, String permission, String btnName) {
        Intrinsics.g(state, "state");
        Intrinsics.g(permission, "permission");
        Intrinsics.g(btnName, "btnName");
        this.itemType = i11;
        this.icon = i12;
        this.title = str;
        this.content = str2;
        this.state = state;
        this.permission = permission;
        this.btnName = btnName;
    }

    public /* synthetic */ PermissionsBean(int i11, int i12, String str, String str2, PermissionState permissionState, String str3, String str4, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? null : str, (i13 & 8) != 0 ? null : str2, permissionState, str3, str4);
    }

    public static /* synthetic */ PermissionsBean copy$default(PermissionsBean permissionsBean, int i11, int i12, String str, String str2, PermissionState permissionState, String str3, String str4, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = permissionsBean.itemType;
        }
        if ((i13 & 2) != 0) {
            i12 = permissionsBean.icon;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            str = permissionsBean.title;
        }
        String str5 = str;
        if ((i13 & 8) != 0) {
            str2 = permissionsBean.content;
        }
        String str6 = str2;
        if ((i13 & 16) != 0) {
            permissionState = permissionsBean.state;
        }
        PermissionState permissionState2 = permissionState;
        if ((i13 & 32) != 0) {
            str3 = permissionsBean.permission;
        }
        String str7 = str3;
        if ((i13 & 64) != 0) {
            str4 = permissionsBean.btnName;
        }
        return permissionsBean.copy(i11, i14, str5, str6, permissionState2, str7, str4);
    }

    public final int component1() {
        return this.itemType;
    }

    public final int component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.content;
    }

    public final PermissionState component5() {
        return this.state;
    }

    public final String component6() {
        return this.permission;
    }

    public final String component7() {
        return this.btnName;
    }

    public final PermissionsBean copy(int i11, int i12, String str, String str2, PermissionState state, String permission, String btnName) {
        Intrinsics.g(state, "state");
        Intrinsics.g(permission, "permission");
        Intrinsics.g(btnName, "btnName");
        return new PermissionsBean(i11, i12, str, str2, state, permission, btnName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionsBean)) {
            return false;
        }
        PermissionsBean permissionsBean = (PermissionsBean) obj;
        return this.itemType == permissionsBean.itemType && this.icon == permissionsBean.icon && Intrinsics.b(this.title, permissionsBean.title) && Intrinsics.b(this.content, permissionsBean.content) && this.state == permissionsBean.state && Intrinsics.b(this.permission, permissionsBean.permission) && Intrinsics.b(this.btnName, permissionsBean.btnName);
    }

    public final String getBtnName() {
        return this.btnName;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final PermissionState getState() {
        return this.state;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i11 = ((this.itemType * 31) + this.icon) * 31;
        String str = this.title;
        int iHashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.content;
        return ((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.state.hashCode()) * 31) + this.permission.hashCode()) * 31) + this.btnName.hashCode();
    }

    public final void setBtnName(String str) {
        Intrinsics.g(str, "<set-?>");
        this.btnName = str;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setIcon(int i11) {
        this.icon = i11;
    }

    public final void setItemType(int i11) {
        this.itemType = i11;
    }

    public final void setPermission(String str) {
        Intrinsics.g(str, "<set-?>");
        this.permission = str;
    }

    public final void setState(PermissionState permissionState) {
        Intrinsics.g(permissionState, "<set-?>");
        this.state = permissionState;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "PermissionsBean(itemType=" + this.itemType + ", icon=" + this.icon + ", title=" + this.title + ", content=" + this.content + ", state=" + this.state + ", permission=" + this.permission + ", btnName=" + this.btnName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeInt(this.itemType);
        out.writeInt(this.icon);
        out.writeString(this.title);
        out.writeString(this.content);
        out.writeString(this.state.name());
        out.writeString(this.permission);
        out.writeString(this.btnName);
    }
}
