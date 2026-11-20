package com.cloud.hisavana.sdk.common;

import androidx.core.content.FileProvider;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class HisavanaFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        z.a().d("HisavanaFileProvider", "onCreate");
        return super.onCreate();
    }
}
