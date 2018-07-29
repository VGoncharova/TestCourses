package cources.data;

public class FilterValue {
    String paymentType;
    String paymentValueLimit;

    public FilterValue(String paymentType, String paymentValueLimit) {
        this.paymentType = paymentType;
        this.paymentValueLimit = paymentValueLimit;
    }

    @Override
    public String toString() {
        return "FilterValue{" +
                "paymentType='" + paymentType + '\'' +
                ", paymentValueLimit='" + paymentValueLimit + '\'' +
                '}';
    }
}
