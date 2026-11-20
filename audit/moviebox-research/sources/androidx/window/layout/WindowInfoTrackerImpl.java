package androidx.window.layout;

import android.app.Activity;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowInfoTrackerImpl implements x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13178d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f13179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13180c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WindowInfoTrackerImpl(c0 windowMetricsCalculator, v windowBackend) {
        Intrinsics.g(windowMetricsCalculator, "windowMetricsCalculator");
        Intrinsics.g(windowBackend, "windowBackend");
        this.f13179b = windowMetricsCalculator;
        this.f13180c = windowBackend;
    }

    @Override // androidx.window.layout.x
    public kotlinx.coroutines.flow.a<a0> a(Activity activity) {
        Intrinsics.g(activity, "activity");
        return kotlinx.coroutines.flow.c.o(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
