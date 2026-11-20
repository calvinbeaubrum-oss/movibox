package d7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.v;
import b7.k;
import b7.l;
import b7.m;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y6.o;
import y6.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends com.airbnb.lottie.model.layer.a {
    public final StringBuilder E;
    public final RectF F;
    public final Matrix G;
    public final Paint H;
    public final Paint I;
    public final Map<a7.c, List<x6.d>> J;
    public final v<String> K;
    public final List<d> L;
    public final o M;
    public final LottieDrawable N;
    public final h O;
    public TextRangeUnits P;

    @Nullable
    public y6.a<Integer, Integer> Q;

    @Nullable
    public y6.a<Integer, Integer> R;

    @Nullable
    public y6.a<Integer, Integer> S;

    @Nullable
    public y6.a<Integer, Integer> T;

    @Nullable
    public y6.a<Float, Float> U;

    @Nullable
    public y6.a<Float, Float> V;

    @Nullable
    public y6.a<Float, Float> W;

    @Nullable
    public y6.a<Float, Float> X;

    @Nullable
    public y6.a<Integer, Integer> Y;

    @Nullable
    public y6.a<Float, Float> Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    public y6.a<Typeface, Typeface> f62936a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @Nullable
    public y6.a<Integer, Integer> f62937b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public y6.a<Integer, Integer> f62938c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    public y6.a<Integer, Integer> f62939d0;

    /* JADX INFO: compiled from: source.java */
    public class a extends Paint {
        public a(int i11) {
            super(i11);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Paint {
        public b(int i11) {
            super(i11);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f62942a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            f62942a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62942a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f62942a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f62943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f62944b;

        public d() {
            this.f62943a = "";
            this.f62944b = 0.0f;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }

        public void c(String str, float f11) {
            this.f62943a = str;
            this.f62944b = f11;
        }
    }

    public f(LottieDrawable lottieDrawable, Layer layer) {
        l lVar;
        l lVar2;
        b7.d dVar;
        l lVar3;
        b7.d dVar2;
        l lVar4;
        b7.d dVar3;
        m mVar;
        b7.d dVar4;
        m mVar2;
        b7.b bVar;
        m mVar3;
        b7.b bVar2;
        m mVar4;
        b7.a aVar;
        m mVar5;
        b7.a aVar2;
        super(lottieDrawable, layer);
        this.E = new StringBuilder(2);
        this.F = new RectF();
        this.G = new Matrix();
        this.H = new a(1);
        this.I = new b(1);
        this.J = new HashMap();
        this.K = new v<>();
        this.L = new ArrayList();
        this.P = TextRangeUnits.INDEX;
        this.N = lottieDrawable;
        this.O = layer.c();
        o oVarA = layer.t().a();
        this.M = oVarA;
        oVarA.a(this);
        i(oVarA);
        k kVarU = layer.u();
        if (kVarU != null && (mVar5 = kVarU.f14039a) != null && (aVar2 = mVar5.f14045a) != null) {
            y6.a<Integer, Integer> aVarA = aVar2.a();
            this.Q = aVarA;
            aVarA.a(this);
            i(this.Q);
        }
        if (kVarU != null && (mVar4 = kVarU.f14039a) != null && (aVar = mVar4.f14046b) != null) {
            y6.a<Integer, Integer> aVarA2 = aVar.a();
            this.S = aVarA2;
            aVarA2.a(this);
            i(this.S);
        }
        if (kVarU != null && (mVar3 = kVarU.f14039a) != null && (bVar2 = mVar3.f14047c) != null) {
            y6.d dVarA = bVar2.a();
            this.U = dVarA;
            dVarA.a(this);
            i(this.U);
        }
        if (kVarU != null && (mVar2 = kVarU.f14039a) != null && (bVar = mVar2.f14048d) != null) {
            y6.d dVarA2 = bVar.a();
            this.W = dVarA2;
            dVarA2.a(this);
            i(this.W);
        }
        if (kVarU != null && (mVar = kVarU.f14039a) != null && (dVar4 = mVar.f14049e) != null) {
            y6.a<Integer, Integer> aVarA3 = dVar4.a();
            this.Y = aVarA3;
            aVarA3.a(this);
            i(this.Y);
        }
        if (kVarU != null && (lVar4 = kVarU.f14040b) != null && (dVar3 = lVar4.f14041a) != null) {
            y6.a<Integer, Integer> aVarA4 = dVar3.a();
            this.f62937b0 = aVarA4;
            aVarA4.a(this);
            i(this.f62937b0);
        }
        if (kVarU != null && (lVar3 = kVarU.f14040b) != null && (dVar2 = lVar3.f14042b) != null) {
            y6.a<Integer, Integer> aVarA5 = dVar2.a();
            this.f62938c0 = aVarA5;
            aVarA5.a(this);
            i(this.f62938c0);
        }
        if (kVarU != null && (lVar2 = kVarU.f14040b) != null && (dVar = lVar2.f14043c) != null) {
            y6.a<Integer, Integer> aVarA6 = dVar.a();
            this.f62939d0 = aVarA6;
            aVarA6.a(this);
            i(this.f62939d0);
        }
        if (kVarU == null || (lVar = kVarU.f14040b) == null) {
            return;
        }
        this.P = lVar.f14044d;
    }

    public final String P(String str, int i11) {
        int iCodePointAt = str.codePointAt(i11);
        int iCharCount = Character.charCount(iCodePointAt) + i11;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!e0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j11 = iCodePointAt;
        if (this.K.d(j11)) {
            return this.K.f(j11);
        }
        this.E.setLength(0);
        while (i11 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i11);
            this.E.appendCodePoint(iCodePointAt3);
            i11 += Character.charCount(iCodePointAt3);
        }
        String string = this.E.toString();
        this.K.l(j11, string);
        return string;
    }

    public final void Q(DocumentData documentData, int i11, int i12) {
        y6.a<Integer, Integer> aVar = this.R;
        if (aVar != null) {
            this.H.setColor(aVar.h().intValue());
        } else if (this.Q == null || !d0(i12)) {
            this.H.setColor(documentData.f15150h);
        } else {
            this.H.setColor(this.Q.h().intValue());
        }
        y6.a<Integer, Integer> aVar2 = this.T;
        if (aVar2 != null) {
            this.I.setColor(aVar2.h().intValue());
        } else if (this.S == null || !d0(i12)) {
            this.I.setColor(documentData.f15151i);
        } else {
            this.I.setColor(this.S.h().intValue());
        }
        int iIntValue = 100;
        int iIntValue2 = this.f15254x.h() == null ? 100 : this.f15254x.h().h().intValue();
        if (this.Y != null && d0(i12)) {
            iIntValue = this.Y.h().intValue();
        }
        int iRound = Math.round(((((iIntValue2 * 255.0f) / 100.0f) * (iIntValue / 100.0f)) * i11) / 255.0f);
        this.H.setAlpha(iRound);
        this.I.setAlpha(iRound);
        y6.a<Float, Float> aVar3 = this.V;
        if (aVar3 != null) {
            this.I.setStrokeWidth(aVar3.h().floatValue());
        } else if (this.U == null || !d0(i12)) {
            this.I.setStrokeWidth(documentData.f15152j * g7.l.e());
        } else {
            this.I.setStrokeWidth(this.U.h().floatValue());
        }
    }

    public final void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void S(a7.c cVar, float f11, DocumentData documentData, Canvas canvas, int i11, int i12) {
        Q(documentData, i12, i11);
        List<x6.d> listA0 = a0(cVar);
        for (int i13 = 0; i13 < listA0.size(); i13++) {
            Path path = listA0.get(i13).getPath();
            path.computeBounds(this.F, false);
            this.G.reset();
            this.G.preTranslate(0.0f, (-documentData.f15149g) * g7.l.e());
            this.G.preScale(f11, f11);
            path.transform(this.G);
            if (documentData.f15153k) {
                V(path, this.H, canvas);
                V(path, this.I, canvas);
            } else {
                V(path, this.I, canvas);
                V(path, this.H, canvas);
            }
        }
    }

    public final void T(String str, DocumentData documentData, Canvas canvas, int i11, int i12) {
        Q(documentData, i12, i11);
        if (documentData.f15153k) {
            R(str, this.H, canvas);
            R(str, this.I, canvas);
        } else {
            R(str, this.I, canvas);
            R(str, this.H, canvas);
        }
    }

    public final void U(String str, DocumentData documentData, Canvas canvas, float f11, int i11, int i12) {
        int length = 0;
        while (length < str.length()) {
            String strP = P(str, length);
            T(strP, documentData, canvas, i11 + length, i12);
            canvas.translate(this.H.measureText(strP) + f11, 0.0f);
            length += strP.length();
        }
    }

    public final void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void W(String str, DocumentData documentData, a7.b bVar, Canvas canvas, float f11, float f12, float f13, int i11) {
        for (int i12 = 0; i12 < str.length(); i12++) {
            a7.c cVarG = this.O.c().g(a7.c.c(str.charAt(i12), bVar.a(), bVar.c()));
            if (cVarG != null) {
                S(cVarG, f12, documentData, canvas, i12, i11);
                canvas.translate((((float) cVarG.b()) * f12 * g7.l.e()) + f13, 0.0f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x008c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0097  */
    /* JADX WARN: Code duplicated, block: B:21:0x009a  */
    /* JADX WARN: Code duplicated, block: B:25:0x00af  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:28:0x00df  */
    public final void X(DocumentData documentData, a7.b bVar, Canvas canvas, int i11) {
        float fFloatValue;
        float fE;
        List<String> listB0;
        int size;
        int i12;
        int i13;
        int length;
        PointF pointF;
        float f11;
        List<d> listG0;
        int i14;
        d dVar;
        Typeface typefaceC0 = c0(bVar);
        if (typefaceC0 == null) {
            return;
        }
        String str = documentData.f15143a;
        this.N.f0();
        this.H.setTypeface(typefaceC0);
        y6.a<Float, Float> aVar = this.Z;
        float fFloatValue2 = aVar != null ? aVar.h().floatValue() : documentData.f15145c;
        this.H.setTextSize(g7.l.e() * fFloatValue2);
        this.I.setTypeface(this.H.getTypeface());
        this.I.setTextSize(this.H.getTextSize());
        float f12 = documentData.f15147e / 10.0f;
        y6.a<Float, Float> aVar2 = this.X;
        if (aVar2 == null) {
            y6.a<Float, Float> aVar3 = this.W;
            if (aVar3 != null) {
                fFloatValue = aVar3.h().floatValue();
            }
            fE = ((f12 * g7.l.e()) * fFloatValue2) / 100.0f;
            listB0 = b0(str);
            size = listB0.size();
            i12 = -1;
            length = 0;
            for (i13 = 0; i13 < size; i13++) {
                String str2 = listB0.get(i13);
                pointF = documentData.f15155m;
                if (pointF == null) {
                    f11 = 0.0f;
                } else {
                    f11 = pointF.x;
                }
                i14 = 0;
                for (listG0 = g0(str2, f11, bVar, 0.0f, fE, false); i14 < listG0.size(); listG0 = listG0) {
                    dVar = listG0.get(i14);
                    i12++;
                    canvas.save();
                    if (f0(canvas, documentData, i12, dVar.f62944b)) {
                        U(dVar.f62943a, documentData, canvas, fE, length, i11);
                    }
                    length += dVar.f62943a.length();
                    canvas.restore();
                    i14++;
                }
            }
        }
        fFloatValue = aVar2.h().floatValue();
        f12 += fFloatValue;
        fE = ((f12 * g7.l.e()) * fFloatValue2) / 100.0f;
        listB0 = b0(str);
        size = listB0.size();
        i12 = -1;
        length = 0;
        while (i13 < size) {
            String str3 = listB0.get(i13);
            pointF = documentData.f15155m;
            if (pointF == null) {
                f11 = 0.0f;
            } else {
                f11 = pointF.x;
            }
            i14 = 0;
            while (i14 < listG0.size()) {
                dVar = listG0.get(i14);
                i12++;
                canvas.save();
                if (f0(canvas, documentData, i12, dVar.f62944b)) {
                    U(dVar.f62943a, documentData, canvas, fE, length, i11);
                }
                length += dVar.f62943a.length();
                canvas.restore();
                i14++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0054  */
    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x0077  */
    /* JADX WARN: Code duplicated, block: B:25:0x008e  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ab  */
    public final void Y(DocumentData documentData, Matrix matrix, a7.b bVar, Canvas canvas, int i11) {
        float fFloatValue;
        float f11;
        int i12;
        int i13;
        PointF pointF;
        float f12;
        List<d> listG0;
        int i14;
        d dVar;
        int i15;
        y6.a<Float, Float> aVar = this.Z;
        float fFloatValue2 = (aVar != null ? aVar.h().floatValue() : documentData.f15145c) / 100.0f;
        float fG = g7.l.g(matrix);
        List<String> listB0 = b0(documentData.f15143a);
        int size = listB0.size();
        float f13 = documentData.f15147e / 10.0f;
        y6.a<Float, Float> aVar2 = this.X;
        if (aVar2 == null) {
            y6.a<Float, Float> aVar3 = this.W;
            if (aVar3 != null) {
                fFloatValue = aVar3.h().floatValue();
            }
            f11 = f13;
            i12 = -1;
            i13 = 0;
            while (i13 < size) {
                String str = listB0.get(i13);
                pointF = documentData.f15155m;
                if (pointF == null) {
                    f12 = 0.0f;
                } else {
                    f12 = pointF.x;
                }
                listG0 = g0(str, f12, bVar, fFloatValue2, f11, true);
                i14 = 0;
                while (i14 < listG0.size()) {
                    dVar = listG0.get(i14);
                    i15 = i12 + 1;
                    canvas.save();
                    if (f0(canvas, documentData, i15, dVar.f62944b)) {
                        W(dVar.f62943a, documentData, bVar, canvas, fG, fFloatValue2, f11, i11);
                    }
                    canvas.restore();
                    i14++;
                    listG0 = listG0;
                    i12 = i15;
                    i13 = i13;
                }
                i13++;
            }
        }
        fFloatValue = aVar2.h().floatValue();
        f13 += fFloatValue;
        f11 = f13;
        i12 = -1;
        i13 = 0;
        while (i13 < size) {
            String str2 = listB0.get(i13);
            pointF = documentData.f15155m;
            if (pointF == null) {
                f12 = 0.0f;
            } else {
                f12 = pointF.x;
            }
            listG0 = g0(str2, f12, bVar, fFloatValue2, f11, true);
            i14 = 0;
            while (i14 < listG0.size()) {
                dVar = listG0.get(i14);
                i15 = i12 + 1;
                canvas.save();
                if (f0(canvas, documentData, i15, dVar.f62944b)) {
                    W(dVar.f62943a, documentData, bVar, canvas, fG, fFloatValue2, f11, i11);
                }
                canvas.restore();
                i14++;
                listG0 = listG0;
                i12 = i15;
                i13 = i13;
            }
            i13++;
        }
    }

    public final d Z(int i11) {
        for (int size = this.L.size(); size < i11; size++) {
            this.L.add(new d(null));
        }
        return this.L.get(i11 - 1);
    }

    public final List<x6.d> a0(a7.c cVar) {
        if (this.J.containsKey(cVar)) {
            return this.J.get(cVar);
        }
        List<c7.k> listA = cVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new x6.d(this.N, this, listA.get(i11), this.O));
        }
        this.J.put(cVar, arrayList);
        return arrayList;
    }

    public final List<String> b0(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    @Nullable
    public final Typeface c0(a7.b bVar) {
        Typeface typefaceH;
        y6.a<Typeface, Typeface> aVar = this.f62936a0;
        if (aVar != null && (typefaceH = aVar.h()) != null) {
            return typefaceH;
        }
        Typeface typefaceG0 = this.N.g0(bVar);
        return typefaceG0 != null ? typefaceG0 : bVar.d();
    }

    @Override // com.airbnb.lottie.model.layer.a, a7.e
    public <T> void d(T t11, @Nullable h7.c<T> cVar) {
        super.d(t11, cVar);
        if (t11 == p0.f15267a) {
            y6.a<Integer, Integer> aVar = this.R;
            if (aVar != null) {
                H(aVar);
            }
            if (cVar == null) {
                this.R = null;
                return;
            }
            q qVar = new q(cVar);
            this.R = qVar;
            qVar.a(this);
            i(this.R);
            return;
        }
        if (t11 == p0.f15268b) {
            y6.a<Integer, Integer> aVar2 = this.T;
            if (aVar2 != null) {
                H(aVar2);
            }
            if (cVar == null) {
                this.T = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.T = qVar2;
            qVar2.a(this);
            i(this.T);
            return;
        }
        if (t11 == p0.f15285s) {
            y6.a<Float, Float> aVar3 = this.V;
            if (aVar3 != null) {
                H(aVar3);
            }
            if (cVar == null) {
                this.V = null;
                return;
            }
            q qVar3 = new q(cVar);
            this.V = qVar3;
            qVar3.a(this);
            i(this.V);
            return;
        }
        if (t11 == p0.f15286t) {
            y6.a<Float, Float> aVar4 = this.X;
            if (aVar4 != null) {
                H(aVar4);
            }
            if (cVar == null) {
                this.X = null;
                return;
            }
            q qVar4 = new q(cVar);
            this.X = qVar4;
            qVar4.a(this);
            i(this.X);
            return;
        }
        if (t11 == p0.F) {
            y6.a<Float, Float> aVar5 = this.Z;
            if (aVar5 != null) {
                H(aVar5);
            }
            if (cVar == null) {
                this.Z = null;
                return;
            }
            q qVar5 = new q(cVar);
            this.Z = qVar5;
            qVar5.a(this);
            i(this.Z);
            return;
        }
        if (t11 != p0.M) {
            if (t11 == p0.O) {
                this.M.r(cVar);
                return;
            }
            return;
        }
        y6.a<Typeface, Typeface> aVar6 = this.f62936a0;
        if (aVar6 != null) {
            H(aVar6);
        }
        if (cVar == null) {
            this.f62936a0 = null;
            return;
        }
        q qVar6 = new q(cVar);
        this.f62936a0 = qVar6;
        qVar6.a(this);
        i(this.f62936a0);
    }

    public final boolean d0(int i11) {
        int length = this.M.h().f15143a.length();
        y6.a<Integer, Integer> aVar = this.f62937b0;
        if (aVar == null || this.f62938c0 == null) {
            return true;
        }
        int iMin = Math.min(aVar.h().intValue(), this.f62938c0.h().intValue());
        int iMax = Math.max(this.f62937b0.h().intValue(), this.f62938c0.h().intValue());
        y6.a<Integer, Integer> aVar2 = this.f62939d0;
        if (aVar2 != null) {
            int iIntValue = aVar2.h().intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.P == TextRangeUnits.INDEX) {
            return i11 >= iMin && i11 < iMax;
        }
        float f11 = (i11 / length) * 100.0f;
        return f11 >= ((float) iMin) && f11 < ((float) iMax);
    }

    public final boolean e0(int i11) {
        return Character.getType(i11) == 16 || Character.getType(i11) == 27 || Character.getType(i11) == 6 || Character.getType(i11) == 28 || Character.getType(i11) == 8 || Character.getType(i11) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, x6.e
    public void f(RectF rectF, Matrix matrix, boolean z11) {
        super.f(rectF, matrix, z11);
        rectF.set(0.0f, 0.0f, this.O.b().width(), this.O.b().height());
    }

    public final boolean f0(Canvas canvas, DocumentData documentData, int i11, float f11) {
        PointF pointF = documentData.f15154l;
        PointF pointF2 = documentData.f15155m;
        float fE = g7.l.e();
        float f12 = (i11 * documentData.f15148f * fE) + (pointF == null ? 0.0f : (documentData.f15148f * fE) + pointF.y);
        if (this.N.M() && pointF2 != null && pointF != null && f12 >= pointF.y + pointF2.y + documentData.f15145c) {
            return false;
        }
        float f13 = pointF == null ? 0.0f : pointF.x;
        float f14 = pointF2 != null ? pointF2.x : 0.0f;
        int i12 = c.f62942a[documentData.f15146d.ordinal()];
        if (i12 == 1) {
            canvas.translate(f13, f12);
        } else if (i12 == 2) {
            canvas.translate((f13 + f14) - f11, f12);
        } else if (i12 == 3) {
            canvas.translate((f13 + (f14 / 2.0f)) - (f11 / 2.0f), f12);
        }
        return true;
    }

    public final List<d> g0(String str, float f11, a7.b bVar, float f12, float f13, boolean z11) {
        float fMeasureText;
        float f14 = 0.0f;
        int i11 = 0;
        int i12 = 0;
        boolean z12 = false;
        float f15 = 0.0f;
        int i13 = 0;
        float f16 = 0.0f;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char cCharAt = str.charAt(i14);
            if (z11) {
                a7.c cVarG = this.O.c().g(a7.c.c(cCharAt, bVar.a(), bVar.c()));
                if (cVarG != null) {
                    fMeasureText = ((float) cVarG.b()) * f12 * g7.l.e();
                }
            } else {
                fMeasureText = this.H.measureText(str.substring(i14, i14 + 1));
            }
            float f17 = fMeasureText + f13;
            if (cCharAt == ' ') {
                z12 = true;
                f16 = f17;
            } else if (z12) {
                i13 = i14;
                f15 = f17;
                z12 = false;
            } else {
                f15 += f17;
            }
            f14 += f17;
            if (f11 > 0.0f && f14 >= f11 && cCharAt != ' ') {
                i11++;
                d dVarZ = Z(i11);
                if (i13 == i12) {
                    String strSubstring = str.substring(i12, i14);
                    String strTrim = strSubstring.trim();
                    dVarZ.c(strTrim, (f14 - f17) - ((strTrim.length() - strSubstring.length()) * f16));
                    i12 = i14;
                    i13 = i12;
                    f14 = f17;
                    f15 = f14;
                } else {
                    String strSubstring2 = str.substring(i12, i13 - 1);
                    String strTrim2 = strSubstring2.trim();
                    dVarZ.c(strTrim2, ((f14 - f15) - ((strSubstring2.length() - strTrim2.length()) * f16)) - f16);
                    f14 = f15;
                    i12 = i13;
                }
            }
        }
        if (f14 > 0.0f) {
            i11++;
            Z(i11).c(str.substring(i12), f14);
        }
        return this.L.subList(0, i11);
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(Canvas canvas, Matrix matrix, int i11) {
        DocumentData documentDataH = this.M.h();
        a7.b bVar = this.O.g().get(documentDataH.f15144b);
        if (bVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Q(documentDataH, i11, 0);
        if (this.N.C1()) {
            Y(documentDataH, matrix, bVar, canvas, i11);
        } else {
            X(documentDataH, bVar, canvas, i11);
        }
        canvas.restore();
    }
}
