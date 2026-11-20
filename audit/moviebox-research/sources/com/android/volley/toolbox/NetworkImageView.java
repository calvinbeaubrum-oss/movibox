package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.android.volley.VolleyError;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class NetworkImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public Drawable f16546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Bitmap f16547d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f16549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Bitmap f16550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h.b f16551i;

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16552a;

        public AnonymousClass1(boolean z11) {
            this.f16552a = z11;
        }

        @Override // com.android.volley.toolbox.h.c
        public void a(final h.b bVar, boolean z11) {
            if (z11 && this.f16552a) {
                NetworkImageView.this.post(new Runnable() { // from class: com.android.volley.toolbox.NetworkImageView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1.this.a(bVar, false);
                    }
                });
                return;
            }
            if (bVar.d() != null) {
                NetworkImageView.this.setImageBitmap(bVar.d());
                return;
            }
            if (NetworkImageView.this.f16545b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f16545b);
            } else if (NetworkImageView.this.f16546c != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f16546c);
            } else if (NetworkImageView.this.f16547d != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f16547d);
            }
        }

        @Override // com.android.volley.i.a
        public void onErrorResponse(VolleyError volleyError) {
            if (NetworkImageView.this.f16548f != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f16548f);
            } else if (NetworkImageView.this.f16549g != null) {
                NetworkImageView networkImageView2 = NetworkImageView.this;
                networkImageView2.setImageDrawable(networkImageView2.f16549g);
            } else if (NetworkImageView.this.f16550h != null) {
                NetworkImageView networkImageView3 = NetworkImageView.this;
                networkImageView3.setImageBitmap(networkImageView3.f16550h);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:28:0x004e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    public void g(boolean z11) {
        boolean z12;
        h.b bVar;
        h.b bVar2;
        int width = getWidth();
        int height = getHeight();
        getScaleType();
        if (getLayoutParams() != null) {
            z12 = getLayoutParams().width == -2;
            boolean z13 = getLayoutParams().height == -2;
            boolean z14 = !z12 && z13;
            if (width == 0 || height != 0 || z14) {
                if (TextUtils.isEmpty(this.f16544a)) {
                    bVar2 = this.f16551i;
                    if (bVar2 != null) {
                        bVar2.c();
                        this.f16551i = null;
                    }
                    h();
                    return;
                }
                bVar = this.f16551i;
                if (bVar != null && bVar.e() != null) {
                    if (this.f16551i.e().equals(this.f16544a)) {
                        return;
                    }
                    this.f16551i.c();
                    h();
                }
                new AnonymousClass1(z11);
                throw null;
            }
            return;
        }
        z12 = false;
        if (z12) {
        }
        if (width == 0) {
        }
        if (TextUtils.isEmpty(this.f16544a)) {
            bVar2 = this.f16551i;
            if (bVar2 != null) {
                bVar2.c();
                this.f16551i = null;
            }
            h();
            return;
        }
        bVar = this.f16551i;
        if (bVar != null) {
            if (this.f16551i.e().equals(this.f16544a)) {
                return;
            }
            this.f16551i.c();
            h();
        }
        new AnonymousClass1(z11);
        throw null;
    }

    public final void h() {
        int i11 = this.f16545b;
        if (i11 != 0) {
            setImageResource(i11);
            return;
        }
        Drawable drawable = this.f16546c;
        if (drawable != null) {
            setImageDrawable(drawable);
            return;
        }
        Bitmap bitmap = this.f16547d;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        h.b bVar = this.f16551i;
        if (bVar != null) {
            bVar.c();
            setImageBitmap(null);
            this.f16551i = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        g(true);
    }

    public void setDefaultImageBitmap(Bitmap bitmap) {
        this.f16545b = 0;
        this.f16546c = null;
        this.f16547d = bitmap;
    }

    public void setDefaultImageDrawable(@Nullable Drawable drawable) {
        this.f16545b = 0;
        this.f16547d = null;
        this.f16546c = drawable;
    }

    public void setDefaultImageResId(int i11) {
        this.f16547d = null;
        this.f16546c = null;
        this.f16545b = i11;
    }

    public void setErrorImageBitmap(Bitmap bitmap) {
        this.f16548f = 0;
        this.f16549g = null;
        this.f16550h = bitmap;
    }

    public void setErrorImageDrawable(@Nullable Drawable drawable) {
        this.f16548f = 0;
        this.f16550h = null;
        this.f16549g = drawable;
    }

    public void setErrorImageResId(int i11) {
        this.f16550h = null;
        this.f16549g = null;
        this.f16548f = i11;
    }

    public void setImageUrl(String str, h hVar) {
        n.a();
        this.f16544a = str;
        g(false);
    }
}
