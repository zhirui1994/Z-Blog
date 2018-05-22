package com.zhirui.zblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zhirui.zblog.constant.WebConst;
import com.zhirui.zblog.controller.BaseController;
import com.zhirui.zblog.dto.Types;
import com.zhirui.zblog.model.Bo.ResetResponseBo;
import com.zhirui.zblog.model.Vo.ContentVo;
import com.zhirui.zblog.model.Vo.ContentVoExample;
import com.zhirui.zblog.model.Vo.MetaVo;
import com.zhirui.zblog.model.Vo.UserVo;
import com.zhirui.zblog.service.ContentService;
import com.zhirui.zblog.service.MetaService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "admin/article")
public class ArticleController extends BaseController {
    @Resource
    private ContentService contentService;

    @Resource
    private MetaService metaService;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit,
                        HttpServletRequest request) {
        ContentVoExample contentVoExample = new ContentVoExample();
        contentVoExample.setOrderByClause("created desc");
        contentVoExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType());
        PageInfo<ContentVo> contentsPaginator = contentService.getArticlesWithPage(contentVoExample, page, limit);
        request.setAttribute("articles", contentsPaginator);
        return "admin/article_list";
    }

    @GetMapping(value = "publish")
    public String newArticle(HttpServletRequest request) {
        List<MetaVo> categories = metaService.getMetas(Types.CATEGORY.getType());
        request.setAttribute("categories", categories);
        return "admin/article_edit";
    }

    @ResponseBody
    @PostMapping(value = "publish")
    public ResetResponseBo publishArticle(ContentVo content, HttpServletRequest request) {
        UserVo user = this.user(request);
        content.setAuthorId(user.getUid());
        content.setType(Types.ARTICLE.getType());
        if (StringUtils.isEmpty(content.getCategories())) {
            content.setCategories("默认分类");
        }
        String result = contentService.publish(content);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return ResetResponseBo.fail(result);
        }
        return ResetResponseBo.ok();
    }
}
