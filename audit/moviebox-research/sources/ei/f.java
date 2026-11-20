package ei;

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
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f64239a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f64240b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f64241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f64242d;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<b> f64243c = new Comparator() { // from class: ei.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f.b.e((f.b) obj, (f.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f64244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64245b;

        public b(c cVar, int i11) {
            this.f64244a = cVar;
            this.f64245b = i11;
        }

        public static /* synthetic */ int e(b bVar, b bVar2) {
            return Integer.compare(bVar.f64244a.f64247b, bVar2.f64244a.f64247b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f64246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f64248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f64249d;

        public c(String str, int i11, String str2, Set<String> set) {
            this.f64247b = i11;
            this.f64246a = str;
            this.f64248c = str2;
            this.f64249d = set;
        }

        public static c a(String str, int i11) {
            String str2;
            String strTrim = str.trim();
            com.google.android.exoplayer2.util.a.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrT0 = o0.T0(strTrim, "\\.");
            String str3 = strArrT0[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < strArrT0.length; i12++) {
                hashSet.add(strArrT0[i12]);
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
        public final int f64250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ei.d f64251b;

        public d(int i11, ei.d dVar) {
            this.f64250a = i11;
            this.f64251b = dVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f64250a, dVar.f64250a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f64254c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f64252a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f64253b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f64255d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f64256e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f64257f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f64258g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f64259h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f64260i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f64261j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f64262k = Integer.MIN_VALUE;

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
                            s.i("WebvttCueParser", "Unknown textAlignment: " + i11);
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

        public ei.e a() {
            return new ei.e(g().a(), this.f64252a, this.f64253b);
        }

        public vh.b.C0875b g() {
            float fE = this.f64259h;
            if (fE == -3.4028235E38f) {
                fE = e(this.f64255d);
            }
            int iF = this.f64260i;
            if (iF == Integer.MIN_VALUE) {
                iF = f(this.f64255d);
            }
            vh.b.C0875b c0875bR = new vh.b.C0875b().p(c(this.f64255d)).h(b(this.f64256e, this.f64257f), this.f64257f).i(this.f64258g).k(fE).l(iF).n(Math.min(this.f64261j, d(iF, fE))).r(this.f64262k);
            CharSequence charSequence = this.f64254c;
            if (charSequence != null) {
                c0875bR.o(charSequence);
            }
            return c0875bR;
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
        f64241c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f64242d = Collections.unmodifiableMap(map2);
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i11, int i12) {
        for (String str : set) {
            Map<String, Integer> map = f64241c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(map.get(str).intValue()), i11, i12, 33);
            } else {
                Map<String, Integer> map2 = f64242d;
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
                s.i("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    public static void c(SpannableStringBuilder spannableStringBuilder, @Nullable String str, c cVar, List<b> list, List<ei.d> list2) {
        int i11 = i(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f64243c);
        int i12 = cVar.f64247b;
        int length = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if ("rt".equals(((b) arrayList.get(i13)).f64244a.f64246a)) {
                b bVar = (b) arrayList.get(i13);
                int iG = g(i(list2, str, bVar.f64244a), i11, 1);
                int i14 = bVar.f64244a.f64247b - length;
                int i15 = bVar.f64245b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i14, i15);
                spannableStringBuilder.delete(i14, i15);
                spannableStringBuilder.setSpan(new zh.c(charSequenceSubSequence.toString(), iG), i12, i14, 33);
                length += charSequenceSubSequence.length();
                i12 = i14;
            }
        }
    }

    public static void d(@Nullable String str, c cVar, List<b> list, SpannableStringBuilder spannableStringBuilder, List<ei.d> list2) {
        int i11 = cVar.f64247b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f64246a;
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
                a(spannableStringBuilder, cVar.f64249d, i11, length);
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
            e(spannableStringBuilder, listH.get(i12).f64251b, i11, length);
        }
    }

    public static void e(SpannableStringBuilder spannableStringBuilder, ei.d dVar, int i11, int i12) {
        if (dVar == null) {
            return;
        }
        if (dVar.i() != -1) {
            zh.d.a(spannableStringBuilder, new StyleSpan(dVar.i()), i11, i12, 33);
        }
        if (dVar.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (dVar.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (dVar.k()) {
            zh.d.a(spannableStringBuilder, new ForegroundColorSpan(dVar.c()), i11, i12, 33);
        }
        if (dVar.j()) {
            zh.d.a(spannableStringBuilder, new BackgroundColorSpan(dVar.a()), i11, i12, 33);
        }
        if (dVar.d() != null) {
            zh.d.a(spannableStringBuilder, new TypefaceSpan(dVar.d()), i11, i12, 33);
        }
        int iF = dVar.f();
        if (iF == 1) {
            zh.d.a(spannableStringBuilder, new AbsoluteSizeSpan((int) dVar.e(), true), i11, i12, 33);
        } else if (iF == 2) {
            zh.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e()), i11, i12, 33);
        } else if (iF == 3) {
            zh.d.a(spannableStringBuilder, new RelativeSizeSpan(dVar.e() / 100.0f), i11, i12, 33);
        }
        if (dVar.b()) {
            spannableStringBuilder.setSpan(new zh.a(), i11, i12, 33);
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

    public static List<d> h(List<ei.d> list, @Nullable String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            ei.d dVar = list.get(i11);
            int iH = dVar.h(str, cVar.f64246a, cVar.f64249d, cVar.f64248c);
            if (iH > 0) {
                arrayList.add(new d(iH, dVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int i(List<ei.d> list, @Nullable String str, c cVar) {
        List<d> listH = h(list, str, cVar);
        for (int i11 = 0; i11 < listH.size(); i11++) {
            ei.d dVar = listH.get(i11).f64251b;
            if (dVar.g() != -1) {
                return dVar.g();
            }
        }
        return -1;
    }

    public static String j(String str) {
        String strTrim = str.trim();
        com.google.android.exoplayer2.util.a.a(!strTrim.isEmpty());
        return o0.U0(strTrim, "[ \\.]")[0];
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

    public static vh.b l(CharSequence charSequence) {
        e eVar = new e();
        eVar.f64254c = charSequence;
        return eVar.g().a();
    }

    @Nullable
    public static ei.e m(c0 c0Var, List<ei.d> list) {
        String strP = c0Var.p();
        if (strP == null) {
            return null;
        }
        Pattern pattern = f64239a;
        Matcher matcher = pattern.matcher(strP);
        if (matcher.matches()) {
            return n(null, matcher, c0Var, list);
        }
        String strP2 = c0Var.p();
        if (strP2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strP2);
        if (matcher2.matches()) {
            return n(strP.trim(), matcher2, c0Var, list);
        }
        return null;
    }

    @Nullable
    public static ei.e n(@Nullable String str, Matcher matcher, c0 c0Var, List<ei.d> list) {
        e eVar = new e();
        try {
            eVar.f64252a = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            eVar.f64253b = i.d((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            p((String) com.google.android.exoplayer2.util.a.e(matcher.group(3)), eVar);
            StringBuilder sb2 = new StringBuilder();
            String strP = c0Var.p();
            while (!TextUtils.isEmpty(strP)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(strP.trim());
                strP = c0Var.p();
            }
            eVar.f64254c = q(str, sb2.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            s.i("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    public static vh.b.C0875b o(String str) {
        e eVar = new e();
        p(str, eVar);
        return eVar.g();
    }

    public static void p(String str, e eVar) {
        Matcher matcher = f64240b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(1));
            String str3 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    s(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f64255d = v(str3);
                } else if (RequestParameters.POSITION.equals(str2)) {
                    u(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f64261j = i.c(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f64262k = w(str3);
                } else {
                    s.i("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                s.i("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString q(@Nullable String str, String str2, List<ei.d> list) {
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
                                    if (cVar.f64246a.equals(strJ)) {
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
                s.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void s(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f64258g = r(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.f64256e = i.c(str);
            eVar.f64257f = 0;
        } else {
            eVar.f64256e = Integer.parseInt(str);
            eVar.f64257f = 1;
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
                s.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    public static void u(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f64260i = t(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        eVar.f64259h = i.c(str);
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
                s.i("WebvttCueParser", "Invalid alignment value: " + str);
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
        s.i("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
