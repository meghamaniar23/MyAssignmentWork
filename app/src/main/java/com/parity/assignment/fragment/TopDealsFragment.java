package com.parity.assignment.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.parity.assignment.CustomListeners.PaginationListener;
import com.parity.assignment.R;
import com.parity.assignment.Room.DealsViewModel;
import com.parity.assignment.Utils.Const;
import com.parity.assignment.adaptor.DealsAdapter;
import com.parity.assignment.fragment.Presenter.TopFragmentPresenter;
import com.parity.assignment.model.DealsData;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class TopDealsFragment extends BaseFragment implements TopFragmentPresenter.UpdateView {

    private RecyclerView rcvDeals;
    private DealsAdapter dealsAdapter;
    private TopFragmentPresenter topFragmentPresenter;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deals, container, false);
        rcvDeals = view.findViewById(R.id.rcvDeals);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        topFragmentPresenter = new TopFragmentPresenter(activity, this, 0, Const.CATEGORY_TOP_DEALS);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                topFragmentPresenter.onRefreshPage();
            }
        });

        /*if(!isNetworkAvailable()) {
            ArrayList<DealsData> dealsDataList = topFragmentPresenter.getDealsFromDB(Const.CATEGORY_TOP_DEALS);
            if (dealsDataList != null && dealsDataList.size() > 0) {
                onGetTopDeals(dealsDataList);
            } else {
                Toast.makeText(activity, activity.getResources().getString(R.string.text_error_no_offline_data), Toast.LENGTH_SHORT).show();
            }
        }else{*/
        topFragmentPresenter.getDeals();
//        }


        if (linearLayoutManager == null) {
            linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        }
        rcvDeals.addOnScrollListener(new PaginationListener(linearLayoutManager, topFragmentPresenter.perPageEntries) {
            @Override
            public void loadMoreItems() {
                topFragmentPresenter.loadMoreItems();
            }

            @Override
            public boolean isLoading() {
                return topFragmentPresenter.isLoading;
            }

            @Override
            public boolean isLastPage() {
                return topFragmentPresenter.isLastPage;
            }
        });
    }

    @Override
    public void onGetTopDeals(ArrayList<DealsData> topDealsList) {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (dealsAdapter == null) {
            dealsAdapter = new DealsAdapter(activity, topDealsList);
            rcvDeals.setLayoutManager(linearLayoutManager);
            rcvDeals.setAdapter(dealsAdapter);
        } else {
            dealsAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showLoading() {
        dealsAdapter.showLoading();
    }

    @Override
    public void hideLoading() {
        dealsAdapter.hideLoading();
    }

    @Override
    public void displayServerError(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public DealsViewModel getDealsViewModel(String category) {
        return dealsViweModel;
    }
}
