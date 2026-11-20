package com.transsion.videodetail.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
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
public final class ExtCaption implements Serializable {
    private final int delay;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f59895id;
    private final String lan;
    private final String lanName;
    private final String size;
    private final String url;

    public ExtCaption(String id2, String lan, String lanName, String url, String size, int i11) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(lan, "lan");
        Intrinsics.g(lanName, "lanName");
        Intrinsics.g(url, "url");
        Intrinsics.g(size, "size");
        this.f59895id = id2;
        this.lan = lan;
        this.lanName = lanName;
        this.url = url;
        this.size = size;
        this.delay = i11;
    }

    public static /* synthetic */ ExtCaption copy$default(ExtCaption extCaption, String str, String str2, String str3, String str4, String str5, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = extCaption.f59895id;
        }
        if ((i12 & 2) != 0) {
            str2 = extCaption.lan;
        }
        String str6 = str2;
        if ((i12 & 4) != 0) {
            str3 = extCaption.lanName;
        }
        String str7 = str3;
        if ((i12 & 8) != 0) {
            str4 = extCaption.url;
        }
        String str8 = str4;
        if ((i12 & 16) != 0) {
            str5 = extCaption.size;
        }
        String str9 = str5;
        if ((i12 & 32) != 0) {
            i11 = extCaption.delay;
        }
        return extCaption.copy(str, str6, str7, str8, str9, i11);
    }

    public final String component1() {
        return this.f59895id;
    }

    public final String component2() {
        return this.lan;
    }

    public final String component3() {
        return this.lanName;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.size;
    }

    public final int component6() {
        return this.delay;
    }

    public final ExtCaption copy(String id2, String lan, String lanName, String url, String size, int i11) {
        Intrinsics.g(id2, "id");
        Intrinsics.g(lan, "lan");
        Intrinsics.g(lanName, "lanName");
        Intrinsics.g(url, "url");
        Intrinsics.g(size, "size");
        return new ExtCaption(id2, lan, lanName, url, size, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtCaption)) {
            return false;
        }
        ExtCaption extCaption = (ExtCaption) obj;
        return Intrinsics.b(this.f59895id, extCaption.f59895id) && Intrinsics.b(this.lan, extCaption.lan) && Intrinsics.b(this.lanName, extCaption.lanName) && Intrinsics.b(this.url, extCaption.url) && Intrinsics.b(this.size, extCaption.size) && this.delay == extCaption.delay;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final String getId() {
        return this.f59895id;
    }

    public final String getLan() {
        return this.lan;
    }

    public final String getLanName() {
        return this.lanName;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((this.f59895id.hashCode() * 31) + this.lan.hashCode()) * 31) + this.lanName.hashCode()) * 31) + this.url.hashCode()) * 31) + this.size.hashCode()) * 31) + this.delay;
    }

    public String toString() {
        return "ExtCaption(id=" + this.f59895id + ", lan=" + this.lan + ", lanName=" + this.lanName + ", url=" + this.url + ", size=" + this.size + ", delay=" + this.delay + ")";
    }
}
