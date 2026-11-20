package zn;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import co.b;
import com.permissionx.guolindev.request.PermissionBuilder;
import com.permissionx.guolindev.request.f;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f82104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f82105b;

    public a(FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        this.f82104a = activity;
    }

    public final f a(List<String> permissions) {
        int i11;
        Intrinsics.g(permissions, "permissions");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int i12 = Build.VERSION.SDK_INT;
        FragmentActivity fragmentActivity = this.f82104a;
        if (fragmentActivity != null) {
            Intrinsics.d(fragmentActivity);
            i11 = fragmentActivity.getApplicationInfo().targetSdkVersion;
        } else {
            Fragment fragment = this.f82105b;
            Intrinsics.d(fragment);
            i11 = fragment.requireContext().getApplicationInfo().targetSdkVersion;
        }
        for (String str : permissions) {
            if (b.a().contains(str)) {
                linkedHashSet2.add(str);
            } else {
                linkedHashSet.add(str);
            }
        }
        if (linkedHashSet2.contains("android.permission.ACCESS_BACKGROUND_LOCATION") && (i12 == 29 || (i12 == 30 && i11 < 30))) {
            linkedHashSet2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (linkedHashSet2.contains("android.permission.POST_NOTIFICATIONS") && i12 >= 33 && i11 >= 33) {
            linkedHashSet2.remove("android.permission.POST_NOTIFICATIONS");
            linkedHashSet.add("android.permission.POST_NOTIFICATIONS");
        }
        return new PermissionBuilder(this.f82104a, this.f82105b, linkedHashSet, linkedHashSet2);
    }

    public final f b(String... permissions) {
        Intrinsics.g(permissions, "permissions");
        return a(g.o(Arrays.copyOf(permissions, permissions.length)));
    }
}
