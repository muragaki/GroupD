package com.example.CalLunch.app.image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

    @ModelAttribute
    public ImageForm setForm() {
        return new ImageForm();
    }

    /**
     * まずlocalhost:8080/firstでupload.htmlにアクセスするよう設定
     * @return　upload.html
     */
    @RequestMapping("/first")
    public String first() {
        return "image/image";
    }


    /**
     * アップロードされた画像データを取得し、base64でエンコードする
     * エンコードしたものを文字列に変更(同時に拡張子をここではjpegと指定)し次のhtmlに受け渡す
     * @param imageForm アップロードされたデータ
     * @param model
     * @return
     * @throws Exception
    @PostMapping("/image")
    public String upload(ImageForm imageForm, Model model) throws Exception {
        System.out.println(imageForm.getImage().getSize());
        StringBuffer data = new StringBuffer();
        String base64 = new String(Base64.encodeBase64(imageForm.getImage().getBytes()), "ASCII");
        data.append("data:image/jpeg;base64,");
        data.append(base64);
        model.addAttribute("base64image",data.toString());
        return "express";
    }
     */

}
