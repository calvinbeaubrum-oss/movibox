package b6;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresPermission;
import androidx.core.os.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14034a = new b(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @SourceDebugExtension
    public static final class a extends n {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MeasurementManager f14035b;

        public a(MeasurementManager mMeasurementManager) {
            Intrinsics.g(mMeasurementManager, "mMeasurementManager");
            this.f14035b = mMeasurementManager;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Context context) {
            Intrinsics.g(context, "context");
            Object systemService = context.getSystemService((Class<Object>) i.a());
            Intrinsics.f(systemService, "context.getSystemService…:class.java\n            )");
            this(j.a(systemService));
        }

        @Override // b6.n
        public Object a(b6.a aVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.deleteRegistrations(k(aVar), new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        }

        @Override // b6.n
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public Object b(Continuation<? super Integer> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.getMeasurementApiStatus(new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }

        @Override // b6.n
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public Object c(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.registerSource(uri, inputEvent, new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        }

        @Override // b6.n
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public Object d(Uri uri, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.registerTrigger(uri, new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        }

        @Override // b6.n
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public Object e(o oVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.registerWebSource(l(oVar), new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        }

        @Override // b6.n
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
        public Object f(p pVar, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.f14035b.registerWebTrigger(m(pVar), new m(), q.a(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
        }

        public final DeletionRequest k(b6.a aVar) {
            c.a();
            throw null;
        }

        public final WebSourceRegistrationRequest l(o oVar) {
            k.a();
            throw null;
        }

        public final WebTriggerRegistrationRequest m(p pVar) {
            l.a();
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final n a(Context context) {
            Intrinsics.g(context, "context");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AdServicesInfo.version=");
            a6.a aVar = a6.a.f414a;
            sb2.append(aVar.a());
            if (aVar.a() >= 5) {
                return new a(context);
            }
            return null;
        }
    }

    public abstract Object a(b6.a aVar, Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object b(Continuation<? super Integer> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object c(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object d(Uri uri, Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object e(o oVar, Continuation<? super Unit> continuation);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")
    public abstract Object f(p pVar, Continuation<? super Unit> continuation);
}
