package d3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f62887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f62888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f62889d;

    public f(@Nullable f fVar) {
        this.f62888c = null;
        this.f62889d = d.f62878h;
        if (fVar != null) {
            this.f62886a = fVar.f62886a;
            this.f62887b = fVar.f62887b;
            this.f62888c = fVar.f62888c;
            this.f62889d = fVar.f62889d;
        }
    }

    public boolean a() {
        return this.f62887b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i11 = this.f62886a;
        Drawable.ConstantState constantState = this.f62887b;
        return i11 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @NonNull
    public Drawable newDrawable(@Nullable Resources resources) {
        return new e(this, resources);
    }
}
