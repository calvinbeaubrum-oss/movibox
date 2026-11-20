package p014OoooO0O;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.R$styleable;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import hd.j;
import o000oOoO.OooO00o;
import p0.h;
import p0.i;
import p015OoooOOO.o0000O;
import p016OoooOOo.o000O0o;
import p016OoooOOo.o000Oo0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
public class OooOOO0 extends ViewGroup implements i, NestedScrollingParent {
    public static p0.a o00000O;
    public static p0.b o00000OO;
    public static p0.c o00000Oo;
    public static ViewGroup.MarginLayoutParams o00000o0 = new ViewGroup.MarginLayoutParams(-1, -1);

    /* JADX INFO: renamed from: OooO, reason: collision with root package name */
    public float f280OooO;
    public int OooO00o;
    public int OooO0O0;
    public int OooO0OO;

    /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
    public int f281OooO0Oo;

    /* JADX INFO: renamed from: OooO0o, reason: collision with root package name */
    public int f282OooO0o;

    /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
    public int f283OooO0o0;
    public int OooO0oO;

    /* JADX INFO: renamed from: OooO0oo, reason: collision with root package name */
    public float f284OooO0oo;

    /* JADX INFO: renamed from: OooOO0, reason: collision with root package name */
    public float f285OooOO0;
    public float OooOO0O;

    /* JADX INFO: renamed from: OooOO0o, reason: collision with root package name */
    public float f286OooOO0o;
    public float OooOOO;
    public float OooOOO0;
    public char OooOOOO;
    public boolean OooOOOo;
    public boolean OooOOo;
    public boolean OooOOo0;
    public int OooOOoo;
    public int OooOo;
    public int OooOo0;
    public int OooOo00;
    public int OooOo0O;
    public int OooOo0o;
    public Scroller OooOoO;
    public int OooOoO0;

    /* JADX INFO: renamed from: OooOoOO, reason: collision with root package name */
    public VelocityTracker f287OooOoOO;

    /* JADX INFO: renamed from: OooOoo, reason: collision with root package name */
    public int[] f288OooOoo;

    /* JADX INFO: renamed from: OooOoo0, reason: collision with root package name */
    public Interpolator f289OooOoo0;
    public boolean OooOooO;

    /* JADX INFO: renamed from: OooOooo, reason: collision with root package name */
    public boolean f290OooOooo;
    public boolean Oooo;
    public boolean Oooo0;
    public boolean Oooo000;

    /* JADX INFO: renamed from: Oooo00O, reason: collision with root package name */
    public boolean f291Oooo00O;

    /* JADX INFO: renamed from: Oooo00o, reason: collision with root package name */
    public boolean f292Oooo00o;
    public boolean Oooo0O0;
    public boolean Oooo0OO;
    public boolean Oooo0o;
    public boolean Oooo0o0;

    /* JADX INFO: renamed from: Oooo0oO, reason: collision with root package name */
    public boolean f293Oooo0oO;
    public boolean Oooo0oo;
    public boolean OoooO;

    /* JADX INFO: renamed from: OoooO0, reason: collision with root package name */
    public boolean f294OoooO0;

    /* JADX INFO: renamed from: OoooO00, reason: collision with root package name */
    public boolean f295OoooO00;

    /* JADX INFO: renamed from: OoooO0O, reason: collision with root package name */
    public boolean f296OoooO0O;
    public boolean OoooOO0;

    /* JADX INFO: renamed from: OoooOOO, reason: collision with root package name */
    public boolean f297OoooOOO;

    /* JADX INFO: renamed from: OoooOOo, reason: collision with root package name */
    public boolean f298OoooOOo;

    /* JADX INFO: renamed from: OoooOo0, reason: collision with root package name */
    public boolean f299OoooOo0;
    public boolean OoooOoO;
    public w0.c OoooOoo;
    public w0.b Ooooo00;
    public int Ooooo0o;
    public boolean OooooO0;
    public int[] OooooOO;
    public NestedScrollingChildHelper OooooOo;
    public int Oooooo;
    public NestedScrollingParentHelper Oooooo0;
    public s0.a OoooooO;
    public int Ooooooo;
    public Runnable o00000;
    public boolean o000000;
    public boolean o000000O;
    public MotionEvent o000000o;
    public ValueAnimator o00000O0;
    public boolean o000OOo;

    /* JADX INFO: renamed from: o000oOoO, reason: collision with root package name */
    public boolean f300o000oOoO;
    public int o00O0O;
    public float o00Oo0;
    public float o00Ooo;
    public float o00o0O;
    public p0.d o00oO0O;
    public p0.g o00oO0o;
    public float o00ooo;
    public int o0O0O00;
    public long o0OO00O;
    public MiniRefreshState o0OOO0o;
    public MiniRefreshState o0Oo0oo;
    public s0.a o0OoOo0;
    public Paint o0ooOO0;
    public Handler o0ooOOo;
    public h o0ooOoO;
    public p0.g oo000o;
    public int oo0o0Oo;
    public int ooOO;

    /* JADX INFO: compiled from: source.java */
    public class OooOO0 implements Runnable {
        public OooOO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OooOOO0 oooOOO0 = OooOOO0.this;
            w0.b bVar = oooOOO0.Ooooo00;
            if (bVar != null) {
                bVar.a(oooOOO0);
            } else {
                oooOOO0.OooO00o(2000, true, false);
            }
            OooOOO0.this.getClass();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class OooOO0O implements Runnable {
        public int OooO00o = 0;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ Boolean OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ boolean f301OooO0Oo;

        public OooOO0O(int i11, Boolean bool, boolean z11) {
            this.OooO0O0 = i11;
            this.OooO0OO = bool;
            this.f301OooO0Oo = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i11 = this.OooO00o;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA = null;
            if (i11 == 0) {
                OooOOO0 oooOOO0 = OooOOO0.this;
                MiniRefreshState miniRefreshState = oooOOO0.o0OOO0o;
                MiniRefreshState miniRefreshState2 = MiniRefreshState.NONE;
                if (miniRefreshState == miniRefreshState2 && oooOOO0.o0Oo0oo == MiniRefreshState.REFRESHING) {
                    oooOOO0.o0Oo0oo = miniRefreshState2;
                } else {
                    ValueAnimator valueAnimator = oooOOO0.o00000O0;
                    if (valueAnimator != null && miniRefreshState.isHeader && (miniRefreshState.isDragging || miniRefreshState == MiniRefreshState.REFRESH_RELEASED)) {
                        valueAnimator.setDuration(0L);
                        OooOOO0.this.o00000O0.cancel();
                        OooOOO0 oooOOO1 = OooOOO0.this;
                        oooOOO1.o00000O0 = null;
                        if (((g) oooOOO1.o0ooOoO).a(0) == null) {
                            OooOOO0.this.OooO00o(miniRefreshState2);
                        } else {
                            OooOOO0.this.OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
                        }
                    } else if (miniRefreshState == MiniRefreshState.REFRESHING && oooOOO0.oo000o != null && oooOOO0.o00oO0O != null) {
                        this.OooO00o = i11 + 1;
                        oooOOO0.o0ooOOo.postDelayed(this, this.OooO0O0);
                        OooOOO0.this.OooO00o(MiniRefreshState.REFRESH_FINISH);
                        if (this.OooO0OO == Boolean.FALSE) {
                            OooOOO0.this.OooO0O0(false);
                        }
                    }
                }
                if (this.OooO0OO == Boolean.TRUE) {
                    OooOOO0.this.OooO0O0(true);
                    return;
                }
                return;
            }
            OooOOO0 oooOOO2 = OooOOO0.this;
            int iOooO00o = oooOOO2.oo000o.OooO00o(oooOOO2, this.f301OooO0Oo);
            OooOOO0.this.getClass();
            if (iOooO00o < Integer.MAX_VALUE) {
                OooOOO0 oooOOO3 = OooOOO0.this;
                if (oooOOO3.OooOOOo || oooOOO3.OooooO0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    OooOOO0 oooOOO4 = OooOOO0.this;
                    if (oooOOO4.OooOOOo) {
                        float f11 = oooOOO4.OooOO0O;
                        oooOOO4.f280OooO = f11;
                        oooOOO4.f281OooO0Oo = 0;
                        oooOOO4.OooOOOo = false;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, oooOOO4.f285OooOO0, (f11 + oooOOO4.OooO0O0) - (oooOOO4.OooO00o * 2), 0));
                        OooOOO0 oooOOO5 = OooOOO0.this;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, oooOOO5.f285OooOO0, oooOOO5.OooOO0O + oooOOO5.OooO0O0, 0));
                    }
                    OooOOO0 oooOOO6 = OooOOO0.this;
                    if (oooOOO6.OooooO0) {
                        oooOOO6.Ooooo0o = 0;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, oooOOO6.f285OooOO0, oooOOO6.OooOO0O, 0));
                        OooOOO0 oooOOO7 = OooOOO0.this;
                        oooOOO7.OooooO0 = false;
                        oooOOO7.f281OooO0Oo = 0;
                    }
                }
                OooOOO0 oooOOO8 = OooOOO0.this;
                int i12 = oooOOO8.OooO0O0;
                if (i12 <= 0) {
                    if (i12 < 0) {
                        oooOOO8.OooO00o(0, iOooO00o, oooOOO8.f289OooOoo0, oooOOO8.f282OooO0o);
                        return;
                    }
                    ((g) oooOOO8.o0ooOoO).b(0, false);
                    ((g) OooOOO0.this.o0ooOoO).c(MiniRefreshState.NONE);
                    return;
                }
                ValueAnimator valueAnimatorOooO00o = oooOOO8.OooO00o(0, iOooO00o, oooOOO8.f289OooOoo0, oooOOO8.f282OooO0o);
                OooOOO0 oooOOO9 = OooOOO0.this;
                if (oooOOO9.f295OoooO00) {
                    animatorUpdateListenerA = ((u0.a) oooOOO9.o00oO0O).a(oooOOO9.OooO0O0);
                }
                if (valueAnimatorOooO00o == null || animatorUpdateListenerA == null) {
                    return;
                }
                valueAnimatorOooO00o.addUpdateListener(animatorUpdateListenerA);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class OooOOO implements Runnable {
        public int OooO0O0;

        /* JADX INFO: renamed from: OooO0o0, reason: collision with root package name */
        public float f305OooO0o0;
        public int OooO00o = 0;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public float f303OooO0Oo = 0.0f;
        public long OooO0OO = AnimationUtils.currentAnimationTimeMillis();

        public OooOOO(float f11, int i11) {
            this.f305OooO0o0 = f11;
            this.OooO0O0 = i11;
            OooOOO0.this.o0ooOOo.postDelayed(this, 10);
            if (f11 > 0.0f) {
                ((g) OooOOO0.this.o0ooOoO).c(MiniRefreshState.PULL_DOWN_TO_REFRESH);
            } else {
                ((g) OooOOO0.this.o0ooOoO).c(MiniRefreshState.PULL_UP_TO_LOAD);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            OooOOO0 oooOOO0 = OooOOO0.this;
            if (oooOOO0.o00000 != this || oooOOO0.o0OOO0o.isFinishing) {
                return;
            }
            if (Math.abs(oooOOO0.OooO0O0) < Math.abs(this.OooO0O0)) {
                double d11 = this.f305OooO0o0;
                int i11 = this.OooO00o + 1;
                this.OooO00o = i11;
                this.f305OooO0o0 = (float) (Math.pow(0.949999988079071d, ((double) i11) * 2.0d) * d11);
            } else if (this.OooO0O0 != 0) {
                double d12 = this.f305OooO0o0;
                int i12 = this.OooO00o + 1;
                this.OooO00o = i12;
                this.f305OooO0o0 = (float) (Math.pow(0.44999998807907104d, ((double) i12) * 2.0d) * d12);
            } else {
                double d13 = this.f305OooO0o0;
                int i13 = this.OooO00o + 1;
                this.OooO00o = i13;
                this.f305OooO0o0 = (float) (Math.pow(0.8500000238418579d, ((double) i13) * 2.0d) * d13);
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f11 = this.f305OooO0o0 * (((jCurrentAnimationTimeMillis - this.OooO0OO) * 1.0f) / 1000.0f);
            if (Math.abs(f11) >= 1.0f) {
                this.OooO0OO = jCurrentAnimationTimeMillis;
                float f12 = this.f303OooO0Oo + f11;
                this.f303OooO0Oo = f12;
                OooOOO0.this.OooO00o(f12);
                OooOOO0.this.o0ooOOo.postDelayed(this, 10);
                return;
            }
            OooOOO0 oooOOO1 = OooOOO0.this;
            MiniRefreshState miniRefreshState = oooOOO1.o0Oo0oo;
            boolean z11 = miniRefreshState.isDragging;
            if (z11 && miniRefreshState.isHeader) {
                ((g) oooOOO1.o0ooOoO).c(MiniRefreshState.PULL_DOWN_CANCELED);
            } else if (z11 && miniRefreshState.isFooter) {
                ((g) oooOOO1.o0ooOoO).c(MiniRefreshState.PULL_UP_CANCELED);
            }
            OooOOO0 oooOOO2 = OooOOO0.this;
            oooOOO2.o00000 = null;
            if (Math.abs(oooOOO2.OooO0O0) >= Math.abs(this.OooO0O0)) {
                int iMin = Math.min(Math.max((int) (Math.abs(OooOOO0.this.OooO0O0 - this.OooO0O0) / x0.b.f79782b), 30), 100) * 10;
                OooOOO0 oooOOO3 = OooOOO0.this;
                oooOOO3.OooO00o(this.OooO0O0, 0, oooOOO3.f289OooOoo0, iMin);
            }
        }
    }

    /* JADX INFO: renamed from: OoooO0O.OooOOO0$OooOOO0, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0013OooOOO0 implements Runnable {
        public int OooO00o = 0;
        public final /* synthetic */ int OooO0O0;
        public final /* synthetic */ boolean OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ boolean f306OooO0Oo;

        /* JADX INFO: renamed from: OoooO0O.OooOOO0$OooOOO0$OooO00o */
        /* JADX INFO: compiled from: source.java */
        public class OooO00o implements Runnable {
            public final /* synthetic */ int OooO00o;

            /* JADX INFO: renamed from: OoooO0O.OooOOO0$OooOOO0$OooO00o$a */
            /* JADX INFO: compiled from: source.java */
            public class a extends AnimatorListenerAdapter {
                public a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator == null || animator.getDuration() != 0) {
                        RunnableC0013OooOOO0 runnableC0013OooOOO0 = RunnableC0013OooOOO0.this;
                        OooOOO0 oooOOO0 = OooOOO0.this;
                        oooOOO0.o000000 = false;
                        if (runnableC0013OooOOO0.OooO0OO) {
                            oooOOO0.OooO0O0(true);
                        }
                        OooOOO0 oooOOO1 = OooOOO0.this;
                        if (oooOOO1.o0OOO0o == MiniRefreshState.LOAD_FINISH) {
                            oooOOO1.OooO00o(MiniRefreshState.NONE);
                        }
                    }
                }
            }

            public OooO00o(int i11) {
                this.OooO00o = i11;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA;
                ValueAnimator valueAnimatorA;
                OooOOO0 oooOOO0 = OooOOO0.this;
                if (!oooOOO0.Oooo || this.OooO00o >= 0) {
                    animatorUpdateListenerA = null;
                } else {
                    animatorUpdateListenerA = ((u0.a) oooOOO0.o00oO0O).a(oooOOO0.OooO0O0);
                    if (animatorUpdateListenerA != null) {
                        ((u0.a) animatorUpdateListenerA).onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                a aVar = new a();
                RunnableC0013OooOOO0 runnableC0013OooOOO0 = RunnableC0013OooOOO0.this;
                OooOOO0 oooOOO1 = OooOOO0.this;
                int i11 = oooOOO1.OooO0O0;
                if (i11 > 0) {
                    valueAnimatorA = ((g) oooOOO1.o0ooOoO).a(0);
                } else {
                    if (animatorUpdateListenerA != null || i11 == 0) {
                        ValueAnimator valueAnimator = oooOOO1.o00000O0;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            OooOOO0.this.o00000O0.cancel();
                            OooOOO0.this.o00000O0 = null;
                        }
                        ((g) OooOOO0.this.o0ooOoO).b(0, false);
                        ((g) OooOOO0.this.o0ooOoO).c(MiniRefreshState.NONE);
                    } else if (runnableC0013OooOOO0.OooO0OO && oooOOO1.Oooo0O0) {
                        int i12 = -oooOOO1.Ooooooo;
                        if (i11 >= i12) {
                            oooOOO1.OooO00o(MiniRefreshState.NONE);
                        } else {
                            valueAnimatorA = ((g) oooOOO1.o0ooOoO).a(i12);
                        }
                    } else {
                        valueAnimatorA = ((g) oooOOO1.o0ooOoO).a(0);
                    }
                    valueAnimatorA = null;
                }
                if (valueAnimatorA != null) {
                    valueAnimatorA.addListener(aVar);
                } else {
                    aVar.onAnimationEnd(null);
                }
            }
        }

        public RunnableC0013OooOOO0(int i11, boolean z11, boolean z12) {
            this.OooO0O0 = i11;
            this.OooO0OO = z11;
            this.f306OooO0Oo = z12;
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00a9  */
        @Override // java.lang.Runnable
        public void run() {
            boolean z11;
            int i11 = this.OooO00o;
            if (i11 == 0) {
                OooOOO0 oooOOO0 = OooOOO0.this;
                MiniRefreshState miniRefreshState = oooOOO0.o0OOO0o;
                MiniRefreshState miniRefreshState2 = MiniRefreshState.NONE;
                if (miniRefreshState == miniRefreshState2 && oooOOO0.o0Oo0oo == MiniRefreshState.LOADING) {
                    oooOOO0.o0Oo0oo = miniRefreshState2;
                } else {
                    ValueAnimator valueAnimator = oooOOO0.o00000O0;
                    if (valueAnimator != null && ((miniRefreshState.isDragging || miniRefreshState == MiniRefreshState.LOAD_RELEASED) && miniRefreshState.isFooter)) {
                        valueAnimator.setDuration(0L);
                        OooOOO0.this.o00000O0.cancel();
                        OooOOO0 oooOOO1 = OooOOO0.this;
                        oooOOO1.o00000O0 = null;
                        if (((g) oooOOO1.o0ooOoO).a(0) == null) {
                            OooOOO0.this.OooO00o(miniRefreshState2);
                        } else {
                            OooOOO0.this.OooO00o(MiniRefreshState.PULL_UP_CANCELED);
                        }
                    } else if (miniRefreshState == MiniRefreshState.LOADING && oooOOO0.o00oO0o != null && oooOOO0.o00oO0O != null) {
                        this.OooO00o = i11 + 1;
                        oooOOO0.o0ooOOo.postDelayed(this, this.OooO0O0);
                        OooOOO0.this.OooO00o(MiniRefreshState.LOAD_FINISH);
                        return;
                    }
                }
                if (this.OooO0OO) {
                    OooOOO0.this.OooO0O0(true);
                    return;
                }
                return;
            }
            OooOOO0 oooOOO2 = OooOOO0.this;
            int iOooO00o = oooOOO2.o00oO0o.OooO00o(oooOOO2, this.f306OooO0Oo);
            OooOOO0.this.getClass();
            if (iOooO00o < Integer.MAX_VALUE) {
                if (this.OooO0OO) {
                    OooOOO0 oooOOO3 = OooOOO0.this;
                    z11 = oooOOO3.Oooo0O0 && oooOOO3.OooO0O0 < 0 && ((u0.a) oooOOO3.o00oO0O).e();
                }
                OooOOO0 oooOOO4 = OooOOO0.this;
                int i12 = oooOOO4.OooO0O0;
                int iMax = i12 - (z11 ? Math.max(i12, -oooOOO4.Ooooooo) : 0);
                OooOOO0 oooOOO5 = OooOOO0.this;
                if (oooOOO5.OooOOOo || oooOOO5.OooooO0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    OooOOO0 oooOOO6 = OooOOO0.this;
                    if (oooOOO6.OooOOOo) {
                        float f11 = oooOOO6.OooOO0O;
                        oooOOO6.f280OooO = f11;
                        oooOOO6.f281OooO0Oo = oooOOO6.OooO0O0 - iMax;
                        oooOOO6.OooOOOo = false;
                        float f12 = oooOOO6.Oooo0 ? iMax : 0;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, oooOOO6.f285OooOO0, f11 + f12 + (oooOOO6.OooO00o * 2), 0));
                        OooOOO0 oooOOO7 = OooOOO0.this;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, oooOOO7.f285OooOO0, oooOOO7.OooOO0O + f12, 0));
                    }
                    OooOOO0 oooOOO8 = OooOOO0.this;
                    if (oooOOO8.OooooO0) {
                        oooOOO8.Ooooo0o = 0;
                        OooOOO0.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, oooOOO8.f285OooOO0, oooOOO8.OooOO0O, 0));
                        OooOOO0 oooOOO9 = OooOOO0.this;
                        oooOOO9.OooooO0 = false;
                        oooOOO9.f281OooO0Oo = 0;
                    }
                }
                OooOOO0 oooOOO10 = OooOOO0.this;
                oooOOO10.o0ooOOo.postDelayed(new OooO00o(iMax), oooOOO10.OooO0O0 < 0 ? iOooO00o : 0L);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class OooOOOO implements Runnable {
        public int OooO00o;
        public float OooO0O0;
        public long OooO0OO = 0;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public long f309OooO0Oo = AnimationUtils.currentAnimationTimeMillis();

        public OooOOOO(float f11) {
            this.OooO0O0 = f11;
            this.OooO00o = OooOOO0.this.OooO0O0;
        }

        @Override // java.lang.Runnable
        public void run() {
            OooOOO0 oooOOO0 = OooOOO0.this;
            if (oooOOO0.o00000 != this || oooOOO0.o0OOO0o.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j11 = jCurrentAnimationTimeMillis - this.f309OooO0Oo;
            float fPow = (float) (Math.pow(0.98f, (jCurrentAnimationTimeMillis - this.OooO0OO) / (1000.0f / 10)) * ((double) this.OooO0O0));
            this.OooO0O0 = fPow;
            float f11 = ((j11 * 1.0f) / 1000.0f) * fPow;
            if (Math.abs(f11) <= 1.0f) {
                OooOOO0.this.o00000 = null;
                return;
            }
            this.f309OooO0Oo = jCurrentAnimationTimeMillis;
            int i11 = (int) (this.OooO00o + f11);
            this.OooO00o = i11;
            OooOOO0 oooOOO1 = OooOOO0.this;
            if (oooOOO1.OooO0O0 * i11 > 0) {
                ((g) oooOOO1.o0ooOoO).b(i11, true);
                OooOOO0.this.o0ooOOo.postDelayed(this, 10);
                return;
            }
            oooOOO1.o00000 = null;
            ((g) oooOOO1.o0ooOoO).b(0, true);
            View view = ((u0.a) OooOOO0.this.o00oO0O).f78106c;
            int i12 = (int) (-this.OooO0O0);
            float f12 = x0.b.f79782b;
            if (view instanceof ScrollView) {
                ((ScrollView) view).fling(i12);
            } else if (view instanceof AbsListView) {
                ((AbsListView) view).fling(i12);
            } else if (view instanceof WebView) {
                ((WebView) view).flingScroll(0, i12);
            } else if (view instanceof NestedScrollView) {
                ((NestedScrollView) view).fling(i12);
            } else if (view instanceof RecyclerView) {
                ((RecyclerView) view).fling(0, i12);
            }
            OooOOO0 oooOOO2 = OooOOO0.this;
            if (!oooOOO2.o000000 || f11 <= 0.0f) {
                return;
            }
            oooOOO2.o000000 = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f311a;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            f311a = iArr;
            try {
                iArr[MiniRefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f311a[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f311a[MiniRefreshState.PULL_UP_TO_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f311a[MiniRefreshState.PULL_DOWN_CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f311a[MiniRefreshState.PULL_UP_CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f311a[MiniRefreshState.RELEASE_TO_REFRESH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f311a[MiniRefreshState.RELEASE_TO_LOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f311a[MiniRefreshState.RELEASE_TO_TWO_LEVEL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f311a[MiniRefreshState.REFRESH_RELEASED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f311a[MiniRefreshState.LOAD_RELEASED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f311a[MiniRefreshState.REFRESHING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f311a[MiniRefreshState.LOADING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f312a;

        public b(boolean z11) {
            this.f312a = z11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                OooOOO0.this.setStateDirectLoading(this.f312a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f314a;

        public c(boolean z11) {
            this.f314a = z11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator == null || animator.getDuration() != 0) {
                OooOOO0.this.o0OO00O = System.currentTimeMillis();
                OooOOO0.this.OooO00o(MiniRefreshState.REFRESHING);
                OooOOO0 oooOOO0 = OooOOO0.this;
                w0.c cVar = oooOOO0.OoooOoo;
                if (cVar == null) {
                    oooOOO0.OooO00o(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, true, Boolean.FALSE);
                } else if (this.f314a) {
                    cVar.a(oooOOO0);
                }
                OooOOO0 oooOOO1 = OooOOO0.this;
                p0.g gVar = oooOOO1.oo000o;
                if (gVar != null) {
                    int i11 = oooOOO1.Oooooo;
                    gVar.OooO00o(oooOOO1, i11, (int) (oooOOO1.o00Oo0 * i11));
                }
                OooOOO0.this.getClass();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MiniRefreshState miniRefreshState;
            MiniRefreshState miniRefreshState2;
            if (animator == null || animator.getDuration() != 0) {
                OooOOO0 oooOOO0 = OooOOO0.this;
                oooOOO0.o00000O0 = null;
                if (oooOOO0.OooO0O0 == 0 && (miniRefreshState = oooOOO0.o0OOO0o) != (miniRefreshState2 = MiniRefreshState.NONE) && !miniRefreshState.isOpening && !miniRefreshState.isDragging) {
                    oooOOO0.OooO00o(miniRefreshState2);
                    return;
                }
                MiniRefreshState miniRefreshState3 = oooOOO0.o0OOO0o;
                if (miniRefreshState3 != oooOOO0.o0Oo0oo) {
                    oooOOO0.setViceState(miniRefreshState3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OooOOO0 oooOOO0 = OooOOO0.this;
            if (oooOOO0.o00000O0 != null) {
                ((g) oooOOO0.o0ooOoO).b(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s0.b f319b;

        public f(int i11, int i12) {
            super(i11, i12);
            this.f318a = 0;
            this.f319b = null;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f318a = 0;
            this.f319b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MiniRefreshLayout_Layout);
            this.f318a = typedArrayObtainStyledAttributes.getColor(R$styleable.MiniRefreshLayout_Layout_layout_srlBackgroundColor, this.f318a);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f319b = s0.b.f75915h[typedArrayObtainStyledAttributes.getInt(R$styleable.MiniRefreshLayout_Layout_layout_srlSpinnerStyle, 0)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g implements h {
        public g() {
        }

        public ValueAnimator a(int i11) {
            OooOOO0 oooOOO0 = OooOOO0.this;
            return oooOOO0.OooO00o(i11, 0, oooOOO0.f289OooOoo0, oooOOO0.f282OooO0o);
        }

        /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
        public h b(int i11, boolean z11) {
            int i12;
            boolean z12;
            p0.g gVar;
            p0.g gVar2;
            OooOOO0 oooOOO0;
            p0.g gVar3;
            p0.g gVar4;
            p0.g gVar5;
            p0.g gVar6;
            OooOOO0 oooOOO1 = OooOOO0.this;
            if (oooOOO1.OooO0O0 == i11 && (((gVar5 = oooOOO1.oo000o) == null || !gVar5.OooO00o()) && ((gVar6 = OooOOO0.this.o00oO0o) == null || !gVar6.OooO00o()))) {
                return this;
            }
            OooOOO0 oooOOO2 = OooOOO0.this;
            int i13 = oooOOO2.OooO0O0;
            oooOOO2.OooO0O0 = i11;
            if (z11) {
                MiniRefreshState miniRefreshState = oooOOO2.o0Oo0oo;
                if (miniRefreshState.isDragging || miniRefreshState.isOpening) {
                    if (i11 > oooOOO2.Oooooo * oooOOO2.o00o0O) {
                        if (oooOOO2.o0OOO0o != MiniRefreshState.RELEASE_TO_TWO_LEVEL) {
                            ((g) oooOOO2.o0ooOoO).c(MiniRefreshState.RELEASE_TO_REFRESH);
                        }
                    } else if ((-i11) > oooOOO2.Ooooooo * oooOOO2.o00ooo && !oooOOO2.f300o000oOoO) {
                        ((g) oooOOO2.o0ooOoO).c(MiniRefreshState.RELEASE_TO_LOAD);
                    } else if (i11 < 0 && !oooOOO2.f300o000oOoO) {
                        ((g) oooOOO2.o0ooOoO).c(MiniRefreshState.PULL_UP_TO_LOAD);
                    } else if (i11 > 0) {
                        ((g) oooOOO2.o0ooOoO).c(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                    }
                }
            }
            OooOOO0 oooOOO3 = OooOOO0.this;
            if (oooOOO3.o00oO0O != null) {
                if (i11 < 0 || (gVar4 = oooOOO3.oo000o) == null) {
                    i12 = 0;
                    z12 = false;
                } else {
                    if (oooOOO3.OooO00o(oooOOO3.f292Oooo00o, gVar4)) {
                        i12 = i11;
                    } else if (i13 < 0) {
                        i12 = 0;
                    } else {
                        i12 = 0;
                        z12 = false;
                    }
                    z12 = true;
                }
                if (i11 <= 0 && (gVar3 = (oooOOO0 = OooOOO0.this).o00oO0o) != null) {
                    if (oooOOO0.OooO00o(oooOOO0.Oooo0, gVar3)) {
                        i12 = i11;
                    } else if (i13 > 0) {
                        i12 = 0;
                    }
                    z12 = true;
                }
                if (z12) {
                    OooOOO0 oooOOO4 = OooOOO0.this;
                    ((u0.a) oooOOO4.o00oO0O).c(i12, oooOOO4.OooOo0, oooOOO4.OooOo0O);
                    OooOOO0 oooOOO5 = OooOOO0.this;
                    if (oooOOO5.f300o000oOoO && oooOOO5.f297OoooOOO && oooOOO5.Oooo0O0) {
                        p0.g gVar7 = oooOOO5.o00oO0o;
                        if ((gVar7 instanceof p0.e) && gVar7.getSpinnerStyle() == s0.b.f75911d) {
                            OooOOO0 oooOOO6 = OooOOO0.this;
                            if (oooOOO6.OooO00o(oooOOO6.f290OooOooo)) {
                                OooOOO0.this.o00oO0o.getView().setTranslationY(Math.max(0, i12));
                            }
                        }
                    }
                    OooOOO0 oooOOO7 = OooOOO0.this;
                    boolean z13 = (oooOOO7.Oooo000 && (gVar2 = oooOOO7.oo000o) != null && gVar2.getSpinnerStyle() == s0.b.f75912e) || OooOOO0.this.oo0o0Oo != 0;
                    OooOOO0 oooOOO8 = OooOOO0.this;
                    boolean z14 = (oooOOO8.f291Oooo00O && (gVar = oooOOO8.o00oO0o) != null && gVar.getSpinnerStyle() == s0.b.f75912e) || OooOOO0.this.o0O0O00 != 0;
                    if ((z13 && (i12 >= 0 || i13 > 0)) || (z14 && (i12 <= 0 || i13 < 0))) {
                        oooOOO2.invalidate();
                    }
                }
            }
            if ((i11 >= 0 || i13 > 0) && OooOOO0.this.oo000o != null) {
                int iMax = Math.max(i11, 0);
                OooOOO0 oooOOO9 = OooOOO0.this;
                int i14 = oooOOO9.Oooooo;
                int i15 = (int) (i14 * oooOOO9.o00Oo0);
                float f11 = (iMax * 1.0f) / (i14 == 0 ? 1 : i14);
                if (oooOOO9.OooO00o(oooOOO9.OooOooO) || (OooOOO0.this.o0OOO0o == MiniRefreshState.REFRESH_FINISH && !z11)) {
                    OooOOO0 oooOOO10 = OooOOO0.this;
                    if (i13 != oooOOO10.OooO0O0) {
                        if (oooOOO10.oo000o.getSpinnerStyle() == s0.b.f75911d) {
                            OooOOO0.this.oo000o.getView().setTranslationY(OooOOO0.this.OooO0O0);
                            OooOOO0 oooOOO11 = OooOOO0.this;
                            if (oooOOO11.oo0o0Oo != 0 && oooOOO11.o0ooOO0 != null && !oooOOO11.OooO00o(oooOOO11.f292Oooo00o, oooOOO11.oo000o)) {
                                oooOOO2.invalidate();
                            }
                        } else if (OooOOO0.this.oo000o.getSpinnerStyle().f75918c) {
                            View view = OooOOO0.this.oo000o.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : OooOOO0.o00000o0;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((OooOOO0.this.OooO0O0 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i16 = marginLayoutParams.leftMargin;
                            int i17 = marginLayoutParams.topMargin + OooOOO0.this.ooOO;
                            view.layout(i16, i17, view.getMeasuredWidth() + i16, view.getMeasuredHeight() + i17);
                        }
                        OooOOO0.this.oo000o.OooO00o(z11, f11, iMax, i14, i15);
                    }
                    if (z11 && OooOOO0.this.oo000o.OooO00o()) {
                        int i18 = (int) OooOOO0.this.f285OooOO0;
                        int width = oooOOO2.getWidth();
                        OooOOO0 oooOOO12 = OooOOO0.this;
                        oooOOO12.oo000o.OooO00o(oooOOO12.f285OooOO0 / (width == 0 ? 1 : width), i18, width);
                    }
                }
                int i19 = OooOOO0.this.OooO0O0;
            }
            if ((i11 <= 0 || i13 < 0) && OooOOO0.this.o00oO0o != null) {
                int i21 = -Math.min(i11, 0);
                OooOOO0 oooOOO13 = OooOOO0.this;
                int i22 = oooOOO13.Ooooooo;
                int i23 = (int) (i22 * oooOOO13.o00Ooo);
                float f12 = (i21 * 1.0f) / (i22 == 0 ? 1 : i22);
                if (oooOOO13.OooO00o(oooOOO13.f290OooOooo) || (OooOOO0.this.o0OOO0o == MiniRefreshState.LOAD_FINISH && !z11)) {
                    OooOOO0 oooOOO14 = OooOOO0.this;
                    if (i13 != oooOOO14.OooO0O0) {
                        if (oooOOO14.o00oO0o.getSpinnerStyle() == s0.b.f75911d) {
                            OooOOO0.this.o00oO0o.getView().setTranslationY(OooOOO0.this.OooO0O0);
                            OooOOO0 oooOOO15 = OooOOO0.this;
                            if (oooOOO15.o0O0O00 != 0 && oooOOO15.o0ooOO0 != null && !oooOOO15.OooO00o(oooOOO15.Oooo0, oooOOO15.o00oO0o)) {
                                oooOOO2.invalidate();
                            }
                        } else if (OooOOO0.this.o00oO0o.getSpinnerStyle().f75918c) {
                            View view2 = OooOOO0.this.o00oO0o.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : OooOOO0.o00000o0;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-OooOOO0.this.OooO0O0) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i24 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (oooOOO2.getMeasuredHeight() + marginLayoutParams2.topMargin) - OooOOO0.this.o00O0O;
                            view2.layout(i24, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i24, measuredHeight);
                        }
                        OooOOO0.this.o00oO0o.OooO00o(z11, f12, i21, i22, i23);
                    }
                    if (z11 && OooOOO0.this.o00oO0o.OooO00o()) {
                        int i25 = (int) OooOOO0.this.f285OooOO0;
                        int width2 = oooOOO2.getWidth();
                        OooOOO0 oooOOO16 = OooOOO0.this;
                        oooOOO16.o00oO0o.OooO00o(oooOOO16.f285OooOO0 / (width2 == 0 ? 1 : width2), i25, width2);
                    }
                }
                int i26 = OooOOO0.this.OooO0O0;
            }
            return this;
        }

        public h c(@NonNull MiniRefreshState miniRefreshState) {
            switch (a.f311a[miniRefreshState.ordinal()]) {
                case 1:
                    OooOOO0 oooOOO0 = OooOOO0.this;
                    MiniRefreshState miniRefreshState2 = oooOOO0.o0OOO0o;
                    MiniRefreshState miniRefreshState3 = MiniRefreshState.NONE;
                    if (miniRefreshState2 != miniRefreshState3 && oooOOO0.OooO0O0 == 0) {
                        oooOOO0.OooO00o(miniRefreshState3);
                    } else if (oooOOO0.OooO0O0 != 0) {
                        a(0);
                    }
                    break;
                case 2:
                    OooOOO0 oooOOO1 = OooOOO0.this;
                    if (!oooOOO1.o0OOO0o.isOpening && oooOOO1.OooO00o(oooOOO1.OooOooO)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                    }
                    break;
                case 3:
                    OooOOO0 oooOOO2 = OooOOO0.this;
                    if (oooOOO2.OooO00o(oooOOO2.f290OooOooo)) {
                        OooOOO0 oooOOO3 = OooOOO0.this;
                        MiniRefreshState miniRefreshState4 = oooOOO3.o0OOO0o;
                        if (!miniRefreshState4.isOpening && !miniRefreshState4.isFinishing && (!oooOOO3.f300o000oOoO || !oooOOO3.Oooo0O0 || !oooOOO3.f297OoooOOO)) {
                            oooOOO3.OooO00o(MiniRefreshState.PULL_UP_TO_LOAD);
                        }
                    }
                    OooOOO0.this.setViceState(MiniRefreshState.PULL_UP_TO_LOAD);
                    break;
                case 4:
                    OooOOO0 oooOOO4 = OooOOO0.this;
                    if (!oooOOO4.o0OOO0o.isOpening && oooOOO4.OooO00o(oooOOO4.OooOooO)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.PULL_DOWN_CANCELED);
                        c(MiniRefreshState.NONE);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.PULL_DOWN_CANCELED);
                    }
                    break;
                case 5:
                    OooOOO0 oooOOO5 = OooOOO0.this;
                    if (oooOOO5.OooO00o(oooOOO5.f290OooOooo)) {
                        OooOOO0 oooOOO6 = OooOOO0.this;
                        if (!oooOOO6.o0OOO0o.isOpening && (!oooOOO6.f300o000oOoO || !oooOOO6.Oooo0O0 || !oooOOO6.f297OoooOOO)) {
                            oooOOO6.OooO00o(MiniRefreshState.PULL_UP_CANCELED);
                            c(MiniRefreshState.NONE);
                        }
                    }
                    OooOOO0.this.setViceState(MiniRefreshState.PULL_UP_CANCELED);
                    break;
                case 6:
                    OooOOO0 oooOOO7 = OooOOO0.this;
                    if (!oooOOO7.o0OOO0o.isOpening && oooOOO7.OooO00o(oooOOO7.OooOooO)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.RELEASE_TO_REFRESH);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.RELEASE_TO_REFRESH);
                    }
                    break;
                case 7:
                    OooOOO0 oooOOO8 = OooOOO0.this;
                    if (oooOOO8.OooO00o(oooOOO8.f290OooOooo)) {
                        OooOOO0 oooOOO9 = OooOOO0.this;
                        MiniRefreshState miniRefreshState5 = oooOOO9.o0OOO0o;
                        if (!miniRefreshState5.isOpening && !miniRefreshState5.isFinishing && (!oooOOO9.f300o000oOoO || !oooOOO9.Oooo0O0 || !oooOOO9.f297OoooOOO)) {
                            oooOOO9.OooO00o(MiniRefreshState.RELEASE_TO_LOAD);
                        }
                    }
                    OooOOO0.this.setViceState(MiniRefreshState.RELEASE_TO_LOAD);
                    break;
                case 8:
                    OooOOO0 oooOOO10 = OooOOO0.this;
                    if (!oooOOO10.o0OOO0o.isOpening && oooOOO10.OooO00o(oooOOO10.OooOooO)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.RELEASE_TO_TWO_LEVEL);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.RELEASE_TO_TWO_LEVEL);
                    }
                    break;
                case 9:
                    OooOOO0 oooOOO11 = OooOOO0.this;
                    if (!oooOOO11.o0OOO0o.isOpening && oooOOO11.OooO00o(oooOOO11.OooOooO)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.REFRESH_RELEASED);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.REFRESH_RELEASED);
                    }
                    break;
                case 10:
                    OooOOO0 oooOOO12 = OooOOO0.this;
                    if (!oooOOO12.o0OOO0o.isOpening && oooOOO12.OooO00o(oooOOO12.f290OooOooo)) {
                        OooOOO0.this.OooO00o(MiniRefreshState.LOAD_RELEASED);
                    } else {
                        OooOOO0.this.setViceState(MiniRefreshState.LOAD_RELEASED);
                    }
                    break;
                case 11:
                    OooOOO0.this.setStateRefreshing(true);
                    break;
                case 12:
                    OooOOO0.this.setStateLoading(true);
                    break;
                default:
                    OooOOO0.this.OooO00o(miniRefreshState);
                    break;
            }
            return null;
        }

        public h d(@NonNull p0.g gVar) {
            if (gVar.equals(OooOOO0.this.oo000o)) {
                OooOOO0 oooOOO0 = OooOOO0.this;
                s0.a aVar = oooOOO0.OoooooO;
                if (aVar.f75910b) {
                    oooOOO0.OoooooO = aVar.a();
                }
            } else if (gVar.equals(OooOOO0.this.o00oO0o)) {
                OooOOO0 oooOOO1 = OooOOO0.this;
                s0.a aVar2 = oooOOO1.o0OoOo0;
                if (aVar2.f75910b) {
                    oooOOO1.o0OoOo0 = aVar2.a();
                }
            }
            return this;
        }

        public h e(@NonNull p0.g gVar, int i11) {
            OooOOO0 oooOOO0 = OooOOO0.this;
            if (oooOOO0.o0ooOO0 == null && i11 != 0) {
                oooOOO0.o0ooOO0 = new Paint();
            }
            if (gVar.equals(OooOOO0.this.oo000o)) {
                OooOOO0.this.oo0o0Oo = i11;
            } else if (gVar.equals(OooOOO0.this.o00oO0o)) {
                OooOOO0.this.o0O0O00 = i11;
            }
            return this;
        }
    }

    public OooOOO0(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.f283OooO0o0 = LogSeverity.NOTICE_VALUE;
        this.f282OooO0o = LogSeverity.NOTICE_VALUE;
        this.f286OooOO0o = 1.0f;
        this.OooOOO0 = 0.16666667f;
        this.OooOOO = 0.5f;
        this.OooOOOO = 'n';
        this.OooOOoo = -1;
        this.OooOo00 = -1;
        this.OooOo0 = -1;
        this.OooOo0O = -1;
        this.OooOooO = true;
        this.f290OooOooo = false;
        this.Oooo000 = true;
        this.f291Oooo00O = true;
        this.f292Oooo00o = true;
        this.Oooo0 = true;
        this.Oooo0O0 = false;
        this.Oooo0OO = true;
        this.Oooo0o0 = true;
        this.Oooo0o = false;
        this.f293Oooo0oO = true;
        this.Oooo0oo = false;
        this.Oooo = true;
        this.f295OoooO00 = true;
        this.f294OoooO0 = true;
        this.f296OoooO0O = true;
        this.OoooO = false;
        this.OoooOO0 = false;
        this.f300o000oOoO = false;
        this.f297OoooOOO = false;
        this.f298OoooOOo = false;
        this.f299OoooOo0 = false;
        this.OoooOoO = false;
        this.OooooOO = new int[2];
        this.OooooOo = new NestedScrollingChildHelper(this);
        this.Oooooo0 = new NestedScrollingParentHelper(this);
        s0.a aVar = s0.a.f75903c;
        this.OoooooO = aVar;
        this.o0OoOo0 = aVar;
        this.o00Oo0 = 2.5f;
        this.o00Ooo = 2.5f;
        this.o00o0O = 1.0f;
        this.o00ooo = 1.0f;
        this.o0ooOoO = new g();
        MiniRefreshState miniRefreshState = MiniRefreshState.NONE;
        this.o0OOO0o = miniRefreshState;
        this.o0Oo0oo = miniRefreshState;
        this.o0OO00O = 0L;
        this.oo0o0Oo = 0;
        this.o0O0O00 = 0;
        this.o000000 = false;
        this.o000000O = false;
        this.o000000o = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o0ooOOo = new Handler();
        this.OooOoO = new Scroller(context);
        this.f287OooOoOO = VelocityTracker.obtain();
        this.OooO0oO = context.getResources().getDisplayMetrics().heightPixels;
        this.f289OooOoo0 = new x0.b(0);
        this.OooO00o = viewConfiguration.getScaledTouchSlop();
        this.OooOo0o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.OooOo = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Ooooooo = x0.b.a(60.0f);
        this.Oooooo = x0.b.a(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.MiniRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_android_clipToPadding)) {
            setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_android_clipChildren)) {
            setClipChildren(false);
        }
        this.OooOOO = typedArrayObtainStyledAttributes.getFloat(R$styleable.MiniRefreshLayout_srlDragRate, this.OooOOO);
        this.o00Oo0 = typedArrayObtainStyledAttributes.getFloat(R$styleable.MiniRefreshLayout_srlHeaderMaxDragRate, this.o00Oo0);
        this.o00Ooo = typedArrayObtainStyledAttributes.getFloat(R$styleable.MiniRefreshLayout_srlFooterMaxDragRate, this.o00Ooo);
        this.o00o0O = typedArrayObtainStyledAttributes.getFloat(R$styleable.MiniRefreshLayout_srlHeaderTriggerRate, this.o00o0O);
        this.o00ooo = typedArrayObtainStyledAttributes.getFloat(R$styleable.MiniRefreshLayout_srlFooterTriggerRate, this.o00ooo);
        this.OooOooO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableRefresh, this.OooOooO);
        this.f282OooO0o = typedArrayObtainStyledAttributes.getInt(R$styleable.MiniRefreshLayout_srlReboundDuration, this.f282OooO0o);
        this.f290OooOooo = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableLoadMore, this.f290OooOooo);
        this.Oooooo = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MiniRefreshLayout_srlHeaderHeight, this.Oooooo);
        this.Ooooooo = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MiniRefreshLayout_srlFooterHeight, this.Ooooooo);
        this.ooOO = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MiniRefreshLayout_srlHeaderInsetStart, this.ooOO);
        this.o00O0O = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MiniRefreshLayout_srlFooterInsetStart, this.o00O0O);
        this.OoooO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlDisableContentWhenRefresh, this.OoooO);
        this.OoooOO0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlDisableContentWhenLoading, this.OoooOO0);
        this.f292Oooo00o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableHeaderTranslationContent, this.f292Oooo00o);
        this.Oooo0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableFooterTranslationContent, this.Oooo0);
        this.Oooo0OO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnablePreviewInEditMode, this.Oooo0OO);
        this.f293Oooo0oO = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableAutoLoadMore, this.f293Oooo0oO);
        this.Oooo0o0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableOverScrollBounce, this.Oooo0o0);
        this.Oooo0oo = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnablePureScrollMode, this.Oooo0oo);
        this.Oooo = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableScrollContentWhenLoaded, this.Oooo);
        this.f295OoooO00 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableScrollContentWhenRefreshed, this.f295OoooO00);
        this.f294OoooO0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.f294OoooO0);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.Oooo0O0);
        this.Oooo0O0 = z11;
        this.Oooo0O0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z11);
        this.Oooo000 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.Oooo000);
        this.f291Oooo00O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.f291Oooo00O);
        this.Oooo0o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableOverScrollDrag, this.Oooo0o);
        this.OooOOoo = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MiniRefreshLayout_srlFixedHeaderViewId, this.OooOOoo);
        this.OooOo00 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MiniRefreshLayout_srlFixedFooterViewId, this.OooOo00);
        this.OooOo0 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MiniRefreshLayout_srlHeaderTranslationViewId, this.OooOo0);
        this.OooOo0O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MiniRefreshLayout_srlFooterTranslationViewId, this.OooOo0O);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MiniRefreshLayout_srlEnableNestedScrolling, this.f296OoooO0O);
        this.f296OoooO0O = z12;
        this.OooooOo.setNestedScrollingEnabled(z12);
        this.f298OoooOOo = this.f298OoooOOo || typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_srlEnableLoadMore);
        this.f299OoooOo0 = this.f299OoooOo0 || typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_srlEnableHeaderTranslationContent);
        this.OoooOoO = this.OoooOoO || typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_srlEnableFooterTranslationContent);
        this.OoooooO = typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_srlHeaderHeight) ? s0.a.f75906f : this.OoooooO;
        this.o0OoOo0 = typedArrayObtainStyledAttributes.hasValue(R$styleable.MiniRefreshLayout_srlFooterHeight) ? s0.a.f75906f : this.o0OoOo0;
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MiniRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.MiniRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f288OooOoo = new int[]{color2, color};
            } else {
                this.f288OooOoo = new int[]{color2};
            }
        } else if (color != 0) {
            this.f288OooOoo = new int[]{0, color};
        }
        if (this.Oooo0oo && !this.f298OoooOOo && !this.f290OooOooo) {
            this.f290OooOooo = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(@NonNull p0.a aVar) {
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull p0.b bVar) {
    }

    public static void setDefaultRefreshInitializer(@NonNull p0.c cVar) {
    }

    public OooOOO0 OooO00o(int i11, boolean z11, Boolean bool) {
        int i12 = i11 >> 16;
        int i13 = (i11 << 16) >> 16;
        OooOO0O oooOO0O = new OooOO0O(i12, bool, z11);
        if (i13 > 0) {
            this.o0ooOOo.postDelayed(oooOO0O, i13);
        } else {
            oooOO0O.run();
        }
        return this;
    }

    public OooOOO0 OooO00o(int i11, boolean z11, boolean z12) {
        int i12 = i11 >> 16;
        int i13 = (i11 << 16) >> 16;
        RunnableC0013OooOOO0 runnableC0013OooOOO0 = new RunnableC0013OooOOO0(i12, z12, z11);
        if (i13 > 0) {
            this.o0ooOOo.postDelayed(runnableC0013OooOOO0, i13);
        } else {
            runnableC0013OooOOO0.run();
        }
        return this;
    }

    public OooOOO0 OooO00o(@NonNull p0.e eVar) {
        p0.g gVar;
        p0.g gVar2 = this.o00oO0o;
        if (gVar2 != null) {
            removeView(gVar2.getView());
        }
        this.o00oO0o = eVar;
        this.o000000 = false;
        this.o0O0O00 = 0;
        this.f297OoooOOO = false;
        this.o0OoOo0 = s0.a.f75903c;
        this.f290OooOooo = !this.f298OoooOOo || this.f290OooOooo;
        f fVar = new f(-1, -2);
        ViewGroup.LayoutParams layoutParams = this.o00oO0o.getView().getLayoutParams();
        if (layoutParams instanceof f) {
            fVar = (f) layoutParams;
        }
        xb.i.b(this.o00oO0o.getView());
        if (this.o00oO0o.getSpinnerStyle().f75917b) {
            addView(this.o00oO0o.getView(), getChildCount(), fVar);
        } else {
            addView(this.o00oO0o.getView(), 0, fVar);
        }
        int[] iArr = this.f288OooOoo;
        if (iArr != null && (gVar = this.o00oO0o) != null) {
            gVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public ValueAnimator OooO00o(int i11, int i12, Interpolator interpolator, int i13) {
        if (this.OooO0O0 == i11) {
            return null;
        }
        ValueAnimator valueAnimator = this.o00000O0;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.o00000O0.cancel();
            this.o00000O0 = null;
        }
        this.o00000 = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.OooO0O0, i11);
        this.o00000O0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i13);
        this.o00000O0.setInterpolator(interpolator);
        this.o00000O0.addListener(new d());
        this.o00000O0.addUpdateListener(new e());
        this.o00000O0.setStartDelay(i12);
        this.o00000O0.start();
        return this.o00000O0;
    }

    public i OooO00o(@NonNull p0.f fVar) {
        p0.g gVar;
        p0.g gVar2 = this.oo000o;
        if (gVar2 != null) {
            removeView(gVar2.getView());
        }
        this.oo000o = fVar;
        this.oo0o0Oo = 0;
        this.OoooooO = s0.a.f75903c;
        f fVar2 = new f(-1, -2);
        ViewGroup.LayoutParams layoutParams = this.oo000o.getView().getLayoutParams();
        if (layoutParams instanceof f) {
            fVar2 = (f) layoutParams;
        }
        xb.i.b(this.oo000o.getView());
        if (this.oo000o.getSpinnerStyle().f75917b) {
            addView(this.oo000o.getView(), getChildCount(), fVar2);
        } else {
            addView(this.oo000o.getView(), 0, fVar2);
        }
        int[] iArr = this.f288OooOoo;
        if (iArr != null && (gVar = this.oo000o) != null) {
            gVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public void OooO00o(float f11) {
        MiniRefreshState miniRefreshState;
        if (this.OooooO0 && !this.f294OoooO0 && f11 < 0.0f && !((u0.a) this.o00oO0O).e()) {
            f11 = 0.0f;
        }
        if (f11 > this.OooO0oO * 5 && getTag() == null) {
            float f12 = this.OooOO0O;
            float f13 = this.OooO0oO;
            if (f12 < f13 / 6.0f && this.f285OooOO0 < f13 / 16.0f) {
                setTag("");
            }
        }
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2 == MiniRefreshState.TwoLevel && f11 > 0.0f && this.o00oO0O != null) {
            int measuredHeight = getMeasuredHeight();
            float f14 = this.f286OooOO0o;
            ((g) this.o0ooOoO).b(Math.min((int) f11, f14 > 1.0f ? (int) f14 : (int) (measuredHeight * f14)), true);
        } else if (miniRefreshState2 == MiniRefreshState.REFRESHING && f11 >= 0.0f) {
            float f15 = this.Oooooo;
            if (f11 < f15) {
                ((g) this.o0ooOoO).b((int) f11, true);
            } else {
                float f16 = (this.o00Oo0 - 1.0f) * f15;
                int iMax = Math.max((this.OooO0oO * 4) / 3, getHeight());
                int i11 = this.Oooooo;
                float f17 = iMax - i11;
                float fMax = Math.max(0.0f, (f11 - i11) * this.OooOOO);
                float f18 = -fMax;
                if (f17 == 0.0f) {
                    f17 = 1.0f;
                }
                ((g) this.o0ooOoO).b(((int) Math.min((1.0f - ((float) Math.pow(100.0d, f18 / f17))) * f16, fMax)) + this.Oooooo, true);
            }
        } else if (f11 < 0.0f && (miniRefreshState2 == MiniRefreshState.LOADING || ((this.Oooo0O0 && this.f300o000oOoO && this.f297OoooOOO && OooO00o(this.f290OooOooo)) || (this.f293Oooo0oO && !this.f300o000oOoO && OooO00o(this.f290OooOooo))))) {
            int i12 = this.Ooooooo;
            if (f11 > (-i12)) {
                ((g) this.o0ooOoO).b((int) f11, true);
            } else {
                float f19 = (this.o00Ooo - 1.0f) * i12;
                int iMax2 = Math.max((this.OooO0oO * 4) / 3, getHeight());
                int i13 = this.Ooooooo;
                float f21 = iMax2 - i13;
                float f22 = -Math.min(0.0f, (i13 + f11) * this.OooOOO);
                float f23 = -f22;
                if (f21 == 0.0f) {
                    f21 = 1.0f;
                }
                ((g) this.o0ooOoO).b(((int) (-Math.min((1.0f - ((float) Math.pow(100.0d, f23 / f21))) * f19, f22))) - this.Ooooooo, true);
            }
        } else if (f11 >= 0.0f) {
            float f24 = this.o00Oo0 * this.Oooooo;
            float fMax2 = Math.max(this.OooO0oO / 2, getHeight());
            float fMax3 = Math.max(0.0f, this.OooOOO * f11);
            float f25 = -fMax3;
            if (fMax2 == 0.0f) {
                fMax2 = 1.0f;
            }
            ((g) this.o0ooOoO).b((int) Math.min((1.0f - ((float) Math.pow(100.0d, f25 / fMax2))) * f24, fMax3), true);
        } else {
            float f26 = this.o00Ooo * this.Ooooooo;
            float fMax4 = Math.max(this.OooO0oO / 2, getHeight());
            float f27 = -Math.min(0.0f, this.OooOOO * f11);
            float f28 = -f27;
            if (fMax4 == 0.0f) {
                fMax4 = 1.0f;
            }
            ((g) this.o0ooOoO).b((int) (-Math.min((1.0f - ((float) Math.pow(100.0d, f28 / fMax4))) * f26, f27)), true);
        }
        if (!this.f293Oooo0oO || this.f300o000oOoO || !OooO00o(this.f290OooOooo) || f11 >= 0.0f || (miniRefreshState = this.o0OOO0o) == MiniRefreshState.REFRESHING || miniRefreshState == MiniRefreshState.LOADING || miniRefreshState == MiniRefreshState.LOAD_FINISH) {
            return;
        }
        if (this.OoooOO0) {
            this.o00000 = null;
            ((g) this.o0ooOoO).a(-this.Ooooooo);
        }
        setStateDirectLoading(false);
        this.o0ooOOo.postDelayed(new OooOO0(), this.f282OooO0o);
    }

    public void OooO00o(MiniRefreshState miniRefreshState) {
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2 == miniRefreshState) {
            if (this.o0Oo0oo != miniRefreshState2) {
                this.o0Oo0oo = miniRefreshState2;
                return;
            }
            return;
        }
        this.o0OOO0o = miniRefreshState;
        this.o0Oo0oo = miniRefreshState;
        p0.g gVar = this.oo000o;
        p0.g gVar2 = this.o00oO0o;
        if (gVar != null) {
            gVar.OooO00o(this, miniRefreshState2, miniRefreshState);
        }
        if (gVar2 != null) {
            gVar2.OooO00o(this, miniRefreshState2, miniRefreshState);
        }
        if (miniRefreshState == MiniRefreshState.LOAD_FINISH) {
            this.o000000 = false;
        }
    }

    public boolean OooO00o() {
        int i11 = this.o000OOo ? 0 : LogSeverity.WARNING_VALUE;
        int i12 = this.f282OooO0o;
        float f11 = (this.o00Oo0 / 2.0f) + 0.5f;
        int i13 = this.Oooooo;
        float f12 = f11 * i13 * 1.0f;
        if (i13 == 0) {
            i13 = 1;
        }
        float f13 = f12 / i13;
        if (this.o0OOO0o != MiniRefreshState.NONE || !OooO00o(this.OooOooO)) {
            return false;
        }
        p014OoooO0O.OooOOO oooOOO = new p014OoooO0O.OooOOO(this, f13, i12, false);
        setViceState(MiniRefreshState.REFRESHING);
        if (i11 > 0) {
            this.o0ooOOo.postDelayed(oooOOO, i11);
        } else {
            oooOOO.run();
        }
        return true;
    }

    public boolean OooO00o(int i11) {
        if (i11 == 0) {
            if (this.o00000O0 != null) {
                MiniRefreshState miniRefreshState = this.o0OOO0o;
                if (miniRefreshState.isFinishing || miniRefreshState == MiniRefreshState.TWO_LEVEL_RELEASED || miniRefreshState == MiniRefreshState.REFRESH_RELEASED || miniRefreshState == MiniRefreshState.LOAD_RELEASED) {
                    return true;
                }
                if (miniRefreshState == MiniRefreshState.PULL_DOWN_CANCELED) {
                    ((g) this.o0ooOoO).c(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                } else if (miniRefreshState == MiniRefreshState.PULL_UP_CANCELED) {
                    ((g) this.o0ooOoO).c(MiniRefreshState.PULL_UP_TO_LOAD);
                }
                this.o00000O0.setDuration(0L);
                this.o00000O0.cancel();
                this.o00000O0 = null;
            }
            this.o00000 = null;
        }
        return this.o00000O0 != null;
    }

    public boolean OooO00o(boolean z11) {
        return z11 && !this.Oooo0oo;
    }

    public boolean OooO00o(boolean z11, p0.g gVar) {
        return z11 || this.Oooo0oo || gVar == null || gVar.getSpinnerStyle() == s0.b.f75912e;
    }

    public OooOOO0 OooO0O0(boolean z11) {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        if (miniRefreshState == MiniRefreshState.REFRESHING && z11) {
            OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.o0OO00O))), LogSeverity.NOTICE_VALUE) << 16, true, Boolean.TRUE);
        } else if (miniRefreshState == MiniRefreshState.LOADING && z11) {
            OooO00o(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.o0OO00O))), LogSeverity.NOTICE_VALUE) << 16, true, true);
        } else if (this.f300o000oOoO != z11) {
            this.f300o000oOoO = z11;
            p0.g gVar = this.o00oO0o;
            if (gVar instanceof p0.e) {
                if (((p0.e) gVar).OooO00o(z11)) {
                    this.f297OoooOOO = true;
                    if (this.f300o000oOoO && this.Oooo0O0 && this.OooO0O0 > 0 && this.o00oO0o.getSpinnerStyle() == s0.b.f75911d && OooO00o(this.f290OooOooo) && OooO00o(this.OooOooO, this.oo000o)) {
                        this.o00oO0o.getView().setTranslationY(this.OooO0O0);
                    }
                } else {
                    this.f297OoooOOO = false;
                    StringBuilder sbA = j.a("Footer:");
                    sbA.append(this.o00oO0o);
                    sbA.append(" NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])");
                    new RuntimeException(sbA.toString()).printStackTrace();
                }
            }
        }
        return this;
    }

    public void OooO0O0() {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.TwoLevel;
        if (miniRefreshState == miniRefreshState2) {
            int measuredHeight = getMeasuredHeight();
            float f11 = this.f286OooOO0o;
            int i11 = f11 > 1.0f ? (int) f11 : (int) (measuredHeight * f11);
            if (this.OooOoO0 > -1000 && this.OooO0O0 > i11 / 2) {
                ValueAnimator valueAnimatorA = ((g) this.o0ooOoO).a(i11);
                if (valueAnimatorA != null) {
                    valueAnimatorA.setDuration(this.f283OooO0o0);
                    return;
                }
                return;
            }
            if (this.OooOOOo) {
                g gVar = (g) this.o0ooOoO;
                OooOOO0 oooOOO0 = OooOOO0.this;
                if (oooOOO0.o0OOO0o == miniRefreshState2) {
                    ((g) oooOOO0.o0ooOoO).c(MiniRefreshState.TwoLevelFinish);
                    if (OooOOO0.this.OooO0O0 != 0) {
                        gVar.a(0).setDuration(OooOOO0.this.f283OooO0o0);
                        return;
                    } else {
                        gVar.b(0, false);
                        OooOOO0.this.OooO00o(MiniRefreshState.NONE);
                        return;
                    }
                }
                return;
            }
            return;
        }
        MiniRefreshState miniRefreshState3 = MiniRefreshState.LOADING;
        if (miniRefreshState == miniRefreshState3 || (this.Oooo0O0 && this.f300o000oOoO && this.f297OoooOOO && this.OooO0O0 < 0 && OooO00o(this.f290OooOooo))) {
            int i12 = this.OooO0O0;
            int i13 = -this.Ooooooo;
            if (i12 < i13) {
                ((g) this.o0ooOoO).a(i13);
                return;
            } else {
                if (i12 > 0) {
                    ((g) this.o0ooOoO).a(0);
                    return;
                }
                return;
            }
        }
        MiniRefreshState miniRefreshState4 = this.o0OOO0o;
        MiniRefreshState miniRefreshState5 = MiniRefreshState.REFRESHING;
        if (miniRefreshState4 == miniRefreshState5) {
            int i14 = this.OooO0O0;
            int i15 = this.Oooooo;
            if (i14 > i15) {
                ((g) this.o0ooOoO).a(i15);
                return;
            } else {
                if (i14 < 0) {
                    ((g) this.o0ooOoO).a(0);
                    return;
                }
                return;
            }
        }
        if (miniRefreshState4 == MiniRefreshState.PULL_DOWN_TO_REFRESH) {
            ((g) this.o0ooOoO).c(MiniRefreshState.PULL_DOWN_CANCELED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.PULL_UP_TO_LOAD) {
            ((g) this.o0ooOoO).c(MiniRefreshState.PULL_UP_CANCELED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_REFRESH) {
            ((g) this.o0ooOoO).c(miniRefreshState5);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_LOAD) {
            ((g) this.o0ooOoO).c(miniRefreshState3);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.RELEASE_TO_TWO_LEVEL) {
            ((g) this.o0ooOoO).c(MiniRefreshState.TWO_LEVEL_RELEASED);
            return;
        }
        if (miniRefreshState4 == MiniRefreshState.REFRESH_RELEASED) {
            if (this.o00000O0 == null) {
                ((g) this.o0ooOoO).a(this.Oooooo);
            }
        } else if (miniRefreshState4 == MiniRefreshState.LOAD_RELEASED) {
            if (this.o00000O0 == null) {
                ((g) this.o0ooOoO).a(-this.Ooooooo);
            }
        } else {
            if (miniRefreshState4 == MiniRefreshState.LOAD_FINISH || this.OooO0O0 == 0) {
                return;
            }
            ((g) this.o0ooOoO).a(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x00f6  */
    public boolean OooO0O0(float f11) {
        MiniRefreshState miniRefreshState;
        if (f11 == 0.0f) {
            f11 = this.OooOoO0;
        }
        if (Build.VERSION.SDK_INT > 27 && this.o00oO0O != null) {
            getScaleY();
            View view = ((u0.a) this.o00oO0O).f78104a;
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f11 = -f11;
            }
        }
        int i11 = 0;
        if (Math.abs(f11) > this.OooOo0o) {
            int i12 = this.OooO0O0;
            if (i12 * f11 < 0.0f) {
                MiniRefreshState miniRefreshState2 = this.o0OOO0o;
                MiniRefreshState miniRefreshState3 = MiniRefreshState.REFRESHING;
                if (miniRefreshState2 == miniRefreshState3 || miniRefreshState2 == MiniRefreshState.LOADING || (i12 < 0 && this.f300o000oOoO)) {
                    OooOOOO oooOOOO = new OooOOOO(f11);
                    MiniRefreshState miniRefreshState4 = this.o0OOO0o;
                    if (miniRefreshState4.isFinishing) {
                        oooOOOO = null;
                    } else {
                        if (this.OooO0O0 != 0 && ((!miniRefreshState4.isOpening && (!this.f300o000oOoO || !this.Oooo0O0 || !this.f297OoooOOO || !OooO00o(this.f290OooOooo))) || (((this.o0OOO0o == MiniRefreshState.LOADING || (this.f300o000oOoO && this.Oooo0O0 && this.f297OoooOOO && OooO00o(this.f290OooOooo))) && this.OooO0O0 < (-this.Ooooooo)) || (this.o0OOO0o == miniRefreshState3 && this.OooO0O0 > this.Oooooo)))) {
                            int i13 = this.OooO0O0;
                            float fPow = oooOOOO.OooO0O0;
                            int i14 = i13;
                            while (true) {
                                if (i13 * i14 > 0) {
                                    i11++;
                                    fPow = (float) (Math.pow(0.98f, (i11 * 10) / 10.0f) * ((double) fPow));
                                    float f12 = ((10 * 1.0f) / 1000.0f) * fPow;
                                    if (Math.abs(f12) < 1.0f) {
                                        OooOOO0 oooOOO0 = OooOOO0.this;
                                        MiniRefreshState miniRefreshState5 = oooOOO0.o0OOO0o;
                                        if (!miniRefreshState5.isOpening || ((miniRefreshState5 == (miniRefreshState = MiniRefreshState.REFRESHING) && i14 > oooOOO0.Oooooo) || (miniRefreshState5 != miniRefreshState && i14 < (-oooOOO0.Ooooooo)))) {
                                            oooOOOO = null;
                                        }
                                    } else {
                                        i14 = (int) (i14 + f12);
                                    }
                                }
                            }
                        }
                        oooOOOO.OooO0OO = AnimationUtils.currentAnimationTimeMillis();
                        OooOOO0.this.o0ooOOo.postDelayed(oooOOOO, 10);
                    }
                    this.o00000 = oooOOOO;
                    return true;
                }
                if (miniRefreshState2.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f11 < 0.0f && ((this.Oooo0o0 && (this.f290OooOooo || this.Oooo0o)) || ((this.o0OOO0o == MiniRefreshState.LOADING && i12 >= 0) || (this.f293Oooo0oO && OooO00o(this.f290OooOooo))))) || (f11 > 0.0f && ((this.Oooo0o0 && this.OooOooO) || this.Oooo0o || (this.o0OOO0o == MiniRefreshState.REFRESHING && this.OooO0O0 <= 0)))) {
                this.o000000O = false;
                this.OooOoO.fling(0, 0, 0, (int) (-f11), 0, 0, -2147483647, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                this.OooOoO.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        MiniRefreshState miniRefreshState;
        this.OooOoO.getCurrY();
        if (this.OooOoO.computeScrollOffset()) {
            int finalY = this.OooOoO.getFinalY();
            if ((finalY >= 0 || !((this.OooOooO || this.Oooo0o) && ((u0.a) this.o00oO0O).f())) && (finalY <= 0 || !((this.f290OooOooo || this.Oooo0o) && ((u0.a) this.o00oO0O).e()))) {
                this.o000000O = true;
                invalidate();
                return;
            }
            if (this.o000000O) {
                float currVelocity = finalY > 0 ? -this.OooOoO.getCurrVelocity() : this.OooOoO.getCurrVelocity();
                if (this.o00000O0 == null) {
                    if (currVelocity > 0.0f && ((miniRefreshState = this.o0OOO0o) == MiniRefreshState.REFRESHING || miniRefreshState == MiniRefreshState.TwoLevel)) {
                        this.o00000 = new OooOOO(currVelocity, this.Oooooo);
                    } else if (currVelocity < 0.0f && (this.o0OOO0o == MiniRefreshState.LOADING || ((this.Oooo0O0 && this.f300o000oOoO && this.f297OoooOOO && OooO00o(this.f290OooOooo)) || (this.f293Oooo0oO && !this.f300o000oOoO && OooO00o(this.f290OooOooo) && this.o0OOO0o != MiniRefreshState.REFRESHING)))) {
                        this.o00000 = new OooOOO(currVelocity, -this.Ooooooo);
                    } else if (this.OooO0O0 == 0 && this.Oooo0o0) {
                        this.o00000 = new OooOOO(currVelocity, 0);
                    }
                }
            }
            this.OooOoO.forceFinished(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        MiniRefreshState miniRefreshState;
        char c11;
        p0.g gVar;
        p0.g gVar2;
        int actionMasked = motionEvent.getActionMasked();
        int i11 = 0;
        boolean z11 = actionMasked == 6;
        int actionIndex = z11 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x11 = 0.0f;
        float y11 = 0.0f;
        for (int i12 = 0; i12 < pointerCount; i12++) {
            if (actionIndex != i12) {
                x11 += motionEvent.getX(i12);
                y11 += motionEvent.getY(i12);
            }
        }
        if (z11) {
            pointerCount--;
        }
        float f11 = pointerCount;
        float f12 = x11 / f11;
        float f13 = y11 / f11;
        if ((actionMasked == 6 || actionMasked == 5) && this.OooOOOo) {
            this.f280OooO = (f13 - this.OooOO0O) + this.f280OooO;
        }
        this.f285OooOO0 = f12;
        this.OooOO0O = f13;
        if (this.OooooO0) {
            int i13 = this.Ooooo0o;
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i13 == this.Ooooo0o) {
                int i14 = (int) this.f285OooOO0;
                int width = getWidth();
                float f14 = this.f285OooOO0 / (width != 0 ? width : 1);
                if (OooO00o(this.OooOooO) && this.OooO0O0 > 0 && (gVar2 = this.oo000o) != null && gVar2.OooO00o()) {
                    this.oo000o.OooO00o(f14, i14, width);
                } else if (OooO00o(this.f290OooOooo) && this.OooO0O0 < 0 && (gVar = this.o00oO0o) != null && gVar.OooO00o()) {
                    this.o00oO0o.OooO00o(f14, i14, width);
                }
            }
            return zDispatchTouchEvent;
        }
        if (!isEnabled() || (!this.OooOooO && !this.f290OooOooo && !this.Oooo0o)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!OooO00o(actionMasked)) {
            MiniRefreshState miniRefreshState2 = this.o0OOO0o;
            if (!miniRefreshState2.isFinishing && ((miniRefreshState2 != (miniRefreshState = MiniRefreshState.LOADING) || !this.OoooOO0) && (miniRefreshState2 != MiniRefreshState.REFRESHING || !this.OoooO))) {
                if (actionMasked == 0) {
                    this.OooOoO0 = 0;
                    this.f287OooOoOO.addMovement(motionEvent);
                    this.OooOoO.forceFinished(true);
                    this.f284OooO0oo = f12;
                    this.f280OooO = f13;
                    this.OooO0OO = 0;
                    this.f281OooO0Oo = this.OooO0O0;
                    this.OooOOOo = false;
                    this.OooOOo = false;
                    this.OooOOo0 = super.dispatchTouchEvent(motionEvent);
                    if (this.o0OOO0o == MiniRefreshState.TwoLevel) {
                        int measuredHeight = getMeasuredHeight();
                        float f15 = this.OooOOO0;
                        if (f15 <= 1.0f) {
                            if (this.f280OooO < (1.0f - f15) * measuredHeight) {
                                this.OooOOOO = 'h';
                                return this.OooOOo0;
                            }
                        }
                        if (f15 > 1.0f && this.f280OooO < measuredHeight - f15) {
                            this.OooOOOO = 'h';
                            return this.OooOOo0;
                        }
                    }
                    p0.d dVar = this.o00oO0O;
                    if (dVar != null) {
                        u0.a aVar = (u0.a) dVar;
                        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                        pointF.offset(-aVar.f78104a.getLeft(), -aVar.f78104a.getTop());
                        View view = aVar.f78106c;
                        View view2 = aVar.f78104a;
                        if (view != view2) {
                            aVar.f78106c = aVar.b(view2, pointF, view);
                        }
                        if (aVar.f78106c == aVar.f78104a) {
                            aVar.f78112j.f78113a = null;
                        } else {
                            aVar.f78112j.f78113a = pointF;
                        }
                    }
                    return true;
                }
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float f16 = f12 - this.f284OooO0oo;
                        float f17 = f13 - this.f280OooO;
                        this.f287OooOoOO.addMovement(motionEvent);
                        if (!this.OooOOOo && !this.OooOOo && (c11 = this.OooOOOO) != 'h' && this.o00oO0O != null) {
                            if (c11 == 'v' || (Math.abs(f17) >= this.OooO00o && Math.abs(f16) < Math.abs(f17))) {
                                this.OooOOOO = 'v';
                                if (f17 > 0.0f && (this.OooO0O0 < 0 || ((this.Oooo0o || this.OooOooO) && ((u0.a) this.o00oO0O).f()))) {
                                    this.OooOOOo = true;
                                    this.f280OooO = f13 - this.OooO00o;
                                } else if (f17 < 0.0f && (this.OooO0O0 > 0 || ((this.Oooo0o || this.f290OooOooo) && ((this.o0OOO0o == miniRefreshState && this.o000000) || ((u0.a) this.o00oO0O).e())))) {
                                    this.OooOOOo = true;
                                    this.f280OooO = this.OooO00o + f13;
                                }
                                if (this.OooOOOo) {
                                    f17 = f13 - this.f280OooO;
                                    if (this.OooOOo0) {
                                        motionEvent.setAction(3);
                                        super.dispatchTouchEvent(motionEvent);
                                    }
                                    h hVar = this.o0ooOoO;
                                    int i15 = this.OooO0O0;
                                    ((g) hVar).c((i15 > 0 || (i15 == 0 && f17 > 0.0f)) ? MiniRefreshState.PULL_DOWN_TO_REFRESH : MiniRefreshState.PULL_UP_TO_LOAD);
                                    ViewParent parent = getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            } else if (Math.abs(f16) >= this.OooO00o && Math.abs(f16) > Math.abs(f17) && this.OooOOOO != 'v') {
                                this.OooOOOO = 'h';
                            }
                        }
                        if (this.OooOOOo) {
                            int i16 = ((int) f17) + this.f281OooO0Oo;
                            MiniRefreshState miniRefreshState3 = this.o0Oo0oo;
                            if ((miniRefreshState3.isHeader && (i16 < 0 || this.OooO0OO < 0)) || (miniRefreshState3.isFooter && (i16 > 0 || this.OooO0OO > 0))) {
                                this.OooO0OO = i16;
                                long eventTime = motionEvent.getEventTime();
                                if (this.o000000o == null) {
                                    MotionEvent motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 0, this.f284OooO0oo + f16, this.f280OooO, 0);
                                    this.o000000o = motionEventObtain;
                                    super.dispatchTouchEvent(motionEventObtain);
                                }
                                MotionEvent motionEventObtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.f284OooO0oo + f16, this.f280OooO + i16, 0);
                                super.dispatchTouchEvent(motionEventObtain2);
                                if (this.o000000 && f17 > this.OooO00o && this.OooO0O0 < 0) {
                                    this.o000000 = false;
                                }
                                if (i16 > 0 && ((this.Oooo0o || this.OooOooO) && ((u0.a) this.o00oO0O).f())) {
                                    this.OooOO0O = f13;
                                    this.f280OooO = f13;
                                    this.f281OooO0Oo = 0;
                                    ((g) this.o0ooOoO).c(MiniRefreshState.PULL_DOWN_TO_REFRESH);
                                } else if (i16 >= 0 || !((this.Oooo0o || this.f290OooOooo) && ((u0.a) this.o00oO0O).e())) {
                                    i11 = i16;
                                } else {
                                    this.OooOO0O = f13;
                                    this.f280OooO = f13;
                                    this.f281OooO0Oo = 0;
                                    ((g) this.o0ooOoO).c(MiniRefreshState.PULL_UP_TO_LOAD);
                                }
                                MiniRefreshState miniRefreshState4 = this.o0Oo0oo;
                                if ((miniRefreshState4.isHeader && i11 < 0) || (miniRefreshState4.isFooter && i11 > 0)) {
                                    if (this.OooO0O0 != 0) {
                                        OooO00o(0.0f);
                                    }
                                    return true;
                                }
                                if (this.o000000o != null) {
                                    this.o000000o = null;
                                    motionEventObtain2.setAction(3);
                                    super.dispatchTouchEvent(motionEventObtain2);
                                }
                                motionEventObtain2.recycle();
                                i16 = i11;
                            }
                            OooO00o(i16);
                            return true;
                        }
                        if (this.o000000 && f17 > this.OooO00o && this.OooO0O0 < 0) {
                            this.o000000 = false;
                        }
                    } else if (actionMasked == 3) {
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                this.f287OooOoOO.addMovement(motionEvent);
                this.f287OooOoOO.computeCurrentVelocity(1000, this.OooOo);
                this.OooOoO0 = (int) this.f287OooOoOO.getYVelocity();
                OooO0O0(0.0f);
                this.f287OooOoOO.clear();
                this.OooOOOO = 'n';
                MotionEvent motionEvent2 = this.o000000o;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                    this.o000000o = null;
                    long eventTime2 = motionEvent.getEventTime();
                    MotionEvent motionEventObtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.f284OooO0oo, f13, 0);
                    super.dispatchTouchEvent(motionEventObtain3);
                    motionEventObtain3.recycle();
                }
                OooO0O0();
                if (this.OooOOOo) {
                    this.OooOOOo = false;
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j11) {
        Paint paint;
        Paint paint2;
        p0.d dVar = this.o00oO0O;
        View view2 = dVar != null ? ((u0.a) dVar).f78104a : null;
        p0.g gVar = this.oo000o;
        if (gVar != null && gVar.getView() == view) {
            if (!OooO00o(this.OooOooO) || (!this.Oooo0OO && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getPaddingTop() + view2.getTop() + this.OooO0O0, view.getTop());
                int i11 = this.oo0o0Oo;
                if (i11 != 0 && (paint2 = this.o0ooOO0) != null) {
                    paint2.setColor(i11);
                    if (this.oo000o.getSpinnerStyle().f75918c) {
                        iMax = view.getBottom();
                    } else if (this.oo000o.getSpinnerStyle() == s0.b.f75911d) {
                        iMax = view.getBottom() + this.OooO0O0;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), iMax, this.o0ooOO0);
                }
                if ((this.Oooo000 && this.oo000o.getSpinnerStyle() == s0.b.f75912e) || this.oo000o.getSpinnerStyle().f75918c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        p0.g gVar2 = this.o00oO0o;
        if (gVar2 != null && gVar2.getView() == view) {
            if (!OooO00o(this.f290OooOooo) || (!this.Oooo0OO && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.OooO0O0, view.getBottom());
                int i12 = this.o0O0O00;
                if (i12 != 0 && (paint = this.o0ooOO0) != null) {
                    paint.setColor(i12);
                    if (this.o00oO0o.getSpinnerStyle().f75918c) {
                        iMin = view.getTop();
                    } else if (this.o00oO0o.getSpinnerStyle() == s0.b.f75911d) {
                        iMin = view.getTop() + this.OooO0O0;
                    }
                    canvas.drawRect(0.0f, iMin, getWidth(), view.getBottom(), this.o0ooOO0);
                }
                if ((this.f291Oooo00O && this.o00oO0o.getSpinnerStyle() == s0.b.f75912e) || this.o00oO0o.getSpinnerStyle().f75918c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j11);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j11);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // p0.i
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.Oooooo0.getNestedScrollAxes();
    }

    @Nullable
    public p0.e getRefreshFooter() {
        p0.g gVar = this.o00oO0o;
        if (gVar instanceof p0.e) {
            return (p0.e) gVar;
        }
        return null;
    }

    @Nullable
    public p0.f getRefreshHeader() {
        p0.g gVar = this.oo000o;
        if (gVar instanceof p0.f) {
            return (p0.f) gVar;
        }
        return null;
    }

    @NonNull
    public MiniRefreshState getState() {
        return this.o0OOO0o;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f296OoooO0O && (this.Oooo0o || this.OooOooO || this.f290OooOooo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        p0.g gVar;
        super.onAttachedToWindow();
        boolean z11 = true;
        this.o000OOo = true;
        if (!isInEditMode()) {
            if (this.oo000o == null) {
                OooO00o(new o0000O(getContext(), null));
            }
            if (this.o00oO0o == null) {
                boolean z12 = this.f290OooOooo;
                OooO00o(new OooO00o(getContext(), null));
                this.f290OooOooo = z12;
            } else {
                if (!this.f290OooOooo && this.f298OoooOOo) {
                    z11 = false;
                }
                this.f290OooOooo = z11;
            }
            if (this.o00oO0O == null) {
                int childCount = getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = getChildAt(i11);
                    p0.g gVar2 = this.oo000o;
                    if ((gVar2 == null || childAt != gVar2.getView()) && ((gVar = this.o00oO0o) == null || childAt != gVar.getView())) {
                        this.o00oO0O = new u0.a(childAt);
                    }
                }
            }
            if (this.o00oO0O == null) {
                int iA = x0.b.a(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R$string.srl_content_empty);
                xb.i.b(textView);
                addView(textView, 0, new f(-1, -1));
                u0.a aVar = new u0.a(textView);
                this.o00oO0O = aVar;
                aVar.f78104a.setPadding(iA, iA, iA, iA);
            }
            View viewFindViewById = findViewById(this.OooOOoo);
            View viewFindViewById2 = findViewById(this.OooOo00);
            u0.a aVar2 = (u0.a) this.o00oO0O;
            aVar2.getClass();
            aVar2.f78112j.f78114b = null;
            u0.a aVar3 = (u0.a) this.o00oO0O;
            aVar3.f78112j.f78115c = this.f294OoooO0;
            aVar3.d(this.o0ooOoO, viewFindViewById, viewFindViewById2);
            if (this.OooO0O0 != 0) {
                OooO00o(MiniRefreshState.NONE);
                p0.d dVar = this.o00oO0O;
                this.OooO0O0 = 0;
                ((u0.a) dVar).c(0, this.OooOo0, this.OooOo0O);
            }
        }
        int[] iArr = this.f288OooOoo;
        if (iArr != null) {
            p0.g gVar3 = this.oo000o;
            if (gVar3 != null) {
                gVar3.setPrimaryColors(iArr);
            }
            p0.g gVar4 = this.o00oO0o;
            if (gVar4 != null) {
                gVar4.setPrimaryColors(this.f288OooOoo);
            }
        }
        p0.d dVar2 = this.o00oO0O;
        if (dVar2 != null) {
            bringChildToFront(((u0.a) dVar2).f78104a);
        }
        p0.g gVar5 = this.oo000o;
        if (gVar5 != null && gVar5.getSpinnerStyle().f75917b) {
            bringChildToFront(this.oo000o.getView());
        }
        p0.g gVar6 = this.o00oO0o;
        if (gVar6 == null || !gVar6.getSpinnerStyle().f75917b) {
            return;
        }
        bringChildToFront(this.o00oO0o.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o000OOo = false;
        this.f298OoooOOo = true;
        this.o00000 = null;
        ValueAnimator valueAnimator = this.o00000O0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.o00000O0.removeAllUpdateListeners();
            this.o00000O0.setDuration(0L);
            this.o00000O0.cancel();
            this.o00000O0 = null;
        }
        p0.g gVar = this.oo000o;
        if (gVar != null && this.o0OOO0o == MiniRefreshState.REFRESHING) {
            gVar.OooO00o(this, false);
        }
        p0.g gVar2 = this.o00oO0o;
        if (gVar2 != null && this.o0OOO0o == MiniRefreshState.LOADING) {
            gVar2.OooO00o(this, false);
        }
        if (this.OooO0O0 != 0) {
            ((g) this.o0ooOoO).b(0, true);
        }
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.NONE;
        if (miniRefreshState != miniRefreshState2) {
            OooO00o(miniRefreshState2);
        }
        Handler handler = this.o0ooOOo;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.o000000 = false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i11;
        int i12;
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i13 = 0;
        int i14 = -1;
        char c11 = 0;
        while (true) {
            i11 = 2;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (x0.b.b(childAt) && (c11 < 2 || i13 == 1)) {
                i14 = i13;
                c11 = 2;
            } else if (!(childAt instanceof p0.g) && c11 < 1) {
                c11 = i13 > 0 ? (char) 1 : (char) 0;
                i14 = i13;
            }
            i13++;
        }
        if (i14 >= 0) {
            this.o00oO0O = new u0.a(getChildAt(i14));
            if (i14 == 1) {
                if (childCount == 3) {
                    i12 = 0;
                } else {
                    i12 = 0;
                    i11 = -1;
                }
            } else if (childCount == 2) {
                i12 = -1;
                i11 = 1;
            } else {
                i12 = -1;
                i11 = -1;
            }
        } else {
            i12 = -1;
            i11 = -1;
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (i15 == i12 || (i15 != i11 && i12 == -1 && this.oo000o == null && (childAt2 instanceof p0.f))) {
                this.oo000o = childAt2 instanceof p0.f ? (p0.f) childAt2 : new o000Oo0(childAt2);
            } else if (i15 == i11 || (i11 == -1 && (childAt2 instanceof p0.e))) {
                this.f290OooOooo = this.f290OooOooo || !this.f298OoooOOo;
                this.o00oO0o = childAt2 instanceof p0.e ? (p0.e) childAt2 : new o000O0o(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                p0.d dVar = this.o00oO0O;
                if (dVar != null && ((u0.a) dVar).f78104a == childAt) {
                    boolean z12 = isInEditMode() && this.Oooo0OO && OooO00o(this.OooOooO) && this.oo000o != null;
                    View view = ((u0.a) this.o00oO0O).f78104a;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : o00000o0;
                    int i16 = marginLayoutParams.leftMargin + paddingLeft;
                    int i17 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i16;
                    int measuredHeight = view.getMeasuredHeight() + i17;
                    if (z12 && OooO00o(this.f292Oooo00o, this.oo000o)) {
                        int i18 = this.Oooooo;
                        i17 += i18;
                        measuredHeight += i18;
                    }
                    view.layout(i16, i17, measuredWidth, measuredHeight);
                }
                p0.g gVar = this.oo000o;
                if (gVar != null && gVar.getView() == childAt) {
                    boolean z13 = isInEditMode() && this.Oooo0OO && OooO00o(this.OooOooO);
                    View view2 = this.oo000o.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : o00000o0;
                    int i19 = marginLayoutParams2.leftMargin;
                    int i21 = marginLayoutParams2.topMargin + this.ooOO;
                    int measuredWidth2 = view2.getMeasuredWidth() + i19;
                    int measuredHeight2 = view2.getMeasuredHeight() + i21;
                    if (!z13 && this.oo000o.getSpinnerStyle() == s0.b.f75911d) {
                        int i22 = this.Oooooo;
                        i21 -= i22;
                        measuredHeight2 -= i22;
                    }
                    view2.layout(i19, i21, measuredWidth2, measuredHeight2);
                }
                p0.g gVar2 = this.o00oO0o;
                if (gVar2 != null && gVar2.getView() == childAt) {
                    boolean z14 = isInEditMode() && this.Oooo0OO && OooO00o(this.f290OooOooo);
                    View view3 = this.o00oO0o.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : o00000o0;
                    s0.b spinnerStyle = this.o00oO0o.getSpinnerStyle();
                    int i23 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (getMeasuredHeight() + marginLayoutParams3.topMargin) - this.o00O0O;
                    if (this.f300o000oOoO && this.f297OoooOOO && this.Oooo0O0 && this.o00oO0O != null && this.o00oO0o.getSpinnerStyle() == s0.b.f75911d && OooO00o(this.f290OooOooo)) {
                        View view4 = ((u0.a) this.o00oO0O).f78104a;
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == s0.b.f75914g) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.o00O0O;
                    } else {
                        if (z14 || spinnerStyle == s0.b.f75913f || spinnerStyle == s0.b.f75912e) {
                            iMax = this.Ooooooo;
                        } else if (spinnerStyle.f75918c && this.OooO0O0 < 0) {
                            iMax = Math.max(OooO00o(this.f290OooOooo) ? -this.OooO0O0 : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i23, measuredHeight3, view3.getMeasuredWidth() + i23, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0212  */
    /* JADX WARN: Code duplicated, block: B:114:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x022d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0236  */
    /* JADX WARN: Code duplicated, block: B:118:0x0249  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cd  */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        View view;
        int i13;
        int i14;
        s0.a aVar;
        boolean z11;
        int iMax;
        int i15;
        int i16;
        boolean z12 = isInEditMode() && this.Oooo0OO;
        int childCount = getChildCount();
        int measuredHeight = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8 && childAt.getTag(R$string.srl_component_falsify) != childAt) {
                p0.g gVar = this.oo000o;
                if (gVar != null && gVar.getView() == childAt) {
                    View view2 = this.oo000o.getView();
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : o00000o0;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int i18 = this.Oooooo;
                    s0.a aVar2 = this.OoooooO;
                    if (aVar2.f75909a >= 6) {
                        iMax = i18;
                    } else {
                        int i19 = layoutParams.height;
                        if (i19 > 0) {
                            iMax = i19 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            s0.a aVar3 = s0.a.f75905e;
                            if (aVar2.b(aVar3)) {
                                this.Oooooo = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.OoooooO = aVar3;
                            }
                        } else if (i19 != -2 || (this.oo000o.getSpinnerStyle() == s0.b.f75914g && this.OoooooO.f75910b)) {
                            iMax = i18;
                        } else {
                            int iMax2 = Math.max((View.MeasureSpec.getSize(i12) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != iMax2) {
                                    s0.a aVar4 = this.OoooooO;
                                    s0.a aVar5 = s0.a.f75904d;
                                    if (aVar4.b(aVar5)) {
                                        this.Oooooo = measuredHeight2 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.OoooooO = aVar5;
                                    }
                                }
                                iMax = -1;
                            } else {
                                iMax = i18;
                            }
                        }
                    }
                    if (this.oo000o.getSpinnerStyle() == s0.b.f75914g) {
                        iMax = View.MeasureSpec.getSize(i12);
                        i16 = -1;
                        i15 = 0;
                    } else {
                        if (!this.oo000o.getSpinnerStyle().f75918c || z12) {
                            i15 = 0;
                        } else {
                            i15 = 0;
                            iMax = Math.max(0, OooO00o(this.OooOooO) ? this.OooO0O0 : 0);
                        }
                        i16 = -1;
                    }
                    if (iMax != i16) {
                        view2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i15), 1073741824));
                    }
                    s0.a aVar6 = this.OoooooO;
                    boolean z13 = aVar6.f75910b;
                    if (!z13) {
                        if (!z13) {
                            aVar6 = s0.a.f75908h[aVar6.f75909a + 1];
                        }
                        this.OoooooO = aVar6;
                        p0.g gVar2 = this.oo000o;
                        h hVar = this.o0ooOoO;
                        int i21 = this.Oooooo;
                        gVar2.OooO00o(hVar, i21, (int) (this.o00Oo0 * i21));
                    }
                    if (z12 && OooO00o(this.OooOooO)) {
                        measuredHeight += view2.getMeasuredHeight();
                    }
                }
                p0.g gVar3 = this.o00oO0o;
                if (gVar3 != null && gVar3.getView() == childAt) {
                    View view3 = this.o00oO0o.getView();
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : o00000o0;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int iMax3 = this.Ooooooo;
                    s0.a aVar7 = this.o0OoOo0;
                    if (aVar7.f75909a < 6) {
                        int i22 = layoutParams2.height;
                        if (i22 > 0) {
                            iMax3 = marginLayoutParams2.bottomMargin + i22 + marginLayoutParams2.topMargin;
                            s0.a aVar8 = s0.a.f75905e;
                            if (aVar7.b(aVar8)) {
                                this.Ooooooo = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.o0OoOo0 = aVar8;
                            }
                        } else if (i22 == -2 && (this.o00oO0o.getSpinnerStyle() != s0.b.f75914g || !this.o0OoOo0.f75910b)) {
                            int iMax4 = Math.max((View.MeasureSpec.getSize(i12) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view3.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                            int measuredHeight3 = view3.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax4) {
                                    s0.a aVar9 = this.o0OoOo0;
                                    s0.a aVar10 = s0.a.f75904d;
                                    if (aVar9.b(aVar10)) {
                                        this.Ooooooo = measuredHeight3 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.o0OoOo0 = aVar10;
                                    }
                                }
                                iMax3 = -1;
                            }
                        }
                    }
                    if (this.o00oO0o.getSpinnerStyle() == s0.b.f75914g) {
                        iMax3 = View.MeasureSpec.getSize(i12);
                    } else {
                        if (this.o00oO0o.getSpinnerStyle().f75918c && !z12) {
                            if (OooO00o(this.f290OooOooo)) {
                                i14 = -this.OooO0O0;
                                i13 = 0;
                            } else {
                                i13 = 0;
                                i14 = 0;
                            }
                            iMax3 = Math.max(i13, i14);
                        }
                        if (iMax3 != -1) {
                            view3.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax3 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i13), 1073741824));
                        }
                        aVar = this.o0OoOo0;
                        z11 = aVar.f75910b;
                        if (z11) {
                            if (!z11) {
                                aVar = s0.a.f75908h[aVar.f75909a + 1];
                            }
                            this.o0OoOo0 = aVar;
                            p0.g gVar4 = this.o00oO0o;
                            h hVar2 = this.o0ooOoO;
                            int i23 = this.Ooooooo;
                            gVar4.OooO00o(hVar2, i23, (int) (this.o00Ooo * i23));
                        }
                        if (z12 && OooO00o(this.f290OooOooo)) {
                            measuredHeight = view3.getMeasuredHeight() + measuredHeight;
                        }
                    }
                    i13 = 0;
                    if (iMax3 != -1) {
                        view3.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax3 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i13), 1073741824));
                    }
                    aVar = this.o0OoOo0;
                    z11 = aVar.f75910b;
                    if (z11) {
                        if (!z11) {
                            aVar = s0.a.f75908h[aVar.f75909a + 1];
                        }
                        this.o0OoOo0 = aVar;
                        p0.g gVar5 = this.o00oO0o;
                        h hVar3 = this.o0ooOoO;
                        int i24 = this.Ooooooo;
                        gVar5.OooO00o(hVar3, i24, (int) (this.o00Ooo * i24));
                    }
                    if (z12) {
                        measuredHeight = view3.getMeasuredHeight() + measuredHeight;
                    }
                }
                p0.d dVar = this.o00oO0O;
                if (dVar != null && (view = ((u0.a) dVar).f78104a) == childAt) {
                    ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : o00000o0;
                    view.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingRight() + getPaddingLeft() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((z12 && (this.oo000o != null && OooO00o(this.OooOooO) && OooO00o(this.f292Oooo00o, this.oo000o))) ? this.Oooooo : 0) + ((z12 && (this.o00oO0o != null && OooO00o(this.f290OooOooo) && OooO00o(this.Oooo0, this.o00oO0o))) ? this.Ooooooo : 0), layoutParams3.height));
                    measuredHeight += view.getMeasuredHeight();
                }
            }
        }
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(measuredHeight, i12));
        this.f285OooOO0 = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z11) {
        return this.OooooOo.dispatchNestedFling(f11, f12, z11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return (this.o000000 && f12 > 0.0f) || OooO0O0(-f12) || this.OooooOo.dispatchNestedPreFling(f11, f12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i11, int i12, @NonNull int[] iArr) {
        int i13 = this.Ooooo0o;
        int i14 = 0;
        if (i12 * i13 > 0) {
            if (Math.abs(i12) > Math.abs(this.Ooooo0o)) {
                int i15 = this.Ooooo0o;
                this.Ooooo0o = 0;
                i14 = i15;
            } else {
                this.Ooooo0o -= i12;
                i14 = i12;
            }
            OooO00o(this.Ooooo0o);
        } else if (i12 > 0 && this.o000000) {
            int i16 = i13 - i12;
            this.Ooooo0o = i16;
            OooO00o(i16);
            i14 = i12;
        }
        this.OooooOo.dispatchNestedPreScroll(i11, i12 - i14, iArr, null);
        iArr[1] = iArr[1] + i14;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14) {
        boolean zDispatchNestedScroll = this.OooooOo.dispatchNestedScroll(i11, i12, i13, i14, this.OooooOO);
        int i15 = i14 + this.OooooOO[1];
        if ((i15 < 0 && (this.OooOooO || this.Oooo0o)) || (i15 > 0 && (this.f290OooOooo || this.Oooo0o))) {
            MiniRefreshState miniRefreshState = this.o0Oo0oo;
            if (miniRefreshState == MiniRefreshState.NONE || miniRefreshState.isOpening) {
                ((g) this.o0ooOoO).c(i15 > 0 ? MiniRefreshState.PULL_UP_TO_LOAD : MiniRefreshState.PULL_DOWN_TO_REFRESH);
                if (!zDispatchNestedScroll) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i16 = this.Ooooo0o - i15;
            this.Ooooo0o = i16;
            OooO00o(i16);
        }
        if (!this.o000000 || i12 >= 0) {
            return;
        }
        this.o000000 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11) {
        this.Oooooo0.onNestedScrollAccepted(view, view2, i11);
        this.OooooOo.startNestedScroll(i11 & 2);
        this.Ooooo0o = this.OooO0O0;
        this.OooooO0 = true;
        OooO00o(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11) {
        return isEnabled() && isNestedScrollingEnabled() && (i11 & 2) != 0 && (this.Oooo0o || this.OooOooO || this.f290OooOooo);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.Oooooo0.onStopNestedScroll(view);
        this.OooooO0 = false;
        this.Ooooo0o = 0;
        OooO0O0();
        this.OooooOo.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z11) {
        if (ViewCompat.isNestedScrollingEnabled(((u0.a) this.o00oO0O).f78106c)) {
            this.OooOOo = z11;
            super.requestDisallowInterceptTouchEvent(z11);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z11) {
        this.f296OoooO0O = z11;
        this.OooooOo.setNestedScrollingEnabled(z11);
    }

    public void setStateDirectLoading(boolean z11) {
        MiniRefreshState miniRefreshState = this.o0OOO0o;
        MiniRefreshState miniRefreshState2 = MiniRefreshState.LOADING;
        if (miniRefreshState != miniRefreshState2) {
            this.o0OO00O = System.currentTimeMillis();
            this.o000000 = true;
            OooO00o(miniRefreshState2);
            w0.b bVar = this.Ooooo00;
            if (bVar == null) {
                OooO00o(2000, true, false);
            } else if (z11) {
                bVar.a(this);
            }
            p0.g gVar = this.o00oO0o;
            if (gVar != null) {
                int i11 = this.Ooooooo;
                gVar.OooO00o(this, i11, (int) (this.o00Ooo * i11));
            }
        }
    }

    public void setStateLoading(boolean z11) {
        b bVar = new b(z11);
        OooO00o(MiniRefreshState.LOAD_RELEASED);
        ValueAnimator valueAnimatorA = ((g) this.o0ooOoO).a(-this.Ooooooo);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(bVar);
        }
        p0.g gVar = this.o00oO0o;
        if (gVar != null) {
            int i11 = this.Ooooooo;
            gVar.OooO0O0(this, i11, (int) (this.o00Ooo * i11));
        }
        if (valueAnimatorA == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z11) {
        c cVar = new c(z11);
        OooO00o(MiniRefreshState.REFRESH_RELEASED);
        ValueAnimator valueAnimatorA = ((g) this.o0ooOoO).a(this.Oooooo);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(cVar);
        }
        p0.g gVar = this.oo000o;
        if (gVar != null) {
            int i11 = this.Oooooo;
            gVar.OooO0O0(this, i11, (int) (this.o00Oo0 * i11));
        }
        if (valueAnimatorA == null) {
            cVar.onAnimationEnd(null);
        }
    }

    public void setViceState(MiniRefreshState miniRefreshState) {
        MiniRefreshState miniRefreshState2 = this.o0OOO0o;
        if (miniRefreshState2.isDragging && miniRefreshState2.isHeader != miniRefreshState.isHeader) {
            OooO00o(MiniRefreshState.NONE);
        }
        if (this.o0Oo0oo != miniRefreshState) {
            this.o0Oo0oo = miniRefreshState;
        }
    }
}
