package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f7711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f7712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f7713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f7715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f7716g;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(20)
    public static class a {
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(c0 c0Var) {
            Set<String> setD;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(c0Var.i()).setLabel(c0Var.h()).setChoices(c0Var.e()).setAllowFreeFormInput(c0Var.c()).addExtras(c0Var.g());
            if (Build.VERSION.SDK_INT >= 26 && (setD = c0Var.d()) != null) {
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    b.d(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(builderAddExtras, c0Var.f());
            }
            return builderAddExtras.build();
        }

        public static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(26)
    public static class b {
        public static void a(c0 c0Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(c0.a(c0Var), intent, map);
        }

        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z11) {
            return builder.setAllowDataType(str, z11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class c {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i11) {
            return builder.setEditChoicesBeforeSending(i11);
        }
    }

    public c0(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z11, int i11, Bundle bundle, Set<String> set) {
        this.f7710a = str;
        this.f7711b = charSequence;
        this.f7712c = charSequenceArr;
        this.f7713d = z11;
        this.f7714e = i11;
        this.f7715f = bundle;
        this.f7716g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    @RequiresApi(20)
    public static RemoteInput a(c0 c0Var) {
        return a.b(c0Var);
    }

    @RequiresApi(20)
    public static RemoteInput[] b(c0[] c0VarArr) {
        if (c0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[c0VarArr.length];
        for (int i11 = 0; i11 < c0VarArr.length; i11++) {
            remoteInputArr[i11] = a(c0VarArr[i11]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f7713d;
    }

    @Nullable
    public Set<String> d() {
        return this.f7716g;
    }

    @Nullable
    public CharSequence[] e() {
        return this.f7712c;
    }

    public int f() {
        return this.f7714e;
    }

    @NonNull
    public Bundle g() {
        return this.f7715f;
    }

    @Nullable
    public CharSequence h() {
        return this.f7711b;
    }

    @NonNull
    public String i() {
        return this.f7710a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
