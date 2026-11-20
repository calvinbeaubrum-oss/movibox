package r6;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g<Boolean> f75160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f75161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g<p6.b> f75162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g<Boolean> f75163d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public n(Context context, t6.c taskExecutor) {
        this(context, taskExecutor, null, null, null, null, 60, null);
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
    }

    @JvmOverloads
    public n(Context context, t6.c taskExecutor, g<Boolean> batteryChargingTracker, c batteryNotLowTracker, g<p6.b> networkStateTracker, g<Boolean> storageNotLowTracker) {
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        Intrinsics.g(batteryChargingTracker, "batteryChargingTracker");
        Intrinsics.g(batteryNotLowTracker, "batteryNotLowTracker");
        Intrinsics.g(networkStateTracker, "networkStateTracker");
        Intrinsics.g(storageNotLowTracker, "storageNotLowTracker");
        this.f75160a = batteryChargingTracker;
        this.f75161b = batteryNotLowTracker;
        this.f75162c = networkStateTracker;
        this.f75163d = storageNotLowTracker;
    }

    public /* synthetic */ n(Context context, t6.c cVar, g gVar, c cVar2, g gVar2, g gVar3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        g aVar;
        c cVar3;
        g gVarA;
        g lVar;
        if ((i11 & 4) != 0) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.f(applicationContext, "context.applicationContext");
            aVar = new a(applicationContext, cVar);
        } else {
            aVar = gVar;
        }
        if ((i11 & 8) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.f(applicationContext2, "context.applicationContext");
            cVar3 = new c(applicationContext2, cVar);
        } else {
            cVar3 = cVar2;
        }
        if ((i11 & 16) != 0) {
            Context applicationContext3 = context.getApplicationContext();
            Intrinsics.f(applicationContext3, "context.applicationContext");
            gVarA = j.a(applicationContext3, cVar);
        } else {
            gVarA = gVar2;
        }
        if ((i11 & 32) != 0) {
            Context applicationContext4 = context.getApplicationContext();
            Intrinsics.f(applicationContext4, "context.applicationContext");
            lVar = new l(applicationContext4, cVar);
        } else {
            lVar = gVar3;
        }
        this(context, cVar, aVar, cVar3, gVarA, lVar);
    }

    public final g<Boolean> a() {
        return this.f75160a;
    }

    public final c b() {
        return this.f75161b;
    }

    public final g<p6.b> c() {
        return this.f75162c;
    }

    public final g<Boolean> d() {
        return this.f75163d;
    }
}
