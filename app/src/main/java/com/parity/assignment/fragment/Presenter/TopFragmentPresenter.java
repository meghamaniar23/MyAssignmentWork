package com.parity.assignment.fragment.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.parity.assignment.R;
import com.parity.assignment.Room.DealsEntity;
import com.parity.assignment.Room.DealsViewModel;
import com.parity.assignment.Utils.Const;
import com.parity.assignment.model.DealsData;
import com.parity.assignment.model.DealsResponse;
import com.parity.assignment.webservice.ApiClient;
import com.parity.assignment.webservice.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class TopFragmentPresenter {

    UpdateView updateView;
    ArrayList<DealsData> dealsList;
    ApiInterface apiInterface;
    private int pageNumber = 1;
    public int perPageEntries = 10;
    private int totalPages;
    public boolean isLoading, isLastPage;
    private int currentFragmentPos;
    private Context context;
    private String dealCategory;
    private DealsViewModel dealsViweModel;

    public TopFragmentPresenter(Context context, UpdateView updateView, int currentFragmentPos, String dealCategory) {
        this.context = context;
        this.updateView = updateView;
        this.currentFragmentPos = currentFragmentPos;
        this.dealCategory = dealCategory;
        dealsViweModel = updateView.getDealsViewModel(dealCategory);
        dealsList = new ArrayList<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        switch (currentFragmentPos){
            case Const.FRAGMENT_TOP_DEALS_POS:
                totalPages = 9;
                break;

            case Const.FRAGMENT_POPULAR_DEALS_POS:
                totalPages = 1;
                break;

            case Const.FRAGMENT_FEATURED_DEALS_POS:
                totalPages = 2;
                break;
        }
    }

    public void getDeals() {
        Call<DealsResponse> call = null;
        switch (currentFragmentPos){
            case Const.FRAGMENT_TOP_DEALS_POS:
                dealCategory =  Const.CATEGORY_TOP_DEALS;
                call = apiInterface.getTopDeals(perPageEntries, pageNumber);
                break;

            case Const.FRAGMENT_POPULAR_DEALS_POS:
                dealCategory =  Const.CATEGORY_POPULAR_DEALS;
                call = apiInterface.getPopularDeals();
                break;

            case Const.FRAGMENT_FEATURED_DEALS_POS:
                dealCategory =  Const.CATEGORY_FEATURED_DEALS;
                call = apiInterface.getFeaturedDeals(perPageEntries, pageNumber);
                break;
        }

        call.enqueue(new Callback<DealsResponse>() {

            @Override
            public void onResponse(Call<DealsResponse> call, retrofit2.Response<DealsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (pageNumber > 1) {
                        updateView.hideLoading();
                        isLoading = false;
                    }
                    if(response.body().getDeals().getData().size() > 0) {
                        /*Insert new data to database*/
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                for(DealsData dealsData : dealsList) {
                                    Log.i("id", String.valueOf(dealsData.getId()));
                                    Log.i("title", dealsData.getTitle());
                                    Log.i("vote", String.valueOf(dealsData.getVoteCount()));
                                    Log.i("comment", String.valueOf(dealsData.getCommentsCount()));
                                    Log.i("date", String.valueOf(dealsData.getCreatedAt()));
                                    Log.i("img", String.valueOf(dealsData.getImage()));
                                    Log.i("cat", String.valueOf(dealCategory));

                                    DealsEntity dealsEntity = new DealsEntity(String.valueOf(dealsData.getId()), dealsData.getTitle(), dealsData.getVoteCount(), dealsData.getCommentsCount(), String.valueOf(dealsData.getCreatedAt()), dealsData.getImage(), dealCategory);
                                    dealsViweModel.insertDeals(dealsEntity);
                                }
                            }
                        });
                        thread.start();
                        dealsList.addAll(response.body().getDeals().getData());
                        updateView.onGetTopDeals(dealsList);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (pageNumber < totalPages) {
                                    updateView.showLoading();
                                } else {
                                    isLastPage = true;
                                }
                            }
                        }, 1500);

                    }else {
                        isLastPage = true;
                    }
                } else{
                    switch (response.code()) {
                        case 404:
                            updateView.displayServerError(context.getResources().getString(R.string.text_resource_not_found));
                            break;
                        case 500:
                            updateView.displayServerError(context.getResources().getString(R.string.text_server_broken));
                            break;
                        default:
                            updateView.displayServerError(context.getResources().getString(R.string.text_unknown_error));
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<DealsResponse> call, Throwable t) {
                if (isLoading) {
                    isLoading = false;
                    updateView.hideLoading();
                }
                Log.e("GET TOP DEALS ERROR", "******* " + t.getMessage());
            }
        });
    }

    /*For Pagination*/

    public void loadMoreItems() {
        if (pageNumber < totalPages) {
            isLoading = true;
            pageNumber++;
            Log.i("PRESENTOR", "******PAGE NO.********* " + pageNumber);
            getDeals();
        }else{
            isLastPage = true;
        }
    }

    public void loadMoreItemsFromDb() {
        if (pageNumber < totalPages) {
            isLoading = true;
            pageNumber++;
            Log.i("PRESENTOR", "******PAGE NO.********* " + pageNumber);
            getDeals();
        }else{
            isLastPage = true;
        }
    }

    public void onRefreshPage() {
        dealsList.clear();
        dealsViweModel.clearDealsTable();
        pageNumber = 1;
        getDeals();
    }

    public interface UpdateView {
        void onGetTopDeals(ArrayList<DealsData> topDealsList);

        void showLoading();

        void hideLoading();

        void displayServerError(String msg);

        DealsViewModel getDealsViewModel(String category);
    }

    public ArrayList<DealsData> getDealsFromDB(String category){
        dealsList.clear();
        dealsViweModel = updateView.getDealsViewModel(category);
        ArrayList<DealsEntity> dealsEntityList = (ArrayList<DealsEntity>) dealsViweModel.getAllDeals();
        for(DealsEntity dealsEntity : dealsEntityList){
            DealsData dealsData = new DealsData(Integer.parseInt(dealsEntity.getId()), dealsEntity.getTitle(), dealsEntity.getLikeCount(), dealsEntity.getCommentsCount(), Long.parseLong(dealsEntity.getDate()), dealsEntity.getImageUrl());
            dealsList.add(dealsData);
        }
        return dealsList;
    }
}
