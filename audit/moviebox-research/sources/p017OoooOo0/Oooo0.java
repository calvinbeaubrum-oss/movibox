package p017OoooOo0;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import p0.h;
import p0.i;
import p014OoooO0O.OooOOO0;
import p017OoooOo0.Oooo0;
import v0.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Oooo0<T extends Oooo0> extends Oooo000 {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public b f343OooO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public TextView f344OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public ImageView f345OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public ImageView f346OooO0o0;
    public h OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public b f347OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public boolean f348OooOO0;
    public boolean OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public int f349OooOO0o;
    public int OooOOO;
    public int OooOOO0;
    public int OooOOOO;
    public int OooOOOo;

    public Oooo0(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.OooOOO0 = 500;
        this.OooOOO = 20;
        this.OooOOOO = 20;
        this.OooOOOo = 0;
        this.OooO0O0 = s0.b.f75911d;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public int OooO00o(@NonNull i iVar, boolean z11) {
        ImageView imageView = this.f345OooO0o;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.OooOOO0;
    }

    public T OooO00o(int i11) {
        this.f348OooOO0 = true;
        this.f344OooO0Oo.setTextColor(i11);
        b bVar = this.f347OooO0oo;
        if (bVar != null) {
            bVar.f78670a.setColor(i11);
            this.f346OooO0o0.invalidateDrawable(this.f347OooO0oo);
        }
        b bVar2 = this.f343OooO;
        if (bVar2 != null) {
            bVar2.f78670a.setColor(i11);
            this.f345OooO0o.invalidateDrawable(this.f343OooO);
        }
        return this;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(@NonNull h hVar, int i11, int i12) {
        this.OooO0oO = hVar;
        ((OooOOO0.g) hVar).e(this, this.f349OooOO0o);
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO00o(@NonNull i iVar, int i11, int i12) {
        ImageView imageView = this.f345OooO0o;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f345OooO0o.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public T OooO0O0(int i11) {
        this.OooOO0O = true;
        this.f349OooOO0o = i11;
        h hVar = this.OooO0oO;
        if (hVar != null) {
            ((OooOOO0.g) hVar).e(this, i11);
        }
        return this;
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void OooO0O0(@NonNull i iVar, int i11, int i12) {
        OooO00o(iVar, i11, i12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.f346OooO0o0;
        ImageView imageView2 = this.f345OooO0o;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.f345OooO0o.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i11, int i12) {
        if (this.OooOOOo == 0) {
            this.OooOOO = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.OooOOOO = paddingBottom;
            if (this.OooOOO == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int iA = this.OooOOO;
                if (iA == 0) {
                    iA = x0.b.a(20.0f);
                }
                this.OooOOO = iA;
                int iA2 = this.OooOOOO;
                if (iA2 == 0) {
                    iA2 = x0.b.a(20.0f);
                }
                this.OooOOOO = iA2;
                setPadding(paddingLeft, this.OooOOO, paddingRight, iA2);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            int size = View.MeasureSpec.getSize(i12);
            int i13 = this.OooOOOo;
            if (size < i13) {
                int i14 = (size - i13) / 2;
                setPadding(getPaddingLeft(), i14, getPaddingRight(), i14);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.OooOOO, getPaddingRight(), this.OooOOOO);
        }
        super.onMeasure(i11, i12);
        if (this.OooOOOo == 0) {
            for (int i15 = 0; i15 < getChildCount(); i15++) {
                int measuredHeight = getChildAt(i15).getMeasuredHeight();
                if (this.OooOOOo < measuredHeight) {
                    this.OooOOOo = measuredHeight;
                }
            }
        }
    }

    @Override // p017OoooOo0.Oooo000, p0.g
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.OooOO0O) {
                OooO0O0(iArr[0]);
                this.OooOO0O = false;
            }
            if (this.f348OooOO0) {
                return;
            }
            if (iArr.length > 1) {
                OooO00o(iArr[1]);
            } else {
                OooO00o(iArr[0] == -1 ? -10066330 : -1);
            }
            this.f348OooOO0 = false;
        }
    }
}
