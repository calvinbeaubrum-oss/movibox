package com.aliyun.player.nativeclass;

import android.content.Context;
import com.aliyun.utils.NativeLoader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class JniListPlayerBase {
    private long mNativeContext = 0;

    static {
        NativeLoader.loadPlayer();
    }

    public JniListPlayerBase(Context context, long j11) {
        nConstruct(j11);
    }

    public static void loadClass() {
    }

    public void clear() {
        nClear();
    }

    public String getCurrentUid() {
        return nGetCurrentUid();
    }

    public int getMaxPreloadMemorySizeMB() {
        return nGetMaxPreloadMemorySizeMB();
    }

    public long getNativeListContext() {
        return this.mNativeContext;
    }

    public native void nClear();

    public native void nConstruct(long j11);

    public native String nGetCurrentUid();

    public native int nGetMaxPreloadMemorySizeMB();

    public native void nRelease();

    public native void nRemoveSource(String str);

    public native void nSetMaxPreloadMemorySizeMB(int i11);

    public native void nSetPreloadCount(int i11);

    public native void nStop();

    public void release() {
        nRelease();
    }

    public void removeSource(String str) {
        nRemoveSource(str);
    }

    public void setMaxPreloadMemorySizeMB(int i11) {
        nSetMaxPreloadMemorySizeMB(i11);
    }

    public void setNativeListContext(long j11) {
        this.mNativeContext = j11;
    }

    public void setPreloadCount(int i11) {
        nSetPreloadCount(i11);
    }

    public void stop() {
        nStop();
    }
}
