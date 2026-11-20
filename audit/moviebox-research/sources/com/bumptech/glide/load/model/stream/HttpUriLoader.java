package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HttpUriLoader extends UrlUriLoader<InputStream> {

    /* JADX INFO: compiled from: source.java */
    @Deprecated
    public static class Factory extends UrlUriLoader.StreamFactory {
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(modelLoader);
    }
}
