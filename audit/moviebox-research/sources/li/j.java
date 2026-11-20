package li;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f70298d = {1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f70299e = {1, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70300c = 0;

    @Override // li.f
    @NonNull
    public com.google.android.material.carousel.b g(@NonNull b bVar, @NonNull View view) {
        float fB = bVar.b();
        if (bVar.d()) {
            fB = bVar.a();
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        float f11 = ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (bVar.d()) {
            f11 = ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float f12 = f11;
        float fD = d() + f12;
        float fMax = Math.max(c() + f12, fD);
        float fMin = Math.min(measuredHeight + f12, fB);
        float fA = g3.a.a((measuredHeight / 3.0f) + f12, fD + f12, fMax + f12);
        float f13 = (fMin + fA) / 2.0f;
        int[] iArrA = f70298d;
        if (fB < 2.0f * fD) {
            iArrA = new int[]{0};
        }
        int[] iArrA2 = f70299e;
        if (bVar.c() == 1) {
            iArrA = f.a(iArrA);
            iArrA2 = f.a(iArrA2);
        }
        int[] iArr = iArrA;
        int[] iArr2 = iArrA2;
        int iMax = (int) Math.max(1.0d, Math.floor(((fB - (com.google.android.material.carousel.a.i(iArr2) * f13)) - (com.google.android.material.carousel.a.i(iArr) * fMax)) / fMin));
        int iCeil = (int) Math.ceil(fB / fMin);
        int i11 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr3[i12] = iCeil - i12;
        }
        a aVarC = a.c(fB, fA, fD, fMax, iArr, f13, iArr2, fMin, iArr3);
        this.f70300c = aVarC.e();
        if (i(aVarC, bVar.getItemCount())) {
            aVarC = a.c(fB, fA, fD, fMax, new int[]{aVarC.f70284c}, f13, new int[]{aVarC.f70285d}, fMin, new int[]{aVarC.f70288g});
        }
        return com.google.android.material.carousel.a.d(view.getContext(), f12, fB, aVarC, bVar.c());
    }

    @Override // li.f
    public boolean h(b bVar, int i11) {
        return (i11 < this.f70300c && bVar.getItemCount() >= this.f70300c) || (i11 >= this.f70300c && bVar.getItemCount() < this.f70300c);
    }

    public boolean i(a aVar, int i11) {
        int iE = aVar.e() - i11;
        boolean z11 = iE > 0 && (aVar.f70284c > 0 || aVar.f70285d > 1);
        while (iE > 0) {
            int i12 = aVar.f70284c;
            if (i12 > 0) {
                aVar.f70284c = i12 - 1;
            } else {
                int i13 = aVar.f70285d;
                if (i13 > 1) {
                    aVar.f70285d = i13 - 1;
                }
            }
            iE--;
        }
        return z11;
    }
}
