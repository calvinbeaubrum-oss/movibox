package com.cloud.hisavana.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class u0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f30126c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Unit> f30128b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u0(String appId, Function1<? super Integer, Unit> function1) {
        Intrinsics.g(appId, "appId");
        this.f30127a = appId;
        this.f30128b = function1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        r3 = 0;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        Function1<? super Integer, Unit> function1;
        if (context == null || intent == null || !Intrinsics.b(intent.getAction(), "action_add_item_result_receiver")) {
            return;
        }
        String stringExtra = intent.getStringExtra("add_item_info_id_key");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() != 0 && Intrinsics.b(stringExtra, this.f30127a)) {
            int intExtra = intent.getIntExtra("add_item_result_key", -1);
            if (intExtra != 0) {
                int i11 = 1;
                if (intExtra != 1) {
                    function1 = this.f30128b;
                } else {
                    function1 = this.f30128b;
                    if (function1 != null) {
                        function1.invoke(Integer.valueOf(i11));
                    }
                }
            } else {
                function1 = this.f30128b;
            }
            this.f30128b = null;
        }
    }
}
