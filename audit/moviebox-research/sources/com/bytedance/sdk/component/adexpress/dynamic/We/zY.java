package com.bytedance.sdk.component.adexpress.dynamic.We;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    private JSONObject pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private HashMap<String, Object> f26773sc = new HashMap<>();

    public zY(JSONObject jSONObject) {
        this.pFF = jSONObject;
    }

    private void sc(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i11 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i11 < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                            this.f26773sc.put(str + InstructionFileId.DOT + str2 + InstructionFileId.DOT + next + InstructionFileId.DOT + i11 + InstructionFileId.DOT + next2, objOpt2);
                        }
                        i11++;
                    }
                }
            } else {
                this.f26773sc.put(str + InstructionFileId.DOT + str2 + InstructionFileId.DOT + next, objOpt);
            }
        }
    }

    public boolean pFF(String str) {
        return this.f26773sc.containsKey(str);
    }

    public Object sc(String str) {
        if (this.f26773sc.containsKey(str)) {
            return this.f26773sc.get(str);
        }
        return null;
    }

    public void sc() {
        Iterator<String> itKeys = this.pFF.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.pFF.opt(next);
            int i11 = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i11 < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i11);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                                    this.f26773sc.put(next + InstructionFileId.DOT + i11 + InstructionFileId.DOT + next2, objOpt2);
                                }
                            }
                            i11++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt3 = jSONObject.opt(next3);
                            if ((objOpt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i12 = 0; i12 < ((JSONArray) objOpt3).length(); i12++) {
                                    this.f26773sc.put(next + InstructionFileId.DOT + next3 + InstructionFileId.DOT + i12, ((JSONArray) objOpt3).opt(i12));
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt3).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    Object objOpt4 = ((JSONObject) objOpt3).opt(next4);
                                    this.f26773sc.put(next + InstructionFileId.DOT + next3 + InstructionFileId.DOT + next4, objOpt4);
                                }
                            } else if ((objOpt3 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                sc(next, next3, objOpt3);
                            } else {
                                this.f26773sc.put(next + InstructionFileId.DOT + next3, objOpt3);
                            }
                        }
                    } catch (JSONException unused) {
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.f26773sc.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.f26773sc.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    Object objOpt5 = jSONObject2.opt(next5);
                    this.f26773sc.put(next + InstructionFileId.DOT + next5, objOpt5);
                }
            }
        }
    }
}
