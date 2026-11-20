package q6;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s6.u;

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
public final class e extends c<p6.b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f74440f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f74441g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String strI = j.i("NetworkMeteredCtrlr");
        Intrinsics.f(strI, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        f74441g = strI;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(r6.g<p6.b> tracker) {
        super(tracker);
        Intrinsics.g(tracker, "tracker");
    }

    @Override // q6.c
    public boolean b(u workSpec) {
        Intrinsics.g(workSpec, "workSpec");
        return workSpec.f76208j.d() == NetworkType.METERED;
    }

    @Override // q6.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(p6.b value) {
        Intrinsics.g(value, "value");
        if (Build.VERSION.SDK_INT < 26) {
            j.e().a(f74441g, "Metered network constraint is not supported before API 26, only checking for connected state.");
            if (value.a()) {
                return false;
            }
        } else if (value.a() && value.b()) {
            return false;
        }
        return true;
    }
}
