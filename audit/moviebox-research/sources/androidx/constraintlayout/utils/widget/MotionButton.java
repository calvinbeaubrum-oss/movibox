package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f7216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewOutlineProvider f7217d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RectF f7218f;

    /* JADX INFO: compiled from: source.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = MotionButton.this.getWidth();
            int height = MotionButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * MotionButton.this.f7214a) / 2.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.f7215b);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.f7214a = 0.0f;
        this.f7215b = Float.NaN;
        init(context, null);
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7214a = 0.0f;
        this.f7215b = Float.NaN;
        init(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7214a = 0.0f;
        this.f7215b = Float.NaN;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f7215b;
    }

    public float getRoundPercent() {
        return this.f7214a;
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        if (Float.isNaN(f11)) {
            this.f7215b = f11;
            float f12 = this.f7214a;
            this.f7214a = -1.0f;
            setRoundPercent(f12);
            return;
        }
        boolean z11 = this.f7215b != f11;
        this.f7215b = f11;
        if (f11 != 0.0f) {
            if (this.f7216c == null) {
                this.f7216c = new Path();
            }
            if (this.f7218f == null) {
                this.f7218f = new RectF();
            }
            if (this.f7217d == null) {
                b bVar = new b();
                this.f7217d = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f7218f.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f7216c.reset();
            Path path = this.f7216c;
            RectF rectF = this.f7218f;
            float f13 = this.f7215b;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f11) {
        boolean z11 = this.f7214a != f11;
        this.f7214a = f11;
        if (f11 != 0.0f) {
            if (this.f7216c == null) {
                this.f7216c = new Path();
            }
            if (this.f7218f == null) {
                this.f7218f = new RectF();
            }
            if (this.f7217d == null) {
                a aVar = new a();
                this.f7217d = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f7214a) / 2.0f;
            this.f7218f.set(0.0f, 0.0f, width, height);
            this.f7216c.reset();
            this.f7216c.addRoundRect(this.f7218f, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }
}
