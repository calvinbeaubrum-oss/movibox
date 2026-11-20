package androidx.compose.ui.platform;

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
public final class e extends androidx.compose.ui.platform.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5461c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f5462d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e a() {
            if (e.f5462d == null) {
                e.f5462d = new e(null);
            }
            e eVar = e.f5462d;
            Intrinsics.e(eVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            return eVar;
        }
    }

    public e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int length = d().length();
        if (length <= 0 || i11 >= length) {
            return null;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < length && d().charAt(i11) == '\n' && !j(i11)) {
            i11++;
        }
        if (i11 >= length) {
            return null;
        }
        int i12 = i11 + 1;
        while (i12 < length && !i(i12)) {
            i12++;
        }
        return c(i11, i12);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int length = d().length();
        if (length <= 0 || i11 <= 0) {
            return null;
        }
        if (i11 > length) {
            i11 = length;
        }
        while (i11 > 0 && d().charAt(i11 - 1) == '\n' && !i(i11)) {
            i11--;
        }
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        while (i12 > 0 && !j(i12)) {
            i12--;
        }
        return c(i12, i11);
    }

    public final boolean i(int i11) {
        return i11 > 0 && d().charAt(i11 + (-1)) != '\n' && (i11 == d().length() || d().charAt(i11) == '\n');
    }

    public final boolean j(int i11) {
        return d().charAt(i11) != '\n' && (i11 == 0 || d().charAt(i11 - 1) == '\n');
    }
}
