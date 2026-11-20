package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<byte[]> f7809a = new Comparator() { // from class: androidx.core.provider.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return d.g((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f7810a;

        public b(Context context, Uri uri) {
            this.f7810a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.d.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f7810a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e11) {
                Log.w("FontsProvider", "Unable to query the content provider", e11);
                return null;
            }
        }

        @Override // androidx.core.provider.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f7810a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentProviderClient f7811a;

        public c(Context context, Uri uri) {
            this.f7811a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.d.a
        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f7811a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e11) {
                Log.w("FontsProvider", "Unable to query the content provider", e11);
                return null;
            }
        }

        @Override // androidx.core.provider.d.a
        public void close() {
            ContentProviderClient contentProviderClient = this.f7811a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    public static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> d(e eVar, Resources resources) {
        return eVar.b() != null ? eVar.b() : b3.e.c(resources, eVar.c());
    }

    @NonNull
    public static g.a e(@NonNull Context context, @NonNull e eVar, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), eVar, context.getResources());
        return providerInfoF == null ? g.a.a(1, null) : g.a.a(0, h(context, eVar, providerInfoF.authority, cancellationSignal));
    }

    @Nullable
    public static ProviderInfo f(@NonNull PackageManager packageManager, @NonNull e eVar, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String strE = eVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(eVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + eVar.f());
        }
        List<byte[]> listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f7809a);
        List<List<byte[]>> listD = d(eVar, resources);
        for (int i11 = 0; i11 < listD.size(); i11++) {
            ArrayList arrayList = new ArrayList(listD.get(i11));
            Collections.sort(arrayList, f7809a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            byte b12 = bArr2[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00fa  */
    @NonNull
    public static g.b[] h(Context context, e eVar, String str, CancellationSignal cancellationSignal) throws Throwable {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme(AppLovinEventTypes.USER_VIEWED_CONTENT).authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme(AppLovinEventTypes.USER_VIEWED_CONTENT).authority(str).appendPath("file").build();
        a aVarA = androidx.core.provider.c.a(context, uriBuild);
        Cursor cursor = null;
        try {
            int i11 = 1;
            Cursor cursorA = aVarA.a(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{eVar.g()}, null, cancellationSignal);
            if (cursorA != null) {
                try {
                    if (cursorA.getCount() > 0) {
                        int columnIndex = cursorA.getColumnIndex("result_code");
                        ArrayList arrayList3 = new ArrayList();
                        int columnIndex2 = cursorA.getColumnIndex("_id");
                        int columnIndex3 = cursorA.getColumnIndex("file_id");
                        int columnIndex4 = cursorA.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorA.getColumnIndex("font_weight");
                        int columnIndex6 = cursorA.getColumnIndex("font_italic");
                        while (cursorA.moveToNext()) {
                            int i12 = columnIndex != -1 ? cursorA.getInt(columnIndex) : 0;
                            arrayList3.add(g.b.a(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorA.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorA.getLong(columnIndex3)), columnIndex4 != -1 ? cursorA.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorA.getInt(columnIndex5) : LogSeverity.WARNING_VALUE, columnIndex6 != -1 && cursorA.getInt(columnIndex6) == i11, i12));
                            i11 = 1;
                        }
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorA;
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVarA.close();
                    throw th;
                }
            } else {
                arrayList = arrayList2;
            }
            if (cursorA != null) {
                cursorA.close();
            }
            aVarA.close();
            return (g.b[]) arrayList.toArray(new g.b[0]);
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
