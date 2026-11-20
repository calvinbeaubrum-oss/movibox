package uk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f78565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Object> f78566b;

    /* JADX INFO: renamed from: uk.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0866b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f78567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Class<?>, Object> f78568b = null;

        public C0866b(String str) {
            this.f78567a = str;
        }

        @NonNull
        public b a() {
            return new b(this.f78567a, this.f78568b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f78568b)));
        }

        @NonNull
        public <T extends Annotation> C0866b b(@NonNull T t11) {
            if (this.f78568b == null) {
                this.f78568b = new HashMap();
            }
            this.f78568b.put(t11.annotationType(), t11);
            return this;
        }
    }

    public b(String str, Map<Class<?>, Object> map) {
        this.f78565a = str;
        this.f78566b = map;
    }

    @NonNull
    public static C0866b a(@NonNull String str) {
        return new C0866b(str);
    }

    @NonNull
    public static b d(@NonNull String str) {
        return new b(str, Collections.emptyMap());
    }

    @NonNull
    public String b() {
        return this.f78565a;
    }

    @Nullable
    public <T extends Annotation> T c(@NonNull Class<T> cls) {
        return (T) this.f78566b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f78565a.equals(bVar.f78565a) && this.f78566b.equals(bVar.f78566b);
    }

    public int hashCode() {
        return (this.f78565a.hashCode() * 31) + this.f78566b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f78565a + ", properties=" + this.f78566b.values() + "}";
    }
}
