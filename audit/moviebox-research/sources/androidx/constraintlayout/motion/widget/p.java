package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f7039a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MotionEvent f7052n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MotionLayout.e f7055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final t f7057s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f7058t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f7059u;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.e f7040b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7041c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7042d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<b> f7043e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f7044f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<b> f7045g = new ArrayList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f7046h = new SparseArray<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<String, Integer> f7047i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SparseIntArray f7048j = new SparseIntArray();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7049k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7050l = LogSeverity.WARNING_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7051m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7053o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7054p = false;

    /* JADX INFO: compiled from: source.java */
    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.constraintlayout.core.motion.utils.c f7060a;

        public a(p pVar, androidx.constraintlayout.core.motion.utils.c cVar) {
            this.f7060a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            return (float) this.f7060a.a(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f7066f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7067g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7068h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7069i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final p f7070j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ArrayList<g> f7071k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public q f7072l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ArrayList<a> f7073m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7074n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7075o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7076p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7077q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7078r;

        /* JADX INFO: compiled from: source.java */
        public static class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f7079a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f7080b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f7081c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f7080b = -1;
                this.f7081c = 17;
                this.f7079a = bVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i11 = 0; i11 < indexCount; i11++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i11);
                    if (index == R$styleable.OnClick_targetId) {
                        this.f7080b = typedArrayObtainStyledAttributes.getResourceId(index, this.f7080b);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.f7081c = typedArrayObtainStyledAttributes.getInt(index, this.f7081c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i11, b bVar) {
                boolean z11;
                View viewFindViewById;
                int i12 = this.f7080b;
                View view = motionLayout;
                if (i12 != -1) {
                    viewFindViewById = motionLayout.findViewById(i12);
                }
                if (view == null) {
                    view = viewFindViewById;
                    Log.e("MotionScene", "OnClick could not find id " + this.f7080b);
                    return;
                }
                int i13 = bVar.f7064d;
                int i14 = bVar.f7063c;
                if (i13 == -1) {
                    view = viewFindViewById;
                    view.setOnClickListener(this);
                    return;
                }
                int i15 = this.f7081c;
                boolean z12 = false;
                if ((i15 & 1) == 0 || i11 != i13) {
                    view = viewFindViewById;
                    z11 = false;
                } else {
                    z11 = true;
                }
                boolean z13 = ((i15 & 1) != 0 && i11 == i13) | z11 | ((i15 & 256) != 0 && i11 == i13) | ((i15 & 16) != 0 && i11 == i14);
                if ((i15 & 4096) != 0 && i11 == i14) {
                    z12 = true;
                }
                if (z13 || z12) {
                    view.setOnClickListener(this);
                }
            }

            public boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f7079a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i11 = bVar2.f7063c;
                int i12 = this.f7079a.f7064d;
                if (i12 == -1) {
                    return motionLayout.f6775g != i11;
                }
                int i13 = motionLayout.f6775g;
                return i13 == i12 || i13 == i11;
            }

            public void c(MotionLayout motionLayout) {
                int i11 = this.f7080b;
                if (i11 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i11);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f7080b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f7079a.f7070j.f7039a;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.f7079a.f7064d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.f7079a.f7063c);
                            return;
                        }
                        b bVar = new b(this.f7079a.f7070j, this.f7079a);
                        bVar.f7064d = currentState;
                        bVar.f7063c = this.f7079a.f7063c;
                        motionLayout.setTransition(bVar);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    b bVar2 = this.f7079a.f7070j.f7041c;
                    int i11 = this.f7081c;
                    boolean z11 = false;
                    boolean z12 = ((i11 & 1) == 0 && (i11 & 256) == 0) ? false : true;
                    boolean z13 = ((i11 & 16) == 0 && (i11 & 4096) == 0) ? false : true;
                    if (z12 && z13) {
                        b bVar3 = this.f7079a.f7070j.f7041c;
                        b bVar4 = this.f7079a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z11 = z12;
                            z13 = false;
                        }
                    } else {
                        z11 = z12;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z11 && (this.f7081c & 1) != 0) {
                            motionLayout.setTransition(this.f7079a);
                            motionLayout.transitionToEnd();
                            return;
                        }
                        if (z13 && (this.f7081c & 16) != 0) {
                            motionLayout.setTransition(this.f7079a);
                            motionLayout.transitionToStart();
                        } else if (z11 && (this.f7081c & 256) != 0) {
                            motionLayout.setTransition(this.f7079a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z13 || (this.f7081c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f7079a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        public b(int i11, p pVar, int i12, int i13) {
            this.f7061a = -1;
            this.f7062b = false;
            this.f7063c = -1;
            this.f7064d = -1;
            this.f7065e = 0;
            this.f7066f = null;
            this.f7067g = -1;
            this.f7068h = LogSeverity.WARNING_VALUE;
            this.f7069i = 0.0f;
            this.f7071k = new ArrayList<>();
            this.f7072l = null;
            this.f7073m = new ArrayList<>();
            this.f7074n = 0;
            this.f7075o = false;
            this.f7076p = -1;
            this.f7077q = 0;
            this.f7078r = 0;
            this.f7061a = i11;
            this.f7070j = pVar;
            this.f7064d = i12;
            this.f7063c = i13;
            this.f7068h = pVar.f7050l;
            this.f7077q = pVar.f7051m;
        }

        public b(p pVar, Context context, XmlPullParser xmlPullParser) {
            this.f7061a = -1;
            this.f7062b = false;
            this.f7063c = -1;
            this.f7064d = -1;
            this.f7065e = 0;
            this.f7066f = null;
            this.f7067g = -1;
            this.f7068h = LogSeverity.WARNING_VALUE;
            this.f7069i = 0.0f;
            this.f7071k = new ArrayList<>();
            this.f7072l = null;
            this.f7073m = new ArrayList<>();
            this.f7074n = 0;
            this.f7075o = false;
            this.f7076p = -1;
            this.f7077q = 0;
            this.f7078r = 0;
            this.f7068h = pVar.f7050l;
            this.f7077q = pVar.f7051m;
            this.f7070j = pVar;
            w(pVar, context, Xml.asAttributeSet(xmlPullParser));
        }

        public b(p pVar, b bVar) {
            this.f7061a = -1;
            this.f7062b = false;
            this.f7063c = -1;
            this.f7064d = -1;
            this.f7065e = 0;
            this.f7066f = null;
            this.f7067g = -1;
            this.f7068h = LogSeverity.WARNING_VALUE;
            this.f7069i = 0.0f;
            this.f7071k = new ArrayList<>();
            this.f7072l = null;
            this.f7073m = new ArrayList<>();
            this.f7074n = 0;
            this.f7075o = false;
            this.f7076p = -1;
            this.f7077q = 0;
            this.f7078r = 0;
            this.f7070j = pVar;
            this.f7068h = pVar.f7050l;
            if (bVar != null) {
                this.f7076p = bVar.f7076p;
                this.f7065e = bVar.f7065e;
                this.f7066f = bVar.f7066f;
                this.f7067g = bVar.f7067g;
                this.f7068h = bVar.f7068h;
                this.f7071k = bVar.f7071k;
                this.f7069i = bVar.f7069i;
                this.f7077q = bVar.f7077q;
            }
        }

        public int A() {
            return this.f7064d;
        }

        public q B() {
            return this.f7072l;
        }

        public boolean C() {
            return !this.f7075o;
        }

        public boolean D(int i11) {
            return (i11 & this.f7078r) != 0;
        }

        public void E(int i11) {
            this.f7068h = Math.max(i11, 8);
        }

        public void F(boolean z11) {
            this.f7075o = !z11;
        }

        public void G(int i11, String str, int i12) {
            this.f7065e = i11;
            this.f7066f = str;
            this.f7067g = i12;
        }

        public void H(int i11) {
            q qVarB = B();
            if (qVarB != null) {
                qVarB.y(i11);
            }
        }

        public void I(int i11) {
            this.f7076p = i11;
        }

        public void t(g gVar) {
            this.f7071k.add(gVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.f7073m.add(new a(context, this, xmlPullParser));
        }

        public final void v(p pVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArray.getIndex(i11);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.f7063c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f7063c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        bVar.E(context, this.f7063c);
                        pVar.f7046h.append(this.f7063c, bVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f7063c = pVar.O(context, this.f7063c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.f7064d = typedArray.getResourceId(index, this.f7064d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f7064d);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        bVar2.E(context, this.f7064d);
                        pVar.f7046h.append(this.f7064d, bVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f7064d = pVar.O(context, this.f7064d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f7067g = resourceId;
                        if (resourceId != -1) {
                            this.f7065e = -2;
                        }
                    } else if (i12 == 3) {
                        String string = typedArray.getString(index);
                        this.f7066f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f7067g = typedArray.getResourceId(index, -1);
                                this.f7065e = -2;
                            } else {
                                this.f7065e = -1;
                            }
                        }
                    } else {
                        this.f7065e = typedArray.getInteger(index, this.f7065e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i13 = typedArray.getInt(index, this.f7068h);
                    this.f7068h = i13;
                    if (i13 < 8) {
                        this.f7068h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.f7069i = typedArray.getFloat(index, this.f7069i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.f7074n = typedArray.getInteger(index, this.f7074n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.f7061a = typedArray.getResourceId(index, this.f7061a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.f7075o = typedArray.getBoolean(index, this.f7075o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.f7076p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f7077q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.f7078r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f7064d == -1) {
                this.f7062b = true;
            }
        }

        public final void w(p pVar, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            v(pVar, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int x() {
            return this.f7074n;
        }

        public int y() {
            return this.f7063c;
        }

        public int z() {
            return this.f7077q;
        }
    }

    public p(Context context, MotionLayout motionLayout, int i11) {
        this.f7039a = motionLayout;
        this.f7057s = new t(motionLayout);
        M(context, i11);
        this.f7046h.put(R$id.motion_base, new androidx.constraintlayout.widget.b());
        this.f7047i.put("motion_base", Integer.valueOf(R$id.motion_base));
    }

    public static String c0(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public int A() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0;
        }
        return this.f7041c.f7072l.k();
    }

    public float B() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.l();
    }

    public float C() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.m();
    }

    public float D() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.n();
    }

    public float E() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.o();
    }

    public float F() {
        b bVar = this.f7041c;
        if (bVar != null) {
            return bVar.f7069i;
        }
        return 0.0f;
    }

    public int G() {
        b bVar = this.f7041c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7064d;
    }

    public b H(int i11) {
        for (b bVar : this.f7043e) {
            if (bVar.f7061a == i11) {
                return bVar;
            }
        }
        return null;
    }

    public List<b> I(int i11) {
        int iZ = z(i11);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.f7043e) {
            if (bVar.f7064d == iZ || bVar.f7063c == iZ) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final boolean J(int i11) {
        int i12 = this.f7048j.get(i11);
        int size = this.f7048j.size();
        while (i12 > 0) {
            if (i12 == i11) {
                return true;
            }
            int i13 = size - 1;
            if (size < 0) {
                return true;
            }
            i12 = this.f7048j.get(i12);
            size = i13;
        }
        return false;
    }

    public final boolean K() {
        return this.f7055q != null;
    }

    public boolean L(int i11) {
        return this.f7057s.g(i11);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:51:0x00ab  */
    public final void M(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.f7049k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name) {
                        case "MotionScene":
                            Q(context, xml);
                            break;
                        case "Transition":
                            ArrayList<b> arrayList = this.f7043e;
                            bVar = new b(this, context, xml);
                            arrayList.add(bVar);
                            if (this.f7041c == null && !bVar.f7062b) {
                                this.f7041c = bVar;
                                if (bVar.f7072l != null) {
                                    this.f7041c.f7072l.x(this.f7056r);
                                }
                            }
                            if (!bVar.f7062b) {
                                break;
                            } else {
                                if (bVar.f7063c == -1) {
                                    this.f7044f = bVar;
                                } else {
                                    this.f7045g.add(bVar);
                                }
                                this.f7043e.remove(bVar);
                                break;
                            }
                            break;
                        case "OnSwipe":
                            if (bVar == null) {
                                Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i11) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f7072l = new q(context, this.f7039a, xml);
                                break;
                            }
                            break;
                        case "OnClick":
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.u(context, xml);
                                break;
                            }
                            break;
                        case "StateSet":
                            this.f7040b = new androidx.constraintlayout.widget.e(context, xml);
                            break;
                        case "ConstraintSet":
                            N(context, xml);
                            break;
                        case "include":
                        case "Include":
                            P(context, xml);
                            break;
                        case "KeyFrameSet":
                            g gVar = new g(context, xml);
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.f7071k.add(gVar);
                                break;
                            }
                            break;
                        case "ViewTransition":
                            this.f7057s.a(new s(context, xml));
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x0041  */
    /* JADX WARN: Code duplicated, block: B:30:0x0096  */
    public final int N(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.S(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int iS = -1;
        int iS2 = -1;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (this.f7049k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            switch (attributeName) {
                case "deriveConstraintsFrom":
                    iS2 = s(context, attributeValue);
                    break;
                case "constraintRotate":
                    try {
                        bVar.f7373d = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.hashCode();
                        switch (attributeValue) {
                            case "x_left":
                                bVar.f7373d = 4;
                                break;
                            case "left":
                                bVar.f7373d = 2;
                                break;
                            case "none":
                                bVar.f7373d = 0;
                                break;
                            case "right":
                                bVar.f7373d = 1;
                                break;
                            case "x_right":
                                bVar.f7373d = 3;
                                break;
                        }
                    }
                    break;
                case "id":
                    iS = s(context, attributeValue);
                    this.f7047i.put(c0(attributeValue), Integer.valueOf(iS));
                    bVar.f7371b = androidx.constraintlayout.motion.widget.a.c(context, iS);
                    break;
            }
        }
        if (iS != -1) {
            if (this.f7039a.f6811y != 0) {
                bVar.U(true);
            }
            bVar.F(context, xmlPullParser);
            if (iS2 != -1) {
                this.f7048j.put(iS, iS2);
            }
            this.f7046h.put(iS, bVar);
        }
        return iS;
    }

    public final int O(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return N(context, xml);
                }
            }
            return -1;
        } catch (IOException e11) {
            e11.printStackTrace();
            return -1;
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
            return -1;
        }
    }

    public final void P(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.include_constraintSet) {
                O(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void Q(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i12 = typedArrayObtainStyledAttributes.getInt(index, this.f7050l);
                this.f7050l = i12;
                if (i12 < 8) {
                    this.f7050l = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f7051m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void R(float f11, float f12) {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return;
        }
        this.f7041c.f7072l.u(f11, f12);
    }

    public void S(float f11, float f12) {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return;
        }
        this.f7041c.f7072l.v(f11, f12);
    }

    public void T(MotionEvent motionEvent, int i11, MotionLayout motionLayout) {
        MotionLayout.e eVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f7055q == null) {
            this.f7055q = this.f7039a.O();
        }
        this.f7055q.a(motionEvent);
        if (i11 != -1) {
            int action = motionEvent.getAction();
            boolean z11 = false;
            if (action == 0) {
                this.f7058t = motionEvent.getRawX();
                this.f7059u = motionEvent.getRawY();
                this.f7052n = motionEvent;
                this.f7053o = false;
                if (this.f7041c.f7072l != null) {
                    RectF rectFF = this.f7041c.f7072l.f(this.f7039a, rectF);
                    if (rectFF != null && !rectFF.contains(this.f7052n.getX(), this.f7052n.getY())) {
                        this.f7052n = null;
                        this.f7053o = true;
                        return;
                    }
                    RectF rectFP = this.f7041c.f7072l.p(this.f7039a, rectF);
                    if (rectFP == null || rectFP.contains(this.f7052n.getX(), this.f7052n.getY())) {
                        this.f7054p = false;
                    } else {
                        this.f7054p = true;
                    }
                    this.f7041c.f7072l.w(this.f7058t, this.f7059u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f7053o) {
                float rawY = motionEvent.getRawY() - this.f7059u;
                float rawX = motionEvent.getRawX() - this.f7058t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f7052n) == null) {
                    return;
                }
                b bVarI = i(i11, rawX, rawY, motionEvent2);
                if (bVarI != null) {
                    motionLayout.setTransition(bVarI);
                    RectF rectFP2 = this.f7041c.f7072l.p(this.f7039a, rectF);
                    if (rectFP2 != null && !rectFP2.contains(this.f7052n.getX(), this.f7052n.getY())) {
                        z11 = true;
                    }
                    this.f7054p = z11;
                    this.f7041c.f7072l.z(this.f7058t, this.f7059u);
                }
            }
        }
        if (this.f7053o) {
            return;
        }
        b bVar = this.f7041c;
        if (bVar != null && bVar.f7072l != null && !this.f7054p) {
            this.f7041c.f7072l.s(motionEvent, this.f7055q, i11, this);
        }
        this.f7058t = motionEvent.getRawX();
        this.f7059u = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (eVar = this.f7055q) == null) {
            return;
        }
        eVar.recycle();
        this.f7055q = null;
        int i12 = motionLayout.f6775g;
        if (i12 != -1) {
            h(motionLayout, i12);
        }
    }

    public final void U(int i11, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.b bVar = this.f7046h.get(i11);
        bVar.f7372c = bVar.f7371b;
        int i12 = this.f7048j.get(i11);
        if (i12 > 0) {
            U(i12, motionLayout);
            androidx.constraintlayout.widget.b bVar2 = this.f7046h.get(i12);
            if (bVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.c(this.f7039a.getContext(), i12));
                return;
            }
            bVar.f7372c += "/" + bVar2.f7372c;
            bVar.N(bVar2);
        } else {
            bVar.f7372c += "  layout";
            bVar.M(motionLayout);
        }
        bVar.h(bVar);
    }

    public void V(MotionLayout motionLayout) {
        for (int i11 = 0; i11 < this.f7046h.size(); i11++) {
            int iKeyAt = this.f7046h.keyAt(i11);
            if (J(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            U(iKeyAt, motionLayout);
        }
    }

    public void W(int i11, androidx.constraintlayout.widget.b bVar) {
        this.f7046h.put(i11, bVar);
    }

    public void X(int i11) {
        b bVar = this.f7041c;
        if (bVar != null) {
            bVar.E(i11);
        } else {
            this.f7050l = i11;
        }
    }

    public void Y(boolean z11) {
        this.f7056r = z11;
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return;
        }
        this.f7041c.f7072l.x(this.f7056r);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    /* JADX WARN: Code duplicated, block: B:40:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0075 A[SYNTHETIC] */
    public void Z(int i11, int i12) {
        int iC;
        int iC2;
        b bVar;
        Iterator<b> it;
        b bVar2;
        b bVar3;
        b next;
        androidx.constraintlayout.widget.e eVar = this.f7040b;
        if (eVar != null) {
            iC = eVar.c(i11, -1, -1);
            if (iC == -1) {
                iC = i11;
            }
            iC2 = this.f7040b.c(i12, -1, -1);
            if (iC2 == -1) {
            }
            bVar = this.f7041c;
            if (bVar == null && bVar.f7063c == i12 && this.f7041c.f7064d == i11) {
                return;
            }
            it = this.f7043e.iterator();
            while (true) {
                if (it.hasNext()) {
                    bVar2 = this.f7044f;
                    for (b bVar4 : this.f7045g) {
                        if (bVar4.f7063c == i12) {
                            bVar2 = bVar4;
                        }
                    }
                    bVar3 = new b(this, bVar2);
                    bVar3.f7064d = iC;
                    bVar3.f7063c = iC2;
                    if (iC != -1) {
                        this.f7043e.add(bVar3);
                    }
                    this.f7041c = bVar3;
                    return;
                }
                next = it.next();
                if ((next.f7063c != iC2 && next.f7064d == iC) || (next.f7063c == i12 && next.f7064d == i11)) {
                    break;
                }
            }
            this.f7041c = next;
            if (next != null || next.f7072l == null) {
            }
            this.f7041c.f7072l.x(this.f7056r);
            return;
        }
        iC = i11;
        iC2 = i12;
        bVar = this.f7041c;
        if (bVar == null) {
        }
        it = this.f7043e.iterator();
        while (true) {
            if (it.hasNext()) {
                bVar2 = this.f7044f;
                while (r3.hasNext()) {
                    if (bVar4.f7063c == i12) {
                        bVar2 = bVar4;
                    }
                }
                bVar3 = new b(this, bVar2);
                bVar3.f7064d = iC;
                bVar3.f7063c = iC2;
                if (iC != -1) {
                    this.f7043e.add(bVar3);
                }
                this.f7041c = bVar3;
                return;
            }
            next = it.next();
            if (next.f7063c != iC2) {
            }
        }
        this.f7041c = next;
        if (next != null) {
        }
    }

    public void a0(b bVar) {
        this.f7041c = bVar;
        if (bVar == null || bVar.f7072l == null) {
            return;
        }
        this.f7041c.f7072l.x(this.f7056r);
    }

    public void b0() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return;
        }
        this.f7041c.f7072l.A();
    }

    public boolean d0() {
        Iterator<b> it = this.f7043e.iterator();
        while (it.hasNext()) {
            if (it.next().f7072l != null) {
                return true;
            }
        }
        b bVar = this.f7041c;
        return (bVar == null || bVar.f7072l == null) ? false : true;
    }

    public void e0(int i11, View... viewArr) {
        this.f7057s.k(i11, viewArr);
    }

    public void f(MotionLayout motionLayout, int i11) {
        for (b bVar : this.f7043e) {
            if (bVar.f7073m.size() > 0) {
                Iterator it = bVar.f7073m.iterator();
                while (it.hasNext()) {
                    ((b.a) it.next()).c(motionLayout);
                }
            }
        }
        for (b bVar2 : this.f7045g) {
            if (bVar2.f7073m.size() > 0) {
                Iterator it2 = bVar2.f7073m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        for (b bVar3 : this.f7043e) {
            if (bVar3.f7073m.size() > 0) {
                Iterator it3 = bVar3.f7073m.iterator();
                while (it3.hasNext()) {
                    ((b.a) it3.next()).a(motionLayout, i11, bVar3);
                }
            }
        }
        for (b bVar4 : this.f7045g) {
            if (bVar4.f7073m.size() > 0) {
                Iterator it4 = bVar4.f7073m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).a(motionLayout, i11, bVar4);
                }
            }
        }
    }

    public boolean g(int i11, m mVar) {
        return this.f7057s.d(i11, mVar);
    }

    public boolean h(MotionLayout motionLayout, int i11) {
        b bVar;
        if (K() || this.f7042d) {
            return false;
        }
        for (b bVar2 : this.f7043e) {
            if (bVar2.f7074n != 0 && ((bVar = this.f7041c) != bVar2 || !bVar.D(2))) {
                if (i11 == bVar2.f7064d && (bVar2.f7074n == 4 || bVar2.f7074n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f7074n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.G(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.P();
                    }
                    return true;
                }
                if (i11 == bVar2.f7063c && (bVar2.f7074n == 3 || bVar2.f7074n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.f7074n == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.G(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.P();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i11, float f11, float f12, MotionEvent motionEvent) {
        if (i11 == -1) {
            return this.f7041c;
        }
        List<b> listI = I(i11);
        RectF rectF = new RectF();
        float f13 = 0.0f;
        b bVar = null;
        for (b bVar2 : listI) {
            if (!bVar2.f7075o && bVar2.f7072l != null) {
                bVar2.f7072l.x(this.f7056r);
                RectF rectFP = bVar2.f7072l.p(this.f7039a, rectF);
                if (rectFP == null || motionEvent == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFF = bVar2.f7072l.f(this.f7039a, rectF);
                    if (rectFF == null || motionEvent == null || rectFF.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fA = bVar2.f7072l.a(f11, f12);
                        if (bVar2.f7072l.f7093l && motionEvent != null) {
                            float x11 = motionEvent.getX() - bVar2.f7072l.f7090i;
                            float y11 = motionEvent.getY() - bVar2.f7072l.f7091j;
                            fA = ((float) (Math.atan2(f12 + y11, f11 + x11) - Math.atan2(x11, y11))) * 10.0f;
                        }
                        float f14 = fA * (bVar2.f7063c == i11 ? -1.0f : 1.1f);
                        if (f14 > f13) {
                            bVar = bVar2;
                            f13 = f14;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public void j(int i11, boolean z11) {
        this.f7057s.e(i11, z11);
    }

    public int k() {
        b bVar = this.f7041c;
        if (bVar != null) {
            return bVar.f7076p;
        }
        return -1;
    }

    public int l() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0;
        }
        return this.f7041c.f7072l.d();
    }

    public androidx.constraintlayout.widget.b m(int i11) {
        return n(i11, -1, -1);
    }

    public androidx.constraintlayout.widget.b n(int i11, int i12, int i13) {
        int iC;
        if (this.f7049k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i11);
            printStream.println("size " + this.f7046h.size());
        }
        androidx.constraintlayout.widget.e eVar = this.f7040b;
        if (eVar != null && (iC = eVar.c(i11, i12, i13)) != -1) {
            i11 = iC;
        }
        if (this.f7046h.get(i11) != null) {
            return this.f7046h.get(i11);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.c(this.f7039a.getContext(), i11) + " In MotionScene");
        SparseArray<androidx.constraintlayout.widget.b> sparseArray = this.f7046h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] o() {
        int size = this.f7046h.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = this.f7046h.keyAt(i11);
        }
        return iArr;
    }

    public ArrayList<b> p() {
        return this.f7043e;
    }

    public int q() {
        b bVar = this.f7041c;
        return bVar != null ? bVar.f7068h : this.f7050l;
    }

    public int r() {
        b bVar = this.f7041c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f7063c;
    }

    public final int s(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f7049k) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    public Interpolator t() {
        int i11 = this.f7041c.f7065e;
        if (i11 == -2) {
            return AnimationUtils.loadInterpolator(this.f7039a.getContext(), this.f7041c.f7067g);
        }
        if (i11 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.c.c(this.f7041c.f7066f));
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

    public void u(m mVar) {
        b bVar = this.f7041c;
        if (bVar != null) {
            Iterator it = bVar.f7071k.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(mVar);
            }
        } else {
            b bVar2 = this.f7044f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f7071k.iterator();
                while (it2.hasNext()) {
                    ((g) it2.next()).b(mVar);
                }
            }
        }
    }

    public float v() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.g();
    }

    public float w() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.h();
    }

    public boolean x() {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return false;
        }
        return this.f7041c.f7072l.i();
    }

    public float y(float f11, float f12) {
        b bVar = this.f7041c;
        if (bVar == null || bVar.f7072l == null) {
            return 0.0f;
        }
        return this.f7041c.f7072l.j(f11, f12);
    }

    public final int z(int i11) {
        int iC;
        androidx.constraintlayout.widget.e eVar = this.f7040b;
        return (eVar == null || (iC = eVar.c(i11, -1, -1)) == -1) ? i11 : iC;
    }
}
