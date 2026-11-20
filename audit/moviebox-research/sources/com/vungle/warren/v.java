package com.vungle.warren;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.NetworkProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Repository f62643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final NetworkProvider f62644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public d10.c f62645c = new d10.c();

    public v(@NonNull Repository repository, @NonNull NetworkProvider networkProvider) {
        this.f62643a = repository;
        this.f62644b = networkProvider;
    }

    @Nullable
    public final String a() {
        com.vungle.warren.model.j jVar = (com.vungle.warren.model.j) this.f62643a.T("visionCookie", com.vungle.warren.model.j.class).get();
        if (jVar == null) {
            return null;
        }
        return jVar.d("data_science_cache");
    }

    public String b(String str) {
        str.hashCode();
        switch (str) {
            case "campaign_details":
                return "campaign";
            case "creative_details":
                return "creative";
            case "advertiser_details":
                return "advertiser";
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0043 A[PHI: r4
  0x0043: PHI (r4v8 int) = (r4v7 int), (r4v10 int) binds: [B:27:0x004e, B:23:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    @NonNull
    @TargetApi(21)
    public JsonObject c() {
        int i11;
        d10.c.a aVar;
        int i12;
        d10.c.a aVar2;
        v vVar = this;
        JsonObject jsonObject = new JsonObject();
        String strA = a();
        if (strA != null) {
            jsonObject.addProperty("data_science_cache", strA);
        }
        if (vVar.f62645c.f62864d != null) {
            int iE = vVar.f62644b.e();
            if (iE == 0) {
                aVar = vVar.f62645c.f62864d;
                i12 = aVar.f62867c;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar.f62865a;
                }
            } else if (iE == 1) {
                aVar2 = vVar.f62645c.f62864d;
                i12 = aVar2.f62866b;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar2.f62865a;
                }
            } else if (iE == 4) {
                aVar = vVar.f62645c.f62864d;
                i12 = aVar.f62867c;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar.f62865a;
                }
            } else if (iE == 9) {
                aVar2 = vVar.f62645c.f62864d;
                i12 = aVar2.f62866b;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar2.f62865a;
                }
            } else if (iE == 17) {
                aVar = vVar.f62645c.f62864d;
                i12 = aVar.f62867c;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar.f62865a;
                }
            } else if (iE == 6) {
                aVar2 = vVar.f62645c.f62864d;
                i12 = aVar2.f62866b;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar2.f62865a;
                }
            } else if (iE != 7) {
                i11 = vVar.f62645c.f62864d.f62865a;
            } else {
                aVar = vVar.f62645c.f62864d;
                i12 = aVar.f62867c;
                if (i12 > 0) {
                    i11 = i12;
                } else {
                    i11 = aVar.f62865a;
                }
            }
        } else {
            i11 = 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("aggregate", jsonArray);
        int[] iArr = vVar.f62645c.f62863c;
        if (iArr != null) {
            int length = iArr.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = iArr[i13];
                long millis = jCurrentTimeMillis - TimeUnit.DAYS.toMillis(i14);
                d10.b bVar = vVar.f62643a.R(millis).get();
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("window", Integer.valueOf(i14));
                jsonObject2.addProperty("last_viewed_creative_id", bVar != null ? bVar.f62860b : null);
                jsonObject2.addProperty("total_view_count", Integer.valueOf(bVar != null ? bVar.f62859a : 0));
                String[] strArr = vVar.f62645c.f62862b;
                if (strArr != null) {
                    int length2 = strArr.length;
                    int i15 = 0;
                    while (i15 < length2) {
                        String str = strArr[i15];
                        long j11 = jCurrentTimeMillis;
                        JsonArray jsonArray2 = new JsonArray();
                        jsonObject2.add(str, jsonArray2);
                        String strB = vVar.b(str);
                        List<d10.a> list = vVar.f62643a.Q(millis, i11, strB).get();
                        if (list != null) {
                            Iterator<d10.a> it = list.iterator();
                            while (it.hasNext()) {
                                d10.a next = it.next();
                                int i16 = i11;
                                JsonObject jsonObject3 = new JsonObject();
                                jsonObject3.addProperty(strB + "_id", next.f62856a);
                                jsonObject3.addProperty("view_count", Integer.valueOf(next.f62857b));
                                jsonObject3.addProperty("last_time_viewed", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(next.f62858c)));
                                jsonArray2.add(jsonObject3);
                                iArr = iArr;
                                i11 = i16;
                                it = it;
                                strB = strB;
                                length = length;
                            }
                        }
                        i15++;
                        vVar = this;
                        iArr = iArr;
                        jCurrentTimeMillis = j11;
                        i11 = i11;
                        length = length;
                    }
                }
                jsonArray.add(jsonObject2);
                i13++;
                vVar = this;
                iArr = iArr;
                jCurrentTimeMillis = jCurrentTimeMillis;
                i11 = i11;
                length = length;
            }
        }
        return jsonObject;
    }

    public boolean d() {
        return this.f62645c.f62861a;
    }

    public void e(@NonNull String str, @NonNull String str2, @NonNull String str3) throws DatabaseHelper.DBException {
        this.f62643a.h0(new com.vungle.warren.model.r(System.currentTimeMillis(), str, str2, str3));
        Repository repository = this.f62643a;
        d10.c.a aVar = this.f62645c.f62864d;
        repository.n0(aVar != null ? aVar.f62865a : 0);
    }

    public void f(@NonNull d10.c cVar) throws DatabaseHelper.DBException {
        this.f62645c = cVar;
        if (cVar.f62861a) {
            Repository repository = this.f62643a;
            d10.c.a aVar = cVar.f62864d;
            repository.n0(aVar != null ? aVar.f62865a : 0);
        }
    }

    public void g(@Nullable String str) throws DatabaseHelper.DBException {
        com.vungle.warren.model.j jVar = new com.vungle.warren.model.j("visionCookie");
        if (str != null) {
            jVar.e("data_science_cache", str);
        }
        this.f62643a.h0(jVar);
    }
}
