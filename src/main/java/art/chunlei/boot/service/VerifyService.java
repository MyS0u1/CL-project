package art.chunlei.boot.service;


public interface VerifyService {
    void sendVerifyCode(String email);

    boolean doVerify(String email, String code);
}
