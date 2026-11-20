package wi;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import yi.i;
import yi.n;
import yi.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends Drawable implements q, d3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f79519a;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public i f79520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f79521b;

        public b(@NonNull b bVar) {
            this.f79520a = (i) bVar.f79520a.getConstantState().newDrawable();
            this.f79521b = bVar.f79521b;
        }

        public b(i iVar) {
            this.f79520a = iVar;
            this.f79521b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    public a(b bVar) {
        this.f79519a = bVar;
    }

    public a(n nVar) {
        this(new b(new i(nVar)));
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f79519a = new b(this.f79519a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f79519a;
        if (bVar.f79521b) {
            bVar.f79520a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f79519a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f79519a.f79520a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f79519a.f79520a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f79519a.f79520a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zF = wi.b.f(iArr);
        b bVar = this.f79519a;
        if (bVar.f79521b == zF) {
            return zOnStateChange;
        }
        bVar.f79521b = zF;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        this.f79519a.f79520a.setAlpha(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f79519a.f79520a.setColorFilter(colorFilter);
    }

    @Override // yi.q
    public void setShapeAppearanceModel(@NonNull n nVar) {
        this.f79519a.f79520a.setShapeAppearanceModel(nVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        this.f79519a.f79520a.setTint(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.f79519a.f79520a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.f79519a.f79520a.setTintMode(mode);
    }
}
