
package com.parity.assignment.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deals {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("data")
    @Expose
    private List<DealsData> data = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<DealsData> getData() {
        return data;
    }

    public void setData(List<DealsData> data) {
        this.data = data;
    }

}
