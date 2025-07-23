package com.distribution.app.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pager {
    private int nowPage;
    private int start;
    private int end;
    private boolean endCheck;

    private int searchCount;
    private String search = "";
    private String kind = "";

    public Pager(int nowPage, int totalCount, int size) {

        int pageGroupSize = 5;
        this.nowPage = nowPage;
        this.start = ((nowPage - 1) / pageGroupSize) * pageGroupSize + 1;
        int totalPageCount = (int) Math.ceil((double) totalCount / size);
        this.end = Math.min(start + pageGroupSize - 1, (int)Math.ceil((double) totalCount / size));
        this.endCheck = nowPage >= totalPageCount; 
    }
}
