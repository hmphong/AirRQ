
package com.example.airrq.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class O3 {

    @SerializedName("v")
    @Expose
    private Double v;

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

}
