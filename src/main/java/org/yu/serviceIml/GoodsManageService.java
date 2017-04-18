package org.yu.serviceIml;

import org.springframework.web.multipart.MultipartFile;
import org.yu.entity.GoodsEntity;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
public interface GoodsManageService {

    public boolean releaseGoods(HttpSession session, GoodsEntity goods, MultipartFile imgPic);

    /**
     *   @Description:           通过登录用户的ID查找出其发布的商品
     *   @Author:俞竞雄
     *   @Param:[session]            用户会话的session
     *   @return:List<GoodsEntity>  返回商品集合
     *   @Date:2017-04-18
    */
    public List<GoodsEntity> showMyReleaseGoods(HttpSession session, Integer pageNum);
}
