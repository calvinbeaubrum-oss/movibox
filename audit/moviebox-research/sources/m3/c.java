package m3;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f70724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f70725b;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public boolean a(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i11, int i12, boolean z11) {
            return EmojiCompat.f(inputConnection, editable, i11, i12, z11);
        }

        public void b(@NonNull EditorInfo editorInfo) {
            if (EmojiCompat.i()) {
                EmojiCompat.c().v(editorInfo);
            }
        }
    }

    public c(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    public c(@NonNull TextView textView, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull a aVar) {
        super(inputConnection, false);
        this.f70724a = textView;
        this.f70725b = aVar;
        aVar.b(editorInfo);
    }

    public final Editable a() {
        return this.f70724a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i11, int i12) {
        return this.f70725b.a(this, a(), i11, i12, false) || super.deleteSurroundingText(i11, i12);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i11, int i12) {
        return this.f70725b.a(this, a(), i11, i12, true) || super.deleteSurroundingTextInCodePoints(i11, i12);
    }
}
