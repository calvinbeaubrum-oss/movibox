package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.transsion.push.PushConstants;
import com.transsion.sdk.oneid.a;
import com.transsion.sdk.oneid.e;
import com.transsion.sdk.oneid.f;
import java.io.File;
import java.io.Serializable;
import java.util.UUID;
import k20.b;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GroupFpInfo extends OneBaseInfo implements Serializable {
    public DeviceInfo device;
    public UniqueIdInfo dids;
    public EnvironInfo env;

    /* JADX INFO: renamed from: fp, reason: collision with root package name */
    public FingerprintInfo f57401fp;
    public PackageInfo pkg;
    public RomInfo rom;
    public UserIdInfo user;
    public String vaid;

    public GroupFpInfo(Context context, Handler.Callback callback) {
        String strF;
        String packageName = context.getPackageName();
        try {
            this.vaid = b.b(context).f(PushConstants.PROVIDER_VAID);
        } catch (Exception unused) {
        }
        try {
            if (TextUtils.isEmpty(this.vaid)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        if (!TextUtils.isEmpty(string)) {
                            this.vaid = UUID.nameUUIDFromBytes((packageName + string).getBytes()).toString();
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (TextUtils.isEmpty(this.vaid)) {
                    this.vaid = UUID.randomUUID().toString();
                }
                b.b(context).d(PushConstants.PROVIDER_VAID, this.vaid);
            }
            try {
                File file = new File(a.a());
                if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0 && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    String strOptString = "";
                    if (file.exists() && (strF = f.f(file)) != null && strF.length() > 0) {
                        f.f57417a.g("read vaid success");
                        strOptString = new JSONObject(strF).optString(packageName, "");
                    }
                    if (!TextUtils.equals(strOptString, this.vaid)) {
                        e.a(context).e(new IdChangeInfo(PushConstants.PROVIDER_VAID, strOptString, this.vaid));
                    }
                }
            } catch (Exception e11) {
                f.f57417a.i(e11.getMessage());
            }
        } catch (Exception unused3) {
        }
        this.dids = new UniqueIdInfo(context, callback);
        this.user = new UserIdInfo(context);
        this.pkg = new PackageInfo(context);
        this.env = new EnvironInfo(context);
        this.device = new DeviceInfo(context);
        this.f57401fp = new FingerprintInfo(context);
        this.rom = new RomInfo(context);
    }
}
