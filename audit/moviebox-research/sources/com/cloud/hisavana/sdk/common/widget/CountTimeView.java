package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class CountTimeView extends View implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f29516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f29517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f29519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x9.a f29520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f29521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f29522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f29523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f29524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f29525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f29526l;

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.a {
        public a(long j11, long j12) {
            super(j11, j12);
        }

        @Override // x9.a
        public void e() {
            if (CountTimeView.this.f29523i != null) {
                CountTimeView.this.f29523i.onFinish();
            }
        }

        @Override // x9.a
        public void f(long j11) {
            CountTimeView.this.f29522h = "SKIP " + (j11 / 1000);
            CountTimeView.this.f29525k = (int) j11;
            CountTimeView.this.invalidate();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onClick();

        void onFinish();

        void onStart();
    }

    public CountTimeView(Context context) {
        this(context, null);
    }

    public CountTimeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountTimeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29518c = 6L;
        this.f29519d = 0L;
        this.f29522h = "5s";
        this.f29526l = new Rect();
        setOnClickListener(this);
        this.f29521g = context.getResources().getDimensionPixelSize(R$dimen.ad_skip_text_size);
        e();
    }

    private Bitmap getBg() {
        try {
            Drawable drawable = getResources().getDrawable(R$drawable.ad_skip_button);
            if (drawable instanceof BitmapDrawable) {
                this.f29524j = ((BitmapDrawable) drawable).getBitmap();
            } else {
                this.f29524j = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f29524j);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
            return this.f29524j;
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            return null;
        }
    }

    public void cancel() {
        x9.a aVar = this.f29520f;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void changeFinishMode() {
        this.f29522h = "X";
        invalidate();
    }

    public final void d() {
        this.f29520f = new a(this.f29518c, 1000L);
    }

    public final void e() {
        Paint paint = new Paint();
        this.f29516a = paint;
        paint.setAntiAlias(true);
        this.f29516a.setDither(true);
        this.f29516a.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f29517b = paint2;
        paint2.setAntiAlias(true);
        this.f29517b.setColor(-1);
        this.f29517b.setTextSize(this.f29521g);
        this.f29517b.setStrokeWidth(8.0f);
        this.f29517b.setTextAlign(Paint.Align.CENTER);
    }

    public long getRemainder() {
        return this.f29525k;
    }

    public long getSupposeFinishTime() {
        return this.f29519d;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f29520f.g();
        b bVar = this.f29523i;
        if (bVar != null) {
            bVar.onStart();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.f29523i;
        if (bVar != null) {
            bVar.onClick();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x9.a aVar = this.f29520f;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (TextUtils.isEmpty(this.f29522h)) {
                return;
            }
            if (this.f29524j == null) {
                this.f29524j = getBg();
            }
            Rect rect = new Rect(0, 0, this.f29524j.getWidth(), this.f29524j.getHeight());
            canvas.drawBitmap(this.f29524j, rect, rect, this.f29516a);
            Paint.FontMetrics fontMetrics = this.f29517b.getFontMetrics();
            Rect rect2 = this.f29526l;
            canvas.drawText(this.f29522h, rect2.centerX(), ((int) (((rect2.bottom + rect2.top) - fontMetrics.bottom) - fontMetrics.top)) / 2, this.f29517b);
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        this.f29526l.set(0, 0, getWidth(), getHeight());
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setCountDownTimerListener(b bVar) {
        this.f29523i = bVar;
    }

    public void setStartTime(int i11) {
        this.f29518c = ((long) (i11 * 1000)) + 400;
        this.f29519d = System.currentTimeMillis() + this.f29518c + 1000;
        this.f29525k = i11;
        d();
    }

    public void start() {
        this.f29520f.g();
        this.f29519d = System.currentTimeMillis() + this.f29518c + 1000;
        b bVar = this.f29523i;
        if (bVar != null) {
            bVar.onStart();
        }
    }
}
