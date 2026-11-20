package com.transsion.payment.lib.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
@Keep
@Metadata
public final class CreateOrderReq implements Parcelable {
    public static final Parcelable.Creator<CreateOrderReq> CREATOR = new a();
    private String cpFrontPage;
    private String productId;
    private boolean subscriptOrder;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<CreateOrderReq> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CreateOrderReq createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new CreateOrderReq(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CreateOrderReq[] newArray(int i11) {
            return new CreateOrderReq[i11];
        }
    }

    public CreateOrderReq(String productId, String str, boolean z11) {
        Intrinsics.g(productId, "productId");
        this.productId = productId;
        this.cpFrontPage = str;
        this.subscriptOrder = z11;
    }

    public /* synthetic */ CreateOrderReq(String str, String str2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? false : z11);
    }

    public static /* synthetic */ CreateOrderReq copy$default(CreateOrderReq createOrderReq, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = createOrderReq.productId;
        }
        if ((i11 & 2) != 0) {
            str2 = createOrderReq.cpFrontPage;
        }
        if ((i11 & 4) != 0) {
            z11 = createOrderReq.subscriptOrder;
        }
        return createOrderReq.copy(str, str2, z11);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.cpFrontPage;
    }

    public final boolean component3() {
        return this.subscriptOrder;
    }

    public final CreateOrderReq copy(String productId, String str, boolean z11) {
        Intrinsics.g(productId, "productId");
        return new CreateOrderReq(productId, str, z11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateOrderReq)) {
            return false;
        }
        CreateOrderReq createOrderReq = (CreateOrderReq) obj;
        return Intrinsics.b(this.productId, createOrderReq.productId) && Intrinsics.b(this.cpFrontPage, createOrderReq.cpFrontPage) && this.subscriptOrder == createOrderReq.subscriptOrder;
    }

    public final String getCpFrontPage() {
        return this.cpFrontPage;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final boolean getSubscriptOrder() {
        return this.subscriptOrder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.productId.hashCode() * 31;
        String str = this.cpFrontPage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z11 = this.subscriptOrder;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode2 + r11;
    }

    public final void setCpFrontPage(String str) {
        this.cpFrontPage = str;
    }

    public final void setProductId(String str) {
        Intrinsics.g(str, "<set-?>");
        this.productId = str;
    }

    public final void setSubscriptOrder(boolean z11) {
        this.subscriptOrder = z11;
    }

    public String toString() {
        return "CreateOrderReq(productId=" + this.productId + ", cpFrontPage=" + this.cpFrontPage + ", subscriptOrder=" + this.subscriptOrder + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i11) {
        Intrinsics.g(out, "out");
        out.writeString(this.productId);
        out.writeString(this.cpFrontPage);
        out.writeInt(this.subscriptOrder ? 1 : 0);
    }
}
