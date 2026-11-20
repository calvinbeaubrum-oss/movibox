package com.bytedance.sdk.openadsdk.SR.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class We implements pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile We f27144sc;

    private We() {
    }

    public static We sc() {
        if (f27144sc == null) {
            synchronized (We.class) {
                try {
                    if (f27144sc == null) {
                        f27144sc = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27144sc;
    }

    @Override // com.bytedance.sdk.openadsdk.SR.zY.pFF
    public void sc(com.bytedance.sdk.openadsdk.SR.pFF pff) {
    }

    @Override // com.bytedance.sdk.openadsdk.SR.zY.pFF
    public void sc(com.bytedance.sdk.openadsdk.SR.pFF pff, boolean z11) {
    }
}
