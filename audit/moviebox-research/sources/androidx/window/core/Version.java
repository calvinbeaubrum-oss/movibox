package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class Version implements Comparable<Version> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f13122g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Version f13123h = new Version(0, 0, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Version f13124i = new Version(0, 1, 0, "");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Version f13125j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Version f13126k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13130d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f13131f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version a() {
            return Version.f13124i;
        }

        @JvmStatic
        public final Version b(String str) {
            if (str == null || l.y(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String strGroup = matcher.group(1);
            Integer numValueOf = strGroup == null ? null : Integer.valueOf(Integer.parseInt(strGroup));
            if (numValueOf == null) {
                return null;
            }
            int iIntValue = numValueOf.intValue();
            String strGroup2 = matcher.group(2);
            Integer numValueOf2 = strGroup2 == null ? null : Integer.valueOf(Integer.parseInt(strGroup2));
            if (numValueOf2 == null) {
                return null;
            }
            int iIntValue2 = numValueOf2.intValue();
            String strGroup3 = matcher.group(3);
            Integer numValueOf3 = strGroup3 == null ? null : Integer.valueOf(Integer.parseInt(strGroup3));
            if (numValueOf3 == null) {
                return null;
            }
            int iIntValue3 = numValueOf3.intValue();
            String description = matcher.group(4) != null ? matcher.group(4) : "";
            Intrinsics.f(description, "description");
            return new Version(iIntValue, iIntValue2, iIntValue3, description, null);
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f13125j = version;
        f13126k = version;
    }

    public Version(int i11, int i12, int i13, String str) {
        this.f13127a = i11;
        this.f13128b = i12;
        this.f13129c = i13;
        this.f13130d = str;
        this.f13131f = LazyKt__LazyJVMKt.b(new Function0<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BigInteger invoke() {
                return BigInteger.valueOf(this.this$0.d()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.e())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.h()));
            }
        });
    }

    public /* synthetic */ Version(int i11, int i12, int i13, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13, str);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version other) {
        Intrinsics.g(other, "other");
        return c().compareTo(other.c());
    }

    public final BigInteger c() {
        Object value = this.f13131f.getValue();
        Intrinsics.f(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public final int d() {
        return this.f13127a;
    }

    public final int e() {
        return this.f13128b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f13127a == version.f13127a && this.f13128b == version.f13128b && this.f13129c == version.f13129c;
    }

    public final int h() {
        return this.f13129c;
    }

    public int hashCode() {
        return ((((527 + this.f13127a) * 31) + this.f13128b) * 31) + this.f13129c;
    }

    public String toString() {
        return this.f13127a + '.' + this.f13128b + '.' + this.f13129c + (l.y(this.f13130d) ^ true ? Intrinsics.p("-", this.f13130d) : "");
    }
}
