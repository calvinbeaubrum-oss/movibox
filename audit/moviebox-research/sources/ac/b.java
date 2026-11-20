package ac;

import com.google.gson.JsonObject;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JsonObject f472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f475f;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f476a = "native_" + System.currentTimeMillis();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JsonObject f478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public i f480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f481f;

        public a(i iVar) {
            this.f480e = iVar;
        }

        public a g(String str) {
            this.f477b = str;
            return this;
        }

        public b h() {
            return new b(this);
        }

        public a i(JsonObject jsonObject) {
            this.f478c = jsonObject;
            return this;
        }

        public a j(String str) {
            this.f479d = str;
            return this;
        }
    }

    public b(a aVar) {
        this.f470a = aVar.f476a;
        this.f471b = aVar.f477b;
        JsonObject jsonObject = aVar.f478c;
        this.f472c = jsonObject;
        if (jsonObject == null) {
            this.f472c = new JsonObject();
        }
        this.f473d = aVar.f479d;
        this.f475f = aVar.f481f;
        this.f474e = aVar.f480e;
    }

    public static a b(i iVar) {
        return new a(iVar);
    }

    public JsonObject a() {
        return this.f472c;
    }
}
