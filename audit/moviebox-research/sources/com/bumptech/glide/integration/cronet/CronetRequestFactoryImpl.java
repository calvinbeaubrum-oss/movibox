package com.bumptech.glide.integration.cronet;

import com.google.common.base.q;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CronetRequestFactoryImpl implements CronetRequestFactory {
    private final q<CronetEngine> cronetEngineGetter;

    public CronetRequestFactoryImpl(q<CronetEngine> qVar) {
        this.cronetEngineGetter = qVar;
    }

    @Override // com.bumptech.glide.integration.cronet.CronetRequestFactory
    public UrlRequest.Builder newRequest(String str, int i11, Map<String, String> map, UrlRequest.Callback callback) {
        UrlRequest.Builder builderNewUrlRequestBuilder = this.cronetEngineGetter.get().newUrlRequestBuilder(str, callback, new Executor() { // from class: com.bumptech.glide.integration.cronet.CronetRequestFactoryImpl.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        builderNewUrlRequestBuilder.allowDirectExecutor();
        builderNewUrlRequestBuilder.setPriority(i11);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!"Accept-Encoding".equalsIgnoreCase(key) && !"User-Agent".equalsIgnoreCase(key)) {
                builderNewUrlRequestBuilder.addHeader(key, entry.getValue());
            }
        }
        return builderNewUrlRequestBuilder;
    }
}
