package c1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import java.util.List;
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
@RequiresApi(19)
@Metadata
public class e extends c1.a<b1.e, List<Uri>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14540b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14541a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e(int i11) {
        this.f14541a = i11;
        if (i11 <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1".toString());
        }
    }

    @Override // c1.a
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @CallSuper
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, b1.e input) {
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        g.a aVar = g.f14542a;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(input.a()));
            if (this.f14541a > MediaStore.getPickImagesMaxLimit()) {
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f14541a);
            return intent;
        }
        if (aVar.e(context)) {
            ResolveInfo resolveInfoB = aVar.b(context);
            if (resolveInfoB == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo = resolveInfoB.activityInfo;
            Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setType(aVar.c(input.a()));
            intent2.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f14541a);
            return intent2;
        }
        if (aVar.d(context)) {
            ResolveInfo resolveInfoA = aVar.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
            Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f14541a);
            return intent3;
        }
        Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent4.setType(aVar.c(input.a()));
        intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (intent4.getType() != null) {
            return intent4;
        }
        intent4.setType("*/*");
        intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        return intent4;
    }

    @Override // c1.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final c1.a.C0152a<List<Uri>> b(Context context, b1.e input) {
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        return null;
    }

    @Override // c1.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List<Uri> c(int i11, Intent intent) {
        List<Uri> listA;
        if (i11 != -1) {
            intent = null;
        }
        return (intent == null || (listA = c.f14539a.a(intent)) == null) ? kotlin.collections.g.l() : listA;
    }
}
