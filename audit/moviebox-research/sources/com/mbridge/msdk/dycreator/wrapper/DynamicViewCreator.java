package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.b.a;
import com.mbridge.msdk.dycreator.e.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DynamicViewCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DynamicViewCreator f43735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f43736b = -201;

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43737a;

        static {
            int[] iArr = new int[DyAdType.values().length];
            f43737a = iArr;
            try {
                iArr[DyAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43737a[DyAdType.REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private DynamicViewCreator() {
        b.a().a(c.m().c());
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        int i11 = 0;
        ViewGroup viewGroup = null;
        int i12 = 0;
        while (i12 < fileDirs.size()) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i12))) {
                    if (i12 == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i12));
                    } else {
                        String str = fileDirs.get(i12);
                        if (context != null && viewGroup != null && !TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String string = jSONObject.getString("folder_dir");
                                if (!TextUtils.isEmpty(string)) {
                                    JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
                                    if (jSONArray.length() != 0) {
                                        int i13 = 0;
                                        while (i13 < jSONArray.length()) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i13);
                                            if (jSONObject2 != null) {
                                                View viewA = f.a(context).a(string + File.separator + jSONObject2.optString("name"));
                                                if (viewA != null) {
                                                    JSONObject jSONObject3 = jSONObject2.getJSONObject(TtmlNode.TAG_LAYOUT);
                                                    if (jSONObject3 != null) {
                                                        try {
                                                            String strOptString = jSONObject3.optString("parent_id");
                                                            ViewGroup viewGroup2 = !TextUtils.isEmpty(strOptString) ? (ViewGroup) f.a(context).a(viewGroup, strOptString) : viewGroup;
                                                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
                                                            if (layoutParams != null) {
                                                                String strOptString2 = jSONObject3.optString("below", "");
                                                                if (!TextUtils.isEmpty(strOptString2)) {
                                                                    layoutParams.addRule(3, strOptString2.hashCode());
                                                                }
                                                                String strOptString3 = jSONObject3.optString("left_of", "");
                                                                if (!TextUtils.isEmpty(strOptString3)) {
                                                                    layoutParams.addRule(i11, strOptString3.hashCode());
                                                                }
                                                                String strOptString4 = jSONObject3.optString("right_of", "");
                                                                if (!TextUtils.isEmpty(strOptString4)) {
                                                                    layoutParams.addRule(1, strOptString4.hashCode());
                                                                }
                                                                int iOptInt = jSONObject3.optInt("index", -2);
                                                                int iOptInt2 = jSONObject3.optInt("visibility", -1);
                                                                if (iOptInt2 != -1) {
                                                                    viewA.setVisibility(iOptInt2);
                                                                }
                                                                if (iOptInt != -2) {
                                                                    viewGroup2.addView(viewA, iOptInt, layoutParams);
                                                                } else {
                                                                    viewGroup2.addView(viewA, layoutParams);
                                                                }
                                                            }
                                                        } catch (Exception e11) {
                                                            ad.b("DynamicViewCreator", e11.getMessage());
                                                        }
                                                    } else {
                                                        viewGroup.addView(viewA, 3);
                                                    }
                                                }
                                            }
                                            i13++;
                                            i11 = 0;
                                        }
                                    }
                                }
                            } catch (Exception e12) {
                                ad.b("DynamicViewCreator", e12.getMessage());
                            }
                        }
                    }
                }
                i12++;
                i11 = 0;
            } catch (Exception e13) {
                ad.b("DynamicViewCreator", e13.getMessage());
            }
        }
        return viewGroup;
    }

    public static DynamicViewCreator getInstance() {
        if (f43735a == null) {
            synchronized (DynamicViewCreator.class) {
                try {
                    if (f43735a == null) {
                        f43735a = new DynamicViewCreator();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43735a;
    }

    public View createDynamicView(DyOption dyOption) {
        Context contextC;
        if (dyOption == null || (contextC = c.m().c()) == null) {
            return null;
        }
        return a(contextC, dyOption);
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        boolean z11;
        BaseViewModel mBSplashViewVModel;
        BaseViewModel mBCommonViewVModel;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_DYNAMIC_OPTION));
            return;
        }
        if (dynamicViewBackListener == null) {
            return;
        }
        Context contextC = c.m().c();
        if (contextC == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CONTEXT));
            return;
        }
        if (dyOption.getCampaignEx() == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.NOT_FOUND_CAMPAIGN));
            z11 = false;
        } else {
            z11 = true;
        }
        if (dyOption.getFile() == null && dyOption.getFileDirs() != null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.BIND_DATA_FILE_OR_DIR));
            return;
        }
        if (z11) {
            try {
                View viewA = a(contextC, dyOption);
                if (viewA == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.b.b.FILE_CREATE_VIEW_FILE));
                    return;
                }
                int i11 = AnonymousClass1.f43737a[dyOption.getDyAdType().ordinal()];
                if (i11 != 1) {
                    if (i11 != 2) {
                        mBCommonViewVModel = new MBCommonViewVModel();
                    } else {
                        mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                    }
                    mBCommonViewVModel.setDynamicViewBackListener(dynamicViewBackListener);
                    com.mbridge.msdk.dycreator.binding.b.a().a(mBCommonViewVModel);
                    mBCommonViewVModel.setModelDataAndBind();
                    dynamicViewBackListener.viewCreatedSuccess(viewA);
                }
                mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                mBCommonViewVModel = mBSplashViewVModel;
                mBCommonViewVModel.setDynamicViewBackListener(dynamicViewBackListener);
                com.mbridge.msdk.dycreator.binding.b.a().a(mBCommonViewVModel);
                mBCommonViewVModel.setModelDataAndBind();
                dynamicViewBackListener.viewCreatedSuccess(viewA);
            } catch (Exception e11) {
                ad.b("DynamicViewCreator", e11.getMessage());
                dynamicViewBackListener.viewCreateFail(new a(f43736b, e11.getMessage()));
            }
        }
    }
}
