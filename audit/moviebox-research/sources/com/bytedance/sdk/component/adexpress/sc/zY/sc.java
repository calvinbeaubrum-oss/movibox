package com.bytedance.sdk.component.adexpress.sc.zY;

import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private pFF ExN;
    private Map<String, sc> TRI = new ConcurrentHashMap();
    private List<C0259sc> We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26913sc;
    private String zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        private String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26914sc;
        private List<Pair<String, String>> zY;

        public List<Pair<String, String>> pFF() {
            return this.zY;
        }

        public void pFF(String str) {
            this.pFF = str;
        }

        public String sc() {
            return this.f26914sc;
        }

        public void sc(String str) {
            this.f26914sc = str;
        }

        public void sc(List<Pair<String, String>> list) {
            this.zY = list;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.sc.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0259sc {
        private String pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private String f26915sc;
        private int zY;

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0259sc)) {
                return super.equals(obj);
            }
            String str2 = this.f26915sc;
            if (str2 != null) {
                C0259sc c0259sc = (C0259sc) obj;
                if (str2.equals(c0259sc.sc()) && (str = this.pFF) != null && str.equals(c0259sc.pFF())) {
                    return true;
                }
            }
            return false;
        }

        public String pFF() {
            return this.pFF;
        }

        public void pFF(String str) {
            this.pFF = str;
        }

        public String sc() {
            return this.f26915sc;
        }

        public void sc(int i11) {
            this.zY = i11;
        }

        public void sc(String str) {
            this.f26915sc = str;
        }

        public int zY() {
            return this.zY;
        }
    }

    public static sc We(String str) {
        if (str == null) {
            return null;
        }
        try {
            return sc(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static sc sc(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        sc scVar = new sc();
        scVar.sc(jSONObject.optString("name"));
        scVar.pFF(jSONObject.optString("version"));
        scVar.zY(jSONObject.optString("main"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i11);
                C0259sc c0259sc = new C0259sc();
                c0259sc.sc(jSONObjectOptJSONObject2.optString("url"));
                c0259sc.pFF(jSONObjectOptJSONObject2.optString("md5"));
                c0259sc.sc(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0259sc);
            }
        }
        scVar.sc(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    sc scVarSc = sc(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (scVarSc != null) {
                        scVar.sc().put(next, scVarSc);
                    }
                }
            }
        } catch (Exception e11) {
            e11.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            pFF pff = new pFF();
            pff.sc(jSONObjectOptJSONObject.optString("url"));
            pff.pFF(jSONObjectOptJSONObject.optString("md5"));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                pff.sc(arrayList2);
            }
            scVar.sc(pff);
        }
        if (scVar.qr()) {
            return scVar;
        }
        return null;
    }

    public pFF ExN() {
        return this.ExN;
    }

    public String Ol() {
        JSONObject jSONObjectQj;
        if (!qr() || (jSONObjectQj = Qj()) == null) {
            return null;
        }
        return jSONObjectQj.toString();
    }

    public JSONObject Qj() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", pFF());
            jSONObject.putOpt("version", zY());
            jSONObject.putOpt("main", We());
            JSONArray jSONArray = new JSONArray();
            if (TRI() != null) {
                for (C0259sc c0259sc : TRI()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0259sc.sc());
                    jSONObject2.putOpt("md5", c0259sc.pFF());
                    jSONObject2.putOpt("level", Integer.valueOf(c0259sc.zY()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.TRI.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z11 = false;
                for (String str : this.TRI.keySet()) {
                    sc scVar = this.TRI.get(str);
                    if (scVar != null) {
                        jSONObject3.put(str, scVar.Qj());
                        z11 = true;
                    }
                }
                if (z11) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            pFF pffExN = ExN();
            if (pffExN != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", pffExN.f26914sc);
                jSONObject4.put("md5", pffExN.pFF);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listPFF = pffExN.pFF();
                if (listPFF != null) {
                    for (Pair<String, String> pair : listPFF) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<C0259sc> TRI() {
        if (this.We == null) {
            this.We = new ArrayList();
        }
        return this.We;
    }

    public String We() {
        return this.zY;
    }

    public String pFF() {
        return this.f26913sc;
    }

    public void pFF(String str) {
        this.pFF = str;
    }

    public boolean qr() {
        return (TextUtils.isEmpty(We()) || TextUtils.isEmpty(zY()) || TextUtils.isEmpty(pFF())) ? false : true;
    }

    public Map<String, sc> sc() {
        return this.TRI;
    }

    public void sc(pFF pff) {
        this.ExN = pff;
    }

    public void sc(String str) {
        this.f26913sc = str;
    }

    public void sc(List<C0259sc> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.We = list;
    }

    public String zY() {
        return this.pFF;
    }

    public void zY(String str) {
        this.zY = str;
    }
}
