package com.silencetao.controller.route;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.silencetao.entity.Picture;
import com.silencetao.service.module.PictureService;

/**
 * Ueditor处理类
 * @author Silence
 *
 */
@RequestMapping(value="config")
@Controller
public class UeditorController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="getConfig")
    public void config(HttpServletRequest request, HttpServletResponse response) {
 
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            if("uploadimage".equals(request.getParameter("action"))) {
            	JSONObject json = new JSONObject(exec);
        		Picture picture = new Picture();
        		HttpSession session = request.getSession();
        		String opinionSign = (String) session.getAttribute("opinionSign");
        		picture.setRealPath((String) json.get("url"));
        		picture.setPertain(opinionSign);
        		try {
        			pictureService.insertPicture(picture);
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
