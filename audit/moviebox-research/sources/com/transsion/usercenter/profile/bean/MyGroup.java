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
public final class MyGroup implements Serializable {
    private int count;
    private List<String> groups;

    public MyGroup(int i11, List<String> list) {
        this.count = i11;
        this.groups = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyGroup copy$default(MyGroup myGroup, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = myGroup.count;
        }
        if ((i12 & 2) != 0) {
            list = myGroup.groups;
        }
        return myGroup.copy(i11, list);
    }

    public final int component1() {
        return this.count;
    }

    public final List<String> component2() {
        return this.groups;
    }

    public final MyGroup copy(int i11, List<String> list) {
        return new MyGroup(i11, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyGroup)) {
            return false;
        }
        MyGroup myGroup = (MyGroup) obj;
        return this.count == myGroup.count && Intrinsics.b(this.groups, myGroup.groups);
    }

    public final int getCount() {
        return this.count;
    }

    public final List<String> getGroups() {
        return this.groups;
    }

    public int hashCode() {
        int i11 = this.count * 31;
        List<String> list = this.groups;
        return i11 + (list == null ? 0 : list.hashCode());
    }

    public final void setCount(int i11) {
        this.count = i11;
    }

    public final void setGroups(List<String> list) {
        this.groups = list;
    }

    public String toString() {
        return "MyGroup(count=" + this.count + ", groups=" + this.groups + ")";
    }
}
