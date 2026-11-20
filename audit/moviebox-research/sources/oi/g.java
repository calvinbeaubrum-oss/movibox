package oi;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class g extends androidx.appcompat.graphics.drawable.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72435c;

    public g(@NonNull Drawable drawable, int i11, int i12) {
        super(drawable);
        this.f72434b = i11;
        this.f72435c = i12;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f72435c;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f72434b;
    }
}
