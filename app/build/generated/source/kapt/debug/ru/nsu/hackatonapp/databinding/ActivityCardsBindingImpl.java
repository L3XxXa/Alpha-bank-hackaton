package ru.nsu.hackatonapp.databinding;
import ru.nsu.hackatonapp.R;
import ru.nsu.hackatonapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCardsBindingImpl extends ActivityCardsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.user_email, 2);
        sViewsWithIds.put(R.id.logout, 3);
        sViewsWithIds.put(R.id.createCard, 4);
        sViewsWithIds.put(R.id.refresh_cards, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCardsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityCardsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (android.widget.Button) bindings[4]
            , (android.widget.ImageButton) bindings[3]
            , (android.widget.Button) bindings[5]
            , (android.widget.TextView) bindings[2]
            );
        this.cardsGrid.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((ru.nsu.hackatonapp.domain.viewmodels.CardsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable ru.nsu.hackatonapp.domain.viewmodels.CardsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCards((androidx.lifecycle.LiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCards(androidx.lifecycle.LiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> ViewModelCards, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.util.List<ru.nsu.hackatonapp.network.json.card.Card> viewModelCardsGetValue = null;
        androidx.lifecycle.LiveData<java.util.List<ru.nsu.hackatonapp.network.json.card.Card>> viewModelCards = null;
        ru.nsu.hackatonapp.domain.viewmodels.CardsViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.cards
                    viewModelCards = viewModel.getCards();
                }
                updateLiveDataRegistration(0, viewModelCards);


                if (viewModelCards != null) {
                    // read viewModel.cards.getValue()
                    viewModelCardsGetValue = viewModelCards.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            ru.nsu.hackatonapp.adapters.BindingAdapterKt.bindRecycleView(this.cardsGrid, viewModelCardsGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.cards
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}