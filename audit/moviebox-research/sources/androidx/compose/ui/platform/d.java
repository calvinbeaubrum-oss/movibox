package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
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
public final class d extends androidx.compose.ui.platform.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d f5451h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.compose.ui.text.a0 f5454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SemanticsNode f5455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Rect f5456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5449f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5450g = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ResolvedTextDirection f5452i = ResolvedTextDirection.Rtl;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ResolvedTextDirection f5453j = ResolvedTextDirection.Ltr;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            if (d.f5451h == null) {
                d.f5451h = new d(null);
            }
            d dVar = d.f5451h;
            Intrinsics.e(dVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return dVar;
        }
    }

    public d() {
        this.f5456e = new Rect();
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int i(int i11, ResolvedTextDirection resolvedTextDirection) {
        androidx.compose.ui.text.a0 a0Var = this.f5454c;
        androidx.compose.ui.text.a0 a0Var2 = null;
        if (a0Var == null) {
            Intrinsics.y("layoutResult");
            a0Var = null;
        }
        int iT = a0Var.t(i11);
        androidx.compose.ui.text.a0 a0Var3 = this.f5454c;
        if (a0Var3 == null) {
            Intrinsics.y("layoutResult");
            a0Var3 = null;
        }
        if (resolvedTextDirection != a0Var3.w(iT)) {
            androidx.compose.ui.text.a0 a0Var4 = this.f5454c;
            if (a0Var4 == null) {
                Intrinsics.y("layoutResult");
            } else {
                a0Var2 = a0Var4;
            }
            return a0Var2.t(i11);
        }
        androidx.compose.ui.text.a0 a0Var5 = this.f5454c;
        if (a0Var5 == null) {
            Intrinsics.y("layoutResult");
            a0Var5 = null;
        }
        return androidx.compose.ui.text.a0.o(a0Var5, i11, false, 2, null) - 1;
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int iM;
        androidx.compose.ui.text.a0 a0Var = null;
        if (d().length() <= 0 || i11 >= d().length()) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.f5455d;
            if (semanticsNode == null) {
                Intrinsics.y("node");
                semanticsNode = null;
            }
            int iRound = Math.round(semanticsNode.i().e());
            int iD = kotlin.ranges.a.d(0, i11);
            androidx.compose.ui.text.a0 a0Var2 = this.f5454c;
            if (a0Var2 == null) {
                Intrinsics.y("layoutResult");
                a0Var2 = null;
            }
            int iP = a0Var2.p(iD);
            androidx.compose.ui.text.a0 a0Var3 = this.f5454c;
            if (a0Var3 == null) {
                Intrinsics.y("layoutResult");
                a0Var3 = null;
            }
            float fU = a0Var3.u(iP) + iRound;
            androidx.compose.ui.text.a0 a0Var4 = this.f5454c;
            if (a0Var4 == null) {
                Intrinsics.y("layoutResult");
                a0Var4 = null;
            }
            androidx.compose.ui.text.a0 a0Var5 = this.f5454c;
            if (a0Var5 == null) {
                Intrinsics.y("layoutResult");
                a0Var5 = null;
            }
            if (fU < a0Var4.u(a0Var5.m() - 1)) {
                androidx.compose.ui.text.a0 a0Var6 = this.f5454c;
                if (a0Var6 == null) {
                    Intrinsics.y("layoutResult");
                } else {
                    a0Var = a0Var6;
                }
                iM = a0Var.q(fU);
            } else {
                androidx.compose.ui.text.a0 a0Var7 = this.f5454c;
                if (a0Var7 == null) {
                    Intrinsics.y("layoutResult");
                } else {
                    a0Var = a0Var7;
                }
                iM = a0Var.m();
            }
            return c(iD, i(iM - 1, f5453j) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int iQ;
        androidx.compose.ui.text.a0 a0Var = null;
        if (d().length() <= 0 || i11 <= 0) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.f5455d;
            if (semanticsNode == null) {
                Intrinsics.y("node");
                semanticsNode = null;
            }
            int iRound = Math.round(semanticsNode.i().e());
            int iG = kotlin.ranges.a.g(d().length(), i11);
            androidx.compose.ui.text.a0 a0Var2 = this.f5454c;
            if (a0Var2 == null) {
                Intrinsics.y("layoutResult");
                a0Var2 = null;
            }
            int iP = a0Var2.p(iG);
            androidx.compose.ui.text.a0 a0Var3 = this.f5454c;
            if (a0Var3 == null) {
                Intrinsics.y("layoutResult");
                a0Var3 = null;
            }
            float fU = a0Var3.u(iP) - iRound;
            if (fU > 0.0f) {
                androidx.compose.ui.text.a0 a0Var4 = this.f5454c;
                if (a0Var4 == null) {
                    Intrinsics.y("layoutResult");
                } else {
                    a0Var = a0Var4;
                }
                iQ = a0Var.q(fU);
            } else {
                iQ = 0;
            }
            if (iG == d().length() && iQ < iP) {
                iQ++;
            }
            return c(i(iQ, f5452i), iG);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final void j(String str, androidx.compose.ui.text.a0 a0Var, SemanticsNode semanticsNode) {
        f(str);
        this.f5454c = a0Var;
        this.f5455d = semanticsNode;
    }
}
