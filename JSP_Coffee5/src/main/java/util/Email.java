package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Email {
//    loantest2809@gmail.com
//    hqoc zlbs euhx gzcf

    static final String from ="loantest2809@gmail.com";
    static String password = "hqoc zlbs euhx gzcf";

    public static boolean sendEmail(String to, String tieuDe, String noiDung){
//        Properties: khai bao cac thuoc tinh
        Properties props = new Properties();
//        doc them cac giao thuc smtp,...
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

//        create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from, password);
            }
        };

//        phien lam viec
        Session session = Session.getInstance(props, auth);

//        tao mot tin nhan moi
        MimeMessage msg = new MimeMessage(session);

        try {
//            kieu noi dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            nguoi gui
            msg.setFrom(from);
//            nguoi nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
//            tieu de
            msg.setSubject(tieuDe, "UTF-8");
//            quy dinh ngay gui
            msg.setSentDate(new Date());
//            quy dinh email phan hoi
            msg.setReplyTo(InternetAddress.parse(from, false));
//            noi dung
            msg.setContent(noiDung, "text/html; charset=UTF-8");
//            gui email
            Transport.send(msg);
            System.out.println("Gửi email thành công");
            return true;
        } catch (MessagingException e) {
            System.out.println("Gặp lỗi trong quá trình gửi email");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Email.sendEmail("loantest2809@gmail.com", System.currentTimeMillis() + "", "<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Chúc mừng bạn đã đăng ký tài khoản thành công</h1>\n" +
                    "<img src=\"https://titv.vn/wp-content/uploads/2023/10/Screenshot-2023-10-03-121024-300x271.png\" alt=\"\">\n" +
                    "</body>\n" +
                    "</html>");
        }

    }
}
