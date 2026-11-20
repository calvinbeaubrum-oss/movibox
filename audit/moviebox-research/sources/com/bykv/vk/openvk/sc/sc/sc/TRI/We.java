package com.bykv.vk.openvk.sc.sc.sc.TRI;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import s8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends TextureView implements TextureView.SurfaceTextureListener, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f26066a;

    public We(Context context) {
        this(context, null);
    }

    public We(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.sc.sc.sc.TRI.a
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.sc.sc.sc.TRI.a
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        b bVar = this.f26066a;
        if (bVar != null) {
            bVar.sc(surfaceTexture, i11, i12);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b bVar = this.f26066a;
        if (bVar != null) {
            return bVar.sc(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
    }

    @Override // com.bykv.vk.openvk.sc.sc.sc.TRI.a
    public void sc(int i11, int i12) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i12;
        layoutParams.width = i11;
        setLayoutParams(layoutParams);
    }

    @Override // com.bykv.vk.openvk.sc.sc.sc.TRI.a
    public void sc(b bVar) {
        this.f26066a = bVar;
        setSurfaceTextureListener(this);
    }

    public void setWindowVisibilityChangedListener(a.InterfaceC0221a interfaceC0221a) {
    }
}
