package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends DrawableContainerCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f981o;

    /* JADX INFO: compiled from: source.java */
    public static class a extends DrawableContainerCompat.c {
        public int[][] J;

        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()][];
            }
        }

        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int iH = h();
            for (int i11 = 0; i11 < iH; i11++) {
                if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.c
        public void o(int i11, int i12) {
            super.o(i11, i12);
            int[][] iArr = new int[i12][];
            System.arraycopy(this.J, 0, iArr, 0, i11);
            this.J = iArr;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.c
        public void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[] iArr3 = this.J[length];
                iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
            }
            this.J = iArr2;
        }

        public int z(int[] iArr, Drawable drawable) {
            int iA = a(drawable);
            this.J[iA] = iArr;
            return iA;
        }
    }

    public d(@Nullable a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }

    public d(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    public void h(@NonNull DrawableContainerCompat.c cVar) {
        super.h(cVar);
        if (cVar instanceof a) {
            this.f980n = (a) cVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.f980n, this, null);
    }

    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i11 = 0;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i12);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i13 = i11 + 1;
                if (!attributeSet.getAttributeBooleanValue(i12, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i11] = attributeNameResource;
                i11 = i13;
            }
        }
        return StateSet.trimStateSet(iArr, i11);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f981o && super.mutate() == this) {
            this.f980n.r();
            this.f981o = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iA = this.f980n.A(iArr);
        if (iA < 0) {
            iA = this.f980n.A(StateSet.WILD_CARD);
        }
        return g(iA) || zOnStateChange;
    }
}
