package hg;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f66446c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LogEventDropped> f66448b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f66449a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<LogEventDropped> f66450b = new ArrayList();

        public c a() {
            return new c(this.f66449a, Collections.unmodifiableList(this.f66450b));
        }

        public a b(List<LogEventDropped> list) {
            this.f66450b = list;
            return this;
        }

        public a c(String str) {
            this.f66449a = str;
            return this;
        }
    }

    public c(String str, List<LogEventDropped> list) {
        this.f66447a = str;
        this.f66448b = list;
    }

    public static a c() {
        return new a();
    }

    @Protobuf(tag = 2)
    public List<LogEventDropped> a() {
        return this.f66448b;
    }

    @Protobuf(tag = 1)
    public String b() {
        return this.f66447a;
    }
}
