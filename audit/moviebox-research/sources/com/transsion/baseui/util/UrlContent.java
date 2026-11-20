package com.transsion.baseui.util;

import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UrlContent implements Serializable {
    public static final int $stable = 8;
    private ClickableSpan clickableSpan;
    private ImageSpan iconSpan;
    private int indexOfUrl;
    private String originUrl;
    private String url;

    public UrlContent(ClickableSpan clickableSpan, ImageSpan imageSpan, String originUrl, String url, int i11) {
        Intrinsics.g(clickableSpan, "clickableSpan");
        Intrinsics.g(originUrl, "originUrl");
        Intrinsics.g(url, "url");
        this.clickableSpan = clickableSpan;
        this.iconSpan = imageSpan;
        this.originUrl = originUrl;
        this.url = url;
        this.indexOfUrl = i11;
    }

    public static /* synthetic */ UrlContent copy$default(UrlContent urlContent, ClickableSpan clickableSpan, ImageSpan imageSpan, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            clickableSpan = urlContent.clickableSpan;
        }
        if ((i12 & 2) != 0) {
            imageSpan = urlContent.iconSpan;
        }
        ImageSpan imageSpan2 = imageSpan;
        if ((i12 & 4) != 0) {
            str = urlContent.originUrl;
        }
        String str3 = str;
        if ((i12 & 8) != 0) {
            str2 = urlContent.url;
        }
        String str4 = str2;
        if ((i12 & 16) != 0) {
            i11 = urlContent.indexOfUrl;
        }
        return urlContent.copy(clickableSpan, imageSpan2, str3, str4, i11);
    }

    public final ClickableSpan component1() {
        return this.clickableSpan;
    }

    public final ImageSpan component2() {
        return this.iconSpan;
    }

    public final String component3() {
        return this.originUrl;
    }

    public final String component4() {
        return this.url;
    }

    public final int component5() {
        return this.indexOfUrl;
    }

    public final UrlContent copy(ClickableSpan clickableSpan, ImageSpan imageSpan, String originUrl, String url, int i11) {
        Intrinsics.g(clickableSpan, "clickableSpan");
        Intrinsics.g(originUrl, "originUrl");
        Intrinsics.g(url, "url");
        return new UrlContent(clickableSpan, imageSpan, originUrl, url, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UrlContent)) {
            return false;
        }
        UrlContent urlContent = (UrlContent) obj;
        return Intrinsics.b(this.clickableSpan, urlContent.clickableSpan) && Intrinsics.b(this.iconSpan, urlContent.iconSpan) && Intrinsics.b(this.originUrl, urlContent.originUrl) && Intrinsics.b(this.url, urlContent.url) && this.indexOfUrl == urlContent.indexOfUrl;
    }

    public final ClickableSpan getClickableSpan() {
        return this.clickableSpan;
    }

    public final ImageSpan getIconSpan() {
        return this.iconSpan;
    }

    public final int getIndexOfUrl() {
        return this.indexOfUrl;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = this.clickableSpan.hashCode() * 31;
        ImageSpan imageSpan = this.iconSpan;
        return ((((((iHashCode + (imageSpan == null ? 0 : imageSpan.hashCode())) * 31) + this.originUrl.hashCode()) * 31) + this.url.hashCode()) * 31) + this.indexOfUrl;
    }

    public final void setClickableSpan(ClickableSpan clickableSpan) {
        Intrinsics.g(clickableSpan, "<set-?>");
        this.clickableSpan = clickableSpan;
    }

    public final void setIconSpan(ImageSpan imageSpan) {
        this.iconSpan = imageSpan;
    }

    public final void setIndexOfUrl(int i11) {
        this.indexOfUrl = i11;
    }

    public final void setOriginUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.originUrl = str;
    }

    public final void setUrl(String str) {
        Intrinsics.g(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "UrlContent(clickableSpan=" + this.clickableSpan + ", iconSpan=" + this.iconSpan + ", originUrl=" + this.originUrl + ", url=" + this.url + ", indexOfUrl=" + this.indexOfUrl + ")";
    }
}
