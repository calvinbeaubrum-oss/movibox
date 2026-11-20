package com.bumptech.glide.integration.cronet;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.google.common.base.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@GlideModule
public final class CronetLibraryGlideModule extends LibraryGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@NonNull final Context context, @NonNull Glide glide, @NonNull Registry registry) {
        CronetRequestFactoryImpl cronetRequestFactoryImpl = new CronetRequestFactoryImpl(new q<CronetEngine>() { // from class: com.bumptech.glide.integration.cronet.CronetLibraryGlideModule.1
            @Override // com.google.common.base.q
            /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
            public CronetEngine get2() {
                return CronetEngineSingleton.getSingleton(context);
            }
        });
        registry.replace(GlideUrl.class, InputStream.class, new ChromiumUrlLoader.StreamFactory(cronetRequestFactoryImpl, null));
        registry.prepend(GlideUrl.class, ByteBuffer.class, new ChromiumUrlLoader.ByteBufferFactory(cronetRequestFactoryImpl, null));
    }
}
