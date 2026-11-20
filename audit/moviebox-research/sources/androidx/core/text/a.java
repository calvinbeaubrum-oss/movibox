package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f7857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f7859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f7860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f7861h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f7864c;

    /* JADX INFO: renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public t f7867c;

        public C0073a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z11) {
            return z11 ? a.f7861h : a.f7860g;
        }

        public a a() {
            return (this.f7866b == 2 && this.f7867c == a.f7857d) ? b(this.f7865a) : new a(this.f7865a, this.f7866b, this.f7867c);
        }

        public final void c(boolean z11) {
            this.f7865a = z11;
            this.f7867c = a.f7857d;
            this.f7866b = 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f7868f = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f7869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public char f7873e;

        static {
            for (int i11 = 0; i11 < 1792; i11++) {
                f7868f[i11] = Character.getDirectionality(i11);
            }
        }

        public b(CharSequence charSequence, boolean z11) {
            this.f7869a = charSequence;
            this.f7870b = z11;
            this.f7871c = charSequence.length();
        }

        public static byte c(char c11) {
            return c11 < 1792 ? f7868f[c11] : Character.getDirectionality(c11);
        }

        public byte a() {
            char cCharAt = this.f7869a.charAt(this.f7872d - 1);
            this.f7873e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f7869a, this.f7872d);
                this.f7872d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f7872d--;
            byte bC = c(this.f7873e);
            if (!this.f7870b) {
                return bC;
            }
            char c11 = this.f7873e;
            if (c11 == '>') {
                return h();
            }
            return c11 == ';' ? f() : bC;
        }

        public byte b() {
            char cCharAt = this.f7869a.charAt(this.f7872d);
            this.f7873e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f7869a, this.f7872d);
                this.f7872d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f7872d++;
            byte bC = c(this.f7873e);
            if (!this.f7870b) {
                return bC;
            }
            char c11 = this.f7873e;
            if (c11 == '<') {
                return i();
            }
            return c11 == '&' ? g() : bC;
        }

        public int d() {
            this.f7872d = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (this.f7872d < this.f7871c && i11 == 0) {
                byte b11 = b();
                if (b11 != 0) {
                    if (b11 == 1 || b11 == 2) {
                        if (i13 == 0) {
                            return 1;
                        }
                    } else if (b11 != 9) {
                        switch (b11) {
                            case 14:
                            case 15:
                                i13++;
                                i12 = -1;
                                continue;
                            case 16:
                            case 17:
                                i13++;
                                i12 = 1;
                                continue;
                            case 18:
                                i13--;
                                i12 = 0;
                                continue;
                        }
                    }
                } else if (i13 == 0) {
                    return -1;
                }
                i11 = i13;
            }
            if (i11 == 0) {
                return 0;
            }
            if (i12 != 0) {
                return i12;
            }
            while (this.f7872d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i11 == i13) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i11 == i13) {
                            return 1;
                        }
                        break;
                    case 18:
                        i13++;
                        continue;
                    default:
                        continue;
                }
                i13--;
            }
            return 0;
        }

        public int e() {
            this.f7872d = this.f7871c;
            int i11 = 0;
            int i12 = 0;
            while (this.f7872d > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i11 == 0) {
                        return -1;
                    }
                    if (i12 == 0) {
                        i12 = i11;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i11 == 0) {
                        return 1;
                    }
                    if (i12 == 0) {
                        i12 = i11;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i12 == i11) {
                                return -1;
                            }
                            i11--;
                            break;
                        case 16:
                        case 17:
                            if (i12 == i11) {
                                return 1;
                            }
                            i11--;
                            break;
                        case 18:
                            i11++;
                            break;
                        default:
                            if (i12 == 0) {
                                i12 = i11;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }

        public final byte f() {
            char cCharAt;
            int i11 = this.f7872d;
            do {
                int i12 = this.f7872d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f7869a;
                int i13 = i12 - 1;
                this.f7872d = i13;
                cCharAt = charSequence.charAt(i13);
                this.f7873e = cCharAt;
                if (cCharAt == '&') {
                    return Ascii.FF;
                }
            } while (cCharAt != ';');
            this.f7872d = i11;
            this.f7873e = ';';
            return Ascii.CR;
        }

        public final byte g() {
            char cCharAt;
            do {
                int i11 = this.f7872d;
                if (i11 >= this.f7871c) {
                    return Ascii.FF;
                }
                CharSequence charSequence = this.f7869a;
                this.f7872d = i11 + 1;
                cCharAt = charSequence.charAt(i11);
                this.f7873e = cCharAt;
            } while (cCharAt != ';');
            return Ascii.FF;
        }

        public final byte h() {
            char cCharAt;
            int i11 = this.f7872d;
            while (true) {
                int i12 = this.f7872d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f7869a;
                int i13 = i12 - 1;
                this.f7872d = i13;
                char cCharAt2 = charSequence.charAt(i13);
                this.f7873e = cCharAt2;
                if (cCharAt2 == '<') {
                    return Ascii.FF;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i14 = this.f7872d;
                        if (i14 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f7869a;
                        int i15 = i14 - 1;
                        this.f7872d = i15;
                        cCharAt = charSequence2.charAt(i15);
                        this.f7873e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f7872d = i11;
            this.f7873e = '>';
            return Ascii.CR;
        }

        public final byte i() {
            char cCharAt;
            int i11 = this.f7872d;
            while (true) {
                int i12 = this.f7872d;
                if (i12 >= this.f7871c) {
                    this.f7872d = i11;
                    this.f7873e = '<';
                    return Ascii.CR;
                }
                CharSequence charSequence = this.f7869a;
                this.f7872d = i12 + 1;
                char cCharAt2 = charSequence.charAt(i12);
                this.f7873e = cCharAt2;
                if (cCharAt2 == '>') {
                    return Ascii.FF;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i13 = this.f7872d;
                        if (i13 >= this.f7871c) {
                            break;
                        }
                        CharSequence charSequence2 = this.f7869a;
                        this.f7872d = i13 + 1;
                        cCharAt = charSequence2.charAt(i13);
                        this.f7873e = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }
    }

    static {
        t tVar = u.f7877c;
        f7857d = tVar;
        f7858e = Character.toString((char) 8206);
        f7859f = Character.toString((char) 8207);
        f7860g = new a(false, 2, tVar);
        f7861h = new a(true, 2, tVar);
    }

    public a(boolean z11, int i11, t tVar) {
        this.f7862a = z11;
        this.f7863b = i11;
        this.f7864c = tVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0073a().a();
    }

    public static boolean e(Locale locale) {
        return v.a(locale) == 1;
    }

    public boolean d() {
        return (this.f7863b & 2) != 0;
    }

    public final String f(CharSequence charSequence, t tVar) {
        boolean zA = tVar.a(charSequence, 0, charSequence.length());
        if (!this.f7862a && (zA || b(charSequence) == 1)) {
            return f7858e;
        }
        if (this.f7862a) {
            return (!zA || b(charSequence) == -1) ? f7859f : "";
        }
        return "";
    }

    public final String g(CharSequence charSequence, t tVar) {
        boolean zA = tVar.a(charSequence, 0, charSequence.length());
        if (!this.f7862a && (zA || a(charSequence) == 1)) {
            return f7858e;
        }
        if (this.f7862a) {
            return (!zA || a(charSequence) == -1) ? f7859f : "";
        }
        return "";
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f7864c, true);
    }

    public CharSequence i(CharSequence charSequence, t tVar, boolean z11) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = tVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z11) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? u.f7876b : u.f7875a));
        }
        if (zA != this.f7862a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z11) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? u.f7876b : u.f7875a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return l(str, this.f7864c, true);
    }

    public String k(String str, t tVar) {
        return l(str, tVar, true);
    }

    public String l(String str, t tVar, boolean z11) {
        if (str == null) {
            return null;
        }
        return i(str, tVar, z11).toString();
    }
}
