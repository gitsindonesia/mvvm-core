package id.gits.mvvmsample.api.main;

public class MainResponse {
    public static class LoginResponse {
        private String message;

        public LoginResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}