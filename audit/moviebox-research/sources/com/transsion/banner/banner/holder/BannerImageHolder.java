package com.transsion.banner.banner.holder;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.banner.R$id;
import com.transsnet.downloader.widget.DownloadView;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BannerImageHolder extends MultiBannerHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatImageView f51002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatTextView f51003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadView f51004d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f51005f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerImageHolder(View itemView) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        this.f51002b = (AppCompatImageView) itemView.findViewById(R$id.image);
        this.f51003c = (AppCompatTextView) itemView.findViewById(R$id.title);
        this.f51004d = (DownloadView) itemView.findViewById(R$id.download);
        this.f51005f = itemView.findViewById(R$id.shadow);
    }

    public final AppCompatImageView e() {
        return this.f51002b;
    }
}
