package me.superkoh.evpn.controller;

import com.github.bingoohuang.patchca.Patchca;
import com.github.bingoohuang.patchca.service.Captcha;
import me.superkoh.evpn.exception.IllegalRequestParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by KOH on 16/5/12.
 */
@Controller
public class CaptchaController {

    @Autowired
    private Jedis jedis;

    @RequestMapping(path = "/captcha", method = RequestMethod.GET)
    public ModelAndView getCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vd = (String) request.getAttribute("vd");
        if (null == vd || vd.isEmpty()) {
            throw new IllegalRequestParamException("vd");
        }
        Captcha captcha = Patchca.next();

        jedis.set("login_captcha_" + vd, captcha.getWord());
        jedis.expire("login_captcha_" + vd, 600);

        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(captcha.getImage(), "png", os);
        try {
            os.flush();
        } finally {
            os.close();
        }
        return null;
    }
}
