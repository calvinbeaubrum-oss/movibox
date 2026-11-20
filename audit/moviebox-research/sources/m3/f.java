package m3;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.i;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f70732a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f70733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f70734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f70735c = true;

        public a(TextView textView) {
            this.f70733a = textView;
            this.f70734b = new d(textView);
        }

        @Override // m3.f.b
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return !this.f70735c ? h(inputFilterArr) : f(inputFilterArr);
        }

        @Override // m3.f.b
        public boolean b() {
            return this.f70735c;
        }

        @Override // m3.f.b
        public void c(boolean z11) {
            if (z11) {
                l();
            }
        }

        @Override // m3.f.b
        public void d(boolean z11) {
            this.f70735c = z11;
            l();
            k();
        }

        @Override // m3.f.b
        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            return this.f70735c ? m(transformationMethod) : j(transformationMethod);
        }

        @NonNull
        public final InputFilter[] f(@NonNull InputFilter[] inputFilterArr) {
            int length = inputFilterArr.length;
            for (InputFilter inputFilter : inputFilterArr) {
                if (inputFilter == this.f70734b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, length);
            inputFilterArr2[length] = this.f70734b;
            return inputFilterArr2;
        }

        public final SparseArray<InputFilter> g(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArray = new SparseArray<>(1);
            for (int i11 = 0; i11 < inputFilterArr.length; i11++) {
                InputFilter inputFilter = inputFilterArr[i11];
                if (inputFilter instanceof d) {
                    sparseArray.put(i11, inputFilter);
                }
            }
            return sparseArray;
        }

        @NonNull
        public final InputFilter[] h(@NonNull InputFilter[] inputFilterArr) {
            SparseArray<InputFilter> sparseArrayG = g(inputFilterArr);
            if (sparseArrayG.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArrayG.size()];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (sparseArrayG.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }

        public void i(boolean z11) {
            this.f70735c = z11;
        }

        @Nullable
        public final TransformationMethod j(@Nullable TransformationMethod transformationMethod) {
            return transformationMethod instanceof h ? ((h) transformationMethod).a() : transformationMethod;
        }

        public final void k() {
            this.f70733a.setFilters(a(this.f70733a.getFilters()));
        }

        public void l() {
            this.f70733a.setTransformationMethod(e(this.f70733a.getTransformationMethod()));
        }

        @NonNull
        public final TransformationMethod m(@Nullable TransformationMethod transformationMethod) {
            return ((transformationMethod instanceof h) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new h(transformationMethod);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public void c(boolean z11) {
            throw null;
        }

        public void d(boolean z11) {
            throw null;
        }

        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f70736a;

        public c(TextView textView) {
            this.f70736a = new a(textView);
        }

        @Override // m3.f.b
        @NonNull
        public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
            return f() ? inputFilterArr : this.f70736a.a(inputFilterArr);
        }

        @Override // m3.f.b
        public boolean b() {
            return this.f70736a.b();
        }

        @Override // m3.f.b
        public void c(boolean z11) {
            if (f()) {
                return;
            }
            this.f70736a.c(z11);
        }

        @Override // m3.f.b
        public void d(boolean z11) {
            if (f()) {
                this.f70736a.i(z11);
            } else {
                this.f70736a.d(z11);
            }
        }

        @Override // m3.f.b
        @Nullable
        public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
            return f() ? transformationMethod : this.f70736a.e(transformationMethod);
        }

        public final boolean f() {
            return !EmojiCompat.i();
        }
    }

    public f(@NonNull TextView textView, boolean z11) {
        i.h(textView, "textView cannot be null");
        if (z11) {
            this.f70732a = new a(textView);
        } else {
            this.f70732a = new c(textView);
        }
    }

    @NonNull
    public InputFilter[] a(@NonNull InputFilter[] inputFilterArr) {
        return this.f70732a.a(inputFilterArr);
    }

    public boolean b() {
        return this.f70732a.b();
    }

    public void c(boolean z11) {
        this.f70732a.c(z11);
    }

    public void d(boolean z11) {
        this.f70732a.d(z11);
    }

    @Nullable
    public TransformationMethod e(@Nullable TransformationMethod transformationMethod) {
        return this.f70732a.e(transformationMethod);
    }
}
