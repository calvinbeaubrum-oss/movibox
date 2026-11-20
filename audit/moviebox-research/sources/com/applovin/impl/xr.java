package com.applovin.impl;

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
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f24393a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f24394b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f24395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f24396d;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f24397c = new Comparator() { // from class: com.applovin.impl.k90
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return xr.b.a((xr.b) obj, (xr.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f24398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24399b;

        private b(c cVar, int i11) {
            this.f24398a = cVar;
            this.f24399b = i11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            return Integer.compare(bVar.f24398a.f24401b, bVar2.f24398a.f24401b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f24400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f24402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set f24403d;

        private c(String str, int i11, String str2, Set set) {
            this.f24401b = i11;
            this.f24400a = str;
            this.f24402c = str2;
            this.f24403d = set;
        }

        public static c a() {
            return new c("", 0, "", Collections.emptySet());
        }

        public static c a(String str, int i11) {
            String str2;
            String strTrim = str.trim();
            b1.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrA = xp.a(strTrim, "\\.");
            String str3 = strArrA[0];
            HashSet hashSet = new HashSet();
            for (int i12 = 1; i12 < strArrA.length; i12++) {
                hashSet.add(strArrA[i12]);
            }
            return new c(str3, i11, str2, hashSet);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vr f24405b;

        public d(int i11, vr vrVar) {
            this.f24404a = i11;
            this.f24405b = vrVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f24404a, dVar.f24404a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f24408c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24406a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f24407b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24409d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f24410e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f24411f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f24412g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f24413h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f24414i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f24415j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f24416k = Integer.MIN_VALUE;

        private static float a(float f11, int i11) {
            if (f11 != -3.4028235E38f && i11 == 0 && (f11 < 0.0f || f11 > 1.0f)) {
                return 1.0f;
            }
            if (f11 != -3.4028235E38f) {
                return f11;
            }
            return i11 == 0 ? 1.0f : -3.4028235E38f;
        }

        private static float a(int i11, float f11) {
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

        private static Layout.Alignment a(int i11) {
            if (i11 != 1) {
                if (i11 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 != 5) {
                            pc.d("WebvttCueParser", "Unknown textAlignment: " + i11);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float b(int i11) {
            if (i11 != 4) {
                return i11 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int c(int i11) {
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

        public wr a() {
            return new wr(b().a(), this.f24406a, this.f24407b);
        }

        public b5.b b() {
            float fB = this.f24413h;
            if (fB == -3.4028235E38f) {
                fB = b(this.f24409d);
            }
            int iC = this.f24414i;
            if (iC == Integer.MIN_VALUE) {
                iC = c(this.f24409d);
            }
            b5.b bVarC = new b5.b().b(a(this.f24409d)).a(a(this.f24410e, this.f24411f), this.f24411f).a(this.f24412g).b(fB).b(iC).d(Math.min(this.f24415j, a(iC, fB))).c(this.f24416k);
            CharSequence charSequence = this.f24408c;
            if (charSequence != null) {
                bVarC.a(charSequence);
            }
            return bVarC;
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
        f24395c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f24396d = Collections.unmodifiableMap(map2);
    }

    private static int a(int i11, int i12, int i13) {
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

    private static int a(String str, int i11) {
        int iIndexOf = str.indexOf(62, i11);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    public static SpannedString a(String str, String str2, List list) {
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
                    a(str2.substring(i11, iIndexOf), spannableStringBuilder);
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
                int iA = i11 + 1;
                if (iA < str2.length()) {
                    boolean z11 = str2.charAt(iA) == '/';
                    iA = a(str2, iA);
                    int i12 = iA - 2;
                    boolean z12 = str2.charAt(i12) == '/';
                    int i13 = i11 + (z11 ? 2 : 1);
                    if (!z12) {
                        i12 = iA - 1;
                    }
                    String strSubstring = str2.substring(i13, i12);
                    if (!strSubstring.trim().isEmpty()) {
                        String strA = a(strSubstring);
                        if (b(strA)) {
                            if (z11) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    a(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    }
                                    if (cVar.f24400a.equals(strA)) {
                                        break;
                                    }
                                }
                            } else if (!z12) {
                                arrayDeque.push(c.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i11 = iA;
            }
        }
        while (!arrayDeque.isEmpty()) {
            a(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        a(str, c.a(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static b5 a(CharSequence charSequence) {
        e eVar = new e();
        eVar.f24408c = charSequence;
        return eVar.b().a();
    }

    public static wr a(bh bhVar, List list) {
        String strL = bhVar.l();
        if (strL == null) {
            return null;
        }
        Pattern pattern = f24393a;
        Matcher matcher = pattern.matcher(strL);
        if (matcher.matches()) {
            return a((String) null, matcher, bhVar, list);
        }
        String strL2 = bhVar.l();
        if (strL2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strL2);
        if (matcher2.matches()) {
            return a(strL.trim(), matcher2, bhVar, list);
        }
        return null;
    }

    private static wr a(String str, Matcher matcher, bh bhVar, List list) {
        e eVar = new e();
        try {
            eVar.f24406a = zr.b((String) b1.a((Object) matcher.group(1)));
            eVar.f24407b = zr.b((String) b1.a((Object) matcher.group(2)));
            a((String) b1.a((Object) matcher.group(3)), eVar);
            StringBuilder sb2 = new StringBuilder();
            String strL = bhVar.l();
            while (!TextUtils.isEmpty(strL)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(strL.trim());
                strL = bhVar.l();
            }
            eVar.f24408c = a(str, sb2.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            pc.d("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    private static String a(String str) {
        String strTrim = str.trim();
        b1.a(!strTrim.isEmpty());
        return xp.b(strTrim, "[ \\.]")[0];
    }

    private static List a(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            vr vrVar = (vr) list.get(i11);
            int iA = vrVar.a(str, cVar.f24400a, cVar.f24403d, cVar.f24402c);
            if (iA > 0) {
                arrayList.add(new d(iA, vrVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, vr vrVar, int i11, int i12) {
        if (vrVar == null) {
            return;
        }
        if (vrVar.h() != -1) {
            pk.a(spannableStringBuilder, new StyleSpan(vrVar.h()), i11, i12, 33);
        }
        if (vrVar.k()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (vrVar.l()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (vrVar.j()) {
            pk.a(spannableStringBuilder, new ForegroundColorSpan(vrVar.c()), i11, i12, 33);
        }
        if (vrVar.i()) {
            pk.a(spannableStringBuilder, new BackgroundColorSpan(vrVar.a()), i11, i12, 33);
        }
        if (vrVar.d() != null) {
            pk.a(spannableStringBuilder, new TypefaceSpan(vrVar.d()), i11, i12, 33);
        }
        int iF = vrVar.f();
        if (iF == 1) {
            pk.a(spannableStringBuilder, new AbsoluteSizeSpan((int) vrVar.e(), true), i11, i12, 33);
        } else if (iF == 2) {
            pk.a(spannableStringBuilder, new RelativeSizeSpan(vrVar.e()), i11, i12, 33);
        } else if (iF == 3) {
            pk.a(spannableStringBuilder, new RelativeSizeSpan(vrVar.e() / 100.0f), i11, i12, 33);
        }
        if (vrVar.b()) {
            spannableStringBuilder.setSpan(new pa(), i11, i12, 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int iB = b(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f24397c);
        int i11 = cVar.f24401b;
        int length = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            if ("rt".equals(((b) arrayList.get(i12)).f24398a.f24400a)) {
                b bVar = (b) arrayList.get(i12);
                int iA = a(b(list2, str, bVar.f24398a), iB, 1);
                int i13 = bVar.f24398a.f24401b - length;
                int i14 = bVar.f24399b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i13, i14);
                spannableStringBuilder.delete(i13, i14);
                spannableStringBuilder.setSpan(new zi(charSequenceSubSequence.toString(), iA), i11, i13, 33);
                length += charSequenceSubSequence.length();
                i11 = i13;
            }
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i11, int i12) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f24395c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str)).intValue()), i11, i12, 33);
            } else {
                Map map2 = f24396d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str)).intValue()), i11, i12, 33);
                }
            }
        }
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
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
                pc.d("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    private static void a(String str, c cVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i11 = cVar.f24401b;
        int length = spannableStringBuilder.length();
        String str2 = cVar.f24400a;
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
                a(spannableStringBuilder, cVar.f24403d, i11, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case "ruby":
                a(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List listA = a(list2, str, cVar);
        for (int i12 = 0; i12 < listA.size(); i12++) {
            a(spannableStringBuilder, ((d) listA.get(i12)).f24405b, i11, length);
        }
    }

    private static void a(String str, e eVar) {
        Matcher matcher = f24394b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) b1.a((Object) matcher.group(1));
            String str3 = (String) b1.a((Object) matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    b(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f24409d = f(str3);
                } else if (RequestParameters.POSITION.equals(str2)) {
                    c(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f24415j = zr.a(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f24416k = g(str3);
                } else {
                    pc.d("WebvttCueParser", "Unknown cue setting " + str2 + ":" + str3);
                }
            } catch (NumberFormatException unused) {
                pc.d("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    private static int b(List list, String str, c cVar) {
        List listA = a(list, str, cVar);
        for (int i11 = 0; i11 < listA.size(); i11++) {
            vr vrVar = ((d) listA.get(i11)).f24405b;
            if (vrVar.g() != -1) {
                return vrVar.g();
            }
        }
        return -1;
    }

    private static void b(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f24412g = d(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.f24410e = zr.a(str);
            eVar.f24411f = 0;
        } else {
            eVar.f24410e = Integer.parseInt(str);
            eVar.f24411f = 1;
        }
    }

    private static boolean b(String str) {
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

    public static b5.b c(String str) {
        e eVar = new e();
        a(str, eVar);
        return eVar.b();
    }

    private static void c(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f24414i = e(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        eVar.f24413h = zr.a(str);
    }

    private static int d(String str) {
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
                pc.d("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int e(String str) {
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
                pc.d("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int f(String str) {
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
                pc.d("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int g(String str) {
        str.hashCode();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        pc.d("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }
}
