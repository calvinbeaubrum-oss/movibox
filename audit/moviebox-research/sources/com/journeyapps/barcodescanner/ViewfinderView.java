package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.client.android.R$color;
import com.google.zxing.client.android.R$styleable;
import com.google.zxing.k;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.ArrayList;
import java.util.List;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class ViewfinderView extends View {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f42524o = {0, 64, 128, PsExtractor.AUDIO_STREAM, 255, PsExtractor.AUDIO_STREAM, 128, 64};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f42525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f42526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42528d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f42529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f42530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f42531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f42532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<k> f42533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<k> f42534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CameraPreview f42535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Rect f42536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f42537n;

    /* JADX INFO: compiled from: source.java */
    public class a implements CameraPreview.f {
        public a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            ViewfinderView.this.a();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42525a = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_finder);
        this.f42527c = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R$color.zxing_viewfinder_mask));
        this.f42528d = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_result_view, resources.getColor(R$color.zxing_result_view));
        this.f42529f = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R$color.zxing_viewfinder_laser));
        this.f42530g = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R$color.zxing_possible_result_points));
        this.f42531h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.zxing_finder_zxing_viewfinder_laser_visibility, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f42532i = 0;
        this.f42533j = new ArrayList(20);
        this.f42534k = new ArrayList(20);
    }

    public void a() {
        CameraPreview cameraPreview = this.f42535l;
        if (cameraPreview == null) {
            return;
        }
        Rect framingRect = cameraPreview.getFramingRect();
        t previewSize = this.f42535l.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f42536m = framingRect;
        this.f42537n = previewSize;
    }

    public void addPossibleResultPoint(k kVar) {
        if (this.f42533j.size() < 20) {
            this.f42533j.add(kVar);
        }
    }

    public void drawResultBitmap(Bitmap bitmap) {
        this.f42526b = bitmap;
        invalidate();
    }

    public void drawViewfinder() {
        Bitmap bitmap = this.f42526b;
        this.f42526b = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        t tVar;
        a();
        Rect rect = this.f42536m;
        if (rect == null || (tVar = this.f42537n) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.f42525a.setColor(this.f42526b != null ? this.f42528d : this.f42527c);
        float f11 = width;
        canvas.drawRect(0.0f, 0.0f, f11, rect.top, this.f42525a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f42525a);
        canvas.drawRect(rect.right + 1, rect.top, f11, rect.bottom + 1, this.f42525a);
        canvas.drawRect(0.0f, rect.bottom + 1, f11, height, this.f42525a);
        if (this.f42526b != null) {
            this.f42525a.setAlpha(160);
            canvas.drawBitmap(this.f42526b, (Rect) null, rect, this.f42525a);
            return;
        }
        if (this.f42531h) {
            this.f42525a.setColor(this.f42529f);
            Paint paint = this.f42525a;
            int[] iArr = f42524o;
            paint.setAlpha(iArr[this.f42532i]);
            this.f42532i = (this.f42532i + 1) % iArr.length;
            int iHeight = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, iHeight - 1, rect.right - 1, iHeight + 2, this.f42525a);
        }
        float width2 = getWidth() / tVar.f80643a;
        float height2 = getHeight() / tVar.f80644b;
        if (!this.f42534k.isEmpty()) {
            this.f42525a.setAlpha(80);
            this.f42525a.setColor(this.f42530g);
            for (k kVar : this.f42534k) {
                canvas.drawCircle((int) (kVar.c() * width2), (int) (kVar.d() * height2), 3.0f, this.f42525a);
            }
            this.f42534k.clear();
        }
        if (!this.f42533j.isEmpty()) {
            this.f42525a.setAlpha(160);
            this.f42525a.setColor(this.f42530g);
            for (k kVar2 : this.f42533j) {
                canvas.drawCircle((int) (kVar2.c() * width2), (int) (kVar2.d() * height2), 6.0f, this.f42525a);
            }
            List<k> list = this.f42533j;
            List<k> list2 = this.f42534k;
            this.f42533j = list2;
            this.f42534k = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.f42535l = cameraPreview;
        cameraPreview.addStateListener(new a());
    }

    public void setLaserVisibility(boolean z11) {
        this.f42531h = z11;
    }

    public void setMaskColor(int i11) {
        this.f42527c = i11;
    }
}
