package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f7110w = "ViewTransition";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7111a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f7116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.constraintlayout.widget.b.a f7117g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7120j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7121k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Context f7125o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7112b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7113c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7114d = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7118h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7119i = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7122l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7123m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7124n = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f7126p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7127q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7128r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f7129s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7130t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7131u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7132v = -1;

    /* JADX INFO: compiled from: source.java */
    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7133a;

        public a(s sVar, androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7133a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7133a.a(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m f7137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7139f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public t f7141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Interpolator f7142i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7144k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f7145l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f7146m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7148o;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.constraintlayout.core.motion.utils.d f7140g = new androidx.constraintlayout.core.motion.utils.d();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f7143j = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Rect f7147n = new Rect();

        public b(t tVar, m mVar, int i11, int i12, int i13, Interpolator interpolator, int i14, int i15) {
            this.f7148o = false;
            this.f7141h = tVar;
            this.f7137d = mVar;
            this.f7138e = i11;
            this.f7139f = i12;
            long jNanoTime = System.nanoTime();
            this.f7136c = jNanoTime;
            this.f7146m = jNanoTime;
            this.f7141h.b(this);
            this.f7142i = interpolator;
            this.f7134a = i14;
            this.f7135b = i15;
            if (i13 == 3) {
                this.f7148o = true;
            }
            this.f7145l = i11 == 0 ? Float.MAX_VALUE : 1.0f / i11;
            a();
        }

        public void a() {
            if (this.f7143j) {
                c();
            } else {
                b();
            }
        }

        public void b() {
            long jNanoTime = System.nanoTime();
            long j11 = jNanoTime - this.f7146m;
            this.f7146m = jNanoTime;
            float f11 = this.f7144k + (((float) (j11 * 1.0E-6d)) * this.f7145l);
            this.f7144k = f11;
            if (f11 >= 1.0f) {
                this.f7144k = 1.0f;
            }
            Interpolator interpolator = this.f7142i;
            float interpolation = interpolator == null ? this.f7144k : interpolator.getInterpolation(this.f7144k);
            m mVar = this.f7137d;
            boolean zX = mVar.x(mVar.f6993b, interpolation, jNanoTime, this.f7140g);
            if (this.f7144k >= 1.0f) {
                if (this.f7134a != -1) {
                    this.f7137d.v().setTag(this.f7134a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7135b != -1) {
                    this.f7137d.v().setTag(this.f7135b, null);
                }
                if (!this.f7148o) {
                    this.f7141h.i(this);
                }
            }
            if (this.f7144k < 1.0f || zX) {
                this.f7141h.f();
            }
        }

        public void c() {
            long jNanoTime = System.nanoTime();
            long j11 = jNanoTime - this.f7146m;
            this.f7146m = jNanoTime;
            float f11 = this.f7144k - (((float) (j11 * 1.0E-6d)) * this.f7145l);
            this.f7144k = f11;
            if (f11 < 0.0f) {
                this.f7144k = 0.0f;
            }
            Interpolator interpolator = this.f7142i;
            float interpolation = interpolator == null ? this.f7144k : interpolator.getInterpolation(this.f7144k);
            m mVar = this.f7137d;
            boolean zX = mVar.x(mVar.f6993b, interpolation, jNanoTime, this.f7140g);
            if (this.f7144k <= 0.0f) {
                if (this.f7134a != -1) {
                    this.f7137d.v().setTag(this.f7134a, Long.valueOf(System.nanoTime()));
                }
                if (this.f7135b != -1) {
                    this.f7137d.v().setTag(this.f7135b, null);
                }
                this.f7141h.i(this);
            }
            if (this.f7144k > 0.0f || zX) {
                this.f7141h.f();
            }
        }

        public void d(int i11, float f11, float f12) {
            if (i11 == 1) {
                if (this.f7143j) {
                    return;
                }
                e(true);
            } else {
                if (i11 != 2) {
                    return;
                }
                this.f7137d.v().getHitRect(this.f7147n);
                if (this.f7147n.contains((int) f11, (int) f12) || this.f7143j) {
                    return;
                }
                e(true);
            }
        }

        public void e(boolean z11) {
            int i11;
            this.f7143j = z11;
            if (z11 && (i11 = this.f7139f) != -1) {
                this.f7145l = i11 == 0 ? Float.MAX_VALUE : 1.0f / i11;
            }
            this.f7141h.f();
            this.f7146m = System.nanoTime();
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public s(Context context, XmlPullParser xmlPullParser) {
        byte b11;
        this.f7125o = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (!name.equals("ConstraintOverride")) {
                                b11 = -1;
                            } else {
                                b11 = 2;
                            }
                            break;
                        case -1239391468:
                            if (!name.equals("KeyFrameSet")) {
                                b11 = -1;
                            } else {
                                b11 = 1;
                            }
                            break;
                        case 61998586:
                            if (!name.equals("ViewTransition")) {
                                b11 = -1;
                            } else {
                                b11 = 0;
                            }
                            break;
                        case 366511058:
                            if (!name.equals("CustomMethod")) {
                                b11 = -1;
                            } else {
                                b11 = 4;
                            }
                            break;
                        case 1791837707:
                            if (!name.equals("CustomAttribute")) {
                                b11 = -1;
                            } else {
                                b11 = 3;
                            }
                            break;
                        default:
                            b11 = -1;
                            break;
                    }
                    if (b11 == 0) {
                        m(context, xmlPullParser);
                    } else if (b11 == 1) {
                        this.f7116f = new g(context, xmlPullParser);
                    } else if (b11 == 2) {
                        this.f7117g = androidx.constraintlayout.widget.b.m(context, xmlPullParser);
                    } else if (b11 == 3 || b11 == 4) {
                        ConstraintAttribute.i(context, xmlPullParser, this.f7117g.f7383g);
                    } else {
                        Log.e(f7110w, androidx.constraintlayout.motion.widget.a.a() + " unknown tag " + name);
                        Log.e(f7110w, ".xml:" + xmlPullParser.getLineNumber());
                    }
                } else if (eventType == 3 && "ViewTransition".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    public void b(t tVar, MotionLayout motionLayout, View view) {
        m mVar = new m(view);
        mVar.B(view);
        this.f7116f.a(mVar);
        mVar.I(motionLayout.getWidth(), motionLayout.getHeight(), this.f7118h, System.nanoTime());
        new b(tVar, mVar, this.f7118h, this.f7119i, this.f7112b, f(motionLayout.getContext()), this.f7126p, this.f7127q);
    }

    public void c(t tVar, MotionLayout motionLayout, int i11, androidx.constraintlayout.widget.b bVar, final View... viewArr) {
        if (this.f7113c) {
            return;
        }
        int i12 = this.f7115e;
        if (i12 == 2) {
            b(tVar, motionLayout, viewArr[0]);
            return;
        }
        if (i12 == 1) {
            for (int i13 : motionLayout.getConstraintSetIds()) {
                if (i13 != i11) {
                    androidx.constraintlayout.widget.b constraintSet = motionLayout.getConstraintSet(i13);
                    for (View view : viewArr) {
                        androidx.constraintlayout.widget.b.a aVarX = constraintSet.x(view.getId());
                        androidx.constraintlayout.widget.b.a aVar = this.f7117g;
                        if (aVar != null) {
                            aVar.d(aVarX);
                            aVarX.f7383g.putAll(this.f7117g.f7383g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
        bVar2.q(bVar);
        for (View view2 : viewArr) {
            androidx.constraintlayout.widget.b.a aVarX2 = bVar2.x(view2.getId());
            androidx.constraintlayout.widget.b.a aVar2 = this.f7117g;
            if (aVar2 != null) {
                aVar2.d(aVarX2);
                aVarX2.f7383g.putAll(this.f7117g.f7383g);
            }
        }
        motionLayout.updateState(i11, bVar2);
        motionLayout.updateState(R$id.view_transition, bVar);
        motionLayout.setState(R$id.view_transition, -1, -1);
        p.b bVar3 = new p.b(-1, motionLayout.f6764a, R$id.view_transition, i11);
        for (View view3 : viewArr) {
            p(bVar3, view3);
        }
        motionLayout.setTransition(bVar3);
        motionLayout.transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f7108a.k(viewArr);
            }
        });
    }

    public boolean d(View view) {
        int i11 = this.f7128r;
        boolean z11 = i11 == -1 || view.getTag(i11) != null;
        int i12 = this.f7129s;
        return z11 && (i12 == -1 || view.getTag(i12) == null);
    }

    public int e() {
        return this.f7111a;
    }

    public Interpolator f(Context context) {
        int i11 = this.f7122l;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f7124n);
        }
        if (i11 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.c.c(this.f7123m));
        }
        if (i11 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i11 == 1) {
            return new AccelerateInterpolator();
        }
        if (i11 == 2) {
            return new DecelerateInterpolator();
        }
        if (i11 == 4) {
            return new BounceInterpolator();
        }
        if (i11 == 5) {
            return new OvershootInterpolator();
        }
        if (i11 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f7130t;
    }

    public int h() {
        return this.f7131u;
    }

    public int i() {
        return this.f7112b;
    }

    public boolean j() {
        return !this.f7113c;
    }

    public final /* synthetic */ void k(View[] viewArr) {
        if (this.f7126p != -1) {
            for (View view : viewArr) {
                view.setTag(this.f7126p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f7127q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f7127q, null);
            }
        }
    }

    public boolean l(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f7120j == -1 && this.f7121k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f7120j) {
            return true;
        }
        return this.f7121k != null && (view.getLayoutParams() instanceof ConstraintLayout.b) && (str = ((ConstraintLayout.b) view.getLayoutParams()).f7282c0) != null && str.matches(this.f7121k);
    }

    public final void m(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ViewTransition_android_id) {
                this.f7111a = typedArrayObtainStyledAttributes.getResourceId(index, this.f7111a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f7120j);
                    this.f7120j = resourceId;
                    if (resourceId == -1) {
                        this.f7121k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f7121k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f7120j = typedArrayObtainStyledAttributes.getResourceId(index, this.f7120j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.f7112b = typedArrayObtainStyledAttributes.getInt(index, this.f7112b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.f7113c = typedArrayObtainStyledAttributes.getBoolean(index, this.f7113c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.f7114d = typedArrayObtainStyledAttributes.getInt(index, this.f7114d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.f7118h = typedArrayObtainStyledAttributes.getInt(index, this.f7118h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.f7119i = typedArrayObtainStyledAttributes.getInt(index, this.f7119i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.f7115e = typedArrayObtainStyledAttributes.getInt(index, this.f7115e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i12 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i12 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f7124n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f7122l = -2;
                    }
                } else if (i12 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f7123m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f7122l = -1;
                    } else {
                        this.f7124n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f7122l = -2;
                    }
                } else {
                    this.f7122l = typedArrayObtainStyledAttributes.getInteger(index, this.f7122l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.f7126p = typedArrayObtainStyledAttributes.getResourceId(index, this.f7126p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f7127q = typedArrayObtainStyledAttributes.getResourceId(index, this.f7127q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.f7128r = typedArrayObtainStyledAttributes.getResourceId(index, this.f7128r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.f7129s = typedArrayObtainStyledAttributes.getResourceId(index, this.f7129s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.f7131u = typedArrayObtainStyledAttributes.getResourceId(index, this.f7131u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.f7130t = typedArrayObtainStyledAttributes.getInteger(index, this.f7130t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void n(boolean z11) {
        this.f7113c = !z11;
    }

    public boolean o(int i11) {
        int i12 = this.f7112b;
        if (i12 == 1) {
            return i11 == 0;
        }
        if (i12 == 2) {
            return i11 == 1;
        }
        return i12 == 3 && i11 == 0;
    }

    public final void p(p.b bVar, View view) {
        int i11 = this.f7118h;
        if (i11 != -1) {
            bVar.E(i11);
        }
        bVar.I(this.f7114d);
        bVar.G(this.f7122l, this.f7123m, this.f7124n);
        int id2 = view.getId();
        g gVar = this.f7116f;
        if (gVar != null) {
            ArrayList<d> arrayListD = gVar.d(-1);
            g gVar2 = new g();
            Iterator<d> it = arrayListD.iterator();
            while (it.hasNext()) {
                gVar2.c(it.next().clone().i(id2));
            }
            bVar.t(gVar2);
        }
    }

    public String toString() {
        return "ViewTransition(" + androidx.constraintlayout.motion.widget.a.c(this.f7125o, this.f7111a) + ")";
    }
}
