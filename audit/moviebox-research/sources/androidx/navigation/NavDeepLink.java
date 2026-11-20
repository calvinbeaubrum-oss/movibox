package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NavDeepLink {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f12184l = new b(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final Pattern f12185m = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12188c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f12191f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12194i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12196k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f12189d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, d> f12190e = new LinkedHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f12192g = LazyKt__LazyJVMKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pattern$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str = this.this$0.f12191f;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str, 2);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f12195j = LazyKt__LazyJVMKt.b(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str = this.this$0.f12194i;
            if (str == null) {
                return null;
            }
            return Pattern.compile(str);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0110a f12197d = new C0110a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12200c;

        /* JADX INFO: renamed from: androidx.navigation.NavDeepLink$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0110a {
            public C0110a() {
            }

            public /* synthetic */ C0110a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f12198a, this.f12199b, this.f12200c);
        }

        public final a b(String action) {
            Intrinsics.g(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            }
            this.f12199b = action;
            return this;
        }

        public final a c(String mimeType) {
            Intrinsics.g(mimeType, "mimeType");
            this.f12200c = mimeType;
            return this;
        }

        public final a d(String uriPattern) {
            Intrinsics.g(uriPattern, "uriPattern");
            this.f12198a = uriPattern;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12202b;

        public c(String mimeType) {
            List listL;
            Intrinsics.g(mimeType, "mimeType");
            List<String> listSplit = new Regex("/").split(mimeType, 0);
            if (listSplit.isEmpty()) {
                listL = kotlin.collections.g.l();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    }
                }
                listL = kotlin.collections.g.l();
            }
            this.f12201a = (String) listL.get(0);
            this.f12202b = (String) listL.get(1);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c other) {
            Intrinsics.g(other, "other");
            int i11 = Intrinsics.b(this.f12201a, other.f12201a) ? 2 : 0;
            return Intrinsics.b(this.f12202b, other.f12202b) ? i11 + 1 : i11;
        }

        public final String b() {
            return this.f12202b;
        }

        public final String c() {
            return this.f12201a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f12204b = new ArrayList();

        public final void a(String name) {
            Intrinsics.g(name, "name");
            this.f12204b.add(name);
        }

        public final String b(int i11) {
            return this.f12204b.get(i11);
        }

        public final List<String> c() {
            return this.f12204b;
        }

        public final String d() {
            return this.f12203a;
        }

        public final void e(String str) {
            this.f12203a = str;
        }

        public final int f() {
            return this.f12204b.size();
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.f12186a = str;
        this.f12187b = str2;
        this.f12188c = str3;
        if (str != null) {
            Uri uri = Uri.parse(str);
            this.f12193h = uri.getQuery() != null;
            StringBuilder sb2 = new StringBuilder("^");
            if (!f12185m.matcher(str).find()) {
                sb2.append("http[s]?://");
            }
            Pattern fillInPattern = Pattern.compile("\\{(.+?)\\}");
            if (this.f12193h) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    String strSubstring = str.substring(0, matcher.start());
                    Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.f(fillInPattern, "fillInPattern");
                    this.f12196k = c(strSubstring, sb2, fillInPattern);
                }
                for (String paramName : uri.getQueryParameterNames()) {
                    StringBuilder sb3 = new StringBuilder();
                    String queryParameter = uri.getQueryParameter(paramName);
                    if (queryParameter == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    Matcher matcher2 = fillInPattern.matcher(queryParameter);
                    d dVar = new d();
                    int iEnd = 0;
                    while (matcher2.find()) {
                        String strGroup = matcher2.group(1);
                        if (strGroup == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        dVar.a(strGroup);
                        String strSubstring2 = queryParameter.substring(iEnd, matcher2.start());
                        Intrinsics.f(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb3.append(Pattern.quote(strSubstring2));
                        sb3.append("(.+?)?");
                        iEnd = matcher2.end();
                    }
                    if (iEnd < queryParameter.length()) {
                        String strSubstring3 = queryParameter.substring(iEnd);
                        Intrinsics.f(strSubstring3, "this as java.lang.String).substring(startIndex)");
                        sb3.append(Pattern.quote(strSubstring3));
                    }
                    String string = sb3.toString();
                    Intrinsics.f(string, "argRegex.toString()");
                    dVar.e(kotlin.text.l.F(string, ".*", "\\E.*\\Q", false, 4, null));
                    Map<String, d> map = this.f12190e;
                    Intrinsics.f(paramName, "paramName");
                    map.put(paramName, dVar);
                }
            } else {
                Intrinsics.f(fillInPattern, "fillInPattern");
                this.f12196k = c(str, sb2, fillInPattern);
            }
            String string2 = sb2.toString();
            Intrinsics.f(string2, "uriRegex.toString()");
            this.f12191f = kotlin.text.l.F(string2, ".*", "\\E.*\\Q", false, 4, null);
        }
        if (this.f12188c != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.f12188c).matches()) {
                throw new IllegalArgumentException(("The given mimeType " + ((Object) g()) + " does not match to required \"type/subtype\" format").toString());
            }
            c cVar = new c(this.f12188c);
            this.f12194i = kotlin.text.l.F("^(" + cVar.c() + "|[*]+)/(" + cVar.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
        }
    }

    public final boolean c(String str, StringBuilder sb2, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z11 = !StringsKt__StringsKt.Q(str, ".*", false, 2, null);
        int iEnd = 0;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.f12189d.add(strGroup);
            String strSubstring = str.substring(iEnd, matcher.start());
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb2.append(Pattern.quote(strSubstring));
            sb2.append("([^/]+?)");
            iEnd = matcher.end();
            z11 = false;
        }
        if (iEnd < str.length()) {
            String strSubstring2 = str.substring(iEnd);
            Intrinsics.f(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(Pattern.quote(strSubstring2));
        }
        sb2.append("($|(\\?(.)*)|(\\#(.)*))");
        return z11;
    }

    public final String d() {
        return this.f12187b;
    }

    public final List<String> e() {
        List<String> list = this.f12189d;
        Collection<d> collectionValues = this.f12190e.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            kotlin.collections.k.A(arrayList, ((d) it.next()).c());
        }
        return CollectionsKt___CollectionsKt.x0(list, arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        return Intrinsics.b(this.f12186a, navDeepLink.f12186a) && Intrinsics.b(this.f12187b, navDeepLink.f12187b) && Intrinsics.b(this.f12188c, navDeepLink.f12188c);
    }

    public final Bundle f(Uri deepLink, Map<String, androidx.navigation.d> arguments) {
        Matcher matcher;
        String strGroup;
        Intrinsics.g(deepLink, "deepLink");
        Intrinsics.g(arguments, "arguments");
        Pattern patternJ = j();
        Matcher matcher2 = patternJ == null ? null : patternJ.matcher(deepLink.toString());
        if (matcher2 == null || !matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f12189d.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            String str = this.f12189d.get(i11);
            String value = Uri.decode(matcher2.group(i12));
            androidx.navigation.d dVar = arguments.get(str);
            try {
                Intrinsics.f(value, "value");
                if (m(bundle, str, value, dVar)) {
                    return null;
                }
                i11 = i12;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (this.f12193h) {
            for (String str2 : this.f12190e.keySet()) {
                d dVar2 = this.f12190e.get(str2);
                String queryParameter = deepLink.getQueryParameter(str2);
                if (queryParameter != null) {
                    Intrinsics.d(dVar2);
                    matcher = Pattern.compile(dVar2.d(), 32).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                Bundle bundle2 = new Bundle();
                try {
                    Intrinsics.d(dVar2);
                    int iF = dVar2.f();
                    int i13 = 0;
                    while (i13 < iF) {
                        int i14 = i13 + 1;
                        if (matcher != null) {
                            strGroup = matcher.group(i14);
                            if (strGroup == null) {
                                strGroup = "";
                            }
                        } else {
                            strGroup = null;
                        }
                        String strB = dVar2.b(i13);
                        androidx.navigation.d dVar3 = arguments.get(strB);
                        if (strGroup != null) {
                            if (!Intrinsics.b(strGroup, '{' + strB + '}') && m(bundle2, strB, strGroup, dVar3)) {
                                return null;
                            }
                        }
                        i13 = i14;
                    }
                    bundle.putAll(bundle2);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        for (Map.Entry<String, androidx.navigation.d> entry : arguments.entrySet()) {
            String key = entry.getKey();
            androidx.navigation.d value2 = entry.getValue();
            if (value2 != null && !value2.c() && !value2.b() && !bundle.containsKey(key)) {
                return null;
            }
        }
        return bundle;
    }

    public final String g() {
        return this.f12188c;
    }

    public final int h(String mimeType) {
        Intrinsics.g(mimeType, "mimeType");
        if (this.f12188c != null) {
            Pattern patternI = i();
            Intrinsics.d(patternI);
            if (patternI.matcher(mimeType).matches()) {
                return new c(this.f12188c).compareTo(new c(mimeType));
            }
        }
        return -1;
    }

    public int hashCode() {
        String str = this.f12186a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f12187b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f12188c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final Pattern i() {
        return (Pattern) this.f12195j.getValue();
    }

    public final Pattern j() {
        return (Pattern) this.f12192g.getValue();
    }

    public final String k() {
        return this.f12186a;
    }

    public final boolean l() {
        return this.f12196k;
    }

    public final boolean m(Bundle bundle, String str, String str2, androidx.navigation.d dVar) {
        if (dVar != null) {
            dVar.a().d(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }
}
