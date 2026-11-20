package androidx.compose.ui.text.font;

import com.google.logging.type.LogSeverity;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class u implements Comparable<u> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5860b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f5861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f5862d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f5863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f5864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f5865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f5866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u f5867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f5868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f5869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u f5870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final u f5871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final u f5872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final u f5873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final u f5874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final u f5875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final u f5876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final u f5877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final u f5878u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<u> f5879v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5880a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final u a() {
            return u.f5873p;
        }

        public final u b() {
            return u.f5864g;
        }

        public final u c() {
            return u.f5865h;
        }

        public final u d() {
            return u.f5866i;
        }

        public final u e() {
            return u.f5867j;
        }
    }

    static {
        u uVar = new u(100);
        f5861c = uVar;
        u uVar2 = new u(200);
        f5862d = uVar2;
        u uVar3 = new u(LogSeverity.NOTICE_VALUE);
        f5863f = uVar3;
        u uVar4 = new u(LogSeverity.WARNING_VALUE);
        f5864g = uVar4;
        u uVar5 = new u(500);
        f5865h = uVar5;
        u uVar6 = new u(LogSeverity.CRITICAL_VALUE);
        f5866i = uVar6;
        u uVar7 = new u(LogSeverity.ALERT_VALUE);
        f5867j = uVar7;
        u uVar8 = new u(LogSeverity.EMERGENCY_VALUE);
        f5868k = uVar8;
        u uVar9 = new u(900);
        f5869l = uVar9;
        f5870m = uVar;
        f5871n = uVar2;
        f5872o = uVar3;
        f5873p = uVar4;
        f5874q = uVar5;
        f5875r = uVar6;
        f5876s = uVar7;
        f5877t = uVar8;
        f5878u = uVar9;
        f5879v = kotlin.collections.g.o(uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9);
    }

    public u(int i11) {
        this.f5880a = i11;
        if (1 > i11 || i11 >= 1001) {
            throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i11).toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && this.f5880a == ((u) obj).f5880a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        return Intrinsics.i(this.f5880a, uVar.f5880a);
    }

    public int hashCode() {
        return this.f5880a;
    }

    public final int i() {
        return this.f5880a;
    }

    public String toString() {
        return "FontWeight(weight=" + this.f5880a + ')';
    }
}
