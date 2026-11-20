package com.transsion.baselib.config;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yl.f;
import yl.h;

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
public final class FirebaseConfigManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f51018c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<FirebaseConfigManager> f51019d = LazyKt__LazyJVMKt.b(new Function0<FirebaseConfigManager>() { // from class: com.transsion.baselib.config.FirebaseConfigManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FirebaseConfigManager invoke() {
            return new FirebaseConfigManager();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f51020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51021b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FirebaseConfigManager a() {
            return (FirebaseConfigManager) FirebaseConfigManager.f51019d.getValue();
        }
    }

    public static final void d(FirebaseConfigManager this$0, Function2 callback, Task task) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(callback, "$callback");
        Intrinsics.g(task, "task");
        boolean zIsSuccessful = task.isSuccessful();
        this$0.f51021b = zIsSuccessful;
        Boolean boolValueOf = Boolean.valueOf(zIsSuccessful);
        f fVar = this$0.f51020a;
        if (fVar == null) {
            Intrinsics.y("remoteConfig");
            fVar = null;
        }
        callback.invoke(boolValueOf, fVar);
    }

    public final void c(final Function2<? super Boolean, ? super f, Unit> callback) {
        Intrinsics.g(callback, "callback");
        f fVarA = am.a.a(il.a.f67224a);
        this.f51020a = fVarA;
        f fVar = null;
        if (fVarA == null) {
            Intrinsics.y("remoteConfig");
            fVarA = null;
        }
        fVarA.v(am.a.b(new Function1<h.b, Unit>() { // from class: com.transsion.baselib.config.FirebaseConfigManager$initConfig$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(h.b bVar) {
                invoke2(bVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(h.b remoteConfigSettings) {
                Intrinsics.g(remoteConfigSettings, "$this$remoteConfigSettings");
                remoteConfigSettings.e(3600L);
            }
        }));
        f fVar2 = this.f51020a;
        if (fVar2 == null) {
            Intrinsics.y("remoteConfig");
        } else {
            fVar = fVar2;
        }
        fVar.h().addOnCompleteListener(new OnCompleteListener() { // from class: com.transsion.baselib.config.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirebaseConfigManager.d(this.f51022a, callback, task);
            }
        });
    }
}
