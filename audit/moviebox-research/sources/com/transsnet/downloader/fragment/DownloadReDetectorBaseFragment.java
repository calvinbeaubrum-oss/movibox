package com.transsnet.downloader.fragment;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.util.DocumentsUtils;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n6.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public abstract class DownloadReDetectorBaseFragment<T extends n6.a> extends PageStatusFragment<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DownloadResourcesDetectorViewModel f60692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f60693m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f60696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f60697q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f00.b f60699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b1.b<String[]> f60700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b1.b<Intent> f60701u;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f60691k = getClass().getSimpleName();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f60694n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f60695o = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f60698r = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    public DownloadReDetectorBaseFragment() {
        b1.b bVarRegisterForActivityResult = registerForActivityResult(new c1.h(), new b1.a() { // from class: com.transsnet.downloader.fragment.x
            @Override // b1.a
            public final void a(Object obj) {
                DownloadReDetectorBaseFragment.g1(this.f60978a, (Map) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.f60700t = bVarRegisterForActivityResult;
        b1.b bVarRegisterForActivityResult2 = registerForActivityResult(new c1.j(), new b1.a() { // from class: com.transsnet.downloader.fragment.y
            @Override // b1.a
            public final void a(Object obj) {
                DownloadReDetectorBaseFragment.f1(this.f60981a, (ActivityResult) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult2, "registerForActivityResul…        }\n        }\n    }");
        this.f60701u = bVarRegisterForActivityResult2;
    }

    public static final void f1(DownloadReDetectorBaseFragment this$0, ActivityResult activityResult) {
        Intrinsics.g(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            if (activityResult.getData() != null) {
                Intent data = activityResult.getData();
                Intrinsics.d(data);
                if (data.getData() != null) {
                    uo.b.a aVar = uo.b.f78622a;
                    String TAG = this$0.f60691k;
                    Intrinsics.f(TAG, "TAG");
                    Intent data2 = activityResult.getData();
                    Intrinsics.d(data2);
                    uo.b.a.f(aVar, TAG, "onStoragePermissionGranted------- uri = " + data2.getData(), false, 4, null);
                    DocumentsUtils documentsUtils = DocumentsUtils.f61126a;
                    Application applicationA = Utils.a();
                    String str = this$0.f60695o;
                    Intent data3 = activityResult.getData();
                    Intrinsics.d(data3);
                    Uri data4 = data3.getData();
                    Intrinsics.d(data4);
                    documentsUtils.l(applicationA, str, data4);
                    FragmentActivity fragmentActivityRequireActivity = this$0.requireActivity();
                    String packageName = this$0.requireActivity().getPackageName();
                    Intent data5 = activityResult.getData();
                    Intrinsics.d(data5);
                    Uri data6 = data5.getData();
                    Intrinsics.d(data6);
                    fragmentActivityRequireActivity.grantUriPermission(packageName, data6, 3);
                    ContentResolver contentResolver = this$0.requireActivity().getContentResolver();
                    Intent data7 = activityResult.getData();
                    Intrinsics.d(data7);
                    Uri data8 = data7.getData();
                    Intrinsics.d(data8);
                    contentResolver.takePersistableUriPermission(data8, 3);
                    this$0.f60697q = true;
                    this$0.b1();
                    return;
                }
            }
            this$0.f60697q = false;
        }
    }

    public static final void g1(DownloadReDetectorBaseFragment this$0, Map permissions) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(permissions, "permissions");
        boolean z11 = true;
        for (Map.Entry entry : permissions.entrySet()) {
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this$0.f60691k;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "registerForActivityResult Granted = " + entry.getValue(), false, 4, null);
            if (!((Boolean) entry.getValue()).booleanValue()) {
                z11 = false;
            }
        }
        if (z11) {
            uo.b.a aVar2 = uo.b.f78622a;
            String TAG2 = this$0.f60691k;
            Intrinsics.f(TAG2, "TAG");
            uo.b.a.f(aVar2, TAG2, "授权成功", false, 4, null);
            this$0.d1();
            return;
        }
        uo.b.a aVar3 = uo.b.f78622a;
        String TAG3 = this$0.f60691k;
        Intrinsics.f(TAG3, "TAG");
        uo.b.a.f(aVar3, TAG3, "授权失败", false, 4, null);
        this$0.c1();
    }

    public void S0() {
        Fragment parentFragment = getParentFragment();
        DownloadReDetectorMainDialog downloadReDetectorMainDialog = parentFragment instanceof DownloadReDetectorMainDialog ? (DownloadReDetectorMainDialog) parentFragment : null;
        if (downloadReDetectorMainDialog != null) {
            downloadReDetectorMainDialog.dismissAllowingStateLoss();
        }
    }

    public int T0() {
        return getResources().getDisplayMetrics().heightPixels - ((com.blankj.utilcode.util.d0.e() * 9) / 16);
    }

    public final com.transsnet.downloader.manager.a U0() {
        return (com.transsnet.downloader.manager.a) this.f60698r.getValue();
    }

    public int V0() {
        return T0() - com.blankj.utilcode.util.f0.a(116.0f);
    }

    public final b1.b<String[]> W0() {
        return this.f60700t;
    }

    public final String X0() {
        return this.f60691k;
    }

    public final DownloadResourcesDetectorViewModel Y0() {
        return this.f60692l;
    }

    public final boolean Z0() {
        return this.f60694n;
    }

    public boolean a1(long j11) {
        long jA;
        f00.b bVar = this.f60699s;
        if (bVar == null) {
            DownloadEsHelper.a aVar = DownloadEsHelper.f60994m;
            aVar.a().e();
            String strO = aVar.a().o();
            if (strO.length() == 0) {
                return false;
            }
            try {
                jA = com.blankj.utilcode.util.m.l(strO);
            } catch (Throwable unused) {
                return false;
            }
        } else {
            Intrinsics.d(bVar);
            jA = bVar.a();
        }
        Long lX = U0().x();
        if (j11 + (lX != null ? lX.longValue() : 0L) < jA) {
            return false;
        }
        zp.b.f82110a.d(R$string.insufficient_storage_available);
        uo.b.f78622a.m("--- 可用存储空间不足，释放空间并重试 ---", true);
        return true;
    }

    public void b1() {
    }

    public void c1() {
    }

    public void d1() {
    }

    public void e1() {
    }

    public final void h1(f00.b bVar) {
        this.f60699s = bVar;
    }

    public final void i1(boolean z11) {
        this.f60694n = z11;
    }

    public final void j1(boolean z11) {
        this.f60693m = z11;
    }

    public final void k1(DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel) {
        this.f60692l = downloadResourcesDetectorViewModel;
    }

    public final void l1() {
        try {
            Intent intent = null;
            if (Build.VERSION.SDK_INT >= 24) {
                FragmentActivity activity = getActivity();
                Intrinsics.d(activity);
                StorageVolume storageVolume = ((StorageManager) activity.getSystemService(StorageManager.class)).getStorageVolume(new File(this.f60695o));
                if (storageVolume != null) {
                    intent = storageVolume.createAccessIntent(null);
                }
            }
            if (intent == null) {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            }
            this.f60701u.a(intent);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final boolean m1() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return false;
        }
        if (this.f60696p) {
            return !this.f60697q;
        }
        this.f60696p = true;
        if (i11 <= 28) {
            String strB = "";
            for (f00.e eVar : DownloadSDCardUtil.f61130a.b()) {
                if (eVar.c()) {
                    strB = eVar.b();
                    this.f60695o = strB;
                }
            }
            uo.b.a aVar = uo.b.f78622a;
            String TAG = this.f60691k;
            Intrinsics.f(TAG, "TAG");
            uo.b.a.f(aVar, TAG, "onStoragePermissionGranted，1  sdRootPath = " + strB, false, 4, null);
            if (strB.length() > 0) {
                DocumentsUtils documentsUtils = DocumentsUtils.f61126a;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                boolean zD = documentsUtils.d(applicationA, strB);
                String TAG2 = this.f60691k;
                Intrinsics.f(TAG2, "TAG");
                uo.b.a.f(aVar, TAG2, " check other permission, showOpenDocumentTree = " + zD, false, 4, null);
                if (zD) {
                    this.f60697q = false;
                    return true;
                }
            }
        }
        this.f60697q = true;
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f60694n = RoomAppMMKV.f51271a.a().getBoolean("download_root_path_permission_first", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f60693m) {
            this.f60693m = false;
            e1();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        Fragment parentFragment = getParentFragment();
        DownloadReDetectorMainDialog downloadReDetectorMainDialog = parentFragment instanceof DownloadReDetectorMainDialog ? (DownloadReDetectorMainDialog) parentFragment : null;
        if (downloadReDetectorMainDialog != null) {
            this.f60692l = (DownloadResourcesDetectorViewModel) new androidx.lifecycle.v0(downloadReDetectorMainDialog).a(DownloadResourcesDetectorViewModel.class);
        }
        super.onViewCreated(view, bundle);
    }
}
