package androidx.compose.ui.text;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class MultiParagraph {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiParagraphIntrinsics f5703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f5707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<y1.i> f5709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<m> f5710h;

    public MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z11) {
        boolean z12;
        this.f5703a = multiParagraphIntrinsics;
        this.f5704b = i11;
        if (q2.b.n(j11) != 0 || q2.b.m(j11) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
        }
        ArrayList arrayList = new ArrayList();
        List<n> listF = multiParagraphIntrinsics.f();
        int size = listF.size();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        float f11 = 0.0f;
        while (true) {
            if (i13 >= size) {
                z12 = false;
                break;
            }
            n nVar = listF.get(i13);
            l lVarC = q.c(nVar.b(), q2.c.b(0, q2.b.l(j11), 0, q2.b.g(j11) ? kotlin.ranges.a.d(q2.b.k(j11) - q.d(f11), i12) : q2.b.k(j11), 5, null), this.f5704b - i14, z11);
            float height = f11 + lVarC.getHeight();
            int i15 = i14 + lVarC.i();
            List<n> list = listF;
            arrayList.add(new m(lVarC, nVar.c(), nVar.a(), i14, i15, f11, height));
            if (lVarC.k() || (i15 == this.f5704b && i13 != kotlin.collections.g.n(this.f5703a.f()))) {
                z12 = true;
                i14 = i15;
                f11 = height;
                break;
            } else {
                i13++;
                i14 = i15;
                f11 = height;
                i12 = 0;
                listF = list;
            }
        }
        this.f5707e = f11;
        this.f5708f = i14;
        this.f5705c = z12;
        this.f5710h = arrayList;
        this.f5706d = q2.b.l(j11);
        List<y1.i> arrayList2 = new ArrayList<>(arrayList.size());
        int size2 = arrayList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            m mVar = (m) arrayList.get(i16);
            List<y1.i> listT = mVar.e().t();
            ArrayList arrayList3 = new ArrayList(listT.size());
            int size3 = listT.size();
            for (int i17 = 0; i17 < size3; i17++) {
                y1.i iVar = listT.get(i17);
                arrayList3.add(iVar != null ? mVar.i(iVar) : null);
            }
            kotlin.collections.k.A(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.f5703a.g().size()) {
            int size4 = this.f5703a.g().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i18 = 0; i18 < size4; i18++) {
                arrayList4.add(null);
            }
            arrayList2 = CollectionsKt___CollectionsKt.x0(arrayList2, arrayList4);
        }
        this.f5709g = arrayList2;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j11, i11, z11);
    }

    public final void B(int i11) {
        if (i11 < 0 || i11 >= b().i().length()) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + b().length() + ')').toString());
        }
    }

    public final void C(int i11) {
        if (i11 < 0 || i11 > b().i().length()) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + b().length() + ']').toString());
        }
    }

    public final void D(int i11) {
        if (i11 < 0 || i11 >= this.f5708f) {
            throw new IllegalArgumentException(("lineIndex(" + i11 + ") is out of bounds [0, " + this.f5708f + ')').toString());
        }
    }

    public final float[] a(final long j11, final float[] fArr, int i11) {
        B(c0.j(j11));
        C(c0.i(j11));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        i.d(this.f5710h, j11, new Function1<m, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m mVar) {
                invoke2(mVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m mVar) {
                long j12 = j11;
                float[] fArr2 = fArr;
                Ref.IntRef intRef2 = intRef;
                Ref.FloatRef floatRef2 = floatRef;
                long jB = d0.b(mVar.m(mVar.f() > c0.j(j12) ? mVar.f() : c0.j(j12)), mVar.m(mVar.b() < c0.i(j12) ? mVar.b() : c0.i(j12)));
                mVar.e().n(jB, fArr2, intRef2.element);
                int iH = intRef2.element + (c0.h(jB) * 4);
                for (int i12 = intRef2.element; i12 < iH; i12 += 4) {
                    int i13 = i12 + 1;
                    float f11 = fArr2[i13];
                    float f12 = floatRef2.element;
                    fArr2[i13] = f11 + f12;
                    int i14 = i12 + 3;
                    fArr2[i14] = fArr2[i14] + f12;
                }
                intRef2.element = iH;
                floatRef2.element += mVar.e().getHeight();
            }
        });
        return fArr;
    }

    public final AnnotatedString b() {
        return this.f5703a.e();
    }

    public final ResolvedTextDirection c(int i11) {
        C(i11);
        m mVar = this.f5710h.get(i11 == b().length() ? kotlin.collections.g.n(this.f5710h) : i.a(this.f5710h, i11));
        return mVar.e().q(mVar.m(i11));
    }

    public final y1.i d(int i11) {
        B(i11);
        m mVar = this.f5710h.get(i.a(this.f5710h, i11));
        return mVar.i(mVar.e().s(mVar.m(i11)));
    }

    public final y1.i e(int i11) {
        C(i11);
        m mVar = this.f5710h.get(i11 == b().length() ? kotlin.collections.g.n(this.f5710h) : i.a(this.f5710h, i11));
        return mVar.i(mVar.e().e(mVar.m(i11)));
    }

    public final boolean f() {
        return this.f5705c;
    }

    public final float g() {
        if (this.f5710h.isEmpty()) {
            return 0.0f;
        }
        return this.f5710h.get(0).e().f();
    }

    public final float h() {
        return this.f5707e;
    }

    public final MultiParagraphIntrinsics i() {
        return this.f5703a;
    }

    public final float j() {
        if (this.f5710h.isEmpty()) {
            return 0.0f;
        }
        m mVar = (m) CollectionsKt___CollectionsKt.q0(this.f5710h);
        return mVar.l(mVar.e().o());
    }

    public final float k(int i11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.l(mVar.e().r(mVar.n(i11)));
    }

    public final int l() {
        return this.f5708f;
    }

    public final int m(int i11, boolean z11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.j(mVar.e().h(mVar.n(i11), z11));
    }

    public final int n(int i11) {
        int iA;
        if (i11 >= b().length()) {
            iA = kotlin.collections.g.n(this.f5710h);
        } else {
            iA = i11 < 0 ? 0 : i.a(this.f5710h, i11);
        }
        m mVar = this.f5710h.get(iA);
        return mVar.k(mVar.e().p(mVar.m(i11)));
    }

    public final int o(float f11) {
        m mVar = this.f5710h.get(i.c(this.f5710h, f11));
        return mVar.d() == 0 ? mVar.g() : mVar.k(mVar.e().l(mVar.o(f11)));
    }

    public final float p(int i11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.e().m(mVar.n(i11));
    }

    public final float q(int i11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.e().j(mVar.n(i11));
    }

    public final int r(int i11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.j(mVar.e().g(mVar.n(i11)));
    }

    public final float s(int i11) {
        D(i11);
        m mVar = this.f5710h.get(i.b(this.f5710h, i11));
        return mVar.l(mVar.e().d(mVar.n(i11)));
    }

    public final ResolvedTextDirection t(int i11) {
        C(i11);
        m mVar = this.f5710h.get(i11 == b().length() ? kotlin.collections.g.n(this.f5710h) : i.a(this.f5710h, i11));
        return mVar.e().c(mVar.m(i11));
    }

    public final List<m> u() {
        return this.f5710h;
    }

    public final List<y1.i> v() {
        return this.f5709g;
    }

    public final float w() {
        return this.f5706d;
    }

    public final void x(o1 o1Var, long j11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        o1Var.d();
        List<m> list = this.f5710h;
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = list.get(i12);
            mVar.e().b(o1Var, j11, b5Var, iVar, hVar, i11);
            o1Var.c(0.0f, mVar.e().getHeight());
        }
        o1Var.k();
    }

    public final void z(o1 o1Var, l1 l1Var, float f11, b5 b5Var, androidx.compose.ui.text.style.i iVar, z1.h hVar, int i11) {
        androidx.compose.ui.text.platform.b.a(this, o1Var, l1Var, f11, b5Var, iVar, hVar, i11);
    }
}
