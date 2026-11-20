package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class Carousel extends MotionHelper {
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    public int A;
    public int B;
    public float C;
    public int D;
    public int E;
    public int F;
    public Runnable G;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<View> f6710o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6711p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6712q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MotionLayout f6713r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6714s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6715t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6716u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6717v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6718w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6719x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6720y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6721z;

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public Carousel(Context context) {
        super(context);
        this.f6710o = new ArrayList<>();
        this.f6711p = 0;
        this.f6712q = 0;
        this.f6714s = -1;
        this.f6715t = false;
        this.f6716u = -1;
        this.f6717v = -1;
        this.f6718w = -1;
        this.f6719x = -1;
        this.f6720y = 0.9f;
        this.f6721z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class RunnableC00671 implements Runnable {
                final /* synthetic */ float val$v;

                public RunnableC00671(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f6713r.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f6713r.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f6712q;
                throw null;
            }
        };
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6710o = new ArrayList<>();
        this.f6711p = 0;
        this.f6712q = 0;
        this.f6714s = -1;
        this.f6715t = false;
        this.f6716u = -1;
        this.f6717v = -1;
        this.f6718w = -1;
        this.f6719x = -1;
        this.f6720y = 0.9f;
        this.f6721z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class RunnableC00671 implements Runnable {
                final /* synthetic */ float val$v;

                public RunnableC00671(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f6713r.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f6713r.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f6712q;
                throw null;
            }
        };
        p(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f6710o = new ArrayList<>();
        this.f6711p = 0;
        this.f6712q = 0;
        this.f6714s = -1;
        this.f6715t = false;
        this.f6716u = -1;
        this.f6717v = -1;
        this.f6718w = -1;
        this.f6719x = -1;
        this.f6720y = 0.9f;
        this.f6721z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1

            /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            public class RunnableC00671 implements Runnable {
                final /* synthetic */ float val$v;

                public RunnableC00671(float f11) {
                    this.val$v = f11;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Carousel.this.f6713r.touchAnimateTo(5, 1.0f, this.val$v);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f6713r.setProgress(0.0f);
                Carousel.this.q();
                Carousel.o(Carousel.this);
                int unused = Carousel.this.f6712q;
                throw null;
            }
        };
        p(context, attributeSet);
    }

    public static /* synthetic */ a o(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.f6712q;
    }

    public void jumpToIndex(int i11) {
        this.f6712q = Math.max(0, Math.min(getCount() - 1, i11));
        refresh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @RequiresApi(api = 17)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i11 = 0; i11 < this.f7268b; i11++) {
                int i12 = this.f7267a[i11];
                View viewById = motionLayout.getViewById(i12);
                if (this.f6714s == i12) {
                    this.f6721z = i11;
                }
                this.f6710o.add(viewById);
            }
            this.f6713r = motionLayout;
            if (this.B == 2) {
                p.b transition = motionLayout.getTransition(this.f6717v);
                if (transition != null) {
                    transition.H(5);
                }
                p.b transition2 = this.f6713r.getTransition(this.f6716u);
                if (transition2 != null) {
                    transition2.H(5);
                }
            }
            q();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
        this.F = i11;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.h
    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        int i12 = this.f6712q;
        this.f6711p = i12;
        if (i11 == this.f6719x) {
            this.f6712q = i12 + 1;
        } else if (i11 == this.f6718w) {
            this.f6712q = i12 - 1;
        }
        if (!this.f6715t) {
            throw null;
        }
        throw null;
    }

    public final void p(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.f6714s = typedArrayObtainStyledAttributes.getResourceId(index, this.f6714s);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.f6716u = typedArrayObtainStyledAttributes.getResourceId(index, this.f6716u);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.f6717v = typedArrayObtainStyledAttributes.getResourceId(index, this.f6717v);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.A = typedArrayObtainStyledAttributes.getInt(index, this.A);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.f6718w = typedArrayObtainStyledAttributes.getResourceId(index, this.f6718w);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.f6719x = typedArrayObtainStyledAttributes.getResourceId(index, this.f6719x);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f6720y = typedArrayObtainStyledAttributes.getFloat(index, this.f6720y);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.B = typedArrayObtainStyledAttributes.getInt(index, this.B);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.f6715t = typedArrayObtainStyledAttributes.getBoolean(index, this.f6715t);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void q() {
    }

    public void refresh() {
        if (this.f6710o.size() > 0) {
            this.f6710o.get(0);
            throw null;
        }
        this.f6713r.rebuildScene();
        q();
    }

    public void setAdapter(a aVar) {
    }

    public void transitionToIndex(int i11, int i12) {
        this.D = Math.max(0, Math.min(getCount() - 1, i11));
        int iMax = Math.max(0, i12);
        this.E = iMax;
        this.f6713r.setTransitionDuration(iMax);
        if (i11 < this.f6712q) {
            this.f6713r.transitionToState(this.f6718w, this.E);
        } else {
            this.f6713r.transitionToState(this.f6719x, this.E);
        }
    }
}
