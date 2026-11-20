package com.bytedance.adsdk.ugeno.yoga;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class SR extends YogaNodeJNIBase {
    public void Tf() {
        long j11 = this.f26475sc;
        if (j11 != 0) {
            this.f26475sc = 0L;
            YogaNative.jni_YGNodeDeallocateJNI(j11);
        }
    }

    public void finalize() throws Throwable {
        try {
            Tf();
        } finally {
            super.finalize();
        }
    }
}
