package com.transsion.publish.api;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.Serializable;
import kotlin.Metadata;

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
public final class PhotoEntity implements Serializable {
    private boolean enableSelect;
    private int height;
    private long imageSize;
    private String imageTitle;
    private boolean isAdd;
    private String localPath;
    private String thumbPath;
    private Uri uri;
    private Bitmap videoBitmap;
    private int width;

    public final boolean getEnableSelect() {
        return this.enableSelect;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getImageSize() {
        return this.imageSize;
    }

    public final String getImageTitle() {
        return this.imageTitle;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getThumbPath() {
        return this.thumbPath;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final Bitmap getVideoBitmap() {
        return this.videoBitmap;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAdd() {
        return this.isAdd;
    }

    public final void setAdd(boolean z11) {
        this.isAdd = z11;
    }

    public final void setEnableSelect(boolean z11) {
        this.enableSelect = z11;
    }

    public final void setHeight(int i11) {
        this.height = i11;
    }

    public final void setImageSize(long j11) {
        this.imageSize = j11;
    }

    public final void setImageTitle(String str) {
        this.imageTitle = str;
    }

    public final void setLocalPath(String str) {
        this.localPath = str;
    }

    public final void setThumbPath(String str) {
        this.thumbPath = str;
    }

    public final void setUri(Uri uri) {
        this.uri = uri;
    }

    public final void setVideoBitmap(Bitmap bitmap) {
        this.videoBitmap = bitmap;
    }

    public final void setWidth(int i11) {
        this.width = i11;
    }
}
