package c1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@RequiresApi(19)
@SourceDebugExtension
public class g extends c1.a<b1.e, Uri> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14542a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ResolveInfo a(Context context) {
            Intrinsics.g(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        @JvmStatic
        public final ResolveInfo b(Context context) {
            Intrinsics.g(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(f input) {
            Intrinsics.g(input, "input");
            if (input instanceof c) {
                return "image/*";
            }
            if (input instanceof e) {
                return "video/*";
            }
            if (input instanceof d) {
                return ((d) input).a();
            }
            if (input instanceof b) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final boolean d(Context context) {
            Intrinsics.g(context, "context");
            return a(context) != null;
        }

        @JvmStatic
        public final boolean e(Context context) {
            Intrinsics.g(context, "context");
            return b(context) != null;
        }

        @JvmStatic
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public final boolean f() {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 33) {
                return true;
            }
            return i11 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14543a = new b();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14544a = new c();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14545a;

        public final String a() {
            return this.f14545a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f14546a = new e();
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface f {
    }

    @Override // c1.a
    @CallSuper
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, b1.e input) {
        Intent intent;
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        a aVar = f14542a;
        if (aVar.f()) {
            Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
            intent2.setType(aVar.c(input.a()));
            return intent2;
        }
        if (aVar.e(context)) {
            ResolveInfo resolveInfoB = aVar.b(context);
            if (resolveInfoB == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo = resolveInfoB.activityInfo;
            intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.setType(aVar.c(input.a()));
        } else {
            if (!aVar.d(context)) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(aVar.c(input.a()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
            ResolveInfo resolveInfoA = aVar.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
            intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent.setType(aVar.c(input.a()));
        }
        return intent;
    }

    @Override // c1.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final c1.a.C0152a<Uri> b(Context context, b1.e input) {
        Intrinsics.g(context, "context");
        Intrinsics.g(input, "input");
        return null;
    }

    @Override // c1.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i11, Intent intent) {
        if (i11 != -1) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            data = (Uri) CollectionsKt___CollectionsKt.g0(c1.c.f14539a.a(intent));
        }
        return data;
    }
}
