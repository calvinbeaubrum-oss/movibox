package bc;

import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f14083b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f14084c = new C0142b(1, "not implemented!");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f14085d = new C0142b(2, "invalid parameter!");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f14086e = new C0142b(3, "unknown error!");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f14087f = new C0142b(4, "forbidden error!");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f14088g = new C0142b(10, "未授权读取用户信息!");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JsonObject f14089a;

    /* JADX INFO: compiled from: source.java */
    public class a extends b {
        public a(JsonObject jsonObject) {
            super(jsonObject);
        }

        @Override // bc.b
        public JsonObject a() {
            return new JsonObject();
        }
    }

    /* JADX INFO: renamed from: bc.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0142b extends b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14090h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f14091i;

        public C0142b(int i11, String str) {
            super(null);
            this.f14090h = i11;
            this.f14091i = str;
        }

        @Override // bc.b
        public JsonObject a() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("error", Integer.valueOf(this.f14090h));
            jsonObject.addProperty("message", this.f14091i);
            jsonObject.addProperty("errorMessage", this.f14091i);
            return jsonObject;
        }

        public int b() {
            return this.f14090h;
        }

        public String c() {
            return this.f14091i;
        }
    }

    public b() {
    }

    public b(JsonObject jsonObject) {
        this.f14089a = jsonObject;
    }

    public JsonObject a() {
        return this.f14089a;
    }
}
