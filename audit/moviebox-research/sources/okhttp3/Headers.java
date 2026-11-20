package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.d;
import kotlin.collections.g;
import kotlin.collections.k;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.a;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String line) {
            Intrinsics.g(line, "line");
            int iC0 = StringsKt__StringsKt.c0(line, ':', 0, false, 6, null);
            if (!(iC0 != -1)) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String strSubstring = line.substring(0, iC0);
            Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (strSubstring == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = StringsKt__StringsKt.Z0(strSubstring).toString();
            String strSubstring2 = line.substring(iC0 + 1);
            Intrinsics.f(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            add(string, strSubstring2);
            return this;
        }

        public final Builder add(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder add(String name, Instant value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }

        public final Builder add(String name, Date value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            add(name, DatesKt.toHttpDateString(value));
            return this;
        }

        public final Builder addAll(Headers headers) {
            Intrinsics.g(headers, "headers");
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                addLenient$okhttp(headers.name(i11), headers.value(i11));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String line) {
            Intrinsics.g(line, "line");
            int iC0 = StringsKt__StringsKt.c0(line, ':', 1, false, 4, null);
            if (iC0 != -1) {
                String strSubstring = line.substring(0, iC0);
                Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iC0 + 1);
                Intrinsics.f(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                Intrinsics.f(strSubstring3, "(this as java.lang.String).substring(startIndex)");
                addLenient$okhttp("", strSubstring3);
            } else {
                addLenient$okhttp("", line);
            }
            return this;
        }

        public final Builder addLenient$okhttp(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            this.namesAndValues.add(name);
            this.namesAndValues.add(StringsKt__StringsKt.Z0(value).toString());
            return this;
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final String get(String name) {
            Intrinsics.g(name, "name");
            IntProgression intProgressionQ = a.q(a.n(this.namesAndValues.size() - 2, 0), 2);
            int iG = intProgressionQ.g();
            int i11 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if (iR >= 0) {
                if (iG > i11) {
                    return null;
                }
            } else if (iG < i11) {
                return null;
            }
            while (!l.v(name, this.namesAndValues.get(iG), true)) {
                if (iG == i11) {
                    return null;
                }
                iG += iR;
            }
            return this.namesAndValues.get(iG + 1);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String name) {
            Intrinsics.g(name, "name");
            int i11 = 0;
            while (i11 < this.namesAndValues.size()) {
                if (l.v(name, this.namesAndValues.get(i11), true)) {
                    this.namesAndValues.remove(i11);
                    this.namesAndValues.remove(i11);
                    i11 -= 2;
                }
                i11 += 2;
            }
            return this;
        }

        public final Builder set(String name, String value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            Companion companion = Headers.Companion;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @IgnoreJRERequirement
        public final Builder set(String name, Instant value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        public final Builder set(String name, Date value) {
            Intrinsics.g(name, "name");
            Intrinsics.g(value, "value");
            set(name, DatesKt.toHttpDateString(value));
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i11), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String str, String str2) {
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i11), str2));
                    sb2.append(Util.isSensitiveHeader(str2) ? "" : ": " + str);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] strArr, String str) {
            IntProgression intProgressionQ = a.q(a.n(strArr.length - 2, 0), 2);
            int iG = intProgressionQ.g();
            int i11 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if (iR >= 0) {
                if (iG > i11) {
                    return null;
                }
            } else if (iG < i11) {
                return null;
            }
            while (!l.v(str, strArr[iG], true)) {
                if (iG == i11) {
                    return null;
                }
                iG += iR;
            }
            return strArr[iG + 1];
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m225deprecated_of(Map<String, String> headers) {
            Intrinsics.g(headers, "headers");
            return of(headers);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m226deprecated_of(String... namesAndValues) {
            Intrinsics.g(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName
        public final Headers of(Map<String, String> toHeaders) {
            Intrinsics.g(toHeaders, "$this$toHeaders");
            String[] strArr = new String[toHeaders.size() * 2];
            int i11 = 0;
            for (Map.Entry<String, String> entry : toHeaders.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = StringsKt__StringsKt.Z0(key).toString();
                if (value == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string2 = StringsKt__StringsKt.Z0(value).toString();
                checkName(string);
                checkValue(string2, string);
                strArr[i11] = string;
                strArr[i11 + 1] = string2;
                i11 += 2;
            }
            return new Headers(strArr, null);
        }

        @JvmStatic
        @JvmName
        public final Headers of(String... namesAndValues) throws CloneNotSupportedException {
            Intrinsics.g(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            Object objClone = namesAndValues.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            String[] strArr = (String[]) objClone;
            int length = strArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                String str = strArr[i11];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                strArr[i11] = StringsKt__StringsKt.Z0(str).toString();
            }
            IntProgression intProgressionQ = a.q(d.R(strArr), 2);
            int iG = intProgressionQ.g();
            int i12 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if (iR < 0 ? iG >= i12 : iG <= i12) {
                while (true) {
                    String str2 = strArr[iG];
                    String str3 = strArr[iG + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (iG == i12) {
                        break;
                    }
                    iG += iR;
                }
            }
            return new Headers(strArr, null);
        }
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    @JvmStatic
    @JvmName
    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }

    @JvmStatic
    @JvmName
    public static final Headers of(String... strArr) {
        return Companion.of(strArr);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m224deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        int length2 = strArr.length;
        for (int i11 = 0; i11 < length2; i11++) {
            length += (long) this.namesAndValues[i11].length();
        }
        return length;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
    }

    public final String get(String name) {
        Intrinsics.g(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        Intrinsics.g(name, "name");
        String str = get(name);
        if (str != null) {
            return DatesKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    public final Instant getInstant(String name) {
        Intrinsics.g(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i11 = 0; i11 < size; i11++) {
            pairArr[i11] = TuplesKt.a(name(i11), value(i11));
        }
        return ArrayIteratorKt.a(pairArr);
    }

    public final String name(int i11) {
        return this.namesAndValues[i11 * 2];
    }

    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(l.x(StringCompanionObject.f68912a));
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            treeSet.add(name(i11));
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.f(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        k.B(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    @JvmName
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(l.x(StringCompanionObject.f68912a));
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = name(i11);
            Locale locale = Locale.US;
            Intrinsics.f(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(value(i11));
        }
        return treeMap;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = name(i11);
            String strValue = value(i11);
            sb2.append(strName);
            sb2.append(": ");
            if (Util.isSensitiveHeader(strName)) {
                strValue = "██";
            }
            sb2.append(strValue);
            sb2.append("\n");
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String value(int i11) {
        return this.namesAndValues[(i11 * 2) + 1];
    }

    public final List<String> values(String name) {
        Intrinsics.g(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            if (l.v(name, name(i11), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i11));
            }
        }
        if (arrayList == null) {
            return g.l();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.f(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }
}
