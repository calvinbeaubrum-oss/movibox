package com.transsion.athena.data;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import athena.a0;
import br.g;
import cr.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class AppIdData implements Parcelable {
    public static final Parcelable.Creator<AppIdData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<d> f50751e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50752f;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<AppIdData> {
        @Override // android.os.Parcelable.Creator
        public AppIdData createFromParcel(Parcel parcel) {
            return new AppIdData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public AppIdData[] newArray(int i11) {
            return new AppIdData[i11];
        }
    }

    public AppIdData() {
    }

    public AppIdData(Parcel parcel) {
        this.f50747a = parcel.readInt();
        this.f50748b = parcel.readString();
    }

    public static AppIdData a(Context context, int i11) {
        AppIdData appIdData = new AppIdData();
        appIdData.f50747a = i11;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgName", context.getPackageName());
            jSONObject.put("versionSDK", "3.0.0.5");
            jSONObject.put("channel", g.t());
            jSONObject.put("installer", com.transsion.ga.g.d());
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put("versionName", packageInfo.versionName);
                jSONObject.put("versionCode", packageInfo.versionCode + "");
            } catch (PackageManager.NameNotFoundException e11) {
                a0.c(Log.getStackTraceString(e11));
            }
            appIdData.f50748b = jSONObject.toString();
        } catch (Exception e12) {
            a0.c(Log.getStackTraceString(e12));
        }
        return appIdData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator<d> it = this.f50751e.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
        }
        return "AppIdData{appid=" + this.f50747a + ", baseInfo='" + this.f50748b + "', packetUid='" + this.f50749c + "', retryTimes=" + this.f50750d + ", serverUrl='" + this.f50752f + "', tidEventSets='" + ((Object) sb2) + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f50747a);
        parcel.writeString(this.f50748b);
    }
}
