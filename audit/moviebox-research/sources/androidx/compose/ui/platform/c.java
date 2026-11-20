package androidx.compose.ui.platform;

import androidx.compose.ui.text.style.ResolvedTextDirection;
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
public final class c extends androidx.compose.ui.platform.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static c f5442f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.ui.text.a0 f5445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5440d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5441e = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ResolvedTextDirection f5443g = ResolvedTextDirection.Rtl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ResolvedTextDirection f5444h = ResolvedTextDirection.Ltr;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            if (c.f5442f == null) {
                c.f5442f = new c(null);
            }
            c cVar = c.f5442f;
            Intrinsics.e(cVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
            return cVar;
        }
    }

    public c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int iP;
        if (d().length() <= 0 || i11 >= d().length()) {
            return null;
        }
        if (i11 < 0) {
            androidx.compose.ui.text.a0 a0Var = this.f5445c;
            if (a0Var == null) {
                Intrinsics.y("layoutResult");
                a0Var = null;
            }
            iP = a0Var.p(0);
        } else {
            androidx.compose.ui.text.a0 a0Var2 = this.f5445c;
            if (a0Var2 == null) {
                Intrinsics.y("layoutResult");
                a0Var2 = null;
            }
            int iP2 = a0Var2.p(i11);
            iP = i(iP2, f5443g) == i11 ? iP2 : iP2 + 1;
        }
        androidx.compose.ui.text.a0 a0Var3 = this.f5445c;
        if (a0Var3 == null) {
            Intrinsics.y("layoutResult");
            a0Var3 = null;
        }
        if (iP >= a0Var3.m()) {
            return null;
        }
        return c(i(iP, f5443g), i(iP, f5444h) + 1);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int iP;
        if (d().length() <= 0 || i11 <= 0) {
            return null;
        }
        if (i11 > d().length()) {
            androidx.compose.ui.text.a0 a0Var = this.f5445c;
            if (a0Var == null) {
                Intrinsics.y("layoutResult");
                a0Var = null;
            }
            iP = a0Var.p(d().length());
        } else {
            androidx.compose.ui.text.a0 a0Var2 = this.f5445c;
            if (a0Var2 == null) {
                Intrinsics.y("layoutResult");
                a0Var2 = null;
            }
            int iP2 = a0Var2.p(i11);
            iP = i(iP2, f5444h) + 1 == i11 ? iP2 : iP2 - 1;
        }
        if (iP < 0) {
            return null;
        }
        return c(i(iP, f5443g), i(iP, f5444h) + 1);
    }

    public final int i(int i11, ResolvedTextDirection resolvedTextDirection) {
        androidx.compose.ui.text.a0 a0Var = this.f5445c;
        androidx.compose.ui.text.a0 a0Var2 = null;
        if (a0Var == null) {
            Intrinsics.y("layoutResult");
            a0Var = null;
        }
        int iT = a0Var.t(i11);
        androidx.compose.ui.text.a0 a0Var3 = this.f5445c;
        if (a0Var3 == null) {
            Intrinsics.y("layoutResult");
            a0Var3 = null;
        }
        if (resolvedTextDirection != a0Var3.w(iT)) {
            androidx.compose.ui.text.a0 a0Var4 = this.f5445c;
            if (a0Var4 == null) {
                Intrinsics.y("layoutResult");
            } else {
                a0Var2 = a0Var4;
            }
            return a0Var2.t(i11);
        }
        androidx.compose.ui.text.a0 a0Var5 = this.f5445c;
        if (a0Var5 == null) {
            Intrinsics.y("layoutResult");
            a0Var5 = null;
        }
        return androidx.compose.ui.text.a0.o(a0Var5, i11, false, 2, null) - 1;
    }

    public final void j(String str, androidx.compose.ui.text.a0 a0Var) {
        f(str);
        this.f5445c = a0Var;
    }
}
