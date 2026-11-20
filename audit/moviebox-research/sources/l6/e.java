package l6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b3.k;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends i implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f69984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f69985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f69986d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f69987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animator.AnimatorListener f69988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<l6.b> f69989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Drawable.Callback f69990i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            e.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            e.this.scheduleSelf(runnable, j11);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            e.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(e.this.f69989h);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((l6.b) arrayList.get(i11)).b(e.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(e.this.f69989h);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((l6.b) arrayList.get(i11)).c(e.this);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f69993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f69994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AnimatorSet f69995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f69996d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.collection.a<Animator, String> f69997e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f69993a = cVar.f69993a;
                j jVar = cVar.f69994b;
                if (jVar != null) {
                    Drawable.ConstantState constantState = jVar.getConstantState();
                    if (resources != null) {
                        this.f69994b = (j) constantState.newDrawable(resources);
                    } else {
                        this.f69994b = (j) constantState.newDrawable();
                    }
                    j jVar2 = (j) this.f69994b.mutate();
                    this.f69994b = jVar2;
                    jVar2.setCallback(callback);
                    this.f69994b.setBounds(cVar.f69994b.getBounds());
                    this.f69994b.h(false);
                }
                ArrayList<Animator> arrayList = cVar.f69996d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f69996d = new ArrayList<>(size);
                    this.f69997e = new androidx.collection.a<>(size);
                    for (int i11 = 0; i11 < size; i11++) {
                        Animator animator = cVar.f69996d.get(i11);
                        Animator animatorClone = animator.clone();
                        String str = cVar.f69997e.get(animator);
                        animatorClone.setTarget(this.f69994b.d(str));
                        this.f69996d.add(animatorClone);
                        this.f69997e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f69995c == null) {
                this.f69995c = new AnimatorSet();
            }
            this.f69995c.playTogether(this.f69996d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f69993a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f69998a;

        public d(Drawable.ConstantState constantState) {
            this.f69998a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f69998a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f69998a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            e eVar = new e();
            Drawable drawableNewDrawable = this.f69998a.newDrawable();
            eVar.f70001a = drawableNewDrawable;
            drawableNewDrawable.setCallback(eVar.f69990i);
            return eVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            e eVar = new e();
            Drawable drawableNewDrawable = this.f69998a.newDrawable(resources);
            eVar.f70001a = drawableNewDrawable;
            drawableNewDrawable.setCallback(eVar.f69990i);
            return eVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            e eVar = new e();
            Drawable drawableNewDrawable = this.f69998a.newDrawable(resources, theme);
            eVar.f70001a = drawableNewDrawable;
            drawableNewDrawable.setCallback(eVar.f69990i);
            return eVar;
        }
    }

    public e() {
        this(null, null, null);
    }

    public e(@Nullable Context context) {
        this(context, null, null);
    }

    public e(@Nullable Context context, @Nullable c cVar, @Nullable Resources resources) {
        this.f69986d = null;
        this.f69988g = null;
        this.f69989h = null;
        a aVar = new a();
        this.f69990i = aVar;
        this.f69985c = context;
        if (cVar != null) {
            this.f69984b = cVar;
        } else {
            this.f69984b = new c(context, cVar, aVar, resources);
        }
    }

    @Nullable
    public static e a(@NonNull Context context, int i11) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            e eVar = new e(context);
            Drawable drawableE = b3.h.e(context.getResources(), i11, context.getTheme());
            eVar.f70001a = drawableE;
            drawableE.setCallback(eVar.f69990i);
            eVar.f69987f = new d(eVar.f70001a.getConstantState());
            return eVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i11);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return b(context, context.getResources(), xml, attributeSetAsAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e11) {
            Log.e("AnimatedVDCompat", "parser error", e11);
            return null;
        } catch (XmlPullParserException e12) {
            Log.e("AnimatedVDCompat", "parser error", e12);
            return null;
        }
    }

    public static e b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        e eVar = new e(context);
        eVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return eVar;
    }

    @RequiresApi(23)
    public static void d(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull l6.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    @RequiresApi(23)
    public static boolean h(AnimatedVectorDrawable animatedVectorDrawable, l6.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.a(drawable, theme);
        }
    }

    public void c(@NonNull l6.b bVar) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f69989h == null) {
            this.f69989h = new ArrayList<>();
        }
        if (this.f69989h.contains(bVar)) {
            return;
        }
        this.f69989h.add(bVar);
        if (this.f69988g == null) {
            this.f69988g = new b();
        }
        this.f69984b.f69995c.addListener(this.f69988g);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            return d3.a.b(drawable);
        }
        return false;
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f69984b.f69994b.draw(canvas);
        if (this.f69984b.f69995c.isStarted()) {
            invalidateSelf();
        }
    }

    public final void e() {
        Animator.AnimatorListener animatorListener = this.f69988g;
        if (animatorListener != null) {
            this.f69984b.f69995c.removeListener(animatorListener);
            this.f69988g = null;
        }
    }

    public final void f(String str, Animator animator) {
        animator.setTarget(this.f69984b.f69994b.d(str));
        c cVar = this.f69984b;
        if (cVar.f69996d == null) {
            cVar.f69996d = new ArrayList<>();
            this.f69984b.f69997e = new androidx.collection.a<>();
        }
        this.f69984b.f69996d.add(animator);
        this.f69984b.f69997e.put(animator, str);
    }

    public boolean g(@NonNull l6.b bVar) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList<l6.b> arrayList = this.f69989h;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(bVar);
        if (this.f69989h.size() == 0) {
            e();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.d(drawable) : this.f69984b.f69994b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f69984b.f69993a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.e(drawable) : this.f69984b.f69994b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f70001a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f70001a.getConstantState());
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f69984b.f69994b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f69984b.f69994b.getIntrinsicWidth();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.getOpacity() : this.f69984b.f69994b.getOpacity();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayK = k.k(resources, theme, attributeSet, l6.a.f69974e);
                    int resourceId = typedArrayK.getResourceId(0, 0);
                    if (resourceId != 0) {
                        j jVarB = j.b(resources, resourceId, theme);
                        jVarB.h(false);
                        jVarB.setCallback(this.f69990i);
                        j jVar = this.f69984b.f69994b;
                        if (jVar != null) {
                            jVar.setCallback(null);
                        }
                        this.f69984b.f69994b = jVarB;
                    }
                    typedArrayK.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, l6.a.f69975f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f69985c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        f(string, g.i(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f69984b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f70001a;
        return drawable != null ? d3.a.h(drawable) : this.f69984b.f69994b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f70001a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f69984b.f69995c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.isStateful() : this.f69984b.f69994b.isStateful();
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f69984b.f69994b.setBounds(rect);
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.setLevel(i11) : this.f69984b.f69994b.setLevel(i11);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f70001a;
        return drawable != null ? drawable.setState(iArr) : this.f69984b.f69994b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else {
            this.f69984b.f69994b.setAlpha(i11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.j(drawable, z11);
        } else {
            this.f69984b.f69994b.setAutoMirrored(z11);
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f69984b.f69994b.setColorFilter(colorFilter);
        }
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z11) {
        super.setFilterBitmap(z11);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    @Override // l6.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.n(drawable, i11);
        } else {
            this.f69984b.f69994b.setTint(i11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.o(drawable, colorStateList);
        } else {
            this.f69984b.f69994b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            d3.a.p(drawable, mode);
        } else {
            this.f69984b.f69994b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            return drawable.setVisible(z11, z12);
        }
        this.f69984b.f69994b.setVisible(z11, z12);
        return super.setVisible(z11, z12);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f69984b.f69995c.isStarted()) {
                return;
            }
            this.f69984b.f69995c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f70001a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f69984b.f69995c.end();
        }
    }
}
