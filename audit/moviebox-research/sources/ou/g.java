package ou;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberViewModel;
import com.transsion.member.adapter.task.TaskCheckInProvider;
import com.transsion.member.adapter.task.TaskInviteUserProvider;
import com.transsion.member.adapter.task.h;
import com.transsion.member.adapter.task.i;
import com.transsion.member.adapter.task.j;
import com.transsion.member.adapter.task.l;
import com.transsion.member.adapter.task.m;
import com.transsion.member.adapter.task.n;
import com.transsion.member.constants.TaskType;
import com.transsion.memberapi.MemberTaskItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class g extends BaseProviderMultiAdapter<MemberTaskItem> {
    public final Set<Integer> I;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f73426a = f0.a(24.0f);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73427b = f0.a(8.0f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f73428c = f0.a(12.0f);

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            Intrinsics.e(adapter, "null cannot be cast to non-null type com.transsion.member.adapter.TaskAdapter");
            Integer taskSubType = ((g) adapter).getItem(childAdapterPosition).getTaskSubType();
            TaskType taskType = TaskType.TITLE;
            int value = taskType.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                outRect.top = this.f73426a;
            } else if (childAdapterPosition > 0) {
                RecyclerView.Adapter adapter2 = parent.getAdapter();
                Intrinsics.e(adapter2, "null cannot be cast to non-null type com.transsion.member.adapter.TaskAdapter");
                Integer taskSubType2 = ((g) adapter2).getItem(childAdapterPosition - 1).getTaskSubType();
                int value2 = taskType.getValue();
                if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                    outRect.top = this.f73427b;
                } else {
                    outRect.top = this.f73428c;
                }
            }
            if (childAdapterPosition == state.b() - 1) {
                outRect.bottom = f0.a(20.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(u owner, MemberViewModel viewModel, MemberFragment fragment) {
        super(null, 1, null);
        Intrinsics.g(owner, "owner");
        Intrinsics.g(viewModel, "viewModel");
        Intrinsics.g(fragment, "fragment");
        this.I = new LinkedHashSet();
        K0(new l());
        K0(new m(fragment));
        K0(new TaskInviteUserProvider(fragment, viewModel));
        K0(new n(fragment));
        K0(new com.transsion.member.adapter.task.b(fragment));
        K0(new h(fragment));
        K0(new j(fragment));
        K0(new com.transsion.member.adapter.task.c(fragment));
        K0(new com.transsion.member.adapter.task.c(fragment));
        K0(new TaskCheckInProvider(owner, viewModel));
        K0(new i(fragment));
        K0(new com.transsion.member.adapter.task.d(fragment));
        K0(new com.transsion.member.adapter.task.e(fragment));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public void K0(BaseItemProvider<MemberTaskItem> provider) {
        Intrinsics.g(provider, "provider");
        this.I.add(Integer.valueOf(provider.h()));
        super.K0(provider);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends MemberTaskItem> data, int i11) {
        Intrinsics.g(data, "data");
        Integer taskSubType = data.get(i11).getTaskSubType();
        if (taskSubType != null) {
            return taskSubType.intValue();
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void w0(Collection<MemberTaskItem> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection == null) {
            collection = new ArrayList<>();
        }
        for (MemberTaskItem memberTaskItem : collection) {
            if (CollectionsKt___CollectionsKt.X(this.I, memberTaskItem.getTaskSubType())) {
                arrayList.add(memberTaskItem);
            } else {
                uo.b.a.f(uo.b.f78622a, "MemberTask", "task type " + memberTaskItem.getTaskSubType() + " not support", false, 4, null);
            }
        }
        super.w0(arrayList);
    }
}
