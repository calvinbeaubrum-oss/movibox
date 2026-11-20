package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GifTextureView extends TextureView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ImageView.ScaleType[] f73910h = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f73911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f73912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f73913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RenderThread f73914d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f73915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d.b f73916g;

    /* JADX INFO: compiled from: source.java */
    public static class RenderThread extends Thread implements TextureView.SurfaceTextureListener {
        final pl.droidsonroids.gif.b isSurfaceValid;
        private GifInfoHandle mGifInfoHandle;
        private final WeakReference<GifTextureView> mGifTextureViewReference;
        private IOException mIOException;
        long[] mSavedState;

        public RenderThread(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.isSurfaceValid = new pl.droidsonroids.gif.b();
            this.mGifInfoHandle = new GifInfoHandle();
            this.mGifTextureViewReference = new WeakReference<>(gifTextureView);
        }

        public void dispose(@NonNull GifTextureView gifTextureView, @Nullable b bVar) {
            this.isSurfaceValid.b();
            gifTextureView.setSuperSurfaceTextureListener(bVar != null ? new h(bVar) : null);
            this.mGifInfoHandle.s();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            GifTextureView gifTextureView = this.mGifTextureViewReference.get();
            if (gifTextureView != null) {
                gifTextureView.h(this.mGifInfoHandle);
            }
            this.isSurfaceValid.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.isSurfaceValid.b();
            this.mGifInfoHandle.s();
            interrupt();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.mGifTextureViewReference.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle gifInfoHandleA = gifTextureView.f73913c.a();
                this.mGifInfoHandle = gifInfoHandleA;
                gifInfoHandleA.C((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f73916g.f73925b >= 0) {
                    this.mGifInfoHandle.B(gifTextureView.f73916g.f73925b);
                }
                final GifTextureView gifTextureView2 = this.mGifTextureViewReference.get();
                if (gifTextureView2 == null) {
                    this.mGifInfoHandle.t();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean zIsAvailable = gifTextureView2.isAvailable();
                this.isSurfaceValid.d(zIsAvailable);
                if (zIsAvailable) {
                    gifTextureView2.post(new Runnable() { // from class: pl.droidsonroids.gif.GifTextureView.RenderThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gifTextureView2.h(RenderThread.this.mGifInfoHandle);
                        }
                    });
                }
                this.mGifInfoHandle.D(gifTextureView2.f73915f);
                while (!isInterrupted()) {
                    try {
                        this.isSurfaceValid.a();
                        GifTextureView gifTextureView3 = this.mGifTextureViewReference.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.mGifInfoHandle.a(surface, this.mSavedState);
                                surface.release();
                            } catch (Throwable th2) {
                                surface.release();
                                throw th2;
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.mGifInfoHandle.t();
                this.mGifInfoHandle = new GifInfoHandle();
            } catch (IOException e11) {
                this.mIOException = e11;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73917a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f73917a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f73917a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f73917a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f73917a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f73917a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f73917a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f73917a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f73917a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    public GifTextureView(Context context) {
        super(context);
        this.f73911a = ImageView.ScaleType.FIT_CENTER;
        this.f73912b = new Matrix();
        this.f73915f = 1.0f;
        g(null, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f73911a = ImageView.ScaleType.FIT_CENTER;
        this.f73912b = new Matrix();
        this.f73915f = 1.0f;
        g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f73911a = ImageView.ScaleType.FIT_CENTER;
        this.f73912b = new Matrix();
        this.f73915f = 1.0f;
        g(attributeSet, i11, 0);
    }

    @RequiresApi(21)
    public GifTextureView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f73911a = ImageView.ScaleType.FIT_CENTER;
        this.f73912b = new Matrix();
        this.f73915f = 1.0f;
        g(attributeSet, i11, i12);
    }

    public static e f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(R$styleable.GifTextureView_gifSource, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (d.f73921a.contains(resourceTypeName)) {
                return new e.c(typedArray.getResources(), typedValue.resourceId);
            }
            if (!"string".equals(resourceTypeName)) {
                throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new e.b(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public final void g(AttributeSet attributeSet, int i11, int i12) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f73910h;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f73911a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GifTextureView, i11, i12);
            this.f73913c = f(typedArrayObtainStyledAttributes);
            super.setOpaque(typedArrayObtainStyledAttributes.getBoolean(R$styleable.GifTextureView_isOpaque, false));
            typedArrayObtainStyledAttributes.recycle();
            this.f73916g = new d.b(this, attributeSet, i11, i12);
        } else {
            super.setOpaque(false);
            this.f73916g = new d.b();
        }
        if (isInEditMode()) {
            return;
        }
        RenderThread renderThread = new RenderThread(this);
        this.f73914d = renderThread;
        if (this.f73913c != null) {
            renderThread.start();
        }
    }

    @Nullable
    public IOException getIOException() {
        return this.f73914d.mIOException != null ? this.f73914d.mIOException : GifIOException.fromCode(this.f73914d.mGifInfoHandle.j());
    }

    public ImageView.ScaleType getScaleType() {
        return this.f73911a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.f73912b);
        return matrix;
    }

    public final void h(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float fN = gifInfoHandle.n() / width;
        float fG = gifInfoHandle.g() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.n(), gifInfoHandle.g());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        switch (a.f73917a[this.f73911a.ordinal()]) {
            case 1:
                matrix.setScale(fN, fG, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float fMin = 1.0f / Math.min(fN, fG);
                matrix.setScale(fN * fMin, fMin * fG, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float fMin2 = (((float) gifInfoHandle.n()) > width || ((float) gifInfoHandle.g()) > height) ? Math.min(1.0f / fN, 1.0f / fG) : 1.0f;
                matrix.setScale(fN * fMin2, fMin2 * fG, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(fN, fG);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(fN, fG);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(fN, fG);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f73912b);
                matrix.preScale(fN, fG);
                break;
        }
        super.setTransform(matrix);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f73914d.dispose(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f73914d.mSavedState = gifViewSavedState.f73918a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        RenderThread renderThread = this.f73914d;
        renderThread.mSavedState = renderThread.mGifInfoHandle.m();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f73916g.f73924a ? this.f73914d.mSavedState : null);
    }

    public void setFreezesAnimation(boolean z11) {
        this.f73916g.f73924a = z11;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable e eVar) {
        setInputSource(eVar, null);
    }

    public synchronized void setInputSource(@Nullable e eVar, @Nullable b bVar) {
        this.f73914d.dispose(this, bVar);
        try {
            this.f73914d.join();
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        this.f73913c = eVar;
        RenderThread renderThread = new RenderThread(this);
        this.f73914d = renderThread;
        if (eVar != null) {
            renderThread.start();
        }
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z11) {
        if (z11 != isOpaque()) {
            super.setOpaque(z11);
            setInputSource(this.f73913c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f73911a = scaleType;
        h(this.f73914d.mGifInfoHandle);
    }

    public void setSpeed(float f11) {
        this.f73915f = f11;
        this.f73914d.mGifInfoHandle.D(f11);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.f73912b.set(matrix);
        h(this.f73914d.mGifInfoHandle);
    }
}
