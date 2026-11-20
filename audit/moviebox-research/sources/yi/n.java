package yi;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f81423m = new l(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f81424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f81425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f81426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f81427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f81428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f81429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f81430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f81431h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f81432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f81433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f81434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f81435l;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public e f81436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public e f81437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public e f81438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public e f81439d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        public d f81440e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        public d f81441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        public d f81442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NonNull
        public d f81443h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public g f81444i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @NonNull
        public g f81445j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @NonNull
        public g f81446k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @NonNull
        public g f81447l;

        public b() {
            this.f81436a = j.b();
            this.f81437b = j.b();
            this.f81438c = j.b();
            this.f81439d = j.b();
            this.f81440e = new yi.a(0.0f);
            this.f81441f = new yi.a(0.0f);
            this.f81442g = new yi.a(0.0f);
            this.f81443h = new yi.a(0.0f);
            this.f81444i = j.c();
            this.f81445j = j.c();
            this.f81446k = j.c();
            this.f81447l = j.c();
        }

        public b(@NonNull n nVar) {
            this.f81436a = j.b();
            this.f81437b = j.b();
            this.f81438c = j.b();
            this.f81439d = j.b();
            this.f81440e = new yi.a(0.0f);
            this.f81441f = new yi.a(0.0f);
            this.f81442g = new yi.a(0.0f);
            this.f81443h = new yi.a(0.0f);
            this.f81444i = j.c();
            this.f81445j = j.c();
            this.f81446k = j.c();
            this.f81447l = j.c();
            this.f81436a = nVar.f81424a;
            this.f81437b = nVar.f81425b;
            this.f81438c = nVar.f81426c;
            this.f81439d = nVar.f81427d;
            this.f81440e = nVar.f81428e;
            this.f81441f = nVar.f81429f;
            this.f81442g = nVar.f81430g;
            this.f81443h = nVar.f81431h;
            this.f81444i = nVar.f81432i;
            this.f81445j = nVar.f81433j;
            this.f81446k = nVar.f81434k;
            this.f81447l = nVar.f81435l;
        }

        public static float n(e eVar) {
            if (eVar instanceof m) {
                return ((m) eVar).f81422a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f81367a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(@NonNull e eVar) {
            this.f81438c = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                B(fN);
            }
            return this;
        }

        @NonNull
        public b B(float f11) {
            this.f81442g = new yi.a(f11);
            return this;
        }

        @NonNull
        public b C(@NonNull d dVar) {
            this.f81442g = dVar;
            return this;
        }

        @NonNull
        public b D(@NonNull g gVar) {
            this.f81444i = gVar;
            return this;
        }

        @NonNull
        public b E(int i11, float f11) {
            return G(j.a(i11)).H(f11);
        }

        @NonNull
        public b F(int i11, @NonNull d dVar) {
            return G(j.a(i11)).I(dVar);
        }

        @NonNull
        public b G(@NonNull e eVar) {
            this.f81436a = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                H(fN);
            }
            return this;
        }

        @NonNull
        public b H(float f11) {
            this.f81440e = new yi.a(f11);
            return this;
        }

        @NonNull
        public b I(@NonNull d dVar) {
            this.f81440e = dVar;
            return this;
        }

        @NonNull
        public b J(int i11, float f11) {
            return L(j.a(i11)).M(f11);
        }

        @NonNull
        public b K(int i11, @NonNull d dVar) {
            return L(j.a(i11)).N(dVar);
        }

        @NonNull
        public b L(@NonNull e eVar) {
            this.f81437b = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                M(fN);
            }
            return this;
        }

        @NonNull
        public b M(float f11) {
            this.f81441f = new yi.a(f11);
            return this;
        }

        @NonNull
        public b N(@NonNull d dVar) {
            this.f81441f = dVar;
            return this;
        }

        @NonNull
        public n m() {
            return new n(this);
        }

        @NonNull
        public b o(float f11) {
            return H(f11).M(f11).B(f11).w(f11);
        }

        @NonNull
        public b p(@NonNull d dVar) {
            return I(dVar).N(dVar).C(dVar).x(dVar);
        }

        @NonNull
        public b q(int i11, float f11) {
            return r(j.a(i11)).o(f11);
        }

        @NonNull
        public b r(@NonNull e eVar) {
            return G(eVar).L(eVar).A(eVar).v(eVar);
        }

        @NonNull
        public b s(@NonNull g gVar) {
            this.f81446k = gVar;
            return this;
        }

        @NonNull
        public b t(int i11, float f11) {
            return v(j.a(i11)).w(f11);
        }

        @NonNull
        public b u(int i11, @NonNull d dVar) {
            return v(j.a(i11)).x(dVar);
        }

        @NonNull
        public b v(@NonNull e eVar) {
            this.f81439d = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                w(fN);
            }
            return this;
        }

        @NonNull
        public b w(float f11) {
            this.f81443h = new yi.a(f11);
            return this;
        }

        @NonNull
        public b x(@NonNull d dVar) {
            this.f81443h = dVar;
            return this;
        }

        @NonNull
        public b y(int i11, float f11) {
            return A(j.a(i11)).B(f11);
        }

        @NonNull
        public b z(int i11, @NonNull d dVar) {
            return A(j.a(i11)).C(dVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        @NonNull
        d a(@NonNull d dVar);
    }

    public n() {
        this.f81424a = j.b();
        this.f81425b = j.b();
        this.f81426c = j.b();
        this.f81427d = j.b();
        this.f81428e = new yi.a(0.0f);
        this.f81429f = new yi.a(0.0f);
        this.f81430g = new yi.a(0.0f);
        this.f81431h = new yi.a(0.0f);
        this.f81432i = j.c();
        this.f81433j = j.c();
        this.f81434k = j.c();
        this.f81435l = j.c();
    }

    public n(@NonNull b bVar) {
        this.f81424a = bVar.f81436a;
        this.f81425b = bVar.f81437b;
        this.f81426c = bVar.f81438c;
        this.f81427d = bVar.f81439d;
        this.f81428e = bVar.f81440e;
        this.f81429f = bVar.f81441f;
        this.f81430g = bVar.f81442g;
        this.f81431h = bVar.f81443h;
        this.f81432i = bVar.f81444i;
        this.f81433j = bVar.f81445j;
        this.f81434k = bVar.f81446k;
        this.f81435l = bVar.f81447l;
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, int i11, int i12) {
        return c(context, i11, i12, 0);
    }

    @NonNull
    public static b c(Context context, int i11, int i12, int i13) {
        return d(context, i11, i12, new yi.a(i13));
    }

    @NonNull
    public static b d(Context context, int i11, int i12, @NonNull d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i11);
        if (i12 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i12);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.ShapeAppearance);
        try {
            int i13 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i13);
            int i15 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i13);
            int i16 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i13);
            int i17 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i13);
            d dVarM = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, dVar);
            d dVarM2 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, dVarM);
            d dVarM3 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, dVarM);
            d dVarM4 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, dVarM);
            return new b().F(i14, dVarM2).K(i15, dVarM3).z(i16, dVarM4).u(i17, m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, dVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, int i11, int i12) {
        return f(context, attributeSet, i11, i12, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, int i11, int i12, int i13) {
        return g(context, attributeSet, i11, i12, new yi.a(i13));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, int i11, int i12, @NonNull d dVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i11, i12);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    @NonNull
    public static d m(TypedArray typedArray, int i11, @NonNull d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i11);
        if (typedValuePeekValue == null) {
            return dVar;
        }
        int i12 = typedValuePeekValue.type;
        if (i12 == 5) {
            return new yi.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i12 == 6 ? new l(typedValuePeekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @NonNull
    public g h() {
        return this.f81434k;
    }

    @NonNull
    public e i() {
        return this.f81427d;
    }

    @NonNull
    public d j() {
        return this.f81431h;
    }

    @NonNull
    public e k() {
        return this.f81426c;
    }

    @NonNull
    public d l() {
        return this.f81430g;
    }

    @NonNull
    public g n() {
        return this.f81435l;
    }

    @NonNull
    public g o() {
        return this.f81433j;
    }

    @NonNull
    public g p() {
        return this.f81432i;
    }

    @NonNull
    public e q() {
        return this.f81424a;
    }

    @NonNull
    public d r() {
        return this.f81428e;
    }

    @NonNull
    public e s() {
        return this.f81425b;
    }

    @NonNull
    public d t() {
        return this.f81429f;
    }

    public boolean u(@NonNull RectF rectF) {
        boolean z11 = this.f81435l.getClass().equals(g.class) && this.f81433j.getClass().equals(g.class) && this.f81432i.getClass().equals(g.class) && this.f81434k.getClass().equals(g.class);
        float fA = this.f81428e.a(rectF);
        return z11 && ((this.f81429f.a(rectF) > fA ? 1 : (this.f81429f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f81431h.a(rectF) > fA ? 1 : (this.f81431h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f81430g.a(rectF) > fA ? 1 : (this.f81430g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f81425b instanceof m) && (this.f81424a instanceof m) && (this.f81426c instanceof m) && (this.f81427d instanceof m));
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public n w(float f11) {
        return v().o(f11).m();
    }

    @NonNull
    public n x(@NonNull d dVar) {
        return v().p(dVar).m();
    }

    @NonNull
    public n y(@NonNull c cVar) {
        return v().I(cVar.a(r())).N(cVar.a(t())).x(cVar.a(j())).C(cVar.a(l())).m();
    }
}
