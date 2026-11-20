package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f8314a;

        public a(@Nullable b bVar) {
            this.f8314a = bVar == null ? e() : bVar;
        }

        @NonNull
        public static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new C0083d() : new c();
        }

        @Nullable
        public final EmojiCompat.c a(@NonNull Context context, @Nullable androidx.core.provider.e eVar) {
            if (eVar == null) {
                return null;
            }
            return new j(context, eVar);
        }

        @NonNull
        public final List<List<byte[]>> b(@NonNull Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @Nullable
        public EmojiCompat.c c(@NonNull Context context) {
            return a(context, h(context));
        }

        @NonNull
        public final androidx.core.provider.e d(@NonNull ProviderInfo providerInfo, @NonNull PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new androidx.core.provider.e(str, str2, "emojicompat-emoji-font", b(this.f8314a.b(packageManager, str2)));
        }

        public final boolean f(@Nullable ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        @Nullable
        public final ProviderInfo g(@NonNull PackageManager packageManager) {
            Iterator<ResolveInfo> it = this.f8314a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo providerInfoA = this.f8314a.a(it.next());
                if (f(providerInfoA)) {
                    return providerInfoA;
                }
            }
            return null;
        }

        @Nullable
        public androidx.core.provider.e h(@NonNull Context context) {
            PackageManager packageManager = context.getPackageManager();
            androidx.core.util.i.h(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoG = g(packageManager);
            if (providerInfoG == null) {
                return null;
            }
            try {
                return d(providerInfoG, packageManager);
            } catch (PackageManager.NameNotFoundException e11) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e11);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            throw null;
        }

        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i11) {
            throw null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(19)
    public static class c extends b {
        @Override // androidx.emoji2.text.d.b
        @Nullable
        public ProviderInfo a(@NonNull ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.d.b
        @NonNull
        public List<ResolveInfo> c(@NonNull PackageManager packageManager, @NonNull Intent intent, int i11) {
            return packageManager.queryIntentContentProviders(intent, i11);
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class C0083d extends c {
        @Override // androidx.emoji2.text.d.b
        @NonNull
        public Signature[] b(@NonNull PackageManager packageManager, @NonNull String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    @Nullable
    public static j a(@NonNull Context context) {
        return (j) new a(null).c(context);
    }
}
