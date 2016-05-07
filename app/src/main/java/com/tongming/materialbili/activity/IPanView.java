package com.tongming.materialbili.activity;

import com.tongming.materialbili.model.Comment;
import com.tongming.materialbili.model.Contract;
import com.tongming.materialbili.model.PanDetail;

/**
 * Created by Tongming on 2016/5/7.
 */
public interface IPanView {
    void onGetPanDetail(PanDetail detail);
    void onGetPanComment(Comment comment);
    void onGetPanContract(Contract contract);
}
