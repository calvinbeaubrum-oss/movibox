package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;
import androidx.annotation.Keep;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Keep
public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 20;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;

    /* JADX INFO: renamed from: ih, reason: collision with root package name */
    int f25349ih;

    /* JADX INFO: renamed from: iw, reason: collision with root package name */
    int f25350iw;

    /* JADX INFO: renamed from: ix, reason: collision with root package name */
    int f25351ix;

    /* JADX INFO: renamed from: iy, reason: collision with root package name */
    int f25352iy;

    @Keep
    private long mNativePtr;

    public WebpFrame(long j11, int i11, int i12, int i13, int i14, int i15, boolean z11, boolean z12) {
        this.mNativePtr = j11;
        this.f25351ix = i11;
        this.f25352iy = i12;
        this.f25350iw = i13;
        this.f25349ih = i14;
        this.delay = i15;
        this.blendPreviousFrame = z11;
        this.disposeBackgroundColor = z12;
        fixFrameDuration();
    }

    private void fixFrameDuration() {
        if (this.delay < 20) {
            this.delay = 100;
        }
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int i11, int i12, Bitmap bitmap);

    public void dispose() {
        nativeDispose();
    }

    public void finalize() throws Throwable {
        nativeFinalize();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.f25349ih;
    }

    public int getWidth() {
        return this.f25350iw;
    }

    public int getXOffest() {
        return this.f25351ix;
    }

    public int getYOffest() {
        return this.f25352iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public void renderFrame(int i11, int i12, Bitmap bitmap) {
        nativeRenderFrame(i11, i12, bitmap);
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }
}
