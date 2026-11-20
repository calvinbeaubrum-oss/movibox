package com.vungle.warren.model;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.transsion.push.PushConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ReportDBAdapter implements com.vungle.warren.persistence.c<o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Gson f62120a = new GsonBuilder().create();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Type f62121b = new TypeToken<ArrayList<String>>() { // from class: com.vungle.warren.model.ReportDBAdapter.1
    }.getType();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Type f62122c = new TypeToken<ArrayList<o.a>>() { // from class: com.vungle.warren.model.ReportDBAdapter.2
    }.getType();

    @Override // com.vungle.warren.persistence.c
    public String b() {
        return "report";
    }

    @Override // com.vungle.warren.persistence.c
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public o c(ContentValues contentValues) {
        o oVar = new o();
        oVar.f62208k = contentValues.getAsLong("ad_duration").longValue();
        oVar.f62205h = contentValues.getAsLong("adStartTime").longValue();
        oVar.f62200c = contentValues.getAsString("adToken");
        oVar.f62216s = contentValues.getAsString("ad_type");
        oVar.f62201d = contentValues.getAsString(PushConstants.PROVIDER_FIELD_APP_ID);
        oVar.f62210m = contentValues.getAsString("campaign");
        oVar.f62219v = contentValues.getAsInteger("ordinal").intValue();
        oVar.f62199b = contentValues.getAsString("placementId");
        oVar.f62217t = contentValues.getAsString("template_id");
        oVar.f62209l = contentValues.getAsLong("tt_download").longValue();
        oVar.f62206i = contentValues.getAsString("url");
        oVar.f62218u = contentValues.getAsString("user_id");
        oVar.f62207j = contentValues.getAsLong("videoLength").longValue();
        oVar.f62212o = contentValues.getAsInteger("videoViewed").intValue();
        oVar.f62221x = com.vungle.warren.persistence.b.a(contentValues, "was_CTAC_licked");
        oVar.f62202e = com.vungle.warren.persistence.b.a(contentValues, "incentivized");
        oVar.f62203f = com.vungle.warren.persistence.b.a(contentValues, "header_bidding");
        oVar.f62198a = contentValues.getAsInteger(NotificationCompat.CATEGORY_STATUS).intValue();
        oVar.f62220w = contentValues.getAsString("ad_size");
        oVar.f62222y = contentValues.getAsLong("init_timestamp").longValue();
        oVar.f62223z = contentValues.getAsLong("asset_download_duration").longValue();
        oVar.f62204g = com.vungle.warren.persistence.b.a(contentValues, "play_remote_url");
        List list = (List) this.f62120a.fromJson(contentValues.getAsString("clicked_through"), this.f62121b);
        List list2 = (List) this.f62120a.fromJson(contentValues.getAsString("errors"), this.f62121b);
        List list3 = (List) this.f62120a.fromJson(contentValues.getAsString("user_actions"), this.f62122c);
        if (list != null) {
            oVar.f62214q.addAll(list);
        }
        if (list2 != null) {
            oVar.f62215r.addAll(list2);
        }
        if (list3 != null) {
            oVar.f62213p.addAll(list3);
        }
        return oVar;
    }

    @Override // com.vungle.warren.persistence.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ContentValues a(o oVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item_id", oVar.c());
        contentValues.put("ad_duration", Long.valueOf(oVar.f62208k));
        contentValues.put("adStartTime", Long.valueOf(oVar.f62205h));
        contentValues.put("adToken", oVar.f62200c);
        contentValues.put("ad_type", oVar.f62216s);
        contentValues.put(PushConstants.PROVIDER_FIELD_APP_ID, oVar.f62201d);
        contentValues.put("campaign", oVar.f62210m);
        contentValues.put("incentivized", Boolean.valueOf(oVar.f62202e));
        contentValues.put("header_bidding", Boolean.valueOf(oVar.f62203f));
        contentValues.put("ordinal", Integer.valueOf(oVar.f62219v));
        contentValues.put("placementId", oVar.f62199b);
        contentValues.put("template_id", oVar.f62217t);
        contentValues.put("tt_download", Long.valueOf(oVar.f62209l));
        contentValues.put("url", oVar.f62206i);
        contentValues.put("user_id", oVar.f62218u);
        contentValues.put("videoLength", Long.valueOf(oVar.f62207j));
        contentValues.put("videoViewed", Integer.valueOf(oVar.f62212o));
        contentValues.put("was_CTAC_licked", Boolean.valueOf(oVar.f62221x));
        contentValues.put("user_actions", this.f62120a.toJson(new ArrayList(oVar.f62213p), this.f62122c));
        contentValues.put("clicked_through", this.f62120a.toJson(new ArrayList(oVar.f62214q), this.f62121b));
        contentValues.put("errors", this.f62120a.toJson(new ArrayList(oVar.f62215r), this.f62121b));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(oVar.f62198a));
        contentValues.put("ad_size", oVar.f62220w);
        contentValues.put("init_timestamp", Long.valueOf(oVar.f62222y));
        contentValues.put("asset_download_duration", Long.valueOf(oVar.f62223z));
        contentValues.put("play_remote_url", Boolean.valueOf(oVar.f62204g));
        return contentValues;
    }
}
