package com.applovin.exoplayer2.common.base;

import java.util.Arrays;
import java.util.BitSet;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f17155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f17156b;

        public a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f17155a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f17156b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return this.f17155a.matches(c11) && this.f17156b.matches(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f17155a.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f17156b.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.f17155a + ", " + this.f17156b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a0 extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f17157b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final a0 f17158c = new a0();

        public a0() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c11) >>> f17157b) == c11;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            for (int i11 = 0; i11 < 32; i11++) {
                bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f17159b = new b();

        private b() {
            super("CharMatcher.any()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c11) {
            return charSequence.length() == 0 ? "" : String.valueOf(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i11) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i11, length);
            if (i11 == length) {
                return -1;
            }
            return i11;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c11) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c11);
            return new String(cArr);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb2 = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i11 = 0; i11 < charSequence.length(); i11++) {
                sb2.append(charSequence2);
            }
            return sb2.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char[] f17160a;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f17160a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Arrays.binarySearch(this.f17160a, c11) >= 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            for (char c11 : this.f17160a) {
                bitSet.set(c11);
            }
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            StringBuilder sb2 = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c11 : this.f17160a) {
                sb2.append(CharMatcher.showCharacter(c11));
            }
            sb2.append("\")");
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final d f17161b = new d();

        public d() {
            super("CharMatcher.ascii()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return c11 <= 127;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f17162a = new e();

        private e() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            if (c11 != ' ' && c11 != 133 && c11 != 5760) {
                if (c11 == 8199) {
                    return false;
                }
                if (c11 != 8287 && c11 != 12288 && c11 != 8232 && c11 != 8233) {
                    switch (c11) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c11 >= 8192 && c11 <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final f f17163d = new f();

        private f() {
            super("CharMatcher.digit()", b(), a());
        }

        private static char[] a() {
            char[] cArr = new char[37];
            for (int i11 = 0; i11 < 37; i11++) {
                cArr[i11] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i11) + '\t');
            }
            return cArr;
        }

        private static char[] b() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class g extends CharMatcher {
        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return new v(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Predicate f17164a;

        public h(Predicate predicate) {
            this.f17164a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Character ch2) {
            return this.f17164a.apply(Preconditions.checkNotNull(ch2));
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return this.f17164a.apply(Character.valueOf(c11));
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f17164a + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class i extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f17165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f17166b;

        public i(char c11, char c12) {
            Preconditions.checkArgument(c12 >= c11);
            this.f17165a = c11;
            this.f17166b = c12;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return this.f17165a <= c11 && c11 <= this.f17166b;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            bitSet.set(this.f17165a, this.f17166b + 1);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.f17165a) + "', '" + CharMatcher.showCharacter(this.f17166b) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class j extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final j f17167d = new j();

        private j() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class k extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f17168a;

        public k(char c11) {
            this.f17168a = c11;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.f17168a) ? this : CharMatcher.none();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return c11 == this.f17168a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.f17168a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.f17168a) ? charMatcher : super.or(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c11) {
            return charSequence.toString().replace(this.f17168a, c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            bitSet.set(this.f17168a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.f17168a) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class l extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f17169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f17170b;

        public l(char c11, char c12) {
            this.f17169a = c11;
            this.f17170b = c12;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return c11 == this.f17169a || c11 == this.f17170b;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            bitSet.set(this.f17169a);
            bitSet.set(this.f17170b);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.f17169a) + CharMatcher.showCharacter(this.f17170b) + "\")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f17171a;

        public m(char c11) {
            this.f17171a = c11;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.f17171a) ? super.and(charMatcher) : charMatcher;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return c11 != this.f17171a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.f17171a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.f17171a) ? CharMatcher.any() : this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            bitSet.set(0, this.f17171a);
            bitSet.set(this.f17171a + 1, 65536);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.f17171a) + "')";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class n extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final n f17172a = new n();

        private n() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Character.isDigit(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class o extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final o f17173b = new o();

        private o() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return c11 <= 31 || (c11 >= 127 && c11 <= 159);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class p extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f17174a = new p();

        private p() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Character.isLetter(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class q extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final q f17175a = new q();

        private q() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Character.isLetterOrDigit(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class r extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final r f17176a = new r();

        private r() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Character.isLowerCase(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class s extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f17177a = new s();

        private s() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return Character.isUpperCase(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class t extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17178a;

        public t(String str) {
            this.f17178a = (String) Preconditions.checkNotNull(str);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public final String toString() {
            return this.f17178a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class u extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f17179a;

        public u(CharMatcher charMatcher) {
            this.f17179a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.f17179a.countIn(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return !this.f17179a.matches(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.f17179a.matchesNoneOf(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.f17179a.matchesAllOf(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return this.f17179a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f17179a.setBits(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return this.f17179a + ".negate()";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class v extends u {
        public v(CharMatcher charMatcher) {
            super(charMatcher);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class w extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final w f17180b = new w();

        private w() {
            super("CharMatcher.none()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c11) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i11) {
            Preconditions.checkPositionIndex(i11, charSequence.length());
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c11) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class x extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f17181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f17182b;

        public x(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f17181a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f17182b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            return this.f17181a.matches(c11) || this.f17182b.matches(c11);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public void setBits(BitSet bitSet) {
            this.f17181a.setBits(bitSet);
            this.f17182b.setBits(bitSet);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.f17181a + ", " + this.f17182b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class y extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f17184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char[] f17185c;

        public y(String str, char[] cArr, char[] cArr2) {
            this.f17183a = str;
            this.f17184b = cArr;
            this.f17185c = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i11 = 0;
            while (i11 < cArr.length) {
                Preconditions.checkArgument(cArr[i11] <= cArr2[i11]);
                int i12 = i11 + 1;
                if (i12 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i11] < cArr[i12]);
                }
                i11 = i12;
            }
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch2) {
            return super.apply(ch2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c11) {
            int iBinarySearch = Arrays.binarySearch(this.f17184b, c11);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i11 = (~iBinarySearch) - 1;
            return i11 >= 0 && c11 <= this.f17185c[i11];
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return this.f17183a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class z extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final z f17186d = new z();

        private z() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    public static CharMatcher any() {
        return b.f17159b;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return none();
        }
        if (length != 1) {
            return length != 2 ? new c(charSequence) : isEither(charSequence.charAt(0), charSequence.charAt(1));
        }
        return is(charSequence.charAt(0));
    }

    public static CharMatcher ascii() {
        return d.f17161b;
    }

    public static CharMatcher breakingWhitespace() {
        return e.f17162a;
    }

    @Deprecated
    public static CharMatcher digit() {
        return f.f17163d;
    }

    private String finishCollapseFrom(CharSequence charSequence, int i11, int i12, char c11, StringBuilder sb2, boolean z11) {
        while (i11 < i12) {
            char cCharAt = charSequence.charAt(i11);
            if (!matches(cCharAt)) {
                sb2.append(cCharAt);
                z11 = false;
            } else if (!z11) {
                sb2.append(c11);
                z11 = true;
            }
            i11++;
        }
        return sb2.toString();
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new h(predicate);
    }

    public static CharMatcher inRange(char c11, char c12) {
        return new i(c11, c12);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return j.f17167d;
    }

    public static CharMatcher is(char c11) {
        return new k(c11);
    }

    private static l isEither(char c11, char c12) {
        return new l(c11, c12);
    }

    public static CharMatcher isNot(char c11) {
        return new m(c11);
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return n.f17172a;
    }

    public static CharMatcher javaIsoControl() {
        return o.f17173b;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return p.f17174a;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return q.f17175a;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return r.f17176a;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return s.f17177a;
    }

    public static CharMatcher none() {
        return w.f17180b;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String showCharacter(char c11) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(c11 & 15);
            c11 = (char) (c11 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return z.f17186d;
    }

    public static CharMatcher whitespace() {
        return a0.f17158c;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new a(this, charMatcher);
    }

    @Override // com.applovin.exoplayer2.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch2) {
        return matches(ch2.charValue());
    }

    public String collapseFrom(CharSequence charSequence, char c11) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            char cCharAt = charSequence.charAt(i11);
            if (matches(cCharAt)) {
                if (cCharAt != c11 || (i11 != length - 1 && matches(charSequence.charAt(i11 + 1)))) {
                    StringBuilder sb2 = new StringBuilder(length);
                    sb2.append(charSequence, 0, i11);
                    sb2.append(c11);
                    return finishCollapseFrom(charSequence, i11 + 1, length, c11, sb2, true);
                }
                i11++;
            }
            i11++;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i11 = 0;
        for (int i12 = 0; i12 < charSequence.length(); i12++) {
            if (matches(charSequence.charAt(i12))) {
                i11++;
            }
        }
        return i11;
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i11, length);
        while (i11 < length) {
            if (matches(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c11);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public CharMatcher negate() {
        return new u(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new x(this, charMatcher);
    }

    public String removeFrom(CharSequence charSequence) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i11 = 1;
        while (true) {
            iIndexIn++;
            while (iIndexIn != charArray.length) {
                if (matches(charArray[iIndexIn])) {
                    i11++;
                } else {
                    charArray[iIndexIn - i11] = charArray[iIndexIn];
                    iIndexIn++;
                }
            }
            return new String(charArray, 0, iIndexIn - i11);
        }
    }

    public String replaceFrom(CharSequence charSequence, char c11) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iIndexIn] = c11;
        while (true) {
            iIndexIn++;
            if (iIndexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[iIndexIn])) {
                charArray[iIndexIn] = c11;
            }
        }
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i11 = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb2 = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb2.append((CharSequence) string, i11, iIndexIn);
            sb2.append(charSequence2);
            i11 = iIndexIn + 1;
            iIndexIn = indexIn(string, i11);
        } while (iIndexIn != -1);
        sb2.append((CharSequence) string, i11, length2);
        return sb2.toString();
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public void setBits(BitSet bitSet) {
        for (int i11 = Settings.DEFAULT_INITIAL_WINDOW_SIZE; i11 >= 0; i11--) {
            if (matches((char) i11)) {
                bitSet.set(i11);
            }
        }
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c11) {
        int length = charSequence.length();
        int i11 = length - 1;
        int i12 = 0;
        while (i12 < length && matches(charSequence.charAt(i12))) {
            i12++;
        }
        int i13 = i11;
        while (i13 > i12 && matches(charSequence.charAt(i13))) {
            i13--;
        }
        if (i12 == 0 && i13 == i11) {
            return collapseFrom(charSequence, c11);
        }
        int i14 = i13 + 1;
        return finishCollapseFrom(charSequence, i12, i14, c11, new StringBuilder(i14 - i12), false);
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length && matches(charSequence.charAt(i11))) {
            i11++;
        }
        int i12 = length - 1;
        while (i12 > i11 && matches(charSequence.charAt(i12))) {
            i12--;
        }
        return charSequence.subSequence(i11, i12 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!matches(charSequence.charAt(i11))) {
                return charSequence.subSequence(i11, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }
}
