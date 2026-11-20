package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;

    @NonNull
    private final f mCompat;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {

        @NonNull
        private final c mBuilderCompat;

        public Builder(@NonNull ClipData clipData, int i11) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(clipData, i11);
            } else {
                this.mBuilderCompat = new d(clipData, i11);
            }
        }

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(contentInfoCompat);
            } else {
                this.mBuilderCompat = new d(contentInfoCompat);
            }
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            this.mBuilderCompat.c(clipData);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mBuilderCompat.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder setFlags(int i11) {
            this.mBuilderCompat.setFlags(i11);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            this.mBuilderCompat.b(uri);
            return this;
        }

        @NonNull
        public Builder setSource(int i11) {
            this.mBuilderCompat.a(i11);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class a {
        @NonNull
        public static Pair<ContentInfo, ContentInfo> a(@NonNull ContentInfo contentInfo, @NonNull final Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() == 1) {
                boolean zTest = predicate.test(clip.getItemAt(0));
                ContentInfo contentInfo2 = zTest ? contentInfo : null;
                if (zTest) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair<ClipData, ClipData> pairPartition = ContentInfoCompat.partition(clip, (androidx.core.util.j<ClipData.Item>) new androidx.core.util.j() { // from class: androidx.core.view.b
                @Override // androidx.core.util.j
                public final boolean test(Object obj) {
                    return predicate.test((ClipData.Item) obj);
                }
            });
            if (pairPartition.first == null) {
                return Pair.create(null, contentInfo);
            }
            return pairPartition.second == null ? Pair.create(contentInfo, null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) pairPartition.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) pairPartition.second).build());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final ContentInfo.Builder f7899a;

        public b(@NonNull ClipData clipData, int i11) {
            this.f7899a = i.a(clipData, i11);
        }

        public b(@NonNull ContentInfoCompat contentInfoCompat) {
            k.a();
            this.f7899a = j.a(contentInfoCompat.toContentInfo());
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(int i11) {
            this.f7899a.setSource(i11);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void b(@Nullable Uri uri) {
            this.f7899a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new e(this.f7899a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void c(@NonNull ClipData clipData) {
            this.f7899a.setClip(clipData);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(@Nullable Bundle bundle) {
            this.f7899a.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setFlags(int i11) {
            this.f7899a.setFlags(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(int i11);

        void b(@Nullable Uri uri);

        @NonNull
        ContentInfoCompat build();

        void c(@NonNull ClipData clipData);

        void setExtras(@Nullable Bundle bundle);

        void setFlags(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public ClipData f7900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Uri f7903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public Bundle f7904e;

        public d(@NonNull ClipData clipData, int i11) {
            this.f7900a = clipData;
            this.f7901b = i11;
        }

        public d(@NonNull ContentInfoCompat contentInfoCompat) {
            this.f7900a = contentInfoCompat.getClip();
            this.f7901b = contentInfoCompat.getSource();
            this.f7902c = contentInfoCompat.getFlags();
            this.f7903d = contentInfoCompat.getLinkUri();
            this.f7904e = contentInfoCompat.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void a(int i11) {
            this.f7901b = i11;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void b(@Nullable Uri uri) {
            this.f7903d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new g(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void c(@NonNull ClipData clipData) {
            this.f7900a = clipData;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setExtras(@Nullable Bundle bundle) {
            this.f7904e = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.c
        public void setFlags(int i11) {
            this.f7902c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final ContentInfo f7905a;

        public e(@NonNull ContentInfo contentInfo) {
            this.f7905a = androidx.core.view.a.a(androidx.core.util.i.g(contentInfo));
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int a() {
            return this.f7905a.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public Uri b() {
            return this.f7905a.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ContentInfo c() {
            return this.f7905a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ClipData d() {
            return this.f7905a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public Bundle getExtras() {
            return this.f7905a.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            return this.f7905a.getFlags();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.f7905a + "}";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        int a();

        @Nullable
        Uri b();

        @Nullable
        ContentInfo c();

        @NonNull
        ClipData d();

        @Nullable
        Bundle getExtras();

        int getFlags();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final ClipData f7906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7908c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Uri f7909d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final Bundle f7910e;

        public g(d dVar) {
            this.f7906a = (ClipData) androidx.core.util.i.g(dVar.f7900a);
            this.f7907b = androidx.core.util.i.c(dVar.f7901b, 0, 5, "source");
            this.f7908c = androidx.core.util.i.f(dVar.f7902c, 1);
            this.f7909d = dVar.f7903d;
            this.f7910e = dVar.f7904e;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int a() {
            return this.f7907b;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public Uri b() {
            return this.f7909d;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @NonNull
        public ClipData d() {
            return this.f7906a;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        @Nullable
        public Bundle getExtras() {
            return this.f7910e;
        }

        @Override // androidx.core.view.ContentInfoCompat.f
        public int getFlags() {
            return this.f7908c;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f7906a.getDescription());
            sb2.append(", source=");
            sb2.append(ContentInfoCompat.sourceToString(this.f7907b));
            sb2.append(", flags=");
            sb2.append(ContentInfoCompat.flagsToString(this.f7908c));
            if (this.f7909d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f7909d.toString().length() + ")";
            }
            sb2.append(str);
            sb2.append(this.f7910e != null ? ", hasExtras" : "");
            sb2.append("}");
            return sb2.toString();
        }
    }

    public ContentInfoCompat(@NonNull f fVar) {
        this.mCompat = fVar;
    }

    @NonNull
    public static ClipData buildClipData(@NonNull ClipDescription clipDescription, @NonNull List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i11 = 1; i11 < list.size(); i11++) {
            clipData.addItem(list.get(i11));
        }
        return clipData;
    }

    @NonNull
    public static String flagsToString(int i11) {
        return (i11 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i11);
    }

    @NonNull
    public static Pair<ClipData, ClipData> partition(@NonNull ClipData clipData, @NonNull androidx.core.util.j<ClipData.Item> jVar) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i11 = 0; i11 < clipData.getItemCount(); i11++) {
            ClipData.Item itemAt = clipData.getItemAt(i11);
            if (jVar.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create(null, clipData);
        }
        return arrayList2 == null ? Pair.create(clipData, null) : Pair.create(buildClipData(clipData.getDescription(), arrayList), buildClipData(clipData.getDescription(), arrayList2));
    }

    @NonNull
    @RequiresApi(VungleException.WEB_CRASH)
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
        return a.a(contentInfo, predicate);
    }

    @NonNull
    public static String sourceToString(int i11) {
        if (i11 == 0) {
            return "SOURCE_APP";
        }
        if (i11 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i11 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i11 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i11 != 4) {
            return i11 != 5 ? String.valueOf(i11) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    @NonNull
    @RequiresApi(VungleException.WEB_CRASH)
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new e(contentInfo));
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.d();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.b();
    }

    public int getSource() {
        return this.mCompat.a();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.j<ClipData.Item> jVar) {
        ClipData clipDataD = this.mCompat.d();
        if (clipDataD.getItemCount() == 1) {
            boolean zTest = jVar.test(clipDataD.getItemAt(0));
            return Pair.create(zTest ? this : null, zTest ? null : this);
        }
        Pair<ClipData, ClipData> pairPartition = partition(clipDataD, jVar);
        if (pairPartition.first == null) {
            return Pair.create(null, this);
        }
        return pairPartition.second == null ? Pair.create(this, null) : Pair.create(new Builder(this).setClip((ClipData) pairPartition.first).build(), new Builder(this).setClip((ClipData) pairPartition.second).build());
    }

    @NonNull
    @RequiresApi(VungleException.WEB_CRASH)
    public ContentInfo toContentInfo() {
        ContentInfo contentInfoC = this.mCompat.c();
        Objects.requireNonNull(contentInfoC);
        return androidx.core.view.a.a(contentInfoC);
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }
}
