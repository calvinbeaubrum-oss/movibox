package kj;

import android.text.TextUtils;
import com.google.firebase.abt.AbtException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f68601g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateFormat f68602h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f68605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Date f68606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f68607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f68608f;

    public a(String str, String str2, String str3, Date date, long j11, long j12) {
        this.f68603a = str;
        this.f68604b = str2;
        this.f68605c = str3;
        this.f68606d = date;
        this.f68607e = j11;
        this.f68608f = j12;
    }

    public static a a(Map<String, String> map) throws AbtException {
        e(map);
        try {
            return new a(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", f68602h.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
        } catch (NumberFormatException e11) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e11);
        } catch (ParseException e12) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e12);
        }
    }

    public static void e(Map<String, String> map) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (String str : f68601g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    public String b() {
        return this.f68603a;
    }

    public long c() {
        return this.f68606d.getTime();
    }

    public nj.a.c d(String str) {
        nj.a.c cVar = new nj.a.c();
        cVar.f71997a = str;
        cVar.f72009m = c();
        cVar.f71998b = this.f68603a;
        cVar.f71999c = this.f68604b;
        cVar.f72000d = TextUtils.isEmpty(this.f68605c) ? null : this.f68605c;
        cVar.f72001e = this.f68607e;
        cVar.f72006j = this.f68608f;
        return cVar;
    }
}
