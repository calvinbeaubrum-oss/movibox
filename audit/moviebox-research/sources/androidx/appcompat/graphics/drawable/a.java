package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.e0;
import androidx.collection.v;
import androidx.collection.w0;
import b3.k;
import com.transsion.web.api.WebConstants;
import java.io.IOException;
import l6.j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends androidx.appcompat.graphics.drawable.d implements d3.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f954p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f955q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f956r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f957s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f958t;

    /* JADX INFO: compiled from: source.java */
    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animatable f959a;

        public b(Animatable animatable) {
            super();
            this.f959a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f959a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f959a.stop();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends androidx.appcompat.graphics.drawable.d.a {
        public v<Long> K;
        public w0<Integer> L;

        public c(@Nullable c cVar, @NonNull a aVar, @Nullable Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new v<>();
                this.L = new w0<>();
            }
        }

        public static long D(int i11, int i12) {
            return ((long) i12) | (((long) i11) << 32);
        }

        public int B(@NonNull int[] iArr, @NonNull Drawable drawable, int i11) {
            int iZ = super.z(iArr, drawable);
            this.L.m(iZ, Integer.valueOf(i11));
            return iZ;
        }

        public int C(int i11, int i12, @NonNull Drawable drawable, boolean z11) {
            int iA = super.a(drawable);
            long jD = D(i11, i12);
            long j11 = z11 ? 8589934592L : 0L;
            long j12 = iA;
            this.K.a(jD, Long.valueOf(j12 | j11));
            if (z11) {
                this.K.a(D(i12, i11), Long.valueOf(4294967296L | j12 | j11));
            }
            return iA;
        }

        public int E(int i11) {
            if (i11 < 0) {
                return 0;
            }
            return this.L.h(i11, 0).intValue();
        }

        public int F(@NonNull int[] iArr) {
            int iA = super.A(iArr);
            return iA >= 0 ? iA : super.A(StateSet.WILD_CARD);
        }

        public int G(int i11, int i12) {
            return (int) this.K.g(D(i11, i12), -1L).longValue();
        }

        public boolean H(int i11, int i12) {
            return (this.K.g(D(i11, i12), -1L).longValue() & 4294967296L) != 0;
        }

        public boolean I(int i11, int i12) {
            return (this.K.g(D(i11, i12), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.d.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        @Override // androidx.appcompat.graphics.drawable.d.a, androidx.appcompat.graphics.drawable.DrawableContainerCompat.c
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l6.e f960a;

        public d(l6.e eVar) {
            super();
            this.f960a = eVar;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f960a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f960a.stop();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f962b;

        public e(AnimationDrawable animationDrawable, boolean z11, boolean z12) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i11 = z11 ? numberOfFrames - 1 : 0;
            int i12 = z11 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z11);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i11, i12);
            objectAnimatorOfInt.setAutoCancel(true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f962b = z12;
            this.f961a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public boolean a() {
            return this.f962b;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void b() {
            this.f961a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f961a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f961a.cancel();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f965c;

        public f(AnimationDrawable animationDrawable, boolean z11) {
            b(animationDrawable, z11);
        }

        public int a() {
            return this.f965c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z11) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f964b = numberOfFrames;
            int[] iArr = this.f963a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f963a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f963a;
            int i11 = 0;
            for (int i12 = 0; i12 < numberOfFrames; i12++) {
                int duration = animationDrawable.getDuration(z11 ? (numberOfFrames - i12) - 1 : i12);
                iArr2[i12] = duration;
                i11 += duration;
            }
            this.f965c = i11;
            return i11;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            int i11 = (int) ((f11 * this.f965c) + 0.5f);
            int i12 = this.f964b;
            int[] iArr = this.f963a;
            int i13 = 0;
            while (i13 < i12) {
                int i14 = iArr[i13];
                if (i11 < i14) {
                    break;
                }
                i11 -= i14;
                i13++;
            }
            return (i13 / i12) + (i13 < i12 ? i11 / this.f965c : 0.0f);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public a(@Nullable c cVar, @Nullable Resources resources) {
        super(null);
        this.f956r = -1;
        this.f957s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @NonNull
    public static a m(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.n(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void p() {
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.d, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void h(@NonNull DrawableContainerCompat.c cVar) {
        super.h(cVar);
        if (cVar instanceof c) {
            this.f954p = (c) cVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f955q;
        if (gVar != null) {
            gVar.d();
            this.f955q = null;
            g(this.f956r);
            this.f956r = -1;
            this.f957s = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.d
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.f954p, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.d, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f958t && super.mutate() == this) {
            this.f954p.r();
            this.f958t = true;
        }
        return this;
    }

    public void n(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayK.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        t(typedArrayK);
        i(resources);
        typedArrayK.recycle();
        o(context, resources, xmlPullParser, attributeSet, theme);
        p();
    }

    public final void o(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals(WebConstants.FIELD_ITEM)) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    r(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    @Override // androidx.appcompat.graphics.drawable.d, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        int iF = this.f954p.F(iArr);
        boolean z11 = iF != c() && (s(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z11 | current.setState(iArr) : z11;
    }

    public final int q(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? e0.h().j(context, resourceId2) : null;
        typedArrayK.recycle();
        int[] iArrK = k(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? j.c(resources, xmlPullParser, attributeSet, theme) : e1.a.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ != null) {
            return this.f954p.B(iArrK, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int r(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = k.k(resources, theme, attributeSet, R$styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayK.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? e0.h().j(context, resourceId3) : null;
        boolean z11 = typedArrayK.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayK.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? l6.e.b(context, resources, xmlPullParser, attributeSet, theme) : e1.a.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f954p.C(resourceId, resourceId2, drawableJ, z11);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    public final boolean s(int i11) {
        int iC;
        int iG;
        g bVar;
        g gVar = this.f955q;
        if (gVar == null) {
            iC = c();
        } else {
            if (i11 == this.f956r) {
                return true;
            }
            if (i11 == this.f957s && gVar.a()) {
                gVar.b();
                this.f956r = this.f957s;
                this.f957s = i11;
                return true;
            }
            iC = this.f956r;
            gVar.d();
        }
        this.f955q = null;
        this.f957s = -1;
        this.f956r = -1;
        c cVar = this.f954p;
        int iE = cVar.E(iC);
        int iE2 = cVar.E(i11);
        if (iE2 == 0 || iE == 0 || (iG = cVar.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = cVar.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.H(iE, iE2), zI);
        } else {
            if (!(current instanceof l6.e)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((l6.e) current);
        }
        bVar.c();
        this.f955q = bVar;
        this.f957s = iC;
        this.f956r = i11;
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        g gVar = this.f955q;
        if (gVar != null && (visible || z12)) {
            if (z11) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public final void t(TypedArray typedArray) {
        c cVar = this.f954p;
        cVar.f931d |= e1.a.b(typedArray);
        cVar.x(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f936i));
        cVar.t(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f939l));
        cVar.u(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.v(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f951x));
    }
}
