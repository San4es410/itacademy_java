package by.itacademy.jd2.firstapp.ex_voiting.support;

import java.time.LocalDateTime;

public class AboutMyself {
    private String text;
    private LocalDateTime time;

    public AboutMyself(String text) {
        this.text = text;
        time = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "О себе: " + text +
                " было добавлено " + time;
    }
}
