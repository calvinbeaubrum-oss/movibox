package o0;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72238a;

    /* JADX INFO: renamed from: o0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0774a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0774a f72239b = new C0774a();

        public C0774a() {
            super("error", null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f72240b = new b();

        public b() {
            super("loading", null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f72241b = new c();

        public c() {
            super(DevicePublicKeyStringDef.NONE, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f72242b = new d();

        public d() {
            super("success", null);
        }
    }

    public a(String str) {
        this.f72238a = str;
    }

    public /* synthetic */ a(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
