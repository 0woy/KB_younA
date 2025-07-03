package org.scoula.common.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Page<T> {
    private int totalCount; // 전체 데이터 건수
    private int totalPage;

    @JsonIgnore
    private PageRequest pageRequest;
    private List<T> list;

    public static <T> Page of(PageRequest pageRequest, int totalCount, List<T> list) {
        int totalPage = (int) Math.ceil((double) totalCount / pageRequest.getAmount()); // 전체 페이지 수
        return new Page(totalCount, totalPage, pageRequest, list);
    }

    public int getPageNum() {
        return pageRequest.getPage();
    }

    public int getAmount() {
        return pageRequest.getAmount();
    }

}
