package com.util;

import java.io.Serializable;
import java.util.List;


public class PageUtils implements Serializable {
    private static final long serialVersionUID = -1202716581589799959L;

    //�ܼ�¼��
    private int totalCount;
    //ÿҳ��¼��
    private int pageSize;
    //��ҳ��
    private int totalPage;
    //��ǰҳ��
    private int currPage;
    //�б�����
    private List<?> list;

    /**
     * ��ҳ
     * @param list        �б�����
     * @param totalCount  �ܼ�¼��
     * @param pageSize    ÿҳ��¼��
     * @param currPage    ��ǰҳ��
     */
    public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }
}
