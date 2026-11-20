package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import b6.n;
import b6.o;
import b6.p;
import com.google.common.util.concurrent.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public abstract class MeasurementManagerFutures {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12345a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f12346b;

        public Api33Ext5JavaImpl(n mMeasurementManager) {
            Intrinsics.g(mMeasurementManager, "mMeasurementManager");
            this.f12346b = mMeasurementManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Integer> b() {
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3, null), null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Unit> c(Uri attributionSource, InputEvent inputEvent) {
            Intrinsics.g(attributionSource, "attributionSource");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null), 3, null), null, 1, null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Unit> e(b6.a deletionRequest) {
            Intrinsics.g(deletionRequest, "deletionRequest");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null), 3, null), null, 1, null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Unit> f(Uri trigger) {
            Intrinsics.g(trigger, "trigger");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null), 3, null), null, 1, null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Unit> g(o request) {
            Intrinsics.g(request, "request");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, request, null), 3, null), null, 1, null);
        }

        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public s<Unit> h(p request) {
            Intrinsics.g(request, "request");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.a()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MeasurementManagerFutures a(Context context) {
            Intrinsics.g(context, "context");
            n nVarA = n.f14034a.a(context);
            if (nVarA != null) {
                return new Api33Ext5JavaImpl(nVarA);
            }
            return null;
        }
    }

    @JvmStatic
    public static final MeasurementManagerFutures a(Context context) {
        return f12345a.a(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract s<Integer> b();

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract s<Unit> c(Uri uri, InputEvent inputEvent);
}
