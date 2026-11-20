package m3;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.i;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f70716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70717b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70718c = 0;

    /* JADX INFO: renamed from: m3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class C0755a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f70719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f70720b;

        public C0755a(@NonNull EditText editText, boolean z11) {
            this.f70719a = editText;
            g gVar = new g(editText, z11);
            this.f70720b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(m3.b.getInstance());
        }

        @Override // m3.a.b
        public KeyListener a(@Nullable KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // m3.a.b
        public boolean b() {
            return this.f70720b.b();
        }

        @Override // m3.a.b
        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f70719a, inputConnection, editorInfo);
        }

        @Override // m3.a.b
        public void d(boolean z11) {
            this.f70720b.d(z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        @Nullable
        public KeyListener a(@Nullable KeyListener keyListener) {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public InputConnection c(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
            throw null;
        }

        public void d(boolean z11) {
            throw null;
        }
    }

    public a(@NonNull EditText editText, boolean z11) {
        i.h(editText, "editText cannot be null");
        this.f70716a = new C0755a(editText, z11);
    }

    @Nullable
    public KeyListener a(@Nullable KeyListener keyListener) {
        return this.f70716a.a(keyListener);
    }

    public boolean b() {
        return this.f70716a.b();
    }

    @Nullable
    public InputConnection c(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f70716a.c(inputConnection, editorInfo);
    }

    public void d(boolean z11) {
        this.f70716a.d(z11);
    }
}
