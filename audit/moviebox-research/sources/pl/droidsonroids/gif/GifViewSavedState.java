package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[][] f73918a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<GifViewSavedState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GifViewSavedState[] newArray(int i11) {
            return new GifViewSavedState[i11];
        }
    }

    public GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.f73918a = new long[parcel.readInt()][];
        int i11 = 0;
        while (true) {
            long[][] jArr = this.f73918a;
            if (i11 >= jArr.length) {
                return;
            }
            jArr[i11] = parcel.createLongArray();
            i11++;
        }
    }

    public /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.f73918a = new long[][]{jArr};
    }

    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f73918a = new long[drawableArr.length][];
        for (int i11 = 0; i11 < drawableArr.length; i11++) {
            Drawable drawable = drawableArr[i11];
            if (drawable instanceof GifDrawable) {
                this.f73918a[i11] = ((GifDrawable) drawable).f73894h.m();
            } else {
                this.f73918a[i11] = null;
            }
        }
    }

    public void a(Drawable drawable, int i11) {
        long[] jArr = this.f73918a[i11];
        if (jArr == null || !(drawable instanceof GifDrawable)) {
            return;
        }
        GifDrawable gifDrawable = (GifDrawable) drawable;
        gifDrawable.j(gifDrawable.f73894h.x(jArr, gifDrawable.f73893g));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        super.writeToParcel(parcel, i11);
        parcel.writeInt(this.f73918a.length);
        for (long[] jArr : this.f73918a) {
            parcel.writeLongArray(jArr);
        }
    }
}
