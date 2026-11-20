package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.RequiresApi;
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
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f623e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f627d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(float f11, float f12, float f13, int i11) {
        this.f624a = f11;
        this.f625b = f12;
        this.f626c = f13;
        this.f627d = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @RequiresApi(34)
    public b(BackEvent backEvent) {
        Intrinsics.g(backEvent, "backEvent");
        androidx.activity.a aVar = androidx.activity.a.f622a;
        this(aVar.d(backEvent), aVar.e(backEvent), aVar.b(backEvent), aVar.c(backEvent));
    }

    public final float a() {
        return this.f626c;
    }

    public final int b() {
        return this.f627d;
    }

    public final float c() {
        return this.f625b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f624a + ", touchY=" + this.f625b + ", progress=" + this.f626c + ", swipeEdge=" + this.f627d + '}';
    }
}
