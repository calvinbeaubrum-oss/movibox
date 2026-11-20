package kotlin.text;

import com.google.android.gms.common.api.Api;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@SinceKotlin
@Metadata
@ExperimentalStdlibApi
public final class HexFormat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f69110d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HexFormat f69111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HexFormat f69112f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f69113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BytesHexFormat f69114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NumberHexFormat f69115c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f69116a = HexFormat.f69110d.a().b();

        @PublishedApi
        public Builder() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class BytesHexFormat {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Companion f69117g = new Companion(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final BytesHexFormat f69118h = new BytesHexFormat(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f69120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f69121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f69122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f69123e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f69124f;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f69125a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f69126b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f69127c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f69128d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f69129e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f69130f;

            public Builder() {
                Companion companion = BytesHexFormat.f69117g;
                this.f69125a = companion.a().g();
                this.f69126b = companion.a().f();
                this.f69127c = companion.a().h();
                this.f69128d = companion.a().d();
                this.f69129e = companion.a().c();
                this.f69130f = companion.a().e();
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

            public final BytesHexFormat a() {
                return BytesHexFormat.f69118h;
            }
        }

        public BytesHexFormat(int i11, int i12, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            Intrinsics.g(groupSeparator, "groupSeparator");
            Intrinsics.g(byteSeparator, "byteSeparator");
            Intrinsics.g(bytePrefix, "bytePrefix");
            Intrinsics.g(byteSuffix, "byteSuffix");
            this.f69119a = i11;
            this.f69120b = i12;
            this.f69121c = groupSeparator;
            this.f69122d = byteSeparator;
            this.f69123e = bytePrefix;
            this.f69124f = byteSuffix;
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            Intrinsics.g(sb2, "sb");
            Intrinsics.g(indent, "indent");
            sb2.append(indent);
            sb2.append("bytesPerLine = ");
            sb2.append(this.f69119a);
            Intrinsics.f(sb2, "append(...)");
            sb2.append(",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("bytesPerGroup = ");
            sb2.append(this.f69120b);
            Intrinsics.f(sb2, "append(...)");
            sb2.append(",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("groupSeparator = \"");
            sb2.append(this.f69121c);
            Intrinsics.f(sb2, "append(...)");
            sb2.append("\",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("byteSeparator = \"");
            sb2.append(this.f69122d);
            Intrinsics.f(sb2, "append(...)");
            sb2.append("\",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("bytePrefix = \"");
            sb2.append(this.f69123e);
            Intrinsics.f(sb2, "append(...)");
            sb2.append("\",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("byteSuffix = \"");
            sb2.append(this.f69124f);
            sb2.append("\"");
            return sb2;
        }

        public final String c() {
            return this.f69123e;
        }

        public final String d() {
            return this.f69122d;
        }

        public final String e() {
            return this.f69124f;
        }

        public final int f() {
            return this.f69120b;
        }

        public final int g() {
            return this.f69119a;
        }

        public final String h() {
            return this.f69121c;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BytesHexFormat(");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            StringBuilder sbB = b(sb2, "    ");
            sbB.append('\n');
            Intrinsics.f(sbB, "append(...)");
            sb2.append(")");
            String string = sb2.toString();
            Intrinsics.f(string, "toString(...)");
            return string;
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

        public final HexFormat a() {
            return HexFormat.f69111e;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class NumberHexFormat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f69131d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final NumberHexFormat f69132e = new NumberHexFormat("", "", false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f69133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f69134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f69135c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f69136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f69137b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f69138c;

            public Builder() {
                Companion companion = NumberHexFormat.f69131d;
                this.f69136a = companion.a().c();
                this.f69137b = companion.a().e();
                this.f69138c = companion.a().d();
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

            public final NumberHexFormat a() {
                return NumberHexFormat.f69132e;
            }
        }

        public NumberHexFormat(String prefix, String suffix, boolean z11) {
            Intrinsics.g(prefix, "prefix");
            Intrinsics.g(suffix, "suffix");
            this.f69133a = prefix;
            this.f69134b = suffix;
            this.f69135c = z11;
        }

        public final StringBuilder b(StringBuilder sb2, String indent) {
            Intrinsics.g(sb2, "sb");
            Intrinsics.g(indent, "indent");
            sb2.append(indent);
            sb2.append("prefix = \"");
            sb2.append(this.f69133a);
            Intrinsics.f(sb2, "append(...)");
            sb2.append("\",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("suffix = \"");
            sb2.append(this.f69134b);
            Intrinsics.f(sb2, "append(...)");
            sb2.append("\",");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            sb2.append(indent);
            sb2.append("removeLeadingZeros = ");
            sb2.append(this.f69135c);
            return sb2;
        }

        public final String c() {
            return this.f69133a;
        }

        public final boolean d() {
            return this.f69135c;
        }

        public final String e() {
            return this.f69134b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NumberHexFormat(");
            Intrinsics.f(sb2, "append(...)");
            sb2.append('\n');
            Intrinsics.f(sb2, "append(...)");
            StringBuilder sbB = b(sb2, "    ");
            sbB.append('\n');
            Intrinsics.f(sbB, "append(...)");
            sb2.append(")");
            String string = sb2.toString();
            Intrinsics.f(string, "toString(...)");
            return string;
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.f69117g;
        BytesHexFormat bytesHexFormatA = companion.a();
        NumberHexFormat.Companion companion2 = NumberHexFormat.f69131d;
        f69111e = new HexFormat(false, bytesHexFormatA, companion2.a());
        f69112f = new HexFormat(true, companion.a(), companion2.a());
    }

    public HexFormat(boolean z11, BytesHexFormat bytes, NumberHexFormat number) {
        Intrinsics.g(bytes, "bytes");
        Intrinsics.g(number, "number");
        this.f69113a = z11;
        this.f69114b = bytes;
        this.f69115c = number;
    }

    public final boolean b() {
        return this.f69113a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HexFormat(");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        sb2.append("    upperCase = ");
        sb2.append(this.f69113a);
        Intrinsics.f(sb2, "append(...)");
        sb2.append(",");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        sb2.append("    bytes = BytesHexFormat(");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        StringBuilder sbB = this.f69114b.b(sb2, "        ");
        sbB.append('\n');
        Intrinsics.f(sbB, "append(...)");
        sb2.append("    ),");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        sb2.append("    number = NumberHexFormat(");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        StringBuilder sbB2 = this.f69115c.b(sb2, "        ");
        sbB2.append('\n');
        Intrinsics.f(sbB2, "append(...)");
        sb2.append("    )");
        Intrinsics.f(sb2, "append(...)");
        sb2.append('\n');
        Intrinsics.f(sb2, "append(...)");
        sb2.append(")");
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }
}
