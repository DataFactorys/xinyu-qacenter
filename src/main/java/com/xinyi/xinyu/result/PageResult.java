package com.xinyi.xinyu.result;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 10067610 on 16/9/8.
 */
public class PageResult<T> implements Serializable {

    /** 当前页 */
    private int pageNum;

    /** 每页的数量 */
    private int pageSize;

    /** 总记录数 */
    private long total;

    /** 总页数 */
    private int pages;

    /** 是否有前一页 */
    private boolean hasPreviousPage = false;

    /** 是否有下一页 */
    private boolean hasNextPage = false;

    /** 结果集 */
    private List<T> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
