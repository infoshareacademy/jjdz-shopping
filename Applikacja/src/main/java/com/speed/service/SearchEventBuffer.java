package com.speed.service;

import com.speed.model.SearchEvent;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slawekskel on 7/21/16.
 */
@Stateless
public class SearchEventBuffer {

    private List<SearchEvent> buffer = new ArrayList<>();;
    private boolean reportAppON;


    public SearchEventBuffer() {

        reportAppON = true;
    }

    public List<SearchEvent> getBuffer() {
        return buffer;
    }

    public void setBuffer(SearchEvent thisbuffer) {
        this.buffer.add(thisbuffer);
    }

    public boolean wasReportAppON() {
        return reportAppON;
    }

    public void setReportAppON(boolean reportAppON) {
        this.reportAppON = reportAppON;
    }


    public void deleteBuffer() {
        this.buffer.clear();
    }

    @Override
    public String toString() {
        return "SearchEventBuffer{" +
                "buffer=" + buffer +
                ", reportAppON=" + reportAppON +
                '}';
    }
}
