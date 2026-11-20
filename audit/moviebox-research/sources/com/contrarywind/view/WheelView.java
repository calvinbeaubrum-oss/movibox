package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.contrarywind.timer.InertiaTimerTask;
import com.contrarywind.timer.SmoothScrollTimerTask;
import com.google.android.material.timepicker.TimeModel;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import ue.a;
import we.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WheelView extends View {
    public boolean A;
    public float B;
    public float C;
    public float D;
    public float E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public float O;
    public long P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public float U;
    public final float V;
    public final ArrayList<String> W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DividerType f32304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f32305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f32306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GestureDetector f32307d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f32308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f32309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f32310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f32311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ScheduledFuture<?> f32312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f32313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Paint f32314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f32315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f32316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f32317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Boolean f32318p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f32319q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f32320r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f32321s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f32322t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f32323u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f32324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f32325w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f32326x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f32327y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f32328z;

    /* JADX INFO: compiled from: source.java */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* JADX INFO: compiled from: source.java */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32309g = false;
        this.f32310h = true;
        this.f32311i = Executors.newSingleThreadScheduledExecutor();
        this.f32318p = Boolean.FALSE;
        this.f32324v = Typeface.MONOSPACE;
        this.f32328z = 4.0f;
        this.J = 5;
        this.N = 0;
        this.O = 0.0f;
        this.P = 0L;
        this.R = 17;
        this.S = 0;
        this.T = 0;
        this.V = 0.5f;
        this.W = new ArrayList<String>() { // from class: com.contrarywind.view.WheelView.2
            {
                add("Jan");
                add("Feb");
                add("Mar");
                add("Apr");
                add("May");
                add("June");
                add("July");
                add("Aug");
                add("Sept");
                add("Oct");
                add("Nov");
                add("Dec");
            }
        };
        this.f32319q = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f11 = getResources().getDisplayMetrics().density;
        if (f11 < 1.0f) {
            this.U = 2.4f;
        } else if (1.0f <= f11 && f11 < 2.0f) {
            this.U = 3.6f;
        } else if (1.0f <= f11 && f11 < 2.0f) {
            this.U = 4.5f;
        } else if (2.0f <= f11 && f11 < 3.0f) {
            this.U = 6.0f;
        } else if (f11 >= 3.0f) {
            this.U = f11 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.R = typedArrayObtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.f32325w = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, FlowLayout.SPACING_AUTO);
            this.f32326x = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -16711936);
            this.f32327y = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, 855638016);
            this.f32319q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.f32319q);
            this.f32328z = typedArrayObtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.f32328z);
            typedArrayObtainStyledAttributes.recycle();
        }
        h();
        f(context);
    }

    public final String b(int i11) {
        try {
            return this.W.get(i11 - 1);
        } catch (Exception unused) {
            return String.valueOf(i11);
        }
    }

    public final String c(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof ve.a) {
            return ((ve.a) obj).a();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.f32312j;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f32312j.cancel(true);
        this.f32312j = null;
    }

    public final int d(int i11) {
        if (i11 < 0) {
            return d(i11 + this.f32316n.a());
        }
        return i11 > this.f32316n.a() + (-1) ? d(i11 - this.f32316n.a()) : i11;
    }

    public final String e(String str) {
        try {
            int i11 = Integer.parseInt(str);
            return i11 > 12 ? str : b(i11);
        } catch (Exception unused) {
            return str;
        }
    }

    public final void f(Context context) {
        this.f32305b = context;
        this.f32306c = new xe.a(this);
        GestureDetector gestureDetector = new GestureDetector(context, new we.a(this));
        this.f32307d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.A = true;
        this.E = 0.0f;
        this.F = -1;
        g();
    }

    public final void g() {
        Paint paint = new Paint();
        this.f32313k = paint;
        paint.setColor(this.f32325w);
        this.f32313k.setAntiAlias(true);
        this.f32313k.setTypeface(this.f32324v);
        this.f32313k.setTextSize(this.f32319q);
        Paint paint2 = new Paint();
        this.f32314l = paint2;
        paint2.setColor(this.f32326x);
        this.f32314l.setAntiAlias(true);
        this.f32314l.setTextScaleX(1.1f);
        this.f32314l.setTypeface(this.f32324v);
        this.f32314l.setTextSize(this.f32319q);
        Paint paint3 = new Paint();
        this.f32315m = paint3;
        paint3.setColor(this.f32327y);
        this.f32315m.setAntiAlias(true);
        setLayerType(1, null);
    }

    public final a getAdapter() {
        return this.f32316n;
    }

    public final int getCurrentItem() {
        int i11;
        a aVar = this.f32316n;
        if (aVar == null) {
            return 0;
        }
        return (!this.A || ((i11 = this.G) >= 0 && i11 < aVar.a())) ? Math.max(0, Math.min(this.G, this.f32316n.a() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.G) - this.f32316n.a()), this.f32316n.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.f32306c;
    }

    public int getInitPosition() {
        return this.F;
    }

    public float getItemHeight() {
        return this.f32323u;
    }

    public int getItemsCount() {
        a aVar = this.f32316n;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public int getTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int iCeil = 0;
        for (int i11 = 0; i11 < length; i11++) {
            iCeil += (int) Math.ceil(fArr[i11]);
        }
        return iCeil;
    }

    public float getTotalScrollY() {
        return this.E;
    }

    public final void h() {
        float f11 = this.f32328z;
        if (f11 < 1.0f) {
            this.f32328z = 1.0f;
        } else if (f11 > 4.0f) {
            this.f32328z = 4.0f;
        }
    }

    public final void i() {
        Rect rect = new Rect();
        for (int i11 = 0; i11 < this.f32316n.a(); i11++) {
            String strC = c(this.f32316n.getItem(i11));
            this.f32314l.getTextBounds(strC, 0, strC.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f32320r) {
                this.f32320r = iWidth;
            }
            this.f32314l.getTextBounds("星期", 0, 2, rect);
            this.f32321s = rect.height() + 2;
        }
        this.f32323u = this.f32321s * 3;
    }

    public void isCenterLabel(boolean z11) {
        this.f32310h = z11;
    }

    public boolean isLoop() {
        return this.A;
    }

    public final void j(String str) {
        String str2;
        Rect rect = new Rect();
        this.f32314l.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.R;
        if (i11 == 3) {
            this.S = 0;
            return;
        }
        if (i11 == 5) {
            this.S = (this.L - rect.width()) - ((int) this.U);
            return;
        }
        if (i11 != 17) {
            return;
        }
        if (this.f32309g || (str2 = this.f32317o) == null || str2.equals("") || !this.f32310h) {
            this.S = (int) (((double) (this.L - rect.width())) * 0.5d);
        } else {
            this.S = (int) (((double) (this.L - rect.width())) * 0.25d);
        }
    }

    public final void k(String str) {
        String str2;
        Rect rect = new Rect();
        this.f32313k.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.R;
        if (i11 == 3) {
            this.T = 0;
            return;
        }
        if (i11 == 5) {
            this.T = (this.L - rect.width()) - ((int) this.U);
            return;
        }
        if (i11 != 17) {
            return;
        }
        if (this.f32309g || (str2 = this.f32317o) == null || str2.equals("") || !this.f32310h) {
            this.T = (int) (((double) (this.L - rect.width())) * 0.5d);
        } else {
            this.T = (int) (((double) (this.L - rect.width())) * 0.25d);
        }
    }

    public final void l(String str) {
        Rect rect = new Rect();
        this.f32314l.getTextBounds(str, 0, str.length(), rect);
        int i11 = this.f32319q;
        for (int iWidth = rect.width(); iWidth > this.L; iWidth = rect.width()) {
            i11--;
            this.f32314l.setTextSize(i11);
            this.f32314l.getTextBounds(str, 0, str.length(), rect);
        }
        this.f32313k.setTextSize(i11);
    }

    public final void m() {
        if (this.f32316n == null) {
            return;
        }
        i();
        int i11 = (int) (this.f32323u * (this.J - 1));
        this.K = (int) (((double) (i11 * 2)) / 3.141592653589793d);
        this.M = (int) (((double) i11) / 3.141592653589793d);
        this.L = View.MeasureSpec.getSize(this.Q);
        int i12 = this.K;
        float f11 = this.f32323u;
        this.B = (i12 - f11) / 2.0f;
        float f12 = (i12 + f11) / 2.0f;
        this.C = f12;
        this.D = (f12 - ((f11 - this.f32321s) / 2.0f)) - this.U;
        if (this.F == -1) {
            if (this.A) {
                this.F = (this.f32316n.a() + 1) / 2;
            } else {
                this.F = 0;
            }
        }
        this.H = this.F;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i11;
        float f11;
        int i12;
        if (this.f32316n == null) {
            return;
        }
        int iMin = Math.min(Math.max(0, this.F), this.f32316n.a() - 1);
        this.F = iMin;
        Object[] objArr = new Object[this.J];
        int i13 = (int) (this.E / this.f32323u);
        this.I = i13;
        try {
            this.H = iMin + (i13 % this.f32316n.a());
            while (true) {
                int i14 = this.J;
                if (i11 >= i14) {
                    break;
                }
                int i15 = this.H - ((i14 / 2) - i11);
                if (this.A) {
                    objArr[i11] = this.f32316n.getItem(d(i15));
                } else if (i15 < 0) {
                    objArr[i11] = "";
                } else if (i15 > this.f32316n.a() - 1) {
                    objArr[i11] = "";
                } else {
                    objArr[i11] = this.f32316n.getItem(i15);
                }
                i11++;
            }
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.A) {
            if (this.H < 0) {
                this.H = this.f32316n.a() + this.H;
            }
            if (this.H > this.f32316n.a() - 1) {
                this.H -= this.f32316n.a();
            }
        } else {
            if (this.H < 0) {
                this.H = 0;
            }
            if (this.H > this.f32316n.a() - 1) {
                this.H = this.f32316n.a() - 1;
            }
        }
        float f12 = this.E % this.f32323u;
        i11 = 0;
        if (this.f32304a == DividerType.WRAP) {
            float f13 = (TextUtils.isEmpty(this.f32317o) ? (this.L - this.f32320r) / 2 : (this.L - this.f32320r) / 4) - 12;
            float f14 = f13 <= 0.0f ? 10.0f : f13;
            float f15 = this.L - f14;
            float f16 = this.B;
            float f17 = f14;
            canvas.drawLine(f17, f16, f15, f16, this.f32315m);
            float f18 = this.C;
            canvas.drawLine(f17, f18, f15, f18, this.f32315m);
        } else {
            float f19 = this.B;
            canvas.drawLine(0.0f, f19, this.L, f19, this.f32315m);
            float f21 = this.C;
            canvas.drawLine(0.0f, f21, this.L, f21, this.f32315m);
        }
        if (!TextUtils.isEmpty(this.f32317o) && this.f32310h) {
            canvas.drawText(this.f32317o, (this.L - getTextWidth(this.f32314l, this.f32317o)) - this.U, this.D, this.f32314l);
        }
        for (int i16 = 0; i16 < this.J; i16++) {
            canvas.save();
            double d11 = ((this.f32323u * i16) - f12) / this.M;
            float f22 = (float) (90.0d - ((d11 / 3.141592653589793d) * 180.0d));
            if (f22 >= 90.0f || f22 <= -90.0f) {
                canvas.restore();
            } else {
                float fPow = (float) Math.pow(Math.abs(f22) / 90.0f, 2.2d);
                String strC = (this.f32310h || TextUtils.isEmpty(this.f32317o) || TextUtils.isEmpty(c(objArr[i16]))) ? c(objArr[i16]) : c(objArr[i16]) + this.f32317o;
                if (this.f32318p.booleanValue()) {
                    strC = e(strC);
                }
                l(strC);
                j(strC);
                k(strC);
                float fCos = (float) ((((double) this.M) - (Math.cos(d11) * ((double) this.M))) - ((Math.sin(d11) * ((double) this.f32321s)) / 2.0d));
                canvas.translate(0.0f, fCos);
                float f23 = this.B;
                if (fCos > f23 || this.f32321s + fCos < f23) {
                    float f24 = this.C;
                    if (fCos > f24 || this.f32321s + fCos < f24) {
                        if (fCos >= f23) {
                            int i17 = this.f32321s;
                            if (i17 + fCos <= f24) {
                                canvas.drawText(strC, this.S, i17 - this.U, this.f32314l);
                                this.G = this.H - ((this.J / 2) - i16);
                            }
                            canvas.restore();
                            this.f32314l.setTextSize(this.f32319q);
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.L, (int) this.f32323u);
                        canvas.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                        Paint paint = this.f32313k;
                        int i18 = this.f32322t;
                        if (i18 == 0) {
                            f11 = 0.0f;
                            i12 = 0;
                        } else if (i18 > 0) {
                            f11 = 0.0f;
                            i12 = 1;
                        } else {
                            f11 = 0.0f;
                            i12 = -1;
                        }
                        paint.setTextSkewX(i12 * (f22 <= f11 ? 1 : -1) * 0.5f * fPow);
                        this.f32313k.setAlpha((int) ((1.0f - fPow) * 255.0f));
                        canvas.drawText(strC, this.T + (this.f32322t * fPow), this.f32321s, this.f32313k);
                        canvas.restore();
                        canvas.restore();
                        this.f32314l.setTextSize(this.f32319q);
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.L, this.C - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                        canvas.drawText(strC, this.S, this.f32321s - this.U, this.f32314l);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.C - fCos, this.L, (int) this.f32323u);
                        canvas.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                        canvas.drawText(strC, this.T, this.f32321s, this.f32313k);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.L, this.B - fCos);
                    canvas.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                    canvas.drawText(strC, this.T, this.f32321s, this.f32313k);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.B - fCos, this.L, (int) this.f32323u);
                    canvas.scale(1.0f, ((float) Math.sin(d11)) * 1.0f);
                    canvas.drawText(strC, this.S, this.f32321s - this.U, this.f32314l);
                    canvas.restore();
                }
                canvas.restore();
                this.f32314l.setTextSize(this.f32319q);
            }
        }
    }

    public final void onItemSelected() {
        if (this.f32308f != null) {
            postDelayed(new Runnable() { // from class: com.contrarywind.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.f32308f.a(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        this.Q = i11;
        m();
        setMeasuredDimension(this.L, this.K);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.f32307d.onTouchEvent(motionEvent);
        float f11 = (-this.F) * this.f32323u;
        float fA = ((this.f32316n.a() - 1) - this.F) * this.f32323u;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.P = System.currentTimeMillis();
            cancelFuture();
            this.O = motionEvent.getRawY();
        } else {
            if (action == 2) {
                float rawY = this.O - motionEvent.getRawY();
                this.O = motionEvent.getRawY();
                float f12 = this.E + rawY;
                this.E = f12;
                if (!this.A) {
                    float f13 = this.f32323u;
                    if ((f12 - (f13 * 0.25f) < f11 && rawY < 0.0f) || ((f13 * 0.25f) + f12 > fA && rawY > 0.0f)) {
                        this.E = f12 - rawY;
                    }
                }
                return true;
            }
            if (!zOnTouchEvent) {
                float y11 = motionEvent.getY();
                int i11 = this.M;
                double dAcos = Math.acos((i11 - y11) / i11) * ((double) this.M);
                float f14 = this.f32323u;
                this.N = (int) (((((int) ((dAcos + ((double) (f14 / 2.0f))) / ((double) f14))) - (this.J / 2)) * f14) - (((this.E % f14) + f14) % f14));
                if (System.currentTimeMillis() - this.P > 120) {
                    smoothScroll(ACTION.DAGGLE);
                } else {
                    smoothScroll(ACTION.CLICK);
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void scrollBy(float f11) {
        cancelFuture();
        this.f32312j = this.f32311i.scheduleWithFixedDelay(new InertiaTimerTask(this, f11), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(a aVar) {
        this.f32316n = aVar;
        m();
        invalidate();
    }

    public void setConvertMonth(boolean z11) {
        this.f32318p = Boolean.valueOf(z11);
    }

    public final void setCurrentItem(int i11) {
        this.G = i11;
        this.F = i11;
        this.E = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z11) {
        this.A = z11;
    }

    public void setDividerColor(int i11) {
        this.f32327y = i11;
        this.f32315m.setColor(i11);
    }

    public void setDividerType(DividerType dividerType) {
        this.f32304a = dividerType;
    }

    public void setGravity(int i11) {
        this.R = i11;
    }

    public void setIsOptions(boolean z11) {
        this.f32309g = z11;
    }

    public void setLabel(String str) {
        this.f32317o = str;
    }

    public void setLineSpacingMultiplier(float f11) {
        if (f11 != 0.0f) {
            this.f32328z = f11;
            h();
        }
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.f32308f = bVar;
    }

    public void setTextColorCenter(int i11) {
        this.f32326x = i11;
        this.f32314l.setColor(i11);
    }

    public void setTextColorOut(int i11) {
        this.f32325w = i11;
        this.f32313k.setColor(i11);
    }

    public final void setTextSize(float f11) {
        if (f11 > 0.0f) {
            int i11 = (int) (this.f32305b.getResources().getDisplayMetrics().density * f11);
            this.f32319q = i11;
            this.f32313k.setTextSize(i11);
            this.f32314l.setTextSize(this.f32319q);
        }
    }

    public void setTextXOffset(int i11) {
        this.f32322t = i11;
        if (i11 != 0) {
            this.f32314l.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f11) {
        this.E = f11;
    }

    public final void setTypeface(Typeface typeface) {
        this.f32324v = typeface;
        this.f32313k.setTypeface(typeface);
        this.f32314l.setTypeface(this.f32324v);
    }

    public void smoothScroll(ACTION action) {
        cancelFuture();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f11 = this.E;
            float f12 = this.f32323u;
            int i11 = (int) (((f11 % f12) + f12) % f12);
            this.N = i11;
            if (i11 > f12 / 2.0f) {
                this.N = (int) (f12 - i11);
            } else {
                this.N = -i11;
            }
        }
        this.f32312j = this.f32311i.scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.N), 0L, 10L, TimeUnit.MILLISECONDS);
    }
}
