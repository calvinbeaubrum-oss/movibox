package x6;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class q implements s, y6.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieDrawable f80397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f80398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y6.a<Float, Float> f80399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public c7.i f80400d;

    public q(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, c7.h hVar) {
        this.f80397a = lottieDrawable;
        this.f80398b = hVar.c();
        y6.a<Float, Float> aVarA = hVar.b().a();
        this.f80399c = aVarA;
        aVar.i(aVarA);
        aVarA.a(this);
    }

    public static int d(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    public static int e(int i11, int i12) {
        return i11 - (d(i11, i12) * i12);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x009f  */
    @Override // x6.s
    public c7.i a(c7.i iVar) {
        boolean z11;
        List<a7.a> listA = iVar.a();
        if (listA.size() <= 2) {
            return iVar;
        }
        float fFloatValue = this.f80399c.h().floatValue();
        if (fFloatValue == 0.0f) {
            return iVar;
        }
        c7.i iVarI = i(iVar);
        iVarI.f(iVar.b().x, iVar.b().y);
        List<a7.a> listA2 = iVarI.a();
        boolean zD = iVar.d();
        int i11 = 0;
        int i12 = 0;
        while (i11 < listA.size()) {
            a7.a aVar = listA.get(i11);
            a7.a aVar2 = listA.get(e(i11 - 1, listA.size()));
            a7.a aVar3 = listA.get(e(i11 - 2, listA.size()));
            PointF pointFC = (i11 != 0 || zD) ? aVar2.c() : iVar.b();
            PointF pointFB = (i11 != 0 || zD) ? aVar2.b() : pointFC;
            PointF pointFA = aVar.a();
            PointF pointFC2 = aVar3.c();
            PointF pointFC3 = aVar.c();
            if (iVar.d()) {
                z11 = false;
            } else {
                z11 = true;
                if (i11 != 0 && i11 != listA.size() - 1) {
                    z11 = false;
                }
            }
            if (pointFB.equals(pointFC) && pointFA.equals(pointFC) && !z11) {
                float f11 = pointFC.x;
                float f12 = f11 - pointFC2.x;
                float f13 = pointFC.y;
                float f14 = f13 - pointFC2.y;
                float f15 = pointFC3.x - f11;
                float f16 = pointFC3.y - f13;
                float fHypot = (float) Math.hypot(f12, f14);
                float fHypot2 = (float) Math.hypot(f15, f16);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f17 = pointFC.x;
                float f18 = ((pointFC2.x - f17) * fMin) + f17;
                float f19 = pointFC.y;
                float f21 = ((pointFC2.y - f19) * fMin) + f19;
                float f22 = ((pointFC3.x - f17) * fMin2) + f17;
                float f23 = ((pointFC3.y - f19) * fMin2) + f19;
                float f24 = f18 - ((f18 - f17) * 0.5519f);
                float f25 = f21 - ((f21 - f19) * 0.5519f);
                float f26 = f22 - ((f22 - f17) * 0.5519f);
                float f27 = f23 - ((f23 - f19) * 0.5519f);
                a7.a aVar4 = listA2.get(e(i12 - 1, listA2.size()));
                a7.a aVar5 = listA2.get(i12);
                aVar4.e(f18, f21);
                aVar4.f(f18, f21);
                if (i11 == 0) {
                    iVarI.f(f18, f21);
                }
                aVar5.d(f24, f25);
                a7.a aVar6 = listA2.get(i12 + 1);
                aVar5.e(f26, f27);
                aVar5.f(f22, f23);
                aVar6.d(f22, f23);
                i12 += 2;
            } else {
                a7.a aVar7 = listA2.get(e(i12 - 1, listA2.size()));
                a7.a aVar8 = listA2.get(i12);
                aVar7.e(aVar2.b().x, aVar2.b().y);
                aVar7.f(aVar2.c().x, aVar2.c().y);
                aVar8.d(aVar.a().x, aVar.a().y);
                i12++;
            }
            i11++;
            listA = listA;
        }
        return iVarI;
    }

    @Override // y6.a.b
    public void b() {
        this.f80397a.invalidateSelf();
    }

    @Override // x6.c
    public void c(List<c> list, List<c> list2) {
    }

    public y6.a<Float, Float> g() {
        return this.f80399c;
    }

    @NonNull
    public final c7.i i(c7.i iVar) {
        List<a7.a> listA = iVar.a();
        boolean zD = iVar.d();
        int size = listA.size() - 1;
        int i11 = 0;
        while (size >= 0) {
            a7.a aVar = listA.get(size);
            a7.a aVar2 = listA.get(e(size - 1, listA.size()));
            PointF pointFC = (size != 0 || zD) ? aVar2.c() : iVar.b();
            i11 = (((size != 0 || zD) ? aVar2.b() : pointFC).equals(pointFC) && aVar.a().equals(pointFC) && !(!iVar.d() && (size == 0 || size == listA.size() - 1))) ? i11 + 2 : i11 + 1;
            size--;
        }
        c7.i iVar2 = this.f80400d;
        if (iVar2 == null || iVar2.a().size() != i11) {
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new a7.a());
            }
            this.f80400d = new c7.i(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f80400d.e(zD);
        return this.f80400d;
    }
}
