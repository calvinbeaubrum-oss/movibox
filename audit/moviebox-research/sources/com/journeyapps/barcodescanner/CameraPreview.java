package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$styleable;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.PreviewScalingStrategy;
import com.journeyapps.barcodescanner.camera.i;
import com.journeyapps.barcodescanner.camera.j;
import com.journeyapps.barcodescanner.camera.l;
import com.journeyapps.barcodescanner.camera.m;
import com.journeyapps.barcodescanner.camera.n;
import com.journeyapps.barcodescanner.camera.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xn.r;
import xn.s;
import xn.t;
import xn.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CameraPreview extends ViewGroup {
    public static final String B = "CameraPreview";
    public final f A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraInstance f42487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowManager f42488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f42489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f42490d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SurfaceView f42491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextureView f42492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f42493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s f42494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f42495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<f> f42496k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m f42497l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CameraSettings f42498m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f42499n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f42500o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Rect f42501p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t f42502q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f42503r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Rect f42504s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public t f42505t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f42506u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PreviewScalingStrategy f42507v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f42508w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SurfaceHolder.Callback f42509x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Handler.Callback f42510y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public r f42511z;

    /* JADX INFO: compiled from: source.java */
    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            onSurfaceTextureSizeChanged(surfaceTexture, i11, i12);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            CameraPreview.this.f42502q = new t(i11, i12);
            CameraPreview.this.w();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            if (surfaceHolder == null) {
                Log.e(CameraPreview.B, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            CameraPreview.this.f42502q = new t(i12, i13);
            CameraPreview.this.w();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraPreview.this.f42502q = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == R$id.zxing_prewiew_size_ready) {
                CameraPreview.this.r((t) message.obj);
                return true;
            }
            if (i11 != R$id.zxing_camera_error) {
                if (i11 != R$id.zxing_camera_closed) {
                    return false;
                }
                CameraPreview.this.A.b();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!CameraPreview.this.q()) {
                return false;
            }
            CameraPreview.this.pause();
            CameraPreview.this.A.c(exc);
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements r {
        public d() {
        }

        @Override // xn.r
        public void a(int i11) {
            CameraPreview.this.f42489c.postDelayed(new Runnable() { // from class: xn.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f80607a.c();
                }
            }, 250L);
        }

        public final /* synthetic */ void c() {
            CameraPreview.this.t();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements f {
        public e() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            Iterator it = CameraPreview.this.f42496k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
            Iterator it = CameraPreview.this.f42496k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
            Iterator it = CameraPreview.this.f42496k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            Iterator it = CameraPreview.this.f42496k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
            Iterator it = CameraPreview.this.f42496k.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a();

        void b();

        void c(Exception exc);

        void d();

        void e();
    }

    public CameraPreview(Context context) {
        super(context);
        this.f42490d = false;
        this.f42493h = false;
        this.f42495j = -1;
        this.f42496k = new ArrayList();
        this.f42498m = new CameraSettings();
        this.f42503r = null;
        this.f42504s = null;
        this.f42505t = null;
        this.f42506u = 0.1d;
        this.f42507v = null;
        this.f42508w = false;
        this.f42509x = new b();
        this.f42510y = new c();
        this.f42511z = new d();
        this.A = new e();
        o(context, null, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42490d = false;
        this.f42493h = false;
        this.f42495j = -1;
        this.f42496k = new ArrayList();
        this.f42498m = new CameraSettings();
        this.f42503r = null;
        this.f42504s = null;
        this.f42505t = null;
        this.f42506u = 0.1d;
        this.f42507v = null;
        this.f42508w = false;
        this.f42509x = new b();
        this.f42510y = new c();
        this.f42511z = new d();
        this.A = new e();
        o(context, attributeSet, 0, 0);
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42490d = false;
        this.f42493h = false;
        this.f42495j = -1;
        this.f42496k = new ArrayList();
        this.f42498m = new CameraSettings();
        this.f42503r = null;
        this.f42504s = null;
        this.f42505t = null;
        this.f42506u = 0.1d;
        this.f42507v = null;
        this.f42508w = false;
        this.f42509x = new b();
        this.f42510y = new c();
        this.f42511z = new d();
        this.A = new e();
        o(context, attributeSet, i11, 0);
    }

    private int getDisplayRotation() {
        return this.f42488b.getDefaultDisplay().getRotation();
    }

    public void addStateListener(f fVar) {
        this.f42496k.add(fVar);
    }

    public void changeCameraParameters(i iVar) {
        CameraInstance cameraInstance = this.f42487a;
        if (cameraInstance != null) {
            cameraInstance.m(iVar);
        }
    }

    public CameraInstance getCameraInstance() {
        return this.f42487a;
    }

    public CameraSettings getCameraSettings() {
        return this.f42498m;
    }

    public Rect getFramingRect() {
        return this.f42503r;
    }

    public t getFramingRectSize() {
        return this.f42505t;
    }

    public double getMarginFraction() {
        return this.f42506u;
    }

    public Rect getPreviewFramingRect() {
        return this.f42504s;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        PreviewScalingStrategy previewScalingStrategy = this.f42507v;
        if (previewScalingStrategy != null) {
            return previewScalingStrategy;
        }
        return this.f42492g != null ? new l() : new n();
    }

    public t getPreviewSize() {
        return this.f42500o;
    }

    public final void i() {
        t tVar;
        m mVar;
        t tVar2 = this.f42499n;
        if (tVar2 == null || (tVar = this.f42500o) == null || (mVar = this.f42497l) == null) {
            this.f42504s = null;
            this.f42503r = null;
            this.f42501p = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        int i11 = tVar.f80643a;
        int i12 = tVar.f80644b;
        int i13 = tVar2.f80643a;
        int i14 = tVar2.f80644b;
        Rect rectD = mVar.d(tVar);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.f42501p = rectD;
        this.f42503r = j(new Rect(0, 0, i13, i14), this.f42501p);
        Rect rect = new Rect(this.f42503r);
        Rect rect2 = this.f42501p;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i11) / this.f42501p.width(), (rect.top * i12) / this.f42501p.height(), (rect.right * i11) / this.f42501p.width(), (rect.bottom * i12) / this.f42501p.height());
        this.f42504s = rect3;
        if (rect3.width() > 0 && this.f42504s.height() > 0) {
            this.A.a();
            return;
        }
        this.f42504s = null;
        this.f42503r = null;
        Log.w(B, "Preview frame is too small");
    }

    public boolean isCameraClosed() {
        CameraInstance cameraInstance = this.f42487a;
        return cameraInstance == null || cameraInstance.r();
    }

    public boolean isPreviewActive() {
        return this.f42493h;
    }

    public boolean isUseTextureView() {
        return this.f42490d;
    }

    public Rect j(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.f42505t != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.f42505t.f80643a) / 2), Math.max(0, (rect3.height() - this.f42505t.f80644b) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(((double) rect3.width()) * this.f42506u, ((double) rect3.height()) * this.f42506u);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix k(t tVar, t tVar2) {
        float f11;
        float f12 = tVar.f80643a / tVar.f80644b;
        float f13 = tVar2.f80643a / tVar2.f80644b;
        float f14 = 1.0f;
        if (f12 < f13) {
            f14 = f13 / f12;
            f11 = 1.0f;
        } else {
            f11 = f12 / f13;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f14, f11);
        int i11 = tVar.f80643a;
        int i12 = tVar.f80644b;
        matrix.postTranslate((i11 - (i11 * f14)) / 2.0f, (i12 - (i12 * f11)) / 2.0f);
        return matrix;
    }

    public final void l(t tVar) {
        this.f42499n = tVar;
        CameraInstance cameraInstance = this.f42487a;
        if (cameraInstance == null || cameraInstance.p() != null) {
            return;
        }
        m mVar = new m(getDisplayRotation(), tVar);
        this.f42497l = mVar;
        mVar.e(getPreviewScalingStrategy());
        this.f42487a.A(this.f42497l);
        this.f42487a.o();
        boolean z11 = this.f42508w;
        if (z11) {
            this.f42487a.D(z11);
        }
    }

    public CameraInstance m() {
        CameraInstance cameraInstance = new CameraInstance(getContext());
        cameraInstance.z(this.f42498m);
        return cameraInstance;
    }

    public final void n() {
        if (this.f42487a != null) {
            Log.w(B, "initCamera called twice");
            return;
        }
        CameraInstance cameraInstanceM = m();
        this.f42487a = cameraInstanceM;
        cameraInstanceM.B(this.f42489c);
        this.f42487a.x();
        this.f42495j = getDisplayRotation();
    }

    public final void o(Context context, AttributeSet attributeSet, int i11, int i12) {
        if (getBackground() == null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        p(attributeSet);
        this.f42488b = (WindowManager) context.getSystemService("window");
        this.f42489c = new Handler(this.f42510y);
        this.f42494i = new s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        l(new t(i13 - i11, i14 - i12));
        SurfaceView surfaceView = this.f42491f;
        if (surfaceView == null) {
            TextureView textureView = this.f42492g;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.f42501p;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.f42508w);
        return bundle;
    }

    public void p(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_camera_preview);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f42505t = new t(dimension, dimension2);
        }
        this.f42490d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.f42507v = new l();
        } else if (integer == 2) {
            this.f42507v = new n();
        } else if (integer == 3) {
            this.f42507v = new o();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void pause() {
        TextureView textureView;
        SurfaceView surfaceView;
        v.a();
        this.f42495j = -1;
        CameraInstance cameraInstance = this.f42487a;
        if (cameraInstance != null) {
            cameraInstance.n();
            this.f42487a = null;
            this.f42493h = false;
        } else {
            this.f42489c.sendEmptyMessage(R$id.zxing_camera_closed);
        }
        if (this.f42502q == null && (surfaceView = this.f42491f) != null) {
            surfaceView.getHolder().removeCallback(this.f42509x);
        }
        if (this.f42502q == null && (textureView = this.f42492g) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f42499n = null;
        this.f42500o = null;
        this.f42504s = null;
        this.f42494i.f();
        this.A.d();
    }

    public void pauseAndWait() {
        CameraInstance cameraInstance = getCameraInstance();
        pause();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.r() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public boolean q() {
        return this.f42487a != null;
    }

    public final void r(t tVar) {
        this.f42500o = tVar;
        if (this.f42499n != null) {
            i();
            requestLayout();
            w();
        }
    }

    public void resume() {
        v.a();
        n();
        if (this.f42502q != null) {
            w();
        } else {
            SurfaceView surfaceView = this.f42491f;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f42509x);
            } else {
                TextureView textureView = this.f42492g;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        x().onSurfaceTextureAvailable(this.f42492g.getSurfaceTexture(), this.f42492g.getWidth(), this.f42492g.getHeight());
                    } else {
                        this.f42492g.setSurfaceTextureListener(x());
                    }
                }
            }
        }
        requestLayout();
        this.f42494i.e(getContext(), this.f42511z);
    }

    public void s() {
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f42498m = cameraSettings;
    }

    public void setFramingRectSize(t tVar) {
        this.f42505t = tVar;
    }

    public void setMarginFraction(double d11) {
        if (d11 >= 0.5d) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.f42506u = d11;
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f42507v = previewScalingStrategy;
    }

    public void setTorch(boolean z11) {
        this.f42508w = z11;
        CameraInstance cameraInstance = this.f42487a;
        if (cameraInstance != null) {
            cameraInstance.D(z11);
        }
    }

    public void setUseTextureView(boolean z11) {
        this.f42490d = z11;
    }

    public final void t() {
        if (!q() || getDisplayRotation() == this.f42495j) {
            return;
        }
        pause();
        resume();
    }

    public final void u() {
        if (this.f42490d) {
            TextureView textureView = new TextureView(getContext());
            this.f42492g = textureView;
            textureView.setSurfaceTextureListener(x());
            addView(this.f42492g);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f42491f = surfaceView;
        surfaceView.getHolder().addCallback(this.f42509x);
        addView(this.f42491f);
    }

    public final void v(j jVar) {
        if (this.f42493h || this.f42487a == null) {
            return;
        }
        this.f42487a.C(jVar);
        this.f42487a.E();
        this.f42493h = true;
        s();
        this.A.e();
    }

    public final void w() {
        Rect rect;
        t tVar = this.f42502q;
        if (tVar == null || this.f42500o == null || (rect = this.f42501p) == null) {
            return;
        }
        if (this.f42491f != null && tVar.equals(new t(rect.width(), this.f42501p.height()))) {
            v(new j(this.f42491f.getHolder()));
            return;
        }
        TextureView textureView = this.f42492g;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.f42500o != null) {
            this.f42492g.setTransform(k(new t(this.f42492g.getWidth(), this.f42492g.getHeight()), this.f42500o));
        }
        v(new j(this.f42492g.getSurfaceTexture()));
    }

    @TargetApi(14)
    public final TextureView.SurfaceTextureListener x() {
        return new a();
    }
}
