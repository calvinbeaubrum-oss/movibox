package com.transsion.baseui.image;

import android.content.Context;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.utils.g;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.net.CronetEngine;

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
@GlideModule
@Metadata
public final class CustomGlideModule extends AppGlideModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestOptions f51370a = new RequestOptions();

    public final boolean a() {
        try {
            new CronetEngine.Builder(Utils.a()).build().shutdown();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder builder) {
        Intrinsics.g(context, "context");
        Intrinsics.g(builder, "builder");
        if (g.f51315a.a()) {
            builder.setDefaultRequestOptions(this.f51370a.format(DecodeFormat.PREFER_RGB_565));
        }
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Intrinsics.g(context, "context");
        Intrinsics.g(glide, "glide");
        Intrinsics.g(registry, "registry");
        if (a()) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "CustomGlideModule", "glide cronet disabled,use okhttp", false, 4, null);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(NetServiceGenerator.f49399d.a().j()));
    }
}
