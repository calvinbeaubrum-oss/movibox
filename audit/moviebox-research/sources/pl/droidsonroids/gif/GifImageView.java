package pl.droidsonroids.gif;

import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class GifImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f73907a;

    public GifImageView(Context context) {
        super(context);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(d.c(this, attributeSet, 0, 0));
    }

    public GifImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(d.c(this, attributeSet, i11, 0));
    }

    @RequiresApi(21)
    public GifImageView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        a(d.c(this, attributeSet, i11, i12));
    }

    public final void a(d.a aVar) {
        this.f73907a = aVar.f73924a;
        int i11 = aVar.f73922c;
        if (i11 > 0) {
            super.setImageResource(i11);
        }
        int i12 = aVar.f73923d;
        if (i12 > 0) {
            super.setBackgroundResource(i12);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new GifViewSavedState(super.onSaveInstanceState(), this.f73907a ? getDrawable() : null, this.f73907a ? getBackground() : null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i11) {
        if (d.e(this, false, i11)) {
            return;
        }
        super.setBackgroundResource(i11);
    }

    public void setFreezesAnimation(boolean z11) {
        this.f73907a = z11;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i11) {
        if (d.e(this, true, i11)) {
            return;
        }
        super.setImageResource(i11);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (d.d(this, uri)) {
            return;
        }
        super.setImageURI(uri);
    }
}
