package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sj;
import com.applovin.impl.yl;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f22766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final n f22767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f22768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f22769k;

    public c(b bVar, j jVar) {
        super("PersistentPostbackQueueSaveTask", jVar);
        this.f22768j = new AtomicBoolean();
        this.f22769k = false;
        this.f22766h = bVar;
        this.f22767i = jVar.J();
    }

    private void a(List list) {
        if (!(this.f22769k && list.isEmpty()) && this.f22768j.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                try {
                    jSONArray.put(dVar.q());
                } catch (Throwable th2) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + dVar, th2);
                    this.f24689a.E().a("PersistentPostbackQueueSaveTask", "serializePostback", th2);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
                l lVarB = this.f24689a.B();
                if (lVarB.a((InputStream) byteArrayInputStream, lVarB.a("persistent_postback_cache.json", j.l()), true)) {
                    if (n.a()) {
                        this.f22767i.a("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                    }
                } else if (n.a()) {
                    this.f22767i.b("PersistentPostbackQueueSaveTask", "Unable to export postback queue to disk.");
                }
            } catch (Throwable th3) {
                n.c("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th3);
                this.f24689a.E().a("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th3);
            }
            this.f22768j.set(false);
        }
    }

    public List a(int i11) throws Throwable {
        ArrayList arrayList = new ArrayList();
        l lVarB = this.f24689a.B();
        if (!lVarB.b("persistent_postback_cache.json", j.l())) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        File fileA = lVarB.a("persistent_postback_cache.json", j.l());
        String strE = lVarB.e(fileA);
        if (TextUtils.isEmpty(strE)) {
            n.h("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        boolean z11 = false;
        try {
            JSONArray jSONArray = new JSONObject(strE).getJSONArray("pb");
            if (n.a()) {
                this.f22767i.a("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.f24689a.a(sj.X2);
            for (int i12 = 0; i12 < jSONArray.length() && arrayList.size() < i11; i12++) {
                try {
                    d dVar = new d(jSONArray.getJSONObject(i12), this.f24689a);
                    if (dVar.c() < num.intValue()) {
                        arrayList.add(dVar);
                    } else {
                        n.h("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + dVar);
                    }
                } catch (Throwable th2) {
                    n.c("PersistentPostbackQueueSaveTask", "Unable to deserialize postback from json", th2);
                    this.f24689a.E().a("PersistentPostbackQueueSaveTask", "deserializePostback", th2);
                }
            }
            if (n.a()) {
                this.f22767i.a("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th3) {
            try {
                n.c("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th3);
                try {
                    this.f24689a.E().a("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th3);
                    if (((Boolean) this.f24689a.a(sj.f22966h1)).booleanValue()) {
                        lVarB.a(fileA, "removeAfterDeserializationFail");
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z11 = true;
                    if (z11 && ((Boolean) this.f24689a.a(sj.f22966h1)).booleanValue()) {
                        lVarB.a(fileA, "removeAfterDeserializationFail");
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        this.f22769k = arrayList.isEmpty();
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.f22766h.d());
    }
}
