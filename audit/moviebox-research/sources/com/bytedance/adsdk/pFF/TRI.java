package com.bytedance.adsdk.pFF;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI extends ImageView {
    private static final UFX<Throwable> pFF = new UFX<Throwable>() { // from class: com.bytedance.adsdk.pFF.TRI.1
        @Override // com.bytedance.adsdk.pFF.UFX
        public void sc(Throwable th2) {
            com.bytedance.adsdk.pFF.TRI.TRI.sc(th2);
        }
    };

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final String f26132sc = "TRI";
    private final Set<Object> BT;
    private long Dl;
    private UFX<Throwable> ExN;
    private int FI;
    private pFF Gb;
    private final Runnable HJN;
    private String II;
    private int JPJ;
    private JSONArray McK;

    @RawRes
    private int Ol;
    private String Qj;
    private boolean Ql;
    private final Set<We> SR;
    private int Sfl;
    private int TRI;
    private boolean Tf;
    private boolean UFX;
    private com.bytedance.adsdk.ugeno.zY WH;
    private int WP;
    private final UFX<Throwable> We;
    private qr Xc;
    private Handler YIK;
    private sc cD;
    private int cvk;
    private Ql<qr> dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Ol f26133qr;
    private com.bytedance.adsdk.pFF.zY.zY.zY uEA;
    private final Handler wjp;
    private final UFX<qr> zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.TRI$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26143sc;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f26143sc = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26143sc[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26143sc[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26143sc[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum We {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY extends View.BaseSavedState {
        public static final Parcelable.Creator<zY> CREATOR = new Parcelable.Creator<zY>() { // from class: com.bytedance.adsdk.pFF.TRI.zY.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public zY createFromParcel(Parcel parcel) {
                return new zY(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public zY[] newArray(int i11) {
                return new zY[i11];
            }
        };
        String ExN;
        int TRI;
        boolean We;
        int pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        int f26150qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        String f26151sc;
        float zY;

        private zY(Parcel parcel) {
            super(parcel);
            this.f26151sc = parcel.readString();
            this.zY = parcel.readFloat();
            this.We = parcel.readInt() == 1;
            this.ExN = parcel.readString();
            this.TRI = parcel.readInt();
            this.f26150qr = parcel.readInt();
        }

        public zY(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f26151sc);
            parcel.writeFloat(this.zY);
            parcel.writeInt(this.We ? 1 : 0);
            parcel.writeString(this.ExN);
            parcel.writeInt(this.TRI);
            parcel.writeInt(this.f26150qr);
        }
    }

    public TRI(Context context) {
        super(context);
        this.zY = new UFX<qr>() { // from class: com.bytedance.adsdk.pFF.TRI.6
            @Override // com.bytedance.adsdk.pFF.UFX
            public void sc(qr qrVar) {
                TRI.this.setComposition(qrVar);
            }
        };
        this.We = new UFX<Throwable>() { // from class: com.bytedance.adsdk.pFF.TRI.7
            @Override // com.bytedance.adsdk.pFF.UFX
            public void sc(Throwable th2) {
                if (TRI.this.TRI != 0) {
                    TRI tri = TRI.this;
                    tri.setImageResource(tri.TRI);
                }
                (TRI.this.ExN == null ? TRI.pFF : TRI.this.ExN).sc(th2);
            }
        };
        this.TRI = 0;
        this.f26133qr = new Ol();
        this.UFX = false;
        this.Tf = false;
        this.Ql = true;
        this.SR = new HashSet();
        this.BT = new HashSet();
        this.wjp = new Handler(Looper.getMainLooper());
        this.Sfl = 0;
        this.Dl = 0L;
        this.HJN = new Runnable() { // from class: com.bytedance.adsdk.pFF.TRI.4
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb2 = new StringBuilder("--==--- timer callback, timer: ");
                sb2.append(TRI.this.JPJ);
                sb2.append(", ");
                sb2.append(TRI.this.FI);
                if (TRI.this.JPJ > TRI.this.FI) {
                    TRI.wjp(TRI.this);
                    com.bytedance.adsdk.pFF.zY.zY.zY zYVar = TRI.this.uEA;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(TRI.this.JPJ);
                    zYVar.sc(sb3.toString());
                    TRI.this.invalidate();
                    TRI.this.BT();
                    return;
                }
                if (TRI.this.WP < 0 || TRI.this.cvk < 0) {
                    StringBuilder sb4 = new StringBuilder("--==--- timer end, frame invalid: ");
                    sb4.append(TRI.this.WP);
                    sb4.append(",");
                    sb4.append(TRI.this.cvk);
                } else {
                    new StringBuilder("--==--- timer end, play anim, startframe: ").append(TRI.this.WP);
                    TRI.this.sc();
                    TRI tri = TRI.this;
                    tri.setFrame(tri.WP);
                    TRI.this.sc(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.TRI.4.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (TRI.this.getFrame() < TRI.this.cvk - 1 || TRI.this.getFrame() >= TRI.this.cvk + 2) {
                                return;
                            }
                            new StringBuilder("--==--- timer end, play anim, endframe: ").append(TRI.this.cvk);
                            TRI.this.pFF(this);
                            TRI.this.TRI();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(TRI.this.II) || (TRI.this.McK != null && TRI.this.McK.length() > 0)) && TRI.this.Gb != null) {
                    pFF unused = TRI.this.Gb;
                    String unused2 = TRI.this.II;
                    JSONArray unused3 = TRI.this.McK;
                }
            }
        };
        Qj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        this.wjp.postDelayed(this.HJN, 1000L);
    }

    public static /* synthetic */ int ExN(TRI tri) {
        int i11 = tri.Sfl;
        tri.Sfl = i11 + 1;
        return i11;
    }

    private void Ol() {
        sc(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.pFF.TRI.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                TRI.this.pFF(this);
                TRI.this.SR();
                TRI.this.UFX();
            }
        });
    }

    private void Qj() {
        setSaveEnabled(false);
        this.Ql = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        sc(0.0f, false);
        sc(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.f26133qr.sc(Boolean.valueOf(com.bytedance.adsdk.pFF.TRI.TRI.sc(getContext()) != 0.0f));
        Ol();
        WH();
        Tf();
    }

    private void Ql() {
        Ql<qr> ql2 = this.dE;
        if (ql2 != null) {
            ql2.pFF(this.zY);
            this.dE.We(this.We);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR() {
        Ol ol2;
        int i11;
        int i12;
        final int i13;
        if (this.Xc == null || (ol2 = this.f26133qr) == null) {
            return;
        }
        YIK yikFI = ol2.FI();
        qr.zY zYVarQj = this.Xc.Qj();
        if (zYVarQj == null || yikFI == null) {
            return;
        }
        final int i14 = zYVarQj.f26178sc;
        if (i14 < 0) {
            "--==--- timer fail, ke is invalid: ".concat(String.valueOf(i14));
            return;
        }
        int[] iArr = zYVarQj.ExN;
        final int i15 = -1;
        if (iArr == null || iArr.length < 2) {
            i11 = -1;
            i12 = -1;
        } else {
            i12 = iArr[0];
            i11 = iArr[1];
        }
        String strSc = yikFI.sc(zYVarQj.zY);
        String strSc2 = yikFI.sc(zYVarQj.We);
        try {
            i13 = Integer.parseInt(strSc);
            try {
                i15 = Integer.parseInt(strSc2);
            } catch (NumberFormatException unused) {
            }
        } catch (NumberFormatException unused2) {
            i13 = -1;
        }
        StringBuilder sb2 = new StringBuilder("--==--- prepare timer, startS: ");
        sb2.append(i13);
        sb2.append(", lenS: ");
        sb2.append(i15);
        if (TextUtils.isEmpty(zYVarQj.pFF)) {
            new StringBuilder("--==--- timer fail, id is invalid: ").append(zYVarQj.pFF);
            return;
        }
        new StringBuilder("--==--- timer, id:").append(zYVarQj.pFF);
        com.bytedance.adsdk.pFF.zY.zY.zY zYVarZY = zY(zYVarQj.pFF);
        if (zYVarZY != null) {
            this.II = zYVarQj.TRI;
            this.McK = zYVarQj.f26177qr;
            this.uEA = zYVarZY;
            this.JPJ = i13;
            this.FI = i13 - i15;
            this.WP = i12;
            this.cvk = i11;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.JPJ);
            zYVarZY.sc(sb3.toString());
            sc(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.TRI.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (TRI.this.getFrame() < i14 - 1 || TRI.this.getFrame() >= i14 + 2) {
                        return;
                    }
                    new StringBuilder("--==--- enter timer point, frame: ").append(TRI.this.getFrame());
                    TRI.this.pFF(this);
                    if (i13 >= 0 && i15 >= 0) {
                        TRI.this.BT();
                    }
                    TRI.this.TRI();
                }
            });
        }
    }

    private void Tf() {
        sc(new Animator.AnimatorListener() { // from class: com.bytedance.adsdk.pFF.TRI.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                YIK yikFI;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - TRI.this.Dl;
                TRI.this.pFF(this);
                String playDelayedELExpressTimeS = TRI.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (yikFI = TRI.this.f26133qr.FI()) != null) {
                    try {
                        int i11 = Integer.parseInt(yikFI.sc(playDelayedELExpressTimeS)) * 1000;
                        if (TRI.this.Dl > 0) {
                            long jElapsedRealtime2 = (TRI.this.Dl + ((long) i11)) - SystemClock.elapsedRealtime();
                            "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2));
                            if (jElapsedRealtime2 > 0) {
                                TRI.this.TRI();
                                TRI.this.setVisibility(8);
                                if (TRI.this.YIK == null) {
                                    TRI.this.YIK = new Handler(Looper.getMainLooper());
                                }
                                TRI.this.YIK.removeCallbacksAndMessages(null);
                                TRI.this.YIK.postDelayed(new Runnable() { // from class: com.bytedance.adsdk.pFF.TRI.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TRI.this.setVisibility(0);
                                        TRI.this.sc();
                                        TRI.this.sc(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                TRI.this.sc(jElapsedRealtime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UFX() {
        final qr.sc globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.ExN <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.TRI) && globalConfig.f26175qr == null) {
            return;
        }
        int maxFrame = globalConfig.ExN;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        sc(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.TRI.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                TRI.this.pFF(this);
                if (TRI.this.Gb != null) {
                    pFF unused = TRI.this.Gb;
                }
            }
        });
    }

    private void WH() {
        sc(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.TRI.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i11;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                TRI.ExN(TRI.this);
                qr.sc globalConfig = TRI.this.getGlobalConfig();
                if (globalConfig != null && (i11 = globalConfig.We) > 0 && i11 > TRI.this.Sfl) {
                    TRI.this.SR();
                    TRI.this.sc();
                    TRI.this.setProgress(0.0f);
                } else {
                    TRI.this.pFF(this);
                    if (TRI.this.cD != null) {
                        sc unused = TRI.this.cD;
                    }
                }
            }
        });
    }

    private void We(Matrix matrix, float f11, float f12, float f13, float f14) {
        if (f13 >= f11 || f14 >= f12) {
            if (f13 / f14 >= f11 / f12) {
                float f15 = f11 / f13;
                matrix.preScale(f15, f15);
                matrix.postTranslate(0.0f, (f12 - (f14 * f15)) / 2.0f);
                return;
            } else {
                float f16 = f12 / f14;
                matrix.preScale(f16, f16);
                matrix.postTranslate((f11 - (f13 * f16)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f13 / f14 >= f11 / f12) {
            float f17 = f11 / f13;
            matrix.preScale(f17, f17);
            matrix.postTranslate(0.0f, (f12 - (f14 * f17)) / 2.0f);
        } else {
            float f18 = f12 / f14;
            matrix.preScale(f18, f18);
            matrix.postTranslate((f11 - (f13 * f18)) / 2.0f, 0.0f);
        }
    }

    private void Xc() {
        this.Xc = null;
        this.f26133qr.WH();
    }

    private void dE() {
        this.wjp.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qr.sc getGlobalConfig() {
        qr qrVarCvk;
        Ol ol2 = this.f26133qr;
        if (ol2 == null || (qrVarCvk = ol2.cvk()) == null) {
            return null;
        }
        return qrVarCvk.UFX();
    }

    private qr.pFF getGlobalEvent() {
        qr qrVarCvk;
        Ol ol2 = this.f26133qr;
        if (ol2 == null || (qrVarCvk = ol2.cvk()) == null) {
            return null;
        }
        return qrVarCvk.WH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        qr qrVarCvk;
        Ol ol2 = this.f26133qr;
        if (ol2 == null || (qrVarCvk = ol2.cvk()) == null) {
            return null;
        }
        return qrVarCvk.Ol();
    }

    private Ql<qr> pFF(final String str) {
        if (isInEditMode()) {
            return new Ql<>(new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.TRI.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                public Tf<qr> call() throws Exception {
                    return TRI.this.Ql ? Qj.zY(TRI.this.getContext(), str) : Qj.zY(TRI.this.getContext(), str, null);
                }
            }, true);
        }
        return this.Ql ? Qj.pFF(getContext(), str) : Qj.pFF(getContext(), str, (String) null);
    }

    private void pFF(Matrix matrix, float f11, float f12, float f13, float f14) {
        if (f13 < f11 && f14 < f12) {
            matrix.postTranslate((f11 - f13) / 2.0f, (f12 - f14) / 2.0f);
            return;
        }
        if (f13 / f14 >= f11 / f12) {
            float f15 = f11 / f13;
            matrix.preScale(f15, f15);
            matrix.postTranslate(0.0f, (f12 - (f14 * f15)) / 2.0f);
        } else {
            float f16 = f12 / f14;
            matrix.preScale(f16, f16);
            matrix.postTranslate((f11 - (f13 * f16)) / 2.0f, 0.0f);
        }
    }

    private void pFF(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.f26133qr.getBounds().width();
        float fHeight = this.f26133qr.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i11 = AnonymousClass5.f26143sc[getScaleType().ordinal()];
        if (i11 == 1) {
            sc(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 2) {
            pFF(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 3) {
            zY(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 4) {
            We(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private Ql<qr> sc(@RawRes final int i11) {
        if (isInEditMode()) {
            return new Ql<>(new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.TRI.13
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                public Tf<qr> call() throws Exception {
                    return TRI.this.Ql ? Qj.pFF(TRI.this.getContext(), i11) : Qj.pFF(TRI.this.getContext(), i11, (String) null);
                }
            }, true);
        }
        return this.Ql ? Qj.sc(getContext(), i11) : Qj.sc(getContext(), i11, (String) null);
    }

    private WH sc(String str) {
        Ol ol2;
        qr qrVarCvk;
        Map<String, WH> mapDE;
        if (TextUtils.isEmpty(str) || (ol2 = this.f26133qr) == null || (qrVarCvk = ol2.cvk()) == null || (mapDE = qrVarCvk.dE()) == null) {
            return null;
        }
        return mapDE.get(str);
    }

    private com.bytedance.adsdk.pFF.zY.zY.sc sc(MotionEvent motionEvent) {
        com.bytedance.adsdk.pFF.zY.zY.pFF pFF2;
        Ol ol2 = this.f26133qr;
        if (ol2 == null || (pFF2 = ol2.pFF()) == null) {
            return null;
        }
        return sc(pFF2, motionEvent);
    }

    private com.bytedance.adsdk.pFF.zY.zY.sc sc(com.bytedance.adsdk.pFF.zY.zY.pFF pff, MotionEvent motionEvent) {
        com.bytedance.adsdk.pFF.zY.zY.sc scVarSc;
        for (com.bytedance.adsdk.pFF.zY.zY.sc scVar : pff.Tf()) {
            if (scVar instanceof com.bytedance.adsdk.pFF.zY.zY.pFF) {
                if (scVar.Qj() && scVar.TRI() > 0.0f) {
                    RectF rectF = new RectF();
                    scVar.sc(rectF, scVar.We(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (scVarSc = sc((com.bytedance.adsdk.pFF.zY.zY.pFF) scVar, motionEvent)) != null) {
                        return scVarSc;
                    }
                }
            } else if (scVar.Qj() && scVar.TRI() > 0.0f) {
                RectF rectF2 = new RectF();
                Ol ol2 = this.f26133qr;
                if (ol2 == null || !ol2.qr()) {
                    RectF rectF3 = new RectF();
                    scVar.sc(rectF3, scVar.We(), true);
                    pFF(rectF2, rectF3);
                } else {
                    scVar.sc(rectF2, scVar.We(), true);
                    RectF rectFGb = this.f26133qr.Gb();
                    if (rectFGb != null) {
                        sc(rectF2, rectFGb);
                    }
                }
                if (sc(motionEvent, rectF2)) {
                    return scVar;
                }
            }
        }
        return null;
    }

    private com.bytedance.adsdk.pFF.zY.zY.zY sc(com.bytedance.adsdk.pFF.zY.zY.pFF pff, String str) {
        for (com.bytedance.adsdk.pFF.zY.zY.sc scVar : pff.Tf()) {
            if (scVar instanceof com.bytedance.adsdk.pFF.zY.zY.pFF) {
                com.bytedance.adsdk.pFF.zY.zY.zY zYVarSc = sc((com.bytedance.adsdk.pFF.zY.zY.pFF) scVar, str);
                if (zYVarSc != null) {
                    return zYVarSc;
                }
            } else if (TextUtils.equals(str, scVar.Ol()) && (scVar instanceof com.bytedance.adsdk.pFF.zY.zY.zY)) {
                return (com.bytedance.adsdk.pFF.zY.zY.zY) scVar;
            }
        }
        return null;
    }

    private void sc(@FloatRange(from = 0.0d, to = 1.0d) float f11, boolean z11) {
        if (z11) {
            this.SR.add(We.SET_PROGRESS);
        }
        this.f26133qr.We(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(long j11) {
        Map<String, Object> map;
        qr.sc globalConfig = getGlobalConfig();
        if (this.cD != null) {
            HashMap map2 = new HashMap();
            map2.put("duration", Long.valueOf(j11));
            if (globalConfig == null || (map = globalConfig.pFF) == null || map.isEmpty()) {
                return;
            }
            map2.putAll(globalConfig.pFF);
        }
    }

    private void sc(Matrix matrix, float f11, float f12, float f13, float f14) {
        if (f13 / f14 >= f11 / f12) {
            float f15 = f12 / f14;
            matrix.preScale(f15, f15);
            matrix.postTranslate(-(((f13 * f15) - f11) / 2.0f), 0.0f);
        } else {
            float f16 = f11 / f13;
            matrix.preScale(f16, f16);
            matrix.postTranslate(0.0f, -(((f14 * f16) - f12) / 2.0f));
        }
    }

    private void sc(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i11 = AnonymousClass5.f26143sc[getScaleType().ordinal()];
        if (i11 == 1) {
            sc(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 2) {
            pFF(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 3) {
            zY(matrix, width, height, fWidth, fHeight);
        } else if (i11 == 4) {
            We(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    private void sc(String str, String str2, JSONArray jSONArray) {
        qr.pFF globalEvent = getGlobalEvent();
        if (globalEvent != null && str != null) {
            if (TextUtils.isEmpty(str2) && !str.contains("CSJNO")) {
                str2 = globalEvent.f26174sc;
            }
            if ((jSONArray == null || jSONArray.length() <= 0) && !str.contains("CSJLELNO")) {
                jSONArray = globalEvent.zY;
            }
        }
        if (!TextUtils.isEmpty(str2) || jSONArray == null) {
            return;
        }
        jSONArray.length();
    }

    private void sc(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i11 = iArr2[0];
            final int i12 = iArr2[1];
            if (i11 < 0 || i12 < 0) {
                return;
            }
            "--==--- inel enter, play anim, startframe: ".concat(String.valueOf(i11));
            dE();
            sc();
            setFrame(i11);
            sc(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.pFF.TRI.12
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (TRI.this.getFrame() < i12 - 1 || TRI.this.getFrame() >= i12 + 2) {
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder("--==--- inel enter, play anim end, endframe: ");
                    sb2.append(i12);
                    sb2.append(", realFrame: ");
                    sb2.append(TRI.this.getFrame());
                    TRI.this.pFF(this);
                    TRI.this.TRI();
                }
            });
        } catch (Throwable unused) {
        }
    }

    private boolean sc(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (x11 >= rectF.left && x11 <= rectF.right && y11 >= rectF.top && y11 <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void setCompositionTask(Ql<qr> ql2) {
        this.SR.add(We.SET_ANIMATION);
        Xc();
        Ql();
        this.dE = ql2.sc(this.zY).zY(this.We);
    }

    public static /* synthetic */ int wjp(TRI tri) {
        int i11 = tri.JPJ;
        tri.JPJ = i11 - 1;
        return i11;
    }

    private void wjp() {
        boolean zWe = We();
        setImageDrawable(null);
        setImageDrawable(this.f26133qr);
        if (zWe) {
            this.f26133qr.Ql();
        }
    }

    private com.bytedance.adsdk.pFF.zY.zY.zY zY(String str) {
        com.bytedance.adsdk.pFF.zY.zY.pFF pFF2;
        Ol ol2 = this.f26133qr;
        if (ol2 == null || (pFF2 = ol2.pFF()) == null) {
            return null;
        }
        return sc(pFF2, str);
    }

    private void zY(Matrix matrix, float f11, float f12, float f13, float f14) {
        matrix.postTranslate((f11 - f13) / 2.0f, (f12 - f14) / 2.0f);
    }

    @MainThread
    public void ExN() {
        this.SR.add(We.PLAY_OPTION);
        this.f26133qr.II();
    }

    @MainThread
    public void TRI() {
        this.Tf = false;
        this.f26133qr.McK();
    }

    public boolean We() {
        return this.f26133qr.uEA();
    }

    public boolean getClipToCompositionBounds() {
        return this.f26133qr.zY();
    }

    public qr getComposition() {
        return this.Xc;
    }

    public long getDuration() {
        qr qrVar = this.Xc;
        if (qrVar != null) {
            return (long) qrVar.ExN();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f26133qr.Sfl();
    }

    public String getImageAssetsFolder() {
        return this.f26133qr.We();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f26133qr.ExN();
    }

    public float getMaxFrame() {
        return this.f26133qr.BT();
    }

    public float getMinFrame() {
        return this.f26133qr.SR();
    }

    public wjp getPerformanceTracker() {
        return this.f26133qr.Qj();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f26133qr.HJN();
    }

    public Sfl getRenderMode() {
        return this.f26133qr.TRI();
    }

    public int getRepeatCount() {
        return this.f26133qr.Dl();
    }

    public int getRepeatMode() {
        return this.f26133qr.YIK();
    }

    public float getSpeed() {
        return this.f26133qr.dE();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof Ol) && ((Ol) drawable).TRI() == Sfl.SOFTWARE) {
            this.f26133qr.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        Ol ol2 = this.f26133qr;
        if (drawable2 == ol2) {
            super.invalidateDrawable(ol2);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.Tf) {
            this.f26133qr.UFX();
        }
        com.bytedance.adsdk.ugeno.zY zYVar = this.WH;
        if (zYVar != null) {
            zYVar.qr();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dE();
        Handler handler = this.YIK;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        zY();
        pFF();
        com.bytedance.adsdk.ugeno.zY zYVar = this.WH;
        if (zYVar != null) {
            zYVar.Qj();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        if (!(parcelable instanceof zY)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        zY zYVar = (zY) parcelable;
        super.onRestoreInstanceState(zYVar.getSuperState());
        this.Qj = zYVar.f26151sc;
        Set<We> set = this.SR;
        We we2 = We.SET_ANIMATION;
        if (!set.contains(we2) && !TextUtils.isEmpty(this.Qj)) {
            setAnimation(this.Qj);
        }
        this.Ol = zYVar.pFF;
        if (!this.SR.contains(we2) && (i11 = this.Ol) != 0) {
            setAnimation(i11);
        }
        if (!this.SR.contains(We.SET_PROGRESS)) {
            sc(zYVar.zY, false);
        }
        if (!this.SR.contains(We.PLAY_OPTION) && zYVar.We) {
            sc();
        }
        if (!this.SR.contains(We.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(zYVar.ExN);
        }
        if (!this.SR.contains(We.SET_REPEAT_MODE)) {
            setRepeatMode(zYVar.TRI);
        }
        if (this.SR.contains(We.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(zYVar.f26150qr);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        zY zYVar = new zY(super.onSaveInstanceState());
        zYVar.f26151sc = this.Qj;
        zYVar.pFF = this.Ol;
        zYVar.zY = this.f26133qr.HJN();
        zYVar.We = this.f26133qr.JPJ();
        zYVar.ExN = this.f26133qr.We();
        zYVar.TRI = this.f26133qr.YIK();
        zYVar.f26150qr = this.f26133qr.Dl();
        return zYVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int[][] iArr;
        com.bytedance.adsdk.pFF.zY.zY.sc scVarSc = sc(motionEvent);
        if (scVarSc == null) {
            if (getGlobalConfig() == null || getGlobalConfig().f26176sc != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        String strOl = scVarSc.Ol();
        if (scVarSc instanceof com.bytedance.adsdk.pFF.zY.zY.pFF) {
            if (getGlobalConfig() == null || getGlobalConfig().f26176sc != 1) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        if (strOl != null && strOl.startsWith("CSJCLOSE")) {
            dE();
        }
        WH whSc = sc(scVarSc.ExN());
        if (whSc != null && motionEvent.getAction() == 1) {
            sc(strOl, whSc.ExN(), whSc.qr());
            int[][] iArrTRI = whSc.TRI();
            if (iArrTRI != null) {
                sc(iArrTRI);
            } else if (getGlobalEvent() != null && (iArr = getGlobalEvent().pFF) != null) {
                sc(iArr);
            }
        }
        if (strOl == null || !strOl.startsWith("CSJNTP")) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void pFF() {
        this.f26133qr.Xc();
    }

    public void pFF(Animator.AnimatorListener animatorListener) {
        this.f26133qr.pFF(animatorListener);
    }

    public void pFF(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f26133qr.pFF(animatorUpdateListener);
    }

    public Bitmap sc(String str, Bitmap bitmap) {
        return this.f26133qr.sc(str, bitmap);
    }

    @MainThread
    public void sc() {
        if (this.Dl == 0) {
            this.Dl = SystemClock.elapsedRealtime();
        }
        this.SR.add(We.PLAY_OPTION);
        this.f26133qr.UFX();
    }

    public void sc(Animator.AnimatorListener animatorListener) {
        this.f26133qr.sc(animatorListener);
    }

    public void sc(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f26133qr.sc(animatorUpdateListener);
    }

    public void sc(com.bytedance.adsdk.ugeno.zY zYVar) {
        this.WH = zYVar;
    }

    public void sc(InputStream inputStream, String str) {
        setCompositionTask(Qj.sc(inputStream, str));
    }

    public void sc(String str, String str2) {
        sc(new ByteArrayInputStream(str.getBytes()), str2);
    }

    @Deprecated
    public void sc(boolean z11) {
        this.f26133qr.ExN(z11 ? -1 : 0);
    }

    public void sc(boolean z11, Context context) {
        this.f26133qr.sc(z11, context);
    }

    public void setAnimation(@RawRes int i11) {
        this.Ol = i11;
        this.Qj = null;
        setCompositionTask(sc(i11));
    }

    public void setAnimation(String str) {
        this.Qj = str;
        this.Ol = 0;
        setCompositionTask(pFF(str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        sc(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.Ql ? Qj.sc(getContext(), str) : Qj.sc(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z11) {
        this.f26133qr.ExN(z11);
    }

    public void setCacheComposition(boolean z11) {
        this.Ql = z11;
    }

    public void setClipToCompositionBounds(boolean z11) {
        this.f26133qr.sc(z11);
    }

    public void setComposition(qr qrVar) {
        if (ExN.f26084sc) {
            Log.v(f26132sc, "Set Composition \n".concat(String.valueOf(qrVar)));
        }
        this.f26133qr.setCallback(this);
        this.Xc = qrVar;
        this.UFX = true;
        boolean zSc = this.f26133qr.sc(qrVar, getContext().getApplicationContext());
        this.UFX = false;
        if (getDrawable() != this.f26133qr || zSc) {
            if (!zSc) {
                wjp();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.BT.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f26133qr.qr(str);
    }

    public void setFailureListener(UFX<Throwable> ufx) {
        this.ExN = ufx;
    }

    public void setFallbackResource(int i11) {
        this.TRI = i11;
    }

    public void setFontAssetDelegate(com.bytedance.adsdk.pFF.zY zYVar) {
        this.f26133qr.sc(zYVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f26133qr.sc(map);
    }

    public void setFrame(int i11) {
        this.f26133qr.zY(i11);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z11) {
        this.f26133qr.qr(z11);
    }

    public void setImageAssetDelegate(com.bytedance.adsdk.pFF.We we2) {
        this.f26133qr.sc(we2);
    }

    public void setImageAssetsFolder(String str) {
        this.f26133qr.sc(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        Ql();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Ql();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        Ql();
        super.setImageResource(i11);
    }

    public void setLottieAnimListener(sc scVar) {
        this.cD = scVar;
    }

    public void setLottieClicklistener(pFF pff) {
        this.Gb = pff;
    }

    public void setMaintainOriginalImageBounds(boolean z11) {
        this.f26133qr.pFF(z11);
    }

    public void setMaxFrame(int i11) {
        this.f26133qr.pFF(i11);
    }

    public void setMaxFrame(String str) {
        this.f26133qr.zY(str);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.f26133qr.pFF(f11);
    }

    public void setMinAndMaxFrame(String str) {
        this.f26133qr.We(str);
    }

    public void setMinFrame(int i11) {
        this.f26133qr.sc(i11);
    }

    public void setMinFrame(String str) {
        this.f26133qr.pFF(str);
    }

    public void setMinProgress(float f11) {
        this.f26133qr.sc(f11);
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        this.f26133qr.We(z11);
    }

    public void setPerformanceTrackingEnabled(boolean z11) {
        this.f26133qr.zY(z11);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        sc(f11, true);
    }

    public void setRenderMode(Sfl sfl) {
        this.f26133qr.sc(sfl);
    }

    public void setRepeatCount(int i11) {
        this.SR.add(We.SET_REPEAT_COUNT);
        this.f26133qr.ExN(i11);
    }

    public void setRepeatMode(int i11) {
        this.SR.add(We.SET_REPEAT_MODE);
        this.f26133qr.We(i11);
    }

    public void setSafeMode(boolean z11) {
        this.f26133qr.TRI(z11);
    }

    public void setSpeed(float f11) {
        this.f26133qr.zY(f11);
    }

    public void setTextDelegate(YIK yik) {
        this.f26133qr.sc(yik);
    }

    public void setUseCompositionFrameRate(boolean z11) {
        this.f26133qr.Qj(z11);
    }

    public void setView(View view) {
        this.f26133qr.sc(view);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        Ol ol2;
        if (!this.UFX && drawable == (ol2 = this.f26133qr) && ol2.uEA()) {
            TRI();
        } else if (!this.UFX && (drawable instanceof Ol)) {
            Ol ol3 = (Ol) drawable;
            if (ol3.uEA()) {
                ol3.McK();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void zY() {
        this.f26133qr.wjp();
    }
}
