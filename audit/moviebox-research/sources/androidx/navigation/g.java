package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12280c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.g(intent, "intent");
    }

    public g(Uri uri, String str, String str2) {
        this.f12278a = uri;
        this.f12279b = str;
        this.f12280c = str2;
    }

    public String a() {
        return this.f12279b;
    }

    public String b() {
        return this.f12280c;
    }

    public Uri c() {
        return this.f12278a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("NavDeepLinkRequest");
        sb2.append("{");
        if (c() != null) {
            sb2.append(" uri=");
            sb2.append(String.valueOf(c()));
        }
        if (a() != null) {
            sb2.append(" action=");
            sb2.append(a());
        }
        if (b() != null) {
            sb2.append(" mimetype=");
            sb2.append(b());
        }
        sb2.append(" }");
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }
}
