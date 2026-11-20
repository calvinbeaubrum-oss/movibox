package y9;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f81314d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f81315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f81316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f81317c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final f a(String title) {
            Intrinsics.g(title, "title");
            return new f(title, Color.parseColor("#92969E"), 14.0f);
        }

        @JvmStatic
        public final f b(String title) {
            Intrinsics.g(title, "title");
            return new f(title, Color.parseColor("#191F2B"), 16.0f);
        }
    }

    public f(String text, int i11, float f11) {
        Intrinsics.g(text, "text");
        this.f81315a = text;
        this.f81316b = i11;
        this.f81317c = f11;
    }

    public final int a() {
        return this.f81316b;
    }

    public final String b() {
        return this.f81315a;
    }

    public final float c() {
        return this.f81317c;
    }
}
