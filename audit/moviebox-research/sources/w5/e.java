package w5;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f79313a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f79314b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f79315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f79316d;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<b> f79317c = new Comparator() { // from class: w5.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return e.b.e((e.b) obj, (e.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f79318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f79319b;

        public b(c cVar, int i11) {
            this.f79318a = cVar;
            this.f79319b = i11;
        }

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f79318a.f79321b, bVar2.f79318a.f79321b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f79320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f79321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f79322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f79323d;

        public c(String str, int i11, String str2, Set<String> set) {
            this.f79321b = i11;
            this.f79320a = str;
            this.f79322c = str2;
            this.f79323d = set;
        }

        public static c a(String str, int i11) {
            String str2;
            String strTrim = str.trim();
            z3.a.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrO1 = u0.o1(strTrim, "\\.");
            String str3 = strArrO1[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < strArrO1.length; i12++) {
                hashSet.add(strArrO1[i12]);
            }
            return new c(str3, i11, str2, hashSet);
        }

        public static c b() {
            return new c("", 0, "", Collections.emptySet());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f79324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w5.c f79325b;

        public d(int i11, w5.c cVar) {
            this.f79324a = i11;
            this.f79325b = cVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f79324a, dVar.f79324a);
        }
    }

    /* JADX INFO: renamed from: w5.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0883e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f79328c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f79326a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f79327b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79329d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f79330e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f79331f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79332g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f79333h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f79334i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f79335j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f79336k = Integer.MIN_VALUE;

        public static float b(float f11, int i11) {
            if (f11 != -3.4028235E38f && i11 == 0 && (f11 < 0.0f || f11 > 1.0f)) {
                return 1.0f;
            }
            if (f11 != -3.4028235E38f) {
                return f11;
            }
            return i11 == 0 ? 1.0f : -3.4028235E38f;
        }

        @Nullable
        public static Layout.Alignment c(int i11) {
            if (i11 != 1) {
                if (i11 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            o.h("WebvttCueParser", "Unknown textAlignment: " + i11);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public static float d(int i11, float f11) {
            if (i11 == 0) {
                return 1.0f - f11;
            }
            if (i11 == 1) {
                return f11 <= 0.5f ? f11 * 2.0f : (1.0f - f11) * 2.0f;
            }
            if (i11 == 2) {
                return f11;
            }
            throw new IllegalStateException(String.valueOf(i11));
        }

        public static float e(int i11) {
            if (i11 != 4) {
                return i11 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        public static int f(int i11) {
            if (i11 == 1) {
                return 0;
            }
            if (i11 == 3) {
                return 2;
            }
            if (i11 != 4) {
                return i11 != 5 ? 1 : 2;
            }
            return 0;
        }

        public w5.d a() {
            return new w5.d(g().a(), this.f79326a, this.f79327b);
        }

        public y3.a.b g() {
            float fE = this.f79333h;
            if (fE == -3.4028235E38f) {
                fE = e(this.f79329d);
            }
            int iF = this.f79334i;
            if (iF == Integer.MIN_VALUE) {
                iF = f(this.f79329d);
            }
            y3.a.b bVarR = new y3.a.b().p(c(this.f79329d)).h(b(this.f79330e, this.f79331f), this.f79331f).i(this.f79332g).k(fE).l(iF).n(Math.min(this.f79335j, d(iF, fE))).r(this.f79336k);
            CharSequence charSequence = this.f79328c;
            if (charSequence != null) {
                bVarR.o(charSequence);
            }
            return bVarR;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f79315c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f79316d = Collections.unmodifiableMap(map2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i11, int i12) {
        for (String str : set) {
            Map<String, Integer> map = f79315c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i11, i12, 33);
            } else {
                Map<String, Integer> map2 = f79316d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(map2.get(str).intValue()), i11, i12, 33);
                }
            }
        }
    }

    public static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.hashCode();
        switch (str) {
            case "gt":
                spannableStringBuilder.append('>');
                break;
            case "lt":
                spannableStringBuilder.append('<');
                break;
            case "amp":
                spannableStringBuilder.append('&');
                break;
            case "nbsp":
                spannableStringBuilder.append(' ');
                break;
            default:
                o.h("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, @Nullable String str, c cVar, List<b> list, List<w5.c> list2) {
        int i11 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f79317c);
        int i12 = cVar.f79321b;
        int length = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if ("rt".equals(((b) arrayList.get(i13)).f79318a.f79320a)) {
                b bVar = (b) arrayList.get(i13);
                int iG = g(i(list2, str, bVar.f79318a), i11, 1);
                int i14 = bVar.f79318a.f79321b - length;
                int i15 = bVar.f79319b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i14, i15);
                spannableStringBuilder.delete(i14, i15);
                spannableStringBuilder.setSpan(new y3.f(charSequenceSubSequence.toString(), iG), i12, i14, 33);
                length += charSequenceSubSequence.length();
                i12 = i14;
            }
        }
    }

    public static void d(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<w5.c> list2) {
        int i11 = cVar.f79321b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f79320a;
        str2.hashCode();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, cVar.f79323d, i11, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case "ruby":
                c(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List<d> listH = h(list2, str, cVar);
        for (int i12 = 0; i12 < listH.size(); i12++) {
            e(spannableStringBuilder, listH.get(i12).f79325b, i11, length);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, w5.c cVar, int i11, int i12) {
        if (cVar == null) {
            return;
        }
        if (cVar.i() != -1) {
            y3.g.a(spannableStringBuilder, new StyleSpan(cVar.i()), i11, i12, 33);
        }
        if (cVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (cVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (cVar.k()) {
            y3.g.a(spannableStringBuilder, new ForegroundColorSpan(cVar.c()), i11, i12, 33);
        }
        if (cVar.j()) {
            y3.g.a(spannableStringBuilder, new BackgroundColorSpan(cVar.a()), i11, i12, 33);
        }
        if (cVar.d() != null) {
            y3.g.a(spannableStringBuilder, new TypefaceSpan(cVar.d()), i11, i12, 33);
        }
        int iF = cVar.f();
        if (iF == 1) {
            y3.g.a(spannableStringBuilder, new AbsoluteSizeSpan((int) cVar.e(), true), i11, i12, 33);
        } else if (iF == 2) {
            y3.g.a(spannableStringBuilder, new RelativeSizeSpan(cVar.e()), i11, i12, 33);
        } else if (iF == 3) {
            y3.g.a(spannableStringBuilder, new RelativeSizeSpan(cVar.e() / 100.0f), i11, i12, 33);
        }
        if (cVar.b()) {
            spannableStringBuilder.setSpan(new y3.d(), i11, i12, 33);
        }
    }

    public static int f(String str, int i11) {
        int iIndexOf = str.indexOf(62, i11);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    public static int g(int i11, int i12, int i13) {
        if (i11 != -1) {
            return i11;
        }
        if (i12 != -1) {
            return i12;
        }
        if (i13 != -1) {
            return i13;
        }
        throw new IllegalArgumentException();
    }

    public static List<d> h(List<w5.c> list, @Nullable String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            w5.c cVar2 = list.get(i11);
            int iH = cVar2.h(str, cVar.f79320a, cVar.f79323d, cVar.f79322c);
            if (iH > 0) {
                arrayList.add(new d(iH, cVar2));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List<w5.c> list, @Nullable String str, c cVar) {
        List<d> listH = h(list, str, cVar);
        for (int i11 = 0; i11 < listH.size(); i11++) {
            w5.c cVar2 = listH.get(i11).f79325b;
            if (cVar2.g() != -1) {
                return cVar2.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String strTrim = str.trim();
        z3.a.a(!strTrim.isEmpty());
        return u0.p1(strTrim, "[ \\.]")[0];
    }

    public static boolean k(String str) {
        str.hashCode();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static y3.a l(CharSequence charSequence) {
        C0883e c0883e = new C0883e();
        c0883e.f79328c = charSequence;
        return c0883e.g().a();
    }

    @Nullable
    public static w5.d m(@Nullable String str, Matcher matcher, c0 c0Var, List<w5.c> list) {
        C0883e c0883e = new C0883e();
        try {
            c0883e.f79326a = h.d((String) z3.a.e(matcher.group(1)));
            c0883e.f79327b = h.d((String) z3.a.e(matcher.group(2)));
            p((String) z3.a.e(matcher.group(3)), c0883e);
            StringBuilder sb2 = new StringBuilder();
            String strS = c0Var.s();
            while (!TextUtils.isEmpty(strS)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(strS.trim());
                strS = c0Var.s();
            }
            c0883e.f79328c = q(str, sb2.toString(), list);
            return c0883e.a();
        } catch (NumberFormatException unused) {
            o.h("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    @Nullable
    public static w5.d n(c0 c0Var, List<w5.c> list) {
        String strS = c0Var.s();
        if (strS == null) {
            return null;
        }
        Pattern pattern = f79313a;
        Matcher matcher = pattern.matcher(strS);
        if (matcher.matches()) {
            return m(null, matcher, c0Var, list);
        }
        String strS2 = c0Var.s();
        if (strS2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strS2);
        if (matcher2.matches()) {
            return m(strS.trim(), matcher2, c0Var, list);
        }
        return null;
    }

    public static y3.a.b o(String str) {
        C0883e c0883e = new C0883e();
        p(str, c0883e);
        return c0883e.g();
    }

    public static void p(String str, C0883e c0883e) {
        Matcher matcher = f79314b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) z3.a.e(matcher.group(1));
            String str3 = (String) z3.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, c0883e);
                } else if ("align".equals(str2)) {
                    c0883e.f79329d = v(str3);
                } else if (RequestParameters.POSITION.equals(str2)) {
                    u(str3, c0883e);
                } else if ("size".equals(str2)) {
                    c0883e.f79335j = h.c(str3);
                } else if ("vertical".equals(str2)) {
                    c0883e.f79336k = w(str3);
                } else {
                    o.h("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                o.h("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString q(@Nullable String str, String str2, List<w5.c> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < str2.length()) {
            char cCharAt = str2.charAt(i11);
            if (cCharAt == '&') {
                i11++;
                int iIndexOf = str2.indexOf(59, i11);
                int iIndexOf2 = str2.indexOf(32, i11);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    b(str2.substring(i11, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i11 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i11++;
            } else {
                int iF = i11 + 1;
                if (iF < str2.length()) {
                    boolean z11 = str2.charAt(iF) == '/';
                    iF = f(str2, iF);
                    int i12 = iF - 2;
                    boolean z12 = str2.charAt(i12) == '/';
                    int i13 = i11 + (z11 ? 2 : 1);
                    if (!z12) {
                        i12 = iF - 1;
                    }
                    String strSubstring = str2.substring(i13, i12);
                    if (!strSubstring.trim().isEmpty()) {
                        String strJ = j(strSubstring);
                        if (k(strJ)) {
                            if (z11) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    d(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f79320a.equals(strJ)) {
                                        break;
                                    }
                                }
                            } else if (!z12) {
                                arrayDeque.push(c.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i11 = iF;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, c.b(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static int r(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                o.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, C0883e c0883e) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            c0883e.f79332g = r(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            c0883e.f79330e = h.c(str);
            c0883e.f79331f = 0;
        } else {
            c0883e.f79330e = Integer.parseInt(str);
            c0883e.f79331f = 1;
        }
    }

    public static int t(String str) {
        str.hashCode();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                o.h("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, C0883e c0883e) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            c0883e.f79334i = t(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        c0883e.f79333h = h.c(str);
    }

    public static int v(String str) {
        str.hashCode();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                o.h("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    public static int w(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        o.h("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
