package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EmojiCompat.i f8328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final m f8329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public EmojiCompat.e f8330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final int[] f8332e;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static final class a {
        public static int a(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    i11--;
                    if (i11 < 0) {
                        return z11 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i11);
                    if (z11) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i12--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i12--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z11 = true;
                    }
                }
                return i11;
            }
        }

        public static int b(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z11 = false;
                while (i12 != 0) {
                    if (i11 >= length) {
                        if (z11) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i11);
                    if (z11) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i12--;
                        i11++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i12--;
                        i11++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i11++;
                        z11 = true;
                    }
                }
                return i11;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements c<s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public s f8333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final EmojiCompat.i f8334b;

        public b(@Nullable s sVar, EmojiCompat.i iVar) {
            this.f8333a = sVar;
            this.f8334b = iVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(@NonNull CharSequence charSequence, int i11, int i12, o oVar) {
            if (oVar.k()) {
                return true;
            }
            if (this.f8333a == null) {
                this.f8333a = new s(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f8333a.setSpan(this.f8334b.a(oVar), i11, i12, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public s a() {
            return this.f8333a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c<T> {
        T a();

        boolean b(@NonNull CharSequence charSequence, int i11, int i12, o oVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements c<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8335a;

        public d(String str) {
            this.f8335a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(@NonNull CharSequence charSequence, int i11, int i12, o oVar) {
            if (!TextUtils.equals(charSequence.subSequence(i11, i12), this.f8335a)) {
                return true;
            }
            oVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8336a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m.a f8337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public m.a f8338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m.a f8339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8340e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f8342g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f8343h;

        public e(m.a aVar, boolean z11, int[] iArr) {
            this.f8337b = aVar;
            this.f8338c = aVar;
            this.f8342g = z11;
            this.f8343h = iArr;
        }

        public static boolean d(int i11) {
            return i11 == 65039;
        }

        public static boolean f(int i11) {
            return i11 == 65038;
        }

        public int a(int i11) {
            m.a aVarA = this.f8338c.a(i11);
            int iG = 2;
            if (this.f8336a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f8336a = 2;
                    this.f8338c = aVarA;
                    this.f8341f = 1;
                }
            } else if (aVarA != null) {
                this.f8338c = aVarA;
                this.f8341f++;
            } else if (f(i11)) {
                iG = g();
            } else if (!d(i11)) {
                if (this.f8338c.b() != null) {
                    iG = 3;
                    if (this.f8341f != 1 || h()) {
                        this.f8339d = this.f8338c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f8340e = i11;
            return iG;
        }

        public o b() {
            return this.f8338c.b();
        }

        public o c() {
            return this.f8339d.b();
        }

        public boolean e() {
            return this.f8336a == 2 && this.f8338c.b() != null && (this.f8341f > 1 || h());
        }

        public final int g() {
            this.f8336a = 1;
            this.f8338c = this.f8337b;
            this.f8341f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f8338c.b().j() || d(this.f8340e)) {
                return true;
            }
            if (this.f8342g) {
                if (this.f8343h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f8343h, this.f8338c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public h(@NonNull m mVar, @NonNull EmojiCompat.i iVar, @NonNull EmojiCompat.e eVar, boolean z11, @Nullable int[] iArr, @NonNull Set<int[]> set) {
        this.f8328a = iVar;
        this.f8329b = mVar;
        this.f8330c = eVar;
        this.f8331d = z11;
        this.f8332e = iArr;
        g(set);
    }

    public static boolean a(@NonNull Editable editable, @NonNull KeyEvent keyEvent, boolean z11) {
        i[] iVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z11 && spanStart == selectionStart) || ((!z11 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i11, int i12, boolean z11) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i11 >= 0 && i12 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z11) {
                iMax = a.a(editable, selectionStart, Math.max(i11, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i12, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i11, 0);
                iMin = Math.min(selectionEnd + i12, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(iMax, iMin, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean c(@NonNull Editable editable, int i11, @NonNull KeyEvent keyEvent) {
        boolean zA;
        if (i11 != 67) {
            if (i11 == 112) {
                zA = a(editable, keyEvent, true);
            }
            return false;
        }
        zA = a(editable, keyEvent, false);
        if (zA) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    public static boolean e(int i11, int i12) {
        return i11 == -1 || i12 == -1 || i11 != i12;
    }

    public static boolean f(@NonNull KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final boolean d(CharSequence charSequence, int i11, int i12, o oVar) {
        if (oVar.d() == 0) {
            oVar.m(this.f8330c.a(charSequence, i11, i12, oVar.h()));
        }
        return oVar.d() == 2;
    }

    public final void g(@NonNull Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    public CharSequence h(@NonNull CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
        s sVar;
        i[] iVarArr;
        boolean z12 = charSequence instanceof n;
        if (z12) {
            ((n) charSequence).a();
        }
        if (!z12) {
            try {
                sVar = charSequence instanceof Spannable ? new s((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i11 + (-1), i12 + 1, i.class) > i12) ? null : new s(charSequence);
            } finally {
                if (z12) {
                    ((n) charSequence).d();
                }
            }
        }
        if (sVar != null && (iVarArr = (i[]) sVar.getSpans(i11, i12, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = sVar.getSpanStart(iVar);
                int spanEnd = sVar.getSpanEnd(iVar);
                if (spanStart != i12) {
                    sVar.removeSpan(iVar);
                }
                i11 = Math.min(spanStart, i11);
                i12 = Math.max(spanEnd, i12);
            }
        }
        int i14 = i12;
        if (i11 != i14 && i11 < charSequence.length()) {
            if (i13 != Integer.MAX_VALUE && sVar != null) {
                i13 -= ((i[]) sVar.getSpans(0, sVar.length(), i.class)).length;
            }
            s sVar2 = (s) i(charSequence, i11, i14, i13, z11, new b(sVar, this.f8328a));
            return sVar2 != null ? sVar2.b() : charSequence;
        }
        return charSequence;
    }

    public final <T> T i(@NonNull CharSequence charSequence, int i11, int i12, int i13, boolean z11, c<T> cVar) {
        int iCharCount;
        e eVar = new e(this.f8329b.f(), this.f8331d, this.f8332e);
        int iCodePointAt = Character.codePointAt(charSequence, i11);
        int i14 = 0;
        boolean zB = true;
        loop0: while (true) {
            iCharCount = i11;
            while (true) {
                if (i11 >= i12 || i14 >= i13 || !zB) {
                    break loop0;
                }
                int iA = eVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i12) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i11 = iCharCount;
                } else if (iA == 2) {
                    i11 += Character.charCount(iCodePointAt);
                    if (i11 < i12) {
                        iCodePointAt = Character.codePointAt(charSequence, i11);
                    }
                } else if (iA != 3) {
                }
            }
            if (z11 || !d(charSequence, iCharCount, i11, eVar.c())) {
                zB = cVar.b(charSequence, iCharCount, i11, eVar.c());
                i14++;
            }
        }
        if (eVar.e() && i14 < i13 && zB && (z11 || !d(charSequence, iCharCount, i11, eVar.b()))) {
            cVar.b(charSequence, iCharCount, i11, eVar.b());
        }
        return cVar.a();
    }
}
