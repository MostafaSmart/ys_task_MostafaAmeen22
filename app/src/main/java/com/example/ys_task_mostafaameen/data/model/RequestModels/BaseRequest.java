package com.example.ys_task_mostafaameen.data.model.RequestModels;


import com.google.gson.annotations.SerializedName;

public class BaseRequest<T> {
    @SerializedName("Value")
    protected T value;

    public BaseRequest(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
       return "Value { " +
               "value =" + (value != null ? value.toString() : "null") +
               '}';
    }
}
