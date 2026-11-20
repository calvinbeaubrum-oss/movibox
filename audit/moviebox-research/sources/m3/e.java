package m3;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f70730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f70731b;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public boolean a(@NonNull Editable editable, int i11, @NonNull KeyEvent keyEvent) {
            return EmojiCompat.g(editable, i11, keyEvent);
        }
    }

    public e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    public e(KeyListener keyListener, a aVar) {
        this.f70730a = keyListener;
        this.f70731b = aVar;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i11) {
        this.f70730a.clearMetaKeyState(view, editable, i11);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f70730a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f70731b.a(editable, i11, keyEvent) || this.f70730a.onKeyDown(view, editable, i11, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f70730a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f70730a.onKeyUp(view, editable, i11, keyEvent);
    }
}
