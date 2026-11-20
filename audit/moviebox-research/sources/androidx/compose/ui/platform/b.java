package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
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
public class b extends androidx.compose.ui.platform.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5429d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5430e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f5431f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BreakIterator f5432c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(Locale locale) {
            if (b.f5431f == null) {
                b.f5431f = new b(locale, null);
            }
            b bVar = b.f5431f;
            Intrinsics.e(bVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return bVar;
        }
    }

    public b(Locale locale) {
        i(locale);
    }

    public /* synthetic */ b(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
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
        do {
            BreakIterator breakIterator = this.f5432c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i11)) {
                BreakIterator breakIterator2 = this.f5432c;
                if (breakIterator2 == null) {
                    Intrinsics.y("impl");
                    breakIterator2 = null;
                }
                int iFollowing = breakIterator2.following(i11);
                if (iFollowing == -1) {
                    return null;
                }
                return c(i11, iFollowing);
            }
            BreakIterator breakIterator3 = this.f5432c;
            if (breakIterator3 == null) {
                Intrinsics.y("impl");
                breakIterator3 = null;
            }
            i11 = breakIterator3.following(i11);
        } while (i11 != -1);
        return null;
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
        do {
            BreakIterator breakIterator = this.f5432c;
            if (breakIterator == null) {
                Intrinsics.y("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(i11)) {
                BreakIterator breakIterator2 = this.f5432c;
                if (breakIterator2 == null) {
                    Intrinsics.y("impl");
                    breakIterator2 = null;
                }
                int iPreceding = breakIterator2.preceding(i11);
                if (iPreceding == -1) {
                    return null;
                }
                return c(iPreceding, i11);
            }
            BreakIterator breakIterator3 = this.f5432c;
            if (breakIterator3 == null) {
                Intrinsics.y("impl");
                breakIterator3 = null;
            }
            i11 = breakIterator3.preceding(i11);
        } while (i11 != -1);
        return null;
    }

    @Override // androidx.compose.ui.platform.a
    public void e(String str) {
        super.e(str);
        BreakIterator breakIterator = this.f5432c;
        if (breakIterator == null) {
            Intrinsics.y("impl");
            breakIterator = null;
        }
        breakIterator.setText(str);
    }

    public final void i(Locale locale) {
        this.f5432c = BreakIterator.getCharacterInstance(locale);
    }
}
