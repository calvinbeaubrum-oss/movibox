package m3;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f70737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiCompat.f f70739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70740d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f70741f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f70742g = true;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class a extends EmojiCompat.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<EditText> f70743a;

        public a(EditText editText) {
            this.f70743a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            super.b();
            g.c(this.f70743a.get(), 1);
        }
    }

    public g(EditText editText, boolean z11) {
        this.f70737a = editText;
        this.f70738b = z11;
    }

    public static void c(@Nullable EditText editText, int i11) {
        if (i11 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final EmojiCompat.f a() {
        if (this.f70739c == null) {
            this.f70739c = new a(this.f70737a);
        }
        return this.f70739c;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f70742g;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void d(boolean z11) {
        if (this.f70742g != z11) {
            if (this.f70739c != null) {
                EmojiCompat.c().u(this.f70739c);
            }
            this.f70742g = z11;
            if (z11) {
                c(this.f70737a, EmojiCompat.c().e());
            }
        }
    }

    public final boolean e() {
        return (this.f70742g && (this.f70738b || EmojiCompat.i())) ? false : true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (this.f70737a.isInEditMode() || e() || i12 > i13 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = EmojiCompat.c().e();
        if (iE != 0) {
            if (iE == 1) {
                EmojiCompat.c().s((Spannable) charSequence, i11, i11 + i13, this.f70740d, this.f70741f);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        EmojiCompat.c().t(a());
    }
}
