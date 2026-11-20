package com.bytedance.sdk.openadsdk.core.act;

import android.content.ComponentName;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ActServiceConnection extends f {
    private pFF mConnectionCallback;

    public ActServiceConnection(pFF pff) {
        this.mConnectionCallback = pff;
    }

    @Override // androidx.browser.customtabs.f
    public void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient) {
        pFF pff = this.mConnectionCallback;
        if (pff != null) {
            pff.sc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        pFF pff = this.mConnectionCallback;
        if (pff != null) {
            pff.sc();
        }
    }
}
