package com.bumptech.glide.integration.cronet;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.google.common.base.q;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class CronetGlideModule implements GlideModule {
    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(final Context context, Glide glide, Registry registry) {
        CronetRequestFactoryImpl cronetRequestFactoryImpl = new CronetRequestFactoryImpl(new q<CronetEngine>() { // from class: com.bumptech.glide.integration.cronet.CronetGlideModule.1
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
