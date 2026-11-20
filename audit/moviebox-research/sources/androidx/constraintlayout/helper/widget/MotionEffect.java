package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.motion.widget.e;
import androidx.constraintlayout.motion.widget.h;
import androidx.constraintlayout.motion.widget.m;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    public static final int WEST = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6751o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6752p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6753q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6754r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6755s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6756t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6757u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6758v;

    public MotionEffect(Context context) {
        super(context);
        this.f6751o = 0.1f;
        this.f6752p = 49;
        this.f6753q = 50;
        this.f6754r = 0;
        this.f6755s = 0;
        this.f6756t = true;
        this.f6757u = -1;
        this.f6758v = -1;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6751o = 0.1f;
        this.f6752p = 49;
        this.f6753q = 50;
        this.f6754r = 0;
        this.f6755s = 0;
        this.f6756t = true;
        this.f6757u = -1;
        this.f6758v = -1;
        l(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f6751o = 0.1f;
        this.f6752p = 49;
        this.f6753q = 50;
        this.f6754r = 0;
        this.f6755s = 0;
        this.f6756t = true;
        this.f6757u = -1;
        this.f6758v = -1;
        l(context, attributeSet);
    }

    private void l(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionEffect_motionEffect_start) {
                    int i12 = typedArrayObtainStyledAttributes.getInt(index, this.f6752p);
                    this.f6752p = i12;
                    this.f6752p = Math.max(Math.min(i12, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_end) {
                    int i13 = typedArrayObtainStyledAttributes.getInt(index, this.f6753q);
                    this.f6753q = i13;
                    this.f6753q = Math.max(Math.min(i13, 99), 0);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationX) {
                    this.f6754r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6754r);
                } else if (index == R$styleable.MotionEffect_motionEffect_translationY) {
                    this.f6755s = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6755s);
                } else if (index == R$styleable.MotionEffect_motionEffect_alpha) {
                    this.f6751o = typedArrayObtainStyledAttributes.getFloat(index, this.f6751o);
                } else if (index == R$styleable.MotionEffect_motionEffect_move) {
                    this.f6758v = typedArrayObtainStyledAttributes.getInt(index, this.f6758v);
                } else if (index == R$styleable.MotionEffect_motionEffect_strict) {
                    this.f6756t = typedArrayObtainStyledAttributes.getBoolean(index, this.f6756t);
                } else if (index == R$styleable.MotionEffect_motionEffect_viewTransition) {
                    this.f6757u = typedArrayObtainStyledAttributes.getResourceId(index, this.f6757u);
                }
            }
            int i14 = this.f6752p;
            int i15 = this.f6753q;
            if (i14 == i15) {
                if (i14 > 0) {
                    this.f6752p = i14 - 1;
                } else {
                    this.f6753q = i15 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean isDecorator() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x0162  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:92:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e5  */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0186, code lost:
    
        if (r14 == 0.0f) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x019a, code lost:
    
        if (r14 == 0.0f) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01aa, code lost:
    
        if (r15 == 0.0f) goto L57;
     */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPreSetup(MotionLayout motionLayout, HashMap<View, m> map) {
        e eVar;
        e eVar2;
        e eVar3;
        int i11;
        HashMap<View, m> map2 = map;
        View[] viewArrJ = j((ConstraintLayout) getParent());
        if (viewArrJ == null) {
            Log.v(TAG, a.a() + " views = null");
            return;
        }
        e eVar4 = new e();
        e eVar5 = new e();
        eVar4.R("alpha", Float.valueOf(this.f6751o));
        eVar5.R("alpha", Float.valueOf(this.f6751o));
        eVar4.g(this.f6752p);
        eVar5.g(this.f6753q);
        h hVar = new h();
        hVar.g(this.f6752p);
        hVar.m(0);
        hVar.n("percentX", 0);
        hVar.n("percentY", 0);
        h hVar2 = new h();
        hVar2.g(this.f6753q);
        hVar2.m(0);
        int i12 = 1;
        hVar2.n("percentX", 1);
        hVar2.n("percentY", 1);
        e eVar6 = null;
        if (this.f6754r > 0) {
            eVar = new e();
            eVar2 = new e();
            eVar.R("translationX", Integer.valueOf(this.f6754r));
            eVar.g(this.f6753q);
            eVar2.R("translationX", 0);
            eVar2.g(this.f6753q - 1);
        } else {
            eVar = null;
            eVar2 = null;
        }
        if (this.f6755s > 0) {
            eVar6 = new e();
            eVar3 = new e();
            eVar6.R("translationY", Integer.valueOf(this.f6755s));
            eVar6.g(this.f6753q);
            eVar3.R("translationY", 0);
            eVar3.g(this.f6753q - 1);
        } else {
            eVar3 = null;
        }
        int i13 = this.f6758v;
        if (i13 == -1) {
            int[] iArr = new int[4];
            for (View view : viewArrJ) {
                m mVar = map2.get(view);
                if (mVar != null) {
                    float fN = mVar.n() - mVar.t();
                    float fO = mVar.o() - mVar.u();
                    if (fO < 0.0f) {
                        iArr[1] = iArr[1] + 1;
                    }
                    if (fO > 0.0f) {
                        iArr[0] = iArr[0] + 1;
                    }
                    if (fN > 0.0f) {
                        iArr[3] = iArr[3] + 1;
                    }
                    if (fN < 0.0f) {
                        iArr[2] = iArr[2] + 1;
                    }
                }
            }
            int i14 = iArr[0];
            i13 = 0;
            for (int i15 = 4; i12 < i15; i15 = 4) {
                int i16 = iArr[i12];
                if (i14 < i16) {
                    i14 = i16;
                    i13 = i12;
                }
                i12++;
            }
        }
        int i17 = 0;
        while (i17 < viewArrJ.length) {
            m mVar2 = map2.get(viewArrJ[i17]);
            if (mVar2 != null) {
                float fN2 = mVar2.n() - mVar2.t();
                float fO2 = mVar2.o() - mVar2.u();
                if (i13 == 0) {
                    if (fO2 > 0.0f) {
                        if (this.f6756t) {
                        }
                    }
                    i11 = this.f6757u;
                    if (i11 == -1) {
                        mVar2.a(eVar4);
                        mVar2.a(eVar5);
                        mVar2.a(hVar);
                        mVar2.a(hVar2);
                        if (this.f6754r > 0) {
                            mVar2.a(eVar);
                            mVar2.a(eVar2);
                        }
                        if (this.f6755s > 0) {
                            mVar2.a(eVar6);
                            mVar2.a(eVar3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i11, mVar2);
                    }
                } else if (i13 == 1) {
                    if (fO2 < 0.0f) {
                        if (this.f6756t) {
                        }
                    }
                    i11 = this.f6757u;
                    if (i11 == -1) {
                        mVar2.a(eVar4);
                        mVar2.a(eVar5);
                        mVar2.a(hVar);
                        mVar2.a(hVar2);
                        if (this.f6754r > 0) {
                            mVar2.a(eVar);
                            mVar2.a(eVar2);
                        }
                        if (this.f6755s > 0) {
                            mVar2.a(eVar6);
                            mVar2.a(eVar3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i11, mVar2);
                    }
                } else if (i13 == 2) {
                    if (fN2 < 0.0f) {
                        if (this.f6756t) {
                        }
                    }
                    i11 = this.f6757u;
                    if (i11 == -1) {
                        mVar2.a(eVar4);
                        mVar2.a(eVar5);
                        mVar2.a(hVar);
                        mVar2.a(hVar2);
                        if (this.f6754r > 0) {
                            mVar2.a(eVar);
                            mVar2.a(eVar2);
                        }
                        if (this.f6755s > 0) {
                            mVar2.a(eVar6);
                            mVar2.a(eVar3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i11, mVar2);
                    }
                } else if (i13 != 3 || fN2 <= 0.0f || (this.f6756t && fO2 != 0.0f)) {
                    i11 = this.f6757u;
                    if (i11 == -1) {
                        mVar2.a(eVar4);
                        mVar2.a(eVar5);
                        mVar2.a(hVar);
                        mVar2.a(hVar2);
                        if (this.f6754r > 0) {
                            mVar2.a(eVar);
                            mVar2.a(eVar2);
                        }
                        if (this.f6755s > 0) {
                            mVar2.a(eVar6);
                            mVar2.a(eVar3);
                        }
                    } else {
                        motionLayout.applyViewTransition(i11, mVar2);
                    }
                }
            }
            i17++;
            map2 = map;
        }
    }
}
