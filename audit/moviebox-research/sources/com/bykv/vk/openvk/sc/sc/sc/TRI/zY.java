package com.bykv.vk.openvk.sc.sc.sc.TRI;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import s8.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends ExN implements SurfaceHolder.Callback, a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<s8.a> f26067c = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<b> f26068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s8.a f26069b;

    public zY(Context context) {
        super(context);
        a();
    }

    public final void a() {
        s8.a aVar = new s8.a(this);
        this.f26069b = aVar;
        f26067c.add(aVar);
    }

    @Override // com.bykv.vk.openvk.sc.sc.sc.TRI.a
    public View getView() {
        return this;
    }

    @Override // android.view.SurfaceView, android.view.View
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
        this.f26068a = new WeakReference<>(bVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<s8.a> it = f26067c.iterator();
        while (it.hasNext()) {
            s8.a next = it.next();
            if (next != null && next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f26069b);
    }

    public void setWindowVisibilityChangedListener(a.InterfaceC0221a interfaceC0221a) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        WeakReference<b> weakReference = this.f26068a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26068a.get().sc(surfaceHolder, i11, i12, i13);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<b> weakReference = this.f26068a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26068a.get().sc(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<b> weakReference = this.f26068a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26068a.get().pFF(surfaceHolder);
    }
}
