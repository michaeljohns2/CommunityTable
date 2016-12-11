package com.community.controller;

import com.community.data.BlogRepository;
import com.community.model.BlogModel;
import com.community.utils.Base64Utils;
import com.community.utils.MessageManager;
import com.community.utils.ModelUtils;
import com.google.common.io.ByteStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepo;

    @RequestMapping(value="/blogs", method= RequestMethod.GET)
    public String displayBlogEntries(Model model) {
        MessageManager mgr = MessageManager.getInstance();

        // header & nav
        ModelUtils.addCommonAttrs(model);

        model.addAttribute("title_1", mgr.getMessage("blogsummaries.title_1"));

        List<BlogModel> blogs = blogRepo.getAllBlogs();
        model.addAttribute("blogList", blogs);
        return "blogSummaries";
    }

    @RequestMapping(value="/blog/{id}", method= RequestMethod.GET)
    public String displayBlogEntry(@PathVariable("id") String id, Model model) {
        // header & nav
        ModelUtils.addCommonAttrs(model);
        BlogModel blog = null;

        try {
            blog = blogRepo.getBlog(id);
        } catch (Exception ex) {
            // An exception may occur if the ID is an invalid format.
            // This can happen since it is exposed in the UI.
            // If it occurs treat it as blog not found.
        }

        if (blog == null) {
            return "blogNotFound";
        } else {
            model.addAttribute("blogEntry", blog);
            model.addAttribute("blogModel", blog);
            model.addAttribute("featured_img_mime_type",determineImgMimeType(blog));
            return "blogDetail";
        }
    }

    /**
     * Need to set the mime type, so have to peek.
     *
     * @param blog
     */
    private String determineImgMimeType(BlogModel blog){

        String featuredImg = blog.getFeaturedImg();

        // (1) ::: NO FEATURED IMG
        if (featuredImg.isEmpty()) {

            // get name of default featured img resource (expect it to be on classpath)
            String defImgName = MessageManager.getInstance().getMessage("default.featured.img");

            // get file extension of image to use as the format
            String ext = defImgName.substring(defImgName.lastIndexOf('.') + 1).trim();
            return Base64Utils.mimeTypeForExtension(ext);
        }

        // (2) ::: HAVE FEATURED IMG
        // featuredImg is stored as a base64 data url so separate into parts
        String[] parts = Base64Utils.separateBase64DataUrlToParts(featuredImg);

        // get format from parts, e.g. 'png' or 'jpeg'
        String ext = Base64Utils.getBase64ImgFormatFromParts(parts);
        return Base64Utils.mimeTypeForExtension(ext);
    }

    @RequestMapping(value="/blog/{id}/featured-img", method= RequestMethod.GET)
    public void getBlogEntryFeaturedImg(@PathVariable("id") String id, HttpServletResponse response) throws Exception {

         /*
         * Adapted from http://stackoverflow.com/questions/33938704/spring-mvc-how-to-return-an-image-from-controller
         */
        try (ByteArrayOutputStream imgos = new ByteArrayOutputStream()) {

            //NOTE: only getting blog model populated for featured image (to speed up GET)
            BlogModel blog = blogRepo.getBlog(id,true);

            String featuredImg = blog.getFeaturedImg();

            // (1) ::: NO FEATURED IMG
            if (featuredImg.isEmpty()){

                // get name of default featured img resource (expect it to be on classpath)
                String defImgName = MessageManager.getInstance().getMessage("default.featured.img");

                // get file extension of image to use as the format
                String ext = defImgName.substring(defImgName.lastIndexOf('.') + 1).trim();

                // load the resource and copy to stream
                ByteStreams.copy(this.getClass().getClassLoader().getResourceAsStream(defImgName), imgos);

                // stream into response
                writeImgToResponse(Base64Utils.mimeTypeForExtension(ext), imgos.toByteArray(), response);
                return;
            }

            // (2) ::: HAVE FEATURED IMG

            // featuredImg is stored as a base64 data url so separate into parts
            String[] parts = Base64Utils.separateBase64DataUrlToParts(featuredImg);

            // get format from parts, e.g. 'png' or 'jpeg'
            String ext = Base64Utils.getBase64ImgFormatFromParts(parts);

            // get the data from parts
            BufferedImage image = Base64Utils.decodeToBufferedImage(Base64Utils.getBase64ImgDataFromParts(parts));

            // write image into stream
            ImageIO.write(image,ext,imgos);

            // stream into response
            writeImgToResponse(Base64Utils.mimeTypeForExtension(ext),imgos.toByteArray(),response);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void writeImgToResponse(String mimeType, byte[] imgBytes, HttpServletResponse response) throws IOException {

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType(mimeType);
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(imgBytes);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
