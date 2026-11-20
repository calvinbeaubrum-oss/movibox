package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class AnnotatedString implements CharSequence {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5693f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<AnnotatedString, ?> f5694g = SaversKt.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<y>> f5696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b<r>> f5697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b<? extends Object>> f5698d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f5699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f5702d;

        public b(T t11, int i11, int i12) {
            this(t11, i11, i12, "");
        }

        public b(T t11, int i11, int i12, String str) {
            this.f5699a = t11;
            this.f5700b = i11;
            this.f5701c = i12;
            this.f5702d = str;
            if (i11 > i12) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public final T a() {
            return this.f5699a;
        }

        public final int b() {
            return this.f5700b;
        }

        public final int c() {
            return this.f5701c;
        }

        public final int d() {
            return this.f5701c;
        }

        public final T e() {
            return this.f5699a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f5699a, bVar.f5699a) && this.f5700b == bVar.f5700b && this.f5701c == bVar.f5701c && Intrinsics.b(this.f5702d, bVar.f5702d);
        }

        public final int f() {
            return this.f5700b;
        }

        public final String g() {
            return this.f5702d;
        }

        public int hashCode() {
            T t11 = this.f5699a;
            return ((((((t11 == null ? 0 : t11.hashCode()) * 31) + this.f5700b) * 31) + this.f5701c) * 31) + this.f5702d.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.f5699a + ", start=" + this.f5700b + ", end=" + this.f5701c + ", tag=" + this.f5702d + ')';
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnnotatedString(String str, List<b<y>> list, List<b<r>> list2) {
        List<b<y>> list3 = list;
        List<b<r>> list4 = list2;
        this(str, list3.isEmpty() ? null : list3, list4.isEmpty() ? null : list4, null);
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? kotlin.collections.g.l() : list, (i11 & 4) != 0 ? kotlin.collections.g.l() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(String str, List<b<y>> list, List<b<r>> list2, List<? extends b<? extends Object>> list3) {
        List listE0;
        this.f5695a = str;
        this.f5696b = list;
        this.f5697c = list2;
        this.f5698d = list3;
        if (list2 == null || (listE0 = CollectionsKt___CollectionsKt.E0(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return kotlin.comparisons.b.d(Integer.valueOf(((AnnotatedString.b) t11).f()), Integer.valueOf(((AnnotatedString.b) t12).f()));
            }
        })) == null) {
            return;
        }
        int size = listE0.size();
        int iD = -1;
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) listE0.get(i11);
            if (bVar.f() < iD) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
            }
            if (bVar.d() > this.f5695a.length()) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + bVar.f() + ", " + bVar.d() + ") is out of boundary").toString());
            }
            iD = bVar.d();
        }
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : list, (i11 & 4) != 0 ? null : list2, (i11 & 8) != 0 ? null : list3);
    }

    public char a(int i11) {
        return this.f5695a.charAt(i11);
    }

    public final List<b<? extends Object>> b() {
        return this.f5698d;
    }

    public int c() {
        return this.f5695a.length();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i11) {
        return a(i11);
    }

    public final List<b<f>> d(int i11, int i12) {
        List listL;
        List<b<? extends Object>> list = this.f5698d;
        if (list != null) {
            listL = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                b<? extends Object> bVar = list.get(i13);
                b<? extends Object> bVar2 = bVar;
                if ((bVar2.e() instanceof f) && d.f(i11, i12, bVar2.f(), bVar2.d())) {
                    listL.add(bVar);
                }
            }
        } else {
            listL = kotlin.collections.g.l();
        }
        Intrinsics.e(listL, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return listL;
    }

    public final List<b<r>> e() {
        List<b<r>> list = this.f5697c;
        return list == null ? kotlin.collections.g.l() : list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.b(this.f5695a, annotatedString.f5695a) && Intrinsics.b(this.f5696b, annotatedString.f5696b) && Intrinsics.b(this.f5697c, annotatedString.f5697c) && Intrinsics.b(this.f5698d, annotatedString.f5698d);
    }

    public final List<b<r>> f() {
        return this.f5697c;
    }

    public final List<b<y>> g() {
        List<b<y>> list = this.f5696b;
        return list == null ? kotlin.collections.g.l() : list;
    }

    public final List<b<y>> h() {
        return this.f5696b;
    }

    public int hashCode() {
        int iHashCode = this.f5695a.hashCode() * 31;
        List<b<y>> list = this.f5696b;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<b<r>> list2 = this.f5697c;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<b<? extends Object>> list3 = this.f5698d;
        return iHashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    public final String i() {
        return this.f5695a;
    }

    public final List<b<g0>> j(int i11, int i12) {
        List listL;
        List<b<? extends Object>> list = this.f5698d;
        if (list != null) {
            listL = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                b<? extends Object> bVar = list.get(i13);
                b<? extends Object> bVar2 = bVar;
                if ((bVar2.e() instanceof g0) && d.f(i11, i12, bVar2.f(), bVar2.d())) {
                    listL.add(bVar);
                }
            }
        } else {
            listL = kotlin.collections.g.l();
        }
        Intrinsics.e(listL, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return listL;
    }

    @Deprecated
    public final List<b<h0>> k(int i11, int i12) {
        List listL;
        List<b<? extends Object>> list = this.f5698d;
        if (list != null) {
            listL = new ArrayList(list.size());
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                b<? extends Object> bVar = list.get(i13);
                b<? extends Object> bVar2 = bVar;
                if ((bVar2.e() instanceof h0) && d.f(i11, i12, bVar2.f(), bVar2.d())) {
                    listL.add(bVar);
                }
            }
        } else {
            listL = kotlin.collections.g.l();
        }
        Intrinsics.e(listL, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return listL;
    }

    public final boolean l(AnnotatedString annotatedString) {
        return Intrinsics.b(this.f5698d, annotatedString.f5698d);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return c();
    }

    public final boolean m(int i11, int i12) {
        List<b<? extends Object>> list = this.f5698d;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            b<? extends Object> bVar = list.get(i13);
            if ((bVar.e() instanceof f) && d.f(i11, i12, bVar.f(), bVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public AnnotatedString subSequence(int i11, int i12) {
        if (i11 <= i12) {
            if (i11 == 0 && i12 == this.f5695a.length()) {
                return this;
            }
            String strSubstring = this.f5695a.substring(i11, i12);
            Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(strSubstring, d.d(this.f5696b, i11, i12), d.d(this.f5697c, i11, i12), d.d(this.f5698d, i11, i12));
        }
        throw new IllegalArgumentException(("start (" + i11 + ") should be less or equal to end (" + i12 + ')').toString());
    }

    public final AnnotatedString o(long j11) {
        return subSequence(c0.j(j11), c0.i(j11));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f5695a;
    }
}
