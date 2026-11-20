package y9;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f81309e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f81312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f81313d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final e a(String title, Function0<Unit> function0) {
            Intrinsics.g(title, "title");
            return new e(title, Color.parseColor("#FF007AFF"), 16.0f, function0);
        }
    }

    public e(String title, int i11, float f11, Function0<Unit> function0) {
        Intrinsics.g(title, "title");
        this.f81310a = title;
        this.f81311b = i11;
        this.f81312c = f11;
        this.f81313d = function0;
    }

    public final Function0<Unit> a() {
        return this.f81313d;
    }

    public final int b() {
        return this.f81311b;
    }

    public final float c() {
        return this.f81312c;
    }

    public final String d() {
        return this.f81310a;
    }

    public final void e(Function0<Unit> function0) {
        this.f81313d = function0;
    }
}
