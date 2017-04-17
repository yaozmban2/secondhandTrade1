package org.yu.serviceIml;

import org.springframework.web.multipart.MultipartFile;
import org.yu.entity.GoodsEntity;

import javax.servlet.http.HttpSession;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface GoodsManageService {

    public boolean releaseGoods(HttpSession session, GoodsEntity goods, MultipartFile imgPic);
}
