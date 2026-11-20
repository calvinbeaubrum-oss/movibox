package la;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f70162a = new a();

    public final String a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        try {
            Set<String> setKeySet = bundle.keySet();
            Set<String> set = setKeySet;
            if (set != null && !set.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                for (String str : setKeySet) {
                    sb2.append("key:" + str + ",value:" + bundle.getString(str) + " | ");
                }
                String string = sb2.toString();
                Intrinsics.f(string, "result.toString()");
                return string;
            }
            return "";
        } catch (Throwable th2) {
            b.c("CommonUtils", "", th2);
            return "";
        }
    }

    public final String b(Intent intent) {
        if (intent == null) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            if (intent.getComponent() != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("componentName:");
                ComponentName component = intent.getComponent();
                sb3.append(component != null ? component.getPackageName() : null);
                sb3.append('|');
                ComponentName component2 = intent.getComponent();
                sb3.append(component2 != null ? component2.getClassName() : null);
                sb3.append(" | ");
                sb2.append(sb3.toString());
            }
            if (intent.getExtras() != null) {
                sb2.append("extras:" + a(intent.getExtras()));
            }
            String string = sb2.toString();
            Intrinsics.f(string, "result.toString()");
            return string;
        } catch (Throwable th2) {
            b.c("CommonUtils", "", th2);
            return "";
        }
    }
}
