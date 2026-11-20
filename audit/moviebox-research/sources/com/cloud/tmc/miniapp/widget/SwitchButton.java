package com.cloud.tmc.miniapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$dimen;
import com.cloud.tmc.miniapp.R$styleable;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class SwitchButton extends View {

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public final float f31878OooO;
    public final AccelerateInterpolator OooO00o;
    public final Paint OooO0O0;
    public final Path OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public final Path f31879OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public float f31880OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public final RectF f31881OooO0o0;
    public float OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public RadialGradient f31882OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public final float f31883OooOO0;
    public int OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public int f31884OooOO0o;
    public boolean OooOOO;
    public boolean OooOOO0;
    public boolean OooOOOO;
    public int OooOOOo;
    public int OooOOo;
    public int OooOOo0;
    public int OooOOoo;
    public float OooOo;
    public a OooOo0;
    public int OooOo00;
    public float OooOo0O;
    public float OooOo0o;
    public float OooOoO;
    public float OooOoO0;

    /* JADX INFO: renamed from: OooOoOO, reason: collision with root package name */
    public float f31885OooOoOO;

    /* JADX INFO: renamed from: OooOoo, reason: collision with root package name */
    public float f31886OooOoo;

    /* JADX INFO: renamed from: OooOoo0, reason: collision with root package name */
    public float f31887OooOoo0;
    public float OooOooO;

    /* JADX INFO: renamed from: OooOooo, reason: collision with root package name */
    public float f31888OooOooo;
    public float Oooo0;
    public float Oooo000;

    /* JADX INFO: renamed from: Oooo00O, reason: collision with root package name */
    public float f31889Oooo00O;

    /* JADX INFO: renamed from: Oooo00o, reason: collision with root package name */
    public float f31890Oooo00o;
    public float Oooo0O0;

    /* JADX INFO: compiled from: source.java */
    public static final class SavedState extends View.BaseSavedState {

        @JvmField
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean OooO00o;

        /* JADX INFO: compiled from: source.java */
        public static final class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in2) {
                Intrinsics.g(in2, "in");
                return new SavedState(in2);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.OooO00o = 1 == parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int i11) {
            Intrinsics.g(out, "out");
            super.writeToParcel(out, i11);
            out.writeInt(this.OooO00o ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SwitchButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Intrinsics.g(context, "context");
        this.OooO00o = new AccelerateInterpolator(2.0f);
        this.OooO0O0 = new Paint();
        this.OooO0OO = new Path();
        this.f31879OooO0Oo = new Path();
        this.f31881OooO0o0 = new RectF();
        this.f31878OooO = 0.68f;
        this.f31883OooOO0 = 0.1f;
        this.OooOOOo = Color.parseColor("#0081FF");
        this.OooOOo0 = Color.parseColor("#0081FF");
        Color.parseColor("#C2C6CE");
        this.OooOOo = Color.parseColor("#BFBFBF");
        this.OooOo00 = Color.parseColor("#333333");
        setLayerType(1, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchButton);
        Intrinsics.f(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.SwitchButton)");
        this.OooOOOO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SwitchButton_android_checked, this.OooOOOO);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.SwitchButton_android_enabled, isEnabled()));
        int i13 = this.OooOOOO ? 3 : 1;
        this.f31884OooOO0o = i13;
        this.OooOO0O = i13;
        this.OooOOoo = z2.a.getColor(context, R$color.mini_color_switch_off_bg);
        this.OooOOOo = z2.a.getColor(context, R$color.mini_color_primary);
        this.OooOOo0 = z2.a.getColor(context, R$color.mini_color_primary);
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ SwitchButton(Context context, AttributeSet attributeSet, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public static void OooO00o(SwitchButton switchButton, boolean z11, boolean z12, boolean z13, int i11) {
        if ((i11 & 4) != 0) {
            z13 = true;
        }
        int i12 = z11 ? 3 : 1;
        int i13 = switchButton.f31884OooOO0o;
        if (i12 == i13) {
            return;
        }
        if ((i12 == 3 && (i13 == 1 || i13 == 2)) || (i12 == 1 && (i13 == 3 || i13 == 4))) {
            switchButton.f31880OooO0o = z13 ? 1.0f : 0.0f;
        }
        switchButton.OooO0oO = z13 ? 1.0f : 0.0f;
        boolean z14 = switchButton.OooOOOO;
        if (!z14 && i12 == 3) {
            switchButton.OooOOOO = true;
        } else if (z14 && i12 == 1) {
            switchButton.OooOOOO = false;
        }
        switchButton.OooOO0O = i13;
        switchButton.f31884OooOO0o = i12;
        switchButton.postInvalidate();
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0109  */
    /* JADX WARN: Code duplicated, block: B:71:0x011e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0164  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01bc  */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f11;
        float f12;
        float f13;
        int i11;
        int i12;
        float f14;
        float f15;
        Intrinsics.g(canvas, "canvas");
        if (this.OooOOO0) {
            this.OooO0O0.setAntiAlias(true);
            int i13 = this.f31884OooOO0o;
            boolean z11 = i13 == 3 || i13 == 4;
            Paint paint = this.OooO0O0;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            this.OooO0O0.setColor(z11 ? this.OooOOOo : this.OooOOoo);
            canvas.drawPath(this.OooO0OO, this.OooO0O0);
            float f16 = this.f31880OooO0o;
            float f17 = this.f31883OooOO0;
            float f18 = f16 - f17;
            if (f18 <= 0.0f) {
                f18 = 0.0f;
            }
            this.f31880OooO0o = f18;
            float f19 = this.OooO0oO - f17;
            if (f19 <= 0.0f) {
                f19 = 0.0f;
            }
            this.OooO0oO = f19;
            float interpolation = this.OooO00o.getInterpolation(f18);
            float interpolation2 = this.OooO00o.getInterpolation(this.OooO0oO);
            float f21 = this.OooOoO0 * (z11 ? interpolation : 1 - interpolation);
            float f22 = (this.OooOo0O - this.OooOo0o) - this.f31885OooOoOO;
            if (z11) {
                interpolation = 1 - interpolation;
            }
            canvas.save();
            canvas.scale(f21, f21, this.OooOo0o + (f22 * interpolation), this.OooOo);
            if (isEnabled()) {
                this.OooO0O0.setColor(this.OooOOoo);
            } else {
                this.OooO0O0.setColor(Color.parseColor("#BBBBBB"));
            }
            canvas.drawPath(this.OooO0OO, this.OooO0O0);
            canvas.restore();
            canvas.save();
            int i14 = this.f31884OooOO0o;
            int i15 = i14 - this.OooOO0O;
            if (i15 != -3) {
                if (i15 != -2) {
                    if (i15 != -1) {
                        if (i15 != 1) {
                            if (i15 == 2) {
                                if (i14 == 3) {
                                    f14 = this.Oooo000;
                                    f15 = this.Oooo0;
                                } else if (i14 == 4) {
                                    f14 = this.f31889Oooo00O;
                                    f15 = this.Oooo0;
                                } else {
                                    f13 = 0.0f;
                                }
                                f13 = f14 - ((f14 - f15) * interpolation2);
                            } else if (i15 == 3) {
                                f14 = this.Oooo000;
                                f15 = this.Oooo0;
                                f13 = f14 - ((f14 - f15) * interpolation2);
                            } else if (i14 == 1) {
                                f13 = this.Oooo0;
                            } else if (i14 == 3) {
                                f13 = this.Oooo000;
                            } else {
                                f13 = 0.0f;
                            }
                        } else if (i14 == 2) {
                            f13 = this.Oooo0;
                        } else if (i14 == 3) {
                            f14 = this.Oooo000;
                            f15 = this.f31889Oooo00O;
                            f13 = f14 - ((f14 - f15) * interpolation2);
                        } else {
                            f13 = 0.0f;
                        }
                    } else if (i14 == 4) {
                        f11 = this.f31889Oooo00O;
                        f12 = this.Oooo000;
                    } else if (i14 == 1) {
                        f13 = this.Oooo0;
                    } else {
                        f13 = 0.0f;
                    }
                } else if (i14 == 1) {
                    f11 = this.Oooo0;
                    f12 = this.f31889Oooo00O;
                } else if (i14 == 2) {
                    f11 = this.f31890Oooo00o;
                    f12 = this.Oooo000;
                } else {
                    f13 = 0.0f;
                }
                canvas.translate(f13 - this.Oooo0, this.Oooo0O0);
                i11 = this.f31884OooOO0o;
                if (i11 != 4 || i11 == 2) {
                    interpolation2 = 1 - interpolation2;
                }
                this.f31879OooO0Oo.reset();
                RectF rectF = this.f31881OooO0o0;
                float f23 = this.OooOooO;
                float f24 = 2;
                float f25 = this.f31887OooOoo0 / f24;
                rectF.left = f23 + f25;
                rectF.right = this.f31888OooOooo - f25;
                this.f31879OooO0Oo.arcTo(rectF, 90.0f, 180.0f);
                RectF rectF2 = this.f31881OooO0o0;
                float f26 = this.OooOooO;
                float f27 = interpolation2 * this.OooOoO;
                float f28 = this.f31887OooOoo0 / f24;
                rectF2.left = f26 + f27 + f28;
                rectF2.right = (f27 + this.f31888OooOooo) - f28;
                this.f31879OooO0Oo.arcTo(rectF2, 270.0f, 180.0f);
                this.f31879OooO0Oo.close();
                if (this.OooOOO) {
                    this.OooO0O0.setStyle(style);
                    this.OooO0O0.setShader(this.f31882OooO0oo);
                    canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
                    this.OooO0O0.setShader(null);
                }
                canvas.translate(0.0f, -this.Oooo0O0);
                float f29 = this.f31886OooOoo / f24;
                canvas.scale(0.98f, 0.98f, f29, f29);
                this.OooO0O0.setStyle(style);
                this.OooO0O0.setColor(Color.parseColor("#FFFFFF"));
                canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
                this.OooO0O0.setStyle(Paint.Style.STROKE);
                this.OooO0O0.setStrokeWidth(this.f31887OooOoo0 * 0.5f);
                Paint paint2 = this.OooO0O0;
                if (z11) {
                    i12 = this.OooOOo0;
                } else {
                    i12 = this.OooOOo;
                }
                paint2.setColor(i12);
                canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
                canvas.restore();
                this.OooO0O0.reset();
                if (this.f31880OooO0o <= 0.0f || this.OooO0oO > 0.0f) {
                    invalidate();
                }
                return;
            }
            f11 = this.Oooo0;
            f12 = this.Oooo000;
            f13 = f11 + ((f12 - f11) * interpolation2);
            canvas.translate(f13 - this.Oooo0, this.Oooo0O0);
            i11 = this.f31884OooOO0o;
            if (i11 != 4) {
                interpolation2 = 1 - interpolation2;
            } else {
                interpolation2 = 1 - interpolation2;
            }
            this.f31879OooO0Oo.reset();
            RectF rectF3 = this.f31881OooO0o0;
            float f210 = this.OooOooO;
            float f211 = 2;
            float f212 = this.f31887OooOoo0 / f211;
            rectF3.left = f210 + f212;
            rectF3.right = this.f31888OooOooo - f212;
            this.f31879OooO0Oo.arcTo(rectF3, 90.0f, 180.0f);
            RectF rectF4 = this.f31881OooO0o0;
            float f213 = this.OooOooO;
            float f214 = interpolation2 * this.OooOoO;
            float f215 = this.f31887OooOoo0 / f211;
            rectF4.left = f213 + f214 + f215;
            rectF4.right = (f214 + this.f31888OooOooo) - f215;
            this.f31879OooO0Oo.arcTo(rectF4, 270.0f, 180.0f);
            this.f31879OooO0Oo.close();
            if (this.OooOOO) {
                this.OooO0O0.setStyle(style);
                this.OooO0O0.setShader(this.f31882OooO0oo);
                canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
                this.OooO0O0.setShader(null);
            }
            canvas.translate(0.0f, -this.Oooo0O0);
            float f216 = this.f31886OooOoo / f211;
            canvas.scale(0.98f, 0.98f, f216, f216);
            this.OooO0O0.setStyle(style);
            this.OooO0O0.setColor(Color.parseColor("#FFFFFF"));
            canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
            this.OooO0O0.setStyle(Paint.Style.STROKE);
            this.OooO0O0.setStrokeWidth(this.f31887OooOoo0 * 0.5f);
            Paint paint3 = this.OooO0O0;
            if (z11) {
                i12 = this.OooOOo0;
            } else {
                i12 = this.OooOOo;
            }
            paint3.setColor(i12);
            canvas.drawPath(this.f31879OooO0Oo, this.OooO0O0);
            canvas.restore();
            this.OooO0O0.reset();
            if (this.f31880OooO0o <= 0.0f) {
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (getResources().getDimension(R$dimen.mini_dp_56) + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i12 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + ((int) (View.MeasureSpec.getSize(i11) * this.f31878OooO)), 1073741824);
        }
        setMeasuredDimension(i11, i12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.e(parcelable, "null cannot be cast to non-null type com.cloud.tmc.miniapp.widget.SwitchButton.SavedState");
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z11 = savedState.OooO00o;
        this.OooOOOO = z11;
        this.f31884OooOO0o = z11 ? 3 : 1;
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.OooO00o = this.OooOOOO;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        boolean z11;
        int paddingLeft;
        int width;
        int paddingTop;
        int height;
        if (i11 > getPaddingRight() + getPaddingLeft()) {
            if (i12 > getPaddingBottom() + getPaddingTop()) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.OooOOO0 = z11;
        if (z11) {
            int paddingLeft2 = (i11 - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (i12 - getPaddingTop()) - getPaddingBottom();
            float f11 = paddingLeft2;
            float f12 = this.f31878OooO;
            float f13 = paddingTop2;
            if (f11 * f12 < f13) {
                paddingLeft = getPaddingLeft();
                width = i11 - getPaddingRight();
                int i15 = ((int) (f13 - (f11 * this.f31878OooO))) / 2;
                paddingTop = getPaddingTop() + i15;
                height = (getHeight() - getPaddingBottom()) - i15;
            } else {
                int i16 = ((int) (f11 - (f13 / f12))) / 2;
                paddingLeft = getPaddingLeft() + i16;
                width = (getWidth() - getPaddingRight()) - i16;
                paddingTop = getPaddingTop();
                height = getHeight() - getPaddingBottom();
            }
            float f14 = (int) ((height - paddingTop) * 0.07f);
            this.Oooo0O0 = f14;
            float f15 = paddingLeft;
            float f16 = paddingTop + f14;
            float f17 = width;
            this.OooOo0O = f17;
            float f18 = height - f14;
            float f19 = f18 - f16;
            float f21 = 2;
            this.OooOo0o = (f17 + f15) / f21;
            float f22 = (f18 + f16) / f21;
            this.OooOo = f22;
            this.OooOooO = f15;
            this.f31886OooOoo = f19;
            float f23 = f15 + f19;
            this.f31888OooOooo = f23;
            float f24 = f19 / f21;
            float f25 = 0.95f * f24;
            this.f31885OooOoOO = f25;
            float f26 = 0.2f * f25;
            this.OooOoO = f26;
            float f27 = (f24 - f25) * f21;
            this.f31887OooOoo0 = f27;
            float f28 = f17 - f19;
            this.Oooo000 = f28;
            this.f31889Oooo00O = f28 - f26;
            this.Oooo0 = f15;
            this.f31890Oooo00o = f26 + f15;
            this.OooOoO0 = 1 - (f27 / f19);
            this.OooO0OO.reset();
            RectF rectF = new RectF();
            rectF.top = f16;
            rectF.bottom = f18;
            rectF.left = f15;
            rectF.right = f23;
            this.OooO0OO.arcTo(rectF, 90.0f, 180.0f);
            float f29 = this.OooOo0O;
            rectF.left = f29 - f19;
            rectF.right = f29;
            this.OooO0OO.arcTo(rectF, 270.0f, 180.0f);
            this.OooO0OO.close();
            RectF rectF2 = this.f31881OooO0o0;
            float f31 = this.OooOooO;
            rectF2.left = f31;
            float f32 = this.f31888OooOooo;
            rectF2.right = f32;
            float f33 = this.f31887OooOoo0 / f21;
            rectF2.top = f16 + f33;
            rectF2.bottom = f18 - f33;
            float f34 = (f32 + f31) / f21;
            int i17 = this.OooOo00;
            int i18 = (i17 >> 16) & 255;
            int i19 = (i17 >> 8) & 255;
            int i21 = i17 & 255;
            this.f31882OooO0oo = new RadialGradient(f34, f22, this.f31885OooOoOO, Color.argb(200, i18, i19, i21), Color.argb(25, i18, i19, i21), Shader.TileMode.CLAMP);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i11;
        Intrinsics.g(event, "event");
        super.onTouchEvent(event);
        if (isEnabled() && (((i11 = this.f31884OooOO0o) == 3 || i11 == 1) && this.f31880OooO0o * this.OooO0oO == 0.0f && event.getAction() == 1)) {
            int i12 = this.f31884OooOO0o;
            this.OooOO0O = i12;
            this.OooO0oO = 1.0f;
            if (i12 == 1) {
                OooO00o(this, true, false, false, 4);
            } else if (i12 == 3) {
                OooO00o(this, false, false, false, 4);
            }
        }
        return true;
    }

    public final void setChecked(boolean z11) {
        OooO00o(this, z11, true, false, 4);
    }

    public final void setOnCheckedChangeListener(a aVar) {
    }

    public final void setShadow(boolean z11) {
        this.OooOOO = z11;
        invalidate();
    }
}
