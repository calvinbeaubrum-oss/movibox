package m3;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f70726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EmojiCompat.f f70727b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class a extends EmojiCompat.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Reference<TextView> f70728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Reference<d> f70729b;

        public a(TextView textView, d dVar) {
            this.f70728a = new WeakReference(textView);
            this.f70729b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            CharSequence text;
            CharSequence charSequenceP;
            super.b();
            TextView textView = this.f70728a.get();
            if (c(textView, this.f70729b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = EmojiCompat.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(@Nullable TextView textView, @Nullable InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(@NonNull TextView textView) {
        this.f70726a = textView;
    }

    public static void b(Spannable spannable, int i11, int i12) {
        if (i11 >= 0 && i12 >= 0) {
            Selection.setSelection(spannable, i11, i12);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        } else if (i12 >= 0) {
            Selection.setSelection(spannable, i12);
        }
    }

    public final EmojiCompat.f a() {
        if (this.f70727b == null) {
            this.f70727b = new a(this.f70726a, this);
        }
        return this.f70727b;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        if (this.f70726a.isInEditMode()) {
            return charSequence;
        }
        int iE = EmojiCompat.c().e();
        if (iE != 0) {
            if (iE == 1) {
                if ((i14 == 0 && i13 == 0 && spanned.length() == 0 && charSequence == this.f70726a.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i11 != 0 || i12 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i11, i12);
                }
                return EmojiCompat.c().q(charSequence, 0, charSequence.length());
            }
            if (iE != 3) {
                return charSequence;
            }
        }
        EmojiCompat.c().t(a());
        return charSequence;
    }
}
