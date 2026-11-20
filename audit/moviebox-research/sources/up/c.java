package up;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c extends SpannableStringBuilder {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f78631a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f78632b = new c();

        public final void a() {
            if (this.f78631a.length() != 0) {
                this.f78632b.append(this.f78631a);
            }
        }

        public c b() {
            a();
            return this.f78632b;
        }

        public a c(int i11) {
            this.f78631a.c(i11);
            return this;
        }

        public a d(int i11) {
            this.f78631a.d(i11);
            return this;
        }

        public a e(CharSequence charSequence) {
            a();
            this.f78631a = new b(charSequence);
            return this;
        }

        public a f(Typeface typeface) {
            this.f78631a.e(typeface);
            return this;
        }
    }

    public static a e() {
        return new a();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c append(char c11) {
        super.append(c11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence, int i11, int i12) {
        super.append((CharSequence) new b(charSequence, i11, i12));
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c append(CharSequence charSequence, Object obj, int i11) {
        super.append(charSequence, obj, i11);
        return this;
    }
}
