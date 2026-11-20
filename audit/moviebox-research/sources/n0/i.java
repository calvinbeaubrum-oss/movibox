package n0;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements o0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f71347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f71348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f71349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f71350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f71351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f71353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f71354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f71355i;

    @Override // o0.e
    public ImageView a(View view) {
        return o0.e.a.a(view);
    }

    public abstract boolean b();

    @Override // o0.e
    public View getView() {
        return this.f71347a;
    }

    @Override // o0.e
    public void setDuration(int i11) {
        this.f71349c = i11;
    }

    @Override // o0.e
    public void setGravity(int i11, int i12, int i13) {
        this.f71350d = i11;
        this.f71351e = i12;
        this.f71352f = i13;
    }

    @Override // o0.e
    public void setMargin(float f11, float f12) {
        this.f71353g = f11;
        this.f71354h = f12;
    }

    @Override // o0.e
    public void setText(CharSequence charSequence) {
        TextView textView = this.f71348b;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // o0.e
    public void setView(View view) {
        this.f71347a = view;
        if (view == null) {
            this.f71348b = null;
        } else {
            this.f71348b = o0.e.a.b(view);
        }
    }
}
