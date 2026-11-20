package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f15013o = "LottieAnimationView";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m0<Throwable> f15014p = new m0() { // from class: com.airbnb.lottie.f
        @Override // com.airbnb.lottie.m0
        public final void onResult(Object obj) {
            LottieAnimationView.n((Throwable) obj);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0<h> f15015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0<Throwable> f15016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public m0<Throwable> f15017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15018d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieDrawable f15019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f15020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f15022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<UserActionTaken> f15025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<o0> f15026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public LottieTask<h> f15027n;

    /* JADX INFO: compiled from: source.java */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f15030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15031d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f15032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f15034h;

        /* JADX INFO: compiled from: source.java */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f15028a = parcel.readString();
            this.f15030c = parcel.readFloat();
            this.f15031d = parcel.readInt() == 1;
            this.f15032f = parcel.readString();
            this.f15033g = parcel.readInt();
            this.f15034h = parcel.readInt();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f15028a);
            parcel.writeFloat(this.f15030c);
            parcel.writeInt(this.f15031d ? 1 : 0);
            parcel.writeString(this.f15032f);
            parcel.writeInt(this.f15033g);
            parcel.writeInt(this.f15034h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    public class a<T> extends h7.c<T> {
        public a(h7.e eVar) {
        }

        @Override // h7.c
        public T a(h7.b<T> bVar) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements m0<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LottieAnimationView> f15036a;

        public b(LottieAnimationView lottieAnimationView) {
            this.f15036a = new WeakReference<>(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th2) {
            LottieAnimationView lottieAnimationView = this.f15036a.get();
            if (lottieAnimationView == null) {
                return;
            }
            if (lottieAnimationView.f15018d != 0) {
                lottieAnimationView.setImageResource(lottieAnimationView.f15018d);
            }
            (lottieAnimationView.f15017c == null ? LottieAnimationView.f15014p : lottieAnimationView.f15017c).onResult(th2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements m0<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LottieAnimationView> f15037a;

        public c(LottieAnimationView lottieAnimationView) {
            this.f15037a = new WeakReference<>(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.m0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(h hVar) {
            LottieAnimationView lottieAnimationView = this.f15037a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(hVar);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f15015a = new c(this);
        this.f15016b = new b(this);
        this.f15018d = 0;
        this.f15019f = new LottieDrawable();
        this.f15022i = false;
        this.f15023j = false;
        this.f15024k = true;
        this.f15025l = new HashSet();
        this.f15026m = new HashSet();
        k(null, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15015a = new c(this);
        this.f15016b = new b(this);
        this.f15018d = 0;
        this.f15019f = new LottieDrawable();
        this.f15022i = false;
        this.f15023j = false;
        this.f15024k = true;
        this.f15025l = new HashSet();
        this.f15026m = new HashSet();
        k(attributeSet, R$attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f15015a = new c(this);
        this.f15016b = new b(this);
        this.f15018d = 0;
        this.f15019f = new LottieDrawable();
        this.f15022i = false;
        this.f15023j = false;
        this.f15024k = true;
        this.f15025l = new HashSet();
        this.f15026m = new HashSet();
        k(attributeSet, i11);
    }

    public static /* synthetic */ void n(Throwable th2) {
        if (!g7.l.k(th2)) {
            throw new IllegalStateException("Unable to parse composition", th2);
        }
        g7.f.d("Unable to load composition.", th2);
    }

    private void setCompositionTask(LottieTask<h> lottieTask) {
        q0<h> q0VarE = lottieTask.e();
        LottieDrawable lottieDrawable = this.f15019f;
        if (q0VarE != null && lottieDrawable == getDrawable() && lottieDrawable.O() == q0VarE.b()) {
            return;
        }
        this.f15025l.add(UserActionTaken.SET_ANIMATION);
        h();
        g();
        this.f15027n = lottieTask.d(this.f15015a).c(this.f15016b);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f15019f.s(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f15019f.t(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15019f.u(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull o0 o0Var) {
        h composition = getComposition();
        if (composition != null) {
            o0Var.a(composition);
        }
        return this.f15026m.add(o0Var);
    }

    public <T> void addValueCallback(a7.d dVar, T t11, h7.c<T> cVar) {
        this.f15019f.v(dVar, t11, cVar);
    }

    public <T> void addValueCallback(a7.d dVar, T t11, h7.e<T> eVar) {
        this.f15019f.v(dVar, t11, new a(eVar));
    }

    public void cancelAnimation() {
        this.f15023j = false;
        this.f15025l.add(UserActionTaken.PLAY_OPTION);
        this.f15019f.y();
    }

    public <T> void clearValueCallback(a7.d dVar, T t11) {
        this.f15019f.v(dVar, t11, null);
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.f15019f.D();
    }

    public void enableFeatureFlag(LottieFeatureFlag lottieFeatureFlag, boolean z11) {
        this.f15019f.F(lottieFeatureFlag, z11);
    }

    public void enableMergePathsForKitKatAndAbove(boolean z11) {
        this.f15019f.F(LottieFeatureFlag.MergePathsApi19, z11);
    }

    public final void g() {
        LottieTask<h> lottieTask = this.f15027n;
        if (lottieTask != null) {
            lottieTask.k(this.f15015a);
            this.f15027n.j(this.f15016b);
        }
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.f15019f.J();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.f15019f.K();
    }

    public boolean getClipTextToBoundingBox() {
        return this.f15019f.M();
    }

    public boolean getClipToCompositionBounds() {
        return this.f15019f.N();
    }

    @Nullable
    public h getComposition() {
        Drawable drawable = getDrawable();
        LottieDrawable lottieDrawable = this.f15019f;
        if (drawable == lottieDrawable) {
            return lottieDrawable.O();
        }
        return null;
    }

    public long getDuration() {
        h composition = getComposition();
        if (composition != null) {
            return (long) composition.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f15019f.R();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f15019f.T();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f15019f.V();
    }

    public float getMaxFrame() {
        return this.f15019f.X();
    }

    public float getMinFrame() {
        return this.f15019f.Y();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.f15019f.Z();
    }

    public float getProgress() {
        return this.f15019f.a0();
    }

    public RenderMode getRenderMode() {
        return this.f15019f.b0();
    }

    public int getRepeatCount() {
        return this.f15019f.c0();
    }

    public int getRepeatMode() {
        return this.f15019f.d0();
    }

    public float getSpeed() {
        return this.f15019f.e0();
    }

    public final void h() {
        this.f15019f.z();
    }

    public boolean hasMasks() {
        return this.f15019f.h0();
    }

    public boolean hasMatte() {
        return this.f15019f.i0();
    }

    public final LottieTask<h> i(final String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f15097a.l(str);
                }
            }, true);
        }
        return this.f15024k ? r.l(getContext(), str) : r.m(getContext(), str, null);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).b0() == RenderMode.SOFTWARE) {
            this.f15019f.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f15019f;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.f15019f.k0();
    }

    public boolean isFeatureFlagEnabled(LottieFeatureFlag lottieFeatureFlag) {
        return this.f15019f.n0(lottieFeatureFlag);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.f15019f.n0(LottieFeatureFlag.MergePathsApi19);
    }

    public final LottieTask<h> j(final int i11) {
        if (isInEditMode()) {
            return new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f15091a.m(i11);
                }
            }, true);
        }
        return this.f15024k ? r.u(getContext(), i11) : r.v(getContext(), i11, null);
    }

    public final void k(@Nullable AttributeSet attributeSet, int i11) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.LottieAnimationView, i11, 0);
        this.f15024k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f15023j = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false)) {
            this.f15019f.t1(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R$styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        p(typedArrayObtainStyledAttributes.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f), typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_progress));
        enableMergePathsForKitKatAndAbove(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_colorFilter)) {
            addValueCallback(new a7.d("**"), p0.K, (h7.c<ColorFilter>) new h7.c(new t0(d1.a.a(getContext(), typedArrayObtainStyledAttributes.getResourceId(R$styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_renderMode)) {
            int i12 = R$styleable.LottieAnimationView_lottie_renderMode;
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i12, renderMode.ordinal());
            if (iOrdinal >= RenderMode.values().length) {
                iOrdinal = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[iOrdinal]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_asyncUpdates)) {
            int i13 = R$styleable.LottieAnimationView_lottie_asyncUpdates;
            AsyncUpdates asyncUpdates = AsyncUpdates.AUTOMATIC;
            int iOrdinal2 = typedArrayObtainStyledAttributes.getInt(i13, asyncUpdates.ordinal());
            if (iOrdinal2 >= RenderMode.values().length) {
                iOrdinal2 = asyncUpdates.ordinal();
            }
            setAsyncUpdates(AsyncUpdates.values()[iOrdinal2]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(R$styleable.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f15019f.x1(Boolean.valueOf(g7.l.f(getContext()) != 0.0f));
    }

    public final /* synthetic */ q0 l(String str) throws Exception {
        return this.f15024k ? r.n(getContext(), str) : r.o(getContext(), str, null);
    }

    @Deprecated
    public void loop(boolean z11) {
        this.f15019f.t1(z11 ? -1 : 0);
    }

    public final /* synthetic */ q0 m(int i11) throws Exception {
        return this.f15024k ? r.w(getContext(), i11) : r.x(getContext(), i11, null);
    }

    public final void o() {
        boolean zIsAnimating = isAnimating();
        setImageDrawable(null);
        setImageDrawable(this.f15019f);
        if (zIsAnimating) {
            this.f15019f.P0();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f15023j) {
            return;
        }
        this.f15019f.H0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15020g = savedState.f15028a;
        Set<UserActionTaken> set = this.f15025l;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f15020g)) {
            setAnimation(this.f15020g);
        }
        this.f15021h = savedState.f15029b;
        if (!this.f15025l.contains(userActionTaken) && (i11 = this.f15021h) != 0) {
            setAnimation(i11);
        }
        if (!this.f15025l.contains(UserActionTaken.SET_PROGRESS)) {
            p(savedState.f15030c, false);
        }
        if (!this.f15025l.contains(UserActionTaken.PLAY_OPTION) && savedState.f15031d) {
            playAnimation();
        }
        if (!this.f15025l.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f15032f);
        }
        if (!this.f15025l.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f15033g);
        }
        if (this.f15025l.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.f15034h);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15028a = this.f15020g;
        savedState.f15029b = this.f15021h;
        savedState.f15030c = this.f15019f.a0();
        savedState.f15031d = this.f15019f.l0();
        savedState.f15032f = this.f15019f.T();
        savedState.f15033g = this.f15019f.d0();
        savedState.f15034h = this.f15019f.c0();
        return savedState;
    }

    public final void p(float f11, boolean z11) {
        if (z11) {
            this.f15025l.add(UserActionTaken.SET_PROGRESS);
        }
        this.f15019f.r1(f11);
    }

    public void pauseAnimation() {
        this.f15023j = false;
        this.f15019f.G0();
    }

    public void playAnimation() {
        this.f15025l.add(UserActionTaken.PLAY_OPTION);
        this.f15019f.H0();
    }

    public void removeAllAnimatorListeners() {
        this.f15019f.I0();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.f15026m.clear();
    }

    public void removeAllUpdateListeners() {
        this.f15019f.J0();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f15019f.K0(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f15019f.L0(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull o0 o0Var) {
        return this.f15026m.remove(o0Var);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15019f.M0(animatorUpdateListener);
    }

    public List<a7.d> resolveKeyPath(a7.d dVar) {
        return this.f15019f.O0(dVar);
    }

    public void resumeAnimation() {
        this.f15025l.add(UserActionTaken.PLAY_OPTION);
        this.f15019f.P0();
    }

    public void reverseAnimationSpeed() {
        this.f15019f.Q0();
    }

    public void setAnimation(int i11) {
        this.f15021h = i11;
        this.f15020g = null;
        setCompositionTask(j(i11));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(r.p(inputStream, str));
    }

    public void setAnimation(String str) {
        this.f15020g = str;
        this.f15021h = 0;
        setCompositionTask(i(str));
    }

    public void setAnimation(ZipInputStream zipInputStream, @Nullable String str) {
        setCompositionTask(r.B(zipInputStream, str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f15024k ? r.y(getContext(), str) : r.z(getContext(), str, null));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(r.z(getContext(), str, str2));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z11) {
        this.f15019f.S0(z11);
    }

    public void setAsyncUpdates(AsyncUpdates asyncUpdates) {
        this.f15019f.T0(asyncUpdates);
    }

    public void setCacheComposition(boolean z11) {
        this.f15024k = z11;
    }

    public void setClipTextToBoundingBox(boolean z11) {
        this.f15019f.U0(z11);
    }

    public void setClipToCompositionBounds(boolean z11) {
        this.f15019f.V0(z11);
    }

    public void setComposition(@NonNull h hVar) {
        if (d.f15078a) {
            Log.v(f15013o, "Set Composition \n" + hVar);
        }
        this.f15019f.setCallback(this);
        this.f15022i = true;
        boolean zW0 = this.f15019f.W0(hVar);
        if (this.f15023j) {
            this.f15019f.H0();
        }
        this.f15022i = false;
        if (getDrawable() != this.f15019f || zW0) {
            if (!zW0) {
                o();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<o0> it = this.f15026m.iterator();
            while (it.hasNext()) {
                it.next().a(hVar);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f15019f.X0(str);
    }

    public void setFailureListener(@Nullable m0<Throwable> m0Var) {
        this.f15017c = m0Var;
    }

    public void setFallbackResource(int i11) {
        this.f15018d = i11;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f15019f.Y0(aVar);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f15019f.Z0(map);
    }

    public void setFrame(int i11) {
        this.f15019f.a1(i11);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z11) {
        this.f15019f.b1(z11);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f15019f.c1(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f15019f.d1(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f15021h = 0;
        this.f15020g = null;
        g();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f15021h = 0;
        this.f15020g = null;
        g();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i11) {
        this.f15021h = 0;
        this.f15020g = null;
        g();
        super.setImageResource(i11);
    }

    public void setMaintainOriginalImageBounds(boolean z11) {
        this.f15019f.e1(z11);
    }

    public void setMaxFrame(int i11) {
        this.f15019f.f1(i11);
    }

    public void setMaxFrame(String str) {
        this.f15019f.g1(str);
    }

    public void setMaxProgress(float f11) {
        this.f15019f.h1(f11);
    }

    public void setMinAndMaxFrame(int i11, int i12) {
        this.f15019f.i1(i11, i12);
    }

    public void setMinAndMaxFrame(String str) {
        this.f15019f.j1(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z11) {
        this.f15019f.k1(str, str2, z11);
    }

    public void setMinAndMaxProgress(float f11, float f12) {
        this.f15019f.l1(f11, f12);
    }

    public void setMinFrame(int i11) {
        this.f15019f.m1(i11);
    }

    public void setMinFrame(String str) {
        this.f15019f.n1(str);
    }

    public void setMinProgress(float f11) {
        this.f15019f.o1(f11);
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        this.f15019f.p1(z11);
    }

    public void setPerformanceTrackingEnabled(boolean z11) {
        this.f15019f.q1(z11);
    }

    public void setProgress(float f11) {
        p(f11, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f15019f.s1(renderMode);
    }

    public void setRepeatCount(int i11) {
        this.f15025l.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f15019f.t1(i11);
    }

    public void setRepeatMode(int i11) {
        this.f15025l.add(UserActionTaken.SET_REPEAT_MODE);
        this.f15019f.u1(i11);
    }

    public void setSafeMode(boolean z11) {
        this.f15019f.v1(z11);
    }

    public void setSpeed(float f11) {
        this.f15019f.w1(f11);
    }

    public void setTextDelegate(u0 u0Var) {
        this.f15019f.y1(u0Var);
    }

    public void setUseCompositionFrameRate(boolean z11) {
        this.f15019f.z1(z11);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f15022i && drawable == (lottieDrawable = this.f15019f) && lottieDrawable.k0()) {
            pauseAnimation();
        } else if (!this.f15022i && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.k0()) {
                lottieDrawable2.G0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.f15019f.B1(str, bitmap);
    }
}
