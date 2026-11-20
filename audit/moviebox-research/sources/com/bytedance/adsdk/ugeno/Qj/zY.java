package com.bytedance.adsdk.ugeno.Qj;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.google.logging.type.LogSeverity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends ViewGroup {
    private float BR;
    private TRI BT;
    private ExN Bs;
    private VelocityTracker CYO;
    private int Cb;
    private final Runnable DNB;
    private float Dl;
    private boolean FI;
    private int GI;
    private int Gb;
    private boolean HJN;
    private int II;
    private int JPJ;
    private int JoC;
    private boolean McK;
    private int MxZ;
    private int NP;
    private ArrayList<View> NQ;
    private boolean OKY;
    private float OXF;
    private final Rect Ol;
    private boolean QLv;
    private final pFF Qj;
    private Scroller Ql;
    private boolean SR;
    private int Sfl;
    private ClassLoader Tf;
    private Parcelable UFX;
    private int WH;
    private boolean WP;
    int We;
    private Drawable Xc;
    private float YIK;
    private int YdT;
    private boolean Yhz;
    private We ZM;
    private int bSP;
    private int cD;
    private float cJ;
    private boolean cvk;
    private int dE;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    private EdgeEffect f26351eo;
    private List<Object> fT;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    private List<We> f26352ht;
    private We idT;
    private float kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    private int f26353ko;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    private int f26354pc;
    private int qKn;
    private boolean qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final ArrayList<pFF> f26355qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26356sc;
    private int uEA;
    private int wjp;
    private EdgeEffect yL;
    com.bytedance.adsdk.ugeno.Qj.pFF zY;
    static final int[] pFF = {R.attr.layout_gravity};
    private static final Comparator<pFF> ExN = new Comparator<pFF>() { // from class: com.bytedance.adsdk.ugeno.Qj.zY.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int compare(pFF pff, pFF pff2) {
            return pff.pFF - pff2.pFF;
        }
    };
    private static final Interpolator TRI = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.Qj.zY.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    };
    private static final Qj kDg = new Qj();

    /* JADX INFO: compiled from: source.java */
    public interface ExN {
        void sc(View view, float f11);
    }

    /* JADX INFO: compiled from: source.java */
    public static class Qj implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0227zY c0227zY = (C0227zY) view.getLayoutParams();
            C0227zY c0227zY2 = (C0227zY) view2.getLayoutParams();
            boolean z11 = c0227zY.f26360sc;
            if (z11 != c0227zY2.f26360sc) {
                return z11 ? 1 : -1;
            }
            return c0227zY.ExN - c0227zY2.ExN;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class TRI extends DataSetObserver {
        public TRI() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            zY.this.pFF();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            zY.this.pFF();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface We {
        void Qj(int i11);

        void sc(int i11, float f11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        float ExN;
        float We;
        int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        Object f26359sc;
        boolean zY;
    }

    /* JADX INFO: compiled from: source.java */
    public static class qr extends com.bytedance.adsdk.ugeno.Qj.sc {
        public static final Parcelable.Creator<qr> CREATOR = new Parcelable.ClassLoaderCreator<qr>() { // from class: com.bytedance.adsdk.ugeno.Qj.zY.qr.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public qr createFromParcel(Parcel parcel) {
                return new qr(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public qr createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new qr(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public qr[] newArray(int i11) {
                return new qr[i11];
            }
        };
        ClassLoader We;
        int pFF;
        Parcelable zY;

        public qr(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.pFF = parcel.readInt();
            this.zY = parcel.readParcelable(classLoader);
            this.We = classLoader;
        }

        public qr(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.pFF + "}";
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.sc, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.pFF);
            parcel.writeParcelable(this.zY, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface sc {
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Qj.zY$zY, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0227zY extends ViewGroup.LayoutParams {
        int ExN;
        int TRI;
        boolean We;
        public int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public boolean f26360sc;
        float zY;

        public C0227zY() {
            super(-1, -1);
            this.zY = 0.0f;
        }

        public C0227zY(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.zY = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zY.pFF);
            this.pFF = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public zY(Context context) {
        super(context);
        this.f26355qr = new ArrayList<>();
        this.Qj = new pFF();
        this.Ol = new Rect();
        this.WH = -1;
        this.UFX = null;
        this.Tf = null;
        this.YIK = -3.4028235E38f;
        this.Dl = Float.MAX_VALUE;
        this.II = 1;
        this.JoC = -1;
        this.Yhz = true;
        this.qfG = false;
        this.DNB = new Runnable() { // from class: com.bytedance.adsdk.ugeno.Qj.zY.3
            @Override // java.lang.Runnable
            public void run() {
                zY.this.setScrollState(0);
                zY.this.zY();
            }
        };
        this.NP = 0;
        sc();
    }

    private void ExN(int i11) {
        We we2 = this.ZM;
        if (we2 != null) {
            we2.Qj(i11);
        }
        List<We> list = this.f26352ht;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                We we3 = this.f26352ht.get(i12);
                if (we3 != null) {
                    we3.Qj(i11);
                }
            }
        }
        We we4 = this.idT;
        if (we4 != null) {
            we4.Qj(i11);
        }
    }

    private pFF Ol() {
        int i11;
        int clientWidth = getClientWidth();
        float f11 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f12 = clientWidth > 0 ? this.dE / clientWidth : 0.0f;
        pFF pff = null;
        float f13 = 0.0f;
        int i12 = -1;
        int i13 = 0;
        boolean z11 = true;
        while (i13 < this.f26355qr.size()) {
            pFF pff2 = this.f26355qr.get(i13);
            if (!z11 && pff2.pFF != (i11 = i12 + 1)) {
                pff2 = this.Qj;
                pff2.ExN = f11 + f13 + f12;
                pff2.pFF = i11;
                pff2.We = this.zY.sc(i11);
                i13--;
            }
            pFF pff3 = pff2;
            f11 = pff3.ExN;
            float f14 = pff3.We + f11 + f12;
            if (!z11 && scrollX < f11) {
                return pff;
            }
            if (scrollX < f14 || i13 == this.f26355qr.size() - 1) {
                return pff3;
            }
            int i14 = pff3.pFF;
            float f15 = pff3.We;
            i13++;
            z11 = false;
            i12 = i14;
            f13 = f15;
            pff = pff3;
        }
        return pff;
    }

    private boolean Qj() {
        this.JoC = -1;
        WH();
        this.f26351eo.onRelease();
        this.yL.onRelease();
        return this.f26351eo.isFinished() || this.yL.isFinished();
    }

    private void TRI() {
        int i11 = 0;
        while (i11 < getChildCount()) {
            if (!((C0227zY) getChildAt(i11).getLayoutParams()).f26360sc) {
                removeViewAt(i11);
                i11--;
            }
            i11++;
        }
    }

    private void TRI(int i11) {
        List<We> list = this.f26352ht;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                this.f26352ht.get(i12);
            }
        }
    }

    private void WH() {
        this.McK = false;
        this.HJN = false;
        VelocityTracker velocityTracker = this.CYO;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.CYO = null;
        }
    }

    private boolean We(int i11) {
        if (this.f26355qr.size() == 0) {
            if (this.Yhz) {
                return false;
            }
            this.OKY = false;
            sc(0, 0.0f, 0);
            if (this.OKY) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        pFF pffOl = Ol();
        int clientWidth = getClientWidth();
        int i12 = this.dE;
        int i13 = clientWidth + i12;
        float f11 = clientWidth;
        int i14 = pffOl.pFF;
        float f12 = ((i11 / f11) - pffOl.ExN) / (pffOl.We + (i12 / f11));
        this.OKY = false;
        sc(i14, f12, (int) (i13 * f12));
        if (this.OKY) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void pFF(int i11, float f11, int i12) {
        We we2 = this.ZM;
        if (we2 != null) {
            we2.sc(i11, f11, i12);
        }
        List<We> list = this.f26352ht;
        if (list != null) {
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                We we3 = this.f26352ht.get(i13);
                if (we3 != null) {
                    we3.sc(i11, f11, i12);
                }
            }
        }
        We we4 = this.idT;
        if (we4 != null) {
            we4.sc(i11, f11, i12);
        }
    }

    private void pFF(boolean z11) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11).setLayerType(z11 ? this.YdT : 0, null);
        }
    }

    private boolean pFF(float f11) {
        boolean z11;
        boolean z12;
        float f12 = this.OXF - f11;
        this.OXF = f11;
        float scrollX = getScrollX() + f12;
        float clientWidth = getClientWidth();
        float f13 = this.YIK * clientWidth;
        float f14 = this.Dl * clientWidth;
        boolean z13 = false;
        pFF pff = this.f26355qr.get(0);
        ArrayList<pFF> arrayList = this.f26355qr;
        pFF pff2 = arrayList.get(arrayList.size() - 1);
        if (pff.pFF != 0) {
            f13 = pff.ExN * clientWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (pff2.pFF != this.zY.sc() - 1) {
            f14 = pff2.ExN * clientWidth;
            z12 = false;
        } else {
            z12 = true;
        }
        if (scrollX < f13) {
            if (z11) {
                this.f26351eo.onPull(Math.abs(f13 - scrollX) / clientWidth);
                z13 = true;
            }
            scrollX = f13;
        } else if (scrollX > f14) {
            if (z12) {
                this.yL.onPull(Math.abs(scrollX - f14) / clientWidth);
                z13 = true;
            }
            scrollX = f14;
        }
        int i11 = (int) scrollX;
        this.OXF += scrollX - i11;
        scrollTo(i11, getScrollY());
        We(i11);
        return z13;
    }

    private void qr() {
        if (this.bSP != 0) {
            ArrayList<View> arrayList = this.NQ;
            if (arrayList == null) {
                this.NQ = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                this.NQ.add(getChildAt(i11));
            }
            Collections.sort(this.NQ, kDg);
        }
    }

    private int sc(int i11, float f11, int i12, int i13) {
        if (Math.abs(i13) <= this.GI || Math.abs(i12) <= this.qKn) {
            i11 += (int) (f11 + (i11 >= this.We ? 0.4f : 0.6f));
        } else if (i12 <= 0) {
            i11++;
        }
        if (this.f26355qr.size() <= 0) {
            return i11;
        }
        pFF pff = this.f26355qr.get(0);
        ArrayList<pFF> arrayList = this.f26355qr;
        return Math.max(pff.pFF, Math.min(i11, arrayList.get(arrayList.size() - 1).pFF));
    }

    private Rect sc(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void sc(int i11, int i12, int i13, int i14) {
        if (i12 > 0 && !this.f26355qr.isEmpty()) {
            if (!this.Ql.isFinished()) {
                this.Ql.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i12 - getPaddingLeft()) - getPaddingRight()) + i14)) * (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)), getScrollY());
                return;
            }
        }
        pFF pFF2 = pFF(this.We);
        int iMin = (int) ((pFF2 != null ? Math.min(pFF2.ExN, this.Dl) : 0.0f) * ((i11 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            sc(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void sc(int i11, boolean z11, int i12, boolean z12) {
        pFF pFF2 = pFF(i11);
        int clientWidth = pFF2 != null ? (int) (getClientWidth() * Math.max(this.YIK, Math.min(pFF2.ExN, this.Dl))) : 0;
        if (z11) {
            sc(clientWidth, 0, i12);
            if (z12) {
                ExN(i11);
                return;
            }
            return;
        }
        if (z12) {
            ExN(i11);
        }
        sc(false);
        scrollTo(clientWidth, 0);
        We(clientWidth);
    }

    private void sc(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.JoC) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.OXF = motionEvent.getX(i11);
            this.JoC = motionEvent.getPointerId(i11);
            VelocityTracker velocityTracker = this.CYO;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void sc(pFF pff, int i11, pFF pff2) {
        int i12;
        int i13;
        pFF pff3;
        pFF pff4;
        int iSc = this.zY.sc();
        int clientWidth = getClientWidth();
        float f11 = clientWidth > 0 ? this.dE / clientWidth : 0.0f;
        if (pff2 != null) {
            int i14 = pff2.pFF;
            int i15 = pff.pFF;
            if (i14 < i15) {
                float fSc = pff2.ExN + pff2.We + f11;
                int i16 = i14 + 1;
                int i17 = 0;
                while (i16 <= pff.pFF && i17 < this.f26355qr.size()) {
                    pFF pff5 = this.f26355qr.get(i17);
                    while (true) {
                        pff4 = pff5;
                        if (i16 <= pff4.pFF || i17 >= this.f26355qr.size() - 1) {
                            break;
                        }
                        i17++;
                        pff5 = this.f26355qr.get(i17);
                    }
                    while (i16 < pff4.pFF) {
                        fSc += this.zY.sc(i16) + f11;
                        i16++;
                    }
                    pff4.ExN = fSc;
                    fSc += pff4.We + f11;
                    i16++;
                }
            } else if (i14 > i15) {
                int size = this.f26355qr.size() - 1;
                float fSc2 = pff2.ExN;
                while (true) {
                    i14--;
                    if (i14 < pff.pFF || size < 0) {
                        break;
                    }
                    pFF pff6 = this.f26355qr.get(size);
                    while (true) {
                        pff3 = pff6;
                        if (i14 >= pff3.pFF || size <= 0) {
                            break;
                        }
                        size--;
                        pff6 = this.f26355qr.get(size);
                    }
                    while (i14 > pff3.pFF) {
                        fSc2 -= this.zY.sc(i14) + f11;
                        i14--;
                    }
                    fSc2 -= pff3.We + f11;
                    pff3.ExN = fSc2;
                }
            }
        }
        int size2 = this.f26355qr.size();
        float fSc3 = pff.ExN;
        int i18 = pff.pFF;
        int i19 = i18 - 1;
        this.YIK = i18 == 0 ? fSc3 : -3.4028235E38f;
        int i21 = iSc - 1;
        this.Dl = i18 == i21 ? (pff.We + fSc3) - 1.0f : Float.MAX_VALUE;
        int i22 = i11 - 1;
        while (i22 >= 0) {
            pFF pff7 = this.f26355qr.get(i22);
            while (true) {
                i13 = pff7.pFF;
                if (i19 <= i13) {
                    break;
                }
                fSc3 -= this.zY.sc(i19) + f11;
                i19--;
            }
            fSc3 -= pff7.We + f11;
            pff7.ExN = fSc3;
            if (i13 == 0) {
                this.YIK = fSc3;
            }
            i22--;
            i19--;
        }
        float fSc4 = pff.ExN + pff.We + f11;
        int i23 = pff.pFF + 1;
        int i24 = i11 + 1;
        while (i24 < size2) {
            pFF pff8 = this.f26355qr.get(i24);
            while (true) {
                i12 = pff8.pFF;
                if (i23 >= i12) {
                    break;
                }
                fSc4 += this.zY.sc(i23) + f11;
                i23++;
            }
            if (i12 == i21) {
                this.Dl = (pff8.We + fSc4) - 1.0f;
            }
            pff8.ExN = fSc4;
            fSc4 += pff8.We + f11;
            i24++;
            i23++;
        }
        this.qfG = false;
    }

    private void sc(boolean z11) {
        boolean z12 = this.NP == 2;
        if (z12) {
            setScrollingCacheEnabled(false);
            if (!this.Ql.isFinished()) {
                this.Ql.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.Ql.getCurrX();
                int currY = this.Ql.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        We(currX);
                    }
                }
            }
        }
        this.cvk = false;
        for (int i11 = 0; i11 < this.f26355qr.size(); i11++) {
            pFF pff = this.f26355qr.get(i11);
            if (pff.zY) {
                pff.zY = false;
                z12 = true;
            }
        }
        if (z12) {
            if (z11) {
                postOnAnimation(this.DNB);
            } else {
                this.DNB.run();
            }
        }
    }

    private boolean sc(float f11, float f12) {
        if (f11 >= this.cD || f12 <= 0.0f) {
            return f11 > ((float) (getWidth() - this.cD)) && f12 < 0.0f;
        }
        return true;
    }

    private void setScrollingCacheEnabled(boolean z11) {
        if (this.WP != z11) {
            this.WP = z11;
        }
    }

    private void zY(boolean z11) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z11);
        }
    }

    private static boolean zY(View view) {
        return view.getClass().getAnnotation(sc.class) != null;
    }

    public boolean ExN() {
        com.bytedance.adsdk.ugeno.Qj.pFF pff = this.zY;
        if (pff == null || this.We >= pff.sc() - 1) {
            return false;
        }
        sc(this.We + 1, true);
        return true;
    }

    public boolean We() {
        int i11 = this.We;
        if (i11 <= 0) {
            return false;
        }
        sc(i11 - 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        pFF pffSc;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i13 = 0; i13 < getChildCount(); i13++) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 0 && (pffSc = sc(childAt)) != null && pffSc.pFF == this.We) {
                    childAt.addFocusables(arrayList, i11, i12);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i12 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        pFF pffSc;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (pffSc = sc(childAt)) != null && pffSc.pFF == this.We) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0227zY c0227zY = (C0227zY) layoutParams;
        boolean zZY = c0227zY.f26360sc | zY(view);
        c0227zY.f26360sc = zZY;
        if (!this.FI) {
            super.addView(view, i11, layoutParams);
        } else {
            if (zZY) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0227zY.We = true;
            addViewInLayout(view, i11, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i11) {
        if (this.zY == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i11 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.YIK));
        }
        return i11 > 0 && scrollX < ((int) (((float) clientWidth) * this.Dl));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0227zY) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.SR = true;
        if (this.Ql.isFinished() || !this.Ql.computeScrollOffset()) {
            sc(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.Ql.getCurrX();
        int currY = this.Ql.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!We(currX)) {
                this.Ql.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || sc(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        pFF pffSc;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (pffSc = sc(childAt)) != null && pffSc.pFF == this.We && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zDraw;
        com.bytedance.adsdk.ugeno.Qj.pFF pff;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0 && (overScrollMode != 1 || (pff = this.zY) == null || pff.sc() <= 1)) {
            this.f26351eo.finish();
            this.yL.finish();
            return;
        }
        if (this.f26351eo.isFinished()) {
            zDraw = false;
        } else {
            int iSave = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((-height) + getPaddingTop(), this.YIK * width);
            this.f26351eo.setSize(height, width);
            zDraw = this.f26351eo.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (!this.yL.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.Dl + 1.0f)) * width2);
            this.yL.setSize(height2, width2);
            zDraw |= this.yL.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.Xc;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0227zY();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0227zY(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.Qj.pFF getAdapter() {
        return this.zY;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i11, int i12) {
        if (this.bSP == 2) {
            i12 = (i11 - 1) - i12;
        }
        return ((C0227zY) this.NQ.get(i12).getLayoutParams()).TRI;
    }

    public int getCurrentItem() {
        return this.We;
    }

    public int getOffscreenPageLimit() {
        return this.II;
    }

    public int getPageMargin() {
        return this.dE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Yhz = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.DNB);
        Scroller scroller = this.Ql;
        if (scroller != null && !scroller.isFinished()) {
            this.Ql.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i11;
        float f11;
        super.onDraw(canvas);
        if (this.dE <= 0 || this.Xc == null || this.f26355qr.size() <= 0 || this.zY == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f12 = width;
        float f13 = this.dE / f12;
        int i12 = 0;
        pFF pff = this.f26355qr.get(0);
        float f14 = pff.ExN;
        int size = this.f26355qr.size();
        int i13 = pff.pFF;
        int i14 = this.f26355qr.get(size - 1).pFF;
        while (i13 < i14) {
            while (true) {
                i11 = pff.pFF;
                if (i13 <= i11 || i12 >= size) {
                    break;
                }
                i12++;
                pff = this.f26355qr.get(i12);
            }
            if (i13 == i11) {
                float f15 = pff.ExN;
                float f16 = pff.We;
                f11 = (f15 + f16) * f12;
                f14 = f15 + f16 + f13;
            } else {
                float fSc = this.zY.sc(i13);
                f11 = (f14 + fSc) * f12;
                f14 += fSc + f13;
            }
            if (this.dE + f11 > scrollX) {
                this.Xc.setBounds(Math.round(f11), this.wjp, Math.round(this.dE + f11), this.Sfl);
                this.Xc.draw(canvas);
            }
            if (f11 > scrollX + width) {
                return;
            }
            i13++;
            f13 = f13;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            Qj();
            return false;
        }
        if (action != 0) {
            if (this.McK) {
                return true;
            }
            if (this.HJN) {
                return false;
            }
        }
        if (action == 0) {
            float x11 = motionEvent.getX();
            this.kX = x11;
            this.OXF = x11;
            float y11 = motionEvent.getY();
            this.BR = y11;
            this.cJ = y11;
            this.JoC = motionEvent.getPointerId(0);
            this.HJN = false;
            this.SR = true;
            this.Ql.computeScrollOffset();
            if (this.NP != 2 || Math.abs(this.Ql.getFinalX() - this.Ql.getCurrX()) <= this.MxZ) {
                sc(false);
                this.McK = false;
            } else {
                this.Ql.abortAnimation();
                this.cvk = false;
                zY();
                this.McK = true;
                zY(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i11 = this.JoC;
            if (i11 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i11)) != -1) {
                float x12 = motionEvent.getX(iFindPointerIndex);
                float f11 = x12 - this.OXF;
                float fAbs = Math.abs(f11);
                float y12 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y12 - this.BR);
                if (f11 != 0.0f && !sc(this.OXF, f11) && sc(this, false, (int) f11, (int) x12, (int) y12)) {
                    this.OXF = x12;
                    this.cJ = y12;
                    this.HJN = true;
                    return false;
                }
                int i12 = this.Cb;
                if (fAbs > i12 && fAbs * 0.5f > fAbs2) {
                    this.McK = true;
                    zY(true);
                    setScrollState(1);
                    float f12 = this.kX;
                    float f13 = this.Cb;
                    this.OXF = f11 > 0.0f ? f12 + f13 : f12 - f13;
                    this.cJ = y12;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i12) {
                    this.HJN = true;
                }
                if (this.McK && pFF(x12)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            sc(motionEvent);
        }
        if (this.CYO == null) {
            this.CYO = VelocityTracker.obtain();
        }
        this.CYO.addMovement(motionEvent);
        return this.McK;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076  */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        pFF pffSc;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i15 = i13 - i11;
        int i16 = i14 - i12;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                C0227zY c0227zY = (C0227zY) childAt.getLayoutParams();
                if (c0227zY.f26360sc) {
                    int i19 = c0227zY.pFF;
                    int i21 = i19 & 7;
                    int i22 = i19 & 112;
                    if (i21 != 1) {
                        if (i21 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i21 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i15 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i22 != 16) {
                            if (i22 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i22 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i16 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i23 = paddingLeft + scrollX;
                            childAt.layout(i23, paddingTop, childAt.getMeasuredWidth() + i23, paddingTop + childAt.getMeasuredHeight());
                            i17++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i16 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i24 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i24;
                        int i25 = paddingLeft + scrollX;
                        childAt.layout(i25, paddingTop, childAt.getMeasuredWidth() + i25, paddingTop + childAt.getMeasuredHeight());
                        i17++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i15 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i26 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i26;
                    if (i22 != 16) {
                        if (i22 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i22 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i16 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i27 = paddingLeft + scrollX;
                        childAt.layout(i27, paddingTop, childAt.getMeasuredWidth() + i27, paddingTop + childAt.getMeasuredHeight());
                        i17++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i16 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i28 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i28;
                    int i29 = paddingLeft + scrollX;
                    childAt.layout(i29, paddingTop, childAt.getMeasuredWidth() + i29, paddingTop + childAt.getMeasuredHeight());
                    i17++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i31 = (i15 - paddingLeft) - paddingRight;
        for (int i32 = 0; i32 < childCount; i32++) {
            View childAt2 = getChildAt(i32);
            if (childAt2.getVisibility() != 8) {
                C0227zY c0227zY2 = (C0227zY) childAt2.getLayoutParams();
                if (!c0227zY2.f26360sc && (pffSc = sc(childAt2)) != null) {
                    float f11 = i31;
                    int i33 = ((int) (pffSc.ExN * f11)) + paddingLeft;
                    if (c0227zY2.We) {
                        c0227zY2.We = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f11 * c0227zY2.zY), 1073741824), View.MeasureSpec.makeMeasureSpec((i16 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i33, paddingTop, childAt2.getMeasuredWidth() + i33, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.wjp = paddingTop;
        this.Sfl = i16 - paddingBottom;
        this.f26353ko = i17;
        if (this.Yhz) {
            z12 = false;
            sc(this.We, false, 0, false);
        } else {
            z12 = false;
        }
        this.Yhz = z12;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0086  */
    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0090  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae A[SYNTHETIC] */
    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        C0227zY c0227zY;
        C0227zY c0227zY2;
        int i13;
        int i14;
        int i15;
        setMeasuredDimension(View.getDefaultSize(0, i11), View.getDefaultSize(0, i12));
        int measuredWidth = getMeasuredWidth();
        this.cD = Math.min(measuredWidth / 10, this.Gb);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i16 = 0;
        while (true) {
            boolean z11 = true;
            int i17 = 1073741824;
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8 && (c0227zY2 = (C0227zY) childAt.getLayoutParams()) != null && c0227zY2.f26360sc) {
                int i18 = c0227zY2.pFF;
                int i19 = i18 & 7;
                int i21 = i18 & 112;
                boolean z12 = i21 == 48 || i21 == 80;
                if (i19 != 3 && i19 != 5) {
                    z11 = false;
                }
                int i22 = Integer.MIN_VALUE;
                if (z12) {
                    i22 = 1073741824;
                } else {
                    i13 = z11 ? 1073741824 : Integer.MIN_VALUE;
                    i14 = ((ViewGroup.LayoutParams) c0227zY2).width;
                    if (i14 != -2) {
                        if (i14 == -1) {
                            i14 = paddingLeft;
                        }
                        i22 = 1073741824;
                    } else {
                        i14 = paddingLeft;
                    }
                    i15 = ((ViewGroup.LayoutParams) c0227zY2).height;
                    if (i15 != -2) {
                        i15 = measuredHeight;
                        i17 = i13;
                    } else if (i15 == -1) {
                        i15 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, i22), View.MeasureSpec.makeMeasureSpec(i15, i17));
                    if (z12) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z11) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i14 = ((ViewGroup.LayoutParams) c0227zY2).width;
                if (i14 != -2) {
                    if (i14 == -1) {
                        i14 = paddingLeft;
                    }
                    i22 = 1073741824;
                } else {
                    i14 = paddingLeft;
                }
                i15 = ((ViewGroup.LayoutParams) c0227zY2).height;
                if (i15 != -2) {
                    i15 = measuredHeight;
                    i17 = i13;
                } else if (i15 == -1) {
                    i15 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14, i22), View.MeasureSpec.makeMeasureSpec(i15, i17));
                if (z12) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z11) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i16++;
        }
        this.uEA = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.JPJ = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.FI = true;
        zY();
        this.FI = false;
        int childCount2 = getChildCount();
        for (int i23 = 0; i23 < childCount2; i23++) {
            View childAt2 = getChildAt(i23);
            if (childAt2.getVisibility() != 8 && ((c0227zY = (C0227zY) childAt2.getLayoutParams()) == null || !c0227zY.f26360sc)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0227zY.zY), 1073741824), this.JPJ);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i11, Rect rect) {
        int i12;
        int i13;
        int i14;
        pFF pffSc;
        int childCount = getChildCount();
        if ((i11 & 2) != 0) {
            i13 = childCount;
            i12 = 0;
            i14 = 1;
        } else {
            i12 = childCount - 1;
            i13 = -1;
            i14 = -1;
        }
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 0 && (pffSc = sc(childAt)) != null && pffSc.pFF == this.We && childAt.requestFocus(i11, rect)) {
                return true;
            }
            i12 += i14;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof qr)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        qr qrVar = (qr) parcelable;
        super.onRestoreInstanceState(qrVar.sc());
        if (this.zY != null) {
            sc(qrVar.pFF, false, true);
            return;
        }
        this.WH = qrVar.pFF;
        this.UFX = qrVar.zY;
        this.Tf = qrVar.We;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        qr qrVar = new qr(super.onSaveInstanceState());
        qrVar.pFF = this.We;
        com.bytedance.adsdk.ugeno.Qj.pFF pff = this.zY;
        if (pff != null) {
            qrVar.zY = pff.pFF();
        }
        return qrVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13) {
            int i15 = this.dE;
            sc(i11, i13, i15, i15);
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0141  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.Qj.pFF pff;
        boolean zQj;
        int iFindPointerIndex;
        if (this.QLv) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pff = this.zY) == null || pff.sc() == 0) {
            return false;
        }
        if (this.CYO == null) {
            this.CYO = VelocityTracker.obtain();
        }
        this.CYO.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.Ql.abortAnimation();
            this.cvk = false;
            zY();
            float x11 = motionEvent.getX();
            this.kX = x11;
            this.OXF = x11;
            float y11 = motionEvent.getY();
            this.BR = y11;
            this.cJ = y11;
            this.JoC = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.OXF = motionEvent.getX(actionIndex);
                            this.JoC = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        sc(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.JoC);
                        if (iFindPointerIndex2 != -1) {
                            this.OXF = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.McK) {
                    sc(this.We, true, 0, false);
                    zQj = Qj();
                    if (zQj) {
                        postInvalidateOnAnimation();
                    }
                }
            } else if (!this.McK) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.JoC);
                if (iFindPointerIndex3 == -1) {
                    zQj = Qj();
                } else {
                    float x12 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x12 - this.OXF);
                    float y12 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y12 - this.cJ);
                    if (fAbs > this.Cb && fAbs > fAbs2) {
                        this.McK = true;
                        zY(true);
                        float f11 = this.kX;
                        this.OXF = x12 - f11 > 0.0f ? f11 + this.Cb : f11 - this.Cb;
                        this.cJ = y12;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.McK) {
                        zQj = pFF(motionEvent.getX(iFindPointerIndex));
                    }
                }
                if (zQj) {
                    postInvalidateOnAnimation();
                }
            } else if (this.McK && (iFindPointerIndex = motionEvent.findPointerIndex(this.JoC)) != -1) {
                zQj = pFF(motionEvent.getX(iFindPointerIndex));
                if (zQj) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (this.McK) {
            VelocityTracker velocityTracker = this.CYO;
            velocityTracker.computeCurrentVelocity(1000, this.f26354pc);
            int xVelocity = (int) velocityTracker.getXVelocity(this.JoC);
            this.cvk = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            pFF pffOl = Ol();
            float f12 = clientWidth;
            float f13 = this.dE / f12;
            int i11 = pffOl.pFF;
            float f14 = ((scrollX / f12) - pffOl.ExN) / (pffOl.We + f13);
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.JoC);
            if (iFindPointerIndex4 != -1) {
                sc(sc(i11, f14, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.kX)), true, true, xVelocity);
                zQj = Qj();
                if (zQj) {
                    postInvalidateOnAnimation();
                }
            }
        }
        return true;
    }

    public pFF pFF(int i11) {
        for (int i12 = 0; i12 < this.f26355qr.size(); i12++) {
            pFF pff = this.f26355qr.get(i12);
            if (pff.pFF == i11) {
                return pff;
            }
        }
        return null;
    }

    public pFF pFF(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return sc(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public void pFF() {
        int iSc = this.zY.sc();
        this.f26356sc = iSc;
        boolean z11 = this.f26355qr.size() < (this.II * 2) + 1 && this.f26355qr.size() < iSc;
        int iMax = this.We;
        int i11 = 0;
        while (i11 < this.f26355qr.size()) {
            pFF pff = this.f26355qr.get(i11);
            int iSc2 = this.zY.sc(pff.f26359sc);
            if (iSc2 != -1) {
                if (iSc2 == -2) {
                    this.f26355qr.remove(i11);
                    i11--;
                    this.zY.sc((ViewGroup) this, pff.pFF, pff.f26359sc);
                    int i12 = this.We;
                    if (i12 == pff.pFF) {
                        iMax = Math.max(0, Math.min(i12, iSc - 1));
                    }
                } else {
                    int i13 = pff.pFF;
                    if (i13 != iSc2) {
                        if (i13 == this.We) {
                            iMax = iSc2;
                        }
                        pff.pFF = iSc2;
                    }
                }
                z11 = true;
            }
            i11++;
        }
        Collections.sort(this.f26355qr, ExN);
        if (z11) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                C0227zY c0227zY = (C0227zY) getChildAt(i14).getLayoutParams();
                if (!c0227zY.f26360sc) {
                    c0227zY.zY = 0.0f;
                }
            }
            sc(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.FI) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public float sc(float f11) {
        return (float) Math.sin((f11 - 0.5f) * 0.47123894f);
    }

    public pFF sc(int i11, int i12) {
        pFF pff = new pFF();
        pff.pFF = i11;
        pff.f26359sc = this.zY.sc((ViewGroup) this, i11);
        pff.We = this.zY.sc(i11);
        if (i12 < 0 || i12 >= this.f26355qr.size()) {
            this.f26355qr.add(pff);
        } else {
            this.f26355qr.add(i12, pff);
        }
        return pff;
    }

    public pFF sc(View view) {
        for (int i11 = 0; i11 < this.f26355qr.size(); i11++) {
            pFF pff = this.f26355qr.get(i11);
            if (this.zY.sc(view, pff.f26359sc)) {
                return pff;
            }
        }
        return null;
    }

    public void sc() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.Ql = new Scroller(context, TRI);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.Cb = viewConfiguration.getScaledPagingTouchSlop();
        this.qKn = (int) (400.0f * f11);
        this.f26354pc = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f26351eo = new EdgeEffect(context);
        this.yL = new EdgeEffect(context);
        this.GI = (int) (25.0f * f11);
        this.MxZ = (int) (2.0f * f11);
        this.Gb = (int) (f11 * 16.0f);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c5 A[PHI: r7 r10 r15
  0x00c5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:63:0x00e9, B:60:0x00d3, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
  0x00c5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:63:0x00e9, B:60:0x00d3, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]
  0x00c5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:63:0x00e9, B:60:0x00d3, B:52:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    public void sc(int i11) {
        pFF pFF2;
        String hexString;
        pFF pffSc;
        pFF pffSc2;
        pFF pff;
        int i12 = this.We;
        if (i12 != i11) {
            pFF2 = pFF(i12);
            this.We = i11;
        } else {
            pFF2 = null;
        }
        if (this.zY == null) {
            qr();
            return;
        }
        if (this.cvk) {
            qr();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i13 = this.II;
        int iMax = Math.max(0, this.We - i13);
        int iSc = this.zY.sc();
        int iMin = Math.min(iSc - 1, this.We + i13);
        if (iSc != this.f26356sc) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f26356sc + ", found: " + iSc + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.zY.getClass());
        }
        int i14 = 0;
        while (true) {
            if (i14 < this.f26355qr.size()) {
                pffSc = this.f26355qr.get(i14);
                int i15 = pffSc.pFF;
                int i16 = this.We;
                if (i15 >= i16) {
                    if (i15 != i16) {
                        break;
                    } else {
                        break;
                    }
                }
                i14++;
            }
            pffSc = null;
            break;
        }
        if (pffSc == null && iSc > 0) {
            pffSc = sc(this.We, i14);
        }
        if (pffSc != null) {
            int i17 = i14 - 1;
            pFF pff2 = i17 >= 0 ? this.f26355qr.get(i17) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - pffSc.We) + (getPaddingLeft() / clientWidth);
            float f11 = 0.0f;
            for (int i18 = this.We - 1; i18 >= 0; i18--) {
                if (f11 >= paddingLeft && i18 < iMax) {
                    if (pff2 == null) {
                        break;
                    }
                    if (i18 == pff2.pFF && !pff2.zY) {
                        this.f26355qr.remove(i17);
                        this.zY.sc((ViewGroup) this, i18, pff2.f26359sc);
                        i17--;
                        i14--;
                        if (i17 >= 0) {
                            pff = this.f26355qr.get(i17);
                        } else {
                            pff = null;
                        }
                        pff2 = pff;
                    }
                } else {
                    if (pff2 == null || i18 != pff2.pFF) {
                        f11 += sc(i18, i17 + 1).We;
                        i14++;
                        if (i17 >= 0) {
                            pff = this.f26355qr.get(i17);
                        } else {
                            pff = null;
                        }
                    } else {
                        f11 += pff2.We;
                        i17--;
                        if (i17 >= 0) {
                            pff = this.f26355qr.get(i17);
                        } else {
                            pff = null;
                        }
                    }
                    pff2 = pff;
                }
            }
            float f12 = pffSc.We;
            int i19 = i14 + 1;
            if (f12 < 2.0f) {
                pFF pff3 = i19 < this.f26355qr.size() ? this.f26355qr.get(i19) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i21 = this.We;
                while (true) {
                    i21++;
                    if (i21 >= iSc) {
                        break;
                    }
                    if (f12 >= paddingRight && i21 > iMin) {
                        if (pff3 == null) {
                            break;
                        }
                        if (i21 == pff3.pFF && !pff3.zY) {
                            this.f26355qr.remove(i19);
                            this.zY.sc((ViewGroup) this, i21, pff3.f26359sc);
                            if (i19 < this.f26355qr.size()) {
                                pff3 = this.f26355qr.get(i19);
                            }
                        }
                    } else if (pff3 == null || i21 != pff3.pFF) {
                        pFF pffSc3 = sc(i21, i19);
                        i19++;
                        f12 += pffSc3.We;
                        pff3 = i19 < this.f26355qr.size() ? this.f26355qr.get(i19) : null;
                    } else {
                        f12 += pff3.We;
                        i19++;
                        if (i19 < this.f26355qr.size()) {
                            pff3 = this.f26355qr.get(i19);
                        }
                    }
                }
            }
            sc(pffSc, i14, pFF2);
        }
        int childCount = getChildCount();
        for (int i22 = 0; i22 < childCount; i22++) {
            View childAt = getChildAt(i22);
            C0227zY c0227zY = (C0227zY) childAt.getLayoutParams();
            c0227zY.TRI = i22;
            if (!c0227zY.f26360sc && c0227zY.zY == 0.0f && (pffSc2 = sc(childAt)) != null) {
                c0227zY.zY = pffSc2.We;
                c0227zY.ExN = pffSc2.pFF;
            }
        }
        qr();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            pFF pFF3 = viewFindFocus != null ? pFF(viewFindFocus) : null;
            if (pFF3 == null || pFF3.pFF != this.We) {
                for (int i23 = 0; i23 < getChildCount(); i23++) {
                    View childAt2 = getChildAt(i23);
                    pFF pffSc4 = sc(childAt2);
                    if (pffSc4 != null && pffSc4.pFF == this.We && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0064  */
    public void sc(int i11, float f11, int i12) {
        int iMax;
        int width;
        int left;
        if (this.f26353ko > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                C0227zY c0227zY = (C0227zY) childAt.getLayoutParams();
                if (c0227zY.f26360sc) {
                    int i14 = c0227zY.pFF & 7;
                    if (i14 != 1) {
                        if (i14 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i14 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i15 = iMax;
                    width = paddingLeft;
                    paddingLeft = i15;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        pFF(i11, f11, i12);
        if (this.Bs != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt2 = getChildAt(i16);
                if (!((C0227zY) childAt2.getLayoutParams()).f26360sc) {
                    this.Bs.sc(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.OKY = true;
    }

    public void sc(int i11, int i12, int i13) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.Ql;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.SR ? this.Ql.getCurrX() : this.Ql.getStartX();
            this.Ql.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i14 = scrollX;
        int scrollY = getScrollY();
        int i15 = i11 - i14;
        int i16 = i12 - scrollY;
        if (i15 == 0 && i16 == 0) {
            sc(false);
            zY();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i17 = clientWidth / 2;
        float f11 = clientWidth;
        float f12 = i17;
        float fSc = f12 + (sc(Math.min(1.0f, (Math.abs(i15) * 1.0f) / f11)) * f12);
        int iAbs2 = Math.abs(i13);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fSc / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i15) / ((f11 * this.zY.sc(this.We)) + this.dE)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, LogSeverity.CRITICAL_VALUE);
        this.SR = false;
        this.Ql.startScroll(i14, scrollY, i15, i16, iMin);
        postInvalidateOnAnimation();
    }

    public void sc(int i11, boolean z11) {
        this.cvk = false;
        sc(i11, z11, false);
    }

    public void sc(int i11, boolean z11, boolean z12) {
        sc(i11, z11, z12, 0);
    }

    public void sc(int i11, boolean z11, boolean z12, int i12) {
        com.bytedance.adsdk.ugeno.Qj.pFF pff = this.zY;
        if (pff == null || pff.sc() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z12 && this.We == i11 && this.f26355qr.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i11 < 0) {
            i11 = 0;
        } else if (i11 >= this.zY.sc()) {
            i11 = this.zY.sc() - 1;
        }
        int i13 = this.II;
        int i14 = this.We;
        if (i11 > i14 + i13 || i11 < i14 - i13) {
            for (int i15 = 0; i15 < this.f26355qr.size(); i15++) {
                this.f26355qr.get(i15).zY = true;
            }
        }
        boolean z13 = this.We != i11;
        if (!this.Yhz) {
            sc(i11);
            sc(i11, z11, i12, z13);
        } else {
            this.We = i11;
            if (z13) {
                ExN(i11);
            }
            requestLayout();
        }
    }

    public void sc(We we2) {
        if (this.f26352ht == null) {
            this.f26352ht = new ArrayList();
        }
        this.f26352ht.add(we2);
    }

    public void sc(boolean z11, ExN exN) {
        sc(z11, exN, 2);
    }

    public void sc(boolean z11, ExN exN, int i11) {
        boolean z12 = exN != null;
        boolean z13 = z12 != (this.Bs != null);
        this.Bs = exN;
        setChildrenDrawingOrderEnabled(z12);
        if (z12) {
            this.bSP = z11 ? 2 : 1;
            this.YdT = i11;
        } else {
            this.bSP = 0;
        }
        if (z13) {
            zY();
        }
    }

    public boolean sc(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? We() : zY(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? ExN() : zY(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return zY(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return zY(1);
                }
            }
        }
        return false;
    }

    public boolean sc(View view, boolean z11, int i11, int i12, int i13) {
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom() && sc(childAt, true, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z11 && view.canScrollHorizontally(-i11);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.Qj.pFF pff) {
        com.bytedance.adsdk.ugeno.Qj.pFF pff2 = this.zY;
        if (pff2 != null) {
            pff2.sc((DataSetObserver) null);
            for (int i11 = 0; i11 < this.f26355qr.size(); i11++) {
                pFF pff3 = this.f26355qr.get(i11);
                this.zY.sc((ViewGroup) this, pff3.pFF, pff3.f26359sc);
            }
            this.f26355qr.clear();
            TRI();
            this.We = 0;
            scrollTo(0, 0);
        }
        this.zY = pff;
        this.f26356sc = 0;
        if (pff != null) {
            if (this.BT == null) {
                this.BT = new TRI();
            }
            this.zY.sc((DataSetObserver) this.BT);
            this.cvk = false;
            boolean z11 = this.Yhz;
            this.Yhz = true;
            this.f26356sc = this.zY.sc();
            int i12 = this.WH;
            if (i12 >= 0) {
                sc(i12, false, true);
                this.WH = -1;
                this.UFX = null;
                this.Tf = null;
            } else if (z11) {
                requestLayout();
            } else {
                zY();
            }
        }
        List<Object> list = this.fT;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.fT.size();
        for (int i13 = 0; i13 < size; i13++) {
            this.fT.get(i13);
        }
    }

    public void setCurrentItem(int i11) {
        this.cvk = false;
        sc(i11, !this.Yhz, false);
    }

    public void setOffscreenPageLimit(int i11) {
        if (i11 <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i11 + " too small; defaulting to 1");
            i11 = 1;
        }
        if (i11 != this.II) {
            this.II = i11;
            zY();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(We we2) {
        this.ZM = we2;
    }

    public void setPageMargin(int i11) {
        int i12 = this.dE;
        this.dE = i11;
        int width = getWidth();
        sc(width, width, i11, i12);
        requestLayout();
    }

    public void setPageMarginDrawable(int i11) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i11));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.Xc = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i11) {
        if (this.NP == i11) {
            return;
        }
        this.NP = i11;
        if (this.Bs != null) {
            pFF(i11 != 0);
        }
        TRI(i11);
    }

    public void setScroller(Scroller scroller) {
        this.Ql = scroller;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Xc;
    }

    public void zY() {
        sc(this.We);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    public boolean zY(int i11) {
        boolean zWe;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
            break;
        }
        if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(viewFindFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb2.append(" => ");
                        sb2.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb2.toString());
                    viewFindFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i11);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i11 == 17 || i11 == 1) {
                zWe = We();
            } else if (i11 == 66 || i11 == 2) {
                zWe = ExN();
            } else {
                zWe = false;
            }
        } else if (i11 == 17) {
            zWe = (viewFindFocus == null || sc(this.Ol, viewFindNextFocus).left < sc(this.Ol, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : We();
        } else if (i11 == 66) {
            int i12 = sc(this.Ol, viewFindNextFocus).left;
            int i13 = sc(this.Ol, viewFindFocus).left;
            if (viewFindFocus == null || i12 > i13) {
                zWe = viewFindNextFocus.requestFocus();
            } else {
                zWe = ExN();
            }
        } else {
            zWe = false;
        }
        if (zWe) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i11));
        }
        return zWe;
    }
}
