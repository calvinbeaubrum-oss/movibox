package com.cloud.tmc.miniapp;

import android.os.Bundle;
import com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class DynamicChangeUrlImpl implements IChangeUrlProxy {
    @Override // com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy
    public Object getConfigValue(Bundle bundle, String key) {
        Intrinsics.g(key, "key");
        if (bundle != null) {
            return bundle.get(key);
        }
        return null;
    }
}
