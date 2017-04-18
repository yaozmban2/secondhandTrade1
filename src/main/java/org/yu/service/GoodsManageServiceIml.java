package org.yu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.yu.dao.SHTDao;
import org.yu.entity.GoodsEntity;
import org.yu.entity.UserEntity;
import org.yu.serviceIml.GoodsManageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author:俞竞雄
 * @Description:
 * @Date: ${date}
 */
@Service(value = "goodsManageServiceIml")
public class GoodsManageServiceIml implements GoodsManageService {

    @Resource(name = "shtDao")
    private SHTDao shtDao;

    public boolean releaseGoods(HttpSession session, GoodsEntity goods, MultipartFile imgPic) {

        UserEntity user = null;

        //已经登录的情况
        if (session.getAttribute("user") != null)
        {
            user = (UserEntity) session.getAttribute("user");

            //存储商品图片
            //存储图片文件夹的物理路径
            String picPath = "E:\\secondhandTrade2\\image\\goods";
            //原始名称
            String originalFileName = imgPic.getOriginalFilename();
            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
            //获得日期
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //新图片的物理路径
            String newPicPath = picPath + "\\" + date + "\\" + newFileName;
            //新图片
            File newFile = new File(newPicPath);
            //创建每日对应的文件夹
            newFile.getParentFile().mkdir();
            //将内存中的数据写入磁盘
            try {
                imgPic.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //将图片路径放到goods对象中去
            //获得旧文件的物理路径
            goods.setImage("/goods/" + date + "/" + newFileName);

            //将商品所有者ID添加进goods对象
            goods.setProducterId(user.getId());
            goods.setUserName(user.getName());
            //将商品创建日期添加进goods对象
            Date createDate = new Date();
            goods.setCreateDate(createDate);
            //设置商品状态为在售
            goods.setStatus(2);

            //将商品数据放入到数据库中
            shtDao.insertGoods(goods);

            return true;
        }else {
            return false;
        }

    }

    public List<GoodsEntity> showMyReleaseGoods(HttpSession session, Integer pageNum) {

        UserEntity user = null;
        List<GoodsEntity> list = null;

        if (session.getAttribute("user") != null)
        {
            //将新的分页值存入session中以便查询上下页
            session.setAttribute("pageNum", pageNum);
            user = (UserEntity) session.getAttribute("user");
            //获得分页的商品列表
            list = shtDao.selectMyRealseGoodsInfo(user.getId(), pageNum);
        }

        return list;
    }
}
