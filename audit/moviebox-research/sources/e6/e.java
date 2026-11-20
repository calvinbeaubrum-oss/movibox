package e6;

import android.annotation.SuppressLint;
import androidx.room.Index$Order;
import com.google.android.gms.ads.AdError;
import g6.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f64032e = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final String f64033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final Map<String, a> f64034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final Set<c> f64035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final Set<C0658e> f64036d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0657a f64037h = new C0657a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final String f64038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final String f64039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final boolean f64040c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public final int f64041d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @JvmField
        public final String f64042e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @JvmField
        public final int f64043f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public final int f64044g;

        /* JADX INFO: renamed from: e6.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0657a {
            public C0657a() {
            }

            public /* synthetic */ C0657a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final boolean a(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (i11 < str.length()) {
                    char cCharAt = str.charAt(i11);
                    int i14 = i13 + 1;
                    if (i13 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i12++;
                    } else if (cCharAt == ')' && (i12 = i12 - 1) == 0 && i13 != str.length() - 1) {
                        return false;
                    }
                    i11++;
                    i13 = i14;
                }
                return i12 == 0;
            }

            @JvmStatic
            @SuppressLint({"SyntheticAccessor"})
            public final boolean b(String current, String str) {
                Intrinsics.g(current, "current");
                if (Intrinsics.b(current, str)) {
                    return true;
                }
                if (!a(current)) {
                    return false;
                }
                String strSubstring = current.substring(1, current.length() - 1);
                Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return Intrinsics.b(StringsKt__StringsKt.Z0(strSubstring).toString(), str);
            }
        }

        public a(String name, String type, boolean z11, int i11, String str, int i12) {
            Intrinsics.g(name, "name");
            Intrinsics.g(type, "type");
            this.f64038a = name;
            this.f64039b = type;
            this.f64040c = z11;
            this.f64041d = i11;
            this.f64042e = str;
            this.f64043f = i12;
            this.f64044g = a(type);
        }

        public final int a(String str) {
            if (str == null) {
                return 5;
            }
            Locale US = Locale.US;
            Intrinsics.f(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.f(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt__StringsKt.Q(upperCase, "INT", false, 2, null)) {
                return 3;
            }
            if (StringsKt__StringsKt.Q(upperCase, "CHAR", false, 2, null) || StringsKt__StringsKt.Q(upperCase, "CLOB", false, 2, null) || StringsKt__StringsKt.Q(upperCase, "TEXT", false, 2, null)) {
                return 2;
            }
            if (StringsKt__StringsKt.Q(upperCase, "BLOB", false, 2, null)) {
                return 5;
            }
            return (StringsKt__StringsKt.Q(upperCase, "REAL", false, 2, null) || StringsKt__StringsKt.Q(upperCase, "FLOA", false, 2, null) || StringsKt__StringsKt.Q(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a) || this.f64041d != ((a) obj).f64041d) {
                return false;
            }
            a aVar = (a) obj;
            if (!Intrinsics.b(this.f64038a, aVar.f64038a) || this.f64040c != aVar.f64040c) {
                return false;
            }
            if (this.f64043f == 1 && aVar.f64043f == 2 && (str3 = this.f64042e) != null && !f64037h.b(str3, aVar.f64042e)) {
                return false;
            }
            if (this.f64043f == 2 && aVar.f64043f == 1 && (str2 = aVar.f64042e) != null && !f64037h.b(str2, this.f64042e)) {
                return false;
            }
            int i11 = this.f64043f;
            return (i11 == 0 || i11 != aVar.f64043f || ((str = this.f64042e) == null ? aVar.f64042e == null : f64037h.b(str, aVar.f64042e))) && this.f64044g == aVar.f64044g;
        }

        public int hashCode() {
            return (((((this.f64038a.hashCode() * 31) + this.f64044g) * 31) + (this.f64040c ? 1231 : 1237)) * 31) + this.f64041d;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Column{name='");
            sb2.append(this.f64038a);
            sb2.append("', type='");
            sb2.append(this.f64039b);
            sb2.append("', affinity='");
            sb2.append(this.f64044g);
            sb2.append("', notNull=");
            sb2.append(this.f64040c);
            sb2.append(", primaryKeyPosition=");
            sb2.append(this.f64041d);
            sb2.append(", defaultValue='");
            String str = this.f64042e;
            if (str == null) {
                str = AdError.UNDEFINED_DOMAIN;
            }
            sb2.append(str);
            sb2.append("'}");
            return sb2.toString();
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

        @JvmStatic
        public final e a(g database, String tableName) {
            Intrinsics.g(database, "database");
            Intrinsics.g(tableName, "tableName");
            return f.f(database, tableName);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final String f64045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final String f64046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final String f64047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public final List<String> f64048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @JvmField
        public final List<String> f64049e;

        public c(String referenceTable, String onDelete, String onUpdate, List<String> columnNames, List<String> referenceColumnNames) {
            Intrinsics.g(referenceTable, "referenceTable");
            Intrinsics.g(onDelete, "onDelete");
            Intrinsics.g(onUpdate, "onUpdate");
            Intrinsics.g(columnNames, "columnNames");
            Intrinsics.g(referenceColumnNames, "referenceColumnNames");
            this.f64045a = referenceTable;
            this.f64046b = onDelete;
            this.f64047c = onUpdate;
            this.f64048d = columnNames;
            this.f64049e = referenceColumnNames;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (Intrinsics.b(this.f64045a, cVar.f64045a) && Intrinsics.b(this.f64046b, cVar.f64046b) && Intrinsics.b(this.f64047c, cVar.f64047c) && Intrinsics.b(this.f64048d, cVar.f64048d)) {
                return Intrinsics.b(this.f64049e, cVar.f64049e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f64045a.hashCode() * 31) + this.f64046b.hashCode()) * 31) + this.f64047c.hashCode()) * 31) + this.f64048d.hashCode()) * 31) + this.f64049e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f64045a + "', onDelete='" + this.f64046b + " +', onUpdate='" + this.f64047c + "', columnNames=" + this.f64048d + ", referenceColumnNames=" + this.f64049e + '}';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f64052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f64053d;

        public d(int i11, int i12, String from, String to2) {
            Intrinsics.g(from, "from");
            Intrinsics.g(to2, "to");
            this.f64050a = i11;
            this.f64051b = i12;
            this.f64052c = from;
            this.f64053d = to2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d other) {
            Intrinsics.g(other, "other");
            int i11 = this.f64050a - other.f64050a;
            return i11 == 0 ? this.f64051b - other.f64051b : i11;
        }

        public final String b() {
            return this.f64052c;
        }

        public final int c() {
            return this.f64050a;
        }

        public final String d() {
            return this.f64053d;
        }
    }

    /* JADX INFO: renamed from: e6.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0658e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f64054e = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final String f64055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final boolean f64056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final List<String> f64057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public List<String> f64058d;

        /* JADX INFO: renamed from: e6.e$e$a */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public C0658e(String name, boolean z11, List<String> columns, List<String> orders) {
            Intrinsics.g(name, "name");
            Intrinsics.g(columns, "columns");
            Intrinsics.g(orders, "orders");
            this.f64055a = name;
            this.f64056b = z11;
            this.f64057c = columns;
            this.f64058d = orders;
            List<String> arrayList = orders;
            if (arrayList.isEmpty()) {
                int size = columns.size();
                arrayList = new ArrayList(size);
                for (int i11 = 0; i11 < size; i11++) {
                    arrayList.add(Index$Order.ASC.name());
                }
            }
            this.f64058d = (List) arrayList;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0658e)) {
                return false;
            }
            C0658e c0658e = (C0658e) obj;
            if (this.f64056b == c0658e.f64056b && Intrinsics.b(this.f64057c, c0658e.f64057c) && Intrinsics.b(this.f64058d, c0658e.f64058d)) {
                return l.L(this.f64055a, "index_", false, 2, null) ? l.L(c0658e.f64055a, "index_", false, 2, null) : Intrinsics.b(this.f64055a, c0658e.f64055a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((l.L(this.f64055a, "index_", false, 2, null) ? -1184239155 : this.f64055a.hashCode()) * 31) + (this.f64056b ? 1 : 0)) * 31) + this.f64057c.hashCode()) * 31) + this.f64058d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f64055a + "', unique=" + this.f64056b + ", columns=" + this.f64057c + ", orders=" + this.f64058d + "'}";
        }
    }

    public e(String name, Map<String, a> columns, Set<c> foreignKeys, Set<C0658e> set) {
        Intrinsics.g(name, "name");
        Intrinsics.g(columns, "columns");
        Intrinsics.g(foreignKeys, "foreignKeys");
        this.f64033a = name;
        this.f64034b = columns;
        this.f64035c = foreignKeys;
        this.f64036d = set;
    }

    @JvmStatic
    public static final e a(g gVar, String str) {
        return f64032e.a(gVar, str);
    }

    public boolean equals(Object obj) {
        Set<C0658e> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!Intrinsics.b(this.f64033a, eVar.f64033a) || !Intrinsics.b(this.f64034b, eVar.f64034b) || !Intrinsics.b(this.f64035c, eVar.f64035c)) {
            return false;
        }
        Set<C0658e> set2 = this.f64036d;
        if (set2 == null || (set = eVar.f64036d) == null) {
            return true;
        }
        return Intrinsics.b(set2, set);
    }

    public int hashCode() {
        return (((this.f64033a.hashCode() * 31) + this.f64034b.hashCode()) * 31) + this.f64035c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.f64033a + "', columns=" + this.f64034b + ", foreignKeys=" + this.f64035c + ", indices=" + this.f64036d + '}';
    }
}
