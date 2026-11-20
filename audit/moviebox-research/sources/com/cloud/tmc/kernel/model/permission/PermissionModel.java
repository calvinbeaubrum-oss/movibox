package com.cloud.tmc.kernel.model.permission;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rc.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PermissionModel extends b implements Serializable, Parcelable {
    public static final a CREATOR = new a(null);
    private ArrayList<String> api;
    private String group;
    private ArrayList<String> hosts;
    private Set<String> ignorePermissionCheck;
    private final JsonObject nativeApiScopeConfig;
    private final JsonObject nativeApiUserAuth;
    private ArrayList<String> scopes;
    private ArrayList<ScopesV2Bean> scopesV2;
    private JsonObject specialConfigs;
    private Set<String> validDomains;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Parcelable.Creator<PermissionModel> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionModel createFromParcel(Parcel parcel) {
            Intrinsics.g(parcel, "parcel");
            return new PermissionModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PermissionModel[] newArray(int i11) {
            return new PermissionModel[i11];
        }
    }

    public PermissionModel() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PermissionModel(Parcel parcel) {
        this();
        Intrinsics.g(parcel, "parcel");
        this.group = parcel.readString();
        this.api = parcel.createStringArrayList();
        this.hosts = parcel.createStringArrayList();
        this.scopes = parcel.createStringArrayList();
        this.scopesV2 = parcel.createTypedArrayList(ScopesV2Bean.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final ArrayList<String> getApi() {
        return this.api;
    }

    public final String getGroup() {
        return this.group;
    }

    public final ArrayList<String> getHosts() {
        return this.hosts;
    }

    public final Set<String> getIgnorePermissionCheck() {
        return this.ignorePermissionCheck;
    }

    public final List<String> getJsapiList() {
        return this.scopes;
    }

    public final JsonObject getNativeApiScopeConfig() {
        return this.nativeApiScopeConfig;
    }

    public final JsonObject getNativeApiUserAuth() {
        return this.nativeApiUserAuth;
    }

    public final ArrayList<String> getScopes() {
        return this.scopes;
    }

    public final ArrayList<ScopesV2Bean> getScopesV2() {
        return this.scopesV2;
    }

    public final JsonObject getSpecialConfigs() {
        return this.specialConfigs;
    }

    public final Set<String> getValidDomains() {
        return this.validDomains;
    }

    public final void setApi(ArrayList<String> arrayList) {
        this.api = arrayList;
    }

    public final void setGroup(String str) {
        this.group = str;
    }

    public final void setHosts(ArrayList<String> arrayList) {
        this.hosts = arrayList;
    }

    public final void setIgnorePermissionCheck(Set<String> set) {
        this.ignorePermissionCheck = set;
    }

    public final void setScopes(ArrayList<String> arrayList) {
        this.scopes = arrayList;
    }

    public final void setScopesV2(ArrayList<ScopesV2Bean> arrayList) {
        this.scopesV2 = arrayList;
    }

    public final void setSpecialConfigs(JsonObject jsonObject) {
        this.specialConfigs = jsonObject;
    }

    public final void setValidDomains(Set<String> set) {
        this.validDomains = set;
    }

    public String toString() {
        return "PermissionModel(group=" + this.group + ", api=" + this.api + ", hosts=" + this.hosts + ", scopes=" + this.scopes + ", scopesV2=" + this.scopesV2 + ", nativeApiUserAuth=" + this.nativeApiUserAuth + ", nativeApiScopeConfig=" + this.nativeApiScopeConfig + ", ignorePermissionCheck=" + this.ignorePermissionCheck + ", specialConfigs=" + this.specialConfigs + ", validDomains=" + this.validDomains + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        Intrinsics.g(parcel, "parcel");
        parcel.writeString(this.group);
        parcel.writeStringList(this.api);
        parcel.writeStringList(this.hosts);
        parcel.writeStringList(this.scopes);
    }
}
