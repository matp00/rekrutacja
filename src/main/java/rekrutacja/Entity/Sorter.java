package rekrutacja.Entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Sorter {
    private List<Integer> list ;
    private String order;

    public Sorter(List<Integer> list, String order) {
        this.list = list;
        this.order = order;
    }

    public Sorter() {
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Sorter{" +
                "list=" + list +
                ", order='" + order + '\'' +
                '}';
    }
}
