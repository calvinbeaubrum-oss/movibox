package com.cloud.tmc.kernel.api.classloader;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class DefaultClassLoaderFactory implements ClassLoaderFactory {
    @Override // com.cloud.tmc.kernel.api.classloader.ClassLoaderFactory
    public ClassLoader getClassLoader(String str) {
        return DefaultClassLoaderFactory.class.getClassLoader();
    }
}
