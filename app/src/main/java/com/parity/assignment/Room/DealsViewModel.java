package com.parity.assignment.Room;

import android.app.Application;

import com.parity.assignment.Utils.Const;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;

public class DealsViewModel extends AndroidViewModel {
    private DealsRepository dealsRepository;

    private List<DealsEntity> dealsList;
    private Application application;

    public DealsViewModel(Application application) {
        super(application);
        this.application = application;
    }


    public List<DealsEntity> getAllDeals()
    {
        dealsRepository = new DealsRepository(application, Const.CURRENT_DEALS_CATEGORY);
        dealsList = dealsRepository.getAllDeals(Const.CURRENT_DEALS_CATEGORY);
        return dealsList;
    }


    public void insertDeals(DealsEntity dealsEntity)
    {
        dealsRepository = new DealsRepository(application, Const.CURRENT_DEALS_CATEGORY);
        dealsRepository.insertDeals(dealsEntity);
    }

    public void clearDealsTable()
    {
        dealsRepository = new DealsRepository(application, Const.CURRENT_DEALS_CATEGORY);
        dealsRepository.clearTable();
    }
}
