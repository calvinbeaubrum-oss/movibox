package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public CharSequence f7694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public IconCompat f7695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public String f7696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public String f7697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7699f;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(28)
    public static class a {
        public static a0 a(Person person) {
            return new b().f(person.getName()).c(person.getIcon() != null ? IconCompat.c(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        public static Person b(a0 a0Var) {
            return new Person.Builder().setName(a0Var.d()).setIcon(a0Var.b() != null ? a0Var.b().y() : null).setUri(a0Var.e()).setKey(a0Var.c()).setBot(a0Var.f()).setImportant(a0Var.g()).build();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f7700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public IconCompat f7701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f7702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f7703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f7705f;

        @NonNull
        public a0 a() {
            return new a0(this);
        }

        @NonNull
        public b b(boolean z11) {
            this.f7704e = z11;
            return this;
        }

        @NonNull
        public b c(@Nullable IconCompat iconCompat) {
            this.f7701b = iconCompat;
            return this;
        }

        @NonNull
        public b d(boolean z11) {
            this.f7705f = z11;
            return this;
        }

        @NonNull
        public b e(@Nullable String str) {
            this.f7703d = str;
            return this;
        }

        @NonNull
        public b f(@Nullable CharSequence charSequence) {
            this.f7700a = charSequence;
            return this;
        }

        @NonNull
        public b g(@Nullable String str) {
            this.f7702c = str;
            return this;
        }
    }

    public a0(b bVar) {
        this.f7694a = bVar.f7700a;
        this.f7695b = bVar.f7701b;
        this.f7696c = bVar.f7702c;
        this.f7697d = bVar.f7703d;
        this.f7698e = bVar.f7704e;
        this.f7699f = bVar.f7705f;
    }

    @NonNull
    @RequiresApi(28)
    public static a0 a(@NonNull Person person) {
        return a.a(person);
    }

    @Nullable
    public IconCompat b() {
        return this.f7695b;
    }

    @Nullable
    public String c() {
        return this.f7697d;
    }

    @Nullable
    public CharSequence d() {
        return this.f7694a;
    }

    @Nullable
    public String e() {
        return this.f7696c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        String strC = c();
        String strC2 = a0Var.c();
        if (strC == null && strC2 == null) {
            return Objects.equals(Objects.toString(d()), Objects.toString(a0Var.d())) && Objects.equals(e(), a0Var.e()) && Objects.equals(Boolean.valueOf(f()), Boolean.valueOf(a0Var.f())) && Objects.equals(Boolean.valueOf(g()), Boolean.valueOf(a0Var.g()));
        }
        return Objects.equals(strC, strC2);
    }

    public boolean f() {
        return this.f7698e;
    }

    public boolean g() {
        return this.f7699f;
    }

    @NonNull
    public String h() {
        String str = this.f7696c;
        if (str != null) {
            return str;
        }
        if (this.f7694a == null) {
            return "";
        }
        return "name:" + ((Object) this.f7694a);
    }

    public int hashCode() {
        String strC = c();
        return strC != null ? strC.hashCode() : Objects.hash(d(), e(), Boolean.valueOf(f()), Boolean.valueOf(g()));
    }

    @NonNull
    @RequiresApi(28)
    public Person i() {
        return a.b(this);
    }

    @NonNull
    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f7694a);
        IconCompat iconCompat = this.f7695b;
        bundle.putBundle(RewardPlus.ICON, iconCompat != null ? iconCompat.x() : null);
        bundle.putString("uri", this.f7696c);
        bundle.putString("key", this.f7697d);
        bundle.putBoolean("isBot", this.f7698e);
        bundle.putBoolean("isImportant", this.f7699f);
        return bundle;
    }
}
