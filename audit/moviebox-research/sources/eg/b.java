package eg;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends eg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f64109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f64113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f64114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f64115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f64116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f64117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f64118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f64119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f64120l;

    /* JADX INFO: renamed from: eg.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0661b extends eg.a.AbstractC0660a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f64121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f64122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f64123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f64124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f64125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f64126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f64127g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f64128h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f64129i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f64130j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f64131k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f64132l;

        @Override // eg.a.AbstractC0660a
        public eg.a a() {
            return new b(this.f64121a, this.f64122b, this.f64123c, this.f64124d, this.f64125e, this.f64126f, this.f64127g, this.f64128h, this.f64129i, this.f64130j, this.f64131k, this.f64132l);
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a b(@Nullable String str) {
            this.f64132l = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a c(@Nullable String str) {
            this.f64130j = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a d(@Nullable String str) {
            this.f64124d = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a e(@Nullable String str) {
            this.f64128h = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a f(@Nullable String str) {
            this.f64123c = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a g(@Nullable String str) {
            this.f64129i = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a h(@Nullable String str) {
            this.f64127g = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a i(@Nullable String str) {
            this.f64131k = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a j(@Nullable String str) {
            this.f64122b = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a k(@Nullable String str) {
            this.f64126f = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a l(@Nullable String str) {
            this.f64125e = str;
            return this;
        }

        @Override // eg.a.AbstractC0660a
        public eg.a.AbstractC0660a m(@Nullable Integer num) {
            this.f64121a = num;
            return this;
        }
    }

    public b(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.f64109a = num;
        this.f64110b = str;
        this.f64111c = str2;
        this.f64112d = str3;
        this.f64113e = str4;
        this.f64114f = str5;
        this.f64115g = str6;
        this.f64116h = str7;
        this.f64117i = str8;
        this.f64118j = str9;
        this.f64119k = str10;
        this.f64120l = str11;
    }

    @Override // eg.a
    @Nullable
    public String b() {
        return this.f64120l;
    }

    @Override // eg.a
    @Nullable
    public String c() {
        return this.f64118j;
    }

    @Override // eg.a
    @Nullable
    public String d() {
        return this.f64112d;
    }

    @Override // eg.a
    @Nullable
    public String e() {
        return this.f64116h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof eg.a)) {
            return false;
        }
        eg.a aVar = (eg.a) obj;
        Integer num = this.f64109a;
        if (num != null ? num.equals(aVar.m()) : aVar.m() == null) {
            String str = this.f64110b;
            if (str != null ? str.equals(aVar.j()) : aVar.j() == null) {
                String str2 = this.f64111c;
                if (str2 != null ? str2.equals(aVar.f()) : aVar.f() == null) {
                    String str3 = this.f64112d;
                    if (str3 != null ? str3.equals(aVar.d()) : aVar.d() == null) {
                        String str4 = this.f64113e;
                        if (str4 != null ? str4.equals(aVar.l()) : aVar.l() == null) {
                            String str5 = this.f64114f;
                            if (str5 != null ? str5.equals(aVar.k()) : aVar.k() == null) {
                                String str6 = this.f64115g;
                                if (str6 != null ? str6.equals(aVar.h()) : aVar.h() == null) {
                                    String str7 = this.f64116h;
                                    if (str7 != null ? str7.equals(aVar.e()) : aVar.e() == null) {
                                        String str8 = this.f64117i;
                                        if (str8 != null ? str8.equals(aVar.g()) : aVar.g() == null) {
                                            String str9 = this.f64118j;
                                            if (str9 != null ? str9.equals(aVar.c()) : aVar.c() == null) {
                                                String str10 = this.f64119k;
                                                if (str10 != null ? str10.equals(aVar.i()) : aVar.i() == null) {
                                                    String str11 = this.f64120l;
                                                    if (str11 == null) {
                                                        if (aVar.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(aVar.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // eg.a
    @Nullable
    public String f() {
        return this.f64111c;
    }

    @Override // eg.a
    @Nullable
    public String g() {
        return this.f64117i;
    }

    @Override // eg.a
    @Nullable
    public String h() {
        return this.f64115g;
    }

    public int hashCode() {
        Integer num = this.f64109a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f64110b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f64111c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f64112d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f64113e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f64114f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f64115g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f64116h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f64117i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f64118j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f64119k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f64120l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // eg.a
    @Nullable
    public String i() {
        return this.f64119k;
    }

    @Override // eg.a
    @Nullable
    public String j() {
        return this.f64110b;
    }

    @Override // eg.a
    @Nullable
    public String k() {
        return this.f64114f;
    }

    @Override // eg.a
    @Nullable
    public String l() {
        return this.f64113e;
    }

    @Override // eg.a
    @Nullable
    public Integer m() {
        return this.f64109a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f64109a + ", model=" + this.f64110b + ", hardware=" + this.f64111c + ", device=" + this.f64112d + ", product=" + this.f64113e + ", osBuild=" + this.f64114f + ", manufacturer=" + this.f64115g + ", fingerprint=" + this.f64116h + ", locale=" + this.f64117i + ", country=" + this.f64118j + ", mccMnc=" + this.f64119k + ", applicationBuild=" + this.f64120l + "}";
    }
}
