package com.bykv.vk.openvk.preload.falconx.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.e.b;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements ILoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f25673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f25674b = new AtomicBoolean(false);

    public a(Context context, String str, File file) {
        if (context == null) {
            throw new RuntimeException("context == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file == null) {
            throw new RuntimeException("resRootDir == null");
        }
        this.f25673a = new b(context, str, file);
    }

    public final int a(String str) throws Exception {
        if (this.f25674b.get()) {
            throw new RuntimeException("released!");
        }
        return this.f25673a.b(str);
    }

    @Override // com.bykv.vk.openvk.preload.falconx.loader.ILoader
    public final boolean exist(String str) throws Exception {
        if (this.f25674b.get()) {
            throw new RuntimeException("released!");
        }
        return this.f25673a.c(str);
    }

    @Override // com.bykv.vk.openvk.preload.falconx.loader.ILoader
    public final Map<String, Long> getChannelVersion() {
        return this.f25673a.b();
    }

    @Override // com.bykv.vk.openvk.preload.falconx.loader.ILoader
    public final InputStream getInputStream(String str) throws Exception {
        if (this.f25674b.get()) {
            throw new RuntimeException("released!");
        }
        GeckoLogger.d("WebOffline-falcon", "GeckoResLoader ready to load, file:", str);
        return this.f25673a.a(str);
    }

    @Override // com.bykv.vk.openvk.preload.falconx.loader.ILoader
    public final String getResRootDir() {
        return this.f25673a.a();
    }

    @Override // com.bykv.vk.openvk.preload.falconx.loader.ILoader
    public final void release() throws Exception {
        if (this.f25674b.getAndSet(true)) {
            return;
        }
        this.f25673a.c();
    }
}
