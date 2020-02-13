package com.parity.assignment.Room;

import android.app.Application;

import java.util.List;

public class DealsRepository {
    private DealsDAO dealsDAO;
    private List<DealsEntity> dealsList;

    DealsRepository(Application application, String category) {
        DealsDatabase db = DealsDatabase.getDatabase(application);
        dealsDAO = db.dealsDAO();
        dealsList = dealsDAO.getDeals(category);
    }

    List<DealsEntity> getAllDeals(String category) {
        return dealsList;
    }

    void insertDeals(final DealsEntity dealsEntity) {
        DealsDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dealsDAO.insert(dealsEntity);
            }
        });
    }

    void clearTable(){
        dealsDAO.clearTable();
    }
}

